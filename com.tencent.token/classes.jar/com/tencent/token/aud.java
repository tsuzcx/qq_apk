package com.tencent.token;

import java.util.ArrayList;
import java.util.Iterator;

public class aud
  implements aua
{
  public atb k = null;
  
  public void a(int paramInt, az paramaz) {}
  
  public final void a(byte[] paramArrayOfByte)
  {
    ba localba = asu.a(paramArrayOfByte);
    Object localObject = this.k;
    paramArrayOfByte = null;
    if ((localObject != null) && (localba != null)) {
      paramArrayOfByte = localba.c;
    }
    if (paramArrayOfByte == null) {
      return;
    }
    paramArrayOfByte = paramArrayOfByte.iterator();
    while (paramArrayOfByte.hasNext())
    {
      localObject = (az)paramArrayOfByte.next();
      a(localba.a, (az)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aud
 * JD-Core Version:    0.7.0.1
 */