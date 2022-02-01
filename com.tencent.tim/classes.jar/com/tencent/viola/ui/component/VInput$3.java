package com.tencent.viola.ui.component;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class VInput$3
  implements View.OnKeyListener
{
  VInput$3(VInput paramVInput) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 66) && (paramKeyEvent.getAction() == 1))
    {
      this.this$0.inputFireEvent("return", VInput.access$100(this.this$0).toString());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.component.VInput.3
 * JD-Core Version:    0.7.0.1
 */