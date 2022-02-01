package cooperation.qqpim;

import android.content.Intent;
import avfw;
import avfw.d;
import avli;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;

public class QQPimPluginProxyService
  extends PluginProxyService
{
  public static void eQ(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      Intent localIntent = new Intent(paramQQAppInterface.getApp(), QQPimPluginProxyService.class);
      avfw.d locald = new avfw.d(1);
      locald.mPluginID = "qqpim_plugin.apk";
      locald.mPluginName = "QQ同步助手插件";
      locald.mUin = paramQQAppInterface.getCurrentAccountUin();
      locald.cKu = avli.cLQ;
      locald.mIntent = localIntent;
      avfw.c(paramQQAppInterface.getApp(), locald);
    } while (!QLog.isColorLevel());
    QLog.i(avli.TAG, 2, "QQPimPluginProxyService.preloadQQPimService() IPluginManager.SUPPORT_NETWORKING = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyService
 * JD-Core Version:    0.7.0.1
 */