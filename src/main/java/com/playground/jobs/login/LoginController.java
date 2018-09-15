package com.playground.jobs.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.playground.common.dto.Member;


@RestController
@RequestMapping("login")
public class LoginController {
	
	
	@Autowired
	private LoginService loginService;
	
	
	private Log log = LogFactory.getLog(this.getClass());
	
	/** 목록 반환
	 * @param popupVo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody	
	@RequestMapping(value="/loginProcess", method = RequestMethod.GET )
	public String loginProcess( Member member, HttpServletRequest request , HttpSession session)throws Exception {
		JSONObject rtnObject = new JSONObject();
		try {
			Member mem = loginService.view(member);
			if ( mem != null) {
				if( ! mem.getPasswd().equals(member.getPasswd() ) ) {
					rtnObject.put("MSG", "암호가 맞지 않습니다");
					rtnObject.put("SUCCESS", "FALSE");
					rtnObject.put("member", "");
				} else {
					rtnObject.put("SUCCESS", "TRUE");
					mem.setPasswd("");
					mem.setLastLogin("Y");
					
					loginService.update(mem);
					
					session.setAttribute("member", mem);
				}
				
			} else {
				rtnObject.put("MSG", "사용자가 존재하지 않습니다");
				rtnObject.put("SUCCESS", "FALSE");
				rtnObject.put("member", "");
			}
		} catch ( Exception e) {
			try {
				rtnObject.put("MSG", e.getMessage());
				rtnObject.put("SUCCESS", "FALSE");
				rtnObject.put("member", "");
			} catch (JSONException e1) {
				
			}
			e.printStackTrace();
		}
		return rtnObject.toString();
	}

	
}
