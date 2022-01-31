package com.weiyun.sdk.job.af;

public abstract class UploadAddressFetcher
  extends AddressFetcher
{
  protected volatile boolean mDone;
  protected String mFileId;
  protected final String mFileModifyTime;
  protected final String mFileName;
  protected final String mFileNote;
  protected final String mGrandparentDirKey;
  protected final String mMacAddress;
  protected final String mMd5;
  protected String mPId;
  protected final String mParentDirKey;
  protected final String mSha;
  protected final long mTotalSize;
  
  public UploadAddressFetcher(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.mFileName = paramString1;
    this.mFileNote = paramString2;
    this.mFileModifyTime = paramString3;
    this.mTotalSize = paramLong;
    this.mMd5 = paramString4;
    this.mSha = paramString5;
    this.mParentDirKey = paramString6;
    this.mGrandparentDirKey = paramString7;
    this.mMacAddress = paramString8;
    this.mDone = false;
  }
  
  public AddressFetcher.UploadAddress createUploadAddress(String paramString1, int paramInt, String paramString2)
  {
    return new AddressFetcher.UploadAddress(paramString1, paramInt, paramString2);
  }
  
  public String getFileId()
    throws IllegalStateException
  {
    if (this.mDone) {
      return this.mFileId;
    }
    throw new IllegalStateException("can not call this function when job is not done!");
  }
  
  public String getPId()
    throws IllegalStateException
  {
    if (this.mDone) {
      return this.mPId;
    }
    throw new IllegalStateException("can not call this function when job is not done!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.af.UploadAddressFetcher
 * JD-Core Version:    0.7.0.1
 */