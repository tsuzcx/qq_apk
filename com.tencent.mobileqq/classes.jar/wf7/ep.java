package wf7;

import android.content.Context;
import java.util.ArrayList;

public class ep
{
  private em lT;
  private boolean lh = false;
  private dt mC;
  private ep.a ni;
  private boolean pc = false;
  private ez pd;
  private eu pe;
  
  public ep(boolean paramBoolean1, Context paramContext, dt paramdt, boolean paramBoolean2, ep.a parama, em.c paramc, em paramem, String paramString)
  {
    this.pc = paramBoolean1;
    this.ni = parama;
    this.mC = paramdt;
    this.lT = paramem;
    this.lh = paramBoolean2;
    if (this.pc)
    {
      this.pe = new dn(paramContext, paramBoolean2, paramdt, paramString);
      this.pd = new ez(paramContext, paramdt, this.pe, this.lh);
    }
  }
  
  public static void a(em.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramd != null) && (paramd.nE != null))
    {
      int j = paramd.nE.size();
      int i = 0;
      while (i < j)
      {
        x localx = (x)paramd.nE.get(i);
        if (localx != null)
        {
          el localel = el.cP();
          int k = localx.bH;
          int m = localx.bZ;
          String str;
          if (paramInt3 > 0) {
            str = String.format("%d/%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(j) });
          } else {
            str = null;
          }
          localel.a("SharkWharf", k, m, localx, paramInt1, paramInt2, str);
        }
        i += 1;
      }
    }
  }
  
  public void d(em.d paramd)
  {
    try
    {
      boolean bool = this.pc;
      if (bool)
      {
        if (paramd == null) {
          return;
        }
        if (paramd.cX())
        {
          if (paramd.nz)
          {
            this.ni.b(true, -30000007, paramd);
            return;
          }
          this.ni.b(true, -30001400, paramd);
          return;
        }
        paramd.ny = false;
        byte[] arrayOfByte = ee.a(paramd, false, this.lT.cC(), this.mC);
        if (arrayOfByte == null) {
          return;
        }
        a(paramd, 15, 0, arrayOfByte.length);
        this.pd.a(paramd, arrayOfByte, new ep.1(this, paramd));
        return;
      }
      throw new RuntimeException("sendData(), not in sending process!");
    }
    finally {}
  }
  
  public eu dc()
  {
    return this.pe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.ep
 * JD-Core Version:    0.7.0.1
 */