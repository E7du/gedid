package cn.zhucongqi.gedid.core;

import cn.zhucongqi.gedid.core.dc.GedidDC;

public class Gedid {
	
	private final static String GEDID_PREFIX = "gedid_";
	
	private GedidDC dc;
	
	public Gedid(String name, GedidDC dc) {
		this.dc = dc;
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
