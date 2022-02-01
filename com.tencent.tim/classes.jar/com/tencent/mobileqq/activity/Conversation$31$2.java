package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import usm;

public class Conversation$31$2
  implements Runnable
{
  public Conversation$31$2(usm paramusm, boolean paramBoolean) {}
  
  public void run()
  {
    Conversation.a(this.a.this$0, 800L);
    PullRefreshHeader localPullRefreshHeader;
    if (this.a.this$0.f != null)
    {
      localPullRefreshHeader = this.a.this$0.f;
      if (!this.val$isSuccess) {
        break label66;
      }
    }
    label66:
    for (int i = 0;; i = 2)
    {
      localPullRefreshHeader.tT(i);
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ConversationTab[onRefleshRecentListFinished_ui]");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.31.2
 * JD-Core Version:    0.7.0.1
 */