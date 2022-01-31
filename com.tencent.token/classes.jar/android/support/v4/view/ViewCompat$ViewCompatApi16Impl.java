package android.support.v4.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewParent;

@RequiresApi(16)
class ViewCompat$ViewCompatApi16Impl
  extends ViewCompat.ViewCompatApi15Impl
{
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    paramView = paramView.getAccessibilityNodeProvider();
    if (paramView != null) {
      return new AccessibilityNodeProviderCompat(paramView);
    }
    return null;
  }
  
  public boolean getFitsSystemWindows(View paramView)
  {
    return paramView.getFitsSystemWindows();
  }
  
  public int getImportantForAccessibility(View paramView)
  {
    return paramView.getImportantForAccessibility();
  }
  
  public int getMinimumHeight(View paramView)
  {
    return paramView.getMinimumHeight();
  }
  
  public int getMinimumWidth(View paramView)
  {
    return paramView.getMinimumWidth();
  }
  
  public ViewParent getParentForAccessibility(View paramView)
  {
    return paramView.getParentForAccessibility();
  }
  
  public boolean hasOverlappingRendering(View paramView)
  {
    return paramView.hasOverlappingRendering();
  }
  
  public boolean hasTransientState(View paramView)
  {
    return paramView.hasTransientState();
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return paramView.performAccessibilityAction(paramInt, paramBundle);
  }
  
  public void postInvalidateOnAnimation(View paramView)
  {
    paramView.postInvalidateOnAnimation();
  }
  
  public void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.postInvalidateOnAnimation(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
  
  public void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postOnAnimationDelayed(paramRunnable, paramLong);
  }
  
  public void requestApplyInsets(View paramView)
  {
    paramView.requestFitSystemWindows();
  }
  
  public void setBackground(View paramView, Drawable paramDrawable)
  {
    paramView.setBackground(paramDrawable);
  }
  
  public void setHasTransientState(View paramView, boolean paramBoolean)
  {
    paramView.setHasTransientState(paramBoolean);
  }
  
  public void setImportantForAccessibility(View paramView, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 4) {
      i = 2;
    }
    paramView.setImportantForAccessibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.ViewCompatApi16Impl
 * JD-Core Version:    0.7.0.1
 */