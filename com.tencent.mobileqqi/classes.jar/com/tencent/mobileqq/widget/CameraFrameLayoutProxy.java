package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.CameraUtil;
import com.tencent.qphone.base.util.QLog;
import hfo;
import hfp;
import hft;
import hfu;

public class CameraFrameLayoutProxy
{
  public static final String a = "CameraFrameLayoutProxy";
  private int jdField_a_of_type_Int = 2131231211;
  private Context jdField_a_of_type_AndroidContentContext;
  private SharedPreferences.OnSharedPreferenceChangeListener jdField_a_of_type_AndroidContentSharedPreferences$OnSharedPreferenceChangeListener = new hfo(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy$OnDoubleClick);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private CameraFrameLayout jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout;
  private CameraFrameLayoutProxy.OnDoubleClick jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy$OnDoubleClick = new hfp(this);
  public boolean a;
  private int b;
  public boolean b;
  
  public CameraFrameLayoutProxy(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).registerOnSharedPreferenceChangeListener(this.jdField_a_of_type_AndroidContentSharedPreferences$OnSharedPreferenceChangeListener);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraFrameLayoutProxy", 2, "openRealtimeBg");
    }
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidViewViewGroup == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout = new CameraFrameLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewViewGroup);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout.setLayoutParams(localLayoutParams);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout.getParent() == null) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout, 0);
    }
    if (this.jdField_b_of_type_Int != 0)
    {
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout.getLayoutParams()).addRule(3, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout.setCloseBtnBlewViewResId(this.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout.e();
    this.jdField_b_of_type_Boolean = true;
    ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).setRequestedOrientation(1);
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraFrameLayoutProxy", 2, "closeRealtimeBg");
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout.a(false);
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout);
    }
    ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).setRequestedOrientation(-1);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a()
  {
    if (CameraUtil.a((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime())) {
      new Handler().postDelayed(new hft(this), 1000L);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout.setCloseBtnBlewViewResId(paramInt);
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraFrameLayoutProxy", 2, "list width:" + paramView.getWidth() + " list height:" + paramView.getHeight() + " x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
    }
    float f = paramMotionEvent.getY();
    int i = AIOUtils.a(20.0F, paramView.getResources());
    if ((f > i) && (f < paramView.getHeight() - i))
    {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      if (QLog.isColorLevel()) {
        QLog.d("CameraFrameLayoutProxy", 2, "onTouchEvent");
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraFrameLayoutProxy", 2, "onResume");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout.c();
    }
    this.jdField_a_of_type_Boolean = true;
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime();
    if ((CameraUtil.a(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext)) && (CameraUtil.a(localQQAppInterface)) && (CameraUtil.b(localQQAppInterface))) {
      new Handler().postDelayed(new hfu(this), 1500L);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout.a();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout.b();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayout.d();
    }
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).unregisterOnSharedPreferenceChangeListener(this.jdField_a_of_type_AndroidContentSharedPreferences$OnSharedPreferenceChangeListener);
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CameraFrameLayoutProxy
 * JD-Core Version:    0.7.0.1
 */