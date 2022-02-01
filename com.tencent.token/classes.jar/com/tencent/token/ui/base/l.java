package com.tencent.token.ui.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.f;

public class l
{
  View a;
  TextView b;
  ProgressBar c;
  SwitchButton d;
  ImageView e;
  ImageView f;
  ImageView g;
  f h;
  
  public l(View paramView, f paramf)
  {
    this.a = paramView;
    paramView = this.a;
    if (paramView == null) {
      return;
    }
    this.h = paramf;
    this.d = ((SwitchButton)paramView.findViewById(2131166205));
    this.b = ((TextView)this.a.findViewById(2131166234));
    this.c = ((ProgressBar)this.a.findViewById(2131166209));
    this.e = ((ImageView)this.a.findViewById(2131166235));
    this.f = ((ImageView)this.a.findViewById(2131166204));
    this.g = ((ImageView)this.a.findViewById(2131166233));
  }
  
  public f a()
  {
    return this.h;
  }
  
  public SwitchButton b()
  {
    return this.d;
  }
  
  public TextView c()
  {
    return this.b;
  }
  
  public ProgressBar d()
  {
    return this.c;
  }
  
  public ImageView e()
  {
    return this.e;
  }
  
  public ImageView f()
  {
    return this.f;
  }
  
  public ImageView g()
  {
    return this.g;
  }
  
  public View h()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.l
 * JD-Core Version:    0.7.0.1
 */