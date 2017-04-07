package paul.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import paul.service.IUserService;
import paul.entity.User;

@Controller
public class UserController {
	
	@Resource(name="userservice")
	private IUserService userService;

	@RequestMapping(value="login.do",method={RequestMethod.POST})
	public @ResponseBody boolean login(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		System.out.println(request.getParameter("name"));
		boolean flag = false;
		try{
			User user1 = new User();
			user1.setUser_username(request.getParameter("name"));
			user1.setUser_password(request.getParameter("pwd"));
			if(userService.Login(user1))
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", user1.getUser_username());
//				System.out.println(session.getAttribute("username"));
				flag = true;
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
}
