package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.widget.Gallery;

public class PreloadGallery
  extends Gallery
{
  private PreloadGallery.OnPreloadListener a;
  private int p = 1;
  
  public PreloadGallery(Context paramContext)
  {
    super(paramContext);
  }
  
  public PreloadGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PreloadGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.a != null) {
      this.a.c(paramInt, paramView, paramViewGroup);
    }
  }
  
  protected void a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.a(paramInt, paramView, paramViewGroup, paramBoolean);
    }
  }
  
  protected void a(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 0;
    int n = this.p;
    if ((n == 0) || (this.a == null)) {}
    int m;
    label34:
    do
    {
      return;
      m = a();
      int i = 0;
      int j = paramInt;
      if (i < n)
      {
        j -= 1;
        if (j >= 0) {}
      }
      else
      {
        j = paramInt;
        i = k;
      }
      for (;;)
      {
        if (i < n)
        {
          j += 1;
          if (j < m) {}
        }
        else
        {
          if (!paramBoolean2) {
            break;
          }
          if (!paramBoolean1) {
            break label158;
          }
          paramInt = paramInt - n - 1;
          if (paramInt < 0) {
            break;
          }
          this.a.b(paramInt, null, paramViewGroup);
          return;
          this.a.a(j, null, paramViewGroup);
          i += 1;
          break label34;
        }
        this.a.a(j, null, paramViewGroup);
        i += 1;
      }
      paramInt = paramInt + n + 1;
    } while (paramInt >= m);
    label158:
    this.a.b(paramInt, null, paramViewGroup);
  }
  
  protected void b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.a != null) {
      this.a.a(paramInt, paramView, paramViewGroup);
    }
  }
  
  public void setOnNoBlankListener(PreloadGallery.OnPreloadListener paramOnPreloadListener)
  {
    if (paramOnPreloadListener != this.a) {
      this.a = paramOnPreloadListener;
    }
  }
  
  public void setSelection(int paramInt)
  {
    int m = 0;
    super.setSelection(paramInt);
    int n = this.p;
    if ((n == 0) || (this.a == null)) {}
    label193:
    for (;;)
    {
      return;
      int i1 = this.aB;
      int i = this.aE;
      int j = i - n;
      int k = i + n;
      i = j;
      if (j < 0) {
        i = 0;
      }
      j = k;
      if (k >= i1) {
        j = i1 - 1;
      }
      k = paramInt - n;
      n += paramInt;
      paramInt = k;
      if (k < 0) {
        paramInt = 0;
      }
      k = n;
      if (n >= i1) {
        k = i1 - 1;
      }
      if ((paramInt > j) || (k < i))
      {
        paramInt = i;
        i = j;
      }
      for (;;)
      {
        if (paramInt >= i) {
          break label193;
        }
        while (paramInt <= i)
        {
          this.a.b(paramInt, null, this);
          paramInt += 1;
        }
        break;
        if (paramInt > i)
        {
          j = paramInt - 1;
          paramInt = i;
          i = j;
        }
        else if (k < j)
        {
          paramInt = k + 1;
          i = j;
        }
        else
        {
          paramInt = 0;
          i = m;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PreloadGallery
 * JD-Core Version:    0.7.0.1
 */