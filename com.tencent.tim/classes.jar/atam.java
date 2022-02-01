import android.content.Context;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class atam
{
  private ArrayList<atam.a> _sessionInfoList = new ArrayList();
  private ReentrantLock mLock = new ReentrantLock();
  
  public atam.a a(long paramLong)
  {
    this.mLock.lock();
    int i = 0;
    atam.a locala;
    if (i < this._sessionInfoList.size())
    {
      locala = (atam.a)this._sessionInfoList.get(i);
      if (locala.sessionId != paramLong) {}
    }
    for (;;)
    {
      this.mLock.unlock();
      return locala;
      i += 1;
      break;
      locala = null;
    }
  }
  
  public void g(long paramLong, Context paramContext)
  {
    if (a(paramLong) != null) {
      return;
    }
    paramContext = new atam.a();
    paramContext.sessionId = paramLong;
    this.mLock.lock();
    this._sessionInfoList.add(paramContext);
    this.mLock.unlock();
  }
  
  public void remove(long paramLong)
  {
    this.mLock.lock();
    int i = 0;
    for (;;)
    {
      if (i < this._sessionInfoList.size())
      {
        if (((atam.a)this._sessionInfoList.get(i)).sessionId == paramLong) {
          this._sessionInfoList.remove(i);
        }
      }
      else
      {
        this.mLock.unlock();
        return;
      }
      i += 1;
    }
  }
  
  public class a
  {
    public long sessionId;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atam
 * JD-Core Version:    0.7.0.1
 */