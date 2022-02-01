package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.token.gs.j;
import com.tencent.token.ha;
import com.tencent.token.ha.a;

public abstract class ActionBar
{
  public abstract int a();
  
  public ha a(ha.a parama)
  {
    return null;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
  }
  
  public void a(int paramInt) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(CharSequence paramCharSequence) {}
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public Context b()
  {
    return null;
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
  }
  
  public void c(boolean paramBoolean) {}
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public boolean f()
  {
    return false;
  }
  
  public boolean g()
  {
    return false;
  }
  
  protected void h() {}
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int a = 0;
    
    public LayoutParams()
    {
      super(-2);
      this.a = 8388627;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, gs.j.ActionBarLayout);
      this.a = paramContext.getInt(gs.j.ActionBarLayout_android_layout_gravity, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.a = paramLayoutParams.a;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  @Deprecated
  public static abstract class a
  {
    public abstract Drawable a();
    
    public abstract CharSequence b();
    
    public abstract View c();
    
    public abstract CharSequence d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBar
 * JD-Core Version:    0.7.0.1
 */