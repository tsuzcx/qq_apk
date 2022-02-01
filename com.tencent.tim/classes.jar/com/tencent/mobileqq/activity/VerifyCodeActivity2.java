package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class VerifyCodeActivity2
  extends VerifyCodeActivity
{
  public boolean doOnCreate(Bundle paramBundle)
  {
    try
    {
      boolean bool = super.doOnCreate(paramBundle);
      return bool;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerifyCodeActivity2", 2, "e= " + paramBundle);
      }
      finish();
      return false;
    }
    catch (Error paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VerifyCodeActivity2", 2, "e= " + paramBundle);
        }
        finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyCodeActivity2
 * JD-Core Version:    0.7.0.1
 */