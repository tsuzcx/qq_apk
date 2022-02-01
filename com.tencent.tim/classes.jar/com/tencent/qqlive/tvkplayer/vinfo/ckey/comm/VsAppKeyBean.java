package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

public class VsAppKeyBean
{
  private String mPkgName = "";
  private String mPlatform = "";
  private String mSdtfrom = "";
  private String mVsKey = "";
  
  public VsAppKeyBean(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mPlatform = paramString1;
    this.mSdtfrom = paramString2;
    this.mVsKey = paramString3;
    this.mPkgName = paramString4;
  }
  
  public String getPkgName()
  {
    return this.mPkgName;
  }
  
  public String getPlatform()
  {
    return this.mPlatform;
  }
  
  public String getSdtfrom()
  {
    return this.mSdtfrom;
  }
  
  public String getVsKey()
  {
    return this.mVsKey;
  }
  
  public void setPkgName(String paramString)
  {
    this.mPkgName = paramString;
  }
  
  public void setPlatform(String paramString)
  {
    this.mPlatform = paramString;
  }
  
  public void setSdtfrom(String paramString)
  {
    this.mSdtfrom = paramString;
  }
  
  public void setVsKey(String paramString)
  {
    this.mVsKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsAppKeyBean
 * JD-Core Version:    0.7.0.1
 */