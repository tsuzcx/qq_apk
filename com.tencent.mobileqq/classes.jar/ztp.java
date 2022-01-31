import IMMsgBodyPack.MsgType0x210;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.service.QavWrapper.OnReadyListener;
import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;

public class ztp
  implements QavWrapper.OnReadyListener
{
  public ztp(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210) {}
  
  public void a(QavWrapper paramQavWrapper)
  {
    paramQavWrapper.b(this.jdField_a_of_type_IMMsgBodyPackMsgType0x210.vProtobuf);
    paramQavWrapper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ztp
 * JD-Core Version:    0.7.0.1
 */