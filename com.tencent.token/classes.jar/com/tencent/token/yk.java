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

public final class yk
  extends BaseAdapter
{
  public static boolean h = false;
  public UtilsGameLockActivity a;
  public boolean b;
  public ss c;
  public zi d;
  public Handler e;
  public boolean f = true;
  public View g;
  a i = new a();
  private LayoutInflater j;
  private ListView k;
  
  public yk(UtilsGameLockActivity paramUtilsGameLockActivity, ListView paramListView, Handler paramHandler)
  {
    this.a = paramUtilsGameLockActivity;
    this.j = LayoutInflater.from(paramUtilsGameLockActivity);
    this.k = paramListView;
    this.e = paramHandler;
  }
  
  public static void a()
  {
    int n = ti.a().c.a();
    int m = 0;
    while (m < n)
    {
      ss localss = ti.a().a(m);
      if (localss != null) {
        localss.e = false;
      }
      m += 1;
    }
  }
  
  public final void a(zi paramzi, boolean paramBoolean)
  {
    if ((paramzi != null) && (paramzi.h != null))
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        if (((UtilsGameLockActivity)localObject).isFinishing()) {
          return;
        }
        localObject = paramzi.h;
        TextView localTextView = paramzi.b;
        SwitchButton localSwitchButton = paramzi.d;
        ProgressBar localProgressBar = paramzi.c;
        paramzi = paramzi.e;
        if ((localTextView != null) && (localSwitchButton != null) && (localProgressBar != null) && (paramzi != null))
        {
          if (localObject == null) {
            return;
          }
          if ((paramBoolean) && (!((ss)localObject).b.equals(localTextView.getText()))) {
            return;
          }
          if (((ss)localObject).f) {
            paramzi.setVisibility(0);
          } else {
            paramzi.setVisibility(4);
          }
          if ((!((ss)localObject).e) && (ti.a().c()))
          {
            localProgressBar.setVisibility(4);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(true);
            localSwitchButton.a(true ^ ((ss)localObject).c, false);
          }
          else
          {
            localProgressBar.setVisibility(0);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(false);
          }
          if (!ti.a().c()) {
            this.a.queryGameLockStatus();
          }
          localTextView.setText(((ss)localObject).b);
          return;
        }
        return;
      }
    }
  }
  
  public final int getCount()
  {
    if (this.f) {
      return ti.a().c.b();
    }
    return ti.a().c.a();
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
    paramView = new zi(localView, ti.a().a(paramInt));
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
      paramCompoundButton = (zi)paramCompoundButton.getTag();
      if (paramCompoundButton == null) {
        return;
      }
      ss localss = paramCompoundButton.h;
      if ((localss != null) && (paramCompoundButton.a != null) && (ti.a().c()))
      {
        if (paramBoolean != localss.c) {
          return;
        }
        if (!localss.e)
        {
          if (yk.a(yk.this)) {
            return;
          }
          yk.a(yk.this, localss);
          yk.a(yk.this, paramCompoundButton);
          localss.e = true;
          yk.b(yk.this);
          yk.this.a(paramCompoundButton, false);
          tm.a().a(3, yk.c(yk.this).getHandler());
          return;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yk
 * JD-Core Version:    0.7.0.1
 */