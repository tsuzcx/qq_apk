package com.tencent.token.ui.base;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.global.h;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.VerifySuccActivity;

public class dd
  extends LinearLayout
{
  public Handler a = new de(this);
  private BaseActivity b;
  private LayoutInflater c;
  private View d;
  private int e;
  private ImageView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private Button j;
  private final long k = 523005419L;
  private int l = 1;
  private boolean m = false;
  private byte[] n;
  private long o;
  private int[] p = { 2131231552, 2131231546, 2131231562, 2131231597, 2131231528, 2131231543, 2131231360, 2131231536, 2131231602, 2131230954, 2131231304, 2131231061 };
  private int[] q = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 20 };
  private int[] r = { 2131231533, 2131231548, 2131231534, 2131231598, 2131231122, 2131231123, 2131231331, 2131231243, 2131231602, 2131230954, 2131231304, 2131231061 };
  private int[] s = { 2130837770, 2130837755, 2130837758, 2130837768, 2130837749, 2130837754, 2130837775, 2130837760, 2130837776, 2130837751, 2130837751 };
  private View.OnClickListener t = new dh(this);
  
  public dd(BaseActivity paramBaseActivity, int paramInt)
  {
    super(paramBaseActivity);
    this.b = paramBaseActivity;
    this.e = paramInt;
    c();
  }
  
  private void a()
  {
    if (do.a().e() == null) {
      return;
    }
    b();
  }
  
  private void b()
  {
    QQUser localQQUser = do.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L)) {
      return;
    }
    cp.a(this.b).a(this.b, 523005419L, this.a, "" + localQQUser.b());
  }
  
  private void c()
  {
    this.c = ((LayoutInflater)this.b.getSystemService("layout_inflater"));
    this.d = this.c.inflate(2130968812, null);
    removeAllViews();
    addView(this.d, new LinearLayout.LayoutParams(-1, -1));
    this.f = ((ImageView)findViewById(2131559388));
    this.g = ((TextView)findViewById(2131559389));
    this.h = ((TextView)findViewById(2131559390));
    this.i = ((TextView)findViewById(2131559391));
    this.j = ((Button)findViewById(2131559449));
    Object localObject = getResources().getString(2131231609);
    h.a("flag show scene id: " + this.e);
    int i1 = 0;
    int i3 = -1;
    int i2 = -1;
    while (i1 < this.q.length)
    {
      if (this.q[i1] == this.e)
      {
        i2 = this.s[i1];
        i3 = this.r[i1];
      }
      i1 += 1;
    }
    String str;
    if ((i2 != -1) && (i3 != -1))
    {
      this.f.setImageDrawable(getResources().getDrawable(i2));
      this.g.setText(this.p[this.e]);
      str = getResources().getString(2131231607) + getResources().getString(i3) + "?";
      localObject = getResources().getString(2131231606) + getResources().getString(i3) + (String)localObject;
      this.h.setText(str);
      this.i.setText((CharSequence)localObject);
    }
    for (;;)
    {
      this.j.setOnClickListener(this.t);
      localObject = do.a().e();
      if (localObject != null) {
        this.o = ((QQUser)localObject).mRealUin;
      }
      return;
      if (this.e == -1)
      {
        this.f.setImageDrawable(getResources().getDrawable(2130837759));
        this.g.setText(2131231569);
        str = getResources().getString(2131231607) + getResources().getString(2131231564) + "?";
        localObject = getResources().getString(2131231606) + getResources().getString(2131231564) + (String)localObject;
        this.h.setText(str);
        this.i.setText((CharSequence)localObject);
      }
    }
  }
  
  private void setActiveSucc(boolean paramBoolean)
  {
    Object localObject = cx.c();
    ((cx)localObject).i();
    ((cx)localObject).n();
    localObject = new Intent(this.b, VerifySuccActivity.class);
    ((Intent)localObject).putExtra("mRealUin", this.o);
    this.b.startActivity((Intent)localObject);
    this.b.finish();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((this.m) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          bool = super.dispatchKeyEvent(paramKeyEvent);
          return bool;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.dd
 * JD-Core Version:    0.7.0.1
 */