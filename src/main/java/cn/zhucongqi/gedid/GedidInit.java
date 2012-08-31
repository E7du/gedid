package cn.zhucongqi.gedid;

import cn.zhucongqi.gedid.core.Gedid;

public class GedidInit {
	
	public GedidInit(GedidConfig config) {
		this.config = config;
	}
	
	public Gedid build(String bizName) {
		return new Gedid(bizName, this.config);
	}
	
	private GedidConfig config;

}
