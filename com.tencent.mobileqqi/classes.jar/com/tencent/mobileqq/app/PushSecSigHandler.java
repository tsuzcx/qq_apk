package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.ims.signature.SignatureReport;
import com.tencent.ims.signature.SignatureResult;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fez;
import mqq.app.MobileQQ;

public class PushSecSigHandler
  extends BusinessHandler
{
  public static final byte a = 18;
  public static final int a = 2;
  private static final long jdField_a_of_type_Long = 604800000L;
  public static final String a = "PushSecSigHandler";
  public static final int b = 1001;
  public static final String b = "MobileQQ";
  public static final String c = "SecResEntry";
  public static final String d = "SecStampEntry";
  public static final String e = "SecMd5Entry";
  public static final String f = "SecSig";
  public static final String g = "dlg_title";
  public static final String h = "dlg_content";
  public static final String i = "dlg_lbutton";
  public static final String j = "dlg_rbutton";
  public static final String k = "dlg_url";
  private Runnable jdField_a_of_type_JavaLangRunnable = new fez(this);
  private boolean jdField_a_of_type_Boolean = false;
  
  PushSecSigHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("SecSig", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int m = localSharedPreferences.getInt("SecResEntry", -1);
    if ((m == -1) || ((m ^ 0x12) != paramInt))
    {
      QLog.d("PushSecSigHandler", 2, "updateSigcheckCache:newRes=" + paramInt);
      localEditor.putInt("SecResEntry", paramInt ^ 0x12);
      localEditor.putLong("SecStampEntry", System.currentTimeMillis() ^ 0x12);
      localEditor.commit();
      QLog.d("PushSecSigHandler", 2, "updateSigcheckCache done cacheRes = " + localSharedPreferences.getInt("SecResEntry", -1) + "stamp = " + localSharedPreferences.getLong("SecStampEntry", -1L));
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, signature.SignatureResult paramSignatureResult)
  {
    QLog.d("PushSecSigHandler", 2, "handleSigcheckSucc");
    if (paramSignatureResult.u32_check_result.get() == 0) {}
    for (int m = 1;; m = 0)
    {
      a(m);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, signature.SignatureResult paramSignatureResult)
  {
    QLog.d("PushSecSigHandler", 2, "handleSigcheckSucc");
    if (paramSignatureResult.u32_check_result.get() == 0) {}
    for (int m = 1;; m = 0)
    {
      a(m);
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, signature.SignatureResult paramSignatureResult)
  {
    QLog.d("PushSecSigHandler", 2, "handleSigcheckFailTips");
    if (paramSignatureResult.u32_check_result.get() == 0) {}
    for (int m = 1;; m = 0)
    {
      a(m);
      QLog.d("PushSecSigHandler", 2, "handleSigcheckFailTips:notify ui");
      paramToServiceMsg = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), NotificationActivity.class);
      paramToServiceMsg.putExtra("type", 9);
      paramFromServiceMsg = new Bundle();
      paramFromServiceMsg.putString("dlg_title", paramSignatureResult.str_title.get());
      paramFromServiceMsg.putString("dlg_content", paramSignatureResult.str_content.get());
      paramFromServiceMsg.putString("dlg_lbutton", paramSignatureResult.str_left_button.get());
      paramFromServiceMsg.putString("dlg_rbutton", paramSignatureResult.str_right_button.get());
      paramFromServiceMsg.putString("dlg_url", paramSignatureResult.str_url.get());
      paramToServiceMsg.putExtras(paramFromServiceMsg);
      paramToServiceMsg.setFlags(872415232);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().startActivity(paramToServiceMsg);
      return;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, signature.SignatureResult paramSignatureResult)
  {
    QLog.d("PushSecSigHandler", 2, "handleSigcheckFailKick");
    if (paramSignatureResult.u32_check_result.get() == 0) {}
    for (int m = 1;; m = 0)
    {
      a(m);
      return;
    }
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    Thread localThread;
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      localThread = new Thread(this.jdField_a_of_type_JavaLangRunnable);
    } while (localThread == null);
    localThread.setPriority(1);
    localThread.start();
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramLong == 0L) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null) || (paramString4 == null)) {
      return;
    }
    signature.SignatureReport localSignatureReport = new signature.SignatureReport();
    localSignatureReport.u64_uin.set(paramLong);
    localSignatureReport.u32_client_type.set(paramInt1);
    localSignatureReport.u32_is_repack.set(paramInt2);
    localSignatureReport.str_packname.set(paramString1);
    localSignatureReport.str_version.set(paramString2);
    localSignatureReport.str_md5.set(paramString3);
    localSignatureReport.str_signature.set(paramString4);
    localSignatureReport.u32_protocol_version.set(2);
    paramString1 = a("SecCheckSigSvc.UploadReq");
    paramString1.putWupBuffer(localSignatureReport.toByteArray());
    b(paramString1);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramFromServiceMsg.getServiceCmd();
    if ((localObject == null) || (((String)localObject).length() == 0)) {
      QLog.d("PushSecSigHandler", 2, "onReceive: onReceive sec_server package: server cmd is null");
    }
    do
    {
      do
      {
        return;
      } while (!"SecCheckSigSvc.UploadReq".equalsIgnoreCase((String)localObject));
      QLog.d("PushSecSigHandler", 2, "onReceive: onReceive sec_server package:check result");
      if (!paramFromServiceMsg.isSuccess()) {
        break;
      }
      QLog.d("PushSecSigHandler", 2, "onReceive: onReceive sec_server package:server result code ok");
      localObject = new signature.SignatureResult();
      try
      {
        ((signature.SignatureResult)localObject).mergeFrom((byte[])paramObject);
        if ((!((signature.SignatureResult)localObject).str_packname.has()) || (((signature.SignatureResult)localObject).str_packname.get() == null) || (!((signature.SignatureResult)localObject).u32_check_result.has()) || (!((signature.SignatureResult)localObject).u32_protocol_version.has()) || (((signature.SignatureResult)localObject).u32_protocol_version.get() != 2))
        {
          QLog.d("PushSecSigHandler", 2, "onReceive: onReceive sec_server package:packname fail");
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          QLog.d("PushSecSigHandler", 2, "onReceive: onReceive sec_server package:sigResult parse fail");
          paramObject.printStackTrace();
        }
      }
    } while (!((signature.SignatureResult)localObject).str_packname.get().equalsIgnoreCase("MobileQQ"));
    switch (((signature.SignatureResult)localObject).u32_check_result.get())
    {
    default: 
      return;
    case 0: 
      a(paramToServiceMsg, paramFromServiceMsg, (signature.SignatureResult)localObject);
      return;
    case 2: 
      c(paramToServiceMsg, paramFromServiceMsg, (signature.SignatureResult)localObject);
      return;
    case 1: 
      b(paramToServiceMsg, paramFromServiceMsg, (signature.SignatureResult)localObject);
      return;
    }
    d(paramToServiceMsg, paramFromServiceMsg, (signature.SignatureResult)localObject);
    return;
    QLog.d("PushSecSigHandler", 2, "onReceive: onReceive sec_server package:server result code fail:" + paramFromServiceMsg.getBusinessFailCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PushSecSigHandler
 * JD-Core Version:    0.7.0.1
 */