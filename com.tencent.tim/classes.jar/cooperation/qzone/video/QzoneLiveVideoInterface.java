package cooperation.qzone.video;

import aija;
import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import anol;
import anop;
import anop.a;
import anpc;
import aqgz;
import aqhq;
import aqul;
import arap;
import ardk;
import arxr;
import avpp;
import avpq;
import avpw;
import avpw.d;
import avqq;
import avqw;
import avqw.a;
import avqy;
import avsu;
import avyi;
import avyo;
import avyu;
import avzf;
import awdo;
import awdx;
import awdy;
import awdz;
import awea;
import awed;
import awhv;
import awhx;
import awib;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.module.statistics.SpeedStatistics;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneVideoDownloadActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.ServerListProvider;
import cooperation.qzone.report.lp.LpReportInfo_dc01245;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QzoneHardwareRestriction;
import cooperation.qzone.webviewwrapper.IWebviewWrapper;
import cooperation.qzone.webviewwrapper.LiveVideoFeedVipIconListner;
import ilp;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import jqc;
import lk;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import rwt;
import tle;
import tll;
import txk;
import wgv;
import wja;

public class QzoneLiveVideoInterface
{
  public static final String BUSINESS_ID_QZONE_LIVE = "qzone_live";
  public static final String IS_QZONE_LIVE_LAUNCH = "is_qzone_live_launch";
  public static final int MSG_WNS_HTTP_GET_DATA = 203;
  public static final String QZONE_LIVE_PROCESS_ID = "qzone_live_process_id";
  public static final int RET_CODE_COMPRESS_SUCCESS = 2;
  public static final String TAG = "QzoneLiveVideoInterface";
  private static HashMap<String, String> friNickNameMap = new HashMap();
  private static volatile IWebviewWrapper gLiveWebviewInstance;
  private static String version = "0";
  
  public static void addFriend(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    if ((paramActivity instanceof BasePluginActivity)) {
      paramActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    for (;;)
    {
      if (paramActivity != null) {
        paramActivity.startActivityForResult(AddFriendLogicActivity.a(paramActivity, 1, paramString1, "", paramInt2, paramInt3, paramString3, null, null, paramString2, null), paramInt1);
      }
      return;
    }
  }
  
  public static void addLiveVideoComment(Intent paramIntent, Handler paramHandler)
  {
    paramIntent = paramIntent.getExtras();
    avzf.a().a("cmd.uploadCommentVideo", paramIntent, true);
    paramIntent = new awdz(paramHandler);
    avzf.a().a(paramIntent);
  }
  
  public static boolean checkAVCameraUsed(Context paramContext)
  {
    return ilp.g(paramContext, false);
  }
  
  public static void collectPerformance(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    anpc.a(getContext()).collectPerformance(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3);
  }
  
  public static void doAppJump(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    tll.b(GdtBaseAdItem.a().d(paramString1).f(paramString3).e(paramString2).b(paramString4).c(paramString5));
  }
  
  public static void doCgiReport(String paramString)
  {
    GdtReporter.doCgiReport(paramString);
  }
  
  public static void ecLiveShareToQQ(Activity paramActivity, Bundle paramBundle)
  {
    Activity localActivity = paramActivity;
    if ((paramActivity instanceof BasePluginActivity)) {
      localActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    paramActivity = new Intent(localActivity, ForwardRecentActivity.class);
    paramActivity.putExtra("forward_type", 2);
    paramActivity.putExtra("req_type", 1);
    paramActivity.putExtra("req_share_id", Long.parseLong("101735437"));
    paramActivity.putExtras(paramBundle);
    localActivity.startActivity(paramActivity);
  }
  
  public static void ecReportToDc03266(Bundle paramBundle)
  {
    anop.a locala = new anop.a();
    locala.Uq = paramBundle.getString("sop_type");
    locala.Ur = paramBundle.getString("sop_name");
    locala.type = paramBundle.getString("type");
    locala.cfB = paramBundle.getString("push_id");
    locala.feedID = paramBundle.getString("feed_id");
    locala.cfC = paramBundle.getString("content_id");
    locala.contentTitle = paramBundle.getString("content_title");
    locala.cfD = paramBundle.getString("content_url");
    locala.contentType = paramBundle.getString("content_type");
    locala.cfE = paramBundle.getString("content_author");
    locala.d1 = paramBundle.getString("d1");
    locala.d2 = paramBundle.getString("d2");
    locala.d3 = paramBundle.getString("d3");
    locala.d4 = paramBundle.getString("d4");
    anop.a(null, locala);
  }
  
  public static void forwardOpenQzoneVip(Activity paramActivity, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    paramString2 = avpw.d.a();
    paramString2.cMP = (paramLong + "");
    if ((paramActivity instanceof BasePluginActivity))
    {
      avpw.a(((BasePluginActivity)paramActivity).getOutActivity(), paramString2, paramString1, paramLong, "", -1);
      return;
    }
    avpw.a(paramActivity, paramString2, paramString1, paramLong, "", -1);
  }
  
  public static void forwardToBrowser(Activity paramActivity, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("_ext_launch_activity_when_finish")))
    {
      if ((paramActivity instanceof BasePluginActivity))
      {
        avpw.a(((BasePluginActivity)paramActivity).getOutActivity(), avpw.d.a(), paramString1, paramInt, paramBundle, paramString2);
        return;
      }
      avpw.a(paramActivity, avpw.d.a(), paramString1, paramInt, paramBundle, paramString2);
      return;
    }
    if ((paramBundle != null) && (paramBundle.getBoolean("needTranslucentBrowser")))
    {
      if ((paramActivity instanceof BasePluginActivity))
      {
        avpw.a(((BasePluginActivity)paramActivity).getOutActivity(), paramString1, paramInt, paramBundle, paramString2);
        return;
      }
      avpw.a(paramActivity, paramString1, paramInt, paramBundle, paramString2);
      return;
    }
    if ((paramActivity instanceof BasePluginActivity))
    {
      avpw.forwardToBrowser(((BasePluginActivity)paramActivity).getOutActivity(), paramString1, paramInt, paramBundle, paramString2);
      return;
    }
    avpw.forwardToBrowser(paramActivity, paramString1, paramInt, paramBundle, paramString2);
  }
  
