package com.tencent.token.core.bean;

import android.content.Context;
import android.content.res.Resources;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class d
{
  public static int[] a = { 2131099734, 2131099735, 2131099736 };
  public static int[] b = { 2130968787, 2130968653, 2130968654 };
  public static int[] c = { 2130968677, 2130968676, 2130968675 };
  private RelativeLayout d;
  private TextView e;
  private TextView f;
  private ImageView g;
  private ImageView h;
  private EvalAccountResult.RecommendItem i;
  private int j;
  private int k;
  private String l;
  private Context m;
  private View.OnClickListener n;
  
  public d(Context paramContext, RelativeLayout paramRelativeLayout, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView1, EvalAccountResult.RecommendItem paramRecommendItem, ImageView paramImageView2)
  {
    this.d = paramRelativeLayout;
    this.m = paramContext;
    this.e = paramTextView1;
    this.f = paramTextView2;
    this.g = paramImageView1;
    this.h = paramImageView2;
    if (paramRecommendItem != null)
    {
      this.i = paramRecommendItem;
      this.j = paramRecommendItem.mDegree;
      this.k = paramRecommendItem.mRecommendId;
      this.l = paramRecommendItem.mDesc;
    }
  }
  
  private String a()
  {
    String str = "";
    int i1 = this.k;
    if (i1 == 2) {
      return this.m.getResources().getString(2131493398);
    }
    if (i1 == 4) {
      str = this.m.getResources().getString(2131493395);
    }
    return str;
  }
  
  private String b()
  {
    String str = "";
    int i1 = this.k;
    if (i1 == 2) {
      return this.m.getResources().getString(2131493399);
    }
    if (i1 == 4) {
      str = this.m.getResources().getString(2131493396);
    }
    return str;
  }
  
  private String c()
  {
    String str = "";
    int i1 = this.k;
    if (i1 == 2) {
      return this.m.getResources().getString(2131493280);
    }
    if (i1 == 4) {
      str = this.m.getResources().getString(2131493273);
    }
    return str;
  }
  
  public void a(int paramInt)
  {
    this.k = paramInt;
    this.j = 0;
    this.l = b();
    this.g.setVisibility(4);
    this.h.setVisibility(4);
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      paramInt = this.j;
      if ((paramInt < 0) || (paramInt > b.length - 1)) {
        this.j = 0;
      }
      this.e.setTextColor(this.m.getResources().getColor(c[2]));
      this.f.setText(this.l);
      this.f.setTextColor(this.m.getResources().getColor(b[this.j]));
      this.g.clearAnimation();
      if (this.j != 0)
      {
        this.g.setVisibility(0);
        this.g.setImageDrawable(this.m.getResources().getDrawable(a[this.j]));
      }
      this.h.setVisibility(0);
      this.d.setEnabled(true);
      this.d.setOnClickListener(this.n);
      return;
    case 2: 
      this.e.setTextColor(this.m.getResources().getColor(c[2]));
      this.f.setText(c());
      this.f.setTextColor(this.m.getResources().getColor(c[1]));
      this.d.setEnabled(false);
      return;
    case 1: 
      this.e.setTextColor(this.m.getResources().getColor(c[1]));
      this.f.setTextColor(this.m.getResources().getColor(c[0]));
      this.g.setVisibility(4);
      this.h.setVisibility(4);
      this.d.setEnabled(false);
      return;
    }
    this.e.setText(a());
    this.e.setTextColor(this.m.getResources().getColor(c[2]));
    this.f.setText(b());
    this.f.setTextColor(this.m.getResources().getColor(c[1]));
    this.g.setVisibility(4);
    this.h.setVisibility(0);
    this.g.clearAnimation();
    this.d.setEnabled(true);
    if (paramOnClickListener != null) {
      this.d.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.n = paramOnClickListener;
  }
  
  public void a(EvalAccountResult.RecommendItem paramRecommendItem)
  {
    if (paramRecommendItem == null) {
      return;
    }
    this.i = paramRecommendItem;
    this.j = paramRecommendItem.mDegree;
    this.k = paramRecommendItem.mRecommendId;
    this.l = paramRecommendItem.mDesc;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    a(0, paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.d
 * JD-Core Version:    0.7.0.1
 */