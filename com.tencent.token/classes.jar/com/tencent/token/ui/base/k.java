package com.tencent.token.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.token.bz;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cr;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.VerifySuccActivity;
import com.tencent.token.ui.u;

public class k
  extends LinearLayout
{
  public Handler a = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      if ((k.a(k.this) == null) || (k.a(k.this).isFinishing())) {}
      int i;
      do
      {
        do
        {
          return;
          i = paramAnonymousMessage.arg1;
          switch (paramAnonymousMessage.what)
          {
          default: 
            return;
          case 1019: 
            paramAnonymousMessage = (byte[])paramAnonymousMessage.obj;
          }
        } while (paramAnonymousMessage == null);
        k.a(k.this, paramAnonymousMessage);
        cb.a().a(k.b(k.this), paramAnonymousMessage, k.this.a, k.c(k.this));
        return;
        k.a(k.this).dismissDialog();
        if (paramAnonymousMessage.arg1 == 0)
        {
          postDelayed(new Runnable()
          {
            public void run()
            {
              u.a().a(k.a(k.this), this.a, k.this.a);
            }
          }, 10L);
          return;
        }
        paramAnonymousMessage = (e)paramAnonymousMessage.obj;
        g.c("err " + paramAnonymousMessage.a);
        e.a(k.this.getResources(), paramAnonymousMessage);
        g.c("query up flow failed:" + paramAnonymousMessage.a + "-" + paramAnonymousMessage.b + "-" + paramAnonymousMessage.c);
        k.a(k.this).showUserDialog(2131230843, paramAnonymousMessage.c, 2131230897, null);
        return;
        byte[] arrayOfByte = (byte[])paramAnonymousMessage.obj;
        k.a(k.this, arrayOfByte);
        if ((i == 0) && (arrayOfByte != null))
        {
          cb.a().a(k.b(k.this), arrayOfByte, k.this.a, k.c(k.this));
          return;
        }
        if (i != 2) {
          break;
        }
      } while (k.a(k.this).isFinishing());
      new WtloginCaptchaDialog(k.a(k.this), 2131362182, k.this.a, Long.toString(k.b(k.this))).show();
      return;
      if (i == -1000)
      {
        k.a(k.this).dismissDialog();
        k.a(k.this).showToast(2131230960);
        return;
      }
      if (i == 8192)
      {
        k.a(k.this).dismissDialog();
        k.a(k.this).showToast(2131231407);
        return;
      }
      if ((i == 1) || (i == 15) || (i == 16))
      {
        k.a(k.this).dismissDialog();
        k.a(k.this).showUserDialog(2131231654, k.this.getResources().getString(2131231653), 2131230897, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            k.d(k.this);
          }
        });
        return;
      }
      if ((i == 40) || (i == 42) || (i == 64))
      {
        k.a(k.this).dismissDialog();
        k.a(k.this).goToRemoveProtectH5(k.a(k.this), paramAnonymousMessage, i);
        return;
      }
      k.a(k.this).dismissDialog();
      if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("loginerror") != null))
      {
        k.a(k.this).showToast(k.this.getResources().getString(2131231411) + ":" + paramAnonymousMessage.getData().getString("loginerror"));
        return;
      }
      k.a(k.this).showToast(2131231411);
      return;
      if (i == 0)
      {
        cb.a().a(k.b(k.this), k.e(k.this), k.this.a, k.c(k.this), 1);
        return;
      }
      paramAnonymousMessage = (e)paramAnonymousMessage.obj;
      g.c("err " + paramAnonymousMessage.a);
      e.a(k.this.getResources(), paramAnonymousMessage);
      g.c("query up flow failed:" + paramAnonymousMessage.a + "-" + paramAnonymousMessage.b + "-" + paramAnonymousMessage.c);
      k.a(k.this).showToast(paramAnonymousMessage.c);
      return;
      k.a(k.this).dismissDialog();
      if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("exception") != null))
      {
        k.a(k.this).showToast(k.this.getResources().getString(2131231411) + ":" + paramAnonymousMessage.getData().getString("exception"));
        return;
      }
      k.a(k.this).showToast(2131231411);
      return;
      if (paramAnonymousMessage.arg1 == 0)
      {
        if (paramAnonymousMessage.arg2 == 1) {}
        for (;;)
        {
          k.a(k.this, bool1);
          return;
          bool1 = false;
        }
      }
      paramAnonymousMessage = (e)paramAnonymousMessage.obj;
      e.a(k.this.getResources(), paramAnonymousMessage);
      g.c("query up flow failed:" + paramAnonymousMessage.a + "-" + paramAnonymousMessage.b + "-" + paramAnonymousMessage.c);
      k.a(k.this).showUserDialog(2131230779, paramAnonymousMessage.c, 2131230897, null);
      return;
      if (paramAnonymousMessage.arg1 == 0)
      {
        if (paramAnonymousMessage.arg2 == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          k.a(k.this, bool1);
          return;
        }
      }
      paramAnonymousMessage = (e)paramAnonymousMessage.obj;
      e.a(k.this.getResources(), paramAnonymousMessage);
      g.c("query up flow failed:" + paramAnonymousMessage.a + "-" + paramAnonymousMessage.b + "-" + paramAnonymousMessage.c);
      k.a(k.this).showUserDialog(2131230779, paramAnonymousMessage.c, 2131230897, null);
    }
  };
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
  private View.OnClickListener t = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = cr.a().e();
      if (paramAnonymousView == null) {
        return;
      }
      paramAnonymousView = "" + paramAnonymousView.mRealUin;
      bz localbz = bz.a(RqdApplication.l());
      if (!localbz.b(paramAnonymousView, 523005419L))
      {
        localbz.a(paramAnonymousView, k.this.a, 523005419L);
        k.a(k.this).showProDialog(k.a(k.this), 2131230843, 2131231298, null);
        k.a(k.this, 1);
        return;
      }
      k.a(k.this).showUserDialog(2131231654, k.this.getResources().getString(2131231653), 2131230897, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          k.d(k.this);
        }
      });
    }
  };
  
  public k(BaseActivity paramBaseActivity, int paramInt)
  {
    super(paramBaseActivity);
    this.b = paramBaseActivity;
    this.e = paramInt;
    c();
  }
  
  private void a()
  {
    if (cr.a().e() == null) {
      return;
    }
    b();
  }
  
  private void b()
  {
    QQUser localQQUser = cr.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L)) {
      return;
    }
    bz.a(this.b).a(this.b, 523005419L, this.a, "" + localQQUser.b());
  }
  
  private void c()
  {
    this.c = ((LayoutInflater)this.b.getSystemService("layout_inflater"));
    this.d = this.c.inflate(2130968812, null);
    removeAllViews();
    addView(this.d, new LinearLayout.LayoutParams(-1, -1));
    this.f = ((ImageView)findViewById(2131559389));
    this.g = ((TextView)findViewById(2131559390));
    this.h = ((TextView)findViewById(2131559391));
    this.i = ((TextView)findViewById(2131559392));
    this.j = ((Button)findViewById(2131559450));
    Object localObject = getResources().getString(2131231609);
    g.a("flag show scene id: " + this.e);
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
      localObject = cr.a().e();
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
    Object localObject = cc.c();
    ((cc)localObject).i();
    ((cc)localObject).n();
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
 * Qualified Name:     com.tencent.token.ui.base.k
 * JD-Core Version:    0.7.0.1
 */