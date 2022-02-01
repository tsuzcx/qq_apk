package com.tencent.moai.mailsdk.net.http;

import java.io.File;
import java.util.Map;

public class HttpRequest
{
  public static final String METHOD_OPTION = "OPTIONS";
  public static final String METHOD_POST = "POST";
  private byte[] content;
  private Map<String, String> header;
  private String method;
  private File requestDataFile;
  private boolean requestStream;
  private String url;
  
  public byte[] getContent()
  {
    return this.content;
  }
  
  public long getContentLength()
  {
    if (this.requestStream)
    {
      if (this.requestDataFile != null) {
        return this.requestDataFile.length();
      }
    }
    else if (this.content != null) {
      return this.content.length;
    }
    return 0L;
  }
  
  public Map<String, String> getHeader()
  {
    return this.header;
  }
  
  public String getMethod()
  {
    return this.method;
  }
  
  public File getRequestDataFile()
  {
    return this.requestDataFile;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public boolean isRequestStream()
  {
    return this.requestStream;
  }
  
  public void setContent(byte[] paramArrayOfByte)
  {
    this.content = paramArrayOfByte;
  }
  
  public void setHeader(Map<String, String> paramMap)
  {
    this.header = paramMap;
  }
  
  public void setMethod(String paramString)
  {
    this.method = paramString;
  }
  
  public void setRequestDataFile(File paramFile)
  {
    this.requestDataFile = paramFile;
  }
  
  public void setRequestStream(boolean paramBoolean)
  {
    this.requestStream = paramBoolean;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.net.http.HttpRequest
 * JD-Core Version:    0.7.0.1
 */