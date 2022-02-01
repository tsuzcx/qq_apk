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
import com.tencent.token.aad;
import com.tencent.token.xj;

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
    setOnFocusChangeListener(this);
    setFocusable(true);
    setFocusableInTouchMode(true);
    ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this, 0);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b = aad.a().j;
    this.c = 0L;
    if (this.b != null)
    {
      this.c = (System.currentTimeMillis() - (SystemClock.uptimeMillis() - this.b.getDownTime()));
      this.d = ((int)this.b.getRawX());
      this.e = ((int)this.b.getRawY());
    }
    this.f = "";
    Context localContext = this.a;
    if (localContext != null) {
      try
      {
        this.f = ((Activity)localContext).getLocalClassName();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    if (paramBoolean)
    {
      if (getText() != null)
      {
        localStringBuilder = new StringBuilder("focus start:");
        localStringBuilder.append(getText().toString());
        xj.c(localStringBuilder.toString());
        aad.a().a(aad.c, "", this.f, getClass().getName(), getText().toString(), "", this.d, this.e, this.c);
        aad.a().b();
      }
    }
    else if (getText() != null)
    {
      localStringBuilder = new StringBuilder("focus end");
      localStringBuilder.append(getText().toString());
      xj.c(localStringBuilder.toString());
      aad.a().a(aad.d, "", this.f, getClass().getName(), getText().toString(), "", this.d, this.e, this.c);
    }
    StringBuilder localStringBuilder = new StringBuilder("pagename:");
    localStringBuilder.append(this.f);
    xj.c(localStringBuilder.toString());
    localStringBuilder = new StringBuilder("ctrlName:");
    localStringBuilder.append(getClass().getName());
    xj.c(localStringBuilder.toString());
    localStringBuilder = new StringBuilder("getRawX:");
    localStringBuilder.append(this.d);
    xj.c(localStringBuilder.toString());
    localStringBuilder = new StringBuilder("getRawY:");
    localStringBuilder.append(this.e);
    xj.c(localStringBuilder.toString());
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