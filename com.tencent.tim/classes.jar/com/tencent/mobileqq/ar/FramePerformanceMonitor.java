package com.tencent.mobileqq.ar;

import adfg;
import adfg.a;
import com.tencent.mobileqq.app.ThreadManager;

public class FramePerformanceMonitor
{
  private adfg jdField_a_of_type_Adfg = new adfg(100);
  private CurrentRunnable jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable;
  private a jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$a;
  private int cEf = 1000;
  
  public void KP(int paramInt)
  {
    this.cEf = paramInt;
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$a = parama;
  }
  
  public boolean bP(long paramLong)
  {
    return this.jdField_a_of_type_Adfg.bP(paramLong);
  }
  
  public void cRd()
  {
    cRe();
    if (this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable = new CurrentRunnable(null);
    CurrentRunnable.a(this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable, true);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable, 8, null, true);
  }
  
  public void cRe()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable != null)
    {
      CurrentRunnable.a(this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable, false);
      this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$CurrentRunnable = null;
    }
  }
  
  class CurrentRunnable
    implements Runnable
  {
    private boolean ob;
    
    private CurrentRunnable() {}
    
    public void run()
    {
      for (;;)
      {
        try
        {
          if (this.ob)
          {
            if (FramePerformanceMonitor.a(FramePerformanceMonitor.this).size() == 0) {
              Thread.sleep(FramePerformanceMonitor.a(FramePerformanceMonitor.this));
            }
          }
          else {
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        adfg.a locala = FramePerformanceMonitor.a(FramePerformanceMonitor.this).a();
        FramePerformanceMonitor.a(FramePerformanceMonitor.this).a(locala);
        Thread.sleep(FramePerformanceMonitor.a(FramePerformanceMonitor.this));
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(adfg.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FramePerformanceMonitor
 * JD-Core Version:    0.7.0.1
 */