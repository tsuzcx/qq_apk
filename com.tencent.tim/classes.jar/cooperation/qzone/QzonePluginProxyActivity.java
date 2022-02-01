package cooperation.qzone;

import acfp;
import ahyh;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.CheckBox;
import anpf;
import aqha;
import aqju;
import aqnm;
import avpw;
import avrl;
import avrm;
import avrn;
import avro;
import avsj;
import avyo;
import awcz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.pluginsdk.IPluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.exception.QZoneStartupFailException;
import java.util.Iterator;
import java.util.List;

public class QzonePluginProxyActivity
  extends PluginProxyFragmentActivity
  implements QzoneJumpQBrowserInterface
{
  public static volatile ClassLoader f;
  private static final String[] iW = { "com.qzone.preview.QzonePictureViewer", "com.qzone.preview.LocalPictureViewer", "com.qzone.preview.QZonePanoramaActivity", "com.qzone.preview.QzonePictureSelectViewer" };
  private static final String[] iX = { "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity", "com.qzone.common.activities.QzoneAdaptVideoActivity", "com.qzone.log.CrashNotificationActivity", "com.qzone.common.activities.NotificationActivity", "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity", "com.qzone.misc.web.QZoneTranslucentActivity", "com.qzone.misc.web.QZoneTranslucentActivity2", "com.qzone.bulletscreen.BulletScreenActivity", "com.qzone.album.business.dlna.activity.DLNAActivity", "com.qzone.bulletscreen.BulletScreenActivity", "com.qzone.common.activities.base.QzoneGiftPanelActivity", "com.qzone.common.activities.QzoneDualWarmActivity" };
  private avsj a = new avsj();
  private TopGestureLayout g;
  
  public static String Gg()
  {
    return "qzone_plugin.apk";
  }
  
  public static ClassLoader a()
  {
    return f;
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    a(paramActivity, paramString, paramIntent, paramInt, null, true, null, paramBoolean);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    a(paramContext, paramString, paramIntent, paramInt, null);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt, ahyh paramahyh)
  {
    a(paramContext, paramString, paramIntent, paramInt, null, true, paramahyh, false);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    a(paramContext, paramString, paramIntent, paramInt, paramOnDismissListener, paramBoolean, null, false);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean1, ahyh paramahyh, boolean paramBoolean2)
  {
    b(paramContext, paramString, paramIntent, paramInt, paramOnDismissListener, paramBoolean1, paramahyh, paramBoolean2);
  }
  
  public static boolean aLs()
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
          QLog.d("QzonePluginProxyActivity", 2, "QzoneProcess is exist");
        }
        return true;
      }
    }
    return false;
  }
  
  private static void b(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean1, ahyh paramahyh, boolean paramBoolean2)
  {
    if ((avpw.dnL) && ((paramContext instanceof SplashActivity)))
    {
      paramInt = LocalMultiProcConfig.getInt("qzapp_vercode", 84);
      if (!LocalMultiProcConfig.getBool("qz_safe_mode_no_tip", false))
      {
        paramContext = aqha.b(paramContext, 230, 2131562734, acfp.m(2131713270), "空间出问题了，启用空间保护模式点\"确定\"；点击\"取消\"，保护模式不会生效。", acfp.m(2131713278), acfp.m(2131713267), new avrl(paramContext, paramInt, paramString, paramIntent), new avrm());
        ((CheckBox)paramContext.findViewById(2131365901)).setOnCheckedChangeListener(new avrn());
        paramContext.show();
      }
      while (avpw.a(paramContext, paramInt, Long.valueOf(paramString).longValue(), "com.qzonex.app.tab.QZoneTabActivity")) {
        return;
      }
      avpw.p(paramIntent.getStringExtra("sid"), paramContext);
      return;
    }
    if ((paramContext instanceof FriendProfileCardActivity)) {
      anpf.a().Rf(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "launchPluingActivityForResult.isPluginInstalled start， showProgressDialog：" + paramBoolean1);
    }
    avpw.a(paramBoolean1, new avro(paramIntent, paramString, paramahyh, paramInt, paramBoolean2, paramContext, paramOnDismissListener));
  }
  
  public static ClassLoader c(Context paramContext)
    throws Exception
  {
    f = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_plugin.apk");
    return f;
  }
  
  public static ClassLoader d(Context paramContext)
    throws Exception
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "Photoplus.apk");
  }
  
  private static boolean d(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private void dismissPluginLoading()
  {
    Intent localIntent = new Intent("action_launch_completed");
    String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "FriendFeed", "好友动态");
    localIntent.putExtra("plugin_apk", this.mPluginID);
    localIntent.putExtra("plugin_name", str);
    sendBroadcast(localIntent);
  }
  
  public static ClassLoader e(Context paramContext)
    throws Exception
  {
    ClassLoader localClassLoader = null;
    String str = avyo.GF();
    if (str.equals("qzone_live_video_plugin_hack.apk")) {
      localClassLoader = PluginStatic.getOrCreateClassLoader(paramContext, str);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("patch", 2, "getQzoneLiveClassLoader classsloader: " + localClassLoader);
      }
      return localClassLoader;
      if (str.equals("qzone_live_video_plugin.apk")) {
        localClassLoader = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_live_video_plugin.apk");
      }
    }
  }
  
  public static void eh(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.putBoolean("cleartop", true);
    paramBundle.putBoolean("PhotoConst.IS_CALL_IN_PLUGIN", true);
    paramBundle.putString("PhotoConst.PLUGIN_NAME", "QZone");
    paramBundle.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
  }
  
  public static ClassLoader f(Context paramContext)
    throws Exception
  {
    paramContext = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_vertical_video_plugin.apk");
    if (QLog.isColorLevel()) {
      QLog.i("patch", 2, "getQzoneVerticalVideoClassLoader classsloader: " + paramContext);
    }
    return paramContext;
  }
  
  public static ClassLoader g(Context paramContext)
    throws Exception
  {
    paramContext = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_weishi_feeds_plugin.apk");
    if (QLog.isColorLevel()) {
      QLog.i("patch", 2, "getQzoneWeishiFeedsClassLoader classsloader: " + paramContext);
    }
    return paramContext;
  }
  
  public static String i(Intent paramIntent)
  {
    return paramIntent.getStringExtra("qzone_plugin_activity_name");
  }
  
  public static void x(Intent paramIntent, String paramString)
  {
    paramIntent.putExtra("qzone_plugin_activity_name", paramString);
  }
  
  public IPluginActivity a()
  {
    return this.mPluginActivity;
  }
  
  public String getPluginID()
  {
    return "qzone_plugin.apk";
  }
  
  public int getPluginResType()
  {
    return 1;
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return a.g(paramString);
  }
  
  public int getThemeResId()
  {
    return 0;
  }
  
  public avsj getWatchActivityManager()
  {
    return this.a;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    aqnm.resetScreenSize();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.g = new QZoneTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.g);
    }
    if ((!TextUtils.isEmpty(this.mCreateErrorInfo)) && (!this.mCreateErrorInfo.equals("success")))
    {
      if (paramBundle != null) {}
      for (;;)
      {
        paramBundle = paramBundle.getString("pluginsdk_launchActivity");
        localObject = new StringBuffer(acfp.m(2131713280));
        ((StringBuffer)localObject).append(paramBundle).append(" ").append(this.mCreateErrorInfo);
        QLog.e("QZLog", 1, ((StringBuffer)localObject).toString());
        awcz.h(new QZoneStartupFailException(this.mCreateErrorInfo), acfp.m(2131713271) + getPluginActivity());
        dismissPluginLoading();
        return;
        paramBundle = getIntent().getExtras();
      }
    }
    Object localObject = getIntent().getExtras();
    if (localObject != null)
    {
      paramBundle = ((Bundle)localObject).getString("from_plugin");
      localObject = ((Bundle)localObject).getString("uin");
      getIntent().putExtra("from_plugin", "");
      if ((!TextUtils.isEmpty(paramBundle)) && (paramBundle.equals("QZoneVideoPlugin"))) {
        a(this, (String)localObject, getIntent(), 1000);
      }
    }
    this.a.onCreate(this);
  }
  
  public void onDestroy()
  {
    this.a.onDestroy();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    this.a.b(paramInt, paramKeyEvent);
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }
  
  public void onResume()
  {
    super.onResume();
    this.a.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.onStop();
  }
  
  public boolean shouldHandleStartPluginFailed(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    label60:
    do
    {
      do
      {
        return false;
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", "PluginPermissionErrorHandle", 1) != 0) {}
        int j;
        for (i = 1;; i = 0)
        {
          j = QzoneConfig.getInstance().getConfig("QZoneSetting", "PluginErrorHandleCount", -1);
          if (j != 0) {
            break label60;
          }
          if (i == 0) {
            break;
          }
          return super.shouldHandleStartPluginFailed(paramString);
        }
        paramString = paramString.toLowerCase();
        if (!paramString.contains("classnotfoundexception")) {
          break;
        }
        SharedPreferences localSharedPreferences = getSharedPreferences("Qz_setting", 0);
        int k = localSharedPreferences.getInt("Crash_Count_In_CNFException", 0);
        localSharedPreferences.edit().putInt("Crash_Count_In_CNFException", k + 1).commit();
        if (k == 0)
        {
          QLog.e("Plugin", 1, "kill process with first Exception:" + paramString);
          finish();
          Process.killProcess(Process.myPid());
        }
        for (;;)
        {
          return true;
          if ((j >= 0) && (k >= j)) {
            break;
          }
          QLog.e("Plugin", 1, "show dialog with non-first Exception:" + paramString);
          showNeedUninstanllAndInstallDialog();
        }
      } while (i == 0);
      return super.shouldHandleStartPluginFailed(paramString);
    } while (i == 0);
    return super.shouldHandleStartPluginFailed(paramString);
  }
  
  public static class a
  {
    public static Class<? extends PluginProxyActivity> g(String paramString)
    {
      if (QzonePluginProxyActivity.e(QzonePluginProxyActivity.iW, paramString)) {
        return QzonePicturePluginProxyActivity.class;
      }
      if (QzonePluginProxyActivity.e(QzonePluginProxyActivity.l(), paramString)) {
        return QzoneTransNoTitlePluginProxyActivity.class;
      }
      if ("com.qzone.common.activities.FeedActionPanelActivity".equals(paramString)) {
        return QzoneTransWithKeyboardPluginProxyActivity.class;
      }
      if ("com.qzone.common.activities.QZoneRapidCommentActivity".equals(paramString)) {
        return QzoneTransNoTitlePluginProxyActivity.class;
      }
      if ("com.qzone.face.ui.QzoneMarkFaceActivity".equals(paramString)) {
        return QzonePictureExtPluginProxyActivity.class;
      }
      if (("com.qzone.preview.QZoneVideoFloatActivity".equals(paramString)) || ("com.qzone.preview.QZoneAdvertiseVideoFloatActivity".equals(paramString)) || ("com.qzone.preview.QZoneEncourageAdvActivity".equals(paramString)) || ("com.qzone.preview.VideoPlayerActivity".equals(paramString)) || ("com.qzone.commoncode.module.videorecommend.ui.QzoneVideoFullscreenRecommendActivity".equals(paramString))) {
        return QzoneOrientationPluginProxyActivity.class;
      }
      if ("com.qzone.commoncode.module.videorecommend.ui.QzoneVideoRecommendActivity".equals(paramString)) {
        return QzoneTranslucentGPUPluginProxyActivity.class;
      }
      if ("com.qzone.video.activity.TrimVideoActivity".equals(paramString)) {
        return QzoneNOGPUPluginProxyActivity.class;
      }
      if ("com.qzone.video.activity.PreviewVideoActivity".equals(paramString)) {
        return QzoneNOGPUPluginProxyActivity.class;
      }
      if ("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity".equals(paramString)) {
        return QzonePublishMoodProxyActivity.class;
      }
      if ("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity".equals(paramString)) {
        return QzonePublishMoodProxyActivity.class;
      }
      if ("com.qzone.publish.ui.activity.QzonePublishSecretShuoShuoH5Activity".equals(paramString)) {
        return QzonePublishMoodProxyActivity.class;
      }
      if ("com.qzone.feed.ui.activity.QZoneFriendFeedActivity".equals(paramString)) {
        return QzoneFeedsPluginProxyActivity.class;
      }
      if ("com.qzone.common.activities.QzoneDialogActivity".equals(paramString)) {
        return QzoneFullscreenPluginProxyActivity.class;
      }
      if ("com.qzone.feed.ui.activity.QZoneExtendFeedActiviy".equals(paramString)) {
        return QzoneTranslucentGPUPluginProxyActivity.class;
      }
      if ("com.qzone.feed.ui.activity.QZoneExtendLiveCollectActivity".equals(paramString)) {
        return QzoneTranslucentGPUPluginProxyActivity.class;
      }
      if ("com.qzone.publish.ui.activity.QQPublicAccountPublishFeedActivity".equals(paramString)) {
        return QzonePublishMoodProxyActivity.class;
      }
      if ("com.tencent.qcircle.QCirclePublishFeedActivity".equals(paramString)) {
        return QzonePublishMoodProxyActivity.class;
      }
      return QzoneGPUPluginProxyActivity.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */