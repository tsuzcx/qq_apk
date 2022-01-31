package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;

@RequiresApi(21)
class ViewCompat$ViewCompatApi21Impl
  extends ViewCompat.ViewCompatApi19Impl
{
  private static ThreadLocal sThreadLocalRect;
  
  private static Rect getEmptyTempRect()
  {
    if (sThreadLocalRect == null) {
      sThreadLocalRect = new ThreadLocal();
    }
    Rect localRect2 = (Rect)sThreadLocalRect.get();
    Rect localRect1 = localRect2;
    if (localRect2 == null)
    {
      localRect1 = new Rect();
      sThreadLocalRect.set(localRect1);
    }
    localRect1.setEmpty();
    return localRect1;
  }
  
  public WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    paramWindowInsetsCompat = (WindowInsets)WindowInsetsCompat.unwrap(paramWindowInsetsCompat);
    WindowInsets localWindowInsets = paramView.dispatchApplyWindowInsets(paramWindowInsetsCompat);
    paramView = paramWindowInsetsCompat;
    if (localWindowInsets != paramWindowInsetsCompat) {
      paramView = new WindowInsets(localWindowInsets);
    }
    return WindowInsetsCompat.wrap(paramView);
  }
  
  public boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return paramView.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return paramView.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return paramView.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return paramView.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public ColorStateList getBackgroundTintList(View paramView)
  {
    return paramView.getBackgroundTintList();
  }
  
  public PorterDuff.Mode getBackgroundTintMode(View paramView)
  {
    return paramView.getBackgroundTintMode();
  }
  
  public float getElevation(View paramView)
  {
    return paramView.getElevation();
  }
  
  public String getTransitionName(View paramView)
  {
    return paramView.getTransitionName();
  }
  
  public float getTranslationZ(View paramView)
  {
    return paramView.getTranslationZ();
  }
  
  public float getZ(View paramView)
  {
    return paramView.getZ();
  }
  
  public boolean hasNestedScrollingParent(View paramView)
  {
    return paramView.hasNestedScrollingParent();
  }
  
  public boolean isImportantForAccessibility(View paramView)
  {
    return paramView.isImportantForAccessibility();
  }
  
  public boolean isNestedScrollingEnabled(View paramView)
  {
    return paramView.isNestedScrollingEnabled();
  }
  
  public void offsetLeftAndRight(View paramView, int paramInt)
  {
    Rect localRect = getEmptyTempRect();
    ViewParent localViewParent = paramView.getParent();
    int i;
    if ((localViewParent instanceof View))
    {
      View localView = (View)localViewParent;
      localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        i = 1;
      }
    }
    for (;;)
    {
      super.offsetLeftAndRight(paramView, paramInt);
      if ((i != 0) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public void offsetTopAndBottom(View paramView, int paramInt)
  {
    Rect localRect = getEmptyTempRect();
    ViewParent localViewParent = paramView.getParent();
    int i;
    if ((localViewParent instanceof View))
    {
      View localView = (View)localViewParent;
      localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        i = 1;
      }
    }
    for (;;)
    {
      super.offsetTopAndBottom(paramView, paramInt);
      if ((i != 0) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    paramWindowInsetsCompat = (WindowInsets)WindowInsetsCompat.unwrap(paramWindowInsetsCompat);
    WindowInsets localWindowInsets = paramView.onApplyWindowInsets(paramWindowInsetsCompat);
    paramView = paramWindowInsetsCompat;
    if (localWindowInsets != paramWindowInsetsCompat) {
      paramView = new WindowInsets(localWindowInsets);
    }
    return WindowInsetsCompat.wrap(paramView);
  }
  
  public void requestApplyInsets(View paramView)
  {
    paramView.requestApplyInsets();
  }
  
  public void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
  {
    paramView.setBackgroundTintList(paramColorStateList);
    if (Build.VERSION.SDK_INT == 21)
    {
      paramColorStateList = paramView.getBackground();
      if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      if ((paramColorStateList != null) && (i != 0))
      {
        if (paramColorStateList.isStateful()) {
          paramColorStateList.setState(paramView.getDrawableState());
        }
        paramView.setBackground(paramColorStateList);
      }
      return;
    }
  }
  
  public void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
  {
    paramView.setBackgroundTintMode(paramMode);
    if (Build.VERSION.SDK_INT == 21)
    {
      paramMode = paramView.getBackground();
      if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      if ((paramMode != null) && (i != 0))
      {
        if (paramMode.isStateful()) {
          paramMode.setState(paramView.getDrawableState());
        }
        paramView.setBackground(paramMode);
      }
      return;
    }
  }
  
  public void setElevation(View paramView, float paramFloat)
  {
    paramView.setElevation(paramFloat);
  }
  
  public void setNestedScrollingEnabled(View paramView, boolean paramBoolean)
  {
    paramView.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    if (paramOnApplyWindowInsetsListener == null)
    {
      paramView.setOnApplyWindowInsetsListener(null);
      return;
    }
    paramView.setOnApplyWindowInsetsListener(new ViewCompat.ViewCompatApi21Impl.1(this, paramOnApplyWindowInsetsListener));
  }
  
  public void setTransitionName(View paramView, String paramString)
  {
    paramView.setTransitionName(paramString);
  }
  
  public void setTranslationZ(View paramView, float paramFloat)
  {
    paramView.setTranslationZ(paramFloat);
  }
  
  public void setZ(View paramView, float paramFloat)
  {
    paramView.setZ(paramFloat);
  }
  
  public boolean startNestedScroll(View paramView, int paramInt)
  {
    return paramView.startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll(View paramView)
  {
    paramView.stopNestedScroll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.ViewCompatApi21Impl
 * JD-Core Version:    0.7.0.1
 */