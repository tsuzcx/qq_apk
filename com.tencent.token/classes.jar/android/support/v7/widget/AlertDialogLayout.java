package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.id;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class AlertDialogLayout
  extends LinearLayoutCompat
{
  public AlertDialogLayout(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  public AlertDialogLayout(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void forceUniformWidth(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    int i = 0;
    while (i < paramInt1)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        LinearLayoutCompat.LayoutParams localLayoutParams = (LinearLayoutCompat.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.width == -1)
        {
          int k = localLayoutParams.height;
          localLayoutParams.height = localView.getMeasuredHeight();
          measureChildWithMargins(localView, j, 0, paramInt2, 0);
          localLayoutParams.height = k;
        }
      }
      i += 1;
    }
  }
  
  private static int resolveMinimumHeight(View paramView)
  {
    int i = ViewCompat.getMinimumHeight(paramView);
    if (i > 0) {
      return i;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getChildCount() == 1) {
        return resolveMinimumHeight(paramView.getChildAt(0));
      }
    }
    return 0;
  }
  
  private void setChildFrame(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
  }
  
  private boolean tryOnMeasure(int paramInt1, int paramInt2)
  {
    int i5 = getChildCount();
    Object localObject4 = null;
    Object localObject1 = localObject4;
    Object localObject2 = localObject1;
    int i = 0;
    Object localObject3 = localObject1;
    while (i < i5)
    {
      localObject1 = getChildAt(i);
      if (((View)localObject1).getVisibility() != 8)
      {
        j = ((View)localObject1).getId();
        if (j == R.id.topPanel)
        {
          localObject4 = localObject1;
        }
        else if (j == R.id.buttonPanel)
        {
          localObject3 = localObject1;
        }
        else
        {
          if ((j != R.id.contentPanel) && (j != R.id.customPanel)) {
            return false;
          }
          if (localObject2 != null) {
            return false;
          }
          localObject2 = localObject1;
        }
      }
      i += 1;
    }
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int n = View.MeasureSpec.getSize(paramInt2);
    int i6 = View.MeasureSpec.getMode(paramInt1);
    int k = getPaddingTop() + getPaddingBottom();
    if (localObject4 != null)
    {
      localObject4.measure(paramInt1, 0);
      k += localObject4.getMeasuredHeight();
      j = View.combineMeasuredStates(0, localObject4.getMeasuredState());
    }
    else
    {
      j = 0;
    }
    int i1;
    if (localObject3 != null)
    {
      localObject3.measure(paramInt1, 0);
      i = resolveMinimumHeight(localObject3);
      i1 = localObject3.getMeasuredHeight() - i;
      k += i;
      j = View.combineMeasuredStates(j, localObject3.getMeasuredState());
    }
    else
    {
      i = 0;
      i1 = 0;
    }
    int i2;
    if (localObject2 != null)
    {
      if (i7 == 0) {
        m = 0;
      } else {
        m = View.MeasureSpec.makeMeasureSpec(Math.max(0, n - k), i7);
      }
      localObject2.measure(paramInt1, m);
      i2 = localObject2.getMeasuredHeight();
      k += i2;
      j = View.combineMeasuredStates(j, localObject2.getMeasuredState());
    }
    else
    {
      i2 = 0;
    }
    int i3 = n - k;
    n = j;
    int i4 = i3;
    int m = k;
    if (localObject3 != null)
    {
      i1 = Math.min(i3, i1);
      n = i3;
      m = i;
      if (i1 > 0)
      {
        n = i3 - i1;
        m = i + i1;
      }
      localObject3.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(m, 1073741824));
      m = k - i + localObject3.getMeasuredHeight();
      i = View.combineMeasuredStates(j, localObject3.getMeasuredState());
      i4 = n;
      n = i;
    }
    int j = n;
    i = m;
    if (localObject2 != null)
    {
      j = n;
      i = m;
      if (i4 > 0)
      {
        localObject2.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(i2 + i4, i7));
        i = m - i2 + localObject2.getMeasuredHeight();
        j = View.combineMeasuredStates(n, localObject2.getMeasuredState());
      }
    }
    k = 0;
    for (m = 0; k < i5; m = n)
    {
      localObject1 = getChildAt(k);
      n = m;
      if (((View)localObject1).getVisibility() != 8) {
        n = Math.max(m, ((View)localObject1).getMeasuredWidth());
      }
      k += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(m + (getPaddingLeft() + getPaddingRight()), paramInt1, j), View.resolveSizeAndState(i, paramInt2, 0));
    if (i6 != 1073741824) {
      forceUniformWidth(i5, paramInt2);
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getPaddingLeft();
    int k = paramInt3 - paramInt1;
    int m = getPaddingRight();
    int n = getPaddingRight();
    paramInt1 = getMeasuredHeight();
    int i1 = getChildCount();
    int i2 = getGravity();
    paramInt3 = i2 & 0x70;
    if (paramInt3 != 16)
    {
      if (paramInt3 != 80) {
        paramInt1 = getPaddingTop();
      } else {
        paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - paramInt1;
      }
    }
    else {
      paramInt1 = getPaddingTop() + (paramInt4 - paramInt2 - paramInt1) / 2;
    }
    Object localObject = getDividerDrawable();
    if (localObject == null) {
      paramInt3 = 0;
    } else {
      paramInt3 = ((Drawable)localObject).getIntrinsicHeight();
    }
    paramInt4 = 0;
    while (paramInt4 < i1)
    {
      localObject = getChildAt(paramInt4);
      paramInt2 = paramInt1;
      if (localObject != null)
      {
        paramInt2 = paramInt1;
        if (((View)localObject).getVisibility() != 8)
        {
          int i3 = ((View)localObject).getMeasuredWidth();
          int i4 = ((View)localObject).getMeasuredHeight();
          LinearLayoutCompat.LayoutParams localLayoutParams = (LinearLayoutCompat.LayoutParams)((View)localObject).getLayoutParams();
          int i = localLayoutParams.gravity;
          paramInt2 = i;
          if (i < 0) {
            paramInt2 = i2 & 0x800007;
          }
          paramInt2 = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection(this)) & 0x7;
          if (paramInt2 != 1)
          {
            if (paramInt2 != 5) {
              paramInt2 = localLayoutParams.leftMargin + j;
            } else {
              paramInt2 = k - m - i3 - localLayoutParams.rightMargin;
            }
          }
          else {
            paramInt2 = (k - j - n - i3) / 2 + j + localLayoutParams.leftMargin - localLayoutParams.rightMargin;
          }
          i = paramInt1;
          if (hasDividerBeforeChildAt(paramInt4)) {
            i = paramInt1 + paramInt3;
          }
          paramInt1 = i + localLayoutParams.topMargin;
          setChildFrame((View)localObject, paramInt2, paramInt1, i3, i4);
          paramInt2 = paramInt1 + (i4 + localLayoutParams.bottomMargin);
        }
      }
      paramInt4 += 1;
      paramInt1 = paramInt2;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!tryOnMeasure(paramInt1, paramInt2)) {
      super.onMeasure(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AlertDialogLayout
 * JD-Core Version:    0.7.0.1
 */