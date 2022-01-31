package com.tencent.mobileqq.bubble;

import java.util.ArrayList;

public class BubbleConfig
{
  public static final String a = "BubbleConfig";
  public static final String b = "config.json";
  public static final String c = "version.json";
  public static final String d = "static";
  public static final String e = "height";
  public static final String f = "width";
  public static final String g = "voice";
  public static final String h = "static.zip";
  public static final String i = "height.zip";
  public static final String j = "voice.zip";
  public static final String k = "all.zip";
  public static final String l = "global_version";
  public int a = 0;
  public AnimationConfig a;
  public ArrayList a;
  public int[] a;
  public int b;
  public AnimationConfig b;
  public int c;
  public AnimationConfig c;
  public String m;
  
  public BubbleConfig(int paramInt)
  {
    this.a = paramInt;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("[ bubbleId=" + this.a).append(",");
    localStringBuffer.append("name=" + this.m).append(" ]");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleConfig
 * JD-Core Version:    0.7.0.1
 */