import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ShakeWindow;

public class tqg
  implements tpp
{
  public void a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    paramMsg = paramList.iterator();
    while (paramMsg.hasNext()) {
      if (((im_msg_body.Elem)paramMsg.next()).shake_window.has()) {
        new anbg().a(paramList, paramList1, paramStringBuilder, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tqg
 * JD-Core Version:    0.7.0.1
 */