import io.restassured.response.Response;
import org.testng.Assert;

public class AssertUtils {

    public static void assertStatusCode(Response response, String fileName){
        Assert.assertEquals(response.getStatusCode(), JsonReaderUtils.getResponseStatusCode(fileName));
    }

    public static void  assertBodyContent(Response response, String fileName){
        Assert.assertEquals(response.getBody().asString(), JsonReaderUtils.getResponseBody(fileName).toJSONString());
    }
}
