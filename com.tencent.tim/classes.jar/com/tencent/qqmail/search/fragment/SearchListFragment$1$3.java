package com.tencent.qqmail.search.fragment;

class SearchListFragment$1$3
  implements Runnable
{
  SearchListFragment$1$3(SearchListFragment.1 param1) {}
  
  public void run()
  {
    SearchListFragment.access$002(this.this$1.this$0, true);
    SearchListFragment.access$100(this.this$1.this$0).setError(false);
    SearchListFragment.access$100(this.this$1.this$0).setMoreLoading(false);
    SearchListFragment.access$100(this.this$1.this$0).updateRemote(true);
    SearchListFragment.access$100(this.this$1.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.1.3
 * JD-Core Version:    0.7.0.1
 */