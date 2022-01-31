package com.tencent.token.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.h;
import com.tencent.token.ui.base.SwitchButton;

class kf
{
  View a;
  TextView b;
  ProgressBar c;
  SwitchButton d;
  ImageView e;
  h f;
  
  kf(kb paramkb, View paramView, h paramh)
  {
    this.a = paramView;
    if (this.a == null) {
      return;
    }
    this.f = paramh;
    this.d = ((SwitchButton)this.a.findViewById(2131559373));
    this.b = ((TextView)this.a.findViewById(2131559371));
    this.c = ((ProgressBar)this.a.findViewById(2131559374));
    this.e = ((ImageView)this.a.findViewById(2131559372));
  }
  
  public h a()
  {
    return this.f;
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
  
  public View f()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kf
 * JD-Core Version:    0.7.0.1
 */