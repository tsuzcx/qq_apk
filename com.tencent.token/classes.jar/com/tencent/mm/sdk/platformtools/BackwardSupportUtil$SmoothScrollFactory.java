package com.tencent.mm.sdk.platformtools;

import android.os.Build.VERSION;
import android.widget.ListView;

public class BackwardSupportUtil$SmoothScrollFactory
{
  public static void scrollTo(ListView paramListView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      new SmoothScrollToPosition22().doScroll(paramListView, paramInt);
      return;
    }
    new SmoothScrollToPosition21below().doScroll(paramListView, paramInt);
  }
  
  public static void scrollToTop(ListView paramListView)
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      new SmoothScrollToPosition22().doScroll(paramListView);
      return;
    }
    new SmoothScrollToPosition21below().doScroll(paramListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory
 * JD-Core Version:    0.7.0.1
 */