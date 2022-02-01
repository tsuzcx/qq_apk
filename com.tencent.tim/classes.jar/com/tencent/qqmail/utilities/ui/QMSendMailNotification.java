package com.tencent.qqmail.utilities.ui;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.launcher.third.LaunchWebPush;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;

public class QMSendMailNotification
{
  private static final int STATE_ERROR = 4;
  private static final int STATE_FINISHING = 5;
  private static final int STATE_PENDING = 0;
  private static final int STATE_RUNNING = 2;
  private static final int STATE_STARTING = 1;
  private static final int STATE_SUCCESS = 3;
  public static final int TYPE_SENDMAIL = 0;
  public static final int TYPE_SENDNOTE = 1;
  private static final int UPDATE_PROGRESS_GAP = 2;
  private static final QMSendMailNotification instance = new QMSendMailNotification();
  private static Notification.Builder notificationBuilder;
  private PendingIntent contentIntent;
  private String contentText;
  private String contentTitle;
  private Context context = QMApplicationContext.sharedInstance();
  private int currentSendingMailIndex;
  private final ArrayList<String> errorMessageList = new ArrayList();
  private final ArrayList<String> errorSubjectList = new ArrayList();
  private int mailForSendCount;
  private boolean needUpdate;
  private Notification notification;
  private NotificationManager notifyMgr = (NotificationManager)this.context.getSystemService("notification");
  private int progress;
  private int state;
  private String stringSendMailContentText = this.context.getResources().getString(2131696466);
  private String stringSendMailContentTextMulti = this.context.getResources().getString(2131696467);
  private String stringSendMailTitle = this.context.getResources().getString(2131696468);
  private String stringSendNoteContentText = this.context.getResources().getString(2131696473);
  private String stringSendNoteContentTextMulti = this.context.getResources().getString(2131696474);
  private String stringSendNoteTitle = this.context.getResources().getString(2131696475);
  private String tickerText;
  
  private QMSendMailNotification()
  {
    initContentIntent(null);
    reset();
  }
  
  private void finishedRoutine()
  {
    reset();
  }
  
  public static QMSendMailNotification getInstance()
  {
    return instance;
  }
  
  private void handleError(String paramString, int paramInt, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    this.state = 4;
    Context localContext = this.context;
    int i;
    if (isSendMail(paramInt))
    {
      i = 2131696462;
      this.tickerText = localContext.getString(i);
      if (!isSendMail(paramInt)) {
        break label125;
      }
      DataCollector.logException(7, 48, "Event_Error", this.tickerText, true);
    }
    for (;;)
    {
      this.contentTitle = paramString;
      this.progress = ((int)(this.currentSendingMailIndex / this.mailForSendCount) * 100);
      this.errorSubjectList.clear();
      this.errorSubjectList.addAll(paramArrayList1);
      this.errorMessageList.clear();
      this.errorMessageList.addAll(paramArrayList2);
      processRoutine();
      return;
      i = 2131696472;
      break;
      label125:
      DataCollector.logException(7, 49, "Event_Error", this.tickerText, true);
    }
  }
  
  private void handleSuccess(String paramString1, String paramString2, int paramInt)
  {
    this.state = 3;
    this.tickerText = paramString1;
    this.contentTitle = paramString2;
    this.contentText = "";
    this.progress = 100;
    processRoutine();
    if (isSendMail(paramInt))
    {
      DataCollector.logPerformanceEnd("Performance_Send", "");
      Threads.runOnMainThread(new QMSendMailNotification.7(this), 3000L);
    }
  }
  
