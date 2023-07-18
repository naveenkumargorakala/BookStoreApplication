package com.example.bookstoreproject.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Verification;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {
    private static final String TOKEN_SECRET= "SecretOne";

    public String encodeToken(int id){
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

        String token = JWT.create().withClaim("user_id",id).sign(algorithm);
        return token;
    }

    public int decodeToken(String token){
        Verification verification = null;
        verification =JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
        JWTVerifier jwtVerifier = verification.build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Claim claim = decodedJWT.getClaim("user_id");
        int user_id = claim.asInt();

        return user_id;
    }
}
