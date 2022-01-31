package com.tencent.token.ui.base;

import android.database.DataSetObserver;

class be
  extends DataSetObserver
{
  be(HorizontialListView paramHorizontialListView) {}
  
  public void onChanged()
  {
    synchronized (this.a)
    {
      HorizontialListView.a(this.a, true);
      this.a.invalidate();
      this.a.requestLayout();
      return;
    }
  }
  
  public void onInvalidated()
  {
    HorizontialListView.a(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.be
 * JD-Core Version:    0.7.0.1
 */