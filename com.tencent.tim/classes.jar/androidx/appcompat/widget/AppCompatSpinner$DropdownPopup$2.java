package androidx.appcompat.widget;

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
    AppCompatSpinner.DropdownPopup.access$001(this.this$1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.2
 * JD-Core Version:    0.7.0.1
 */