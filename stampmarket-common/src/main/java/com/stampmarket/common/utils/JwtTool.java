package com.stampmarket.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtTool {
    /**
     * 生成JWT
     *
     * @param secretKey 秘钥
     * @param ttlMillis 有效时长（毫秒）
     * @param claims    负载信息
     * @return token
     */
    public static String getToken(String secretKey, long ttlMillis, Map<String, Object> claims) {
        // 指定签名时使用的签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        // 生成JWT的过期时间
        Date exp = new Date(System.currentTimeMillis() + ttlMillis);
        // 设置JWT的body
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .signWith(signatureAlgorithm, secretKey.getBytes())
                .setExpiration(exp);
        return builder.compact();
    }

    /**
     * 解析JWT
     * @param secretKey 秘钥
     * @param token 待解析的token
     * @return 负载信息
     */
    public static Claims parseToken(String secretKey, String token) {
        return Jwts.parser()
                .setSigningKey(secretKey.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }
}
