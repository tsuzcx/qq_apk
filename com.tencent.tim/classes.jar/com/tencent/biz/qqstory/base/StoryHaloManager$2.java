package com.tencent.biz.qqstory.base;

import android.view.View;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import pmj;
import puh;

public class StoryHaloManager$2
  implements Runnable
{
  public StoryHaloManager$2(pmj parampmj, RecentItemChatMsgData paramRecentItemChatMsgData, View paramView) {}
  
  public void run()
  {
    puh localpuh = this.this$0.a(this.b.qx());
    if (localpuh == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new StoryHaloManager.2.1(this, localpuh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryHaloManager.2
 * JD-Core Version:    0.7.0.1
 */