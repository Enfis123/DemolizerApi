package com.enfis.DemolizerApi.config;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {
    private static final Dotenv dotenv = Dotenv.load();

    @Bean
    public MongoClient mongoClient() {
        String mongoUri = dotenv.get("MONGODB_URI");
        return MongoClients.create(mongoUri);
    }
}
