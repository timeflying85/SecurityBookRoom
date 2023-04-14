package be.technifutur.security.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class JwtProvider {

    private final UserDetailsService userDetailsService;

    public JwtProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String createToken(Authentication auth){

        return JWT.create()
                .withSubject(auth.getName())
                .withExpiresAt(Instant.now().plusMillis(86_400_000))
                .withClaim("mood", " :) ")
                .sign(Algorithm.HMAC512("sI]kM2<)P|AFg?WTPCsKHOtcMTou_Xk,5<rm*&m)BCJzk'a4W,h`jDy,>XyOejq"));

    }

    public String extractToken(HttpServletRequest request){

        String authHeader = request.getHeader("authorization");

        if (authHeader == null)
            return null;

        return authHeader.replace("Bearer","");

    }

    public boolean ValidateToken(String token){

        try{
            DecodedJWT jwt = JWT.require( Algorithm.HMAC512("sI]kM2<)P|AFg?WTPCsKHOtcMTou_Xk,5<rm*&m)BCJzk'a4W,h`jDy,>XyOejq") )
                    .acceptExpiresAt( 86_400_000 )
                    .withClaim("mood", " :) ")
                    .build()
                    .verify(token);

//            return jwt.getSubject().length() > 550;
            return true;
        }
        catch (JWTVerificationException ex){
            return false;
        }

    }

    public Authentication createAuth(String token){

        DecodedJWT jwt = JWT.decode(token);
        String username = jwt.getSubject();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());

    }


}
