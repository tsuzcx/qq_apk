package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import aqhv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class JumpAction$23
  implements Runnable
{
  public JumpAction$23(aqhv paramaqhv) {}
  
  public void run()
  {
    if (this.this$0.app == null) {}
    String str;
    do
    {
      return;
      str = this.this$0.app.getCurrentAccountUin();
    } while (TextUtils.isEmpty(str));
    WebProcessManager.bv(str, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.23
 * JD-Core Version:    0.7.0.1
 */