package com.tencent.token;

import android.os.Build.VERSION;
import android.view.View;

public final class jy
{
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramView.setTooltipText(paramCharSequence);
      return;
    }
    jz.a(paramView, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.jy
 * JD-Core Version:    0.7.0.1
 */