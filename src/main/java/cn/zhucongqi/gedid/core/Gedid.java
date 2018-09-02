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
