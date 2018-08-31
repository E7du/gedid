package cn.zhucongqi.gedid.core.dc.impl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.zhucongqi.gedid.GedidConfig;
import cn.zhucongqi.gedid.core.dc.GedidDC;
import redis.clients.jedis.Jedis;

public class RedisDC implements GedidDC {

	/**
	 * Jedis client.
	 */
	private Jedis jedis;
	
	/**
	 * Business name.
	 */
	private String name;
	
	/**
	 * Resources lock.
	 */
	private final Lock lock;
	
	public RedisDC(GedidConfig config) {
		this.jedis = new Jedis(config.getIp(), config.getPort());
		String auth = config.getAuth();
		if (null != auth && !"".equals(auth)) {
			this.jedis.auth(auth);
		}
		this.lock = new ReentrantLock();
	}

	@Override
	public boolean follow(String name) {
		this.name = name;
		this.jedis.setnx(this.name, "0");
		return true;
	}

	@Override
	public long incr() {
		this.lock.lock();
		long current = 0L;
		try {
			current = this.jedis.incr(this.name);
		} finally {
			this.lock.unlock();
		}
		return current;
	}
	
}
