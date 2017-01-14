package com.mkyong.ws;
 
import com.mkyong.Author;

import javax.jws.WebService;
import java.sql.Timestamp;

//Service Implementation
@WebService(endpointInterface = "com.mkyong.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld{
 
	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}

    @Override
    public Author getAuthor() {
        return new Author(1l,"name");
    }

}