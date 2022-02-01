package com.tencent.mobileqq.activity.voip;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.voip.VoipHistoryData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.voip.VoipSIPInterface;
import etp;
import etq;
import etr;
import ets;
import ett;

public class VoipDialInterface
{
  static int jdField_a_of_type_Int;
  public static BroadcastReceiver a;
  private static VoipDialInterface jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface;
  public static String a;
  public static final long[] a;
  public static int b;
  public static String b;
  static int jdField_c_of_type_Int;
  public static int d;
  private long jdField_a_of_type_Long = 0L;
  private Notification jdField_a_of_type_AndroidAppNotification;
  private PendingIntent jdField_a_of_type_AndroidAppPendingIntent;
  private Handler jdField_a_of_type_AndroidOsHandler = new etq(this);
  private VoipSSOInterface jdField_a_of_type_ComTencentMobileqqActivityVoipVoipSSOInterface;
  protected QQAppInterface a;
  private VoipHistoryData jdField_a_of_type_ComTencentMobileqqDataVoipVoipHistoryData;
  private VoipSIPInterface jdField_a_of_type_ComTencentVoipVoipSIPInterface = new VoipSIPInterface();
  private ett jdField_a_of_type_Ett = new ett(this, null);
  private Runnable jdField_a_of_type_JavaLangRunnable = new etr(this);
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private Handler jdField_b_of_type_AndroidOsHandler = new ets(this);
  private boolean jdField_b_of_type_Boolean = true;
  private long jdField_c_of_type_Long = 0L;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = jdField_b_of_type_Int;
  private String jdField_e_of_type_JavaLangString = "";
  private int jdField_f_of_type_Int = -1;
  private String jdField_f_of_type_JavaLangString = "";
  private String g = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "VoipDialInterface";
    jdField_a_of_type_Int = 778832;
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = 100;
    jdField_b_of_type_JavaLangString = "com.tencent.Voip.CallState";
    jdField_d_of_type_Int = jdField_b_of_type_Int;
    jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface = null;
    jdField_a_of_type_ArrayOfLong = new long[] { 50L };
    jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    try
    {
      System.loadLibrary("pjsua");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Log.e("MyActivity", localUnsatisfiedLinkError.toString());
    }
  }
  
  public static VoipDialInterface a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface == null) {
      jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface = new VoipDialInterface();
    }
    return jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDialInterface;
  }
  
  private void b(int paramInt) {}
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidAppPendingIntent == null) || (this.jdField_a_of_type_AndroidAppNotification == null)) {
      return;
    }
    NotificationManager localNotificationManager = (NotificationManager)BaseApplication.getContext().getSystemService("notification");
    new String();
    String str = a(this.jdField_a_of_type_Long * 1000L);
    this.jdField_a_of_type_AndroidAppNotification.setLatestEventInfo(BaseApplication.getContext(), this.jdField_c_of_type_JavaLangString, str, this.jdField_a_of_type_AndroidAppPendingIntent);
    localNotificationManager.notify(jdField_a_of_type_Int, this.jdField_a_of_type_AndroidAppNotification);
  }
  
  private void d()
  {
    a(false, 0, null, null);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidAppPendingIntent = null;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = jdField_b_of_type_Int;
    if (jdField_d_of_type_Int != jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentVoipVoipSIPInterface.DelAccount(jdField_d_of_type_Int);
      jdField_d_of_type_Int = jdField_b_of_type_Int;
    }
  }
  
  private void e()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_ComTencentVoipVoipSIPInterface.Init(1);
      this.jdField_a_of_type_ComTencentVoipVoipSIPInterface.SetCallBackObject(this.jdField_a_of_type_Ett);
      if (i == 0)
      {
        this.jdField_a_of_type_Boolean = true;
        QLog.d(jdField_a_of_type_JavaLangString, 4, "Sip init success");
      }
    }
    else
    {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "Sip init fail");
  }
  
  public float a()
  {
    return 0.0F;
  }
  
  public int a()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public int a(String paramString)
  {
    this.jdField_a_of_type_ComTencentVoipVoipSIPInterface.SendDTMF(this.jdField_e_of_type_Int, paramString);
    return 0;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public VoipHistoryData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataVoipVoipHistoryData;
  }
  
  public String a()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public String a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong >= 360000000L) {
      l1 = paramLong - 360000000L;
    }
    if (l1 < 0L) {
      return "00:00";
    }
    paramLong = l1 / 3600000L;
    String str1 = "0" + paramLong;
    str1 = str1.substring(str1.length() - 2, str1.length());
    long l2 = (l1 - 3600000L * paramLong) / 60000L;
    String str2 = "0" + l2;
    str2 = str2.substring(str2.length() - 2, str2.length());
    l1 = (l1 - 3600000L * paramLong - l2 * 60000L) / 1000L;
    String str3 = "0" + l1;
    str3 = str3.substring(str3.length() - 2, str3.length());
    if (paramLong > 0L) {
      return str1 + ":" + str2 + ":" + str3;
    }
    return str2 + ":" + str3;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentVoipVoipSIPInterface.Hangup();
    d();
  }
  
  public void a(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_c_of_type_Long = paramLong2;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipSSOInterface = new VoipSSOInterface(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidOsHandler);
    if (jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      jdField_a_of_type_AndroidContentBroadcastReceiver = new etp(this);
      paramQQAppInterface = new IntentFilter();
      paramQQAppInterface.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      BaseApplication.getContext().registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, paramQQAppInterface);
    }
  }
  
  public void a(VoipHistoryData paramVoipHistoryData)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataVoipVoipHistoryData = paramVoipHistoryData;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "InitSip begin");
    this.jdField_d_of_type_JavaLangString = paramString;
    e();
    QLog.d(jdField_a_of_type_JavaLangString, 4, "InitSip end");
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(VoipErrorCodeEnum.VOIP_INIT_FAIL.ordinal());
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(jdField_c_of_type_Int);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    this.jdField_f_of_type_JavaLangString = paramString1;
    this.g = paramString2;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_c_of_type_Long = paramLong2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    if (paramBoolean) {
      if (e())
      {
        NotificationManager localNotificationManager = (NotificationManager)BaseApplication.getContext().getSystemService("notification");
        this.jdField_a_of_type_AndroidAppNotification = new Notification(paramInt, "QQ Out", System.currentTimeMillis());
        Notification localNotification = this.jdField_a_of_type_AndroidAppNotification;
        localNotification.flags |= 0x2;
        localNotification = this.jdField_a_of_type_AndroidAppNotification;
        localNotification.flags |= 0x20;
        this.jdField_c_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_AndroidAppPendingIntent = paramPendingIntent;
        this.jdField_a_of_type_AndroidAppNotification.setLatestEventInfo(BaseApplication.getContext(), paramString, "1", this.jdField_a_of_type_AndroidAppPendingIntent);
        localNotificationManager.notify(jdField_a_of_type_Int, this.jdField_a_of_type_AndroidAppNotification);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidAppNotification = null;
      ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(jdField_a_of_type_Int);
    } while (!this.jdField_d_of_type_Boolean);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqDataVoipVoipHistoryData.endTime = l;
    paramString = VoipHistoryInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramString.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramString.a(this.jdField_a_of_type_ComTencentMobileqqDataVoipVoipHistoryData);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String b()
  {
    return this.g;
  }
  
  public void b()
  {
    Vibrator localVibrator = (Vibrator)BaseApplication.getContext().getSystemService("vibrator");
    localVibrator.vibrate(jdField_a_of_type_ArrayOfLong, -1);
    localVibrator.vibrate(50L);
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public long c()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean e()
  {
    return this.jdField_e_of_type_Int != jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipDialInterface
 * JD-Core Version:    0.7.0.1
 */