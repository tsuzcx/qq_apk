package android.support.v4.view;

import android.graphics.Paint;
import android.support.annotation.RequiresApi;
import android.view.Display;
import android.view.View;

@RequiresApi(17)
class ViewCompat$ViewCompatApi17Impl
  extends ViewCompat.ViewCompatApi16Impl
{
  public int generateViewId()
  {
    return View.generateViewId();
  }
  
  public Display getDisplay(View paramView)
  {
    return paramView.getDisplay();
  }
  
  public int getLabelFor(View paramView)
  {
    return paramView.getLabelFor();
  }
  
  public int getLayoutDirection(View paramView)
  {
    return paramView.getLayoutDirection();
  }
  
  public int getPaddingEnd(View paramView)
  {
    return paramView.getPaddingEnd();
  }
  
  public int getPaddingStart(View paramView)
  {
    return paramView.getPaddingStart();
  }
  
  public int getWindowSystemUiVisibility(View paramView)
  {
    return paramView.getWindowSystemUiVisibility();
  }
  
  public boolean isPaddingRelative(View paramView)
  {
    return paramView.isPaddingRelative();
  }
  
  public void setLabelFor(View paramView, int paramInt)
  {
    paramView.setLabelFor(paramInt);
  }
  
  public void setLayerPaint(View paramView, Paint paramPaint)
  {
    paramView.setLayerPaint(paramPaint);
  }
  
  public void setLayoutDirection(View paramView, int paramInt)
  {
    paramView.setLayoutDirection(paramInt);
  }
  
  public void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.ViewCompatApi17Impl
 * JD-Core Version:    0.7.0.1
 */