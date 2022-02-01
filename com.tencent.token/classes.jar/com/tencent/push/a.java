package com.tencent.push;

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

public class a
  extends b
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
  
  private void m() {}
  
  protected void a()
  {
    super.a();
    a(8000L);
  }
  
  protected View b()
  {
    d();
    if (TextUtils.isEmpty(this.l)) {
      return null;
    }
    View localView = View.inflate(this.o, 2131296358, null);
    this.a = ((TextView)localView.findViewById(2131166101));
    this.b = ((LinearLayout)localView.findViewById(2131165541));
    this.c = ((TextView)localView.findViewById(2131165542));
    this.d = ((ImageView)localView.findViewById(2131165579));
    this.e = ((TextView)localView.findViewById(2131166104));
    this.f = ((TextView)localView.findViewById(2131166035));
    this.g = ((Button)localView.findViewById(2131165340));
    this.h = ((ImageView)localView.findViewById(2131165379));
    if (!TextUtils.isEmpty(this.i))
    {
      this.a.setVisibility(0);
      this.a.setText(this.i);
    }
    if (!TextUtils.isEmpty(this.j))
    {
      this.b.setVisibility(0);
      TextView localTextView = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("·");
      localStringBuilder.append(this.j);
      localTextView.setText(localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(this.k))
    {
      this.d.setVisibility(0);
      this.d.setImageResource(2131099893);
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
      public void onClick(View paramAnonymousView)
      {
        a.this.a(false);
      }
    });
    TMSDKContext.saveActionData(1150174);
    return localView;
  }
  
  protected int c()
  {
    return e.a(this.o, 104.0F);
  }
  
  protected void d()
  {
    this.l = "QQ帐号持续保护中";
    this.m = "你的帐号今天有新的登录足迹";
    this.k = "";
    this.n = "查看";
    this.j = "";
    this.i = "";
  }
  
  protected void e()
  {
    super.e();
    m();
  }
  
  protected void f()
  {
    super.f();
    m();
  }
  
  protected void g()
  {
    super.g();
    Intent localIntent = new Intent(this.o, IndexActivity.class);
    localIntent.addFlags(67108864);
    RqdApplication.l().startActivity(localIntent);
    TMSDKContext.saveActionData(1150175);
  }
  
  public void onClick(View paramView)
  {
    g();
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.push.a
 * JD-Core Version:    0.7.0.1
 */