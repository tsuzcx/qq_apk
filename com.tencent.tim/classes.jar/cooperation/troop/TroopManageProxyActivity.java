package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import anot;
import avfw;
import avfw.d;

public class TroopManageProxyActivity
  extends TroopBaseProxyActivity
{
  public static void a(String paramString1, String paramString2, Class paramClass, Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString3, String paramString4, int paramInt)
  {
    avfw.d locald = new avfw.d(1);
    locald.mPluginID = paramString1;
    locald.mPluginName = paramString2;
    locald.mUin = paramString4;
    locald.cKu = paramString3;
    locald.K = paramClass;
    locald.mIntent = paramIntent;
    locald.mDialog = paramDialog;
    paramIntent.putExtra("userQqResources", 1);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    locald.mIntent.putExtra("useSkinEngine", true);
    locald.mRequestCode = paramInt;
    locald.mTimeOut = 10000;
    locald.cKv = null;
    avfw.a(paramActivity, locald);
    anot.a(null, "P_CliOper", "BizTechReport", "", "troop_manage_plugin", "load_plugin_v2", 0, 0, null, null, null, null);
  }
  
  public String getPluginID()
  {
    return "troop_manage_plugin.apk";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.troop.TroopManageProxyActivity
 * JD-Core Version:    0.7.0.1
 */