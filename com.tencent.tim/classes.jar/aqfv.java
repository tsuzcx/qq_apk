import android.os.SystemClock;
import android.widget.ListAdapter;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;

public class aqfv
{
  private static aqfv a = new aqfv();
  private HashSet<Object> bE;
  private HashSet<Object> bF;
  private HashMap<String, HashSet<Long>> oP;
  private HashMap<Object, MessageForShortVideo> oQ;
  
  public static aqfv a()
  {
    return a;
  }
  
  public boolean E(Object paramObject)
  {
    boolean bool = false;
    if (this.bE != null) {
      bool = this.bE.contains(paramObject);
    }
    return bool;
  }
  
  public boolean F(Object paramObject)
  {
    boolean bool = false;
    if (this.bF != null) {
      bool = this.bF.contains(paramObject);
    }
    return bool;
  }
  
  public MessageForShortVideo a(Object paramObject)
  {
    if ((paramObject != null) && (this.oQ != null)) {
      return (MessageForShortVideo)this.oQ.get(paramObject);
    }
    return null;
  }
  
  public void a(ChatXListView paramChatXListView)
  {
    if ((this.bE == null) || (this.bE.size() == 0)) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    HashSet localHashSet = new HashSet();
    int i = paramChatXListView.getFirstVisiblePosition();
    int k = paramChatXListView.getLastVisiblePosition();
    int j = paramChatXListView.getHeaderViewsCount();
    if (i > j) {}
    for (;;)
    {
      if ((i < j) || (i > k)) {
        break label147;
      }
      try
      {
        ChatMessage localChatMessage = (ChatMessage)paramChatXListView.getAdapter().getItem(i);
        if ((localChatMessage != null) && ((localChatMessage instanceof MessageForShortVideo)))
        {
          long l2 = localChatMessage.uniseq;
          if (this.bE.contains(Long.valueOf(l2))) {
            localHashSet.add(Long.valueOf(l2));
          }
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        for (;;)
        {
          localIndexOutOfBoundsException.printStackTrace();
        }
      }
      i += 1;
      continue;
      i = j;
    }
    label147:
    this.bE = localHashSet;
    QLog.d("ShortVideoUtils", 2, "markVisibleView cost time: " + (SystemClock.uptimeMillis() - l1));
  }
  
  public void a(Object paramObject, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramObject != null) && (paramMessageForShortVideo != null))
    {
      if (this.oQ == null) {
        this.oQ = new HashMap();
      }
      this.oQ.put(paramObject, paramMessageForShortVideo);
    }
  }
  
  public boolean b(MessageRecord paramMessageRecord, String paramString)
  {
    if (this.oP != null)
    {
      paramString = (HashSet)this.oP.get(paramString);
      if (paramString == null) {}
    }
    for (boolean bool = paramString.contains(Long.valueOf(paramMessageRecord.uniseq));; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOSingleReporter", 2, "hasReported(): mr.uniseq=" + paramMessageRecord.uniseq + " result = " + bool);
      }
      return bool;
    }
  }
  
  public void bz(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if (this.bF == null) {
      this.bF = new HashSet();
    }
    this.bF.add(paramObject);
  }
  
  public void clear()
  {
    if (this.oP != null)
    {
      this.oP.clear();
      this.oP = null;
    }
    if (this.bE != null)
    {
      this.bE.clear();
      this.bE = null;
    }
    if (this.bF != null)
    {
      this.bF.clear();
      this.bF = null;
    }
    if (this.oQ != null)
    {
      this.oQ.clear();
      this.oQ = null;
    }
  }
  
  public void f(Object paramObject, boolean paramBoolean)
  {
    if (paramObject == null) {
      return;
    }
    if (this.bE == null) {
      this.bE = new HashSet();
    }
    if (paramBoolean)
    {
      this.bE.add(paramObject);
      return;
    }
    this.bE.remove(paramObject);
  }
  
  public void g(MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (this.oP == null) {
      this.oP = new HashMap();
    }
    HashSet localHashSet2 = (HashSet)this.oP.get(paramString);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null)
    {
      localHashSet1 = new HashSet();
      this.oP.put(paramString, localHashSet1);
    }
    localHashSet1.add(Long.valueOf(paramMessageRecord.uniseq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfv
 * JD-Core Version:    0.7.0.1
 */