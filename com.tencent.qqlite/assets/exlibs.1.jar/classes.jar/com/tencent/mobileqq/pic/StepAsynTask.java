package com.tencent.mobileqq.pic;

import android.os.AsyncTask;

public class StepAsynTask
  extends AsyncTask
{
  StepAsynTask a;
  
  protected Void a(Object... paramVarArgs)
  {
    return null;
  }
  
  public void a(StepAsynTask paramStepAsynTask)
  {
    this.a = paramStepAsynTask;
  }
  
  protected void onPostExecute(Object paramObject)
  {
    if (this.a != null) {
      this.a.execute(new Object[0]);
    }
    super.onPostExecute(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.StepAsynTask
 * JD-Core Version:    0.7.0.1
 */