import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class SimulationTests {

    private String getClassName(){return new Object() {}.getClass().getEnclosingClass().getName();}
    private String getMethodName(){return StackWalker.getInstance().walk(stream -> stream.skip(1).findFirst().get()).getMethodName();}

    @Test
    /**
     * Check the return of the API for a success simulation.
     */
    public void checkReturnOfASuccesfullySimulation() {

        String filePath = "src/test/resources/" + getClassName() + "/" + getMethodName() + ".json";

        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest = HeaderUtils.setJsonHeaders(httpRequest);
        httpRequest.body(JsonReaderUtils.getRequestBody(filePath).toJSONString());

        Response response = httpRequest.request(Method.POST, JsonReaderUtils.getRequestURI(filePath));

        AssertUtils.assertStatusCode(response, filePath);
    }

    @Test
    /**
     * Check the return of the API for a duplicant simulation.
     */
    public void checkReturnOfADuplicantSimulation() {

        String filePath = "src/test/resources/" + getClassName() + "/" + getMethodName() + ".json";

        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest = HeaderUtils.setJsonHeaders(httpRequest);
        httpRequest.body(JsonReaderUtils.getRequestBody(filePath).toJSONString());

        Response response = httpRequest.request(Method.POST, JsonReaderUtils.getRequestURI(filePath));

        AssertUtils.assertStatusCode(response, filePath);
        AssertUtils.assertBodyContent(response, filePath);
    }

    @Test
    /**
     * Check the return of the API for a simulation withtou the information of CPF.
     */
    public void checkReturnOfASimulationWithoutCPFInformation() {

        String filePath = "src/test/resources/" + getClassName() + "/" + getMethodName() + ".json";

        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest = HeaderUtils.setJsonHeaders(httpRequest);
        httpRequest.body(JsonReaderUtils.getRequestBody(filePath).toJSONString());

        Response response = httpRequest.request(Method.POST, JsonReaderUtils.getRequestURI(filePath));

        AssertUtils.assertStatusCode(response, filePath);
        AssertUtils.assertBodyContent(response, filePath);
    }

    @Test
    /**
     * Check the return of the API for a simulation withtou the information of Name.
     */
    public void checkReturnOfASimulationWithoutNameInformation() {

        String filePath = "src/test/resources/" + getClassName() + "/" + getMethodName() + ".json";

        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest = HeaderUtils.setJsonHeaders(httpRequest);
        httpRequest.body(JsonReaderUtils.getRequestBody(filePath).toJSONString());

        Response response = httpRequest.request(Method.POST, JsonReaderUtils.getRequestURI(filePath));

        AssertUtils.assertStatusCode(response, filePath);
        AssertUtils.assertBodyContent(response, filePath);
    }

    @Test
    /**
     * Check the return of the API for a simulation withtou the information of Email.
     */
    public void checkReturnOfASimulationWithoutEmailInformation() {

        String filePath = "src/test/resources/" + getClassName() + "/" + getMethodName() + ".json";

        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest = HeaderUtils.setJsonHeaders(httpRequest);
        httpRequest.body(JsonReaderUtils.getRequestBody(filePath).toJSONString());

        Response response = httpRequest.request(Method.POST, JsonReaderUtils.getRequestURI(filePath));

        AssertUtils.assertStatusCode(response, filePath);
        AssertUtils.assertBodyContent(response, filePath);
    }

    @Test
    /**
     * Check the return of the API for a simulation withtou the information of Value.
     */
    public void checkReturnOfASimulationWithoutValueInformation() {

        String filePath = "src/test/resources/" + getClassName() + "/" + getMethodName() + ".json";

        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest = HeaderUtils.setJsonHeaders(httpRequest);
        httpRequest.body(JsonReaderUtils.getRequestBody(filePath).toJSONString());

        Response response = httpRequest.request(Method.POST, JsonReaderUtils.getRequestURI(filePath));

        AssertUtils.assertStatusCode(response, filePath);
        AssertUtils.assertBodyContent(response, filePath);
    }

    @Test
    /**
     * Check the return of the API for a simulation withtou the information of Installments.
     */
    public void checkReturnOfASimulationWithoutInstallmentsInformation() {

        String filePath = "src/test/resources/" + getClassName() + "/" + getMethodName() + ".json";

        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest = HeaderUtils.setJsonHeaders(httpRequest);
        httpRequest.body(JsonReaderUtils.getRequestBody(filePath).toJSONString());

        Response response = httpRequest.request(Method.POST, JsonReaderUtils.getRequestURI(filePath));

        AssertUtils.assertStatusCode(response, filePath);
        AssertUtils.assertBodyContent(response, filePath);
    }

    @Test
    /**
     * Check the return of the API for a simulation withtou the information of Insurance.
     * Observation: Should return "Falta de informações" message, but it's not returning any message.
     * Observation2: It's not validating null value.
     */
    public void checkReturnOfASimulationWithoutInsuranceInformation() {

        String filePath = "src/test/resources/" + getClassName() + "/" + getMethodName() + ".json";

        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest = HeaderUtils.setJsonHeaders(httpRequest);
        httpRequest.body(JsonReaderUtils.getRequestBody(filePath).toJSONString());

        Response response = httpRequest.request(Method.POST, JsonReaderUtils.getRequestURI(filePath));

        AssertUtils.assertStatusCode(response, filePath);
        AssertUtils.assertBodyContent(response, filePath);
    }

    @Test
    /**
     * Check the return of the API for a simulation with the Value lower then 1000.
     * Observation: It's not validating the lower limit.
     */
    public void checkReturnOfASimulationWithValueLowerThanMinimumAmount() {

        String filePath = "src/test/resources/" + getClassName() + "/" + getMethodName() + ".json";

        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest = HeaderUtils.setJsonHeaders(httpRequest);
        httpRequest.body(JsonReaderUtils.getRequestBody(filePath).toJSONString());

        Response response = httpRequest.request(Method.POST, JsonReaderUtils.getRequestURI(filePath));

        AssertUtils.assertStatusCode(response, filePath);
        AssertUtils.assertBodyContent(response, filePath);
    }

    @Test
    /**
     * Check the return of the API for a simulation with the Value higher then 40000.
     */
    public void checkReturnOfASimulationWithValueHigherThanMaximumAmount() {

        String filePath = "src/test/resources/" + getClassName() + "/" + getMethodName() + ".json";

        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest = HeaderUtils.setJsonHeaders(httpRequest);
        httpRequest.body(JsonReaderUtils.getRequestBody(filePath).toJSONString());

        Response response = httpRequest.request(Method.POST, JsonReaderUtils.getRequestURI(filePath));

        AssertUtils.assertStatusCode(response, filePath);
        AssertUtils.assertBodyContent(response, filePath);
    }

    @Test
    /**
     * Check the return of the API for a simulation with the quantity of installments lesser than two.
     */
    public void checkReturnOfASimulationWithQuantityOfInstallmentsLesserThanTwo() {

        String filePath = "src/test/resources/" + getClassName() + "/" + getMethodName() + ".json";

        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest = HeaderUtils.setJsonHeaders(httpRequest);
        httpRequest.body(JsonReaderUtils.getRequestBody(filePath).toJSONString());

        Response response = httpRequest.request(Method.POST, JsonReaderUtils.getRequestURI(filePath));

        AssertUtils.assertStatusCode(response, filePath);
        AssertUtils.assertBodyContent(response, filePath);
    }

    @Test
    /**
     * Check the return of the API for a simulation with the quantity of installments higher than forty two.
     * Observation: It's not validating the maximum amount for the Installments.
     */
    public void checkReturnOfASimulationWithQuantityOfInstallmentsHigherThanFortyTwo() {

        String filePath = "src/test/resources/" + getClassName() + "/" + getMethodName() + ".json";

        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest = HeaderUtils.setJsonHeaders(httpRequest);
        httpRequest.body(JsonReaderUtils.getRequestBody(filePath).toJSONString());

        Response response = httpRequest.request(Method.POST, JsonReaderUtils.getRequestURI(filePath));

        AssertUtils.assertStatusCode(response, filePath);
        AssertUtils.assertBodyContent(response, filePath);
    }

}
