package cooperation.qzone;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import common.qzone.component.util.SecurityUtil;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.model.CoverCacheData;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.tools.MD5;

public class QZoneHelper
{
  public static final String A = "com.qzone.qun.ui.activity.QzoneTroopAlbumViewPhotoActivity";
  public static final String B = "com.qzone.qun.ui.activity.QZoneTroopAlbumListActivity";
  public static final String C = "com.qzone.homepage.ui.activity.QZoneUserHomeActivity";
  public static final String D = "com.qzone.album.share.ui.activity.QzoneShareAlbumFeedActivity";
  public static final String E = "com.qzone.album.share.ui.activity.QZoneNewShareAlbumActivity";
  public static final String F = "com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity";
  public static final String G = "com.qzone.permissionsetting.ui.activities.QZonePermissionSettingActivity";
  public static final String H = "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity";
  public static final String I = "com.qzone.qun.ui.activity.QzoneQunFeedActivity";
  public static final String J = "com.qzone.cover.ui.activity.QzoneCoverPhotoWallActivity";
  public static final String K = "com.qzone.lbs.ui.activity.QZoneMoodSelectLocation";
  public static final String L = "com.qzone.feed.ui.activity.QZoneFriendFeedActivity";
  public static final String M = "com.qzone.cover.ui.activity.QZoneCoverStoreActivity";
  public static final String N = "com.qzone.qun.ui.activity.QzoneQunMsgbListActivity";
  public static final String O = "com.tencent.qq.syncQunMsg";
  public static final String P = "com.tencent.qq.unreadcount";
  private static final String Q = "com.qzone.app.QZoneAppInterface";
  private static final String R = "com.qzone.component.cache.CacheManager";
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
  public static final String q = "qzone_entry";
  public static final String r = "qqid";
  public static final String s = "k_modal";
  public static final String t = "k_hide_qzone_icon";
  public static final String u = "qqid";
  public static final String v = "com.qzone.detail.ui.activity.QzoneDetailActivity";
  public static final String w = "com.qzone.publish.ui.activity.QZonePublishMoodActivity";
  public static final String x = "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity";
  public static final String y = "com.qzone.album.ui.activity.QZonePersonalAlbumActivity";
  public static final String z = "com.qzone.album.ui.activity.QZonePersonalPhotoListActivity";
  
  public static Intent a(Context paramContext)
  {
    paramContext = new Intent();
    QzonePluginProxyActivity.a(paramContext, "com.qzone.feed.ui.activity.QZoneMyFeedActivity");
    return paramContext;
  }
  
  public static Intent a(Context paramContext, Long paramLong, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_left_tab_title", paramContext.getString(2131561276));
    localIntent.putExtra("key_rihgt_tab_title", paramContext.getString(2131561277));
    localIntent.putExtra("key_album_owner_uin", paramLong);
    localIntent.putExtra("key_selected_tab", paramInt);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.album.ui.activity.QZonePersonalAlbumActivity");
    return localIntent;
  }
  
