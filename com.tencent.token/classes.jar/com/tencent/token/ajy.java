package com.tencent.token;

public final class ajy
{
  public static final alb a = alb.a(":");
  public static final alb b = alb.a(":status");
  public static final alb c = alb.a(":method");
  public static final alb d = alb.a(":path");
  public static final alb e = alb.a(":scheme");
  public static final alb f = alb.a(":authority");
  public final alb g;
  public final alb h;
  final int i;
  
  public ajy(alb paramalb1, alb paramalb2)
  {
    this.g = paramalb1;
    this.h = paramalb2;
    this.i = (paramalb1.g() + 32 + paramalb2.g());
  }
  
  public ajy(alb paramalb, String paramString)
  {
    this(paramalb, alb.a(paramString));
  }
  
  public ajy(String paramString1, String paramString2)
  {
    this(alb.a(paramString1), alb.a(paramString2));
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ajy))
    {
      paramObject = (ajy)paramObject;
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
    return aiw.a("%s: %s", new Object[] { this.g.a(), this.h.a() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajy
 * JD-Core Version:    0.7.0.1
 */