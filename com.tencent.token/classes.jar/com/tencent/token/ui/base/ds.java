package com.tencent.token.ui.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.g;

public final class ds
{
  View a;
  TextView b;
  ProgressBar c;
  SwitchButton d;
  ImageView e;
  ImageView f;
  ImageView g;
  g h;
  
  public ds(View paramView, g paramg)
  {
    this.a = paramView;
    if (this.a == null) {
      return;
    }
    this.h = paramg;
    this.d = ((SwitchButton)this.a.findViewById(2131297196));
    this.b = ((TextView)this.a.findViewById(2131297193));
    this.c = ((ProgressBar)this.a.findViewById(2131297197));
    this.e = ((ImageView)this.a.findViewById(2131297195));
    this.f = ((ImageView)this.a.findViewById(2131297198));
    this.g = ((ImageView)this.a.findViewById(2131297194));
  }
  
  public final g a()
  {
    return this.h;
  }
  
  public final SwitchButton b()
  {
    return this.d;
  }
  
  public final TextView c()
  {
    return this.b;
  }
  
  public final ProgressBar d()
  {
    return this.c;
  }
  
  public final ImageView e()
  {
    return this.e;
  }
  
  public final ImageView f()
  {
    return this.f;
  }
  
  public final ImageView g()
  {
    return this.g;
  }
  
  public final View h()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ds
 * JD-Core Version:    0.7.0.1
 */