  private static Intent a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString1 = new Intent(paramString1);
    paramString1.putExtra("QZoneUploadPhotoActivity.key_state_type_src", paramInt);
    paramString1.putExtra("key_qun_id", paramString2);
    paramString1.putExtra("ken_qun_name", paramString3);
    paramString1.putExtra("UploadPhoto.key_album_id", paramString4);
    paramString1.putExtra("UploadPhoto.key_album_name", paramString5);
    paramString1.putExtra("key_need_load_photo_from_intent", false);
    paramString1.putExtra("refer", paramString6);
    paramString1.putExtra("IsBack", true);
    return paramString1;
  }
  
  public static BaseBusinessAlbumInfo a(String paramString1, String paramString2)
  {
    String str = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_id");
    paramString1 = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_title");
    paramString2 = QZoneHelper.LocalConfig.a(str, "");
    paramString1 = QZoneHelper.LocalConfig.a(paramString1, "");
    paramString2 = new BaseBusinessAlbumInfo(paramString2);
    paramString2.b = paramString1;
    return paramString2;
  }
  
  public static String a()
  {
    return QUA.a();
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.qzone.app.QZoneAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        try
        {
          QLog.e("QZLog", 1, "*createQZoneAppInterface load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
        paramString = paramString;
        paramString = QzonePluginProxyActivity.a(paramBaseApplicationImpl);
        paramBaseApplicationImpl = paramString.loadClass("com.qzone.app.QZoneAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl != null) {}
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.album.share.ui.activity.QZoneNewShareAlbumActivity");
    localIntent.putExtra("refer", "share_album_zushou");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity");
    localIntent.putExtra("qqid", paramLong);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, paramIntent, paramInt, paramOnDismissListener);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, ArrayList paramArrayList, int paramInt2)
  {
    paramString1 = a(null, 1, paramString1, paramString2, paramString3, paramString4, "mqqChat");
    a(paramString1, paramUserInfo);
    QzonePluginProxyActivity.a(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    if (paramString1 == null) {
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      paramString1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      paramString1.putExtra("key_quality", paramInt1);
      paramString1.putExtra("key_album_upload_immediately", true);
      paramString1.putExtra("photoactivity_key_type", 1);
      paramString2 = String.valueOf(MessageUtils.a());
      paramIntent.putExtra("key_upload_client_key", paramString2);
      paramString1.putExtra("key_upload_client_key", paramString2);
      QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, paramString1, paramInt2);
      return;
      paramInt1 = 0;
      continue;
      paramInt1 = 3;
    }
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, CoverCacheData paramCoverCacheData, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.cover.ui.activity.QZoneCoverStoreActivity");
    localIntent.putExtra("set_source", 1);
    localIntent.putExtra("key_from", 3);
    if (paramCoverCacheData != null) {
      localIntent.putExtra("current_cover", paramCoverCacheData);
    }
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, int paramInt2)
  {
    paramLong = a(paramActivity, paramLong, paramInt1);
    a(paramLong, paramUserInfo);
    paramLong.putExtra("key_need_show_album_recent_photo", true);
    paramLong.putExtra("refer", "mqqSetting");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, paramLong, paramInt2);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    paramLong = a(paramActivity, paramLong, paramInt1);
    a(paramLong, paramUserInfo);
    a(paramLong, paramInt2);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, paramLong, paramInt3);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    localIntent.putExtra("qqid", Long.parseLong(paramString));
    localIntent.putExtra("qzone_entry", 5);
    a(localIntent, paramInt1);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, int paramInt, String paramString2)
  {
    paramString2 = new Intent();
    a(paramString2, paramUserInfo);
    QzonePluginProxyActivity.a(paramString2, "com.qzone.album.ui.activity.QZonePersonalPhotoListActivity");
    paramString2.putExtra("mqqflag", 1);
    paramString2.putExtra("cell_operation.qq_url", paramString1);
    paramString2.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, paramString2, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("qzone.cellid", paramString);
    localIntent.putExtra("qzone.sourceFrom", true);
    localIntent.putExtra("qzone.favorOwner", paramLong);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = a(null, 10, "shareId", "shareName", null, null, "share_album_dengpao");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    localIntent.putExtra("key_share_album_id", paramString1);
    localIntent.putExtra("key_share_album_name", paramString2);
    localIntent.putExtra("photoactivity_key_type", 7);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramString1 = a(null, 9, "shareId", "shareName", paramString1, paramString2, "share_album_zushou");
    a(paramString1, paramUserInfo);
    QzonePluginProxyActivity.a(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    if (paramString1 != null)
    {
      paramString1.putExtra("photoactivity_key_type", paramInt1);
      paramString1.addFlags(67108864);
      QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, paramString1, paramInt2);
    }
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_PUBLISH_QR_CODE");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodActivity");
    localIntent.putExtra("key_file_path", paramString1);
    localIntent.putExtra("key_title", paramString2);
    localIntent.putExtra("key_desc", paramString3);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.qun.ui.activity.QzoneTroopAlbumViewPhotoActivity");
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("UploadPhoto.key_album_id", paramString2);
    localIntent.putExtra("cell_operation.qq_url", paramString3);
    localIntent.putExtra("refer", paramString4);
    localIntent.putExtra("qundetail", 1);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("key_qun_code", paramString2);
    localIntent.putExtra("key_thumb_file_path", paramString3);
    localIntent.putExtra("key_big_photo_uuid", paramString4);
    localIntent.putExtra("key_msg_time", paramLong);
    localIntent.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("key_qun_code", paramString2);
    localIntent.putExtra("key_thumb_file_paths", paramArrayList1);
    localIntent.putExtra("key_big_photo_uuids", paramArrayList2);
    localIntent.putExtra("key_msg_times", paramArrayList3);
    localIntent.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.qun.ui.activity.QzoneQunMsgbListActivity");
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("ken_qun_name", paramString2);
    localIntent.putExtra("newflag", paramBoolean);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong1, long paramLong2, int paramInt2)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_QUOTE_FROM_AIO");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    if (paramBoolean)
    {
      localIntent.putExtra("key_qun_id", paramString1);
      localIntent.putExtra("key_qun_code", paramString2);
      localIntent.putExtra("key_big_photo_file_id", paramLong2);
    }
    localIntent.putExtra("key_quote_src_type", paramInt1);
    localIntent.putExtra("key_thumb_file_path", paramString3);
    localIntent.putExtra("key_big_photo_uuid", paramString4);
    localIntent.putExtra("key_msg_time", paramLong1);
    localIntent.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4, int paramInt2)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_QUOTE_FROM_AIO");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    if (paramBoolean)
    {
      localIntent.putExtra("key_qun_id", paramString1);
      localIntent.putExtra("key_qun_code", paramString2);
      localIntent.putExtra("key_big_photo_fileids", paramArrayList4);
    }
    localIntent.putExtra("key_quote_src_type", paramInt1);
    localIntent.putExtra("key_thumb_file_paths", paramArrayList1);
    localIntent.putExtra("key_big_photo_uuids", paramArrayList2);
    localIntent.putExtra("key_msg_times", paramArrayList3);
    localIntent.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    a(paramActivity, paramString, paramIntent, paramInt, null);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    QzonePluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt, paramOnDismissListener);
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
      Object localObject = new Intent(BaseApplicationImpl.getContext(), QzonePictureViewerProxyService.class);
      BaseApplicationImpl.getContext().stopService((Intent)localObject);
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:picture");
      localObject = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
      BaseApplicationImpl.getContext().stopService((Intent)localObject);
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzone");
      localObject = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "file" + File.separator + "image";
      if (localObject != null) {
        FileUtil.c((String)localObject);
      }
      localObject = paramContext.getCacheDir().getAbsolutePath() + File.separator + "qzone" + File.separator + "file" + File.separator + "image";
      if (localObject != null) {
        FileUtil.c((String)localObject);
      }
    } while (TextUtils.isEmpty(paramString));
    paramContext.deleteDatabase(SecurityUtil.a(paramString));
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
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_id");
    paramString1 = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_title");
    QZoneHelper.LocalConfig.a(str, paramString3);
    QZoneHelper.LocalConfig.a(paramString1, paramString4);
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
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, CoverCacheData paramCoverCacheData, int paramInt)
  {
    if (paramCoverCacheData == null) {
      return;
    }
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.cover.ui.activity.QzoneCoverPhotoWallActivity");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramCoverCacheData.type != null)
    {
      bool1 = bool2;
      if (paramCoverCacheData.type.equals("PhotoWallCover")) {
        bool1 = true;
      }
    }
    localIntent.putExtra("cover_uin", paramCoverCacheData.uin);
    localIntent.putExtra("photowall_mode", bool1);
    localIntent.putExtra("set_source", 1);
    if (!bool1) {
      localIntent.putExtra("current_cover", paramCoverCacheData);
    }
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    localIntent.putExtra("appid", paramInt1);
    localIntent.setFlags(67108864);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt2);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.album.share.ui.activity.QzoneShareAlbumFeedActivity");
    localIntent.putExtra("QZoneTroopAlbumListActivity.key_state_type_src", "qq");
    localIntent.putExtra("UploadPhoto.key_album_id", paramString1);
    localIntent.putExtra("UploadPhoto.key_album_name", paramString2);
    localIntent.putExtra("UploadPhoto.key_album_cover", paramString3);
    localIntent.putExtra("refer", "share_album_zushou");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_QUN");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.qun.ui.activity.QzoneQunFeedActivity");
    localIntent.putExtra("refer", "1");
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("ken_qun_name", paramString2);
    localIntent.putExtra("newflag", paramBoolean);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void c(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.permissionsetting.ui.activities.QZonePermissionSettingActivity");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void c(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    localIntent.putExtra("qundetail", 1);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void d(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.lbs.ui.activity.QZoneMoodSelectLocation");
    localIntent.putExtra("k_modal", true);
    localIntent.putExtra("k_hide_qzone_icon", true);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
  
  public static void d(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.qun.ui.activity.QZoneTroopAlbumListActivity");
    localIntent.putExtra("QZoneTroopAlbumListActivity.key_state_type_src", 1);
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("ken_qun_name", paramString2);
    localIntent.putExtra("QZoneTroopAlbumListActivity.key_troop_album_is_from_qq", true);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.a, localIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper
 * JD-Core Version:    0.7.0.1
 */