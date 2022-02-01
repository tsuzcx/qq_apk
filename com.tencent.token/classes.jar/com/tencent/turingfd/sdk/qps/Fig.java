package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;

public final class Fig
  extends final
{
  public static Durian a;
  public int b = 0;
  public Durian c = null;
  
  public final void a(agd paramagd)
  {
    this.b = paramagd.a(this.b, 0, true);
    if (a == null) {
      a = new Durian();
    }
    this.c = ((Durian)paramagd.a(a, 1, false));
  }
  
  public final void a(age paramage)
  {
    paramage.a(this.b, 0);
    Durian localDurian = this.c;
    if (localDurian != null) {
      paramage.a(localDurian, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Fig
 * JD-Core Version:    0.7.0.1
 */