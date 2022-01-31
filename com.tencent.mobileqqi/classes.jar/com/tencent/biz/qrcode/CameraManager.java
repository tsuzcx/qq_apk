package com.tencent.biz.qrcode;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public final class CameraManager
  implements Camera.PreviewCallback, Comparator
{
  protected static final int a = 76800;
  protected static final String a = "Scaner";
  protected static final int b = 921600;
  protected final Context a;
  protected Point a;
  protected Rect a;
  protected Camera a;
  protected Handler a;
  protected AutoFocusManager a;
  protected ReentrantLock a;
  protected boolean a;
  protected Point b;
  protected Rect b;
  public boolean b;
  protected int c;
  
  public CameraManager(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a(Camera.Size paramSize1, Camera.Size paramSize2)
  {
    int i = paramSize1.height * paramSize1.width;
    int j = paramSize2.height * paramSize2.width;
    if (j < i) {
      return 1;
    }
    if (j > i) {
      return -1;
    }
    return 0;
  }
  
  protected Point a(Camera paramCamera)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("GT-I9008L")))
    {
      paramCamera = localParameters.getPreviewSize();
      localObject = new Point(paramCamera.width, paramCamera.height);
      return localObject;
    }
    paramCamera = localParameters.getSupportedPreviewSizes();
    if (paramCamera == null)
    {
      paramCamera = localParameters.getPreviewSize();
      return new Point(paramCamera.width, paramCamera.height);
    }
    Object localObject = new ArrayList(paramCamera);
    Collections.sort((List)localObject, this);
    paramCamera = null;
    int j;
    int i;
    float f3;
    float f1;
    if (this.c % 180 == 0)
    {
      j = this.jdField_a_of_type_AndroidGraphicsPoint.x;
      i = this.jdField_a_of_type_AndroidGraphicsPoint.y;
      f3 = j / i;
      f1 = (1.0F / 1.0F);
      localObject = ((List)localObject).iterator();
    }
    label270:
    label280:
    for (;;)
    {
      label154:
      if (((Iterator)localObject).hasNext())
      {
        Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
        int k = localSize.width;
        int m = localSize.height;
        int n = k * m;
        if ((n >= 76800) && (n <= 921600) && ((k != 980) || (m != 800) || (!Build.MANUFACTURER.equalsIgnoreCase("samsung")) || ((!Build.MODEL.equalsIgnoreCase("GT-I9220")) && (!Build.MODEL.equalsIgnoreCase("GT-N7000")))))
        {
          if (j > i)
          {
            n = 1;
            if (k >= m) {
              break label361;
            }
            i1 = 1;
            if (n != i1) {
              break label367;
            }
            i1 = 1;
            label290:
            if (i1 == 0) {
              break label373;
            }
            n = m;
            label299:
            if (i1 == 0) {
              break label380;
            }
          }
          label361:
          label367:
          label373:
          label380:
          for (int i1 = k;; i1 = m)
          {
            if ((n != j) || (i1 != i)) {
              break label387;
            }
            return new Point(k, m);
            j = this.jdField_a_of_type_AndroidGraphicsPoint.y;
            i = this.jdField_a_of_type_AndroidGraphicsPoint.x;
            break;
            n = 0;
            break label270;
            i1 = 0;
            break label280;
            i1 = 0;
            break label290;
            n = k;
            break label299;
          }
          if ((n * 2 >= j) && (j * 2 >= n) && (i1 * 2 >= i) && (i * 2 >= i1))
          {
            float f2 = Math.abs(n / i1 - f3);
            if (f2 >= f1) {
              break label489;
            }
            paramCamera = new Point(k, m);
            f1 = f2;
          }
        }
      }
    }
    label387:
    label489:
    for (;;)
    {
      break label154;
      localObject = paramCamera;
      if (paramCamera != null) {
        break;
      }
      paramCamera = localParameters.getPreviewSize();
      return new Point(paramCamera.width, paramCamera.height);
    }
  }
  
  public Rect a()
  {
    int j;
    int i;
    if (this.jdField_b_of_type_AndroidGraphicsRect == null)
    {
      if (this.jdField_a_of_type_AndroidGraphicsRect == null) {}
      while ((this.jdField_b_of_type_AndroidGraphicsPoint == null) || (this.jdField_a_of_type_AndroidGraphicsPoint == null)) {
        return null;
      }
      if (this.c % 180 != 0) {
        break label151;
      }
      j = this.jdField_a_of_type_AndroidGraphicsPoint.x;
      i = this.jdField_a_of_type_AndroidGraphicsPoint.y;
    }
    for (Rect localRect = new Rect(this.jdField_a_of_type_AndroidGraphicsRect);; localRect = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsRect.right))
    {
      localRect.left = (localRect.left * this.jdField_b_of_type_AndroidGraphicsPoint.x / j);
      localRect.right = (localRect.right * this.jdField_b_of_type_AndroidGraphicsPoint.x / j);
      localRect.top = (localRect.top * this.jdField_b_of_type_AndroidGraphicsPoint.y / i);
      localRect.bottom = (localRect.bottom * this.jdField_b_of_type_AndroidGraphicsPoint.y / i);
      this.jdField_b_of_type_AndroidGraphicsRect = localRect;
      return this.jdField_b_of_type_AndroidGraphicsRect;
      label151:
      j = this.jdField_a_of_type_AndroidGraphicsPoint.y;
      i = this.jdField_a_of_type_AndroidGraphicsPoint.x;
    }
  }
  
  public PlanarYUVLuminanceSource a(byte[] paramArrayOfByte)
  {
    Rect localRect = a();
    if ((localRect == null) || (paramArrayOfByte == null)) {
      return null;
    }
    return new PlanarYUVLuminanceSource(paramArrayOfByte, this.jdField_b_of_type_AndroidGraphicsPoint.x, this.jdField_b_of_type_AndroidGraphicsPoint.y, localRect.left, localRect.top, localRect.width(), localRect.height(), false);
  }
  
  protected String a(Collection paramCollection, String... paramVarArgs)
  {
    if (paramCollection != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        if (paramCollection.contains(str)) {
          return str;
        }
        i += 1;
      }
    }
    return null;
  }
  
  @TargetApi(8)
  protected void a()
  {
    int i = 0;
    int k = 0;
    int n = 0;
    int m = 90;
    int j;
    if (Build.VERSION.SDK_INT >= 9) {
      j = k;
    }
    for (;;)
    {
      try
      {
        int i1 = ((Integer)Camera.class.getMethod("getNumberOfCameras", new Class[0]).invoke(null, new Object[0])).intValue();
        if (i1 <= 0) {
          break label539;
        }
        j = k;
        localObject3 = Class.forName("android.hardware.Camera$CameraInfo");
        j = k;
        localObject1 = ((Class)localObject3).newInstance();
        j = k;
        localObject2 = ((Class)localObject3).getField("facing");
        j = k;
        localField = ((Class)localObject3).getField("orientation");
        j = k;
        localObject3 = Camera.class.getMethod("getCameraInfo", new Class[] { Integer.TYPE, localObject3 });
        i = 0;
        if (i < i1)
        {
          j = k;
          ((Method)localObject3).invoke(null, new Object[] { Integer.valueOf(i), localObject1 });
          j = k;
          if (((Integer)((Field)localObject2).get(localObject1)).intValue() != 0) {}
        }
        else
        {
          j = k;
          localObject2 = Camera.class.getMethod("open", new Class[] { Integer.TYPE });
          if (i < i1) {
            break label531;
          }
        }
      }
      catch (Exception localException1)
      {
        Object localObject3;
        Object localObject1;
        Object localObject2;
        Field localField;
        i = j;
      }
      try
      {
        ((Method)localObject3).invoke(null, new Object[] { Integer.valueOf(0), localObject1 });
        k = 0;
        i = 1;
        j = i;
        this.jdField_a_of_type_AndroidHardwareCamera = ((Camera)((Method)localObject2).invoke(null, new Object[] { Integer.valueOf(k) }));
        j = i;
        k = ((Integer)localField.get(localObject1)).intValue();
        j = k;
        if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
          break label318;
        }
        throw new IOException();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Camera.Parameters localParameters;
          i = 1;
        }
      }
      i += 1;
      continue;
      localException1.printStackTrace();
      j = m;
      continue;
      this.jdField_a_of_type_AndroidHardwareCamera = Camera.open();
      j = m;
      continue;
      label318:
      k = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay().getOrientation() * 90;
      if (i == 0)
      {
        this.c = ((j - k + 360) % 360);
        if (QLog.isColorLevel()) {
          QLog.d("Scaner", 2, "cameraOrientation: " + j + " screenRotation: " + k + " previewRotation: " + this.c);
        }
        localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (Build.VERSION.SDK_INT < 8) {
          break label491;
        }
        this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(this.c);
        if (localParameters.isZoomSupported()) {
          localParameters.setZoom(Math.min(2, localParameters.getMaxZoom()));
        }
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          label491:
          return;
        }
        this.c = ((j + k) % 360);
        break;
        if (k % 180 == 0) {
          localParameters.set("orientation", "portrait");
        }
        localParameters.setRotation(this.c);
      }
      label531:
      k = i;
      i = n;
      continue;
      label539:
      i = 0;
      j = 90;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Scaner", 2, "view size" + paramInt1 + "," + paramInt2);
    }
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(paramInt1, paramInt2);
  }
  
  public void a(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
  }
  
  void a(Camera paramCamera, boolean paramBoolean)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    if (localParameters == null) {
      return;
    }
    if (paramBoolean) {}
    String str2 = a(localParameters.getSupportedFocusModes(), new String[] { "auto" });
    String str1 = str2;
    if (!paramBoolean)
    {
      str1 = str2;
      if (str2 == null) {
        str1 = a(localParameters.getSupportedFocusModes(), new String[] { "macro", "edof" });
      }
    }
    if (str1 != null) {
      localParameters.setFocusMode(str1);
    }
    localParameters.setPreviewSize(this.jdField_b_of_type_AndroidGraphicsPoint.x, this.jdField_b_of_type_AndroidGraphicsPoint.y);
    paramCamera.setParameters(localParameters);
  }
  
  protected void a(SurfaceHolder paramSurfaceHolder)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
      a();
    }
    this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(paramSurfaceHolder);
    if (this.jdField_b_of_type_AndroidGraphicsPoint == null) {
      this.jdField_b_of_type_AndroidGraphicsPoint = a(this.jdField_a_of_type_AndroidHardwareCamera);
    }
    paramSurfaceHolder = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
    if (paramSurfaceHolder == null) {
      paramSurfaceHolder = null;
    }
    try
    {
      for (;;)
      {
        a(this.jdField_a_of_type_AndroidHardwareCamera, false);
        return;
        paramSurfaceHolder = paramSurfaceHolder.flatten();
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      while (paramSurfaceHolder == null) {}
      Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      localParameters.unflatten(paramSurfaceHolder);
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
        a(this.jdField_a_of_type_AndroidHardwareCamera, true);
        return;
      }
      catch (RuntimeException paramSurfaceHolder) {}
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      if (!this.jdField_b_of_type_Boolean) {
        throw new IllegalStateException();
      }
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    a(paramSurfaceHolder);
    if ((this.jdField_a_of_type_AndroidHardwareCamera != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQrcodeAutoFocusManager = new AutoFocusManager(this.jdField_a_of_type_AndroidHardwareCamera);
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localObject != null) {
      try
      {
        localObject = ((Camera)localObject).getParameters();
        if (MobileIssueSettings.i)
        {
          if (!MobileIssueSettings.k) {
            return false;
          }
          if ((((Camera.Parameters)localObject).getSupportedFlashModes() == null) || (!this.jdField_a_of_type_AndroidContentContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash")))
          {
            boolean bool = MobileIssueSettings.l;
            if (!bool) {}
          }
          else
          {
            return true;
          }
        }
      }
      catch (RuntimeException localRuntimeException) {}
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localCamera == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentBizQrcodeAutoFocusManager != null) {
      this.jdField_a_of_type_ComTencentBizQrcodeAutoFocusManager.b();
    }
    for (;;)
    {
      try
      {
        localParameters = localCamera.getParameters();
        str = "torch";
        if (MobileIssueSettings.j) {
          continue;
        }
        str = KapalaiAdapterUtil.a().a(localParameters);
      }
      catch (RuntimeException localRuntimeException)
      {
        Camera.Parameters localParameters;
        String str;
        paramBoolean = false;
        continue;
        if (!paramBoolean) {
          continue;
        }
        continue;
      }
      localParameters.setFlashMode(str);
      localCamera.setParameters(localParameters);
      if (this.jdField_a_of_type_ComTencentBizQrcodeAutoFocusManager != null) {
        this.jdField_a_of_type_ComTencentBizQrcodeAutoFocusManager.a();
      }
      return paramBoolean;
      str = "off";
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      this.jdField_a_of_type_AndroidHardwareCamera.release();
      this.jdField_a_of_type_AndroidHardwareCamera = null;
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 405	com/tencent/biz/qrcode/CameraManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   5: aload_0
    //   6: getfield 35	com/tencent/biz/qrcode/CameraManager:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   9: invokevirtual 383	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   12: aload_0
    //   13: getfield 403	com/tencent/biz/qrcode/CameraManager:jdField_a_of_type_ComTencentBizQrcodeAutoFocusManager	Lcom/tencent/biz/qrcode/AutoFocusManager;
    //   16: ifnull +15 -> 31
    //   19: aload_0
    //   20: getfield 403	com/tencent/biz/qrcode/CameraManager:jdField_a_of_type_ComTencentBizQrcodeAutoFocusManager	Lcom/tencent/biz/qrcode/AutoFocusManager;
    //   23: invokevirtual 433	com/tencent/biz/qrcode/AutoFocusManager:b	()V
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 403	com/tencent/biz/qrcode/CameraManager:jdField_a_of_type_ComTencentBizQrcodeAutoFocusManager	Lcom/tencent/biz/qrcode/AutoFocusManager;
    //   31: aload_0
    //   32: getfield 252	com/tencent/biz/qrcode/CameraManager:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   35: ifnull +47 -> 82
    //   38: aload_0
    //   39: getfield 393	com/tencent/biz/qrcode/CameraManager:jdField_a_of_type_Boolean	Z
    //   42: istore_1
    //   43: iload_1
    //   44: ifeq +38 -> 82
    //   47: aload_0
    //   48: getfield 252	com/tencent/biz/qrcode/CameraManager:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   51: invokevirtual 56	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   54: astore_2
    //   55: aload_2
    //   56: ldc_w 452
    //   59: invokevirtual 449	android/hardware/Camera$Parameters:setFlashMode	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 252	com/tencent/biz/qrcode/CameraManager:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   66: aload_2
    //   67: invokevirtual 330	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   70: aload_0
    //   71: getfield 252	com/tencent/biz/qrcode/CameraManager:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   74: invokevirtual 458	android/hardware/Camera:stopPreview	()V
    //   77: aload_0
    //   78: iconst_0
    //   79: putfield 393	com/tencent/biz/qrcode/CameraManager:jdField_a_of_type_Boolean	Z
    //   82: aload_0
    //   83: invokevirtual 459	com/tencent/biz/qrcode/CameraManager:b	()V
    //   86: aload_0
    //   87: getfield 35	com/tencent/biz/qrcode/CameraManager:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   90: invokevirtual 389	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   93: return
    //   94: astore_2
    //   95: aload_0
    //   96: getfield 35	com/tencent/biz/qrcode/CameraManager:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   99: invokevirtual 389	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   102: aload_2
    //   103: athrow
    //   104: astore_2
    //   105: goto -35 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	CameraManager
    //   42	2	1	bool	boolean
    //   54	13	2	localParameters	Camera.Parameters
    //   94	9	2	localObject	Object
    //   104	1	2	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   12	31	94	finally
    //   31	43	94	finally
    //   47	70	94	finally
    //   70	82	94	finally
    //   82	86	94	finally
    //   47	70	104	java/lang/RuntimeException
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.tryLock()) {}
    try
    {
      if ((this.jdField_a_of_type_AndroidHardwareCamera != null) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidHardwareCamera.setOneShotPreviewCallback(this);
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((this.jdField_b_of_type_AndroidGraphicsPoint != null) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101, this.jdField_b_of_type_AndroidGraphicsPoint.x, this.jdField_b_of_type_AndroidGraphicsPoint.y, paramArrayOfByte).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.CameraManager
 * JD-Core Version:    0.7.0.1
 */