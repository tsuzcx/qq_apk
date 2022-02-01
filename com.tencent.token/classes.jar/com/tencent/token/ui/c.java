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
import com.tencent.token.ca;
import com.tencent.token.core.bean.f;
import com.tencent.token.cr;
import com.tencent.token.cv;
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
    this.j = cr.a().a(true);
    this.k = cr.a().a(false);
    this.i = (this.j + this.k);
    if (this.i != 0) {
      this.i += 1;
    }
  }
  
  private void b(e parame)
  {
    if (this.f == null) {
      return;
    }
    e.a(this.b.getResources(), parame);
    this.b.showTipDialog(2131231390, parame.c);
  }
  
  public void a()
  {
    this.j = cr.a().a(true);
    this.k = cr.a().a(false);
    this.i = (this.j + this.k);
    if (this.i != 0) {
      this.i += 1;
    }
  }
  
  public void a(e parame)
  {
    if ((this.f == null) || (this.g == null) || (parame == null)) {
      return;
    }
    this.f.e = false;
    if (parame.b())
    {
      AccountPageActivity.mNeedRefreshEval = true;
      cr.a().b();
      ca.a().a(0L, this.h);
      this.m = true;
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      b(parame);
    }
  }
  
  public void a(final l paraml, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paraml == null) || (paraml.a() == null) || (this.b == null) || (this.b.isFinishing())) {}
    f localf;
    TextView localTextView;
    SwitchButton localSwitchButton;
    ProgressBar localProgressBar;
    ImageView localImageView;
    do
    {
      return;
      localf = paraml.a();
      localTextView = paraml.c();
      localSwitchButton = paraml.b();
      localProgressBar = paraml.d();
      localImageView = paraml.e();
    } while ((localTextView == null) || (localSwitchButton == null) || (localProgressBar == null) || (localImageView == null) || (localf == null) || ((paramBoolean) && (!localf.b.equals(localTextView.getText()))));
    if (localf.c)
    {
      paraml.g().setVisibility(0);
      if ((this.m) && (localf.b.equals(this.f.b)) && (localf.c == true))
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
      if (!localf.f) {
        break label326;
      }
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      if ((!localf.e) && (cr.a().n())) {
        break label335;
      }
      localProgressBar.setVisibility(0);
      localSwitchButton.setVisibility(0);
      localSwitchButton.setEnabled(false);
      if (!cr.a().n()) {
        this.b.queryAccountLockStatus();
      }
      localTextView.setText(localf.b);
      return;
      paraml.g().setVisibility(8);
      break;
      label326:
      localImageView.setVisibility(4);
    }
    label335:
    localProgressBar.setVisibility(4);
    localSwitchButton.setVisibility(0);
    localSwitchButton.setEnabled(true);
    if (!localf.c) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localSwitchButton.a(paramBoolean, false);
      break;
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
    if ((localf == null) || (paraml.h() == null) || (!cr.a().n()) || (paramBoolean != localf.c)) {}
    while ((localf.e) || (this.e)) {
      return;
    }
    this.f = localf;
    this.g = paraml;
    localf.e = true;
    this.e = true;
    a(paraml, false);
    cv.a().a(3, this.b.getHandler());
  }
  
  public void c()
  {
    int n = 1;
    int i1 = this.f.a;
    if (this.f.c) {
      n = 0;
    }
    ca localca = ca.a();
    Handler localHandler = this.h;
    localca.a(0L, new int[] { i1 }, new int[] { n }, "", localHandler);
  }
  
  public void d()
  {
    int i1 = cr.a().a(true);
    int n = 0;
    f localf;
    while (n < i1)
    {
      localf = cr.a().a(n, true);
      if (localf != null) {
        localf.e = false;
      }
      n += 1;
    }
    i1 = cr.a().a(false);
    n = 0;
    while (n < i1)
    {
      localf = cr.a().a(n, false);
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
    View localView;
    if (paramInt == this.j)
    {
      localView = this.c.inflate(2130968788, paramViewGroup, false);
      return localView;
    }
    if (paramInt < this.j) {
      paramView = this.c.inflate(2130968791, paramViewGroup, false);
    }
    for (paramViewGroup = cr.a().a(paramInt, true);; paramViewGroup = cr.a().a(paramInt - this.j - 1, false))
    {
      localView = paramView;
      if (paramViewGroup == null) {
        break;
      }
      paramViewGroup = new l(paramView, paramViewGroup);
      paramViewGroup.b().setTag(paramViewGroup);
      paramViewGroup.b().setOnCheckedChangeListener(this.a);
      a(paramViewGroup, false);
      return paramView;
      paramView = this.c.inflate(2130968790, paramViewGroup, false);
    }
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
        new UtilsAccountLockTipDialog(c.a(c.this), 2131362182, c.b(c.this), paramCompoundButton, paramBoolean).show();
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