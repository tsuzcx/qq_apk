package com.tencent.av.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.text.format.Time;
import bgv;
import bgw;
import bgx;
import bgy;
import bgz;
import bha;
import bhb;
import bhc;
import com.tencent.av.VideoController;
import com.tencent.av.VideoServlet;
import com.tencent.av.report.AVReport;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.av.service.IQQServiceCallback.Stub;
import com.tencent.av.service.IQQServiceForAV;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import mqq.app.MobileQQ;

public class VideoAppInterface
  extends AppInterface
{
  public static final int a = 2;
  public static String a;
  public static final int b = 1;
  public static final String b = "tencent.video.q2v.membersChange";
  public static final int c = 0;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bgy(this);
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new bhc(this);
  Handler jdField_a_of_type_AndroidOsHandler = null;
  public VideoController a;
  VideoNotifyCenter jdField_a_of_type_ComTencentAvAppVideoNotifyCenter = null;
  public IQQServiceCallback.Stub a;
  public IQQServiceForAV a;
  INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new bgw(this);
  EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(1, new bhb(this));
  public boolean a;
  BroadcastReceiver b = new bgz(this);
  BroadcastReceiver c = new bgx(this);
  public volatile int d = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VideoAppInterface";
  }
  
  public VideoAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvServiceIQQServiceCallback$Stub = new bha(this);
    this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV = null;
  }
  
  public int a()
  {
    return AppSetting.a;
  }
  
  public int a(String paramString)
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      i = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString);
      return i;
    }
    catch (RemoteException paramString)
    {
      do
      {
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getDiscussMemberNum", paramString);
    }
    return 0;
  }
  
  public Bitmap a()
  {
    return ImageUtil.a();
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null)
    {
      try
      {
        paramString2 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt, paramString1, paramString2, paramBoolean1, paramBoolean2);
        return paramString2;
      }
      catch (RemoteException localRemoteException)
      {
        if (!paramBoolean2) {}
      }
      for (paramString1 = a();; paramString1 = null)
      {
        paramString2 = paramString1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w(jdField_a_of_type_JavaLangString, 2, "getFaceBitmap-->can not get facebitmap", localRemoteException);
        return paramString1;
      }
    }
    return null;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public VideoController a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController = VideoController.a();
      this.jdField_a_of_type_ComTencentAvVideoController.a(this);
    }
    return this.jdField_a_of_type_ComTencentAvVideoController;
  }
  
  public VideoNotifyCenter a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoNotifyCenter == null) {
      this.jdField_a_of_type_ComTencentAvAppVideoNotifyCenter = new VideoNotifyCenter(this);
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoNotifyCenter;
  }
  
  public EntityManagerFactory a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public BaseApplication a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public Boolean a()
  {
    Boolean localBoolean2 = Boolean.valueOf(false);
    Boolean localBoolean1 = localBoolean2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a();
      localBoolean1 = Boolean.valueOf(bool);
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        localBoolean1 = localBoolean2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "isQQpaused", localRemoteException);
    }
    return localBoolean1;
    return localBoolean2;
  }
  
  public String a()
  {
    return getAccount();
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      str = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt, paramString1, paramString2);
      return str;
    }
    catch (RemoteException paramString2)
    {
      do
      {
        str = paramString1;
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "getDisplayName", paramString2);
    }
    return paramString1;
  }
  
  String a(Context paramContext)
  {
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return null;
  }
  
  String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label143;
      }
    }
    label143:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        int i = this.jdField_a_of_type_ComTencentAvVideoController.a().e;
        if ((i > 0) && (i <= 4))
        {
          String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentAvVideoController.a(str, 0);
          this.jdField_a_of_type_ComTencentAvVideoController.c(str, 0);
        }
        for (;;)
        {
          e();
          return;
          if (this.jdField_a_of_type_ComTencentAvVideoController.f) {
            this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a);
          }
        }
      }
      System.exit(0);
    }
    catch (Exception localException)
    {
      System.exit(0);
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "startPumpMessage", paramString);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt, paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "setPeerInfo", paramString1);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = getApplication().refreAccountList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
        if (paramString.equals(localSimpleAccount.getUin()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "Switch Account: " + paramString);
          }
          switchAccount(localSimpleAccount);
          if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
            this.jdField_a_of_type_ComTencentAvVideoController.a(paramString);
          }
          this.jdField_a_of_type_ComTencentAvVideoController = null;
        }
      }
    }
  }
  
  public void a(Observer paramObserver)
  {
    if (paramObserver != null)
    {
      a().addObserver(paramObserver);
      if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
        paramObserver.update(a(), new Object[] { Integer.valueOf(10) });
      }
    }
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      a().a(paramArrayOfObject);
    }
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramLong);
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "curGAInviteIsRight", localRemoteException);
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString);
      return bool1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "isFriend", paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, ArrayList paramArrayList)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((!paramString.equals(a(paramArrayList, false))) && (!paramString.equals(a(paramArrayList, true)))) {
      return false;
    }
    return true;
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return true;
      try
      {
        String str = a(a());
        int i = 0;
        for (;;)
        {
          if (i >= paramArrayList.size()) {
            break label58;
          }
          boolean bool = str.equals(paramArrayList.get(i));
          if (bool) {
            break;
          }
          i += 1;
        }
        return false;
      }
      catch (Exception paramArrayList)
      {
        return false;
      }
    }
  }
  
  public long[] a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString);
      return localObject1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getDiscussMemberList", paramString);
    }
    return null;
  }
  
  public int b()
  {
    return a().countObservers();
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "regist QQ Account Receiver");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.i.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName());
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.i.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("tencent.video.q2v.membersChange");
    localIntentFilter.addAction("mqq.i.intent.action.LOGOUT");
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public void b(Observer paramObserver)
  {
    a().deleteObserver(paramObserver);
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "regist QQGAudioMsg Receiver");
    }
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.q2v.MultiVideo");
    localIntentFilter.addAction("tencent.video.q2v.AddDiscussMember");
    localIntentFilter.addAction("tencent.video.q2v.SwitchToDiscuss");
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.b, localIntentFilter);
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "regist QQ Process Exit Receiver");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.process.exit");
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.c, localIntentFilter);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.b);
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.c);
    Object localObject = new Intent(getApplication(), AVServiceForQQ.class);
    getApplication().stopService((Intent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "exit video process clearNotification");
    }
    ((NotificationManager)getApplication().getApplicationContext().getSystemService("notification")).cancel(2130838309);
    localObject = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
    if (localObject != null)
    {
      ((AudioManager)localObject).setSpeakerphoneOn(false);
      ((AudioManager)localObject).setMode(0);
    }
    getApplication().otherProcessExit(true);
    new bgv(this).run();
  }
  
  void f()
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV == null)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, QQServiceForAV.class);
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a();
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(this.jdField_a_of_type_ComTencentAvServiceIQQServiceCallback$Stub);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
          return;
        }
        catch (Exception localException) {}
        localRemoteException = localRemoteException;
        if (QLog.isColorLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "unbindQQService", localRemoteException);
        }
      }
    }
  }
  
  protected Class[] getMessagePushServlets()
  {
    return new Class[] { VideoServlet.class };
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "stopPumpMessage", localRemoteException);
    }
  }
  
  public void i()
  {
    a().deleteObservers();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Video process launch: " + System.currentTimeMillis() + " UIN " + getAccount());
    }
    a(null);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    UpdateAvSo.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      a();
    }
    for (;;)
    {
      b();
      c();
      d();
      f();
      paramBundle = new Intent(getApplication(), AVServiceForQQ.class);
      getApplication().startService(paramBundle);
      this.d = 2;
      AVReport.a().a();
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.a(this);
    }
  }
  
  protected void onDestroy()
  {
    g();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface
 * JD-Core Version:    0.7.0.1
 */