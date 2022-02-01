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

public final class yq
  extends BaseAdapter
{
  public UtilsAccountLockActivity a;
  public boolean b;
  public te c;
  public zu d;
  public Handler e;
  public int f;
  public int g;
  public int h;
  public boolean i = false;
  a j = new a();
  private LayoutInflater k;
  private ListView l;
  private TranslateAnimation m;
  
  public yq(UtilsAccountLockActivity paramUtilsAccountLockActivity, ListView paramListView, Handler paramHandler)
  {
    this.a = paramUtilsAccountLockActivity;
    this.k = LayoutInflater.from(paramUtilsAccountLockActivity);
    this.l = paramListView;
    this.e = paramHandler;
    this.g = tu.a().a(true);
    this.h = tu.a().a(false);
    this.f = (this.g + this.h);
    int n = this.f;
    if (n != 0) {
      this.f = (n + 1);
    }
  }
  
  public static void a()
  {
    int i1 = tu.a().a(true);
    int n = 0;
    te localte;
    while (n < i1)
    {
      localte = tu.a().a(n, true);
      if (localte != null) {
        localte.e = false;
      }
      n += 1;
    }
    i1 = tu.a().a(false);
    n = 0;
    while (n < i1)
    {
      localte = tu.a().a(n, false);
      if (localte != null) {
        localte.e = false;
      }
      n += 1;
    }
  }
  
  public final void a(final zu paramzu, boolean paramBoolean)
  {
    if ((paramzu != null) && (paramzu.h != null))
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        if (((UtilsAccountLockActivity)localObject).isFinishing()) {
          return;
        }
        localObject = paramzu.h;
        TextView localTextView = paramzu.b;
        SwitchButton localSwitchButton = paramzu.d;
        ProgressBar localProgressBar = paramzu.c;
        ImageView localImageView = paramzu.e;
        if ((localTextView != null) && (localSwitchButton != null) && (localProgressBar != null) && (localImageView != null))
        {
          if (localObject == null) {
            return;
          }
          if ((paramBoolean) && (!((te)localObject).b.equals(localTextView.getText()))) {
            return;
          }
          if (((te)localObject).c) {
            paramzu.g.setVisibility(0);
          } else {
            paramzu.g.setVisibility(8);
          }
          if ((this.i) && (((te)localObject).b.equals(this.c.b)) && (((te)localObject).c == true))
          {
            paramzu = paramzu.f;
            paramzu.setVisibility(0);
            this.m = new TranslateAnimation(-300.0F, UtilsAccountLockActivity.windowWidth, 0.0F, 0.0F);
            this.m.setDuration(800L);
            this.m.setInterpolator(new AccelerateInterpolator());
            this.m.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                paramzu.setVisibility(8);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
              
              public final void onAnimationStart(Animation paramAnonymousAnimation) {}
            });
            paramzu.startAnimation(this.m);
            this.i = false;
          }
          if (((te)localObject).f) {
            localImageView.setVisibility(0);
          } else {
            localImageView.setVisibility(4);
          }
          if ((!((te)localObject).e) && (tu.a().b()))
          {
            localProgressBar.setVisibility(4);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(true);
            localSwitchButton.a(((te)localObject).c ^ true, false);
          }
          else
          {
            localProgressBar.setVisibility(0);
            localSwitchButton.setVisibility(0);
            localSwitchButton.setEnabled(false);
          }
          if (!tu.a().b()) {
            this.a.queryAccountLockStatus();
          }
          localTextView.setText(((te)localObject).b);
          return;
        }
        return;
      }
    }
  }
  
  public final void b(zu paramzu, boolean paramBoolean)
  {
    te localte = paramzu.h;
    if ((localte != null) && (paramzu.a != null) && (tu.a().b()))
    {
      if (paramBoolean != localte.c) {
        return;
      }
      if (!localte.e)
      {
        if (this.b) {
          return;
        }
        this.c = localte;
        this.d = paramzu;
        localte.e = true;
        this.b = true;
        a(paramzu, false);
        ty.a().a(3, this.a.getHandler());
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
      return this.k.inflate(2131296483, paramViewGroup, false);
    }
    if (paramInt < n)
    {
      paramView = this.k.inflate(2131296486, paramViewGroup, false);
      paramViewGroup = tu.a().a(paramInt, true);
    }
    else
    {
      paramView = this.k.inflate(2131296485, paramViewGroup, false);
      paramViewGroup = tu.a().a(paramInt - this.g - 1, false);
    }
    if (paramViewGroup == null) {
      return paramView;
    }
    paramViewGroup = new zu(paramView, paramViewGroup);
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
      paramCompoundButton = (zu)paramCompoundButton.getTag();
      if (paramCompoundButton == null) {
        return;
      }
      if ((!xy.c()) && (!paramBoolean))
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
          xv.c(localStringBuilder.toString());
        }
        new UtilsAccountLockTipDialog(yq.a(yq.this), yq.b(yq.this), paramCompoundButton, paramBoolean).show();
        return;
      }
      yq.this.b(paramCompoundButton, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yq
 * JD-Core Version:    0.7.0.1
 */