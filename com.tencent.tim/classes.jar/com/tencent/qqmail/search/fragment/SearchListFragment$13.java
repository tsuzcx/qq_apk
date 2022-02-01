package com.tencent.qqmail.search.fragment;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

class SearchListFragment$13
  implements TextWatcher
{
  SearchListFragment$13(SearchListFragment paramSearchListFragment, ImageButton paramImageButton) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    String str = SearchListFragment.access$1900(this.this$0);
    SearchListFragment.access$1902(this.this$0, paramCharSequence.toString());
    SearchListFragment.access$2002(this.this$0, true);
    if (!SearchListFragment.access$2100(this.this$0)) {}
    for (paramInt1 = 400;; paramInt1 = 0)
    {
      SearchListFragment.access$2300(this.this$0).removeCallbacks(SearchListFragment.access$2200(this.this$0));
      SearchListFragment.access$2300(this.this$0).postDelayed(SearchListFragment.access$2200(this.this$0), paramInt1);
      if (SearchListFragment.access$1900(this.this$0).length() > 0)
      {
        this.val$searchBarInputCleaner.setVisibility(0);
        SearchListFragment.access$2400(this.this$0).setVisibility(0);
        paramCharSequence = this.this$0;
        if ((SearchListFragment.access$1900(this.this$0).length() <= 0) && ((str == null) || (str.length() == 0))) {
          break label210;
        }
        bool1 = true;
        label152:
        SearchListFragment.access$2502(paramCharSequence, bool1);
        paramCharSequence = this.this$0;
        if (SearchListFragment.access$1900(this.this$0).equals(str)) {
          break label216;
        }
      }
      label210:
      label216:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        SearchListFragment.access$2602(paramCharSequence, bool1);
        SearchListFragment.access$2700(this.this$0);
        return;
        this.val$searchBarInputCleaner.setVisibility(8);
        break;
        bool1 = false;
        break label152;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.13
 * JD-Core Version:    0.7.0.1
 */