package com.weiyun.sdk.job;

public class DownloadJobContext
  extends JobContext
{
  public static final String UNFINISHED_FILE_EXT = ".tdl";
  private final String mDataDirectoryPath;
  private String mDataFilePath;
  private final String mDestDirectoryPath;
  private String mDestFileName;
  private String mDestFilePath;
  private String mMd5;
  private String mServerIp;
  
  public DownloadJobContext(long paramLong1, long paramLong2, String paramString)
  {
    super(paramLong1, paramLong2);
    this.mDestDirectoryPath = paramString;
    this.mDataDirectoryPath = paramString;
  }
  
  public DownloadJobContext(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    super(paramLong1, paramLong2);
    this.mDestDirectoryPath = paramString1;
    this.mDataDirectoryPath = paramString2;
  }
  
  public DownloadJobContext(long paramLong, String paramString)
  {
    super(paramLong);
    this.mDestDirectoryPath = paramString;
    this.mDataDirectoryPath = paramString;
  }
  
  private void setDataFilePath(String paramString)
  {
    this.mDataFilePath = paramString;
  }
  
  private void setDestFilePath(String paramString)
  {
    this.mDestFilePath = paramString;
  }
  
  public String getDataDirectoryPath()
  {
    return this.mDataDirectoryPath;
  }
  
  public String getDataFilePath()
  {
    return this.mDataFilePath;
  }
  
  public String getDestDirectoryPath()
  {
    return this.mDestDirectoryPath;
  }
  
  public String getDestFileName()
  {
    return this.mDestFileName;
  }
  
  public String getDestFilePath()
  {
    return this.mDestFilePath;
  }
  
  public String getMd5()
  {
    return this.mMd5;
  }
  
  public String getServerIp()
  {
    return this.mServerIp;
  }
  
  public void setDestFileName(String paramString)
  {
    this.mDestFileName = paramString;
    setDestFilePath(this.mDestDirectoryPath + paramString);
    setDataFilePath(this.mDataDirectoryPath + paramString + "." + super.getModifyTime() + ".tdl");
  }
  
  public void setMd5(String paramString)
  {
    this.mMd5 = paramString;
  }
  
  public void setModifyTime(long paramLong)
  {
    super.setModifyTime(paramLong);
    if (this.mDestFileName != null) {
      setDataFilePath(this.mDestDirectoryPath + this.mDestFileName + "." + super.getModifyTime() + ".tdl");
    }
  }
  
  public void setServerip(String paramString)
  {
    this.mServerIp = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.job.DownloadJobContext
 * JD-Core Version:    0.7.0.1
 */