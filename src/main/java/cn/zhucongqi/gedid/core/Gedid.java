package cn.zhucongqi.gedid.core;

import cn.zhucongqi.gedid.GedidConfig;
import cn.zhucongqi.gedid.core.dc.GedidDC;
import cn.zhucongqi.gedid.core.dc.impl.RedisDC;

public class Gedid {
	
	private final static String GEDID_PREFIX = "gedid_";

	/**
	 * Data Center
	 */
	private GedidDC dc;
	
	public Gedid(String name, GedidConfig config) {
		this.dc = new RedisDC(config);
		this.dc.follow(this.getName(name));
	}

	/**
	 * Get next Id.
	 */
	public long next() {
		return this.dc.incr();
	}
	
	private String getName(String name) {
		return GEDID_PREFIX + name;
	}
	
}
