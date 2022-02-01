import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

public class anch
  implements anbs
{
  private tpb<Integer, anbs> b = new tpc();
  
  public anch()
  {
    onCreate();
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, anax paramanax)
  {
    if (!((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.has()) {}
    anbs localanbs;
    do
    {
      return;
      int i = paramMsg.msg_head.c2c_cmd.get();
      localanbs = (anbs)this.b.get(Integer.valueOf(i));
    } while (localanbs == null);
    localanbs.a(paramMessageHandler, paramMsg, paramList, paramanax);
  }
  
  protected void onCreate()
  {
    this.b.a(Integer.valueOf(169), ancj.class);
    this.b.a(Integer.valueOf(241), ancj.class);
    this.b.a(Integer.valueOf(242), ancj.class);
    this.b.a(Integer.valueOf(243), ancj.class);
    this.b.a(Integer.valueOf(175), anci.class);
    this.b.a(Integer.valueOf(11), anci.class);
    this.b.a(Integer.valueOf(129), anck.class);
    this.b.a(Integer.valueOf(131), anck.class);
    this.b.a(Integer.valueOf(133), anck.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anch
 * JD-Core Version:    0.7.0.1
 */