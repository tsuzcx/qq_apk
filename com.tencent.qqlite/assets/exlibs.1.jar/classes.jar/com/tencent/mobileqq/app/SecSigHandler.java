package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.ims.signature.SignatureReport;
import com.tencent.ims.signature.SignatureResult;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class SecSigHandler
  extends BusinessHandler
{
  public static final byte a = 18;
  public static final int a = 0;
  public static final String a = "sec_sig_tag";
  public static final int b = 1001;
  public static final String b = "MobileQQ";
  public static final String c = "SecResEntry";
  public static final String d = "SecStampEntry";
  public static final String e = "SecMd5Entry";
  public static final String f = "SecSig";
  
  SecSigHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("SecSig", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("SecResEntry", -1);
    if ((i == -1) || ((i ^ 0x12) != paramInt))
    {
      QLog.d("sec_sig_tag", 2, "updateSigcheckCache:newRes=" + paramInt);
      localEditor.putInt("SecResEntry", paramInt ^ 0x12);
      localEditor.putLong("SecStampEntry", System.currentTimeMillis() ^ 0x12);
      localEditor.commit();
      QLog.d("sec_sig_tag", 2, "updateSigcheckCache done cacheRes = " + localSharedPreferences.getInt("SecResEntry", -1) + "stamp = " + localSharedPreferences.getLong("SecStampEntry", -1L));
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, signature.SignatureResult paramSignatureResult)
  {
    QLog.d("sec_sig_tag", 2, "handleSigcheckSucc");
    if (paramSignatureResult.u32_check_result.get() == 0) {}
    for (int i = 1;; i = 0)
    {
      a(i);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, signature.SignatureResult paramSignatureResult)
  {
    QLog.d("sec_sig_tag", 2, "handleSigcheckSucc");
    if (paramSignatureResult.u32_check_result.get() == 0) {}
    for (int i = 1;; i = 0)
    {
      a(i);
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, signature.SignatureResult paramSignatureResult)
  {
    QLog.d("sec_sig_tag", 2, "handleSigcheckFailTips");
    if (paramSignatureResult.u32_check_result.get() == 0) {}
    for (int i = 1;; i = 0)
    {
      a(i);
      QLog.d("sec_sig_tag", 2, "handleSigcheckFailTips:notify ui");
      a(1001, true, paramSignatureResult);
      return;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, signature.SignatureResult paramSignatureResult)
  {
    QLog.d("sec_sig_tag", 2, "handleSigcheckFailKick");
    if (paramSignatureResult.u32_check_result.get() == 0) {}
    for (int i = 1;; i = 0)
    {
      a(i);
      return;
    }
  }
  
  protected Class a()
  {
    return SecSigObserver.class;
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
    paramString1 = a("SecCheckSigSvc.UploadReq");
    paramString1.putWupBuffer(localSignatureReport.toByteArray());
    b(paramString1);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramFromServiceMsg.getServiceCmd();
    if ((localObject == null) || (((String)localObject).length() == 0)) {
      QLog.d("sec_sig_tag", 2, "onReceive: onReceive sec_server package: server cmd is null");
    }
    do
    {
      for (;;)
      {
        return;
        if ("SecCheckSigSvc.UploadReq".equalsIgnoreCase((String)localObject))
        {
          QLog.d("sec_sig_tag", 2, "onReceive: onReceive sec_server package:check result");
          if (!paramFromServiceMsg.isSuccess()) {
            break label281;
          }
          QLog.d("sec_sig_tag", 2, "onReceive: onReceive sec_server package:server result code ok");
          localObject = new signature.SignatureResult();
          try
          {
            ((signature.SignatureResult)localObject).mergeFrom((byte[])paramObject);
            if (((signature.SignatureResult)localObject).has()) {
              if ((((signature.SignatureResult)localObject).u32_protocol_version.has()) && (((signature.SignatureResult)localObject).u32_protocol_version.get() != 0))
              {
                QLog.d("sec_sig_tag", 2, "onReceive: onReceive sec_server protocol_version fail");
                return;
              }
            }
          }
          catch (InvalidProtocolBufferMicroException paramObject)
          {
            for (;;)
            {
              QLog.d("sec_sig_tag", 2, "onReceive: onReceive sec_server package:sigResult parse fail");
              paramObject.printStackTrace();
            }
            if ((!((signature.SignatureResult)localObject).str_packname.has()) || (((signature.SignatureResult)localObject).str_packname.get() == null))
            {
              QLog.d("sec_sig_tag", 2, "onReceive: onReceive sec_server package:packname fail");
              return;
            }
            if (!((signature.SignatureResult)localObject).u32_check_result.has())
            {
              QLog.d("sec_sig_tag", 2, "onReceive: onReceive sec_server package:checkresult fail");
              return;
            }
          }
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
    label281:
    QLog.d("sec_sig_tag", 2, "onReceive: onReceive sec_server package:server result code fail:" + paramFromServiceMsg.getBusinessFailCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecSigHandler
 * JD-Core Version:    0.7.0.1
 */