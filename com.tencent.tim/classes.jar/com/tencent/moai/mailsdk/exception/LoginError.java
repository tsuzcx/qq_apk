package com.tencent.moai.mailsdk.exception;

public class LoginError
{
  private int detailCode;
  private String detailMessage;
  private boolean hasError;
  private int resultCode;
  
  public LoginError()
  {
    this.hasError = false;
  }
  
  public LoginError(int paramInt1, int paramInt2, String paramString)
  {
    this.resultCode = paramInt1;
    this.detailCode = paramInt2;
    this.detailMessage = paramString;
    this.hasError = true;
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
  
  public boolean isHasError()
  {
    return this.hasError;
  }
  
  public void setDetailCode(int paramInt)
  {
    this.detailCode = paramInt;
  }
  
  public void setDetailMessage(String paramString)
  {
    this.detailMessage = paramString;
  }
  
  public void setHasError(boolean paramBoolean)
  {
    this.hasError = paramBoolean;
  }
  
  public void setResultCode(int paramInt)
  {
    this.resultCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.exception.LoginError
 * JD-Core Version:    0.7.0.1
 */