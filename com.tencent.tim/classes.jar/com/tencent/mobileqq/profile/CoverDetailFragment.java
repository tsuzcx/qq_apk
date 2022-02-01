package com.tencent.mobileqq.profile;

import acfp;
import acle;
import aclh;
import alau;
import alav;
import alaw;
import alco;
import alco.a;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import aqfo;
import aqmp;
import aqnl;
import aqrc;
import awdo;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class CoverDetailFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private ImageView Cu;
  private TextView Pd;
  private alco.a a;
  private int brx;
  private URLDrawable.URLDrawableListener c = new alav(this);
  private aclh g = new alaw(this);
  private Button mButton;
  private ImageView mImageView;
  private int mItemId;
  
  private void c(FragmentActivity paramFragmentActivity)
  {
    QQToast.a(paramFragmentActivity, 1, 2131721430, 0).show();
    this.mButton.setBackgroundResource(2130851071);
    this.brx = 1;
    this.mButton.setTextColor(-16777216);
    this.mButton.setText(2131697051);
  }
  
  public Drawable D(Drawable paramDrawable)
  {
    Object localObject2 = null;
    if (getActivity() == null) {
      return null;
    }
    Object localObject1;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject1 = ((BitmapDrawable)paramDrawable).getBitmap();
      if (localObject1 != null) {
        break label150;
      }
      paramDrawable = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
      paramDrawable.eraseColor(-7829368);
    }
    for (;;)
    {
      aqmp.fastblur(paramDrawable, 40);
      return new LayerDrawable(new Drawable[] { new BitmapDrawable(getActivity().getResources(), paramDrawable), new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { -1728053248, -1275068417, -1 }) });
      localObject1 = localObject2;
      if (!(paramDrawable instanceof URLDrawable)) {
        break;
      }
      paramDrawable = ((URLDrawable)paramDrawable).getCurrDrawable();
      localObject1 = localObject2;
      if (!(paramDrawable instanceof RegionDrawable)) {
        break;
      }
      localObject1 = ((RegionDrawable)paramDrawable).getBitmap();
      break;
      label150:
      paramDrawable = ((Bitmap)localObject1).copy(Bitmap.Config.ARGB_8888, true);
    }
  }
  
  void dEI()
  {
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      getTitleBarView().setBackgroundColor(-1);
    }
    FragmentActivity localFragmentActivity = getActivity();
    SystemBarCompact localSystemBarCompact;
    if ((localFragmentActivity != null) && ((localFragmentActivity instanceof PublicFragmentActivity)))
    {
      localSystemBarCompact = ((PublicFragmentActivity)localFragmentActivity).mSystemBarComp;
      if ((localSystemBarCompact != null) && (needImmersive()) && (needStatusTrans()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (!ThemeUtil.isInNightMode(localFragmentActivity.getAppRuntime())) {
          break label113;
        }
        if ((aqfo.isMIUI()) || (aqfo.isFlyme())) {
          break label101;
        }
        localSystemBarCompact.setStatusBarColor(8947848);
      }
    }
    return;
    label101:
    localSystemBarCompact.setStatusBarColor(8947848);
    localSystemBarCompact.setStatusBarDarkMode(true);
    return;
    label113:
    if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
    {
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(16777215);
      return;
    }
    if (!aqfo.isFlyme())
    {
      localSystemBarCompact.setStatusBarColor(14408667);
      return;
    }
    localSystemBarCompact.setStatusBarColor(16777215);
    localSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    FragmentActivity localFragmentActivity = getActivity();
    localFragmentActivity.getWindow().addFlags(256);
    localFragmentActivity.getWindow().addFlags(512);
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.Cu = ((ImageView)this.mContentView.findViewById(2131365759));
    this.mImageView = ((ImageView)this.mContentView.findViewById(2131364318));
    this.Pd = ((TextView)this.mContentView.findViewById(2131365781));
    this.mButton = ((Button)this.mContentView.findViewById(2131363996));
    this.mButton.setOnClickListener(this);
    this.mContentView.findViewById(2131365486).setOnClickListener(this);
    this.Cu.setImageDrawable(D(null));
    getActivity().app.addObserver(this.g);
    hideTitleBar();
    paramLayoutInflater = this.mContentView.findViewById(2131365789).getLayoutParams();
    int i = awdo.a(getActivity(), getActivity());
    if (i > paramLayoutInflater.height)
    {
      paramLayoutInflater.height = i;
      this.mItemId = localFragmentActivity.getIntent().getIntExtra("cover_id_key", 0);
      this.brx = localFragmentActivity.getIntent().getIntExtra("cover_button_key", 0);
      if (this.brx != 0) {
        break label399;
      }
      this.mButton.setBackgroundResource(2130851044);
      this.mButton.setTextColor(-8947849);
      this.mButton.setText(2131697051);
    }
    for (;;)
    {
      paramLayoutInflater = ((aqrc)localFragmentActivity.app.getManager(235)).b;
      if ((paramLayoutInflater != null) && (this.mItemId > 0))
      {
        this.a = paramLayoutInflater.a(this.mItemId, false);
        if (this.a == null) {
          break label470;
        }
        if (!TextUtils.isEmpty(this.a.name)) {
          this.Pd.setText(this.a.name);
        }
        if (!TextUtils.isEmpty(this.a.bVo)) {
          this.mImageView.getViewTreeObserver().addOnGlobalLayoutListener(new alau(this));
        }
      }
      return;
      i = aqnl.getStatusBarHeight(getActivity());
      if (i <= paramLayoutInflater.height) {
        break;
      }
      paramLayoutInflater.height = i;
      break;
      label399:
      if (this.brx == 2)
      {
        this.mButton.setBackgroundResource(2130851044);
        this.mButton.setTextColor(-8947849);
        this.mButton.setText(2131719633);
      }
      else
      {
        this.mButton.setBackgroundResource(2130851071);
        this.mButton.setTextColor(-16777216);
        this.mButton.setText(2131697051);
      }
    }
    label470:
    QLog.e("Q.profilecard.FrdProfileCard.CoverDetailFragment", 0, "item is null");
  }
  
  public int getContentLayoutId()
  {
    return 2131562207;
  }
  
  public boolean isTransparent()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (getActivity() != null)
      {
        getActivity().finish();
        continue;
        if (this.brx == 1)
        {
          if ((getActivity() != null) && (getActivity().app != null) && (this.mItemId > 0))
          {
            QQAppInterface localQQAppInterface = getActivity().app;
            ((acle)localQQAppInterface.getBusinessHandler(13)).JQ(this.mItemId);
            VasWebviewUtil.reportCommercialDrainage(localQQAppInterface.getCurrentAccountUin(), "defaultcard", "set_defaultcard", "", 1, 0, 0, "", Integer.toString(this.mItemId), "");
            this.mButton.setBackgroundResource(2130851044);
            this.mButton.setTextColor(-8947849);
            this.mButton.setText(acfp.m(2131704513));
            this.brx = 3;
          }
        }
        else if ((this.brx == 0) && (getActivity() != null)) {
          QQToast.a(getActivity(), 0, 2131691283, 0).show();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (getActivity().app != null) {
      getActivity().app.removeObserver(this.g);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    dEI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CoverDetailFragment
 * JD-Core Version:    0.7.0.1
 */