package com.tencent.token;

import com.tencent.turingfd.sdk.qps.Leo;
import java.nio.ByteBuffer;
import java.util.HashMap;

public final class adg
{
  public static HashMap<String, byte[]> a;
  public Leo b = new Leo();
  public HashMap<String, byte[]> c = new HashMap();
  public HashMap<String, Object> d = new HashMap();
  
  public adg()
  {
    Leo localLeo = this.b;
    localLeo.d = 3;
    localLeo.g = 3;
  }
  
  public final <T> T a(String paramString, T paramT)
  {
    if (this.c.containsKey(paramString))
    {
      if (this.d.containsKey(paramString)) {
        return this.d.get(paramString);
      }
      byte[] arrayOfByte = (byte[])this.c.get(paramString);
      try
      {
        afb localafb = new afb();
        localafb.a = ByteBuffer.wrap(arrayOfByte);
        localafb.b = "UTF-8";
        paramT = localafb.a(paramT, 0, true);
        if (paramT != null) {
          this.d.put(paramString, paramT);
        }
        return paramT;
      }
      catch (Exception paramString)
      {
        throw new Exception(paramString);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adg
 * JD-Core Version:    0.7.0.1
 */