package com.tencent.mobileqq.ar.view;

import adgw;
import adkt;
import adkt.a;
import adkt.c;
import adkx;
import adky;
import adly;
import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARGLSurfaceView;
import com.tencent.mobileqq.ar.ARGLSurfaceView.b;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

@TargetApi(14)
public abstract class ScanGLRenderBaseFragment
  extends ReportV4Fragment
  implements adkt.a, adkt.c, adly, ARGLSurfaceView.b
{
  protected adkt b;
  protected ARGLSurfaceView b;
  protected adkx c;
  private SurfaceTexture c;
  protected int cIN;
  int cIO = 0;
  protected int mSurfaceHeight;
  protected boolean mSurfaceReady;
  protected int mSurfaceWidth;
  
  public ScanGLRenderBaseFragment()
  {
    this.jdField_c_of_type_Adkx = new adky();
  }
  
  private void Lp(int paramInt)
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "OpenCamera mCameraOpend:" + this.jdField_b_of_type_Adkt.tT());
    this.jdField_b_of_type_Adkt.Le(paramInt);
  }
  
  private void cTt()
  {
    Lp(this.cIO);
    cTu();
  }
  
  private void cTu()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "startCameraPreview mSurfaceReady:" + this.mSurfaceReady + ";sCameraProxy.isCameraOpened()=" + this.jdField_b_of_type_Adkt.tT());
    if (this.mSurfaceReady) {
      this.jdField_b_of_type_Adkt.b(this.jdField_c_of_type_AndroidGraphicsSurfaceTexture);
    }
  }
  
  private void closeCamera()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "closeCamera");
    this.jdField_b_of_type_Adkt.closeCamera();
  }
  
  public void b(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onSurfaceChange");
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
    this.mSurfaceReady = true;
    cTt();
  }
  
  public adkx c()
  {
    return this.jdField_c_of_type_Adkx;
  }
  
  public void cPz()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onEglContextDestory");
    this.mSurfaceReady = false;
    closeCamera();
    if (this.jdField_c_of_type_Adkx != null) {
      this.jdField_c_of_type_Adkx.stop();
    }
  }
  
  public void cSj()
  {
    if (this.jdField_c_of_type_Adkx != null)
    {
      int i = this.jdField_b_of_type_Adkt.fk();
      int j = this.jdField_b_of_type_Adkt.fl();
      this.jdField_c_of_type_Adkx.a(this.cIN, this.jdField_c_of_type_AndroidGraphicsSurfaceTexture, i, j, this.mSurfaceWidth, this.mSurfaceHeight);
      QLog.i("AREngine_ScanGLRenderFragment", 1, "onStartPreviewSuccess imageWidth:" + i + ",imageHeight:" + j + ",");
    }
  }
  
  public void d(GL10 paramGL10)
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onSurfaceCreate");
    this.mSurfaceReady = false;
    this.cIN = GlUtil.createTexture(36197);
    this.jdField_c_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.cIN);
  }
  
  public void hz(int paramInt1, int paramInt2)
  {
    int i = 0;
    paramInt2 = 1;
    QLog.i("AREngine_ScanGLRenderFragment", 1, "Camera operation success stage:" + paramInt1);
    paramInt1 = i;
    if (isResumed())
    {
      if ((this.cIO == 1) || (Camera.getNumberOfCameras() <= 1)) {
        break label94;
      }
      paramInt1 = adgw.gP(1);
      if (paramInt1 != 1) {
        break label104;
      }
      this.cIO = paramInt1;
      cTt();
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        ThreadManager.getUIHandler().post(new ScanGLRenderBaseFragment.1(this));
      }
      return;
      label94:
      this.cIO = 0;
      paramInt1 = i;
      continue;
      label104:
      paramInt1 = 0;
    }
  }
  
  public boolean l(byte[] paramArrayOfByte)
  {
    this.jdField_c_of_type_Adkx.iP(this.jdField_c_of_type_Adkx.fq() + 1L);
    this.jdField_c_of_type_Adkx.iQ(this.jdField_c_of_type_Adkx.fq());
    if (this.jdField_b_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
      this.jdField_b_of_type_ComTencentMobileqqArARGLSurfaceView.requestRender();
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ScanGLRenderFragment", 2, "onCreate  this=" + this);
    }
    super.onCreate(paramBundle);
    this.jdField_b_of_type_Adkt = adkt.a();
    this.jdField_b_of_type_Adkt.a(this);
    this.jdField_b_of_type_Adkt.a(this);
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_ScanGLRenderFragment", 2, String.format("onCreate time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = new ARGLSurfaceView(getActivity(), null, null);
    paramLayoutInflater.setOnEglContextDestoryListener(this);
    if (paramLayoutInflater != null)
    {
      paramViewGroup = paramLayoutInflater.getParent();
      if (paramViewGroup != null)
      {
        QLog.d("AREngine_ScanGLRenderFragment", 1, String.format("onCreateView glSurfaceView has a parent? viewParent=%s", new Object[] { paramViewGroup }));
        if ((paramViewGroup instanceof ViewGroup)) {
          ((ViewGroup)paramViewGroup).removeView(paramLayoutInflater);
        }
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqArARGLSurfaceView = paramLayoutInflater;
    this.jdField_c_of_type_Adkx.a(this.jdField_b_of_type_ComTencentMobileqqArARGLSurfaceView, getActivity());
    this.jdField_c_of_type_Adkx.a(this);
    this.jdField_b_of_type_ComTencentMobileqqArARGLSurfaceView.setRenderer(this.jdField_c_of_type_Adkx);
    this.jdField_b_of_type_ComTencentMobileqqArARGLSurfaceView.setRenderMode(0);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  @TargetApi(18)
  public void onDestroy()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onDestroy start.  this=" + this);
    if (this.jdField_c_of_type_Adkx != null) {
      this.jdField_c_of_type_Adkx.uninit();
    }
    this.jdField_b_of_type_Adkt.b(this);
    this.jdField_b_of_type_Adkt.doDestroy();
    super.onDestroy();
  }
  
  public void onPause()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onPause");
    if (this.jdField_b_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
      this.jdField_b_of_type_ComTencentMobileqqArARGLSurfaceView.onPause();
    }
    closeCamera();
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onResume");
    super.onResume();
    if (this.jdField_b_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
      this.jdField_b_of_type_ComTencentMobileqqArARGLSurfaceView.onResume();
    }
    cTt();
  }
  
  public void onStart()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onStart");
    super.onStart();
    if (this.jdField_c_of_type_Adkx != null) {
      this.jdField_c_of_type_Adkx.start();
    }
  }
  
  public void onStop()
  {
    QLog.i("AREngine_ScanGLRenderFragment", 1, "onStop");
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanGLRenderBaseFragment
 * JD-Core Version:    0.7.0.1
 */