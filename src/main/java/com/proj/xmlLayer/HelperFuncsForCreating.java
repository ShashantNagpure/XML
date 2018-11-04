package com.proj.xmlLayer;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.proj.Pojos.TreeNode;
@Component
@Scope("prototype")
public class HelperFuncsForCreating {
	public void add(TreeNode n,Node root)
	{
		if(root.getNodeType()==2) {n.setVal(root.getNodeName());}
		if(root.getNodeType()==1) {n.setVal(root.getNodeName());}

		if(root.getNodeType()==2)
		{
			n.list.add(new TreeNode(root.getNodeValue()));
		}
		if(root.getNodeType()==1)
		{
			NamedNodeMap mp=root.getAttributes();
			int cnt=-1;
			if(mp.getLength()!=0) {
				cnt++;
			n.list.add(new TreeNode("Attributes"));
			for(int i=0;i<mp.getLength();i++)
			{
				n.list.get(0).list.add(new TreeNode());
				add(n.list.get(0).list.get(i),mp.item(i));
				
			}
			}
			Element el=(Element) root;

			for(int i=0;i<el.getChildNodes().getLength();i++)
			{
				if(el.getChildNodes().item(i).getNodeType()==1)
				{
					cnt++;
					n.list.add(new TreeNode());
					add(n.list.get(cnt),el.getChildNodes().item(i));
				}
			}
		}
		if(root.getNodeType()==1&&root.getChildNodes().getLength()==1) 
		{
			n.list.add(new TreeNode(root.getChildNodes().item(0).getNodeValue()));
		}
		
	}
	public void print(TreeNode root)
	{
		System.out.println(root.getVal());
		for(TreeNode t:root.list)
		{
			print(t);
		}
	}
	

}
