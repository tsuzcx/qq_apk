package com.tencent.token;

public final class afh
{
  public String a = "";
  public boolean b;
  public long c;
  public long d;
  
  public afh(String paramString)
  {
    boolean bool = false;
    this.b = false;
    this.c = 0L;
    this.d = 0L;
    if (paramString == null) {
      return;
    }
    this.a = paramString;
    paramString = paramString.split(":");
    if ((paramString != null) && (paramString.length >= 4)) {}
    for (;;)
    {
      try
      {
        Integer.valueOf(paramString[0]).intValue();
        this.c = Long.valueOf(paramString[1]).longValue();
        this.d = Long.valueOf(paramString[2]).longValue();
        if (Integer.valueOf(paramString[3]).intValue() == 0) {
          this.b = bool;
        }
      }
      finally
      {
        return;
      }
      bool = true;
    }
  }
  
  public final String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afh
 * JD-Core Version:    0.7.0.1
 */