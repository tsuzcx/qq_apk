package com.tencent.mobileqq.flutter.channel.model;

import ahge;
import java.util.Map;

public class SCFSwitchs
{
  public Boolean isQzoneNotify;
  public Boolean isSpecialCare;
  public Boolean isVoiceNewFlag;
  
  public static SCFSwitchs fromMap(Map paramMap)
  {
    return (SCFSwitchs)ahge.a(paramMap, SCFSwitchs.class);
  }
  
  public static Map toMap(SCFSwitchs paramSCFSwitchs)
  {
    return ahge.a(paramSCFSwitchs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.model.SCFSwitchs
 * JD-Core Version:    0.7.0.1
 */