import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.content.Intent;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader;

public class acsd
  extends tnv
{
  public acsd(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private void aR(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      for (;;)
      {
        return;
        C2CType0x211_SubC2CType0xb.MsgBody localMsgBody = new C2CType0x211_SubC2CType0xb.MsgBody();
        try
        {
          paramArrayOfByte = (C2CType0x211_SubC2CType0xb.MsgBody)localMsgBody.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = (C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader)paramArrayOfByte.msg_msg_header.get();
          if (paramArrayOfByte != null) {
            break label71;
          }
          if (QLog.isColorLevel())
          {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "<VideoMessageProcessor><---handle0x2110xbMsg : subMsgType[0xb] MsgHeader failed");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.msg.BaseMessageProcessor", 2, "<VideoMessageProcessor><---handle0x2110xbMsg : subMsgType[0xb] MsgBody failed", paramArrayOfByte);
    return;
    label71:
    long l1 = paramArrayOfByte.uint64_to_uin.get();
    long l2 = paramArrayOfByte.uint64_room_id.get();
    paramArrayOfByte = new Intent();
    paramArrayOfByte.setAction("tencent.video.q2v.AudioEngineReady");
    paramArrayOfByte.putExtra("uin", String.valueOf(l1));
    paramArrayOfByte.putExtra("c2cuin", l1);
    paramArrayOfByte.putExtra("c2croomid", l2);
    this.app.getApp().sendBroadcast(paramArrayOfByte);
    QLog.d("svenxu", 1, "ACTION_OPPOSITE_AUDIO_ENGINE_READY Send video c2c broadcast: selfUin = " + l1 + " roomid = " + l2);
  }
  
  private void j(byte[] paramArrayOfByte, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    aR(paramArrayOfByte);
  }
  
  public tov a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return new tov(null, true);
      if ((paramMsgInfo != null) && (paramSvcReqPushMsg != null))
      {
        a(paramSvcReqPushMsg.lUin, paramMsgInfo.vMsg, paramMsgInfo.lFromUin, (int)paramMsgInfo.uMsgTime);
      }
      else
      {
        bN(getClass().getName(), paramInt);
        continue;
        if ((paramMsgInfo != null) && (paramSvcReqPushMsg != null))
        {
          boolean bool = imi.g(paramMsgInfo.vMsg);
          this.app.a().a(paramSvcReqPushMsg.lUin, paramMsgInfo.vMsg, paramMsgInfo.lFromUin, (int)paramMsgInfo.uMsgTime, bool);
        }
        else
        {
          bN(getClass().getName(), paramInt);
        }
      }
    }
  }
  
  public void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt) {}
  
  public void f(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      j((byte[])paramVarArgs[2], 11);
      return;
    }
    bN(getClass().getName(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acsd
 * JD-Core Version:    0.7.0.1
 */