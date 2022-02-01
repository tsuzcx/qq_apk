package com.tencent.turingfd.sdk.base;

public final class instanceof
  extends break
{
  public static byte[] lb;
  public byte[] mb = null;
  public String nb = "";
  
  public void a(cy paramcy)
  {
    if (lb == null)
    {
      lb = new byte[1];
      lb[0] = 0;
    }
    this.mb = paramcy.a(lb, 0, false);
    this.nb = paramcy.a(1, false);
  }
  
  public void a(db paramdb)
  {
    Object localObject = this.mb;
    if (localObject != null) {
      paramdb.a((byte[])localObject, 0);
    }
    localObject = this.nb;
    if (localObject != null) {
      paramdb.a((String)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.instanceof
 * JD-Core Version:    0.7.0.1
 */