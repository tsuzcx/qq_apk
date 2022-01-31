package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.token.ai;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.b;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.k;
import com.tencent.token.utils.t;

public class DualMsgView
  extends RelativeLayout
{
  private View a;
  private View b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private Button h;
  private Button i;
  private ImageView j;
  private ImageView k;
  private ImageView l;
  private Activity m;
  private LayoutInflater n;
  private View o;
  private View p;
  private View q;
  private View r;
  private View s;
  private Bitmap t;
  private Bitmap u;
  private int v;
  private int w;
  private z x;
  private Handler y = new p(this);
  
  public DualMsgView(Activity paramActivity)
  {
    super(paramActivity);
    this.m = paramActivity;
  }
  
  public DualMsgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.m = ((Activity)paramContext);
  }
  
  public DualMsgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.m = ((Activity)paramContext);
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      return "";
    }
    String str = null;
    int i1 = 0;
    if (i1 < paramString1.length() - 1)
    {
      if (str == null) {}
      for (str = paramString1.substring(i1, i1 + 1);; str = str + paramString1.substring(i1, i1 + 1))
      {
        str = str + paramString2;
        i1 += 1;
        break;
      }
    }
    return str + paramString1.substring(paramString1.length() - 1, paramString1.length());
  }
  
  public final void a()
  {
    if (this.t != null) {
      this.t.recycle();
    }
    if (this.u != null) {
      this.u.recycle();
    }
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == 3)
    {
      this.y.post(new w(this, this));
      return;
    }
    this.y.post(new u(this, this.p, this.q, this.r, this.s));
    ai.a(RqdApplication.i()).a();
  }
  
  public final void a(b paramb)
  {
    this.c.setText(Html.fromHtml(paramb.f()));
    this.d.setText(Html.fromHtml(paramb.g()));
    this.h.setText(a(paramb.h(), " "));
    this.i.setText(a(paramb.i(), " "));
    paramb = ax.a().c(paramb.c());
    if (paramb != null)
    {
      this.j.setImageDrawable(k.a(paramb.mRealUin + "", paramb.mUin + ""));
      if (paramb.mIsZzb)
      {
        this.k.setImageDrawable(getResources().getDrawable(2130838022));
        this.l.setVisibility(0);
      }
      this.g.setText(paramb.mNickName);
      return;
    }
    this.g.setText("");
  }
  
  public final void a(z paramz)
  {
    this.x = paramz;
  }
  
  public final boolean a(Context paramContext)
  {
    if ((this.m == null) || ((this.m != null) && (this.m.isFinishing()))) {
      return false;
    }
    this.n = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.o = this.n.inflate(2130903075, null);
    this.o.setVisibility(4);
    this.p = this.o.findViewById(2131296536);
    this.q = this.o.findViewById(2131296522);
    this.r = this.o.findViewById(2131296517);
    this.s = this.o.findViewById(2131296519);
    this.t = t.a(this.m.getResources(), 2130837596);
    this.u = t.a(this.m.getResources(), 2130837595);
    if (this.t != null) {
      ((LinearLayout)this.o.findViewById(2131296523)).setBackgroundDrawable(new BitmapDrawable(this.t));
    }
    if (this.u != null)
    {
      ((LinearLayout)this.o.findViewById(2131296524)).setBackgroundDrawable(new BitmapDrawable(this.u));
      ((LinearLayout)this.o.findViewById(2131296525)).setBackgroundDrawable(new BitmapDrawable(this.u));
    }
    this.a = this.o.findViewById(2131296528);
    this.c = ((TextView)this.o.findViewById(2131296529));
    this.d = ((TextView)this.o.findViewById(2131296530));
    this.b = this.o.findViewById(2131296531);
    this.e = ((TextView)this.o.findViewById(2131296532));
    this.f = ((TextView)this.o.findViewById(2131296533));
    this.j = ((ImageView)this.o.findViewById(2131296538));
    this.k = ((ImageView)this.o.findViewById(2131296539));
    this.l = ((ImageView)this.o.findViewById(2131296540));
    this.h = ((Button)this.o.findViewById(2131296534));
    this.i = ((Button)this.o.findViewById(2131296535));
    this.g = ((TextView)this.o.findViewById(2131296527));
    this.h.setOnClickListener(new n(this));
    this.i.setOnClickListener(new o(this));
    addView(this.o, new RelativeLayout.LayoutParams(-1, -1));
    return true;
  }
  
  public final void b()
  {
    this.y.post(new s(this, this.p, this.q, this.r, this.s));
  }
  
  public final void b(b paramb)
  {
    this.e.setText(Html.fromHtml(paramb.f()));
    this.f.setText(Html.fromHtml(paramb.g()));
    this.h.setText("  " + Html.fromHtml(paramb.h()));
    this.i.setText("  " + Html.fromHtml(paramb.i()));
    paramb = ax.a().c(paramb.c());
    if (paramb != null)
    {
      this.j.setImageDrawable(k.a(paramb.mRealUin + "", paramb.mUin + ""));
      if (paramb.mIsZzb)
      {
        this.k.setImageDrawable(getResources().getDrawable(2130838022));
        this.l.setVisibility(0);
      }
      this.g.setText(paramb.mNickName);
    }
    for (;;)
    {
      this.y.post(new q(this, this.a, this.b));
      return;
      this.g.setText("");
      this.l.setVisibility(4);
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.v = this.p.getMeasuredHeight();
    this.w = this.q.getMeasuredHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.DualMsgView
 * JD-Core Version:    0.7.0.1
 */