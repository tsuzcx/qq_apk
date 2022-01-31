package com.pay.googlewalletsdk.util;

public class IabException
  extends Exception
{
  IabResult mResult;
  
  public IabException(int paramInt, String paramString)
  {
    this(new IabResult(paramInt, paramString));
  }
  
  public IabException(int paramInt, String paramString, Exception paramException)
  {
    this(new IabResult(paramInt, paramString), paramException);
  }
  
  public IabException(IabResult paramIabResult)
  {
    this(paramIabResult, null);
  }
  
  public IabException(IabResult paramIabResult, Exception paramException)
  {
    super(paramIabResult.getMessage(), paramException);
    this.mResult = paramIabResult;
  }
  
  public IabResult getResult()
  {
    return this.mResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.util.IabException
 * JD-Core Version:    0.7.0.1
 */