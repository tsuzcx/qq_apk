package cooperation.weiyun;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import avfw;
import avfw.d;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class AlbumBackupProxyActivity
  extends PluginProxyActivity
{
  public static void i(Activity paramActivity, String paramString1, String paramString2)
  {
    i(paramActivity, paramString1, paramString2, -1);
  }
  
  public static void i(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(536870912);
    localIntent.putExtra("userQqResources", 1);
    localIntent.putExtra("useSkinEngine", true);
    localIntent.putExtra("weiyun_backup_source", paramString2);
    paramString2 = new avfw.d(0);
    paramString2.mPluginID = "WeiyunPlugin.apk";
    paramString2.mPluginName = paramActivity.getResources().getString(2131721855);
    paramString2.mUin = paramString1;
    paramString2.cKu = "com.weiyun.plugin.cloudalbum.activity.CloudAlbumActivity";
    paramString2.K = AlbumBackupProxyActivity.class;
    paramString2.mIntent = localIntent;
    if (paramInt != -1) {
      paramString2.mRequestCode = paramInt;
    }
    avfw.a(paramActivity, paramString2);
  }
  
  public String getPluginID()
  {
    return "WeiyunPlugin.apk";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.weiyun.AlbumBackupProxyActivity
 * JD-Core Version:    0.7.0.1
 */