package com.tencent.token;

import java.util.ArrayList;
import java.util.Iterator;

public class atf
  implements atc
{
  public asd k = null;
  
  public void a(int paramInt, al paramal) {}
  
  public final void a(byte[] paramArrayOfByte)
  {
    am localam = arw.a(paramArrayOfByte);
    Object localObject = this.k;
    paramArrayOfByte = null;
    if ((localObject != null) && (localam != null)) {
      paramArrayOfByte = localam.c;
    }
    if (paramArrayOfByte == null) {
      return;
    }
    paramArrayOfByte = paramArrayOfByte.iterator();
    while (paramArrayOfByte.hasNext())
    {
      localObject = (al)paramArrayOfByte.next();
      a(localam.a, (al)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.atf
 * JD-Core Version:    0.7.0.1
 */