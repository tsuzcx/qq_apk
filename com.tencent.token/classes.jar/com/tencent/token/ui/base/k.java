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
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.cd;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cs;
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
      if (k.a(k.this) != null)
      {
        if (k.a(k.this).isFinishing()) {
          return;
        }
        int i = paramAnonymousMessage.arg1;
        int j = paramAnonymousMessage.what;
        boolean bool2 = false;
        boolean bool1 = false;
        Object localObject;
        StringBuilder localStringBuilder;
        switch (j)
        {
        default: 
          return;
        case 4104: 
          k.a(k.this).dismissDialog();
          if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("exception") != null))
          {
            localObject = k.a(k.this);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(k.this.getResources().getString(2131493554));
            localStringBuilder.append(":");
            localStringBuilder.append(paramAnonymousMessage.getData().getString("exception"));
            ((BaseActivity)localObject).showToast(localStringBuilder.toString());
            return;
          }
          k.a(k.this).showToast(2131493554);
          return;
        case 4097: 
        case 4098: 
          localObject = (byte[])paramAnonymousMessage.obj;
          k.a(k.this, (byte[])localObject);
          if ((i == 0) && (localObject != null))
          {
            cc.a().a(k.b(k.this), (byte[])localObject, k.this.a, k.c(k.this));
            return;
          }
          if (i == 2)
          {
            if (k.a(k.this).isFinishing()) {
              return;
            }
            new WtloginCaptchaDialog(k.a(k.this), 2131558791, k.this.a, Long.toString(k.b(k.this))).show();
            return;
          }
          if (i == -1000)
          {
            k.a(k.this).dismissDialog();
            k.a(k.this).showToast(2131493103);
            return;
          }
          if (i == 8192)
          {
            k.a(k.this).dismissDialog();
            k.a(k.this).showToast(2131493550);
            return;
          }
          if ((i != 1) && (i != 15) && (i != 16))
          {
            if ((i != 40) && (i != 42) && (i != 64))
            {
              k.a(k.this).dismissDialog();
              if ((paramAnonymousMessage.getData() != null) && (paramAnonymousMessage.getData().getString("loginerror") != null))
              {
                localObject = k.a(k.this);
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(k.this.getResources().getString(2131493554));
                localStringBuilder.append(":");
                localStringBuilder.append(paramAnonymousMessage.getData().getString("loginerror"));
                ((BaseActivity)localObject).showToast(localStringBuilder.toString());
                return;
              }
              k.a(k.this).showToast(2131493554);
              return;
            }
            k.a(k.this).dismissDialog();
            k.a(k.this).goToRemoveProtectH5(k.a(k.this), paramAnonymousMessage, i);
            return;
          }
          k.a(k.this).dismissDialog();
          k.a(k.this).showUserDialog(2131493799, k.this.getResources().getString(2131493798), 2131493040, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              k.d(k.this);
            }
          });
          return;
        case 4004: 
          if (paramAnonymousMessage.arg1 == 0)
          {
            if (paramAnonymousMessage.arg2 == 1) {
              bool1 = true;
            }
            k.a(k.this, bool1);
            return;
          }
          paramAnonymousMessage = (e)paramAnonymousMessage.obj;
          e.a(k.this.getResources(), paramAnonymousMessage);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("query up flow failed:");
          ((StringBuilder)localObject).append(paramAnonymousMessage.a);
          ((StringBuilder)localObject).append("-");
          ((StringBuilder)localObject).append(paramAnonymousMessage.b);
          ((StringBuilder)localObject).append("-");
          ((StringBuilder)localObject).append(paramAnonymousMessage.c);
          g.c(((StringBuilder)localObject).toString());
          k.a(k.this).showUserDialog(2131492922, paramAnonymousMessage.c, 2131493040, null);
          return;
        case 4003: 
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
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("err ");
          ((StringBuilder)localObject).append(paramAnonymousMessage.a);
          g.c(((StringBuilder)localObject).toString());
          e.a(k.this.getResources(), paramAnonymousMessage);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("query up flow failed:");
          ((StringBuilder)localObject).append(paramAnonymousMessage.a);
          ((StringBuilder)localObject).append("-");
          ((StringBuilder)localObject).append(paramAnonymousMessage.b);
          ((StringBuilder)localObject).append("-");
          ((StringBuilder)localObject).append(paramAnonymousMessage.c);
          g.c(((StringBuilder)localObject).toString());
          k.a(k.this).showUserDialog(2131492986, paramAnonymousMessage.c, 2131493040, null);
          return;
        case 3026: 
          if (paramAnonymousMessage.arg1 == 0)
          {
            bool1 = bool2;
            if (paramAnonymousMessage.arg2 == 1) {
              bool1 = true;
            }
            k.a(k.this, bool1);
            return;
          }
          paramAnonymousMessage = (e)paramAnonymousMessage.obj;
          e.a(k.this.getResources(), paramAnonymousMessage);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("query up flow failed:");
          ((StringBuilder)localObject).append(paramAnonymousMessage.a);
          ((StringBuilder)localObject).append("-");
          ((StringBuilder)localObject).append(paramAnonymousMessage.b);
          ((StringBuilder)localObject).append("-");
          ((StringBuilder)localObject).append(paramAnonymousMessage.c);
          g.c(((StringBuilder)localObject).toString());
          k.a(k.this).showUserDialog(2131492922, paramAnonymousMessage.c, 2131493040, null);
          return;
        case 3024: 
          if (i == 0)
          {
            cc.a().a(k.b(k.this), k.e(k.this), k.this.a, k.c(k.this), 1);
            return;
          }
          paramAnonymousMessage = (e)paramAnonymousMessage.obj;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("err ");
          ((StringBuilder)localObject).append(paramAnonymousMessage.a);
          g.c(((StringBuilder)localObject).toString());
          e.a(k.this.getResources(), paramAnonymousMessage);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("query up flow failed:");
          ((StringBuilder)localObject).append(paramAnonymousMessage.a);
          ((StringBuilder)localObject).append("-");
          ((StringBuilder)localObject).append(paramAnonymousMessage.b);
          ((StringBuilder)localObject).append("-");
          ((StringBuilder)localObject).append(paramAnonymousMessage.c);
          g.c(((StringBuilder)localObject).toString());
          k.a(k.this).showToast(paramAnonymousMessage.c);
          return;
        }
        paramAnonymousMessage = (byte[])paramAnonymousMessage.obj;
        if (paramAnonymousMessage != null)
        {
          k.a(k.this, paramAnonymousMessage);
          cc.a().a(k.b(k.this), paramAnonymousMessage, k.this.a, k.c(k.this));
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
  private int[] p = { 2131493697, 2131493691, 2131493707, 2131493742, 2131493673, 2131493688, 2131493503, 2131493681, 2131493747, 2131493097, 2131493447, 2131493204 };
  private int[] q = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 20 };
  private int[] r = { 2131493678, 2131493693, 2131493679, 2131493743, 2131493265, 2131493266, 2131493474, 2131493386, 2131493747, 2131493097, 2131493447, 2131493204 };
  private int[] s = { 2131099916, 2131099901, 2131099904, 2131099914, 2131099895, 2131099900, 2131099921, 2131099906, 2131099922, 2131099897, 2131099897 };
  private View.OnClickListener t = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = cs.a().e();
      if (paramAnonymousView == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramAnonymousView.mRealUin);
      paramAnonymousView = ((StringBuilder)localObject).toString();
      localObject = ca.a(RqdApplication.n());
      if (!((ca)localObject).b(paramAnonymousView, 523005419L))
      {
        ((ca)localObject).a(paramAnonymousView, k.this.a, 523005419L);
        k.a(k.this).showProDialog(k.a(k.this), 2131492986, 2131493441, null);
        k.a(k.this, 1);
        return;
      }
      k.a(k.this).showUserDialog(2131493799, k.this.getResources().getString(2131493798), 2131493040, new DialogInterface.OnClickListener()
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
    if (cs.a().e() == null) {
      return;
    }
    b();
  }
  
  private void b()
  {
    QQUser localQQUser = cs.a().e();
    if (localQQUser != null)
    {
      if (localQQUser.mRealUin <= 0L) {
        return;
      }
      ca localca = ca.a(this.b);
      BaseActivity localBaseActivity = this.b;
      Handler localHandler = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(localQQUser.b());
      localca.a(localBaseActivity, 523005419L, localHandler, localStringBuilder.toString());
      return;
    }
  }
  
  private void c()
  {
    this.c = ((LayoutInflater)this.b.getSystemService("layout_inflater"));
    this.d = this.c.inflate(2131296493, null);
    removeAllViews();
    addView(this.d, new LinearLayout.LayoutParams(-1, -1));
    this.f = ((ImageView)findViewById(2131166227));
    this.g = ((TextView)findViewById(2131166228));
    this.h = ((TextView)findViewById(2131166234));
    this.i = ((TextView)findViewById(2131166233));
    this.j = ((Button)findViewById(2131166232));
    Object localObject1 = getResources().getString(2131493754);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("flag show scene id: ");
    ((StringBuilder)localObject2).append(this.e);
    g.a(((StringBuilder)localObject2).toString());
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
      ((StringBuilder)localObject2).append(getResources().getString(2131493752));
      ((StringBuilder)localObject2).append(getResources().getString(i2));
      ((StringBuilder)localObject2).append("?");
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131493751));
      localStringBuilder.append(getResources().getString(i2));
      localStringBuilder.append((String)localObject1);
      localObject1 = localStringBuilder.toString();
      this.h.setText((CharSequence)localObject2);
      this.i.setText((CharSequence)localObject1);
    }
    else if (this.e == -1)
    {
      this.f.setImageDrawable(getResources().getDrawable(2131099905));
      this.g.setText(2131493714);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getResources().getString(2131493752));
      ((StringBuilder)localObject2).append(getResources().getString(2131493709));
      ((StringBuilder)localObject2).append("?");
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131493751));
      localStringBuilder.append(getResources().getString(2131493709));
      localStringBuilder.append((String)localObject1);
      localObject1 = localStringBuilder.toString();
      this.h.setText((CharSequence)localObject2);
      this.i.setText((CharSequence)localObject1);
    }
    this.j.setOnClickListener(this.t);
    localObject1 = cs.a().e();
    if (localObject1 != null) {
      this.o = ((QQUser)localObject1).mRealUin;
    }
  }
  
  private void setActiveSucc(boolean paramBoolean)
  {
    Object localObject = cd.c();
    ((cd)localObject).i();
    ((cd)localObject).n();
    localObject = new Intent(this.b, VerifySuccActivity.class);
    ((Intent)localObject).putExtra("mRealUin", this.o);
    this.b.startActivity((Intent)localObject);
    this.b.finish();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
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
 * Qualified Name:     com.tencent.token.ui.base.k
 * JD-Core Version:    0.7.0.1
 */