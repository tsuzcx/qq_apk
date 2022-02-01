package cooperation.qqindividuality.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import avfw;
import avfw.d;
import avky;
import avld;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQIndividualityPluginProxyService
  extends PluginProxyService
{
  private static avky jdField_a_of_type_Avky;
  private static avld jdField_a_of_type_Avld;
  
  public static avky a()
  {
    if (jdField_a_of_type_Avky == null) {}
    try
    {
      if (jdField_a_of_type_Avky == null) {
        jdField_a_of_type_Avky = new avky(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Avky;
    }
    finally {}
  }
  
  public static avld a()
  {
    if (jdField_a_of_type_Avld == null) {}
    try
    {
      if (jdField_a_of_type_Avld == null) {
        jdField_a_of_type_Avld = new avld(BaseApplicationImpl.getApplication().getRuntime());
      }
      return jdField_a_of_type_Avld;
    }
    finally {}
  }
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection, String paramString)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), QQIndividualityPluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = "qqindividuality_plugin.apk";
    locald.mPluginName = PluginInfo.cKK;
    locald.mUin = paramAppRuntime.getAccount();
    locald.cKu = paramString;
    locald.mIntent = localIntent;
    locald.mServiceConnection = paramServiceConnection;
    avfw.c(paramAppRuntime.getApplication(), locald);
  }
  
  public static boolean aKH()
  {
    avky localavky = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localavky.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localavky);
      return true;
    }
    return false;
  }
  
  public static void e(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    paramAppRuntime.getApplication().unbindService(paramServiceConnection);
  }
  
  public static void eAA()
  {
    if (jdField_a_of_type_Avld != null)
    {
      jdField_a_of_type_Avld.tv("qqindividuality_signature");
      jdField_a_of_type_Avld = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService
 * JD-Core Version:    0.7.0.1
 */