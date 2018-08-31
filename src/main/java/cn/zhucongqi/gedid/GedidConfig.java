package cn.zhucongqi.gedid;

public class GedidConfig {

	/**
	 * Redis Server Ip
	 */
	private String ip;
	
	/**
	 * Redis server port
	 */
	private Integer port;
	
	/**
	 * Redis auth password
	 */
	private String auth;

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * @return the auth
	 */
	public String getAuth() {
		return auth;
	}

	/**
	 * @param auth the auth to set
	 */
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
	/**
	 * Redis Default Config<br/>
	 * host: 127.0.0.1; Port: 6379.
	 */
	public static GedidConfig defaultConfig() {
		GedidConfig config = new GedidConfig();
		config.setIp("127.0.0.1");
		config.setPort(6379);
		return config;
	}

	@Override
	public String toString() {
		return "GedidConfig [ip=" + ip + ", port=" + port + ", auth=" + auth + "]";
	}
	
}
