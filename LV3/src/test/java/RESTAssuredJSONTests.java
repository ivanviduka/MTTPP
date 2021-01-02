import static io.restassured.RestAssured.delete ;
import static io.restassured.RestAssured.get ;
import static io.restassured.RestAssured.given ;
import static org.hamcrest.Matchers.hasItems ;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider ;
import org.testng.annotations.Test ;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RESTAssuredJSONTests {
    final static String ROOT_URI = "http://localhost:7000/students" ;

    @Test
    public void simple_get_test() {
        Response response = get(ROOT_URI + "/list" );
        System.out.println(response.asString());
        response.then().body("id", hasItems(1 ,2, 3, 4));
        response.then().body("ime", hasItems( "Ivan", "Marko" ));

        //Vrijednosti za koje test pada
        //response.then().body("id", hasItems(15, 16, 20));
        //response.then().body("ime", hasItems( "Domagoj", "Josip" ));
    }

    @Test
    public void post_test() {
        Response response = given ().
                contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"ime\": \"Marija\",\"prezime\": \"Tomas\",\"smjer\": \"DRD\"}")
                .when()
                .post( ROOT_URI + "/create" );
        System.out.println( "POST Response \n " + response.asString());
        response.then().body("id",Matchers.any(Integer.class));
        response.then().body("ime",Matchers.is("Marija"));

        //Vrijednost za koju test pada jer je ime različito od onog koje smo predali u post metodi
        //response.then().body("ime",Matchers.is("Ivana"));
    }


    @Test
    public void put_test() {
        Response response = given ()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"ime\": \"Ljubo\",\"prezime\": \"Anić\",\"smjer\": \"DRB\"}")
                .when()
                .put( ROOT_URI + "/update/3" );
        System.out.println( "PUT Response \n " + response.asString());
        response.then().body( "id" , Matchers.is( 3 ));
        response.then().body( "ime", Matchers.is("Ljubo"));
        response.then().body( "prezime", Matchers.is("Anić"));
        response.then().body( "smjer", Matchers.is("DRB"));

        //Vrijednosti za koje test pada jer su različite od onih koje smo predali u put metodi
        //response.then().body( "id" , Matchers.is( 5 ));
        //response.then().body( "ime", Matchers.is("Igor"));
        //response.then().body( "prezime", Matchers.is("Šarić"));
        //response.then().body( "smjer", Matchers.is("DRD"));
    }



    @Test
    public void delete_test() {
        Response response = delete (ROOT_URI + "/delete/4" );
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());


        response = get ( ROOT_URI + "/list" );
        System.out.println(response.asString());
        response.then().body("id" ,Matchers.not(4));

        //Vrijednost za koju test pada jer je id=4 obrisan u ovoj metodi
        //response.then().body("id" ,Matchers.is(4));
    }

    @Test (dataProvider = "dpGetWithParam" )
    public void get_with_param( int id, String smjer) {
        get(ROOT_URI + "/get/" + id).then().body( "smjer", Matchers.is(smjer));
        System.out.println("Predani ID: " + id + "\t Predani smjer: " + smjer + "\n");
    }
    @DataProvider
    public Object[][] dpGetWithParam() {
        Object[][] testDatas = new Object[][]{
                new Object[]{ 1 , "DRC" },
                new Object[]{ 2 , "DRB" },
                new Object[]{ 3 , "DRB" }};

                //Vrijednost za koju test pada jer se unutar put testa smjer na id=3 mijenja iz DRC u DRB
                //new Object[]{ 3 , "DRC" }};
        return testDatas;
    }

}
