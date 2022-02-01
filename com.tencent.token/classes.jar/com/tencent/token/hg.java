package com.tencent.token;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class hg
  implements ht
{
  protected Context a;
  protected Context b;
  public hm c;
  protected LayoutInflater d;
  protected LayoutInflater e;
  public ht.a f;
  public hu g;
  public int h;
  private int i;
  private int j;
  
  public hg(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.i = paramInt1;
    this.j = paramInt2;
  }
  
  public View a(ho paramho, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof hu.a)) {
      paramView = (hu.a)paramView;
    } else {
      paramView = (hu.a)this.d.inflate(this.j, paramViewGroup, false);
    }
    a(paramho, paramView);
    return (View)paramView;
  }
  
  public hu a(ViewGroup paramViewGroup)
  {
    if (this.g == null)
    {
      this.g = ((hu)this.d.inflate(this.i, paramViewGroup, false));
      this.g.a(this.c);
      b(true);
    }
    return this.g;
  }
  
  public void a(Context paramContext, hm paramhm)
  {
    this.b = paramContext;
    this.e = LayoutInflater.from(this.b);
    this.c = paramhm;
  }
  
  public void a(hm paramhm, boolean paramBoolean)
  {
    ht.a locala = this.f;
    if (locala != null) {
      locala.a(paramhm, paramBoolean);
    }
  }
  
  public abstract void a(ho paramho, hu.a parama);
  
  public final void a(ht.a parama)
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
  
  public boolean a(ho paramho)
  {
    return true;
  }
  
  public boolean a(hz paramhz)
  {
    ht.a locala = this.f;
    if (locala != null) {
      return locala.a(paramhz);
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
      ((hm)localObject).i();
      ArrayList localArrayList = this.c.h();
      int i1 = localArrayList.size();
      int m = 0;
      int n;
      for (k = 0; m < i1; k = n)
      {
        ho localho = (ho)localArrayList.get(m);
        n = k;
        if (a(localho))
        {
          View localView1 = localViewGroup.getChildAt(k);
          if ((localView1 instanceof hu.a)) {
            localObject = ((hu.a)localView1).getItemData();
          } else {
            localObject = null;
          }
          View localView2 = a(localho, localView1, localViewGroup);
          if (localho != localObject)
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
  
  public final boolean b(ho paramho)
  {
    return false;
  }
  
  public final boolean c(ho paramho)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hg
 * JD-Core Version:    0.7.0.1
 */