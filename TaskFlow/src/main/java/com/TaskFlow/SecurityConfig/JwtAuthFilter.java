package com.TaskFlow.SecurityConfig;

import com.TaskFlow.Entity.RegisterEntity;
import com.TaskFlow.Repositry.RegisterRepo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenCreation jwtTokenCreation;

    @Autowired
    private RegisterRepo registerRepo;

    public RegisterEntity email;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if(authHeader != null && authHeader.startsWith("Bearer "))
        {
            String token = authHeader.substring(7).trim();
            String username = jwtTokenCreation.extractEmail(token);
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null)
            {
                RegisterEntity op = registerRepo.findByEmail(username);
                email = op;
                if(op != null && jwtTokenCreation.validateToken(token,username)){
                    List<GrantedAuthority> authority = List.of(new SimpleGrantedAuthority(op.getRole().toString()));
                    UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(username,null,authority);
                    SecurityContextHolder.getContext().setAuthentication(authtoken);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
