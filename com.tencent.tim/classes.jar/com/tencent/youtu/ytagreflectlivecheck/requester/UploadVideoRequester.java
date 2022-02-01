package com.tencent.youtu.ytagreflectlivecheck.requester;

public abstract interface UploadVideoRequester
{
  public abstract void request(String paramString, UploadVideoResponse paramUploadVideoResponse);
  
  public static abstract interface UploadVideoResponse
  {
    public abstract void onFailed(int paramInt, String paramString);
    
    public abstract void onSuccess(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester
 * JD-Core Version:    0.7.0.1
 */