package com.weiyun.sdk.job.af;

public abstract class ContinueUploadAddressFetcher
  extends AddressFetcher
{
  protected final String mFildId;
  protected final String mFileName;
  protected final String mGrandparentDirKey;
  protected final String mParentDirKey;
  protected final String mSha;
  
  public ContinueUploadAddressFetcher(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mFileName = paramString1;
    this.mFildId = paramString2;
    this.mParentDirKey = paramString3;
    this.mGrandparentDirKey = paramString4;
    this.mSha = paramString5;
  }
  
  public AddressFetcher.UploadAddress createUploadAddress(String paramString1, int paramInt, String paramString2)
  {
    return new AddressFetcher.UploadAddress(paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.job.af.ContinueUploadAddressFetcher
 * JD-Core Version:    0.7.0.1
 */