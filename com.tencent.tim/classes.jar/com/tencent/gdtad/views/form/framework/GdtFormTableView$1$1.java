package com.tencent.gdtad.views.form.framework;

import android.view.ViewTreeObserver;
import tmb;

public class GdtFormTableView$1$1
  implements Runnable
{
  public GdtFormTableView$1$1(tmb paramtmb) {}
  
  public void run()
  {
    if ((GdtFormTableView.a(this.a.b) != null) && (this.a.b.getViewTreeObserver() != null))
    {
      this.a.b.getViewTreeObserver().removeOnGlobalLayoutListener(GdtFormTableView.a(this.a.b));
      GdtFormTableView.a(this.a.b, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.form.framework.GdtFormTableView.1.1
 * JD-Core Version:    0.7.0.1
 */