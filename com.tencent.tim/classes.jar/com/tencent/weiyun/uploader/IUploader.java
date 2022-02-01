package com.tencent.weiyun.uploader;

import com.tencent.weiyun.uploader.xplatform.UploadNative.CanceledFlag;

public abstract interface IUploader
{
  public abstract String[] calSliceSha1(String paramString, UploadNative.CanceledFlag paramCanceledFlag);
  
  public abstract void cancel(UploadRequest paramUploadRequest);
  
  public abstract void cancelAll();
  
  public abstract void reportError(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean2, int paramInt2);
  
  public abstract void setHttpProxy(String paramString1, int paramInt, String paramString2, String paramString3);
  
  public abstract void setIpConfig(String paramString1, String paramString2);
  
  public abstract void setNetType(int paramInt);
  
  public abstract void setReporter(IReporter paramIReporter);
  
  public abstract void speedDown();
  
  public abstract void trialSpeedUp(int paramInt);
  
  public abstract boolean upload(UploadRequest paramUploadRequest);
  
  public abstract void vipSpeedUp();
  
  public static abstract interface IUploadListener
  {
    public abstract void onUploadCanceled(UploadRequest paramUploadRequest);
    
    public abstract void onUploadFinished(UploadRequest paramUploadRequest, boolean paramBoolean, UploadResponse paramUploadResponse);
    
    public abstract void onUploadProgress(UploadRequest paramUploadRequest, long paramLong1, float paramFloat, long paramLong2, long paramLong3, long paramLong4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.uploader.IUploader
 * JD-Core Version:    0.7.0.1
 */