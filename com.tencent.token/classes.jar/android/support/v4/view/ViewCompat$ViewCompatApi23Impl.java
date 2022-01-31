package android.support.v4.view;

import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(23)
class ViewCompat$ViewCompatApi23Impl
  extends ViewCompat.ViewCompatApi21Impl
{
  public int getScrollIndicators(View paramView)
  {
    return paramView.getScrollIndicators();
  }
  
  public void offsetLeftAndRight(View paramView, int paramInt)
  {
    paramView.offsetLeftAndRight(paramInt);
  }
  
  public void offsetTopAndBottom(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
  }
  
  public void setScrollIndicators(View paramView, int paramInt)
  {
    paramView.setScrollIndicators(paramInt);
  }
  
  public void setScrollIndicators(View paramView, int paramInt1, int paramInt2)
  {
    paramView.setScrollIndicators(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.ViewCompatApi23Impl
 * JD-Core Version:    0.7.0.1
 */