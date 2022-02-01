package com.tencent.moai.mailsdk.protocol.mime.model;

import com.tencent.moai.mailsdk.protocol.model.Pair;

public class MimePair
  extends Pair
{
  private static final String TAG = "MimePair";
  protected String line;
  protected String name;
  protected String value;
  
  public MimePair(String paramString)
  {
    this.line = paramString;
  }
  
  public MimePair(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.value = paramString2;
    this.line = write();
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void read()
  {
    int i = this.line.indexOf(":");
    if (i < 0)
    {
      this.name = this.line;
      this.value = this.line;
      return;
    }
    this.name = this.line.substring(0, i).trim();
    this.value = this.line.substring(i + 1, this.line.length()).trim();
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
  
  public String write()
  {
    if (this.line != null) {
      return this.line;
    }
    return this.name + ": " + this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.mime.model.MimePair
 * JD-Core Version:    0.7.0.1
 */