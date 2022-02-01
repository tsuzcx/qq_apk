package com.tencent.qqmail;

import android.annotation.SuppressLint;
import java.util.HashMap;

class BaseActivity$4
  implements Runnable
{
  BaseActivity$4(BaseActivity paramBaseActivity, Runnable paramRunnable) {}
  
  @SuppressLint({"NewApi"})
  public void run()
  {
    BaseActivity.access$100().remove(this.val$r);
    if (!this.this$0.isDestroyed()) {
      this.val$r.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivity.4
 * JD-Core Version:    0.7.0.1
 */