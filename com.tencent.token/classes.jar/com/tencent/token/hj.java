package com.tencent.token;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertController.a;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.a;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public final class hj
  implements AdapterView.OnItemClickListener, hs
{
  Context a;
  LayoutInflater b;
  hl c;
  ExpandedMenuView d;
  int e;
  int f;
  int g;
  public hs.a h;
  a i;
  
  private hj(int paramInt)
  {
    this.g = paramInt;
    this.f = 0;
  }
  
  public hj(Context paramContext, int paramInt)
  {
    this(paramInt);
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a);
  }
  
  public final ht a(ViewGroup paramViewGroup)
  {
    if (this.d == null)
    {
      this.d = ((ExpandedMenuView)this.b.inflate(go.g.abc_expanded_menu_layout, paramViewGroup, false));
      if (this.i == null) {
        this.i = new a();
      }
      this.d.setAdapter(this.i);
      this.d.setOnItemClickListener(this);
    }
    return this.d;
  }
  
  public final void a(Context paramContext, hl paramhl)
  {
    int j = this.f;
    if (j != 0)
    {
      this.a = new ContextThemeWrapper(paramContext, j);
      this.b = LayoutInflater.from(this.a);
    }
    else if (this.a != null)
    {
      this.a = paramContext;
      if (this.b == null) {
        this.b = LayoutInflater.from(this.a);
      }
    }
    this.c = paramhl;
    paramContext = this.i;
    if (paramContext != null) {
      paramContext.notifyDataSetChanged();
    }
  }
  
  public final void a(hl paramhl, boolean paramBoolean)
  {
    hs.a locala = this.h;
    if (locala != null) {
      locala.a(paramhl, paramBoolean);
    }
  }
  
  public final void a(hs.a parama)
  {
    this.h = parama;
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(hy paramhy)
  {
    if (!paramhy.hasVisibleItems()) {
      return false;
    }
    Object localObject1 = new hm(paramhy);
    Object localObject3 = ((hm)localObject1).a;
    Object localObject2 = new AlertDialog.a(((hl)localObject3).a);
    ((hm)localObject1).c = new hj(((AlertDialog.a)localObject2).a.a, go.g.abc_list_menu_item_layout);
    ((hm)localObject1).c.h = ((hs.a)localObject1);
    ((hm)localObject1).a.a(((hm)localObject1).c);
    Object localObject4 = ((hm)localObject1).c.b();
    ((AlertDialog.a)localObject2).a.w = ((ListAdapter)localObject4);
    ((AlertDialog.a)localObject2).a.x = ((DialogInterface.OnClickListener)localObject1);
    localObject4 = ((hl)localObject3).h;
    if (localObject4 != null)
    {
      ((AlertDialog.a)localObject2).a.g = ((View)localObject4);
    }
    else
    {
      localObject4 = ((hl)localObject3).g;
      ((AlertDialog.a)localObject2).a.d = ((Drawable)localObject4);
      localObject3 = ((hl)localObject3).f;
      ((AlertDialog.a)localObject2).a.f = ((CharSequence)localObject3);
    }
    ((AlertDialog.a)localObject2).a.u = ((DialogInterface.OnKeyListener)localObject1);
    ((hm)localObject1).b = ((AlertDialog.a)localObject2).a();
    ((hm)localObject1).b.setOnDismissListener((DialogInterface.OnDismissListener)localObject1);
    localObject2 = ((hm)localObject1).b.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).type = 1003;
    ((WindowManager.LayoutParams)localObject2).flags |= 0x20000;
    ((hm)localObject1).b.show();
    localObject1 = this.h;
    if (localObject1 != null) {
      ((hs.a)localObject1).a(paramhy);
    }
    return true;
  }
  
  public final ListAdapter b()
  {
    if (this.i == null) {
      this.i = new a();
    }
    return this.i;
  }
  
  public final void b(boolean paramBoolean)
  {
    a locala = this.i;
    if (locala != null) {
      locala.notifyDataSetChanged();
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
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.c.a(this.i.a(paramInt), this, 0);
  }
  
  final class a
    extends BaseAdapter
  {
    private int b = -1;
    
    public a()
    {
      a();
    }
    
    private void a()
    {
      hn localhn = hj.this.c.j;
      if (localhn != null)
      {
        ArrayList localArrayList = hj.this.c.j();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((hn)localArrayList.get(i) == localhn)
          {
            this.b = i;
            return;
          }
          i += 1;
        }
      }
      this.b = -1;
    }
    
    public final hn a(int paramInt)
    {
      ArrayList localArrayList = hj.this.c.j();
      int i = paramInt + hj.this.e;
      int j = this.b;
      paramInt = i;
      if (j >= 0)
      {
        paramInt = i;
        if (i >= j) {
          paramInt = i + 1;
        }
      }
      return (hn)localArrayList.get(paramInt);
    }
    
    public final int getCount()
    {
      int i = hj.this.c.j().size() - hj.this.e;
      if (this.b < 0) {
        return i;
      }
      return i - 1;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = hj.this.b.inflate(hj.this.g, paramViewGroup, false);
      }
      ((ht.a)localView).a(a(paramInt));
      return localView;
    }
    
    public final void notifyDataSetChanged()
    {
      a();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hj
 * JD-Core Version:    0.7.0.1
 */