package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.aae;
import com.tencent.token.ahc;
import com.tencent.token.sf;
import com.tencent.token.sw;
import com.tencent.token.sy;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.ModifyQQPwdActivity;
import com.tencent.token.utils.UserTask;
import com.tencent.token.wz;
import com.tencent.token.xb;
import com.tencent.token.ye;

public class DualMsgShowDialog
  extends Dialog
{
  public DualMsgView a;
  public sf b = null;
  private Activity c;
  private boolean d = false;
  private int e;
  private int f = 0;
  private boolean g = false;
  private long h;
  private int i = 0;
  private Toast j;
  private TextView k;
  
  public DualMsgShowDialog(Activity paramActivity)
  {
    super(paramActivity, 2131558764);
    this.c = paramActivity;
    this.e = 1;
  }
  
  public DualMsgShowDialog(Activity paramActivity, boolean paramBoolean, long paramLong)
  {
    super(paramActivity, 2131558764);
    this.c = paramActivity;
    this.e = 0;
    this.g = paramBoolean;
    this.h = paramLong;
  }
  
  public final void a()
  {
    if (this.e == 0) {
      this.b = sy.a().a(this.f);
    } else {
      this.b = sw.a().a(this.f);
    }
    sf localsf = this.b;
    if ((localsf == null) || (localsf.f == null) || (this.b.g == null) || (this.b.h == null) || (this.b.i == null))
    {
      xb.c("item content err");
      this.b = null;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = new DualMsgView(this.c);
    this.a.setListener(new DualMsgView.f()
    {
      public final void a()
      {
        DualMsgShowDialog.this.dismiss();
        if (DualMsgShowDialog.a(DualMsgShowDialog.this))
        {
          Intent localIntent = new Intent(DualMsgShowDialog.b(DualMsgShowDialog.this), IndexActivity.class);
          localIntent.putExtra("intent.retcode", DualMsgShowDialog.c(DualMsgShowDialog.this));
          DualMsgShowDialog.b(DualMsgShowDialog.this).startActivity(localIntent);
        }
      }
      
      public final void a(int paramAnonymousInt)
      {
        sf localsf;
        if (DualMsgShowDialog.d(DualMsgShowDialog.this) == 0) {
          localsf = sy.a().a(DualMsgShowDialog.e(DualMsgShowDialog.this));
        } else {
          localsf = sw.a().a(DualMsgShowDialog.e(DualMsgShowDialog.this));
        }
        DualMsgShowDialog.a(DualMsgShowDialog.this, localsf, paramAnonymousInt);
      }
    });
    paramBundle = this.a;
    Activity localActivity = this.c;
    int m;
    if ((paramBundle.m != null) && ((paramBundle.m == null) || (!paramBundle.m.isFinishing())))
    {
      paramBundle.n = ((LayoutInflater)localActivity.getSystemService("layout_inflater"));
      paramBundle.o = paramBundle.n.inflate(2131296321, null);
      paramBundle.o.setVisibility(4);
      paramBundle.p = paramBundle.o.findViewById(2131166273);
      paramBundle.q = paramBundle.o.findViewById(2131166260);
      paramBundle.r = paramBundle.o.findViewById(2131166274);
      paramBundle.s = paramBundle.o.findViewById(2131166261);
      paramBundle.t = aae.a(paramBundle.m.getResources(), 2131099828);
      paramBundle.u = aae.a(paramBundle.m.getResources(), 2131099827);
      if (paramBundle.t != null) {
        ((LinearLayout)paramBundle.o.findViewById(2131166254)).setBackgroundDrawable(new BitmapDrawable(paramBundle.t));
      }
      if (paramBundle.u != null)
      {
        ((LinearLayout)paramBundle.o.findViewById(2131166255)).setBackgroundDrawable(new BitmapDrawable(paramBundle.u));
        ((LinearLayout)paramBundle.o.findViewById(2131166256)).setBackgroundDrawable(new BitmapDrawable(paramBundle.u));
      }
      paramBundle.a = paramBundle.o.findViewById(2131165764);
      paramBundle.c = ((TextView)paramBundle.o.findViewById(2131165760));
      paramBundle.d = ((TextView)paramBundle.o.findViewById(2131165748));
      paramBundle.b = paramBundle.o.findViewById(2131165765);
      paramBundle.e = ((TextView)paramBundle.o.findViewById(2131165761));
      paramBundle.f = ((TextView)paramBundle.o.findViewById(2131165749));
      paramBundle.j = ((ImageView)paramBundle.o.findViewById(2131165751));
      paramBundle.k = ((ImageView)paramBundle.o.findViewById(2131165753));
      paramBundle.l = ((ImageView)paramBundle.o.findViewById(2131165752));
      paramBundle.h = ((Button)paramBundle.o.findViewById(2131165747));
      paramBundle.i = ((Button)paramBundle.o.findViewById(2131165757));
      paramBundle.g = ((TextView)paramBundle.o.findViewById(2131165763));
      paramBundle.h.setOnClickListener(new DualMsgView.1(paramBundle));
      paramBundle.i.setOnClickListener(new DualMsgView.2(paramBundle));
      paramBundle.addView(paramBundle.o, new RelativeLayout.LayoutParams(-1, -1));
      m = 1;
    }
    else
    {
      m = 0;
    }
    if (m == 0)
    {
      dismiss();
      xb.a("Dual initView failed!");
      return;
    }
    a();
    paramBundle = this.b;
    if (paramBundle == null)
    {
      dismiss();
      return;
    }
    this.a.a(paramBundle);
    setContentView(this.a);
    new UserTask()
    {
      private static wz e()
      {
        try
        {
          ahc.a("tbl_dual_msg");
          ahc.a("tbl_barcode_msg");
          label10:
          return null;
        }
        catch (Exception|Error localException)
        {
          break label10;
        }
      }
    }.equals("");
    paramBundle = this.c.getLayoutInflater().inflate(2131296462, null);
    this.j = new Toast(this.c);
    this.j.setView(paramBundle);
    this.j.setDuration(0);
    this.j.setGravity(55, 0, IndexActivity.S_TITLE_HEIGHT);
    this.k = ((TextView)paramBundle.findViewById(2131166126));
    ((ImageView)paramBundle.findViewById(2131166124)).setBackgroundResource(2131100170);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.b == null)
      {
        dismiss();
        this.d = true;
      }
      if (!this.d)
      {
        this.d = true;
        DualMsgView localDualMsgView = this.a;
        localDualMsgView.v.post(new DualMsgView.b(localDualMsgView, localDualMsgView.p, localDualMsgView.q, localDualMsgView.r, localDualMsgView.s));
      }
    }
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.DualMsgShowDialog
 * JD-Core Version:    0.7.0.1
 */