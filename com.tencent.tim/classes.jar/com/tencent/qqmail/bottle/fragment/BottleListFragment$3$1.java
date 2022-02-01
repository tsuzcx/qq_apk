package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.maillist.ListViewHelper.OnHandleNextUnread;

class BottleListFragment$3$1
  implements ListViewHelper.OnHandleNextUnread
{
  BottleListFragment$3$1(BottleListFragment.3 param3) {}
  
  public void onFoundUnread(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1)
    {
      ListViewHelper.scrollToTop(this.this$1.this$0.getActivity(), BottleListFragment.access$200(this.this$1.this$0));
      return;
    }
    ListViewHelper.scrollToPosition(BottleListFragment.access$200(this.this$1.this$0), paramInt1);
  }
  
  public boolean onReachEnd(int paramInt)
  {
    ListViewHelper.scrollToTop(this.this$1.this$0.getActivity(), BottleListFragment.access$200(this.this$1.this$0));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleListFragment.3.1
 * JD-Core Version:    0.7.0.1
 */