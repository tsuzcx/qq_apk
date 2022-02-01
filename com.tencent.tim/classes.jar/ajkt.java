import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ajkt
  extends ajks
{
  public ajkt(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void F(HashMap<String, ArrayList<MessageRecord>> paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
      return;
    }
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      ArrayList localArrayList = (ArrayList)paramHashMap.get((String)localIterator.next());
      int i = 0;
      while (i < localArrayList.size())
      {
        MessageRecord localMessageRecord = (MessageRecord)localArrayList.get(i);
        if (((localMessageRecord instanceof MessageForFile)) || ((localMessageRecord instanceof MessageForTroopFile)))
        {
          String str = acfp.m(2131721065) + localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
          localArrayList.set(i, this.app.a().b().a(localMessageRecord, str, true));
        }
        i += 1;
      }
    }
  }
  
  public void a(ajlf paramajlf, HashMap<String, ArrayList<MessageRecord>> paramHashMap, ajkv paramajkv)
  {
    if (paramajlf == null) {
      return;
    }
    if ((paramajlf.djJ == 8) || (paramajlf.djJ == 9)) {}
    for (paramajlf = new agno(this.app, paramajlf, paramHashMap, paramajkv);; paramajlf = new agnm(this.app, paramajlf, paramHashMap, paramajkv))
    {
      this.app.a().a().a(paramajlf, paramHashMap);
      return;
      if (paramajlf.djJ == 2)
      {
        F(paramHashMap);
        paramajkv.a(0, 2, paramajlf);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajkt
 * JD-Core Version:    0.7.0.1
 */