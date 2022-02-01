package com.tencent.qqmail.utilities.cacheclear;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.QMPackageSizeManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.BaseService;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ClearCacheService
  extends BaseService
{
  public static final String CACHE_PATHS_DELETED_LIST = "cache_paths_deleted_list";
  public static final String CACHE_PATHS_TO_DELETE = "cache_paths_to_delete";
  public static final int CLIENT_REGISTER = 0;
  private static final int COMMAND_ALERT_SPACE = 2;
  private static final int COMMAND_CLEAR_CACHE_UPGRADE = 1;
  private static final String KEY_COMMAND = "command";
  public static final int RESULT_BACK = 0;
  public static final int SUBMIT_CLEAR_TASK = 1;
  public static final String TAG = "ClearCacheService";
  private Messenger mClient;
  private Messenger mMessenger;
  private HandlerThread mThread = new HandlerThread("ClearCache");
  
  public static Intent createAlertSpaceIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), ClearCacheService.class).putExtra("command", 2);
  }
  
  public static Intent createIntentForUpgrade()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ClearCacheService.class);
    localIntent.putExtra("command", 1);
    return localIntent;
  }
  
  private void resultCallback(ArrayList<String> paramArrayList)
  {
    QMLog.log(4, "ClearCacheService", "result callback, delete size : " + paramArrayList.size());
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("cache_paths_deleted_list", paramArrayList);
    localMessage.setData(localBundle);
    try
    {
      this.mClient.send(localMessage);
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(5, "ClearCacheService", "result callback error!! delete size : " + paramArrayList.size(), localException);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mMessenger.getBinder();
  }
  
  public void onCreate()
  {
    QMLog.log(4, "ClearCacheService", "onCreate");
    super.onCreate();
    this.mThread.start();
    this.mMessenger = new Messenger(new IncomingHandler(this.mThread.getLooper(), this));
  }
  
  public void onDestroy()
  {
    this.mThread.quit();
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramIntent = SafeIntent.createSafeIntet(paramIntent);
    int i;
    if (paramIntent == null)
    {
      i = -1;
      QMLog.log(4, "ClearCacheService", "onStartCommand, command: " + i);
      switch (i)
      {
      }
    }
    for (;;)
    {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      i = paramIntent.getIntExtra("command", 0);
      break;
      Threads.runInBackground(new ClearCacheService.1(this));
      continue;
      long[] arrayOfLong = QMPackageSizeManager.getAvailableAndTotalSize(Environment.getDataDirectory().getPath());
      if (arrayOfLong[0] <= 10485760L) {
        Toast.makeText(QMApplicationContext.sharedInstance(), "存储空间不足，QQ邮箱可能无法正常使用，请及时清理", 1).show();
      }
      QMLog.log(4, "ClearCacheService", "alert space, total: " + arrayOfLong[1] + ", available: " + arrayOfLong[0]);
    }
  }
  
  static class IncomingHandler
    extends Handler
  {
    WeakReference<ClearCacheService> mOut;
    
    IncomingHandler(Looper paramLooper, ClearCacheService paramClearCacheService)
    {
      super();
      this.mOut = new WeakReference(paramClearCacheService);
    }
    
    public void handleMessage(Message paramMessage)
    {
      ClearCacheService localClearCacheService = (ClearCacheService)this.mOut.get();
      if ((localClearCacheService == null) || (paramMessage == null)) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        ClearCacheService.access$002(localClearCacheService, paramMessage.replyTo);
        return;
      }
      paramMessage = paramMessage.getData().getStringArrayList("cache_paths_to_delete");
      QMLog.log(4, "ClearCacheService", "start clear task");
      QMClearCacheManager.clearFileCache(paramMessage, new ClearCacheService.IncomingHandler.1(this, localClearCacheService));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.cacheclear.ClearCacheService
 * JD-Core Version:    0.7.0.1
 */