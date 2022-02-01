package com.tencent.mobileqq.msf.sdk.report;

import com.tencent.feedback.eup.CrashReport;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class a
{
  private static final String a = "MSFCatchedExceptionReporter";
  private static Field b;
  
  private static void a(Throwable paramThrowable, String paramString)
  {
    try
    {
      if (b == null) {
        b = Throwable.class.getDeclaredField("detailMessage");
      }
      b.setAccessible(true);
      b.set(paramThrowable, paramString + " : " + paramThrowable.getMessage());
      return;
    }
    catch (Exception paramThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MSFCatchedExceptionReporter", 2, "addCatchedMsgTag failed : ", paramThrowable);
    }
  }
  
  public static void a(Throwable paramThrowable, String paramString1, String paramString2)
  {
    if ((paramThrowable == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    a(paramThrowable, paramString1);
    CrashReport.handleCatchException(Thread.currentThread(), paramThrowable, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.report.a
 * JD-Core Version:    0.7.0.1
 */