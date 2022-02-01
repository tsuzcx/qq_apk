package com.tencent.qqmail.search.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.maillist.view.MailListMoreItemView;
import com.tencent.qqmail.view.QMListItemView;

class SearchNoteListActivity$15
  implements AdapterView.OnItemClickListener
{
  SearchNoteListActivity$15(SearchNoteListActivity paramSearchNoteListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramView instanceof QMListItemView)) {
      SearchNoteListActivity.access$1500(this.this$0, paramView, paramInt);
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      String str = SearchNoteListActivity.access$800(this.this$0).getText().toString();
      SearchNoteListActivity.access$1600(this.this$0, str);
      ((MailListMoreItemView)paramView).showLoading(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchNoteListActivity.15
 * JD-Core Version:    0.7.0.1
 */