package com.tencent.token.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ErrorView
  extends LinearLayout
{
  private Context a;
  private LayoutInflater b;
  private View c;
  private View.OnClickListener d;
  private int e = 0;
  private boolean f = false;
  private View.OnClickListener g = new aa(this);
  
  public ErrorView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public ErrorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  private void a()
  {
    if (this.f) {}
    for (int i = 2130903079;; i = 2130903078)
    {
      this.b = ((LayoutInflater)this.a.getSystemService("layout_inflater"));
      this.c = this.b.inflate(i, null);
      removeAllViews();
      addView(this.c, new LinearLayout.LayoutParams(-1, -1));
      this.c.setOnClickListener(this.g);
      return;
    }
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == this.e) {
      return;
    }
    this.e = paramInt;
    switch (paramInt)
    {
    default: 
      this.f = false;
      a();
      return;
    }
    this.f = true;
    a();
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    this.d = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ErrorView
 * JD-Core Version:    0.7.0.1
 */