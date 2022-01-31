package com.tencent.token.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.token.global.g;

public final class dt
  extends RelativeLayout
{
  private Context a;
  private LayoutInflater b;
  private View c;
  private CheckBox d;
  private dw e;
  
  public dt(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = ((LayoutInflater)this.a.getSystemService("layout_inflater"));
    if (paramInt == 0)
    {
      this.c = this.b.inflate(2130903182, null);
      addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
      this.d = ((CheckBox)findViewById(2131297016));
      g.a(paramInt, false);
      this.d.setOnCheckedChangeListener(new du(this, paramInt));
    }
    for (;;)
    {
      findViewById(2131297015).setOnClickListener(new dv(this));
      return;
      this.c = this.b.inflate(2130903183, null);
      addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
    }
  }
  
  public final void a(dw paramdw)
  {
    this.e = paramdw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.dt
 * JD-Core Version:    0.7.0.1
 */