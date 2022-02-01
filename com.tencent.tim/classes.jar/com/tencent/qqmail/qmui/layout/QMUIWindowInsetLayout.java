package com.tencent.qqmail.qmui.layout;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public class QMUIWindowInsetLayout
  extends FrameLayout
{
  public QMUIWindowInsetLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMUIWindowInsetLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QMUIWindowInsetLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSystemUiVisibility(4);
  }
  
  @TargetApi(19)
  private boolean applySystemWindowInsets19(Rect paramRect)
  {
    int i = 0;
    boolean bool = false;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (!localView.getFitsSystemWindows()) {}
      for (;;)
      {
        i += 1;
        break;
        Rect localRect = new Rect(paramRect);
        computeInsetsWithGravity(localView, localRect);
        localView.setPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
        bool = true;
      }
    }
    return bool;
  }
  
  @TargetApi(21)
  private boolean applySystemWindowInsets21(WindowInsets paramWindowInsets)
  {
    int i = 0;
    boolean bool = false;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (!localView.getFitsSystemWindows()) {}
      for (;;)
      {
        i += 1;
        break;
        Rect localRect = new Rect(paramWindowInsets.getSystemWindowInsetLeft(), paramWindowInsets.getSystemWindowInsetTop(), paramWindowInsets.getSystemWindowInsetRight(), paramWindowInsets.getSystemWindowInsetBottom());
        computeInsetsWithGravity(localView, localRect);
        localView.dispatchApplyWindowInsets(paramWindowInsets.replaceSystemWindowInsets(localRect));
        bool = true;
      }
    }
    return bool;
  }
  
  @SuppressLint({"RtlHardcoded"})
  private void computeInsetsWithGravity(View paramView, Rect paramRect)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    int i = GravityCompat.getAbsoluteGravity(localLayoutParams.gravity, ViewCompat.getLayoutDirection(paramView));
    if (localLayoutParams.width != -1)
    {
      if ((i & 0x3) != 3) {
        paramRect.left = 0;
      }
      if ((i & 0x5) != 5) {
        paramRect.right = 0;
      }
    }
    if (localLayoutParams.height != -1)
    {
      if ((i & 0x30) != 48) {
        paramRect.top = 0;
      }
      if ((i & 0x50) != 80) {
        paramRect.bottom = 0;
      }
    }
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    if ((Build.VERSION.SDK_INT >= 19) && (Build.VERSION.SDK_INT < 21)) {
      return applySystemWindowInsets19(paramRect);
    }
    return super.fitSystemWindows(paramRect);
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    WindowInsets localWindowInsets = paramWindowInsets;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localWindowInsets = paramWindowInsets;
      if (paramWindowInsets.hasSystemWindowInsets())
      {
        localWindowInsets = paramWindowInsets;
        if (applySystemWindowInsets21(paramWindowInsets)) {
          localWindowInsets = paramWindowInsets.consumeSystemWindowInsets();
        }
      }
    }
    return localWindowInsets;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.layout.QMUIWindowInsetLayout
 * JD-Core Version:    0.7.0.1
 */