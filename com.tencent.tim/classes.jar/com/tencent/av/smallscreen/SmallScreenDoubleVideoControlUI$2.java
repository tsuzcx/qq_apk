package com.tencent.av.smallscreen;

import com.tencent.qphone.base.util.QLog;
import ivp;

public class SmallScreenDoubleVideoControlUI$2
  implements Runnable
{
  public SmallScreenDoubleVideoControlUI$2(ivp paramivp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "2s has past, startTimer now!");
    }
    this.this$0.startTimer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI.2
 * JD-Core Version:    0.7.0.1
 */