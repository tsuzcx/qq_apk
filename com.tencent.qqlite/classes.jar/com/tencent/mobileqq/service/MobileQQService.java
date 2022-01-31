package com.tencent.mobileqq.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.tencent.biz.bmqq.protocol.BmqqBusinessService;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.compatible.ActionListener;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.service.RegisterProxySvcPack.RegisterProxySvcPackService;
import com.tencent.mobileqq.service.cardpay.CardPayService;
import com.tencent.mobileqq.service.config.ConfigService;
import com.tencent.mobileqq.service.discussion.DiscussionService;
import com.tencent.mobileqq.service.friendlist.FriendListService;
import com.tencent.mobileqq.service.lbs.LBSService;
import com.tencent.mobileqq.service.message.MessageService;
import com.tencent.mobileqq.service.profile.ProfileService;
import com.tencent.mobileqq.service.push.PushService;
import com.tencent.mobileqq.service.qwallet.QWalletAuthService;
import com.tencent.mobileqq.service.qwallet.QWalletHomeService;
import com.tencent.mobileqq.service.qwallet.QWalletOpenService;
import com.tencent.mobileqq.service.qwallet.UniPayService;
import com.tencent.mobileqq.service.qzone.QZoneService;
import com.tencent.mobileqq.service.report.ReportService;
import com.tencent.mobileqq.util.NotifyLightUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import edf;
import edg;
import edh;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class MobileQQService
  implements AppConstants
{
  public static final int a = 1;
  public static final String a = "MobileQQService";
  public static final int b = 2;
  public static final String b = "req_pb_protocol_flag";
  public static volatile int c = 0;
  private static final String c = "sendtimekey";
  private NotificationManager jdField_a_of_type_AndroidAppNotificationManager;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new edh(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ActionListener jdField_a_of_type_ComTencentMobileqqCompatibleActionListener = new edf(this);
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  private volatile boolean b = false;
  private int d = 0;
  
  public MobileQQService(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    PendingIntent localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 134217728);
    Notification localNotification;
    int i;
    if (!MobileIssueSettings.e)
    {
      localNotification = KapalaiAdapterUtil.a().a(BaseApplication.getContext(), 2130838149);
      paramIntent = localNotification;
      if (QLog.isColorLevel())
      {
        QLog.i("MobileQQService", 2, "buildIdleNotification by newNotificationForMeizu. nf=" + localNotification);
        paramIntent = localNotification;
      }
      paramIntent.icon = 2130838149;
      if (!this.jdField_a_of_type_Boolean) {
        break label189;
      }
      if (paramBitmap != null)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a("icon");
        if ((i > 0) && (paramIntent.contentView != null)) {
          paramIntent.contentView.setImageViewBitmap(i, paramBitmap);
        }
      }
      paramIntent.setLatestEventInfo(BaseApplication.getContext(), paramString1, paramString2, localPendingIntent);
    }
    label189:
    do
    {
      do
      {
        return paramIntent;
        localNotification = new Notification(2130838149, null, System.currentTimeMillis());
        paramIntent = localNotification;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("MobileQQService", 2, "buildIdleNotification by default. nf=" + localNotification);
        paramIntent = localNotification;
        break;
        paramIntent.setLatestEventInfo(BaseApplication.getContext(), paramString1, paramString2, localPendingIntent);
      } while (paramBitmap == null);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a("icon");
    } while ((i <= 0) || (paramIntent.contentView == null));
    paramIntent.contentView.setImageViewBitmap(i, paramBitmap);
    return paramIntent;
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
    paramIntent = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 268435456);
    if (QLog.isColorLevel()) {
      QLog.i("MobileQQService", 2, "buildNotification by getActivity. contentIntent=" + paramIntent);
    }
    paramString1 = new NotificationCompat.Builder(BaseApplication.getContext()).setSmallIcon(2130838150).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(paramString1);
    if (bool) {
      paramString1.setOngoing(true);
    }
    if (NotifyLightUtil.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      int i = Calendar.getInstance().get(11);
      if ((i < 23) && (i < 8)) {}
      paramString1.setLights(-16711936, 2000, 2000);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramBitmap != null) {
        paramString1.setLargeIcon(paramBitmap);
      }
      paramString1.setContentTitle(paramString2).setContentText(paramString3).setContentIntent(paramIntent);
    }
    for (;;)
    {
      return paramString1.build();
      paramString1.setContentTitle(paramString2).setContentText(paramString3).setContentIntent(paramIntent);
      if (paramBitmap != null) {
        paramString1.setLargeIcon(paramBitmap);
      }
    }
  }
  
  private void a(boolean paramBoolean) {}
  
  private boolean a(BaseProtocolCoder paramBaseProtocolCoder)
  {
    int i = 0;
    String[] arrayOfString = paramBaseProtocolCoder.a();
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return false;
    }
    while (i < arrayOfString.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(arrayOfString[i], paramBaseProtocolCoder);
      i += 1;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return ("OnlinePush.PbPushGroupMsg".equalsIgnoreCase(paramString)) || ("OnlinePush.PbPushDisMsg".equalsIgnoreCase(paramString)) || ("OnlinePush.PbC2CMsgSync".equalsIgnoreCase(paramString)) || ("NearFieldTranFileSvr.NotifyList".equalsIgnoreCase(paramString)) || ("NearFieldDiscussSvr.NotifyList".equalsIgnoreCase(paramString));
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    Object localObject = new ProfileService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((ProfileService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new FriendListService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((FriendListService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new MessageService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((MessageService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new LBSService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((LBSService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new QZoneService();
    ((QZoneService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new PushService();
    ((PushService)localObject).a();
    a((BaseProtocolCoder)localObject);
    ((PushService)localObject).a(this.jdField_a_of_type_ComTencentMobileqqCompatibleActionListener);
    localObject = new ConfigService();
    ((ConfigService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new ReportService();
    ((ReportService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new DiscussionService();
    ((DiscussionService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new RegisterProxySvcPackService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((RegisterProxySvcPackService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new VIPService();
    ((VIPService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new CardPayService();
    ((CardPayService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new QWalletOpenService();
    ((QWalletOpenService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new QWalletHomeService();
    ((QWalletHomeService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new BmqqBusinessService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((BmqqBusinessService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new UniPayService();
    ((UniPayService)localObject).a();
    a((BaseProtocolCoder)localObject);
    this.b = true;
    localObject = new QWalletAuthService();
    ((QWalletAuthService)localObject).a();
    a((BaseProtocolCoder)localObject);
  }
  
  public BaseProtocolCoder a(String paramString)
  {
    if (!this.b) {}
    int i;
    try
    {
      if (!this.b) {
        c();
      }
      i = paramString.indexOf('.');
      if (i <= 1) {
        return null;
      }
    }
    finally {}
    paramString = paramString.substring(0, i);
    return (BaseProtocolCoder)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidAppNotificationManager == null) && (this.d < 3)) {}
    try
    {
      this.jdField_a_of_type_Boolean = DeviceInfoUtil.a();
      a(true);
      this.jdField_a_of_type_AndroidAppNotificationManager = ((NotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSystemService("notification"));
      c = Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt());
      if (QLog.isColorLevel()) {
        QLog.i("MobileQQService", 2, "MobileQQService has created. mNM=" + this.jdField_a_of_type_AndroidAppNotificationManager);
      }
      this.d += 1;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "e = " + localException.toString());
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if ((this.jdField_a_of_type_AndroidAppNotificationManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_AndroidAppNotificationManager != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        this.jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, paramNotification);
        return;
      }
      catch (Throwable paramNotification)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("MobileQQService", 2, "startForegroundCompat exception. id=" + paramInt + ", mNM=" + this.jdField_a_of_type_AndroidAppNotificationManager, paramNotification);
        return;
      }
    }
    QLog.i("MobileQQService", 2, "startForegroundCompat. id=" + paramInt + ", mNM=" + this.jdField_a_of_type_AndroidAppNotificationManager);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = new edg(this, paramToServiceMsg);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.a().post(paramToServiceMsg);
      return;
    }
    paramToServiceMsg.run();
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    BusinessHandler localBusinessHandler = null;
    if (paramToServiceMsg == null) {
      return;
    }
    float f = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
    label105:
    boolean bool;
    label165:
    Object localObject;
    label203:
    int i;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MobileQQService", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " during " + this.jdField_a_of_type_JavaTextDecimalFormat.format(f) + "sec.");
      }
      bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
      if (QLog.isDevelopLevel()) {
        QLog.d("Troop", 4, "bPbResp:" + bool);
      }
      if (bool) {
        break label817;
      }
      bool = a(paramFromServiceMsg.getServiceCmd());
      paramException = (IBaseActionListener)paramToServiceMsg.getAttribute("listener");
      if (paramException != null) {
        paramToServiceMsg.actionListener = paramException;
      }
      if (bool) {
        break label811;
      }
      localObject = a(paramFromServiceMsg.getServiceCmd());
      paramException = localBusinessHandler;
      if (paramBoolean)
      {
        if (!bool) {
          break label680;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "PB cmd: recv cmd: " + paramFromServiceMsg.getServiceCmd());
        }
        paramException = localBusinessHandler;
        if (paramFromServiceMsg.getWupBuffer() != null)
        {
          i = paramFromServiceMsg.getWupBuffer().length - 4;
          paramException = new byte[i];
          PkgTools.a(paramException, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
          paramFromServiceMsg.putWupBuffer(paramException);
          paramException = paramFromServiceMsg.getWupBuffer();
        }
      }
    }
    label680:
    label811:
    label817:
    label820:
    for (;;)
    {
      for (;;)
      {
        LoadingStateManager.a().a(paramFromServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((!bool) && (localObject == null)) {
          break;
        }
        localObject = (int[])Cmd2HandlerMap.a().get(paramFromServiceMsg.getServiceCmd());
        if ((localObject == null) || (localObject.length <= 0)) {
          break;
        }
        int j = localObject.length;
        i = 0;
        label359:
        if (i >= j) {
          break;
        }
        int k = localObject[i];
        localBusinessHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(k);
        if (localBusinessHandler != null) {}
        try
        {
          localBusinessHandler.a(paramToServiceMsg, paramFromServiceMsg, paramException);
          i += 1;
          break label359;
          if (paramFromServiceMsg.getResultCode() == 2008)
          {
            paramFromServiceMsg = BaseActivity.sTopActivity;
            paramToServiceMsg = paramFromServiceMsg;
            if (paramFromServiceMsg == null) {
              paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
            }
            paramFromServiceMsg = new Intent(paramToServiceMsg, NotificationActivity.class);
            paramFromServiceMsg.setFlags(872415232);
            paramFromServiceMsg.putExtra("type", 2);
            paramToServiceMsg.startActivity(paramFromServiceMsg);
            return;
          }
          if (paramException != null)
          {
            localObject = new ByteArrayOutputStream();
            paramException.printStackTrace(new PrintStream((OutputStream)localObject));
            paramException = new String(((ByteArrayOutputStream)localObject).toByteArray());
            if (!QLog.isColorLevel()) {
              break label105;
            }
            QLog.d("MobileQQService", 2, "[NOT SEND]cmd=" + paramFromServiceMsg.getServiceCmd() + ", " + paramException);
            break label105;
          }
          if (QLog.isColorLevel()) {
            QLog.w("MobileQQService", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + ",CODE=" + paramFromServiceMsg.getResultCode() + " during " + this.jdField_a_of_type_JavaTextDecimalFormat.format(f) + "sec.");
          }
          if (((paramFromServiceMsg.getResultCode() != 1002) && (paramFromServiceMsg.getResultCode() != 1013)) || (!"ProfileService.CheckUpdateReq".equals(paramFromServiceMsg.getServiceCmd()))) {
            break label105;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
          break label105;
          if (localObject != null) {}
          try
          {
            ((BaseProtocolCoder)localObject).a(paramToServiceMsg, paramFromServiceMsg);
            paramException = ((BaseProtocolCoder)localObject).a(paramToServiceMsg, paramFromServiceMsg);
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            paramException = localBusinessHandler;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MobileQQService", 2, "bpc null");
          }
          paramException = null;
          break label820;
          if (QLog.isColorLevel())
          {
            QLog.d("MobileQQService", 2, "", localException1);
            paramException = localBusinessHandler;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.w("MobileQQService", 2, localBusinessHandler.getClass().getSimpleName() + " onReceive error,", localException2);
            }
          }
        }
      }
      localObject = null;
      break label203;
      break label165;
    }
  }
  
  public void b()
  {
    a(false);
    a(119);
    if (QLog.isColorLevel()) {
      QLog.i("MobileQQService", 2, "MobileQQService has destroyed.");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (BaseProtocolCoder)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject != null)
        {
          try
          {
            ((BaseProtocolCoder)localObject).b();
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel()) {
            QLog.d("MobileQQService", 2, "bpc destory error " + localException, localException);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    this.b = false;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppNotificationManager != null) {
      this.jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.MobileQQService
 * JD-Core Version:    0.7.0.1
 */