import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ajlf
{
  public List<ChatMessage> Dr;
  public List<MessageForStructing> Ds;
  public int action;
  public int bEW;
  public int bnm;
  public AbsStructMsg c;
  public boolean cpg;
  public int djJ;
  public int djK;
  private int djx;
  public int fileSize;
  public MessageForStructing j;
  public HashMap<String, ArrayList<MessageRecord>> lG;
  private Object lock = new Object();
  public Map<String, String> mb;
  private int resultCode;
  public SessionInfo sessionInfo;
  public int videoSize;
  
  public int Gs()
  {
    synchronized (this.lock)
    {
      int i = this.djx;
      return i;
    }
  }
  
  public void Re(int paramInt)
  {
    synchronized (this.lock)
    {
      this.djx ^= paramInt;
      return;
    }
  }
  
  public String getKey()
  {
    return String.valueOf(hashCode());
  }
  
  public int getResult()
  {
    synchronized (this.lock)
    {
      int i = this.resultCode;
      return i;
    }
  }
  
  public void iK(int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      int i = this.resultCode;
      if (paramInt1 == 0) {
        paramInt2 = 0;
      }
      this.resultCode = (i + paramInt2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajlf
 * JD-Core Version:    0.7.0.1
 */