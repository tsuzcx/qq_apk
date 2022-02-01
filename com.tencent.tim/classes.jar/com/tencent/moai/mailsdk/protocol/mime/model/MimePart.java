package com.tencent.moai.mailsdk.protocol.mime.model;

import com.tencent.moai.mailsdk.protocol.model.Part;

public abstract interface MimePart
  extends Part
{
  public abstract String getContentDescription();
  
  public abstract String getContentEncoding();
  
  public abstract String getContentID();
  
  public abstract String getContentLanguage();
  
  public abstract String getContentMD5();
  
  public abstract String getContentType();
  
  public abstract String getDisposition();
  
  public abstract void setContentDescription(String paramString);
  
  public abstract void setContentEncoding(String paramString);
  
  public abstract void setContentID(String paramString);
  
  public abstract void setContentLanguage(String paramString);
  
  public abstract void setContentMD5(String paramString);
  
  public abstract void setContentType(String paramString);
  
  public abstract void setDisposition(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.mime.model.MimePart
 * JD-Core Version:    0.7.0.1
 */