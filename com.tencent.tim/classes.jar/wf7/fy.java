package wf7;

import android.content.Intent;
import android.util.SparseIntArray;
import com.tencent.wifisdk.services.common.api.d;
import java.util.HashMap;
import java.util.Map;

public class fy
  implements as
{
  private hd rK;
  private SparseIntArray rL = new SparseIntArray();
  private Map<as.a, a> rM = new HashMap();
  
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
      a locala2 = (a)this.rM.get(parama);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a(parama);
        this.rM.put(parama, locala1);
      }
      this.rK.a(paramInt, locala1);
    }
  }
  
  public void a(as.a parama)
  {
    parama = (a)this.rM.remove(parama);
    if (parama != null) {
      this.rK.a(parama);
    }
  }
  
  class a
    implements d
  {
    private as.a rN;
    
    a(as.a parama)
    {
      this.rN = parama;
    }
    
    public void a(int paramInt, Intent paramIntent)
    {
      paramInt = fy.a(fy.this).indexOfValue(paramInt);
      if (paramInt >= 0)
      {
        paramInt = fy.a(fy.this).keyAt(paramInt);
        this.rN.a(paramInt, paramIntent);
      }
    }
    
    public int hashCode()
    {
      return this.rN.hashCode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.fy
 * JD-Core Version:    0.7.0.1
 */