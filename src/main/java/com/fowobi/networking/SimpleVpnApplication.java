package com.fowobi.networking;

import com.fowobi.networking.server.VPNServerAsync;
import com.fowobi.networking.util.EncryptionUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@PropertySource("file:/home/tostos/Documents/code/properties/simpleVpnServer.properties")
@SpringBootApplication
public class SimpleVpnApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SimpleVpnApplication.class, args);

		VPNServerAsync vpnServerAsync = new VPNServerAsync();
		vpnServerAsync.startServer();
	}


}
