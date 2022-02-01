package com.tencent.qqmini.sdk.launcher.core.auth;

import java.util.List;

public class SubscribeMessage
{
  public int authState;
  public List<Entry> contents;
  public String templateId;
  
  class Entry
  {
    public String key;
    public String value;
    
    Entry() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.auth.SubscribeMessage
 * JD-Core Version:    0.7.0.1
 */