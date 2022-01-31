package com.tencent.common.galleryactivity;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

public class AnimationUtils
{
  private static final float a = 1.5F;
  
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
    return a(paramInt1, paramInt2, paramInt3, paramInt4, true);
  }
  
  public static Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i = paramInt2 * paramInt3 / paramInt1;
    float f;
    int j;
    if (paramInt1 >= paramInt3) {
      if (paramInt4 >= i)
      {
        f = paramInt3 / paramInt1;
        i = 17;
        j = 0;
      }
    }
    for (;;)
    {
      label48:
      Rect localRect;
      if ((!paramBoolean) && (f > 1.0F))
      {
        i = 17;
        localRect = new Rect(0, 0, paramInt1, paramInt2);
        if (i != 17) {
          break label326;
        }
        localRect.offset((paramInt3 - paramInt1) / 2, (paramInt4 - paramInt2) / 2);
      }
      label326:
      while ((i != 48) || (j == 0))
      {
        return localRect;
        if ((paramInt4 * 1.5F >= i) && (i > paramInt4))
        {
          f = paramInt4 / paramInt2;
          i = (int)(paramInt1 * f);
          i = 17;
          j = 0;
          break;
        }
        if (i <= 1.5D * paramInt4) {
          break label358;
        }
        f = paramInt3 / paramInt1;
        i = 48;
        j = 0;
        break;
        if (paramInt2 < paramInt4)
        {
          if (paramInt4 >= i)
          {
            if (paramInt1 * 1.5F >= paramInt3)
            {
              f = paramInt3 / paramInt1;
              i = 17;
              j = 0;
              break;
            }
            i = 17;
            f = 1.0F;
            j = 0;
            break;
          }
          if (paramInt2 * 1.5F >= paramInt4)
          {
            f = paramInt4 / paramInt2;
            i = 17;
            j = 0;
            break;
          }
          i = 17;
          f = 1.0F;
          j = 0;
          break;
        }
        if ((paramInt2 > paramInt4) && (paramInt2 < paramInt4 * 1.5F))
        {
          f = paramInt4 / paramInt2;
          i = 17;
          j = 0;
          break;
        }
        if (paramInt2 <= paramInt4 * 1.5F) {
          break label358;
        }
        i = 48;
        f = 1.0F;
        j = 1;
        break;
        paramInt1 = (int)(paramInt1 * f);
        paramInt2 = (int)(paramInt2 * f);
        break label48;
      }
      localRect.offset((int)(paramInt3 - paramInt1 * f) / 2, 0);
      return localRect;
      label358:
      i = 17;
      f = 1.0F;
      j = 0;
    }
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
      return (localViewGroup == null) || (localViewGroup.getChildVisibleRect(paramView, localRect, localPoint));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AnimationUtils
 * JD-Core Version:    0.7.0.1
 */