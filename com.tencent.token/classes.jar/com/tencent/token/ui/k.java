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
import com.tencent.token.af;
import com.tencent.token.ba;
import com.tencent.token.bf;
import com.tencent.token.core.bean.g;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.ui.base.ds;

final class k
  extends BaseAdapter
{
  m a = new m(this);
  private UtilsAccountLockActivity b;
  private LayoutInflater c;
  private ListView d;
  private boolean e;
  private g f;
  private ds g;
  private Handler h;
  private int i;
  private int j;
  private int k;
  private TranslateAnimation l;
  private boolean m = false;
  
  public k(UtilsAccountLockActivity paramUtilsAccountLockActivity, ListView paramListView, Handler paramHandler)
  {
    this.b = paramUtilsAccountLockActivity;
    this.c = LayoutInflater.from(paramUtilsAccountLockActivity);
    this.d = paramListView;
    this.h = paramHandler;
    this.j = ba.a().a(true);
    this.k = ba.a().a(false);
    this.i = (this.j + this.k);
    if (this.i != 0) {
      this.i += 1;
    }
  }
  
  public final void a()
  {
    this.j = ba.a().a(true);
    this.k = ba.a().a(false);
    this.i = (this.j + this.k);
    if (this.i != 0) {
      this.i += 1;
    }
  }
  
  public final void a(d paramd)
  {
    int n = 0;
    e.c("account lock set: ");
    if ((this.f == null) || (this.g == null) || (paramd == null)) {}
    do
    {
      return;
      e.c("account lock set: ");
      this.f.e = false;
      if (paramd.a == 0) {
        n = 1;
      }
      if (n != 0)
      {
        AccountPageActivity.mNeedRefreshEval = true;
        ba.a().b();
        af.a().a(0L, this.h);
        this.m = true;
        return;
      }
    } while (this.f == null);
    d.a(this.b.getResources(), paramd);
    this.b.showTipDialog(2131361919, paramd.c);
  }
  
  public final void a(ds paramds, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramds == null) || (paramds.a() == null) || (this.b == null) || (this.b.isFinishing())) {}
    g localg;
    TextView localTextView;
    SwitchButton localSwitchButton;
    ProgressBar localProgressBar;
    ImageView localImageView;
    do
    {
      return;
      localg = paramds.a();
      localTextView = paramds.c();
      localSwitchButton = paramds.b();
      localProgressBar = paramds.d();
      localImageView = paramds.e();
    } while ((localTextView == null) || (localSwitchButton == null) || (localProgressBar == null) || (localImageView == null) || (localg == null) || ((paramBoolean) && (!localg.b.equals(localTextView.getText()))));
    if (localg.c)
    {
      paramds.g().setVisibility(0);
      if ((this.m) && (localg.b.equals(this.f.b)) && (localg.c == true))
      {
        paramds = paramds.f();
        paramds.setVisibility(0);
        this.l = new TranslateAnimation(-300.0F, UtilsAccountLockActivity.windowWidth, 0.0F, 0.0F);
        this.l.setDuration(800L);
        this.l.setInterpolator(new AccelerateInterpolator());
        this.l.setAnimationListener(new l(this, paramds));
        paramds.startAnimation(this.l);
        this.m = false;
      }
      if (!localg.f) {
        break label326;
      }
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      if ((!localg.e) && (ba.a().m())) {
        break label335;
      }
      localProgressBar.setVisibility(0);
      localSwitchButton.setVisibility(0);
      localSwitchButton.setEnabled(false);
      if (!ba.a().m()) {
        this.b.queryAccountLockStatus();
      }
      localTextView.setText(localg.b);
      return;
      paramds.g().setVisibility(8);
      break;
      label326:
      localImageView.setVisibility(4);
    }
    label335:
    localProgressBar.setVisibility(4);
    localSwitchButton.setVisibility(0);
    localSwitchButton.setEnabled(true);
    if (!localg.c) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localSwitchButton.a(paramBoolean, false);
      break;
    }
  }
  
  public final void b()
  {
    this.e = false;
  }
  
  public final void b(ds paramds, boolean paramBoolean)
  {
    g localg = paramds.a();
    if ((localg == null) || (paramds.h() == null) || (!ba.a().m()) || (paramBoolean != localg.c)) {}
    while ((localg.e) || (this.e)) {
      return;
    }
    this.f = localg;
    this.g = paramds;
    localg.e = true;
    this.e = true;
    a(paramds, false);
    bf.a().a(3, this.b.getHandler());
  }
  
  public final void c()
  {
    this.f.e = false;
    notifyDataSetChanged();
  }
  
  public final void d()
  {
    int n = 1;
    int i1 = this.f.a;
    if (this.f.c) {
      n = 0;
    }
    af localaf = af.a();
    Handler localHandler = this.h;
    localaf.a(0L, new int[] { i1 }, new int[] { n }, "", localHandler);
  }
  
  public final int getCount()
  {
    return this.i;
  }
  
  public final Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramInt == this.j)
    {
      localView = this.c.inflate(2130903225, paramViewGroup, false);
      return localView;
    }
    if (paramInt < this.j) {
      paramView = this.c.inflate(2130903228, paramViewGroup, false);
    }
    for (paramViewGroup = ba.a().a(paramInt, true);; paramViewGroup = ba.a().a(paramInt - this.j - 1, false))
    {
      localView = paramView;
      if (paramViewGroup == null) {
        break;
      }
      paramViewGroup = new ds(paramView, paramViewGroup);
      paramViewGroup.b().setTag(paramViewGroup);
      paramViewGroup.b().setOnCheckedChangeListener(this.a);
      a(paramViewGroup, false);
      return paramView;
      paramView = this.c.inflate(2130903227, paramViewGroup, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.k
 * JD-Core Version:    0.7.0.1
 */