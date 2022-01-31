package cooperation.qzone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.tools.MD5;

public class QZoneHelper
{
  public static final String A = "key_nearby_profile";
  public static final String B = "key_nearby_qzone_to_aio";
  public static final String C = "nearby_qzone_to_aio";
  public static final String D = "qqid";
  public static final String E = "k_modal";
  public static final String F = "k_hide_qzone_icon";
  public static final String G = "qqid";
  public static final String H = "com.qzone.detail.ui.activity.QzoneDetailActivity";
  public static final String I = "com.qzone.publish.ui.activity.QZonePublishMoodActivity";
  public static final String J = "com.qzone.album.ui.activity.QZonePersonalAlbumActivity";
  public static final String K = "com.qzone.album.ui.activity.QZonePersonalPhotoListActivity";
  public static final String L = "com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity";
  public static final String M = "com.qzone.qun.ui.activity.QzoneTroopAlbumViewPhotoActivity";
  public static final String N = "com.qzone.album.share.ui.activity.QzoneShareAlbumFeedActivity";
  public static final String O = "com.qzone.homepage.ui.activity.QZoneUserHomeActivity";
  public static final String P = "com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity";
  public static final String Q = "com.qzone.setting.QZoneSettingManager";
  public static final String R = "com.qzone.cover.ui.activity.QzoneCoverPhotoWallActivity";
  public static final String S = "com.qzone.lbs.ui.activity.QZoneMoodSelectLocation";
  public static final String T = "com.qzone.feed.ui.activity.QZoneFriendFeedActivity";
  public static final String U = "com.qzone.cover.ui.activity.QZoneCoverStoreActivity";
  public static final String V = "com.qzone.preview.QzonePictureViewer";
  public static final String W = "com.tencent.qq.syncQunMsg";
  public static final String X = "com.tencent.qq.unreadcount";
  private static final String Y = "com.qzone.app.QZoneAppInterface";
  private static final String Z = "com.qzone.component.cache.CacheManager";
  public static final String a = "qzone_key_publish_mood_camera_flag";
  public static final String b = "qzone_key_skip_from_widget";
  public static final String c = "qzone_start";
  public static final String d = "key_select_poi";
  public static final String e = "com.qzone";
  public static final String f = "com.tencent.zebra";
  public static final String g = "com.adobe.flashplayer";
  public static final String h = "aciton_check_qzone_vip_info";
  public static final String i = "requestQzoneOpenVip";
  public static final String j = "http://pay.qq.com/h5/index.shtml?m=buy&c=xxjzgw&aid={AID}&sid={SID}&u={UIN}&pf=2103&su=pay%3A%2F%2FrequestQzoneOpenVip";
  public static final String k = "pay://requestQzoneOpenVip";
  public static final String l = "key_qzone_vip_open_back_need_check_vipinfo";
  public static final String m = "file" + File.separator + "image";
  public static final String n = "qzone_uin";
  public static final String o = "nickname";
  public static final String p = "sid";
  public static final String q = "com.qzone.preview.service.PictureService";
  public static final String r = "com.qzone.publish.service.PublishQueueService";
  public static final String s = "com.qzone.intent.action.PRELOAD_FRIEND_FEEDS";
  public static final String t = "com.qzone.intent.action.PRELOAD_QUN_ALBUM_FEEDS";
  public static final String u = "com.qzone.intent.action.PRE_DOWNLOAD_PHOTOS";
  public static final String v = "com.qzone.intent.action.LAUNCH_BY_WEB_MUSIC";
  public static final String w = "com.qzone.intent.action.LAUNCH_PUBLISH_QUEUE";
  public static final String x = "SQQzoneSvc.";
  public static final String y = "qzone_entry";
  public static final String z = "key_has_talk";
  
  public static int a()
  {
    return QzoneConfig.a().a("QZoneSetting", "UpdateCountIntervalWhenClickFeedTab", 30) * 1000;
  }
  
  private static Intent a(Context paramContext, Long paramLong, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_left_tab_title", paramContext.getString(2131364505));
    localIntent.putExtra("key_rihgt_tab_title", paramContext.getString(2131364504));
    localIntent.putExtra("key_album_owner_uin", paramLong);
    localIntent.putExtra("key_selected_tab", paramInt);
    a(localIntent);
    a();
    return localIntent;
  }
  
