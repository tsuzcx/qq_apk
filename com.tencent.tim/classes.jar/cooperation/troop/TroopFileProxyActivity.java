package cooperation.troop;

import acfp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import avfw;
import avfw.d;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import java.util.ArrayList;

public class TroopFileProxyActivity
  extends TroopBaseProxyActivity
{
  public static ArrayList<FileInfo> aw = new ArrayList();
  public static String cjr = "key_qun_id";
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = "troop_plugin.apk";
    locald.mPluginName = acfp.m(2131715688);
    locald.mUin = paramString2;
    locald.cKu = paramString1;
    locald.K = TroopFileProxyActivity.class;
    locald.mIntent = paramIntent;
    locald.mDialog = paramDialog;
    paramIntent.putExtra("userQqResources", 1);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    locald.mRequestCode = paramInt;
    locald.mTimeOut = 10000;
    locald.cKv = null;
    avfw.a(paramActivity, locald);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    a(paramActivity, paramIntent, null, "com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity", paramString, 0);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent, int paramInt, String paramString)
  {
    a(paramActivity, paramIntent, null, "com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity", paramString, paramInt);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent, String paramString)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.TroopFileUploadActivity", paramString, 0);
  }
  
  public static void c(Activity paramActivity, Intent paramIntent, String paramString)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.TroopFileSearchByTypeActivity", paramString, 0);
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return TroopFileProxyActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.troop.TroopFileProxyActivity
 * JD-Core Version:    0.7.0.1
 */