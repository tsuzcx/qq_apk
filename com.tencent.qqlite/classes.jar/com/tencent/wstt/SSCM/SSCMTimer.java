package com.tencent.wstt.SSCM;

import com.tencent.mobileqq.utils.httputils.HttpMsg;
import flp;
import java.util.Timer;
import java.util.TimerTask;

public class SSCMTimer
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  private static final int d = 120000;
  private static final int e = 5000;
  private long jdField_a_of_type_Long = 0L;
  private HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  private SSCMTimer.SSCMTimerObserver jdField_a_of_type_ComTencentWsttSSCMSSCMTimer$SSCMTimerObserver;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  private boolean jdField_a_of_type_Boolean = true;
  private int f = 0;
  private int g = 0;
  private int h;
  
  public SSCMTimer(SSCMTimer.SSCMTimerObserver paramSSCMTimerObserver, HttpMsg paramHttpMsg)
  {
    this(paramSSCMTimerObserver, paramHttpMsg, 5000);
  }
  
  public SSCMTimer(SSCMTimer.SSCMTimerObserver paramSSCMTimerObserver, HttpMsg paramHttpMsg, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWsttSSCMSSCMTimer$SSCMTimerObserver = paramSSCMTimerObserver;
    this.h = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramHttpMsg;
  }
  
  private TimerTask a()
  {
    return new flp(this);
  }
  
  public int a()
  {
    return this.g;
  }
  
  public void a()
  {
    this.f = 0;
    if (this.jdField_a_of_type_JavaUtilTimer == null)
    {
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_Long = Long.parseLong(Utils.a());
      if (this.jdField_a_of_type_JavaUtilTimerTask == null)
      {
        this.jdField_a_of_type_JavaUtilTimerTask = a();
        this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, this.h, this.h);
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilTimerTask != null)
    {
      this.jdField_a_of_type_JavaUtilTimerTask.cancel();
      this.jdField_a_of_type_JavaUtilTimerTask = null;
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.wstt.SSCM.SSCMTimer
 * JD-Core Version:    0.7.0.1
 */