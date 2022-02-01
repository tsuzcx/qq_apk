package com.tencent.mobileqq.pluginsdk;

import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;

/**
 * @author chaosxian
 **/
interface RemotePluginManager {
	/**
	 * install the specified plugin with callback.
	 */
	void installPlugin(String pluginId, OnPluginInstallListener listener);
	
	/**
	 * check the specified plugin installed or not.
	 */
	boolean isPlugininstalled(String pluginId);
	
	/**
	 * query the specified plugin info.
	 */
	PluginBaseInfo queryPlugin(String pluginId);
	
	/**
	 * cancel the specified plugin.
	 */
	void cancelInstall(String pluginId);
	
	/**
	 * is plugin manager ready to run.
	 */
	boolean isReady();

	void setListener(RemotePluginManager manager);
}