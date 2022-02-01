package com.tencent.mobileqq.activity.richmedia.view;

import aasx;
import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import anir;
import anjd;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicReference;

public class FSurfaceViewLayout
  extends FrameLayout
{
  public GLSurfaceView a;
  public boolean bAj;
  public boolean bAk;
  public boolean bAl;
  public boolean bzf;
  private volatile boolean hX;
  
  public FSurfaceViewLayout(Context paramContext)
  {
    super(paramContext);
    initData();
  }
  
  public FSurfaceViewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    initData();
  }
  
  private void initData()
  {
    this.bAj = true;
    this.bAk = false;
    this.bzf = false;
    this.bAl = false;
    this.hX = false;
  }
  
  public void Dh(boolean paramBoolean)
  {
    if ((this.bzf) && (this.a != null) && ((this.a instanceof CameraFilterGLView))) {
      ((CameraFilterGLView)this.a).Dg(paramBoolean);
    }
  }
  
  public boolean Xt()
  {
    if ((this.bzf) && (this.a != null)) {
      return ((CameraFilterGLView)this.a).Xr();
    }
    return false;
  }
  
  public boolean Xu()
  {
    if ((this.bzf) && (this.a != null) && ((this.a instanceof CameraFilterGLView))) {
      return ((CameraFilterGLView)this.a).jdField_a_of_type_Anjd.mNeedDoFaceDetect;
    }
    return true;
  }
  
  public boolean Xv()
  {
    if ((this.bzf) && (this.a != null) && ((this.a instanceof CameraFilterGLView))) {
      return ((CameraFilterGLView)this.a).jdField_a_of_type_Anjd.mNeedDoGestureDetect;
    }
    return true;
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if ((this.bzf) && (this.a != null)) {
      ((CameraFilterGLView)this.a).jdField_a_of_type_Anjd.e(paramBoolean, paramFloat1);
    }
  }
  
  public boolean a(Context paramContext, CameraFilterGLView.a parama, PreviewContext paramPreviewContext)
  {
    if (!this.bAl)
    {
      this.a = null;
      return false;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, localDisplayMetrics.heightPixels);
    localLayoutParams.height = localDisplayMetrics.heightPixels;
    localLayoutParams.width = localDisplayMetrics.widthPixels;
    localLayoutParams.gravity = 49;
    if (QLog.isColorLevel()) {
      QLog.d("face", 2, "initSurfaceView needChangeNewSurfaceView=" + this.bAj);
    }
    if (this.bAj)
    {
      super.setVisibility(8);
      if (!this.bzf) {
        break label241;
      }
      if (this.bAj)
      {
        super.removeAllViews();
        if ((this.a != null) && ((this.a instanceof CameraFilterGLView))) {
          ((CameraFilterGLView)this.a).cyV();
        }
        this.a = null;
      }
      if (this.a == null)
      {
        this.a = new CameraFilterGLView(paramContext, null);
        this.a.setVisibility(8);
        this.a.setId(2131367273);
      }
      paramContext = (CameraFilterGLView)this.a;
      paramContext.setFilterListener(parama);
      paramContext.setVideoContext(paramPreviewContext);
      paramContext.cyO();
      this.a.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      return true;
      super.setVisibility(0);
      break;
      label241:
      if (this.bAj)
      {
        super.removeAllViews();
        this.a = null;
      }
      if (this.a == null)
      {
        this.a = new CameraGLSurfaceView(paramContext);
        this.a.setId(2131367282);
        this.a.setVisibility(8);
      }
      paramContext = (CameraGLSurfaceView)this.a;
      paramContext.setVideoContext(paramPreviewContext);
      paramContext.createMsgThread();
      this.a.setLayoutParams(localLayoutParams);
    }
  }
  
  public void bo(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.hX)
    {
      this.bAk = VideoEnvironment.isBeautySupported();
      if ((!VideoEnvironment.awR()) || (!paramBoolean1)) {
        break label122;
      }
      paramBoolean1 = true;
      this.bzf = paramBoolean1;
      if (((!this.bAk) && (!this.bzf)) || (!paramBoolean2)) {
        break label127;
      }
    }
    label122:
    label127:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.bAl = paramBoolean1;
      this.hX = true;
      if (QLog.isColorLevel()) {
        QLog.d("face", 2, "initEnvVar isSurpportFilter=" + this.bzf + ",needOpenglView=" + this.bAl);
      }
      if (!this.bzf) {
        break label132;
      }
      PtvFilterUtils.Qh(true);
      CameraFilterGLView.cyM();
      return;
      paramBoolean1 = false;
      break;
    }
    label132:
    PtvFilterUtils.Qh(false);
  }
  
  public void cyS()
  {
    if ((this.bzf) && (this.a != null)) {
      ((CameraFilterGLView)this.a).cyS();
    }
  }
  
  public void cze()
  {
    if ((this.bAj) && (this.a != null)) {
      super.addView(this.a);
    }
  }
  
  public void czf()
  {
    if ((this.bzf) && (this.a != null)) {
      ((CameraFilterGLView)this.a).jdField_a_of_type_Anir.dQw();
    }
  }
  
  public void czg()
  {
    if ((this.bzf) && (this.a != null) && ((this.a instanceof CameraFilterGLView))) {
      ((CameraFilterGLView)this.a).cyU();
    }
  }
  
  public void onDestroy()
  {
    if ((this.bzf) && (this.a != null))
    {
      ((CameraFilterGLView)this.a).cyY();
      ((CameraFilterGLView)this.a).cyZ();
    }
  }
  
  public void onPause()
  {
    if (this.a != null) {
      this.a.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.a != null) {
      this.a.onResume();
    }
  }
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    if ((this.bzf) && (this.a != null) && ((this.a instanceof CameraFilterGLView))) {
      ((CameraFilterGLView)this.a).mAppInterface = paramAppInterface;
    }
  }
  
  public void setEnableBeauty(boolean paramBoolean)
  {
    if ((this.bzf) && (this.a != null)) {
      ((CameraFilterGLView)this.a).setEnableBeauty(paramBoolean);
    }
  }
  
  public void setHwEncoder(SVHwEncoder paramSVHwEncoder)
  {
    if ((this.bzf) && (this.a != null)) {
      ((CameraFilterGLView)this.a).mEncodeRef.getAndSet(paramSVHwEncoder);
    }
  }
  
  public void setNeedWrite(boolean paramBoolean)
  {
    if ((this.bzf) && (this.a != null)) {
      ((CameraFilterGLView)this.a).setNeedWrite(paramBoolean);
    }
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2, aasx paramaasx)
  {
    if (this.a == null) {
      return;
    }
    if (this.bzf)
    {
      ((CameraFilterGLView)this.a).setPreviewSize(paramInt1, paramInt2, paramaasx);
      return;
    }
    ((CameraGLSurfaceView)this.a).setPreviewSize(paramInt1, paramInt2, paramaasx);
  }
  
  public void setVideoFilter(String paramString)
  {
    if ((this.bzf) && (this.a != null)) {
      ((CameraFilterGLView)this.a).setVideoFilter(paramString);
    }
  }
  
  public void setVideoFilter(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((this.bzf) && (this.a != null)) {
      ((CameraFilterGLView)this.a).setVideoFilter(paramString1, paramInt, paramString2, paramString3);
    }
  }
  
  public void setVideoFilter(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.bzf) && (this.a != null)) {
      ((CameraFilterGLView)this.a).setVideoFilter(paramString, paramBoolean1, paramBoolean2);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.a != null) {
      this.a.setVisibility(paramInt);
    }
    super.setVisibility(paramInt);
  }
  
  public int zj()
  {
    if ((this.bzf) && (this.a != null)) {
      return ((CameraFilterGLView)this.a).jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$f.mOrientation;
    }
    return 0;
  }
  
  public int zk()
  {
    if ((this.bzf) && (this.a != null)) {
      return ((CameraFilterGLView)this.a).jdField_a_of_type_Anir.JH();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout
 * JD-Core Version:    0.7.0.1
 */