package com.tencent.tmdownloader;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tmassistant.common.PackageInstallReceiver;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.aa;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.k;
import com.tencent.tmassistantbase.util.m;
import com.tencent.tmassistantbase.util.s;
import com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import com.tencent.tmdownloader.internal.notification.NotifyParam;
import com.tencent.tmdownloader.internal.storage.d;
import java.util.HashMap;

public class TMAssistantDownloadService
  extends Service
  implements com.tencent.tmdownloader.internal.downloadservice.a.a
{
  private static final int MSG_HANDSHAKE_YYB = 1;
  private static final int MSG_INIT_YYBMG = 0;
  protected static final String TAG = "TMADownloadSDKService";
  protected final y downloadSDKServiceImpl = new y(this);
  protected final HashMap<com.tencent.tmassistant.aidl.a, String> mCallbackHashMap = new HashMap();
  protected final RemoteCallbackList<com.tencent.tmassistant.aidl.a> mCallbacks = new RemoteCallbackList();
  private Handler mHandler = new x(this);
  private m mLogListener = null;
  com.tencent.tmdownloader.internal.notification.a mNotificationManager = null;
  com.tencent.tmdownloader.internal.downloadservice.a.c mServiceDownloadTaskManager = null;
  private com.tencent.tmdownloader.internal.downloadclient.c yybManager = null;
  
  private boolean handlePush(NotifyParam paramNotifyParam)
  {
    switch (paramNotifyParam.notificationTypeId)
    {
    }
    for (;;)
    {
      return true;
      ApkDownloadManager.getInstance().pauseDownload(paramNotifyParam.url);
      continue;
      ApkDownloadManager.getInstance().continueDownload(paramNotifyParam.url);
      continue;
      paramNotifyParam = ApkDownloadManager.getInstance().queryDownloadInfo(paramNotifyParam.url);
      if (paramNotifyParam != null)
      {
        com.tencent.tmdownloader.internal.downloadservice.a.a(d.a(paramNotifyParam.j));
        com.tencent.tmdownloader.internal.notification.a.a().b(String.valueOf(paramNotifyParam.q));
        continue;
        ApkDownloadManager.getInstance().restartDownload(paramNotifyParam.url);
      }
    }
  }
  
  public void OnDownloadProgressChanged(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    label127:
    synchronized (this.mCallbacks)
    {
      try
      {
        int j = this.mCallbacks.beginBroadcast();
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label127;
          }
          try
          {
            com.tencent.tmassistant.aidl.a locala = (com.tencent.tmassistant.aidl.a)this.mCallbacks.getBroadcastItem(i);
            String str = (String)this.mCallbackHashMap.get(locala);
            if ((str != null) && (str.equals(paramString1) == true)) {
              locala.a(paramString1, paramString2, paramLong1, paramLong2);
            }
          }
          catch (RemoteException localRemoteException)
          {
            for (;;)
            {
              ab.c("TMADownloadSDKService", "exception: ", localRemoteException);
            }
          }
          i += 1;
        }
        this.mCallbacks.finishBroadcast();
      }
      catch (Throwable paramString1)
      {
        Log.e("TMADownloadSDKService", "exception: ", paramString1);
        ab.c("TMADownloadSDKService", "<OnDownloadProgressChanged>exit");
        return;
      }
    }
  }
  
  public void OnDownloadStateChanged(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    label129:
    synchronized (this.mCallbacks)
    {
      try
      {
        int j = this.mCallbacks.beginBroadcast();
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label129;
          }
          try
          {
            com.tencent.tmassistant.aidl.a locala = (com.tencent.tmassistant.aidl.a)this.mCallbacks.getBroadcastItem(i);
            String str = (String)this.mCallbackHashMap.get(locala);
            if ((str != null) && (str.equals(paramString1) == true)) {
              locala.a(paramString1, paramString2, paramInt1, paramInt2, paramString3);
            }
          }
          catch (RemoteException localRemoteException)
          {
            for (;;)
            {
              Log.e("TMADownloadSDKService", "exception: ", localRemoteException);
            }
          }
          i += 1;
        }
        this.mCallbacks.finishBroadcast();
      }
      catch (Throwable paramString1)
      {
        ab.c("TMADownloadSDKService", "exception: ", paramString1);
        ab.c("TMADownloadSDKService", "<OnDownloadStateChanged>exit");
        return;
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    ab.c("TMADownloadSDKService", "<onBind>enter");
    ab.c("TMADownloadSDKService", "<onBind>intent:" + paramIntent);
    ab.c("TMADownloadSDKService", "<onBind>returnValue: " + this.downloadSDKServiceImpl);
    ab.c("TMADownloadSDKService", "<onBind>exit");
    return this.downloadSDKServiceImpl;
  }
  
  public void onCreate()
  {
    long l = System.currentTimeMillis();
    ab.c("TMADownloadSDKService", "<onCreate>enter");
    super.onCreate();
    GlobalUtil.getInstance().setContext(this);
    NetworkMonitorReceiver.getInstance().registerReceiver();
    s.d();
    try
    {
      MobileQQCloseServiceReceiver.a().a(this);
      label38:
      k.a().post(new v(this));
      new Thread(new w(this)).start();
      aa.a("TMAssistantDownloadService.onCreate end, timeCost = " + (System.currentTimeMillis() - l));
      return;
    }
    catch (Throwable localThrowable)
    {
      break label38;
    }
  }
  
  public void onDestroy()
  {
    ab.c("TMADownloadSDKService", "<onDestroy>enter");
    super.onDestroy();
    ApkDownloadManager.getInstance().uninit();
    if (this.mServiceDownloadTaskManager != null)
    {
      this.mServiceDownloadTaskManager.b();
      this.mServiceDownloadTaskManager.a(null);
      this.mServiceDownloadTaskManager = null;
    }
    if (this.mNotificationManager != null)
    {
      this.mNotificationManager.c();
      this.mNotificationManager = null;
    }
    NetworkMonitorReceiver.getInstance().unregisterReceiver();
    GlobalUtil.getInstance().destroy();
    MobileQQCloseServiceReceiver.a().b(this);
    try
    {
      PackageInstallReceiver.a().b(this);
      label90:
      SystemClock.sleep(300L);
      ab.c("TMADownloadSDKService", "<onDestroy>exit");
      Process.killProcess(Process.myPid());
      return;
    }
    catch (Throwable localThrowable)
    {
      break label90;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    ab.c("TMADownloadSDKService", "onStartCommand......");
    if (paramIntent != null) {}
    for (;;)
    {
      try
      {
        localObject1 = paramIntent.getStringExtra("client_key");
      }
      catch (Exception localException)
      {
        try
        {
          Object localObject1;
          localNotifyParam = (NotifyParam)paramIntent.getParcelableExtra("notifyParam");
          paramIntent = (Intent)localObject1;
          if (localNotifyParam != null)
          {
            if (!TextUtils.isEmpty(localNotifyParam.url))
            {
              handlePush(localNotifyParam);
              paramIntent = (Intent)localObject1;
            }
          }
          else
          {
            ab.c("TMADownloadSDKService", "onStartCommand......clientKey : " + paramIntent);
            localObject1 = new Message();
            ((Message)localObject1).what = 0;
            ((Message)localObject1).obj = paramIntent;
            this.mHandler.sendMessage((Message)localObject1);
          }
          return 2;
          localException = localException;
          localException.printStackTrace();
          Object localObject2 = null;
          continue;
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
          NotifyParam localNotifyParam = null;
          continue;
        }
      }
      paramIntent = null;
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    ab.c("TMADownloadSDKService", "<onUnbind>enter");
    ab.c("TMADownloadSDKService", "<onUnbind>intent:" + paramIntent);
    boolean bool = super.onUnbind(paramIntent);
    ab.c("TMADownloadSDKService", "<onUnbind>returnValue: " + bool);
    ab.c("TMADownloadSDKService", "<onUnbind>exit");
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.TMAssistantDownloadService
 * JD-Core Version:    0.7.0.1
 */