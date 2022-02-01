package com.tencent.qqmail.utilities.ui;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.Notification.Style;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.Html;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.reminder.QMRemindererBroadcast;
import com.tencent.qqmail.download.activity.DownloadActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.pushconfig.QMBetaPushConfig;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.PushSchemaBody;
import com.tencent.qqmail.utilities.thread.Threads;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class QMNotificationConstructor
{
  private static final int BIT_NOTE_FTN_SOUND = 32;
  private static final int BIT_NOTE_FTN_VIBRATE = 64;
  private static final int BIT_PUSH_SOUND = 1;
  private static final int BIT_PUSH_VIBRATE = 2;
  private static final int BIT_SENDMAIL_SOUND = 8;
  private static final int BIT_SENDMAIL_VIBRATE = 16;
  public static final int BONUS_LOW_MEM = 29054322;
  public static final int BONUS_MEM_MONITOR = 29054321;
  public static final int CREDITCARD_ID = 12041689;
  public static final int FTNUPLOAD_ID = 12041688;
  public static final int FTN_UPLOAD_NOTIF_ID = 28000000;
  private static final int MASK_NOTE_FTN_MODE = 96;
  private static final int MASK_PUSH_MODE = 7;
  private static final int MASK_SENDMAIL_MODE = 24;
  public static final int MAX_SECTION_VALUE = 1000000;
  private static final int PUSH_BETA_BASE_ID = 25000000;
  private static final int PUSH_BOTTLE_BASE_ID = 17000000;
  private static final int PUSH_CALENDAR_BASE_ID = 18000000;
  private static final int PUSH_COMMON_BASE_ID = 26000000;
  private static final int PUSH_DEFAULT_ID = 12041683;
  public static final int PUSH_DEVICE_ERROR_BASE_ID = 14000000;
  private static final int PUSH_DIAL_BASE_ID = 19000000;
  private static final int PUSH_FTN_BASE_ID = 12000000;
  private static final int PUSH_GOTO_FTN_ID = 12041687;
  private static final int PUSH_GOTO_READNOTE_ID = 12041686;
  private static int PUSH_ID = 12041683;
  private static final int PUSH_IMAGE_BASE_ID = 13000000;
  private static final int PUSH_IMAGE_ID = 12041681;
  public static final int PUSH_MAIL_BASE_ID = 15000000;
  private static final int PUSH_MUSIC_ID = 12041682;
  private static final int PUSH_NEWMAIL_ID = 12041680;
  private static final int PUSH_NOTE_BASE_ID = 11000000;
  private static final int PUSH_PROGRESS_ID = 12041684;
  public static final int PUSH_PWD_ERROR_BASE_ID = 16000000;
  private static final int PUSH_SCAN_FILE_BASE_ID = 13000001;
  private static final int PUSH_SCHEMA_BASE_ID = 20000000;
  private static final int PUSH_WEIYUN_BASE_ID = 21000000;
  public static final int SENDMAIL_ID = 12041685;
  public static final int SEND_MAIL_NOTIF_ID = 27000000;
  public static final int SSL_ERROR_ID = 28000001;
  private static final String TAG = "QMNotificationConstructor";
  private static QMNotificationConstructor sInstance = new QMNotificationConstructor();
  private Notification.Builder builder;
  private String contentInfo;
  private PendingIntent contentIntent;
  private String contentText;
  private String contentTitle;
  private Context context = QMApplicationContext.sharedInstance();
  private int defaultMode;
  private int icon;
  private int largeIcon;
  private AudioManager mAudioManager = (AudioManager)QMApplicationContext.sharedInstance().getSystemService("audio");
  private Notification notification;
  private int notificationFlag;
  private NotificationManager notificationManager = (NotificationManager)this.context.getSystemService("notification");
  private int resetNotification;
  private int smallIcon;
  private Uri soundUri;
  private String tickerText;
  
  private QMNotificationConstructor()
  {
    resetNotificationData();
    initContentIntent();
  }
  
  private void createNotification(int paramInt, boolean paramBoolean)
  {
    try
    {
      if ((this.resetNotification != 0) || (this.notification == null))
      {
        this.builder = new Notification.Builder(this.context);
        if (this.contentTitle != null) {
          this.builder.setContentTitle(this.contentTitle);
        }
        if (this.contentText != null) {
          this.builder.setContentText(this.contentText);
        }
        if (this.contentInfo != null) {
          this.builder.setContentInfo(this.contentInfo);
        }
        if (this.smallIcon > 0) {
          this.builder.setSmallIcon(QMAppInterface.sharedInstance().getNtId());
        }
        if (this.largeIcon > 0) {
          this.builder.setLargeIcon(BitmapFactory.decodeResource(this.context.getResources(), this.largeIcon));
        }
        this.notification = this.builder.build();
        getNotificationMode(this.notification);
        if (this.contentIntent != null) {
          this.notification.contentIntent = this.contentIntent;
        }
        if (this.tickerText != null) {
          this.notification.tickerText = this.tickerText;
        }
        if (this.icon > 0) {
          this.notification.icon = this.icon;
        }
        if (this.notificationFlag != -1) {
          this.notification.flags = this.notificationFlag;
        }
      }
      PUSH_ID = paramInt;
      if (!paramBoolean) {
        this.notificationManager.notify(paramInt, this.notification);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static Spanned formatSubjectAndContent(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (paramInt == -1)
    {
      localObject = "";
      localObject = localStringBuilder.append((String)localObject);
      if (paramString1 != null) {
        break label104;
      }
      paramString1 = "";
      label33:
      localObject = ((StringBuilder)localObject).append(paramString1);
      if (paramInt != -1) {
        break label136;
      }
      paramString1 = " ";
      label48:
      localObject = ((StringBuilder)localObject).append(paramString1);
      if (paramString2 != null) {
        break label143;
      }
    }
    label136:
    label143:
    for (paramString1 = "";; paramString1 = paramString2.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;"))
    {
      return Html.fromHtml(paramString1);
      localObject = "<font color=\"" + paramInt + "\">";
      break;
      label104:
      paramString1 = paramString1.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
      break label33;
      paramString1 = "</font> ";
      break label48;
    }
  }
  
  public static int getDeviceErrorNotificationId(int paramInt)
  {
    return 14000000 + paramInt;
  }
  
  public static QMNotificationConstructor getInstance()
  {
    return sInstance;
  }
  
  private void getNotificationMode(Notification paramNotification)
  {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    paramNotification.defaults = 0;
    if ((this.defaultMode & 0x7) != 0) {
      if ((this.defaultMode & 0x1) != 0)
      {
        if (this.soundUri == null) {
          paramNotification.defaults |= 0x1;
        }
      }
      else
      {
        if ((this.defaultMode & 0x2) == 0) {
          break label103;
        }
        paramNotification.vibrate = new long[] { 200L, 200L, 200L, 200L };
      }
    }
    for (;;)
    {
      return;
      paramNotification.sound = this.soundUri;
      break;
      label103:
      paramNotification.vibrate = null;
      return;
      if ((this.defaultMode & 0x18) != 0)
      {
        if ((this.defaultMode & 0x8) != 0)
        {
          paramNotification.sound = Uri.parse("android.resource://" + this.context.getPackageName() + "/" + 2131230741);
          paramNotification.vibrate = new long[] { 200L, 200L, 200L, 200L };
        }
        while ((this.defaultMode & 0x10) != 0)
        {
          paramNotification.defaults |= 0x2;
          return;
          paramNotification.sound = null;
        }
      }
    }
  }
  
  public static int getPasswordErrorNotificationId(int paramInt)
  {
    return 16000000 + paramInt;
  }
  
  public static int getTextAppearanceStatusBarEventContentEmphasis()
  {
    Object localObject = QMApplicationContext.sharedInstance();
    int j = -1;
    ColorStateList localColorStateList = new TextAppearanceSpan((Context)localObject, 16973927).getTextColor();
    localObject = new TextAppearanceSpan((Context)localObject, 16973928).getTextColor();
    int i = j;
    if (localColorStateList != null)
    {
      i = j;
      if (localObject != null)
      {
        i = localColorStateList.getDefaultColor();
        j = ((ColorStateList)localObject).getDefaultColor();
        i = Color.argb((Color.alpha(i) + Color.alpha(j)) / 2, (Color.red(i) + Color.red(j)) / 2, (Color.green(i) + Color.green(j)) / 2, (Color.blue(i) + Color.blue(j)) / 2);
      }
    }
    return i;
  }
  
  private void initContentIntent()
  {
    if (this.contentIntent == null) {
      this.contentIntent = PendingIntent.getActivity(this.context, 12041683, new Intent(), 134217728);
    }
  }
  
  private void notifySimplePush(String paramString1, String paramString2, String paramString3, String paramString4, PendingIntent paramPendingIntent, int paramInt)
  {
    Notification.Builder localBuilder = new Notification.Builder(this.context);
    localBuilder.setSmallIcon(QMAppInterface.sharedInstance().getNtId()).setContentTitle(paramString1).setContentText(paramString2).setContentIntent(paramPendingIntent);
    localBuilder.setLargeIcon(BitmapFactory.decodeResource(this.context.getResources(), 2130840992));
    if (paramString3 != null) {
      localBuilder.setContentInfo(paramString3);
    }
    if (paramString4 != null) {
      localBuilder.setTicker(paramString4);
    }
    paramString1 = localBuilder.build();
    if ((!AppStatusUtil.isScreenLocked()) && (AppStatusUtil.isAppOnForeground())) {
      paramString1.defaults = 2;
    }
    try
    {
      for (;;)
      {
        paramString2 = paramString1.getClass().getDeclaredField("extraNotification").get(paramString1);
        paramString2.getClass().getDeclaredMethod("setMessageCount", new Class[] { Integer.TYPE }).invoke(paramString2, new Object[] { Integer.valueOf(0) });
        paramString1.flags |= 0x10;
        this.notificationManager.notify(paramInt, paramString1);
        return;
        paramString1.defaults = 3;
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
  
  private void resetNotificationData()
  {
    this.smallIcon = -1;
    this.largeIcon = -1;
    this.contentTitle = null;
    this.contentText = null;
    this.contentInfo = null;
    this.contentIntent = null;
    this.icon = -1;
    this.tickerText = null;
    this.defaultMode = 0;
    this.notificationFlag = -1;
    this.resetNotification = 0;
  }
  
  public void clearAllCalendar()
  {
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      this.notificationManager.cancel(localAccount.getId() + 18000000);
    }
  }
  
  public void clearAllFtn()
  {
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      this.notificationManager.cancel(localAccount.getId() + 12000000);
    }
  }
  
  public void clearAllImage()
  {
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      this.notificationManager.cancel(localAccount.getId() + 13000000);
    }
  }
  
  public void clearAllNote()
  {
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      this.notificationManager.cancel(localAccount.getId() + 11000000);
    }
  }
  
  public void clearAllNotify()
  {
    if (this.notificationManager != null)
    {
      this.notificationManager.cancel(12041680);
      this.notificationManager.cancel(12041681);
      this.notificationManager.cancel(12041685);
      this.notificationManager.cancel(12041682);
      this.notificationManager.cancel(12041688);
      this.notificationManager.cancel(25000000);
      this.notificationManager.cancel(12041689);
      Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
      while (localIterator.hasNext())
      {
        Account localAccount = (Account)localIterator.next();
        this.notificationManager.cancel(13000001 + localAccount.getId());
        this.notificationManager.cancel(localAccount.getId() + 13000000);
      }
    }
  }
  
  public void clearAllPushNewMail()
  {
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    while (localIterator.hasNext()) {
      clearPushNewMail(((Account)localIterator.next()).getId());
    }
  }
  
  public void clearBottleSendNotify()
  {
    if (this.notificationManager != null) {
      this.notificationManager.cancel(17000000);
    }
  }
  
  public void clearCalendarPushNotifyList()
  {
    int i = 0;
    while (i < QMRemindererBroadcast.myCalendarPushNotifyList.size())
    {
      this.notificationManager.cancel(((Integer)QMRemindererBroadcast.myCalendarPushNotifyList.get(i)).intValue() + 18000000);
      i += 1;
    }
    QMRemindererBroadcast.myCalendarPushNotifyList.clear();
  }
  
  public void clearFtnUploadNotify()
  {
    if (this.notificationManager != null) {
      this.notificationManager.cancel(12041688);
    }
  }
  
  public void clearNewMailNotify(int paramInt)
  {
    if (this.notificationManager != null) {
      this.notificationManager.cancel(paramInt);
    }
  }
  
  public void clearNewMailNotify(boolean paramBoolean)
  {
    NotificationManager localNotificationManager;
    if (this.notificationManager != null)
    {
      localNotificationManager = this.notificationManager;
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (int i = 12041680;; i = 12041681)
    {
      localNotificationManager.cancel(i);
      return;
    }
  }
  
  public void clearNotify()
  {
    if (this.notificationManager != null) {
      this.notificationManager.cancel(PUSH_ID);
    }
  }
  
  public void clearNotifyDelay(long paramLong)
  {
    Threads.runOnMainThread(new QMNotificationConstructor.3(this), paramLong);
  }
  
  public void clearPushBottleNotify(int paramInt)
  {
    this.notificationManager.cancel(17000000 + paramInt % 1000000);
  }
  
  public void clearPushNewMail(int paramInt)
  {
    this.notificationManager.cancel(15000000 + paramInt);
  }
  
  public void clearPushNewMailWithNotificationId(int paramInt)
  {
    this.notificationManager.cancel(paramInt);
  }
  
  public void clearSendMailNotify()
  {
    if (this.notificationManager != null)
    {
      this.notificationManager.cancel(12041680);
      this.notificationManager.cancel(12041681);
    }
  }
  
  void createFtnNotification()
  {
    try
    {
      if ((this.resetNotification != 0) || (this.notification == null))
      {
        this.builder = new Notification.Builder(this.context);
        if (this.contentTitle != null) {
          this.builder.setContentTitle(this.contentTitle);
        }
        if (this.contentText != null) {
          this.builder.setContentText(this.contentText);
        }
        if (this.contentInfo != null) {
          this.builder.setContentInfo(this.contentInfo);
        }
        if (this.smallIcon > 0) {
          this.builder.setSmallIcon(this.smallIcon);
        }
        if (this.largeIcon > 0) {
          this.builder.setLargeIcon(BitmapFactory.decodeResource(this.context.getResources(), this.largeIcon));
        }
        if (this.contentTitle != null) {
          this.builder.setContentTitle(this.contentTitle);
        }
        this.notification = this.builder.build();
        getNotificationMode(this.notification);
        if (this.contentIntent != null) {
          this.notification.contentIntent = this.contentIntent;
        }
        if (this.tickerText != null) {
          this.notification.tickerText = this.tickerText;
        }
        if (this.icon > 0) {
          this.notification.icon = this.icon;
        }
        if (this.notificationFlag != -1) {
          this.notification.flags = this.notificationFlag;
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void notify(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    QMLog.log(3, "FtnNotification", "notify");
    paramString1 = new Notification.Builder(QMApplicationContext.sharedInstance()).setContentTitle(paramString2).setContentText(paramString3).setContentIntent(paramPendingIntent).setSmallIcon(paramInt2).setLargeIcon(BitmapFactory.decodeResource(QMApplicationContext.sharedInstance().getResources(), 2130840992)).setTicker(paramString1).setDefaults(-1).build();
    this.notificationManager.notify(paramInt1, paramString1);
    if (((!AppStatusUtil.isScreenLocked()) && (AppStatusUtil.isAppOnForeground())) || (paramBoolean)) {
      Threads.runInBackground(new QMNotificationConstructor.1(this, paramInt1), 2500L);
    }
  }
  
  public void notifyBeta(QMBetaPushConfig paramQMBetaPushConfig, PendingIntent paramPendingIntent)
  {
    QMLog.log(4, "webpush", "notifyBeta version:" + paramQMBetaPushConfig.getBetaVersion() + ", subject:" + paramQMBetaPushConfig.getNotificationDesp() + ", url:" + paramQMBetaPushConfig.getNotificationUrl() + ", downloadUrl:" + paramQMBetaPushConfig.getDownloadUrl());
    notifySimplePush(paramQMBetaPushConfig.getNotificationTitle(), paramQMBetaPushConfig.getNotificationDesp(), null, null, paramPendingIntent, 25000000);
  }
  
  public void notifyCalendarReminder(int paramInt, String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent)
  {
    QMLog.log(4, "webpush", "notifyCalendarReminder rid:" + paramInt + ", title:" + paramString1 + ", sub:" + paramString2 + ", info:" + paramString3);
    notifySimplePush(paramString1, paramString2, paramString3, null, paramPendingIntent, 18000000 + paramInt);
  }
  
  public void notifyCommonPushConfig(String paramString1, String paramString2, PendingIntent paramPendingIntent)
  {
    QMLog.log(4, "webpush", "notifyCommonPushConfig title:" + paramString1 + ", subject" + paramString2);
    notifySimplePush(paramString1, paramString2, null, null, paramPendingIntent, 26000000);
  }
  
  public void notifyMusic(String paramString1, String paramString2)
  {
    clearNotify();
    this.smallIcon = 2130840992;
    this.contentTitle = paramString1;
    this.contentText = paramString2;
    this.contentIntent = PendingIntent.getActivity(this.context, 12041682, DownloadActivity.createIntent().setFlags(536870912), 134217728);
    this.icon = 2130840992;
    this.tickerText = paramString2;
    this.notificationFlag = 32;
    this.defaultMode = 0;
    createNotification(12041682, false);
  }
  
  public void notifyPushBottle(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, Uri paramUri, boolean paramBoolean2, PendingIntent paramPendingIntent)
  {
    QMLog.log(4, "PushNewMail", "notifyPushBottle: sound:" + paramBoolean1 + ", volume:" + this.mAudioManager.getStreamVolume(5) + ", resId:" + paramUri + ",vibrate:" + paramBoolean2 + ", aid:" + paramInt + ", contentTitle:" + paramString1 + ", tickerText:" + paramString2 + ", contentText:" + paramString3 + ", contentInfo:" + paramString4);
    Notification.Builder localBuilder = new Notification.Builder(this.context);
    localBuilder.setTicker(paramString2).setContentTitle(paramString1).setContentText(paramString3).setSmallIcon(QMAppInterface.sharedInstance().getNtId()).setContentIntent(paramPendingIntent);
    localBuilder.setLargeIcon(BitmapFactory.decodeResource(this.context.getResources(), 2130840992));
    if (paramString4 != null) {
      localBuilder.setContentInfo(paramString4);
    }
    paramString1 = localBuilder.build();
    if (paramBoolean1) {
      if (paramUri == null)
      {
        paramString1.defaults |= 0x1;
        if (!paramBoolean2) {
          break label331;
        }
      }
    }
    label331:
    for (paramString1.vibrate = new long[] { 200L, 200L, 200L, 200L };; paramString1.vibrate = new long[] { 0L })
    {
      paramString1.flags |= 0x10;
      paramString1.flags |= 0x1;
      paramString1.ledARGB = -16711936;
      paramString1.ledOnMS = 1500;
      paramString1.ledOffMS = 800;
      this.notificationManager.notify(17000000 + paramInt % 1000000, paramString1);
      return;
      paramString1.sound = paramUri;
      break;
      paramString1.sound = null;
      break;
    }
  }
  
  public void notifyPushDeviceError(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, PendingIntent paramPendingIntent)
  {
    QMLog.log(5, "webpush", "notifyPushImage aid:" + paramInt1 + ", title:" + paramString2 + ", sub:" + paramString3);
    notifySimplePush(paramString2, paramString3, null, paramString1, paramPendingIntent, getDeviceErrorNotificationId(paramInt1));
  }
  
  public void notifyPushFtn(int paramInt, String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent)
  {
    QMLog.log(4, "webpush", "notifyPushFtn aid:" + paramInt + ", title:" + paramString1 + ", sub:" + paramString2 + ", info:" + paramString3);
    notifySimplePush(paramString1, paramString2, paramString3, null, paramPendingIntent, 12000000 + paramInt);
  }
  
  public void notifyPushImage(int paramInt, String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent)
  {
    QMLog.log(4, "webpush", "notifyPushImage aid:" + paramInt + ", title:" + paramString1 + ", sub:" + paramString2 + ", info:" + paramString3);
    notifySimplePush(paramString1, paramString2, paramString3, paramString2, paramPendingIntent, 13000000 + paramInt);
  }
  
  /* Error */
  @SuppressLint({"InlinedApi"})
  public void notifyPushNewMail(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, Uri paramUri, boolean paramBoolean2, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String paramString5, String paramString6, ArrayList<CharSequence> paramArrayList, PendingIntent paramPendingIntent3, PendingIntent paramPendingIntent4, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, long paramLong, boolean paramBoolean5)
  {
    // Byte code:
    //   0: new 256	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   7: ldc_w 678
    //   10: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: iload 21
    //   15: invokevirtual 627	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   18: ldc_w 680
    //   21: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload 6
    //   26: invokevirtual 627	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: ldc_w 634
    //   32: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload 7
    //   37: invokevirtual 637	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: ldc_w 682
    //   43: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 8
    //   48: invokevirtual 627	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: ldc_w 641
    //   54: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload_1
    //   58: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: ldc_w 643
    //   64: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_2
    //   68: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc_w 645
    //   74: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_3
    //   78: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc_w 647
    //   84: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 4
    //   89: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w 649
    //   95: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload 5
    //   100: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 684
    //   106: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 11
    //   111: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc_w 686
    //   117: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 12
    //   122: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc_w 688
    //   128: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: astore 25
    //   133: aload 13
    //   135: ifnonnull +195 -> 330
    //   138: aconst_null
    //   139: astore 24
    //   141: aload 25
    //   143: aload 24
    //   145: invokevirtual 637	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: ldc_w 690
    //   151: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: astore 24
    //   156: aload 14
    //   158: ifnonnull +185 -> 343
    //   161: iconst_1
    //   162: istore 23
    //   164: aload 24
    //   166: iload 23
    //   168: invokevirtual 627	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   171: ldc_w 692
    //   174: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: astore 24
    //   179: aload 15
    //   181: ifnonnull +168 -> 349
    //   184: iconst_1
    //   185: istore 23
    //   187: iconst_4
    //   188: ldc 89
    //   190: aload 24
    //   192: iload 23
    //   194: invokevirtual 627	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   197: ldc_w 694
    //   200: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: iload 17
    //   205: invokevirtual 627	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   208: ldc_w 696
    //   211: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload 18
    //   216: invokevirtual 627	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   219: ldc_w 698
    //   222: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: lload 19
    //   227: invokevirtual 701	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   230: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 540	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   236: aconst_null
    //   237: astore 24
    //   239: aload 11
    //   241: ifnonnull +13 -> 254
    //   244: aload 12
    //   246: ifnonnull +8 -> 254
    //   249: aload 13
    //   251: ifnull +104 -> 355
    //   254: new 703	android/app/Notification$InboxStyle
    //   257: dup
    //   258: invokespecial 704	android/app/Notification$InboxStyle:<init>	()V
    //   261: astore 24
    //   263: aload 11
    //   265: ifnull +11 -> 276
    //   268: aload 24
    //   270: aload 11
    //   272: invokevirtual 708	android/app/Notification$InboxStyle:setBigContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$InboxStyle;
    //   275: pop
    //   276: aload 12
    //   278: ifnull +11 -> 289
    //   281: aload 24
    //   283: aload 12
    //   285: invokevirtual 711	android/app/Notification$InboxStyle:setSummaryText	(Ljava/lang/CharSequence;)Landroid/app/Notification$InboxStyle;
    //   288: pop
    //   289: aload 13
    //   291: ifnull +64 -> 355
    //   294: aload 13
    //   296: invokevirtual 712	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   299: astore 11
    //   301: aload 11
    //   303: invokeinterface 466 1 0
    //   308: ifeq +47 -> 355
    //   311: aload 24
    //   313: aload 11
    //   315: invokeinterface 470 1 0
    //   320: checkcast 714	java/lang/CharSequence
    //   323: invokevirtual 717	android/app/Notification$InboxStyle:addLine	(Ljava/lang/CharSequence;)Landroid/app/Notification$InboxStyle;
    //   326: pop
    //   327: goto -26 -> 301
    //   330: aload 13
    //   332: invokevirtual 500	java/util/ArrayList:size	()I
    //   335: invokestatic 435	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   338: astore 24
    //   340: goto -199 -> 141
    //   343: iconst_0
    //   344: istore 23
    //   346: goto -182 -> 164
    //   349: iconst_0
    //   350: istore 23
    //   352: goto -165 -> 187
    //   355: new 170	android/app/Notification$Builder
    //   358: dup
    //   359: aload_0
    //   360: getfield 144	com/tencent/qqmail/utilities/ui/QMNotificationConstructor:context	Landroid/content/Context;
    //   363: invokespecial 173	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   366: astore 11
    //   368: aload 11
    //   370: aload_2
    //   371: invokevirtual 181	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   374: aload 4
    //   376: invokevirtual 186	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   379: invokestatic 198	com/tencent/androidqqmail/tim/QMAppInterface:sharedInstance	()Lcom/tencent/androidqqmail/tim/QMAppInterface;
    //   382: invokevirtual 202	com/tencent/androidqqmail/tim/QMAppInterface:getNtId	()I
    //   385: invokevirtual 206	android/app/Notification$Builder:setSmallIcon	(I)Landroid/app/Notification$Builder;
    //   388: aload 9
    //   390: invokevirtual 388	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   393: aload 10
    //   395: invokevirtual 720	android/app/Notification$Builder:setDeleteIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   398: pop
    //   399: iload 18
    //   401: ifeq +10 -> 411
    //   404: aload 11
    //   406: aload_3
    //   407: invokevirtual 392	android/app/Notification$Builder:setTicker	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   410: pop
    //   411: aload 11
    //   413: aload_0
    //   414: getfield 144	com/tencent/qqmail/utilities/ui/QMNotificationConstructor:context	Landroid/content/Context;
    //   417: invokevirtual 212	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   420: ldc_w 389
    //   423: invokestatic 218	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   426: invokevirtual 222	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   429: pop
    //   430: aload 5
    //   432: ifnull +11 -> 443
    //   435: aload 11
    //   437: aload 5
    //   439: invokevirtual 191	android/app/Notification$Builder:setContentInfo	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   442: pop
    //   443: aload 24
    //   445: ifnull +11 -> 456
    //   448: aload 11
    //   450: aload 24
    //   452: invokevirtual 724	android/app/Notification$Builder:setStyle	(Landroid/app/Notification$Style;)Landroid/app/Notification$Builder;
    //   455: pop
    //   456: aload 14
    //   458: ifnull +24 -> 482
    //   461: aload 11
    //   463: ldc_w 725
    //   466: aload_0
    //   467: getfield 144	com/tencent/qqmail/utilities/ui/QMNotificationConstructor:context	Landroid/content/Context;
    //   470: ldc_w 726
    //   473: invokevirtual 730	android/content/Context:getString	(I)Ljava/lang/String;
    //   476: aload 14
    //   478: invokevirtual 734	android/app/Notification$Builder:addAction	(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   481: pop
    //   482: aload 15
    //   484: ifnull +24 -> 508
    //   487: aload 11
    //   489: ldc_w 735
    //   492: aload_0
    //   493: getfield 144	com/tencent/qqmail/utilities/ui/QMNotificationConstructor:context	Landroid/content/Context;
    //   496: ldc_w 736
    //   499: invokevirtual 730	android/content/Context:getString	(I)Ljava/lang/String;
    //   502: aload 15
    //   504: invokevirtual 734	android/app/Notification$Builder:addAction	(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   507: pop
    //   508: aload 14
    //   510: ifnonnull +15 -> 525
    //   513: aload 15
    //   515: ifnonnull +10 -> 525
    //   518: aload 11
    //   520: aconst_null
    //   521: invokevirtual 724	android/app/Notification$Builder:setStyle	(Landroid/app/Notification$Style;)Landroid/app/Notification$Builder;
    //   524: pop
    //   525: iload 21
    //   527: ifeq +199 -> 726
    //   530: iconst_2
    //   531: istore 22
    //   533: aload 11
    //   535: iload 22
    //   537: invokevirtual 739	android/app/Notification$Builder:setPriority	(I)Landroid/app/Notification$Builder;
    //   540: pop
    //   541: aload 11
    //   543: lload 19
    //   545: invokevirtual 743	android/app/Notification$Builder:setWhen	(J)Landroid/app/Notification$Builder;
    //   548: pop
    //   549: aload 11
    //   551: invokevirtual 226	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   554: astore_2
    //   555: iload 6
    //   557: ifeq +205 -> 762
    //   560: aload 7
    //   562: ifnonnull +191 -> 753
    //   565: aload_2
    //   566: aload_2
    //   567: getfield 316	android/app/Notification:defaults	I
    //   570: iconst_1
    //   571: ior
    //   572: putfield 316	android/app/Notification:defaults	I
    //   575: iload 8
    //   577: ifeq +193 -> 770
    //   580: aload_2
    //   581: iconst_4
    //   582: newarray long
    //   584: dup
    //   585: iconst_0
    //   586: ldc2_w 321
    //   589: lastore
    //   590: dup
    //   591: iconst_1
    //   592: ldc2_w 321
    //   595: lastore
    //   596: dup
    //   597: iconst_2
    //   598: ldc2_w 321
    //   601: lastore
    //   602: dup
    //   603: iconst_3
    //   604: ldc2_w 321
    //   607: lastore
    //   608: putfield 313	android/app/Notification:vibrate	[J
    //   611: aload_2
    //   612: aload_2
    //   613: getfield 248	android/app/Notification:flags	I
    //   616: bipush 16
    //   618: ior
    //   619: putfield 248	android/app/Notification:flags	I
    //   622: iload 17
    //   624: ifne +34 -> 658
    //   627: aload_2
    //   628: aload_2
    //   629: getfield 248	android/app/Notification:flags	I
    //   632: iconst_1
    //   633: ior
    //   634: putfield 248	android/app/Notification:flags	I
    //   637: aload_2
    //   638: ldc_w 650
    //   641: putfield 653	android/app/Notification:ledARGB	I
    //   644: aload_2
    //   645: sipush 1500
    //   648: putfield 656	android/app/Notification:ledOnMS	I
    //   651: aload_2
    //   652: sipush 800
    //   655: putfield 659	android/app/Notification:ledOffMS	I
    //   658: aload_2
    //   659: invokevirtual 405	java/lang/Object:getClass	()Ljava/lang/Class;
    //   662: ldc_w 407
    //   665: invokevirtual 413	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   668: aload_2
    //   669: invokevirtual 419	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   672: astore_3
    //   673: aload_3
    //   674: invokevirtual 405	java/lang/Object:getClass	()Ljava/lang/Class;
    //   677: ldc_w 421
    //   680: iconst_1
    //   681: anewarray 409	java/lang/Class
    //   684: dup
    //   685: iconst_0
    //   686: getstatic 427	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   689: aastore
    //   690: invokevirtual 431	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   693: aload_3
    //   694: iconst_1
    //   695: anewarray 4	java/lang/Object
    //   698: dup
    //   699: iconst_0
    //   700: iload 16
    //   702: invokestatic 435	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   705: aastore
    //   706: invokevirtual 441	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   709: pop
    //   710: iconst_0
    //   711: newarray double
    //   713: invokestatic 749	moai/oss/KvHelper:eventShowNewMailNotification	([D)V
    //   716: aload_0
    //   717: getfield 152	com/tencent/qqmail/utilities/ui/QMNotificationConstructor:notificationManager	Landroid/app/NotificationManager;
    //   720: iload_1
    //   721: aload_2
    //   722: invokevirtual 252	android/app/NotificationManager:notify	(ILandroid/app/Notification;)V
    //   725: return
    //   726: bipush 254
    //   728: istore 22
    //   730: goto -197 -> 533
    //   733: astore_2
    //   734: bipush 6
    //   736: ldc 89
    //   738: ldc_w 751
    //   741: aload_2
    //   742: invokestatic 754	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   745: ldc_w 259
    //   748: iconst_0
    //   749: invokestatic 760	com/tencent/qqmail/utilities/validate/ValidateHelper:assertInDebug	(Ljava/lang/String;Z)V
    //   752: return
    //   753: aload_2
    //   754: aload 7
    //   756: putfield 309	android/app/Notification:sound	Landroid/net/Uri;
    //   759: goto -184 -> 575
    //   762: aload_2
    //   763: aconst_null
    //   764: putfield 309	android/app/Notification:sound	Landroid/net/Uri;
    //   767: goto -192 -> 575
    //   770: aload_2
    //   771: iconst_1
    //   772: newarray long
    //   774: dup
    //   775: iconst_0
    //   776: lconst_0
    //   777: lastore
    //   778: putfield 313	android/app/Notification:vibrate	[J
    //   781: goto -170 -> 611
    //   784: astore_3
    //   785: goto -75 -> 710
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	788	0	this	QMNotificationConstructor
    //   0	788	1	paramInt1	int
    //   0	788	2	paramString1	String
    //   0	788	3	paramString2	String
    //   0	788	4	paramString3	String
    //   0	788	5	paramString4	String
    //   0	788	6	paramBoolean1	boolean
    //   0	788	7	paramUri	Uri
    //   0	788	8	paramBoolean2	boolean
    //   0	788	9	paramPendingIntent1	PendingIntent
    //   0	788	10	paramPendingIntent2	PendingIntent
    //   0	788	11	paramString5	String
    //   0	788	12	paramString6	String
    //   0	788	13	paramArrayList	ArrayList<CharSequence>
    //   0	788	14	paramPendingIntent3	PendingIntent
    //   0	788	15	paramPendingIntent4	PendingIntent
    //   0	788	16	paramInt2	int
    //   0	788	17	paramBoolean3	boolean
    //   0	788	18	paramBoolean4	boolean
    //   0	788	19	paramLong	long
    //   0	788	21	paramBoolean5	boolean
    //   531	198	22	i	int
    //   162	189	23	bool	boolean
    //   139	312	24	localObject	Object
    //   131	11	25	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   549	555	733	java/lang/Throwable
    //   658	710	784	java/lang/Exception
  }
  
  public void notifyPushNote(int paramInt, String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent)
  {
    QMLog.log(4, "webpush", "notifyPushNote aid:" + paramInt + ", title:" + paramString1 + ", sub:" + paramString2 + ", info:" + paramString3);
    notifySimplePush(paramString1, paramString2, paramString3, null, paramPendingIntent, 11000000 + paramInt);
  }
  
  public void notifyPushScanFile(int paramInt, String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent)
  {
    QMLog.log(4, "webpush", "notifyPushImage aid:" + paramInt + ", title:" + paramString1 + ", sub:" + paramString2 + ", info:" + paramString3);
    notifySimplePush(paramString1, paramString2, paramString3, paramString2, paramPendingIntent, 13000001 + paramInt);
  }
  
  public void notifyPushSchema(PushSchemaBody paramPushSchemaBody, PendingIntent paramPendingIntent)
  {
    QMLog.log(4, "webpush", "notifyPushSchema sid:" + paramPushSchemaBody.getId() + ", title:" + paramPushSchemaBody.getTitle() + ", sub:" + paramPushSchemaBody.getSubject() + ", schema:" + paramPushSchemaBody.getSchema());
    paramPendingIntent = new Notification.Builder(this.context).setSmallIcon(QMAppInterface.sharedInstance().getNtId()).setContentTitle(paramPushSchemaBody.getTitle()).setContentText(paramPushSchemaBody.getSubject()).setContentIntent(paramPendingIntent).build();
    paramPendingIntent.icon = 2130840992;
    paramPendingIntent.flags |= 0x10;
    if ((paramPushSchemaBody.getSound()) && (AppStatusUtil.isAppOnBackGround())) {
      paramPendingIntent.defaults |= 0x1;
    }
    if (paramPushSchemaBody.getVibra()) {
      paramPendingIntent.defaults |= 0x2;
    }
    this.notificationManager.notify(20000000 + paramPushSchemaBody.getId(), paramPendingIntent);
  }
  
  public void notifySSLError(String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent)
  {
    QMLog.log(4, "QMNotificationConstructor", "notifySSLError title:" + paramString1 + ", sub:" + paramString2 + ", info:" + paramString3);
    notifySimplePush(paramString1, paramString2, paramString3, null, paramPendingIntent, 28000001);
  }
  
  public void notifySaveToWeiYun(int paramInt, String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent)
  {
    QMLog.log(4, "webpush", "notifySaveToWeiYun rid:" + paramInt + ", title:" + paramString1 + ", sub:" + paramString2 + ", info:" + paramString3);
    notifySimplePush(paramString1, paramString2, paramString3, null, paramPendingIntent, 21000000 + paramInt);
  }
  
  public void notifySendBottle(String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt, PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    QMLog.log(4, "webpush", "notifySendBottle ticker:" + paramString1 + ", title:" + paramString2 + ", contentText:" + paramCharSequence);
    Notification.Builder localBuilder = new Notification.Builder(this.context);
    localBuilder.setLargeIcon(BitmapFactory.decodeResource(this.context.getResources(), 2130840992));
    paramString1 = localBuilder.setSmallIcon(2130840993).setContentTitle(paramString2).setContentText(paramCharSequence).setContentIntent(paramPendingIntent).setTicker(paramString1).build();
    paramString1.flags |= 0x10;
    if (paramBoolean)
    {
      paramString1.defaults = 0;
      paramString1.sound = null;
    }
    for (paramString1.vibrate = null;; paramString1.vibrate = new long[] { 200L, 200L, 200L, 200L })
    {
      this.notificationManager.notify(17000000, paramString1);
      if (paramBoolean) {
        Threads.runOnMainThread(new QMNotificationConstructor.2(this), 2500L);
      }
      return;
      paramString1.sound = null;
    }
  }
  
  @SuppressLint({"NewApi"})
  public void notifySendMail(String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt, PendingIntent paramPendingIntent, boolean paramBoolean, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    Object localObject2 = new StringBuilder().append("notifySendMail ticker:").append(paramString1).append(", title:").append(paramString2).append(", contentText:").append(paramCharSequence).append(", list:");
    Object localObject1;
    label99:
    int i;
    label141:
    int j;
    if (paramArrayList1 != null)
    {
      localObject1 = Integer.valueOf(paramArrayList1.size());
      QMLog.log(4, "webpush", localObject1);
      if ((paramBoolean) || (paramArrayList2 == null) || (paramArrayList2.size() != 1)) {
        break label429;
      }
      paramInt = 1;
      localObject2 = new Notification.Builder(this.context);
      if ((paramBoolean) || (Build.VERSION.SDK_INT < 16) || (paramArrayList1 == null) || (paramArrayList1.size() <= 0)) {
        break label435;
      }
      i = 1;
      localObject1 = paramCharSequence;
      if (i != 0)
      {
        if (paramInt == 0) {
          break label441;
        }
        j = getTextAppearanceStatusBarEventContentEmphasis();
        localObject1 = formatSubjectAndContent((String)paramArrayList1.get(0), (String)paramArrayList2.get(0), j);
      }
      label184:
      ((Notification.Builder)localObject2).setLargeIcon(BitmapFactory.decodeResource(this.context.getResources(), 2130840992));
      paramString1 = ((Notification.Builder)localObject2).setSmallIcon(QMAppInterface.sharedInstance().getNtId()).setContentTitle(paramString2).setContentText((CharSequence)localObject1).setContentIntent(paramPendingIntent).setTicker(paramString1).build();
      if ((i != 0) && (paramInt == 0)) {
        paramString1.priority = 2;
      }
      boolean bool = QMSettingManager.sharedInstance().getEnableSendMailSound();
      if (!paramBoolean) {
        break label537;
      }
      if (!bool) {
        break label529;
      }
      this.defaultMode = 8;
      label275:
      getNotificationMode(paramString1);
      QMLog.log(4, "QMNotificationConstructor", "notifySendMail, success: " + paramBoolean + ", defaultMode: " + this.defaultMode + ", sound: " + paramString1.sound + ", vibrate: " + Arrays.toString(paramString1.vibrate) + ", mode: " + this.mAudioManager.getRingerMode() + ", volume: " + this.mAudioManager.getStreamVolume(5) + ", enableSendMailSound: " + bool);
      this.notificationManager.notify(12041680, paramString1);
      if ((AppStatusUtil.isScreenLocked()) || (!AppStatusUtil.isAppOnForeground())) {
        break label588;
      }
      clearNotifyDelay(2500L);
    }
    label429:
    label435:
    label441:
    label588:
    while (!paramBoolean)
    {
      return;
      localObject1 = null;
      break;
      paramInt = 0;
      break label99;
      i = 0;
      break label141;
      int k = getTextAppearanceStatusBarEventContentEmphasis();
      localObject1 = new Notification.InboxStyle();
      j = 0;
      while (j < paramArrayList1.size())
      {
        ((Notification.InboxStyle)localObject1).addLine(formatSubjectAndContent((String)paramArrayList1.get(j), (String)paramArrayList2.get(j), k));
        j += 1;
      }
      ((Notification.InboxStyle)localObject1).setBigContentTitle(paramString2);
      ((Notification.Builder)localObject2).setStyle((Notification.Style)localObject1);
      localObject1 = paramCharSequence;
      break label184;
      this.defaultMode = 0;
      break label275;
      this.defaultMode = 16;
      paramString1.flags |= 0x1;
      paramString1.flags |= 0x10;
      paramString1.ledARGB = -65536;
      paramString1.ledOnMS = 1500;
      paramString1.ledOffMS = 800;
      break label275;
    }
    label529:
    label537:
    clearNotifyDelay(2500L);
  }
  
  public void notifyTelphoneReminder(int paramInt, String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent)
  {
    notifySimplePush(paramString1, paramString2, paramString3, null, paramPendingIntent, 19000000 + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMNotificationConstructor
 * JD-Core Version:    0.7.0.1
 */