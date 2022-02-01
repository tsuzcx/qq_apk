package com.tencent.qqprotect.singleupdate;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.TimerTask;

public class QPSingleUpdTimerTask
  extends TimerTask
{
  public void run()
  {
    ThreadManager.post(new QPSingleUpdTimerTask.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSingleUpdTimerTask
 * JD-Core Version:    0.7.0.1
 */