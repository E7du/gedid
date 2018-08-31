package cn.zhucongqi.gedid;

import java.util.concurrent.ConcurrentHashMap;

import cn.zhucongqi.gedid.core.Gedid;
import cn.zhucongqi.gedid.core.dc.GedidDC;
import cn.zhucongqi.gedid.core.dc.impl.RedisDC;

public class GedidLoader {
	
	/**
	 * Gedid Data Center
	 */
	private GedidDC dc;
	
	/**
	 * Business Mapping
	 */
	private ConcurrentHashMap<String, Gedid> bisMapping;
	
	public static GedidLoader init(GedidConfig config) {
		return (new GedidLoader(config));
	}
	
	/**
	 * Follow Business.
	 * @param bisName
	 * @return Gedid instance.
	 */
	public Gedid follow(String bisName) {
		if (this.bisMapping.containsKey(bisName)) {
			return this.bisMapping.get(bisName);
		}
		Gedid gedid = new Gedid(bisName, this.dc);
		this.bisMapping.put(bisName, gedid);
		return gedid;
	}
	
	private GedidLoader(GedidConfig config) {
		this.dc = new RedisDC(config);
		this.bisMapping = new ConcurrentHashMap<String, Gedid>();
	}

}
