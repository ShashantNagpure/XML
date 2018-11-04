package com.proj.uilayer;


import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.proj.Pojos.TreeNode;
import com.proj.xmlLayer.Doms;
import com.proj.xmlLayer.HelperFunctionsForWriting;


@Controller
public class Controllers {

@Autowired
public Doms file1;
@Autowired
public Doms file2;
@Autowired
public HelperFunctionsForWriting h;
@RequestMapping(value = "/view", method = RequestMethod.GET)
public ModelAndView view()
{
	TreeNode node=file1.parse("cd2.xml");
	TreeNode node2=file2.parse("Employee.xml");
	//ParserXML x2= new ParserXML("cd.xml");
	ModelAndView m=new ModelAndView("home");
	m.addObject("node", node);
	m.addObject("node2", node2);
	return m;
}
@RequestMapping(value = "/htmlparser", method = RequestMethod.POST)
public void htmlparser(HttpServletRequest request) 
{
	String x=request.getParameter("htm");
	System.out.println(Jsoup.parse(x).outerHtml());
    h.write(Jsoup.parse(x).outerHtml());
    //System.out.println(x);
}

}
