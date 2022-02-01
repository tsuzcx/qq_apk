package com.tencent.qqmail.search.fragment;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchNoteListActivity$9
  implements View.OnClickListener
{
  SearchNoteListActivity$9(SearchNoteListActivity paramSearchNoteListActivity) {}
  
  public void onClick(View paramView)
  {
    SearchNoteListActivity.access$800(this.this$0).setFocusable(true);
    SearchNoteListActivity.access$800(this.this$0).setFocusableInTouchMode(true);
    SearchNoteListActivity.access$800(this.this$0).requestFocus();
    ((InputMethodManager)this.this$0.getApplicationContext().getSystemService("input_method")).toggleSoftInput(0, 2);
    Editable localEditable = SearchNoteListActivity.access$800(this.this$0).getText();
    Selection.setSelection(localEditable, localEditable.length());
    SearchNoteListActivity.access$800(this.this$0).setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchNoteListActivity.9
 * JD-Core Version:    0.7.0.1
 */