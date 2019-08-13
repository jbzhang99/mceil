package com.mceil.gateway.config;

import com.mceil.auth.utils.RsaUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.security.PublicKey;

@Slf4j
@Data
@ConfigurationProperties(prefix = "mc.jwt")
public class JwtProperties {
    private String pubKeyPath;//公钥路径
    private String cookieName; //cookie名称
    private PublicKey publicKey; // 公钥

    //对象实例化之后，获取公钥和私钥
    @PostConstruct
    public void init() throws Exception {
        //获取公私钥
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
    }

}

