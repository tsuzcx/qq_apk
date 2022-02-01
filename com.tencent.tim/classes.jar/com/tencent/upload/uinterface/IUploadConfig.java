package com.tencent.upload.uinterface;

public abstract interface IUploadConfig
{
  public abstract boolean canHoldSystemLock();
  
  public abstract boolean enableBitmapNativeAlloc();
  
  public abstract boolean enableV6Route();
  
  public abstract int getAppId();
  
  public abstract String getChangeRouteRetCodes();
  
  public abstract int getCompressToWebpFlag();
  
  public abstract int getConnectTimeout();
  
  public abstract long getCurrentUin();
  
  public abstract int getDataTimeout();
  
  public abstract String getDeviceInfo();
  
  public abstract int getDoNotFragment();
  
  public abstract String getExifTagCode(String paramString);
  
  public abstract int getGifUploadLimit(int paramInt);
  
  public abstract String getMaxSegmentSizeArray();
  
  public abstract String getMobileLogUrl();
  
  public abstract String getMobileLogUrlV6();
  
  public abstract String getNetworkUnavailableRetCodes();
  
  public abstract String getOtherBakUrl();
  
  public abstract String getOtherHostUrl();
  
  public abstract String getOtherOptUrl();
  
  public abstract String getOtherOptUrlV6();
  
  public abstract String getPhotoBakUrl();
  
  public abstract String getPhotoHostUrl();
  
  public abstract String getPhotoOptUrl();
  
  public abstract String getPhotoOptUrlV6();
  
  public abstract float getPictureQuality(String paramString);
  
  public abstract String getQUA3();
  
  public abstract long getRecentRouteExpire();
  
  public abstract int getTimeoutRetryCount();
  
  public abstract UploadImageSize getUploadImageSize(UploadImageSize paramUploadImageSize, int paramInt, AbstractUploadTask paramAbstractUploadTask);
  
  public abstract String getUploadPort();
  
  public abstract String getVideoBakUrl();
  
  public abstract String getVideoHostUrl();
  
  public abstract String getVideoOptUrl();
  
  public abstract String getVideoOptUrlV6();
  
  public abstract int getWifiOperator();
  
  public abstract boolean isPictureNeedToCompress(String paramString);
  
  public abstract boolean isReleaseMode();
  
  public static class UploadImageSize
  {
    public int height;
    public int quality;
    public int width;
    
    public UploadImageSize(int paramInt1, int paramInt2, int paramInt3)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.quality = paramInt3;
    }
    
    public String toString()
    {
      return "[width=" + this.width + ", height=" + this.height + ", quality=" + this.quality + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.uinterface.IUploadConfig
 * JD-Core Version:    0.7.0.1
 */