package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.utils.CameraUtil;
import com.tencent.qphone.base.util.QLog;
import hfu;
import java.util.Iterator;
import java.util.List;

public class CameraPreview
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  protected static final int a = 76800;
  private static final String jdField_a_of_type_JavaLangString = "CameraPreview";
  protected static final int b = 921600;
  private Point jdField_a_of_type_AndroidGraphicsPoint;
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private boolean jdField_a_of_type_Boolean;
  
  public CameraPreview(Context paramContext, Camera paramCamera)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidHardwareCamera = paramCamera;
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      this.jdField_a_of_type_AndroidGraphicsPoint = a(this.jdField_a_of_type_AndroidHardwareCamera);
    }
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setType(3);
  }
  
  @TargetApi(9)
  public Point a(Camera paramCamera)
  {
    label167:
    for (;;)
    {
      try
      {
        paramCamera = paramCamera.getParameters();
        Object localObject = paramCamera.getSupportedPreviewSizes();
        if (localObject == null)
        {
          paramCamera = paramCamera.getPreviewSize();
          return new Point(paramCamera.width, paramCamera.height);
        }
        paramCamera = (Camera.Size)((List)localObject).get(0);
        Iterator localIterator = ((List)localObject).iterator();
        if (localIterator.hasNext())
        {
          localObject = (Camera.Size)localIterator.next();
          if (((Camera.Size)localObject).width * ((Camera.Size)localObject).height > paramCamera.width * paramCamera.height)
          {
            paramCamera = (Camera)localObject;
            break label167;
          }
        }
        else
        {
          paramCamera = new Point(paramCamera.width, paramCamera.height);
          return paramCamera;
        }
      }
      catch (Exception paramCamera)
      {
        paramCamera.printStackTrace();
        paramCamera = new DisplayMetrics();
        ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(paramCamera);
        return new Point(paramCamera.widthPixels, paramCamera.heightPixels);
      }
    }
  }
  
  @TargetApi(9)
  public void a()
  {
    int i;
    switch (((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = new Camera.CameraInfo();
      Camera.getCameraInfo(0, (Camera.CameraInfo)localObject1);
      if (((Camera.CameraInfo)localObject1).facing == 1)
      {
        i = (360 - (i + ((Camera.CameraInfo)localObject1).orientation) % 360) % 360;
        label90:
        CameraUtil.a(this.jdField_a_of_type_AndroidHardwareCamera, i);
        if (QLog.isColorLevel()) {
          QLog.d("CameraPreview", 2, "camera orientation:" + i);
        }
      }
      try
      {
        localObject1 = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (localObject1 != null)
        {
          if (Build.VERSION.SDK_INT < 14) {
            break label235;
          }
          ((Camera.Parameters)localObject1).setFocusMode("continuous-picture");
          ((Camera.Parameters)localObject1).setPreviewSize(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y);
        }
      }
      catch (Exception localException)
      {
        try
        {
          Object localObject2;
          for (;;)
          {
            this.jdField_a_of_type_AndroidHardwareCamera.setParameters((Camera.Parameters)localObject1);
            return;
            i = 0;
            break;
            i = 90;
            break;
            i = 180;
            break;
            i = 270;
            break;
            i = (((Camera.CameraInfo)localObject1).orientation - i + 360) % 360;
            break label90;
            localException = localException;
            localException.printStackTrace();
            localObject2 = null;
            continue;
            label235:
            if (Build.VERSION.SDK_INT < 9) {
              break label252;
            }
            localObject2.setFocusMode("continuous-video");
          }
          label252:
          localObject2.setFocusMode("auto");
        }
        catch (RuntimeException localRuntimeException)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d("CameraPreview", 2, "camera set parameters failed");
        }
      }
    }
  }
  
  @TargetApi(9)
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidHardwareCamera == null)) {}
    int i;
    do
    {
      return;
      i = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation();
    } while ((paramInt1 == 0) || (paramInt2 == 0));
    double d2 = this.jdField_a_of_type_AndroidGraphicsPoint.x * 1.0D / this.jdField_a_of_type_AndroidGraphicsPoint.y;
    double d1;
    if (i != 0)
    {
      d1 = d2;
      if (i != 2) {}
    }
    else
    {
      d1 = 1.0D / d2;
    }
    if (paramInt1 * 1.0D / paramInt2 <= d1) {
      paramInt1 = (int)(d1 * paramInt2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraPreview", 2, "previewSize width:" + paramInt1 + " height:" + paramInt2);
      }
      setLayoutParams(new FrameLayout.LayoutParams(paramInt1, paramInt2));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CameraPreview", 2, "after setLayoutParams width:" + getWidth() + " height:" + getHeight());
      return;
      paramInt2 = (int)(paramInt1 / d1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidHardwareCamera == null)) {}
    while (this.jdField_a_of_type_AndroidViewSurfaceHolder.getSurface() == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
      try
      {
        label34:
        a();
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder);
        this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
        if (Build.VERSION.SDK_INT < 9) {
          this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(new hfu(this));
        }
        FrameLayout localFrameLayout = (FrameLayout)getParent();
        a(localFrameLayout.getWidth(), localFrameLayout.getHeight());
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
        }
      }
    }
    catch (Exception localException2)
    {
      break label34;
    }
  }
  
  public void setCamera(Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidHardwareCamera = paramCamera;
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      this.jdField_a_of_type_AndroidGraphicsPoint = a(this.jdField_a_of_type_AndroidHardwareCamera);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreview", 2, "surfaceChanged");
    }
    b();
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreview", 2, "surfaceCreated");
    }
    b();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreview", 2, "surfaceDestroyed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CameraPreview
 * JD-Core Version:    0.7.0.1
 */