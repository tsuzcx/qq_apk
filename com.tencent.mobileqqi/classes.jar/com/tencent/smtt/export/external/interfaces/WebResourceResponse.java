package com.tencent.smtt.export.external.interfaces;

import java.io.InputStream;

public class WebResourceResponse
{
  private String mEncoding;
  private InputStream mInputStream;
  private String mMimeType;
  
  public WebResourceResponse(String paramString1, String paramString2, InputStream paramInputStream)
  {
    this.mMimeType = paramString1;
    this.mEncoding = paramString2;
    this.mInputStream = paramInputStream;
  }
  
  public InputStream getData()
  {
    return this.mInputStream;
  }
  
  public String getEncoding()
  {
    return this.mEncoding;
  }
  
  public String getMimeType()
  {
    return this.mMimeType;
  }
  
  public void setData(InputStream paramInputStream)
  {
    this.mInputStream = paramInputStream;
  }
  
  public void setEncoding(String paramString)
  {
    this.mEncoding = paramString;
  }
  
  public void setMimeType(String paramString)
  {
    this.mMimeType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.WebResourceResponse
 * JD-Core Version:    0.7.0.1
 */