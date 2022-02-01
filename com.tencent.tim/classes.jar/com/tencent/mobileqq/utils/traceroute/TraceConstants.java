package com.tencent.mobileqq.utils.traceroute;

public class TraceConstants
{
  public static enum TraceAction
  {
    TRACE_COMPLETE,  TRACE_ERROR;
    
    private TraceAction() {}
  }
  
  public static enum TraceMethod
  {
    ICMP,  UDP;
    
    private TraceMethod() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.traceroute.TraceConstants
 * JD-Core Version:    0.7.0.1
 */