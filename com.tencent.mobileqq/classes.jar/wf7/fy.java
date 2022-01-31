package wf7;

import android.util.SparseIntArray;
import java.util.HashMap;
import java.util.Map;

public class fy
  implements as
{
  private hd rK;
  private SparseIntArray rL = new SparseIntArray();
  private Map<as.a, fy.a> rM = new HashMap();
  
  public fy(hd paramhd)
  {
    this.rK = paramhd;
    this.rL.put(1034, 101);
  }
  
  public void a(int paramInt, as.a parama)
  {
    paramInt = this.rL.get(paramInt);
    if (paramInt > 0)
    {
      fy.a locala2 = (fy.a)this.rM.get(parama);
      fy.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new fy.a(this, parama);
        this.rM.put(parama, locala1);
      }
      this.rK.a(paramInt, locala1);
    }
  }
  
  public void a(as.a parama)
  {
    parama = (fy.a)this.rM.remove(parama);
    if (parama != null) {
      this.rK.a(parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.fy
 * JD-Core Version:    0.7.0.1
 */