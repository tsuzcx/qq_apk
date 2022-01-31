package btmsdkobf;

class hz
  extends ib
{
  private int e = 0;
  private String f = "";
  
  public hz(di paramdi, int paramInt1, int paramInt2, String paramString)
  {
    super(paramdi, 10997, paramInt1);
    this.e = paramInt2;
    this.f = paramString;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    paramInt1 = bz.p(paramInt1);
    if ((this.e < 1) && (bz.q(paramInt1)) && (di.a(this.a) < 3) && (di.b(this.a).cg() > 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      eh.g("TmsTcpManager", "[tcp_control][f_p]fp fail, retCode: " + paramInt1 + " dataRetCode: " + paramInt2 + " mRetryTimes: " + this.e + " need retry? " + bool1);
      di.a(this.a, true);
      di.a(this.a, (byte)0);
      di.b(this.a, true);
      cv.by().a("TmsTcpManager", 997, this.c, (ba)null, 30, paramInt1);
      Object localObject = cv.by();
      paramInt2 = this.c;
      if (!bool1) {
        bool2 = true;
      }
      ((cv)localObject).a(paramInt2, bool2);
      di.a(this.a, 3, null, paramInt1, 0L, true);
      if (!bool1) {
        break;
      }
      eh.f("TmsTcpManager", "[tcp_control][f_p]fp fail, ref count: " + di.b(this.a).cg() + ", retry send fp in " + di.b(this.a).aq().aS + "s");
      di.c(this.a);
      localObject = this.a;
      String str = "delay_fp_retry:" + this.f + ":" + paramInt1;
      paramInt1 = this.e + 1;
      this.e = paramInt1;
      di.a((di)localObject, 11, str, paramInt1, 1000L * di.b(this.a).aq().aS, true);
      return;
    }
    eh.f("TmsTcpManager", "[tcp_control][f_p]fp fail, should not retry, retCode: " + paramInt1);
  }
  
  protected void a(ba paramba)
  {
    eh.f("TmsTcpManager", "[tcp_control][f_p]fp success, mRetryTimes: " + this.e);
    di.a(this.a, false);
    di.a(this.a, (byte)1);
    di.b(this.a, false);
    cv.by().a("TmsTcpManager", 997, this.c, paramba, 30, 0);
    cv.by().x(this.c);
    di.a(this.a, 2, null, 0, 0L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.hz
 * JD-Core Version:    0.7.0.1
 */