package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;

public abstract class CoordinatorLayout$Behavior
{
  public CoordinatorLayout$Behavior() {}
  
  public CoordinatorLayout$Behavior(Context paramContext, AttributeSet paramAttributeSet) {}
  
  public static Object getTag(View paramView)
  {
    return ((CoordinatorLayout.LayoutParams)paramView.getLayoutParams()).mBehaviorTag;
  }
  
  public static void setTag(View paramView, Object paramObject)
  {
    ((CoordinatorLayout.LayoutParams)paramView.getLayoutParams()).mBehaviorTag = paramObject;
  }
  
  public boolean blocksInteractionBelow(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    return getScrimOpacity(paramCoordinatorLayout, paramView) > 0.0F;
  }
  
  public boolean getInsetDodgeRect(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView, @NonNull Rect paramRect)
  {
    return false;
  }
  
  @ColorInt
  public int getScrimColor(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    return -16777216;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getScrimOpacity(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    return 0.0F;
  }
  
  public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return false;
  }
  
  @NonNull
  public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout paramCoordinatorLayout, View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return paramWindowInsetsCompat;
  }
  
  public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams paramLayoutParams) {}
  
  public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return false;
  }
  
  public void onDependentViewRemoved(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2) {}
  
  public void onDetachedFromLayoutParams() {}
  
  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    return false;
  }
  
  public boolean onMeasureChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  public boolean onNestedFling(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  @Deprecated
  public void onNestedPreScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2, @NonNull int[] paramArrayOfInt) {}
  
  public void onNestedPreScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2, @NonNull int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 0) {
      onNestedPreScroll(paramCoordinatorLayout, paramView1, paramView2, paramInt1, paramInt2, paramArrayOfInt);
    }
  }
  
  @Deprecated
  public void onNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      onNestedScroll(paramCoordinatorLayout, paramView1, paramView2, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  @Deprecated
  public void onNestedScrollAccepted(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2, @NonNull View paramView3, int paramInt) {}
  
  public void onNestedScrollAccepted(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2, @NonNull View paramView3, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      onNestedScrollAccepted(paramCoordinatorLayout, paramView1, paramView2, paramView3, paramInt1);
    }
  }
  
  public boolean onRequestChildRectangleOnScreen(CoordinatorLayout paramCoordinatorLayout, View paramView, Rect paramRect, boolean paramBoolean)
  {
    return false;
  }
  
  public void onRestoreInstanceState(CoordinatorLayout paramCoordinatorLayout, View paramView, Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    return View.BaseSavedState.EMPTY_STATE;
  }
  
  @Deprecated
  public boolean onStartNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2, @NonNull View paramView3, int paramInt)
  {
    return false;
  }
  
  public boolean onStartNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2, @NonNull View paramView3, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return onStartNestedScroll(paramCoordinatorLayout, paramView1, paramView2, paramView3, paramInt1);
    }
    return false;
  }
  
  @Deprecated
  public void onStopNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2) {}
  
  public void onStopNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2, int paramInt)
  {
    if (paramInt == 0) {
      onStopNestedScroll(paramCoordinatorLayout, paramView1, paramView2);
    }
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.Behavior
 * JD-Core Version:    0.7.0.1
 */