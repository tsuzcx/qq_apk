package com.tencent.token;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class ej
{
  public a a;
  public b b;
  private final Context c;
  
  public ej(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public abstract View a();
  
  public View a(MenuItem paramMenuItem)
  {
    return a();
  }
  
  public void a(SubMenu paramSubMenu) {}
  
  public void a(b paramb)
  {
    if (this.b != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" instance while it is still in use somewhere else?");
    }
    this.b = paramb;
  }
  
  public final void a(boolean paramBoolean)
  {
    a locala = this.a;
    if (locala != null) {
      locala.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ej
 * JD-Core Version:    0.7.0.1
 */