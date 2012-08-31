package cn.zhucongqi.gedid.core;

import cn.zhucongqi.gedid.GedidConfig;

public class Gedid implements GedidBuilder {

	public Gedid(String bizName, GedidConfig config) {
		
	}

	@Override
	public long next() {
		return 0L;
	}
	
}