  public static void forwardToFeedActionPanel(Activity paramActivity, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString6, int paramInt8, int paramInt9, boolean paramBoolean1, String paramString7, boolean paramBoolean2)
  {
    paramString2 = avpw.d.a();
    paramString2.cMP = paramString1;
    if ((paramActivity instanceof BasePluginActivity))
    {
      avpw.a(((BasePluginActivity)paramActivity).getOutActivity(), paramString2, paramInt1, "", "", "", "", 0, true, 0, 1, 0, 0, 0, "", 40, 0, paramBoolean1, paramString7, paramBoolean2);
      return;
    }
    avpw.a(paramActivity, paramString2, paramInt1, "", "", "", "", 0, true, 0, 1, 0, 0, 0, "", 40, 0, paramBoolean1, paramString7, paramBoolean2);
  }
  
  public static void forwardToFriendFeed(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("newflag", true);
    localIntent.putExtras(paramBundle);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    localIntent.addFlags(805306368);
    avpw.c(paramActivity, paramString, localIntent, paramInt);
  }
  
  public static void forwardToMoodSelectLocation(Activity paramActivity, String paramString, int paramInt, Bundle paramBundle)
  {
    avpw.d locald = avpw.d.a();
    locald.cMP = paramString;
    if ((paramActivity instanceof BasePluginActivity))
    {
      avpw.a(((BasePluginActivity)paramActivity).getOutActivity(), locald, paramInt, paramBundle);
      return;
    }
    avpw.a(paramActivity, locald, paramInt, paramBundle);
  }
  
