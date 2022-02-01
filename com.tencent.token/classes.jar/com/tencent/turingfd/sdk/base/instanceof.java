package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;

public final class instanceof
  extends break
{
  public static byte[] lb;
  public byte[] mb = null;
  public String nb = "";
  
  public final void a(afl paramafl)
  {
    if (lb == null)
    {
      byte[] arrayOfByte = new byte[1];
      lb = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    this.mb = paramafl.b(0, false);
    this.nb = paramafl.a(1, false);
  }
  
  public final void a(afo paramafo)
  {
    Object localObject = this.mb;
    if (localObject != null) {
      paramafo.a((byte[])localObject, 0);
    }
    localObject = this.nb;
    if (localObject != null) {
      paramafo.a((String)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.instanceof
 * JD-Core Version:    0.7.0.1
 */