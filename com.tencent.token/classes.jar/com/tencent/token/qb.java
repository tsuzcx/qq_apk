package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.IndexActivity;
import com.tmsdk.TMSDKContext;

public final class qb
  extends qc
  implements View.OnClickListener
{
  protected TextView a;
  protected LinearLayout b;
  protected TextView c;
  protected ImageView d;
  protected TextView e;
  protected TextView f;
  protected Button g;
  protected ImageView h;
  protected String i;
  protected String j;
  protected String k;
  protected String l;
  protected String m;
  protected String n;
  
  protected final void a()
  {
    super.a();
    this.t = 8000L;
  }
  
  protected final View b()
  {
    this.l = "QQ帐号持续保护中";
    this.m = "你的帐号今天有新的登录足迹";
    this.k = "";
    this.n = "查看";
    this.j = "";
    this.i = "";
    if (TextUtils.isEmpty(this.l)) {
      return null;
    }
    View localView = View.inflate(this.A, 2131296359, null);
    this.a = ((TextView)localView.findViewById(2131166109));
    this.b = ((LinearLayout)localView.findViewById(2131165545));
    this.c = ((TextView)localView.findViewById(2131165546));
    this.d = ((ImageView)localView.findViewById(2131165583));
    this.e = ((TextView)localView.findViewById(2131166112));
    this.f = ((TextView)localView.findViewById(2131166043));
    this.g = ((Button)localView.findViewById(2131165344));
    this.h = ((ImageView)localView.findViewById(2131165383));
    if (!TextUtils.isEmpty(this.i))
    {
      this.a.setVisibility(0);
      this.a.setText(this.i);
    }
    if (!TextUtils.isEmpty(this.j))
    {
      this.b.setVisibility(0);
      TextView localTextView = this.c;
      StringBuilder localStringBuilder = new StringBuilder("·");
      localStringBuilder.append(this.j);
      localTextView.setText(localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(this.k))
    {
      this.d.setVisibility(0);
      this.d.setImageResource(2131099894);
    }
    if (!TextUtils.isEmpty(this.n))
    {
      this.g.setVisibility(0);
      this.g.setText(this.n);
    }
    this.e.setText(this.l);
    this.f.setText(this.m);
    localView.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        qb.this.a(false);
      }
    });
    TMSDKContext.saveActionData(1150174);
    return localView;
  }
  
  protected final int c()
  {
    return qf.a(this.A, 104.0F);
  }
  
  protected final void d()
  {
    super.d();
  }
  
  protected final void e()
  {
    super.e();
  }
  
  protected final void f()
  {
    super.f();
    Intent localIntent = new Intent(this.A, IndexActivity.class);
    localIntent.addFlags(67108864);
    RqdApplication.n().startActivity(localIntent);
    TMSDKContext.saveActionData(1150175);
  }
  
  public final void onClick(View paramView)
  {
    f();
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qb
 * JD-Core Version:    0.7.0.1
 */