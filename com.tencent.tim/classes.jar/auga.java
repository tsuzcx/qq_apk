import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import com.tencent.tim.dingdong.MessageForDingdongSchedule;
import com.trunk.Qworkflow.Qworkflow.AppID;
import tencent.im.oidb.cmd0x592.oidb_0x592.AcceptScheduleReq;
import tencent.im.oidb.cmd0x592.oidb_0x592.AcceptScheduleRsp;
import tencent.im.oidb.cmd0x592.oidb_0x592.ReqBody;
import tencent.im.oidb.cmd0x592.oidb_0x592.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class auga
  extends accg
{
  public auga(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private oidb_0x592.ReqBody b()
  {
    oidb_0x592.ReqBody localReqBody = new oidb_0x592.ReqBody();
    localReqBody.msg_appid.setHasFlag(true);
    localReqBody.msg_appid.uint64_appid.set(1800000002L);
    localReqBody.msg_appid.uint32_type.set(3);
    return localReqBody;
  }
  
  private void lT(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    int k = localOIDBSSOPkg.uint32_result.get();
    paramObject = (String)paramToServiceMsg.getAttribute("frienduin", "");
    String str1 = (String)paramToServiceMsg.getAttribute("extstr", "");
    String str2 = (String)paramToServiceMsg.getAttribute("scheduleid", "");
    int j = ((Integer)paramToServiceMsg.getAttribute("istroop", Integer.valueOf(0))).intValue();
    long l = ((Long)paramToServiceMsg.getAttribute("uniseq", Long.valueOf(0L))).longValue();
    for (;;)
    {
      try
      {
        localOIDBSSOPkg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if (1000 != i) {
          break label619;
        }
        try
        {
          localOIDBSSOPkg.mergeFrom(paramFromServiceMsg.getWupBuffer());
          if (k == 0) {
            break label619;
          }
          i = 1001;
          paramToServiceMsg = localOIDBSSOPkg.str_error_msg.get();
          QLog.e("ScheduleHandler", 1, localOIDBSSOPkg.uint32_service_type.get() + " ssoPkg biz return error(" + k + ") -> " + paramToServiceMsg);
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramToServiceMsg = paramFromServiceMsg.toString();
          QLog.e("ScheduleHandler", 1, " decode ssoPkg error -> " + paramFromServiceMsg.toString());
          i = 1001;
          continue;
          i = localOIDBSSOPkg.uint32_service_type.get();
          paramToServiceMsg = new oidb_0x592.RspBody();
          for (;;)
          {
            try
            {
              paramToServiceMsg.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
              switch (i)
              {
              default: 
                return;
              }
              paramToServiceMsg = (oidb_0x592.AcceptScheduleRsp)paramToServiceMsg.msg_accept_schedule_rsp.get();
              if (paramToServiceMsg == null)
              {
                i = -1;
                if (i != 0) {
                  break label508;
                }
                if (!paramToServiceMsg.bytes_schedule_id.has()) {
                  break;
                }
                notifyUI(0, true, new Object[] { paramObject, Integer.valueOf(j), Long.valueOf(l), str1, Integer.valueOf(i), paramToServiceMsg.bytes_schedule_id.get().toStringUtf8() });
                return;
              }
            }
            catch (InvalidProtocolBufferMicroException paramToServiceMsg)
            {
              QLog.e("ScheduleHandler", 1, "reqSeq[]0x592." + i + " decode pkg error -> " + paramToServiceMsg.toString());
              return;
            }
            i = paramToServiceMsg.uint32_result.get();
          }
          if (paramToServiceMsg == null) {
            continue;
          }
          paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
          notifyUI(0, false, new Object[] { paramObject, Integer.valueOf(j), Long.valueOf(l), str1, Integer.valueOf(i), str2 });
          return;
        }
        if (1000 == i)
        {
          i = localOIDBSSOPkg.uint32_command.get();
          switch (i)
          {
          default: 
            QLog.e("ScheduleHandler", 1, "unknown sso cmd:" + i);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        continue;
      }
      label508:
      QLog.e("ScheduleHandler", 1, "]result:" + i + ", retCode:" + k + ", retMsg:" + paramToServiceMsg);
      return;
      label619:
      paramToServiceMsg = null;
    }
  }
  
  public void a(MessageForDingdongSchedule paramMessageForDingdongSchedule)
  {
    Object localObject = new oidb_0x592.AcceptScheduleReq();
    ((oidb_0x592.AcceptScheduleReq)localObject).bytes_schedule_id.set(ByteStringMicro.copyFrom(paramMessageForDingdongSchedule.getSummaryData().id.getBytes()), true);
    oidb_0x592.ReqBody localReqBody = b();
    localReqBody.msg_accept_schedule_req.set((MessageMicro)localObject);
    localObject = super.makeOIDBPkg("OidbSvc.0x592", 1426, 19, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).addAttribute("scheduleid", paramMessageForDingdongSchedule.getSummaryData().id);
    ((ToServiceMsg)localObject).addAttribute("frienduin", paramMessageForDingdongSchedule.frienduin);
    ((ToServiceMsg)localObject).addAttribute("istroop", Integer.valueOf(paramMessageForDingdongSchedule.istroop));
    ((ToServiceMsg)localObject).addAttribute("uniseq", Long.valueOf(paramMessageForDingdongSchedule.uniseq));
    ((ToServiceMsg)localObject).addAttribute("extstr", "2");
    ((ToServiceMsg)localObject).setTimeout(20000L);
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void bt(String paramString1, String paramString2, String paramString3)
  {
    notifyUI(2, true, new Object[] { paramString1, paramString2, paramString3 });
  }
  
  protected Class<? extends acci> observerClass()
  {
    return augb.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    lT(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auga
 * JD-Core Version:    0.7.0.1
 */