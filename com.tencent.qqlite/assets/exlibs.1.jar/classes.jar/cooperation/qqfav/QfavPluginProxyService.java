package cooperation.qqfav;

import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qqfav.ipc.FavoritesRemoteCommand;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QfavPluginProxyService
  extends PluginProxyService
{
  private static FavoritesRemoteCommand jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand = null;
  private static QfavRemoteProxyForQQ jdField_a_of_type_CooperationQqfavIpcQfavRemoteProxyForQQ = null;
  
  public static FavoritesRemoteCommand a()
  {
    if (jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand == null) {
        jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand = new FavoritesRemoteCommand(BaseApplicationImpl.a().a());
      }
      return jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand;
    }
    finally {}
  }
  
  public static QfavRemoteProxyForQQ a()
  {
    if (jdField_a_of_type_CooperationQqfavIpcQfavRemoteProxyForQQ == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQqfavIpcQfavRemoteProxyForQQ == null) {
        jdField_a_of_type_CooperationQqfavIpcQfavRemoteProxyForQQ = new QfavRemoteProxyForQQ(BaseApplicationImpl.a().a());
      }
      return jdField_a_of_type_CooperationQqfavIpcQfavRemoteProxyForQQ;
    }
    finally {}
  }
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    paramAppRuntime.getApplication().unbindService(paramServiceConnection);
  }
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection, String paramString)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), QfavPluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "qqfav.apk";
    localPluginParams.d = "qqfav.apk";
    localPluginParams.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localPluginParams.e = paramString;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    IPluginManager.b(paramAppRuntime.getApplication(), localPluginParams);
  }
  
  public static boolean a()
  {
    FavoritesRemoteCommand localFavoritesRemoteCommand = a();
    if (!PluginCommunicationHandler.getInstance().containsCmd(localFavoritesRemoteCommand.getCmd()))
    {
      PluginCommunicationHandler.getInstance().register(localFavoritesRemoteCommand);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyService
 * JD-Core Version:    0.7.0.1
 */