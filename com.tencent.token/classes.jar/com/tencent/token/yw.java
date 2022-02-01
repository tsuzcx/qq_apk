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

public final class yw
  extends BaseAdapter
{
  public static boolean h = false;
  public UtilsGameLockActivity a;
  public boolean b;
  public te c;
  public zu d;
  public Handler e;
  public boolean f = true;
  public View g;
  a i = new a();
  private LayoutInflater j;
  private ListView k;
  
  public yw(UtilsGameLockActivity paramUtilsGameLockActivity, ListView paramListView, Handler paramHandler)
  {
    this.a = paramUtilsGameLockActivity;
    this.j = LayoutInflater.from(paramUtilsGameLockActivity);
    this.k = paramListView;
    this.e = paramHandler;
  }
  
  public static void a()
  {
    int n = tu.a().c.a();
    int m = 0;
    while (m < n)
    {
      te localte = tu.a().a(m);
      if (localte != null) {
        localte.e = false;
      }
      m += 1;
    }
  }
  
  public final void a(zu paramzu, boolean paramBoolean)
  {
    if ((paramzu != null) && (paramzu.h != null))
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        if (((UtilsGameLockActivity)localObject).isFinishing()) {
          return;
        }
        localObject = paramzu.h;
        TextView localTextView = paramzu.b;
        SwitchButton localSwitchButton = paramzu.d;
        ProgressBar localProgressBar = paramzu.c;
        paramzu = paramzu.e;
        if ((localTextView != null) && (localSwitchButton != null) && (localProgressBar != null) && (paramzu != null))
        {
          if (localObject == null) {
            return;
          }
          if ((paramBoolean) && (!((te)localObject).b.equals(localTextView.getText()))) {
            return;
          }
          if (((te)localObject).f) {
            paramzu.setVisibility(0);
          } else {
            paramzu.setVisibility(4);
          }
          if ((!((te)localObject).e) && (tu.a().c()))
          {
            localProgressBar.setVisibility(4);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(true);
            localSwitchButton.a(true ^ ((te)localObject).c, false);
          }
          else
          {
            localProgressBar.setVisibility(0);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(false);
          }
          if (!tu.a().c()) {
            this.a.queryGameLockStatus();
          }
          localTextView.setText(((te)localObject).b);
          return;
        }
        return;
      }
    }
  }
  
  public final int getCount()
  {
    if (this.f) {
      return tu.a().c.b();
    }
    return tu.a().c.a();
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
      localView = this.j.inflate(2131296485, paramViewGroup, false);
    }
    paramView = new zu(localView, tu.a().a(paramInt));
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
      paramCompoundButton = (zu)paramCompoundButton.getTag();
      if (paramCompoundButton == null) {
        return;
      }
      te localte = paramCompoundButton.h;
      if ((localte != null) && (paramCompoundButton.a != null) && (tu.a().c()))
      {
        if (paramBoolean != localte.c) {
          return;
        }
        if (!localte.e)
        {
          if (yw.a(yw.this)) {
            return;
          }
          yw.a(yw.this, localte);
          yw.a(yw.this, paramCompoundButton);
          localte.e = true;
          yw.b(yw.this);
          yw.this.a(paramCompoundButton, false);
          ty.a().a(3, yw.c(yw.this).getHandler());
          return;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yw
 * JD-Core Version:    0.7.0.1
 */