package com.searchingflights.lamda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

//com.searchingflights.lamda.LambdaMessage::handleRequest
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class LambdaMessage implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	@Override
	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
		// TODO Auto-generated method stub
		String message = "Testing the Lambda.";
		return new APIGatewayProxyResponseEvent().withBody(message).withStatusCode(200);
	}

}
