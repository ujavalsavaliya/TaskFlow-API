package com.TaskFlow.SecurityConfig;

import com.TaskFlow.Entity.RegisterEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenCreation {
    private final SecretKey secretKey = Keys.hmacShaKeyFor("hello_user_hello_user_hello_user_1234".getBytes());
    public String makeToken(String username, RegisterEntity.Role role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
    public String extractEmail(String token)
    {
        return extractAllClaims(token).getSubject();
    }
    public String extractRoles(String token)
    {
        return extractAllClaims(token).get("role",String.class);
    }
    public boolean validateToken(String token,String username)
    {
        return extractEmail(token).equals(username) && !istokenExpire(token);
    }
    public boolean istokenExpire(String token)
    {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    public Claims extractAllClaims(String token)
    {
        return Jwts
                .parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
