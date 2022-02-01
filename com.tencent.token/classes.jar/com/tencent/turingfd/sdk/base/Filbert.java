package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;

public final class Filbert
  extends break
{
  public static Ginkgo pc;
  public String metaData = "";
  public String qc = "";
  public Ginkgo rc = null;
  
  public final void a(afk paramafk)
  {
    this.qc = paramafk.a(0, true);
    this.metaData = paramafk.a(1, false);
    if (pc == null) {
      pc = new Ginkgo();
    }
    this.rc = ((Ginkgo)paramafk.a(pc, 2, false));
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.qc, 0);
    Object localObject = this.metaData;
    if (localObject != null) {
      paramafn.a((String)localObject, 1);
    }
    localObject = this.rc;
    if (localObject != null) {
      paramafn.a((break)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Filbert
 * JD-Core Version:    0.7.0.1
 */