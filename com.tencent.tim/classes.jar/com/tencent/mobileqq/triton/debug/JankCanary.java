package com.tencent.mobileqq.triton.debug;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.sdk.ITTEngine.OnGetTraceRecordCallback;

public class JankCanary
{
  private final TTEngine a;
  
  public JankCanary(TTEngine paramTTEngine)
  {
    this.a = paramTTEngine;
  }
  
  private static native Object[] getBriefTraceInfo(TTEngine paramTTEngine, Class<Object> paramClass);
  
  public void a(ITTEngine.OnGetTraceRecordCallback paramOnGetTraceRecordCallback)
  {
    this.a.a(new JankCanary.a(this, paramOnGetTraceRecordCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.debug.JankCanary
 * JD-Core Version:    0.7.0.1
 */