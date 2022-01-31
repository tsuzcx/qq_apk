package android.support.v7.internal.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AdapterViewICS$OnItemClickListenerWrapper
  implements AdapterView.OnItemClickListener
{
  private final AdapterViewICS.OnItemClickListener mWrappedListener;
  
  public AdapterViewICS$OnItemClickListenerWrapper(AdapterViewICS paramAdapterViewICS, AdapterViewICS.OnItemClickListener paramOnItemClickListener)
  {
    this.mWrappedListener = paramOnItemClickListener;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.mWrappedListener.onItemClick(this.this$0, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.AdapterViewICS.OnItemClickListenerWrapper
 * JD-Core Version:    0.7.0.1
 */