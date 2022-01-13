package rest;

import dtos.TripDTO;
import entities.Trip;
import facades.TripFacade;
import utils.EMF_Creator;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import java.net.URI;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


//Test works
class TripResourceTest {


    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/test/api";

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static org.glassfish.grizzly.http.server.HttpServer httpServer;
    private static EntityManagerFactory emf;
    private static TripFacade facade;
    private static Trip t1 = new Trip("GreenLand", "marts", "1400", "Nuuk", "12", "warm clothes");
    private static Trip t2 = new Trip("France", "Januar", "1400", "Paris", "12", "warm clothes");
    private static Trip t3 = new Trip("Demark", "Januar", "1400", "Copenhagen", "12", "warm clothes");


    static org.glassfish.grizzly.http.server.HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    @BeforeAll
    public static void setUpClass() {
        //This method must be called before EntityManagerFactory
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactoryForTest();

        httpServer = startServer();
        //Setup RestAssured
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterAll
    public static void closeTestServer() {
        EMF_Creator.endREST_TestWithDB();
        httpServer.shutdownNow();

        facade = TripFacade.getTripFacade(emf);
        //em.createNamedQuery("Trip.deleteAllRows").executeUpdate();

    }


    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
    }


    @Test
    public void testCreateTrip() {
        Trip trip = new Trip("Iceland", "marts", "1400", "Nuuk", "12", "warm clothes");
        trip.setName("Iceland");

        given()
                .contentType("application/json")
                .body(new TripDTO(trip))
                .when()
                .post("boat")
                .then()
                .statusCode(200)
                .body("name", equalTo("Iceland"))
                .body("date", equalTo("marts"))
                .body("time", equalTo("1400"))
                .body("location", equalTo("Nuuk"))
                .body("duration", equalTo("12"))
                .body("packingList", equalTo("warm clothes"));
    }


}