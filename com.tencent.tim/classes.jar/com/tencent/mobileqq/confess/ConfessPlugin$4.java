package com.tencent.mobileqq.confess;

import com.tencent.qphone.base.util.QLog;

class ConfessPlugin$4
  implements Runnable
{
  ConfessPlugin$4(ConfessPlugin paramConfessPlugin) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPlugin", 4, "mProcessShareRunable mLastShareData:" + this.this$0.bs + " mHeaderLoader:" + this.this$0.b);
    }
    if ((this.this$0.bs == null) || (this.this$0.b == null)) {
      return;
    }
    ConfessPlugin.a(this.this$0, this.this$0.bs);
    this.this$0.bs = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin.4
 * JD-Core Version:    0.7.0.1
 */