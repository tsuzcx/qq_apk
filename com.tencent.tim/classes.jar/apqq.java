import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import java.util.Comparator;

class apqq
  implements Comparator<apqk.c>
{
  apqq(apqk paramapqk) {}
  
  public int a(apqk.c paramc1, apqk.c paramc2)
  {
    int j = -1;
    if (((paramc1 instanceof MessageForDeliverGiftTips)) && ((paramc2 instanceof MessageForDeliverGiftTips)))
    {
      paramc1 = (MessageForDeliverGiftTips)paramc1;
      paramc2 = (MessageForDeliverGiftTips)paramc2;
      int i;
      if ((paramc1.isToAll()) && (paramc2.isToAll())) {
        i = (int)(paramc1.time - paramc2.time);
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramc1.isToAll());
        if (paramc2.isToAll()) {
          return 1;
        }
        if ((paramc1.receiverUin == this.this$0.mApp.getLongAccountUin()) && (paramc2.receiverUin == this.this$0.mApp.getLongAccountUin())) {
          return (int)(paramc1.time - paramc2.time);
        }
        i = j;
      } while (paramc1.receiverUin == this.this$0.mApp.getLongAccountUin());
      if (paramc2.receiverUin == this.this$0.mApp.getLongAccountUin()) {
        return 1;
      }
      return (int)(paramc1.time - paramc2.time);
    }
    return (int)(paramc1.getShmsgseq() - paramc2.getShmsgseq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqq
 * JD-Core Version:    0.7.0.1
 */