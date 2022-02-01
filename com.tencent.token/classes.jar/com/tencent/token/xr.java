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

public final class xr
  extends BaseAdapter
{
  public UtilsAccountLockActivity a;
  public boolean b;
  public sk c;
  public yv d;
  public Handler e;
  public int f;
  public int g;
  public int h;
  public boolean i = false;
  a j = new a();
  private LayoutInflater k;
  private ListView l;
  private TranslateAnimation m;
  
  public xr(UtilsAccountLockActivity paramUtilsAccountLockActivity, ListView paramListView, Handler paramHandler)
  {
    this.a = paramUtilsAccountLockActivity;
    this.k = LayoutInflater.from(paramUtilsAccountLockActivity);
    this.l = paramListView;
    this.e = paramHandler;
    this.g = ta.a().a(true);
    this.h = ta.a().a(false);
    this.f = (this.g + this.h);
    int n = this.f;
    if (n != 0) {
      this.f = (n + 1);
    }
  }
  
  public static void a()
  {
    int i1 = ta.a().a(true);
    int n = 0;
    sk localsk;
    while (n < i1)
    {
      localsk = ta.a().a(n, true);
      if (localsk != null) {
        localsk.e = false;
      }
      n += 1;
    }
    i1 = ta.a().a(false);
    n = 0;
    while (n < i1)
    {
      localsk = ta.a().a(n, false);
      if (localsk != null) {
        localsk.e = false;
      }
      n += 1;
    }
  }
  
  public final void a(final yv paramyv, boolean paramBoolean)
  {
    if ((paramyv != null) && (paramyv.h != null))
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        if (((UtilsAccountLockActivity)localObject).isFinishing()) {
          return;
        }
        localObject = paramyv.h;
        TextView localTextView = paramyv.b;
        SwitchButton localSwitchButton = paramyv.d;
        ProgressBar localProgressBar = paramyv.c;
        ImageView localImageView = paramyv.e;
        if ((localTextView != null) && (localSwitchButton != null) && (localProgressBar != null) && (localImageView != null))
        {
          if (localObject == null) {
            return;
          }
          if ((paramBoolean) && (!((sk)localObject).b.equals(localTextView.getText()))) {
            return;
          }
          if (((sk)localObject).c) {
            paramyv.g.setVisibility(0);
          } else {
            paramyv.g.setVisibility(8);
          }
          if ((this.i) && (((sk)localObject).b.equals(this.c.b)) && (((sk)localObject).c == true))
          {
            paramyv = paramyv.f;
            paramyv.setVisibility(0);
            this.m = new TranslateAnimation(-300.0F, UtilsAccountLockActivity.windowWidth, 0.0F, 0.0F);
            this.m.setDuration(800L);
            this.m.setInterpolator(new AccelerateInterpolator());
            this.m.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                paramyv.setVisibility(8);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
              
              public final void onAnimationStart(Animation paramAnonymousAnimation) {}
            });
            paramyv.startAnimation(this.m);
            this.i = false;
          }
          if (((sk)localObject).f) {
            localImageView.setVisibility(0);
          } else {
            localImageView.setVisibility(4);
          }
          if ((!((sk)localObject).e) && (ta.a().b()))
          {
            localProgressBar.setVisibility(4);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(true);
            localSwitchButton.a(((sk)localObject).c ^ true, false);
          }
          else
          {
            localProgressBar.setVisibility(0);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(false);
          }
          if (!ta.a().b()) {
            this.a.queryAccountLockStatus();
          }
          localTextView.setText(((sk)localObject).b);
          return;
        }
        return;
      }
    }
  }
  
  public final void b(yv paramyv, boolean paramBoolean)
  {
    sk localsk = paramyv.h;
    if ((localsk != null) && (paramyv.a != null) && (ta.a().b()))
    {
      if (paramBoolean != localsk.c) {
        return;
      }
      if (!localsk.e)
      {
        if (this.b) {
          return;
        }
        this.c = localsk;
        this.d = paramyv;
        localsk.e = true;
        this.b = true;
        a(paramyv, false);
        te.a().a(3, this.a.getHandler());
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
      paramViewGroup = ta.a().a(paramInt, true);
    }
    else
    {
      paramView = this.k.inflate(2131296472, paramViewGroup, false);
      paramViewGroup = ta.a().a(paramInt - this.g - 1, false);
    }
    if (paramViewGroup == null) {
      return paramView;
    }
    paramViewGroup = new yv(paramView, paramViewGroup);
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
      paramCompoundButton = (yv)paramCompoundButton.getTag();
      if (paramCompoundButton == null) {
        return;
      }
      if ((!xb.c()) && (!paramBoolean))
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
          xa.c(localStringBuilder.toString());
        }
        new UtilsAccountLockTipDialog(xr.a(xr.this), xr.b(xr.this), paramCompoundButton, paramBoolean).show();
        return;
      }
      xr.this.b(paramCompoundButton, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xr
 * JD-Core Version:    0.7.0.1
 */