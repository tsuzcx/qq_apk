package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.device_lock_query_status.ReqBody;
import com.tencent.ims.device_lock_query_status.RspBody;
import com.tencent.ims.get_config.ReqBody;
import com.tencent.ims.get_config.RspBody;
import com.tencent.ims.wx_msg_opt.ReqBody;
import com.tencent.ims.wx_msg_opt.RspBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class SecSvcHandler
  extends BusinessHandler
{
  public static final int a = 0;
  public static final String a = "SecSvcHandler";
  public static final int b = 1;
  public static final String b = "SecuritySvc.GetConfig";
  public static final int c = 2;
  public static final String c = "DevLockAuthSvc.WxMsgOpt";
  public static final int d = 3;
  public static final String d = "DevLockSecSvc.DevLockQuery";
  public static final int e = 1;
  public static final String e = "proto_version";
  public static final String f = "config_name";
  public static final String g = "config_version";
  public static final String h = "effect_time";
  public static final String i = "md5";
  public static final String j = "download_url";
  public static final String k = "cmd";
  public static final String l = "ret";
  public static final String m = "opt";
  public static final String n = "wording";
  public static final String o = "status";
  public static final String p = "wording";
  private int f = 1;
  
  SecSvcHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i2 = 0;
    int i1 = 1;
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(1, false, null);
      return;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new get_config.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = new Bundle();
        if (paramFromServiceMsg.u32_proto_version.has()) {
          i1 = paramFromServiceMsg.u32_proto_version.get();
        }
        paramObject.putInt("proto_version", i1);
        paramToServiceMsg = "";
        if (paramFromServiceMsg.str_config_name.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_config_name.get();
        }
        paramObject.putString("config_name", paramToServiceMsg);
        if (!paramFromServiceMsg.u32_config_version.has()) {
          break label266;
        }
        i1 = paramFromServiceMsg.u32_config_version.get();
        paramObject.putInt("config_version", i1);
        i1 = i2;
        if (paramFromServiceMsg.u32_effect_time.has()) {
          i1 = paramFromServiceMsg.u32_effect_time.get();
        }
        paramObject.putInt("effect_time", i1);
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
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SecSvcHandler", 2, "onGetAntiFraudConfig error:" + paramToServiceMsg.getMessage());
      return;
      label266:
      i1 = 0;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 1;
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(2, false, null);
      return;
    }
    paramObject = new wx_msg_opt.RspBody();
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new Bundle();
        if (paramObject.uint32_cmd.has()) {
          i1 = paramObject.uint32_cmd.get();
        }
        paramFromServiceMsg.putInt("cmd", i1);
        i1 = -1;
        if (paramObject.uint32_ret.has()) {
          i1 = paramObject.uint32_ret.get();
        }
        paramFromServiceMsg.putInt("ret", i1);
        if (!paramObject.uint32_opt.has()) {
          break label203;
        }
        i1 = paramObject.uint32_opt.get();
        paramFromServiceMsg.putInt("opt", i1);
        paramToServiceMsg = "";
        if (paramObject.str_wording.has()) {
          paramToServiceMsg = paramObject.str_wording.get();
        }
        paramFromServiceMsg.putString("wording", paramToServiceMsg);
        a(2, true, paramFromServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SecSvcHandler", 2, "onWXSyncQQMsgOption error:" + paramToServiceMsg.getMessage());
      return;
      label203:
      i1 = 2;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(3, false, null);
      return;
    }
    paramObject = new device_lock_query_status.RspBody();
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new Bundle();
        if (!paramObject.u32_status.has()) {
          break label178;
        }
        i1 = paramObject.u32_status.get();
        paramFromServiceMsg.putInt("status", i1);
        paramToServiceMsg = "";
        if (paramObject.str_wording.has()) {
          paramToServiceMsg = paramObject.str_wording.get();
        }
        paramFromServiceMsg.putString("wording", paramToServiceMsg);
        boolean bool1 = bool2;
        if (paramObject.u32_ret.has())
        {
          bool1 = bool2;
          if (paramObject.u32_ret.get() == 0) {
            bool1 = true;
          }
        }
        a(3, bool1, paramFromServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SecSvcHandler", 2, "onQueryDevLockStatus error:" + paramToServiceMsg.getMessage());
      return;
      label178:
      int i1 = 0;
    }
  }
  
  protected Class a()
  {
    return SecSvcObserver.class;
  }
  
  public void a()
  {
    wx_msg_opt.ReqBody localReqBody = new wx_msg_opt.ReqBody();
    localReqBody.uint64_uin.set(this.a.getLongAccountUin());
    localReqBody.uint32_cmd.set(1);
    Object localObject = localReqBody.uint32_seq;
    int i1 = this.f;
    this.f = (i1 + 1);
    ((PBUInt32Field)localObject).set(i1);
    localReqBody.uint32_opt.set(1);
    localObject = a("DevLockAuthSvc.WxMsgOpt");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (str.equalsIgnoreCase("SecuritySvc.GetConfig")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (str.equalsIgnoreCase("DevLockAuthSvc.WxMsgOpt"))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!str.equalsIgnoreCase("DevLockSecSvc.DevLockQuery"));
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecSvcHandler", 2, "getAntiFraudConfig");
    }
    get_config.ReqBody localReqBody = new get_config.ReqBody();
    localReqBody.u64_uin.set(this.a.getLongAccountUin());
    localReqBody.u32_appid.set(AppSetting.a);
    localReqBody.u32_proto_version.set(1);
    PBUInt32Field localPBUInt32Field = localReqBody.u32_seq;
    int i1 = this.f;
    this.f = (i1 + 1);
    localPBUInt32Field.set(i1);
    localReqBody.str_config_name.set(paramString);
    paramString = AntiFraudConfigFileUtil.a().a(paramString, "Version");
    int i2 = 0;
    i1 = i2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i1 = Integer.parseInt(paramString);
      localReqBody.u32_config_version.set(i1);
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
        i1 = i2;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 2;
    if (QLog.isColorLevel()) {
      QLog.d("SecSvcHandler", 2, "setWXSyncQQMsgOption");
    }
    wx_msg_opt.ReqBody localReqBody = new wx_msg_opt.ReqBody();
    localReqBody.uint64_uin.set(this.a.getLongAccountUin());
    localReqBody.uint32_cmd.set(2);
    Object localObject = localReqBody.uint32_seq;
    int i2 = this.f;
    this.f = (i2 + 1);
    ((PBUInt32Field)localObject).set(i2);
    localObject = localReqBody.uint32_opt;
    if (paramBoolean) {
      i1 = 1;
    }
    ((PBUInt32Field)localObject).set(i1);
    localObject = a("DevLockAuthSvc.WxMsgOpt");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void b()
  {
    device_lock_query_status.ReqBody localReqBody = new device_lock_query_status.ReqBody();
    Object localObject = localReqBody.u32_seq;
    int i1 = this.f;
    this.f = (i1 + 1);
    ((PBUInt32Field)localObject).set(i1);
    localReqBody.u32_sys_type.set(1);
    localReqBody.u32_app_id.set(AppSetting.a);
    localObject = a("DevLockSecSvc.DevLockQuery");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecSvcHandler
 * JD-Core Version:    0.7.0.1
 */