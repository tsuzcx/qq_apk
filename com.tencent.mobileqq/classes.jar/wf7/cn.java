package wf7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cn
  extends co
{
  private static final List<cn.a> hC = new ArrayList();
  private cn.a hB;
  
  public cn(String arg1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    cn.a locala = new cn.a(null);
    locala.hD = System.currentTimeMillis();
    locala.fZ = paramString2;
    locala.ey = ???;
    locala.eV = cp.S(paramInt1);
    locala.hE = paramInt2;
    locala.hF = paramBoolean;
    locala.hG = paramInt3;
    if (!a(locala)) {
      synchronized (hC)
      {
        hC.add(locala);
        this.hB = locala;
        return;
      }
    }
    this.hB = null;
  }
  
  private boolean a(cn.a parama)
  {
    synchronized (hC)
    {
      long l = System.currentTimeMillis();
      Iterator localIterator = hC.iterator();
      while (localIterator.hasNext())
      {
        cn.a locala = (cn.a)localIterator.next();
        if ((locala.ey.compareTo(parama.ey) == 0) && (locala.fZ.compareTo(parama.fZ) == 0) && (locala.eV == parama.eV)) {
          return true;
        }
        if (l - locala.hD > 3600000L) {
          localIterator.remove();
        }
      }
    }
    if (hC.size() + 1 > 100) {
      hC.remove(0);
    }
    return false;
  }
  
  public int F()
  {
    return 76;
  }
  
  public void a(String... paramVarArgs)
  {
    a(6, this.hB.hD);
    a(7, this.hB.fZ);
    a(8, this.hB.ey);
    b(9, this.hB.eV);
    b(10, this.hB.hE);
    a(11, this.hB.hF);
    b(12, this.hB.hG);
  }
  
  protected boolean aU()
  {
    return false;
  }
  
  public void b(String... paramVarArgs)
  {
    if (this.hB != null) {
      super.b(new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.cn
 * JD-Core Version:    0.7.0.1
 */