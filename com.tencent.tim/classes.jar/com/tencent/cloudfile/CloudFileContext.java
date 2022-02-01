package com.tencent.cloudfile;

import java.util.Map;

public abstract class CloudFileContext
{
  protected static Logger sLogger;
  
  public CloudFileContext(Logger paramLogger)
  {
    if (paramLogger != null) {
      sLogger = paramLogger;
    }
  }
  
  public static void nativeLog(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (sLogger != null)
    {
      paramString2 = new StringBuilder(paramString2);
      paramString2.append(" [").append(paramInt2).append("]");
      sLogger.log(paramInt1, paramString1, paramString2.toString());
    }
  }
  
  public abstract String getCachePath();
  
  public abstract Map<String, String> getCgiCookies();
  
  public abstract String getDBKeyPath();
  
  public abstract byte[] getDataKey();
  
  public abstract String getDownloadPath();
  
  public abstract String getDownloadTempPath();
  
  public abstract long getSelfUin();
  
  public abstract long getServerCalTime();
  
  public abstract int getTIMVersion();
  
  public abstract String getThumbPath();
  
  public abstract String getUploadTempPath();
  
  public abstract void reportTransferData(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void sendRequest(byte[] paramArrayOfByte, long paramLong);
  
  public static abstract interface Logger
  {
    public abstract void log(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.cloudfile.CloudFileContext
 * JD-Core Version:    0.7.0.1
 */