package com.tencent.token;

import com.tencent.token.global.c;

public class cb
{
  private static cb a;
  
  public static cb a()
  {
    if (a == null) {
      a = new cb();
    }
    return a;
  }
  
  public void a(String paramString)
  {
    switch ()
    {
    default: 
      cs.e = paramString;
      break;
    case 3: 
      cs.g = paramString;
      break;
    case 2: 
      cs.f = paramString;
      break;
    case 1: 
      cs.e = paramString;
      break;
    case 0: 
      cs.d = paramString;
    }
    cs.c = paramString;
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    a(paramString);
    cs.a().i = paramLong1;
    cs.a().h = paramLong2;
    cs.a().a = paramArrayOfByte;
  }
  
  public String b()
  {
    if (cs.a().p())
    {
      cs.a();
      return cs.c;
    }
    return null;
  }
  
  public void c()
  {
    cs.a().m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cb
 * JD-Core Version:    0.7.0.1
 */