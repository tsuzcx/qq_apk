package com.tencent.token;

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
import com.tencent.token.ui.UtilsGameLockActivity;
import com.tencent.token.ui.base.SwitchButton;

public final class xy
  extends BaseAdapter
{
  public static boolean h = false;
  public UtilsGameLockActivity a;
  public boolean b;
  public sl c;
  public yw d;
  public Handler e;
  public boolean f = true;
  public View g;
  a i = new a();
  private LayoutInflater j;
  private ListView k;
  
  public xy(UtilsGameLockActivity paramUtilsGameLockActivity, ListView paramListView, Handler paramHandler)
  {
    this.a = paramUtilsGameLockActivity;
    this.j = LayoutInflater.from(paramUtilsGameLockActivity);
    this.k = paramListView;
    this.e = paramHandler;
  }
  
  public static void a()
  {
    int n = tb.a().c.a();
    int m = 0;
    while (m < n)
    {
      sl localsl = tb.a().a(m);
      if (localsl != null) {
        localsl.e = false;
      }
      m += 1;
    }
  }
  
  public final void a(yw paramyw, boolean paramBoolean)
  {
    if ((paramyw != null) && (paramyw.h != null))
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        if (((UtilsGameLockActivity)localObject).isFinishing()) {
          return;
        }
        localObject = paramyw.h;
        TextView localTextView = paramyw.b;
        SwitchButton localSwitchButton = paramyw.d;
        ProgressBar localProgressBar = paramyw.c;
        paramyw = paramyw.e;
        if ((localTextView != null) && (localSwitchButton != null) && (localProgressBar != null) && (paramyw != null))
        {
          if (localObject == null) {
            return;
          }
          if ((paramBoolean) && (!((sl)localObject).b.equals(localTextView.getText()))) {
            return;
          }
          if (((sl)localObject).f) {
            paramyw.setVisibility(0);
          } else {
            paramyw.setVisibility(4);
          }
          if ((!((sl)localObject).e) && (tb.a().c()))
          {
            localProgressBar.setVisibility(4);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(true);
            localSwitchButton.a(true ^ ((sl)localObject).c, false);
          }
          else
          {
            localProgressBar.setVisibility(0);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(false);
          }
          if (!tb.a().c()) {
            this.a.queryGameLockStatus();
          }
          localTextView.setText(((sl)localObject).b);
          return;
        }
        return;
      }
    }
  }
  
  public final int getCount()
  {
    if (this.f) {
      return tb.a().c.b();
    }
    return tb.a().c.a();
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
      localView = this.j.inflate(2131296472, paramViewGroup, false);
    }
    paramView = new yw(localView, tb.a().a(paramInt));
    paramView.d.setTag(paramView);
    paramView.d.setOnCheckedChangeListener(this.i);
    a(paramView, false);
    return localView;
  }
  
  final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a() {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      paramCompoundButton = (yw)paramCompoundButton.getTag();
      if (paramCompoundButton == null) {
        return;
      }
      sl localsl = paramCompoundButton.h;
      if ((localsl != null) && (paramCompoundButton.a != null) && (tb.a().c()))
      {
        if (paramBoolean != localsl.c) {
          return;
        }
        if (!localsl.e)
        {
          if (xy.a(xy.this)) {
            return;
          }
          xy.a(xy.this, localsl);
          xy.a(xy.this, paramCompoundButton);
          localsl.e = true;
          xy.b(xy.this);
          xy.this.a(paramCompoundButton, false);
          tf.a().a(3, xy.c(xy.this).getHandler());
          return;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xy
 * JD-Core Version:    0.7.0.1
 */