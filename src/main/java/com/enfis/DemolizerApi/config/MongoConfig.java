package com.enfis.DemolizerApi.config;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.enfis.DemolizerApi.repository") // Asegura que Spring detecte los repositorios
public class MongoConfig extends AbstractMongoClientConfiguration {

    private static final Dotenv dotenv = Dotenv.load(); // Cargar variables desde .env

    @Override
    protected String getDatabaseName() {
        return "demolizerDB"; // Nombre de la base de datos en MongoDB Atlas
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        String mongoUri = dotenv.get("MONGODB_URI"); // Obtener URI de conexión desde el .env
        return MongoClients.create(mongoUri);
    }

    @Override
    protected boolean autoIndexCreation() {
        return true; // Habilita la creación automática de índices en MongoDB
    }
}