package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.at;
import com.tencent.token.av;
import com.tencent.token.core.bean.b;
import com.tencent.token.global.e;
import com.tencent.token.ui.IndexActivity;

public class DualMsgShowDialog
  extends Dialog
{
  private Activity a;
  private DualMsgView b;
  private boolean c = false;
  private int d;
  private int e = 0;
  private boolean f = false;
  private b g = null;
  private long h;
  private int i = 0;
  private Toast j;
  private TextView k;
  
  public DualMsgShowDialog(Activity paramActivity)
  {
    super(paramActivity, 2131427401);
    this.a = paramActivity;
    this.d = 1;
  }
  
  public DualMsgShowDialog(Activity paramActivity, boolean paramBoolean, long paramLong)
  {
    super(paramActivity, 2131427401);
    this.a = paramActivity;
    this.d = 0;
    this.f = paramBoolean;
    this.h = paramLong;
  }
  
  private void c()
  {
    if (this.d == 0) {}
    for (this.g = av.a().a(this.e);; this.g = at.a().a(this.e))
    {
      if ((this.g == null) || (this.g.f() == null) || (this.g.g() == null) || (this.g.h() == null) || (this.g.i() == null))
      {
        e.c("item content err");
        this.g = null;
      }
      return;
    }
  }
  
  public final void a()
  {
    c();
    if (this.g == null) {
      return;
    }
    this.b.a(this.g);
  }
  
  public final void b()
  {
    this.b.a();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = new DualMsgView(this.a);
    this.b.a(new j(this));
    if (!this.b.a(this.a))
    {
      dismiss();
      e.a("Dual initView failed!");
      return;
    }
    c();
    if (this.g == null)
    {
      dismiss();
      return;
    }
    this.b.a(this.g);
    setContentView(this.b);
    new m(this).equals("");
    paramBundle = this.a.getLayoutInflater().inflate(2130903218, null);
    this.j = new Toast(this.a);
    this.j.setView(paramBundle);
    this.j.setDuration(0);
    this.j.setGravity(55, 0, IndexActivity.S_TITLE_HEIGHT);
    this.k = ((TextView)paramBundle.findViewById(2131296784));
    ((ImageView)paramBundle.findViewById(2131296783)).setBackgroundResource(2130837966);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.g == null)
      {
        dismiss();
        this.c = true;
      }
      if (!this.c)
      {
        this.c = true;
        this.b.b();
      }
    }
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.DualMsgShowDialog
 * JD-Core Version:    0.7.0.1
 */