package com.tencent.qqmail.search.fragment;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;
import com.tencent.qqmail.utilities.log.QMLog;

class SearchListFragment$12
  implements TextView.OnEditorActionListener
{
  SearchListFragment$12(SearchListFragment paramSearchListFragment) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || (paramInt == 0) || (paramInt == 2))
    {
      QMLog.log(4, "hill-search-keyworld", SearchListFragment.access$1500(this.this$0) + ":" + SearchListFragment.access$800(this.this$0) + ":" + paramTextView.getText() + "::" + SearchListFragment.access$1400(this.this$0).getText());
      SearchListFragment.access$1600(this.this$0);
      if ((SearchListFragment.access$1700(this.this$0) != null) && (SearchListFragment.access$1700(this.this$0).isUsable()) && (SearchListFragment.access$1700(this.this$0).getLocalCount() == 0) && (SearchListFragment.access$1700(this.this$0).canLoadMore())) {
        SearchListFragment.access$1700(this.this$0).loadMore();
      }
      SearchListFragment.access$1800(this.this$0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.12
 * JD-Core Version:    0.7.0.1
 */