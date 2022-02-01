package com.tencent.token;

import android.view.View;
import android.view.ViewParent;

public final class fh
{
  public boolean a;
  private ViewParent b;
  private ViewParent c;
  private final View d;
  private int[] e;
  
  public fh(View paramView)
  {
    this.d = paramView;
  }
  
  private void a(int paramInt, ViewParent paramViewParent)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.c = paramViewParent;
      return;
    }
    this.b = paramViewParent;
    return;
  }
  
  private ViewParent c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.c;
    }
    return this.b;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.a) {
      fo.p(this.d);
    }
    this.a = paramBoolean;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.a)
    {
      ViewParent localViewParent = c(0);
      if (localViewParent != null) {
        return fq.a(localViewParent, this.d, paramFloat1, paramFloat2);
      }
    }
    return false;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.a)
    {
      ViewParent localViewParent = c(0);
      if (localViewParent != null) {
        return fq.a(localViewParent, this.d, paramFloat1, paramFloat2, paramBoolean);
      }
    }
    return false;
  }
  
  public final boolean a(int paramInt)
  {
    return c(paramInt) != null;
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    if (a(paramInt2)) {
      return true;
    }
    if (this.a)
    {
      ViewParent localViewParent = this.d.getParent();
      View localView = this.d;
      while (localViewParent != null)
      {
        if (fq.a(localViewParent, localView, this.d, paramInt1, paramInt2))
        {
          a(paramInt2, localViewParent);
          fq.b(localViewParent, localView, this.d, paramInt1, paramInt2);
          return true;
        }
        if ((localViewParent instanceof View)) {
          localView = (View)localViewParent;
        }
        localViewParent = localViewParent.getParent();
      }
    }
    return false;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, 0);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    if (this.a)
    {
      ViewParent localViewParent = c(paramInt5);
      if (localViewParent == null) {
        return false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0))
      {
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = 0;
          paramArrayOfInt[1] = 0;
          return false;
        }
      }
      else
      {
        int i;
        int j;
        if (paramArrayOfInt != null)
        {
          this.d.getLocationInWindow(paramArrayOfInt);
          i = paramArrayOfInt[0];
          j = paramArrayOfInt[1];
        }
        else
        {
          i = 0;
          j = 0;
        }
        fq.a(localViewParent, this.d, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
        if (paramArrayOfInt != null)
        {
          this.d.getLocationInWindow(paramArrayOfInt);
          paramArrayOfInt[0] -= i;
          paramArrayOfInt[1] -= j;
        }
        return true;
      }
    }
    return false;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    if (this.a)
    {
      ViewParent localViewParent = c(paramInt3);
      if (localViewParent == null) {
        return false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramArrayOfInt2 != null)
        {
          paramArrayOfInt2[0] = 0;
          paramArrayOfInt2[1] = 0;
          return false;
        }
      }
      else
      {
        int i;
        int j;
        if (paramArrayOfInt2 != null)
        {
          this.d.getLocationInWindow(paramArrayOfInt2);
          i = paramArrayOfInt2[0];
          j = paramArrayOfInt2[1];
        }
        else
        {
          i = 0;
          j = 0;
        }
        int[] arrayOfInt = paramArrayOfInt1;
        if (paramArrayOfInt1 == null)
        {
          if (this.e == null) {
            this.e = new int[2];
          }
          arrayOfInt = this.e;
        }
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        fq.a(localViewParent, this.d, paramInt1, paramInt2, arrayOfInt, paramInt3);
        if (paramArrayOfInt2 != null)
        {
          this.d.getLocationInWindow(paramArrayOfInt2);
          paramArrayOfInt2[0] -= i;
          paramArrayOfInt2[1] -= j;
        }
        if (arrayOfInt[0] == 0) {
          return arrayOfInt[1] != 0;
        }
        return true;
      }
    }
    return false;
  }
  
  public final void b(int paramInt)
  {
    ViewParent localViewParent = c(paramInt);
    if (localViewParent != null)
    {
      fq.a(localViewParent, this.d, paramInt);
      a(paramInt, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fh
 * JD-Core Version:    0.7.0.1
 */