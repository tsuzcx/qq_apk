package com.tencent.mqp.app.sec;

import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.ClientInfoA.EnvParamPacket;
import com.tencent.ims.ClientInfoA.ReportDetectResultPacket;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.security.MessageDigest;
import mqq.app.MobileQQ;
import twz;

class SecClientInfoTask$1
  implements Runnable
{
  SecClientInfoTask$1(SecClientInfoTask paramSecClientInfoTask) {}
  
  public void run()
  {
    Object localObject1 = null;
    for (;;)
    {
      QQAppInterface localQQAppInterface;
      String str;
      ClientInfoA.ReportDetectResultPacket localReportDetectResultPacket;
      Object localObject3;
      try
      {
        localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localQQAppInterface == null) {
          return;
        }
        str = "" + SecClientInfoTask.a(this.this$0);
        localReportDetectResultPacket = new ClientInfoA.ReportDetectResultPacket();
        localObject3 = new ClientInfoA.EnvParamPacket();
        ((ClientInfoA.EnvParamPacket)localObject3).u32_platform.set(1);
        ((ClientInfoA.EnvParamPacket)localObject3).str_sysversion.set(Build.VERSION.RELEASE);
        ((ClientInfoA.EnvParamPacket)localObject3).str_qqversion.set("3.4.4.3058");
        ((ClientInfoA.EnvParamPacket)localObject3).u32_appid.set(AppSetting.getAppId());
        ((ClientInfoA.EnvParamPacket)localObject3).bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
        ((ClientInfoA.EnvParamPacket)localObject3).str_uin.set(str);
        localReportDetectResultPacket.uint32_cmd.set(1);
        localReportDetectResultPacket.envParam.set((MessageMicro)localObject3);
        if (SecClientInfoTask.a(this.this$0) == 1)
        {
          localObject1 = SecClientInfoTask.m(SecClientInfoTask.b(this.this$0));
          if (localObject1 != null) {
            localReportDetectResultPacket.bytes_buffer.set(ByteStringMicro.copyFrom((byte[])localObject1));
          }
          localObject1 = new ToServiceMsg("mobileqq.service", str, "ClientInfoA.SecReport");
          if (localObject1 == null) {
            break;
          }
          ((ToServiceMsg)localObject1).putWupBuffer(localReportDetectResultPacket.toByteArray());
          ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
          ((ToServiceMsg)localObject1).setNeedCallback(false);
          localQQAppInterface.sendToService((ToServiceMsg)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      if (SecClientInfoTask.a(this.this$0) == 2)
      {
        if (!SecClientInfoTask.access$400())
        {
          SecClientInfoTask.access$502(twz.getFileMd5(localQQAppInterface.getApplication().getApplicationInfo().sourceDir));
          SecClientInfoTask.y(true);
        }
        if ((SecClientInfoTask.access$500() != null) && (SecClientInfoTask.access$500().length() > 0)) {
          localReportDetectResultPacket.str_qqmd5.set(SecClientInfoTask.access$500());
        }
        Object localObject2 = SecUtil.toHexString(NetConnInfoCenter.GUID).toLowerCase() + SecClientInfoTask.b(this.this$0);
        localObject3 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject3).update(((String)localObject2).getBytes());
        localReportDetectResultPacket.bytes_buffer.set(ByteStringMicro.copyFrom(((MessageDigest)localObject3).digest()));
        localObject2 = SecClientInfoTask.m(SecClientInfoTask.b(this.this$0) >> 1 & 0x7FFFFFFF);
        if (localObject2 != null) {
          localReportDetectResultPacket.bytes_buffer2.set(ByteStringMicro.copyFrom((byte[])localObject2));
        }
        localObject2 = new ToServiceMsg("mobileqq.service", str, "ClientInfoC.SecReport");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mqp.app.sec.SecClientInfoTask.1
 * JD-Core Version:    0.7.0.1
 */