  private static Intent a(QZoneHelper.UserInfo paramUserInfo, String paramString)
  {
    paramString = new Intent();
    a(paramString, paramUserInfo);
    a();
    return paramString;
  }
  
  public static Intent a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("qqid", Long.parseLong(paramString));
    localIntent.putExtra("qzone_entry", 5);
    a(localIntent);
    return localIntent;
  }
  
  public static String a()
  {
    return QUA.a();
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    PerfTracer.a(null, "Runtime_load_runtime");
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramBaseApplicationImpl = Class.forName("com.qzone.app.QZoneAppInterface");
      if (paramBaseApplicationImpl == null)
      {
        QLog.e("QZLog", 1, "*createQZoneAppInterface load class fail");
        return null;
      }
      paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      if ((paramBaseApplicationImpl != null) && ((paramBaseApplicationImpl instanceof AppRuntime)))
      {
        paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
      }
    }
    catch (ClassNotFoundException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.a("Runtime_load_runtime", null);
      }
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.a("Runtime_load_runtime", null);
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.a("Runtime_load_runtime", null);
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.a("Runtime_load_runtime", null);
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.a("Runtime_load_runtime", null);
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.a("Runtime_load_runtime", null);
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.a("Runtime_load_runtime", null);
      }
    }
    finally
    {
      PerfTracer.a("Runtime_load_runtime", null);
    }
    return null;
  }
  
  private static void a()
  {
    QQToast.a(BaseApplication.getContext(), 2131364501, 0).a();
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    paramActivity = new Intent();
    a(paramActivity, paramUserInfo);
    paramActivity.putExtra("k_modal", true);
    paramActivity.putExtra("k_hide_qzone_icon", true);
    a();
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, long paramLong, int paramInt)
  {
    paramActivity = new Intent();
    a(paramActivity, paramUserInfo);
    paramActivity.putExtra("qqid", paramLong);
    a();
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    a(paramUserInfo, "com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity").putExtras(paramBundle);
    a();
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "QzoneRecent_click2Activity");
    paramActivity = a(paramActivity, paramLong, paramInt1);
    a(paramActivity, paramUserInfo);
    a(paramActivity, paramInt2);
    a();
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, ProfileActivity.AllInOne paramAllInOne)
  {
    paramActivity = a(paramString);
    a(paramActivity, paramUserInfo);
    paramActivity.putExtra("key_has_talk", paramBoolean);
    paramActivity.putExtra("key_nearby_profile", paramAllInOne);
    a(paramActivity, paramInt1);
    a();
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, int paramInt, String paramString2)
  {
    paramActivity = new Intent();
    a(paramActivity, paramUserInfo);
    paramActivity.putExtra("mqqflag", 1);
    paramActivity.putExtra("cell_operation.qq_url", paramString1);
    paramActivity.putExtra("refer", "mqqChat");
    a();
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, long paramLong, int paramInt)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "Detail_click2Activity");
    paramActivity = new Intent("android.intent.action.MAIN");
    a(paramActivity, paramUserInfo);
    paramActivity.putExtra("qzone.cellid", paramString);
    paramActivity.putExtra("qzone.sourceFrom", true);
    paramActivity.putExtra("qzone.favorOwner", paramLong);
    a();
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "Detail_click2Activity");
    paramActivity = new Intent();
    a(paramActivity, paramUserInfo);
    paramActivity.putExtra("mqqflag", 1);
    paramActivity.putExtra("cell_operation.qq_url", paramString1);
    paramActivity.putExtra("refer", paramString2);
    a();
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "Detail_click2Activity");
    paramActivity = new Intent();
    a(paramActivity, paramUserInfo);
    paramActivity.putExtra("mqqflag", 1);
    paramActivity.putExtra("cell_operation.qq_url", paramString1);
    paramActivity.putExtra("refer", paramString2);
    paramActivity.putExtra("appid", paramInt1);
    paramActivity.setFlags(67108864);
    a();
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramActivity = new Intent("com.tencent.intent.QZONE_PUBLISH_QR_CODE");
    a(paramActivity, paramUserInfo);
    paramActivity.putExtra("key_file_path", paramString1);
    paramActivity.putExtra("key_title", paramString2);
    paramActivity.putExtra("key_desc", paramString3);
    a();
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "QunAlbum_click2Activity");
    paramActivity = new Intent();
    a(paramActivity, paramUserInfo);
    paramActivity.putExtra("mqqflag", 1);
    paramActivity.putExtra("key_qun_id", paramString1);
    paramActivity.putExtra("key_album_id", paramString2);
    paramActivity.putExtra("cell_operation.qq_url", paramString3);
    paramActivity.putExtra("refer", paramString4);
    paramActivity.putExtra("qundetail", 1);
    a();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.qq.syncQunMsg");
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.tencent.qq.unreadcount", paramInt);
    localIntent.putExtras(localBundle);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    do
    {
      return;
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.qqlite:picture");
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.qqlite:qzone");
      String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "image";
      if (str != null) {
        FileUtil.c(str);
      }
      str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.tencent.qqlite" + File.separator + "qzone" + File.separator + "cache" + File.separator + "video";
      if (str != null) {
        FileUtil.c(str);
      }
      str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.tencent.qqlite" + File.separator + "files" + File.separator + "MaxVideo" + File.separator + "Source";
      if (!TextUtils.isEmpty(str)) {
        FileUtil.c(str);
      }
      str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.tencent.qqlite" + File.separator + "files" + File.separator + "MaxVideo" + File.separator + "trimvideo";
      if (!TextUtils.isEmpty(str)) {
        FileUtil.c(str);
      }
      str = paramContext.getCacheDir().getAbsolutePath() + File.separator + "qzone" + File.separator + "file" + File.separator + "image";
      if (str != null) {
        FileUtil.c(str);
      }
    } while (TextUtils.isEmpty(paramString));
    paramContext.deleteDatabase(SecurityUtil.a(paramString));
  }
  
  public static void a(Intent paramIntent)
  {
    paramIntent.putExtra("key_time_record", System.currentTimeMillis());
  }
  
  private static void a(Intent paramIntent, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramIntent.putExtra("refer", "mqqSetProfile");
      return;
    case 2: 
      paramIntent.putExtra("refer", "mqqAvatar");
      return;
    case 3: 
      paramIntent.putExtra("refer", "mqqQuanzi");
      return;
    case 4: 
      paramIntent.putExtra("refer", "mqqNearby");
      return;
    case 5: 
      paramIntent.putExtra("refer", "mqqChat");
      return;
    }
    paramIntent.putExtra("refer", "mqqQunSpace");
  }
  
  public static void a(Intent paramIntent, QZoneHelper.UserInfo paramUserInfo)
  {
    paramIntent.putExtra("qzone_uin", paramUserInfo.a);
    paramIntent.putExtra("nickname", paramUserInfo.b);
    paramIntent.putExtra("sid", paramUserInfo.c);
  }
  
  public static void a(QQAppInterface paramQQAppInterface) {}
  
  public static void a(QQAppInterface paramQQAppInterface, ServiceConnection paramServiceConnection) {}
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_id");
    paramString1 = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_title");
    LocalMultiProcConfig.a(str, paramString3);
    LocalMultiProcConfig.a(paramString1, paramString4);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager().getInstalledPackages(4).iterator();
    while (paramContext.hasNext()) {
      if (paramString.equals(((PackageInfo)paramContext.next()).packageName)) {
        return true;
      }
    }
    return false;
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    a(paramUserInfo, "com.qzone.preview.QzonePictureViewer").putExtras(paramBundle);
    a();
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "Detail_click2Activity");
    paramActivity = new Intent();
    a(paramActivity, paramUserInfo);
    paramActivity.putExtra("mqqflag", 1);
    paramActivity.putExtra("cell_operation.qq_url", paramString1);
    paramActivity.putExtra("refer", paramString2);
    paramActivity.putExtra("qundetail", 1);
    a();
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    PerfTracer.a(null, "click2LoadCompleted");
    PerfTracer.a(null, "ShareAlbum_click2Activity");
    paramActivity = new Intent();
    a(paramActivity, paramUserInfo);
    paramActivity.putExtra("mqqflag", 1);
    paramActivity.putExtra("key_album_id", paramString1);
    paramActivity.putExtra("key_album_name", paramString2);
    paramActivity.putExtra("refer", paramString3);
    paramActivity.putExtra("key_album_cover", paramString4);
    a(paramActivity);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper
 * JD-Core Version:    0.7.0.1
 */