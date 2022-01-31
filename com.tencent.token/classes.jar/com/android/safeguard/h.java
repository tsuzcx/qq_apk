package com.android.safeguard;

public class h
{
  private String a = "";
  
  public h()
  {
    u();
  }
  
  protected String a(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = str;
    if (str.length() > paramInt) {
      paramString = str.substring(0, paramInt);
    }
    return paramString;
  }
  
  protected void a(Exception paramException)
  {
    try
    {
      this.a = (this.a + paramException.getMessage() + ":");
      paramException = paramException.getStackTrace();
      if (paramException.length != 0)
      {
        paramException = paramException[0];
        this.a = (this.a + paramException.getClassName() + "." + paramException.getMethodName() + "\n");
      }
      return;
    }
    finally {}
  }
  
  protected void a(Throwable paramThrowable)
  {
    try
    {
      this.a = (this.a + paramThrowable.getMessage() + ":");
      paramThrowable = paramThrowable.getStackTrace();
      if (paramThrowable.length != 0)
      {
        paramThrowable = paramThrowable[0];
        this.a = (this.a + paramThrowable.getClassName() + "." + paramThrowable.getMethodName() + "\n");
      }
      return;
    }
    finally {}
  }
  
  protected void i(String paramString)
  {
    try
    {
      if (paramString.length() > 0) {
        this.a = (this.a + paramString + "\n");
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected String t()
  {
    return this.a;
  }
  
  protected void u()
  {
    try
    {
      this.a = "";
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.android.safeguard.h
 * JD-Core Version:    0.7.0.1
 */