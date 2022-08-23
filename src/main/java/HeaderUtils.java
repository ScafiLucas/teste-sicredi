import io.restassured.specification.RequestSpecification;

public class HeaderUtils {

    public static RequestSpecification setJsonHeaders(RequestSpecification httpRequest){
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("Accept", "application/json");
        return httpRequest;
    }
}
