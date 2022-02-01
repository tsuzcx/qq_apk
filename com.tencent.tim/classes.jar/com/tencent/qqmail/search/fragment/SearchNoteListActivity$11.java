package com.tencent.qqmail.search.fragment;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class SearchNoteListActivity$11
  implements View.OnTouchListener
{
  SearchNoteListActivity$11(SearchNoteListActivity paramSearchNoteListActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      SearchNoteListActivity.access$800(this.this$0).setFocusable(true);
      SearchNoteListActivity.access$800(this.this$0).setFocusableInTouchMode(true);
      SearchNoteListActivity.access$800(this.this$0).requestFocus();
      ((InputMethodManager)this.this$0.getApplicationContext().getSystemService("input_method")).showSoftInput(paramView, 2);
      paramView = SearchNoteListActivity.access$800(this.this$0).getText();
      Selection.setSelection(paramView, paramView.length());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchNoteListActivity.11
 * JD-Core Version:    0.7.0.1
 */