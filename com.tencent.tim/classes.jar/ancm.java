import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.DataLineDecoder.1;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgType0x210;

public class ancm
  implements ancz
{
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineDecoder", 2, "<---decodeC2CMsgPkg_Dataline");
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DataLineDecoder", 2, "<---decodeC2CMsgPkg_Dataline: return isReaded4DataLine:" + paramBoolean);
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new DataLineDecoder.1(this, paramMessageHandler, paramMsg));
      return;
    }
    ((acde)paramMessageHandler.app.getBusinessHandler(8)).b(paramMsg);
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, anax paramanax, MessageHandler paramMessageHandler)
  {
    a(paramMessageHandler, paramMsg, paramanax.cEH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ancm
 * JD-Core Version:    0.7.0.1
 */