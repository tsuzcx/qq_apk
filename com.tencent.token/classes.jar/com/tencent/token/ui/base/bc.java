package com.tencent.token.ui.base;

import android.database.DataSetObserver;

final class bc
  extends DataSetObserver
{
  bc(HorizontialListView paramHorizontialListView) {}
  
  public final void onChanged()
  {
    synchronized (this.a)
    {
      HorizontialListView.a(this.a);
      this.a.invalidate();
      this.a.requestLayout();
      return;
    }
  }
  
  public final void onInvalidated()
  {
    HorizontialListView.b(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bc
 * JD-Core Version:    0.7.0.1
 */