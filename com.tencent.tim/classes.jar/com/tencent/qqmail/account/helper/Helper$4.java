package com.tencent.qqmail.account.helper;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageButton;

final class Helper$4
  implements View.OnFocusChangeListener
{
  Helper$4(ImageButton paramImageButton) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.val$passwordStateButton.setVisibility(0);
      return;
    }
    this.val$passwordStateButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.Helper.4
 * JD-Core Version:    0.7.0.1
 */