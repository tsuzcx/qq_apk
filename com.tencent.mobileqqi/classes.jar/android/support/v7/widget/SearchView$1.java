package android.support.v7.widget;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

class SearchView$1
  implements Runnable
{
  SearchView$1(SearchView paramSearchView) {}
  
  public void run()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.this$0.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      SearchView.HIDDEN_METHOD_INVOKER.showSoftInputUnchecked(localInputMethodManager, this.this$0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.widget.SearchView.1
 * JD-Core Version:    0.7.0.1
 */