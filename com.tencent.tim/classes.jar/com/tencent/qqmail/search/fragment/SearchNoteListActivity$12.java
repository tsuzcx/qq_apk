package com.tencent.qqmail.search.fragment;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;

class SearchNoteListActivity$12
  implements TextView.OnEditorActionListener
{
  SearchNoteListActivity$12(SearchNoteListActivity paramSearchNoteListActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((SearchNoteListActivity.access$900(this.this$0, paramInt)) || (SearchNoteListActivity.access$1000(this.this$0, paramInt)) || (SearchNoteListActivity.access$1100(this.this$0, paramInt)))
    {
      SearchNoteListActivity.access$602(this.this$0, true);
      KeyBoardHelper.hideKeyBoard(SearchNoteListActivity.access$800(this.this$0));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchNoteListActivity.12
 * JD-Core Version:    0.7.0.1
 */