package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.token.ej;
import com.tencent.token.ew;
import com.tencent.token.go.f;

public class AlertDialogLayout
  extends LinearLayoutCompat
{
  public AlertDialogLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
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
    paramInt4 = 0;
    if (localObject == null) {
      paramInt3 = 0;
    } else {
      paramInt3 = ((Drawable)localObject).getIntrinsicHeight();
    }
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
          int i = localLayoutParams.h;
          paramInt2 = i;
          if (i < 0) {
            paramInt2 = i2 & 0x800007;
          }
          paramInt2 = ej.a(paramInt2, ew.c(this)) & 0x7;
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
          if (a(paramInt4)) {
            i = paramInt1 + paramInt3;
          }
          paramInt1 = i + localLayoutParams.topMargin;
          ((View)localObject).layout(paramInt2, paramInt1, i3 + paramInt2, paramInt1 + i4);
          paramInt2 = paramInt1 + (i4 + localLayoutParams.bottomMargin);
        }
      }
      paramInt4 += 1;
      paramInt1 = paramInt2;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i5 = getChildCount();
    int j = 0;
    Object localObject4 = null;
    Object localObject1 = localObject4;
    Object localObject3 = localObject1;
    int i = 0;
    Object localObject2;
    while (i < i5)
    {
      localObject2 = getChildAt(i);
      Object localObject5 = localObject4;
      Object localObject6 = localObject1;
      Object localObject7 = localObject3;
      if (((View)localObject2).getVisibility() != 8)
      {
        k = ((View)localObject2).getId();
        if (k == go.f.topPanel)
        {
          localObject5 = localObject2;
          localObject6 = localObject1;
          localObject7 = localObject3;
        }
        else if (k == go.f.buttonPanel)
        {
          localObject5 = localObject4;
          localObject6 = localObject2;
          localObject7 = localObject3;
        }
        else
        {
          if ((k != go.f.contentPanel) && (k != go.f.customPanel))
          {
            i = j;
            break label777;
          }
          if (localObject3 != null)
          {
            i = j;
            break label777;
          }
          localObject7 = localObject2;
          localObject6 = localObject1;
          localObject5 = localObject4;
        }
      }
      i += 1;
      localObject4 = localObject5;
      localObject1 = localObject6;
      localObject3 = localObject7;
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
    label311:
    int i1;
    if (localObject1 != null)
    {
      ((View)localObject1).measure(paramInt1, 0);
      for (localObject2 = localObject1;; localObject2 = ((ViewGroup)localObject2).getChildAt(0))
      {
        i = ew.e((View)localObject2);
        if (i > 0) {
          break label311;
        }
        if (!(localObject2 instanceof ViewGroup)) {
          break;
        }
        localObject2 = (ViewGroup)localObject2;
        if (((ViewGroup)localObject2).getChildCount() != 1) {
          break;
        }
      }
      i = 0;
      i1 = ((View)localObject1).getMeasuredHeight() - i;
      k += i;
      j = View.combineMeasuredStates(j, ((View)localObject1).getMeasuredState());
    }
    else
    {
      i1 = 0;
      i = 0;
    }
    int i2;
    if (localObject3 != null)
    {
      if (i7 == 0) {
        m = 0;
      } else {
        m = View.MeasureSpec.makeMeasureSpec(Math.max(0, n - k), i7);
      }
      localObject3.measure(paramInt1, m);
      i2 = localObject3.getMeasuredHeight();
      k += i2;
      j = View.combineMeasuredStates(j, localObject3.getMeasuredState());
    }
    else
    {
      i2 = 0;
    }
    int i3 = n - k;
    n = j;
    int i4 = i3;
    int m = k;
    if (localObject1 != null)
    {
      i1 = Math.min(i3, i1);
      n = i3;
      m = i;
      if (i1 > 0)
      {
        n = i3 - i1;
        m = i + i1;
      }
      ((View)localObject1).measure(paramInt1, View.MeasureSpec.makeMeasureSpec(m, 1073741824));
      m = k - i + ((View)localObject1).getMeasuredHeight();
      i = View.combineMeasuredStates(j, ((View)localObject1).getMeasuredState());
      i4 = n;
      n = i;
    }
    j = n;
    i = m;
    if (localObject3 != null)
    {
      j = n;
      i = m;
      if (i4 > 0)
      {
        localObject3.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(i2 + i4, i7));
        i = m - i2 + localObject3.getMeasuredHeight();
        j = View.combineMeasuredStates(n, localObject3.getMeasuredState());
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
    if (i6 != 1073741824)
    {
      j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
      i = 0;
      while (i < i5)
      {
        localObject1 = getChildAt(i);
        if (((View)localObject1).getVisibility() != 8)
        {
          localObject2 = (LinearLayoutCompat.LayoutParams)((View)localObject1).getLayoutParams();
          if (((LinearLayoutCompat.LayoutParams)localObject2).width == -1)
          {
            k = ((LinearLayoutCompat.LayoutParams)localObject2).height;
            ((LinearLayoutCompat.LayoutParams)localObject2).height = ((View)localObject1).getMeasuredHeight();
            measureChildWithMargins((View)localObject1, j, 0, paramInt2, 0);
            ((LinearLayoutCompat.LayoutParams)localObject2).height = k;
          }
        }
        i += 1;
      }
    }
    i = 1;
    label777:
    if (i == 0) {
      super.onMeasure(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AlertDialogLayout
 * JD-Core Version:    0.7.0.1
 */