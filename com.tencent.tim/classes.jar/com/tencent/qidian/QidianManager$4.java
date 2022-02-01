package com.tencent.qidian;

import asgx;
import com.tencent.common.app.AppInterface;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.BaseApplication;

public class QidianManager$4
  implements Runnable
{
  public QidianManager$4(asgx paramasgx, String paramString) {}
  
  public void run()
  {
    this.this$0.b(this.this$0.app.getApp().getBaseContext(), new BmqqAccountType(this.val$uin, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianManager.4
 * JD-Core Version:    0.7.0.1
 */