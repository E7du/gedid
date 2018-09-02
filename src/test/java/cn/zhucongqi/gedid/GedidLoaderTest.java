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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cn.zhucongqi.gedid.core.Gedid;

class GedidLoaderTest {

	GedidLoader loader;
	
	@BeforeEach
	void setUp() throws Exception {
		loader = GedidLoader.init(GedidConfig.defaultConfig());
	}

	@Test
	void test() {
		Gedid user = loader.follow("user");
		
		Long id = user.next();
		System.out.println(id);
		
		Gedid order = loader.follow("order");
		
		id = order.next();
		System.out.println(id);
		
		new Thread() {
			public void run() {
				for (int j = 0; j < 10; j++) {
					GedidLoader loader = GedidLoader.init(GedidConfig.defaultConfig());
					Gedid user = loader.follow("user");
					
					Long id = user.next();
					System.out.println("A"+id+"j= "+j);
				}
			}
			
		}.start();
		
		new Thread() {
			public void run() {
				for (int j = 0; j < 10; j++) {
					GedidLoader loader = GedidLoader.init(GedidConfig.defaultConfig());
					Gedid user = loader.follow("user");
					
					Long id = user.next();
					System.out.println("B"+id+"j= "+j);
				}
			}
			
		}.start();

	}

}
