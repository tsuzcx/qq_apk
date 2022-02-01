package com.tencent.image;

import java.util.HashMap;

public class ReportBean
{
  public HashMap<String, String> params = new HashMap();
  public long size;
  public boolean suc = true;
  public String tag;
  public long time;
  
  public ReportBean(String paramString)
  {
    this.tag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.ReportBean
 * JD-Core Version:    0.7.0.1
 */