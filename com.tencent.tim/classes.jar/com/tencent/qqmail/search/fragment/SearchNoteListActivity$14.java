package com.tencent.qqmail.search.fragment;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import com.tencent.qqmail.search.view.SearchToggleView;

class SearchNoteListActivity$14
  implements Runnable
{
  SearchNoteListActivity$14(SearchNoteListActivity paramSearchNoteListActivity) {}
  
  public void run()
  {
    SearchNoteListActivity.access$800(this.this$0).setVisibility(0);
    SearchNoteListActivity.access$800(this.this$0).setText("");
    SearchNoteListActivity.access$1200(this.this$0).setVisibility(8);
    this.this$0.hideKeyBoard();
    SearchNoteListActivity.access$700(this.this$0).hide();
    SearchNoteListActivity.access$1400(this.this$0).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchNoteListActivity.14
 * JD-Core Version:    0.7.0.1
 */