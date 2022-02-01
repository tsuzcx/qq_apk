package com.weiyun.sdk.job.transfer;

public abstract interface Transfer
{
  public abstract int transfer();
  
  public static final class ProcessInfo
  {
    public int attemptCount = 0;
    public String clientIp;
    public long connTimeCost;
    public String dns;
    public Throwable failException = null;
    public int flowId;
    public String hostIp;
    public String hostPort;
    public long recvRspTimeCost;
    public long startTime;
    public long transferDataSize;
    public long transferDataTimeCost;
    public String url;
    
    public void resetLast()
    {
      this.dns = null;
      this.hostPort = null;
      this.hostIp = null;
      this.clientIp = null;
      this.transferDataSize = 0L;
      this.recvRspTimeCost = 0L;
      this.transferDataTimeCost = 0L;
      this.failException = null;
    }
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.Transfer
 * JD-Core Version:    0.7.0.1
 */