package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.core.bean.EvalAccountResult.RecommendItem;

public final class sq
{
  public static int[] b = { 2131099734, 2131099735, 2131099736 };
  public static int[] c = { 2130968787, 2130968653, 2130968654 };
  public static int[] d = { 2130968677, 2130968676, 2130968675 };
  public View.OnClickListener a;
  private RelativeLayout e;
  private TextView f;
  private TextView g;
  private ImageView h;
  private ImageView i;
  private EvalAccountResult.RecommendItem j;
  private int k;
  private int l;
  private String m;
  private Context n;
  
  public sq(Context paramContext, RelativeLayout paramRelativeLayout, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView1, ImageView paramImageView2)
  {
    this.e = paramRelativeLayout;
    this.n = paramContext;
    this.f = paramTextView1;
    this.g = paramTextView2;
    this.h = paramImageView1;
    this.i = paramImageView2;
  }
  
  private String a()
  {
    String str = "";
    int i1 = this.l;
    if (i1 == 2) {
      return this.n.getResources().getString(2131493400);
    }
    if (i1 == 4) {
      str = this.n.getResources().getString(2131493397);
    }
    return str;
  }
  
  public final void a(int paramInt)
  {
    this.l = paramInt;
    this.k = 0;
    this.m = a();
    this.h.setVisibility(4);
    this.i.setVisibility(4);
  }
  
  public final void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      paramInt = this.k;
      if ((paramInt < 0) || (paramInt > c.length - 1)) {
        this.k = 0;
      }
      this.f.setTextColor(this.n.getResources().getColor(d[2]));
      this.g.setText(this.m);
      this.g.setTextColor(this.n.getResources().getColor(c[this.k]));
      this.h.clearAnimation();
      if (this.k != 0)
      {
        this.h.setVisibility(0);
        this.h.setImageDrawable(this.n.getResources().getDrawable(b[this.k]));
      }
      this.i.setVisibility(0);
      this.e.setEnabled(true);
      this.e.setOnClickListener(this.a);
      return;
    case 2: 
      this.f.setTextColor(this.n.getResources().getColor(d[2]));
      localObject = this.g;
      paramOnClickListener = "";
      paramInt = this.l;
      if (paramInt == 2) {
        paramOnClickListener = this.n.getResources().getString(2131493281);
      } else if (paramInt == 4) {
        paramOnClickListener = this.n.getResources().getString(2131493274);
      }
      ((TextView)localObject).setText(paramOnClickListener);
      this.g.setTextColor(this.n.getResources().getColor(d[1]));
      this.e.setEnabled(false);
      return;
    case 1: 
      this.f.setTextColor(this.n.getResources().getColor(d[1]));
      this.g.setTextColor(this.n.getResources().getColor(d[0]));
      this.h.setVisibility(4);
      this.i.setVisibility(4);
      this.e.setEnabled(false);
      return;
    }
    TextView localTextView = this.f;
    Object localObject = "";
    paramInt = this.l;
    if (paramInt == 2) {
      localObject = this.n.getResources().getString(2131493399);
    } else if (paramInt == 4) {
      localObject = this.n.getResources().getString(2131493396);
    }
    localTextView.setText((CharSequence)localObject);
    this.f.setTextColor(this.n.getResources().getColor(d[2]));
    this.g.setText(a());
    this.g.setTextColor(this.n.getResources().getColor(d[1]));
    this.h.setVisibility(4);
    this.i.setVisibility(0);
    this.h.clearAnimation();
    this.e.setEnabled(true);
    if (paramOnClickListener != null)
    {
      this.e.setOnClickListener(paramOnClickListener);
      return;
    }
  }
  
  public final void a(EvalAccountResult.RecommendItem paramRecommendItem)
  {
    if (paramRecommendItem == null) {
      return;
    }
    this.j = paramRecommendItem;
    this.k = paramRecommendItem.mDegree;
    this.l = paramRecommendItem.mRecommendId;
    this.m = paramRecommendItem.mDesc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sq
 * JD-Core Version:    0.7.0.1
 */