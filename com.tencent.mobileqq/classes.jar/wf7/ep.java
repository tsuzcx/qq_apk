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
        if (localx == null)
        {
          i += 1;
        }
        else
        {
          el localel = el.cP();
          int k = localx.bH;
          int m = localx.bZ;
          if (paramInt3 > 0) {}
          for (String str = String.format("%d/%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(j) });; str = null)
          {
            localel.a("SharkWharf", k, m, localx, paramInt1, paramInt2, str);
            break;
          }
        }
      }
    }
  }
  
  public void d(em.d paramd)
  {
    try
    {
      if (!this.pc) {
        throw new RuntimeException("sendData(), not in sending process!");
      }
    }
    finally {}
    if (paramd == null) {}
    for (;;)
    {
      return;
      if (!paramd.cX()) {
        break;
      }
      if (paramd.nz) {
        this.ni.b(true, -30000007, paramd);
      } else {
        this.ni.b(true, -30001400, paramd);
      }
    }
    for (;;)
    {
      paramd.ny = false;
      byte[] arrayOfByte = ee.a(paramd, false, this.lT.cC(), this.mC);
      if (arrayOfByte == null) {
        break;
      }
      a(paramd, 15, 0, arrayOfByte.length);
      this.pd.a(paramd, arrayOfByte, new ep.1(this, paramd));
      break;
      if (1 == 0) {}
    }
  }
  
  public eu dc()
  {
    return this.pe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.ep
 * JD-Core Version:    0.7.0.1
 */