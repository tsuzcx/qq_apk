package btmsdkobf;

class ge
  implements cs.a
{
  ge(gd paramgd) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = bz.p(paramInt3);
    eh.e("SharkNetwork", "[rsa_key]onUpdateFinish(), ret: " + paramInt3);
    for (;;)
    {
      synchronized (cy.q(this.a.a.a))
      {
        cy.c(this.a.a.a, false);
        cv.by().a("SharkNetwork", paramInt2, paramInt1, (ba)null, 30, paramInt3);
        cv.by().x(paramInt1);
        if (paramInt3 == 0)
        {
          cs.a(cy.e(this.a.a.a), paramInt3, this.a.a.a.ai());
          cy.b(this.a.a.a, paramInt3);
          return;
        }
      }
      cs.a(cy.e(this.a.a.a), paramInt3, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ge
 * JD-Core Version:    0.7.0.1
 */