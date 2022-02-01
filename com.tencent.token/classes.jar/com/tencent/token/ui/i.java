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
import com.tencent.token.cc;
import com.tencent.token.core.bean.f;
import com.tencent.token.ct;
import com.tencent.token.cx;
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
    this.d.showTipDialog(2131493533, parame.c);
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
        i.c(i.this).findViewById(2131166219).setVisibility(8);
        i.c(i.this).findViewById(2131166218).setVisibility(8);
        i.c(i.this).setVisibility(8);
        paramAnonymousView = i.this;
        paramAnonymousView.a = false;
        paramAnonymousView.notifyDataSetChanged();
      }
    });
  }
  
  public void a(e parame)
  {
    f localf = this.h;
    if ((localf != null) && (this.i != null))
    {
      if (parame == null) {
        return;
      }
      localf.e = false;
      if (parame.b())
      {
        parame = this.h;
        parame.c ^= true;
        AccountPageActivity.mNeedRefreshEval = true;
      }
      else
      {
        b(parame);
      }
      parame = this.i;
      if ((parame != null) && (parame.c() != null) && (this.h.b.equals(this.i.c().getText())))
      {
        a(this.i, true);
        return;
      }
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(l paraml, boolean paramBoolean)
  {
    if ((paraml != null) && (paraml.a() != null))
    {
      Object localObject = this.d;
      if (localObject != null)
      {
        if (((UtilsGameLockActivity)localObject).isFinishing()) {
          return;
        }
        localObject = paraml.a();
        TextView localTextView = paraml.c();
        SwitchButton localSwitchButton = paraml.b();
        ProgressBar localProgressBar = paraml.d();
        paraml = paraml.e();
        if ((localTextView != null) && (localSwitchButton != null) && (localProgressBar != null) && (paraml != null))
        {
          if (localObject == null) {
            return;
          }
          if ((paramBoolean) && (!((f)localObject).b.equals(localTextView.getText()))) {
            return;
          }
          if (((f)localObject).f) {
            paraml.setVisibility(0);
          } else {
            paraml.setVisibility(4);
          }
          if ((!((f)localObject).e) && (ct.a().o()))
          {
            localProgressBar.setVisibility(4);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(true);
            localSwitchButton.a(true ^ ((f)localObject).c, false);
          }
          else
          {
            localProgressBar.setVisibility(0);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(false);
          }
          if (!ct.a().o()) {
            this.d.queryGameLockStatus();
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
    this.g = paramBoolean;
  }
  
  public void b()
  {
    int m = this.h.a;
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = (this.h.c ^ true);
    if ((arrayOfInt.length > 0) && (arrayOfInt[0] == 1)) {
      b = true;
    }
    cc localcc = cc.a();
    Handler localHandler = this.j;
    localcc.a(0L, new int[] { m }, arrayOfInt, "", localHandler);
  }
  
  public void c()
  {
    int n = ct.a().d();
    int m = 0;
    while (m < n)
    {
      f localf = ct.a().a(m);
      if (localf != null) {
        localf.e = false;
      }
      m += 1;
    }
  }
  
  public int getCount()
  {
    if (this.a) {
      return ct.a().c();
    }
    return ct.a().d();
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
      localView = this.e.inflate(2131296471, paramViewGroup, false);
    }
    paramView = new l(localView, ct.a().a(paramInt));
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
      if (paramCompoundButton == null) {
        return;
      }
      f localf = paramCompoundButton.a();
      if ((localf != null) && (paramCompoundButton.h() != null) && (ct.a().o()))
      {
        if (paramBoolean != localf.c) {
          return;
        }
        if (!localf.e)
        {
          if (i.a(i.this)) {
            return;
          }
          i.a(i.this, localf);
          i.a(i.this, paramCompoundButton);
          localf.e = true;
          i.a(i.this, true);
          i.this.a(paramCompoundButton, false);
          cx.a().a(3, i.b(i.this).getHandler());
          return;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.i
 * JD-Core Version:    0.7.0.1
 */