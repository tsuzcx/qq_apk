package com.tencent.qqmail.search.fragment;

class SearchListAdapter$2
  implements Runnable
{
  SearchListAdapter$2(SearchListAdapter paramSearchListAdapter, Runnable paramRunnable) {}
  
  public void run()
  {
    SearchListAdapter.access$002(this.this$0, null);
    this.this$0.setMoreLoading(false);
    this.this$0.notifyDataSetChanged();
    if (this.val$afterRefresh != null) {
      this.val$afterRefresh.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListAdapter.2
 * JD-Core Version:    0.7.0.1
 */