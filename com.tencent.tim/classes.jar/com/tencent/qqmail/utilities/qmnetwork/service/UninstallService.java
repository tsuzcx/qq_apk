package com.tencent.qqmail.utilities.qmnetwork.service;

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.IBinder;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.fileextention.FileDefine;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UninstallService
  extends Service
{
  private static String TAG = "UninstallService";
  public static final String WATCHDOG_DIRECTORY = FileDefine.INNER_DATA_DIR + "/exec/";
  public static final String WATCHDOG_FILE_NAME = "mail/mailwatchdog_v1.4";
  public static final String WATCHDOG_PATH = WATCHDOG_DIRECTORY + "mail/mailwatchdog_v1.4";
  public static final String WATCHDOG_PROCESS_NAME = "mailwatchdog";
  private static boolean started = false;
  
  public static void copyWatchDogForce()
  {
    QMLog.log(4, TAG, "copyWatchDogForce");
    File localFile = new File(WATCHDOG_PATH);
    tryCreateWatchDogDir(localFile);
    copyWatchDogForce(localFile);
  }
  
  public static boolean copyWatchDogForce(File paramFile)
  {
    try
    {
      if ((paramFile.exists()) && (!paramFile.delete())) {
        QMLog.log(4, TAG, "watch file delete fail");
      }
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(QMApplicationContext.sharedInstance().getResources().getAssets().open("mail/mailwatchdog_v1.4"));
      paramFile = new BufferedOutputStream(new FileOutputStream(paramFile));
      byte[] arrayOfByte = new byte[8096];
      for (;;)
      {
        int i = localBufferedInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramFile.write(arrayOfByte, 0, i);
      }
      return false;
    }
    catch (IOException paramFile)
    {
      QMLog.log(6, TAG, "copy mailwatchdog fail IOException:" + paramFile.toString());
      return false;
      paramFile.flush();
      paramFile.close();
      localBufferedInputStream.close();
      QMLog.log(4, TAG, "mailwatchdog copyed.");
      if (Runtime.getRuntime().exec("chmod 744 " + WATCHDOG_PATH).waitFor() == 0)
      {
        QMLog.log(4, TAG, "chmod ok");
        return true;
      }
      QMLog.log(6, TAG, "chmod fail");
      return false;
    }
    catch (InterruptedException paramFile)
    {
      QMLog.log(6, TAG, "copy mailwatchdog fail InterruptedException:" + paramFile.toString());
    }
  }
  
  private boolean copyWatchDogIfNeed()
  {
    File localFile = new File(WATCHDOG_PATH);
    if (localFile.exists()) {
      return true;
    }
    tryCreateWatchDogDir(localFile);
    return copyWatchDogForce(localFile);
  }
  
  private void killUninstallWatchService()
  {
    stopService();
    int i = android.os.Process.myPid();
    QMLog.log(4, TAG, "kill uninstall watcher process:" + i);
    android.os.Process.killProcess(i);
  }
  
  private void stopService()
  {
    QMLog.log(4, TAG, "stopService");
    stopSelf();
  }
  
  private static void tryCreateWatchDogDir(File paramFile)
  {
    paramFile = paramFile.getParentFile();
    if (!paramFile.exists())
    {
      boolean bool = paramFile.mkdirs();
      QMLog.log(4, TAG, "tryCreateWatchDogDir mkdir Success:" + bool + "," + paramFile.getAbsolutePath());
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    QMLog.log(4, TAG, "UninstallService. onCreate:");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (!started)
    {
      started = true;
      QMLog.log(4, TAG, "onStartCommand");
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      long l = QMApplicationContext.sharedInstance().getVid();
      paramIntent = QMApplicationContext.sharedInstance().getVidPwd();
      String str1 = CloudProtocolHelper.getDeviceId();
      String str2 = AppConfig.getCodeVersion();
      String str3 = DeviceUtil.getDeviceInfos().BRAND;
      QMLog.log(4, TAG, "Uninstall Service onStartCommand. vid:" + l + ",vidpwdLength:" + paramIntent.length() + ",deviceid:" + str1 + ",appversion:" + str2);
      paramIntent = new Thread(new UninstallService.1(this, l, paramIntent, str1, str2, str3));
      paramIntent.setName("UninstallServiceStartThread");
      paramIntent.start();
      return paramInt1;
    }
    QMLog.log(4, TAG, "UninstallService has started. return");
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.UninstallService
 * JD-Core Version:    0.7.0.1
 */