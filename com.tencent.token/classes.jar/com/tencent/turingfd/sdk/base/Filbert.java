package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;

public final class Filbert
  extends break
{
  public static Ginkgo pc;
  public String metaData = "";
  public String qc = "";
  public Ginkgo rc = null;
  
  public final void a(afl paramafl)
  {
    this.qc = paramafl.a(0, true);
    this.metaData = paramafl.a(1, false);
    if (pc == null) {
      pc = new Ginkgo();
    }
    this.rc = ((Ginkgo)paramafl.a(pc, 2, false));
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.qc, 0);
    Object localObject = this.metaData;
    if (localObject != null) {
      paramafo.a((String)localObject, 1);
    }
    localObject = this.rc;
    if (localObject != null) {
      paramafo.a((break)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Filbert
 * JD-Core Version:    0.7.0.1
 */