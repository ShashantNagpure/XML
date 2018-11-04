package com.proj.Pojos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class TreeNode {
	public String val;
	public List<TreeNode> list;
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public List<TreeNode> getList() {
		return list;
	}
	public void setList(List<TreeNode> list) {
		this.list = list;
	}
	public TreeNode(String val)
	{
		this.val=val;
		list=new ArrayList<>();
	}
	public TreeNode()
	{
		list=new ArrayList<>();
	}
	

}
