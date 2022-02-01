package com.tencent.mobileqq.troop.createNewTroop;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import anot;
import aozb;
import aozc;
import aozd;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.mobileqq.widget.TabBarView2;
import com.tencent.widget.immersive.ImmersiveUtils;
import rpq;

public class NewTroopCreateActivity
  extends FragmentActivity
  implements TabBarView.a
{
  protected TextView Bi;
  protected TextView GS;
  protected ValueAnimator.AnimatorUpdateListener a;
  public AbsNewTroopBaseView a;
  protected int aXu;
  protected NewTroopCateView b;
  public TabBarView2 b;
  protected FrameLayout bZ;
  protected AnimatorListenerAdapter c;
  protected NewTroopContactView c;
  public boolean cPr;
  protected int cmq;
  protected int dSh;
  protected Intent mIntent;
  protected TextView mRightBtn;
  protected TextView mTitle;
  protected View mTitleBar;
  protected String mTitleString;
  
  public NewTroopCreateActivity()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new aozc(this);
    this.jdField_c_of_type_AndroidAnimationAnimatorListenerAdapter = new aozd(this);
  }
  
  private void a(AbsNewTroopBaseView paramAbsNewTroopBaseView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != paramAbsNewTroopBaseView)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.onPause();
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.onStop();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView = paramAbsNewTroopBaseView;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.onStart();
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.onResume();
        }
        this.bZ.removeAllViews();
        this.bZ.addView(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView);
      }
    }
  }
  
  private void cjM()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView2.setSelectedTab(this.dSh, false);
  }
  
  private void dXY()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView == null)
    {
      this.jdField_c_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView = new NewTroopContactView(this);
      this.jdField_c_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(this);
    }
    a(this.jdField_c_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView);
  }
  
  private void dXZ()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView = new NewTroopCateView(this);
      this.jdField_b_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(this);
    }
    a(this.jdField_b_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView);
    if (this.jdField_c_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView != null) {
      this.jdField_c_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.gR();
    }
    anot.a(this.app, "dc00899", "grp_create", "", "grp_create_bytype", "exp_grptype", 0, 0, "", "", "", "");
  }
  
  public void Rt(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator;
    if (paramBoolean)
    {
      localValueAnimator = ValueAnimator.ofInt(new int[] { -this.aXu, 0 }).setDuration(200L);
      localValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
      localValueAnimator.addListener(this.jdField_c_of_type_AndroidAnimationAnimatorListenerAdapter);
      localValueAnimator.start();
    }
    for (;;)
    {
      this.cPr = paramBoolean;
      return;
      localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -this.aXu }).setDuration(200L);
      localValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
      localValueAnimator.addListener(this.jdField_c_of_type_AndroidAnimationAnimatorListenerAdapter);
      localValueAnimator.start();
    }
  }
  
  protected void aC()
  {
    this.Bi.setVisibility(0);
    this.GS.setVisibility(8);
    this.mRightBtn.setVisibility(8);
    this.Bi.setText(2131719436);
    this.Bi.setBackgroundResource(0);
    this.Bi.setPadding(0, 0, 0, 0);
    this.mTitle.setText(this.mTitleString);
    if (AppSetting.enableTalkBack)
    {
      this.mTitle.setContentDescription(this.mTitleString);
      this.Bi.setContentDescription(getString(2131719436));
    }
    this.Bi.setOnClickListener(new aozb(this));
  }
  
  protected void cAb()
  {
    this.mIntent = getIntent();
    this.mTitleString = this.mIntent.getStringExtra("param_title");
    if (this.mTitleString == null) {
      this.mTitleString = getString(2131692294);
    }
    this.dSh = this.mIntent.getIntExtra("param_default_tab", 0);
    this.cmq = this.mIntent.getIntExtra("param_exit_animation", 0);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!this.cPr) {
      Rt(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131755343);
    super.doOnCreate(paramBundle);
    this.aXu = rpq.dip2px(this, 40.0F);
    cAb();
    initViews();
    aC();
    cjM();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView != null) {
      this.jdField_b_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.onDestroy();
    }
    if (this.jdField_c_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView != null) {
      this.jdField_c_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.onDestroy();
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.onPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.onResume();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.onStart();
    }
    getWindow().setSoftInputMode(16);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(48);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.onStop();
    }
  }
  
  public void finish()
  {
    super.finish();
    switch (this.cmq)
    {
    default: 
      overridePendingTransition(0, 2130771990);
    case 2: 
      return;
    case 1: 
      overridePendingTransition(2130772000, 2130772001);
      return;
    }
    overridePendingTransition(0, 0);
  }
  
  @TargetApi(14)
  protected void initViews()
  {
    super.setContentView(2131559706);
    View localView = findViewById(2131377546);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        localView.setFitsSystemWindows(true);
      }
      localView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.mTitleBar = findViewById(2131379791);
    this.mTitle = ((TextView)findViewById(2131369627));
    this.Bi = ((TextView)findViewById(2131369579));
    this.GS = ((TextView)findViewById(2131369581));
    this.mRightBtn = ((TextView)findViewById(2131369612));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView2 = ((TabBarView2)findViewById(2131380407));
    this.bZ = ((FrameLayout)findViewById(2131380408));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView2.a(0, getString(2131721438));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView2.b(0).setContentDescription(getString(2131721438));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView2.a(1, getString(2131721439));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView2.b(1).setContentDescription(getString(2131721439));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView2.setOnTabChangeListener(this);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.onBackEvent();
    }
    return super.onBackEvent();
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      dXY();
      return;
    }
    dXZ();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity
 * JD-Core Version:    0.7.0.1
 */