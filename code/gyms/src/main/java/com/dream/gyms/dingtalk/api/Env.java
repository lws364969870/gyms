package com.dream.gyms.dingtalk.api;

/**
 * 企业应用接入时的常量定义
 */
public class Env {

	/**
	 * 企业应用接入秘钥相关
	 */
	// 企业Id
	public static final String CORP_ID = "dingf0a0f351e9b0458935c2f4657eb6378f";
	// 企业应用的凭证密钥
	public static final String CORP_SECRET = "2zcEfu-MQO-tz4grZ_SUvNLIHjsl0uyihNPj3CulH3ItXlP8M6GqYi2X6XODZJK5";
	public static final String SSO_Secret = "k-eh23D93iKsrOd6kKAcYGmjefOQaBSVeDVzrMtCc__zdI4oYsi8xmftWtv3TeeJ";

	/**
	 * DING API地址
	 */
	public static final String OAPI_HOST = "https://oapi.dingtalk.com";
	/**
	 * 企业应用后台地址，用户管理后台免登使用
	 */
	public static final String OA_BACKGROUND_URL = "https://www.douyu.com";

	/**
	 * 企业通讯回调加密Token，注册事件回调接口时需要传递给钉钉服务器
	 */
	public static final String TOKEN = "";
	public static final String ENCODING_AES_KEY = "";

}
