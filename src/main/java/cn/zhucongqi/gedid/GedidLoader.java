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
package cn.zhucongqi.gedid;

import java.util.concurrent.ConcurrentHashMap;

import cn.zhucongqi.gedid.core.Gedid;

public class GedidLoader {
	
	/**
	 * Gedid Config
	 */
	private GedidConfig config;
	
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
		if (null == bisName || "".equals(bisName.trim())) {
			throw (new GedidException("The bisname cannot be Empty."));
		}
		
		if (this.bisMapping.containsKey(bisName)) {
			return this.bisMapping.get(bisName);
		}
		Gedid gedid = new Gedid(bisName, this.config);
		this.bisMapping.put(bisName, gedid);
		return gedid;
	}
	
	private GedidLoader(GedidConfig config) {
		this.config = config;
		this.bisMapping = new ConcurrentHashMap<String, Gedid>();
	}

}
