package wf7;

import android.os.Handler;

class em$2$2
  implements Runnable
{
  em$2$2(em.2 param2) {}
  
  public void run()
  {
    em.d(this.np.nm).removeMessages(2);
    if ((em.p(this.np.nm) > 0L) && (Math.abs(System.currentTimeMillis() - em.p(this.np.nm)) <= 20000L)) {
      synchronized (em.h(this.np.nm))
      {
        em.b(this.np.nm, false);
        em.a(this.np.nm, false);
        em.d(this.np.nm).sendEmptyMessage(1);
        return;
      }
    }
    for (;;)
    {
      try
      {
        em.g(this.np.nm).a(new em.2.2.1(this));
        return;
      }
      catch (Exception localException)
      {
        continue;
      }
      synchronized (em.h(this.np.nm))
      {
        em.b(this.np.nm, false);
        em.a(this.np.nm, false, true, -920000014);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.em.2.2
 * JD-Core Version:    0.7.0.1
 */