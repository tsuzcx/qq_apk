package com.tencent.mobileqq.activity.selectmember;

import aayt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;

public class TroopListBaseAdapter$1
  implements Runnable
{
  public TroopListBaseAdapter$1(aayt paramaayt) {}
  
  public void run()
  {
    ((TroopManager)this.this$0.mApp.getManager(52)).eg();
    this.this$0.mApp.runOnUiThread(new TroopListBaseAdapter.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.1
 * JD-Core Version:    0.7.0.1
 */