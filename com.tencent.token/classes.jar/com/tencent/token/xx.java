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

public final class xx
  extends BaseAdapter
{
  public static boolean h = false;
  public UtilsGameLockActivity a;
  public boolean b;
  public sk c;
  public yv d;
  public Handler e;
  public boolean f = true;
  public View g;
  a i = new a();
  private LayoutInflater j;
  private ListView k;
  
  public xx(UtilsGameLockActivity paramUtilsGameLockActivity, ListView paramListView, Handler paramHandler)
  {
    this.a = paramUtilsGameLockActivity;
    this.j = LayoutInflater.from(paramUtilsGameLockActivity);
    this.k = paramListView;
    this.e = paramHandler;
  }
  
  public static void a()
  {
    int n = ta.a().c.a();
    int m = 0;
    while (m < n)
    {
      sk localsk = ta.a().a(m);
      if (localsk != null) {
        localsk.e = false;
      }
      m += 1;
    }
  }
  
  public final void a(yv paramyv, boolean paramBoolean)
  {
    if ((paramyv != null) && (paramyv.h != null))
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        if (((UtilsGameLockActivity)localObject).isFinishing()) {
          return;
        }
        localObject = paramyv.h;
        TextView localTextView = paramyv.b;
        SwitchButton localSwitchButton = paramyv.d;
        ProgressBar localProgressBar = paramyv.c;
        paramyv = paramyv.e;
        if ((localTextView != null) && (localSwitchButton != null) && (localProgressBar != null) && (paramyv != null))
        {
          if (localObject == null) {
            return;
          }
          if ((paramBoolean) && (!((sk)localObject).b.equals(localTextView.getText()))) {
            return;
          }
          if (((sk)localObject).f) {
            paramyv.setVisibility(0);
          } else {
            paramyv.setVisibility(4);
          }
          if ((!((sk)localObject).e) && (ta.a().c()))
          {
            localProgressBar.setVisibility(4);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(true);
            localSwitchButton.a(true ^ ((sk)localObject).c, false);
          }
          else
          {
            localProgressBar.setVisibility(0);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(false);
          }
          if (!ta.a().c()) {
            this.a.queryGameLockStatus();
          }
          localTextView.setText(((sk)localObject).b);
          return;
        }
        return;
      }
    }
  }
  
  public final int getCount()
  {
    if (this.f) {
      return ta.a().c.b();
    }
    return ta.a().c.a();
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
    paramView = new yv(localView, ta.a().a(paramInt));
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
      paramCompoundButton = (yv)paramCompoundButton.getTag();
      if (paramCompoundButton == null) {
        return;
      }
      sk localsk = paramCompoundButton.h;
      if ((localsk != null) && (paramCompoundButton.a != null) && (ta.a().c()))
      {
        if (paramBoolean != localsk.c) {
          return;
        }
        if (!localsk.e)
        {
          if (xx.a(xx.this)) {
            return;
          }
          xx.a(xx.this, localsk);
          xx.a(xx.this, paramCompoundButton);
          localsk.e = true;
          xx.b(xx.this);
          xx.this.a(paramCompoundButton, false);
          te.a().a(3, xx.c(xx.this).getHandler());
          return;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xx
 * JD-Core Version:    0.7.0.1
 */