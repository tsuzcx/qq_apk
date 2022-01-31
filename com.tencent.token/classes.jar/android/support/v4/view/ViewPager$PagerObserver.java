package android.support.v4.view;

import android.database.DataSetObserver;

class ViewPager$PagerObserver
  extends DataSetObserver
{
  ViewPager$PagerObserver(ViewPager paramViewPager) {}
  
  public void onChanged()
  {
    this.this$0.dataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.this$0.dataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewPager.PagerObserver
 * JD-Core Version:    0.7.0.1
 */