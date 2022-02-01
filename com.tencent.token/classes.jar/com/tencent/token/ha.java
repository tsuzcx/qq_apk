package com.tencent.token;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class ha
{
  Object c;
  boolean d;
  
  public abstract MenuInflater a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(View paramView);
  
  public abstract void a(CharSequence paramCharSequence);
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public abstract Menu b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(CharSequence paramCharSequence);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract CharSequence f();
  
  public abstract CharSequence g();
  
  public boolean h()
  {
    return false;
  }
  
  public abstract View i();
  
  public static abstract interface a
  {
    public abstract void a(ha paramha);
    
    public abstract boolean a(ha paramha, Menu paramMenu);
    
    public abstract boolean a(ha paramha, MenuItem paramMenuItem);
    
    public abstract boolean b(ha paramha, Menu paramMenu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ha
 * JD-Core Version:    0.7.0.1
 */