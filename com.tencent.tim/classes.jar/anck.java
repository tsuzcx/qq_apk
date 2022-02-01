import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class anck
  implements anbs
{
  private anbc a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2, int paramInt)
  {
    im_msg_body.MsgBody localMsgBody = (im_msg_body.MsgBody)paramMsg.msg_body.get();
    int i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
    Long localLong1 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
    Long localLong2 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get());
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    Object localObject = localLong1.toString();
    String str = paramMessageHandler.app.getCurrentAccountUin();
    if (i == 129)
    {
      paramMsg = (msg_comm.Msg)localObject;
      if (((String)localObject).equals(String.valueOf(localLong2)))
      {
        paramMsg = (msg_comm.Msg)localObject;
        if (((String)localObject).equals(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile recv  a 0x81 that is from self.");
          }
          return null;
        }
      }
    }
    else
    {
      if (!str.equals(String.valueOf(localLong1))) {
        break label238;
      }
      paramMsg = String.valueOf(localLong2);
    }
    switch (i)
    {
    }
    for (;;)
    {
      return null;
      label238:
      paramMsg = String.valueOf(localLong1);
      break;
      if (str.equalsIgnoreCase(String.valueOf(localLong1)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.it is from self!!!");
        }
        return null;
      }
      if (paramBoolean2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("OnlineFileDecoder", 2, "recv roam online msg, return null!");
        }
        return null;
      }
      localObject = paramMessageHandler.app.a().a(localMsgBody.msg_content.get().toByteArray());
      if (localObject != null)
      {
        if (!paramMessageHandler.app.a().a((agnj)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.");
          }
          return null;
        }
        if (!((agnj)localObject).cey)
        {
          if (QLog.isColorLevel()) {
            QLog.w("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81. requset is no mulitend olfile.");
          }
          return null;
        }
        paramMessageHandler.app.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (agnj)localObject, paramLong2, paramInt);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x81 failed.");
        }
        return null;
        localObject = paramMessageHandler.app.a().a(localMsgBody.msg_content.get().toByteArray());
        if (localObject != null)
        {
          if (!paramMessageHandler.app.a().a((agnj)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x83  is error.");
            }
            return null;
          }
          paramMessageHandler.app.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (agnj)localObject, paramLong2, paramInt);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x83 failed.");
          }
          return null;
          localObject = paramMessageHandler.app.a().b(localMsgBody.msg_content.get().toByteArray());
          if (localObject == null) {
            break label632;
          }
          if (!paramMessageHandler.app.a().a((agnj)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x85  is error.");
            }
            return null;
          }
          paramMessageHandler.app.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (agnj)localObject, paramLong2, paramInt);
        }
      }
    }
    label632:
    if (QLog.isColorLevel()) {
      QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x85 failed.");
    }
    return null;
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, anax paramanax)
  {
    a(paramMessageHandler, paramMsg, paramanax.friendUin, paramanax.isRead, paramanax.cEC, paramanax.vipBubbleID, paramanax.dEN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anck
 * JD-Core Version:    0.7.0.1
 */