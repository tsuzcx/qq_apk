package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.view.FolderLockDialog;

class SearchListFragment$23$1
  implements Runnable
{
  SearchListFragment$23$1(SearchListFragment.23 param23, int paramInt) {}
  
  public void run()
  {
    SearchListFragment.access$4400(this.this$1.this$0, this.val$accountId);
    SearchListFragment.access$900(this.this$1.this$0);
    if (SearchListFragment.access$4500(this.this$1.this$0) != null)
    {
      SearchListFragment.access$4500(this.this$1.this$0).cancelDialog();
      SearchListFragment.access$4500(this.this$1.this$0).dismissTips();
    }
    SearchListFragment.access$4600(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.23.1
 * JD-Core Version:    0.7.0.1
 */