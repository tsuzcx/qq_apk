package com.tencent.youtu.ytagreflectlivecheck.requester;

import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ActionReflectReq;

public abstract interface UploadVideoRequesterV3
{
  public abstract void getActReflectData(ActReflectResponse paramActReflectResponse);
  
  public abstract void request(ActionReflectReq paramActionReflectReq, UploadVideoResponse paramUploadVideoResponse);
  
  public static abstract interface ActReflectResponse
  {
    public abstract void onFailed(String paramString);
    
    public abstract void onSuccess(YTActReflectData paramYTActReflectData);
  }
  
  public static abstract interface UploadVideoResponse
  {
    public abstract void onFailed(int paramInt, String paramString);
    
    public abstract void onSuccess(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV3
 * JD-Core Version:    0.7.0.1
 */