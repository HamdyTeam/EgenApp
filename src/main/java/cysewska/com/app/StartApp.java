package cysewska.com.app;


import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * Created by Ola on 2016-08-04.
 */


@ComponentScan(basePackages = {"cysewska.com"})
//@EnableAutoConfiguration
@EntityScan(basePackages  = "cysewska.com.models.entities")
@SpringBootApplication
@EnableJpaRepositories(basePackages = "cysewska.com.repositories")
public class StartApp extends Application {
    public static Stage primaryStage;
    private static ConfigurableApplicationContext applicationContext;
    static Parent root;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    /*
    public static void main(String[] args) {
        launchApp(StartApp.class, MainView.class, args);*/


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        MySpringFXMLLoader loader = applicationContext.getBean(MySpringFXMLLoader.class);
        this.root = loader.load("complex.fxml");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
            applicationContext = SpringApplication.run(StartApp.class, args);
            launch(args);
        }
    @Override
    public void stop() throws Exception {
        applicationContext.stop();
    }

    }

