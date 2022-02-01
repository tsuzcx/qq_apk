package wf7;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class fl<T>
{
  private int pZ = -1;
  private LinkedHashSet<T> qb = new LinkedHashSet();
  
  public fl(int paramInt)
  {
    this.pZ = paramInt;
  }
  
  public boolean b(T paramT)
  {
    try
    {
      boolean bool = this.qb.contains(paramT);
      return bool;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public T poll()
  {
    try
    {
      if (this.qb != null)
      {
        Object localObject1 = this.qb.iterator();
        if ((localObject1 != null) && (((Iterator)localObject1).hasNext()))
        {
          localObject1 = ((Iterator)localObject1).next();
          this.qb.remove(localObject1);
          return localObject1;
        }
      }
      return null;
    }
    finally {}
  }
  
  public void push(T paramT)
  {
    try
    {
      if (this.qb.size() >= this.pZ) {
        poll();
      }
      this.qb.add(paramT);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fl
 * JD-Core Version:    0.7.0.1
 */