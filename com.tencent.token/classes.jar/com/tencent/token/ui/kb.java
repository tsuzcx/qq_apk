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
import com.tencent.token.dr;
import com.tencent.token.ui.base.SwitchButton;

class kb
  extends BaseAdapter
{
  public boolean a = true;
  ke b = new ke(this);
  private UtilsGameProtectActivity c;
  private LayoutInflater d;
  private ListView e;
  private Handler f;
  private View g;
  
  public kb(UtilsGameProtectActivity paramUtilsGameProtectActivity, ListView paramListView, Handler paramHandler)
  {
    this.c = paramUtilsGameProtectActivity;
    this.d = LayoutInflater.from(paramUtilsGameProtectActivity);
    this.e = paramListView;
    this.f = paramHandler;
  }
  
  public void a()
  {
    int j = dr.a().f();
    int i = 0;
    while (i < j)
    {
      com.tencent.token.core.bean.h localh = dr.a().b(i);
      if (localh != null) {
        localh.e = false;
      }
      i += 1;
    }
  }
  
  public void a(View paramView)
  {
    this.g = paramView;
    this.g.setOnClickListener(new kd(this));
  }
  
  public void a(kf paramkf)
  {
    UtilsLoginProtectActivity.mNeedRefreshLoginProtect = true;
    AccountPageActivity.mNeedRefreshEval = true;
    new kc(this, paramkf).c(new com.tencent.token.core.bean.h[0]);
  }
  
  public void a(kf paramkf, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramkf == null) || (paramkf.a() == null) || (this.c == null) || (this.c.isFinishing())) {}
    com.tencent.token.core.bean.h localh;
    TextView localTextView;
    SwitchButton localSwitchButton;
    ProgressBar localProgressBar;
    do
    {
      do
      {
        return;
        localh = paramkf.a();
        localTextView = paramkf.c();
        localSwitchButton = paramkf.b();
        localProgressBar = paramkf.d();
        paramkf = paramkf.e();
      } while ((localTextView == null) || (localSwitchButton == null) || (localProgressBar == null) || (paramkf == null) || (localh == null));
      com.tencent.token.global.h.c("game protect: " + localh.b + ", " + localTextView.getText());
    } while ((paramBoolean) && (!localh.b.equals(localTextView.getText())));
    if (localh.f) {
      paramkf.setVisibility(0);
    }
    while ((localh.e) || (!dr.a().p()))
    {
      localProgressBar.setVisibility(0);
      localSwitchButton.setVisibility(0);
      localSwitchButton.setEnabled(false);
      if ((!dr.a().p()) && (!this.c.mIsIniting)) {
        this.c.queryGameProtectStatus();
      }
      localTextView.setText(localh.b);
      return;
      paramkf.setVisibility(4);
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
  
  public int getCount()
  {
    if (this.a) {
      return dr.a().e();
    }
    return dr.a().f();
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
    com.tencent.token.core.bean.h localh = dr.a().b(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = this.d.inflate(2130968795, paramViewGroup, false);
    }
    com.tencent.token.global.h.c("game protect getview: " + localh.a);
    paramView = new kf(this, localView, localh);
    paramView.b().setTag(paramView);
    paramView.b().setOnCheckedChangeListener(this.b);
    a(paramView, false);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kb
 * JD-Core Version:    0.7.0.1
 */