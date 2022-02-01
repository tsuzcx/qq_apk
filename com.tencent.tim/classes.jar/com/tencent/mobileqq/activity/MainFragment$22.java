package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Looper;
import android.os.MessageQueue;
import vhl;

public class MainFragment$22
  implements Runnable
{
  MainFragment$22(MainFragment paramMainFragment, Intent paramIntent) {}
  
  public void run()
  {
    Looper.myQueue().addIdleHandler(new vhl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MainFragment.22
 * JD-Core Version:    0.7.0.1
 */