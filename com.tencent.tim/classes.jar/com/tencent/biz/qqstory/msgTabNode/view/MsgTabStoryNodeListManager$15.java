package com.tencent.biz.qqstory.msgTabNode.view;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import pvz;

public class MsgTabStoryNodeListManager$15
  implements Runnable
{
  public void run()
  {
    if (this.this$0.mLastScrollState == 0)
    {
      if (pvz.a(this.this$0)) {
        this.this$0.dp = null;
      }
      return;
    }
    ThreadManager.getUIHandler().post(this.this$0.dp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.15
 * JD-Core Version:    0.7.0.1
 */