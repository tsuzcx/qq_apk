package btmsdkobf;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class dn<T>
{
  private int hu = -1;
  private LinkedHashSet<T> mZ = new LinkedHashSet();
  
  public dn(int paramInt)
  {
    this.hu = paramInt;
  }
  
  public boolean b(T paramT)
  {
    try
    {
      boolean bool = this.mZ.contains(paramT);
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
      if (this.mZ != null)
      {
        Object localObject1 = this.mZ.iterator();
        if ((localObject1 != null) && (((Iterator)localObject1).hasNext()))
        {
          localObject1 = ((Iterator)localObject1).next();
          this.mZ.remove(localObject1);
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
      if (this.mZ.size() >= this.hu) {
        poll();
      }
      this.mZ.add(paramT);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dn
 * JD-Core Version:    0.7.0.1
 */