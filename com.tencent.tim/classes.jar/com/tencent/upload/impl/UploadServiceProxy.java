package com.tencent.upload.impl;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.route.DebugServerRoute;
import com.tencent.upload.report.ReportManager;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadLog;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadSoLoader;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;

public class UploadServiceProxy
  implements IUploadService
{
  private static final int MSG_INNER_TIMEOUT_CLOSE = 8;
  private static final int MSG_UI_CANCEL_TASK = 3;
  private static final int MSG_UI_COMMIT_TASK = 4;
  private static final int MSG_UI_PAUSE_ALL_TASK = 5;
  private static final int MSG_UI_PREPARE = 1;
  private static final int MSG_UI_SET_BACKGROUND_MODE = 6;
  private static final int MSG_UI_SET_TEST_SERVER = 7;
  private static final int MSG_UI_UPLOAD_TASK = 2;
  private static volatile boolean mInit = false;
  private static volatile UploadServiceProxy sInstance;
  public static final String tag = "UploadServiceProxy";
  boolean mIsDebug = false;
  private UploadServiceImpl mServiceImpl;
  private Handler mWorkerHandler;
  private HandlerThread mWorkerThread;
  
  private boolean checkStatus()
  {
    if (!mInit)
    {
      UploadLog.d("UploadServiceProxy", "checkStatus mInit: " + mInit);
      return false;
    }
    if ((this.mWorkerThread == null) || (!this.mWorkerThread.isAlive()))
    {
      UploadLog.d("UploadServiceProxy", "checkStatus work thread is not ready !");
      return false;
    }
    if (this.mWorkerHandler == null)
    {
      UploadLog.d("UploadServiceProxy", "checkStatus mWorkerHandler == null");
      return false;
    }
    return true;
  }
  
  public static IUploadService getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new UploadServiceProxy();
      }
      return sInstance;
    }
    finally {}
  }
  
  /* Error */
  private void initWorkerThread()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/upload/impl/UploadServiceProxy:mWorkerThread	Landroid/os/HandlerThread;
    //   6: ifnull +25 -> 31
    //   9: aload_0
    //   10: getfield 80	com/tencent/upload/impl/UploadServiceProxy:mWorkerThread	Landroid/os/HandlerThread;
    //   13: invokevirtual 85	android/os/HandlerThread:isAlive	()Z
    //   16: ifeq +15 -> 31
    //   19: aload_0
    //   20: getfield 89	com/tencent/upload/impl/UploadServiceProxy:mWorkerHandler	Landroid/os/Handler;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +6 -> 31
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: ldc 32
    //   33: ldc 99
    //   35: invokestatic 102	com/tencent/upload/utils/UploadLog:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: new 82	android/os/HandlerThread
    //   42: dup
    //   43: ldc 104
    //   45: invokespecial 107	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   48: putfield 80	com/tencent/upload/impl/UploadServiceProxy:mWorkerThread	Landroid/os/HandlerThread;
    //   51: aload_0
    //   52: getfield 80	com/tencent/upload/impl/UploadServiceProxy:mWorkerThread	Landroid/os/HandlerThread;
    //   55: invokevirtual 110	android/os/HandlerThread:start	()V
    //   58: aload_0
    //   59: new 112	com/tencent/upload/impl/UploadServiceProxy$1
    //   62: dup
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 80	com/tencent/upload/impl/UploadServiceProxy:mWorkerThread	Landroid/os/HandlerThread;
    //   68: invokevirtual 116	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   71: invokespecial 119	com/tencent/upload/impl/UploadServiceProxy$1:<init>	(Lcom/tencent/upload/impl/UploadServiceProxy;Landroid/os/Looper;)V
    //   74: putfield 89	com/tencent/upload/impl/UploadServiceProxy:mWorkerHandler	Landroid/os/Handler;
    //   77: aload_0
    //   78: getfield 50	com/tencent/upload/impl/UploadServiceProxy:mServiceImpl	Lcom/tencent/upload/impl/UploadServiceImpl;
    //   81: ifnonnull -53 -> 28
    //   84: aload_0
    //   85: invokestatic 124	com/tencent/upload/impl/UploadServiceImpl:getInstance	()Lcom/tencent/upload/impl/UploadServiceImpl;
    //   88: putfield 50	com/tencent/upload/impl/UploadServiceProxy:mServiceImpl	Lcom/tencent/upload/impl/UploadServiceImpl;
    //   91: goto -63 -> 28
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	UploadServiceProxy
    //   23	2	1	localHandler	Handler
    //   94	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	94	finally
    //   31	91	94	finally
  }
  
  public boolean cancel(AbstractUploadTask paramAbstractUploadTask)
  {
    UploadLog.d("UploadServiceProxy", "UI operation >>> cancel");
    if (!checkStatus()) {
      return false;
    }
    if (paramAbstractUploadTask == null)
    {
      UploadLog.d("UploadServiceProxy", "task == null");
      return false;
    }
    UploadLog.d("UploadServiceProxy", "cancel --> flowId:" + paramAbstractUploadTask.flowId);
    this.mWorkerHandler.obtainMessage(3, paramAbstractUploadTask).sendToTarget();
    return true;
  }
  
  public boolean clearCacheWhenIdle(Context paramContext)
  {
    UploadLog.d("UploadServiceProxy", "UI operation >>> clearCacheWhenIdle");
    FileUtils.clearUploadDir(paramContext, 0L, 0L);
    return true;
  }
  
  public boolean commit(AbstractUploadTask paramAbstractUploadTask)
  {
    UploadLog.d("UploadServiceProxy", "UI operation >>> commit");
    if (!checkStatus()) {
      return false;
    }
    if (paramAbstractUploadTask == null)
    {
      UploadLog.d("UploadServiceProxy", "task == null");
      return false;
    }
    UploadLog.d("UploadServiceProxy", "commit --> flowId:" + paramAbstractUploadTask.flowId);
    this.mWorkerHandler.obtainMessage(4, paramAbstractUploadTask).sendToTarget();
    return true;
  }
  
  public void init(Context paramContext, IUploadConfig paramIUploadConfig, IUploadLog paramIUploadLog, IUploadReport paramIUploadReport, IUploadEnv paramIUploadEnv, IUploadSoLoader paramIUploadSoLoader)
  {
    UploadLog.d("UploadServiceProxy", "init() --- env: " + paramIUploadEnv);
    UploadGlobalConfig.init(paramContext, paramIUploadConfig, paramIUploadLog, paramIUploadReport, paramIUploadEnv, paramIUploadSoLoader);
    mInit = true;
  }
  
  public boolean isInitialized()
  {
    return mInit;
  }
  
  public void keepImageTmpFile(boolean paramBoolean)
  {
    UploadGlobalConfig.keepImageTmpFile(paramBoolean);
  }
  
  public void pauseAllTask()
  {
    UploadLog.d("UploadServiceProxy", "UI operation >>> pauseAllTask");
    if (!checkStatus()) {
      return;
    }
    this.mWorkerHandler.obtainMessage(5).sendToTarget();
  }
  
  public void prepare(TaskTypeConfig paramTaskTypeConfig)
  {
    UploadLog.d("UploadServiceProxy", "UI operation >>> prepare");
    if (paramTaskTypeConfig == null) {
      return;
    }
    if (!mInit)
    {
      UploadLog.d("UploadServiceProxy", "prepare !mInit");
      return;
    }
    initWorkerThread();
    this.mWorkerHandler.obtainMessage(1, paramTaskTypeConfig).sendToTarget();
  }
  
  public void setBackgroundMode(boolean paramBoolean)
  {
    UploadLog.d("UploadServiceProxy", "UI operation >>> setBackgroundMode");
    if (!checkStatus()) {
      return;
    }
    Handler localHandler = this.mWorkerHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localHandler.obtainMessage(6, i, 0).sendToTarget();
      return;
    }
  }
  
  public void setDebugServerRoute(DebugServerRoute paramDebugServerRoute)
  {
    UploadLog.d("UploadServiceProxy", "UI operation >>> setDebugServerRoute : mInit:" + mInit);
    if (!mInit) {
      return;
    }
    this.mIsDebug = true;
    initWorkerThread();
    this.mWorkerHandler.obtainMessage(7, 0, 0, paramDebugServerRoute).sendToTarget();
  }
  
  public boolean upload(AbstractUploadTask paramAbstractUploadTask)
  {
    UploadLog.d("UploadServiceProxy", "UI operation >>> upload");
    if (!mInit)
    {
      UploadLog.d("UploadServiceProxy", "upload !mInit");
      return false;
    }
    ReportManager.getInstance().reportTaskStart(paramAbstractUploadTask);
    initWorkerThread();
    this.mWorkerHandler.obtainMessage(2, paramAbstractUploadTask).sendToTarget();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.impl.UploadServiceProxy
 * JD-Core Version:    0.7.0.1
 */