package com.tencent.moai.mailsdk.protocol.pop3;

import java.io.InputStream;

public class POP3Response
{
  private InputStream bytes = null;
  private String data = null;
  private boolean ok = false;
  
  public InputStream getBytes()
  {
    return this.bytes;
  }
  
  public String getData()
  {
    return this.data;
  }
  
  public boolean isOk()
  {
    return this.ok;
  }
  
  public void setBytes(InputStream paramInputStream)
  {
    this.bytes = paramInputStream;
  }
  
  public void setData(String paramString)
  {
    this.data = paramString;
  }
  
  public void setOk(boolean paramBoolean)
  {
    this.ok = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.pop3.POP3Response
 * JD-Core Version:    0.7.0.1
 */