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

public final class zt
  extends LinearLayout
{
  public Handler a = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (zt.a(zt.this) != null)
      {
        if (zt.a(zt.this).isFinishing()) {
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
          zt.a(zt.this).dismissDialog();
          if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("exception") != null))
          {
            localObject1 = zt.a(zt.this);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(zt.this.getResources().getString(2131493563));
            ((StringBuilder)localObject2).append(":");
            ((StringBuilder)localObject2).append(paramAnonymousMessage.getData().getString("exception"));
            ((BaseActivity)localObject1).showToast(((StringBuilder)localObject2).toString());
            return;
          }
          zt.a(zt.this).showToast(2131493563);
          return;
        case 4097: 
        case 4098: 
          localObject1 = (byte[])paramAnonymousMessage.obj;
          zt.a(zt.this, (byte[])localObject1);
          if ((i == 0) && (localObject1 != null))
          {
            paramAnonymousMessage = su.a();
            l = zt.b(zt.this);
            localObject2 = zt.this.a;
            zt.c(zt.this);
            paramAnonymousMessage.a(l, (byte[])localObject1, (Handler)localObject2);
            return;
          }
          if (i == 2)
          {
            if (zt.a(zt.this).isFinishing()) {
              return;
            }
            new WtloginCaptchaDialog(zt.a(zt.this), zt.this.a, Long.toString(zt.b(zt.this))).show();
            return;
          }
          if (i == -1000)
          {
            zt.a(zt.this).dismissDialog();
            zt.a(zt.this).showToast(2131493105);
            return;
          }
          if (i == 8192)
          {
            zt.a(zt.this).dismissDialog();
            zt.a(zt.this).showToast(2131493559);
            return;
          }
          if ((i != 1) && (i != 15) && (i != 16))
          {
            if ((i != 40) && (i != 42) && (i != 64))
            {
              zt.a(zt.this).dismissDialog();
              if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("loginerror") != null))
              {
                localObject1 = zt.a(zt.this);
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(zt.this.getResources().getString(2131493563));
                ((StringBuilder)localObject2).append(":");
                ((StringBuilder)localObject2).append(paramAnonymousMessage.getData().getString("loginerror"));
                ((BaseActivity)localObject1).showToast(((StringBuilder)localObject2).toString());
                return;
              }
              zt.a(zt.this).showToast(2131493563);
              return;
            }
            zt.a(zt.this).dismissDialog();
            zt.a(zt.this).goToRemoveProtectH5(zt.a(zt.this), paramAnonymousMessage, i);
            return;
          }
          zt.a(zt.this).dismissDialog();
          zt.a(zt.this).showUserDialog(2131493809, zt.this.getResources().getString(2131493808), 2131493041, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              zt.d(zt.this);
            }
          });
          return;
        case 4004: 
          if (paramAnonymousMessage.arg1 == 0)
          {
            if (paramAnonymousMessage.arg2 == 1) {
              bool1 = true;
            }
            zt.a(zt.this, bool1);
            return;
          }
          paramAnonymousMessage = (xt)paramAnonymousMessage.obj;
          xt.a(zt.this.getResources(), paramAnonymousMessage);
          localObject1 = new StringBuilder("query up flow failed:");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.a);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.b);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.c);
          xv.c(((StringBuilder)localObject1).toString());
          zt.a(zt.this).showUserDialog(2131492923, paramAnonymousMessage.c, 2131493041, null);
          return;
        case 4003: 
          zt.a(zt.this).dismissDialog();
          if (paramAnonymousMessage.arg1 == 0)
          {
            postDelayed(new Runnable()
            {
              public final void run()
              {
                zi.a().a(zt.a(zt.this), this.a, zt.this.a);
              }
            }, 10L);
            return;
          }
          paramAnonymousMessage = (xt)paramAnonymousMessage.obj;
          localObject1 = new StringBuilder("err ");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.a);
          xv.c(((StringBuilder)localObject1).toString());
          xt.a(zt.this.getResources(), paramAnonymousMessage);
          localObject1 = new StringBuilder("query up flow failed:");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.a);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.b);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.c);
          xv.c(((StringBuilder)localObject1).toString());
          zt.a(zt.this).showUserDialog(2131492987, paramAnonymousMessage.c, 2131493041, null);
          return;
        case 3026: 
          if (paramAnonymousMessage.arg1 == 0)
          {
            bool1 = bool2;
            if (paramAnonymousMessage.arg2 == 1) {
              bool1 = true;
            }
            zt.a(zt.this, bool1);
            return;
          }
          paramAnonymousMessage = (xt)paramAnonymousMessage.obj;
          xt.a(zt.this.getResources(), paramAnonymousMessage);
          localObject1 = new StringBuilder("query up flow failed:");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.a);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.b);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.c);
          xv.c(((StringBuilder)localObject1).toString());
          zt.a(zt.this).showUserDialog(2131492923, paramAnonymousMessage.c, 2131493041, null);
          return;
        case 3024: 
          if (i == 0)
          {
            paramAnonymousMessage = su.a();
            l = zt.b(zt.this);
            localObject1 = zt.e(zt.this);
            localObject2 = zt.this.a;
            zt.c(zt.this);
            paramAnonymousMessage.a(l, (byte[])localObject1, (Handler)localObject2, 1);
            return;
          }
          paramAnonymousMessage = (xt)paramAnonymousMessage.obj;
          localObject1 = new StringBuilder("err ");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.a);
          xv.c(((StringBuilder)localObject1).toString());
          xt.a(zt.this.getResources(), paramAnonymousMessage);
          localObject1 = new StringBuilder("query up flow failed:");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.a);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.b);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append(paramAnonymousMessage.c);
          xv.c(((StringBuilder)localObject1).toString());
          zt.a(zt.this).showToast(paramAnonymousMessage.c);
          return;
        }
        paramAnonymousMessage = (byte[])paramAnonymousMessage.obj;
        if (paramAnonymousMessage != null)
        {
          zt.a(zt.this, paramAnonymousMessage);
          localObject1 = su.a();
          l = zt.b(zt.this);
          localObject2 = zt.this.a;
          zt.c(zt.this);
          ((su)localObject1).a(l, paramAnonymousMessage, (Handler)localObject2);
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
  private int[] p = { 2131493707, 2131493701, 2131493717, 2131493752, 2131493683, 2131493698, 2131493511, 2131493691, 2131493757, 2131493099, 2131493455, 2131493206 };
  private int[] q = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 20 };
  private int[] r = { 2131493688, 2131493703, 2131493689, 2131493753, 2131493267, 2131493268, 2131493482, 2131493389, 2131493757, 2131493099, 2131493455, 2131493206 };
  private int[] s = { 2131099920, 2131099902, 2131099905, 2131099918, 2131099896, 2131099901, 2131099925, 2131099907, 2131099926, 2131099898, 2131099898 };
  private View.OnClickListener t = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      paramAnonymousView = tt.a().k.b();
      if (paramAnonymousView == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAnonymousView.mRealUin);
      paramAnonymousView = ((StringBuilder)localObject).toString();
      localObject = ss.a(RqdApplication.n());
      if (!((ss)localObject).a(paramAnonymousView, 523005419L))
      {
        ((ss)localObject).a(paramAnonymousView, zt.this.a, 523005419L);
        zt.a(zt.this).showProDialog(zt.a(zt.this), 2131492987, 2131493449, null);
        zt.f(zt.this);
        return;
      }
      zt.a(zt.this).showUserDialog(2131493809, zt.this.getResources().getString(2131493808), 2131493041, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          zt.d(zt.this);
        }
      });
    }
  };
  
  public zt(BaseActivity paramBaseActivity, int paramInt)
  {
    super(paramBaseActivity);
    this.b = paramBaseActivity;
    this.e = paramInt;
    a();
  }
  
  private void a()
  {
    this.c = ((LayoutInflater)this.b.getSystemService("layout_inflater"));
    this.d = this.c.inflate(2131296507, null);
    removeAllViews();
    addView(this.d, new LinearLayout.LayoutParams(-1, -1));
    this.f = ((ImageView)findViewById(2131166282));
    this.g = ((TextView)findViewById(2131166283));
    this.h = ((TextView)findViewById(2131166289));
    this.i = ((TextView)findViewById(2131166288));
    this.j = ((Button)findViewById(2131166287));
    Object localObject1 = getResources().getString(2131493764);
    Object localObject2 = new StringBuilder("flag show scene id: ");
    ((StringBuilder)localObject2).append(this.e);
    xv.a(((StringBuilder)localObject2).toString());
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
      ((StringBuilder)localObject2).append(getResources().getString(2131493762));
      ((StringBuilder)localObject2).append(getResources().getString(i2));
      ((StringBuilder)localObject2).append("?");
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131493761));
      localStringBuilder.append(getResources().getString(i2));
      localStringBuilder.append((String)localObject1);
      localObject1 = localStringBuilder.toString();
      this.h.setText((CharSequence)localObject2);
      this.i.setText((CharSequence)localObject1);
    }
    else if (this.e == -1)
    {
      this.f.setImageDrawable(getResources().getDrawable(2131099906));
      this.g.setText(2131493724);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getResources().getString(2131493762));
      ((StringBuilder)localObject2).append(getResources().getString(2131493719));
      ((StringBuilder)localObject2).append("?");
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131493761));
      localStringBuilder.append(getResources().getString(2131493719));
      localStringBuilder.append((String)localObject1);
      localObject1 = localStringBuilder.toString();
      this.h.setText((CharSequence)localObject2);
      this.i.setText((CharSequence)localObject1);
    }
    this.j.setOnClickListener(this.t);
    localObject1 = tt.a().k.b();
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
 * Qualified Name:     com.tencent.token.zt
 * JD-Core Version:    0.7.0.1
 */