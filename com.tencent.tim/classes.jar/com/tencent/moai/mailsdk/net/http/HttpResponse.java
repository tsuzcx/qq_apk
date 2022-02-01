package com.tencent.moai.mailsdk.net.http;

import com.tencent.moai.mailsdk.util.FileUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HttpResponse
{
  public static final int ERROR_CODE_EXCEPTION = 1000;
  public static final int ERROR_CODE_NETWORK = 1001;
  public static final int ERROR_CODE_SSL_ERROR = 1002;
  private int code = 0;
  private byte[] content;
  private Map<String, List<String>> header;
  private InputStream responseInputStream;
  private boolean responseStream;
  
  private void printHeaderMessage()
  {
    Iterator localIterator = this.header.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      Object localObject2 = (List)((Map.Entry)localObject1).getValue();
      localObject1 = (String)((Map.Entry)localObject1).getKey();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          Logger.log(6, "HttpResponse Error", "header key:" + (String)localObject1 + " value:" + str);
        }
      }
    }
  }
  
  public int getCode()
  {
    return this.code;
  }
  
  public byte[] getContent()
  {
    return this.content;
  }
  
  public Map<String, List<String>> getHeader()
  {
    return this.header;
  }
  
  public String getMessage()
  {
    if (this.responseStream) {
      try
      {
        if (this.responseInputStream != null)
        {
          str = new String(FileUtility.readStream(this.responseInputStream));
          return str;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    while (this.content == null)
    {
      String str;
      return "";
    }
    return new String(this.content);
  }
  
  public InputStream getResponseInputStream()
  {
    return this.responseInputStream;
  }
  
  public boolean isOk()
  {
    return (this.code >= 200) && (this.code < 300);
  }
  
  public boolean isResponseStream()
  {
    return this.responseStream;
  }
  
  public void setCode(int paramInt)
  {
    this.code = paramInt;
  }
  
  public void setContent(byte[] paramArrayOfByte)
  {
    this.content = paramArrayOfByte;
  }
  
  public void setHeader(Map<String, List<String>> paramMap)
  {
    this.header = paramMap;
    if ((this.code != 0) && (!isOk())) {
      printHeaderMessage();
    }
  }
  
  public void setResponseInputStream(InputStream paramInputStream)
  {
    this.responseInputStream = paramInputStream;
  }
  
  public void setResponseStream(boolean paramBoolean)
  {
    this.responseStream = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.net.http.HttpResponse
 * JD-Core Version:    0.7.0.1
 */