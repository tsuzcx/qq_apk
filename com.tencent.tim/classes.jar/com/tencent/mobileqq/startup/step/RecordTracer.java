package com.tencent.mobileqq.startup.step;

import android.os.Build.VERSION;
import annn;
import anno;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trackrecordlib.core.RecordManager;

public class RecordTracer
  extends Step
{
  private static final String TAG = RecordTracer.class.getSimpleName();
  
  public static RecordTracer a()
  {
    return a.b;
  }
  
  protected boolean doStep()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      QLog.d(TAG, 2, "doStep: RecordTracer");
    }
    try
    {
      RecordManager.getInstance().startRecord(BaseApplicationImpl.getContext(), new annn(this), new anno(this));
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TAG, 1, localThrowable, new Object[0]);
      localThrowable.printStackTrace();
    }
    return true;
  }
  
  static final class a
  {
    public static final RecordTracer b = new RecordTracer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.RecordTracer
 * JD-Core Version:    0.7.0.1
 */