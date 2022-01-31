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
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.a;
import com.tencent.token.cz;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.x;

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
  private w x;
  private Handler y = new m(this);
  
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
  
  private String a(String paramString1, String paramString2)
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
  
  public void a()
  {
    if (this.t != null) {
      this.t.recycle();
    }
    if (this.u != null) {
      this.u.recycle();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 3)
    {
      d();
      return;
    }
    c();
  }
  
  public void a(a parama)
  {
    this.c.setText(Html.fromHtml(parama.f()));
    this.d.setText(Html.fromHtml(parama.g()));
    this.h.setText(a(parama.h(), " "));
    this.i.setText(a(parama.i(), " "));
    parama = do.a().c(parama.c());
    if (parama != null)
    {
      this.j.setImageDrawable(com.tencent.token.utils.k.a(parama.b() + "", parama.mUin + ""));
      if (parama.mIsZzb)
      {
        this.k.setImageDrawable(getResources().getDrawable(2130838075));
        this.l.setVisibility(0);
      }
      this.g.setText(parama.mNickName);
      return;
    }
    this.g.setText("");
  }
  
  public boolean a(Context paramContext)
  {
    if ((this.m == null) || ((this.m != null) && (this.m.isFinishing()))) {
      return false;
    }
    this.n = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.o = this.n.inflate(2130968640, null);
    this.o.setVisibility(4);
    this.p = this.o.findViewById(2131558822);
    this.q = this.o.findViewById(2131558808);
    this.r = this.o.findViewById(2131558803);
    this.s = this.o.findViewById(2131558805);
    this.t = x.a(this.m.getResources(), 2130837681);
    this.u = x.a(this.m.getResources(), 2130837680);
    if (this.t != null) {
      ((LinearLayout)this.o.findViewById(2131558809)).setBackgroundDrawable(new BitmapDrawable(this.t));
    }
    if (this.u != null)
    {
      ((LinearLayout)this.o.findViewById(2131558810)).setBackgroundDrawable(new BitmapDrawable(this.u));
      ((LinearLayout)this.o.findViewById(2131558811)).setBackgroundDrawable(new BitmapDrawable(this.u));
    }
    this.a = this.o.findViewById(2131558814);
    this.c = ((TextView)this.o.findViewById(2131558815));
    this.d = ((TextView)this.o.findViewById(2131558816));
    this.b = this.o.findViewById(2131558817);
    this.e = ((TextView)this.o.findViewById(2131558818));
    this.f = ((TextView)this.o.findViewById(2131558819));
    this.j = ((ImageView)this.o.findViewById(2131558824));
    this.k = ((ImageView)this.o.findViewById(2131558825));
    this.l = ((ImageView)this.o.findViewById(2131558826));
    this.h = ((Button)this.o.findViewById(2131558820));
    this.i = ((Button)this.o.findViewById(2131558821));
    this.g = ((TextView)this.o.findViewById(2131558813));
    this.h.setOnClickListener(new k(this));
    this.i.setOnClickListener(new l(this));
    addView(this.o, new RelativeLayout.LayoutParams(-1, -1));
    return true;
  }
  
  public void b()
  {
    this.y.post(new p(this, this.p, this.q, this.r, this.s));
  }
  
  public void b(a parama)
  {
    this.e.setText(Html.fromHtml(parama.f()));
    this.f.setText(Html.fromHtml(parama.g()));
    this.h.setText("  " + Html.fromHtml(parama.h()));
    this.i.setText("  " + Html.fromHtml(parama.i()));
    parama = do.a().c(parama.c());
    if (parama != null)
    {
      this.j.setImageDrawable(com.tencent.token.utils.k.a(parama.b() + "", parama.mUin + ""));
      if (parama.mIsZzb)
      {
        this.k.setImageDrawable(getResources().getDrawable(2130838075));
        this.l.setVisibility(0);
      }
      this.g.setText(parama.mNickName);
    }
    for (;;)
    {
      this.y.post(new n(this, this.a, this.b));
      return;
      this.g.setText("");
      this.l.setVisibility(4);
    }
  }
  
  public void c()
  {
    this.y.post(new r(this, this.p, this.q, this.r, this.s));
    cz.a(RqdApplication.l()).a();
  }
  
  public void d()
  {
    this.y.post(new t(this, this));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.v = this.p.getMeasuredHeight();
    this.w = this.q.getMeasuredHeight();
  }
  
  public void setListener(w paramw)
  {
    this.x = paramw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.DualMsgView
 * JD-Core Version:    0.7.0.1
 */