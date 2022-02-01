package com.tencent.token;

import android.os.Build.VERSION;
import android.view.View;

public final class jk
{
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramView.setTooltipText(paramCharSequence);
      return;
    }
    jl.a(paramView, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.jk
 * JD-Core Version:    0.7.0.1
 */