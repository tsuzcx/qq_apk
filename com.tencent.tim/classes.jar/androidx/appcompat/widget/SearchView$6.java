package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class SearchView$6
  implements View.OnKeyListener
{
  SearchView$6(SearchView paramSearchView) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.this$0.mSearchable == null) {}
    do
    {
      return false;
      if ((this.this$0.mSearchSrcTextView.isPopupShowing()) && (this.this$0.mSearchSrcTextView.getListSelection() != -1)) {
        return this.this$0.onSuggestionsKey(paramView, paramInt, paramKeyEvent);
      }
    } while ((this.this$0.mSearchSrcTextView.isEmpty()) || (!paramKeyEvent.hasNoModifiers()) || (paramKeyEvent.getAction() != 1) || (paramInt != 66));
    paramView.cancelLongPress();
    this.this$0.launchQuerySearch(0, null, this.this$0.mSearchSrcTextView.getText().toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.SearchView.6
 * JD-Core Version:    0.7.0.1
 */