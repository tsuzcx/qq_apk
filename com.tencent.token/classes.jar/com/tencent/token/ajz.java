package com.tencent.token;

public final class ajz
{
  public static final alc a = alc.a(":");
  public static final alc b = alc.a(":status");
  public static final alc c = alc.a(":method");
  public static final alc d = alc.a(":path");
  public static final alc e = alc.a(":scheme");
  public static final alc f = alc.a(":authority");
  public final alc g;
  public final alc h;
  final int i;
  
  public ajz(alc paramalc1, alc paramalc2)
  {
    this.g = paramalc1;
    this.h = paramalc2;
    this.i = (paramalc1.g() + 32 + paramalc2.g());
  }
  
  public ajz(alc paramalc, String paramString)
  {
    this(paramalc, alc.a(paramString));
  }
  
  public ajz(String paramString1, String paramString2)
  {
    this(alc.a(paramString1), alc.a(paramString2));
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ajz))
    {
      paramObject = (ajz)paramObject;
      return (this.g.equals(paramObject.g)) && (this.h.equals(paramObject.h));
    }
    return false;
  }
  
  public final int hashCode()
  {
    return (this.g.hashCode() + 527) * 31 + this.h.hashCode();
  }
  
  public final String toString()
  {
    return aix.a("%s: %s", new Object[] { this.g.a(), this.h.a() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajz
 * JD-Core Version:    0.7.0.1
 */