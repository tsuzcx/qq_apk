package com.tencent.token.ui;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.h;
import com.tencent.token.cw;
import com.tencent.token.dr;
import com.tencent.token.dw;
import com.tencent.token.global.f;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.ui.base.dj;

class i
  extends BaseAdapter
{
  k a = new k(this);
  private UtilsAccountLockActivity b;
  private LayoutInflater c;
  private ListView d;
  private boolean e;
  private h f;
  private dj g;
  private Handler h;
  private int i;
  private int j;
  private int k;
  private TranslateAnimation l;
  private boolean m = false;
  
  public i(UtilsAccountLockActivity paramUtilsAccountLockActivity, ListView paramListView, Handler paramHandler)
  {
    this.b = paramUtilsAccountLockActivity;
    this.c = LayoutInflater.from(paramUtilsAccountLockActivity);
    this.d = paramListView;
    this.h = paramHandler;
    this.j = dr.a().a(true);
    this.k = dr.a().a(false);
    this.i = (this.j + this.k);
    if (this.i != 0) {
      this.i += 1;
    }
  }
  
  private void b(f paramf)
  {
    if (this.f == null) {
      return;
    }
    f.a(this.b.getResources(), paramf);
    this.b.showTipDialog(2131231390, paramf.c);
  }
  
  public void a()
  {
    this.j = dr.a().a(true);
    this.k = dr.a().a(false);
    this.i = (this.j + this.k);
    if (this.i != 0) {
      this.i += 1;
    }
  }
  
  public void a(f paramf)
  {
    if ((this.f == null) || (this.g == null) || (paramf == null)) {
      return;
    }
    this.f.e = false;
    if (paramf.b())
    {
      AccountPageActivity.mNeedRefreshEval = true;
      dr.a().b();
      cw.a().a(0L, this.h);
      this.m = true;
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      b(paramf);
    }
  }
  
  public void a(dj paramdj, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramdj == null) || (paramdj.a() == null) || (this.b == null) || (this.b.isFinishing())) {}
    h localh;
    TextView localTextView;
    SwitchButton localSwitchButton;
    ProgressBar localProgressBar;
    ImageView localImageView;
    do
    {
      return;
      localh = paramdj.a();
      localTextView = paramdj.c();
      localSwitchButton = paramdj.b();
      localProgressBar = paramdj.d();
      localImageView = paramdj.e();
    } while ((localTextView == null) || (localSwitchButton == null) || (localProgressBar == null) || (localImageView == null) || (localh == null) || ((paramBoolean) && (!localh.b.equals(localTextView.getText()))));
    if (localh.c)
    {
      paramdj.g().setVisibility(0);
      if ((this.m) && (localh.b.equals(this.f.b)) && (localh.c == true))
      {
        paramdj = paramdj.f();
        paramdj.setVisibility(0);
        this.l = new TranslateAnimation(-300.0F, UtilsAccountLockActivity.windowWidth, 0.0F, 0.0F);
        this.l.setDuration(800L);
        this.l.setInterpolator(new AccelerateInterpolator());
        this.l.setAnimationListener(new j(this, paramdj));
        paramdj.startAnimation(this.l);
        this.m = false;
      }
      if (!localh.f) {
        break label326;
      }
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      if ((!localh.e) && (dr.a().n())) {
        break label335;
      }
      localProgressBar.setVisibility(0);
      localSwitchButton.setVisibility(0);
      localSwitchButton.setEnabled(false);
      if (!dr.a().n()) {
        this.b.queryAccountLockStatus();
      }
      localTextView.setText(localh.b);
      return;
      paramdj.g().setVisibility(8);
      break;
      label326:
      localImageView.setVisibility(4);
    }
    label335:
    localProgressBar.setVisibility(4);
    localSwitchButton.setVisibility(0);
    localSwitchButton.setEnabled(true);
    if (!localh.c) {}
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
  
  public void b(dj paramdj, boolean paramBoolean)
  {
    h localh = paramdj.a();
    if ((localh == null) || (paramdj.h() == null) || (!dr.a().n()) || (paramBoolean != localh.c)) {}
    while ((localh.e) || (this.e)) {
      return;
    }
    this.f = localh;
    this.g = paramdj;
    localh.e = true;
    this.e = true;
    a(paramdj, false);
    dw.a().a(3, this.b.getHandler());
  }
  
  public void c()
  {
    int n = 1;
    int i1 = this.f.a;
    if (this.f.c) {
      n = 0;
    }
    cw localcw = cw.a();
    Handler localHandler = this.h;
    localcw.a(0L, new int[] { i1 }, new int[] { n }, "", localHandler);
  }
  
  public void d()
  {
    int i1 = dr.a().a(true);
    int n = 0;
    h localh;
    while (n < i1)
    {
      localh = dr.a().a(n, true);
      if (localh != null) {
        localh.e = false;
      }
      n += 1;
    }
    i1 = dr.a().a(false);
    n = 0;
    while (n < i1)
    {
      localh = dr.a().a(n, false);
      if (localh != null) {
        localh.e = false;
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
    for (paramViewGroup = dr.a().a(paramInt, true);; paramViewGroup = dr.a().a(paramInt - this.j - 1, false))
    {
      localView = paramView;
      if (paramViewGroup == null) {
        break;
      }
      paramViewGroup = new dj(paramView, paramViewGroup);
      paramViewGroup.b().setTag(paramViewGroup);
      paramViewGroup.b().setOnCheckedChangeListener(this.a);
      a(paramViewGroup, false);
      return paramView;
      paramView = this.c.inflate(2130968790, paramViewGroup, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.i
 * JD-Core Version:    0.7.0.1
 */