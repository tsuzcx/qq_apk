package wf7;

import java.util.ArrayList;
import java.util.Iterator;

class cv$1
  implements bo
{
  cv$1(cv paramcv, ArrayList paramArrayList) {}
  
  public boolean g(bn parambn)
  {
    Iterator localIterator = cv.a(this.iz).iterator();
    while (localIterator.hasNext())
    {
      ct localct = (ct)localIterator.next();
      if (parambn.e(localct.af()))
      {
        localct.bd();
        if (this.iy != null) {
          this.iy.remove(localct);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.cv.1
 * JD-Core Version:    0.7.0.1
 */