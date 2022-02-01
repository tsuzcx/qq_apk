package com.tencent.qqlive.module.videoreport.report;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.IAdditionalReportListener;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.ISessionChangeListener;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.SessionChangeReason;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import com.tencent.qqlive.module.videoreport.utils.SPUtils;
import com.tencent.qqlive.module.videoreport.utils.ThreadUtils;
import java.util.HashSet;
import java.util.Random;

public class AppEventReporter
  extends DefaultEventListener
{
  private static final String TAG = "AppEventReporter";
  private int mActivityCount = 0;
  private final HashSet<Integer> mActivityHashCode = new HashSet();
  private boolean mAppForegroundReported = false;
  private long mAppForegroundTime;
  private IAdditionalReportListener mEventAdditionalReport;
  private boolean mFirstActivityResumed = false;
  private boolean mIsColdStart = true;
  private boolean mIsNeedInterceptForegroundSession = false;
  private long mLastGenerateTime = -1L;
  private final ListenerMgr<IAppEventListener> mListenerMgr = new ListenerMgr();
  private boolean mNoForegroundActivity = true;
  private final ListenerMgr<ISessionChangeListener> mSessionChangeListener = new ListenerMgr();
  private String mUsId = "";
  private long mUsStamp = System.currentTimeMillis();
  
  private void appActivatedDataSender()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AppEventReporter", "appActivatedDataSender: 激活上报");
    }
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("act");
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams("act", localFinalData.getEventParams());
    }
    FinalDataTarget.handle(null, localFinalData);
  }
  
  private void appInDataSender()
  {
    if (!this.mAppForegroundReported)
    {
      this.mAppForegroundReported = true;
      this.mAppForegroundTime = SystemClock.uptimeMillis();
      ThreadUtils.runOnUiThread(new AppEventReporter.2(this));
    }
  }
  
  private void appStartDataSender()
  {
    SessionChangeReason localSessionChangeReason;
    if (this.mNoForegroundActivity)
    {
      if (!isExceedVisitBackgroundTime()) {
        break label45;
      }
      if (this.mLastGenerateTime <= 0L) {
        break label38;
      }
      localSessionChangeReason = SessionChangeReason.REENTER_FOREGROUND_AND_TIMEOUT;
      appStartDataSenderInner(localSessionChangeReason);
    }
    for (;;)
    {
      this.mNoForegroundActivity = false;
      return;
      label38:
      localSessionChangeReason = SessionChangeReason.APP_START_UP;
      break;
      label45:
      if (isVstAdditionalReport()) {
        appStartDataSenderInner(SessionChangeReason.ADDITIONAL_SESSION_REENTER_FOREGROUND);
      }
    }
  }
  
  private void appStartDataSenderInner(SessionChangeReason paramSessionChangeReason)
  {
    startNewSession(paramSessionChangeReason);
    PageManager.getInstance().resetPagePath();
    ThreadUtils.runOnUiThread(new AppEventReporter.1(this));
  }
  
  public static AppEventReporter getInstance()
  {
    return InstanceHolder.INSTANCE;
  }
  
  private void init()
  {
    EventCollector.getInstance().registerEventListener(this);
  }
  
  private boolean isDeviceActivated()
  {
    boolean bool = false;
    if (ReportUtils.getContext() != null) {
      bool = ((Boolean)SPUtils.get(ReportUtils.getContext(), "pref_device_activated", Boolean.valueOf(false))).booleanValue();
    }
    return bool;
  }
  
  private boolean isExceedVisitBackgroundTime()
  {
    return SystemClock.uptimeMillis() > this.mLastGenerateTime + VideoReportInner.getInstance().getConfiguration().getVisitBackgroundTime();
  }
  
  private boolean isVstAdditionalReport()
  {
    return (this.mEventAdditionalReport != null) && (this.mEventAdditionalReport.shouldAdditionalReport("vst"));
  }
  
  private void setDeviceActivated()
  {
    if (ReportUtils.getContext() != null) {
      SPUtils.put(ReportUtils.getContext(), "pref_device_activated", Boolean.valueOf(true));
    }
  }
  
  public void appOutDataSender(boolean paramBoolean)
  {
    FinalData localFinalData;
    if (this.mAppForegroundReported)
    {
      this.mAppForegroundReported = false;
      this.mNoForegroundActivity = true;
      this.mLastGenerateTime = SystemClock.uptimeMillis();
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.i("AppEventReporter", "appOutDataSender: 后台上报");
      }
      localFinalData = (FinalData)ReusablePool.obtain(6);
      localFinalData.setEventKey("appout");
      localFinalData.put("lvtm", Long.valueOf(SystemClock.uptimeMillis() - this.mAppForegroundTime));
      localFinalData.put("cur_pg", PageReporter.getInstance().getCurPageReportInfo());
      IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
      if (localIEventDynamicParams != null) {
        localIEventDynamicParams.setEventDynamicParams("appout", localFinalData.getEventParams());
      }
      if (!paramBoolean) {
        break label138;
      }
      FinalDataTarget.handleInMainThread(null, localFinalData);
    }
    for (;;)
    {
      this.mListenerMgr.startNotify(new AppEventReporter.3(this, paramBoolean));
      return;
      label138:
      FinalDataTarget.handle(null, localFinalData);
    }
  }
  
  String getUsId()
  {
    return this.mUsId;
  }
  
  long getUsStamp()
  {
    return this.mUsStamp;
  }
  
  boolean isColdStart()
  {
    return this.mIsColdStart;
  }
  
  public void onActivityCreate(Activity paramActivity)
  {
    super.onActivityCreate(paramActivity);
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("AppEventReporter", "onActivityCreate: activity=" + paramActivity);
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("AppEventReporter", "onActivityDestroyed: activity=" + paramActivity);
    }
  }
  
  public void onActivityPause(Activity paramActivity)
  {
    super.onActivityPause(paramActivity);
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("AppEventReporter", "onActivityPause: activity=" + paramActivity);
    }
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AppEventReporter", "onActivityResume: activity=" + paramActivity);
    }
    if (!this.mFirstActivityResumed)
    {
      this.mFirstActivityResumed = true;
      if (isDeviceActivated()) {
        break label79;
      }
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.i("AppEventReporter", "onActivityResume: isDeviceActivated:false");
      }
      setDeviceActivated();
      appActivatedDataSender();
    }
    label79:
    while (!VideoReportInner.getInstance().isDebugMode()) {
      return;
    }
    Log.i("AppEventReporter", "onActivityResume: isDeviceActivated:true");
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AppEventReporter", "onActivityStarted: activity=" + paramActivity);
    }
    this.mActivityCount += 1;
    this.mActivityHashCode.add(Integer.valueOf(paramActivity.hashCode()));
    appStartDataSender();
    appInDataSender();
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AppEventReporter", "onActivityStopped: activity=" + paramActivity);
    }
    if (!this.mActivityHashCode.remove(Integer.valueOf(paramActivity.hashCode())))
    {
      String str = paramActivity.getApplicationContext().getString(2131695286, new Object[] { paramActivity.toString() });
      if (VideoReportInner.getInstance().isDebugMode()) {
        Toast.makeText(paramActivity.getApplicationContext(), str, 1).show();
      }
      Log.e("AppEventReporter", str);
    }
    do
    {
      return;
      this.mActivityCount -= 1;
    } while (this.mActivityCount > 0);
    appOutDataSender(false);
  }
  
  public void register(IAppEventListener paramIAppEventListener)
  {
    this.mListenerMgr.register(paramIAppEventListener);
  }
  
  public void registerSessionChangeListener(ISessionChangeListener paramISessionChangeListener)
  {
    this.mSessionChangeListener.register(paramISessionChangeListener);
  }
  
  public void setEventAdditionalReport(IAdditionalReportListener paramIAdditionalReportListener)
  {
    this.mEventAdditionalReport = paramIAdditionalReportListener;
  }
  
  public void startNewSession(SessionChangeReason paramSessionChangeReason)
  {
    boolean bool = true;
    if ((paramSessionChangeReason == SessionChangeReason.REENTER_FOREGROUND_AND_TIMEOUT) && (this.mIsNeedInterceptForegroundSession)) {
      this.mIsNeedInterceptForegroundSession = false;
    }
    do
    {
      return;
      if ((paramSessionChangeReason == SessionChangeReason.CALL_UP_FROM_OUTER) && (this.mLastGenerateTime > 0L) && (isExceedVisitBackgroundTime())) {
        this.mIsNeedInterceptForegroundSession = true;
      }
    } while ((paramSessionChangeReason == SessionChangeReason.APP_START_UP) && (!TextUtils.isEmpty(this.mUsId)));
    int i = new Random().nextInt(900);
    this.mUsId = (System.currentTimeMillis() + "" + (i + 100));
    this.mUsStamp = System.currentTimeMillis();
    if (paramSessionChangeReason == SessionChangeReason.APP_START_UP) {}
    for (;;)
    {
      this.mIsColdStart = bool;
      this.mSessionChangeListener.startNotify(new AppEventReporter.4(this, paramSessionChangeReason));
      return;
      bool = false;
    }
  }
  
  public void unregister(IAppEventListener paramIAppEventListener)
  {
    this.mListenerMgr.unregister(paramIAppEventListener);
  }
  
  public static abstract interface IAppEventListener
  {
    public abstract void onAppIn();
    
    public abstract void onAppOut(boolean paramBoolean);
  }
  
  static class InstanceHolder
  {
    private static final AppEventReporter INSTANCE = new AppEventReporter(null);
    
    static
    {
      INSTANCE.init();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.AppEventReporter
 * JD-Core Version:    0.7.0.1
 */