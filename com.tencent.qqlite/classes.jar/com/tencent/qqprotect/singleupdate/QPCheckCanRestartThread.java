package com.tencent.qqprotect.singleupdate;

import android.app.KeyguardManager;
import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Date;

public class QPCheckCanRestartThread
  extends Thread
{
  final int jdField_a_of_type_Int = 300;
  KeyguardManager jdField_a_of_type_AndroidAppKeyguardManager = null;
  Date jdField_a_of_type_JavaUtilDate = null;
  boolean jdField_a_of_type_Boolean = false;
  Date b = null;
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppKeyguardManager != null) && (this.jdField_a_of_type_AndroidAppKeyguardManager.inKeyguardRestrictedInputMode());
  }
  
  public void run()
  {
    super.run();
    this.jdField_a_of_type_AndroidAppKeyguardManager = ((KeyguardManager)BaseApplication.getContext().getSystemService("keyguard"));
    if (this.jdField_a_of_type_AndroidAppKeyguardManager.inKeyguardRestrictedInputMode()) {
      if (this.jdField_a_of_type_JavaUtilDate == null) {
        this.jdField_a_of_type_JavaUtilDate = new Date();
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(300L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      break;
      this.b = new Date();
      if ((this.b.getTime() - this.jdField_a_of_type_JavaUtilDate.getTime()) / 1000L >= 300L)
      {
        this.jdField_a_of_type_Boolean = true;
        continue;
        this.jdField_a_of_type_JavaUtilDate = null;
        this.b = null;
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPCheckCanRestartThread
 * JD-Core Version:    0.7.0.1
 */