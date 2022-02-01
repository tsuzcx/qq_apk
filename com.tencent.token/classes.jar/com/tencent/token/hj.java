package com.tencent.token;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class hj
  implements hw
{
  protected Context a;
  protected Context b;
  public hp c;
  protected LayoutInflater d;
  protected LayoutInflater e;
  public hw.a f;
  public hx g;
  public int h;
  private int i;
  private int j;
  
  public hj(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.i = paramInt1;
    this.j = paramInt2;
  }
  
  public View a(hr paramhr, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof hx.a)) {
      paramView = (hx.a)paramView;
    } else {
      paramView = (hx.a)this.d.inflate(this.j, paramViewGroup, false);
    }
    a(paramhr, paramView);
    return (View)paramView;
  }
  
  public hx a(ViewGroup paramViewGroup)
  {
    if (this.g == null)
    {
      this.g = ((hx)this.d.inflate(this.i, paramViewGroup, false));
      this.g.a(this.c);
      b(true);
    }
    return this.g;
  }
  
  public void a(Context paramContext, hp paramhp)
  {
    this.b = paramContext;
    this.e = LayoutInflater.from(this.b);
    this.c = paramhp;
  }
  
  public void a(hp paramhp, boolean paramBoolean)
  {
    hw.a locala = this.f;
    if (locala != null) {
      locala.a(paramhp, paramBoolean);
    }
  }
  
  public abstract void a(hr paramhr, hx.a parama);
  
  public final void a(hw.a parama)
  {
    this.f = parama;
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public boolean a(hr paramhr)
  {
    return true;
  }
  
  public boolean a(ic paramic)
  {
    hw.a locala = this.f;
    if (locala != null) {
      return locala.a(paramic);
    }
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.g;
    if (localViewGroup == null) {
      return;
    }
    Object localObject = this.c;
    int k = 0;
    if (localObject != null)
    {
      ((hp)localObject).i();
      ArrayList localArrayList = this.c.h();
      int i1 = localArrayList.size();
      int m = 0;
      int n;
      for (k = 0; m < i1; k = n)
      {
        hr localhr = (hr)localArrayList.get(m);
        n = k;
        if (a(localhr))
        {
          View localView1 = localViewGroup.getChildAt(k);
          if ((localView1 instanceof hx.a)) {
            localObject = ((hx.a)localView1).getItemData();
          } else {
            localObject = null;
          }
          View localView2 = a(localhr, localView1, localViewGroup);
          if (localhr != localObject)
          {
            localView2.setPressed(false);
            localView2.jumpDrawablesToCurrentState();
          }
          if (localView2 != localView1)
          {
            localObject = (ViewGroup)localView2.getParent();
            if (localObject != null) {
              ((ViewGroup)localObject).removeView(localView2);
            }
            ((ViewGroup)this.g).addView(localView2, k);
          }
          n = k + 1;
        }
        m += 1;
      }
    }
    while (k < localViewGroup.getChildCount()) {
      if (!a(localViewGroup, k)) {
        k += 1;
      }
    }
  }
  
  public final boolean b(hr paramhr)
  {
    return false;
  }
  
  public final boolean c(hr paramhr)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hj
 * JD-Core Version:    0.7.0.1
 */