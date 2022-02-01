package com.tencent.turingfd.sdk.qps;

import com.tencent.token.afb;
import com.tencent.token.afd;

public final class Ginkgo
  extends Orion
{
  public String a = "";
  public String b = "";
  
  public final void a(afb paramafb)
  {
    this.a = paramafb.a(0, true);
    this.b = paramafb.a(1, true);
  }
  
  public final void a(afd paramafd)
  {
    paramafd.a(this.a, 0);
    paramafd.a(this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Ginkgo
 * JD-Core Version:    0.7.0.1
 */