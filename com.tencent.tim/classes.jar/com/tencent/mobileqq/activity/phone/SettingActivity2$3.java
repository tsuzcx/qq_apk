package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.app.QQAppInterface;
import zrh;

public class SettingActivity2$3
  implements Runnable
{
  SettingActivity2$3(SettingActivity2 paramSettingActivity2) {}
  
  public void run()
  {
    if (this.this$0.k == null)
    {
      this.this$0.k = new zrh(this);
      this.this$0.app.registObserver(this.this$0.k);
    }
    this.this$0.app.execute(new SettingActivity2.3.2(this));
    this.this$0.j(2131719519, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2.3
 * JD-Core Version:    0.7.0.1
 */