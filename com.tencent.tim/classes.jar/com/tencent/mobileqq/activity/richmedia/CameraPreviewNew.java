package com.tencent.mobileqq.activity.richmedia;

import aaqh;
import acfp;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import anhn;
import anih;
import anij;
import anij.b;
import aniq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class CameraPreviewNew
  extends SurfaceView
  implements Camera.PreviewCallback, SurfaceHolder.Callback
{
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
  private anhn jdField_a_of_type_Anhn = new a();
  private boolean bwA;
  
  public CameraPreviewNew(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CameraPreviewNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setType(3);
  }
  
  public void j(int paramInt, String paramString, boolean paramBoolean)
  {
    post(new CameraPreviewNew.1(this, paramString, paramInt, getContext()));
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera) {}
  
  public void setCamera(boolean paramBoolean)
  {
    this.bwA = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "setCamera isFromGuide" + this.bwA);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (Build.VERSION.SDK_INT <= 10) {
      anij.a().axq();
    }
    if (!anij.a().axt())
    {
      this.jdField_a_of_type_Anhn.notify(2, new Object[] { "set preview format failed" });
      j(2002, acfp.m(2131703373), false);
    }
    do
    {
      return;
      paramSurfaceHolder = anij.a().c(aniq.dHf, aniq.dHg, paramInt2, paramInt3, false);
      if ((paramSurfaceHolder == null) || (!anij.a().c(paramSurfaceHolder)))
      {
        this.jdField_a_of_type_Anhn.notify(2, new Object[] { "set preview size failed" });
        j(2002, acfp.m(2131703376), false);
        return;
      }
      if (!anij.a().lA(aniq.dHc))
      {
        this.jdField_a_of_type_Anhn.notify(2, new Object[] { "set preview fps failed" });
        j(2002, acfp.m(2131703383), false);
        return;
      }
      if (!anij.a().axr())
      {
        this.jdField_a_of_type_Anhn.notify(2, new Object[] { "set display orientation failed" });
        j(2002, acfp.m(2131703382), false);
        return;
      }
      paramSurfaceHolder = anij.a().Z();
      paramInt1 = anij.a().getPreviewFormat();
      anij.b localb = anij.a().c();
      this.jdField_a_of_type_Anhn.notify(2, new Object[] { localb, Integer.valueOf(paramInt1), paramSurfaceHolder });
    } while (anij.a().a(this, this.jdField_a_of_type_AndroidViewSurfaceHolder));
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceChanged");
    }
    j(2002, acfp.m(2131703377), false);
    this.jdField_a_of_type_Anhn.notify(3, new Object[] { "start preview failed" });
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", aaqh.cix);
    if (this.bwA) {
      i = 1;
    }
    int j = i;
    if (!anih.agb())
    {
      j = i;
      if (i == 1) {
        j = 2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceCreated sCurrentCamera=" + j);
    }
    if (anij.a().jr(j) != 0)
    {
      this.jdField_a_of_type_Anhn.notify(1, new Object[] { "open camera failed" });
      j(2002, acfp.m(2131703375), false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceCreated");
    }
    this.jdField_a_of_type_Anhn.notify(1, new Object[] { Boolean.valueOf(true) });
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder.removeCallback(this);
    anij.a().axq();
    anij.a().releaseCamera();
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewNew", 2, "surfaceDestroyed");
    }
  }
  
  public class a
    extends anhn
  {
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.CameraPreviewNew
 * JD-Core Version:    0.7.0.1
 */