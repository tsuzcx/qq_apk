package com.tencent.mobileqq.armap.sensor.provider;

public class OrientationProviderNotFound
  extends Exception
{
  public OrientationProviderNotFound(String paramString)
  {
    super("sensor type:" + paramString + " not found");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.provider.OrientationProviderNotFound
 * JD-Core Version:    0.7.0.1
 */