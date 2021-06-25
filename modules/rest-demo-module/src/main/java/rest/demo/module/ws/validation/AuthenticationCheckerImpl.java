package rest.demo.module.ws.validation;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.osgi.service.component.annotations.Component;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

@Component(
		immediate = true,
		service = AuthenticationChecker.class
)
public class AuthenticationCheckerImpl implements AuthenticationChecker {

	// TODO: refactor - make these values configurable
	private static final String AUTH_USER = "test";
	private static final String AUTH_PWD = "test";
	private static final Log LOGGER = LogFactoryUtil.getLog(AuthenticationCheckerImpl.class);
	
	@Override
	public boolean isAuthenticated(String authString) {
		LOGGER.debug(" **** IS AUTHENTICATED **** ");		
		
		if (Validator.isNull(AUTH_USER) && Validator.isNull(AUTH_PWD)) {
			return true;
		}
		if (Validator.isNull(AUTH_USER) || Validator.isNull(AUTH_PWD) || Validator.isNull(authString)) {
			return false;
		}
		StringBuilder token = new StringBuilder(3);
		token.append(AUTH_USER);
		token.append(StringPool.COLON);
		token.append(AUTH_PWD);
		String encodedToken = Base64.getEncoder().encodeToString(token.toString().getBytes(StandardCharsets.UTF_8));
		LOGGER.debug(" --> encoded token: " + encodedToken);
		boolean isAuthenticated = ("Basic " + encodedToken).equals(authString);
		LOGGER.debug(" --> isAuthenticated: " + isAuthenticated);
		return isAuthenticated;
	}
}
