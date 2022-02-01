package com.weiyun.sdk.job;

public class UploadJobContext
  extends JobContext
{
  private boolean mIsContentExist = false;
  private String mMd5 = null;
  private String mSha = null;
  private final String mSrcPath;
  
  public UploadJobContext(long paramLong1, long paramLong2, String paramString)
  {
    super(paramLong1, paramLong2);
    this.mSrcPath = paramString;
  }
  
  public UploadJobContext(long paramLong, String paramString)
  {
    super(paramLong);
    this.mSrcPath = paramString;
  }
  
  public boolean IsContentExist()
  {
    return this.mIsContentExist;
  }
  
  public String getMd5()
  {
    return this.mMd5;
  }
  
  public String getSha()
  {
    return this.mSha;
  }
  
  public String getSrcPath()
  {
    return this.mSrcPath;
  }
  
  public void setContentExist(boolean paramBoolean)
  {
    this.mIsContentExist = paramBoolean;
  }
  
  public void setMd5(String paramString)
  {
    this.mMd5 = paramString;
  }
  
  public void setSha(String paramString)
  {
    this.mSha = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.job.UploadJobContext
 * JD-Core Version:    0.7.0.1
 */