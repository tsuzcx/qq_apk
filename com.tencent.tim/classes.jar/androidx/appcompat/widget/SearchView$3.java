package androidx.appcompat.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class SearchView$3
  implements View.OnFocusChangeListener
{
  SearchView$3(SearchView paramSearchView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (this.this$0.mOnQueryTextFocusChangeListener != null) {
      this.this$0.mOnQueryTextFocusChangeListener.onFocusChange(this.this$0, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.SearchView.3
 * JD-Core Version:    0.7.0.1
 */