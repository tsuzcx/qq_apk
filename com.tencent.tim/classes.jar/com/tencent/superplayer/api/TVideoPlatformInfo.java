package com.tencent.superplayer.api;

import com.tencent.qqlive.tvkplayer.vinfo.TVKPlatformInfo;

public class TVideoPlatformInfo
{
  private String mAppKey;
  private String mPkgName;
  private int mPlatform;
  private String mSdtfrom;
  
  public TVideoPlatformInfo(Builder paramBuilder)
  {
    this.mPlatform = paramBuilder.mPlatform;
    this.mSdtfrom = paramBuilder.mSdtfrom;
    this.mAppKey = paramBuilder.mAppKey;
    this.mPkgName = paramBuilder.mPkgName;
  }
  
  public static TVKPlatformInfo convert(TVideoPlatformInfo paramTVideoPlatformInfo)
  {
    if (paramTVideoPlatformInfo == null) {
      return null;
    }
    TVKPlatformInfo localTVKPlatformInfo = new TVKPlatformInfo();
    localTVKPlatformInfo.setPlatform(paramTVideoPlatformInfo.mPlatform);
    localTVKPlatformInfo.setSdtfrom(paramTVideoPlatformInfo.mSdtfrom);
    localTVKPlatformInfo.setAppKey(paramTVideoPlatformInfo.mAppKey);
    localTVKPlatformInfo.setPackageName(paramTVideoPlatformInfo.mPkgName);
    return localTVKPlatformInfo;
  }
  
  public String getAppKey()
  {
    return this.mAppKey;
  }
  
  public String getPackageName()
  {
    return this.mPkgName;
  }
  
  public int getPlatform()
  {
    return this.mPlatform;
  }
  
  public String getSdtFrom()
  {
    return this.mSdtfrom;
  }
  
  public void setAppKey(String paramString)
  {
    this.mAppKey = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.mPkgName = paramString;
  }
  
  public void setPlatform(int paramInt)
  {
    this.mPlatform = paramInt;
  }
  
  public void setSdtfrom(String paramString)
  {
    this.mSdtfrom = paramString;
  }
  
  public static class Builder
  {
    private String mAppKey;
    private String mPkgName;
    private int mPlatform;
    private String mSdtfrom;
    
    public Builder appKey(String paramString)
    {
      this.mAppKey = paramString;
      return this;
    }
    
    public TVideoPlatformInfo build()
    {
      return new TVideoPlatformInfo(this);
    }
    
    public Builder pkgName(String paramString)
    {
      this.mPkgName = paramString;
      return this;
    }
    
    public Builder platform(int paramInt)
    {
      this.mPlatform = paramInt;
      return this;
    }
    
    public Builder sdtfrom(String paramString)
    {
      this.mSdtfrom = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.TVideoPlatformInfo
 * JD-Core Version:    0.7.0.1
 */