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
import com.tencent.token.ba;
import com.tencent.token.core.bean.g;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.SwitchButton;

final class kx
  extends BaseAdapter
{
  public boolean a = true;
  la b = new la(this);
  private UtilsGameProtectActivity c;
  private LayoutInflater d;
  private ListView e;
  private Handler f;
  private View g;
  
  public kx(UtilsGameProtectActivity paramUtilsGameProtectActivity, ListView paramListView, Handler paramHandler)
  {
    this.c = paramUtilsGameProtectActivity;
    this.d = LayoutInflater.from(paramUtilsGameProtectActivity);
    this.e = paramListView;
    this.f = paramHandler;
  }
  
  public final void a(View paramView)
  {
    this.g = paramView;
    this.g.setOnClickListener(new kz(this));
  }
  
  public final void a(lb paramlb, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramlb == null) || (paramlb.f == null) || (this.c == null) || (this.c.isFinishing())) {}
    g localg;
    TextView localTextView;
    SwitchButton localSwitchButton;
    ProgressBar localProgressBar;
    do
    {
      do
      {
        return;
        localg = paramlb.f;
        localTextView = paramlb.b;
        localSwitchButton = paramlb.d;
        localProgressBar = paramlb.c;
        paramlb = paramlb.e;
      } while ((localTextView == null) || (localSwitchButton == null) || (localProgressBar == null) || (paramlb == null) || (localg == null));
      e.c("game protect: " + localg.b + ", " + localTextView.getText());
    } while ((paramBoolean) && (!localg.b.equals(localTextView.getText())));
    if (localg.f) {
      paramlb.setVisibility(0);
    }
    while ((localg.e) || (!ba.a().o()))
    {
      localProgressBar.setVisibility(0);
      localSwitchButton.setVisibility(0);
      localSwitchButton.setEnabled(false);
      if ((!ba.a().o()) && (!this.c.mIsIniting)) {
        this.c.queryGameProtectStatus();
      }
      localTextView.setText(localg.b);
      return;
      paramlb.setVisibility(4);
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
  
  public final int getCount()
  {
    if (this.a) {
      return ba.a().e();
    }
    return ba.a().f();
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
    g localg = ba.a().b(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = this.d.inflate(2130903232, paramViewGroup, false);
    }
    e.c("game protect getview: " + localg.a);
    paramView = new lb(this, localView, localg);
    paramView.d.setTag(paramView);
    paramView.d.setOnCheckedChangeListener(this.b);
    a(paramView, false);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kx
 * JD-Core Version:    0.7.0.1
 */