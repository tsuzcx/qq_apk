package com.tencent.turingfd.sdk.base;

public final class Filbert
  extends break
{
  public static Ginkgo pc;
  public String metaData = "";
  public String qc = "";
  public Ginkgo rc = null;
  
  public void a(cy paramcy)
  {
    this.qc = paramcy.a(0, true);
    this.metaData = paramcy.a(1, false);
    if (pc == null) {
      pc = new Ginkgo();
    }
    this.rc = ((Ginkgo)paramcy.a(pc, 2, false));
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.qc, 0);
    Object localObject = this.metaData;
    if (localObject != null) {
      paramdb.a((String)localObject, 1);
    }
    localObject = this.rc;
    if (localObject != null) {
      paramdb.a((break)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Filbert
 * JD-Core Version:    0.7.0.1
 */