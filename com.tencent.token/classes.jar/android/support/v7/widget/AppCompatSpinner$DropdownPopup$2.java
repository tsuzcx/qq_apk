package android.support.v7.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class AppCompatSpinner$DropdownPopup$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AppCompatSpinner$DropdownPopup$2(AppCompatSpinner.DropdownPopup paramDropdownPopup) {}
  
  public void onGlobalLayout()
  {
    if (!this.this$1.isVisibleToUser(this.this$1.this$0))
    {
      this.this$1.dismiss();
      return;
    }
    this.this$1.computeContentWidth();
    AppCompatSpinner.DropdownPopup.access$301(this.this$1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatSpinner.DropdownPopup.2
 * JD-Core Version:    0.7.0.1
 */