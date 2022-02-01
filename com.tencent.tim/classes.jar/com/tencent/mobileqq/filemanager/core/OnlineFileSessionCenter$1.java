package com.tencent.mobileqq.filemanager.core;

import aglp;
import aglq;
import android.content.IntentFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class OnlineFileSessionCenter$1
  implements Runnable
{
  public OnlineFileSessionCenter$1(aglp paramaglp, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    aglp.a(this.this$0, new aglq(this));
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    this.val$app.getApp().registerReceiver(aglp.a(this.this$0), localIntentFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter.1
 * JD-Core Version:    0.7.0.1
 */