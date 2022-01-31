package wf7;

import android.os.Handler;

class em$2$3$1
  implements ef.a
{
  em$2$3$1(em.2.3 param3) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String arg4)
  {
    paramInt3 = dm.ad(paramInt3);
    ef.a(em.q(this.nr.np.nm), paramInt3, ???);
    el.cP().a("SharkNetwork", paramInt2, paramInt1, (ae)null, 30, paramInt3);
    el.cP().aj(paramInt1);
    synchronized (em.h(this.nr.np.nm))
    {
      em.c(this.nr.np.nm, false);
      if (paramInt3 == 0)
      {
        em.d(this.nr.np.nm).sendEmptyMessage(1);
        return;
      }
    }
    if (paramInt3 > 0) {}
    for (paramInt1 = Math.abs(-800000000) + paramInt3;; paramInt1 = -800000000 + paramInt3)
    {
      em.a(this.nr.np.nm, false, false, paramInt1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.em.2.3.1
 * JD-Core Version:    0.7.0.1
 */