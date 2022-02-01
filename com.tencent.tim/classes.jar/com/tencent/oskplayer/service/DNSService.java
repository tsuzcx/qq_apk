package com.tencent.oskplayer.service;

import java.util.concurrent.TimeUnit;

public abstract interface DNSService
{
  public abstract String fastResolve(String paramString);
  
  public abstract boolean isNetReachable();
  
  public abstract String resolve(String paramString);
  
  public abstract String resolve(String paramString, long paramLong, TimeUnit paramTimeUnit);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.service.DNSService
 * JD-Core Version:    0.7.0.1
 */