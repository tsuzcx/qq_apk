package btmsdkobf;

import android.os.Handler;

class gd
  implements Runnable
{
  gd(gb paramgb) {}
  
  public void run()
  {
    cy.d(this.a.a).removeMessages(2);
    if ((cy.p(this.a.a) > 0L) && (Math.abs(System.currentTimeMillis() - cy.p(this.a.a)) <= 60000L))
    {
      eh.f("SharkNetwork", "[rsa_key]update rsa succ in 60s, no need to update now");
      synchronized (cy.q(this.a.a))
      {
        cy.c(this.a.a, false);
        cy.a(this.a.a, false);
        cy.d(this.a.a).sendEmptyMessage(1);
        eh.f("SharkNetwork", "[rsa_key]update rsa succ in 60s, no need to update now, broadcast after 5s");
        cy.d(this.a.a).removeMessages(5);
        cy.d(this.a.a).sendEmptyMessageDelayed(5, 5000L);
        return;
      }
    }
    try
    {
      cy.k(this.a.a).a(new ge(this));
      return;
    }
    catch (Exception localException)
    {
      eh.h("SharkNetwork", "[rsa_key] MSG_SHARK_UPDATE_RSAKEY e: " + localException.toString());
      synchronized (cy.q(this.a.a))
      {
        cy.c(this.a.a, false);
        cy.b(this.a.a, -20000014);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.gd
 * JD-Core Version:    0.7.0.1
 */