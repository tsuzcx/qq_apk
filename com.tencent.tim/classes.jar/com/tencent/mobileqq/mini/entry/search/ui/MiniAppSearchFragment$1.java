package com.tencent.mobileqq.mini.entry.search.ui;

import android.support.v4.app.FragmentActivity;
import android.view.inputmethod.InputMethodManager;

class MiniAppSearchFragment$1
  implements Runnable
{
  MiniAppSearchFragment$1(MiniAppSearchFragment paramMiniAppSearchFragment) {}
  
  public void run()
  {
    if (this.this$0.getActivity() != null) {
      ((InputMethodManager)this.this$0.getActivity().getSystemService("input_method")).showSoftInput(MiniAppSearchFragment.access$000(this.this$0), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.1
 * JD-Core Version:    0.7.0.1
 */