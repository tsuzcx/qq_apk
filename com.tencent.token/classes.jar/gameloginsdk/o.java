package gameloginsdk;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class o
{
  HashMap a = new HashMap(1000);
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.a.values().iterator();
      while (localIterator.hasNext()) {
        if (((l)localIterator.next()).a()) {
          localIterator.remove();
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    try
    {
      a();
      this.a.put(Long.valueOf(paramLong1), new l(paramLong1, paramLong2));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(long paramLong)
  {
    try
    {
      a();
      Object localObject1 = this.a.remove(Long.valueOf(paramLong));
      return localObject1 != null;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.o
 * JD-Core Version:    0.7.0.1
 */