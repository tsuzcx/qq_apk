import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;

class adrn
  extends achq
{
  adrn(adrm paramadrm) {}
  
  public void b(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if ((adrm.a(this.this$0) != null) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord != null) && (localMessageRecord.uniseq == adrm.a(this.this$0).msgUniseq)) {
          this.this$0.iU(localMessageRecord.uniseq);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrn
 * JD-Core Version:    0.7.0.1
 */