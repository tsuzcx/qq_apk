package com.tencent.qqmail.utilities.ui;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.ftn.activity.FtnListActivity;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

public class QMFtnUploadNotification
{
  private static final int STATE_ERROR = 3;
  private static final int STATE_FINISH = 4;
  private static final int STATE_PENDING = 4;
  private static final int STATE_SUCCESS = 1;
  private static final int STATE_UPLOADING = 2;
  private static final String TAG = "QMFtnUploadNotification";
  private static final QMFtnUploadNotification instance = new QMFtnUploadNotification();
  private PendingIntent contentIntent;
  private Context context = QMApplicationContext.sharedInstance();
  private boolean needUpdate;
  private Notification notification;
  private String notifyContent;
  private NotificationManager notifyMgr = (NotificationManager)this.context.getSystemService("notification");
  private String notifyTitle;
  private int state;
  private String tickerText;
  
  public QMFtnUploadNotification()
  {
    initContentIntent(null);
  }
  
  private void clearNotification()
  {
    this.notifyMgr.cancel(28000000);
  }
  
  private void finishNotify()
  {
    reset();
  }
  
  public static QMFtnUploadNotification getInstance()
  {
    return instance;
  }
  
  private void handleError(String paramString)
  {
    this.state = 3;
    Log.d("yahuang", "notify-state set error st: " + this.state);
    this.tickerText = paramString;
    this.notifyTitle = "文件上传失败";
    this.notifyContent = paramString;
    processNotify();
  }
  
  private void handleSuccess(String paramString)
  {
    this.state = 1;
    this.tickerText = "文件上传成功";
    this.notifyTitle = paramString;
    this.notifyContent = "";
    processNotify();
    Threads.runOnMainThread(new QMFtnUploadNotification.6(this), 3000L);
  }
  
  private void handleUpload(String paramString)
  {
    this.state = 2;
    this.tickerText = "文件正在上传";
    this.notifyTitle = paramString;
    this.notifyContent = "";
    this.needUpdate = true;
    processNotify();
  }
  
  private void initContentIntent(Intent paramIntent)
  {
    if (this.contentIntent != null) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent(this.context, FtnListActivity.class);
    }
    localIntent.putExtra("fromNoti", true);
    localIntent.addFlags(536870912);
    this.contentIntent = PendingIntent.getActivity(this.context, 0, localIntent, 0);
  }
  
  private void processNotify()
  {
    QMLog.log(3, "QMFtnUploadNotification", "processNotify, state: " + this.state);
    int i;
    if ((this.state == 2) && (this.needUpdate))
    {
      this.needUpdate = false;
      Object localObject = new Notification.Builder(this.context);
      if (BrandUtil.isColorfulNotificationIcon())
      {
        i = 2130840992;
        ((Notification.Builder)localObject).setSmallIcon(i).setContentTitle(this.notifyTitle).setContentText(this.notifyContent);
        this.notification = ((Notification.Builder)localObject).build();
        this.notification.icon = 2130850532;
        this.notification.tickerText = this.tickerText;
        this.notification.contentIntent = this.contentIntent;
        localObject = this.notification;
        ((Notification)localObject).flags |= 0x2;
        this.notifyMgr.notify(28000000, this.notification);
      }
    }
    do
    {
      return;
      i = 2130841012;
      break;
      if (this.state == 1)
      {
        clearNotification();
        QMNotificationConstructor.getInstance().notify(12041688, this.tickerText, this.notifyTitle, this.notifyContent, 2130841013, this.contentIntent, true);
        finishNotify();
        this.state = 4;
        return;
      }
    } while ((this.state != 3) || (this.notification == null));
    clearNotification();
    QMNotificationConstructor.getInstance().notify(12041688, this.tickerText, this.notifyTitle, this.notifyContent, 2130841014, this.contentIntent, false);
    finishNotify();
    this.state = 3;
  }
  
  private void reset()
  {
    this.needUpdate = false;
    this.notifyTitle = "";
    this.notifyContent = "";
    this.tickerText = "";
  }
  
  public void cancel()
  {
    Threads.runOnMainThread(new QMFtnUploadNotification.3(this));
  }
  
  public boolean clearErrorNotification()
  {
    if (this.state == 3)
    {
      Threads.runOnMainThread(new QMFtnUploadNotification.5(this));
      return true;
    }
    return false;
  }
  
  public void error(String paramString)
  {
    Threads.runOnMainThread(new QMFtnUploadNotification.2(this, paramString));
  }
  
  public void recycle()
  {
    stopNotification();
    this.notifyMgr = null;
    this.notification = null;
    this.contentIntent = null;
  }
  
  public void stopNotification()
  {
    Threads.runOnMainThread(new QMFtnUploadNotification.7(this));
  }
  
  public void success(String paramString)
  {
    Threads.runOnMainThread(new QMFtnUploadNotification.1(this, paramString));
  }
  
  public void uploading(String paramString)
  {
    Threads.runOnMainThread(new QMFtnUploadNotification.4(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMFtnUploadNotification
 * JD-Core Version:    0.7.0.1
 */