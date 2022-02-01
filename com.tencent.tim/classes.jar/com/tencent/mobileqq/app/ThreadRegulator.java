package com.tencent.mobileqq.app;

import acmq;
import acmr;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import mqq.os.MqqRegulatorCallback;

public class ThreadRegulator
  implements MqqRegulatorCallback
{
  private static ThreadRegulator jdField_a_of_type_ComTencentMobileqqAppThreadRegulator;
  private MqqHandler C = new acmr(this, ThreadManager.getSubThreadLooper());
  private volatile a jdField_a_of_type_ComTencentMobileqqAppThreadRegulator$a;
  Runnable fO = new ThreadRegulator.2(this);
  private final RecyclablePool sPool = new RecyclablePool(a.class, 2);
  
  public static ThreadRegulator a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppThreadRegulator == null) {
        jdField_a_of_type_ComTencentMobileqqAppThreadRegulator = new ThreadRegulator();
      }
      ThreadRegulator localThreadRegulator = jdField_a_of_type_ComTencentMobileqqAppThreadRegulator;
      return localThreadRegulator;
    }
    finally {}
  }
  
  public void JW(int paramInt)
  {
    if (!acmq.a().abG()) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppThreadRegulator$a != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppThreadRegulator$a = ((a)this.sPool.obtain(a.class));
    this.jdField_a_of_type_ComTencentMobileqqAppThreadRegulator$a.type = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppThreadRegulator$a.startTime = SystemClock.uptimeMillis();
    try
    {
      ThreadExcutor.getInstance().shrinkMaxPoolSize(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ThreadManager.Regulaotr", 1, "markBusyState: invoked. ", localThrowable);
    }
  }
  
  public void JX(int paramInt)
  {
    ab(paramInt, 0L);
  }
  
  public void ab(int paramInt, long paramLong)
  {
    if (paramLong == 0L)
    {
      this.fO.run();
      return;
    }
    BaseApplicationImpl.sUiHandler.postDelayed(this.fO, paramLong);
  }
  
  public void checkInNextBusiness()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppThreadRegulator$a == null) {
      return;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqAppThreadRegulator$a != null) {
      try
      {
        Thread.sleep(100L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public void checkInRegulatorMsg()
  {
    checkInNextBusiness();
  }
  
  public void init()
  {
    MqqHandler.sRegulatorCallback = this;
    mqq.app.MainService.sRegulatorCallback = this;
  }
  
  public boolean regulatorThread(Thread paramThread)
  {
    if ((paramThread == ThreadManager.getFileThread()) || (paramThread == ThreadManager.getSubThread())) {}
    do
    {
      do
      {
        return true;
        if (!"MSF-Receiver".equals(paramThread.getName())) {
          break;
        }
      } while (!acmq.a().abH());
      paramThread.setPriority(1);
      return true;
    } while ("Rejected_Handler".equals(paramThread.getName()));
    return false;
  }
  
  public static class a
    extends RecyclablePool.Recyclable
  {
    public ConcurrentHashMap<String, Long> el = new ConcurrentHashMap(4);
    public long endTime;
    public long startTime;
    public int type;
    
    public void recycle()
    {
      this.type = 0;
      this.startTime = 0L;
      this.endTime = 0L;
      this.el.clear();
      super.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadRegulator
 * JD-Core Version:    0.7.0.1
 */