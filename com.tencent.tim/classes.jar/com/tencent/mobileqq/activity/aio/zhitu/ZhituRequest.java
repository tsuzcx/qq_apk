package com.tencent.mobileqq.activity.aio.zhitu;

import atad;
import ykx;

public class ZhituRequest
{
  public String chat;
  public String os;
  public ykx report;
  public int styles;
  public String text;
  public String uin;
  public String version;
  
  public String toString()
  {
    return "ZhituRequest{chat='" + this.chat + '\'' + ", styles=" + this.styles + ", os='" + this.os + '\'' + ", uin='" + this.uin + '\'' + ", text='" + atad.toMD5(this.text) + '\'' + ", report=" + this.report + ", version='" + this.version + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituRequest
 * JD-Core Version:    0.7.0.1
 */