  private void handleUpdateSendMailCount(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.state == 5) || (this.state == 4)) {
      reset();
    }
    int i;
    if ((this.currentSendingMailIndex != paramInt1) || (this.mailForSendCount != paramInt2))
    {
      this.needUpdate = true;
      i = this.currentSendingMailIndex;
      this.currentSendingMailIndex = paramInt1;
      this.mailForSendCount = paramInt2;
      if (!isSendMail(paramInt3)) {
        break label175;
      }
      this.contentTitle = this.stringSendMailTitle;
      if (this.mailForSendCount <= 1) {
        break label147;
      }
      this.contentText = String.format(this.stringSendMailContentTextMulti, new Object[] { Integer.valueOf(this.currentSendingMailIndex), Integer.valueOf(this.mailForSendCount), Integer.valueOf(this.progress) });
    }
    for (;;)
    {
      if ((i != paramInt1) && (paramInt2 > 0)) {
        handleUpdateSendMailProgress(0.0D, paramInt3);
      }
      processRoutine();
      return;
      label147:
      this.contentText = String.format(this.stringSendMailContentText, new Object[] { Integer.valueOf(this.progress) });
      continue;
      label175:
      this.contentTitle = this.stringSendNoteTitle;
      if (this.mailForSendCount > 1) {
        this.contentText = String.format(this.stringSendNoteContentTextMulti, new Object[] { Integer.valueOf(this.currentSendingMailIndex), Integer.valueOf(this.mailForSendCount), Integer.valueOf(this.progress) });
      } else {
        this.contentText = String.format(this.stringSendNoteContentText, new Object[] { Integer.valueOf(this.progress) });
      }
    }
  }
  
  private void handleUpdateSendMailProgress(double paramDouble, int paramInt)
  {
    int j = (int)(100.0D * paramDouble);
    int i = j;
    if (j > 100) {
      i = 100;
    }
    if ((Math.abs(i - this.progress) >= 2) || ((i == 100) && (i != this.progress)))
    {
      this.needUpdate = true;
      this.progress = i;
      if (!isSendMail(paramInt)) {
        break label210;
      }
      this.contentTitle = this.stringSendMailTitle;
      if (this.mailForSendCount <= 1) {
        break label182;
      }
      this.contentText = String.format(this.stringSendMailContentTextMulti, new Object[] { Integer.valueOf(this.currentSendingMailIndex), Integer.valueOf(this.mailForSendCount), Integer.valueOf(this.progress) });
    }
    while ((this.state == 0) || (this.state == 4))
    {
      if ((this.state == 0) && (notificationBuilder != null)) {
        notificationBuilder.setWhen(System.currentTimeMillis());
      }
      this.state = 1;
      setStateToStart(paramInt);
      return;
      label182:
      this.contentText = String.format(this.stringSendMailContentText, new Object[] { Integer.valueOf(this.progress) });
      continue;
      label210:
      this.contentTitle = this.stringSendNoteTitle;
      if (this.mailForSendCount > 1) {
        this.contentText = String.format(this.stringSendNoteContentTextMulti, new Object[] { Integer.valueOf(this.currentSendingMailIndex), Integer.valueOf(this.mailForSendCount), Integer.valueOf(this.progress) });
      } else {
        this.contentText = String.format(this.stringSendNoteContentText, new Object[] { Integer.valueOf(this.progress) });
      }
    }
    processRoutine();
  }
  
  @SuppressLint({"InlinedApi"})
  private void initContentIntent(Intent paramIntent)
  {
    if (this.contentIntent != null) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = LaunchWebPush.createSendMailListIntent();
    }
    this.contentIntent = PendingIntent.getActivity(this.context, 0, localIntent, 268435456);
  }
  
  private boolean isSendMail(int paramInt)
  {
    return paramInt == 0;
  }
  
  private void processRoutine()
  {
    if ((this.state == 2) && (this.needUpdate))
    {
      this.needUpdate = false;
      if (notificationBuilder == null) {
        notificationBuilder = new Notification.Builder(this.context);
      }
      if (Build.VERSION.SDK_INT >= 21) {
        notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(this.context.getResources(), 2130840992));
      }
      notificationBuilder.setSmallIcon(QMAppInterface.sharedInstance().getNtId()).setContentTitle(this.contentTitle).setOngoing(true).setContentText(this.contentText);
    }
    label116:
    do
    {
      try
      {
        if (this.progress <= 0) {
          notificationBuilder.setProgress(0, 0, true);
        }
        for (;;)
        {
          this.notification = notificationBuilder.build();
          this.notification.icon = 2130850525;
          this.notification.tickerText = this.tickerText;
          this.notification.contentIntent = this.contentIntent;
          Notification localNotification = this.notification;
          localNotification.flags |= 0x2;
          localNotification = this.notification;
          localNotification.flags |= 0x20;
          QMLog.log(4, "SendMailNotification", "tickertext: " + this.tickerText + ", progress: " + this.progress);
          this.notifyMgr.notify(27000000, this.notification);
          return;
          notificationBuilder.setProgress(100, this.progress, false);
        }
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        break label116;
      }
      if (this.state == 3)
      {
        this.state = 5;
        clearNotification();
        QMNotificationConstructor.getInstance().notifySendMail(this.tickerText, this.tickerText, this.contentTitle, 2130841013, this.contentIntent, true, null, null);
        finishedRoutine();
        return;
      }
    } while (this.state != 4);
    if (this.notification == null)
    {
      QMLog.log(6, "notificationcore", "notificationcore");
      return;
    }
    clearNotification();
    int i = this.errorSubjectList.size();
    String str = "";
    StringBuilder localStringBuilder;
    if (i > 0)
    {
      localStringBuilder = new StringBuilder().append("").append((String)this.errorSubjectList.get(0));
      if (i <= 1) {
        break label476;
      }
    }
    label476:
    for (str = " " + this.context.getString(2131690305);; str = "")
    {
      str = str;
      QMNotificationConstructor.getInstance().notifySendMail(this.tickerText, this.contentTitle, str, 2130841014, this.contentIntent, false, this.errorSubjectList, this.errorMessageList);
      finishedRoutine();
      this.state = 4;
      return;
    }
  }
  
  private void reset()
  {
    this.currentSendingMailIndex = 0;
    this.mailForSendCount = 0;
    this.progress = 0;
    this.state = 0;
    this.needUpdate = false;
    this.tickerText = "";
    this.contentTitle = "";
    this.contentText = "";
  }
  
  private void setStateToStart(int paramInt)
  {
    if (this.state != 1) {
      return;
    }
    this.state = 2;
    if (isSendMail(paramInt))
    {
      this.tickerText = this.stringSendMailTitle;
      this.contentTitle = this.stringSendMailTitle;
      if (this.mailForSendCount > 1) {
        this.contentText = String.format(this.stringSendMailContentTextMulti, new Object[] { Integer.valueOf(this.currentSendingMailIndex), Integer.valueOf(this.mailForSendCount), Integer.valueOf(this.progress) });
      }
    }
    for (;;)
    {
      processRoutine();
      return;
      this.contentText = String.format(this.stringSendMailContentText, new Object[] { Integer.valueOf(this.progress) });
      continue;
      this.tickerText = this.stringSendNoteTitle;
      this.contentTitle = this.stringSendNoteTitle;
      if (this.mailForSendCount > 1) {
        this.contentText = String.format(this.stringSendNoteContentTextMulti, new Object[] { Integer.valueOf(this.currentSendingMailIndex), Integer.valueOf(this.mailForSendCount), Integer.valueOf(this.progress) });
      } else {
        this.contentText = String.format(this.stringSendNoteContentText, new Object[] { Integer.valueOf(this.progress) });
      }
    }
  }
  
  public void clearAllNotification()
  {
    this.notifyMgr.cancelAll();
  }
  
  public boolean clearErrorNotification()
  {
    if (this.state == 4)
    {
      Threads.runOnMainThread(new QMSendMailNotification.5(this));
      return true;
    }
    return false;
  }
  
  public void clearNotification()
  {
    this.notifyMgr.cancel(27000000);
  }
  
  public void error(String paramString, int paramInt, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    Threads.runOnMainThread(new QMSendMailNotification.4(this, paramString, paramInt, new ArrayList(paramArrayList1), new ArrayList(paramArrayList2)));
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
    Threads.runOnMainThread(new QMSendMailNotification.6(this));
  }
  
  public void success(String paramString1, String paramString2, int paramInt)
  {
    Threads.runOnMainThread(new QMSendMailNotification.3(this, paramString1, paramString2, paramInt));
  }
  
  public void updateSendMailNumber(int paramInt1, int paramInt2, int paramInt3)
  {
    Threads.runOnMainThread(new QMSendMailNotification.1(this, paramInt1, paramInt2, paramInt3));
  }
  
  public void updateSendMailProgress(double paramDouble, int paramInt)
  {
    Threads.runOnMainThread(new QMSendMailNotification.2(this, paramDouble, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMSendMailNotification
 * JD-Core Version:    0.7.0.1
 */