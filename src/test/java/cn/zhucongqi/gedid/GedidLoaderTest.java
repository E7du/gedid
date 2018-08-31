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
		
		long id = user.next();
		System.out.println(id);
		
		Gedid order = loader.follow("order");
		
		id = order.next();
		System.out.println(id);
		
		new Thread() {
			public void run() {
				for (int j = 0; j < 10; j++) {
					GedidLoader loader = GedidLoader.init(GedidConfig.defaultConfig());
					Gedid user = loader.follow("user");
					
					long id = user.next();
					System.out.println("A"+id+"j= "+j);
				}
			}
			
		}.start();
		
		new Thread() {
			public void run() {
				for (int j = 0; j < 10; j++) {
					GedidLoader loader = GedidLoader.init(GedidConfig.defaultConfig());
					Gedid user = loader.follow("user");
					
					long id = user.next();
					System.out.println("B"+id+"j= "+j);
				}
			}
			
		}.start();

	}

}
