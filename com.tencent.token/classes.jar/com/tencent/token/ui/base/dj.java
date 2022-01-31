package com.tencent.token.ui.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.h;

public class dj
{
  View a;
  TextView b;
  ProgressBar c;
  SwitchButton d;
  ImageView e;
  ImageView f;
  ImageView g;
  h h;
  
  public dj(View paramView, h paramh)
  {
    this.a = paramView;
    if (this.a == null) {
      return;
    }
    this.h = paramh;
    this.d = ((SwitchButton)this.a.findViewById(2131559356));
    this.b = ((TextView)this.a.findViewById(2131559353));
    this.c = ((ProgressBar)this.a.findViewById(2131559357));
    this.e = ((ImageView)this.a.findViewById(2131559355));
    this.f = ((ImageView)this.a.findViewById(2131559358));
    this.g = ((ImageView)this.a.findViewById(2131559354));
  }
  
  public h a()
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
 * Qualified Name:     com.tencent.token.ui.base.dj
 * JD-Core Version:    0.7.0.1
 */