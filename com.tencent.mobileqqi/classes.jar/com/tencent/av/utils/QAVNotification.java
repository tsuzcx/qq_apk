package com.tencent.av.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import bmc;
import com.tencent.av.gaudio.GaInviteDialogActivity;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.qphone.base.util.QLog;
import java.util.Stack;

public class QAVNotification
{
  static QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  static final String jdField_a_of_type_JavaLangString = "QAVNotification";
  final int jdField_a_of_type_Int = 2130838309;
  Notification jdField_a_of_type_AndroidAppNotification = null;
  NotificationManager jdField_a_of_type_AndroidAppNotificationManager = null;
  Context jdField_a_of_type_AndroidContentContext = null;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  RemoteViews jdField_a_of_type_AndroidWidgetRemoteViews = null;
  NotificationStyleDiscover jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover;
  Stack jdField_a_of_type_JavaUtilStack = new Stack();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString = null;
  String c = null;
  
  QAVNotification(Context paramContext)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    }
    this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover = new NotificationStyleDiscover(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public static QAVNotification a(Context paramContext)
  {
    if ((jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) && (paramContext != null)) {
      jdField_a_of_type_ComTencentAvUtilsQAVNotification = new QAVNotification(paramContext);
    }
    return jdField_a_of_type_ComTencentAvUtilsQAVNotification;
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAVNotification", 2, "cancelNotificationForce");
    }
    ((NotificationManager)paramContext.getSystemService("notification")).cancel(2130838309);
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAVNotification", 2, "addNotification");
    }
    if ((this.jdField_b_of_type_Int == 46) || (this.jdField_b_of_type_Int == 41) || (this.jdField_b_of_type_Int == 47) || (this.jdField_b_of_type_Int == 42))
    {
      localObject1 = new Intent("com.tencent.mobileqq.action.QQ_CALLING");
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject1);
    }
    this.jdField_a_of_type_AndroidAppNotification = new Notification();
    this.jdField_a_of_type_AndroidAppNotificationManager = ((NotificationManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("notification"));
    this.jdField_a_of_type_AndroidWidgetRemoteViews = new RemoteViews(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 2130903357);
    if (this.jdField_b_of_type_JavaLangString == null) {
      return;
    }
    Object localObject1 = this.jdField_b_of_type_JavaLangString;
    int j = ((String)localObject1).length();
    Object localObject2;
    if (j >= 7)
    {
      localObject2 = this.jdField_b_of_type_JavaLangString.toCharArray();
      localObject1 = String.valueOf(localObject2[0]);
      int i = 1;
      while (i < 5)
      {
        localObject1 = (String)localObject1 + String.valueOf(localObject2[i]);
        i += 1;
      }
      localObject1 = (String)localObject1 + "...";
    }
    Object localObject3;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      localObject1 = "";
      localObject2 = "";
      localObject3 = null;
    }
    for (;;)
    {
      localObject3 = PendingIntent.getActivity(this.jdField_a_of_type_AndroidContentContext, 0, (Intent)localObject3, 134217728);
      if (this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.b() > 0.0F) {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setFloat(2131232283, "setTextSize", this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.b());
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.a() > 0.0F) {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setFloat(2131232284, "setTextSize", this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.a());
      }
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131232283, (CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131232284, (CharSequence)localObject1);
      try
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewBitmap(2131232282, this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        this.jdField_a_of_type_AndroidAppNotification.flags = 2;
        this.jdField_a_of_type_AndroidAppNotification.contentView = this.jdField_a_of_type_AndroidWidgetRemoteViews;
        this.jdField_a_of_type_AndroidAppNotification.contentIntent = ((PendingIntent)localObject3);
        this.jdField_a_of_type_AndroidAppNotificationManager.notify(2130838309, this.jdField_a_of_type_AndroidAppNotification);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str;
          if (QLog.isColorLevel()) {
            QLog.d("QAVNotification", 2, "addNotification", localException);
          }
        }
      }
      this.jdField_a_of_type_Boolean = true;
      return;
      localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, VideoInviteFull.class);
      ((Intent)localObject3).addFlags(4194304);
      ((Intent)localObject3).addFlags(262144);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131560129);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131560183);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838309);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838309;
      continue;
      localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      ((Intent)localObject3).addFlags(268435456);
      ((Intent)localObject3).addFlags(4194304);
      ((Intent)localObject3).addFlags(262144);
      ((Intent)localObject3).putExtra("Fromwhere", "AVNotification");
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131560129);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131560215);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838309);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838309;
      continue;
      localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      ((Intent)localObject3).putExtra("Fromwhere", "AVNotification");
      ((Intent)localObject3).addFlags(268435456);
      ((Intent)localObject3).addFlags(4194304);
      ((Intent)localObject3).addFlags(262144);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131560216);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838309);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838309;
      localObject2 = localObject1;
      continue;
      localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, VideoInviteFull.class);
      ((Intent)localObject3).addFlags(4194304);
      ((Intent)localObject3).addFlags(262144);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131560237);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131560157);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838269);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838269;
      continue;
      localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      ((Intent)localObject3).addFlags(268435456);
      ((Intent)localObject3).addFlags(4194304);
      ((Intent)localObject3).addFlags(262144);
      ((Intent)localObject3).putExtra("Fromwhere", "AVNotification");
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131560237);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131560215);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838269);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838269;
      continue;
      localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      ((Intent)localObject3).addFlags(268435456);
      ((Intent)localObject3).addFlags(4194304);
      ((Intent)localObject3).addFlags(262144);
      ((Intent)localObject3).putExtra("Fromwhere", "AVNotification");
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131560217);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838269);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838269;
      localObject2 = localObject1;
      continue;
      localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, GaInviteDialogActivity.class);
      ((Intent)localObject3).addFlags(4194304);
      ((Intent)localObject3).addFlags(262144);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131560187);
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131560166);
      if (j >= 7) {
        this.jdField_a_of_type_AndroidAppNotification.tickerText = ((String)localObject1 + str);
      }
      for (localObject1 = (String)localObject1 + str;; localObject1 = this.jdField_b_of_type_JavaLangString + str)
      {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838269);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130838269;
        break;
        this.jdField_a_of_type_AndroidAppNotification.tickerText = (this.jdField_b_of_type_JavaLangString + str);
      }
      localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      ((Intent)localObject3).addFlags(4194304);
      ((Intent)localObject3).addFlags(262144);
      ((Intent)localObject3).addFlags(268435456);
      ((Intent)localObject3).putExtra("GroupId", this.c);
      ((Intent)localObject3).putExtra("Type", 2);
      ((Intent)localObject3).putExtra("sessionType", 3);
      ((Intent)localObject3).putExtra("Fromwhere", "AVNotification");
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131560219);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = ((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838269);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838269;
      localObject2 = localObject1;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAVNotification", 2, "updateNotification mIsActive: " + this.jdField_a_of_type_Boolean + ", SessionType: " + paramInt + ", time: " + paramString);
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppNotification != null)) {}
        switch (paramInt)
        {
        case 1: 
          this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131232284, paramString);
          this.jdField_a_of_type_AndroidAppNotificationManager.notify(2130838309, this.jdField_a_of_type_AndroidAppNotification);
          return;
        }
      }
      finally {}
      String str = this.jdField_a_of_type_AndroidContentContext.getString(2131560217);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
      continue;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131560216);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAVNotification", 2, "addNotification name: " + paramString1 + ", id: " + paramString2 + ", type: " + paramInt + ", mName: " + this.jdField_b_of_type_JavaLangString + ", mId: " + this.c + ", mType: " + this.jdField_b_of_type_Int);
    }
    if ((paramString1 != null) && (paramString1.equals(this.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_b_of_type_Int = paramInt;
      this.c = paramString2;
      b();
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAVNotification", 2, "addNotification store");
      }
      this.jdField_a_of_type_JavaUtilStack.push(new bmc(this, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap, this.c, this.jdField_b_of_type_Int));
    }
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_b_of_type_Int = paramInt;
    this.c = paramString2;
    a();
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAVNotification", 2, "updateNotification");
    }
    if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_a_of_type_AndroidAppNotificationManager == null) || (this.jdField_a_of_type_AndroidAppNotification == null) || (this.jdField_a_of_type_AndroidWidgetRemoteViews == null)) {
      return;
    }
    String str1 = this.jdField_b_of_type_JavaLangString;
    int j = str1.length();
    Object localObject;
    if (j >= 7)
    {
      localObject = this.jdField_b_of_type_JavaLangString.toCharArray();
      str1 = String.valueOf(localObject[0]);
      int i = 1;
      while (i < 5)
      {
        str1 = str1 + String.valueOf(localObject[i]);
        i += 1;
      }
      str1 = str1 + "...";
    }
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      str1 = "";
      localObject = "";
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.b() > 0.0F) {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setFloat(2131232283, "setTextSize", this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.b());
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.a() > 0.0F) {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setFloat(2131232284, "setTextSize", this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.a());
      }
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131232283, (CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131232284, str1);
      this.jdField_a_of_type_AndroidAppNotificationManager.notify(2130838309, this.jdField_a_of_type_AndroidAppNotification);
      this.jdField_a_of_type_Boolean = true;
      return;
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131560129);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131560183);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str1;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838309);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838309;
      continue;
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131560129);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131560215);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str1;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838309);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838309;
      continue;
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131560216);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str1;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838309);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838309;
      localObject = str1;
      continue;
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131560237);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131560157);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str1;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838269);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838269;
      continue;
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131560237);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131560215);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str1;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838269);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838269;
      continue;
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131560217);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str1;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838269);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838269;
      localObject = str1;
      continue;
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131560187);
      String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131560166);
      if (j >= 7) {
        this.jdField_a_of_type_AndroidAppNotification.tickerText = (str1 + str2);
      }
      for (str1 = str1 + str2;; str1 = this.jdField_b_of_type_JavaLangString + str2)
      {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838269);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130838269;
        break;
        this.jdField_a_of_type_AndroidAppNotification.tickerText = (this.jdField_b_of_type_JavaLangString + str2);
      }
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131560219);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str1;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131232285, 2130838269);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838269;
      localObject = str1;
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +32 -> 37
    //   8: ldc 9
    //   10: iconst_2
    //   11: new 137	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 304
    //   21: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 50	com/tencent/av/utils/QAVNotification:jdField_a_of_type_Boolean	Z
    //   28: invokevirtual 261	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   31: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_0
    //   38: getfield 50	com/tencent/av/utils/QAVNotification:jdField_a_of_type_Boolean	Z
    //   41: ifeq +84 -> 125
    //   44: aload_0
    //   45: getfield 36	com/tencent/av/utils/QAVNotification:jdField_a_of_type_AndroidAppNotificationManager	Landroid/app/NotificationManager;
    //   48: ldc 30
    //   50: invokevirtual 93	android/app/NotificationManager:cancel	(I)V
    //   53: aload_0
    //   54: getfield 55	com/tencent/av/utils/QAVNotification:jdField_a_of_type_JavaUtilStack	Ljava/util/Stack;
    //   57: invokevirtual 307	java/util/Stack:size	()I
    //   60: ifle +68 -> 128
    //   63: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +12 -> 78
    //   69: ldc 9
    //   71: iconst_2
    //   72: ldc_w 309
    //   75: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_0
    //   79: getfield 55	com/tencent/av/utils/QAVNotification:jdField_a_of_type_JavaUtilStack	Ljava/util/Stack;
    //   82: invokevirtual 313	java/util/Stack:pop	()Ljava/lang/Object;
    //   85: checkcast 291	bmc
    //   88: astore_1
    //   89: aload_0
    //   90: aload_1
    //   91: getfield 315	bmc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   94: putfield 42	com/tencent/av/utils/QAVNotification:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   97: aload_0
    //   98: aload_1
    //   99: getfield 316	bmc:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   102: putfield 44	com/tencent/av/utils/QAVNotification:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   105: aload_0
    //   106: aload_1
    //   107: getfield 317	bmc:jdField_a_of_type_Int	I
    //   110: putfield 48	com/tencent/av/utils/QAVNotification:jdField_b_of_type_Int	I
    //   113: aload_0
    //   114: aload_1
    //   115: getfield 318	bmc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   118: putfield 46	com/tencent/av/utils/QAVNotification:c	Ljava/lang/String;
    //   121: aload_0
    //   122: invokevirtual 300	com/tencent/av/utils/QAVNotification:a	()V
    //   125: aload_0
    //   126: monitorexit
    //   127: return
    //   128: aload_0
    //   129: iconst_0
    //   130: putfield 48	com/tencent/av/utils/QAVNotification:jdField_b_of_type_Int	I
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 46	com/tencent/av/utils/QAVNotification:c	Ljava/lang/String;
    //   138: aload_0
    //   139: aconst_null
    //   140: putfield 42	com/tencent/av/utils/QAVNotification:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   143: aload_0
    //   144: aconst_null
    //   145: putfield 44	com/tencent/av/utils/QAVNotification:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   148: aload_0
    //   149: iconst_0
    //   150: putfield 50	com/tencent/av/utils/QAVNotification:jdField_a_of_type_Boolean	Z
    //   153: aload_0
    //   154: getfield 55	com/tencent/av/utils/QAVNotification:jdField_a_of_type_JavaUtilStack	Ljava/util/Stack;
    //   157: invokevirtual 321	java/util/Stack:clear	()V
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 36	com/tencent/av/utils/QAVNotification:jdField_a_of_type_AndroidAppNotificationManager	Landroid/app/NotificationManager;
    //   165: aload_0
    //   166: aconst_null
    //   167: putfield 34	com/tencent/av/utils/QAVNotification:jdField_a_of_type_AndroidAppNotification	Landroid/app/Notification;
    //   170: aload_0
    //   171: aconst_null
    //   172: putfield 38	com/tencent/av/utils/QAVNotification:jdField_a_of_type_AndroidWidgetRemoteViews	Landroid/widget/RemoteViews;
    //   175: goto -50 -> 125
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	QAVNotification
    //   88	27	1	localbmc	bmc
    //   178	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	178	finally
    //   37	78	178	finally
    //   78	125	178	finally
    //   128	175	178	finally
  }
  
  public void d()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAVNotification", 2, "cancelNotificationEx mIsActive: " + this.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidAppNotificationManager.cancel(2130838309);
        this.jdField_b_of_type_Int = 0;
        this.c = null;
        this.jdField_b_of_type_JavaLangString = null;
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilStack.clear();
        this.jdField_a_of_type_AndroidAppNotificationManager = null;
        this.jdField_a_of_type_AndroidAppNotification = null;
        this.jdField_a_of_type_AndroidWidgetRemoteViews = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.utils.QAVNotification
 * JD-Core Version:    0.7.0.1
 */