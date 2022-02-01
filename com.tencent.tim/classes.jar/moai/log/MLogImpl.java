package moai.log;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class MLogImpl
  extends SimpleMLog
{
  private final List<Handler> handlers = new CopyOnWriteArrayList();
  
  public void addHandler(Handler paramHandler)
  {
    this.handlers.add(paramHandler);
  }
  
  public Handler[] getAllHandler()
  {
    return (Handler[])this.handlers.toArray(new Handler[0]);
  }
  
  protected void process(int paramInt, String paramString1, String paramString2)
  {
    Iterator localIterator = this.handlers.iterator();
    while (localIterator.hasNext()) {
      ((Handler)localIterator.next()).publish(paramInt, paramString1, paramString2);
    }
  }
  
  protected void process(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    Iterator localIterator = this.handlers.iterator();
    while (localIterator.hasNext()) {
      ((Handler)localIterator.next()).publish(paramInt, paramString1, paramString2, paramThrowable);
    }
  }
  
  public boolean removeHandler(Handler paramHandler)
  {
    return this.handlers.remove(paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.MLogImpl
 * JD-Core Version:    0.7.0.1
 */