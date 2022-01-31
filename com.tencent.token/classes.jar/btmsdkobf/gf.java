package btmsdkobf;

import android.os.Handler;

class gf
  implements Runnable
{
  gf(gb paramgb) {}
  
  public void run()
  {
    cy.d(this.a.a).removeMessages(3);
    try
    {
      cy.m(this.a.a).a(new gg(this));
      return;
    }
    catch (Exception localException)
    {
      eh.h("SharkNetwork", "[cu_guid]register guid exception: " + localException.toString());
      synchronized (cy.q(this.a.a))
      {
        cy.d(this.a.a, false);
        cy.a(this.a.a, -20000014);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.gf
 * JD-Core Version:    0.7.0.1
 */