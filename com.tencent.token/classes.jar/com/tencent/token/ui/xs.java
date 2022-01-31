package com.tencent.token.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class xs
  implements TextView.OnEditorActionListener
{
  xs(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      if (!RealNameStep1InputNameIdActivity.access$500(this.a)) {
        RealNameStep1InputNameIdActivity.access$3200(this.a);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xs
 * JD-Core Version:    0.7.0.1
 */