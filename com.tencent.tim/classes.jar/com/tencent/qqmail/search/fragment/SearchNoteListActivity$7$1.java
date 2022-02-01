package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.search.view.SearchToggleView;

class SearchNoteListActivity$7$1
  implements Runnable
{
  SearchNoteListActivity$7$1(SearchNoteListActivity.7 param7) {}
  
  public void run()
  {
    this.this$1.this$0.setLoading(false);
    this.this$1.this$0.mergeRender();
    if (SearchNoteListActivity.access$600(this.this$1.this$0))
    {
      SearchNoteListActivity.access$700(this.this$1.this$0).hide();
      SearchNoteListActivity.access$602(this.this$1.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchNoteListActivity.7.1
 * JD-Core Version:    0.7.0.1
 */