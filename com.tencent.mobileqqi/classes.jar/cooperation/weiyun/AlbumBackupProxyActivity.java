package cooperation.weiyun;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class AlbumBackupProxyActivity
  extends PluginProxyActivity
{
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(536870912);
    localIntent.putExtra("userQqResources", 1);
    localIntent.putExtra("useSkinEngine", true);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "WeiyunPlugin.apk";
    localPluginParams.d = paramActivity.getResources().getString(2131563305);
    localPluginParams.jdField_a_of_type_JavaLangString = paramString;
    localPluginParams.e = "com.weiyun.plugin.albumbackup.activity.AlbumBackupActivity";
    localPluginParams.jdField_a_of_type_JavaLangClass = AlbumBackupProxyActivity.class;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.a(paramActivity, localPluginParams);
  }
  
  public String getPluginID()
  {
    return "WeiyunPlugin.apk";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.weiyun.AlbumBackupProxyActivity
 * JD-Core Version:    0.7.0.1
 */