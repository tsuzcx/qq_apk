package wf7;

import android.os.Handler;

class em$2$3
  implements Runnable
{
  em$2$3(em.2 param2) {}
  
  public void run()
  {
    em.d(this.np.nm).removeMessages(3);
    try
    {
      em.l(this.np.nm).a(new em.2.3.1(this));
      return;
    }
    catch (Exception localException)
    {
      synchronized (em.h(this.np.nm))
      {
        em.c(this.np.nm, false);
        em.a(this.np.nm, false, false, -820000014);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.em.2.3
 * JD-Core Version:    0.7.0.1
 */