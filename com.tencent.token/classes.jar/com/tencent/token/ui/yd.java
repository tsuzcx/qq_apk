package com.tencent.token.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class yd
  implements TextView.OnEditorActionListener
{
  yd(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      if (!RealNameStep1InputNameIdActivity.access$500(this.a)) {
        RealNameStep1InputNameIdActivity.access$2900(this.a);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yd
 * JD-Core Version:    0.7.0.1
 */