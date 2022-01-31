package wf7;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class en$b
  implements Runnable
{
  private TreeMap<Integer, en.a> om = new TreeMap();
  
  private en$b(en paramen) {}
  
  public void a(Integer paramInteger, en.a parama)
  {
    this.om.put(paramInteger, parama);
  }
  
  public Set<Map.Entry<Integer, en.a>> cZ()
  {
    synchronized (this.om)
    {
      TreeMap localTreeMap2 = (TreeMap)this.om.clone();
      return localTreeMap2.entrySet();
    }
  }
  
  public void run()
  {
    boolean bool = fi.dI();
    Iterator localIterator = cZ().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!bool)
      {
        this.nS.a(Process.myPid(), ((en.a)localEntry.getValue()).ob, 0, ((en.a)localEntry.getValue()).gV, null, -1000002, 0);
      }
      else if (((en.a)localEntry.getValue()).cW())
      {
        this.nS.a(Process.myPid(), ((en.a)localEntry.getValue()).ob, 0, ((en.a)localEntry.getValue()).gV, null, -1000017, 0);
        en.e(this.nS).t(((en.a)localEntry.getValue()).gV, -1000017);
      }
      else
      {
        Object localObject = Message.obtain(en.f(this.nS), 0, localEntry.getValue());
        en.f(this.nS).sendMessageDelayed((Message)localObject, 185000L);
        localObject = df.a(((en.a)localEntry.getValue()).of);
        en.e(this.nS).a(((en.a)localEntry.getValue()).nL, ((en.a)localEntry.getValue()).oe, ((en.a)localEntry.getValue()).ob, ((en.a)localEntry.getValue()).oc, ((en.a)localEntry.getValue()).od, ((en.a)localEntry.getValue()).gV, (byte[])localObject, ((en.a)localEntry.getValue()).oh, ((en.a)localEntry.getValue()).oj, ((en.a)localEntry.getValue()).ok, ((en.a)localEntry.getValue()).ol);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.en.b
 * JD-Core Version:    0.7.0.1
 */