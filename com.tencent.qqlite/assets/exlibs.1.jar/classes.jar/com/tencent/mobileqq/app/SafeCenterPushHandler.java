package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.ims.AccountSecurityInfo.SecCheckBanner;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x4a.MsgBody;

public class SafeCenterPushHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "SafeCenterPushHandler";
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static int e = 0;
  
  SafeCenterPushHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static int a()
  {
    return e;
  }
  
  public static void a()
  {
    try
    {
      e += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void b()
  {
    try
    {
      e -= 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = new MsgBody();
    try
    {
      ((MsgBody)localObject).mergeFrom(paramArrayOfByte);
      if ((!((MsgBody)localObject).has()) || (!((MsgBody)localObject).uint32_sec_cmd.has())) {
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SafeCenterPushHandler", 2, "onReceive: onReceive push package: msgbody parse fail");
        }
        paramArrayOfByte.printStackTrace();
      }
      switch (((MsgBody)localObject).uint32_sec_cmd.get())
      {
      case 2: 
      default: 
        return;
      }
    }
    ((PushSecSigHandler)this.a.a(23)).a();
    return;
    ((QPSafeCheckHandler)this.a.a(25)).a(((MsgBody)localObject).bytes_data.get().toByteArray());
    return;
    localObject = ((MsgBody)localObject).bytes_data.get().toByteArray();
    paramArrayOfByte = new AccountSecurityInfo.SecCheckBanner();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      localObject = paramArrayOfByte.str_wording.get();
      int i = paramArrayOfByte.u32_timeToShow.get();
      paramArrayOfByte = new Intent();
      paramArrayOfByte.putExtra("wording", (String)localObject);
      paramArrayOfByte.putExtra("timetowait", i);
      this.a.a(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SafeCenterPushHandler
 * JD-Core Version:    0.7.0.1
 */