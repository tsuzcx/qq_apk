package wf7;

import android.text.TextUtils;

public class cu
{
  private int in = -1;
  private int io = -1;
  private int ip = 4;
  private int iq = 50;
  
  private cu()
  {
    bh();
    bi();
    bg();
    ce.aK().a(952, new cu.1(this));
  }
  
  public static final cu bf()
  {
    return cu.a.is;
  }
  
  public static int n(bn parambn)
  {
    bk localbk = (bk)ao.c().i(2);
    if ((parambn != null) && (localbk.d(parambn))) {
      return parambn.ad().L();
    }
    return 0;
  }
  
  public void bg()
  {
    cd localcd = ce.aK().H(952);
    if (localcd != null)
    {
      this.ip = localcd.e(0, 4);
      this.iq = localcd.e(1, 50);
    }
  }
  
  public void bh()
  {
    this.in = ch.aP().f(false);
  }
  
  public void bi()
  {
    this.io = ch.aP().aQ();
  }
  
  public boolean i(bn parambn)
  {
    return (parambn != null) && (parambn.ad().J() >= this.in) && (l(parambn));
  }
  
  public boolean j(bn parambn)
  {
    if (parambn == null) {
      return false;
    }
    int i = cw.bo().bp().X();
    return (parambn != null) && (parambn.ad().J() >= i) && (l(parambn));
  }
  
  public boolean k(bn parambn)
  {
    boolean bool = false;
    if (parambn == null) {
      return false;
    }
    int i = parambn.ab();
    if ((i == 2) && (parambn.ac().aj() != null) && (bw.c(parambn.ac().aj()) != bw.a.gB))
    {
      parambn = cw.p(parambn);
      if (parambn != null)
      {
        parambn = parambn.R();
        if ((parambn != null) && (!TextUtils.isEmpty(parambn.P)))
        {
          i = da.p(parambn.P);
          break label85;
        }
      }
      i = 1;
      label85:
      if (i == 1) {
        bool = true;
      }
      return bool;
    }
    return (parambn.ad().J() >= this.io) && (l(parambn)) && (ck.p(n(parambn), i));
  }
  
  public boolean l(bn parambn)
  {
    boolean bool2 = false;
    if (parambn == null) {
      return false;
    }
    Object localObject = cw.p(parambn);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((ct)localObject).R();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (ck.f(((d)localObject).v, parambn.ab()))
        {
          bool1 = bool2;
          if (da.p(((d)localObject).P) == 1) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean m(bn parambn)
  {
    return (parambn.ad().J() >= this.ip) && (cw.p(parambn).bc()) && (l(parambn)) && ((this.iq == -1) || (parambn.ac().getLevel() >= this.iq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.cu
 * JD-Core Version:    0.7.0.1
 */