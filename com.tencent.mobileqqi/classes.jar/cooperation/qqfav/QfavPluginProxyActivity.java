package cooperation.qqfav;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class QfavPluginProxyActivity
  extends PluginProxyActivity
{
  public static final String a = "com.qqfav.activity.FavoritesListActivity";
  public static final String b = "com.qqfav.FavoriteIpcDelegate";
  private static final String c = QfavPluginProxyActivity.class.getSimpleName() + ": ";
  
  private static Class a(Intent paramIntent)
  {
    if ((paramIntent.getFlags() & 0x20000000) != 0) {
      return QfavPluginProxyActivity.SingleTop.class;
    }
    String str = a(paramIntent);
    if ((str != null) && ((str.equals("com.qqfav.activity.AddPhotosFavActivity")) || (str.equals("com.qqfav.activity.AddLocationFavActivity"))))
    {
      paramIntent.setFlags(paramIntent.getFlags() | 0x20000000);
      return QfavPluginProxyActivity.SingleTop.class;
    }
    return QfavPluginProxyActivity.class;
  }
  
  private static String a(Intent paramIntent)
  {
    switch (paramIntent.getIntExtra("nOperation", -1))
    {
    case 1: 
    default: 
      paramIntent = paramIntent.getComponent();
      if (paramIntent == null) {
        return null;
      }
      break;
    case 0: 
    case 3: 
      return "com.qqfav.FavoriteIpcDelegate";
    case 2: 
      return "com.qqfav.activity.FavoritesListActivity";
    }
    return paramIntent.getClassName();
  }
  
  public static boolean a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    if ((paramIntent.getBooleanExtra("bShowProgress", false)) && (!QfavHelper.a(paramActivity))) {}
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131427376));
        IPluginManager.PluginParams localPluginParams;
        localObject1 = localObject2;
      }
      catch (Exception localException1)
      {
        try
        {
          ((QQProgressDialog)localObject1).a(paramActivity.getString(2131559634));
          localObject2 = a(paramIntent);
          paramIntent.putExtra("useSkinEngine", true);
          paramIntent.putExtra("userQqResources", 1);
          localPluginParams = new IPluginManager.PluginParams(0);
          localPluginParams.jdField_b_of_type_JavaLangString = "qqfav.apk";
          localPluginParams.d = "qqfav.apk";
          localPluginParams.jdField_a_of_type_JavaLangString = paramString;
          localPluginParams.e = ((String)localObject2);
          localPluginParams.jdField_a_of_type_JavaLangClass = a(paramIntent);
          localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
          localPluginParams.jdField_b_of_type_Int = paramInt;
          localPluginParams.jdField_a_of_type_AndroidAppDialog = ((Dialog)localObject1);
          localPluginParams.c = 10000;
          localPluginParams.f = null;
          IPluginManager.a(paramActivity, localPluginParams);
          return true;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject2 = localObject1;
          }
        }
        localException1 = localException1;
        localObject2 = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("qqfav", 2, "launchFavPluing|process dialog|exp:" + localException1.getMessage());
        localObject1 = localObject2;
        continue;
        localObject1 = null;
      }
    }
  }
  
  public String getPluginID()
  {
    return "qqfav.apk";
  }
  
  protected Class getProxyActivity(String paramString)
  {
    if (paramString.equals("com.qqfav.activity.ImageDetailActivity")) {
      return QfavPluginProxyActivity.ImageViewer.class;
    }
    if (paramString.matches("com\\.qqfav\\.activity\\..*DetailActivity"))
    {
      if ((this instanceof QfavPluginProxyActivity.DetailProxy)) {
        return QfavPluginProxyActivity.SingleTop.class;
      }
      return QfavPluginProxyActivity.DetailProxy.class;
    }
    if ((paramString.equals("com.qqfav.activity.AddPhotosFavActivity")) || (paramString.equals("com.qqfav.activity.AddLocationFavActivity"))) {
      return QfavPluginProxyActivity.SingleTop.class;
    }
    return super.getProxyActivity(paramString);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    getIntent().removeExtra("fling_action_key");
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */