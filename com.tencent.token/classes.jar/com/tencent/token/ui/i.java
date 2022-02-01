package com.tencent.token.ui;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.ui.base.l;

class i
  extends BaseAdapter
{
  public static boolean b = false;
  public boolean a = true;
  a c = new a();
  private UtilsGameLockActivity d;
  private LayoutInflater e;
  private ListView f;
  private boolean g;
  private f h;
  private l i;
  private Handler j;
  private View k;
  
  public i(UtilsGameLockActivity paramUtilsGameLockActivity, ListView paramListView, Handler paramHandler)
  {
    this.d = paramUtilsGameLockActivity;
    this.e = LayoutInflater.from(paramUtilsGameLockActivity);
    this.f = paramListView;
    this.j = paramHandler;
  }
  
  private void b(e parame)
  {
    if (this.h == null) {
      return;
    }
    e.a(this.d.getResources(), parame);
    this.d.showTipDialog(2131231390, parame.c);
  }
  
  public void a()
  {
    this.h.e = false;
    notifyDataSetChanged();
  }
  
  public void a(View paramView)
  {
    this.k = paramView;
    this.k.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        i.c(i.this).findViewById(2131559431).setVisibility(8);
        i.c(i.this).findViewById(2131559430).setVisibility(8);
        i.c(i.this).setVisibility(8);
        i.this.a = false;
        i.this.notifyDataSetChanged();
      }
    });
  }
  
  public void a(e parame)
  {
    boolean bool = false;
    if ((this.h == null) || (this.i == null) || (parame == null)) {
      return;
    }
    this.h.e = false;
    if (parame.b())
    {
      parame = this.h;
      if (!this.h.c) {
        bool = true;
      }
      parame.c = bool;
      AccountPageActivity.mNeedRefreshEval = true;
    }
    while ((this.i != null) && (this.i.c() != null) && (this.h.b.equals(this.i.c().getText())))
    {
      a(this.i, true);
      return;
      b(parame);
    }
    notifyDataSetChanged();
  }
  
  public void a(l paraml, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paraml == null) || (paraml.a() == null) || (this.d == null) || (this.d.isFinishing())) {}
    f localf;
    TextView localTextView;
    SwitchButton localSwitchButton;
    ProgressBar localProgressBar;
    do
    {
      return;
      localf = paraml.a();
      localTextView = paraml.c();
      localSwitchButton = paraml.b();
      localProgressBar = paraml.d();
      paraml = paraml.e();
    } while ((localTextView == null) || (localSwitchButton == null) || (localProgressBar == null) || (paraml == null) || (localf == null) || ((paramBoolean) && (!localf.b.equals(localTextView.getText()))));
    if (localf.f) {
      paraml.setVisibility(0);
    }
    while ((localf.e) || (!cr.a().o()))
    {
      localProgressBar.setVisibility(0);
      localSwitchButton.setVisibility(0);
      localSwitchButton.setEnabled(false);
      if (!cr.a().o()) {
        this.d.queryGameLockStatus();
      }
      localTextView.setText(localf.b);
      return;
      paraml.setVisibility(4);
    }
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
      ca localca = ca.a();
      Handler localHandler = this.j;
      localca.a(0L, new int[] { n }, arrayOfInt, "", localHandler);
      return;
    }
  }
  
  public void c()
  {
    int n = cr.a().d();
    int m = 0;
    while (m < n)
    {
      f localf = cr.a().a(m);
      if (localf != null) {
        localf.e = false;
      }
      m += 1;
    }
  }
  
  public int getCount()
  {
    if (this.a) {
      return cr.a().c();
    }
    return cr.a().d();
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
    paramView = new l(localView, cr.a().a(paramInt));
    paramView.b().setTag(paramView);
    paramView.b().setOnCheckedChangeListener(this.c);
    a(paramView, false);
    return localView;
  }
  
  class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      paramCompoundButton = (l)paramCompoundButton.getTag();
      if (paramCompoundButton == null) {}
      f localf;
      do
      {
        return;
        localf = paramCompoundButton.a();
      } while ((localf == null) || (paramCompoundButton.h() == null) || (!cr.a().o()) || (paramBoolean != localf.c) || (localf.e) || (i.a(i.this)));
      i.a(i.this, localf);
      i.a(i.this, paramCompoundButton);
      localf.e = true;
      i.a(i.this, true);
      i.this.a(paramCompoundButton, false);
      cv.a().a(3, i.b(i.this).getHandler());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.i
 * JD-Core Version:    0.7.0.1
 */