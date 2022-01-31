package com.tencent.token.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class uz
  implements TextView.OnEditorActionListener
{
  uz(RealNameFindActivity paramRealNameFindActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      if (!RealNameFindActivity.access$300(this.a)) {
        RealNameFindActivity.access$3100(this.a);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.uz
 * JD-Core Version:    0.7.0.1
 */