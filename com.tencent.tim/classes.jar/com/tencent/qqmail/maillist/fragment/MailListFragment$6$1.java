package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.animation.ListViewRemoveItemAnimator;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.HashMap;

class MailListFragment$6$1
  implements Runnable
{
  MailListFragment$6$1(MailListFragment.6 param6, long[] paramArrayOfLong) {}
  
  public void run()
  {
    if (MailListFragment.access$5900(this.this$1.this$0)) {
      this.this$1.this$0.getTips().hide();
    }
    MailListFragment.access$5902(this.this$1.this$0, false);
    if (MailListFragment.access$2900(this.this$1.this$0).canHandleDelete(this.val$mailIds)) {
      ListViewRemoveItemAnimator.animateRemoval(MailListFragment.access$000(this.this$1.this$0), MailListFragment.access$400(this.this$1.this$0).keySet(), new MailListFragment.6.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.6.1
 * JD-Core Version:    0.7.0.1
 */