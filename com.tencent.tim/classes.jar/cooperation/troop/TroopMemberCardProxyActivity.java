package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import anot;
import avfw;
import avfw.d;
import awjp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;

public class TroopMemberCardProxyActivity
  extends TroopBaseProxyActivity
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Class paramClass, Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString3, String paramString4, int paramInt)
  {
    paramQQAppInterface = new awjp(paramQQAppInterface);
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null) {
      localPluginCommunicationHandler.register(paramQQAppInterface);
    }
    paramQQAppInterface = new avfw.d(1);
    paramQQAppInterface.mPluginID = paramString1;
    paramQQAppInterface.mPluginName = paramString2;
    paramQQAppInterface.mUin = paramString4;
    paramQQAppInterface.cKu = paramString3;
    paramQQAppInterface.K = paramClass;
    paramQQAppInterface.mIntent = paramIntent;
    paramQQAppInterface.mDialog = paramDialog;
    paramQQAppInterface.mIntent.putExtra("userQqResources", 2);
    paramQQAppInterface.mIntent.putExtra("param_plugin_gesturelock", true);
    paramQQAppInterface.mIntent.putExtra("useSkinEngine", true);
    paramQQAppInterface.mRequestCode = paramInt;
    paramQQAppInterface.mTimeOut = 10000;
    paramQQAppInterface.cKv = null;
    avfw.a(paramActivity, paramQQAppInterface);
    anot.a(null, "P_CliOper", "BizTechReport", "", "troop_member_card_plugin", "load_plugin", 0, 0, null, null, null, null);
  }
  
  public String getPluginID()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.troop.TroopMemberCardProxyActivity
 * JD-Core Version:    0.7.0.1
 */