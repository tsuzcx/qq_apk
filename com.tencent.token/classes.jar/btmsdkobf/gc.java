package btmsdkobf;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;

class gc
  implements Runnable
{
  gc(gb paramgb, cy.f paramf, boolean paramBoolean) {}
  
  public void run()
  {
    if (cy.i(this.c.a) != null)
    {
      if (!this.a.jM) {}
      for (;;)
      {
        Object localObject3;
        synchronized (cy.i(this.c.a))
        {
          localObject3 = (ce)cy.i(this.c.a).get(997);
          if ((localObject3 != null) && (!((ce)localObject3).aW()))
          {
            eh.g("SharkNetwork", "[network_control] cloud cmd: fp donot connect, use http channel");
            this.a.jO = true;
          }
          ??? = this.a.jT;
          if ((??? == null) || (((ArrayList)???).size() <= 0)) {
            break;
          }
          eh.f("SharkNetwork", "[network_control] before control, sashimis.size(): " + ((ArrayList)???).size());
          ??? = ((ArrayList)???).iterator();
          if (!((Iterator)???).hasNext()) {
            break;
          }
          localObject3 = (as)((Iterator)???).next();
          if (localObject3 == null) {
            continue;
          }
        }
        synchronized (cy.i(this.c.a))
        {
          ce localce = (ce)cy.i(this.c.a).get(((as)localObject3).bM);
          if (localce == null) {
            continue;
          }
          if (localce.aW())
          {
            localce.aX();
            continue;
            localObject4 = finally;
            throw localObject4;
          }
        }
        localObject2.remove();
        eh.f("SharkNetwork", "network ctrl donot connect, cmdid : " + localObject4.bM);
        eh.g("SharkNetwork", "[network_control] cloud cmd: donot connect, cmdid : " + localObject4.bM);
        ??? = new ba();
        ((ba)???).bM = localObject4.bM;
        ((ba)???).df = -7;
        cy.a(this.c.a, true, false, this.a, -20000007, 0, (ba)???);
      }
    }
    ArrayList localArrayList = this.a.jT;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      eh.f("SharkNetwork", "[network_control] after control, sashimis.size(): " + localArrayList.size());
      try
      {
        this.c.a.a(this.b, this.a);
        return;
      }
      catch (Throwable localThrowable)
      {
        eh.h("SharkNetwork", localThrowable.toString());
        return;
      }
    }
    eh.g("SharkNetwork", "[network_control] no sashimi can connect, control by cloud cmd!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.gc
 * JD-Core Version:    0.7.0.1
 */