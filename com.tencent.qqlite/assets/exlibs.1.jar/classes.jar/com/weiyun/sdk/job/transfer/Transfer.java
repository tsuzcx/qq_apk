package com.weiyun.sdk.job.transfer;

public abstract interface Transfer
{
  public abstract int transfer();
  
  public static class Result
  {
    public String mErrMsg;
    public int mRet;
    
    public Result(int paramInt, String paramString)
    {
      this.mRet = paramInt;
      this.mErrMsg = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.Transfer
 * JD-Core Version:    0.7.0.1
 */