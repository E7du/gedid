package cn.zhucongqi.gedid.core.dc;

public interface GedidDC {
	
	/**
	 * Follow The business with name.
	 * @param name
	 * @return true, follow success.
	 */
	boolean follow(String name);
	
	/**
	 * Increment id.
	 * @return
	 */
	long incr();
	
}
