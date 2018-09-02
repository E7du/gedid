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
