package com.tencent.mobileqq.app.automator;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;

public class AsyncStep
  implements Runnable
{
  public static final int a = 2;
  protected static final long a = 30000L;
  protected static final String a = "QQInitHandler";
  public static final int b = 4;
  public static final int c = 5;
  public static final int d = 6;
  public static final int e = 7;
  public static final int f = 8;
  private static final int j = 1;
  private static final int k = 3;
  protected Automator a;
  protected IResultListener a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean = true;
  protected long b;
  protected String b;
  protected volatile int g = 1;
  protected int h = -1;
  protected int i = 0;
  
  public AsyncStep()
  {
    this.jdField_b_of_type_Long = 30000L;
  }
  
  private boolean a()
  {
    for (;;)
    {
      int m;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        m = this.g;
        if (m != 2) {}
      }
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(this.jdField_b_of_type_Long);
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " waitResult " + this.g + " " + this.i);
        }
        if (this.g == 3)
        {
          this.g = 2;
          continue;
          localObject2 = finally;
          throw localObject2;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
        if (this.g == 2)
        {
          if (!this.jdField_a_of_type_Boolean) {}
          this.g = 5;
          Automator localAutomator = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
          localAutomator.e += 1;
        }
        else if ((this.g == 6) || (this.g == 5))
        {
          m = this.i;
          this.i = (m - 1);
          if (m > 0)
          {
            this.g = 1;
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.e) || (NetConnInfoCenter.socketConnState == 4) || (NetConnInfoCenter.socketConnState == 2) || (NetworkUtil.e(BaseApplicationImpl.a));
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " AsyncStep.doStep()");
    }
    return 7;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " setResult " + paramInt + ", when " + this.g + ", " + this.jdField_a_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 4)) {
      return;
    }
    if (paramInt == 6)
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
      ((Automator)???).e += 1;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (paramInt > this.g)
        {
          if ((this.g == 2) && (paramInt == 4) && (!this.jdField_a_of_type_Boolean))
          {
            this.i += 1;
            this.jdField_a_of_type_Boolean = true;
            this.g = 2;
          }
        }
        else
        {
          this.jdField_a_of_type_JavaLangObject.notifyAll();
          return;
        }
      }
      this.g = paramInt;
      if (this.g == 2) {
        this.jdField_a_of_type_Boolean = b();
      }
    }
  }
  
  public final void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " updateTimeout " + paramLong + ", when " + this.g);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (3 > this.g) {
        this.g = 3;
      }
      this.jdField_b_of_type_Long = paramLong;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public void b() {}
  
  public final void run()
  {
    long l = 0L;
    TraceUtils.a(this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      l = SystemClock.uptimeMillis();
      QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " begin with " + this.g);
    }
    if (this.g == 1) {}
    try
    {
      a();
      do
      {
        a(a());
      } while (a());
      b();
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorIResultListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorIResultListener.a(this, this.g);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQInitHandler", 2, Log.getStackTraceString(localThrowable));
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " cost: " + (SystemClock.uptimeMillis() - l));
    }
    TraceUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.AsyncStep
 * JD-Core Version:    0.7.0.1
 */