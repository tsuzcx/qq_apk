package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.receiver.WebProcessReceiver;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.task.AsyncTask;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashMap;
import java.util.Map;

@ClassTag(tag="TbsAsyncTask")
public class TbsAsyncTask
  extends AsyncTask
{
  public static final int MSG_WHAT_CHECK_TBS = 6;
  public static final int MSG_WHAT_X5_DOWNLOAD_PROGRESS = 3;
  public static final int MSG_WHAT_X5_TIMEOUT = 7;
  private static int X5_STATE_DOWNLOAD_EXIST_IN_WX;
  private static int X5_STATE_DOWNLOAD_FAIL_INIT_THREAD;
  private static int X5_STATE_DOWNLOAD_OTHER_PROCESS;
  private static int X5_STATE_DOWNLOAD_READY;
  private static int X5_STATE_DOWNLOAD_REPEAT;
  private static int X5_STATE_DOWNLOAD_SUCC = 100;
  private static int X5_STATE_INSTALL_COPY_SUCC = 220;
  private static int X5_STATE_INSTALL_SUCC;
  private static int X5_STATE_INSTALL_SUCCESS_AND_RELEASE_LOCK = 232;
  private final int X5_LOAD_TIME_OUT = 30000;
  private boolean mDownloadForground = false;
  public boolean mIsTimeout = false;
  private int mTbsProgress = 0;
  private boolean mWaitForX5 = false;
  protected Handler workHander;
  
  static
  {
    X5_STATE_DOWNLOAD_REPEAT = 110;
    X5_STATE_DOWNLOAD_READY = 120;
    X5_STATE_DOWNLOAD_FAIL_INIT_THREAD = 121;
    X5_STATE_DOWNLOAD_EXIST_IN_WX = 122;
    X5_STATE_DOWNLOAD_OTHER_PROCESS = 177;
    X5_STATE_INSTALL_SUCC = 200;
  }
  
  public TbsAsyncTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public static String getSubProcessName()
  {
    localObject3 = null;
    try
    {
      String str = AppLoaderFactory.g().getProcessName();
      localObject1 = localObject3;
      if (str.contains(":")) {
        localObject1 = str.substring(str.indexOf(":") + 1);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1;
        QMLog.e("minisdk-start", "getSubProcessName exception!", localThrowable);
        Object localObject2 = localObject3;
      }
    }
    localObject3 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject3 = "mini";
    }
    return localObject3;
  }
  
  public void doCheckTbs()
  {
    int i = QbSdk.getTbsVersion(this.mContext);
    int j = QbSdk.getTmpDirTbsVersion(this.mContext);
    QMLog.d("minisdk-start", "getTbsVersion=" + i + " tmpDirTbsVersion=" + j);
    Object localObject = this.mContext.getSharedPreferences(this.mContext.getPackageName() + "_preferences", 4);
    int k = ((SharedPreferences)localObject).getInt("tbs_download_complete", -1);
    QMLog.i("minisdk-start", "tbs download result: " + k);
    if (((k == X5_STATE_INSTALL_SUCCESS_AND_RELEASE_LOCK) || (k == X5_STATE_INSTALL_COPY_SUCC)) && ((i > 0) || (j > 0)))
    {
      getWorkHander().removeMessages(6);
      onTaskSucceed();
    }
    do
    {
      return;
      if (k != -1)
      {
        getWorkHander().removeMessages(6);
        onTaskFailed();
        return;
      }
      i = ((SharedPreferences)localObject).getInt("tbs_download_progress", 0);
      QMLog.d("minisdk-start", "tbs download progress " + i);
      if (i > this.mTbsProgress)
      {
        this.mTbsProgress = i;
        getWorkHander().removeMessages(7);
        getWorkHander().sendEmptyMessageDelayed(7, 30000L);
        localObject = Message.obtain();
        ((Message)localObject).what = 3;
        ((Message)localObject).arg1 = i;
      }
    } while (isDone());
    getWorkHander().sendEmptyMessageDelayed(6, 1000L);
  }
  
  public void executeAsync()
  {
    QMLog.i("minisdk-start", "startTbs");
    int i = QbSdk.getTbsVersion(this.mContext);
    int j = QbSdk.getTmpDirTbsVersion(this.mContext);
    QMLog.i("minisdk-start", "tbsVersion=" + i + " tmpDirTbsVersion=" + j + ",data_directory_suffix:" + getSubProcessName());
    Object localObject = new HashMap();
    ((HashMap)localObject).put("data_directory_suffix", getSubProcessName());
    QbSdk.initTbsSettings((Map)localObject);
    this.mIsTimeout = false;
    if ((i > 0) || (j > 0))
    {
      onTaskSucceed();
      return;
    }
    if (!this.mWaitForX5)
    {
      QMLog.i("minisdk-start", "X5 isn't completed， use system core。");
      localObject = new Intent(this.mContext, WebProcessReceiver.class);
      ((Intent)localObject).setAction("action_download_tbs");
      ((Intent)localObject).putExtra("isDownloadForeground", this.mDownloadForground);
      ((Intent)localObject).putExtra("fromMiniApp", true);
      this.mContext.sendBroadcast((Intent)localObject);
      onTaskSucceed();
      return;
    }
    getWorkHander().sendEmptyMessageDelayed(7, 30000L);
    this.mTbsProgress = 0;
    localObject = this.mContext.getSharedPreferences(this.mContext.getPackageName() + "_preferences", 4);
    ((SharedPreferences)localObject).edit().remove("tbs_download_complete").commit();
    ((SharedPreferences)localObject).edit().remove("tbs_download_progress").commit();
    localObject = new Intent(this.mContext, WebProcessReceiver.class);
    ((Intent)localObject).setAction("action_download_tbs");
    ((Intent)localObject).putExtra("isDownloadForeground", this.mDownloadForground);
    ((Intent)localObject).putExtra("fromMiniApp", true);
    this.mContext.sendBroadcast((Intent)localObject);
    QMLog.d("minisdk-start", "start WebProcessReceiver isDownloadForeground" + this.mDownloadForground);
    getWorkHander().sendEmptyMessageDelayed(6, 1000L);
  }
  
  public Handler getWorkHander()
  {
    if (this.workHander == null) {
      this.workHander = new Handler(Looper.getMainLooper(), this);
    }
    return this.workHander;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      doCheckTbs();
      continue;
      int i = QbSdk.getTbsVersion(this.mContext);
      int j = QbSdk.getTmpDirTbsVersion(this.mContext);
      QMLog.d("minisdk-start", "X5安装超时 tbsVersion=" + i + " tmpDirTbsVersion=" + j);
      if ((i > 0) || (j > 0))
      {
        onTaskSucceed();
      }
      else
      {
        this.mIsTimeout = true;
        onTaskFailed();
      }
    }
  }
  
  public void needDownloadForeground(boolean paramBoolean)
  {
    this.mDownloadForground = paramBoolean;
  }
  
  public void onTaskFailed()
  {
    getWorkHander().removeMessages(7);
    if (this.mIsTimeout) {}
    QMLog.d("minisdk-start", "TbsAsyncTask failed! Work continue as same as succeed anyway. ");
    super.onTaskSucceed();
  }
  
  public void onTaskSucceed()
  {
    getWorkHander().removeMessages(7);
    super.onTaskSucceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.TbsAsyncTask
 * JD-Core Version:    0.7.0.1
 */