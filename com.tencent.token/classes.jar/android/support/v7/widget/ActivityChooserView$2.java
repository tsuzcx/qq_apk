package android.support.v7.widget;

import android.support.v4.view.ActionProvider;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ActivityChooserView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ActivityChooserView$2(ActivityChooserView paramActivityChooserView) {}
  
  public void onGlobalLayout()
  {
    if (this.this$0.isShowingPopup())
    {
      if (this.this$0.isShown()) {
        break label31;
      }
      this.this$0.getListPopupWindow().dismiss();
    }
    label31:
    do
    {
      return;
      this.this$0.getListPopupWindow().show();
    } while (this.this$0.mProvider == null);
    this.this$0.mProvider.subUiVisibilityChanged(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.2
 * JD-Core Version:    0.7.0.1
 */