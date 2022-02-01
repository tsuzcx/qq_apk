import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.NotNull;

public class tom
{
  private MsgLruCache a;
  private ConcurrentHashMap<String, List<MessageRecord>> cL;
  protected ConcurrentHashMap<String, Lock> cM;
  
  public tom()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgPool", 2, "MsgPool() called " + this);
    }
    this.cL = new ConcurrentHashMap();
    this.cM = new ConcurrentHashMap();
    this.a = a();
  }
  
  public Map<String, List<MessageRecord>> T()
  {
    return this.cL;
  }
  
  @NotNull
  protected MsgLruCache a()
  {
    return new MsgLruCache(this);
  }
  
  public Lock a(String paramString)
  {
    if (!this.cM.containsKey(paramString)) {}
    synchronized (this.cM)
    {
      if (!this.cM.containsKey(paramString)) {
        this.cM.put(paramString, new ReentrantLock());
      }
      return (Lock)this.cM.get(paramString);
    }
  }
  
  public Lock a(String paramString, int paramInt)
  {
    return a(top.u(paramString, paramInt));
  }
  
  public MsgLruCache b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tom
 * JD-Core Version:    0.7.0.1
 */