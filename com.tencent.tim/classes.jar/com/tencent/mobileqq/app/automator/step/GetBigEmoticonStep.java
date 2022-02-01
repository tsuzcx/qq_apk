package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qphone.base.util.QLog;

public class GetBigEmoticonStep
  extends AsyncStep
{
  public int od()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetBigEmoticonStep", 2, "doStep begins");
    }
    ThreadManager.post(new GetBigEmoticonStep.1(this), 5, null, false);
    return 7;
  }
  
  static class a
  {
    public String epId;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetBigEmoticonStep
 * JD-Core Version:    0.7.0.1
 */