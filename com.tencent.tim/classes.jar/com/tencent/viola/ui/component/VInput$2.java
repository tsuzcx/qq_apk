package com.tencent.viola.ui.component;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class VInput$2
  implements View.OnFocusChangeListener
{
  VInput$2(VInput paramVInput) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.this$0.inputFireEvent("focus", null);
    }
    do
    {
      return;
      this.this$0.inputFireEvent("blur", null);
    } while (VInput.access$000(this.this$0).equals(VInput.access$100(this.this$0)));
    this.this$0.inputFireEvent("change", VInput.access$000(this.this$0));
    VInput.access$102(this.this$0, VInput.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.component.VInput.2
 * JD-Core Version:    0.7.0.1
 */