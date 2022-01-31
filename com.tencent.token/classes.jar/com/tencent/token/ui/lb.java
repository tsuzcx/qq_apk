package com.tencent.token.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.g;
import com.tencent.token.ui.base.SwitchButton;

final class lb
{
  View a;
  TextView b;
  ProgressBar c;
  SwitchButton d;
  ImageView e;
  g f;
  
  lb(kx paramkx, View paramView, g paramg)
  {
    this.a = paramView;
    if (this.a == null) {
      return;
    }
    this.f = paramg;
    this.d = ((SwitchButton)this.a.findViewById(2131297213));
    this.b = ((TextView)this.a.findViewById(2131297211));
    this.c = ((ProgressBar)this.a.findViewById(2131297214));
    this.e = ((ImageView)this.a.findViewById(2131297212));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.lb
 * JD-Core Version:    0.7.0.1
 */