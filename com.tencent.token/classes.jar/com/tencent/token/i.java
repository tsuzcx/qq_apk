package com.tencent.token;

public class i
{
  private String a = "";
  
  public i()
  {
    a();
  }
  
  private void a()
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
  
  protected final void a(Exception paramException)
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
  
  protected final void a(Throwable paramThrowable)
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
  
  protected final void e(String paramString)
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
  
  protected final String s()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.i
 * JD-Core Version:    0.7.0.1
 */