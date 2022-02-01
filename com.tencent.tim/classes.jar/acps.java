import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import mqq.manager.Manager;

public class acps
  extends Observable
  implements Manager
{
  private final QQAppInterface app;
  private HashMap<String, SoftReference<acpu>> taskCache = new HashMap();
  
  public acps(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private acpu a(String paramString)
  {
    for (;;)
    {
      synchronized (this.taskCache)
      {
        localObject1 = (SoftReference)this.taskCache.get(paramString);
        if (localObject1 != null)
        {
          localObject1 = (acpu)((SoftReference)localObject1).get();
          Object localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new acpu(this.app, paramString, new acpt(this));
            this.taskCache.put(paramString, new SoftReference(localObject2));
          }
          return localObject2;
        }
      }
      Object localObject1 = null;
    }
  }
  
  public void FW(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.FullMessageSearch", 2, "pauseSearch " + paramString);
    }
    for (;;)
    {
      synchronized (this.taskCache)
      {
        paramString = (SoftReference)this.taskCache.get(paramString);
        if (paramString != null)
        {
          paramString = (acpu)paramString.get();
          if (paramString != null) {
            paramString.pause();
          }
          return;
        }
      }
      paramString = null;
    }
  }
  
  public FullMessageSearchResult a(String paramString)
  {
    return a(paramString).b();
  }
  
  public FullMessageSearchResult b(String paramString)
  {
    return a(paramString).c();
  }
  
  public void onDestroy()
  {
    stopSearch();
  }
  
  public void stopSearch()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.FullMessageSearch", 2, "stopSearch " + this.taskCache.size());
    }
    synchronized (this.taskCache)
    {
      Iterator localIterator = this.taskCache.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (SoftReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = (acpu)((SoftReference)localObject2).get();
          if (localObject2 != null) {
            ((acpu)localObject2).sm(2);
          }
        }
      }
    }
    this.taskCache.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acps
 * JD-Core Version:    0.7.0.1
 */