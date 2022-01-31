package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.IndividPub.IndividPub.Platform_Comm_Req;
import com.tencent.IndividPub.IndividPub.expTips_Pull_Rsp;
import com.tencent.IndividPub.IndividPub.expTips_Req;
import com.tencent.IndividPub.IndividPub.expTips_Rsp;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class IndividualExpireInfoHandler
  extends BusinessHandler
{
  public static final String a = "IndivudualExpireInfoHandler";
  public static final String b = "IndividPub.ExpTips";
  public static final String c = "last_pull_individual_expire_info_time";
  protected QQAppInterface b;
  
  IndividualExpireInfoHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a()
  {
    IndividPub.expTips_Req localexpTips_Req = new IndividPub.expTips_Req();
    Object localObject = new IndividPub.Platform_Comm_Req();
    ((IndividPub.Platform_Comm_Req)localObject).platForm.set(109L);
    ((IndividPub.Platform_Comm_Req)localObject).osver.set(Build.VERSION.RELEASE);
    ((IndividPub.Platform_Comm_Req)localObject).mqqver.set("3.4.0.607");
    localexpTips_Req.comm.set((MessageMicro)localObject);
    localexpTips_Req.cmd.set(1);
    localexpTips_Req.setHasFlag(true);
    localObject = new ToServiceMsg("mobileqq.service", this.b.a(), "IndividPub.ExpTips");
    ((ToServiceMsg)localObject).putWupBuffer(localexpTips_Req.toByteArray());
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("IndivudualExpireInfoHandler", 2, "sendPbReq called.");
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("IndividPub.ExpTips".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IndivudualExpireInfoHandler", 2, "onReceive called.");
      }
      if (paramFromServiceMsg.isSuccess()) {
        break label48;
      }
      if (QLog.isColorLevel()) {
        QLog.i("IndivudualExpireInfoHandler", 2, "failed");
      }
    }
    label48:
    do
    {
      int i;
      do
      {
        for (;;)
        {
          return;
          paramToServiceMsg = new IndividPub.expTips_Rsp();
          try
          {
            paramToServiceMsg.mergeFrom((byte[])paramObject);
            if (paramToServiceMsg.ret.get() != 0L)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("IndivudualExpireInfoHandler", 2, "handleResponse, result=" + paramToServiceMsg.errmsg.get());
            }
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg)
          {
            paramToServiceMsg.printStackTrace();
            return;
          }
        }
        new IndividPub.expTips_Pull_Rsp();
        paramToServiceMsg = (IndividPub.expTips_Pull_Rsp)paramToServiceMsg.rspcmd_0x01.get();
        i = paramToServiceMsg.expFlag.get();
        paramToServiceMsg = paramToServiceMsg.content.get();
        paramFromServiceMsg = this.b.a().getSharedPreferences(this.b.a(), 0).edit();
        paramFromServiceMsg.putInt("renewal_tail_tip_exit", i);
        paramFromServiceMsg.putString("renewal_tail_tip", paramToServiceMsg);
        paramFromServiceMsg.commit();
      } while (i == 0);
      ReportController.b(this.b, "CliOper", "", "", "aio_pay", "aio_preshow", 0, 0, "" + i, "", "", "");
      paramToServiceMsg = this.b.a(ChatActivity.class);
    } while (paramToServiceMsg == null);
    paramToServiceMsg.sendMessage(paramToServiceMsg.obtainMessage(26));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualExpireInfoHandler
 * JD-Core Version:    0.7.0.1
 */