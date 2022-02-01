package com.tencent.moai.nativepages.model;

public class AdLandingPageComponentDownloadApkBtnInfo
  extends AdLandingPageComponentBtnInfo
{
  public static final int SUPPORTED_PLATFORM_ALL = 0;
  public static final int SUPPORTED_PLATFORM_ANDROID = 2;
  public static final int SUPPORTED_PLATFORM_IOS = 1;
  public String appid;
  public String channelId;
  public String downloadUrl;
  public long fileSize;
  public boolean isAutoInstall = true;
  public String md5;
  public String pkg;
  public String showName;
  public int supportPlatform;
  public String unSupportWarning;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.model.AdLandingPageComponentDownloadApkBtnInfo
 * JD-Core Version:    0.7.0.1
 */