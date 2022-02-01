package org.apache.commons.lang3;

public class NotImplementedException
  extends UnsupportedOperationException
{
  private static final long serialVersionUID = 20131021L;
  private final String code;
  
  public NotImplementedException(String paramString)
  {
    this(paramString, (String)null);
  }
  
  public NotImplementedException(String paramString1, String paramString2)
  {
    super(paramString1);
    this.code = paramString2;
  }
  
  public NotImplementedException(String paramString, Throwable paramThrowable)
  {
    this(paramString, paramThrowable, null);
  }
  
  public NotImplementedException(String paramString1, Throwable paramThrowable, String paramString2)
  {
    super(paramString1, paramThrowable);
    this.code = paramString2;
  }
  
  public NotImplementedException(Throwable paramThrowable)
  {
    this(paramThrowable, null);
  }
  
  public NotImplementedException(Throwable paramThrowable, String paramString)
  {
    super(paramThrowable);
    this.code = paramString;
  }
  
  public String getCode()
  {
    return this.code;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.NotImplementedException
 * JD-Core Version:    0.7.0.1
 */