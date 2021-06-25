package hu.webtown.content.lister.portlet;

import hu.webtown.content.lister.portlet.constants.ContentListerPortletKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

/**
 * @author lehel
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=webtown.hu",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ContentLister",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ContentListerPortletKeys.CONTENTLISTER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ContentListerPortlet extends MVCPortlet {

	private static final Log LOGGER = LogFactoryUtil.getLog(ContentListerPortlet.class);
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
		
		LOGGER.info("Constants.CMD: " + cmd);
		if (cmd.equals("get_users")) {
			getUsers(resourceRequest, resourceResponse);
		}
		
	}
	
	private void getUsers(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException {
		JSONArray usersJSONArray = JSONFactoryUtil.createJSONArray();

		String userEmail = ParamUtil.getString(resourceRequest, "userEmail");
		LOGGER.info("=====00000========" + userEmail);
		DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(User.class,
				PortalClassLoaderUtil.getClassLoader());
		Criterion criterion = RestrictionsFactoryUtil.like("emailAddress",
				StringPool.PERCENT + userEmail + StringPool.PERCENT);
		userQuery.add(criterion);
		JSONObject userJSON = null;
		LOGGER.info("=====1111========" + userQuery.toString());
		try {
			List<User> userList = UserLocalServiceUtil.dynamicQuery(userQuery);
			LOGGER.info("=====222========" + userList.size());
			for (User user : userList) {
				userJSON = JSONFactoryUtil.createJSONObject();
				userJSON.put("userId", user.getUserId());
				userJSON.put("email", user.getEmailAddress());
				userJSON.put("firstName", user.getFirstName());
				usersJSONArray.put(userJSON);
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		PrintWriter out = resourceResponse.getWriter();
		out.println(usersJSONArray.toString());
	}
}