package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.get_config.ReqBody;
import com.tencent.ims.get_config.RspBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class AntiFraudGetConfigHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "UinSafety.Handler";
  public static final int b = 1;
  public static final String b = "proto_version";
  public static final String c = "config_name";
  public static final String d = "config_version";
  public static final String e = "effect_time";
  public static final String f = "md5";
  public static final String g = "download_url";
  public static final String h = "SecuritySvc.GetConfig";
  private int c = 1;
  
  AntiFraudGetConfigHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    for (int i = 1;; i = 0) {
      try
      {
        paramFromServiceMsg = new get_config.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = new Bundle();
        if (paramFromServiceMsg.u32_proto_version.has()) {
          i = paramFromServiceMsg.u32_proto_version.get();
        }
        paramObject.putInt("proto_version", i);
        paramToServiceMsg = "";
        if (paramFromServiceMsg.str_config_name.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_config_name.get();
        }
        paramObject.putString("config_name", paramToServiceMsg);
        if (paramFromServiceMsg.u32_config_version.has())
        {
          i = paramFromServiceMsg.u32_config_version.get();
          paramObject.putInt("config_version", i);
          i = j;
          if (paramFromServiceMsg.u32_effect_time.has()) {
            i = paramFromServiceMsg.u32_effect_time.get();
          }
          paramObject.putInt("effect_time", i);
          paramToServiceMsg = "";
          if (paramFromServiceMsg.str_md5.has()) {
            paramToServiceMsg = paramFromServiceMsg.str_md5.get();
          }
          paramObject.putString("md5", paramToServiceMsg);
          paramToServiceMsg = "";
          if (paramFromServiceMsg.str_download_link.has()) {
            paramToServiceMsg = paramFromServiceMsg.str_download_link.get();
          }
          paramObject.putString("download_url", paramToServiceMsg);
          a(1, true, paramObject);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("UinSafety.Handler", 2, "onGetAntiFraudConfig error:" + paramToServiceMsg.getMessage());
        return;
      }
    }
  }
  
  protected Class a()
  {
    return AntiFraudGetConfigObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess())) {}
    while (!paramFromServiceMsg.getServiceCmd().equalsIgnoreCase("SecuritySvc.GetConfig")) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UinSafety.Handler", 2, "getAntiFraudConfig");
    }
    get_config.ReqBody localReqBody = new get_config.ReqBody();
    localReqBody.u64_uin.set(this.a.getLongAccountUin());
    localReqBody.u32_appid.set(AppSetting.a);
    localReqBody.u32_proto_version.set(1);
    PBUInt32Field localPBUInt32Field = localReqBody.u32_seq;
    int i = this.c;
    this.c = (i + 1);
    localPBUInt32Field.set(i);
    localReqBody.str_config_name.set(paramString);
    paramString = AntiFraudConfigFileUtil.a().a(paramString, "Version");
    int j = 0;
    i = j;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = Integer.parseInt(paramString);
      localReqBody.u32_config_version.set(i);
      paramString = a("SecuritySvc.GetConfig");
      paramString.putWupBuffer(localReqBody.toByteArray());
      b(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.AntiFraudGetConfigHandler
 * JD-Core Version:    0.7.0.1
 */