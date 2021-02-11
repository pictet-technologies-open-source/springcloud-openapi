package com.pictet.training_springcloud.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.URL;

/**
 * Used to load stubs from spring boot jar classpath
 */
@SpringBootApplication
public class MockApplication {

    private WireMockServer wireMockServer;

    @Value("${wiremock.server.port:8701}")
    private int port;

    public static void main(String[] args) {
        SpringApplication.run(MockApplication.class, args);
    }


    /**
     * Starts up the wire mock server on specified port.
     */
    @PostConstruct
    public void startUp() {
        URL wiremockStubsURL = this.getClass().getClassLoader().getResource("wiremock");
        String wiremockStubsPath = wiremockStubsURL != null && wiremockStubsURL.toString().contains("BOOT-INF/classes") ? "BOOT-INF/classes/wiremock" : "wiremock";

        wireMockServer = new WireMockServer(WireMockConfiguration
                .wireMockConfig()
                .fileSource(new ClasspathFileSource(wiremockStubsPath))
                .port(port)
        );
        wireMockServer.start();
    }

    /**
     * Shuts down the wire mock server.
     */
    @PreDestroy
    public void shutDown() {
        if (wireMockServer != null) {
            wireMockServer.stop();
        }
    }

}
