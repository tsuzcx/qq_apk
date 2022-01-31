package android.support.v7.widget;

import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class SearchView$8
  implements View.OnKeyListener
{
  SearchView$8(SearchView paramSearchView) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (SearchView.access$1400(this.this$0) == null) {}
    do
    {
      return false;
      if ((SearchView.access$1200(this.this$0).isPopupShowing()) && (SearchView.access$1200(this.this$0).getListSelection() != -1)) {
        return SearchView.access$1500(this.this$0, paramView, paramInt, paramKeyEvent);
      }
    } while ((SearchView.SearchAutoComplete.access$1600(SearchView.access$1200(this.this$0))) || (!KeyEventCompat.hasNoModifiers(paramKeyEvent)) || (paramKeyEvent.getAction() != 1) || (paramInt != 66));
    paramView.cancelLongPress();
    SearchView.access$1700(this.this$0, 0, null, SearchView.access$1200(this.this$0).getText().toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.widget.SearchView.8
 * JD-Core Version:    0.7.0.1
 */