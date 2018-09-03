/*
 * Copyright 2018 Jobsz (zcq@zhucongqi.cn)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
*/
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
	 * Start Id
	 */
	private Integer startId;
	
	/**
	 * Resources lock.
	 */
	private final Lock lock;
	
	public RedisDC(GedidConfig config) {
		this.jedis = new Jedis(config.getIp(), config.getPort());
		String auth = config.getAuth();
		if (null != auth && !"".equals(auth.trim())) {
			this.jedis.auth(auth);
		}
		this.startId = config.getStartId();
		this.lock = new ReentrantLock();
	}

	@Override
	public boolean follow(String name) {
		this.name = name;
		this.lock.lock();
		try {
			// if the key (this.name) cannot be exist, create and set the value with `this.startId - 1`.<br/>
			// if the key (this.name) is existed , no operation is performed.
			this.jedis.setnx(this.name, String.valueOf((this.startId - 1)));
		} finally {
			this.lock.unlock();
		}
		return true;
	}

	@Override
	public Long incr() {
		this.lock.lock();
		long nextId = 0L;
		try {
			nextId = this.jedis.incr(this.name);
		} finally {
			this.lock.unlock();
		}
		return nextId;
	}
	
}
