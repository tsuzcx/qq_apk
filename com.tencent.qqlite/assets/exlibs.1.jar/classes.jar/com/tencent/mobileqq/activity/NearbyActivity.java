package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import awk;
import awl;
import awm;
import awn;
import awo;
import awp;
import awq;
import awr;
import aws;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.NearbyFrame;
import com.tencent.mobileqq.app.NearbyFrame.OnNearbyCallBack;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;
import mqq.app.Constants.LogoutReason;

public class NearbyActivity
  extends FrameActivity
  implements View.OnClickListener, NearbyFrame.OnNearbyCallBack, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener
{
  public static final int a = 1;
  public static final String a = "nearby_people_disclaimer_ok";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "发现" };
  public static final int b = 0;
  public static final String b = "nearby_people_profile_ok_new";
  public static final int c = -1;
  public static final String c = "nearby_people_skip_guide";
  public static final int d = -1;
  public static final String d = "is_skip_nearby_guide";
  public static final int e = 0;
  private static final String e = "NearbyActivity";
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 1001;
  public static final int i = 2001;
  public static final int j = 2002;
  public static final int k = 0;
  public static final int l = 0;
  public static final int m = 1;
  public static final int n = 2;
  private static final int o = 2;
  private static final int q = 1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new awm(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aws jdField_a_of_type_Aws;
  private ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  private LBSHandler jdField_a_of_type_ComTencentMobileqqAppLBSHandler;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private int[] jdField_a_of_type_ArrayOfInt;
  private long[] jdField_a_of_type_ArrayOfLong;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private boolean[] jdField_a_of_type_ArrayOfBoolean = { 0, 0 };
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private int p;
  
  public static int a(Activity paramActivity)
  {
    int i1 = -1;
    if (paramActivity != null) {}
    try
    {
      i1 = paramActivity.getIntent().getIntExtra("FROM_WHERE", -1);
      return i1;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return -1;
  }
  
  private View a(int paramInt)
  {
    View localView = getLayoutInflater().inflate(2130903519, null);
    ((TextView)localView.findViewById(2131298352)).setText(jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
    return localView;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.a(this, paramInt1, getResources().getString(paramInt2), 0).b((int)getResources().getDimension(2131492887));
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong)
  {
    if (paramInt1 == this.jdField_a_of_type_ArrayOfAndroidViewView.length - 2) {}
    for (boolean bool = true;; bool = false)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_ArrayOfInt[paramInt1], this.jdField_a_of_type_ArrayOfInt[paramInt1] - paramInt2);
      localTranslateAnimation.setAnimationListener(new awo(this, bool, paramInt1, paramInt2, paramLong));
      localTranslateAnimation.setDuration(paramLong);
      if (!bool) {
        localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      }
      localTranslateAnimation.setFillAfter(true);
      this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1].startAnimation(localTranslateAnimation);
      return;
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, NearbyActivity.class);
    localIntent.putExtra("TAB_INDEX", paramInt1);
    localIntent.putExtra("FROM_WHERE", paramInt2);
    paramContext.startActivity(localIntent);
  }
  
  private int b()
  {
    int i1 = getIntent().getIntExtra("TAB_INDEX", 0);
    getIntent().getIntExtra("FROM_WHERE", -1);
    return i1;
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfAndroidViewView == null) || (paramInt >= this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {
      return;
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_ArrayOfInt[paramInt]);
    localAnimationSet.addAnimation(new AlphaAnimation(0.0F, 1.0F));
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setAnimationListener(new awn(this, paramInt));
    localAnimationSet.setDuration(this.jdField_a_of_type_ArrayOfLong[paramInt]);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt].startAnimation(localAnimationSet);
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong)
  {
    int i1;
    TranslateAnimation localTranslateAnimation;
    if (paramInt1 == this.jdField_a_of_type_ArrayOfAndroidViewView.length - 2)
    {
      i1 = 1;
      localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_ArrayOfInt[paramInt1] - paramInt2, this.jdField_a_of_type_ArrayOfInt[paramInt1]);
      localTranslateAnimation.setDuration(paramLong);
      localTranslateAnimation.setFillAfter(true);
      if (i1 == 0) {
        break label90;
      }
      localTranslateAnimation.setAnimationListener(new awp(this, paramInt1));
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1].startAnimation(localTranslateAnimation);
      return;
      i1 = 0;
      break;
      label90:
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      localTranslateAnimation.setAnimationListener(new awq(this, paramInt1));
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296895));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296901));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296906));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296905));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363566);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131363566);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838044);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a(0, NearbyPeopleListFrame.class, null);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("我的资料及清除位置等功能");
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      c();
      return;
    }
    d();
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
      paramView = a();
      if ((paramView instanceof NearbyPeopleListFrame))
      {
        ((NearbyPeopleListFrame)paramView).m();
        continue;
        paramView = new ProfileActivity.AllInOne(this.app.a(), 0);
        Intent localIntent = new Intent(this, NearbyPeopleProfileActivity.class);
        localIntent.putExtra("param_mode", 2);
        localIntent.putExtra("AllInOne", paramView);
        startActivityForResult(localIntent, 1000);
        continue;
        a(new awr(this));
      }
    }
  }
  
  protected void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 2131363200, 2131363201, 2131362790, 2131363208, new awk(this), new awl(this, paramRunnable));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  protected boolean a()
  {
    if ((this.jdField_a_of_type_ArrayOfBoolean[0] != 0) && (this.jdField_a_of_type_ArrayOfBoolean[1] == 0)) {
      ReportController.b(this.app, "CliOper", "", "", "0X8004A15", "0X8004A15", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return super.a();
      if (this.jdField_a_of_type_ArrayOfBoolean[1] != 0) {
        ReportController.b(this.app, "CliOper", "", "", "0X8004A19", "0X8004A19", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected void c()
  {
    a();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131364488);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131363872);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131364489);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131362790);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  protected boolean c()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      if (this.jdField_b_of_type_Boolean) {
        break label25;
      }
      this.jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      bool = true;
      return bool;
      label25:
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837914);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
      this.p = this.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawablePadding();
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public void d()
  {
    super.d();
    Frame localFrame = a();
    if (localFrame != null) {
      localFrame.l();
    }
  }
  
  protected boolean d()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_c_of_type_Boolean = false;
      }
      for (;;)
      {
        return true;
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.p);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      }
    }
    return false;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903513);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(49));
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = ((LBSHandler)this.app.a(3));
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131297297));
    }
    f();
    this.jdField_a_of_type_JavaUtilList = a();
    this.jdField_a_of_type_Aws = new aws(this, null);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_Aws);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
    paramBundle = (NearbyFrame)a();
    if (paramBundle != null) {
      paramBundle.b();
    }
    if ((getIntent() != null) && (getIntent().getBooleanExtra("is_skip_nearby_guide", false))) {}
    Leba.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_b_of_type_Boolean) {
      getSharedPreferences(this.app.a(), 0).edit().putLong("nearby_enter_time", System.currentTimeMillis()).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Boolean) {
      ReportController.a(this.app, "CliOper", "", "", "0X8004445", "0X8004445", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296901: 
      if ((this.jdField_a_of_type_ArrayOfBoolean[0] != 0) && (this.jdField_a_of_type_ArrayOfBoolean[1] == 0)) {
        ReportController.b(this.app, "CliOper", "", "", "0X8004A15", "0X8004A15", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        finish();
        return;
        if (this.jdField_a_of_type_ArrayOfBoolean[1] != 0) {
          ReportController.b(this.app, "CliOper", "", "", "0X8004A19", "0X8004A19", 0, 0, "", "", "", "");
        }
      }
    }
    c();
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    super.onLogout(paramLogoutReason);
    finish();
  }
  
  public void onTabChanged(String paramString)
  {
    super.onTabChanged(paramString);
    if ((NearbyFrame)a() == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity
 * JD-Core Version:    0.7.0.1
 */