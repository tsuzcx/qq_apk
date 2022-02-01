package com.tencent.moai.mailsdk.exception;

public class MessageException
  extends Exception
{
  protected int detailCode;
  protected String detailMessage;
  protected int resultCode;
  
  public MessageException(int paramInt1, int paramInt2, String paramString)
  {
    super(paramString);
    this.resultCode = paramInt1;
    this.detailCode = paramInt2;
    this.detailMessage = paramString;
  }
  
  public MessageException(int paramInt1, int paramInt2, String paramString, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.resultCode = paramInt1;
    this.detailCode = paramInt2;
    this.detailMessage = paramString;
  }
  
  public MessageException(int paramInt, String paramString)
  {
    super(paramString);
    this.resultCode = paramInt;
    this.detailCode = 200001;
    this.detailMessage = paramString;
  }
  
  public MessageException(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.resultCode = paramInt;
    this.detailCode = 200001;
    this.detailMessage = paramString;
  }
  
  public int getDetailCode()
  {
    return this.detailCode;
  }
  
  public String getDetailMessage()
  {
    return this.detailMessage;
  }
  
  public int getResultCode()
  {
    return this.resultCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.exception.MessageException
 * JD-Core Version:    0.7.0.1
 */