package wf7;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

class el$1
  implements ei.b
{
  el$1(el paramel) {}
  
  public void cM()
  {
    synchronized (this.mF)
    {
      if (el.a(this.mF).size() > 0)
      {
        Iterator localIterator = el.a(this.mF).dK().entrySet().iterator();
        if (localIterator.hasNext()) {
          ((el.a)((Map.Entry)localIterator.next()).getValue()).mK = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.el.1
 * JD-Core Version:    0.7.0.1
 */