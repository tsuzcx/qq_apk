package com.tencent.qqmail.search.fragment;

import android.widget.EditText;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;

class SearchNoteListActivity$10
  implements Runnable
{
  SearchNoteListActivity$10(SearchNoteListActivity paramSearchNoteListActivity) {}
  
  public void run()
  {
    SearchNoteListActivity.access$800(this.this$0).requestFocus();
    KeyBoardHelper.showKeyBoard(SearchNoteListActivity.access$800(this.this$0), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchNoteListActivity.10
 * JD-Core Version:    0.7.0.1
 */