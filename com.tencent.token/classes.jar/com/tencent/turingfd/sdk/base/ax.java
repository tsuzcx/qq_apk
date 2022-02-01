package com.tencent.turingfd.sdk.base;

public class ax
{
  public String a = "";
  public boolean b = false;
  public long c = 0L;
  public long d = 0L;
  
  public ax(String paramString)
  {
    this.a = paramString;
    paramString = paramString.split(":");
    if ((paramString == null) || (paramString.length < 4)) {
      return;
    }
    for (;;)
    {
      try
      {
        Integer.valueOf(paramString[0]).intValue();
        this.c = Long.valueOf(paramString[1]).longValue();
        this.d = Long.valueOf(paramString[2]).longValue();
        if (Integer.valueOf(paramString[3]).intValue() == 0)
        {
          this.b = bool;
          return;
        }
      }
      catch (Throwable paramString)
      {
        return;
      }
      bool = true;
    }
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ax
 * JD-Core Version:    0.7.0.1
 */