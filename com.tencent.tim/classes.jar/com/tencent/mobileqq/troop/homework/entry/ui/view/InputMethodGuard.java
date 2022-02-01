package com.tencent.mobileqq.troop.homework.entry.ui.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import ankt;

public class InputMethodGuard
  extends View
{
  private a a = null;
  private boolean cQM = true;
  private int dUl = 0;
  private boolean mIsActive = false;
  
  public InputMethodGuard(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InputMethodGuard(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InputMethodGuard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    getViewTreeObserver().addOnGlobalLayoutListener(new b(null));
  }
  
  public boolean aBe()
  {
    return this.mIsActive;
  }
  
  public void setOnInputMethodChangeListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bE(boolean paramBoolean, int paramInt);
  }
  
  class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private b() {}
    
    private int getScreenHeight()
    {
      if (ankt.cIE > 0) {
        return ankt.cIE;
      }
      return ((WindowManager)InputMethodGuard.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
    }
    
    public void onGlobalLayout()
    {
      boolean bool = InputMethodGuard.a(InputMethodGuard.this);
      Rect localRect = new Rect();
      ((Activity)InputMethodGuard.this.getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      int i = getScreenHeight();
      int j = i - localRect.bottom;
      if (Math.abs(j) > i / 5)
      {
        InputMethodGuard.a(InputMethodGuard.this, true);
        InputMethodGuard.a(InputMethodGuard.this, j);
      }
      for (;;)
      {
        if ((InputMethodGuard.a(InputMethodGuard.this) != null) && ((bool != InputMethodGuard.a(InputMethodGuard.this)) || (InputMethodGuard.b(InputMethodGuard.this)))) {
          InputMethodGuard.a(InputMethodGuard.this).bE(InputMethodGuard.a(InputMethodGuard.this), InputMethodGuard.a(InputMethodGuard.this));
        }
        if (InputMethodGuard.b(InputMethodGuard.this)) {
          InputMethodGuard.b(InputMethodGuard.this, false);
        }
        return;
        InputMethodGuard.a(InputMethodGuard.this, false);
        InputMethodGuard.a(InputMethodGuard.this, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard
 * JD-Core Version:    0.7.0.1
 */