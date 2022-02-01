package com.tencent.mobileqq.utils.confighandler;

import com.tencent.mobileqq.utils.AudioHelper;

public class ConfigUtil
{
  public static boolean isActivity(long paramLong1, long paramLong2)
  {
    long l = AudioHelper.hF();
    return (paramLong1 < l) && (paramLong2 > l);
  }
  
  public static boolean isExpired(long paramLong)
  {
    return paramLong < AudioHelper.hF();
  }
  
  public static abstract interface DownloadStatus
  {
    public static final int downloading = 1;
    public static final int fail = -1;
    public static final int none = 0;
    public static final int suc = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.ConfigUtil
 * JD-Core Version:    0.7.0.1
 */