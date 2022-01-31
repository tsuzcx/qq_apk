package android.support.v7.widget;

import android.support.v4.widget.CursorAdapter;

class SearchView$2
  implements Runnable
{
  SearchView$2(SearchView paramSearchView) {}
  
  public void run()
  {
    if ((this.this$0.mSuggestionsAdapter != null) && ((this.this$0.mSuggestionsAdapter instanceof SuggestionsAdapter))) {
      this.this$0.mSuggestionsAdapter.changeCursor(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.SearchView.2
 * JD-Core Version:    0.7.0.1
 */