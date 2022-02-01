package com.tencent.token;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.MenuItem;

public final class fe
{
  static final c a = new b();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      a = new a();
      return;
    }
  }
  
  public static MenuItem a(MenuItem paramMenuItem, fa paramfa)
  {
    if ((paramMenuItem instanceof ef)) {
      return ((ef)paramMenuItem).a(paramfa);
    }
    return paramMenuItem;
  }
  
  public static void a(MenuItem paramMenuItem, char paramChar, int paramInt)
  {
    if ((paramMenuItem instanceof ef))
    {
      ((ef)paramMenuItem).setNumericShortcut(paramChar, paramInt);
      return;
    }
    a.b(paramMenuItem, paramChar, paramInt);
  }
  
  public static void a(MenuItem paramMenuItem, ColorStateList paramColorStateList)
  {
    if ((paramMenuItem instanceof ef))
    {
      ((ef)paramMenuItem).setIconTintList(paramColorStateList);
      return;
    }
    a.a(paramMenuItem, paramColorStateList);
  }
  
  public static void a(MenuItem paramMenuItem, PorterDuff.Mode paramMode)
  {
    if ((paramMenuItem instanceof ef))
    {
      ((ef)paramMenuItem).setIconTintMode(paramMode);
      return;
    }
    a.a(paramMenuItem, paramMode);
  }
  
  public static void a(MenuItem paramMenuItem, CharSequence paramCharSequence)
  {
    if ((paramMenuItem instanceof ef))
    {
      ((ef)paramMenuItem).a(paramCharSequence);
      return;
    }
    a.a(paramMenuItem, paramCharSequence);
  }
  
  public static void b(MenuItem paramMenuItem, char paramChar, int paramInt)
  {
    if ((paramMenuItem instanceof ef))
    {
      ((ef)paramMenuItem).setAlphabeticShortcut(paramChar, paramInt);
      return;
    }
    a.a(paramMenuItem, paramChar, paramInt);
  }
  
  public static void b(MenuItem paramMenuItem, CharSequence paramCharSequence)
  {
    if ((paramMenuItem instanceof ef))
    {
      ((ef)paramMenuItem).b(paramCharSequence);
      return;
    }
    a.b(paramMenuItem, paramCharSequence);
  }
  
  static final class a
    extends fe.b
  {
    public final void a(MenuItem paramMenuItem, char paramChar, int paramInt)
    {
      paramMenuItem.setAlphabeticShortcut(paramChar, paramInt);
    }
    
    public final void a(MenuItem paramMenuItem, ColorStateList paramColorStateList)
    {
      paramMenuItem.setIconTintList(paramColorStateList);
    }
    
    public final void a(MenuItem paramMenuItem, PorterDuff.Mode paramMode)
    {
      paramMenuItem.setIconTintMode(paramMode);
    }
    
    public final void a(MenuItem paramMenuItem, CharSequence paramCharSequence)
    {
      paramMenuItem.setContentDescription(paramCharSequence);
    }
    
    public final void b(MenuItem paramMenuItem, char paramChar, int paramInt)
    {
      paramMenuItem.setNumericShortcut(paramChar, paramInt);
    }
    
    public final void b(MenuItem paramMenuItem, CharSequence paramCharSequence)
    {
      paramMenuItem.setTooltipText(paramCharSequence);
    }
  }
  
  static class b
    implements fe.c
  {
    public void a(MenuItem paramMenuItem, char paramChar, int paramInt) {}
    
    public void a(MenuItem paramMenuItem, ColorStateList paramColorStateList) {}
    
    public void a(MenuItem paramMenuItem, PorterDuff.Mode paramMode) {}
    
    public void a(MenuItem paramMenuItem, CharSequence paramCharSequence) {}
    
    public void b(MenuItem paramMenuItem, char paramChar, int paramInt) {}
    
    public void b(MenuItem paramMenuItem, CharSequence paramCharSequence) {}
  }
  
  static abstract interface c
  {
    public abstract void a(MenuItem paramMenuItem, char paramChar, int paramInt);
    
    public abstract void a(MenuItem paramMenuItem, ColorStateList paramColorStateList);
    
    public abstract void a(MenuItem paramMenuItem, PorterDuff.Mode paramMode);
    
    public abstract void a(MenuItem paramMenuItem, CharSequence paramCharSequence);
    
    public abstract void b(MenuItem paramMenuItem, char paramChar, int paramInt);
    
    public abstract void b(MenuItem paramMenuItem, CharSequence paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fe
 * JD-Core Version:    0.7.0.1
 */