package cooperation.qqfav;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import avfw;
import avfw.d;
import avja;
import avkq;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;

public class QfavPluginProxyActivity
  extends PluginProxyActivity
{
  private static Class<? extends PluginProxyActivity> a(Intent paramIntent)
  {
    String str = g(paramIntent);
    if ("com.qqfav.FavoriteIpcDelegate".equals(str)) {
      return ForResult.class;
    }
    if ((str != null) && ((str.equals("com.qqfav.activity.AddPhotosFavActivity")) || (str.equals("com.qqfav.activity.AddLocationFavActivity")) || (str.equals("com.qqfav.FavoriteIpcDelegate")) || (str.equals("com.qqfav.file.activity.QfavFileBrowserActivity")))) {
      paramIntent.setFlags(paramIntent.getFlags() | 0x20000000);
    }
    if ((paramIntent.getFlags() & 0x20000000) != 0) {
      return SingleTop.class;
    }
    if ((str != null) && ((str.equals("com.qqfav.activity.AddPhotosFavActivity")) || (str.equals("com.qqfav.activity.AddLocationFavActivity")) || (str.equals("com.qqfav.FavoriteIpcDelegate")) || (str.equals("com.qqfav.edit.EditPhotosActivity")) || (str.equals("com.qqfav.file.activity.QfavFileBrowserActivity"))))
    {
      paramIntent.setFlags(paramIntent.getFlags() | 0x20000000);
      return SingleTop.class;
    }
    return QfavPluginProxyActivity.class;
  }
  
  public static boolean a(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    return a(paramContext, paramString, paramIntent, paramInt, false);
  }
  
  public static boolean a(Context paramContext, String paramString, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    QfavPluginProxyService.aKH();
    if ((paramIntent.getBooleanExtra("bShowProgress", false)) && (!avja.cK(paramContext))) {}
    for (avkq localavkq = new avkq(paramContext);; localavkq = null)
    {
      String str = g(paramIntent);
      paramIntent.putExtra("useSkinEngine", true);
      paramIntent.putExtra("userQqResources", 1);
      if ((paramBoolean) || (!(paramContext instanceof Activity))) {
        paramIntent.addFlags(268435456);
      }
      avfw.d locald = new avfw.d(0);
      locald.mPluginID = "qqfav.apk";
      locald.mPluginName = "qqfav.apk";
      locald.mUin = paramString;
      locald.cKu = str;
      locald.K = a(paramIntent);
      locald.mIntent = paramIntent;
      locald.mRequestCode = paramInt;
      locald.mDialog = localavkq;
      locald.mTimeOut = 30000;
      locald.cKv = null;
      locald.dmV = false;
      avfw.a(paramContext, locald);
      QLog.i("qqfav", 2, "QfavPluginProxyActivity: openPluginActivityForResult: " + str);
      return true;
    }
  }
  
  private static String g(Intent paramIntent)
  {
    switch (paramIntent.getIntExtra("nOperation", -1))
    {
    case 4: 
    case 5: 
    default: 
      paramIntent = paramIntent.getComponent();
      if (paramIntent == null) {
        return null;
      }
      break;
    case 0: 
    case 1: 
    case 3: 
    case 6: 
    case 7: 
    case 8: 
      return "com.qqfav.FavoriteIpcDelegate";
    case 9: 
      return "com.qqfav.group.activity.QfavGroupActivity";
    case 2: 
      return "com.qqfav.activity.FavoritesListActivity";
    }
    return paramIntent.getClassName();
  }
  
  public String getPluginID()
  {
    return "qqfav.apk";
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    if (paramString.equals("com.qqfav.activity.ImageDetailActivity")) {
      return ImageViewer.class;
    }
    if (paramString.matches("com\\.qqfav\\.activity\\..*DetailActivity"))
    {
      if ((this instanceof DetailProxy)) {
        return SingleTop.class;
      }
      return DetailProxy.class;
    }
    if ((paramString.equals("com.qqfav.activity.AddPhotosFavActivity")) || (paramString.equals("com.qqfav.activity.AddLocationFavActivity")) || (paramString.equals("com.qqfav.FavoriteIpcDelegate")) || (paramString.equals("com.qqfav.edit.EditPhotosActivity")) || (paramString.equals("com.qqfav.group.activity.QfavGroupActivity")) || (paramString.equals("com.qqfav.file.activity.QfavFileBrowserActivity"))) {
      return SingleTop.class;
    }
    if (paramString.equals("com.qqfav.edit.QfavEditActivity")) {
      return DetailProxy.class;
    }
    return super.getProxyActivity(paramString);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    getIntent().removeExtra("fling_action_key");
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if ((paramBundle != null) && (paramBundle.getInt("nOperation") == 6)) {
      super.overridePendingTransition(2130772004, 2130772005);
    }
  }
  
  public static class DetailProxy
    extends QfavPluginProxyActivity.SingleTop
  {}
  
  public static class ForResult
    extends QfavPluginProxyActivity
  {}
  
  public static class ImageViewer
    extends QfavPluginProxyActivity.DetailProxy
  {}
  
  public static class ScreenOrientationProxy
    extends QfavPluginProxyActivity
  {}
  
  public static class SingleTop
    extends QfavPluginProxyActivity
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */