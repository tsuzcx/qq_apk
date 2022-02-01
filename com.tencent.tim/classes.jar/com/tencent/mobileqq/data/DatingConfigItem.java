package com.tencent.mobileqq.data;

import java.io.Serializable;

public class DatingConfigItem
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String contentStr;
  public int id;
  
  public DatingConfigItem(int paramInt, String paramString)
  {
    this.id = paramInt;
    this.contentStr = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.DatingConfigItem
 * JD-Core Version:    0.7.0.1
 */