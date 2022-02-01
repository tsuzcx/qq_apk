package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.NearHornHandler;
import com.tencent.mobileqq.app.NearHornObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.HornAnimationView;
import com.tencent.mobileqq.widget.HornAnimationView.OnHornItemClickObserver;
import com.tencent.widget.AbsListView.LayoutParams;
import cxd;
import cxe;
import cxf;
import cxg;
import cxh;
import cxi;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class NearPeopleActivity
  extends PeopleAroundBaseActivity
{
  public static String a;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 4;
  public static int f;
  public static int g;
  private float jdField_a_of_type_Float;
  public Context a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new cxf(this);
  private NearHornHandler jdField_a_of_type_ComTencentMobileqqAppNearHornHandler;
  NearHornObserver jdField_a_of_type_ComTencentMobileqqAppNearHornObserver = new cxh(this);
  HornAnimationView.OnHornItemClickObserver jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView$OnHornItemClickObserver = new cxg(this);
  public HornAnimationView a;
  public Boolean a;
  private ScheduledExecutorService jdField_a_of_type_JavaUtilConcurrentScheduledExecutorService;
  private ScheduledFuture jdField_a_of_type_JavaUtilConcurrentScheduledFuture;
  public String b;
  private List c;
  private String e = "";
  private String f;
  private String g;
  
  static
  {
    jdField_f_of_type_Int = 0;
    jdField_g_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "source";
  }
  
  public NearPeopleActivity()
  {
    this.jdField_f_of_type_JavaLangString = "178";
    this.jdField_g_of_type_JavaLangString = ("http://imgcache.qq.com/club/roam/html/index.html?_bid=" + this.jdField_f_of_type_JavaLangString + "&pvsrc=nearby&uin=%1$s&_wv=5123");
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    super.OnClick(paramView, paramInt);
    switch (((Integer)((Pair)this.jdField_b_of_type_JavaUtilList.get(paramInt)).first).intValue())
    {
    default: 
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
    if (VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    for (paramView = "1";; paramView = "0")
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Svip", "", "Vip_nearby", "Vip_nearby_enterHornCreate", 0, 0, "isSvip", paramView, "", "");
      startActivityForResult(new Intent(this, HornPublishActivity.class), 0);
      return;
    }
  }
  
  protected void a(List paramList)
  {
    super.a(paramList);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if ((NetworkUtil.e(this)) && (paramBoolean2)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new cxi(this));
    }
  }
  
  protected View b()
  {
    this.y = w;
    a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler = ((NearHornHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(31));
    this.c = this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.a;
    if (NetworkUtil.e(this)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new cxe(this));
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    }
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  protected String c()
  {
    return "filter_type_near_people";
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.a != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.a.isEmpty())) {
      e();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131233341));
    this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    this.jdField_g_of_type_JavaLangString = String.format(this.jdField_g_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString });
    new Handler().postDelayed(new cxd(this), 2000L);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView.c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler = null;
    this.c = null;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.d.booleanValue()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView != null))
    {
      if (this.c.size() <= 0) {
        break label82;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView.b(this.c);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.d = Boolean.valueOf(false);
      a(this.jdField_a_of_type_ComTencentMobileqqAppNearHornObserver);
      return;
      label82:
      this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView.c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView = null;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    b(this.jdField_a_of_type_ComTencentMobileqqAppNearHornObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView.b();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView = new HornAnimationView(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.c, this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView$OnHornItemClickObserver);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.a(74.0F, getResources()));
      localLayoutParams.topMargin = 0;
      localLayoutParams.bottomMargin = 0;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView, localLayoutParams);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView.b(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearPeopleActivity
 * JD-Core Version:    0.7.0.1
 */