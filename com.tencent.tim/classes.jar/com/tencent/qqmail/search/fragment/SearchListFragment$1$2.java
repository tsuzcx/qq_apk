package com.tencent.qqmail.search.fragment;

class SearchListFragment$1$2
  implements Runnable
{
  SearchListFragment$1$2(SearchListFragment.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.val$isRunning)
    {
      SearchListFragment.access$002(this.this$1.this$0, false);
      SearchListFragment.access$100(this.this$1.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.1.2
 * JD-Core Version:    0.7.0.1
 */