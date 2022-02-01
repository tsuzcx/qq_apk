package com.tencent.weiyun.uploader;

import android.content.Context;
import com.tencent.weiyun.uploader.xplatform.UploadNative;

class UploadContext
{
  private final Context mContext;
  private final IReporter mReporter;
  private final String mTag;
  private final UploadNative mXpUploader;
  
  public UploadContext(Context paramContext, String paramString, UploadNative paramUploadNative, IReporter paramIReporter)
  {
    this.mContext = paramContext;
    this.mTag = paramString;
    this.mXpUploader = paramUploadNative;
    this.mReporter = paramIReporter;
  }
  
  public Context context()
  {
    return this.mContext;
  }
  
  public IReporter reporter()
  {
    return this.mReporter;
  }
  
  public String tag()
  {
    return this.mTag;
  }
  
  public UploadNative xpUploader()
  {
    return this.mXpUploader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.uploader.UploadContext
 * JD-Core Version:    0.7.0.1
 */