package com.tencent.mobileqq.widget;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.utils.CameraUtil;
import com.tencent.qphone.base.util.QLog;
import hfg;
import hfh;
import hfi;
import hfj;
import hfk;
import hfm;
import hfn;
import java.util.concurrent.Executor;

public class CameraFrameLayout
  extends FrameLayout
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "CameraFrameLayout";
  private static final int jdField_b_of_type_Int = 2;
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  private Handler jdField_a_of_type_AndroidOsHandler = new hfg(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private CameraPreview jdField_a_of_type_ComTencentMobileqqWidgetCameraPreview;
  private Runnable jdField_a_of_type_JavaLangRunnable = new hfk(this);
  Executor jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.a();
  boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 2131231211;
  private boolean jdField_c_of_type_Boolean = false;
  
  public CameraFrameLayout(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext);
    this.b = true;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqWidgetCameraPreview = new CameraPreview(paramContext, null);
    paramContext = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetCameraPreview.getLayoutParams();
    if (paramContext == null) {
      paramContext = new FrameLayout.LayoutParams(0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraPreview.setLayoutParams(paramContext);
      addView(this.jdField_a_of_type_ComTencentMobileqqWidgetCameraPreview);
      return;
      paramContext.width = 0;
      paramContext.height = 0;
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 0)
    {
      this.b = true;
      QQToast.a(getContext(), 0, getContext().getString(2131562094), 0).b(((BaseActivity)getContext()).d());
      setDoubleClickFlag(false);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWidgetCameraPreview.a(false);
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera == null)
      {
        setDoubleClickFlag(false);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCameraPreview.setCamera(this.jdField_a_of_type_AndroidHardwareCamera);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCameraPreview.b();
    setVisibility(0);
    if (this.jdField_c_of_type_Boolean)
    {
      QQToast.a(getContext(), 0, getContext().getString(2131561739), 0).b(((BaseActivity)getContext()).d());
      setDoubleClickFlag(false);
      postDelayed(new hfm(this), 2000L);
    }
    for (paramInt = 4500;; paramInt = 0)
    {
      postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt);
      g();
      return;
    }
  }
  
  private void f()
  {
    this.b = true;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraPreview != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraPreview.a(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraPreview.setCamera(null);
    }
    setVisibility(4);
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_AndroidWidgetImageView = null;
    }
    g();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ChatXListView localChatXListView = (ChatXListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131231199);
      if (localChatXListView != null) {
        localChatXListView.n();
      }
    }
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    this.b = false;
    this.jdField_a_of_type_Boolean = false;
    if (paramBoolean) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_a_of_type_AndroidHardwareCamera != null)
        {
          CameraUtil.a(this.jdField_a_of_type_AndroidHardwareCamera);
          this.jdField_a_of_type_AndroidHardwareCamera = null;
        }
        f();
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("CameraFrameLayout", 2, "closeRealtimeBg cost time:" + (l2 - l1));
        }
        return;
      }
      ??? = new hfn(this);
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)???);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b()
  {
    a(true);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c() {}
  
  public void d()
  {
    hfi localhfi = new hfi(this);
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(localhfi);
  }
  
  public void e()
  {
    this.b = false;
    hfj localhfj = new hfj(this);
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(localhfj);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    new Handler().post(new hfh(this));
  }
  
  public void setCloseBtnBlewViewResId(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(3, paramInt);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setDoubleClickFlag(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CameraFrameLayout
 * JD-Core Version:    0.7.0.1
 */