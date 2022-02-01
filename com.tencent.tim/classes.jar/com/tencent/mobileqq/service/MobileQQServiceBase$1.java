package com.tencent.mobileqq.service;

import aefh;
import amzq;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class MobileQQServiceBase$1
  implements Runnable
{
  public MobileQQServiceBase$1(amzq paramamzq, ToServiceMsg paramToServiceMsg, aefh paramaefh, Class paramClass) {}
  
  public void run()
  {
    if (this.f == null) {}
    for (Object localObject = "";; localObject = this.f.getServiceCmd())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MobileQQServiceBase", 2, "req cmd: " + (String)localObject);
      }
      if ((this.f != null) && ("MessageSvc.PbSendMsg".equalsIgnoreCase((String)localObject)))
      {
        long l1 = this.f.extraData.getLong("msg_send_time", 0L);
        if (l1 != 0L)
        {
          long l2 = System.currentTimeMillis();
          this.f.extraData.putLong("msg_request_time", l2);
          this.f.extraData.putLong("msg_send_to_request_cost", l2 - l1);
        }
      }
      try
      {
        this.this$0.b(this.f, this.b, this.A);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("MobileQQServiceBase", 2, "handleRequest Exception. cmd = " + (String)localObject, localException);
        localObject = new FromServiceMsg(this.f.getUin(), (String)localObject);
        ((FromServiceMsg)localObject).setMsgFail();
        this.this$0.a(false, this.f, (FromServiceMsg)localObject, localException);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (!QLog.isColorLevel()) {
          break label259;
        }
        QLog.d("MobileQQServiceBase", 2, "handleRequest OutOfMemoryError. cmd = " + (String)localObject);
        localObject = new FromServiceMsg(this.f.getUin(), (String)localObject);
        ((FromServiceMsg)localObject).setMsgFail();
        this.this$0.a(false, this.f, (FromServiceMsg)localObject, null);
      }
    }
    label259:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.MobileQQServiceBase.1
 * JD-Core Version:    0.7.0.1
 */