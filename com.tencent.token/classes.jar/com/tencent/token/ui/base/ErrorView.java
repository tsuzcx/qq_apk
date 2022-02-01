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
  private View.OnClickListener g = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (ErrorView.a(ErrorView.this) != null)
      {
        paramAnonymousView.setTag(ErrorView.this.getTag());
        ErrorView.a(ErrorView.this).onClick(paramAnonymousView);
        ErrorView.this.setVisibility(8);
        return;
      }
      ErrorView.this.setVisibility(8);
    }
  };
  
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
  
  private void c()
  {
    int i;
    if (this.f) {
      i = 2131296324;
    } else {
      i = 2131296323;
    }
    this.b = ((LayoutInflater)this.a.getSystemService("layout_inflater"));
    this.c = this.b.inflate(i, null);
    removeAllViews();
    addView(this.c, new LinearLayout.LayoutParams(-1, -1));
    this.c.setOnClickListener(this.g);
  }
  
  public void a()
  {
    setVisibility(0);
  }
  
  public void b()
  {
    setVisibility(8);
  }
  
  public void setAction(View.OnClickListener paramOnClickListener)
  {
    this.d = paramOnClickListener;
  }
  
  public void setErrorType(int paramInt)
  {
    if (paramInt == this.e) {
      return;
    }
    this.e = paramInt;
    if ((paramInt != 10005) && (paramInt != 100004)) {
      switch (paramInt)
      {
      default: 
        this.f = false;
        c();
        return;
      }
    }
    this.f = true;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ErrorView
 * JD-Core Version:    0.7.0.1
 */