package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.ims.signature.SignatureResult;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cwk;
import cwl;
import cwm;
import cwn;
import cwo;
import cwp;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;

public class StartAppCheckHandler
  extends BusinessHandler
  implements BusinessObserver
{
  public static final int a = 2;
  public static final long a = 86400000L;
  public static final String a = "AppStartedHandler";
  public static final long b = 300L;
  public static final String b = "AppStartedObserver";
  public static final long c = 2305843009213693951L;
  public static final String c = "MobileQQ";
  public Activity a;
  private Handler a;
  public AppInterface a;
  public BrowserAppInterface a;
  public cwn a;
  public cwp a;
  public Runnable a;
  public Queue a;
  public boolean a;
  final int jdField_b_of_type_Int = 1;
  private Handler jdField_b_of_type_AndroidOsHandler = new cwl(this, Looper.getMainLooper());
  final int c = 2;
  final int d = 3;
  
  public StartAppCheckHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_AndroidOsHandler = new cwk(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = new cwm(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQQAppInterface;
  }
  
  private PackageInfo a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString, 64);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:server result code ok");
    }
    Object localObject1 = new signature.SignatureResult();
    for (;;)
    {
      try
      {
        ((signature.SignatureResult)localObject1).mergeFrom(paramArrayOfByte);
        if (((signature.SignatureResult)localObject1).str_packname.get().equalsIgnoreCase("MobileQQ"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:MobileQQ fail");
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:sigResult parse fail");
        }
        paramArrayOfByte.printStackTrace();
        continue;
        if ((!((signature.SignatureResult)localObject1).has()) || (!((signature.SignatureResult)localObject1).str_packname.has()) || (((signature.SignatureResult)localObject1).str_packname.get() == null) || (!((signature.SignatureResult)localObject1).u32_check_result.has()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:packname fail");
          return;
        }
        paramArrayOfByte = ((signature.SignatureResult)localObject1).str_packname.get();
        long l = System.currentTimeMillis();
        this.jdField_a_of_type_Cwn.jdField_b_of_type_Long = Long.valueOf(l).longValue();
        if (((signature.SignatureResult)localObject1).u32_timeout.has()) {
          this.jdField_a_of_type_Cwn.jdField_a_of_type_Long = ((signature.SignatureResult)localObject1).u32_timeout.get();
        }
        if (((signature.SignatureResult)localObject1).u32_check_result.has()) {
          this.jdField_a_of_type_Cwn.jdField_a_of_type_Int = ((signature.SignatureResult)localObject1).u32_check_result.get();
        }
        if (((signature.SignatureResult)localObject1).str_title.has()) {
          this.jdField_a_of_type_Cwn.jdField_c_of_type_JavaLangString = ((signature.SignatureResult)localObject1).str_title.get();
        }
        if (((signature.SignatureResult)localObject1).str_content.has()) {
          this.jdField_a_of_type_Cwn.d = ((signature.SignatureResult)localObject1).str_content.get();
        }
        if (((signature.SignatureResult)localObject1).str_left_button.has()) {
          this.jdField_a_of_type_Cwn.e = ((signature.SignatureResult)localObject1).str_left_button.get();
        }
        if (((signature.SignatureResult)localObject1).str_right_button.has()) {
          this.jdField_a_of_type_Cwn.f = ((signature.SignatureResult)localObject1).str_right_button.get();
        }
        if (((signature.SignatureResult)localObject1).str_url.has()) {
          this.jdField_a_of_type_Cwn.g = ((signature.SignatureResult)localObject1).str_url.get();
        }
        this.jdField_a_of_type_Cwn.b();
        this.jdField_a_of_type_Cwn = null;
        switch (((signature.SignatureResult)localObject1).u32_check_result.get())
        {
        default: 
          return;
        }
      }
      localObject1 = this.jdField_a_of_type_JavaUtilQueue.iterator();
      Object localObject3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cwo)((Iterator)localObject1).next();
        if (((cwo)localObject2).jdField_a_of_type_JavaLangString.equals(paramArrayOfByte))
        {
          this.jdField_a_of_type_JavaUtilQueue.remove(localObject2);
          localObject3 = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(2, localObject2);
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(2, localObject2);
          this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject3);
        }
      }
      continue;
      Object localObject2 = this.jdField_a_of_type_JavaUtilQueue.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (cwo)((Iterator)localObject2).next();
        if (((cwo)localObject3).jdField_a_of_type_JavaLangString.equals(paramArrayOfByte))
        {
          this.jdField_a_of_type_JavaUtilQueue.remove(localObject3);
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(2, localObject3);
          localObject3 = new Intent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), NotificationActivity.class);
          ((Intent)localObject3).putExtra("type", 9);
          Bundle localBundle = new Bundle();
          localBundle.putString("dlg_title", ((signature.SignatureResult)localObject1).str_title.get());
          localBundle.putString("dlg_content", ((signature.SignatureResult)localObject1).str_content.get());
          localBundle.putString("dlg_lbutton", ((signature.SignatureResult)localObject1).str_left_button.get());
          localBundle.putString("dlg_rbutton", ((signature.SignatureResult)localObject1).str_right_button.get());
          localBundle.putString("dlg_url", ((signature.SignatureResult)localObject1).str_url.get());
          ((Intent)localObject3).putExtras(localBundle);
          ((Intent)localObject3).setFlags(872415232);
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().startActivity((Intent)localObject3);
        }
      }
    }
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if ((paramToServiceMsg == null) || (paramToServiceMsg.length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package: server cmd is null");
      }
    }
    do
    {
      do
      {
        return;
      } while (!"SecCheckSigSvc.UploadReq".equalsIgnoreCase(paramToServiceMsg));
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:check result");
      }
    } while (!paramFromServiceMsg.isSuccess());
    a((byte[])paramObject);
  }
  
  public void a(String paramString, Context paramContext, Intent paramIntent)
  {
    QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)paramContext;
    this.jdField_a_of_type_AndroidAppActivity = localQQBrowserActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)localQQBrowserActivity.getAppRuntime());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface;
    b(paramString, paramContext, paramIntent);
  }
  
  public void b(String paramString, Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "<-- AppStartedObserver pkgName=" + paramString);
    }
    if ((true == this.jdField_a_of_type_Boolean) || (paramString == null))
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    this.jdField_a_of_type_Cwp = new cwp(this, paramString);
    this.jdField_a_of_type_Cwn = new cwn(this, paramString);
    long l;
    if (Long.valueOf(System.currentTimeMillis()).longValue() < this.jdField_a_of_type_Cwn.jdField_b_of_type_Long + 86400000L)
    {
      PackageInfo localPackageInfo = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_Cwp.jdField_a_of_type_JavaLangString);
      if (localPackageInfo != null)
      {
        String str = SecUtil.b(localPackageInfo.signatures[0].toByteArray());
        l = new File(localPackageInfo.applicationInfo.sourceDir).lastModified();
        if ((this.jdField_a_of_type_Cwn.jdField_c_of_type_Long == l) && (this.jdField_a_of_type_Cwn.jdField_a_of_type_JavaLangString.equalsIgnoreCase(str)))
        {
          if (this.jdField_a_of_type_Cwn.jdField_a_of_type_Int != 2)
          {
            paramContext.startActivity(paramIntent);
            return;
          }
          paramString = new Intent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), NotificationActivity.class);
          paramString.putExtra("type", 9);
          paramContext = new Bundle();
          paramContext.putString("dlg_title", this.jdField_a_of_type_Cwn.jdField_c_of_type_JavaLangString);
          paramContext.putString("dlg_content", this.jdField_a_of_type_Cwn.d);
          paramContext.putString("dlg_lbutton", this.jdField_a_of_type_Cwn.e);
          paramContext.putString("dlg_rbutton", this.jdField_a_of_type_Cwn.f);
          paramContext.putString("dlg_url", this.jdField_a_of_type_Cwn.g);
          paramString.putExtras(paramContext);
          paramString.setFlags(872415232);
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().startActivity(paramString);
          try
          {
            ReportController.b(null, "P_CliOper", "Safe_StartAppCheck", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "startAppByCheckValid", this.jdField_a_of_type_Cwn.jdField_b_of_type_JavaLangString, 0, 0, "", "", "", "");
            return;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Cwp.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()).longValue();
        this.jdField_a_of_type_Cwp.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Cwp.jdField_a_of_type_JavaLangString = paramString;
        paramString = new cwo(this, paramString, paramContext, paramIntent);
        this.jdField_a_of_type_JavaUtilQueue.offer(paramString);
        paramContext = new Message();
        paramContext.what = 2;
        paramContext.obj = paramString;
        this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramContext);
        paramString = this.jdField_a_of_type_AndroidOsHandler;
        if (this.jdField_a_of_type_Cwn.jdField_a_of_type_Long <= 0L) {
          break label527;
        }
        l = this.jdField_a_of_type_Cwn.jdField_a_of_type_Long;
        paramString.sendEmptyMessageDelayed(3, l);
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AppStartedHandler", 2, "GetAccount Failed!");
      return;
      label527:
      l = 300L;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, "onReceive: onReceive Observer package:MobileQQ fail");
      }
    }
    while ((!paramBoolean) || (paramBundle == null)) {
      return;
    }
    a(paramBundle.getByteArray("data"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.StartAppCheckHandler
 * JD-Core Version:    0.7.0.1
 */