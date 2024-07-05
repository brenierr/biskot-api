package com.biskot.cart.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@Component
public class ProductMockServer {

    private final WireMockServer wireMockServer = new WireMockServer(9001);

    @PostConstruct
    private void configureMockServer() {
        wireMockServer.start();
        IntStream.range(1, 5).forEach(productId -> {
            try {
                wireMockServer.stubFor(
                        get(urlPathEqualTo("/products/" + productId))
                                .willReturn(aResponse()
                                                    .withStatus(HttpStatus.OK.value())
                                                    .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                                    .withBody(Files.readString(Paths.get(
                                                            "src/main/resources/mocks/product_" + productId + ".json"))))
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
