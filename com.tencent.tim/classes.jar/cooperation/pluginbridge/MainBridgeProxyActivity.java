package cooperation.pluginbridge;

import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;

public class MainBridgeProxyActivity
  extends PluginProxyActivity
{
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("MainBridgeProxyActivity", 2, "getProxyActivity:" + paramString);
    }
    return super.getProxyActivity(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.pluginbridge.MainBridgeProxyActivity
 * JD-Core Version:    0.7.0.1
 */