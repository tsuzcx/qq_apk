package btmsdkobf;

import android.content.Context;
import android.text.TextUtils;

public class dk
{
  private cy hF;
  private String mV = "";
  private boolean mW = false;
  
  public dk(Context paramContext, cy paramcy, boolean paramBoolean)
  {
    this.hF = paramcy;
    this.mV = this.hF.bL().aF();
  }
  
  private dj a(long paramLong, int paramInt, av paramav)
  {
    if (paramav == null) {}
    do
    {
      return null;
      if (paramav.dq == 0)
      {
        b(1, true);
        return null;
      }
    } while (paramav.dq != 1);
    b(1, false);
    return null;
  }
  
  private boolean aY()
  {
    if (!cx.ax()) {
      return false;
    }
    return TextUtils.isEmpty(this.mV);
  }
  
  private aq c(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = this.hF.bL().aF();
    String str1 = this.hF.bL().aG();
    label35:
    String str2;
    if (localObject1 != null)
    {
      if (str1 == null) {
        break label106;
      }
      str2 = this.hF.bL().aO();
      if (str2 == null) {
        break label113;
      }
      label52:
      if (!paramBoolean) {
        break label120;
      }
      localObject2 = new aq();
      ((aq)localObject2).cZ = paramInt;
      ((aq)localObject2).da = ((String)localObject1);
      ((aq)localObject2).cS = str1;
      ((aq)localObject2).cT = str2;
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      label106:
      label113:
      label120:
      do
      {
        return localObject2;
        localObject1 = "";
        break;
        str1 = "";
        break label35;
        str2 = "";
        break label52;
      } while (aY());
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str1)) && (!((String)localObject1).equals(str1)))
      {
        localObject2 = new aq();
        ((aq)localObject2).cZ = paramInt;
        ((aq)localObject2).da = ((String)localObject1);
        ((aq)localObject2).cS = str1;
        ((aq)localObject2).cT = str2;
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = null;
      }
    }
  }
  
  private ao cz()
  {
    ao localao = new ao();
    String str = this.hF.bL().aG();
    if (str != null)
    {
      localao.cS = str;
      str = this.hF.bL().aO();
      if (str == null) {
        break label56;
      }
    }
    for (;;)
    {
      localao.cT = str;
      return localao;
      str = "";
      break;
      label56:
      str = "";
    }
  }
  
  public void av()
  {
    eh.f("VidCertifier", "[cu_vid]registerVidIfNeed()");
    if (!this.hF.bL().aD())
    {
      eh.g("VidCertifier", "[cu_vid]registerVidIfNeed(), not support vid, do nothing");
      return;
    }
    if (this.mW)
    {
      eh.f("VidCertifier", "[cu_vid]registerVidIfNeed(), registering, ignore");
      return;
    }
    if (!aY())
    {
      eh.f("VidCertifier", "[cu_vid]registerVidIfNeed(), not necessary, mVidFromPhone: " + this.mV);
      return;
    }
    this.hF.bL().aE();
    this.mW = true;
    cx.bE().b(5006, cz(), new ax(), 0, new ie(this), 30000L);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (!this.hF.bL().aD()) {}
    aq localaq;
    do
    {
      return;
      localaq = c(paramInt, paramBoolean);
    } while (localaq == null);
    cx.bE().b(5007, localaq, new ay(), 0, new if(this), 30000L);
  }
  
  public void c(cy.d paramd)
  {
    ig localig = new ig(this);
    paramd.a(0L, 15020, new av(), 0, localig, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dk
 * JD-Core Version:    0.7.0.1
 */