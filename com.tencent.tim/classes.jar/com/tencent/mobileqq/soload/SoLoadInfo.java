package com.tencent.mobileqq.soload;

import java.io.Serializable;

public class SoLoadInfo
  implements Serializable
{
  public static SoLoadInfo sDefault = new SoLoadInfo();
  public String configSoUrl;
  public int curCode = 6;
  public String curLoadVer;
  public boolean isFinishDownload;
  public String pathToLoad;
  public int subErrCode;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.soload.SoLoadInfo
 * JD-Core Version:    0.7.0.1
 */