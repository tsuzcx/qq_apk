package com.tencent.mobileqq.highway.netprobe;

public class DefaultProbe
  extends ProbeChain
{
  private static final int DEFAULT_PRIORITY = 10;
  
  public DefaultProbe()
  {
    super(10);
    addProbeItem(new EchoProbe());
    addProbeItem(new TracerouteProbe());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.DefaultProbe
 * JD-Core Version:    0.7.0.1
 */