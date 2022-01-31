package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class TitleOptionMenu
  extends RelativeLayout
{
  public boolean a = false;
  private Context b;
  private View c;
  private View d;
  private int e = 2;
  private dh f;
  private View.OnClickListener g = new de(this);
  private View.OnTouchListener h = new df(this);
  
  public TitleOptionMenu(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
  }
  
  public TitleOptionMenu(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
  }
  
  public final void a()
  {
    Object localObject = getTag();
    if (localObject != null) {
      ((View)localObject).setSelected(false);
    }
    setVisibility(8);
    AnimationUtils.loadAnimation(this.b, 2130968578).setAnimationListener(new dg(this));
  }
  
  public final void a(int paramInt)
  {
    this.e = paramInt;
    this.a = true;
    Object localObject = (LayoutInflater)this.b.getSystemService("layout_inflater");
    if (this.e == 2)
    {
      this.c = ((LayoutInflater)localObject).inflate(2130903217, null);
      addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
      this.d = findViewById(2131297149);
      localObject = findViewById(2131297153);
      ((View)localObject).setTag(Integer.valueOf(0));
      ((View)localObject).setOnClickListener(this.g);
      localObject = findViewById(2131297151);
      ((View)localObject).setTag(Integer.valueOf(1));
      ((View)localObject).setOnClickListener(this.g);
    }
    for (;;)
    {
      this.c.setOnTouchListener(this.h);
      ((ViewGroup)((Activity)this.b).getWindow().getDecorView()).setOnTouchListener(this.h);
      return;
      if (this.e == 3)
      {
        this.c = ((LayoutInflater)localObject).inflate(2130903215, null);
        addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
        this.d = findViewById(2131297149);
        localObject = findViewById(2131297150);
        ((View)localObject).setTag(Integer.valueOf(0));
        ((View)localObject).setOnClickListener(this.g);
        localObject = findViewById(2131297151);
        ((View)localObject).setTag(Integer.valueOf(1));
        ((View)localObject).setOnClickListener(this.g);
      }
      else if (this.e == 4)
      {
        this.c = ((LayoutInflater)localObject).inflate(2130903214, null);
        addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
        this.d = findViewById(2131297149);
        localObject = findViewById(2131297150);
        ((View)localObject).setTag(Integer.valueOf(0));
        ((View)localObject).setOnClickListener(this.g);
        localObject = findViewById(2131297151);
        ((View)localObject).setTag(Integer.valueOf(1));
        ((View)localObject).setOnClickListener(this.g);
      }
      else if (this.e == 5)
      {
        this.c = ((LayoutInflater)localObject).inflate(2130903213, null);
        addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
        this.d = findViewById(2131297149);
        localObject = findViewById(2131297150);
        ((View)localObject).setTag(Integer.valueOf(0));
        ((View)localObject).setOnClickListener(this.g);
        localObject = findViewById(2131297151);
        ((View)localObject).setTag(Integer.valueOf(1));
        ((View)localObject).setOnClickListener(this.g);
      }
    }
  }
  
  public final void a(dh paramdh)
  {
    this.f = paramdh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.TitleOptionMenu
 * JD-Core Version:    0.7.0.1
 */