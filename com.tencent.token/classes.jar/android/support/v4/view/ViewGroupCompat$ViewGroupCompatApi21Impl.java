package android.support.v4.view;

import android.support.annotation.RequiresApi;
import android.view.ViewGroup;

@RequiresApi(21)
class ViewGroupCompat$ViewGroupCompatApi21Impl
  extends ViewGroupCompat.ViewGroupCompatApi18Impl
{
  public int getNestedScrollAxes(ViewGroup paramViewGroup)
  {
    return paramViewGroup.getNestedScrollAxes();
  }
  
  public boolean isTransitionGroup(ViewGroup paramViewGroup)
  {
    return paramViewGroup.isTransitionGroup();
  }
  
  public void setTransitionGroup(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramViewGroup.setTransitionGroup(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewGroupCompat.ViewGroupCompatApi21Impl
 * JD-Core Version:    0.7.0.1
 */