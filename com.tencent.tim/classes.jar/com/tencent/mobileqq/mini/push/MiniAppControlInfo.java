package com.tencent.mobileqq.mini.push;

import java.util.HashMap;
import java.util.Map;

public class MiniAppControlInfo
{
  public String cmd;
  public Map<String, String> data = new HashMap();
  
  public String toString()
  {
    return "ctrlInfo:[cmd = " + this.cmd + ", data = " + this.data + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.push.MiniAppControlInfo
 * JD-Core Version:    0.7.0.1
 */