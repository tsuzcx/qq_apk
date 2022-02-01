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
    return a.is;
  }
  
  public static int n(bn parambn)
  {
    bk localbk = (bk)ao.c().i(2);
    if ((parambn == null) || (!localbk.d(parambn))) {
      return 0;
    }
    return parambn.ad().L();
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
    if (parambn == null) {}
    int i;
    do
    {
      return false;
      i = cw.bo().bp().X();
    } while ((parambn == null) || (parambn.ad().J() < i) || (!l(parambn)));
    return true;
  }
  
  public boolean k(bn parambn)
  {
    boolean bool = true;
    if (parambn == null) {
      return false;
    }
    int i = parambn.ab();
    if ((i == 2) && (parambn.ac().aj() != null) && (bw.c(parambn.ac().aj()) != bw.a.gB))
    {
      parambn = cw.p(parambn);
      if (parambn == null) {
        break label127;
      }
      parambn = parambn.R();
      if ((parambn == null) || (TextUtils.isEmpty(parambn.P))) {
        break label127;
      }
    }
    label127:
    for (i = da.p(parambn.P);; i = 1)
    {
      if (i == 1) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
      if ((parambn.ad().J() < this.io) || (!l(parambn)) || (!ck.p(n(parambn), i))) {
        break;
      }
      return true;
    }
  }
  
  public boolean l(bn parambn)
  {
    boolean bool = true;
    if (parambn == null) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = cw.p(parambn);
      } while (localObject == null);
      localObject = ((ct)localObject).R();
    } while (localObject == null);
    if ((ck.f(((d)localObject).v, parambn.ab())) && (da.p(((d)localObject).P) == 1)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean m(bn parambn)
  {
    return (parambn.ad().J() >= this.ip) && (cw.p(parambn).bc()) && (l(parambn)) && ((this.iq == -1) || (parambn.ac().getLevel() >= this.iq));
  }
  
  static abstract interface a
  {
    public static final cu is = new cu(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.cu
 * JD-Core Version:    0.7.0.1
 */