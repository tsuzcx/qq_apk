import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgReqBody;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class acii
  extends accg
{
  protected QQAppInterface app;
  
  public acii(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.app = paramQQAppInterface;
  }
  
  public void a(List<NumRedMsg.NumMsgBusi> paramList, int paramInt, String paramString, long[] paramArrayOfLong)
  {
    NumRedMsg.NumMsgReqBody localNumMsgReqBody = new NumRedMsg.NumMsgReqBody();
    localNumMsgReqBody.i_proto_ver.set(1);
    localNumMsgReqBody.ui_plat_id.set(109);
    localNumMsgReqBody.str_client_ver.set("3.4.4.3058");
    localNumMsgReqBody.ui64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramList);
    localNumMsgReqBody.rpt_num_msg.set(localArrayList);
    paramList = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "red_touch_num_svr.get_num_msg");
    paramList.putWupBuffer(localNumMsgReqBody.toByteArray());
    paramList.extraData.putInt("NumMsgListenerKey", paramInt);
    paramList.extraData.putLongArray("NumMsgIDList", paramArrayOfLong);
    paramList.extraData.putString("NumMsgListenerCmd", paramString);
    sendPbReq(paramList);
    if (QLog.isColorLevel()) {
      QLog.i("NumRedMsgHandler", 2, "sendPbReq called.");
    }
  }
  
  protected void cR(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    for (;;)
    {
      paramFromServiceMsg = (altl)this.app.getManager(65);
      if (i != 0)
      {
        NumRedMsg.NumMsgRspBody localNumMsgRspBody = new NumRedMsg.NumMsgRspBody();
        try
        {
          localNumMsgRspBody.mergeFrom((byte[])paramObject);
          if (localNumMsgRspBody.i_retcode.get() == 0)
          {
            paramFromServiceMsg.a(localNumMsgRspBody, paramToServiceMsg, true);
            return;
            i = 0;
          }
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          for (;;)
          {
            paramObject.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.i("NumRedMsgHandler", 2, "mergeFrom failed");
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("NumRedMsgHandler", 2, "rsp code != 0 , error msg == " + localNumMsgRspBody.str_errmsg.get());
          }
          paramFromServiceMsg.a(localNumMsgRspBody, paramToServiceMsg, false);
          return;
        }
      }
    }
    paramFromServiceMsg.a(null, paramToServiceMsg, false);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("red_touch_num_svr.get_num_msg".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NumRedMsgHandler", 2, "onReceive called.");
      }
      cR(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acii
 * JD-Core Version:    0.7.0.1
 */