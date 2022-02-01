package com.tencent.mobileqq.portal;

import akze;
import com.tencent.widget.HongBaoListView;

public class ConversationHongBao$1
  implements Runnable
{
  public ConversationHongBao$1(akze paramakze) {}
  
  public void run()
  {
    if (this.this$0.a.getScrollY() == 0) {}
    for (;;)
    {
      return;
      if (this.this$0.mState == 4)
      {
        this.this$0.a.setSpringbackOffset(-this.this$0.dqo);
        if (Math.abs(this.this$0.a.getScrollY() + this.this$0.dqo) > this.this$0.dqo * 1.0F / 13.0F) {
          this.this$0.a.springBackTo(-this.this$0.dqo);
        }
      }
      while (!this.this$0.a.dkA)
      {
        this.this$0.GJ(false);
        return;
        this.this$0.a.setSpringbackOffset(0);
        if (this.this$0.a.getScrollY() != 0) {
          this.this$0.a.springBackTo(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBao.1
 * JD-Core Version:    0.7.0.1
 */