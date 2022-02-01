package com.tencent.moai.mailsdk.model;

public class EncodeString
{
  private String charset;
  private String content;
  private byte[] decodingBytes;
  private int decodingBytesCnt;
  private String encoding;
  
  public String getCharset()
  {
    return this.charset;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public byte[] getDecodingBytes()
  {
    return this.decodingBytes;
  }
  
  public int getDecodingBytesCnt()
  {
    return this.decodingBytesCnt;
  }
  
  public String getEncoding()
  {
    return this.encoding;
  }
  
  public boolean isSameEncode(EncodeString paramEncodeString)
  {
    return (this.charset.equalsIgnoreCase(paramEncodeString.charset)) && (this.encoding.equalsIgnoreCase(paramEncodeString.encoding));
  }
  
  public void setCharset(String paramString)
  {
    this.charset = paramString;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setDecodingBytes(byte[] paramArrayOfByte, int paramInt)
  {
    this.decodingBytes = paramArrayOfByte;
    this.decodingBytesCnt = paramInt;
  }
  
  public void setEncoding(String paramString)
  {
    this.encoding = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.model.EncodeString
 * JD-Core Version:    0.7.0.1
 */