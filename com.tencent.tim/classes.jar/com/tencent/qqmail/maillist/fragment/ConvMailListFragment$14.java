package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.maillist.ListViewHelper.OnHandleNextUnread;
import com.tencent.qqmail.view.QMBaseView;

class ConvMailListFragment$14
  implements ListViewHelper.OnHandleNextUnread
{
  ConvMailListFragment$14(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onFoundUnread(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1)
    {
      ConvMailListFragment.access$2100(this.this$0).scrollToTop();
      return;
    }
    ConvMailListFragment.access$2100(this.this$0).scrollToPosition(paramInt1);
  }
  
  public boolean onReachEnd(int paramInt)
  {
    ConvMailListFragment.access$2100(this.this$0).scrollToTop();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.14
 * JD-Core Version:    0.7.0.1
 */