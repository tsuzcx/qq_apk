package gameloginsdk;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

class m
{
  private LinkedBlockingQueue a = new LinkedBlockingQueue(10);
  
  private n b(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.b.equals(paramString)) {
        return localn;
      }
    }
    return null;
  }
  
  public long a(String paramString)
  {
    paramString = b(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.a;
  }
  
  public void a(long paramLong, String paramString)
  {
    if (b(paramString) != null) {}
    n localn;
    do
    {
      return;
      localn = new n(this);
      localn.a = paramLong;
      localn.b = paramString;
    } while (!this.a.offer(localn));
    this.a.poll();
    this.a.offer(localn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.m
 * JD-Core Version:    0.7.0.1
 */