package com.tencent.mobileqq.mini.appbrand.worker;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class MiniAppWorkerManager
  implements Handler.Callback
{
  public static final int MSG_JSCORE_INIT_OVER = 0;
  public static final String OBJ_WEIXINWORKER = "WeixinWorker";
  public static final String TAG = "miniapp-worker";
  private AppBrandRuntime mAppBrandRuntime;
  private ApkgInfo mCurApkgInfo;
  private Handler mHandler = new Handler(Looper.getMainLooper(), this);
  private String mWAWorkerJsStr;
  private String mWorkerRunnableStr;
  private ArrayList<String> messagePendingList = new ArrayList();
  
  public MiniAppWorkerManager(AppBrandRuntime paramAppBrandRuntime)
  {
    this.mAppBrandRuntime = paramAppBrandRuntime;
    this.mWAWorkerJsStr = AppLoaderFactory.getAppLoaderManager().waWorkerStr();
  }
  
  private void handlePendingMsgList()
  {
    if ((this.mAppBrandRuntime == null) || (this.mAppBrandRuntime.webviewPool == null))
    {
      QLog.e("miniapp-worker", 1, "[handlePendingMsgList] failed : mAppBrandRuntime == null || mAppBrandRuntime.webviewPool == null");
      return;
    }
    MiniAppWorker localMiniAppWorker = this.mAppBrandRuntime.webviewPool.getWorker();
    if ((localMiniAppWorker == null) || (!localMiniAppWorker.isJSContextValid()))
    {
      QLog.e("miniapp-worker", 1, "[handlePendingMsgList] failed : worker null/jsctx failed !");
      return;
    }
    localMiniAppWorker.postMessageListToWorker(this.messagePendingList);
  }
  
  private void notifyManager(Message paramMessage)
  {
    if (paramMessage == null) {
      QLog.e("miniapp-worker", 1, "[notifyManager] empty message");
    }
    if (this.mHandler != null) {
      this.mHandler.sendMessage(paramMessage);
    }
  }
  
  public void cleanUp()
  {
    QLog.i("miniapp-worker", 2, "[cleanUp]");
    if (this.messagePendingList != null) {
      this.messagePendingList.clear();
    }
  }
  
  public int handleCreateWorker(String paramString, ApkgInfo paramApkgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("miniapp-worker", 2, "[handleCreateWorker]");
    }
    if (TextUtils.isEmpty(this.mWAWorkerJsStr)) {
      this.mWAWorkerJsStr = AppLoaderFactory.getAppLoaderManager().waWorkerStr();
    }
    if ((TextUtils.isEmpty(this.mWAWorkerJsStr)) || (paramApkgInfo == null))
    {
      QLog.e("miniapp-worker", 1, "[handleCreateWorker] error : waWorker.js is missing");
      return 0;
    }
    if (TextUtils.isEmpty(paramApkgInfo.getWorkerPath(null, paramString)))
    {
      QLog.e("miniapp-worker", 1, "[handleCreateWorker] error : 001 executed js file " + paramString + " is missing");
      return -1;
    }
    String str = paramApkgInfo.getWorkerJsContent(null, paramString);
    if (TextUtils.isEmpty(str))
    {
      QLog.e("miniapp-worker", 1, "[handleCreateWorker] error : 002 executed js file " + paramString + " is missing");
      return -1;
    }
    this.mWorkerRunnableStr = str;
    try
    {
      this.mCurApkgInfo = paramApkgInfo;
      if ((this.mAppBrandRuntime == null) || (this.mAppBrandRuntime.webviewPool == null))
      {
        QLog.e("miniapp-worker", 1, "[handleCreateWorker] failed : mAppBrandRuntime == null || mAppBrandRuntime.webviewPool == null");
        return 0;
      }
      paramString = this.mAppBrandRuntime.webviewPool.createWorker();
      if (paramString == null) {
        return 0;
      }
      paramString.initJSContext();
      return 1;
    }
    catch (Exception paramString)
    {
      QLog.e("miniapp-worker", 1, "[handleCreateWorker] failed : ", paramString);
    }
    return 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      onWorkerJSContextInitFinished();
    }
  }
  
  public void handlePostMsgToServiceWebview(String paramString)
  {
    if ((this.mAppBrandRuntime == null) || (this.mAppBrandRuntime.webviewPool == null))
    {
      QLog.e("miniapp-worker", 1, "[handlePostMsgToServiceWebview] failed : mAppBrandRuntime == null || mAppBrandRuntime.webviewPool == null");
      return;
    }
    JsRuntime localJsRuntime = this.mAppBrandRuntime.webviewPool.getServiceWebview(this.mCurApkgInfo.appId);
    if (localJsRuntime == null)
    {
      QLog.e("miniapp-worker", 1, "[handlePostMsgToServiceWebview] empty ServiceWebview");
      return;
    }
    localJsRuntime.postMessageToMainThread(paramString);
  }
  
  public void handlePostMsgToWorker(Object paramObject, String paramString)
  {
    if ((this.mAppBrandRuntime == null) || (this.mAppBrandRuntime.webviewPool == null))
    {
      QLog.e("miniapp-worker", 1, "[handlePostMsgToWorker] failed : mAppBrandRuntime == null || mAppBrandRuntime.webviewPool == null");
      return;
    }
    paramObject = this.mAppBrandRuntime.webviewPool.getWorker();
    if ((paramObject == null) || (!paramObject.isJSContextValid()))
    {
      if (this.messagePendingList == null) {
        this.messagePendingList = new ArrayList();
      }
      QLog.e("miniapp-worker", 1, "[handlePostMsgToWorker] messagePendingList.add:" + paramString);
      this.messagePendingList.add(paramString);
      return;
    }
    paramObject.postMessageToWorker(paramString);
  }
  
  public void onWorkerJSContextInitFinished()
  {
    QLog.i("miniapp-worker", 2, "[onWorkerJSContextInitFinished]");
    if ((this.mAppBrandRuntime == null) || (this.mAppBrandRuntime.webviewPool == null)) {
      QLog.e("miniapp-worker", 1, "[onWorkerJSContextInitFinished] failed : mAppBrandRuntime == null || mAppBrandRuntime.webviewPool == null!");
    }
    MiniAppWorker localMiniAppWorker;
    do
    {
      return;
      localMiniAppWorker = this.mAppBrandRuntime.webviewPool.getWorker();
      if (localMiniAppWorker == null)
      {
        QLog.e("miniapp-worker", 1, "[onWorkerJSContextInitFinished] failed : worker null!");
        return;
      }
    } while ((!localMiniAppWorker.loadExecutedAppConfig(this.mCurApkgInfo)) || (!localMiniAppWorker.loadWAWorker(this.mWAWorkerJsStr)) || (!localMiniAppWorker.loadExecuteWorkerJs(this.mWorkerRunnableStr)));
    localMiniAppWorker.ctxValid();
    handlePendingMsgList();
  }
  
  public void setWAWorkerJs(String paramString)
  {
    this.mWAWorkerJsStr = paramString;
  }
  
  public void workerJSContextInitFinished()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    notifyManager(localMessage);
  }
  
  public static abstract interface RETURN_CODE
  {
    public static final int CREATE_WORKER_SUC = 1;
    public static final int UNKOWN_ERROR = 0;
    public static final int WORKER_NOT_EXIST = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.worker.MiniAppWorkerManager
 * JD-Core Version:    0.7.0.1
 */