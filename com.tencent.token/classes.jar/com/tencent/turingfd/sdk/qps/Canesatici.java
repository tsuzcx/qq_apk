package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;

public final class Canesatici
  extends final
{
  public static byte[] a;
  public byte[] b = null;
  public String c = "";
  
  public final void a(agd paramagd)
  {
    if (a == null)
    {
      byte[] arrayOfByte = new byte[1];
      a = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    this.b = paramagd.b(0, false);
    this.c = paramagd.a(1, false);
  }
  
  public final void a(age paramage)
  {
    Object localObject = this.b;
    if (localObject != null) {
      paramage.a((byte[])localObject, 0);
    }
    localObject = this.c;
    if (localObject != null) {
      paramage.a((String)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Canesatici
 * JD-Core Version:    0.7.0.1
 */