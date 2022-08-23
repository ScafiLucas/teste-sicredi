import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.StackTrace;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckCPFTests {

    private String getClassName(){return new Object() {}.getClass().getEnclosingClass().getName();}
    private String getMethodName(){return StackWalker.getInstance().walk(stream -> stream.skip(1).findFirst().get()).getMethodName();}

    @Test
    /**
     * Check if the CPF in the JSON file linked to the test is Restricted.
     */
    public void checkReturnWhenACPFWithRestrictionIsSent() {

        String filePath = "src/test/resources/" + getClassName() + "/" + getMethodName() + ".json";

        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification httpRequest = RestAssured.given();
        System.out.println(JsonReaderUtils.getRequestURI(filePath));
        Response response = httpRequest.request(Method.GET, JsonReaderUtils.getRequestURI(filePath));

        AssertUtils.assertStatusCode(response, filePath);
    }

    @Test
    /**
     * Check if the CPF in the JSON file linked to the test isn't Restricted.
     */
    public void checkReturnWhenACPFWithoutRestrictionIsSent() {

        String filePath = "src/test/resources/" + getClassName() + "/" + getMethodName() + ".json";

        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, JsonReaderUtils.getRequestURI(filePath));

        AssertUtils.assertStatusCode(response, filePath);
    }

    @Test
    /**
     * Check if the API returns the correct error code when CPF is not informed.
     */
    public void checkReturnWhenANullCPFIsSent() {

        String filePath = "src/test/resources/" + getClassName() + "/" + getMethodName() + ".json";

        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, JsonReaderUtils.getRequestURI(filePath));

        AssertUtils.assertStatusCode(response, filePath);
    }
}

