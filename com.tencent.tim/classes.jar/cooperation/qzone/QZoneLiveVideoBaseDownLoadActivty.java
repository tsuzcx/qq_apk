package cooperation.qzone;

import acfp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import aqiw;
import arlc;
import avqb;
import avqc;
import avqd;
import avqe;
import awed;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import cooperation.qzone.video.QzoneLiveVideoPluginProxyActivity;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public abstract class QZoneLiveVideoBaseDownLoadActivty
  extends BaseActivity
{
  private String Eq;
  private String FZ;
  private String Ns;
  private boolean aJq;
  protected String account;
  private String bXL;
  private String cMQ;
  private String cMR;
  private String cMS;
  private String cMT;
  private String cMU;
  private String cMV;
  private View.OnClickListener cancelInstallListener = new avqe(this);
  protected boolean dnS;
  protected boolean dnT;
  private boolean dnU;
  private boolean dnV;
  private boolean dnW;
  protected int exT;
  private long hg;
  private View.OnClickListener installListener = new avqd(this);
  protected String mBackupUrl;
  private TextView mBtnAction;
  private ImageView mBtnClose;
  private String mCurrentUin;
  private ViewGroup mDownloadRoot;
  private ProgressBar mDownloadingBar;
  public Handler mHandler = new avqb(this);
  public boolean mInstalling;
  public volatile boolean mIsCanceled;
  protected boolean mIsInstallTimeout;
  private AtomicBoolean mIsUIInited = new AtomicBoolean(false);
  protected long mLaunchTime;
  private ImageView mLiveVideoImgIv;
  public int mMode;
  protected BroadcastReceiver mReceiver;
  private TextView mTxtPluginSize;
  private URLDrawable mURLDrawable;
  private View mWaitingView;
  private int progress;
  protected int retryDownloadNum;
  
  private boolean aLo()
  {
    return Build.VERSION.SDK_INT > 20;
  }
  
  protected abstract String Ge();
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (!a(paramPluginBaseInfo)) {
      return;
    }
    switch (paramPluginBaseInfo.mState)
    {
    case -1: 
    default: 
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "handlePluginInfo, STATE=" + paramPluginBaseInfo.mState);
      return;
    case 0: 
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_NODOWNLOAD");
    case 1: 
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_DOWNLOADING");
    case 2: 
      handleDownloadPlugin(paramPluginBaseInfo);
      return;
    case 3: 
    case 5: 
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, state=" + paramPluginBaseInfo.mState);
      this.mHandler.sendEmptyMessageDelayed(1005, 500L);
      return;
    case 4: 
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_INSTALLED");
      eBy();
      return;
    }
    QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_ERROR");
    this.mHandler.sendEmptyMessage(1003);
  }
  
  protected boolean a(PluginBaseInfo paramPluginBaseInfo)
  {
    return paramPluginBaseInfo != null;
  }
  
  public boolean aLn()
  {
    if (getAppRuntime() != null) {
      this.account = getAppRuntime().getAccount();
    }
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "intent is null");
      Toast.makeText(getApplicationContext(), acfp.m(2131713145), 1).show();
      awed.ad(this.account, "live_video_entry", "6", null);
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", 0.0D, 3, "0");
      finish();
      return false;
    }
    this.mMode = localIntent.getIntExtra("mode", 0);
    this.mLaunchTime = localIntent.getLongExtra("launch_time", System.currentTimeMillis());
    if ((3 != this.mMode) && (1 != this.mMode))
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "mode invalid, mMode=" + this.mMode);
      Toast.makeText(getApplicationContext(), acfp.m(2131713147) + this.mMode, 1).show();
      awed.ad(this.account, "live_video_entry", "6", null);
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.mLaunchTime) / 1000.0D, 3, this.mMode + "");
      finish();
      return false;
    }
    if (!aqiw.isNetworkAvailable(getApplicationContext()))
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "onCreate, no network available");
      QQToast.a(this, acfp.m(2131713151), 0).show();
      if (this.mMode == 1) {
        awed.ad(this.account, "live_video_entry", "2", null);
      }
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.mLaunchTime) / 1000.0D, 4, this.mMode + "");
      finish();
      return false;
    }
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && (((QQAppInterface)localAppRuntime).bF()))
    {
      QQToast.a(this, acfp.m(2131713155), 0).show();
      if (this.mMode == 1) {
        awed.ad(this.account, "live_video_entry", "7", null);
      }
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.mLaunchTime) / 1000.0D, 2, this.mMode + ",1");
      finish();
      return false;
    }
    this.mBackupUrl = localIntent.getStringExtra("backup");
    this.Ns = localIntent.getStringExtra("room_id");
    this.mCurrentUin = localIntent.getStringExtra("current_uin");
    QLog.d("QZoneLiveVideoBaseDownLoadActivty", 1, "mRoomId=" + this.Ns + ", mBackUrl=" + this.mBackupUrl + ", mCurrentUin=" + this.mCurrentUin);
    this.hg = localIntent.getLongExtra("host_uin", 0L);
    this.cMQ = localIntent.getStringExtra("video_play_source");
    this.cMR = localIntent.getStringExtra("feeds_type");
    this.cMS = localIntent.getStringExtra("shuo_id");
    this.bXL = localIntent.getStringExtra("repost_uin");
    this.FZ = localIntent.getStringExtra("video_play_scene");
    this.Eq = localIntent.getStringExtra("entranceReferId");
    this.cMT = localIntent.getStringExtra("realFrom");
    this.dnU = localIntent.getBooleanExtra("stopLive", false);
    this.dnV = localIntent.getBooleanExtra("enterScreenRecord", false);
    this.dnW = localIntent.getBooleanExtra("isFromGame", false);
    this.aJq = localIntent.getBooleanExtra("isVertical", true);
    this.cMU = localIntent.getStringExtra("gamePackgeName");
    this.cMV = localIntent.getStringExtra("invitefriend_opuin");
    return true;
  }
  
  public void cancelInstall()
  {
    this.mInstalling = false;
  }
  
  public void cw()
  {
    finish();
  }
  
  protected void eBA() {}
  
  protected void eBy()
  {
    if (this.mIsCanceled)
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "launch has canceled");
      return;
    }
    if (this.mDownloadRoot != null) {
      this.mDownloadRoot.setVisibility(8);
    }
    if (this.mWaitingView != null) {
      this.mWaitingView.setVisibility(0);
    }
    String str1 = "";
    if (getAppRuntime() != null) {
      str1 = getAppRuntime().getAccount();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "launchLiveVideo, account=" + str1);
      }
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      QQToast.a(this, acfp.m(2131713135), 0).show();
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.mLaunchTime) / 1000.0D, 6, this.mMode + "");
      cw();
      return;
      if (!TextUtils.isEmpty(this.mCurrentUin))
      {
        QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "launchLiveVideo, getAppRuntime is null");
        str1 = this.mCurrentUin;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("room_id", this.Ns);
    localIntent.putExtra("mode", this.mMode);
    localIntent.putExtra("video_play_source", this.cMQ);
    localIntent.putExtra("feeds_type", this.cMR);
    localIntent.putExtra("shuo_id", this.cMS);
    localIntent.putExtra("repost_uin", this.bXL);
    localIntent.putExtra("video_play_scene", this.FZ);
    localIntent.putExtra("entranceReferId", this.Eq);
    localIntent.putExtra("launch_time", this.mLaunchTime);
    localIntent.putExtra("realFrom", this.cMT);
    localIntent.putExtra("stopLive", this.dnU);
    localIntent.putExtra("enterScreenRecord", this.dnV);
    localIntent.putExtra("isFromGame", this.dnW);
    localIntent.putExtra("isVertical", this.aJq);
    localIntent.putExtra("gamePackgeName", this.cMU);
    localIntent.putExtra("invitefriend_opuin", this.cMV);
    String str3 = "com.qzone.adapter.livevideo.QZoneLiveVideoActivity";
    String str2 = str3;
    if (getIntent() != null)
    {
      Boolean localBoolean = Boolean.valueOf(getIntent().getBooleanExtra("isEcLive", false));
      localIntent.putExtra("isEcLive", localBoolean);
      str2 = str3;
      if (localBoolean.booleanValue())
      {
        if (!aLo()) {
          break label704;
        }
        localIntent.putExtra("ec_uin", getIntent().getStringExtra("ec_uin"));
        localIntent.putExtra("ec_room_type", getIntent().getIntExtra("ec_room_type", 0));
        localIntent.putExtra("ec_room_id", getIntent().getStringExtra("ec_room_id"));
        localIntent.putExtra("ec_room_owner_id", getIntent().getStringExtra("ec_room_owner_id"));
        localIntent.putExtra("ec_room_from_type", getIntent().getIntExtra("ec_room_from_type", 0));
        localIntent.putExtra("ec_room_part_flags", getIntent().getIntExtra("ec_room_part_flags", 0));
        localIntent.putExtra("ec_room_create_name", getIntent().getStringExtra("ec_room_create_name"));
        localIntent.putExtra("ec_room_init_type", getIntent().getIntExtra("ec_room_init_type", 1));
        localIntent.putExtra("ec_room_is_owner", getIntent().getBooleanExtra("ec_room_is_owner", false));
        localIntent.putExtra("ec_title", getIntent().getStringExtra("ec_title"));
        localIntent.putExtra("ec_content", getIntent().getStringExtra("ec_content"));
      }
    }
    for (str2 = "com.qzone.adapter.livevideo.ECLiveVideoActivity";; str2 = str3)
    {
      QzoneLiveVideoPluginProxyActivity.a(this, str1, localIntent, -1, str2);
      arlc.b(BaseApplicationImpl.getContext(), false, 5);
      return;
      label704:
      QQToast.a(this, acfp.m(2131713133), 0).show();
      cw();
    }
  }
  
  public void eBz()
  {
    if (this.mMode == 1)
    {
      eBA();
      return;
    }
    eBy();
  }
  
  protected void handleDownloadPlugin(PluginBaseInfo paramPluginBaseInfo)
  {
    if (this.mIsUIInited.get())
    {
      int i = (int)(paramPluginBaseInfo.mDownloadProgress * 100.0F);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_DOWNLOADING, progress=" + i);
      }
      if (i <= 0) {
        break label102;
      }
      this.mHandler.removeMessages(1006);
      this.mHandler.obtainMessage(1004, i, 0).sendToTarget();
      updateTextProgress(false, false);
    }
    for (;;)
    {
      this.mHandler.sendEmptyMessageDelayed(1005, 500L);
      return;
      label102:
      if (this.mIsInstallTimeout)
      {
        this.mHandler.removeMessages(1006);
        updateTextProgress(true, false);
      }
    }
  }
  
  public void initUI(int paramInt)
  {
    this.mWaitingView.setVisibility(8);
    this.mDownloadRoot.setVisibility(0);
    this.mTxtPluginSize = ((TextView)findViewById(2131373425));
    this.mDownloadingBar = ((ProgressBar)findViewById(2131366091));
    this.mBtnAction = ((TextView)findViewById(2131363764));
    this.mBtnClose = ((ImageView)findViewById(2131363823));
    this.mLiveVideoImgIv = ((ImageView)findViewById(2131376157));
    Boolean localBoolean = Boolean.valueOf(false);
    if (getIntent() != null) {
      localBoolean = Boolean.valueOf(getIntent().getBooleanExtra("isEcLive", false));
    }
    if (localBoolean.booleanValue())
    {
      this.mLiveVideoImgIv.setVisibility(8);
      this.mBtnClose.setOnClickListener(this.cancelInstallListener);
      if (paramInt != 0) {
        break label239;
      }
      this.mBtnAction.setText(acfp.m(2131713142));
    }
    for (;;)
    {
      for (;;)
      {
        this.mBtnAction.setOnClickListener(this.installListener);
        return;
        this.mLiveVideoImgIv.setVisibility(0);
        try
        {
          this.mURLDrawable = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_live_video_download_bg.png", null);
          if (this.mURLDrawable == null) {
            break;
          }
          this.mLiveVideoImgIv.setImageDrawable(this.mURLDrawable);
          this.mURLDrawable.setURLDrawableListener(new avqc(this));
        }
        catch (Exception localException)
        {
          QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "initUI", localException);
        }
      }
      break;
      label239:
      this.mBtnAction.setText(acfp.m(2131713149));
    }
  }
  
  public void installPlugin()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "installPlugin");
    }
    this.mIsInstallTimeout = false;
    this.mInstalling = true;
    Message localMessage = Message.obtain();
    localMessage.what = 1000;
    localMessage.arg1 = 0;
    this.mHandler.sendMessage(localMessage);
    int i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginInstallTimeout", 60000);
    this.mHandler.sendEmptyMessageDelayed(1006, i);
  }
  
  protected abstract void installPluginSilence();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.mDrawStatus = false;
    }
    setContentView(2131562565);
    this.mDownloadRoot = ((ViewGroup)findViewById(2131366099));
    this.mWaitingView = findViewById(2131382105);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mHandler.removeMessages(1005);
    this.mHandler.removeMessages(1006);
    if (this.mReceiver != null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 1, "unregisterReceiver");
      }
      unregisterReceiver(this.mReceiver);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "", localException);
      }
    }
    this.mReceiver = null;
  }
  
  public void onHandleMessage(Handler paramHandler, Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "MSG_INIT_UI, mIsUIInited=" + this.mIsUIInited);
        }
        if (!this.mIsUIInited.get())
        {
          initUI(paramMessage.arg1);
          this.mIsUIInited.set(true);
        }
        paramHandler.sendEmptyMessage(1005);
        return;
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "MSG_QUERY_PLUGIN_STATE");
      } while (isFinishing());
      paramHandler = queryPlugin(Ge());
      a(Ge(), paramHandler);
      return;
      updateProgress(paramMessage.arg1);
      return;
      this.mInstalling = false;
      int i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadTimes", 1);
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "MSG_INSTALL_PLUGIN_ERROR, retryDownloadNum=" + this.retryDownloadNum);
      if (this.retryDownloadNum < i)
      {
        this.retryDownloadNum += 1;
        installPlugin();
        return;
      }
      this.mIsInstallTimeout = true;
      this.mInstalling = false;
      updateTextProgress(true, false);
      return;
      this.mIsInstallTimeout = true;
      this.mInstalling = false;
      return;
      this.dnS = false;
      i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadSoTimes", 1);
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "MSG_DOWNLOAD_SO_ERROR, retryDownloadSoNum=" + i);
      if (this.exT < i)
      {
        this.exT += 1;
        eBA();
        return;
      }
      this.dnT = true;
      this.dnS = false;
      updateTextProgress(true, true);
      return;
      this.dnT = true;
      this.dnS = false;
      return;
    } while (!(paramMessage.obj instanceof String));
    paramHandler.removeMessages(1006);
    paramHandler.removeMessages(1005);
    paramHandler.removeMessages(1004);
    this.mBtnAction.setText((String)paramMessage.obj);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (4 == paramInt) {
      this.mIsCanceled = true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected abstract PluginBaseInfo queryPlugin(String paramString);
  
  protected void updateProgress(int paramInt)
  {
    if (this.mDownloadingBar != null) {
      this.mDownloadingBar.setProgress(paramInt);
    }
  }
  
  public void updateTextProgress(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mBtnAction == null) {
      return;
    }
    if (paramBoolean1)
    {
      this.mBtnAction.setText(acfp.m(2131713141));
      return;
    }
    if (paramBoolean2)
    {
      this.mBtnAction.setText(acfp.m(2131713152));
      return;
    }
    this.progress %= 3;
    switch (this.progress)
    {
    }
    for (;;)
    {
      this.progress += 1;
      return;
      this.mBtnAction.setText(acfp.m(2131713134));
      continue;
      this.mBtnAction.setText(acfp.m(2131713143));
      continue;
      this.mBtnAction.setText(acfp.m(2131713146));
    }
  }
  
  public class LaunchCompletedObserver
    extends BroadcastReceiver
  {
    private String mPluginID;
    private String mPluginName;
    
    public LaunchCompletedObserver(String paramString1, String paramString2)
    {
      this.mPluginName = paramString1;
      this.mPluginID = paramString2;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getStringExtra("plugin_apk");
      paramIntent = paramIntent.getStringExtra("plugin_name");
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 1, "LaunchCompletedObserver.onReceive: " + paramContext + ", " + paramIntent);
      }
      if ((this.mPluginID.equalsIgnoreCase(paramContext)) && (paramIntent != null)) {
        QZoneLiveVideoBaseDownLoadActivty.this.cw();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty
 * JD-Core Version:    0.7.0.1
 */