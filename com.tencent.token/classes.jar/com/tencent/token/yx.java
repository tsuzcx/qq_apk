package com.tencent.token;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public final class yx
  extends RelativeLayout
{
  private Context a;
  private LayoutInflater b;
  private View c;
  private CheckBox d;
  private a e;
  
  public yx(Context paramContext, final int paramInt)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = ((LayoutInflater)this.a.getSystemService("layout_inflater"));
    if (paramInt == 0)
    {
      this.c = this.b.inflate(2131296423, null);
      addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
      this.d = ((CheckBox)findViewById(2131165367));
      xc.a(paramInt, false);
      this.d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          xc.a(paramInt, paramAnonymousBoolean ^ true);
        }
      });
    }
    else
    {
      this.c = this.b.inflate(2131296424, null);
      addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
    }
    findViewById(2131165946).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        yx.this.setVisibility(8);
        if (yx.a(yx.this) != null) {
          yx.a(yx.this).a();
        }
      }
    });
  }
  
  public final void setViewListener(a parama)
  {
    this.e = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yx
 * JD-Core Version:    0.7.0.1
 */