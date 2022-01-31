package com.tencent.token.core.bean;

import android.content.Context;
import android.content.res.Resources;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public final class d
{
  public static int[] a = { 2130837507, 2130837509, 2130837510 };
  public static int[] b = { 2131165335, 2131165344, 2131165345 };
  public static int[] c = { 2131165346, 2131165347, 2131165348 };
  private RelativeLayout d;
  private TextView e;
  private TextView f;
  private ImageView g;
  private EvalAccountResult.RecommendItem h;
  private int i;
  private int j;
  private String k;
  private Context l;
  private View.OnClickListener m;
  
  public d(Context paramContext, RelativeLayout paramRelativeLayout, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView)
  {
    this.d = paramRelativeLayout;
    this.l = paramContext;
    this.e = paramTextView1;
    this.f = paramTextView2;
    this.g = paramImageView;
  }
  
  private String a()
  {
    String str = "";
    if (this.j == 2) {
      str = this.l.getResources().getString(2131362312);
    }
    do
    {
      return str;
      if (this.j == 3) {
        return this.l.getResources().getString(2131362314);
      }
    } while (this.j != 4);
    return this.l.getResources().getString(2131362317);
  }
  
  public final void a(int paramInt)
  {
    this.j = paramInt;
    this.i = 0;
    this.k = a();
    this.g.setVisibility(4);
  }
  
  public final void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      TextView localTextView = this.e;
      localObject = "";
      if (this.j == 2) {
        localObject = this.l.getResources().getString(2131362311);
      }
      for (;;)
      {
        localTextView.setText((CharSequence)localObject);
        this.e.setTextColor(this.l.getResources().getColor(c[2]));
        this.f.setText(a());
        this.f.setTextColor(this.l.getResources().getColor(c[1]));
        this.g.setVisibility(4);
        this.g.clearAnimation();
        this.d.setEnabled(true);
        if (paramOnClickListener == null) {
          break;
        }
        this.d.setOnClickListener(paramOnClickListener);
        return;
        if (this.j == 3) {
          localObject = this.l.getResources().getString(2131362313);
        } else if (this.j == 4) {
          localObject = this.l.getResources().getString(2131362316);
        }
      }
    case 1: 
      this.e.setTextColor(this.l.getResources().getColor(c[1]));
      this.f.setTextColor(this.l.getResources().getColor(c[0]));
      this.g.setVisibility(4);
      this.d.setEnabled(false);
      return;
    case 2: 
      this.e.setTextColor(this.l.getResources().getColor(c[2]));
      localObject = this.f;
      paramOnClickListener = "";
      if (this.j == 2) {
        paramOnClickListener = this.l.getResources().getString(2131362323);
      }
      for (;;)
      {
        ((TextView)localObject).setText(paramOnClickListener);
        this.f.setTextColor(this.l.getResources().getColor(c[1]));
        this.g.setVisibility(0);
        this.g.setImageDrawable(this.l.getResources().getDrawable(2130837508));
        this.g.startAnimation(AnimationUtils.loadAnimation(this.l, 2130968581));
        this.d.setEnabled(false);
        return;
        if (this.j == 3) {
          paramOnClickListener = this.l.getResources().getString(2131362324);
        } else if (this.j == 4) {
          paramOnClickListener = this.l.getResources().getString(2131362325);
        }
      }
    }
    if ((this.i < 0) || (this.i > b.length - 1)) {
      this.i = 0;
    }
    this.e.setTextColor(this.l.getResources().getColor(c[2]));
    this.f.setText(this.k);
    this.f.setTextColor(this.l.getResources().getColor(b[this.i]));
    this.g.clearAnimation();
    this.g.setVisibility(0);
    this.g.setImageDrawable(this.l.getResources().getDrawable(a[this.i]));
    this.d.setEnabled(true);
    this.d.setOnClickListener(this.m);
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    this.m = paramOnClickListener;
  }
  
  public final void a(EvalAccountResult.RecommendItem paramRecommendItem)
  {
    if (paramRecommendItem == null) {
      return;
    }
    this.h = paramRecommendItem;
    this.i = paramRecommendItem.mDegree;
    this.j = paramRecommendItem.mRecommendId;
    this.k = paramRecommendItem.mDesc;
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    a(0, paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.d
 * JD-Core Version:    0.7.0.1
 */