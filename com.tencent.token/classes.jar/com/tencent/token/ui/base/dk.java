package com.tencent.token.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.token.global.j;

public class dk
  extends RelativeLayout
{
  private Context a;
  private LayoutInflater b;
  private View c;
  private CheckBox d;
  private dn e;
  
  public dk(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramContext;
    a(paramInt);
  }
  
  private void a(int paramInt)
  {
    this.b = ((LayoutInflater)this.a.getSystemService("layout_inflater"));
    if (paramInt == 0)
    {
      this.c = this.b.inflate(2130968741, null);
      addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
      this.d = ((CheckBox)findViewById(2131559199));
      j.a(paramInt, false);
      this.d.setOnCheckedChangeListener(new dl(this, paramInt));
    }
    for (;;)
    {
      findViewById(2131559198).setOnClickListener(new dm(this));
      return;
      this.c = this.b.inflate(2130968742, null);
      addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
    }
  }
  
  public void setViewListener(dn paramdn)
  {
    this.e = paramdn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.dk
 * JD-Core Version:    0.7.0.1
 */