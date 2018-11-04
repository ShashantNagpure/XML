package com.proj.xmlLayer;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.proj.Pojos.TreeNode;
@Component
@Scope("prototype")
public class Doms {
	private  Document doc;
    
	@Autowired
	public TreeNode root;
	@Autowired
	public HelperFuncsForCreating h;
	public TreeNode parse(String path)
	{
			 	String filePath = path;
		        File xmlFile = new File(filePath);
		        DocumentBuilderFactory db=DocumentBuilderFactory.newInstance();
		        try {
					DocumentBuilder d=db.newDocumentBuilder();
					 doc=d.parse(xmlFile);
					doc.getDocumentElement().normalize();
					NodeList r=doc.getChildNodes();
					h.add(root, r.item(0));
					h.print(root);

				} catch (SAXException | ParserConfigurationException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return root;

	}

}
