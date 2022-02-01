package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.animation.ListViewRemoveItemAnimator;
import com.tencent.qqmail.model.uidomain.MailOperate;
import java.util.HashMap;

class ConvMailListFragment$9$1
  implements Runnable
{
  ConvMailListFragment$9$1(ConvMailListFragment.9 param9, long[] paramArrayOfLong) {}
  
  public void run()
  {
    if (ConvMailListFragment.access$1400(this.this$1.this$0).canHandleDelete(this.val$mailIds)) {
      ListViewRemoveItemAnimator.animateRemoval(ConvMailListFragment.access$1600(this.this$1.this$0), ConvMailListFragment.access$1700(this.this$1.this$0).keySet(), new ConvMailListFragment.9.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.9.1
 * JD-Core Version:    0.7.0.1
 */