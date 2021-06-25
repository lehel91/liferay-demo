package rest.demo.module.ws.validation;

public interface AuthenticationChecker {
	boolean isAuthenticated(String authString);
}
