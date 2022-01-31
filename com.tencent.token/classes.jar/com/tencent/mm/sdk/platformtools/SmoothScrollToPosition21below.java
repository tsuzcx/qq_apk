package com.tencent.mm.sdk.platformtools;

import android.widget.ListView;

class SmoothScrollToPosition21below
  implements BackwardSupportUtil.SmoothScrollFactory.IScroll
{
  public void doScroll(ListView paramListView)
  {
    paramListView.setSelection(0);
  }
  
  public void doScroll(ListView paramListView, int paramInt)
  {
    paramListView.setSelection(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SmoothScrollToPosition21below
 * JD-Core Version:    0.7.0.1
 */