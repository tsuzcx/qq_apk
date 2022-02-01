package com.tencent.mobileqq.nearby.redtouch;

import java.io.Serializable;

public class RedTouchItemExtMsg
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  public byte[] bytesData;
  public long seq;
  public int time;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("seq").append(":").append(this.seq).append(" ");
    localStringBuilder.append("time").append(":").append(this.time).append(" ");
    localStringBuilder.append("bytesData").append(":").append(this.bytesData).append(" ");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.RedTouchItemExtMsg
 * JD-Core Version:    0.7.0.1
 */