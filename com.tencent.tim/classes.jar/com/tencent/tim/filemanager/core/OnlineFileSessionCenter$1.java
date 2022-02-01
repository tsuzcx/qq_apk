package com.tencent.tim.filemanager.core;

import android.content.IntentFilter;
import atuh;
import atui;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class OnlineFileSessionCenter$1
  implements Runnable
{
  public OnlineFileSessionCenter$1(atuh paramatuh, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    atuh.a(this.this$0, new atui(this));
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    this.val$app.getApp().registerReceiver(atuh.a(this.this$0), localIntentFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.OnlineFileSessionCenter.1
 * JD-Core Version:    0.7.0.1
 */