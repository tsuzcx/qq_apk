import android.text.TextUtils;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class afrw
{
  private Map<String, Long> dp = new HashMap();
  private Map<String, Integer> dq = new HashMap();
  private Map<String, List<StructMsg.ButtonInfo>> ko = new HashMap();
  private byte[] lock = new byte[1];
  
  public void a(String paramString, List<StructMsg.ButtonInfo> paramList, int paramInt, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.lock)
      {
        if (this.ko.containsKey(paramString)) {
          this.ko.remove(paramString);
        }
        this.ko.put(paramString, paramList);
        this.dq.put(paramString, Integer.valueOf(paramInt));
        this.dp.put(paramString, Long.valueOf(paramLong));
        return;
      }
    }
  }
  
  public void ah(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.lock)
      {
        this.dp.put(paramString, Long.valueOf(paramLong));
        return;
      }
    }
  }
  
  public long ak(String paramString)
  {
    long l2 = -1L;
    byte[] arrayOfByte = this.lock;
    long l1 = l2;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        l1 = l2;
        if (this.dp.containsKey(paramString)) {
          l1 = ((Long)this.dp.get(paramString)).longValue();
        }
      }
      return l1;
    }
    finally {}
  }
  
  public List<StructMsg.ButtonInfo> au(String paramString)
  {
    synchronized (this.lock)
    {
      if (this.ko.containsKey(paramString))
      {
        paramString = (List)this.ko.get(paramString);
        return paramString;
      }
      return null;
    }
  }
  
  public int cQ(String paramString)
  {
    synchronized (this.lock)
    {
      if ((!TextUtils.isEmpty(paramString)) && (this.dq.containsKey(paramString)))
      {
        int i = ((Integer)this.dq.get(paramString)).intValue();
        return i;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrw
 * JD-Core Version:    0.7.0.1
 */