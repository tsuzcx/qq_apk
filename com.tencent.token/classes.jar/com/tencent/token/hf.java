package com.tencent.token;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class hf
  implements hs
{
  protected Context a;
  protected Context b;
  public hl c;
  protected LayoutInflater d;
  protected LayoutInflater e;
  public hs.a f;
  public ht g;
  public int h;
  private int i;
  private int j;
  
  public hf(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.i = paramInt1;
    this.j = paramInt2;
  }
  
  public View a(hn paramhn, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof ht.a)) {
      paramView = (ht.a)paramView;
    } else {
      paramView = (ht.a)this.d.inflate(this.j, paramViewGroup, false);
    }
    a(paramhn, paramView);
    return (View)paramView;
  }
  
  public ht a(ViewGroup paramViewGroup)
  {
    if (this.g == null)
    {
      this.g = ((ht)this.d.inflate(this.i, paramViewGroup, false));
      this.g.a(this.c);
      b(true);
    }
    return this.g;
  }
  
  public void a(Context paramContext, hl paramhl)
  {
    this.b = paramContext;
    this.e = LayoutInflater.from(this.b);
    this.c = paramhl;
  }
  
  public void a(hl paramhl, boolean paramBoolean)
  {
    hs.a locala = this.f;
    if (locala != null) {
      locala.a(paramhl, paramBoolean);
    }
  }
  
  public abstract void a(hn paramhn, ht.a parama);
  
  public final void a(hs.a parama)
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
  
  public boolean a(hn paramhn)
  {
    return true;
  }
  
  public boolean a(hy paramhy)
  {
    hs.a locala = this.f;
    if (locala != null) {
      return locala.a(paramhy);
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
      ((hl)localObject).i();
      ArrayList localArrayList = this.c.h();
      int i1 = localArrayList.size();
      int m = 0;
      int n;
      for (k = 0; m < i1; k = n)
      {
        hn localhn = (hn)localArrayList.get(m);
        n = k;
        if (a(localhn))
        {
          View localView1 = localViewGroup.getChildAt(k);
          if ((localView1 instanceof ht.a)) {
            localObject = ((ht.a)localView1).getItemData();
          } else {
            localObject = null;
          }
          View localView2 = a(localhn, localView1, localViewGroup);
          if (localhn != localObject)
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
  
  public final boolean b(hn paramhn)
  {
    return false;
  }
  
  public final boolean c(hn paramhn)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hf
 * JD-Core Version:    0.7.0.1
 */