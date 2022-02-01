package com.tencent.biz.pubaccount.readinjoy.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqcl;
import aqfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import kgk;
import kif;

public class ReadInJoyNewBaseActivity
  extends FragmentActivity
{
  protected boolean Wt;
  protected ImmersiveTitleBar2 a;
  public int aJb = -1;
  public LinearLayout ds;
  public ImageView ib;
  protected View jC;
  public TextView leftView;
  public TextView leftViewNotBack;
  protected float mDensity;
  public View mTitleContainer;
  public TextView nR;
  protected View.OnClickListener onBackListener = new kif(this);
  public ImageView rightViewImg;
  public TextView rightViewText;
  protected ViewGroup vg;
  public ViewGroup w;
  
  private View ag()
  {
    this.nR = ((TextView)findViewById(2131369627));
    this.ds = ((LinearLayout)findViewById(2131369629));
    this.ib = ((ImageView)findViewById(2131369628));
    return this.ds;
  }
  
  @TargetApi(11)
  public static void setLayerType(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  public void aDj()
  {
    this.Wt = true;
    this.jC = ((ViewStub)findViewById(2131379880)).inflate();
    if (this.jC != null) {
      this.jC.setVisibility(0);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void init(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130851111));
    this.vg = ((ViewGroup)findViewById(2131377363));
    setLayerType(this.vg);
    ag();
    onCreateLeftView();
    onCreateRightView();
    setLeftViewName(paramIntent);
  }
  
  @TargetApi(23)
  public void lU(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  protected void mc(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.rightViewImg != null)
    {
      localImageView = this.rightViewImg;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void oW(int paramInt)
  {
    if ((this.ib != null) && (paramInt != this.ib.getVisibility()))
    {
      this.ib.clearAnimation();
      this.ib.setVisibility(paramInt);
    }
  }
  
  public void oX(int paramInt)
  {
    if (this.aJb == paramInt) {}
    label188:
    label208:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseActivity", 2, "setDisplayMode from " + paramInt + " to " + this.aJb);
      }
      this.aJb = paramInt;
      if (this.aJb == 0)
      {
        if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
        {
          super.getWindow().addFlags(67108864);
          if (this.mSystemBarComp == null) {
            this.mSystemBarComp = new SystemBarCompact(this, true, -1);
          }
          this.mSystemBarComp.init();
          if (!this.Wt) {
            break label208;
          }
          if ((aqfo.isMIUI()) || (aqfo.isFlyme())) {
            break label188;
          }
          this.mSystemBarComp.setStatusBarColor(-7829368);
        }
        for (;;)
        {
          this.nR.setTextColor(-14408926);
          this.leftView.setTextColor(-14408926);
          this.leftView.setBackgroundResource(2130850369);
          this.rightViewImg.setImageResource(2130850367);
          this.vg.setBackgroundColor(-1);
          return;
          this.mSystemBarComp.setStatusBarColor(-7829368);
          this.mSystemBarComp.setStatusBarDarkMode(true);
          continue;
          if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
          {
            lU(true);
            this.mSystemBarComp.setStatusBarColor(-1);
          }
          else if (!aqfo.isFlyme())
          {
            this.mSystemBarComp.setStatusBarColor(-2368549);
          }
          else
          {
            this.mSystemBarComp.setStatusBarColor(-1);
            this.mSystemBarComp.setStatusBarDarkMode(true);
          }
        }
      }
    } while (this.aJb != 1);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null)
      {
        this.mSystemBarComp = new SystemBarCompact(this, true, -14408926);
        this.mSystemBarComp.init();
      }
      this.mSystemBarComp.setStatusBarDarkMode(false);
      if ((Build.VERSION.SDK_INT < 23) || (aqfo.isMIUI()) || (aqfo.isFlyme())) {
        break label428;
      }
      lU(false);
      this.mSystemBarComp.setStatusBarColor(-14408926);
    }
    for (;;)
    {
      this.nR.setTextColor(-1);
      this.leftView.setTextColor(-1);
      this.leftView.setBackgroundResource(2130850370);
      this.rightViewImg.setImageResource(2130850368);
      this.vg.setBackgroundColor(-14408926);
      return;
      label428:
      this.mSystemBarComp.init();
      this.mSystemBarComp.setStatusBarColor(-14408926);
    }
  }
  
  protected void oY(int paramInt)
  {
    if (this.rightViewImg != null) {
      this.rightViewImg.setImageResource(paramInt);
    }
  }
  
  public boolean onBackEvent()
  {
    finish();
    return false;
  }
  
  protected View onCreateLeftView()
  {
    this.leftView = ((TextView)findViewById(2131369579));
    this.leftView.setOnClickListener(this.onBackListener);
    setLayerType(this.leftView);
    if (AppSetting.enableTalkBack) {
      aqcl.changeAccessibilityForView(this.leftView, Button.class.getName());
    }
    return this.leftView;
  }
  
  protected View onCreateRightView()
  {
    this.rightViewImg = ((ImageView)findViewById(2131369594));
    setLayerType(this.rightViewImg);
    return this.rightViewText;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(7);
  }
  
  public void setContentView(int paramInt)
  {
    if (!this.mNeedStatusTrans)
    {
      super.setContentView(paramInt);
      getWindow().setFeatureInt(7, 2131559119);
    }
    do
    {
      if (this.mTitleContainer != null) {
        this.mTitleContainer.setVisibility(0);
      }
      this.mDensity = getResources().getDisplayMetrics().density;
      init(getIntent());
      return;
      Object localObject = LayoutInflater.from(this);
      View localView = ((LayoutInflater)localObject).inflate(2131560437, null);
      try
      {
        this.w = ((ViewGroup)localView.findViewById(2131379881));
        this.a = ((ImmersiveTitleBar2)localView.findViewById(2131379866));
        localObject = ((LayoutInflater)localObject).inflate(paramInt, this.w, false);
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.w.addView((View)localObject, 0, localLayoutParams);
        super.setContentView(localView);
        this.Wt = ThemeUtil.isInNightMode(this.app);
        i = 0;
      }
      catch (InflateException localInflateException)
      {
        for (;;)
        {
          localInflateException.printStackTrace();
          i = 1;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          localRuntimeException.printStackTrace();
          int i = 1;
        }
      }
    } while (i == 0);
    if (QLog.isColorLevel()) {
      QLog.e("IphoneTitleBarActivity", 2, "layout with merge ,use framelayout to immersive" + getComponentName());
    }
    super.setContentView(paramInt);
    getWindow().setFeatureInt(7, 2131559119);
    if (this.mTitleContainer != null) {
      this.mTitleContainer.setVisibility(0);
    }
    this.mDensity = getResources().getDisplayMetrics().density;
    init(getIntent());
  }
  
  public void setLeftViewName(Intent paramIntent)
  {
    if ((this.leftView != null) && ((this.leftView instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
      if (this.leftViewNotBack != null) {
        this.leftViewNotBack.setVisibility(8);
      }
    }
    try
    {
      TextView localTextView = this.leftView;
      String str = paramIntent.getExtras().getString("leftViewText");
      paramIntent.getExtras().getInt("individuation_url_type");
      if (str != null)
      {
        paramIntent = str;
        if (!str.contains("http")) {}
      }
      else
      {
        paramIntent = getString(2131691039);
      }
      localTextView.setText(paramIntent);
      localTextView.setVisibility(0);
      if (AppSetting.enableTalkBack)
      {
        str = this.leftView.getText().toString();
        paramIntent = str;
        if (!str.contains(getString(2131691039))) {
          paramIntent = getString(2131691039) + str;
        }
        this.leftView.setContentDescription(paramIntent);
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.nR != null) && ((this.nR instanceof TextView)))
    {
      TextView localTextView = this.nR;
      int i = kgk.aIG;
      Object localObject = paramCharSequence;
      if (paramCharSequence.length() > i) {
        localObject = paramCharSequence.subSequence(0, i) + "...";
      }
      localTextView.setText((CharSequence)localObject);
      super.setTitle((CharSequence)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewBaseActivity
 * JD-Core Version:    0.7.0.1
 */