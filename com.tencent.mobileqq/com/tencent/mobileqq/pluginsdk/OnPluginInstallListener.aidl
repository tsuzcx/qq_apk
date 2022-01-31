package com.tencent.mobileqq.pluginsdk;

/**
 * @author chaosxian
 **/
interface OnPluginInstallListener {
	/**
	 * 开始安装
	 */
	void onInstallBegin(String pluginId);
	/**
	 * 有可能不需要下载
	 * @param pluginId
	 * @param offset
	 * @param total
	 */
	void onInstallDownloadProgress(String pluginId, int offset, int total);
	/**
	 * 安装完成
	 */
	void onInstallFinish(String pluginId);
	/**
	 * notice:在整个过程中随时能够通知error，一旦通知，即安装过程停止，别的事件不会再有。
	 * @param pluinId
	 * @param errorCode
	 */
	void onInstallError(String pluginId, int errorCode);
	
}
