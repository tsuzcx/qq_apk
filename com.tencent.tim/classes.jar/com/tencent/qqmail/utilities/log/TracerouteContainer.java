package com.tencent.qqmail.utilities.log;

import java.io.Serializable;

public class TracerouteContainer
  implements Serializable
{
  private static final long serialVersionUID = 1034744411998219581L;
  private boolean desp;
  private String ip;
  private boolean isSuccessful;
  private float ms;
  
  public TracerouteContainer(String paramString1, float paramFloat, boolean paramBoolean, String paramString2)
  {
    this.ip = paramString1;
    this.ms = paramFloat;
    this.isSuccessful = paramBoolean;
  }
  
  public String getIp()
  {
    return this.ip;
  }
  
  public float getMs()
  {
    return this.ms;
  }
  
  public boolean isDesp()
  {
    return this.desp;
  }
  
  public boolean isSuccessful()
  {
    return this.isSuccessful;
  }
  
  public void setDesp(boolean paramBoolean)
  {
    this.desp = paramBoolean;
  }
  
  public void setIp(String paramString)
  {
    this.ip = paramString;
  }
  
  public void setMs(float paramFloat)
  {
    this.ms = paramFloat;
  }
  
  public void setSuccessful(boolean paramBoolean)
  {
    this.isSuccessful = paramBoolean;
  }
  
  public String toString()
  {
    return "Traceroute : ip : " + this.ip + " time(ms) : " + this.ms;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.TracerouteContainer
 * JD-Core Version:    0.7.0.1
 */