package wf7;

import java.util.Iterator;
import java.util.List;

public class cj
{
  private final int[] hv = { 0, 1, 2, 3 };
  private List<ci> hw = null;
  private final Object hx = new Object();
  
  public static cj aS()
  {
    return cj.a.hy;
  }
  
  public ci K(int paramInt)
  {
    synchronized (this.hx)
    {
      if ((this.hw != null) && (this.hw.size() > 0))
      {
        Iterator localIterator = this.hw.iterator();
        while (localIterator.hasNext())
        {
          ci localci = (ci)localIterator.next();
          if (localci.hi == paramInt) {
            return localci;
          }
        }
      }
      return null;
    }
  }
  
  public ci d(String paramString1, String paramString2, int paramInt)
  {
    synchronized (this.hx)
    {
      if ((this.hw != null) && (this.hw.size() > 0))
      {
        Iterator localIterator = this.hw.iterator();
        while (localIterator.hasNext())
        {
          ci localci = (ci)localIterator.next();
          if (localci.a(paramString1, paramInt, paramString2)) {
            return localci;
          }
        }
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.cj
 * JD-Core Version:    0.7.0.1
 */