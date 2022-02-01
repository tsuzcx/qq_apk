import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.arengine.ARCamera.1;
import com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.1;
import com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.2;
import com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class adgw
  implements Camera.AutoFocusCallback
{
  private static long Sp = -1L;
  private static final int cFp = ankt.SCREEN_WIDTH * 3 / 4;
  private static final int cFq = ankt.SCREEN_WIDTH * 3 / 4;
  private static int cFr;
  private static final Object sLock = new Object();
  private Matrix E = new Matrix();
  private adgw.b a;
  private boolean bMT;
  private boolean bMU;
  private boolean bMV;
  private boolean bMW;
  private int bzw;
  private int cFs;
  private int cFt;
  private int cFu;
  private int cFv;
  private int cFw;
  private int cjn;
  private Camera mCamera;
  private Handler mHandler = new adgw.a(Looper.getMainLooper());
  private int mPreviewHeight;
  private int mPreviewWidth;
  SensorEventListener mSensorEventListener = new adgx(this);
  private SensorManager mSensorManager = (SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor");
  private int mSurfaceHeight;
  private int mSurfaceWidth;
  
  static
  {
    cFr = -3;
  }
  
  private Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
  {
    paramInt5 = (int)(paramInt5 * paramFloat);
    paramInt1 = clamp(paramInt1 - paramInt5 / 2, 0, paramInt3 - paramInt5);
    paramInt2 = clamp(paramInt2 - paramInt5 / 2, 0, paramInt4 - paramInt5);
    RectF localRectF = new RectF(paramInt1, paramInt2, paramInt1 + paramInt5, paramInt5 + paramInt2);
    this.E.mapRect(localRectF);
    return new Rect(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
  }
  
  private void cRE()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCamera", 2, String.format("revertZoom mZooming=%s", new Object[] { Boolean.valueOf(this.bMU) }));
    }
    try
    {
      if (this.mCamera != null)
      {
        this.bMU = false;
        if (this.mHandler != null)
        {
          this.mHandler.removeMessages(102);
          this.mHandler.removeMessages(101);
        }
        Camera.Parameters localParameters = this.mCamera.getParameters();
        if (localParameters.isZoomSupported())
        {
          int i = localParameters.getZoom();
          if (i != this.cFt)
          {
            hp(i, this.cFt);
            anot.a(null, "dc00898", "", "", "0X80085B0", "0X80085B0", 0, 0, "", "", "", "");
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void cRF()
  {
    try
    {
      if (this.mCamera != null)
      {
        int i = this.cFv;
        int j = this.cFw;
        if (i != j) {
          try
          {
            if (this.bMV) {
              this.cFv += 5;
            }
            for (this.cFv = Math.min(this.cFv, this.cFw);; this.cFv = Math.max(this.cFv, this.cFw))
            {
              this.cFv = Math.min(this.cFv, this.cFu);
              this.cFv = Math.max(this.cFv, this.cFt);
              Camera.Parameters localParameters = this.mCamera.getParameters();
              localParameters.setZoom(this.cFv);
              this.mCamera.setParameters(localParameters);
              if (this.mHandler == null) {
                break;
              }
              this.mHandler.removeMessages(102);
              this.mHandler.sendEmptyMessageDelayed(102, 20L);
              return;
              this.cFv -= 5;
            }
            QLog.d("AREngine_ARCamera", 2, "updateZoom fail!", localException1);
          }
          catch (Exception localException1)
          {
            if (!QLog.isColorLevel()) {
              break label189;
            }
          }
        } else {
          this.bMU = false;
        }
      }
      label189:
      return;
    }
    catch (Exception localException2) {}
  }
  
  private boolean canFocus()
  {
    return !anii.isFoundProduct(anii.KEY_NOT_FOCUS_MODEL);
  }
  
  private int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  private void g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((this.mCamera == null) || (!canFocus()) || (this.bMT)) {}
    for (;;)
    {
      return;
      try
      {
        Camera.Parameters localParameters1 = this.mCamera.getParameters();
        if (localParameters1.getSupportedFocusModes().contains("auto"))
        {
          Object localObject = a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 1.0F);
          Rect localRect = a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 1.0F);
          QLog.d("AREngine_ARCamera", 1, String.format("focusOnArea focusRect=%s meteringRect=%s", new Object[] { localObject, localRect }));
          localParameters1.setFocusMode("auto");
          if (localParameters1.getMaxNumFocusAreas() > 0)
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(new Camera.Area((Rect)localObject, 1000));
            localParameters1.setFocusAreas(localArrayList);
          }
          if (localParameters1.getMaxNumMeteringAreas() > 0)
          {
            localObject = new ArrayList();
            ((List)localObject).add(new Camera.Area(localRect, 1000));
            localParameters1.setMeteringAreas((List)localObject);
          }
          this.mCamera.cancelAutoFocus();
          this.mCamera.setParameters(localParameters1);
          this.mCamera.autoFocus(this);
          this.bMT = true;
          return;
        }
      }
      catch (Exception localException1)
      {
        QLog.i("AREngine_ARCamera", 1, "focusOnArea fail.", localException1);
        try
        {
          this.mCamera.cancelAutoFocus();
          Camera.Parameters localParameters2 = this.mCamera.getParameters();
          lx.a(localParameters2);
          this.mCamera.setParameters(localParameters2);
          return;
        }
        catch (Exception localException2)
        {
          QLog.i("AREngine_ARCamera", 1, "focusOnArea fail.", localException2);
        }
      }
    }
  }
  
  public static int gP(int paramInt)
  {
    int j = Camera.getNumberOfCameras();
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          Camera.getCameraInfo(i, localCameraInfo);
          int k = localCameraInfo.facing;
          if (paramInt == k) {
            return i;
          }
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          QLog.i("AREngine_ARCamera", 1, "checkCameraFacing error:" + localThrowable.getMessage());
        }
      }
    }
    return 0;
  }
  
  private void hp(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    try
    {
      if (this.mCamera != null)
      {
        this.bMU = true;
        if (paramInt2 <= paramInt1) {
          break label39;
        }
      }
      for (;;)
      {
        this.bMV = bool;
        this.cFv = paramInt1;
        this.cFw = paramInt2;
        cRF();
        return;
        label39:
        bool = false;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public int BD()
  {
    return this.mPreviewWidth;
  }
  
  public int BE()
  {
    return this.mPreviewHeight;
  }
  
  public int BF()
  {
    return this.cFs;
  }
  
  public int BG()
  {
    return (this.bzw - this.cjn + 360) % 360;
  }
  
  public int BH()
  {
    return d(0, 0L);
  }
  
  public void N(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.i("AREngine_ARCamera", 1, String.format("manualFocus touchX=%s touchY=%s surfaceWidth=%s surfaceHeight=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
    if (this.mCamera != null) {
      adkt.a().ab(new ARCamera.1(this, paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
  
  public boolean a(float paramFloat, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCamera", 2, String.format("directZoom scale=%.2f autoRevert=%s mZooming=%s", new Object[] { Float.valueOf(paramFloat), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.bMU) }));
    }
    if (this.bMU)
    {
      this.bMU = false;
      if (this.mHandler != null)
      {
        this.mHandler.removeMessages(102);
        this.mHandler.removeMessages(101);
      }
    }
    if ((this.mCamera != null) && (!this.bMU)) {}
    try
    {
      localParameters = this.mCamera.getParameters();
      localList = localParameters.getZoomRatios();
      if ((localList == null) || (localList.size() == 0)) {
        break label487;
      }
      i2 = localParameters.getZoom();
      if (i2 < 0) {
        return false;
      }
      if (localList.size() <= i2) {
        break label506;
      }
      i1 = ((Integer)localList.get(i2)).intValue();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Camera.Parameters localParameters;
        List localList;
        int i2;
        int i1;
        int i3;
        continue;
        int m = i;
        break label532;
        break label532;
        return false;
        for (;;)
        {
          i3 = (int)(i1 * paramFloat);
          if (i3 > i1) {
            break;
          }
          return false;
          i1 = -1;
        }
        int n = 2147483647;
        m = -1;
        int k = -1;
        int j = 0;
        int i = i2;
        continue;
        i += 1;
      }
    }
    if (i < localList.size())
    {
      if ((Math.abs(((Integer)localList.get(i)).intValue() - i3) >= n) || (((Integer)localList.get(i)).intValue() >= i3)) {
        break label484;
      }
      n = Math.abs(((Integer)localList.get(i)).intValue() - i3);
      k = ((Integer)localList.get(i)).intValue();
      if (i + 1 < localList.size())
      {
        j = ((Integer)localList.get(i + 1)).intValue();
        m = i;
        break label532;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("AREngine_ARCamera", 2, String.format("directZoom [curZoomRatio,dstZoomRatio,index,cur,finalRatio,nextRatio]=[%d,%d,%d,%d,%d,%d]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i3), Integer.valueOf(m), Integer.valueOf(i2), Integer.valueOf(k), Integer.valueOf(j) }));
      }
      if ((localParameters.isZoomSupported()) && (m >= 0) && (m != i2))
      {
        i = Math.max(Math.min(m, this.cFu), this.cFt);
        if (i != i2)
        {
          localParameters.setZoom(i);
          this.mCamera.setParameters(localParameters);
          return true;
        }
        if (this.mHandler != null)
        {
          this.mHandler.removeMessages(101);
          if (paramBoolean) {
            this.mHandler.sendEmptyMessageDelayed(101, 5000L);
          }
        }
      }
      return false;
    }
  }
  
  /* Error */
  public boolean a(android.hardware.Camera.PreviewCallback paramPreviewCallback, android.graphics.SurfaceTexture paramSurfaceTexture, adgw.b paramb)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: ldc 184
    //   8: iconst_1
    //   9: ldc_w 456
    //   12: iconst_3
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_1
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: aload_2
    //   23: aastore
    //   24: dup
    //   25: iconst_2
    //   26: aload_0
    //   27: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   30: aastore
    //   31: invokestatic 200	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokestatic 386	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_0
    //   38: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   41: ifnull +76 -> 117
    //   44: aload_0
    //   45: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   48: aload_1
    //   49: invokevirtual 460	android/hardware/Camera:setPreviewCallbackWithBuffer	(Landroid/hardware/Camera$PreviewCallback;)V
    //   52: aload_0
    //   53: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   56: aload_2
    //   57: invokevirtual 464	android/hardware/Camera:setPreviewTexture	(Landroid/graphics/SurfaceTexture;)V
    //   60: aload_0
    //   61: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   64: invokevirtual 467	android/hardware/Camera:startPreview	()V
    //   67: aload_0
    //   68: aload_3
    //   69: putfield 469	adgw:a	Ladgw$b;
    //   72: aload_0
    //   73: getfield 111	adgw:mSensorManager	Landroid/hardware/SensorManager;
    //   76: ifnull +24 -> 100
    //   79: aload_0
    //   80: getfield 111	adgw:mSensorManager	Landroid/hardware/SensorManager;
    //   83: aload_0
    //   84: getfield 82	adgw:mSensorEventListener	Landroid/hardware/SensorEventListener;
    //   87: aload_0
    //   88: getfield 111	adgw:mSensorManager	Landroid/hardware/SensorManager;
    //   91: iconst_1
    //   92: invokevirtual 473	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   95: iconst_3
    //   96: invokevirtual 477	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   99: pop
    //   100: iconst_1
    //   101: ireturn
    //   102: astore_1
    //   103: iload 5
    //   105: istore 4
    //   107: ldc 184
    //   109: iconst_1
    //   110: ldc_w 479
    //   113: aload_1
    //   114: invokestatic 347	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   117: iload 4
    //   119: ireturn
    //   120: astore_1
    //   121: iconst_1
    //   122: istore 4
    //   124: goto -17 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	adgw
    //   0	127	1	paramPreviewCallback	android.hardware.Camera.PreviewCallback
    //   0	127	2	paramSurfaceTexture	android.graphics.SurfaceTexture
    //   0	127	3	paramb	adgw.b
    //   1	122	4	bool1	boolean
    //   4	100	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   44	72	102	java/lang/Exception
    //   72	100	120	java/lang/Exception
  }
  
  /* Error */
  public boolean aer()
  {
    // Byte code:
    //   0: ldc 184
    //   2: iconst_1
    //   3: ldc_w 482
    //   6: iconst_1
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_0
    //   13: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   16: aastore
    //   17: invokestatic 200	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokestatic 386	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   27: ifnull +124 -> 151
    //   30: aload_0
    //   31: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   34: invokevirtual 485	android/hardware/Camera:release	()V
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   42: getstatic 63	adgw:sLock	Ljava/lang/Object;
    //   45: astore_1
    //   46: aload_1
    //   47: monitorenter
    //   48: bipush 253
    //   50: putstatic 65	adgw:cFr	I
    //   53: invokestatic 491	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   56: invokevirtual 495	java/lang/Thread:getId	()J
    //   59: putstatic 69	adgw:Sp	J
    //   62: aload_1
    //   63: monitorexit
    //   64: iconst_1
    //   65: ireturn
    //   66: astore_2
    //   67: aload_1
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    //   71: astore_1
    //   72: ldc 184
    //   74: iconst_1
    //   75: ldc_w 497
    //   78: aload_1
    //   79: invokestatic 347	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   87: getstatic 63	adgw:sLock	Ljava/lang/Object;
    //   90: astore_1
    //   91: aload_1
    //   92: monitorenter
    //   93: bipush 253
    //   95: putstatic 65	adgw:cFr	I
    //   98: invokestatic 491	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   101: invokevirtual 495	java/lang/Thread:getId	()J
    //   104: putstatic 69	adgw:Sp	J
    //   107: aload_1
    //   108: monitorexit
    //   109: iconst_1
    //   110: ireturn
    //   111: astore_2
    //   112: aload_1
    //   113: monitorexit
    //   114: aload_2
    //   115: athrow
    //   116: astore_2
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   122: getstatic 63	adgw:sLock	Ljava/lang/Object;
    //   125: astore_1
    //   126: aload_1
    //   127: monitorenter
    //   128: bipush 253
    //   130: putstatic 65	adgw:cFr	I
    //   133: invokestatic 491	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   136: invokevirtual 495	java/lang/Thread:getId	()J
    //   139: putstatic 69	adgw:Sp	J
    //   142: aload_1
    //   143: monitorexit
    //   144: aload_2
    //   145: athrow
    //   146: astore_2
    //   147: aload_1
    //   148: monitorexit
    //   149: aload_2
    //   150: athrow
    //   151: iconst_1
    //   152: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	adgw
    //   45	23	1	localObject1	Object
    //   71	8	1	localException	Exception
    //   90	58	1	localObject2	Object
    //   66	4	2	localObject3	Object
    //   111	4	2	localObject4	Object
    //   116	29	2	localObject5	Object
    //   146	4	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   48	64	66	finally
    //   67	69	66	finally
    //   30	37	71	java/lang/Exception
    //   93	109	111	finally
    //   112	114	111	finally
    //   30	37	116	finally
    //   72	82	116	finally
    //   128	144	146	finally
    //   147	149	146	finally
  }
  
  public boolean ba(boolean paramBoolean)
  {
    if (this.mCamera != null) {
      try
      {
        Camera.Parameters localParameters = this.mCamera.getParameters();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCamera", 2, String.format("switchFlashLight on=%s current=%s", new Object[] { Boolean.valueOf(paramBoolean), localParameters.getFlashMode() }));
        }
        if (paramBoolean) {
          localParameters.setFlashMode("torch");
        }
        for (;;)
        {
          this.mCamera.setParameters(localParameters);
          return true;
          localParameters.setFlashMode("off");
        }
        return false;
      }
      catch (Exception localException)
      {
        QLog.e("AREngine_ARCamera", 1, "switchFlashLight fail.", localException);
      }
    }
  }
  
  public void cRA()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeMessages(100);
      this.mHandler.sendEmptyMessageDelayed(100, 100L);
    }
  }
  
  public void cRB()
  {
    if (this.mHandler != null) {
      this.mHandler.removeMessages(100);
    }
  }
  
  public void cRC()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCamera", 2, String.format("autoZoom mZooming=%s", new Object[] { Boolean.valueOf(this.bMU) }));
    }
    if (this.mCamera != null) {
      try
      {
        this.bMU = false;
        if (this.mHandler != null)
        {
          this.mHandler.removeMessages(102);
          this.mHandler.removeMessages(101);
        }
        Camera.Parameters localParameters = this.mCamera.getParameters();
        if (localParameters.isZoomSupported())
        {
          int i = localParameters.getZoom();
          if (i == this.cFt) {
            hp(i, this.cFu);
          }
          for (;;)
          {
            adfx.a().cRq();
            return;
            hp(i, this.cFt);
          }
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("AREngine_ARCamera", 1, "autoZoom fail!", localException);
      }
    }
  }
  
  public void cRD()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeMessages(101);
      this.mHandler.sendEmptyMessageDelayed(101, 20L);
    }
  }
  
  /* Error */
  public int d(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc 184
    //   2: iconst_1
    //   3: new 370	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 371	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 536
    //   13: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   20: invokevirtual 539	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 386	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aload_0
    //   30: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   33: ifnull +37 -> 70
    //   36: getstatic 63	adgw:sLock	Ljava/lang/Object;
    //   39: astore 6
    //   41: aload 6
    //   43: monitorenter
    //   44: iconst_0
    //   45: putstatic 65	adgw:cFr	I
    //   48: invokestatic 491	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   51: invokevirtual 495	java/lang/Thread:getId	()J
    //   54: putstatic 69	adgw:Sp	J
    //   57: aload 6
    //   59: monitorexit
    //   60: iconst_0
    //   61: ireturn
    //   62: astore 7
    //   64: aload 6
    //   66: monitorexit
    //   67: aload 7
    //   69: athrow
    //   70: getstatic 544	android/os/Build:MODEL	Ljava/lang/String;
    //   73: ldc_w 546
    //   76: invokevirtual 549	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   79: ifne +21 -> 100
    //   82: getstatic 544	android/os/Build:MODEL	Ljava/lang/String;
    //   85: ldc_w 551
    //   88: invokevirtual 549	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   91: ifne +9 -> 100
    //   94: lload_2
    //   95: lconst_0
    //   96: lcmp
    //   97: ifeq +17 -> 114
    //   100: lload_2
    //   101: lconst_0
    //   102: lcmp
    //   103: ifeq +142 -> 245
    //   106: invokestatic 491	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   109: pop
    //   110: lload_2
    //   111: invokestatic 555	java/lang/Thread:sleep	(J)V
    //   114: getstatic 560	android/os/Build$VERSION:SDK_INT	I
    //   117: bipush 9
    //   119: if_icmplt +220 -> 339
    //   122: invokestatic 358	android/hardware/Camera:getNumberOfCameras	()I
    //   125: ifle +76 -> 201
    //   128: iload_1
    //   129: invokestatic 562	adgw:gP	(I)I
    //   132: istore 4
    //   134: aload_0
    //   135: iload 4
    //   137: iconst_1
    //   138: invokestatic 567	auqz:a	(II)Landroid/hardware/Camera;
    //   141: putfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   144: aload_0
    //   145: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   148: ifnonnull +525 -> 673
    //   151: iload 4
    //   153: iconst_1
    //   154: if_icmpeq +519 -> 673
    //   157: aload_0
    //   158: iconst_1
    //   159: iconst_1
    //   160: invokestatic 567	auqz:a	(II)Landroid/hardware/Camera;
    //   163: putfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   166: iconst_1
    //   167: istore 4
    //   169: aload_0
    //   170: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   173: ifnull +28 -> 201
    //   176: new 360	android/hardware/Camera$CameraInfo
    //   179: dup
    //   180: invokespecial 361	android/hardware/Camera$CameraInfo:<init>	()V
    //   183: astore 6
    //   185: iload 4
    //   187: aload 6
    //   189: invokestatic 365	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   192: aload_0
    //   193: aload 6
    //   195: getfield 570	android/hardware/Camera$CameraInfo:orientation	I
    //   198: putfield 398	adgw:bzw	I
    //   201: aload_0
    //   202: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   205: ifnonnull +154 -> 359
    //   208: ldc 184
    //   210: iconst_1
    //   211: ldc_w 572
    //   214: invokestatic 386	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: getstatic 63	adgw:sLock	Ljava/lang/Object;
    //   220: astore 6
    //   222: aload 6
    //   224: monitorenter
    //   225: bipush 253
    //   227: putstatic 65	adgw:cFr	I
    //   230: invokestatic 491	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   233: invokevirtual 495	java/lang/Thread:getId	()J
    //   236: putstatic 69	adgw:Sp	J
    //   239: aload 6
    //   241: monitorexit
    //   242: bipush 253
    //   244: ireturn
    //   245: invokestatic 491	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   248: pop
    //   249: ldc2_w 573
    //   252: invokestatic 555	java/lang/Thread:sleep	(J)V
    //   255: goto -141 -> 114
    //   258: astore 6
    //   260: ldc 184
    //   262: iconst_1
    //   263: ldc_w 576
    //   266: aload 6
    //   268: invokestatic 347	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   271: getstatic 63	adgw:sLock	Ljava/lang/Object;
    //   274: astore 6
    //   276: aload 6
    //   278: monitorenter
    //   279: bipush 253
    //   281: putstatic 65	adgw:cFr	I
    //   284: invokestatic 491	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   287: invokevirtual 495	java/lang/Thread:getId	()J
    //   290: putstatic 69	adgw:Sp	J
    //   293: aload 6
    //   295: monitorexit
    //   296: bipush 253
    //   298: ireturn
    //   299: astore 6
    //   301: ldc 184
    //   303: iconst_1
    //   304: new 370	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 371	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 578
    //   314: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: iload 4
    //   319: invokevirtual 581	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: ldc_w 583
    //   325: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: aload 6
    //   333: invokestatic 347	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   336: goto -192 -> 144
    //   339: aload_0
    //   340: iconst_m1
    //   341: iconst_1
    //   342: invokestatic 567	auqz:a	(II)Landroid/hardware/Camera;
    //   345: putfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   348: goto -147 -> 201
    //   351: astore 7
    //   353: aload 6
    //   355: monitorexit
    //   356: aload 7
    //   358: athrow
    //   359: aload_0
    //   360: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   363: sipush 1280
    //   366: sipush 720
    //   369: invokestatic 588	adfw:a	()Ladfw;
    //   372: getfield 591	adfw:cEY	I
    //   375: invokestatic 594	lx:a	(Landroid/hardware/Camera;III)V
    //   378: bipush 90
    //   380: istore 5
    //   382: iload 5
    //   384: istore 4
    //   386: getstatic 597	anii:KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL	Ljava/lang/String;
    //   389: invokestatic 287	anii:isFoundProduct	(Ljava/lang/String;)Z
    //   392: ifeq +16 -> 408
    //   395: iload 5
    //   397: istore 4
    //   399: iload_1
    //   400: ifne +8 -> 408
    //   403: sipush 270
    //   406: istore 4
    //   408: iload 4
    //   410: istore 5
    //   412: iload_1
    //   413: iconst_1
    //   414: if_icmpne +28 -> 442
    //   417: getstatic 600	anii:KEY_PREVIEW_ORIENTATION_270_OF_FRONT_MODEL	Ljava/lang/String;
    //   420: invokestatic 287	anii:isFoundProduct	(Ljava/lang/String;)Z
    //   423: ifne +253 -> 676
    //   426: iload 4
    //   428: istore 5
    //   430: getstatic 603	anii:KEY_PREVIEW_ORIENTATION_270_OF_FRONT_MODEL_2	Ljava/lang/String;
    //   433: invokestatic 606	anii:isFoundProductFeatureRom	(Ljava/lang/String;)Z
    //   436: ifeq +6 -> 442
    //   439: goto +237 -> 676
    //   442: aload_0
    //   443: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   446: iload 5
    //   448: invokevirtual 609	android/hardware/Camera:setDisplayOrientation	(I)V
    //   451: aload_0
    //   452: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   455: invokevirtual 218	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   458: astore 6
    //   460: aload_0
    //   461: aload 6
    //   463: invokevirtual 612	android/hardware/Camera$Parameters:getPreviewFormat	()I
    //   466: putfield 395	adgw:cFs	I
    //   469: new 614	android/graphics/PixelFormat
    //   472: dup
    //   473: invokespecial 615	android/graphics/PixelFormat:<init>	()V
    //   476: astore 7
    //   478: aload_0
    //   479: getfield 395	adgw:cFs	I
    //   482: aload 7
    //   484: invokestatic 619	android/graphics/PixelFormat:getPixelFormatInfo	(ILandroid/graphics/PixelFormat;)V
    //   487: aload 6
    //   489: invokevirtual 623	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   492: astore 8
    //   494: aload_0
    //   495: aload 8
    //   497: getfield 628	android/hardware/Camera$Size:width	I
    //   500: putfield 389	adgw:mPreviewWidth	I
    //   503: aload_0
    //   504: aload 8
    //   506: getfield 631	android/hardware/Camera$Size:height	I
    //   509: putfield 392	adgw:mPreviewHeight	I
    //   512: aload_0
    //   513: iconst_0
    //   514: putfield 291	adgw:bMT	Z
    //   517: aload_0
    //   518: aload 6
    //   520: invokevirtual 226	android/hardware/Camera$Parameters:getZoom	()I
    //   523: putfield 228	adgw:cFt	I
    //   526: aload_0
    //   527: aload 6
    //   529: invokevirtual 634	android/hardware/Camera$Parameters:getMaxZoom	()I
    //   532: iconst_3
    //   533: idiv
    //   534: iconst_2
    //   535: imul
    //   536: putfield 255	adgw:cFu	I
    //   539: ldc 184
    //   541: iconst_1
    //   542: ldc_w 636
    //   545: iconst_3
    //   546: anewarray 4	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: aload_0
    //   552: getfield 228	adgw:cFt	I
    //   555: invokestatic 410	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   558: aastore
    //   559: dup
    //   560: iconst_1
    //   561: aload_0
    //   562: getfield 255	adgw:cFu	I
    //   565: invokestatic 410	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   568: aastore
    //   569: dup
    //   570: iconst_2
    //   571: aload 6
    //   573: invokevirtual 634	android/hardware/Camera$Parameters:getMaxZoom	()I
    //   576: invokestatic 410	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   579: aastore
    //   580: invokestatic 200	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   583: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   586: aload_0
    //   587: getfield 389	adgw:mPreviewWidth	I
    //   590: aload_0
    //   591: getfield 392	adgw:mPreviewHeight	I
    //   594: imul
    //   595: aload 7
    //   597: getfield 639	android/graphics/PixelFormat:bitsPerPixel	I
    //   600: imul
    //   601: bipush 8
    //   603: idiv
    //   604: istore 4
    //   606: iconst_0
    //   607: istore_1
    //   608: iload_1
    //   609: iconst_3
    //   610: if_icmpge +29 -> 639
    //   613: aload_0
    //   614: getfield 206	adgw:mCamera	Landroid/hardware/Camera;
    //   617: iload 4
    //   619: newarray byte
    //   621: invokevirtual 643	android/hardware/Camera:addCallbackBuffer	([B)V
    //   624: iload_1
    //   625: iconst_1
    //   626: iadd
    //   627: istore_1
    //   628: goto -20 -> 608
    //   631: astore 7
    //   633: aload 6
    //   635: monitorexit
    //   636: aload 7
    //   638: athrow
    //   639: getstatic 63	adgw:sLock	Ljava/lang/Object;
    //   642: astore 6
    //   644: aload 6
    //   646: monitorenter
    //   647: iconst_0
    //   648: putstatic 65	adgw:cFr	I
    //   651: invokestatic 491	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   654: invokevirtual 495	java/lang/Thread:getId	()J
    //   657: putstatic 69	adgw:Sp	J
    //   660: aload 6
    //   662: monitorexit
    //   663: iconst_0
    //   664: ireturn
    //   665: astore 7
    //   667: aload 6
    //   669: monitorexit
    //   670: aload 7
    //   672: athrow
    //   673: goto -504 -> 169
    //   676: sipush 270
    //   679: istore 5
    //   681: goto -239 -> 442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	684	0	this	adgw
    //   0	684	1	paramInt	int
    //   0	684	2	paramLong	long
    //   132	486	4	i	int
    //   380	300	5	j	int
    //   258	9	6	localException1	Exception
    //   299	55	6	localException2	Exception
    //   62	6	7	localObject4	Object
    //   351	6	7	localObject5	Object
    //   476	120	7	localPixelFormat	android.graphics.PixelFormat
    //   631	6	7	localObject6	Object
    //   665	6	7	localObject7	Object
    //   492	13	8	localSize	android.hardware.Camera.Size
    // Exception table:
    //   from	to	target	type
    //   44	60	62	finally
    //   64	67	62	finally
    //   70	94	258	java/lang/Exception
    //   106	114	258	java/lang/Exception
    //   114	134	258	java/lang/Exception
    //   144	151	258	java/lang/Exception
    //   157	166	258	java/lang/Exception
    //   169	201	258	java/lang/Exception
    //   201	225	258	java/lang/Exception
    //   245	255	258	java/lang/Exception
    //   301	336	258	java/lang/Exception
    //   339	348	258	java/lang/Exception
    //   356	359	258	java/lang/Exception
    //   359	378	258	java/lang/Exception
    //   386	395	258	java/lang/Exception
    //   417	426	258	java/lang/Exception
    //   430	439	258	java/lang/Exception
    //   442	606	258	java/lang/Exception
    //   613	624	258	java/lang/Exception
    //   134	144	299	java/lang/Exception
    //   225	242	351	finally
    //   353	356	351	finally
    //   279	296	631	finally
    //   633	636	631	finally
    //   647	663	665	finally
    //   667	670	665	finally
  }
  
  public int gO(int paramInt)
  {
    int j = 0;
    Object localObject1 = sLock;
    int i = j;
    try
    {
      if (Sp != -1L)
      {
        if (Thread.currentThread().getId() != Sp) {
          break label53;
        }
        i = j;
      }
      for (;;)
      {
        if (i == 0) {
          break;
        }
        return d(paramInt, 150L);
        label53:
        i = j;
        if (cFr == 0) {
          i = 1;
        }
      }
      return d(paramInt, 0L);
    }
    finally {}
  }
  
  public void ho(int paramInt1, int paramInt2)
  {
    QLog.i("AREngine_ARCamera", 1, String.format("autoFocus surfaceWidth=%s surfaceHeight=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (this.mCamera != null)
    {
      if ((this.mSurfaceWidth != paramInt1) || (this.mSurfaceHeight != paramInt2))
      {
        Matrix localMatrix = new Matrix();
        localMatrix.setScale(1.0F, 1.0F);
        localMatrix.postRotate(90.0F);
        localMatrix.postScale(paramInt1 / 2000.0F, paramInt2 / 2000.0F);
        localMatrix.postTranslate(paramInt1 / 2.0F, paramInt2 / 2.0F);
        localMatrix.invert(this.E);
        this.mSurfaceWidth = paramInt1;
        this.mSurfaceHeight = paramInt2;
      }
      if (this.mHandler != null)
      {
        this.mHandler.removeMessages(100);
        this.mHandler.sendEmptyMessageDelayed(100, 500L);
      }
    }
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    QLog.d("AREngine_ARCamera", 1, String.format("onAutoFocus success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.bMT) {}
    try
    {
      this.mCamera.cancelAutoFocus();
      paramCamera = this.mCamera.getParameters();
      lx.a(paramCamera);
      this.mCamera.setParameters(paramCamera);
      if (this.a != null) {
        this.a.Gc(paramBoolean);
      }
      this.bMT = false;
      return;
    }
    catch (Exception paramCamera)
    {
      for (;;)
      {
        QLog.i("AREngine_ARCamera", 1, "focusOnArea fail.", paramCamera);
      }
    }
  }
  
  public void stopPreview()
  {
    QLog.i("AREngine_ARCamera", 1, String.format("stopPreview mCamera=%s", new Object[] { this.mCamera }));
    cRB();
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    if (this.mCamera != null) {}
    try
    {
      this.mCamera.setPreviewCallbackWithBuffer(null);
      this.mCamera.stopPreview();
      this.a = null;
      if (this.mSensorManager != null) {
        this.mSensorManager.unregisterListener(this.mSensorEventListener);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.i("AREngine_ARCamera", 1, "stopCamera fail.", localException);
    }
  }
  
  public class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 100: 
        adkt.a().ab(new ARCamera.ARCameraHandler.1(this));
        removeMessages(100);
        sendEmptyMessageDelayed(100, 3000L);
        return;
      case 101: 
        adkt.a().ab(new ARCamera.ARCameraHandler.2(this));
        return;
      }
      adkt.a().ab(new ARCamera.ARCameraHandler.3(this));
    }
  }
  
  public static abstract interface b
  {
    public abstract void Gc(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adgw
 * JD-Core Version:    0.7.0.1
 */