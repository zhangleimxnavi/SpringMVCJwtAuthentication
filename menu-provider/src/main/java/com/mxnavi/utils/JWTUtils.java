package com.mxnavi.utils;

import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtils {
    public String createJWT(String id, String subject, long ttlMillis,Map<String, Object> claims) throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; // ָ��ǩ����ʱ��ʹ�õ�ǩ���㷨��Ҳ����header�ǲ��֣�jjwt�Ѿ����ⲿ�����ݷ�װ���ˡ�
        long nowMillis = System.currentTimeMillis();// ����JWT��ʱ��
        Date now = new Date(nowMillis);
        SecretKey key = generalKey();
        // ���������Ϊpayload��Ӹ��ֱ�׼������˽��������
        JwtBuilder builder = Jwts.builder() // ������ʵ����newһ��JwtBuilder������jwt��body
                .setClaims(claims) // �����˽��������һ��Ҫ����������Լ�������˽�е�����������Ǹ�builder��claim��ֵ��һ��д�ڱ�׼��������ֵ֮�󣬾��Ǹ�������Щ��׼��������
                .setId(id) // ������JWT��Ψһ��ʶ������ҵ����Ҫ�������������Ϊһ�����ظ���ֵ����Ҫ������Ϊһ����token,�Ӷ��ر��طŹ�����
                .setIssuedAt(now) //  jwt��ǩ��ʱ��
                .setSubject(subject) // ����������JWT�����壬�������û�����id����֤Ψһ�Ϳ�����
                .signWith(signatureAlgorithm, key);// ����ǩ��ʹ�õ�ǩ���㷨��ǩ��ʹ�õ���Կ
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp); // ���ù���ʱ��
        }
        return builder.compact(); // ����jwt
    }

    /**
     * ����jwt
     */
    public Claims parseJWT(String jwt) throws Exception {
        SecretKey key = generalKey(); // ǩ����Կ�������ɵ�ǩ������Կһģһ��
        Claims claims = Jwts.parser() // �õ�DefaultJwtParser
                .setSigningKey(key) // ����ǩ������Կ
                .parseClaimsJws(jwt).getBody();// ������Ҫ������jwt
        return claims;
    }

    /**
     * ���ַ������ɼ���key
     */
    public SecretKey generalKey() {
/*        PropertiesUtils propertiesUtils = new PropertiesUtils();*/
        byte[] encodedKey = Base64.decodeBase64("FGSJFKSI");// ���ص�������룬�����Զ���
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");// ���ݸ������ֽ�����ʹ��AES�����㷨����һ����Կ��ʹ��
        return key;
    }

}
