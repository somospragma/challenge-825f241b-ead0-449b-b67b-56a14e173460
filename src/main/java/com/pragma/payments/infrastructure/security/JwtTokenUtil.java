package com.pragma.payments.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final String SECRET_KEY = "secret";

    public String generateToken(String subject) {
        return Jwts.builder()
           .setSubject(subject)
           .setIssuedAt(new Date())
           .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
           .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
           .compact();
    }

    public Claims getClaimsFromToken(String token) {
        return Jwts.parser()
           .setSigningKey(SECRET_KEY)
           .parseClaimsJws(token)
           .getBody();
    }

    public Boolean validateToken(String token) {
        try {
            getClaimsFromToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}