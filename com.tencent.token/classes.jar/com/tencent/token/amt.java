package com.tencent.token;

public final class amt
{
  public static final anw a = anw.a(":");
  public static final anw b = anw.a(":status");
  public static final anw c = anw.a(":method");
  public static final anw d = anw.a(":path");
  public static final anw e = anw.a(":scheme");
  public static final anw f = anw.a(":authority");
  public final anw g;
  public final anw h;
  final int i;
  
  public amt(anw paramanw1, anw paramanw2)
  {
    this.g = paramanw1;
    this.h = paramanw2;
    this.i = (paramanw1.g() + 32 + paramanw2.g());
  }
  
  public amt(anw paramanw, String paramString)
  {
    this(paramanw, anw.a(paramString));
  }
  
  public amt(String paramString1, String paramString2)
  {
    this(anw.a(paramString1), anw.a(paramString2));
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof amt))
    {
      paramObject = (amt)paramObject;
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
    return alr.a("%s: %s", new Object[] { this.g.a(), this.h.a() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amt
 * JD-Core Version:    0.7.0.1
 */