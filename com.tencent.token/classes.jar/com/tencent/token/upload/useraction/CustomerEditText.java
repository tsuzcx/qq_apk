package com.tencent.token.upload.useraction;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.token.global.h;

public class CustomerEditText
  extends EditText
  implements View.OnFocusChangeListener
{
  private Context a;
  private MotionEvent b;
  private long c = 0L;
  private int d = 0;
  private int e = 0;
  private String f = "";
  
  public CustomerEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CustomerEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }
  
  public CustomerEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    this.b = null;
    this.c = 0L;
    this.f = "";
    a();
  }
  
  private void a()
  {
    setOnFocusChangeListener(this);
    setFocusable(true);
    setFocusableInTouchMode(true);
    ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = a.a().b();
    this.c = 0L;
    if (this.b != null)
    {
      this.c = (System.currentTimeMillis() - (SystemClock.uptimeMillis() - this.b.getDownTime()));
      this.d = ((int)this.b.getRawX());
      this.e = ((int)this.b.getRawY());
    }
    this.f = "";
    if (this.a != null) {}
    try
    {
      this.f = ((Activity)this.a).getLocalClassName();
      if (paramBoolean)
      {
        if (getText() != null)
        {
          h.c("focus start:" + getText().toString());
          a.a().a(a.c, "", this.f, getClass().getName(), getText().toString(), "", this.d, this.e, this.c);
          a.a().d();
        }
        h.c("pagename:" + this.f);
        h.c("ctrlName:" + getClass().getName());
        h.c("getRawX:" + this.d);
        h.c("getRawY:" + this.e);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        if (getText() != null)
        {
          h.c("focus end" + getText().toString());
          a.a().a(a.d, "", this.f, getClass().getName(), getText().toString(), "", this.d, this.e, this.c);
        }
      }
    }
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.upload.useraction.CustomerEditText
 * JD-Core Version:    0.7.0.1
 */