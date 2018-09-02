package cn.zhucongqi.gedid;

public class GedidConfig {

	/**
	 * DC Server Ip
	 */
	private String ip;
	
	/**
	 * DC server port
	 */
	private Integer port;
	
	/**
	 * DC(Redis) auth password
	 */
	private String auth;
	
	/**
	 * The Start ID default 1
	 */
	private Integer startId;
	
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
	 * @return the startId
	 */
	public Integer getStartId() {
		return startId;
	}

	/**
	 * @param startId the startId to set
	 */
	public void setStartId(Integer startId) {
		this.startId = startId;
	}

	/**
	 * Redis Default Config<br/>
	 * host: 127.0.0.1; Port: 6379.
	 */
	public static GedidConfig defaultConfig() {
		GedidConfig config = new GedidConfig();
		config.startId = 1;
		config.setIp("127.0.0.1");
		config.setPort(6379);
		return config;
	}

	@Override
	public String toString() {
		return "GedidConfig [ip=" + ip + ", port=" + port + ", auth=" + auth + ", startId=" + startId + "]";
	}
	
}
