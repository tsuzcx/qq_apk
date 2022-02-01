package com.tencent.mobileqq.activity;

import acff;
import com.tencent.mobileqq.data.Card;

class QQSettingSettingActivity$11
  implements Runnable
{
  QQSettingSettingActivity$11(QQSettingSettingActivity paramQQSettingSettingActivity, acff paramacff, String paramString) {}
  
  public void run()
  {
    Card localCard = this.d.b(this.val$uin);
    this.this$0.runOnUiThread(new QQSettingSettingActivity.11.1(this, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.11
 * JD-Core Version:    0.7.0.1
 */