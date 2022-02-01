package com.tencent.qqmail.search.fragment;

import android.text.Editable;
import android.text.Selection;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

class SearchListFragment$11
  implements View.OnTouchListener
{
  SearchListFragment$11(SearchListFragment paramSearchListFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      paramView = SearchListFragment.access$1400(this.this$0).getText();
      Selection.setSelection(paramView, paramView.length());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.11
 * JD-Core Version:    0.7.0.1
 */