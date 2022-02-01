package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

abstract class a
  extends ReportDialog
{
  protected RelativeLayout a;
  protected Activity b;
  protected boolean c = false;
  
  protected a(Activity paramActivity)
  {
    super(paramActivity, i.a(paramActivity));
    this.b = paramActivity;
    SizeUtil.init(paramActivity);
  }
  
  private e a(View paramView)
  {
    e locale = new e(this.b);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    if (d())
    {
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(11);
      localLayoutParams.setMargins(0, SizeUtil.dp5, SizeUtil.dp5, 0);
    }
    for (;;)
    {
      locale.setLayoutParams(localLayoutParams);
      locale.setOnClickListener(new a.1(this));
      return locale;
      localLayoutParams.addRule(6, paramView.getId());
      localLayoutParams.addRule(7, paramView.getId());
      localLayoutParams.setMargins(0, -SizeUtil.dp7, -SizeUtil.dp7, 0);
    }
  }
  
  private RelativeLayout g()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.b);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localRelativeLayout.setBackgroundColor(0);
    localRelativeLayout.setLayoutParams(localLayoutParams);
    return localRelativeLayout;
  }
  
  private RelativeLayout h()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.b);
    localRelativeLayout.setId(View.generateViewId());
    localRelativeLayout.setLayoutParams(b());
    if (!d()) {}
    for (boolean bool = true;; bool = false)
    {
      i.a(localRelativeLayout, 0, bool);
      a(localRelativeLayout);
      return localRelativeLayout;
    }
  }
  
  protected void a()
  {
    this.a = g();
    Object localObject = h();
    this.a.addView((View)localObject);
    if (c())
    {
      localObject = a((View)localObject);
      this.a.addView((View)localObject);
    }
    setContentView(this.a, this.a.getLayoutParams());
    this.a.setAnimation(i.a(350L));
    e();
  }
  
  abstract void a(RelativeLayout paramRelativeLayout);
  
  abstract RelativeLayout.LayoutParams b();
  
  abstract boolean c();
  
  public void cancel()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    f();
  }
  
  abstract boolean d();
  
  abstract void e();
  
  protected void f()
  {
    super.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.inappmessage.a
 * JD-Core Version:    0.7.0.1
 */