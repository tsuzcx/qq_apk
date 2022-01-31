package android.support.v7.internal.widget;

import android.database.DataSetObserver;

class ActivityChooserView$1
  extends DataSetObserver
{
  ActivityChooserView$1(ActivityChooserView paramActivityChooserView) {}
  
  public void onChanged()
  {
    super.onChanged();
    ActivityChooserView.access$000(this.this$0).notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
    ActivityChooserView.access$000(this.this$0).notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserView.1
 * JD-Core Version:    0.7.0.1
 */