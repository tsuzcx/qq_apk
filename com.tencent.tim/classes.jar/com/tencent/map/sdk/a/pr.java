package com.tencent.map.sdk.a;

public final class pr
  implements hb
{
  private final pn a;
  
  public pr(pn parampn)
  {
    this.a = parampn;
  }
  
  public final void a(int paramInt)
  {
    if ((this.a == null) || (paramInt != kc.c.c)) {
      return;
    }
    pn localpn = this.a;
    paramInt = localpn.az.c();
    localpn.ae = true;
    localpn.af = true;
    if (paramInt <= localpn.ac) {
      localpn.af = false;
    }
    for (;;)
    {
      if (localpn.r != null)
      {
        localhj = new hj();
        localhj.a = 0;
        localhj.b = localpn.ae;
        localhj.c = localpn.af;
        localpn.r.a(localhj);
      }
      localpn = this.a;
      if (localpn.r == null) {
        break;
      }
      hj localhj = new hj();
      localhj.a = 0;
      localhj.b = localpn.ae;
      localhj.c = localpn.af;
      localpn.r.a(localhj);
      return;
      if (paramInt >= localpn.ab) {
        localpn.ae = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.pr
 * JD-Core Version:    0.7.0.1
 */