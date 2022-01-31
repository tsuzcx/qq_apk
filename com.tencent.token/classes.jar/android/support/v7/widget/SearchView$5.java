package android.support.v7.widget;

import android.view.View;
import android.view.View.OnClickListener;

class SearchView$5
  implements View.OnClickListener
{
  SearchView$5(SearchView paramSearchView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.this$0.mSearchButton) {
      this.this$0.onSearchClicked();
    }
    do
    {
      return;
      if (paramView == this.this$0.mCloseButton)
      {
        this.this$0.onCloseClicked();
        return;
      }
      if (paramView == this.this$0.mGoButton)
      {
        this.this$0.onSubmitQuery();
        return;
      }
      if (paramView == this.this$0.mVoiceButton)
      {
        this.this$0.onVoiceClicked();
        return;
      }
    } while (paramView != this.this$0.mSearchSrcTextView);
    this.this$0.forceSuggestionQuery();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.SearchView.5
 * JD-Core Version:    0.7.0.1
 */