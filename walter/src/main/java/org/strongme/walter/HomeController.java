package org.strongme.walter;

import java.util.Comparator;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.renren.api.client.RenrenApiClient;
import com.renren.api.client.param.impl.SessionKey;

@Controller
public class HomeController {
	
	@Autowired
	Comparator<String> comparator;
	
	
	@RequestMapping(value="/")
	public String welcome(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder
			      .getRequestAttributes()).getRequest();
		request.setAttribute("appId", ApiConfig.APP_ID);
		return "welcome";
	}
	@RequestMapping(value="/home")
	public String home(ModelMap modelMap) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder
				.getRequestAttributes()).getRequest();
		System.out.println("HomeController: passing through...");
		System.out.println("获取相关renren参数");
		String sessionKey = request.getParameter("xn_sig_session_key");
		String renrenUserId = request.getParameter("xn_sig_user");
		System.out.println("Session Key: "+sessionKey);
		System.out.println("renrenUserId: "+renrenUserId);
		if (sessionKey != null && renrenUserId != null) {
			RenrenApiClient apiClient = new RenrenApiClient(sessionKey);
			SessionKey sessionKeyReal = new SessionKey(sessionKey);
			//获取用户信息
			JSONArray userInfo = apiClient.getUserService().getInfo(renrenUserId, sessionKeyReal);
			if (userInfo != null && userInfo.size() > 0) {
				JSONObject currentUser = (JSONObject) userInfo.get(0);
				if (currentUser != null) {
					String userName = (String) currentUser.get("name");
					String userHead = (String) currentUser.get("headurl");
					request.setAttribute("userName", userName);
					request.setAttribute("userHead", userHead);
				}
			}
			JSONArray friends = apiClient.getFriendsService().getFriends(2, 80, sessionKeyReal);
			String friendsStr = friends.toJSONString().replace("\"", "\'");
			request.setAttribute("friends", friendsStr);
		}
		
		
		
		modelMap.addAttribute("welcome", "Walter's APP");
		return "home";
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/compare",method=RequestMethod.POST)
	public String compare(@RequestParam("input1")String input1,@RequestParam("input2")String input2,Model models) {
		int result = comparator.compare(input1, input2);
		String inEnglish = (result<0)?"less than":((result>0)?"greater than":"equal to");
		String output = "According to our Comparator, '"+input1+"' is "+inEnglish+"'"+input2+"'";
		models.addAttribute("output", output);
		return "compareResult";
		
	}
	

}
