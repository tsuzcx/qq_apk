package com.tencent.upload.biz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.upload.common.Const;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.HandlerWapper;
import com.tencent.upload.common.LogPrint;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.network.ISessionServiceCallback;
import com.tencent.upload.network.IUploadSessionService;
import com.tencent.upload.network.UploadSessionService;
import com.tencent.upload.network.route.IUploadRouteStrategy.RouteCategory;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.uinterface.IUploadLog;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.IUploadTaskType;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class UploadServiceImpl
  implements IUploadService
{
  private static final int CLOSE_COMPRESS_PROCESS_TIME_MS = 30000;
  private static final int CLOSE_TIME = 300000;
  private static final int COMPRESS_UNRELIABLE_TIME = 30000;
  private static final int MSG_CLOSE_COMPRESS_PROCESS = 9;
  private static final int MSG_COMPRESS_UNRELIABLE = 5;
  private static final int MSG_INNER_TIMEOUT_CLOSE = 2;
  private static final int MSG_SESSION_STATE_NOTIFY = 6;
  private static final int MSG_UI_CANCEL_TASK = 8;
  private static final int MSG_UI_COMMIT_TASK = 15;
  private static final int MSG_UI_PAUSE_ALL_TASK = 7;
  private static final int MSG_UI_PREPARE = 3;
  private static final int MSG_UI_SET_BACKGROUND_MODE = 10;
  private static final int MSG_UI_SET_TEST_SERVER = 12;
  private static final int MSG_UI_UPLOAD_TASK = 0;
  public static final String tag = "ServiceImpl";
  private boolean mCloseTimerSetted;
  private int mCompressServicePid = 0;
  private long mEnterBackgroundIdleTime;
  private SparseArray<ImageCompressPendingTask> mImageCompressingTasks;
  private ImageProcessProxy mImageCompressor;
  private boolean mInBackgroundMode;
  private volatile boolean mInit;
  private boolean mNetworkIdle;
  private final ReentrantReadWriteLock.ReadLock mReadLock = this.mWorkerThreadLooperLock.readLock();
  private final IUploadService.IUploadServiceContext mServiceContext = new IUploadService.IUploadServiceContext()
  {
    public final boolean compressUploadTask(AbstractUploadTask paramAnonymousAbstractUploadTask, IUploadConfig.UploadImageSize paramAnonymousUploadImageSize, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      ImageProcessProxy localImageProcessProxy = UploadServiceImpl.this.getImageCompressor();
      if (localImageProcessProxy == null) {
        return false;
      }
      SparseArray localSparseArray = UploadServiceImpl.this.getImageCompressingTaskArray();
      if (localSparseArray.get(paramAnonymousAbstractUploadTask.flowId) != null)
      {
        UploadLog.e("ServiceImpl", "compressUploadTask() repeating taskId=" + paramAnonymousAbstractUploadTask.flowId + " file=" + paramAnonymousAbstractUploadTask.uploadFilePath);
        return true;
      }
      if (localImageProcessProxy.asyncCopyAndCompressFile(paramAnonymousAbstractUploadTask.flowId, paramAnonymousAbstractUploadTask.uploadFilePath, paramAnonymousAbstractUploadTask.md5, paramAnonymousUploadImageSize.width, paramAnonymousUploadImageSize.height, paramAnonymousUploadImageSize.quality, paramAnonymousBoolean1, paramAnonymousBoolean2))
      {
        paramAnonymousUploadImageSize = new ImageCompressPendingTask(paramAnonymousAbstractUploadTask, paramAnonymousUploadImageSize.width, paramAnonymousUploadImageSize.height, paramAnonymousUploadImageSize.quality, paramAnonymousBoolean1, paramAnonymousBoolean2);
        localSparseArray.put(paramAnonymousAbstractUploadTask.flowId, paramAnonymousUploadImageSize);
        if (localSparseArray.size() == 1) {
          UploadServiceImpl.this.setCompressUnreliableTimer();
        }
        return true;
      }
      return false;
    }
    
    public final void uploadAction(IUploadAction paramAnonymousIUploadAction)
    {
      paramAnonymousIUploadAction.setSessionService(UploadServiceImpl.this.mSessionService);
      UploadServiceImpl.this.mSessionService.upload(paramAnonymousIUploadAction);
    }
  };
  private final IUploadSessionService mSessionService = new UploadSessionService(this.mSessionServiceCallback);
  private final ISessionServiceCallback mSessionServiceCallback = new ISessionServiceCallback()
  {
    public void onFailToOpen(int paramAnonymousInt, UploadRoute paramAnonymousUploadRoute, String paramAnonymousString)
    {
      UploadGlobalConfig.getUploadReport().openSessionReport(900, paramAnonymousString, paramAnonymousUploadRoute.getIp(), paramAnonymousUploadRoute.getPort());
    }
    
    public void onOpen(int paramAnonymousInt, UploadRoute paramAnonymousUploadRoute, String paramAnonymousString)
    {
      UploadGlobalConfig.getUploadReport().openSessionReport(IUploadRouteStrategy.RouteCategory.toSuccessCode(paramAnonymousUploadRoute.getRouteCategory()), paramAnonymousString, paramAnonymousUploadRoute.getIp(), paramAnonymousUploadRoute.getPort());
    }
    
    public void onSessionServiceStateChange(boolean paramAnonymousBoolean)
    {
      UploadLog.i("ServiceImpl", "onSessionServiceStateChange() idle=" + paramAnonymousBoolean);
      HandlerWapper localHandlerWapper = UploadServiceImpl.this.mWorkerThreadHandler;
      if (paramAnonymousBoolean) {}
      for (int i = 0;; i = 1)
      {
        localHandlerWapper.obtainMessage(6, i, 0).sendToTarget();
        return;
      }
    }
  };
  private SparseArray<AbstractUploadTask> mUploadTasksInLooper = new SparseArray();
  private final byte[] mUploadTasksLock = new byte[0];
  private PowerManager.WakeLock mWakeLock;
  private WifiManager.WifiLock mWifiLock = null;
  private HandlerThread mWorkerThread;
  private HandlerWapper mWorkerThreadHandler;
  private final byte[] mWorkerThreadLock = new byte[0];
  private final ReentrantReadWriteLock mWorkerThreadLooperLock = new ReentrantReadWriteLock();
  private final ReentrantReadWriteLock.WriteLock mWriteLock = this.mWorkerThreadLooperLock.writeLock();
  
  @SuppressLint({"InlinedApi"})
  private void acquireWakeLockIfNot()
  {
    if (this.mWakeLock == null)
    {
      this.mWakeLock = ((PowerManager)UploadGlobalConfig.getContext().getSystemService("power")).newWakeLock(1, "ServiceImpl");
      this.mWakeLock.acquire();
      UploadLog.d("ServiceImpl", "acquireWakeLock()");
    }
    if (this.mWifiLock == null)
    {
      WifiManager localWifiManager = (WifiManager)UploadGlobalConfig.getContext().getSystemService("wifi");
      int i = 1;
      if (Build.VERSION.SDK_INT >= 12) {
        i = 3;
      }
      this.mWifiLock = localWifiManager.createWifiLock(i, "ServiceImpl");
      UploadLog.d("ServiceImpl", "acquireWifiLock()");
    }
  }
  
  private void check2doClose()
  {
    this.mWriteLock.lock();
    try
    {
      if (isUploadIdle()) {
        doClose();
      }
      return;
    }
    finally
    {
      this.mWriteLock.unlock();
    }
  }
  
  private void checkToSetTimer()
  {
    removeCloseTimerIfSetted();
    if (!this.mNetworkIdle)
    {
      UploadLog.v("ServiceImpl", "checkToSetCloseTimer() !mNetworkIdle");
      return;
    }
    if (this.mWorkerThreadHandler.hasMessages(0))
    {
      UploadLog.v("ServiceImpl", "checkToSetCloseTimer() has MSG_UPLOAD_TASK");
      return;
    }
    if ((this.mImageCompressingTasks != null) && (this.mImageCompressingTasks.size() > 0))
    {
      UploadLog.v("ServiceImpl", "checkToSetCloseTimer() has mImageCompressingTasks");
      return;
    }
    setCloseTimer();
  }
  
  private final void closeCompressProcess(String paramString)
  {
    if (this.mCompressServicePid == 0) {
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (this.mImageCompressor != null)
    {
      this.mImageCompressor.release();
      this.mImageCompressor = null;
    }
    Process.killProcess(this.mCompressServicePid);
    UploadLog.d("ServiceImpl", str + " killProcess compressServicePid:" + this.mCompressServicePid);
    this.mCompressServicePid = 0;
  }
  
  private void destroyCompressPendingTasks()
  {
    int i;
    if (this.mImageCompressingTasks != null)
    {
      int j = this.mImageCompressingTasks.size();
      i = 0;
      if (i >= j)
      {
        this.mImageCompressingTasks.clear();
        this.mImageCompressingTasks = null;
      }
    }
    else
    {
      if (this.mImageCompressor != null)
      {
        this.mImageCompressor.release();
        this.mImageCompressor = null;
      }
      return;
    }
    if (!(this.mImageCompressingTasks.valueAt(i) instanceof ImageCompressPendingTask)) {
      UploadLog.e("ServiceImpl", "destroyCompressPendingTasks() find element not instance of ImageCompressPendingTask");
    }
    for (;;)
    {
      i += 1;
      break;
      AbstractUploadTask localAbstractUploadTask = ((ImageCompressPendingTask)this.mImageCompressingTasks.valueAt(i)).mUploadTask;
      if (localAbstractUploadTask.uploadTaskCallback != null) {
        localAbstractUploadTask.uploadTaskCallback.onUploadStateChange(localAbstractUploadTask, 2);
      }
    }
  }
  
  private void doClose()
  {
    UploadLog.d("ServiceImpl", "doClose()");
    this.mNetworkIdle = false;
    this.mCloseTimerSetted = false;
    this.mEnterBackgroundIdleTime = 0L;
    if (this.mSessionService != null)
    {
      this.mSessionService.cancelAll(4);
      this.mSessionService.close();
    }
    destroyCompressPendingTasks();
    synchronized (this.mWorkerThreadLock)
    {
      Looper localLooper = this.mWorkerThread.getLooper();
      if (localLooper != null) {
        localLooper.quit();
      }
      this.mWorkerThread = null;
      this.mWorkerThreadHandler = null;
      FileUtils.clearUploadDir(UploadGlobalConfig.getContext(), 31457280L, 20971520L);
      releaseWakeLockIfExist();
      return;
    }
  }
  
  private final SparseArray<ImageCompressPendingTask> getImageCompressingTaskArray()
  {
    if (this.mImageCompressingTasks == null) {
      this.mImageCompressingTasks = new SparseArray();
    }
    return this.mImageCompressingTasks;
  }
  
  private ImageProcessProxy getImageCompressor()
  {
    if (this.mImageCompressor == null) {
      this.mImageCompressor = new ImageProcessProxy(new ImageProcessProxy.IImageCompressorCallback()
      {
        public void onCompressFinish(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          UploadLog.v("ServiceImpl", "UploadServiceImpl onCompressFinish taskId=" + paramAnonymousInt + " " + paramAnonymousString1);
          if (UploadServiceImpl.this.mImageCompressingTasks == null)
          {
            UploadLog.d("ServiceImpl", "onCompressFinish() mImageCompressingTasks==null, ignored");
            return;
          }
          ImageCompressPendingTask localImageCompressPendingTask = (ImageCompressPendingTask)UploadServiceImpl.this.mImageCompressingTasks.get(paramAnonymousInt);
          if (localImageCompressPendingTask == null)
          {
            UploadLog.d("ServiceImpl", "onCompressFinish() task==null, ignored");
            return;
          }
          UploadServiceImpl.this.mImageCompressingTasks.remove(paramAnonymousInt);
          UploadServiceImpl.this.checkToSetTimer();
          if (UploadServiceImpl.this.mImageCompressingTasks.size() == 0) {
            UploadServiceImpl.this.removeCompressUnreliableTimer();
          }
          while ((TextUtils.isEmpty(paramAnonymousString1)) || (localImageCompressPendingTask.mUploadTask.uploadFilePath.equals(paramAnonymousString1)))
          {
            Const.copyAndUploadTask(UploadServiceImpl.this.mServiceContext, localImageCompressPendingTask.mUploadTask, paramAnonymousString2);
            return;
            UploadServiceImpl.this.resetCompressUnreliableTimer();
          }
          localImageCompressPendingTask.mUploadTask.uploadFilePath = paramAnonymousString1;
          Const.uploadTask(UploadServiceImpl.this.mServiceContext, localImageCompressPendingTask.mUploadTask, true, paramAnonymousString2 + " || " + "uploadCopy=" + "compress");
        }
        
        public void onPidObtained(int paramAnonymousInt)
        {
          UploadServiceImpl.this.mCompressServicePid = paramAnonymousInt;
        }
        
        public void onServiceConnected()
        {
          if ((UploadServiceImpl.this.mImageCompressingTasks == null) || (UploadServiceImpl.this.mImageCompressingTasks.size() == 0)) {
            return;
          }
          UploadLog.d("ServiceImpl", "re asyncCopyAndCompressFile count=" + UploadServiceImpl.this.mImageCompressingTasks.size());
          int j = UploadServiceImpl.this.mImageCompressingTasks.size();
          int i = 0;
          label67:
          if (i < j)
          {
            if ((UploadServiceImpl.this.mImageCompressingTasks.valueAt(i) instanceof ImageCompressPendingTask)) {
              break label103;
            }
            UploadLog.w("ServiceImpl", "onServiceConnected() not instance of ImageCompressPendingTask");
          }
          for (;;)
          {
            i += 1;
            break label67;
            break;
            label103:
            ImageCompressPendingTask localImageCompressPendingTask = (ImageCompressPendingTask)UploadServiceImpl.this.mImageCompressingTasks.valueAt(i);
            if (!UploadServiceImpl.this.mImageCompressor.asyncCopyAndCompressFile(localImageCompressPendingTask.mUploadTask.flowId, localImageCompressPendingTask.mUploadTask.uploadFilePath, localImageCompressPendingTask.mUploadTask.md5, localImageCompressPendingTask.mTargetWidth, localImageCompressPendingTask.mTargetHeight, localImageCompressPendingTask.mTargetQuality, localImageCompressPendingTask.autoRotate, localImageCompressPendingTask.compressToWebp)) {
              Const.copyAndUploadTask(UploadServiceImpl.this.mServiceContext, localImageCompressPendingTask.mUploadTask, "asyncCopyAndCompressFile=false");
            }
          }
        }
      });
    }
    if (this.mImageCompressor.init()) {
      return this.mImageCompressor;
    }
    return null;
  }
  
  public static IUploadService getInstance()
  {
    return Container.instance;
  }
  
  private void initWorkerThread()
  {
    synchronized (this.mWorkerThreadLock)
    {
      if ((this.mWorkerThread != null) && (this.mWorkerThread.isAlive())) {
        return;
      }
      UploadLog.v("ServiceImpl", "initWorkerThread()");
      this.mWorkerThread = new HandlerThread("uploadHandle");
      this.mWorkerThread.start();
      this.mWorkerThreadHandler = new HandlerWapper(this.mWorkerThread.getLooper())
      {
        public void handleMessage(Message arg1)
        {
          switch (???.what)
          {
          case 1: 
          case 4: 
          case 11: 
          case 13: 
          case 14: 
          default: 
          case 0: 
          case 8: 
          case 15: 
          case 10: 
          case 12: 
          case 2: 
          case 7: 
          case 3: 
          case 5: 
          case 6: 
            do
            {
              do
              {
                for (;;)
                {
                  return;
                  if ((???.obj instanceof AbstractUploadTask))
                  {
                    AbstractUploadTask localAbstractUploadTask1 = (AbstractUploadTask)???.obj;
                    UploadLog.d("ServiceImpl", "receive MSG_UPLOAD_TASK uin=" + localAbstractUploadTask1.iUin + " flowId=" + localAbstractUploadTask1.flowId + " file=" + localAbstractUploadTask1.uploadFilePath + " md5HC=" + LogPrint.hashCode(localAbstractUploadTask1.md5) + " pathHC=" + LogPrint.hashCode(localAbstractUploadTask1.uploadFilePath) + " " + localAbstractUploadTask1.getClass().getSimpleName());
                    synchronized (UploadServiceImpl.this.mUploadTasksLock)
                    {
                      UploadServiceImpl.this.mUploadTasksInLooper.remove(localAbstractUploadTask1.flowId);
                      Const.startUploadTask(UploadServiceImpl.this.mServiceContext, localAbstractUploadTask1);
                      UploadServiceImpl.this.checkToSetTimer();
                      return;
                    }
                    if ((???.obj instanceof AbstractUploadTask))
                    {
                      AbstractUploadTask localAbstractUploadTask2 = (AbstractUploadTask)???.obj;
                      UploadLog.d("ServiceImpl", "receive MSG_UI_CANCEL_TASK flowId=" + localAbstractUploadTask2.flowId);
                      int j = 0;
                      int i = j;
                      if (UploadServiceImpl.this.mImageCompressingTasks != null)
                      {
                        i = j;
                        if (UploadServiceImpl.this.mImageCompressingTasks.get(localAbstractUploadTask2.flowId) != null)
                        {
                          UploadLog.d("ServiceImpl", "remove in mImageCompressingTasks flowId=" + localAbstractUploadTask2.flowId);
                          UploadServiceImpl.this.mImageCompressingTasks.remove(localAbstractUploadTask2.flowId);
                          UploadServiceImpl.this.checkToSetTimer();
                          i = 1;
                        }
                      }
                      j = i;
                      if (i == 0)
                      {
                        j = i;
                        if (UploadServiceImpl.this.mWorkerThreadHandler.hasMessages(0, localAbstractUploadTask2)) {
                          UploadLog.d("ServiceImpl", "remove in msgQueue flowId=" + localAbstractUploadTask2.flowId);
                        }
                      }
                      synchronized (UploadServiceImpl.this.mUploadTasksLock)
                      {
                        UploadServiceImpl.this.mUploadTasksInLooper.remove(localAbstractUploadTask2.flowId);
                        UploadServiceImpl.this.mWorkerThreadHandler.removeMessages(0, localAbstractUploadTask2);
                        j = 1;
                        if (j != 0)
                        {
                          if (localAbstractUploadTask2.uploadTaskCallback == null) {
                            continue;
                          }
                          localAbstractUploadTask2.uploadTaskCallback.onUploadStateChange(localAbstractUploadTask2, 5);
                          UploadLog.d("ServiceImpl", "onUploadStateChange=5");
                          return;
                        }
                      }
                      UploadServiceImpl.this.mSessionService.cancel(localObject2.flowId, 3);
                      return;
                      if ((???.obj instanceof AbstractUploadTask))
                      {
                        ??? = (AbstractUploadTask)???.obj;
                        if ((UploadServiceImpl.this.mImageCompressingTasks != null) && (UploadServiceImpl.this.mImageCompressingTasks.get(???.flowId) != null))
                        {
                          UploadLog.d("ServiceImpl", "commit in mImageCompressingTasks flowId=" + ???.flowId);
                          UploadServiceImpl.this.mImageCompressingTasks.remove(???.flowId);
                          UploadServiceImpl.this.checkToSetTimer();
                        }
                        AbstractUploadTask localAbstractUploadTask3;
                        synchronized (UploadServiceImpl.this.mUploadTasksLock)
                        {
                          localAbstractUploadTask3 = (AbstractUploadTask)UploadServiceImpl.this.mUploadTasksInLooper.get(???.flowId);
                          if ((localAbstractUploadTask3 != null) && (UploadServiceImpl.this.mWorkerThreadHandler.hasMessages(0, localAbstractUploadTask3))) {
                            UploadLog.d("ServiceImpl", "remove in msgQueue flowId=" + localAbstractUploadTask3.flowId);
                          }
                        }
                        synchronized (UploadServiceImpl.this.mUploadTasksLock)
                        {
                          UploadServiceImpl.this.mUploadTasksInLooper.remove(localAbstractUploadTask3.flowId);
                          UploadServiceImpl.this.mWorkerThreadHandler.removeMessages(0, localAbstractUploadTask3);
                          UploadServiceImpl.this.mSessionService.cancel(???.flowId, 0);
                          return;
                          ??? = finally;
                          throw ???;
                        }
                        UploadLog.d("ServiceImpl", "receive MSG_UI_SET_BACKGROUND_MODE=" + ???.arg1);
                        if (???.arg1 == 1)
                        {
                          UploadServiceImpl.this.mInBackgroundMode = true;
                          UploadServiceImpl.this.mWriteLock.lock();
                          try
                          {
                            if (!UploadServiceImpl.this.isUploadIdle())
                            {
                              UploadServiceImpl.this.acquireWakeLockIfNot();
                              UploadServiceImpl.this.mEnterBackgroundIdleTime = 0L;
                            }
                            for (;;)
                            {
                              return;
                              UploadServiceImpl.this.mEnterBackgroundIdleTime = SystemClock.elapsedRealtime();
                              UploadLog.v("ServiceImpl", "mEnterBackgroundIdleTime=" + UploadServiceImpl.this.mEnterBackgroundIdleTime);
                            }
                            if (???.arg1 != 0) {}
                          }
                          finally
                          {
                            UploadServiceImpl.this.mWriteLock.unlock();
                          }
                        }
                      }
                    }
                  }
                }
                UploadServiceImpl.this.mInBackgroundMode = false;
                UploadServiceImpl.this.releaseWakeLockIfExist();
                if ((UploadServiceImpl.this.mEnterBackgroundIdleTime != 0L) && (SystemClock.elapsedRealtime() - UploadServiceImpl.this.mEnterBackgroundIdleTime > 300000L))
                {
                  UploadLog.v("ServiceImpl", "进入前台 check2doClose()");
                  UploadServiceImpl.this.check2doClose();
                }
                UploadServiceImpl.this.mEnterBackgroundIdleTime = 0L;
                return;
                UploadLog.d("ServiceImpl", "receive MSG_UI_SET_TEST_SERVER=" + ???.arg1);
                UploadServiceImpl.this.mSessionService.switchServer(0, ???.arg1);
                UploadServiceImpl.this.mSessionService.switchServer(1, ???.arg1);
                return;
                UploadLog.v("ServiceImpl", "receive MSG_INNER_TIMEOUT_CLOSE");
                UploadServiceImpl.this.closeCompressProcess("MSG_INNER_TIMEOUT_CLOSE");
                UploadServiceImpl.this.check2doClose();
                return;
                UploadLog.v("ServiceImpl", "receive MSG_UI_PAUSE_ALL_TASK");
                UploadServiceImpl.this.destroyCompressPendingTasks();
                synchronized (UploadServiceImpl.this.mUploadTasksLock)
                {
                  UploadServiceImpl.this.mUploadTasksInLooper.clear();
                  UploadServiceImpl.this.mSessionService.cancelAll(4);
                  UploadServiceImpl.this.closeCompressProcess("MSG_UI_PAUSE_ALL_TASK");
                  return;
                }
                UploadLog.d("ServiceImpl", "receive MSG_UI_PREPARE");
                if (???.arg1 == 0)
                {
                  UploadServiceImpl.this.mSessionService.perpare(0);
                  return;
                }
              } while (???.arg1 != 1);
              UploadServiceImpl.this.mSessionService.perpare(1);
              return;
              UploadLog.v("ServiceImpl", "receive MSG_COMPRESS_UNRELIABLE");
              UploadServiceImpl.this.processMsgCompressServiceUnreliable();
              return;
              if (???.arg1 == 0)
              {
                UploadServiceImpl.this.mNetworkIdle = true;
                UploadGlobalConfig.getUploadReport().batchComplete();
                UploadServiceImpl.this.checkToSetTimer();
                return;
              }
            } while (1 != ???.arg1);
            UploadServiceImpl.this.mNetworkIdle = false;
            UploadServiceImpl.this.removeCloseTimerIfSetted();
            return;
          }
          UploadServiceImpl.this.closeCompressProcess("MSG_CLOSE_COMPRESS_PROCESS");
        }
      };
      return;
    }
  }
  
  private boolean isUploadIdle()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!this.mWorkerThreadHandler.hasMessages(0)) {
      if (this.mImageCompressingTasks != null)
      {
        bool1 = bool2;
        if (this.mImageCompressingTasks.size() != 0) {}
      }
      else
      {
        bool1 = bool2;
        if (this.mNetworkIdle) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void processMsgCompressServiceUnreliable()
  {
    UploadLog.e("ServiceImpl", "!!!CompressServiceUnreliable!!! process tasks in mImageCompressingTask");
    int i;
    if (this.mImageCompressingTasks != null)
    {
      int j = this.mImageCompressingTasks.size();
      i = 0;
      if (i >= j)
      {
        this.mImageCompressingTasks.clear();
        this.mImageCompressingTasks = null;
      }
    }
    else
    {
      checkToSetTimer();
      return;
    }
    if (!(this.mImageCompressingTasks.valueAt(i) instanceof ImageCompressPendingTask)) {
      UploadLog.e("ServiceImpl", "processMsgCompressServiceUnreliable() not instance of ImageCompressPendingTask");
    }
    for (;;)
    {
      i += 1;
      break;
      AbstractUploadTask localAbstractUploadTask = ((ImageCompressPendingTask)this.mImageCompressingTasks.valueAt(i)).mUploadTask;
      Const.copyAndUploadTask(this.mServiceContext, localAbstractUploadTask, "CompressServiceUnreliable");
    }
  }
  
  private void releaseWakeLockIfExist()
  {
    if ((this.mWakeLock != null) && (this.mWakeLock.isHeld()))
    {
      this.mWakeLock.release();
      this.mWakeLock = null;
      UploadLog.d("ServiceImpl", "releaseWakeLock()");
    }
    if ((this.mWifiLock != null) && (this.mWifiLock.isHeld()))
    {
      this.mWifiLock.release();
      this.mWifiLock = null;
      UploadLog.d("ServiceImpl", "releaseWifiLock()");
    }
  }
  
  private void removeCloseTimerIfSetted()
  {
    if (!this.mCloseTimerSetted) {
      return;
    }
    this.mWorkerThreadHandler.removeMessages(2);
    this.mWorkerThreadHandler.removeMessages(9);
    this.mCloseTimerSetted = false;
    UploadLog.v("ServiceImpl", "removeCloseTimer");
  }
  
  private void removeCompressUnreliableTimer()
  {
    this.mWorkerThreadHandler.removeMessages(5);
    UploadLog.v("ServiceImpl", "removeMessages sfMsgCompressServiceUnreliable");
  }
  
  private void resetCompressUnreliableTimer()
  {
    this.mWorkerThreadHandler.removeMessages(5);
    this.mWorkerThreadHandler.sendMessageDelayed(this.mWorkerThreadHandler.obtainMessage(5), 30000L);
    UploadLog.v("ServiceImpl", "reset sfMsgCompressServiceUnreliable");
  }
  
  private void setCloseTimer()
  {
    UploadLog.v("ServiceImpl", "setCloseTimer()");
    this.mWorkerThreadHandler.removeMessages(2);
    this.mWorkerThreadHandler.sendMessageDelayed(this.mWorkerThreadHandler.obtainMessage(2), 300000L);
    this.mWorkerThreadHandler.sendMessageDelayed(this.mWorkerThreadHandler.obtainMessage(9), 30000L);
    this.mCloseTimerSetted = true;
    releaseWakeLockIfExist();
    if (this.mInBackgroundMode)
    {
      this.mEnterBackgroundIdleTime = SystemClock.elapsedRealtime();
      UploadLog.v("ServiceImpl", "mEnterBackgroundIdleTime=" + this.mEnterBackgroundIdleTime);
    }
  }
  
  private void setCompressUnreliableTimer()
  {
    this.mWorkerThreadHandler.sendMessageDelayed(this.mWorkerThreadHandler.obtainMessage(5), 30000L);
    UploadLog.v("ServiceImpl", "sendMessageDelayed sfMsgCompressServiceUnreliable");
  }
  
  public boolean cancel(AbstractUploadTask paramAbstractUploadTask)
  {
    if (!this.mInit)
    {
      UploadLog.d("ServiceImpl", "cancel !mInit");
      return false;
    }
    if (paramAbstractUploadTask == null)
    {
      UploadLog.d("ServiceImpl", "cancel() task==null");
      return false;
    }
    if (this.mWorkerThreadHandler == null)
    {
      UploadLog.d("ServiceImpl", "cancel() mWorkerThreadHandler==null");
      return false;
    }
    this.mWorkerThreadHandler.obtainMessage(8, paramAbstractUploadTask).sendToTarget();
    return true;
  }
  
  public boolean clearCacheWhenIdle(Context paramContext)
  {
    UploadLog.d("ServiceImpl", "clearCacheWhenIdle");
    synchronized (this.mWorkerThreadLock)
    {
      if (this.mWorkerThreadHandler == null)
      {
        FileUtils.clearUploadDir(paramContext, 0L, 0L);
        UploadLog.d("ServiceImpl", "clearUploadDir isUploadIdle");
        return true;
      }
      return false;
    }
  }
  
  public boolean commit(AbstractUploadTask paramAbstractUploadTask)
  {
    if (!this.mInit)
    {
      UploadLog.d("ServiceImpl", "commit !mInit");
      return false;
    }
    if (paramAbstractUploadTask == null)
    {
      UploadLog.d("ServiceImpl", "commit() task==null");
      return false;
    }
    if (this.mWorkerThreadHandler == null)
    {
      UploadLog.d("ServiceImpl", "commit() mWorkerThreadHandler==null");
      return false;
    }
    this.mWorkerThreadHandler.obtainMessage(15, paramAbstractUploadTask).sendToTarget();
    return true;
  }
  
  public void init(Context paramContext, IUploadConfig paramIUploadConfig, IUploadLog paramIUploadLog, IUploadReport paramIUploadReport)
  {
    long l = System.currentTimeMillis();
    UploadGlobalConfig.init(paramContext, paramIUploadConfig, paramIUploadLog, paramIUploadReport);
    boolean bool = this.mInit;
    this.mInit = true;
    UploadLog.d("ServiceImpl", "init! ms:" + (System.currentTimeMillis() - l) + " oldInitialization:" + bool);
  }
  
  public boolean isInitialized()
  {
    return this.mInit;
  }
  
  public void pauseAllTask()
  {
    if (!this.mInit) {
      return;
    }
    if (this.mWorkerThreadHandler == null)
    {
      UploadLog.d("ServiceImpl", "close() mWorkerThreadHandler==null");
      return;
    }
    this.mWorkerThreadHandler.obtainMessage(7).sendToTarget();
  }
  
  public void prepare(IUploadTaskType paramIUploadTaskType)
  {
    if (!this.mInit)
    {
      UploadLog.d("ServiceImpl", "prepare !mInit");
      return;
    }
    UploadLog.d("ServiceImpl", "prepare() type=" + paramIUploadTaskType);
    initWorkerThread();
    int i = paramIUploadTaskType.getServerCategory();
    this.mWorkerThreadHandler.obtainMessage(3, i, 0).sendToTarget();
  }
  
  public void setBackgroundMode(boolean paramBoolean)
  {
    if (!this.mInit) {
      UploadLog.d("ServiceImpl", "setBackgroundMode !mInit");
    }
    while (this.mWorkerThreadHandler == null) {
      return;
    }
    HandlerWapper localHandlerWapper = this.mWorkerThreadHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localHandlerWapper.obtainMessage(10, i, 0).sendToTarget();
      return;
    }
  }
  
  public void setTestServer(int paramInt)
  {
    if (!this.mInit) {
      UploadLog.d("ServiceImpl", "setTestServer !mInit");
    }
    while (this.mWorkerThreadHandler == null) {
      return;
    }
    this.mWorkerThreadHandler.obtainMessage(12, paramInt, 0).sendToTarget();
  }
  
  public boolean upload(AbstractUploadTask paramAbstractUploadTask)
  {
    synchronized (this.mUploadTasksLock)
    {
      this.mUploadTasksInLooper.append(paramAbstractUploadTask.flowId, paramAbstractUploadTask);
      if (!this.mInit)
      {
        UploadLog.d("ServiceImpl", "upload !mInit");
        return false;
      }
    }
    if (!Const.verifyUploadTask(paramAbstractUploadTask))
    {
      UploadLog.d("ServiceImpl", "upload !verifyUploadTask");
      synchronized (this.mUploadTasksLock)
      {
        this.mUploadTasksInLooper.remove(paramAbstractUploadTask.flowId);
        return false;
      }
    }
    this.mReadLock.lock();
    try
    {
      initWorkerThread();
      this.mWorkerThreadHandler.obtainMessage(0, paramAbstractUploadTask).sendToTarget();
      return true;
    }
    finally
    {
      this.mReadLock.unlock();
    }
  }
  
  private static final class Container
  {
    private static final UploadServiceImpl instance = new UploadServiceImpl(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.upload.biz.UploadServiceImpl
 * JD-Core Version:    0.7.0.1
 */