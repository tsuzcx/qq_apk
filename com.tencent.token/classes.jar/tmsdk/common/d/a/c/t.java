package tmsdk.common.d.a.c;

import a.e.f;
import a.e.g;
import java.util.ArrayList;
import java.util.Iterator;
import tmsdk.common.d.a.b.h;
import tmsdk.common.d.a.b.o;

public class t
  implements q
{
  protected o h = null;
  
  private ArrayList a(g paramg)
  {
    o localo = this.h;
    if (localo == null) {
      return null;
    }
    return localo.a(paramg);
  }
  
  public void a(int paramInt1, int paramInt2, f paramf) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = h.a(paramArrayOfByte);
    Object localObject = a(paramArrayOfByte);
    if (localObject == null) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      a(paramArrayOfByte.a, paramArrayOfByte.b, localf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.c.t
 * JD-Core Version:    0.7.0.1
 */