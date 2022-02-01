package com.tencent.token.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.token.global.h;

public class m
  extends RelativeLayout
{
  private Context a;
  private LayoutInflater b;
  private View c;
  private CheckBox d;
  private a e;
  
  public m(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramContext;
    a(paramInt);
  }
  
  private void a(final int paramInt)
  {
    this.b = ((LayoutInflater)this.a.getSystemService("layout_inflater"));
    if (paramInt == 0)
    {
      this.c = this.b.inflate(2131296422, null);
      addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
      this.d = ((CheckBox)findViewById(2131165363));
      h.a(paramInt, false);
      this.d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          h.a(paramInt, paramAnonymousBoolean ^ true);
        }
      });
    }
    else
    {
      this.c = this.b.inflate(2131296423, null);
      addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
    }
    findViewById(2131165939).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        m.this.setVisibility(8);
        if (m.a(m.this) != null) {
          m.a(m.this).a();
        }
      }
    });
  }
  
  public void setViewListener(a parama)
  {
    this.e = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.m
 * JD-Core Version:    0.7.0.1
 */