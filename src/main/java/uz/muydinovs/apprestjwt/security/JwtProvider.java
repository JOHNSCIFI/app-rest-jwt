package uz.muydinovs.apprestjwt.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtProvider {
    public static String generateToken(String username) {
        Date expireDate = new Date(System.currentTimeMillis() + 36_000_000);
        return Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, "HelloWorld!")
                .compact();
    }

    public static void main(String[] args) {
        String token = generateToken("userLogin");
        System.out.println(token);
    }
}
