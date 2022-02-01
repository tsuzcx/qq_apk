package com.tencent.qqmail.search.fragment;

import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;

class SearchListFragment$10
  implements View.OnClickListener
{
  SearchListFragment$10(SearchListFragment paramSearchListFragment) {}
  
  public void onClick(View paramView)
  {
    Editable localEditable = SearchListFragment.access$1400(this.this$0).getText();
    Selection.setSelection(localEditable, localEditable.length());
    SearchListFragment.access$1400(this.this$0).setText("");
    KeyBoardHelper.showKeyBoard(SearchListFragment.access$1400(this.this$0), 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.10
 * JD-Core Version:    0.7.0.1
 */