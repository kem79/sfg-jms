package guru.springframework.sfgjms;


import org.apache.activemq.artemis.core.config.Configuration;
import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.server.embedded.EmbeddedActiveMQ;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SfgJmsApplication {

    public static void main(String[] args) throws Exception {

        Configuration config = new ConfigurationImpl();
        config.addAcceptorConfiguration("in-vm", "vm://0");
        config.setPersistenceEnabled(false);
        config.setJournalDirectory("target/data/journal");
        config.setSecurityEnabled(false);

        EmbeddedActiveMQ server = new EmbeddedActiveMQ();
        server.setConfiguration(config);

        server.start();

        SpringApplication.run(SfgJmsApplication.class, args);
    }

}
