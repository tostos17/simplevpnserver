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

//		VPNServerAsync vpnServerAsync = new VPNServerAsync();
//		vpnServerAsync.startServer();

		System.out.println("hello world");

//		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
////		KeepAliveService keepAliveService = conc = new VPNServerAsync();
//		vpnServerAsync.startServer();ntext.getBean(KeepAliveService.class);
//		KeepAliveRepo keepAliveRepo = context.getBean(KeepAliveRepo.class);
//		KeepAliveService keepAliveService = new KeepAliveService(keepAliveRepo);
//
//		VPNServerAsync vpnServerAsync = new VPNServerAsync(keepAliveService);
//		vpnServerAsync.startServer();
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

	@Bean
	String start(VPNServerAsync vpnServerAsync) throws Exception {
//		VPNServerAsync vpnServerAsync = new VPNServerAsync();
		vpnServerAsync.startServer();

		return "00";
	}

}
