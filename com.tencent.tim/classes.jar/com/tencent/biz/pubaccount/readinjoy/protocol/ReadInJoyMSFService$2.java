package com.tencent.biz.pubaccount.readinjoy.protocol;

import android.os.Bundle;
import aqoj;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kxm;
import lun;
import luo;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class ReadInJoyMSFService$2
  implements Runnable
{
  public ReadInJoyMSFService$2(lun paramlun, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFService", 2, "req cmd: " + this.f.getServiceCmd());
    }
    for (;;)
    {
      try
      {
        if ((!this.f.extraData.getBoolean("req_pb_protocol_flag", false)) || (this.f.getWupBuffer() == null)) {
          break label441;
        }
        if (!lun.a(this.this$0, this.f))
        {
          long l = this.f.getWupBuffer().length;
          localObject = new byte[(int)l + 4];
          aqoj.DWord2Byte((byte[])localObject, 0, 4L + l);
          aqoj.b((byte[])localObject, 4, this.f.getWupBuffer(), (int)l);
          this.f.putWupBuffer((byte[])localObject);
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("ReadInJoyMSFService", 2, "PB cmd: req cmd: " + this.f.getServiceCmd());
            i = j;
          }
          if (i == 0) {
            break;
          }
          localObject = new NewIntent(kxm.getAppRuntime().getApplication(), luo.class);
          ((NewIntent)localObject).putExtra(ToServiceMsg.class.getSimpleName(), this.f);
          if (this.f.getAttributes().get("req_enable_msf_retry") != null)
          {
            bool = ((Boolean)this.f.getAttributes().get("req_enable_msf_retry")).booleanValue();
            if (bool)
            {
              this.f.setTimeout(360000L);
              ((NewIntent)localObject).putExtra("quickSendEnable", true);
              ((NewIntent)localObject).putExtra("quickSendStrategy", 0);
              QLog.d("ReadInJoyMSFService", 2, "handleRequest | MSF retry enabled");
            }
            kxm.getAppRuntime().startServlet((NewIntent)localObject);
            l = System.currentTimeMillis();
            this.f.extraData.putLong("sendtimekey", l);
          }
        }
        else
        {
          QLog.d("ReadInJoyMSFService", 1, "handleRequest | isRetryRequest ");
          continue;
        }
        StringBuilder localStringBuilder;
        boolean bool = false;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("handleRequest Exception. cmd=");
          if (this.f == null) {
            break label434;
          }
          localObject = this.f.getServiceCmd();
          QLog.e("ReadInJoyMSFService", 2, (String)localObject, localException);
        }
        localObject = new FromServiceMsg(this.f.getUin(), this.f.getServiceCmd());
        ((FromServiceMsg)localObject).setMsgFail();
        this.this$0.a(false, this.f, (FromServiceMsg)localObject, localException);
        return;
      }
      continue;
      label434:
      Object localObject = "";
      continue;
      label441:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService.2
 * JD-Core Version:    0.7.0.1
 */