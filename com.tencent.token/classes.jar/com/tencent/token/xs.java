package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.UtilsAccountLockActivity;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.ui.base.UtilsAccountLockTipDialog;

public final class xs
  extends BaseAdapter
{
  public UtilsAccountLockActivity a;
  public boolean b;
  public sl c;
  public yw d;
  public Handler e;
  public int f;
  public int g;
  public int h;
  public boolean i = false;
  a j = new a();
  private LayoutInflater k;
  private ListView l;
  private TranslateAnimation m;
  
  public xs(UtilsAccountLockActivity paramUtilsAccountLockActivity, ListView paramListView, Handler paramHandler)
  {
    this.a = paramUtilsAccountLockActivity;
    this.k = LayoutInflater.from(paramUtilsAccountLockActivity);
    this.l = paramListView;
    this.e = paramHandler;
    this.g = tb.a().a(true);
    this.h = tb.a().a(false);
    this.f = (this.g + this.h);
    int n = this.f;
    if (n != 0) {
      this.f = (n + 1);
    }
  }
  
  public static void a()
  {
    int i1 = tb.a().a(true);
    int n = 0;
    sl localsl;
    while (n < i1)
    {
      localsl = tb.a().a(n, true);
      if (localsl != null) {
        localsl.e = false;
      }
      n += 1;
    }
    i1 = tb.a().a(false);
    n = 0;
    while (n < i1)
    {
      localsl = tb.a().a(n, false);
      if (localsl != null) {
        localsl.e = false;
      }
      n += 1;
    }
  }
  
  public final void a(final yw paramyw, boolean paramBoolean)
  {
    if ((paramyw != null) && (paramyw.h != null))
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        if (((UtilsAccountLockActivity)localObject).isFinishing()) {
          return;
        }
        localObject = paramyw.h;
        TextView localTextView = paramyw.b;
        SwitchButton localSwitchButton = paramyw.d;
        ProgressBar localProgressBar = paramyw.c;
        ImageView localImageView = paramyw.e;
        if ((localTextView != null) && (localSwitchButton != null) && (localProgressBar != null) && (localImageView != null))
        {
          if (localObject == null) {
            return;
          }
          if ((paramBoolean) && (!((sl)localObject).b.equals(localTextView.getText()))) {
            return;
          }
          if (((sl)localObject).c) {
            paramyw.g.setVisibility(0);
          } else {
            paramyw.g.setVisibility(8);
          }
          if ((this.i) && (((sl)localObject).b.equals(this.c.b)) && (((sl)localObject).c == true))
          {
            paramyw = paramyw.f;
            paramyw.setVisibility(0);
            this.m = new TranslateAnimation(-300.0F, UtilsAccountLockActivity.windowWidth, 0.0F, 0.0F);
            this.m.setDuration(800L);
            this.m.setInterpolator(new AccelerateInterpolator());
            this.m.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                paramyw.setVisibility(8);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
              
              public final void onAnimationStart(Animation paramAnonymousAnimation) {}
            });
            paramyw.startAnimation(this.m);
            this.i = false;
          }
          if (((sl)localObject).f) {
            localImageView.setVisibility(0);
          } else {
            localImageView.setVisibility(4);
          }
          if ((!((sl)localObject).e) && (tb.a().b()))
          {
            localProgressBar.setVisibility(4);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(true);
            localSwitchButton.a(((sl)localObject).c ^ true, false);
          }
          else
          {
            localProgressBar.setVisibility(0);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(false);
          }
          if (!tb.a().b()) {
            this.a.queryAccountLockStatus();
          }
          localTextView.setText(((sl)localObject).b);
          return;
        }
        return;
      }
    }
  }
  
  public final void b(yw paramyw, boolean paramBoolean)
  {
    sl localsl = paramyw.h;
    if ((localsl != null) && (paramyw.a != null) && (tb.a().b()))
    {
      if (paramBoolean != localsl.c) {
        return;
      }
      if (!localsl.e)
      {
        if (this.b) {
          return;
        }
        this.c = localsl;
        this.d = paramyw;
        localsl.e = true;
        this.b = true;
        a(paramyw, false);
        tf.a().a(3, this.a.getHandler());
        return;
      }
      return;
    }
  }
  
  public final int getCount()
  {
    return this.f;
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
    int n = this.g;
    if (paramInt == n) {
      return this.k.inflate(2131296470, paramViewGroup, false);
    }
    if (paramInt < n)
    {
      paramView = this.k.inflate(2131296473, paramViewGroup, false);
      paramViewGroup = tb.a().a(paramInt, true);
    }
    else
    {
      paramView = this.k.inflate(2131296472, paramViewGroup, false);
      paramViewGroup = tb.a().a(paramInt - this.g - 1, false);
    }
    if (paramViewGroup == null) {
      return paramView;
    }
    paramViewGroup = new yw(paramView, paramViewGroup);
    paramViewGroup.d.setTag(paramViewGroup);
    paramViewGroup.d.setOnCheckedChangeListener(this.j);
    a(paramViewGroup, false);
    return paramView;
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
      if ((!xc.c()) && (!paramBoolean))
      {
        try
        {
          SharedPreferences.Editor localEditor = RqdApplication.n().getSharedPreferences("sp_name_global", 0).edit();
          localEditor.putBoolean("utils_account_lock_tip", true);
          localEditor.commit();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
          localStringBuilder.append(localException.getMessage());
          xb.c(localStringBuilder.toString());
        }
        new UtilsAccountLockTipDialog(xs.a(xs.this), xs.b(xs.this), paramCompoundButton, paramBoolean).show();
        return;
      }
      xs.this.b(paramCompoundButton, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xs
 * JD-Core Version:    0.7.0.1
 */