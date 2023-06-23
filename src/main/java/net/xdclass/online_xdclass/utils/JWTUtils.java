package net.xdclass.online_xdclass.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.xdclass.online_xdclass.model.entity.User;


/**
 * Jwt工具类
 * 生成的token是可以通过base64进行解密出明文信息
 * base64进行解密出明文信息，修改再进行编码，则会解密失败
 * 无法作为已颁布token,除非改密钥
 */
import java.util.Date;

/**
 * JWT工具类
 */
public class JWTUtils {

    static final long EXPIRE = 60000 * 60 * 24 * 7; //过期时间1周

    /**
     * 加密密钥
     */
    private static final String SECRET = "secretTest";


    private static final String TOKEN_PREFIX = "tokenPrefixTest";


    private static final String SUBJECT = "subjectTest";

    /**
     * 根据用户信息生成令牌
     *
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user) {

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("head_img", user.getHeadImg())
                .claim("id", user.getId())
                .claim("name", user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();

        token = TOKEN_PREFIX + token;

        return token;
    }


    /**
     *校验token的方法
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {

        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();

            return claims;
        } catch (Exception e) {
            return null;
        }

    }

}
