import NS_MOBILE_QQ.RES_ITEM_COVER;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.SurfaceView;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QzoneLiveMainRuntime;
import com.tencent.common.app.QzoneMainRuntime;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SharePlugin;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo.MediaInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.service.qzone.QZoneTitleTabManager;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper.10;
import cooperation.qzone.QZoneHelper.3;
import cooperation.qzone.QZoneHelper.4;
import cooperation.qzone.QZoneHelper.6;
import cooperation.qzone.QZoneHelper.7;
import cooperation.qzone.QZoneHelper.8;
import cooperation.qzone.QZoneHelper.9;
import cooperation.qzone.QzonePictureViewerProxyService;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.QzonePluginProxyService;
import cooperation.qzone.QzonePluginPublishQueueProxyService;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.model.PublishEventTag;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QzoneHardwareRestriction;
import cooperation.qzone.video.QzoneVideoPluginProxyService;
import dov.com.qq.im.QIMCameraCaptureActivity;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONException;
import org.json.JSONObject;

public class avpw
{
  public static final String cMJ = "file" + File.separator + "image";
  public static final String cMK = acfp.m(2131713120);
  private static volatile String cML;
  private static volatile String cMM;
  private static volatile String cMN;
  private static volatile String cMO;
  public static boolean dnL;
  private static boolean dnM;
  private static boolean dnN;
  private static volatile boolean dnO;
  private static volatile boolean dnP;
  private static volatile boolean dnQ;
  private static volatile boolean dnR;
  private static volatile int exQ;
  private static volatile int exR;
  
