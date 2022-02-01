package com.tencent.mobileqq.activity;

import aizp;
import android.os.Handler;

class TroopAssisSettingActivity$1
  implements Runnable
{
  TroopAssisSettingActivity$1(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  public void run()
  {
    this.this$0.hp = aizp.a().a(this.this$0.app, this.this$0.rj);
    this.this$0.mHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */