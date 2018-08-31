package cn.zhucongqi.gedid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cn.zhucongqi.gedid.core.Gedid;

class GedidLoaderTest {

	GedidLoader init;
	
	@BeforeEach
	void setUp() throws Exception {
		init = new GedidLoader(GedidConfig.defaultConfig());
	}

	@Test
	void test() {
		Gedid user = init.follow("user");
		
		long id = user.next();
		System.out.println(id);
		
		Gedid order = init.follow("order");
		
		id = order.next();
		System.out.println(id);

	}

}
