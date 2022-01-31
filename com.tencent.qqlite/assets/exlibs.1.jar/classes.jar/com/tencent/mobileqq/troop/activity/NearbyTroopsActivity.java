package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import ehz;
import eia;
import eib;
import eic;
import eid;
import eie;
import java.util.ArrayList;
import java.util.Iterator;

public class NearbyTroopsActivity
  extends QQBrowserActivity
  implements Handler.Callback, View.OnTouchListener
{
  public static final int B = -1;
  public static final int C = 0;
  public static final int D = 1;
  public static final int E = 2;
  public static final int F = 3;
  public static final int G = 4;
  public static final int H = 5;
  public static final int a = 886;
  public static final String a = "TAB_INDEX";
  public static final boolean a = true;
  public static final String b = "NearbyTroopsActivity";
  public static final int c = 1229;
  public static final int d = 1339;
  public static final int e = -1;
  public static final String e = "886.100170";
  public static final int f = 0;
  public static final String f = "886.100171";
  public static final String g = "886.100172";
  public int I = -1;
  public Context a;
  public Drawable a;
  protected View.OnClickListener a;
  protected TextView a;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private NearbyTroopsBaseView.INearbyTroopContext jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext;
  private NearbyTroopsBaseView jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView = null;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public String[] a;
  public int b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new eid(this);
  protected TextView b;
  public BrowserAppInterface b;
  private NearbyTroopsBaseView jdField_b_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView = null;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet;
  boolean jdField_b_of_type_Boolean = false;
  protected String[] b;
  private FrameLayout jdField_c_of_type_AndroidWidgetFrameLayout;
  public String c;
  boolean jdField_c_of_type_Boolean = false;
  public String d;
  boolean d;
  protected ImageView f;
  
  public NearbyTroopsActivity()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_b_of_type_ComTencentMobileqqAppBrowserAppInterface = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { "886.100170", "886.100171", "886.100172" };
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ehz(this);
  }
  
  private NearbyTroopsBaseView a(int paramInt)
  {
    if (paramInt == -1) {
      localObject = null;
    }
    NearbyTroopsBaseView localNearbyTroopsBaseView;
    do
    {
      return localObject;
      localNearbyTroopsBaseView = (NearbyTroopsBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      localObject = localNearbyTroopsBaseView;
    } while (localNearbyTroopsBaseView != null);
    Object localObject = new NearbyTroopsView(this);
    this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, localObject);
    ((NearbyTroopsBaseView)localObject).a(getIntent(), this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext);
    return localObject;
  }
  
  private void x()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext = new eic(this);
  }
  
  private void y()
  {
    this.p.setContentDescription(getString(2131362832));
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (isResume()) {
      QQToast.a(this, paramInt1, getResources().getString(paramInt2), 0).b(getTitleBarHeight());
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 8)
    {
      findViewById(2131297719).setVisibility(8);
      super.setTitle(paramCharSequence);
      return;
    }
    this.h.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetAbsoluteLayout.getLayoutParams();
    if (localLayoutParams == null) {
      return;
    }
    localLayoutParams.bottomMargin = 0;
    this.jdField_a_of_type_AndroidWidgetAbsoluteLayout.setLayoutParams(localLayoutParams);
  }
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    if (paramBoolean)
    {
      setContentView(2130903327);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
      this.p.setImageResource(2130838044);
      this.p.setVisibility(0);
      this.p.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131297596));
      y();
    }
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("mode", 0);
    label107:
    int i;
    if (this.jdField_b_of_type_Int == 1)
    {
      b(this.jdField_c_of_type_JavaLangString);
      i = paramIntent.getIntExtra("from", 0);
      if (i != 15) {
        break label230;
      }
      this.I = 3;
    }
    for (;;)
    {
      if ((paramBoolean) && (this.jdField_b_of_type_Int == 0)) {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_b_of_type_ArrayOfJavaLangString, new eia(this));
      }
      if ((!TextUtils.isEmpty(this.h.getText())) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 8)) {
        break;
      }
      this.h.setText(2131362829);
      return;
      String str = paramIntent.getStringExtra("config_res_plugin_item_name");
      if (!TextUtils.isEmpty(str))
      {
        b(str);
        break label107;
      }
      b(2131362829, -1);
      break label107;
      label230:
      if (i == 10) {
        this.I = 4;
      } else if (i == 11) {
        this.I = 5;
      }
    }
  }
  
  public boolean a(boolean paramBoolean, Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_b_of_type_Boolean = false;
    a(paramBoolean, paramIntent);
    d();
    paramIntent = Message.obtain();
    paramIntent.arg1 = 1;
    paramIntent.what = 1229;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(paramIntent, 200L);
    return true;
  }
  
  protected String a_()
  {
    if (this.jdField_b_of_type_Boolean) {
      return getString(2131362938);
    }
    return super.a_();
  }
  
  protected void b()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView == null) {
      return;
    }
    super.b();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if (paramInt2 == -1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localLayoutParams.topMargin = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      if (paramInt1 != -1) {
        setTitle(paramInt1);
      }
      return;
      localLayoutParams.topMargin = Utils.a(BaseApplication.getContext(), 6.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt2);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void b(Intent paramIntent, String paramString) {}
  
  public void b(CharSequence paramCharSequence)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    localLayoutParams.topMargin = 0;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    a(paramCharSequence);
  }
  
  public void b(String paramString1, String paramString2, String paramString3) {}
  
  public boolean b()
  {
    return false;
  }
  
  public void c(int paramInt)
  {
    NearbyTroopsBaseView localNearbyTroopsBaseView = a(paramInt);
    if (localNearbyTroopsBaseView == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView == localNearbyTroopsBaseView);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.e();
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView = localNearbyTroopsBaseView;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.c();
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.d();
        }
        this.jdField_c_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_c_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView);
      }
    } while (this.jdField_c_of_type_Boolean);
    this.jdField_b_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView = localNearbyTroopsBaseView;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1339);
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.f.getDrawable();
    }
    this.f.setVisibility(0);
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    return true;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if ((getAppRuntime() instanceof BrowserAppInterface)) {
      this.jdField_b_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)getAppRuntime());
    }
    if (this.app != null) {}
    for (paramBundle = this.app;; paramBundle = this.jdField_b_of_type_ComTencentMobileqqAppBrowserAppInterface)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramBundle;
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      }
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break;
      }
      finish();
      return true;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    paramBundle = getIntent();
    paramBundle.putExtra("url", "http://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&atvtype=city");
    paramBundle.putExtra("uin", this.L);
    paramBundle.putExtra("portraitOnly", true);
    paramBundle.putExtra("hide_more_button", true);
    paramBundle.putExtra("hide_operation_bar", true);
    paramBundle.putExtra("isShowAd", false);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    x();
    a(true, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      NearbyTroopsBaseView localNearbyTroopsBaseView = (NearbyTroopsBaseView)localIterator.next();
      if (localNearbyTroopsBaseView != null) {
        localNearbyTroopsBaseView.h();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView = null;
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(false, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.a(paramIntent);
    }
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.e();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.d();
    }
    super.doOnResume();
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.f();
    }
    super.doOnStop();
  }
  
  protected void e()
  {
    if (this.jdField_d_of_type_Boolean) {
      super.e();
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    this.f.setVisibility(8);
    return true;
  }
  
  public boolean f()
  {
    boolean bool = false;
    if (this.f.getVisibility() == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool;
    if (paramMessage.what == 1229) {
      if (paramMessage.arg1 == 0)
      {
        bool = true;
        runOnUiThread(new eib(this, bool));
      }
    }
    for (;;)
    {
      return true;
      bool = false;
      break;
      if (paramMessage.what == 1339)
      {
        if (!this.jdField_c_of_type_Boolean) {
          return true;
        }
      }
      else
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          NearbyTroopsBaseView localNearbyTroopsBaseView = (NearbyTroopsBaseView)localIterator.next();
          if (localNearbyTroopsBaseView != null) {
            localNearbyTroopsBaseView.a(paramMessage);
          }
        }
      }
    }
  }
  
  public void onClick(View paramView) {}
  
  protected void onRestart()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView.g();
    }
    super.onRestart();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setContentView(int paramInt)
  {
    if (this.jdField_d_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_c_of_type_Float = getResources().getDisplayMetrics().density;
      super.setContentViewC(paramInt);
      getWindow().setFeatureInt(7, 2130903328);
      ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130839291));
    } while (this.h != null);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131296894));
    setLayerType(this.jdField_b_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296895));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297720));
    this.j = ((TextView)findViewById(2131296905));
    this.p = ((ImageView)findViewById(2131296906));
    setLayerType(this.j);
    setLayerType(this.p);
    this.f = ((ImageView)findViewById(2131297721));
    this.h = ((TextView)findViewById(2131296901));
    this.h.setContentDescription(getString(2131364541));
    this.h.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    setLayerType(this.h);
  }
  
  public void setTitle(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 8)
    {
      findViewById(2131297719).setVisibility(8);
      super.setTitle(paramInt);
      return;
    }
    this.h.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence) {}
  
  public boolean showPreview()
  {
    return true;
  }
  
  public void u()
  {
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.c(getString(2131362838));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.c(getString(2131363771));
    }
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new eie(this));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void v()
  {
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_b_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "nearbygrp_list", "Clk_order", 0, 0, "3", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.NearbyTroopsActivity
 * JD-Core Version:    0.7.0.1
 */