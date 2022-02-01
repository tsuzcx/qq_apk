package com.tencent.qqmail.search.fragment;

class SearchListFragment$1$1
  implements Runnable
{
  SearchListFragment$1$1(SearchListFragment.1 param1, long[] paramArrayOfLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$mailId.length > 0)
    {
      SearchListFragment.access$002(this.this$1.this$0, this.val$isRunning);
      SearchListFragment.access$100(this.this$1.this$0).setMoreLoading(this.val$isRunning);
      SearchListFragment.access$100(this.this$1.this$0).setError(false);
      SearchListFragment.access$100(this.this$1.this$0).updateRemote(false);
      SearchListFragment.access$100(this.this$1.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.1.1
 * JD-Core Version:    0.7.0.1
 */