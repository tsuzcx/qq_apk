package android.support.v7.widget;

import android.database.DataSetObserver;

class ActivityChooserView$1
  extends DataSetObserver
{
  ActivityChooserView$1(ActivityChooserView paramActivityChooserView) {}
  
  public void onChanged()
  {
    super.onChanged();
    this.this$0.mAdapter.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
    this.this$0.mAdapter.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.1
 * JD-Core Version:    0.7.0.1
 */