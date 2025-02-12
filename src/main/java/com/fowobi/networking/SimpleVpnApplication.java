package com.fowobi.networking;

//import com.fowobi.networking.config.BeanConfig;
import com.fowobi.networking.repository.KeepAliveRepo;
import com.fowobi.networking.server.VPNServerAsync;
import com.fowobi.networking.service.KeepAliveService;
import com.fowobi.networking.util.EncryptionUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

@PropertySource("file:/home/tostos/Documents/code/properties/simpleVpnServer.properties")
@SpringBootApplication
public class SimpleVpnApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SimpleVpnApplication.class, args);

	}

	@Bean
	String start(VPNServerAsync vpnServerAsync) throws Exception {
		vpnServerAsync.startServer();

		return "00";
	}

}
