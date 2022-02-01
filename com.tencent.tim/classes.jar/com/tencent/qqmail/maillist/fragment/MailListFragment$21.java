package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.maillist.ListViewHelper.OnHandleNextUnread;
import com.tencent.qqmail.view.QMBaseView;

class MailListFragment$21
  implements ListViewHelper.OnHandleNextUnread
{
  MailListFragment$21(MailListFragment paramMailListFragment) {}
  
  public void onFoundUnread(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1)
    {
      MailListFragment.access$7100(this.this$0).scrollToTop();
      return;
    }
    MailListFragment.access$7100(this.this$0).scrollToPosition(paramInt1);
  }
  
  public boolean onReachEnd(int paramInt)
  {
    MailListFragment.access$7100(this.this$0).scrollToTop();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.21
 * JD-Core Version:    0.7.0.1
 */