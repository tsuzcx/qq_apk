package com.tencent.moai.downloader.network;

import java.io.File;

public class HttpFileEntity
{
  private String contentType;
  private File file;
  
  public HttpFileEntity(File paramFile, String paramString)
  {
    this.file = paramFile;
    this.contentType = paramString;
  }
  
  public String getContentType()
  {
    return this.contentType;
  }
  
  public File getFile()
  {
    return this.file;
  }
  
  public void setContentType(String paramString)
  {
    this.contentType = paramString;
  }
  
  public void setFile(File paramFile)
  {
    this.file = paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.network.HttpFileEntity
 * JD-Core Version:    0.7.0.1
 */