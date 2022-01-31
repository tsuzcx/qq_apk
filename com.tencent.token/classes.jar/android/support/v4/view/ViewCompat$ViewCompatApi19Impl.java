package android.support.v4.view;

import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(19)
class ViewCompat$ViewCompatApi19Impl
  extends ViewCompat.ViewCompatApi18Impl
{
  public int getAccessibilityLiveRegion(View paramView)
  {
    return paramView.getAccessibilityLiveRegion();
  }
  
  public boolean isAttachedToWindow(View paramView)
  {
    return paramView.isAttachedToWindow();
  }
  
  public boolean isLaidOut(View paramView)
  {
    return paramView.isLaidOut();
  }
  
  public boolean isLayoutDirectionResolved(View paramView)
  {
    return paramView.isLayoutDirectionResolved();
  }
  
  public void setAccessibilityLiveRegion(View paramView, int paramInt)
  {
    paramView.setAccessibilityLiveRegion(paramInt);
  }
  
  public void setImportantForAccessibility(View paramView, int paramInt)
  {
    paramView.setImportantForAccessibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.ViewCompatApi19Impl
 * JD-Core Version:    0.7.0.1
 */