  public static Intent G()
  {
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.x(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    return localIntent;
  }
  
  public static String Gc()
  {
    return QzoneConfig.getInstance().getConfig("LiveSetting", "LivePluginSOUrl", "https://d3g.qq.com/sngapp/app/update/20171124202406_7451/res1_qzlive_yt_base.so");
  }
  
  public static int PE()
  {
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "UpdateCountIntervalWhenClickFeedTab", 30) * 1000;
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper.UndealCount", 2, "getUpdateCountIntervalWhenClickFeedTab:" + i);
    }
    return i;
  }
  
  public static int PF()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
  }
  
  public static int PG()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "VideoDurationThreshold", 60000);
  }
  
  public static int PH()
  {
    int i = 3;
    if (exR != 0) {
      return exR;
    }
    if (QzoneHardwareRestriction.equalHardwareRestriction(3, 3)) {
      i = 4;
    }
    for (;;)
    {
      exR = i;
      QLog.d("QZoneHelper", 2, "[jinqianli-performance] current mem level is " + QzoneHardwareRestriction.getCurrentMemLevel() + ", current cpu level is " + QzoneHardwareRestriction.getCurrentCpuLevel() + ", play gif parformance level is " + exQ);
      return i;
      if (!QzoneHardwareRestriction.equalHardwareRestriction(2, 2)) {
        if (QzoneHardwareRestriction.equalHardwareRestriction(1, 1)) {
          i = 2;
        } else {
          i = 1;
        }
      }
    }
  }
  
  public static int PI()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "MaxNumInConverstation", 100);
  }
  
  public static void R(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      LocalMultiProcConfig.putInt4Uin("isQzonePublic", i, paramLong);
      return;
    }
  }
  
  public static void U(Context paramContext, Intent paramIntent)
  {
    if (!pcr.a().ex(36))
    {
      pcr.a().ey(36);
      pcr.a().bjw();
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      long l = ((AppRuntime)localObject).getLongAccountUin();
      localObject = paramIntent;
      if (paramIntent == null) {
        localObject = new Intent();
      }
      ((Intent)localObject).addFlags(603979776);
      QzonePluginProxyActivity.x((Intent)localObject, "com.tencent.qcircle.QCirclePublishFeedActivity");
      QzonePluginProxyActivity.a(paramContext, String.valueOf(l), (Intent)localObject, 300001);
    }
  }
  
  public static void X(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.x(localIntent, "com.qzone.personalize.flashnickname.ui.QZoneFlashNickNameSetting");
    QzonePluginProxyActivity.a(paramActivity, paramString, localIntent, 0);
  }
  
  public static void Y(Activity paramActivity, String paramString)
  {
    if (paramActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("gdt_adv_activity_factory_info", paramString);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.preview.QZoneEncourageAdvActivity");
    if (aKX())
    {
      localIntent.setClassName(paramActivity, "com.qzone.preview.QZoneEncourageAdvActivity");
      paramActivity.startActivity(localIntent);
      return;
    }
    QzonePluginProxyActivity.a(paramActivity, BaseApplicationImpl.getApplication().getRuntime().getAccount(), localIntent, -1);
  }
  
  public static void Z(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_id");
    paramString1 = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_title");
    LocalMultiProcConfig.putString(str, paramString3);
    LocalMultiProcConfig.putString(paramString1, paramString4);
  }
  
  public static int a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.a parama, int paramInt)
  {
    parama = parama.a(parama.getActivity());
    int i = paramInt;
    if ((parama instanceof aran)) {
      i = ((aran)parama).switchRequestCode(paramWebViewPlugin, (byte)paramInt);
    }
    return i;
  }
  
  public static Intent a(Context paramContext, Intent paramIntent)
  {
    paramIntent.setClass(paramContext, SplashActivity.class);
    paramIntent.putExtra("fragment_id", 1);
    paramIntent.putExtra("tab_index", MainFragment.bIs);
    paramIntent.putExtra("open_qzone_tab_fragment", true);
    paramIntent.setFlags(335544320);
    return paramIntent;
  }
  
  private static Intent a(Context paramContext, Long paramLong, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_left_tab_title", paramContext.getString(2131717641));
    localIntent.putExtra("key_rihgt_tab_title", paramContext.getString(2131717722));
    localIntent.putExtra("key_album_owner_uin", paramLong);
    localIntent.putExtra("key_selected_tab", paramInt);
    eo(localIntent);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity");
    return localIntent;
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, Serializable paramSerializable, Parcelable paramParcelable, int paramInt2, String paramString5, boolean paramBoolean)
  {
    paramContext = new Intent();
    paramContext.putExtra("autoSaveStorageKey", paramString5);
    paramContext.putExtra("extraRequestCode", paramInt2);
    paramContext.putExtra("showkeyicon", paramInt1);
    if (paramString3 != null) {
      paramContext.putExtra("extraCommentID", paramString3);
    }
    if (paramString4 != null) {
      paramContext.putExtra("extraReplyID", paramString4);
    }
    if (paramSerializable != null) {
      paramContext.putExtra("extraIntentKey", paramSerializable);
    }
    if (paramString2 != null) {
      paramContext.putExtra("feedTextAutoFillKey", paramString2);
    }
    if (paramParcelable != null) {
      paramContext.putExtra("extraIntentKeyParcelable", paramParcelable);
    }
    if (paramString1 != null) {
      paramContext.putExtra("feedTextHintKey", paramString1);
    }
    paramContext.putExtra("extraIsSystemTransparentBar", 1);
    return paramContext;
  }
  
  @NonNull
  private static Intent a(avpw.d paramd, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity");
    localIntent.putExtra("key_album_id", paramBaseBusinessAlbumInfo.mAlbumId);
    localIntent.putExtra("key_photo_sort_type", paramBaseBusinessAlbumInfo.sortType);
    localIntent.putExtra("key_album_name", paramBaseBusinessAlbumInfo.mTitle);
    localIntent.putExtra("key_album_owner_uin", paramBaseBusinessAlbumInfo.mUin);
    localIntent.putExtra("key_is_individual_album", paramBaseBusinessAlbumInfo.doR);
    localIntent.putExtra("key_personal_album_enter_model", 0);
    return localIntent;
  }
  
  private static Intent a(avpw.d paramd, String paramString)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, paramString);
    return localIntent;
  }
  
  @NonNull
  private static Intent a(@NonNull QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    Intent localIntent = new Intent("intent.start.shortcut.guide");
    localIntent.setClassName(paramQQAppInterface.getApp(), ShortcutGuideActivity.class.getName());
    localIntent.putExtra("from", "shortcutFromQZonePhotolist");
    localIntent.putExtra("UploadPhoto.key_album_id", paramString);
    localIntent.putExtra("UploadPhoto.key_album_owner_uin", paramLong);
    localIntent.putExtra("UploadPhoto.key_from_album_shortcut", true);
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.setFlags(337641472);
    return localIntent;
  }
  
  public static Intent a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    try
    {
      localIntent.putExtra("qqid", Long.parseLong(paramString));
      localIntent.putExtra("qzone_entry", paramInt);
      localIntent.putExtra("hc_code", Leba.bHT);
      Leba.bHT = 0;
      eo(localIntent);
      return localIntent;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        QZLog.e("QZoneHelper", "getQZoneUserHomeActivityIntent", paramString);
      }
    }
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
  
  @NonNull
  @RequiresApi(api=26)
  private static ShortcutInfo a(Context paramContext, Bitmap paramBitmap, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramContext, ShortcutGuideActivity.class);
    localIntent.setAction(paramString3);
    localIntent.putExtra("from", "shortcutFromQZonePhotolist");
    localIntent.putExtra("UploadPhoto.key_album_id", paramString1);
    localIntent.putExtra("UploadPhoto.key_album_owner_uin", paramLong);
    localIntent.setFlags(337641472);
    return new ShortcutInfo.Builder(paramContext, paramString1).setIcon(Icon.createWithBitmap(paramBitmap)).setShortLabel(paramString2).setIntent(localIntent).build();
  }
  
  public static SurfaceView a(Context paramContext, String paramString)
  {
    try
    {
      if (aLc())
      {
        arxa.a().showToast(cMK, 1);
        return null;
      }
      try
      {
        Class localClass1 = Class.forName("com.qzone.personalize.floatobject.ui.FloatItemView");
        if (localClass1 == null)
        {
          QLog.e("QZLog", 1, "*createQZoneFloatObjectView load class fail");
          return null;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Class localClass2;
        for (;;)
        {
          ClassLoader localClassLoader = QzonePluginProxyActivity.c(paramContext);
          localClass2 = localClassLoader.loadClass("com.qzone.personalize.floatobject.ui.FloatItemView");
          BasicClassTypeUtil.setClassLoader(true, localClassLoader);
        }
        paramContext = localClass2.getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        localClass2.getMethod("initObjects", new Class[] { String.class, Boolean.TYPE }).invoke(paramContext, new Object[] { paramString, Boolean.valueOf(true) });
        if (paramContext == null) {
          break label154;
        }
      }
      if ((paramContext instanceof SurfaceView))
      {
        paramContext = (SurfaceView)paramContext;
        return paramContext;
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        label154:
        paramContext.printStackTrace();
      }
    }
  }
  
  private static PublishMoodInfo a(String paramString1, String paramString2, int paramInt)
  {
    PublishMoodInfo localPublishMoodInfo = new PublishMoodInfo();
    ArrayList localArrayList = new ArrayList();
    PublishMoodInfo.MediaInfo localMediaInfo = new PublishMoodInfo.MediaInfo();
    localMediaInfo.mPath = paramString2;
    if (paramInt == 4) {}
    for (localMediaInfo.mType = 2;; localMediaInfo.mType = 1)
    {
      localArrayList.add(localMediaInfo);
      localPublishMoodInfo.mText = paramString1;
      localPublishMoodInfo.mMediaInfo = localArrayList;
      return SharePlugin.validMoodInfo(localPublishMoodInfo);
    }
  }
  
  public static IUploadConfig.UploadImageSize a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      Class localClass = Class.forName("com.qzone.misc.network.uploader.QZoneImageSizeStrategy");
      paramContext = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          QLog.e("QZLog", 1, "*QZoneImageSizeStrategy load class fail");
          return null;
        }
        catch (ClassNotFoundException paramContext)
        {
          ClassLoader localClassLoader;
          paramContext.printStackTrace();
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassLoader = QzonePluginProxyActivity.c(paramContext);
        paramContext = localClassLoader.loadClass("com.qzone.misc.network.uploader.QZoneImageSizeStrategy");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      return null;
      paramContext = (IUploadConfig.UploadImageSize)paramContext.getMethod("getTargetSize", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }).invoke(null, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    if (paramContext != null) {}
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt4, Bundle paramBundle, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (paramActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
    localIntent.putExtra("PhotoConst.VIDEO_TYPE", paramInt1);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localIntent.putExtra("PhotoConst.QZONE_ALBUM_VIDEO_ID", str);
    localIntent.putExtra("file_send_path", paramString2);
    localIntent.putExtra("thumbnail_path", paramString3);
    localIntent.putExtra("thumbnail_height", paramInt3);
    localIntent.putExtra("thumbnail_width", paramInt2);
    localIntent.putExtra("need_process", paramBoolean);
    localIntent.putExtra("start_time", paramLong2);
    localIntent.putExtra("end_time", paramLong3);
    localIntent.putExtra("total_duration", paramLong1);
    localIntent.putExtra("file_send_duration", paramLong3 - paramLong2);
    localIntent.putExtra("sv_total_frame_count", paramInt4);
    localIntent.putExtra("PhotoConst.VIDEO_SIZE", paramLong4);
    localIntent.putExtra("COVER_STRING_TYPE", paramString7);
    if (paramBundle != null) {
      localIntent.putExtra("encode_video_params", paramBundle);
    }
    localIntent.putExtra("defaultText", paramString4);
    if (!TextUtils.isEmpty(paramString5)) {
      localIntent.putExtra("refer", paramString5);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      localIntent.putExtra("video_refer", paramString6);
    }
    paramString1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    QzonePluginProxyActivity.x(localIntent, "com.qzone.cover.ui.activity.QzoneVideoCoverPreviewActivity");
    if (aKX())
    {
      localIntent.setClassName(paramActivity, "com.qzone.cover.ui.activity.QzoneVideoCoverPreviewActivity");
      paramActivity.startActivity(localIntent);
      return;
    }
    QzonePluginProxyActivity.a(paramActivity, paramString1, localIntent, -1);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, avpw.d paramd, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    localIntent.putExtra("startup_sceneid", 5);
    localIntent.putExtra("key_file_path", paramString1);
    localIntent.putExtra("key_title", paramString2);
    localIntent.putExtra("key_desc", paramString3);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, int paramInt)
  {
    c(paramActivity, paramd, null, paramInt);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, int paramInt, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.lbsv2.ui.QZoneMoodSelectLocation");
    localIntent.putExtra("k_modal", true);
    localIntent.putExtra("k_hide_qzone_icon", true);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.video.activity.VideoViewActivity");
    localIntent.putExtra("video_type", paramInt);
    localIntent.putExtra("video_source_path", paramString);
    localIntent.putExtra("start_time", paramLong1);
    localIntent.putExtra("end_time", paramLong2);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, 0);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, int paramInt9, int paramInt10, boolean paramBoolean3)
  {
    a(paramActivity, paramd, paramInt1, paramString1, paramString2, paramString3, paramString4, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramString5, paramInt8, paramBundle, paramBoolean1, paramBoolean2, paramInt9, paramInt10, paramBoolean3, null);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, Bundle paramBundle1, boolean paramBoolean1, boolean paramBoolean2, int paramInt9, int paramInt10, boolean paramBoolean3, Bundle paramBundle2)
  {
    if (paramInt6 == 0) {
      paramInt2 = -1;
    }
    for (;;)
    {
      paramString1 = a(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt2, Integer.valueOf(0), null, paramInt1, "", false);
      a(paramString1, paramd);
      paramString1.putExtra("showaticon", paramInt3);
      paramString1.putExtra("showemotionicon", paramInt4);
      paramString1.putExtra("showxuantuicon", paramInt5);
      paramString1.putExtra("showfonticon", 1);
      paramString1.putExtra("show_super_font", false);
      if (paramBoolean3) {}
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        paramString1.putExtra("needtransemoj", paramInt2);
        paramString1.putExtra("sendbtntext", paramString5);
        paramString1.putExtra("inputmax", paramInt8);
        paramString1.putExtra("extra_key_bundle_priv", paramBundle1);
        paramString1.putExtra("video_edit_mode", true);
        paramString1.putExtra("is_topic", paramBoolean1);
        paramString1.putExtra("extraIsTopicSyncQzone", paramBoolean2);
        paramString1.putExtra("extra_key_font_id", paramInt9);
        paramString1.putExtra("extra_key_super_font_id", paramInt10);
        if (paramBundle2 != null) {
          paramString1.putExtras(paramBundle2);
        }
        QzonePluginProxyActivity.x(paramString1, "com.qzone.common.activities.FeedActionPanelActivity");
        QzonePluginProxyActivity.a(paramActivity, paramd.cMP, paramString1, paramInt1, null, true);
        return;
      }
    }
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, int paramInt9, boolean paramBoolean2, String paramString6, boolean paramBoolean3)
  {
    a(paramActivity, paramd, paramInt1, paramString1, paramString2, paramString3, paramString4, paramInt2, paramBoolean1, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramString5, paramInt8, paramInt9, paramBoolean2, paramString6, paramBoolean3, null);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, int paramInt9, boolean paramBoolean2, String paramString6, boolean paramBoolean3, Bundle paramBundle)
  {
    if (paramInt6 == 0) {
      paramInt2 = -1;
    }
    for (;;)
    {
      paramInt7 = paramInt2;
      if (paramInt6 == 1)
      {
        paramInt7 = paramInt2;
        if (paramInt2 == 1) {
          if (paramInt2 != 1) {
            break label322;
          }
        }
      }
      label322:
      for (paramInt7 = 1;; paramInt7 = 0)
      {
        paramString1 = a(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt7, Integer.valueOf(0), null, paramInt1, "", false);
        a(paramString1, paramd);
        paramString1.putExtra("showaticon", paramInt3);
        paramString1.putExtra("showemotionicon", paramInt4);
        paramString1.putExtra("showxuantuicon", paramInt5);
        paramString1.putExtra("needtransemoj", 1);
        paramString1.putExtra("sendbtntext", paramString5);
        paramString1.putExtra("inputmax", paramInt8);
        paramString1.putExtra("is_share", paramBoolean1);
        if (paramInt9 != 0)
        {
          paramString1.putExtra("extraIsQun", true);
          paramString1.putExtra("extraIsQunID", String.valueOf(paramInt9));
        }
        if (!TextUtils.isEmpty(paramString6)) {
          paramString1.putExtra("extraCacheKey", paramString6);
        }
        paramString1.putExtra("is_live_mode", paramBoolean3);
        QzonePluginProxyActivity.x(paramString1, "com.qzone.common.activities.FeedActionPanelActivity");
        if (paramBundle != null)
        {
          paramString1.putExtra("disableAutoClose", paramBundle.getBoolean("disableAutoClose"));
          paramString1.putExtra("catchHeightChange", paramBundle.getBoolean("catchHeightChange"));
          paramString1.putExtra("catchClosePanel", paramBundle.getBoolean("catchClosePanel"));
          paramString1.putExtra("input_text_allow_empty", paramBundle.getBoolean("input_text_allow_empty"));
          paramString1.putExtra("isFromDIY", paramBundle.getBoolean("isFromDIY"));
          paramString1.putExtra("extra_key_font_id", paramBundle.getInt("extra_key_font_id", -1));
        }
        paramString1.putExtra("extra_key_from_scene", 4);
        QzonePluginProxyActivity.a(paramActivity, paramd.cMP, paramString1, paramInt1, null, paramBoolean2);
        return;
      }
    }
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity");
    localIntent.putExtra("qqid", paramLong);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, Intent paramIntent)
  {
    a(paramActivity, paramd, paramIntent, -1);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, Intent paramIntent, int paramInt)
  {
    a(paramIntent, paramd);
    if (paramInt >= 0) {
      paramIntent.putExtra("bNeedCallBack", true);
    }
    for (;;)
    {
      QzonePluginProxyActivity.x(paramIntent, "com.qzone.misc.web.QZoneTranslucentActivity");
      QzonePluginProxyActivity.a(paramActivity, paramd.cMP, paramIntent, paramInt);
      return;
      paramIntent.putExtra("bNeedCallBack", false);
    }
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, paramIntent, paramInt, paramOnDismissListener, true);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    a(paramIntent, paramd);
    if (paramInt >= 0) {
      paramIntent.putExtra("bNeedCallBack", true);
    }
    for (;;)
    {
      QzonePluginProxyActivity.x(paramIntent, "com.qzone.misc.web.QZoneTranslucentActivity");
      QzonePluginProxyActivity.a(paramActivity, paramd.cMP, paramIntent, paramInt, null, paramBoolean);
      return;
      paramIntent.putExtra("bNeedCallBack", false);
    }
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = a(paramd, "com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity");
    localIntent.putExtras(paramBundle);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo, int paramInt)
  {
    paramBaseBusinessAlbumInfo = a(paramd, paramBaseBusinessAlbumInfo);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, paramBaseBusinessAlbumInfo, paramInt);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo, int paramInt, String paramString)
  {
    paramBaseBusinessAlbumInfo = a(paramd, paramBaseBusinessAlbumInfo);
    paramBaseBusinessAlbumInfo.putExtra("mqqflag", 1);
    paramBaseBusinessAlbumInfo.putExtra("cell_operation.qq_url", paramString);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, paramBaseBusinessAlbumInfo, paramInt);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, CoverCacheData paramCoverCacheData, String paramString, int paramInt)
  {
    paramd = avpw.a.f(paramd.cMP, paramString, "usersummary", true);
    paramCoverCacheData = new Intent(paramActivity, QQBrowserActivity.class);
    en(paramCoverCacheData);
    paramCoverCacheData.putExtra("url", paramd);
    if (arap.sPluginNameSpaceHashMap.containsKey("Qzone")) {
      paramCoverCacheData.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramCoverCacheData.setData(Uri.parse(paramd));
    ay(paramCoverCacheData);
    paramActivity.startActivityForResult(paramCoverCacheData, paramInt);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, Long paramLong, int paramInt1, int paramInt2, int paramInt3, ahyh paramahyh)
  {
    paramLong = a(paramActivity, paramLong, paramInt1);
    a(paramLong, paramd);
    r(paramLong, paramInt2);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, paramLong, paramInt3, paramahyh);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, Long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    a(paramActivity, paramd, paramLong, paramInt1, paramBoolean, paramInt2, 5);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, Long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    LocalMultiProcConfig.putBool("key_photo_guide_is_red", paramBoolean);
    paramLong = a(paramActivity, paramLong, paramInt1);
    a(paramLong, paramd);
    paramLong.putExtra("startup_sceneid", 3);
    paramLong.putExtra("key_need_show_album_recent_photo", true);
    paramLong.putExtra("refer", "mqqSetting");
    paramLong.putExtra("key_redTouch", paramBoolean);
    QZoneLoginReportHelper.handleLoginToMyAlbum(paramLong, paramInt3);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, paramLong, paramInt2);
  }
  
  @Deprecated
  public static void a(Activity paramActivity, avpw.d paramd, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent();
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.cover.ui.activity.QZoneBrowserActivity");
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.setData(Uri.parse(paramString1));
    en(localIntent);
    if (TextUtils.isEmpty(paramString2)) {}
    for (paramString1 = null;; paramString1 = paramString2.getBytes())
    {
      if (paramString1 != null) {
        localIntent.putExtra("post_data", paramString1);
      }
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
      return;
    }
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Intent localIntent = new Intent();
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("blog_url", paramString2);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("need_select_video", true);
    localIntent.putExtra("file_send_path", paramString1);
    localIntent.putExtra("PhotoConst.VIDEO_SIZE", paramLong);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", paramInt2);
    if (paramActivity.getIntent() != null) {
      localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", paramActivity.getIntent().getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("refer", paramString2);
    }
    localIntent.putExtra("video_refer", paramString3);
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.video.activity.TrimVideoActivity");
    if (aKX())
    {
      localIntent.setClassName(paramActivity, "com.qzone.video.activity.TrimVideoActivity");
      paramActivity.startActivity(localIntent);
      return;
    }
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt1);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_OPEN_VIP");
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", paramString1);
    localIntent.putExtra("uin", paramLong);
    if (!TextUtils.isEmpty(paramString2))
    {
      localIntent.putExtra("direct_go", false);
      localIntent.putExtra("key_open_qzone_vip_dialog_title", paramString2);
    }
    for (;;)
    {
      QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
      return;
      localIntent.putExtra("direct_go", true);
    }
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, String paramString1, long paramLong, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_OPEN_VIP");
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", paramString1);
    localIntent.putExtra("provide_uin", paramLong);
    localIntent.putExtra("success_tips", paramString3);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localIntent.putExtra("direct_go", paramBoolean);
      localIntent.putExtra("need_loading_dialog", true);
      localIntent.putExtra("key_open_qzone_vip_dialog_title", paramString2);
      QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
      return;
    }
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, String paramString1, long paramLong, String paramString2, String paramString3, int paramInt)
  {
    Object localObject;
    if (paramActivity == null) {
      localObject = BaseApplication.getContext();
    }
    for (;;)
    {
      localObject = new Intent((Context)localObject, SendHbActivity.class);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("skey", paramString1);
        localJSONObject.put("skey_type", 2);
        localJSONObject.put("recv_uin", paramLong);
        localJSONObject.put("recv_name", paramString2);
        localJSONObject.put("bus_type", 1);
        localJSONObject.put("channel", 128);
        localJSONObject.put("feedsid", paramString3);
        ((Intent)localObject).putExtra("userId", paramd.cMP);
        ((Intent)localObject).putExtra("userName", paramd.nickname);
        ((Intent)localObject).putExtra("app_info", "appid#0|bargainor_id#1000030201|channel#qzonefeeds");
        ((Intent)localObject).putExtra("come_from", 2);
        ((Intent)localObject).putExtra("extra_data", localJSONObject.toString());
        ((Intent)localObject).putExtra("startup_sceneid", 4);
        ((Intent)localObject).putExtra("qzone.sourceFrom", true);
        ((Intent)localObject).setFlags(536870912);
        if (paramActivity == null)
        {
          BaseApplication.getContext().startActivity((Intent)localObject);
          return;
          localObject = paramActivity;
        }
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
        }
        paramActivity.startActivityForResult((Intent)localObject, paramInt);
      }
    }
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("startup_sceneid", 4);
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    if (QZoneLoginReportHelper.needAddLoginFromAIOFeedShare(localIntent, paramString2)) {
      QZoneLoginReportHelper.setLoginFromAIOFeedShare(localIntent);
    }
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("jumpToDetailFromQQWhat", 1);
    localIntent.putExtra("startup_sceneid", 4);
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    localIntent.putExtra("appid", paramInt1);
    localIntent.setFlags(67108864);
    if (QZoneLoginReportHelper.needAddLoginFromAIOFeedCard(localIntent, paramString2)) {
      QZoneLoginReportHelper.setLoginFromAIOFeedCard(localIntent);
    }
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    paramString1 = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunAlbum", "https://h5.qzone.qq.com/groupphoto/inqq/album/{QUN_ID}?_wv=3&_proxy=1").replace("{QUN_ID}", paramString1);
    paramd = paramString1;
    if (!TextUtils.isEmpty(paramString3)) {
      paramd = paramString1 + "&source=" + paramString3;
    }
    paramString1 = new Intent(paramActivity, QQBrowserActivity.class);
    en(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "forwardToQunAlbumList:" + paramd);
    }
    paramString1.putExtra("url", paramd);
    if (arap.sPluginNameSpaceHashMap.containsKey("Qzone")) {
      paramString1.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString1.setData(Uri.parse(paramd));
    ay(paramString1);
    paramActivity.startActivityForResult(paramString1, paramInt2);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_PUBLISH_QR_CODE");
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    localIntent.putExtra("startup_sceneid", 5);
    localIntent.putExtra("key_file_path", paramString1);
    localIntent.putExtra("key_title", paramString2);
    localIntent.putExtra("key_desc", paramString3);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, Bundle paramBundle)
  {
    a(paramActivity, paramd, paramString1, paramString2, paramString3, paramString4, paramInt, paramBundle, true, false);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN");
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    localIntent.putExtra("startup_sceneid", 6);
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("key_qun_code", paramString2);
    localIntent.putExtra("key_thumb_file_path", paramString3);
    localIntent.putExtra("key_big_photo_uuid", paramString4);
    localIntent.putExtra("key_msg_time", paramLong);
    localIntent.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, String paramString1, String paramString2, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Long> paramArrayList, int paramInt, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN");
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    localIntent.putExtra("startup_sceneid", 6);
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("key_qun_code", paramString2);
    localIntent.putExtra("key_thumb_file_paths", paramArrayList1);
    localIntent.putExtra("key_big_photo_uuids", paramArrayList2);
    localIntent.putExtra("key_msg_times", paramArrayList);
    localIntent.setFlags(402653184);
    localIntent.putExtra("refer", "mqqChat");
    if (paramString3 != null) {
      localIntent.putExtra("UploadPhoto.key_album_id", paramString3);
    }
    if (paramString4 != null) {
      localIntent.putExtra("UploadPhoto.key_album_name", paramString4);
    }
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    paramd = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunFeed", "https://h5.qzone.qq.com/groupphoto/inqq/recent/{QUN_ID}/groupphoto?_wv=3&_proxy=1").replace("{QUN_ID}", paramString1);
    paramString1 = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
    paramString1.putExtra("url", paramd);
    paramString1.putExtra("fromQZone", true);
    paramString1.putExtra("injectrecommend", true);
    if (arap.sPluginNameSpaceHashMap.containsKey("Qzone")) {
      paramString1.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString1.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717944));
    paramString1.setData(Uri.parse(paramd));
    if (QZoneLoginReportHelper.needAddLoginFromQunAlbum(paramString1, paramInt)) {
      QZoneLoginReportHelper.reportLoginFromQunAlbum();
    }
    paramActivity.startActivityForResult(paramString1, paramInt);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong1, long paramLong2, int paramInt2)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_QUOTE_FROM_AIO");
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    localIntent.putExtra("startup_sceneid", 6);
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
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, avpw.d paramd, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Long> paramArrayList3, ArrayList<Long> paramArrayList4, int paramInt2)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_QUOTE_FROM_AIO");
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    localIntent.putExtra("startup_sceneid", 6);
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
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramActivity, a(paramIntent.getStringExtra("summary"), paramIntent.getStringExtra("filePath"), paramIntent.getIntExtra("reqType", 1)), paramIntent, paramInt, paramBoolean);
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, String paramString3, String paramString4, int paramInt3, int paramInt4)
  {
    avpw.d locald = avpw.d.a();
    locald.cMP = paramString1;
    paramString1 = a(null, paramInt1, String.valueOf(paramLong), paramString2, paramString3, paramString4, "mqqChat");
    paramString1.putExtra("photoactivity_key_type", paramInt2);
    paramString1.putExtra("up_way", paramInt4);
    paramString1.setFlags(67108864);
    a(paramString1, locald);
    QzonePluginProxyActivity.x(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    QzonePluginProxyActivity.a(paramActivity, locald.cMP, paramString1, paramInt3);
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, String paramString3, String paramString4, ArrayList<String> paramArrayList, int paramInt3, int paramInt4, int paramInt5)
  {
    avpw.d locald = avpw.d.a();
    locald.cMP = paramString1;
    paramString1 = a(null, paramInt1, String.valueOf(paramLong), paramString2, paramString3, paramString4, "mqqChat");
    paramString1.putStringArrayListExtra("images", paramArrayList);
    paramString1.putExtra("photoactivity_key_type", paramInt2);
    paramString1.putExtra("key_quality", paramInt5);
    paramString1.putExtra("up_way", paramInt4);
    paramString1.setFlags(67108864);
    a(paramString1, locald);
    QzonePluginProxyActivity.x(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    QzonePluginProxyActivity.a(paramActivity, locald.cMP, paramString1, paramInt3);
    if (1 == paramInt1) {
      LpReportInfo_pf00064.allReport(40, 3, 4);
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, long paramLong, String paramString2)
  {
    avpw.d locald = avpw.d.a();
    locald.cMP = paramString2;
    paramString2 = new BaseBusinessAlbumInfo();
    paramString2.mAlbumId = paramString1;
    paramString2.mUin = paramLong;
    paramString2.mAlbumType = 0;
    paramString2.doR = true;
    b(paramActivity, locald, paramString2, -1);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    QzonePluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, Intent paramIntent, String paramString2, int paramInt)
  {
    QLog.d("qzone_launch", 4, "forwardToFriendFeed click");
    paramIntent.putExtra("startup_sceneid", 1);
    if (paramString2 != null) {
      paramIntent.putExtra("key_push_trans_channel", paramString2);
    }
    QZoneTitleTabManager.dJ(paramIntent);
    if (!a(paramActivity, paramIntent, true)) {
      QzonePluginProxyActivity.a(paramActivity, paramString1, paramIntent, paramInt);
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, ArrayList<String> paramArrayList, ArrayList<ResultRecord> paramArrayList1, PublishEventTag paramPublishEventTag, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("qzone_uin", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("summary", paramString2);
    }
    paramString2 = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        String str = (String)paramArrayList.next();
        if (!TextUtils.isEmpty(str)) {
          paramString2.add(str);
        }
      } while (paramString2.size() < 9);
    }
    if (paramString2.size() > 0) {
      localIntent.putStringArrayListExtra("images", paramString2);
    }
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
      localIntent.putParcelableArrayListExtra("at_friend", paramArrayList1);
    }
    if (paramPublishEventTag != null) {
      localIntent.putExtra("event_tag", paramPublishEventTag);
    }
    QzonePluginProxyActivity.x(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    QzonePluginProxyActivity.a(paramActivity, paramString1, localIntent, paramInt);
  }
  
  public static void a(Context paramContext, avpw.d paramd)
  {
    paramd = QzoneConfig.getInstance().getConfig("H5Url", "QzonePictureSettingPage", "https://h5.qzone.qq.com/image/setting/imageSetting?_wv=3&_proxy=1&uin={uin}").replace("{uin}", String.valueOf(paramd.cMP)).replace("{host_uin}", paramd.cMP).replace("{UIN}", String.valueOf(paramd.cMP)).replace("{HOST_UIN}", paramd.cMP);
    if (!aurr.getArguments(paramd).containsKey("_wv")) {
      aurr.addParameter(paramd, "_wv", "5");
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "jump qzone setting URL:" + paramd);
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    en(localIntent);
    localIntent.putExtra("url", paramd);
    localIntent.putExtra("isFromQQ", true);
    localIntent.putExtra("fromQZone", false);
    localIntent.putExtra("injectrecommend", true);
    if (arap.sPluginNameSpaceHashMap.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717944));
    localIntent.setData(Uri.parse(paramd));
    localIntent.addFlags(268435456);
    ay(localIntent);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, avpw.d paramd, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramContext, paramd, paramString, paramInt1, paramInt2, paramInt3, null, null, false);
  }
  
  public static void a(Context paramContext, avpw.d paramd, String paramString, int paramInt1, int paramInt2, int paramInt3, ahyh paramahyh, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Intent localIntent = a(paramString, paramInt3);
    if (paramBoolean) {
      localIntent.addFlags(268435456);
    }
    int i;
    if ((aKY()) && (a(localIntent, paramArrayOfByte)))
    {
      i = 1;
      if (i == 0) {
        break label107;
      }
      QzonePluginProxyActivity.x(localIntent, "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity");
    }
    for (;;)
    {
      if (QZoneLoginReportHelper.needAddLoginFromFriendProfile(localIntent, paramString, paramInt3)) {
        QZoneLoginReportHelper.setLoginFromFriendProfile(localIntent);
      }
      localIntent.putExtra("startup_sceneid", 2);
      r(localIntent, paramInt1);
      QzonePluginProxyActivity.a(paramContext, paramd.cMP, localIntent, paramInt2, paramahyh);
      return;
      i = 0;
      break;
      label107:
      a(localIntent, paramd);
      QzonePluginProxyActivity.x(localIntent, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    }
  }
  
  public static void a(Context paramContext, avpw.d paramd, String paramString1, int paramInt1, int paramInt2, ahyh paramahyh, String paramString2, boolean paramBoolean)
  {
    paramString1 = a(paramString1, paramInt2);
    if (paramBoolean) {
      paramString1.addFlags(268435456);
    }
    paramString1.putExtra("famous_space_webview_url", paramString2);
    QzonePluginProxyActivity.x(paramString1, "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity");
    QzonePluginProxyActivity.a(paramContext, paramd.cMP, paramString1, paramInt1, paramahyh);
  }
  
  public static void a(Context paramContext, avpw.d paramd, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramd);
    localIntent.putExtra("startup_sceneid", 4);
    if (paramBoolean2) {
      localIntent.addFlags(268435456);
    }
    QzonePluginProxyActivity.x(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    try
    {
      long l = Long.parseLong(paramString1);
      int i = Integer.valueOf(paramString2).intValue();
      if (paramBundle != null) {}
      for (paramString1 = paramBundle;; paramString1 = new Bundle())
      {
        paramString1.putLong("targetuin", l);
        paramString1.putInt("appid", i);
        paramString1.putString("subid", paramString4);
        paramString1.putString("cellid", paramString3);
        paramString1.putBoolean("messagelist", true);
        if (paramBundle != null) {
          paramString1.putAll(paramBundle);
        }
        localIntent.putExtras(paramString1);
        QzonePluginProxyActivity.a(paramContext, paramd.cMP, localIntent, paramInt, null, paramBoolean1);
        return;
      }
      return;
    }
    catch (Exception paramContext)
    {
      QLog.w("QZoneHelper", 2, "forwardToDetail error", paramContext);
    }
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    a(paramContext, paramString1, paramInt, paramBundle, paramString2, true, true);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, Bundle paramBundle, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      arxa.a().showToast(2131691998);
      QLog.w("QZoneHelper", 1, "browse url fail:" + paramString1);
    }
    Intent localIntent;
    do
    {
      return;
      if (TextUtils.isEmpty(paramString2)) {}
      for (paramString2 = null;; paramString2 = paramString2.getBytes())
      {
        localIntent = new Intent(BaseApplicationImpl.getContext(), QQTranslucentBrowserActivity.class);
        localIntent.putExtra("post_data", paramString2);
        localIntent.putExtra("url", paramString1);
        localIntent.putExtra("fromQZone", true);
        localIntent.putExtra("injectrecommend", true);
        localIntent.putExtra("isTransparentTitle", true);
        localIntent.putExtra("hide_left_button", paramBoolean1);
        localIntent.setData(Uri.parse(paramString1));
        if (!paramBoolean2) {
          localIntent.putExtra("finish_animation_none", true);
        }
        if (paramBundle != null) {
          localIntent.putExtras(paramBundle);
        }
        if (!(paramContext instanceof Activity)) {
          break;
        }
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
        return;
      }
    } while (localIntent == null);
    localIntent.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramContext, QzoneVideoPluginProxyService.class);
    localIntent.putExtra("qzone_uin", paramString);
    QzoneVideoPluginProxyService.a(paramContext, paramString, localIntent, paramServiceConnection);
  }
  
  public static void a(Intent paramIntent, avpw.d paramd)
  {
    paramIntent.putExtra("qzone_uin", paramd.cMP);
    paramIntent.putExtra("nickname", paramd.nickname);
  }
  
  private static void a(Intent paramIntent, @NonNull QQAppInterface paramQQAppInterface, String paramString, Bitmap paramBitmap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString);
    localIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", paramBitmap);
    localIntent.putExtra("duplicate", false);
    localIntent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
    paramQQAppInterface.getApp().sendOrderedBroadcast(localIntent, null);
  }
  
  private static void a(Intent paramIntent, @NonNull QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Bitmap paramBitmap)
    throws InterruptedException
  {
    if (!aqlr.hasShortCut(paramQQAppInterface.getApp(), new String[] { paramString1 })) {
      return;
    }
    a(paramIntent, paramQQAppInterface, paramString2, paramBitmap);
    Thread.sleep(1000L);
    aqlr.a(paramQQAppInterface, paramIntent, paramString2, paramBitmap);
    Thread.sleep(1000L);
  }
  
  private static void a(Bitmap paramBitmap, @NonNull QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2)
    throws InterruptedException
  {
    if (paramBitmap == null) {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneHelper", 2, "createAlbumShortcutWithBmp end, iconBmp is null");
      }
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT < 26)
      {
        if (aqlr.hasShortCut(paramQQAppInterface.getApp(), new String[] { paramString1 }))
        {
          arxa.a().showToast(2131690300);
          return;
        }
        aqlr.a(paramQQAppInterface, a(paramQQAppInterface, paramString1, paramLong), paramString2, paramBitmap);
        Thread.sleep(1000L);
        if (aqml.hasShortCut(paramQQAppInterface.getApplication(), new String[] { paramString1 }))
        {
          arxa.a().showToast(2131692341);
          return;
        }
        eR(paramQQAppInterface);
        return;
      }
      BaseApplication localBaseApplication = paramQQAppInterface.getApp();
      ShortcutManager localShortcutManager = (ShortcutManager)localBaseApplication.getSystemService("shortcut");
      if (isShortcutCreated_O(paramString1, localShortcutManager))
      {
        arxa.a().showToast(2131690300);
        return;
      }
      if (localShortcutManager.isRequestPinShortcutSupported())
      {
        paramBitmap = a(localBaseApplication, paramBitmap, paramString1, paramLong, paramString2, "android.intent.action.VIEW");
        paramString2 = new Intent("com.qzone.album.CreateAlbumShortcutSucceedReceiver");
        paramString2.putExtra("UploadPhoto.key_album_id", paramString1);
      }
      for (boolean bool = localShortcutManager.requestPinShortcut(paramBitmap, PendingIntent.getBroadcast(localBaseApplication, 0, paramString2, 134217728).getIntentSender()); !bool; bool = false)
      {
        eR(paramQQAppInterface);
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ahyh paramahyh)
  {
    ThreadManager.post(new QZoneHelper.8(paramQQAppInterface, paramahyh), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, avpw.d paramd, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, boolean paramBoolean3, boolean paramBoolean4, String paramString3, boolean paramBoolean5, String paramString4, String paramString5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, String paramString6, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, int paramInt2, boolean paramBoolean13, Bundle paramBundle)
  {
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("edit_video_type", 10001);
    LocalMultiProcConfig.putBool("support_trim", paramBoolean1);
    paramQQAppInterface.putInt("from_type", 1);
    paramQQAppInterface.putBoolean("enable_front", true);
    paramQQAppInterface.putBoolean("enable_edit_video", paramBoolean4);
    paramQQAppInterface.putBoolean("enable_local_video", true);
    paramQQAppInterface.putBoolean("is_qzone_vip", paramBoolean3);
    paramQQAppInterface.putString("set_user_callback", "cooperation.qzone.video.VideoComponentCallback");
    paramQQAppInterface.putBoolean("flow_camera_video_mode", true);
    paramQQAppInterface.putBoolean("flow_camera_capture_mode", paramBoolean2);
    paramQQAppInterface.putString("short_video_refer", paramString2);
    paramQQAppInterface.putString("callback", paramString4);
    paramQQAppInterface.putString("dongxiao_id", paramString5);
    paramQQAppInterface.putString("topic_id", paramString3);
    paramQQAppInterface.putBoolean("enter_ptu", paramBoolean5);
    paramQQAppInterface.putBoolean("enable_input_text", paramBoolean6);
    paramQQAppInterface.putBoolean("enable_priv_list", paramBoolean7);
    paramQQAppInterface.putBoolean("enable_sync_qzone", paramBoolean8);
    paramQQAppInterface.putBoolean("enable_origin_video", paramBoolean9);
    paramQQAppInterface.putString("confirm_text", paramString6);
    paramQQAppInterface.putBoolean("enable_edit_button", paramBoolean10);
    paramQQAppInterface.putBoolean("enable_local_button", paramBoolean11);
    paramQQAppInterface.putBoolean("is_glance_video", paramBoolean12);
    if (paramBoolean12)
    {
      paramQQAppInterface.putInt("video_min_frame_count", 5);
      paramQQAppInterface.putLong("activity_start_time", SystemClock.elapsedRealtime());
      if (paramBoolean2)
      {
        paramd = wmj.hp(acbn.SDCARD_IMG_CAMERA);
        paramQQAppInterface.putBoolean("support_photo_merge", true);
        paramQQAppInterface.putString("qcamera_photo_filepath", paramd);
        paramQQAppInterface.putInt("extra.busi_type", 3);
        paramQQAppInterface.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        paramQQAppInterface.putBoolean("DirectBackToQzone", true);
        paramQQAppInterface.putString("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
        paramQQAppInterface.putString("pic_confirm_text", acfp.m(2131713124));
      }
      paramQQAppInterface.putInt("entry_source", paramInt2);
      paramQQAppInterface.putBoolean("go_publish_activity", paramBoolean13);
      if (paramBundle != null) {
        paramQQAppInterface.putAll(paramBundle);
      }
      if (!alwy.auJ()) {
        break label387;
      }
      QIMCameraCaptureActivity.g(paramActivity, paramQQAppInterface);
    }
    for (;;)
    {
      paramActivity.overridePendingTransition(2130772374, 2130772370);
      return;
      if (QzoneHardwareRestriction.meetHardwareRestriction(0, 1)) {
        break;
      }
      paramQQAppInterface.putInt("video_min_frame_count", 8);
      break;
      label387:
      aqha.a(paramActivity, 230).setMessage(acfp.m(2131713122)).setPositiveButton(2131721079, new avpz()).show();
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, PublishMoodInfo paramPublishMoodInfo, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramPublishMoodInfo == null))
    {
      QLog.i("QZoneHelper", 2, "handle moodInfo is null");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("summary", paramPublishMoodInfo.mText);
    localBundle.putBoolean("key_need_save_draft", false);
    localBundle.putString("shareSource", paramIntent.getStringExtra("source"));
    localBundle.putStringArrayList("images", paramPublishMoodInfo.mAllImageAndVideo);
    localBundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", paramPublishMoodInfo.mMediaInfoHashMap);
    localBundle.putString("qq_camera_top_title", paramIntent.getStringExtra("qq_camera_top_title"));
    localBundle.putString("qq_camera_scheme", paramIntent.getStringExtra("qq_camera_scheme"));
    if (paramBoolean) {
      localBundle.putInt("key_max_photo_count", 1);
    }
    avqq.a(paramQQAppInterface, paramActivity, localBundle, null, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ServiceConnection paramServiceConnection)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.getApp(), QzonePluginPublishQueueProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.setAction("com.qzone.intent.action.LAUNCH_PUBLISH_QUEUE");
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = QzonePluginProxyActivity.Gg();
    locald.mPluginName = "QQ空间";
    locald.mUin = paramQQAppInterface.getCurrentAccountUin();
    locald.cKu = "com.qzone.publish.business.publishqueue.PublishQueueService";
    locald.mIntent = localIntent;
    locald.mServiceConnection = paramServiceConnection;
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, "start and bind QzonePublishQueueService");
    }
    avfw.c(paramQQAppInterface.getApp(), locald);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ahyh paramahyh, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (aLa())) {
      return;
    }
    if ("MainAssistObserver".equals(paramString))
    {
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 1, 0, "", "", "", "");
      anpf.a().cS("actQZLoadHitRateRed", true);
    }
    for (;;)
    {
      ThreadManager.postImmediately(new QZoneHelper.7(paramQQAppInterface), null, false);
      try
      {
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("CrashControl_com.tencent.mobileqq:qzone", 4);
        if ((localObject != null) && (!((SharedPreferences)localObject).getBoolean("allowpreload", true)))
        {
          long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
          int i = ((SharedPreferences)localObject).getInt("controlwindow", 86400);
          long l2 = System.currentTimeMillis();
          if ((l1 > 0L) && (i > 0) && (l2 > l1) && (l2 - l1 > i * 1000)) {
            ((SharedPreferences)localObject).edit().putBoolean("allowpreload", true).commit();
          }
        }
        else
        {
          label199:
          QLog.d("qzone_launch", 1, "preloadQzone from: " + paramString);
          localObject = new Intent(paramQQAppInterface.getApp(), QzonePluginProxyService.class);
        }
      }
      catch (Exception localException)
      {
        try
        {
          Object localObject;
          ((Intent)localObject).putExtra("useSkinEngine", 1);
          if ("FriendProfileCardActivity".equals(paramString)) {
            ((Intent)localObject).setAction("com.qzone.intent.action.PRELOAD_USER_HOME");
          }
          for (;;)
          {
            ((Intent)localObject).putExtra("cpuNum", aqgz.getCpuNumber());
            ((Intent)localObject).putExtra("key_can_set_layoutInfalter_factory", aLm());
            ((Intent)localObject).putExtra("key_is_keep_alive", paramBoolean);
            if (!anmo.cIy) {
              break label498;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Perf", 2, "disable preload qzone process");
            }
            anmo.amm = System.currentTimeMillis();
            return;
            if ("Leba".equals(paramString))
            {
              anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 1, 0, "", "", "", "");
              anpf.a().cS("actQZLoadHitRateLeba", true);
              break;
            }
            if (!"FriendProfileCardActivity".equals(paramString)) {
              break;
            }
            anpf.a().cS("actQZLoadHitRateProfile", true);
            break;
            QLog.d("QZoneHelper", 1, "preloadQzone is not allowed as crash frequently.");
            anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "actNoPreloadQzone", true, 0L, 0L, null, "");
            return;
            localException = localException;
            localException.printStackTrace();
            break label199;
            if (!"QCircle".equals(paramString)) {
              break label486;
            }
            localException.setAction("com.qzone.intent.action.PRELOAD_QCIRCLE_PUBLISH");
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            continue;
            label486:
            localException.setAction("com.qzone.intent.action.PRELOAD_FRIEND_FEEDS");
          }
          label498:
          paramString = new avfw.d(0);
          paramString.mPluginID = QzonePluginProxyActivity.Gg();
          paramString.mPluginName = "QQ空间";
          paramString.mUin = paramQQAppInterface.getCurrentAccountUin();
          paramString.a = paramahyh;
          paramString.cKu = "com.qzone.preview.service.PictureService";
          paramString.mIntent = localException;
          paramString.aqY = true;
          avfw.c(paramQQAppInterface.getApp(), paramString);
        }
      }
    }
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Bitmap paramBitmap, long paramLong)
  {
    ThreadManager.post(new QZoneHelper.3(paramBitmap, paramQQAppInterface, paramString1, paramLong, paramString2), 2, null, true);
  }
  
  public static void a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.a parama, Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.x(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    localIntent.putExtra("startup_sceneid", 6);
    paramString2 = parseUrlParams(paramString2);
    localIntent.putExtra("IsBack", true);
    if (paramString2.containsKey("albumid")) {
      localIntent.putExtra("UploadPhoto.key_album_id", paramString2.getString("albumid"));
    }
    if (paramString2.containsKey("albumtitle")) {
      localIntent.putExtra("UploadPhoto.key_album_name", paramString2.getString("albumtitle"));
    }
    localIntent.putExtra("photoactivity_key_type", 1);
    localIntent.putExtras(paramString2);
    QzonePluginProxyActivity.a(paramActivity, paramString1, localIntent, a(paramWebViewPlugin, parama, 1));
  }
  
  public static void a(BaseApplication paramBaseApplication, String paramString1, String paramString2)
  {
    if ((paramBaseApplication == null) || (aLa())) {
      return;
    }
    QLog.d("qzone_launch", 1, "preloadQzone from: " + paramString2);
    Intent localIntent = new Intent(paramBaseApplication, QzonePluginProxyService.class);
    try
    {
      localIntent.putExtra("useSkinEngine", 1);
      if ("album_select".equals(paramString2)) {
        localIntent.setAction("com.qzone.intent.action.PRELOAD_NOTHING");
      }
      for (;;)
      {
        localIntent.putExtra("cpuNum", aqgz.getCpuNumber());
        localIntent.putExtra("key_can_set_layoutInfalter_factory", aLm());
        if (!anmo.cIy) {
          break label168;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Perf", 2, "disable preload qzone process");
        }
        anmo.amm = System.currentTimeMillis();
        return;
        if (!"FriendProfileCardActivity".equals(paramString2)) {
          break;
        }
        localIntent.setAction("com.qzone.intent.action.PRELOAD_USER_HOME");
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
        continue;
        localIntent.setAction("com.qzone.intent.action.PRELOAD_FRIEND_FEEDS");
      }
      label168:
      paramString2 = new avfw.d(0);
      paramString2.mPluginID = QzonePluginProxyActivity.Gg();
      paramString2.mPluginName = "QQ空间";
      paramString2.mUin = paramString1;
      paramString2.a = null;
      paramString2.cKu = "com.qzone.preview.service.PictureService";
      paramString2.mIntent = localIntent;
      avfw.c(paramBaseApplication, paramString2);
    }
  }
  
  public static void a(String paramString1, ArrayList<String> paramArrayList1, int paramInt1, LbsDataV2.PoiInfo paramPoiInfo, String paramString2, String paramString3, ArrayList<String> paramArrayList2, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, String paramString4, int paramInt2)
  {
    paramString2 = new Bundle();
    paramString2.putString("param.content", paramString1);
    paramString2.putStringArrayList("param.images", paramArrayList1);
    paramString2.putSerializable("param.extendInfo", paramHashMap2);
    paramString2.putInt("param.priv", Integer.parseInt(paramString3));
    paramString2.putStringArrayList("param.privList", paramArrayList2);
    paramString2.putParcelable("param.poiInfo", paramPoiInfo);
    paramString2.putInt("param.syncWeibo", paramInt1);
    paramString2.putSerializable("param.storeExtendInfo", paramHashMap1);
    paramString2.putString("param.source", paramString4);
    paramString2.putInt("param.subtype", paramInt2);
    avzf.a().a("cmd.publishMixMood", paramString2, false);
  }
  
  public static void a(String paramString1, ArrayList<String> paramArrayList1, int paramInt1, ArrayList<String> paramArrayList2, int paramInt2, int paramInt3, String paramString2, boolean paramBoolean, int paramInt4, String paramString3)
  {
    a(paramString1, paramArrayList1, paramInt1, paramArrayList2, paramInt2, paramInt3, paramString2, paramBoolean, false, paramInt4, paramString3);
  }
  
  public static void a(String paramString1, ArrayList<String> paramArrayList1, int paramInt1, ArrayList<String> paramArrayList2, int paramInt2, int paramInt3, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.content", paramString1);
    localBundle.putStringArrayList("param.images", paramArrayList1);
    localBundle.putInt("param.priv", paramInt1);
    localBundle.putStringArrayList("param.privList", paramArrayList2);
    localBundle.putInt("extra_key_font_id", paramInt2);
    localBundle.putInt("extra_key_font_format_type", paramInt3);
    localBundle.putString("extra_key_font_url", paramString2);
    localBundle.putInt("extra_key_super_font_id", paramInt4);
    localBundle.putString("extra_key_super_font_info", paramString3);
    localBundle.putBoolean("set_timer_delete", paramBoolean1);
    localBundle.putBoolean("param.isSyncToQQStory", paramBoolean2);
    avzf.a().a("cmd.publishMoodForAll", localBundle, false);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong)
  {
    awat.h(paramString1, paramInt1, paramString2, paramInt2);
  }
  
  public static void a(boolean paramBoolean, avpw.c paramc)
  {
    if (!paramBoolean)
    {
      paramc.cK(false, true);
      return;
    }
    ThreadManager.postImmediately(new QZoneHelper.6(paramc), null, true);
  }
  
  public static boolean a(Context paramContext, int paramInt, long paramLong, String paramString)
  {
    boolean bool = true;
    try
    {
      Object localObject1 = paramContext.getPackageManager().getPackageInfo("com.qzone", 0);
      if (localObject1 != null)
      {
        i = ((PackageInfo)localObject1).versionCode;
        if (i >= paramInt)
        {
          if (bool)
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putLong("qqid", paramLong);
            ((Bundle)localObject1).putLong("uin", paramLong);
            ((Bundle)localObject1).putBoolean("isbackmenu", false);
            ((Bundle)localObject1).putString("selfUin", String.valueOf(paramLong));
            ((Bundle)localObject1).putString("AccountInfoSync", "mobileqq.service");
            ((Bundle)localObject1).putString("ClassNameSync", paramString);
            paramString = new Intent();
            paramString.setClassName("com.qzone", "com.qzone.QZoneSyncAccountActivity");
            paramString.putExtras((Bundle)localObject1);
            paramString.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
            paramContext.startActivity(paramString);
          }
          return bool;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel()) {
          QLog.d("QZoneHelper", 2, localNameNotFoundException.getMessage());
        }
        Object localObject2 = null;
        continue;
        if (i >= 80)
        {
          paramString = new Intent();
          paramString.setData(Uri.parse("mqzone://arouse/activefeed?source=qq&version=1"));
          paramString.setPackage("com.qzone");
          paramContext.startActivity(paramString);
          return true;
        }
        bool = false;
      }
    }
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    if (paramContext != null) {}
    try
    {
      if (anlm.Vr())
      {
        if ((paramContext instanceof FragmentActivity))
        {
          if (avsn.aLz()) {
            return false;
          }
          if (!avsn.b((FragmentActivity)paramContext, ((FragmentActivity)paramContext).app)) {
            return false;
          }
        }
        Intent localIntent = paramIntent;
        if (paramIntent == null) {
          localIntent = new Intent();
        }
        paramIntent = paramContext;
        if ((paramContext instanceof BasePluginActivity)) {
          paramIntent = ((BasePluginActivity)paramContext).getOutActivity();
        }
        paramIntent.startActivity(a(paramIntent, localIntent));
        return true;
      }
      if ((!paramBoolean) && (paramContext != null))
      {
        if ((paramContext instanceof BasePluginActivity)) {
          QzonePluginProxyActivity.x(paramIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
        }
        paramContext.startActivity(paramIntent);
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QZoneHelper", 1, "qzone start error" + paramContext);
    }
    return false;
  }
  
  private static boolean a(Intent paramIntent, byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    long l;
    String str1;
    String str2;
    if (paramArrayOfByte != null)
    {
      bool1 = bool2;
      if (paramArrayOfByte.length > 0)
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        localObject = new RES_ITEM_COVER();
        ((RES_ITEM_COVER)localObject).readFrom(paramArrayOfByte);
        localObject = ((RES_ITEM_COVER)localObject).strJumpQzone;
        paramArrayOfByte = "";
        l = 0L;
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).startsWith("mqzone://arouse/homepage"))) {
          break label208;
        }
        paramArrayOfByte = Uri.parse((String)localObject);
        str1 = paramArrayOfByte.getQueryParameter("actiontype");
        localObject = paramArrayOfByte.getQueryParameter("actionurl");
        str2 = paramArrayOfByte.getQueryParameter("uin");
        paramArrayOfByte = (byte[])localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
    }
    label208:
    for (;;)
    {
      try
      {
        paramArrayOfByte = URLDecoder.decode((String)localObject, "UTF-8");
        int i = 0;
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        try
        {
          i = Integer.parseInt(str1);
          l = Long.parseLong(str2);
          bool1 = bool2;
          if (i == 35)
          {
            paramIntent.putExtra("qqid", l);
            paramIntent.putExtra("famous_space_webview_url", paramArrayOfByte);
            paramIntent.putExtra("click_time", System.currentTimeMillis());
            bool1 = true;
          }
          return bool1;
        }
        catch (NumberFormatException paramIntent)
        {
          QZLog.e("QZoneHelper", "parseAndSetQzoneCoverInfoToIntent", paramIntent);
          return false;
        }
        paramIntent = paramIntent;
        QZLog.e("QZoneHelper", "parseAndSetQzoneCoverInfoToIntent", paramIntent);
        return false;
      }
    }
  }
  
  private static boolean aF(String paramString)
  {
    try
    {
      String str = Build.MODEL;
      if ((str == null) || (str.length() == 0))
      {
        QLog.i("QZoneHelper", 1, "buildModel is empty,not show float items.命中禁止策略");
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QZoneHelper", 2, "buildModel is '" + str + "'");
      }
      if ((paramString == null) || (paramString.length() == 0)) {
        break label158;
      }
      str = "," + str + ",";
      if (("," + paramString + ",").contains(str))
      {
        QLog.i("QZoneHelper", 1, "命中禁止黑名单策略");
        return true;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    return false;
    label158:
    return false;
  }
  
  public static boolean aKX()
  {
    boolean bool2 = false;
    try
    {
      String str = BaseApplicationImpl.getApplication().getQQProcessName();
      boolean bool1 = bool2;
      if (str != null)
      {
        boolean bool3 = str.endsWith(":qzone");
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private static boolean aKY()
  {
    if (isBestPerformanceDevice())
    {
      if (QzoneConfig.getInstance().getConfig("QzoneCover", "HtmlForceClose", 0) == 1) {}
      for (int i = 1; i == 0; i = 0) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  public static boolean aKZ()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if ("com.tencent.mobileqq:qzone".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneHelper", 2, "QzoneProcess is exist");
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean aLa()
  {
    dnL = LocalMultiProcConfig.getBool("comboqz_protect_enable", false);
    if (dnL)
    {
      String str = LocalMultiProcConfig.getString("comboqz_qua", "");
      if (!avpq.getQUA3().equals(str))
      {
        LocalMultiProcConfig.putBool("comboqz_protect_enable", false);
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "QzoneEntranceProtectEnable:" + dnL);
    }
    return dnL;
  }
  
  public static boolean aLb()
  {
    return QzoneConfig.getInstance().getConfig("GifSetting", "GifPlaySwitch", 1) != 0;
  }
  
  public static boolean aLc()
  {
    boolean bool2 = false;
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "FloatModelBlacklist", "N5117,R8007,Coolpad 8720L,R7007,GN9000L,G620-L75,R2017,R6007,R831S,HM 1SC,Coolpad 8705,HUAWEI B199,Coolpad 9190L,HM 1SW,Coolpad 8730L,Coolpad 9190_T00,HS-E620M,HUAWEI G660-L075,Coolpad 5952,HUAWEI G730-L075,Coolpad 8729,HUAWEI C8817L,Bird LT01,Coolpad 5892,Coolpad 7620L,GN9004,HS-X8T,iPhone 6plus,K-Touch Tou ch 2,K-Touch Tou ch3,K-Touch Tou ch3w,Lenovo A560,Lenovo A890e,Lenovo B8080-HV,Lenovo S810t,LT18,MI 3C,N5110,Nokia_XL_4G,R2010,R8000,TCL-P688L,U558,ZTE Grand S II LTE,ZTE Q505T,ZTE Q802T,Coolpad Y60-C1,Coolpad 8702,BOWAY TL2000,Best sonny_LT986,BOWAY TL6000,Coolpad 5200S,Coolpad 5311,Coolpad 5315,DOOV T35,DOOV T60,HS-EG971,HS-EG978,HTC D516d,HUAWEI G6-L22,HUAWEI G620-L72,i6200S,KliTON,koobee M2,L-002,L823,L826,L827,Lingwin K1,LNV-Lenovo A505e,M7009,M811,MI 3W,R830S,ZTE Q801L,ZTE Q701C,YUSUN L63,TCL P631M,TCL J738M,T-smart L818,OUKI G5,OPSSON Q3,　　,MT2L03,VOTO VT898,AOLE,N5111,LA2-L,vtel X5,ETON T3,BOWAY TL500,T-smart L808,DOOV T90,CHM-TL00,thl L968,TCL J938M,2013022,HUAWEI G750-T01,vivo Y20T,vivo Y17T,vivo Y13T,vivo Y15T,vivo X3S W,U707T,R823T,R819T,N1T,Hol-T00,H8S,H30-U10,2014011,M351,HUAWEI G610-T11,vivo X3t,HUAWEI P6-T00,HUAWEI G700-U00,ETON I6,vivo Y11i T,HM NOTE 1TD");
    if (str == null) {
      return false;
    }
    if (!str.equals(cML))
    {
      boolean bool1;
      if (Build.VERSION.SDK_INT != 18)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT != 17) {}
      }
      else
      {
        bool1 = bool2;
        if (aF(str)) {
          bool1 = true;
        }
      }
      dnO = bool1;
      cML = str;
    }
    return dnO;
  }
  
  public static boolean aLd()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneShow_breeze_black_list", "");
    if (str == null) {
      return false;
    }
    return aF(str);
  }
  
  public static boolean aLe()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzonefacade_dynamic_black_list", "GT-N7108");
    if (str == null) {
      return false;
    }
    return aF(str);
  }
  
  public static boolean aLf()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "ParticleEffectBlacklist", "");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if (!str.equals(cMM))
    {
      dnP = aF(str);
      cMM = str;
    }
    return dnP;
  }
  
  public static boolean aLg()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "ParticleEffectBestPerformBlacklist", "");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if (!str.equals(cMN))
    {
      dnQ = aF(str);
      cMN = str;
    }
    return dnQ;
  }
  
  public static boolean aLh()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneSetting", "PhotoCategoryScannerFrontCamBlackList", "N1T");
    if (str == null) {
      return false;
    }
    if (!str.equals(cMO))
    {
      dnR = aF(str);
      cMO = str;
    }
    return dnR;
  }
  
  public static boolean aLi()
  {
    return LocalMultiProcConfig.getBool("key_first_enter_friend_feed", true);
  }
  
  public static boolean aLj()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "hideAioFeeds", 0) == 1;
  }
  
  public static boolean aLk()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "DisableReqAioStoryFeed", 1) == 1;
  }
  
  public static boolean aLl()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "hideFeedsInConverstation", 0) == 1;
  }
  
  public static boolean aLm()
  {
    return QzoneConfig.getInstance().getConfigSync("QZoneSetting", "enable_layout_factory", 1) == 1;
  }
  
  public static void aae(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.contains("mobile.qzone.qq.com")) {
      return;
    }
    QZoneLoginReportHelper.reportLoginFromMQQSearchH5();
  }
  
  public static final void ac(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putString("big_brother_source_key", "biz_src_jc_qzone");
    }
  }
  
  public static final void ay(Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent.putExtra("big_brother_source_key", "biz_src_jc_qzone");
    }
  }
  
  public static void b(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    aqha.a(paramActivity, 230).setMessage(2131718229).setPositiveButton(2131717752, new avpx()).setNegativeButton(2131720223, paramOnClickListener).show();
  }
  
  public static void b(Activity paramActivity, avpw.d paramd, int paramInt)
  {
    paramd = QzoneConfig.getInstance().getConfig("H5Url", "QzoneSettingMainPage", "https://h5.qzone.qq.com/qzone/setting?_wv=3&_proxy=1&uin={uin}").replace("{uin}", String.valueOf(paramd.cMP)).replace("{host_uin}", paramd.cMP).replace("{UIN}", String.valueOf(paramd.cMP)).replace("{HOST_UIN}", paramd.cMP);
    if (!aurr.getArguments(paramd).containsKey("_wv")) {
      aurr.addParameter(paramd, "_wv", "5");
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "jump qzone setting URL:" + paramd);
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    en(localIntent);
    localIntent.putExtra("url", paramd);
    localIntent.putExtra("isFromQQ", true);
    localIntent.putExtra("fromQZone", false);
    localIntent.putExtra("injectrecommend", true);
    if (arap.sPluginNameSpaceHashMap.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717944));
    localIntent.setData(Uri.parse(paramd));
    localIntent.addFlags(268435456);
    ay(localIntent);
    paramActivity.startActivity(localIntent);
  }
  
  public static void b(Activity paramActivity, avpw.d paramd, Intent paramIntent)
  {
    a(paramIntent, paramd);
    QzonePluginProxyActivity.x(paramIntent, "com.qzone.misc.web.QZoneTranslucentActivity2");
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, paramIntent, 0);
  }
  
  public static void b(Activity paramActivity, avpw.d paramd, Intent paramIntent, int paramInt)
  {
    paramIntent = new Intent(paramIntent);
    a(paramIntent, paramd);
    QzonePluginProxyActivity.x(paramIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, paramIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, avpw.d paramd, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = a(paramd, "com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity");
    localIntent.putExtras(paramBundle);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, avpw.d paramd, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo, int paramInt)
  {
    paramBaseBusinessAlbumInfo = a(paramd, paramBaseBusinessAlbumInfo);
    paramBaseBusinessAlbumInfo.putExtra("UploadPhoto.key_from_album_shortcut", true);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, paramBaseBusinessAlbumInfo, paramInt);
  }
  
  public static void b(Activity paramActivity, avpw.d paramd, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo, int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity");
    localIntent.putExtra("key_album_id", paramBaseBusinessAlbumInfo.mAlbumId);
    localIntent.putExtra("key_album_name", paramBaseBusinessAlbumInfo.mTitle);
    localIntent.putExtra("key_album_owner_uin", paramBaseBusinessAlbumInfo.mUin);
    localIntent.putExtra("key_is_individual_album", paramBaseBusinessAlbumInfo.doR);
    localIntent.putExtra("key_album_anonymity", paramBaseBusinessAlbumInfo.eyD);
    localIntent.putExtra("QZ_ALBUM_THEME", paramBaseBusinessAlbumInfo.mAlbumType);
    localIntent.putExtra("key_personal_album_enter_model", 2);
    localIntent.putExtra("key_album_refer", paramString);
    if (aKX())
    {
      localIntent.setClassName(paramActivity, "com.qzone.album.business.photolist.activity.QZonePersonalPhotoListActivity");
      paramActivity.startActivity(localIntent);
      return;
    }
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, avpw.d paramd, Long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    a(paramActivity, paramd, paramLong, paramInt1, paramBoolean, paramInt2, 12);
  }
  
  public static void b(Activity paramActivity, avpw.d paramd, String paramString, int paramInt)
  {
    try
    {
      Intent localIntent = new Intent();
      a(localIntent, paramd);
      QzonePluginProxyActivity.x(localIntent, "com.qzone.feed.ui.activity.QZoneNuanProfileActivity");
      localIntent.putExtra("key_uin", Long.parseLong(paramString));
      QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.e("QZoneHelper", 2, "forwardToNuanProfile error!", paramActivity);
    }
  }
  
  public static void b(Activity paramActivity, avpw.d paramd, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("startup_sceneid", 4);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString2))
    {
      bool1 = bool2;
      if (paramString2.contains("blog")) {
        bool1 = true;
      }
    }
    localIntent.putExtra("qzone.isFavorBlog", bool1);
    localIntent.putExtra("qzone.cellid", paramString1);
    localIntent.putExtra("qzone.sourceFrom", true);
    localIntent.putExtra("qzone.favorOwner", paramLong);
    QZoneLoginReportHelper.setLoginFromMyFav(localIntent);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, avpw.d paramd, String paramString1, String paramString2, int paramInt)
  {
    paramd = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunAlbumDetail", "https://h5.qzone.qq.com/groupphoto/inqq/detail/{QQ_URL}?_wv=3&_proxy=1").replace("{QQ_URL}", URLEncoder.encode(paramString1));
    paramString1 = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
    paramString1.putExtra("url", paramd);
    paramString1.putExtra("fromQZone", true);
    paramString1.putExtra("injectrecommend", true);
    if (arap.sPluginNameSpaceHashMap.containsKey("Qzone")) {
      paramString1.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString1.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717944));
    paramString1.setData(Uri.parse(paramd));
    paramActivity.startActivityForResult(paramString1, paramInt);
  }
  
  public static void b(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, String paramString3, String paramString4, int paramInt3, int paramInt4)
  {
    avpw.d locald = avpw.d.a();
    locald.cMP = paramString1;
    paramString1 = a(null, paramInt1, String.valueOf(paramLong), paramString2, paramString3, paramString4, "mqqChat");
    paramString1.putExtra("photoactivity_key_type", paramInt2);
    paramString1.putExtra("is_from_mini_app", true);
    paramString1.putExtra("up_way", paramInt4);
    paramString1.setFlags(402653184);
    a(paramString1, locald);
    QzonePluginProxyActivity.x(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity");
    QzonePluginProxyActivity.a(paramActivity, locald.cMP, paramString1, paramInt3);
  }
  
  public static void b(Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("categoryBusiType", paramInt1);
      localIntent.putExtra("categoryId", paramString2);
      QzonePluginProxyActivity.x(localIntent, "com.qzone.album.business.albumlist.activity.QzonePhotoCategoryDetailsActivity");
      QzonePluginProxyActivity.a(paramActivity, paramString1, localIntent, paramInt2);
      return;
    }
    QLog.e("QZoneHelper", 1, "forwardToCategoryAlbum fail type = " + paramInt1 + " id=" + paramString2);
  }
  
  public static void b(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    QZoneLoginReportHelper.setLoginFromSearch(paramIntent);
    c(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, ArrayList<String> paramArrayList, ArrayList<ResultRecord> paramArrayList1, PublishEventTag paramPublishEventTag, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("qzone_uin", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("summary", paramString2);
    }
    paramString2 = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        String str = (String)paramArrayList.next();
        if (!TextUtils.isEmpty(str)) {
          paramString2.add(str);
        }
      } while (paramString2.size() < 9);
    }
    if (paramString2.size() > 0) {
      localIntent.putStringArrayListExtra("images", paramString2);
    }
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
      localIntent.putParcelableArrayListExtra("at_friend", paramArrayList1);
    }
    if (paramPublishEventTag != null) {
      localIntent.putExtra("event_tag", paramPublishEventTag);
    }
    localIntent.putExtra("isEmbedInTabActivity", true);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodTabActivity");
    QzonePluginProxyActivity.a(paramActivity, paramString1, localIntent, paramInt);
  }
  
  @RequiresApi(api=26)
  private static void b(Bitmap paramBitmap, @NonNull QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2)
  {
    paramQQAppInterface = paramQQAppInterface.getApp();
    ShortcutManager localShortcutManager = (ShortcutManager)paramQQAppInterface.getSystemService(ShortcutManager.class);
    if (!isShortcutCreated_O(paramString1, localShortcutManager)) {
      return;
    }
    localShortcutManager.updateShortcuts(Arrays.asList(new ShortcutInfo[] { a(paramQQAppInterface, paramBitmap, paramString1, paramLong, paramString2, "update") }));
  }
  
  public static void b(@NonNull QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Bitmap paramBitmap, long paramLong)
  {
    ThreadManager.post(new QZoneHelper.4(paramQQAppInterface, paramString1, paramLong, paramString2, paramBitmap), 2, null, true);
  }
  
  public static void b(WebViewPlugin paramWebViewPlugin, WebViewPlugin.a parama, Activity paramActivity, String paramString1, String paramString2)
  {
    paramString2 = new Intent();
    QzonePluginProxyActivity.x(paramString2, "com.qzone.publish.ui.activity.QZonePublishVoiceMoodActivity");
    paramString2.putExtra("key_entrance_is_voice_mood", false);
    QzonePluginProxyActivity.a(paramActivity, paramString1, paramString2, a(paramWebViewPlugin, parama, 6));
  }
  
  public static void b(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    String str;
    if ("source_from_quick_shoot".equals(paramString2)) {
      str = "value.sourceFromQqQuickShoot";
    }
    for (;;)
    {
      b(paramString1, paramArrayList, str, 2);
      return;
      str = paramString2;
      if ("forward_source_to_qzone".equals(paramString2)) {
        str = "value.personalSign";
      }
    }
  }
  
  public static void b(String paramString1, ArrayList<String> paramArrayList, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.content", paramString1);
    localBundle.putStringArrayList("param.images", paramArrayList);
    localBundle.putString("param.source", paramString2);
    localBundle.putInt("param.subtype", paramInt);
    avzf.a().a("cmd.publishMood", localBundle, false);
  }
  
  public static boolean b(Activity paramActivity, String paramString1, String paramString2)
  {
    if ((!paramString1.startsWith("http://mobile.qzone.qq.com")) && (!paramString1.startsWith("https://mobile.qzone.qq.com"))) {}
    do
    {
      do
      {
        return false;
        paramString2 = Uri.parse(paramString1);
      } while (paramString2 == null);
      paramString2 = paramString2.getQueryParameter("jumptoqzone");
    } while ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals("1")));
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "aio2qzonedetail", 1) == 1)
    {
      paramString2 = new Intent();
      a(paramString2, avpw.d.a());
      QzonePluginProxyActivity.x(paramString2, "com.qzone.detail.ui.activity.QzoneDetailActivity");
      paramString2.putExtra("startup_sceneid", 4);
      paramString2.putExtra("mqqflag", 1);
      paramString2.putExtra("cell_operation.qq_url", paramString1);
      paramString2.putExtra("jumpToDetailFromQQWhat", 2);
      paramString2.putExtra("refer", "mqqChat");
      QZoneLoginReportHelper.setLoginFromAIOFeedShare(paramString2);
      QzonePluginProxyActivity.a(paramActivity, avpw.d.a().cMP, paramString2, 0);
      if (QLog.isColorLevel()) {
        QLog.i("QZoneHelper", 2, "forwardToQzoneDetailFromAIO success:url=" + paramString1);
      }
    }
    return true;
  }
  
  public static boolean bd(Context paramContext, String paramString)
  {
    return ausc.bb(paramContext, paramString);
  }
  
  public static void bf(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.qq.syncQunMsg");
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.tencent.qq.unreadcount", paramInt);
    localIntent.putExtras(localBundle);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void bp(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, paramString, null, false);
  }
  
  public static void bq(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    while (aKZ()) {
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.getApp(), QzonePluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.setAction("com.qzone.intent.action.PRELOAD_QUN_ALBUM_FEEDS");
    localIntent.putExtra("qunid", paramString);
    localIntent.putExtra("qzone_uin", paramQQAppInterface.getCurrentAccountUin());
    paramString = new avfw.d(0);
    paramString.mPluginID = QzonePluginProxyActivity.Gg();
    paramString.mPluginName = "QQ空间";
    paramString.mUin = paramQQAppInterface.getCurrentAccountUin();
    paramString.cKu = "com.qzone.preview.service.PictureService";
    paramString.mIntent = localIntent;
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, "Start QZone QunAlbum Preload");
    }
    avfw.c(paramQQAppInterface.getApp(), paramString);
  }
  
  public static AppRuntime c(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (paramBaseApplicationImpl == null) {
      return null;
    }
    try
    {
      Class localClass = Class.forName("com.tencent.zebra.app.PhotoplusAppInterface");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          QLog.e("QZLog", 1, "createPhotoPlusAppInterface load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          ClassLoader localClassLoader;
          paramBaseApplicationImpl.printStackTrace();
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassLoader = QzonePluginProxyActivity.d(paramBaseApplicationImpl);
        paramBaseApplicationImpl = localClassLoader.loadClass("com.tencent.zebra.app.PhotoplusAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
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
  
  public static void c(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    aqha.a(paramActivity, 230).setMessage(2131718230).setPositiveButton(2131720223, paramOnClickListener).setNegativeButton(2131717752, new avpy()).show();
  }
  
  public static void c(Activity paramActivity, avpw.d paramd, int paramInt)
  {
    paramd = new SimpleDateFormat("yyyyMM", Locale.getDefault()).format(new Date());
    paramd = QzoneConfig.getInstance().getConfig("H5Url", "QzoneShuoshuoDailyCalendar", "https://h5.qzone.qq.com/v2/shuoshuo-daily/calendar/{date}?_wv=16777216").replace("{date}", paramd).replace("{DATE}", paramd);
    if (!aurr.getArguments(paramd).containsKey("_wv")) {
      aurr.addParameter(paramd, "_wv", "1027");
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "jump qzone ShuoshuoDailyCalendar URL:" + paramd);
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    en(localIntent);
    localIntent.putExtra("url", paramd);
    localIntent.putExtra("isFromQQ", false);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    if (arap.sPluginNameSpaceHashMap.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717944));
    localIntent.setData(Uri.parse(paramd));
    localIntent.addFlags(268435456);
    ay(localIntent);
    paramActivity.startActivity(localIntent);
  }
  
  public static void c(Activity paramActivity, avpw.d paramd, Intent paramIntent, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity");
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void c(Activity paramActivity, avpw.d paramd, Bundle paramBundle, int paramInt)
  {
    avzf.a().a("cmd.cancelKillPictureProcess", null, false);
    Intent localIntent = a(paramd, "com.qzone.preview.QzonePictureViewer");
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("fromQZone", false);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt, null, false);
  }
  
  public static void c(Activity paramActivity, avpw.d paramd, String paramString, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_OPEN_SHARE");
    a(localIntent, paramd);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
    localIntent.putExtra("startup_sceneid", 5);
    localIntent.putExtra("key_file_path", paramString);
    localIntent.putExtra("key_title", acfp.m(2131713119));
    localIntent.putExtra("key_desc", "");
    localIntent.putExtra("key_need_save_draft", false);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void c(Activity paramActivity, avpw.d paramd, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramd = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunAlbumSelect", "https://h5.qzone.qq.com/groupphoto/inqq/album/{QUN_ID}/select?_wv=3&_proxy=1").replace("{QUN_ID}", paramString1);
    paramString1 = new Intent(paramActivity, QQBrowserActivity.class);
    en(paramString1);
    paramString1.putExtra("url", paramd);
    if (arap.sPluginNameSpaceHashMap.containsKey("Qzone")) {
      paramString1.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString1.setData(Uri.parse(paramd));
    ay(paramString1);
    paramActivity.startActivityForResult(paramString1, paramInt);
  }
  
  public static void c(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    a(paramActivity, paramString, paramIntent, null, paramInt);
  }
  
  public static AppRuntime d(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (paramBaseApplicationImpl == null) {
      return null;
    }
    try
    {
      Class localClass = Class.forName("com.qzone.live.app.QZoneLiveVideoAppInterface");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          QLog.e("QZLog", 1, "createQzoneLiveAppInterface load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          ClassLoader localClassLoader;
          paramBaseApplicationImpl.printStackTrace();
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassLoader = QzonePluginProxyActivity.e(paramBaseApplicationImpl);
        paramBaseApplicationImpl = localClassLoader.loadClass("com.qzone.live.app.QZoneLiveVideoAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
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
  
  public static void d(Activity paramActivity, avpw.d paramd, Bundle paramBundle, int paramInt)
  {
    avzf.a().a("cmd.cancelKillPictureProcess", null, false);
    Intent localIntent = a(paramd, "com.qzone.preview.QzonePictureViewer");
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("fromQZone", true);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt, null, false);
  }
  
  public static void d(Activity paramActivity, avpw.d paramd, String paramString, int paramInt)
  {
    paramd = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunPassiveFeed", "https://h5.qzone.qq.com/groupphoto/inqq/relatedme/{QUN_ID}/{UIN}?_wv=3&_proxy=1").replace("{QUN_ID}", paramString).replace("{UIN}", paramd.cMP);
    paramString = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
    paramString.putExtra("url", paramd);
    paramString.putExtra("fromQZone", true);
    paramString.putExtra("injectrecommend", true);
    if (arap.sPluginNameSpaceHashMap.containsKey("Qzone")) {
      paramString.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717944));
    paramString.setData(Uri.parse(paramd));
    if (QZoneLoginReportHelper.needAddLoginFromQunAlbum(paramString, paramInt)) {
      QZoneLoginReportHelper.reportLoginFromQunAlbum();
    }
    paramActivity.startActivityForResult(paramString, paramInt);
  }
  
  public static int dW()
  {
    int i = 3;
    if (exQ != 0) {
      return exQ;
    }
    if (QzoneHardwareRestriction.meetHardwareRestriction(3, 2)) {}
    for (;;)
    {
      exQ = i;
      QLog.d("QZoneHelper", 2, "[jinqianli-performance] current mem level is " + QzoneHardwareRestriction.getCurrentMemLevel() + ", current cpu level is " + QzoneHardwareRestriction.getCurrentCpuLevel() + ", play gif parformance level is " + exQ);
      return i;
      if (QzoneHardwareRestriction.meetHardwareRestriction(2, 1)) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
  
  public static void dn(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneHelper", 2, "jump forwardToCmActionUrl URL:" + paramString);
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    en(localIntent);
    localIntent.putExtra("url", paramString);
    if (arap.sPluginNameSpaceHashMap.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717944));
    localIntent.setData(Uri.parse(paramString));
    localIntent.addFlags(268435456);
    ay(localIntent);
    paramContext.startActivity(localIntent);
  }
  
  public static void jdMethod_do(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    do
    {
      return;
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePictureViewerProxyService.class);
      BaseApplicationImpl.getContext().stopService(localIntent);
      aqft.killProcess(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:picture");
      localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
      BaseApplicationImpl.getContext().stopService(localIntent);
      aqft.killProcess(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzone");
      aqft.killProcess(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzonevideo");
    } while (TextUtils.isEmpty(paramString));
    paramContext.deleteDatabase(SecurityUtil.encrypt(paramString));
  }
  
  public static void dp(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("cmd", "Schema");
    localIntent.putExtra("schema", paramString);
    a((Activity)paramContext, avpw.d.a(), localIntent);
  }
  
  public static AppRuntime e(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (paramBaseApplicationImpl == null) {
      return null;
    }
    try
    {
      Class localClass = Class.forName("com.qzone.verticalvideo.app.QZoneVerticalVideoAppInterface");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassLoader = QzonePluginProxyActivity.f(paramBaseApplicationImpl);
        paramBaseApplicationImpl = localClassLoader.loadClass("com.qzone.verticalvideo.app.QZoneVerticalVideoAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      QLog.e("QZLog", 1, "createVerticalVideoAppInterface failed:", paramBaseApplicationImpl);
      return null;
    }
    if (paramBaseApplicationImpl == null)
    {
      QLog.e("QZLog", 1, "createVerticalVideoAppInterface load class fail");
      return null;
    }
    do
    {
      ClassLoader localClassLoader;
      paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
    paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
    return paramBaseApplicationImpl;
  }
  
  public static void e(Activity paramActivity, avpw.d paramd, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = a(paramd, "com.qzone.album.business.dlna.activity.DLNAActivity");
    localIntent.putExtras(paramBundle);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt);
  }
  
  public static void e(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (paramAppRuntime == null) {}
    do
    {
      return;
      Object localObject = paramAppRuntime.getApplication();
      String str = paramAppRuntime.getAccount();
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePictureViewerProxyService.class);
      BaseApplicationImpl.getContext().stopService(localIntent);
      aqft.killProcess(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:picture");
      localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
      BaseApplicationImpl.getContext().stopService(localIntent);
      aqft.killProcess(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzone");
      aqft.killProcess(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzonevideo");
      avsu.clearFileCache((Context)localObject);
      if (!TextUtils.isEmpty(str))
      {
        ((Context)localObject).deleteDatabase(SecurityUtil.encrypt(str));
        LocalMultiProcConfig.putInt("Widget_" + str, "WidgetID", -1);
      }
      ((Context)localObject).deleteDatabase(SecurityUtil.encrypt("0"));
      sxc.KU();
      localObject = ((Context)localObject).getFilesDir().getParent() + File.separator + "shared_prefs";
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        ahbj.deleteFile((String)localObject + File.separator + "qz_predownload_config.xml");
        ahbj.deleteFile((String)localObject + File.separator + "QZ_Per_Config.xml");
        ahbj.deleteFile((String)localObject + File.separator + "QZONE_UNREAD.xml");
      }
      localObject = aqul.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "MobileQQ" + File.separator + "trace");
      if (localObject != null) {
        ahbj.deleteFile((String)localObject);
      }
    } while ((!paramBoolean) || (!(paramAppRuntime instanceof QQAppInterface)));
    PublicAccountJavascriptInterface.deleteAllH5Data((QQAppInterface)paramAppRuntime);
  }
  
  public static void eBx()
  {
    ThreadManager.post(new QZoneHelper.10(), 5, null, false);
  }
  
  private static void eR(@NonNull QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent("com.qzone.album.CreateAlbumShortcutSucceedReceiver");
    localIntent.putExtra("AlbumCreateShortcutFailed", true);
    paramQQAppInterface.getApp().sendBroadcast(localIntent);
  }
  
  public static void eS(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (aLa())) {
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.getApp(), QzonePluginProxyService.class);
    localIntent.setAction("com.qzone.intent.action.CANCEL_QZONE_ALIVE");
    localIntent.putExtra("key_is_keep_alive", false);
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = QzonePluginProxyActivity.Gg();
    locald.mPluginName = "QQ空间";
    locald.mUin = paramQQAppInterface.getCurrentAccountUin();
    locald.a = null;
    locald.cKu = "com.qzone.preview.service.PictureService";
    locald.mIntent = localIntent;
    locald.aqY = true;
    avfw.c(paramQQAppInterface.getApp(), locald);
  }
  
  public static void en(Intent paramIntent)
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "openWebSecurityVerify", 1) == 1) {}
  }
  
  public static void eo(Intent paramIntent)
  {
    paramIntent.putExtra("key_time_record", System.currentTimeMillis());
  }
  
  public static AppRuntime f(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (paramBaseApplicationImpl == null) {
      return null;
    }
    try
    {
      Class localClass = Class.forName("com.qzone.verticalvideo.app.QZoneWeishiFeedsAppInterface");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassLoader = QzonePluginProxyActivity.g(paramBaseApplicationImpl);
        paramBaseApplicationImpl = localClassLoader.loadClass("com.qzone.verticalvideo.app.QZoneWeishiFeedsAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      QLog.e("QZLog", 1, "createWeishiFeedsAppInterface failed:", paramBaseApplicationImpl);
      return null;
    }
    if (paramBaseApplicationImpl == null)
    {
      QLog.e("QZLog", 1, "createWeishiFeedsAppInterface load class fail");
      return null;
    }
    do
    {
      ClassLoader localClassLoader;
      paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
    paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
    return paramBaseApplicationImpl;
  }
  
  public static void f(Activity paramActivity, avpw.d paramd, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.x(localIntent, "com.qzone.album.ui.activity.QzDynamicVideoEditActivity");
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("extra_is_from_p2v_edit", true);
    QzonePluginProxyActivity.a(paramActivity, paramd.cMP, localIntent, paramInt, null, false);
  }
  
  public static void f(Context paramContext, Object paramObject)
  {
    if ((paramContext == null) || (paramObject == null)) {
      return;
    }
    try
    {
      Class localClass = Class.forName("com.qzone.personalize.floatobject.ui.FloatItemView");
      paramContext = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        ClassLoader localClassLoader = QzonePluginProxyActivity.c(paramContext);
        paramContext = localClassLoader.loadClass("com.qzone.personalize.floatobject.ui.FloatItemView");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    if (paramContext == null) {
      try
      {
        QLog.e("QZLog", 1, "*createQZoneFloatObjectView load class fail");
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    paramContext.getMethod("stop", new Class[0]).invoke(paramObject, new Object[0]);
  }
  
  public static void forwardToAggregate(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    QZLog.e("QZoneHelper", "forwardToAggregate() unexpired call request!");
    QzonePluginProxyActivity.x(paramIntent, "com.qzone.commoncode.module.videostory.aggregate.VideoStoryAggregateActivity");
    QzonePluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static void forwardToBrowser(Activity paramActivity, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.setData(Uri.parse(paramString1));
    en(localIntent);
    if (TextUtils.isEmpty(paramString2)) {}
    for (paramString1 = null;; paramString1 = paramString2.getBytes())
    {
      if (paramString1 != null) {
        localIntent.putExtra("post_data", paramString1);
      }
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      ay(localIntent);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
  }
  
  public static void g(Context paramContext, Object paramObject)
  {
    if ((paramContext == null) || (paramObject == null)) {
      return;
    }
    try
    {
      Class localClass = Class.forName("com.qzone.personalize.floatobject.ui.FloatItemView");
      paramContext = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        ClassLoader localClassLoader = QzonePluginProxyActivity.c(paramContext);
        paramContext = localClassLoader.loadClass("com.qzone.personalize.floatobject.ui.FloatItemView");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    if (paramContext == null) {
      try
      {
        QLog.e("QZLog", 1, "*createQZoneFloatObjectView load class fail");
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    paramContext.getMethod("start", new Class[0]).invoke(paramObject, new Object[0]);
  }
  
  public static String getQUA()
  {
    return avpq.getQUA3();
  }
  
  public static void gw(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext.stopService(new Intent(paramContext, QzonePluginPublishQueueProxyService.class));
  }
  
  public static AppRuntime i(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    PerfTracer.traceStart("Runtime_load_runtime");
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      QLog.e("QZLog", 1, "*createQZoneAppInterface  begin");
      try
      {
        paramString = Class.forName("com.qzone.app.QZoneAppInterface");
        paramBaseApplicationImpl = paramString;
      }
      catch (ClassNotFoundException paramString)
      {
        for (;;)
        {
          paramString = QzonePluginProxyActivity.c(paramBaseApplicationImpl);
          paramBaseApplicationImpl = paramString.loadClass("com.qzone.app.QZoneAppInterface");
          BasicClassTypeUtil.setClassLoader(true, paramString);
        }
      }
      if (paramBaseApplicationImpl == null)
      {
        QLog.e("QZLog", 1, "*createQZoneAppInterface load class fail");
        return null;
      }
    }
    catch (ClassNotFoundException paramBaseApplicationImpl)
    {
      QLog.e("QZoneHelper", 1, "createQZoneAppInterface", paramBaseApplicationImpl);
      for (;;)
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.newInstance();
        if ((paramBaseApplicationImpl != null) && ((paramBaseApplicationImpl instanceof AppRuntime)))
        {
          QLog.e("QZLog", 1, "*createQZoneAppInterface  suscees");
          paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
          return paramBaseApplicationImpl;
        }
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        QLog.e("QZoneHelper", 1, "createQZoneAppInterface", paramBaseApplicationImpl);
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        QLog.e("QZoneHelper", 1, "createQZoneAppInterface", paramBaseApplicationImpl);
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        QLog.e("QZoneHelper", 1, "createQZoneAppInterface", paramBaseApplicationImpl);
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        QLog.e("QZoneHelper", 1, "createQZoneAppInterface", paramBaseApplicationImpl);
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        QLog.e("QZoneHelper", 1, "createQZoneAppInterface", paramBaseApplicationImpl);
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        QLog.e("QZoneHelper", 1, "createQZoneAppInterface", paramBaseApplicationImpl);
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    finally
    {
      PerfTracer.traceEnd("Runtime_load_runtime");
    }
  }
  
  public static void i(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      long l = ((AppRuntime)localObject).getLongAccountUin();
      localObject = paramIntent;
      if (paramIntent == null) {
        localObject = new Intent();
      }
      QzonePluginProxyActivity.x((Intent)localObject, "com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity");
      QzonePluginProxyActivity.a(paramActivity, String.valueOf(l), (Intent)localObject, paramInt);
    }
  }
  
  public static void i(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    paramBundle = new Intent();
    QzonePluginProxyActivity.x(paramBundle, "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity");
    paramBundle.putExtra("fromQZone", false);
    QzonePluginProxyActivity.a(paramActivity, "0", paramBundle, paramInt, null, false);
  }
  
  public static long iN()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "VideoCanUploadDurationThreshold", 601000);
  }
  
  public static long iO()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "VideoCanUploadSizeThreshold", 1610612736L);
  }
  
  public static boolean isBestPerformanceDevice()
  {
    if (!dnN)
    {
      dnM = QzoneHardwareRestriction.meetHardwareRestriction(1, 1);
      dnN = true;
    }
    return dnM;
  }
  
  @RequiresApi(api=25)
  public static boolean isShortcutCreated_O(String paramString, ShortcutManager paramShortcutManager)
  {
    if (paramShortcutManager == null) {
      return false;
    }
    paramShortcutManager = paramShortcutManager.getPinnedShortcuts().iterator();
    do
    {
      if (!paramShortcutManager.hasNext()) {
        break;
      }
    } while (!paramString.equals(((ShortcutInfo)paramShortcutManager.next()).getId()));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static AppRuntime j(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    PerfTracer.traceStart("Runtime_load_main_runtime");
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    paramBaseApplicationImpl = new QzoneMainRuntime();
    PerfTracer.traceEnd("Runtime_load_main_runtime");
    return paramBaseApplicationImpl;
  }
  
  public static Intent k(Context paramContext)
  {
    paramContext = new Intent();
    QzonePluginProxyActivity.x(paramContext, "com.qzone.feed.ui.activity.QZoneMyFeedActivity");
    return paramContext;
  }
  
  public static AppRuntime k(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    PerfTracer.traceStart("Runtime_load_live_main_runtime");
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    paramBaseApplicationImpl = new QzoneLiveMainRuntime();
    PerfTracer.traceEnd("Runtime_load_live_main_runtime");
    return paramBaseApplicationImpl;
  }
  
  public static AppRuntime l(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    PerfTracer.traceStart("Runtime_load_runtime");
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.qzone.preview.QZonePictureAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString = paramString;
        paramString = QzonePluginProxyActivity.c(paramBaseApplicationImpl);
        paramBaseApplicationImpl = paramString.loadClass("com.qzone.preview.QZonePictureAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
      for (;;)
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if ((paramBaseApplicationImpl != null) && ((paramBaseApplicationImpl instanceof AppRuntime)))
        {
          paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
          return paramBaseApplicationImpl;
        }
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.traceEnd("Runtime_load_runtime");
      }
    }
    finally
    {
      PerfTracer.traceEnd("Runtime_load_runtime");
    }
    if (paramBaseApplicationImpl != null) {}
  }
  
  public static boolean l(String paramString, @NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return aqlr.hasShortCut(paramContext, new String[] { paramString });
    }
    return isShortcutCreated_O(paramString, (ShortcutManager)paramContext.getSystemService(ShortcutManager.class));
  }
  
  public static AppRuntime m(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.qzone.video.service.QZoneVideoAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        try
        {
          QLog.e("QZLog", 1, "*createQZoneVideoAppInterface load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
        paramString = paramString;
        paramBaseApplicationImpl = QzonePluginProxyActivity.c(paramBaseApplicationImpl).loadClass("com.qzone.video.service.QZoneVideoAppInterface");
        continue;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime))) {
          break label89;
        }
        paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
      }
      return null;
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
  
  public static void nH(long paramLong)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QZoneHelper.9(paramLong));
  }
  
  public static void p(String paramString, Context paramContext)
  {
    String str = LocalMultiProcConfig.getString("qzh5_url", "");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "https://m.qzone.com/infocenter";
    }
    paramString = (String)localObject + "?sid=" + paramString;
    if (paramContext == null) {
      return;
    }
    localObject = new Intent(paramContext, QQBrowserActivity.class);
    en((Intent)localObject);
    ((Intent)localObject).putExtra("plugin_start_time", System.nanoTime());
    ((Intent)localObject).putExtra("click_start_time", System.currentTimeMillis());
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    ((Intent)localObject).putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717944));
    ay((Intent)localObject);
    paramContext.startActivity(((Intent)localObject).putExtra("url", paramString));
  }
  
  public static Bundle parseUrlParams(String paramString)
  {
    int i = 0;
    Bundle localBundle = new Bundle();
    if (paramString == null) {
      return localBundle;
    }
    int j = paramString.indexOf('?');
    if ((j < 0) || (j + 1 >= paramString.length())) {
      return localBundle;
    }
    paramString = paramString.substring(j + 1);
    if (TextUtils.isEmpty(paramString)) {
      return localBundle;
    }
    paramString = paramString.split("&");
    for (;;)
    {
      if ((paramString != null) && (i < paramString.length))
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {}
        try
        {
          localBundle.putString(arrayOfString[0], URLDecoder.decode(arrayOfString[1], "UTF-8"));
          i += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
      }
    }
    return localBundle;
  }
  
  public static void r(Intent paramIntent, int paramInt)
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
  
  public static void s(Activity paramActivity, String paramString, int paramInt)
  {
    a(paramActivity, paramString, null, null, null, null, paramInt);
  }
  
  public static void s(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramString, null, paramBoolean);
  }
  
  public static class a
  {
    public static String f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      return QzoneConfig.getInstance().getConfig("H5Url", "CoverPreview", "https://h5.qzone.qq.com/bgstore/detail/{coverid}?_wv=2098179&from={from}&page={page}&qua={qua}&router=detail&coverid={coverid}&uin={uin}&hostUin={hostUin}&_proxy=1").replace("{qua}", avpq.getQUA3()).replace("{pb}", "").replace("{from}", paramString1).replace("{page}", paramString2).replace("{coverid}", paramString3).replace("{uin}", paramString4).replace("{hostUin}", paramString5);
    }
    
    public static String f(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      paramString1 = QzoneConfig.getInstance().getConfig("H5Url", "PhotoWallUrl", "https://h5.qzone.qq.com/bgstore/photoWall?_wv=2098179&uin={uin}&hostUin={hostUin}&from={from}&page=1&qua={qua}&router=photoWall&_proxy=1").replace("{uin}", paramString1).replace("{hostUin}", paramString2).replace("{qua}", avpq.getQUA3());
      paramString2 = new StringBuilder().append("");
      if (paramBoolean) {}
      for (int i = 1;; i = 0) {
        return paramString1.replace("{isPhotoWall}", i).replace("{clicktime}", String.valueOf(System.currentTimeMillis())).replace("{from}", paramString3);
      }
    }
    
    public static String g(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      return QzoneConfig.getInstance().getConfig("H5Url", "MusicCoverPreview", "https://h5.qzone.qq.com/musicCover/preview?id={coverid}&_wv=2098179&from={from}&page={page}&qua={qua}&router=detail&coverid={coverid}&uin={uin}&hostUin={hostUin}&_proxy=1").replace("{qua}", avpq.getQUA3()).replace("{pb}", "").replace("{from}", paramString1).replace("{page}", paramString2).replace("{coverid}", paramString3).replace("{uin}", paramString4).replace("{hostUin}", paramString5);
    }
    
    public static String l(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      return QzoneConfig.getInstance().getConfig("H5Url", "CoverStore", "https://h5.qzone.qq.com/bgcover/index?_wv=2098179&qua={qua}&_proxy=1").replace("{uin}", paramString3).replace("{hostUin}", paramString4).replace("{qua}", avpq.getQUA3()).replace("{pb}", "").replace("{clicktime}", String.valueOf(System.currentTimeMillis())).replace("{from}", paramString1).replace("{page}", paramString2);
    }
  }
  
  public static class b
  {
    public static String Gd()
    {
      return LocalMultiProcConfig.getString("QzoneFamousSpaceSp", avpw.d.a().cMP, "https://h5.qzone.qq.com/vpage/cover/{uin}/vpage-index?screenWidth={screenWidth}&qua={qua}&_proxy=1&_wv=1029&bottom={bottom}");
    }
  }
  
  public static abstract interface c
  {
    public abstract void cK(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  public static class d
  {
    private static d a;
    public String cMP;
    public String nickname;
    
    public static d a()
    {
      if (a == null) {
        a = new d();
      }
      a.cMP = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      a.nickname = null;
      return a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avpw
 * JD-Core Version:    0.7.0.1
 */