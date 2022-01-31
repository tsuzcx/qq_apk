package com.tencent.token.ui;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.h;
import com.tencent.token.cw;
import com.tencent.token.dr;
import com.tencent.token.global.f;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.ui.base.dj;

class jy
  extends BaseAdapter
{
  public static boolean b = false;
  public boolean a = true;
  ka c = new ka(this);
  private UtilsGameLockActivity d;
  private LayoutInflater e;
  private ListView f;
  private boolean g;
  private h h;
  private dj i;
  private Handler j;
  private View k;
  
  public jy(UtilsGameLockActivity paramUtilsGameLockActivity, ListView paramListView, Handler paramHandler)
  {
    this.d = paramUtilsGameLockActivity;
    this.e = LayoutInflater.from(paramUtilsGameLockActivity);
    this.f = paramListView;
    this.j = paramHandler;
  }
  
  private void b(f paramf)
  {
    if (this.h == null) {
      return;
    }
    f.a(this.d.getResources(), paramf);
    this.d.showTipDialog(2131231390, paramf.c);
  }
  
  public void a()
  {
    this.h.e = false;
    notifyDataSetChanged();
  }
  
  public void a(View paramView)
  {
    this.k = paramView;
    this.k.setOnClickListener(new jz(this));
  }
  
  public void a(f paramf)
  {
    boolean bool = false;
    if ((this.h == null) || (this.i == null) || (paramf == null)) {
      return;
    }
    this.h.e = false;
    if (paramf.b())
    {
      paramf = this.h;
      if (!this.h.c) {
        bool = true;
      }
      paramf.c = bool;
      AccountPageActivity.mNeedRefreshEval = true;
    }
    while ((this.i != null) && (this.i.c() != null) && (this.h.b.equals(this.i.c().getText())))
    {
      a(this.i, true);
      return;
      b(paramf);
    }
    notifyDataSetChanged();
  }
  
  public void a(dj paramdj, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramdj == null) || (paramdj.a() == null) || (this.d == null) || (this.d.isFinishing())) {}
    h localh;
    TextView localTextView;
    SwitchButton localSwitchButton;
    ProgressBar localProgressBar;
    do
    {
      return;
      localh = paramdj.a();
      localTextView = paramdj.c();
      localSwitchButton = paramdj.b();
      localProgressBar = paramdj.d();
      paramdj = paramdj.e();
    } while ((localTextView == null) || (localSwitchButton == null) || (localProgressBar == null) || (paramdj == null) || (localh == null) || ((paramBoolean) && (!localh.b.equals(localTextView.getText()))));
    if (localh.f) {
      paramdj.setVisibility(0);
    }
    while ((localh.e) || (!dr.a().o()))
    {
      localProgressBar.setVisibility(0);
      localSwitchButton.setVisibility(0);
      localSwitchButton.setEnabled(false);
      if (!dr.a().o()) {
        this.d.queryGameLockStatus();
      }
      localTextView.setText(localh.b);
      return;
      paramdj.setVisibility(4);
    }
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
    this.g = paramBoolean;
  }
  
  public void b()
  {
    int n = this.h.a;
    int[] arrayOfInt = new int[1];
    if (this.h.c) {}
    for (int m = 0;; m = 1)
    {
      arrayOfInt[0] = m;
      if ((arrayOfInt != null) && (arrayOfInt.length > 0) && (arrayOfInt[0] == 1)) {
        b = true;
      }
      cw localcw = cw.a();
      Handler localHandler = this.j;
      localcw.a(0L, new int[] { n }, arrayOfInt, "", localHandler);
      return;
    }
  }
  
  public void c()
  {
    int n = dr.a().d();
    int m = 0;
    while (m < n)
    {
      h localh = dr.a().a(m);
      if (localh != null) {
        localh.e = false;
      }
      m += 1;
    }
  }
  
  public int getCount()
  {
    if (this.a) {
      return dr.a().c();
    }
    return dr.a().d();
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
    View localView = paramView;
    if (paramView == null) {
      localView = this.e.inflate(2130968790, paramViewGroup, false);
    }
    paramView = new dj(localView, dr.a().a(paramInt));
    paramView.b().setTag(paramView);
    paramView.b().setOnCheckedChangeListener(this.c);
    a(paramView, false);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jy
 * JD-Core Version:    0.7.0.1
 */