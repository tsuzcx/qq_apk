package com.tencent.token;

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
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.VerifySuccActivity;
import com.tencent.token.ui.base.WtloginCaptchaDialog;

public final class zh
  extends LinearLayout
{
  public Handler a = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (zh.a(zh.this) != null)
      {
        if (zh.a(zh.this).isFinishing()) {
          return;
        }
        int i = paramAnonymousMessage.arg1;
        int j = paramAnonymousMessage.what;
        boolean bool2 = false;
        boolean bool1 = false;
        Object localObject1;
        Object localObject2;
        long l;
        switch (j)
        {
        default: 
          return;
        case 4104: 
          zh.a(zh.this).dismissDialog();
          if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("exception") != null))
          {
            localObject1 = zh.a(zh.this);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(zh.this.getResources().getString(2131493555));
            ((StringBuilder)localObject2).append(":");
            ((StringBuilder)localObject2).append(paramAnonymousMessage.getData().getString("exception"));
            ((BaseActivity)localObject1).showToast(((StringBuilder)localObject2).toString());
            return;
          }
          zh.a(zh.this).showToast(2131493555);
          return;
        case 4097: 
        case 4098: 
          localObject1 = (byte[])paramAnonymousMessage.obj;
          zh.a(zh.this, (byte[])localObject1);
          if ((i == 0) && (localObject1 != null))
          {
            paramAnonymousMessage = si.a();
            l = zh.b(zh.this);
            localObject2 = zh.this.a;
            zh.c(zh.this);
            paramAnonymousMessage.a(l, (byte[])localObject1, (Handler)localObject2);
            return;
          }
          if (i == 2)
          {
            if (zh.a(zh.this).isFinishing()) {
              return;
            }
            new WtloginCaptchaDialog(zh.a(zh.this), zh.this.a, Long.toString(zh.b(zh.this))).show();
            return;
          }
          if (i == -1000)
          {
            zh.a(zh.this).dismissDialog();
            zh.a(zh.this).showToast(2131493103);
            return;
          }
          if (i == 8192)
          {
            zh.a(zh.this).dismissDialog();
            zh.a(zh.this).showToast(2131493551);
            return;
          }
          if ((i != 1) && (i != 15) && (i != 16))
          {
            if ((i != 40) && (i != 42) && (i != 64))
            {
              zh.a(zh.this).dismissDialog();
              if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("loginerror") != null))
              {
                localObject1 = zh.a(zh.this);
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(zh.this.getResources().getString(2131493555));
                ((StringBuilder)localObject2).append(":");
                ((StringBuilder)localObject2).append(paramAnonymousMessage.getData().getString("loginerror"));
                ((BaseActivity)localObject1).showToast(((StringBuilder)localObject2).toString());
                return;
              }
              zh.a(zh.this).showToast(2131493555);
              return;
            }
            zh.a(zh.this).dismissDialog();
            zh.a(zh.this).goToRemoveProtectH5(zh.a(zh.this), paramAnonymousMessage, i);
            return;
          }
          zh.a(zh.this).dismissDialog();
          zh.a(zh.this).showUserDialog(2131493801, zh.this.getResources().getString(2131493800), 2131493040, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              zh.d(zh.this);
            }
          });
          return;
        case 4004: 
          if (paramAnonymousMessage.arg1 == 0)
          {
            if (paramAnonymousMessage.arg2 == 1) {
              bool1 = true;
            }
            zh.a(zh.this, bool1);
            return;
          }
          paramAnonymousMessage = (xh)paramAnonymousMessage.obj;
          xh.a(zh.this.getResources(), paramAnonymousMessage);
          localObject1 = new StringBuilder("query up flow failed:");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.a);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.b);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.c);
          xj.c(((StringBuilder)localObject1).toString());
          zh.a(zh.this).showUserDialog(2131492922, paramAnonymousMessage.c, 2131493040, null);
          return;
        case 4003: 
          zh.a(zh.this).dismissDialog();
          if (paramAnonymousMessage.arg1 == 0)
          {
            postDelayed(new Runnable()
            {
              public final void run()
              {
                yw.a().a(zh.a(zh.this), this.a, zh.this.a);
              }
            }, 10L);
            return;
          }
          paramAnonymousMessage = (xh)paramAnonymousMessage.obj;
          localObject1 = new StringBuilder("err ");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.a);
          xj.c(((StringBuilder)localObject1).toString());
          xh.a(zh.this.getResources(), paramAnonymousMessage);
          localObject1 = new StringBuilder("query up flow failed:");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.a);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.b);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.c);
          xj.c(((StringBuilder)localObject1).toString());
          zh.a(zh.this).showUserDialog(2131492986, paramAnonymousMessage.c, 2131493040, null);
          return;
        case 3026: 
          if (paramAnonymousMessage.arg1 == 0)
          {
            bool1 = bool2;
            if (paramAnonymousMessage.arg2 == 1) {
              bool1 = true;
            }
            zh.a(zh.this, bool1);
            return;
          }
          paramAnonymousMessage = (xh)paramAnonymousMessage.obj;
          xh.a(zh.this.getResources(), paramAnonymousMessage);
          localObject1 = new StringBuilder("query up flow failed:");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.a);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.b);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.c);
          xj.c(((StringBuilder)localObject1).toString());
          zh.a(zh.this).showUserDialog(2131492922, paramAnonymousMessage.c, 2131493040, null);
          return;
        case 3024: 
          if (i == 0)
          {
            paramAnonymousMessage = si.a();
            l = zh.b(zh.this);
            localObject1 = zh.e(zh.this);
            localObject2 = zh.this.a;
            zh.c(zh.this);
            paramAnonymousMessage.a(l, (byte[])localObject1, (Handler)localObject2, 1);
            return;
          }
          paramAnonymousMessage = (xh)paramAnonymousMessage.obj;
          localObject1 = new StringBuilder("err ");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.a);
          xj.c(((StringBuilder)localObject1).toString());
          xh.a(zh.this.getResources(), paramAnonymousMessage);
          localObject1 = new StringBuilder("query up flow failed:");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.a);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.b);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.c);
          xj.c(((StringBuilder)localObject1).toString());
          zh.a(zh.this).showToast(paramAnonymousMessage.c);
          return;
        }
        paramAnonymousMessage = (byte[])paramAnonymousMessage.obj;
        if (paramAnonymousMessage != null)
        {
          zh.a(zh.this, paramAnonymousMessage);
          localObject1 = si.a();
          l = zh.b(zh.this);
          localObject2 = zh.this.a;
          zh.c(zh.this);
          ((si)localObject1).a(l, paramAnonymousMessage, (Handler)localObject2);
          return;
        }
        return;
      }
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
  private int[] p = { 2131493699, 2131493693, 2131493709, 2131493744, 2131493675, 2131493690, 2131493503, 2131493683, 2131493749, 2131493097, 2131493447, 2131493204 };
  private int[] q = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 20 };
  private int[] r = { 2131493680, 2131493695, 2131493681, 2131493745, 2131493265, 2131493266, 2131493474, 2131493386, 2131493749, 2131493097, 2131493447, 2131493204 };
  private int[] s = { 2131099917, 2131099902, 2131099905, 2131099915, 2131099896, 2131099901, 2131099922, 2131099907, 2131099923, 2131099898, 2131099898 };
  private View.OnClickListener t = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      paramAnonymousView = th.a().k.b();
      if (paramAnonymousView == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAnonymousView.mRealUin);
      paramAnonymousView = ((StringBuilder)localObject).toString();
      localObject = sg.a(RqdApplication.p());
      if (!((sg)localObject).a(paramAnonymousView, 523005419L))
      {
        ((sg)localObject).a(paramAnonymousView, zh.this.a, 523005419L);
        zh.a(zh.this).showProDialog(zh.a(zh.this), 2131492986, 2131493441, null);
        zh.f(zh.this);
        return;
      }
      zh.a(zh.this).showUserDialog(2131493801, zh.this.getResources().getString(2131493800), 2131493040, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          zh.d(zh.this);
        }
      });
    }
  };
  
  public zh(BaseActivity paramBaseActivity, int paramInt)
  {
    super(paramBaseActivity);
    this.b = paramBaseActivity;
    this.e = paramInt;
    a();
  }
  
  private void a()
  {
    this.c = ((LayoutInflater)this.b.getSystemService("layout_inflater"));
    this.d = this.c.inflate(2131296494, null);
    removeAllViews();
    addView(this.d, new LinearLayout.LayoutParams(-1, -1));
    this.f = ((ImageView)findViewById(2131166242));
    this.g = ((TextView)findViewById(2131166243));
    this.h = ((TextView)findViewById(2131166249));
    this.i = ((TextView)findViewById(2131166248));
    this.j = ((Button)findViewById(2131166247));
    Object localObject1 = getResources().getString(2131493756);
    Object localObject2 = new StringBuilder("flag show scene id: ");
    ((StringBuilder)localObject2).append(this.e);
    xj.a(((StringBuilder)localObject2).toString());
    int i1 = 0;
    int i3 = -1;
    int i2 = -1;
    for (;;)
    {
      localObject2 = this.q;
      if (i1 >= localObject2.length) {
        break;
      }
      if (localObject2[i1] == this.e)
      {
        i3 = this.s[i1];
        i2 = this.r[i1];
      }
      i1 += 1;
    }
    StringBuilder localStringBuilder;
    if ((i3 != -1) && (i2 != -1))
    {
      this.f.setImageDrawable(getResources().getDrawable(i3));
      this.g.setText(this.p[this.e]);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getResources().getString(2131493754));
      ((StringBuilder)localObject2).append(getResources().getString(i2));
      ((StringBuilder)localObject2).append("?");
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131493753));
      localStringBuilder.append(getResources().getString(i2));
      localStringBuilder.append((String)localObject1);
      localObject1 = localStringBuilder.toString();
      this.h.setText((CharSequence)localObject2);
      this.i.setText((CharSequence)localObject1);
    }
    else if (this.e == -1)
    {
      this.f.setImageDrawable(getResources().getDrawable(2131099906));
      this.g.setText(2131493716);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getResources().getString(2131493754));
      ((StringBuilder)localObject2).append(getResources().getString(2131493711));
      ((StringBuilder)localObject2).append("?");
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131493753));
      localStringBuilder.append(getResources().getString(2131493711));
      localStringBuilder.append((String)localObject1);
      localObject1 = localStringBuilder.toString();
      this.h.setText((CharSequence)localObject2);
      this.i.setText((CharSequence)localObject1);
    }
    this.j.setOnClickListener(this.t);
    localObject1 = th.a().k.b();
    if (localObject1 != null) {
      this.o = ((QQUser)localObject1).mRealUin;
    }
  }
  
  private void setActiveSucc(boolean paramBoolean)
  {
    Intent localIntent = new Intent(this.b, VerifySuccActivity.class);
    localIntent.putExtra("mRealUin", this.o);
    this.b.startActivity(localIntent);
    this.b.finish();
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    try
    {
      if ((this.m) && (paramKeyEvent.getAction() == 0)) {
        if (paramKeyEvent.getKeyCode() == 4) {
          break label40;
        }
      }
      boolean bool = super.dispatchKeyEvent(paramKeyEvent);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      paramKeyEvent.printStackTrace();
      return true;
    }
    label40:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zh
 * JD-Core Version:    0.7.0.1
 */