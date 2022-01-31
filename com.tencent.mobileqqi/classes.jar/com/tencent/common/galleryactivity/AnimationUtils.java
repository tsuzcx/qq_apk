package com.tencent.common.galleryactivity;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

public class AnimationUtils
{
  private static final float a = 1.5F;
  private static final float b = 641.0F;
  
  public static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 1.0F;
    float f1;
    if ((paramInt1 >= paramInt3) && (paramInt2 >= paramInt4 * paramInt1 / paramInt3)) {
      f1 = paramInt3 / paramInt1;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return f1;
            if (paramInt1 >= paramInt3) {
              break;
            }
            f1 = f2;
          } while (paramInt2 >= paramInt4);
          if ((paramInt1 >= paramInt3) && (paramInt2 < paramInt4 * paramInt1 / paramInt3)) {
            return paramInt3 / paramInt1;
          }
          if ((paramInt1 > paramInt3) || (paramInt2 > paramInt4)) {
            return Math.min(paramInt4 / paramInt2, paramInt3 / paramInt1);
          }
          f1 = f2;
        } while (paramInt1 >= paramInt3);
        f1 = f2;
      } while (paramInt1 <= paramInt3 / 2);
      f1 = f2;
    } while (paramInt4 <= paramInt3 / paramInt1 * paramInt2);
    return paramInt3 / paramInt1;
  }
  
  public static Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect();
    localRect.left = 0;
    localRect.top = 0;
    float f = paramInt1 * 1.0F / paramInt2;
    if (paramInt1 < paramInt2)
    {
      localRect.right = paramInt3;
      localRect.bottom = ((int)(paramInt3 * 1.0F / f));
    }
    while (paramInt1 < paramInt2) {
      return localRect;
    }
    localRect.bottom = paramInt4;
    localRect.right = ((int)(f * paramInt4));
    return localRect;
  }
  
  public static Rect a(View paramView)
  {
    Rect localRect = new Rect(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getWidth() - paramView.getPaddingRight(), paramView.getHeight() - paramView.getPaddingBottom());
    a(paramView, localRect);
    return localRect;
  }
  
  public static boolean a(View paramView, Rect paramRect)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    Point localPoint = new Point();
    if ((i > 0) && (j > 0))
    {
      Rect localRect = paramRect;
      if (paramRect == null)
      {
        localRect = new Rect();
        localRect.set(0, 0, i, j);
      }
      if (localPoint != null) {
        localPoint.set(-paramView.getScrollX(), -paramView.getScrollY());
      }
      localRect.offset((i - localRect.width()) / 2, (j - localRect.height()) / 2);
      return (localViewGroup == null) || (a(localViewGroup, paramView, localRect, localPoint));
    }
    return false;
  }
  
  private static boolean a(ViewGroup paramViewGroup, View paramView, Rect paramRect, Point paramPoint)
  {
    int i = paramView.getLeft() - paramViewGroup.getScrollX();
    int j = paramView.getTop() - paramViewGroup.getScrollY();
    if (paramPoint != null)
    {
      paramPoint.x += i;
      paramPoint.y += j;
    }
    paramRect.offset(i, j);
    paramView = paramViewGroup.getParent();
    if ((paramView instanceof ViewGroup)) {
      return (paramView == null) || (a((ViewGroup)paramView, paramViewGroup, paramRect, paramPoint));
    }
    return true;
  }
  
  public static Rect b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 1.0F;
    int i = paramInt2 * paramInt3 / paramInt1;
    int j;
    if (paramInt1 >= paramInt3) {
      if (paramInt4 >= i)
      {
        f = paramInt3 / paramInt1;
        j = 17;
        i = 0;
      }
    }
    for (;;)
    {
      paramInt1 = (int)(paramInt1 * f);
      paramInt2 = (int)(paramInt2 * f);
      Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
      if (j == 17) {
        localRect.offset((paramInt3 - paramInt1) / 2, (paramInt4 - paramInt2) / 2);
      }
      while ((j != 48) || (i == 0))
      {
        return localRect;
        if ((paramInt4 * 1.5F >= i) && (i > paramInt4))
        {
          f = paramInt4 / paramInt2;
          i = (int)(paramInt1 * f);
          j = 17;
          i = 0;
          break;
        }
        if (i <= 1.5D * paramInt4) {
          break label333;
        }
        f = paramInt3 / paramInt1;
        j = 48;
        i = 0;
        break;
        if (paramInt2 < paramInt4)
        {
          if (paramInt4 >= i)
          {
            if (paramInt1 * 1.5F >= paramInt3)
            {
              f = paramInt3 / paramInt1;
              j = 17;
              i = 0;
              break;
            }
            i = 0;
            j = 17;
            break;
          }
          if (paramInt2 * 1.5F >= paramInt4)
          {
            f = paramInt4 / paramInt2;
            j = 17;
            i = 0;
            break;
          }
          i = 0;
          j = 17;
          break;
        }
        if ((paramInt2 > paramInt4) && (paramInt2 < paramInt4 * 1.5F))
        {
          f = paramInt4 / paramInt2;
          j = 17;
          i = 0;
          break;
        }
        if (paramInt2 <= paramInt4 * 1.5F) {
          break label333;
        }
        i = 1;
        j = 48;
        break;
      }
      localRect.offset((int)(paramInt3 - f * paramInt1) / 2, 0);
      return localRect;
      label333:
      i = 0;
      j = 17;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AnimationUtils
 * JD-Core Version:    0.7.0.1
 */