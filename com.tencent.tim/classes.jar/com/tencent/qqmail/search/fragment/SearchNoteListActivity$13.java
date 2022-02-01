package com.tencent.qqmail.search.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;
import com.tencent.qqmail.search.view.SearchToggleView;

class SearchNoteListActivity$13
  implements TextWatcher
{
  SearchNoteListActivity$13(SearchNoteListActivity paramSearchNoteListActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.toString().length() > 0)
    {
      SearchNoteListActivity.access$1200(this.this$0).setVisibility(0);
      this.this$0.renderLocalSearch(paramCharSequence.toString());
      return;
    }
    SearchNoteListActivity.access$1200(this.this$0).setVisibility(8);
    SearchNoteListActivity.access$700(this.this$0).show();
    this.this$0.readDataSourceByCid(SearchNoteListActivity.access$1300(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchNoteListActivity.13
 * JD-Core Version:    0.7.0.1
 */