package com.tencent.qidian;

import asgx;
import com.tencent.common.app.AppInterface;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QidianManager$7
  implements Runnable
{
  public QidianManager$7(asgx paramasgx, String paramString) {}
  
  public void run()
  {
    this.this$0.b(this.this$0.app.getApp().getBaseContext(), new BmqqAccountType(this.val$uin, 6));
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "isQidianMaster get user detail in main thread");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianManager.7
 * JD-Core Version:    0.7.0.1
 */