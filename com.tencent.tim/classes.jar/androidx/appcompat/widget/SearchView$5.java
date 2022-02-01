package androidx.appcompat.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchView$5
  implements View.OnClickListener
{
  SearchView$5(SearchView paramSearchView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.this$0.mSearchButton) {
      this.this$0.onSearchClicked();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.this$0.mCloseButton) {
        this.this$0.onCloseClicked();
      } else if (paramView == this.this$0.mGoButton) {
        this.this$0.onSubmitQuery();
      } else if (paramView == this.this$0.mVoiceButton) {
        this.this$0.onVoiceClicked();
      } else if (paramView == this.this$0.mSearchSrcTextView) {
        this.this$0.forceSuggestionQuery();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.SearchView.5
 * JD-Core Version:    0.7.0.1
 */