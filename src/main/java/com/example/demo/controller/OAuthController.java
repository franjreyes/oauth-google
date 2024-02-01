package com.example.demo.controller;

import java.security.Principal;

import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/oauth")
public class OAuthController {
	
	@GetMapping
	public Principal get(Principal principal) {
		return principal;
	}
	
	@GetMapping(value = "html", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getHtml(OAuth2AuthenticationToken oauth2Token) {
        return "<pre>\n"
        		+ "<p>Authorities: " + oauth2Token.getAuthorities() +  "</p>"
        		+ "<p>Email: " + oauth2Token.getPrincipal().getAttribute("email") +  "</p>"
        		+ "<img src='" + oauth2Token.getPrincipal().getAttribute("picture") + "'></img>"
        		+ "</pre>";
        }

}
