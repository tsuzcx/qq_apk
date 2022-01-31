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
import com.tencent.token.af;
import com.tencent.token.ba;
import com.tencent.token.core.bean.g;
import com.tencent.token.global.d;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.ui.base.ds;

final class ku
  extends BaseAdapter
{
  public static boolean b = false;
  public boolean a = true;
  kw c = new kw(this);
  private UtilsGameLockActivity d;
  private LayoutInflater e;
  private ListView f;
  private boolean g;
  private g h;
  private ds i;
  private Handler j;
  private View k;
  
  public ku(UtilsGameLockActivity paramUtilsGameLockActivity, ListView paramListView, Handler paramHandler)
  {
    this.d = paramUtilsGameLockActivity;
    this.e = LayoutInflater.from(paramUtilsGameLockActivity);
    this.f = paramListView;
    this.j = paramHandler;
  }
  
  public static void d()
  {
    int n = ba.a().d();
    int m = 0;
    while (m < n)
    {
      g localg = ba.a().a(m);
      if (localg != null) {
        localg.e = false;
      }
      m += 1;
    }
  }
  
  public final void a()
  {
    this.g = false;
  }
  
  public final void a(View paramView)
  {
    this.k = paramView;
    this.k.setOnClickListener(new kv(this));
  }
  
  public final void a(d paramd)
  {
    boolean bool = false;
    if ((this.h == null) || (this.i == null) || (paramd == null)) {
      return;
    }
    this.h.e = false;
    int m;
    if (paramd.a == 0)
    {
      m = 1;
      if (m == 0) {
        break label123;
      }
      paramd = this.h;
      if (!this.h.c) {
        bool = true;
      }
      paramd.c = bool;
      AccountPageActivity.mNeedRefreshEval = true;
    }
    for (;;)
    {
      if ((this.i == null) || (this.i.c() == null) || (!this.h.b.equals(this.i.c().getText()))) {
        break label157;
      }
      a(this.i, true);
      return;
      m = 0;
      break;
      label123:
      if (this.h != null)
      {
        d.a(this.d.getResources(), paramd);
        this.d.showTipDialog(2131361919, paramd.c);
      }
    }
    label157:
    notifyDataSetChanged();
  }
  
  public final void a(ds paramds, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramds == null) || (paramds.a() == null) || (this.d == null) || (this.d.isFinishing())) {}
    g localg;
    TextView localTextView;
    SwitchButton localSwitchButton;
    ProgressBar localProgressBar;
    do
    {
      return;
      localg = paramds.a();
      localTextView = paramds.c();
      localSwitchButton = paramds.b();
      localProgressBar = paramds.d();
      paramds = paramds.e();
    } while ((localTextView == null) || (localSwitchButton == null) || (localProgressBar == null) || (paramds == null) || (localg == null) || ((paramBoolean) && (!localg.b.equals(localTextView.getText()))));
    if (localg.f) {
      paramds.setVisibility(0);
    }
    while ((localg.e) || (!ba.a().n()))
    {
      localProgressBar.setVisibility(0);
      localSwitchButton.setVisibility(0);
      localSwitchButton.setEnabled(false);
      if (!ba.a().n()) {
        this.d.queryGameLockStatus();
      }
      localTextView.setText(localg.b);
      return;
      paramds.setVisibility(4);
    }
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
    this.h.e = false;
    notifyDataSetChanged();
  }
  
  public final void c()
  {
    int n = this.h.a;
    int[] arrayOfInt = new int[1];
    if (this.h.c) {}
    for (int m = 0;; m = 1)
    {
      arrayOfInt[0] = m;
      if ((arrayOfInt.length > 0) && (arrayOfInt[0] == 1)) {
        b = true;
      }
      af localaf = af.a();
      Handler localHandler = this.j;
      localaf.a(0L, new int[] { n }, arrayOfInt, "", localHandler);
      return;
    }
  }
  
  public final int getCount()
  {
    if (this.a) {
      return ba.a().c();
    }
    return ba.a().d();
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
    View localView = paramView;
    if (paramView == null) {
      localView = this.e.inflate(2130903227, paramViewGroup, false);
    }
    paramView = new ds(localView, ba.a().a(paramInt));
    paramView.b().setTag(paramView);
    paramView.b().setOnCheckedChangeListener(this.c);
    a(paramView, false);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ku
 * JD-Core Version:    0.7.0.1
 */