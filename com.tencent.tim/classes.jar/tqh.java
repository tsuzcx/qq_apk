import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class tqh
  implements tpp
{
  public void a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    Iterator localIterator = paramList.iterator();
    im_msg_body.Elem localElem;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localElem = (im_msg_body.Elem)localIterator.next();
    } while ((!localElem.common_elem.has()) || (21 != localElem.common_elem.uint32_service_type.get()) || (3 != localElem.common_elem.uint32_business_type.get()));
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        aehj.a(paramList, paramList1, paramStringBuilder, paramMsg);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tqh
 * JD-Core Version:    0.7.0.1
 */