  public static void forwardToUserHome(Activity paramActivity, long paramLong1, long paramLong2, int paramInt)
  {
    avpw.d locald = avpw.d.a();
    locald.cMP = (paramLong1 + "");
    if (paramLong2 > 0L)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action_js2qzone");
      localIntent.putExtra("cmd", "QZonelive2Homepage");
      localIntent.putExtra("visitUin", paramLong2);
      localIntent.putExtra("requestCode", paramInt);
      if ((paramActivity instanceof BasePluginActivity))
      {
        avpw.a(((BasePluginActivity)paramActivity).getOutActivity(), locald, localIntent);
        return;
      }
      avpw.a(paramActivity, locald, localIntent);
      return;
    }
    QLog.w("QzoneLiveVideoInterface", 2, "startUserHomeActivity, invalid uin");
  }
  
  public static void forwardToUserProfileCard(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramString, paramInt1);
    localAllInOne.bJa = paramInt2;
    localAllInOne.bJb = 3094;
    localAllInOne.subSourceId = 5;
    paramString = (Activity)paramContext;
    paramContext = paramString;
    if ((paramString instanceof BasePluginActivity)) {
      paramContext = ((BasePluginActivity)paramString).getOutActivity();
    }
    ProfileActivity.b(paramContext, localAllInOne);
  }
  
  public static void forwardToVideoInteract(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    Activity localActivity = paramActivity;
    if ((paramActivity instanceof BasePluginActivity)) {
      localActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    paramActivity = new Intent(localActivity, QZoneVideoDownloadActivity.class);
    paramActivity.putExtra("encode_video_params", paramBundle);
    paramActivity.putExtra("video_refer", "video_interact");
    localActivity.startActivityForResult(paramActivity, paramInt);
  }
  
  public static Bitmap generateQrCode(String paramString, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = rwt.a(paramString, -1);
    int m = ((lk)localObject).getWidth();
    paramString = new int[m * m];
    int i = 0;
    while (i < m)
    {
      int j = 0;
      if (j < m)
      {
        if (((lk)localObject).get(j, i)) {}
        for (int k = -16777216;; k = 16777215)
        {
          paramString[(i * m + j)] = k;
          j += 1;
          break;
        }
      }
      i += 1;
    }
    localObject = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).setPixels(paramString, 0, m, 0, 0, m, m);
    try
    {
      paramString = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
      if (paramString == null)
      {
        ((Bitmap)localObject).recycle();
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        System.gc();
        try
        {
          paramString = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
        }
        catch (OutOfMemoryError paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.w("QzoneLiveVideoInterface", 2, "generateQrCode " + paramString.getMessage());
          }
          return null;
        }
      }
      Canvas localCanvas = new Canvas(paramString);
      Paint localPaint = new Paint();
      localPaint.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, 600.0F, -657931, -1513240, Shader.TileMode.REPEAT));
      localCanvas.drawRect(0.0F, 0.0F, paramInt1, paramInt1, localPaint);
      localCanvas.drawBitmap((Bitmap)localObject, null, new Rect(paramInt2, paramInt2, paramInt1 - paramInt2, paramInt1 - paramInt2), null);
      if (paramBitmap != null)
      {
        paramInt1 = (paramInt1 - paramInt3) / 2;
        localPaint = new Paint();
        localPaint.setAntiAlias(true);
        localCanvas.drawBitmap(paramBitmap, null, new Rect(paramInt1, paramInt1, paramInt1 + paramInt3, paramInt1 + paramInt3), localPaint);
      }
      ((Bitmap)localObject).recycle();
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("QzoneLiveVideoInterface", 2, "getQrCode cost time:" + (l2 - l1));
      }
    }
    return paramString;
  }
  
  public static Notification generationNotification(PendingIntent paramPendingIntent, Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    if ("oppo".equalsIgnoreCase(aqgz.getManufacturer())) {
      return avyu.a().b(paramPendingIntent, paramContext, paramBitmap, paramString1, paramString2, 2130849229);
    }
    return avyu.a().c(paramPendingIntent, paramContext, paramBitmap, paramString1, paramString2, 2130849229);
  }
  
  public static int getAppId()
  {
    return AppSetting.getAppId();
  }
  
  public static Application getApplication()
  {
    return BaseApplicationImpl.getApplication();
  }
  
  public static float getAveragePicDownloadSpeed()
  {
    return SpeedStatistics.getInstance().getAverageSpeed();
  }
  
  public static String getBuildNumber()
  {
    return "3058";
  }
  
  public static String getBuilderNumber()
  {
    return "100084";
  }
  
  public static String getCacheDir(String paramString)
  {
    return avsu.getCacheDir(paramString);
  }
  
  public static Context getContext()
  {
    return BaseApplicationImpl.getContext();
  }
  
  public static long getCpuFrequency()
  {
    return QzoneHardwareRestriction.getCpuMaxFreq();
  }
  
  public static void getCurrentPoiInfo(Handler paramHandler)
  {
    QZLog.i("QzoneLiveVideoInterface.NewLbsInterface", 1, "[QZLIVE_LBS_MODULE]----getCurrentPoiInfo");
    awdx.a("qzone_live").v(paramHandler);
  }
  
  public static String getDeviceInfor()
  {
    return avpp.a().getDeviceInfor();
  }
  
  public static IWebviewWrapper getEcWebviewInstance(Context paramContext)
  {
    return new awhv(getContext());
  }
  
  public static void getFriendListFromResultRecord(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject2 = paramIntent.getStringArrayListExtra("friendsList");
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        Object localObject3 = paramIntent.getParcelableArrayListExtra("result_set");
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((ArrayList)localObject3).size() > 0)
          {
            localObject1 = new ArrayList();
            localObject2 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (ResultRecord)((Iterator)localObject2).next();
              if ((localObject3 != null) && (!TextUtils.isEmpty(((ResultRecord)localObject3).uin))) {
                ((ArrayList)localObject1).add(((ResultRecord)localObject3).uin);
              }
            }
          }
        }
      }
      paramIntent.putStringArrayListExtra("friendsList", (ArrayList)localObject1);
    }
  }
  
  public static String getHtmlData(String paramString)
  {
    return ardk.getHtmlData(paramString);
  }
  
  public static Drawable getHuangzuanIcon(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, String paramString2, LiveVideoFeedVipIconListner paramLiveVideoFeedVipIconListner)
  {
    Object localObject1 = getContext();
    long l1 = System.currentTimeMillis();
    QZLog.i("QzoneLiveVideoInterface", 1, "getHuangzuanIcon startTime =" + l1);
    try
    {
      Object localObject2 = QzonePluginProxyActivity.c((Context)localObject1);
      Class localClass = ((ClassLoader)localObject2).loadClass("cooperation.vip.vipcomponent.ui.QzoneHuangzuanVipIconShow");
      localObject2 = ((ClassLoader)localObject2).loadClass("cooperation.vip.vipcomponent.util.VipResourcesListener");
      ClassLoader localClassLoader = localClass.getClassLoader();
      paramLiveVideoFeedVipIconListner = new awea(paramLiveVideoFeedVipIconListner);
      paramLiveVideoFeedVipIconListner = Proxy.newProxyInstance(localClassLoader, new Class[] { localObject2 }, paramLiveVideoFeedVipIconListner);
      if (localClass == null)
      {
        QLog.e("QzoneLiveVideoInterface", 1, "*QzoneHuangzuanVipIconShow load class fail");
        return null;
      }
      if (localObject2 == null)
      {
        QLog.e("QzoneLiveVideoInterface", 1, "*VipResourcesListener load class fail");
        return null;
      }
      localObject1 = localClass.getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { localObject1 });
      paramString2 = localClass.getDeclaredMethod("getLayers", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, String.class, localObject2, Integer.TYPE }).invoke(localObject1, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt3), Integer.valueOf(80), paramString2, paramLiveVideoFeedVipIconListner, Integer.valueOf(0) });
      long l2 = System.currentTimeMillis();
      QZLog.i("QzoneLiveVideoInterface", 1, "getHuangzuanIcon endTime  =" + l2 + " diff =" + (l2 - l1));
      awed.bE(paramString1, "qzone_livevideo_gethuangzuanicon", "sucess");
      if ((paramString2 != null) && ((paramString2 instanceof Drawable)))
      {
        paramString2 = (Drawable)paramString2;
        return paramString2;
      }
    }
    catch (Throwable paramString2)
    {
      awed.bE(paramString1, "qzone_livevideo_gethuangzuanicon", "failed");
      QZLog.e("QzoneLiveVideoInterface", 1, paramString2, new Object[0]);
    }
    return null;
  }
  
  public static String getIMEI()
  {
    return avpp.a().getIMEI();
  }
  
  public static String getIMSI()
  {
    return aqgz.getIMSI();
  }
  
  public static int getIntConfig(String paramString1, String paramString2, int paramInt)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramInt);
  }
  
  public static String getLiveVideoDownLoadClassName()
  {
    if ("qzone_live_video_plugin_hack.apk".equals(avyo.GF())) {
      return "cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2";
    }
    return "cooperation.qzone.QZoneLiveVideoDownloadActivity";
  }
  
  public static String getMobileInfo()
  {
    return arxr.getMobileInfo();
  }
  
  public static int getMultiProcInt(String paramString, int paramInt)
  {
    return LocalMultiProcConfig.getInt(paramString, paramInt);
  }
  
  public static int getMultiProcInt4Uin(String paramString, int paramInt, long paramLong)
  {
    return LocalMultiProcConfig.getInt4Uin(paramString, paramInt, paramLong);
  }
  
  public static int getNetWorkType()
  {
    return jqc.getNetWorkType();
  }
  
  public static int getNetworkType()
  {
    return NetworkState.getNetworkType();
  }
  
  public static String getNickname(String paramString)
  {
    return BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramString);
  }
  
  /* Error */
  public static String getNickname(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 41	cooperation/qzone/video/QzoneLiveVideoInterface:friNickNameMap	Ljava/util/HashMap;
    //   3: aload_1
    //   4: invokevirtual 850	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   7: ifne +176 -> 183
    //   10: invokestatic 578	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13: invokevirtual 856	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   16: new 275	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 858
    //   26: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 864	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   39: iconst_3
    //   40: anewarray 527	java/lang/String
    //   43: dup
    //   44: iconst_0
    //   45: ldc_w 865
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: ldc_w 867
    //   54: aastore
    //   55: dup
    //   56: iconst_2
    //   57: ldc_w 869
    //   60: aastore
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokestatic 875	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore 6
    //   69: aload 6
    //   71: ifnull +100 -> 171
    //   74: aload 6
    //   76: astore_0
    //   77: aload 6
    //   79: invokeinterface 880 1 0
    //   84: ifeq +87 -> 171
    //   87: aload 6
    //   89: astore_0
    //   90: aload 6
    //   92: ldc_w 865
    //   95: invokeinterface 884 2 0
    //   100: istore_2
    //   101: aload 6
    //   103: astore_0
    //   104: aload 6
    //   106: ldc_w 867
    //   109: invokeinterface 884 2 0
    //   114: istore_3
    //   115: aload 6
    //   117: astore_0
    //   118: aload 6
    //   120: ldc_w 869
    //   123: invokeinterface 884 2 0
    //   128: istore 4
    //   130: aload 6
    //   132: astore_0
    //   133: aload 6
    //   135: iload_2
    //   136: invokeinterface 887 2 0
    //   141: astore 7
    //   143: aload 6
    //   145: astore_0
    //   146: aload 7
    //   148: invokestatic 659	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   151: ifeq +43 -> 194
    //   154: aload 6
    //   156: astore_0
    //   157: aload 6
    //   159: invokeinterface 890 1 0
    //   164: istore 5
    //   166: iload 5
    //   168: ifne -38 -> 130
    //   171: aload 6
    //   173: ifnull +10 -> 183
    //   176: aload 6
    //   178: invokeinterface 893 1 0
    //   183: getstatic 41	cooperation/qzone/video/QzoneLiveVideoInterface:friNickNameMap	Ljava/util/HashMap;
    //   186: aload_1
    //   187: invokevirtual 896	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   190: checkcast 527	java/lang/String
    //   193: areturn
    //   194: aload 6
    //   196: astore_0
    //   197: new 527	java/lang/String
    //   200: dup
    //   201: aload 7
    //   203: invokevirtual 900	java/lang/String:getBytes	()[B
    //   206: ldc_w 902
    //   209: invokespecial 905	java/lang/String:<init>	([BLjava/lang/String;)V
    //   212: invokestatic 910	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   215: astore 9
    //   217: aload 6
    //   219: astore_0
    //   220: aload 6
    //   222: iload_3
    //   223: invokeinterface 887 2 0
    //   228: astore 7
    //   230: aload 6
    //   232: astore_0
    //   233: aload 7
    //   235: invokestatic 659	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   238: ifne +71 -> 309
    //   241: aload 6
    //   243: astore_0
    //   244: new 527	java/lang/String
    //   247: dup
    //   248: aload 7
    //   250: invokevirtual 900	java/lang/String:getBytes	()[B
    //   253: ldc_w 902
    //   256: invokespecial 905	java/lang/String:<init>	([BLjava/lang/String;)V
    //   259: invokestatic 910	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   262: astore 7
    //   264: aload 6
    //   266: astore_0
    //   267: getstatic 41	cooperation/qzone/video/QzoneLiveVideoInterface:friNickNameMap	Ljava/util/HashMap;
    //   270: aload 9
    //   272: aload 7
    //   274: invokevirtual 914	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   277: pop
    //   278: goto -124 -> 154
    //   281: astore_1
    //   282: aload 6
    //   284: astore_0
    //   285: ldc 22
    //   287: iconst_2
    //   288: ldc_w 916
    //   291: aload_1
    //   292: invokestatic 919	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   295: aload 6
    //   297: ifnull +10 -> 307
    //   300: aload 6
    //   302: invokeinterface 893 1 0
    //   307: aconst_null
    //   308: areturn
    //   309: aload 6
    //   311: astore_0
    //   312: aload 6
    //   314: iload 4
    //   316: invokeinterface 887 2 0
    //   321: astore 7
    //   323: aload 6
    //   325: astore_0
    //   326: aload 7
    //   328: invokestatic 659	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   331: ifne -177 -> 154
    //   334: aload 6
    //   336: astore_0
    //   337: new 527	java/lang/String
    //   340: dup
    //   341: aload 7
    //   343: invokevirtual 900	java/lang/String:getBytes	()[B
    //   346: ldc_w 902
    //   349: invokespecial 905	java/lang/String:<init>	([BLjava/lang/String;)V
    //   352: invokestatic 910	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   355: astore 8
    //   357: aload 8
    //   359: astore 7
    //   361: aload 6
    //   363: astore_0
    //   364: aload 8
    //   366: invokevirtual 922	java/lang/String:length	()I
    //   369: iconst_1
    //   370: if_icmple +45 -> 415
    //   373: aload 8
    //   375: astore 7
    //   377: aload 6
    //   379: astore_0
    //   380: aload 8
    //   382: aload 8
    //   384: invokevirtual 922	java/lang/String:length	()I
    //   387: iconst_1
    //   388: isub
    //   389: invokevirtual 926	java/lang/String:charAt	(I)C
    //   392: bipush 10
    //   394: if_icmpne +21 -> 415
    //   397: aload 6
    //   399: astore_0
    //   400: aload 8
    //   402: iconst_0
    //   403: aload 8
    //   405: invokevirtual 922	java/lang/String:length	()I
    //   408: iconst_1
    //   409: isub
    //   410: invokevirtual 930	java/lang/String:substring	(II)Ljava/lang/String;
    //   413: astore 7
    //   415: aload 6
    //   417: astore_0
    //   418: getstatic 41	cooperation/qzone/video/QzoneLiveVideoInterface:friNickNameMap	Ljava/util/HashMap;
    //   421: aload 9
    //   423: aload 7
    //   425: invokevirtual 914	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   428: pop
    //   429: goto -275 -> 154
    //   432: astore 6
    //   434: aload_0
    //   435: astore_1
    //   436: aload 6
    //   438: astore_0
    //   439: aload_1
    //   440: ifnull +9 -> 449
    //   443: aload_1
    //   444: invokeinterface 893 1 0
    //   449: aload_0
    //   450: athrow
    //   451: astore_0
    //   452: aconst_null
    //   453: astore_1
    //   454: goto -15 -> 439
    //   457: astore_1
    //   458: aconst_null
    //   459: astore 6
    //   461: goto -179 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	paramString1	String
    //   0	464	1	paramString2	String
    //   100	36	2	i	int
    //   114	109	3	j	int
    //   128	187	4	k	int
    //   164	3	5	bool	boolean
    //   67	349	6	localCursor	android.database.Cursor
    //   432	5	6	localObject1	Object
    //   459	1	6	localObject2	Object
    //   141	283	7	localObject3	Object
    //   355	49	8	str1	String
    //   215	207	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   77	87	281	java/lang/Exception
    //   90	101	281	java/lang/Exception
    //   104	115	281	java/lang/Exception
    //   118	130	281	java/lang/Exception
    //   133	143	281	java/lang/Exception
    //   146	154	281	java/lang/Exception
    //   157	166	281	java/lang/Exception
    //   197	217	281	java/lang/Exception
    //   220	230	281	java/lang/Exception
    //   233	241	281	java/lang/Exception
    //   244	264	281	java/lang/Exception
    //   267	278	281	java/lang/Exception
    //   312	323	281	java/lang/Exception
    //   326	334	281	java/lang/Exception
    //   337	357	281	java/lang/Exception
    //   364	373	281	java/lang/Exception
    //   380	397	281	java/lang/Exception
    //   400	415	281	java/lang/Exception
    //   418	429	281	java/lang/Exception
    //   77	87	432	finally
    //   90	101	432	finally
    //   104	115	432	finally
    //   118	130	432	finally
    //   133	143	432	finally
    //   146	154	432	finally
    //   157	166	432	finally
    //   197	217	432	finally
    //   220	230	432	finally
    //   233	241	432	finally
    //   244	264	432	finally
    //   267	278	432	finally
    //   285	295	432	finally
    //   312	323	432	finally
    //   326	334	432	finally
    //   337	357	432	finally
    //   364	373	432	finally
    //   380	397	432	finally
    //   400	415	432	finally
    //   418	429	432	finally
    //   10	69	451	finally
    //   10	69	457	java/lang/Exception
  }
  
  public static int getNotchHeight(Activity paramActivity)
  {
    return awdo.a(BaseApplicationImpl.getContext(), paramActivity);
  }
  
  public static String getPluginID()
  {
    return avyo.GF();
  }
  
  public static String getPluginId()
  {
    return avyo.GF();
  }
  
  public static String getPluginVersion()
  {
    String str = avyo.GF();
    if (!str.equals("qzone_live_video_plugin.apk")) {
      avyi.a(getContext(), new awdy(str));
    }
    for (;;)
    {
      return version;
      version = "2013 3.4.4";
    }
  }
  
  public static String getQUA3()
  {
    return avpq.getQUA3();
  }
  
  public static int[] getRegion(Activity paramActivity, int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = (int)(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 0.7D);
    return new int[] { i, i * paramInt2 / paramInt1 };
  }
  
  public static String getSDKPrivatePath(String paramString)
  {
    return aqul.getSDKPrivatePath(paramString);
  }
  
  public static String getServerListCmdPrefix()
  {
    return ServerListProvider.getCmdPrefix();
  }
  
  public static SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString, paramInt);
  }
  
  public static String getStringConfig(String paramString1, String paramString2, String paramString3)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramString3);
  }
  
  public static long getSystemAvaialbeMemory()
  {
    return aqgz.getSystemTotalMemory() / 1048576L;
  }
  
  public static String getVersion()
  {
    return AppSetting.getVersion();
  }
  
  public static String getVersionForHabo()
  {
    return avpq.getVersionForHabo();
  }
  
  public static String getVideoPlayCacheDir()
  {
    return avsu.getVideoPlayCacheDir();
  }
  
  public static int getVipLevel()
  {
    return avqy.a().getVipLevel();
  }
  
  public static int getVipType()
  {
    return avqy.a().getVipType();
  }
  
  public static IWebviewWrapper getWebviewInstance(Context paramContext)
  {
    if (gLiveWebviewInstance == null) {}
    try
    {
      if (gLiveWebviewInstance == null) {
        gLiveWebviewInstance = new awib(getContext());
      }
      return gLiveWebviewInstance;
    }
    finally {}
  }
  
  public static boolean hasProxyParam(Uri paramUri)
  {
    return ardk.hasProxyParam(paramUri);
  }
  
  public static void impressionReport(String paramString)
  {
    tle.impressionReport(paramString);
  }
  
  public static void init(long paramLong)
  {
    avsu.nI(paramLong);
  }
  
  public static void initUpload() {}
  
  public static boolean isAnnualVip()
  {
    return avqy.a().isAnnualVip();
  }
  
  public static boolean isBestPerformanceDevice()
  {
    return avpw.isBestPerformanceDevice();
  }
  
  public static boolean isCPU64Bit()
  {
    return false;
  }
  
  public static boolean isDebugVersion()
  {
    return false;
  }
  
  public static boolean isFileExist(String paramString)
  {
    return aqhq.fileExists(paramString);
  }
  
  public static boolean isMobile()
  {
    return NetworkState.isMobile();
  }
  
  public static boolean isNetSupport()
  {
    return NetworkState.isNetSupport();
  }
  
  public static boolean isServerListDebug()
  {
    return ServerListProvider.isDebugEnable();
  }
  
  public static boolean isServerListFileExits()
  {
    return ServerListProvider.isServerFileExits();
  }
  
  public static boolean isValidUrl(String paramString)
  {
    return jqc.isValidUrl(paramString);
  }
  
  public static boolean isVideoInteractSupport()
  {
    avqw.a locala = avqw.b();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneLiveVideoInterface", 2, "isVideoInteractSupport " + locala.isAvailable());
    }
    return locala.isAvailable();
  }
  
  public static boolean isWifiConn()
  {
    return NetworkState.isWifiConn();
  }
  
  public static void launchLiveVideo(String paramString1, String paramString2, String paramString3)
  {
    if (QzoneConfig.getInstance().getConfig("LiveSetting", "LiveVideoFloatLayerEntry", 1) == 1)
    {
      if (supportLaunchLiveVideo())
      {
        paramString1 = Uri.parse("mqzonev2://arouse/livevideo?room=&uin=&nickname=&source=qq&version=1&type=1&syncuin=" + paramString1 + "&from=" + paramString3);
        paramString2 = new Intent();
        paramString2.setData(paramString1);
        paramString2.setPackage("com.qzone");
        paramString2.setFlags(268435456);
        BaseApplicationImpl.getContext().startActivity(paramString2);
        return;
      }
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = QzoneConfig.getInstance().getConfig("LiveSetting", "LiveVideoDuliDownload", "https://act.qzone.qq.com/meteor/ekko/prod/57512bc9fbd5ebd076552787/index.html?_wv=1");
      }
      paramString2 = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
      avpw.en(paramString2);
      paramString2.putExtra("url", paramString1);
      paramString2.putExtra("fromQZone", true);
      if (arap.sPluginNameSpaceHashMap.containsKey("Qzone")) {
        paramString2.putExtra("insertPluginsArray", new String[] { "Qzone" });
      }
      paramString2.setData(Uri.parse(paramString1));
      paramString2.addFlags(268435456);
      avpw.ay(paramString2);
      BaseApplicationImpl.getContext().startActivity(paramString2);
      return;
    }
    paramString1 = new Intent();
    paramString1.setClassName(BaseApplicationImpl.getContext(), getLiveVideoDownLoadClassName());
    paramString1.putExtra("mode", 1);
    paramString1.putExtra("from", paramString3);
    paramString1.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(paramString1);
  }
  
  public static boolean loadFilterSo(String paramString)
  {
    try
    {
      System.load(paramString);
      return true;
    }
    catch (Throwable paramString)
    {
      QLog.e("QzoneLiveVideoInterface", 1, "", paramString);
    }
    return false;
  }
  
  public static boolean loadNativeLibrary(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    return SoLoadUtil.loadNativeLibrary(paramContext, paramString, paramInt, paramBoolean);
  }
  
  public static Toast makeToast(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    return QQToast.a(BaseApplication.getContext(), paramInt1, paramCharSequence, paramInt2).create(paramInt3);
  }
  
  public static void onIORunningBackground() {}
  
  public static void openAIO(Activity paramActivity, String paramString)
  {
    Activity localActivity = paramActivity;
    if ((paramActivity instanceof BasePluginActivity)) {
      localActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    paramActivity = wja.a(new Intent(localActivity, SplashActivity.class), new int[] { 2 });
    paramActivity.putExtra("uin", paramString);
    paramActivity.putExtra("uintype", 0);
    paramActivity.addFlags(268435456);
    localActivity.startActivity(paramActivity);
  }
  
  public static void preInitWebview(awhx paramawhx)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QzoneLiveVideoInterface.3(paramawhx));
  }
  
  public static void preloadWebProcess()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("from", -1);
    localIntent.setAction("com.tencent.mobileqq.webprocess.preload_web_process");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    localIntent.putExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
  }
  
  public static void publishMood(String paramString, ArrayList<String> paramArrayList1, int paramInt1, int paramInt2, ArrayList<String> paramArrayList2, long paramLong, HashMap<String, String> paramHashMap)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.content", paramString);
    localBundle.putStringArrayList("param.images", paramArrayList1);
    localBundle.putInt("param.quality", paramInt1);
    localBundle.putInt("param.priv", paramInt2);
    localBundle.putStringArrayList("param.privList", paramArrayList2);
    localBundle.putLong("param.time", paramLong);
    localBundle.putSerializable("param.extMap", paramHashMap);
    avzf.a().a("cmd.publishMood", localBundle, false);
  }
  
  public static void reportMta(String paramString, HashMap<String, String> paramHashMap)
  {
    Properties localProperties = null;
    if (paramHashMap != null)
    {
      localProperties = new Properties();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        if (str1 != null)
        {
          String str2 = (String)paramHashMap.get(str1);
          if (str2 != null) {
            localProperties.setProperty(str1, str2);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneLiveVideoInterface", 2, "reportMta,key=" + paramString + ",value=" + localProperties);
    }
    anol.a(BaseApplicationImpl.getContext()).reportKVEvent(paramString, localProperties);
  }
  
  public static void reportToDC01245(LpReportInfo_dc01245 paramLpReportInfo_dc01245, boolean paramBoolean1, boolean paramBoolean2)
  {
    LpReportManager.getInstance().reportToDC01245(paramLpReportInfo_dc01245, paramBoolean1, paramBoolean2);
  }
  
  public static void sendEventToWebview(String paramString, JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("*.qq.com");
    aija.a(paramString, paramJSONObject, localArrayList, null);
  }
  
  public static void sharePictureToQzone(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramBundle == null))
    {
      QLog.i("QZLog", 1, "sharePictureToQzone failed !");
      return;
    }
    String str1 = paramBundle.getString("title");
    String str2 = paramBundle.getString("summary");
    String str3 = paramBundle.getString("screenshot_path");
    String str4 = paramBundle.getString("uin");
    paramBundle = paramBundle.getString("nickname");
    if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)))
    {
      QLog.i("QZLog", 1, "sharePictureToQzone failed ! picPath=" + str3 + " uin=" + str4);
      return;
    }
    avpw.d locald = avpw.d.a();
    locald.cMP = str4;
    locald.nickname = paramBundle;
    avpw.a(paramActivity, locald, str3, str1, str2, paramInt);
  }
  
  public static void shareToQQ(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Activity localActivity = paramActivity;
    if ((paramActivity instanceof BasePluginActivity)) {
      localActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    paramActivity = new Intent(localActivity, ForwardRecentActivity.class);
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString5)))
    {
      paramActivity.putExtra("forward_type", 1);
      paramActivity.putExtra("forward_thumb", paramString5);
      paramActivity.putExtra("key_flag_from_plugin", true);
    }
    for (;;)
    {
      localActivity.startActivity(paramActivity);
      return;
      paramActivity.putExtra("forward_type", 2);
      paramActivity.putExtra("req_type", 1);
      paramActivity.putExtra("req_share_id", Long.parseLong("1103584836"));
      paramActivity.putExtra("title", paramString1);
      paramActivity.putExtra("image_url_remote", paramString3);
      paramActivity.putExtra("desc", paramString2);
      paramActivity.putExtra("detail_url", paramString4);
    }
  }
  
  public static void shareToQzone(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    QZoneShareData localQZoneShareData = new QZoneShareData();
    localQZoneShareData.mTitle = paramString1;
    localQZoneShareData.mSummary = paramString2;
    localQZoneShareData.ER = new ArrayList();
    localQZoneShareData.ER.add(paramString3);
    localQZoneShareData.targetUrl = paramString4;
    localQZoneShareData.from = 0;
    localQZoneShareData.cMX = paramString5;
    avqq.a(paramContext, paramString5, localQZoneShareData, null, paramInt);
  }
  
  public static void showToast(String paramString, int paramInt)
  {
    QQToast.a(BaseApplicationImpl.getContext(), paramInt, paramString, 1).show();
  }
  
  public static void showToastInQZone(CharSequence paramCharSequence)
  {
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("param.toastText", paramCharSequence);
    avzf.a().a("cmd.showToast", localBundle, false);
  }
  
  public static void startAlbumListActivity(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = getRegion((Activity)paramContext, paramInt1, paramInt2);
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mobileqq", NewPhotoListActivity.class.getName());
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramContext.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.TARGET_PATH", paramString);
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", arrayOfInt[0]);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", arrayOfInt[1]);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt1);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt2);
    localIntent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", true);
    localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.qzone.cover.ui.activity");
    paramContext.startActivity(localIntent);
  }
  
  public static void startEcLiveFromFloat(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    for (boolean bool = ((Boolean)paramVarArgs[0]).booleanValue();; bool = true)
    {
      if (paramBoolean)
      {
        if (bool) {}
        for (i = 3;; i = 1)
        {
          wgv.a(paramContext, paramString3, paramString2, 2, i);
          return;
        }
      }
      if (bool) {}
      for (int i = 3;; i = 1)
      {
        wgv.c(paramContext, paramString1, paramString2, paramString3, "", i);
        return;
      }
    }
  }
  
  public static void startInspect(Object paramObject, long paramLong)
  {
    MagnifierSDK.a().a().startInspect(paramObject, String.format("%d", new Object[] { Long.valueOf(paramLong) }));
  }
  
  public static void startLiveVideoFloatService(Context paramContext, String paramString, Bundle paramBundle, ServiceConnection paramServiceConnection)
  {
    QZoneLiveVideoPluginScreenRecordProxyService.startLiveVideoFloatService(paramContext, paramString, paramBundle, paramServiceConnection);
  }
  
  public static void startPhotoCropActivity(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    int[] arrayOfInt = getRegion((Activity)paramContext, paramInt1, paramInt2);
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mobileqq", PhotoCropActivity.class.getName());
    localIntent.putExtra("fromWhereClick", 10);
    localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramContext.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("PhotoConst.TARGET_PATH", paramString2);
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", arrayOfInt[0]);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", arrayOfInt[1]);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt1);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt2);
    localIntent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", true);
    localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.qzone.cover.ui.activity");
    paramContext.startActivity(localIntent);
  }
  
  public static void startProfileActivy(Context paramContext, String paramString)
  {
    paramContext = new ProfileActivity.AllInOne(paramString, 1);
    paramContext.bJa = 61;
    ProfileActivity.b(BaseApplicationImpl.getContext().getBaseContext(), paramContext);
  }
  
  public static void startSelectMemberForResult(Context paramContext, Intent paramIntent, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.setClassName("com.tencent.mobileqq", SelectMemberActivity.class.getName());
    if (paramContext != null) {
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
    }
  }
  
  public static void startWebSoRequest(String paramString, Handler paramHandler)
  {
    WebSoService.a().a(paramString, paramHandler);
  }
  
  public static void startWebSoRequestWithCheck(String paramString, Handler paramHandler)
  {
    WebSoService.a().startWebSoRequestWithCheck(paramString, paramHandler);
  }
  
  public static boolean supportLaunchLiveVideo()
  {
    boolean bool2 = false;
    Object localObject = null;
    try
    {
      PackageInfo localPackageInfo = BaseApplicationImpl.getContext().getPackageManager().getPackageInfo("com.qzone", 0);
      localObject = localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label20:
      boolean bool1;
      break label20;
    }
    bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (localObject.versionCode >= 91) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveVideoInterface
 * JD-Core Version:    0.7.0.1
 */