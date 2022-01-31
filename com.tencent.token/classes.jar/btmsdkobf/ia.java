package btmsdkobf;

class ia
  extends ib
{
  private int e = 0;
  private String f = "";
  private byte g = 0;
  
  public ia(di paramdi, int paramInt1, int paramInt2, String paramString, byte paramByte)
  {
    super(paramdi, 10999, paramInt1);
    this.e = paramInt2;
    this.f = paramString;
    this.g = paramByte;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    eh.f("TmsTcpManager", "[tcp_control][h_b]hb fail, retCode: " + paramInt1 + " dataRetCode: " + paramInt2 + " helloSeq: " + this.g + " mRetryTimes: " + this.e + " reason: " + this.f);
    if (this.e >= 1)
    {
      eh.i("TmsTcpManager", "[tcp_control][h_b]hb fail again, mark disconnect not handled for reconnect");
      di.a(this.a, true);
      di.a(this.a, (byte)0);
    }
    if ((this.e < 1) && (bz.q(paramInt1)) && (di.a(this.a) < 3) && (di.b(this.a).cg() > 0)) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      cv.by().a("TmsTcpManager", 999, this.c, (ba)null, 30, paramInt1);
      Object localObject = cv.by();
      int i = this.c;
      if (paramInt2 == 0) {
        bool = true;
      }
      ((cv)localObject).a(i, bool);
      cv.by().a(this.g);
      if (paramInt2 != 0)
      {
        eh.f("TmsTcpManager", "[tcp_control][h_b]hb fail, retry");
        localObject = this.a;
        String str = "hb_retry:" + this.f + ":" + paramInt1;
        paramInt1 = this.e + 1;
        this.e = paramInt1;
        di.a((di)localObject, 13, str, paramInt1, 2000L, true);
      }
      return;
    }
  }
  
  protected void a(ba paramba)
  {
    eh.f("TmsTcpManager", "[tcp_control][h_b]hb success, helloSeq: " + this.g + " mRetryTimes: " + this.e + " reason: " + this.f);
    cv.by().a("TmsTcpManager", 999, this.c, paramba, 30, 0);
    cv.by().x(this.c);
    cv.by().a(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ia
 * JD-Core Version:    0.7.0.1
 */