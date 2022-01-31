package com.tencent.mobileqq.bubble;

import java.util.ArrayList;

public class BubbleConfig
{
  public static final String a = "BubbleConfig";
  public static final String b = "config.json";
  public static final String c = "static";
  public static final String d = "height";
  public static final String e = "voice";
  public static final String f = "static.zip";
  public static final String g = "height.zip";
  public static final String h = "voice.zip";
  public static final String i = "all.zip";
  public int a = 0;
  public AnimationConfig a;
  public ArrayList a;
  public int[] a;
  public int b;
  public AnimationConfig b;
  public int c;
  public int d;
  public int e;
  public String j;
  
  public BubbleConfig(int paramInt)
  {
    this.a = paramInt;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("[ bubbleId=" + this.a).append(",");
    localStringBuffer.append("version=" + this.b).append(",");
    localStringBuffer.append("name=" + this.j).append(" ]");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleConfig
 * JD-Core Version:    0.7.0.1
 */