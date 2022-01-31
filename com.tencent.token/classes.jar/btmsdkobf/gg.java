package btmsdkobf;

class gg
  implements cf.a
{
  gg(gf paramgf) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramInt3 = bz.p(paramInt3);
    eh.e("SharkNetwork", "[cu_guid]onGuidFinish(), send broadcast, ret: " + paramInt3);
    synchronized (cy.q(this.a.a.a))
    {
      cy.d(this.a.a.a, false);
      cv.by().a("SharkNetwork", paramInt2, paramInt1, (ba)null, 30, paramInt3);
      cv.by().x(paramInt1);
      cf.b(cy.e(this.a.a.a), paramInt3, paramString);
      cy.a(this.a.a.a, paramInt3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.gg
 * JD-Core Version:    0.7.0.1
 */