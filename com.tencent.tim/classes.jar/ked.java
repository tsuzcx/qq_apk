import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class ked
  extends achq
{
  ked(kec paramkec) {}
  
  public void bI(List<MessageRecord> paramList)
  {
    super.bI(paramList);
    HashSet localHashSet = new HashSet();
    if (kdm.fX != null) {
      localHashSet.addAll(kdm.fX);
    }
    kec localkec = (kec)this.b.mApp.getBusinessHandler(88);
    paramList = new ArrayList(paramList).iterator();
    label164:
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (("2".equals(localMessageRecord.getExtInfoFromExtStr("inter_num"))) || ((localMessageRecord.istroop == 1008) && (nyn.i(this.b.app, localMessageRecord.senderuin)))) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (!localHashSet.contains(localMessageRecord.senderuin))) {
          break label164;
        }
        if (i != 0) {
          localkec.d(localMessageRecord);
        }
        localkec.e(localMessageRecord);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ked
 * JD-Core Version:    0.7.0.1
 */