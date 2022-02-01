package com.tencent.token;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class hx
  implements ik
{
  protected Context a;
  protected Context b;
  public id c;
  protected LayoutInflater d;
  protected LayoutInflater e;
  public ik.a f;
  public il g;
  public int h;
  private int i;
  private int j;
  
  public hx(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.i = paramInt1;
    this.j = paramInt2;
  }
  
  public View a(if paramif, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof il.a)) {
      paramView = (il.a)paramView;
    } else {
      paramView = (il.a)this.d.inflate(this.j, paramViewGroup, false);
    }
    a(paramif, paramView);
    return (View)paramView;
  }
  
  public il a(ViewGroup paramViewGroup)
  {
    if (this.g == null)
    {
      this.g = ((il)this.d.inflate(this.i, paramViewGroup, false));
      this.g.a(this.c);
      b(true);
    }
    return this.g;
  }
  
  public void a(Context paramContext, id paramid)
  {
    this.b = paramContext;
    this.e = LayoutInflater.from(this.b);
    this.c = paramid;
  }
  
  public void a(id paramid, boolean paramBoolean)
  {
    ik.a locala = this.f;
    if (locala != null) {
      locala.a(paramid, paramBoolean);
    }
  }
  
  public abstract void a(if paramif, il.a parama);
  
  public final void a(ik.a parama)
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
  
  public boolean a(if paramif)
  {
    return true;
  }
  
  public boolean a(iq paramiq)
  {
    ik.a locala = this.f;
    if (locala != null) {
      return locala.a(paramiq);
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
      ((id)localObject).i();
      ArrayList localArrayList = this.c.h();
      int i1 = localArrayList.size();
      int m = 0;
      int n;
      for (k = 0; m < i1; k = n)
      {
        if localif = (if)localArrayList.get(m);
        n = k;
        if (a(localif))
        {
          View localView1 = localViewGroup.getChildAt(k);
          if ((localView1 instanceof il.a)) {
            localObject = ((il.a)localView1).getItemData();
          } else {
            localObject = null;
          }
          View localView2 = a(localif, localView1, localViewGroup);
          if (localif != localObject)
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
  
  public final boolean b(if paramif)
  {
    return false;
  }
  
  public final boolean c(if paramif)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hx
 * JD-Core Version:    0.7.0.1
 */