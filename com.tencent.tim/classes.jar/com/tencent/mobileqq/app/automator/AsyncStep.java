package com.tencent.mobileqq.app.automator;

import acon;
import acoo;
import android.os.Process;
import android.os.SystemClock;
import anmo;
import auvk;
import com.tencent.mobileqq.app.automator.step.ActiveAccount;
import com.tencent.mobileqq.app.automator.step.CheckPublicAccount;
import com.tencent.mobileqq.app.automator.step.GetSubAccount;
import com.tencent.mobileqq.app.automator.step.LoginWelcomeRequest;
import com.tencent.mobileqq.app.automator.step.RegisterPush;
import com.tencent.mobileqq.app.automator.step.UpdateDiscuss;
import com.tencent.mobileqq.app.automator.step.UpdateFriend;
import com.tencent.mobileqq.app.automator.step.UpdateTroop;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AsyncStep
  implements Runnable
{
  public acon a;
  public Automator a;
  private long begin;
  public int cyx = -1;
  protected int cyy;
  public String mName;
  public Object[] mParams;
  protected volatile int mResult = 1;
  private Object mResultLock = new Object();
  protected long mTimeout = 30000L;
  
  private boolean abR()
  {
    for (;;)
    {
      int i;
      synchronized (this.mResultLock)
      {
        i = this.mResult;
        if (i != 2) {}
      }
      try
      {
        this.mResultLock.wait(this.mTimeout);
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, this.mName + " waitResult " + this.mResult + " " + this.cyy);
        }
        if (this.mResult == 3)
        {
          this.mResult = 2;
          continue;
          localObject2 = finally;
          throw localObject2;
        }
      }
      catch (InterruptedException localInterruptedException2)
      {
        for (;;)
        {
          localInterruptedException2.printStackTrace();
        }
        if (this.mResult == 2)
        {
          this.mResult = 5;
          Automator localAutomator = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
          localAutomator.cyA += 1;
        }
        if ((this.mResult == 6) || (this.mResult == 5))
        {
          i = this.cyy;
          this.cyy = (i - 1);
          if (i > 0)
          {
            this.mResult = 1;
            return true;
          }
        }
        if ((anmo.cIA) && (!acoo.bV.contains(Integer.valueOf(this.cyx))))
        {
          long l = SystemClock.uptimeMillis() - this.begin;
          if (QLog.isColorLevel()) {
            QLog.d("Perf", 2, new Object[] { "asyncstep runtime = ", Long.valueOf(l) });
          }
          if (l < 1500L) {
            try
            {
              Thread.sleep(1500L - l);
              return false;
            }
            catch (InterruptedException localInterruptedException1) {}
          }
        }
      }
    }
    return false;
  }
  
  public final void ic(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder(64);
      ((StringBuilder)???).append(this.mName);
      ((StringBuilder)???).append(" updateTimeout ");
      ((StringBuilder)???).append(paramLong);
      ((StringBuilder)???).append(", when ");
      ((StringBuilder)???).append(this.mResult);
      QLog.d("QQInitHandler", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.mResultLock)
    {
      if (this.mResult == 2) {
        this.mResult = 3;
      }
      this.mTimeout = paramLong;
      this.mResultLock.notifyAll();
      return;
    }
  }
  
  protected int od()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQInitHandler", 2, this.mName + " AsyncStep.doStep()");
    }
    return 7;
  }
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  public final void run()
  {
    if (this.mResult == 1)
    {
      auvk.p(4096L, this.mName, Process.myTid());
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 1, this.mName + " begin with " + this.mResult);
      }
      this.begin = SystemClock.uptimeMillis();
    }
    try
    {
      onCreate();
      do
      {
        setResult(od());
      } while (abR());
      onDestroy();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 1, this.mName + " cost: " + (SystemClock.uptimeMillis() - this.begin));
      }
    }
    catch (Throwable localThrowable1)
    {
      label250:
      QLog.e("QQInitHandler", 1, "", localThrowable1);
      setResult(8);
      return;
    }
    finally
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 1, this.mName + " cost: " + (SystemClock.uptimeMillis() - this.begin));
      }
      try
      {
        if (((this instanceof ActiveAccount)) || ((this instanceof LoginWelcomeRequest)) || ((this instanceof UpdateFriend)) || ((this instanceof UpdateTroop)) || ((this instanceof UpdateDiscuss)) || ((this instanceof CheckPublicAccount)) || ((this instanceof GetSubAccount)) || ((this instanceof InitBeforeSyncMsg)) || ((this instanceof RegisterPush)) || ("{4,3,5,6}".equals(this.mName)) || ("[11,12,14]".equals(this.mName))) {
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.ew.put(this.mName, Long.valueOf(SystemClock.uptimeMillis() - this.begin));
        }
      }
      catch (Throwable localThrowable4)
      {
        break label653;
      }
      auvk.q(4096L, this.mName, Process.myTid());
      if (this.jdField_a_of_type_Acon != null) {
        this.jdField_a_of_type_Acon.a(this, this.mResult);
      }
    }
    try
    {
      if (((this instanceof ActiveAccount)) || ((this instanceof LoginWelcomeRequest)) || ((this instanceof UpdateFriend)) || ((this instanceof UpdateTroop)) || ((this instanceof UpdateDiscuss)) || ((this instanceof CheckPublicAccount)) || ((this instanceof GetSubAccount)) || ((this instanceof InitBeforeSyncMsg)) || ((this instanceof RegisterPush)) || ("{4,3,5,6}".equals(this.mName)) || ("[11,12,14]".equals(this.mName))) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.ew.put(this.mName, Long.valueOf(SystemClock.uptimeMillis() - this.begin));
      }
    }
    catch (Throwable localThrowable3)
    {
      break label250;
    }
    auvk.q(4096L, this.mName, Process.myTid());
    if (this.jdField_a_of_type_Acon != null) {
      this.jdField_a_of_type_Acon.a(this, this.mResult);
    }
  }
  
  public void setResult(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.mName + " setResult " + paramInt + ", when " + this.mResult);
    }
    if (paramInt == 6)
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
      ((Automator)???).cyA += 1;
    }
    synchronized (this.mResultLock)
    {
      if ((paramInt > this.mResult) && (paramInt != 4)) {
        this.mResult = paramInt;
      }
      this.mResultLock.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.AsyncStep
 * JD-Core Version:    0.7.0.1
 */