package com.tencent.map.sdk.engine.jni;

import java.util.Arrays;

public class JNIEvent
{
  public byte[] data;
  public Object extra;
  public int id;
  public String name;
  
  public String toString()
  {
    return "JNIEvent{id=" + this.id + ", name='" + this.name + '\'' + ", data=" + Arrays.toString(this.data) + ", extra=" + this.extra + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.engine.jni.JNIEvent
 * JD-Core Version:    0.7.0.1
 */