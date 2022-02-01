package com.tencent.token.ui;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.cc;
import com.tencent.token.core.bean.f;
import com.tencent.token.ct;
import com.tencent.token.cx;
import com.tencent.token.global.e;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.ui.base.UtilsAccountLockTipDialog;
import com.tencent.token.ui.base.l;

class c
  extends BaseAdapter
{
  a a = new a();
  private UtilsAccountLockActivity b;
  private LayoutInflater c;
  private ListView d;
  private boolean e;
  private f f;
  private l g;
  private Handler h;
  private int i;
  private int j;
  private int k;
  private TranslateAnimation l;
  private boolean m = false;
  
  public c(UtilsAccountLockActivity paramUtilsAccountLockActivity, ListView paramListView, Handler paramHandler)
  {
    this.b = paramUtilsAccountLockActivity;
    this.c = LayoutInflater.from(paramUtilsAccountLockActivity);
    this.d = paramListView;
    this.h = paramHandler;
    this.j = ct.a().a(true);
    this.k = ct.a().a(false);
    this.i = (this.j + this.k);
    int n = this.i;
    if (n != 0) {
      this.i = (n + 1);
    }
  }
  
  private void b(e parame)
  {
    if (this.f == null) {
      return;
    }
    e.a(this.b.getResources(), parame);
    this.b.showTipDialog(2131493533, parame.c);
  }
  
  public void a()
  {
    this.j = ct.a().a(true);
    this.k = ct.a().a(false);
    this.i = (this.j + this.k);
    int n = this.i;
    if (n != 0) {
      this.i = (n + 1);
    }
  }
  
  public void a(e parame)
  {
    f localf = this.f;
    if ((localf != null) && (this.g != null))
    {
      if (parame == null) {
        return;
      }
      localf.e = false;
      if (parame.b())
      {
        AccountPageActivity.mNeedRefreshEval = true;
        ct.a().b();
        cc.a().a(0L, this.h);
        this.m = true;
      }
      else
      {
        b(parame);
      }
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(final l paraml, boolean paramBoolean)
  {
    if ((paraml != null) && (paraml.a() != null))
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        if (((UtilsAccountLockActivity)localObject).isFinishing()) {
          return;
        }
        localObject = paraml.a();
        TextView localTextView = paraml.c();
        SwitchButton localSwitchButton = paraml.b();
        ProgressBar localProgressBar = paraml.d();
        ImageView localImageView = paraml.e();
        if ((localTextView != null) && (localSwitchButton != null) && (localProgressBar != null) && (localImageView != null))
        {
          if (localObject == null) {
            return;
          }
          if ((paramBoolean) && (!((f)localObject).b.equals(localTextView.getText()))) {
            return;
          }
          if (((f)localObject).c) {
            paraml.g().setVisibility(0);
          } else {
            paraml.g().setVisibility(8);
          }
          if ((this.m) && (((f)localObject).b.equals(this.f.b)) && (((f)localObject).c == true))
          {
            paraml = paraml.f();
            paraml.setVisibility(0);
            this.l = new TranslateAnimation(-300.0F, UtilsAccountLockActivity.windowWidth, 0.0F, 0.0F);
            this.l.setDuration(800L);
            this.l.setInterpolator(new AccelerateInterpolator());
            this.l.setAnimationListener(new Animation.AnimationListener()
            {
              public void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                paraml.setVisibility(8);
              }
              
              public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
              
              public void onAnimationStart(Animation paramAnonymousAnimation) {}
            });
            paraml.startAnimation(this.l);
            this.m = false;
          }
          if (((f)localObject).f) {
            localImageView.setVisibility(0);
          } else {
            localImageView.setVisibility(4);
          }
          if ((!((f)localObject).e) && (ct.a().n()))
          {
            localProgressBar.setVisibility(4);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(true);
            localSwitchButton.a(((f)localObject).c ^ true, false);
          }
          else
          {
            localProgressBar.setVisibility(0);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(false);
          }
          if (!ct.a().n()) {
            this.b.queryAccountLockStatus();
          }
          localTextView.setText(((f)localObject).b);
          return;
        }
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b()
  {
    this.f.e = false;
    notifyDataSetChanged();
  }
  
  public void b(l paraml, boolean paramBoolean)
  {
    f localf = paraml.a();
    if ((localf != null) && (paraml.h() != null) && (ct.a().n()))
    {
      if (paramBoolean != localf.c) {
        return;
      }
      if (!localf.e)
      {
        if (this.e) {
          return;
        }
        this.f = localf;
        this.g = paraml;
        localf.e = true;
        this.e = true;
        a(paraml, false);
        cx.a().a(3, this.b.getHandler());
        return;
      }
      return;
    }
  }
  
  public void c()
  {
    int n = this.f.a;
    boolean bool = this.f.c;
    cc localcc = cc.a();
    Handler localHandler = this.h;
    localcc.a(0L, new int[] { n }, new int[] { true ^ bool }, "", localHandler);
  }
  
  public void d()
  {
    int i1 = ct.a().a(true);
    int n = 0;
    f localf;
    while (n < i1)
    {
      localf = ct.a().a(n, true);
      if (localf != null) {
        localf.e = false;
      }
      n += 1;
    }
    i1 = ct.a().a(false);
    n = 0;
    while (n < i1)
    {
      localf = ct.a().a(n, false);
      if (localf != null) {
        localf.e = false;
      }
      n += 1;
    }
  }
  
  public int getCount()
  {
    return this.i;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int n = this.j;
    if (paramInt == n) {
      return this.c.inflate(2131296469, paramViewGroup, false);
    }
    if (paramInt < n)
    {
      paramView = this.c.inflate(2131296472, paramViewGroup, false);
      paramViewGroup = ct.a().a(paramInt, true);
    }
    else
    {
      paramView = this.c.inflate(2131296471, paramViewGroup, false);
      paramViewGroup = ct.a().a(paramInt - this.j - 1, false);
    }
    if (paramViewGroup == null) {
      return paramView;
    }
    paramViewGroup = new l(paramView, paramViewGroup);
    paramViewGroup.b().setTag(paramViewGroup);
    paramViewGroup.b().setOnCheckedChangeListener(this.a);
    a(paramViewGroup, false);
    return paramView;
  }
  
  class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      paramCompoundButton = (l)paramCompoundButton.getTag();
      if (paramCompoundButton == null) {
        return;
      }
      if ((!h.e()) && (!paramBoolean))
      {
        h.b(true);
        new UtilsAccountLockTipDialog(c.a(c.this), 2131558791, c.b(c.this), paramCompoundButton, paramBoolean).show();
        return;
      }
      c.this.b(paramCompoundButton, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.c
 * JD-Core Version:    0.7.0.1
 */