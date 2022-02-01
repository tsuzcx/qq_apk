package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.view.FolderLockDialog;
import java.util.HashMap;

class MailListFragment$48$1
  implements Runnable
{
  MailListFragment$48$1(MailListFragment.48 param48, int paramInt) {}
  
  public void run()
  {
    MailListFragment.access$8400(this.this$1.this$0).remove(Integer.valueOf(this.val$accountId));
    MailListFragment.access$2500(this.this$1.this$0).cancelDialog();
    MailListFragment.access$2500(this.this$1.this$0).dismissTips();
    if (MailListFragment.access$2700(this.this$1.this$0) != null) {
      this.this$1.this$0.startFragment(MailListFragment.access$2700(this.this$1.this$0));
    }
    while (MailListFragment.access$200(this.this$1.this$0) == null) {
      return;
    }
    MailListFragment.access$200(this.this$1.this$0).update();
    MailListFragment.access$200(this.this$1.this$0).refresh(true, new MailListFragment.48.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.48.1
 * JD-Core Version:    0.7.0.1
 */