import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajgg
  extends ajgl<MessageForMixedMsg>
{
  public ajgg(MessageForMixedMsg paramMessageForMixedMsg)
  {
    super(paramMessageForMixedMsg);
  }
  
  protected int Gm()
  {
    return 1;
  }
  
  public void dxl()
  {
    Iterator localIterator = ((MessageForMixedMsg)this.j).msgElemList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord instanceof MessageForPic)) {
        ajen.a(localMessageRecord).dxl();
      }
    }
  }
  
  public void dxn()
  {
    if (((MessageForMixedMsg)this.j).isSendFromLocal())
    {
      ((MessageForMixedMsg)this.j).issend = 2;
      ((MessageForMixedMsg)this.j).prewrite();
    }
  }
  
  public List<MsgBackupResEntity> fF()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((MessageForMixedMsg)this.j).msgElemList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (MessageRecord)localIterator.next();
      if ((localObject instanceof MessageForPic))
      {
        localObject = ajen.a((MessageRecord)localObject);
        ((ajgl)localObject).aq(this.j);
        localArrayList.addAll(((ajgl)localObject).fF());
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgg
 * JD-Core Version:    0.7.0.1
 */