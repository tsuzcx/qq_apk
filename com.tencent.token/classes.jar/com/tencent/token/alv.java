package com.tencent.token;

public final class alv
{
  public static final amy a = amy.a(":");
  public static final amy b = amy.a(":status");
  public static final amy c = amy.a(":method");
  public static final amy d = amy.a(":path");
  public static final amy e = amy.a(":scheme");
  public static final amy f = amy.a(":authority");
  public final amy g;
  public final amy h;
  final int i;
  
  public alv(amy paramamy1, amy paramamy2)
  {
    this.g = paramamy1;
    this.h = paramamy2;
    this.i = (paramamy1.g() + 32 + paramamy2.g());
  }
  
  public alv(amy paramamy, String paramString)
  {
    this(paramamy, amy.a(paramString));
  }
  
  public alv(String paramString1, String paramString2)
  {
    this(amy.a(paramString1), amy.a(paramString2));
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof alv))
    {
      paramObject = (alv)paramObject;
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
    return akt.a("%s: %s", new Object[] { this.g.a(), this.h.a() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alv
 * JD-Core Version:    0.7.0.1
 */