package com.tencent.av.camera;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import bhe;
import bhf;
import com.tencent.av.VideoController;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class VcCamera
{
  public static int a = 0;
  static bhf jdField_a_of_type_Bhf = new bhf();
  static final String jdField_a_of_type_JavaLangString = "VcCamera";
  static boolean jdField_a_of_type_Boolean = false;
  static final int jdField_b_of_type_Int = 1;
  static final int jdField_c_of_type_Int = 2;
  public Context a;
  private Camera.PreviewCallback jdField_a_of_type_AndroidHardwareCamera$PreviewCallback = new bhe(this);
  Camera jdField_a_of_type_AndroidHardwareCamera = null;
  public Display a;
  public VideoController a;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  String jdField_c_of_type_JavaLangString;
  public int d = 0;
  int e = 0;
  int f;
  int g;
  public int h = 0;
  int i = 0;
  public int j = 0;
  public int k = 0;
  
  public VcCamera(VideoController paramVideoController)
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentAvVideoController.a();
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay();
    this.jdField_b_of_type_Boolean = PhoneStatusTools.g(this.jdField_a_of_type_AndroidContentContext);
    this.f = a();
    this.jdField_b_of_type_JavaLangString = Build.MODEL;
    this.c = Build.MANUFACTURER;
    jdField_a_of_type_Bhf.b = -1;
    jdField_a_of_type_Bhf.c = -1;
    if (QLog.isColorLevel())
    {
      QLog.d("VcCamera", 2, "Device_Tag = " + this.c + ": " + this.jdField_b_of_type_JavaLangString);
      QLog.d("VcCamera", 2, "Rom_Tag = " + Build.VERSION.INCREMENTAL);
    }
  }
  
  public static int a()
  {
    return Build.VERSION.SDK_INT;
  }
  
  private Camera.Size a(List paramList, int paramInt1, int paramInt2)
  {
    double d2 = paramInt1 / paramInt2;
    Object localObject2;
    if (paramList == null)
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    Iterator localIterator = paramList.iterator();
    label33:
    while (localIterator.hasNext())
    {
      localObject2 = (Camera.Size)localIterator.next();
      if (Math.abs(((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height - d2) <= 0.05D)
      {
        if (Math.abs(((Camera.Size)localObject2).height - paramInt2) >= d1) {
          break label205;
        }
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt2);
        localObject1 = localObject2;
      }
    }
    label205:
    for (;;)
    {
      break label33;
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      localIterator = paramList.iterator();
      d1 = 1.7976931348623157E+308D;
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (Camera.Size)localIterator.next();
      if (Math.abs(paramList.height - paramInt2) < d1) {
        d1 = Math.abs(paramList.height - paramInt2);
      }
      for (;;)
      {
        localObject1 = paramList;
        break;
        paramList = (List)localObject1;
      }
    }
  }
  
  private bhf a(int paramInt, Camera paramCamera)
  {
    paramCamera = new bhf();
    try
    {
      Object localObject2 = Class.forName("android.hardware.Camera");
      Class localClass = Class.forName("android.hardware.Camera$CameraInfo");
      if (localClass == null)
      {
        paramCamera.c = -1;
        paramCamera.b = -1;
        return paramCamera;
      }
      Object localObject1 = localClass.newInstance();
      if (localObject1 == null)
      {
        paramCamera.c = -1;
        paramCamera.b = -1;
        return paramCamera;
      }
      Field localField1 = localObject1.getClass().getField("facing");
      Field localField2 = localObject1.getClass().getField("orientation");
      if ((localField1 == null) || (localField2 == null))
      {
        paramCamera.c = -1;
        paramCamera.b = -1;
        return paramCamera;
      }
      localObject2 = ((Class)localObject2).getMethod("getCameraInfo", new Class[] { Integer.TYPE, localClass });
      if (localObject2 == null)
      {
        paramCamera.c = -1;
        paramCamera.b = -1;
        return paramCamera;
      }
      ((Method)localObject2).invoke(null, new Object[] { Integer.valueOf(paramInt), localObject1 });
      paramCamera.jdField_a_of_type_Int = localField1.getInt(localObject1);
      paramCamera.b = localField2.getInt(localObject1);
      if (this.jdField_a_of_type_AndroidViewDisplay == null)
      {
        paramCamera.c = -1;
        return paramCamera;
      }
      localObject1 = this.jdField_a_of_type_AndroidViewDisplay.getClass().getMethod("getRotation", new Class[0]);
      if (localObject1 == null)
      {
        paramCamera.c = -1;
        return paramCamera;
      }
      switch (Integer.parseInt(((Method)localObject1).invoke(this.jdField_a_of_type_AndroidViewDisplay, (Object[])null).toString()))
      {
      case 0: 
        paramCamera.c = 0;
      }
    }
    catch (Exception localException)
    {
      paramCamera.c = 0;
      return paramCamera;
    }
    paramCamera.c = 90;
    return paramCamera;
    paramCamera.c = 180;
    return paramCamera;
    paramCamera.c = 270;
    return paramCamera;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { new String(paramString) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      throw paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static ArrayList a(String paramString)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ",");
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      paramString = localArrayList;
      if (!localStringTokenizer.hasMoreElements()) {
        break;
      }
      localArrayList.add(Integer.valueOf(Integer.parseInt(localStringTokenizer.nextToken())));
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    n = 0;
    synchronized (jdField_a_of_type_Bhf)
    {
      if (c())
      {
        a(this.g, this.jdField_a_of_type_AndroidHardwareCamera);
        ??? = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        VcControllerImpl.setCameraParameters(((Camera.Parameters)???).flatten());
      }
    }
    for (;;)
    {
      try
      {
        List localList = (List)???.getClass().getMethod("getSupportedPreviewFormats", new Class[0]).invoke(???, (Object[])null);
        if (localList == null) {
          continue;
        }
        m = 0;
        if (m < localList.size())
        {
          if (QLog.isColorLevel()) {
            QLog.d("VcCamera", 2, "format: " + localList.get(m));
          }
          m += 1;
          continue;
          a(this.jdField_a_of_type_AndroidHardwareCamera);
          break;
          localObject2 = finally;
          throw localObject2;
        }
        bool = localObject2.contains(Integer.valueOf(17));
        if (bool) {
          m = 17;
        }
      }
      catch (Exception localException4)
      {
        boolean bool;
        Object localObject3;
        int m = n;
        continue;
        m = 0;
        continue;
      }
      try
      {
        localObject3 = ???.getClass().getMethod("getSupportedPreviewSizes", new Class[0]);
        if (localObject3 != null)
        {
          localObject3 = (List)((Method)localObject3).invoke(???, (Object[])null);
          if (localObject3 != null)
          {
            localObject3 = b((List)localObject3, paramInt1, paramInt2);
            if (localObject3 != null)
            {
              VideoChatSettings.b = ((Camera.Size)localObject3).width;
              VideoChatSettings.c = ((Camera.Size)localObject3).height;
            }
          }
        }
      }
      catch (Exception localException3)
      {
        continue;
      }
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = 10;
      }
      try
      {
        localObject3 = ???.getClass().getMethod("getSupportedPreviewFrameRates", new Class[0]);
        if (localObject3 != null)
        {
          localObject3 = (List)((Method)localObject3).invoke(???, (Object[])null);
          if (localObject3 != null)
          {
            jdField_a_of_type_Int = 0;
            localObject3 = ((List)localObject3).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              Integer localInteger = (Integer)((Iterator)localObject3).next();
              if (localInteger.intValue() <= 9) {
                continue;
              }
              paramInt1 = localInteger.intValue();
              if ((jdField_a_of_type_Int <= paramInt1) && (jdField_a_of_type_Int != 0)) {
                continue;
              }
              jdField_a_of_type_Int = paramInt1;
              continue;
            }
          }
        }
        if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("GT-I9003")) {
          continue;
        }
      }
      catch (Exception localException1)
      {
        if (jdField_a_of_type_Int == 0) {
          jdField_a_of_type_Int = 10;
        }
        if (!this.c.equalsIgnoreCase("samsung")) {}
      }
      if (((this.c.equalsIgnoreCase("samsung")) && (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("GT-I9220"))) || ((this.c.equalsIgnoreCase("samsung")) && (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("GT-I7000"))))
      {
        ((Camera.Parameters)???).setPreviewSize(320, 240);
        if (m == 0) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VcCamera", 2, "supportFormat = " + m);
        }
        ((Camera.Parameters)???).setPreviewFormat(m);
        ((Camera.Parameters)???).setPreviewFrameRate(jdField_a_of_type_Int);
        ((Camera.Parameters)???).set("Rotation", 180);
      }
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.setParameters((Camera.Parameters)???);
        Camera.Size localSize = ((Camera.Parameters)???).getPreviewSize();
        paramInt1 = ((Camera.Parameters)???).getPreviewFormat();
        if (QLog.isColorLevel()) {
          QLog.d("VcCamera", 2, "videoFormat = " + paramInt1);
        }
        VideoChatSettings.b = localSize.width;
        VideoChatSettings.c = localSize.height;
        VideoChatSettings.jdField_a_of_type_Int = paramInt1;
        if ((this.c.equalsIgnoreCase("meizu")) && (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("meizu_m9")))
        {
          VideoChatSettings.jdField_a_of_type_Int = 18;
          return;
          if (localSize.contains(Integer.valueOf(16)))
          {
            m = 16;
            continue;
          }
          if (localSize.contains(Integer.valueOf(20)))
          {
            m = 20;
            continue;
          }
          if (localSize.contains(Integer.valueOf(842094169)))
          {
            m = 842094169;
            continue;
          }
          if (localSize.contains(Integer.valueOf(4)))
          {
            m = 4;
            continue;
          }
          if (localSize.contains(Integer.valueOf(17)))
          {
            m = 17;
            continue;
          }
          if (localSize.contains(Integer.valueOf(16)))
          {
            m = 16;
            continue;
          }
          if (localSize.contains(Integer.valueOf(3)))
          {
            m = 3;
            continue;
          }
          if (localSize.contains(Integer.valueOf(2)))
          {
            m = 2;
            continue;
          }
          if (localSize.contains(Integer.valueOf(4)))
          {
            m = 4;
            continue;
          }
          if (localSize.contains(Integer.valueOf(100)))
          {
            m = 100;
            continue;
          }
          if (localSize.contains(Integer.valueOf(101)))
          {
            m = 101;
            continue;
          }
          if (localSize.contains(Integer.valueOf(102)))
          {
            m = 102;
            continue;
          }
          if (localSize.contains(Integer.valueOf(103)))
          {
            m = 103;
            continue;
          }
          bool = localSize.contains(Integer.valueOf(104));
          if (!bool) {
            continue;
          }
          m = 104;
          continue;
          ((Camera.Parameters)???).setPreviewSize(VideoChatSettings.b, VideoChatSettings.c);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("VcCamera", 2, "supportFormat = 17(default value)");
          }
          ((Camera.Parameters)???).setPreviewFormat(17);
          continue;
        }
        if ((!this.c.equalsIgnoreCase("ZTE")) || (!this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("ZTE-T U880"))) {
          continue;
        }
        VideoChatSettings.jdField_a_of_type_Int = 100;
        return;
      }
      catch (Exception localException2) {}
    }
  }
  
  private void a(Camera paramCamera)
  {
    try
    {
      Method localMethod = paramCamera.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE });
      if (this.d == 1) {}
      for (int m = g() % 360;; m = h() % 360)
      {
        localMethod.invoke(paramCamera, new Object[] { Integer.valueOf(m) });
        return;
      }
      return;
    }
    catch (Exception paramCamera)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 2, "adjustDirection", paramCamera);
      }
    }
  }
  
  private void a(Camera paramCamera, int paramInt)
  {
    try
    {
      paramCamera.getClass().getMethod("setDisplayOrientation", new Class[] { Integer.TYPE }).invoke(paramCamera, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramCamera)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VcCamera", 2, "setDisplayOrientation", paramCamera);
    }
  }
  
  private boolean a(int paramInt, Camera paramCamera)
  {
    bhf localbhf = a(paramInt, paramCamera);
    if (localbhf.c != 0) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().i = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VcCamera", 2, "getCameraDisplayOrientation orientation:" + localbhf.b + ",rotation:" + localbhf.c);
    }
    this.i = j();
    this.h = k();
    if (localbhf.jdField_a_of_type_Int == 1)
    {
      paramInt = (360 - (d() + e()) % 360) % 360;
      if (localbhf.jdField_a_of_type_Int != 1) {
        break label187;
      }
    }
    label187:
    for (paramInt = (paramInt + g()) % 360;; paramInt = (paramInt + h()) % 360)
    {
      a(paramCamera, paramInt);
      jdField_a_of_type_Bhf.jdField_a_of_type_Int = localbhf.jdField_a_of_type_Int;
      jdField_a_of_type_Bhf.b = localbhf.b;
      return true;
      paramInt = (d() - e() + 360) % 360;
      break;
    }
  }
  
  private Camera.Size b(List paramList, int paramInt1, int paramInt2)
  {
    Iterator localIterator = paramList.iterator();
    Camera.Size localSize;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localSize = (Camera.Size)localIterator.next();
        if ((localSize.width == paramInt1) && (localSize.height == paramInt2))
        {
          paramList = localSize;
          if (QLog.isColorLevel())
          {
            QLog.d("VcCamera", 2, "previewsize ,w= " + paramInt1 + ",h=" + paramInt2);
            paramList = localSize;
          }
        }
      }
    }
    do
    {
      return paramList;
      if ((paramInt1 != 320) || (paramInt2 != 240)) {
        break;
      }
      localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localSize = (Camera.Size)localIterator.next();
      } while ((localSize.width != 640) || (localSize.height != 480));
      paramList = localSize;
    } while (!QLog.isColorLevel());
    QLog.d("VcCamera", 2, "previewsize ,w= " + 640 + ",h=" + 480);
    return localSize;
    if (0 == 0) {
      return a(paramList, VideoChatSettings.b, VideoChatSettings.c);
    }
    return null;
  }
  
  private Camera b()
  {
    Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localCamera != null) {}
    try
    {
      localCamera.release();
      localCamera = Camera.open();
      if (localCamera == null) {
        return null;
      }
      Camera.Parameters localParameters = localCamera.getParameters();
      localParameters.set("camera-id", 2);
      localCamera.setParameters(localParameters);
      this.jdField_a_of_type_AndroidHardwareCamera = localCamera;
      return localCamera;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 2, "trySamsungFrontCamera", localException);
      }
    }
    return null;
  }
  
  private Camera c()
  {
    Camera localCamera2 = this.jdField_a_of_type_AndroidHardwareCamera;
    Camera localCamera1;
    if (localCamera2 != null) {
      localCamera1 = localCamera2;
    }
    try
    {
      localCamera2.release();
      localCamera1 = localCamera2;
      localCamera2 = Camera.open();
      if (localCamera2 == null) {
        return null;
      }
      localCamera1 = localCamera2;
      Camera.Parameters localParameters = (Camera.Parameters)localCamera2.getClass().getMethod("getCustomParameters", new Class[0]).invoke(localCamera2, new Object[0]);
      localCamera1 = localCamera2;
      ArrayList localArrayList = a(localParameters.get("camera-sensor-values"));
      localCamera1 = localCamera2;
      Method localMethod = localCamera2.getClass().getMethod("setCustomParameters", new Class[] { localParameters.getClass() });
      if (localArrayList != null)
      {
        localCamera1 = localCamera2;
        if (localArrayList.indexOf(Integer.valueOf(1)) != -1)
        {
          localCamera1 = localCamera2;
          localParameters.set("camera-sensor", "1");
          localCamera1 = localCamera2;
          localMethod.invoke(localCamera2, new Object[] { localParameters });
          return localCamera2;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 2, "tryMotoFrontCamera", localException);
      }
      if (localCamera1 != null) {
        localCamera1.release();
      }
      return null;
    }
    return localException;
  }
  
  private boolean c()
  {
    return this.f >= 10;
  }
  
  private Camera d()
  {
    if (c()) {
      return e();
    }
    if (this.c.equalsIgnoreCase("motorola")) {
      return c();
    }
    if (this.c.equalsIgnoreCase("samsung")) {
      return b();
    }
    return null;
  }
  
  private boolean d()
  {
    this.jdField_a_of_type_AndroidHardwareCamera = d();
    if (this.jdField_a_of_type_AndroidHardwareCamera == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 2, "openFrontCamera camera == null");
      }
      jdField_a_of_type_Boolean = false;
      return false;
    }
    if (this.e == 0) {
      this.e = 2;
    }
    this.d = 1;
    jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("VcCamera", 2, "openFrontCamera success");
    }
    return true;
  }
  
  /* Error */
  private Camera e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 15
    //   3: aconst_null
    //   4: astore 16
    //   6: aconst_null
    //   7: astore 17
    //   9: aconst_null
    //   10: astore 18
    //   12: aconst_null
    //   13: astore 19
    //   15: aconst_null
    //   16: astore 20
    //   18: aconst_null
    //   19: astore 21
    //   21: aconst_null
    //   22: astore 22
    //   24: aconst_null
    //   25: astore 23
    //   27: aconst_null
    //   28: astore_3
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 304	com/tencent/av/camera/VcCamera:g	I
    //   34: aload 16
    //   36: astore 6
    //   38: aload 17
    //   40: astore 7
    //   42: aload 18
    //   44: astore 8
    //   46: aload 19
    //   48: astore 9
    //   50: aload 20
    //   52: astore 10
    //   54: aload 21
    //   56: astore 11
    //   58: aload 22
    //   60: astore 12
    //   62: aload 23
    //   64: astore 5
    //   66: ldc 193
    //   68: invokestatic 199	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   71: astore 24
    //   73: aload 16
    //   75: astore 6
    //   77: aload 17
    //   79: astore 7
    //   81: aload 18
    //   83: astore 8
    //   85: aload 19
    //   87: astore 9
    //   89: aload 20
    //   91: astore 10
    //   93: aload 21
    //   95: astore 11
    //   97: aload 22
    //   99: astore 12
    //   101: aload 23
    //   103: astore 5
    //   105: aload_0
    //   106: getfield 51	com/tencent/av/camera/VcCamera:e	I
    //   109: ifne +43 -> 152
    //   112: aload 16
    //   114: astore 6
    //   116: aload 17
    //   118: astore 7
    //   120: aload 18
    //   122: astore 8
    //   124: aload 19
    //   126: astore 9
    //   128: aload 20
    //   130: astore 10
    //   132: aload 21
    //   134: astore 11
    //   136: aload 22
    //   138: astore 12
    //   140: aload 23
    //   142: astore 5
    //   144: aload_0
    //   145: aload_0
    //   146: invokespecial 521	com/tencent/av/camera/VcCamera:i	()I
    //   149: putfield 51	com/tencent/av/camera/VcCamera:e	I
    //   152: aload 15
    //   154: astore 4
    //   156: aload 16
    //   158: astore 6
    //   160: aload 17
    //   162: astore 7
    //   164: aload 18
    //   166: astore 8
    //   168: aload 19
    //   170: astore 9
    //   172: aload 20
    //   174: astore 10
    //   176: aload 21
    //   178: astore 11
    //   180: aload 22
    //   182: astore 12
    //   184: aload 23
    //   186: astore 5
    //   188: aload_0
    //   189: getfield 51	com/tencent/av/camera/VcCamera:e	I
    //   192: iconst_1
    //   193: if_icmple +582 -> 775
    //   196: aload 16
    //   198: astore 6
    //   200: aload 17
    //   202: astore 7
    //   204: aload 18
    //   206: astore 8
    //   208: aload 19
    //   210: astore 9
    //   212: aload 20
    //   214: astore 10
    //   216: aload 21
    //   218: astore 11
    //   220: aload 22
    //   222: astore 12
    //   224: aload 23
    //   226: astore 5
    //   228: ldc 201
    //   230: invokestatic 199	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   233: astore 25
    //   235: aload 25
    //   237: ifnull +785 -> 1022
    //   240: aload 16
    //   242: astore 6
    //   244: aload 17
    //   246: astore 7
    //   248: aload 18
    //   250: astore 8
    //   252: aload 19
    //   254: astore 9
    //   256: aload 20
    //   258: astore 10
    //   260: aload 21
    //   262: astore 11
    //   264: aload 22
    //   266: astore 12
    //   268: aload 23
    //   270: astore 5
    //   272: aload 25
    //   274: invokevirtual 204	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   277: astore 13
    //   279: aload 13
    //   281: ifnull +735 -> 1016
    //   284: aload 16
    //   286: astore 6
    //   288: aload 17
    //   290: astore 7
    //   292: aload 18
    //   294: astore 8
    //   296: aload 19
    //   298: astore 9
    //   300: aload 20
    //   302: astore 10
    //   304: aload 21
    //   306: astore 11
    //   308: aload 22
    //   310: astore 12
    //   312: aload 23
    //   314: astore 5
    //   316: aload 13
    //   318: invokevirtual 208	java/lang/Object:getClass	()Ljava/lang/Class;
    //   321: ldc 210
    //   323: invokevirtual 214	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   326: astore 14
    //   328: aload 16
    //   330: astore 6
    //   332: aload 17
    //   334: astore 7
    //   336: aload 18
    //   338: astore 8
    //   340: aload 19
    //   342: astore 9
    //   344: aload 20
    //   346: astore 10
    //   348: aload 21
    //   350: astore 11
    //   352: aload 22
    //   354: astore 12
    //   356: aload 23
    //   358: astore 5
    //   360: aload 24
    //   362: ldc 218
    //   364: iconst_2
    //   365: anewarray 195	java/lang/Class
    //   368: dup
    //   369: iconst_0
    //   370: getstatic 224	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   373: aastore
    //   374: dup
    //   375: iconst_1
    //   376: aload 25
    //   378: aastore
    //   379: invokevirtual 228	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   382: astore 16
    //   384: aload 15
    //   386: astore 4
    //   388: aload 16
    //   390: ifnull +385 -> 775
    //   393: aload 15
    //   395: astore 4
    //   397: aload 25
    //   399: ifnull +376 -> 775
    //   402: aload 15
    //   404: astore 4
    //   406: aload 14
    //   408: ifnull +367 -> 775
    //   411: iconst_0
    //   412: istore_1
    //   413: aload_3
    //   414: astore 4
    //   416: aload_3
    //   417: astore 6
    //   419: aload_3
    //   420: astore 7
    //   422: aload_3
    //   423: astore 8
    //   425: aload_3
    //   426: astore 9
    //   428: aload_3
    //   429: astore 10
    //   431: aload_3
    //   432: astore 11
    //   434: aload_3
    //   435: astore 12
    //   437: aload_3
    //   438: astore 5
    //   440: iload_1
    //   441: aload_0
    //   442: getfield 51	com/tencent/av/camera/VcCamera:e	I
    //   445: if_icmpge +330 -> 775
    //   448: aload_3
    //   449: astore 6
    //   451: aload_3
    //   452: astore 7
    //   454: aload_3
    //   455: astore 8
    //   457: aload_3
    //   458: astore 9
    //   460: aload_3
    //   461: astore 10
    //   463: aload_3
    //   464: astore 11
    //   466: aload_3
    //   467: astore 12
    //   469: aload_3
    //   470: astore 5
    //   472: aload 16
    //   474: aconst_null
    //   475: iconst_2
    //   476: anewarray 4	java/lang/Object
    //   479: dup
    //   480: iconst_0
    //   481: iload_1
    //   482: invokestatic 232	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   485: aastore
    //   486: dup
    //   487: iconst_1
    //   488: aload 13
    //   490: aastore
    //   491: invokevirtual 238	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   494: pop
    //   495: aload_3
    //   496: astore 6
    //   498: aload_3
    //   499: astore 7
    //   501: aload_3
    //   502: astore 8
    //   504: aload_3
    //   505: astore 9
    //   507: aload_3
    //   508: astore 10
    //   510: aload_3
    //   511: astore 11
    //   513: aload_3
    //   514: astore 12
    //   516: aload_3
    //   517: astore 5
    //   519: aload 14
    //   521: aload 13
    //   523: invokevirtual 244	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   526: istore_2
    //   527: iload_2
    //   528: iconst_1
    //   529: if_icmpne +481 -> 1010
    //   532: aload_3
    //   533: astore 6
    //   535: aload_3
    //   536: astore 7
    //   538: aload_3
    //   539: astore 8
    //   541: aload_3
    //   542: astore 9
    //   544: aload_3
    //   545: astore 10
    //   547: aload_3
    //   548: astore 11
    //   550: aload_3
    //   551: astore 12
    //   553: aload_3
    //   554: astore 5
    //   556: aload 24
    //   558: ldc_w 522
    //   561: iconst_1
    //   562: anewarray 195	java/lang/Class
    //   565: dup
    //   566: iconst_0
    //   567: getstatic 224	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   570: aastore
    //   571: invokevirtual 228	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   574: astore 4
    //   576: aload 4
    //   578: ifnull +432 -> 1010
    //   581: aload_3
    //   582: astore 6
    //   584: aload_3
    //   585: astore 7
    //   587: aload_3
    //   588: astore 8
    //   590: aload_3
    //   591: astore 9
    //   593: aload_3
    //   594: astore 10
    //   596: aload_3
    //   597: astore 11
    //   599: aload_3
    //   600: astore 12
    //   602: aload_3
    //   603: astore 5
    //   605: aload 4
    //   607: aconst_null
    //   608: iconst_1
    //   609: anewarray 4	java/lang/Object
    //   612: dup
    //   613: iconst_0
    //   614: iload_1
    //   615: invokestatic 232	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   618: aastore
    //   619: invokevirtual 238	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   622: checkcast 309	android/hardware/Camera
    //   625: astore 4
    //   627: aload 4
    //   629: astore 5
    //   631: aload 4
    //   633: astore 6
    //   635: aload 4
    //   637: astore 7
    //   639: aload 4
    //   641: astore 8
    //   643: aload 4
    //   645: astore 9
    //   647: aload 4
    //   649: astore 10
    //   651: aload 4
    //   653: astore 11
    //   655: aload 4
    //   657: astore 12
    //   659: aload_0
    //   660: iload_1
    //   661: putfield 304	com/tencent/av/camera/VcCamera:g	I
    //   664: iload_1
    //   665: iconst_1
    //   666: iadd
    //   667: istore_1
    //   668: aload 4
    //   670: astore_3
    //   671: goto -258 -> 413
    //   674: astore 15
    //   676: aload_3
    //   677: astore 4
    //   679: aload_3
    //   680: astore 5
    //   682: aload_3
    //   683: astore 6
    //   685: aload_3
    //   686: astore 7
    //   688: aload_3
    //   689: astore 8
    //   691: aload_3
    //   692: astore 9
    //   694: aload_3
    //   695: astore 10
    //   697: aload_3
    //   698: astore 11
    //   700: aload_3
    //   701: astore 12
    //   703: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   706: ifeq -42 -> 664
    //   709: aload_3
    //   710: astore 5
    //   712: aload_3
    //   713: astore 6
    //   715: aload_3
    //   716: astore 7
    //   718: aload_3
    //   719: astore 8
    //   721: aload_3
    //   722: astore 9
    //   724: aload_3
    //   725: astore 10
    //   727: aload_3
    //   728: astore 11
    //   730: aload_3
    //   731: astore 12
    //   733: ldc 11
    //   735: iconst_2
    //   736: ldc_w 524
    //   739: aload 15
    //   741: invokestatic 526	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   744: aload_3
    //   745: astore 4
    //   747: goto -83 -> 664
    //   750: astore_3
    //   751: aload 5
    //   753: astore 4
    //   755: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   758: ifeq +17 -> 775
    //   761: ldc 11
    //   763: iconst_2
    //   764: ldc_w 528
    //   767: aload_3
    //   768: invokestatic 526	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   771: aload 5
    //   773: astore 4
    //   775: aload 4
    //   777: areturn
    //   778: astore_3
    //   779: aload 6
    //   781: astore 4
    //   783: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   786: ifeq -11 -> 775
    //   789: ldc 11
    //   791: iconst_2
    //   792: ldc_w 530
    //   795: aload_3
    //   796: invokestatic 526	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   799: aload 6
    //   801: areturn
    //   802: astore_3
    //   803: aload 7
    //   805: astore 4
    //   807: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   810: ifeq -35 -> 775
    //   813: ldc 11
    //   815: iconst_2
    //   816: ldc_w 532
    //   819: aload_3
    //   820: invokestatic 526	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   823: aload 7
    //   825: areturn
    //   826: astore_3
    //   827: aload 8
    //   829: astore 4
    //   831: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   834: ifeq -59 -> 775
    //   837: ldc 11
    //   839: iconst_2
    //   840: ldc_w 534
    //   843: aload_3
    //   844: invokestatic 526	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   847: aload 8
    //   849: areturn
    //   850: astore_3
    //   851: aload 9
    //   853: astore 4
    //   855: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   858: ifeq -83 -> 775
    //   861: ldc 11
    //   863: iconst_2
    //   864: ldc_w 536
    //   867: aload_3
    //   868: invokestatic 526	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   871: aload 9
    //   873: areturn
    //   874: astore_3
    //   875: aload 10
    //   877: astore 4
    //   879: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   882: ifeq -107 -> 775
    //   885: ldc 11
    //   887: iconst_2
    //   888: ldc_w 538
    //   891: aload_3
    //   892: invokestatic 526	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   895: aload 10
    //   897: areturn
    //   898: astore_3
    //   899: aload 11
    //   901: astore 4
    //   903: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   906: ifeq -131 -> 775
    //   909: ldc 11
    //   911: iconst_2
    //   912: ldc_w 540
    //   915: aload_3
    //   916: invokestatic 526	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   919: aload 11
    //   921: areturn
    //   922: astore_3
    //   923: aload 12
    //   925: astore 4
    //   927: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq -155 -> 775
    //   933: ldc 11
    //   935: iconst_2
    //   936: ldc_w 524
    //   939: aload_3
    //   940: invokestatic 526	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   943: aload 12
    //   945: areturn
    //   946: astore_3
    //   947: aload 6
    //   949: astore 12
    //   951: goto -28 -> 923
    //   954: astore_3
    //   955: aload 7
    //   957: astore 11
    //   959: goto -60 -> 899
    //   962: astore_3
    //   963: aload 8
    //   965: astore 10
    //   967: goto -92 -> 875
    //   970: astore_3
    //   971: goto -120 -> 851
    //   974: astore_3
    //   975: aload 10
    //   977: astore 8
    //   979: goto -152 -> 827
    //   982: astore_3
    //   983: aload 11
    //   985: astore 7
    //   987: goto -184 -> 803
    //   990: astore_3
    //   991: aload 12
    //   993: astore 6
    //   995: goto -216 -> 779
    //   998: astore_3
    //   999: goto -248 -> 751
    //   1002: astore 15
    //   1004: aload 4
    //   1006: astore_3
    //   1007: goto -331 -> 676
    //   1010: aload_3
    //   1011: astore 4
    //   1013: goto -349 -> 664
    //   1016: aconst_null
    //   1017: astore 14
    //   1019: goto -691 -> 328
    //   1022: aconst_null
    //   1023: astore 13
    //   1025: goto -746 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1028	0	this	VcCamera
    //   412	256	1	m	int
    //   526	4	2	n	int
    //   28	717	3	localObject1	Object
    //   750	18	3	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   778	18	3	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   802	18	3	localNoSuchFieldException1	java.lang.NoSuchFieldException
    //   826	18	3	localIllegalAccessException1	java.lang.IllegalAccessException
    //   850	18	3	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
    //   874	18	3	localInstantiationException1	java.lang.InstantiationException
    //   898	18	3	localSecurityException1	java.lang.SecurityException
    //   922	18	3	localException1	Exception
    //   946	1	3	localException2	Exception
    //   954	1	3	localSecurityException2	java.lang.SecurityException
    //   962	1	3	localInstantiationException2	java.lang.InstantiationException
    //   970	1	3	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
    //   974	1	3	localIllegalAccessException2	java.lang.IllegalAccessException
    //   982	1	3	localNoSuchFieldException2	java.lang.NoSuchFieldException
    //   990	1	3	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   998	1	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   1006	5	3	localObject2	Object
    //   154	858	4	localObject3	Object
    //   64	708	5	localObject4	Object
    //   36	958	6	localObject5	Object
    //   40	946	7	localObject6	Object
    //   44	934	8	localObject7	Object
    //   48	824	9	localObject8	Object
    //   52	924	10	localObject9	Object
    //   56	928	11	localObject10	Object
    //   60	932	12	localObject11	Object
    //   277	747	13	localObject12	Object
    //   326	692	14	localField	Field
    //   1	402	15	localObject13	Object
    //   674	66	15	localRuntimeException1	java.lang.RuntimeException
    //   1002	1	15	localRuntimeException2	java.lang.RuntimeException
    //   4	469	16	localMethod	Method
    //   7	326	17	localObject14	Object
    //   10	327	18	localObject15	Object
    //   13	328	19	localObject16	Object
    //   16	329	20	localObject17	Object
    //   19	330	21	localObject18	Object
    //   22	331	22	localObject19	Object
    //   25	332	23	localObject20	Object
    //   71	486	24	localClass1	Class
    //   233	165	25	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   556	576	674	java/lang/RuntimeException
    //   605	627	674	java/lang/RuntimeException
    //   659	664	750	java/lang/ClassNotFoundException
    //   703	709	750	java/lang/ClassNotFoundException
    //   733	744	750	java/lang/ClassNotFoundException
    //   66	73	778	java/lang/NoSuchMethodException
    //   105	112	778	java/lang/NoSuchMethodException
    //   144	152	778	java/lang/NoSuchMethodException
    //   188	196	778	java/lang/NoSuchMethodException
    //   228	235	778	java/lang/NoSuchMethodException
    //   272	279	778	java/lang/NoSuchMethodException
    //   316	328	778	java/lang/NoSuchMethodException
    //   360	384	778	java/lang/NoSuchMethodException
    //   440	448	778	java/lang/NoSuchMethodException
    //   472	495	778	java/lang/NoSuchMethodException
    //   519	527	778	java/lang/NoSuchMethodException
    //   556	576	778	java/lang/NoSuchMethodException
    //   605	627	778	java/lang/NoSuchMethodException
    //   66	73	802	java/lang/NoSuchFieldException
    //   105	112	802	java/lang/NoSuchFieldException
    //   144	152	802	java/lang/NoSuchFieldException
    //   188	196	802	java/lang/NoSuchFieldException
    //   228	235	802	java/lang/NoSuchFieldException
    //   272	279	802	java/lang/NoSuchFieldException
    //   316	328	802	java/lang/NoSuchFieldException
    //   360	384	802	java/lang/NoSuchFieldException
    //   440	448	802	java/lang/NoSuchFieldException
    //   472	495	802	java/lang/NoSuchFieldException
    //   519	527	802	java/lang/NoSuchFieldException
    //   556	576	802	java/lang/NoSuchFieldException
    //   605	627	802	java/lang/NoSuchFieldException
    //   66	73	826	java/lang/IllegalAccessException
    //   105	112	826	java/lang/IllegalAccessException
    //   144	152	826	java/lang/IllegalAccessException
    //   188	196	826	java/lang/IllegalAccessException
    //   228	235	826	java/lang/IllegalAccessException
    //   272	279	826	java/lang/IllegalAccessException
    //   316	328	826	java/lang/IllegalAccessException
    //   360	384	826	java/lang/IllegalAccessException
    //   440	448	826	java/lang/IllegalAccessException
    //   472	495	826	java/lang/IllegalAccessException
    //   519	527	826	java/lang/IllegalAccessException
    //   556	576	826	java/lang/IllegalAccessException
    //   605	627	826	java/lang/IllegalAccessException
    //   66	73	850	java/lang/reflect/InvocationTargetException
    //   105	112	850	java/lang/reflect/InvocationTargetException
    //   144	152	850	java/lang/reflect/InvocationTargetException
    //   188	196	850	java/lang/reflect/InvocationTargetException
    //   228	235	850	java/lang/reflect/InvocationTargetException
    //   272	279	850	java/lang/reflect/InvocationTargetException
    //   316	328	850	java/lang/reflect/InvocationTargetException
    //   360	384	850	java/lang/reflect/InvocationTargetException
    //   440	448	850	java/lang/reflect/InvocationTargetException
    //   472	495	850	java/lang/reflect/InvocationTargetException
    //   519	527	850	java/lang/reflect/InvocationTargetException
    //   556	576	850	java/lang/reflect/InvocationTargetException
    //   605	627	850	java/lang/reflect/InvocationTargetException
    //   66	73	874	java/lang/InstantiationException
    //   105	112	874	java/lang/InstantiationException
    //   144	152	874	java/lang/InstantiationException
    //   188	196	874	java/lang/InstantiationException
    //   228	235	874	java/lang/InstantiationException
    //   272	279	874	java/lang/InstantiationException
    //   316	328	874	java/lang/InstantiationException
    //   360	384	874	java/lang/InstantiationException
    //   440	448	874	java/lang/InstantiationException
    //   472	495	874	java/lang/InstantiationException
    //   519	527	874	java/lang/InstantiationException
    //   556	576	874	java/lang/InstantiationException
    //   605	627	874	java/lang/InstantiationException
    //   66	73	898	java/lang/SecurityException
    //   105	112	898	java/lang/SecurityException
    //   144	152	898	java/lang/SecurityException
    //   188	196	898	java/lang/SecurityException
    //   228	235	898	java/lang/SecurityException
    //   272	279	898	java/lang/SecurityException
    //   316	328	898	java/lang/SecurityException
    //   360	384	898	java/lang/SecurityException
    //   440	448	898	java/lang/SecurityException
    //   472	495	898	java/lang/SecurityException
    //   519	527	898	java/lang/SecurityException
    //   556	576	898	java/lang/SecurityException
    //   605	627	898	java/lang/SecurityException
    //   66	73	922	java/lang/Exception
    //   105	112	922	java/lang/Exception
    //   144	152	922	java/lang/Exception
    //   188	196	922	java/lang/Exception
    //   228	235	922	java/lang/Exception
    //   272	279	922	java/lang/Exception
    //   316	328	922	java/lang/Exception
    //   360	384	922	java/lang/Exception
    //   440	448	922	java/lang/Exception
    //   472	495	922	java/lang/Exception
    //   519	527	922	java/lang/Exception
    //   556	576	922	java/lang/Exception
    //   605	627	922	java/lang/Exception
    //   659	664	946	java/lang/Exception
    //   703	709	946	java/lang/Exception
    //   733	744	946	java/lang/Exception
    //   659	664	954	java/lang/SecurityException
    //   703	709	954	java/lang/SecurityException
    //   733	744	954	java/lang/SecurityException
    //   659	664	962	java/lang/InstantiationException
    //   703	709	962	java/lang/InstantiationException
    //   733	744	962	java/lang/InstantiationException
    //   659	664	970	java/lang/reflect/InvocationTargetException
    //   703	709	970	java/lang/reflect/InvocationTargetException
    //   733	744	970	java/lang/reflect/InvocationTargetException
    //   659	664	974	java/lang/IllegalAccessException
    //   703	709	974	java/lang/IllegalAccessException
    //   733	744	974	java/lang/IllegalAccessException
    //   659	664	982	java/lang/NoSuchFieldException
    //   703	709	982	java/lang/NoSuchFieldException
    //   733	744	982	java/lang/NoSuchFieldException
    //   659	664	990	java/lang/NoSuchMethodException
    //   703	709	990	java/lang/NoSuchMethodException
    //   733	744	990	java/lang/NoSuchMethodException
    //   66	73	998	java/lang/ClassNotFoundException
    //   105	112	998	java/lang/ClassNotFoundException
    //   144	152	998	java/lang/ClassNotFoundException
    //   188	196	998	java/lang/ClassNotFoundException
    //   228	235	998	java/lang/ClassNotFoundException
    //   272	279	998	java/lang/ClassNotFoundException
    //   316	328	998	java/lang/ClassNotFoundException
    //   360	384	998	java/lang/ClassNotFoundException
    //   440	448	998	java/lang/ClassNotFoundException
    //   472	495	998	java/lang/ClassNotFoundException
    //   519	527	998	java/lang/ClassNotFoundException
    //   556	576	998	java/lang/ClassNotFoundException
    //   605	627	998	java/lang/ClassNotFoundException
    //   659	664	1002	java/lang/RuntimeException
  }
  
  private boolean e()
  {
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera = Camera.open();
      this.d = 2;
      jdField_a_of_type_Boolean = true;
      this.g = 0;
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 2, "openBackCamera success");
      }
      return true;
    }
    catch (Exception localException)
    {
      jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
        this.jdField_a_of_type_AndroidHardwareCamera.release();
      }
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 2, "openBackCamera exception");
      }
    }
    return false;
  }
  
  private int i()
  {
    if (!MobileIssueSettings.h) {
      return KapalaiAdapterUtil.a().b();
    }
    try
    {
      int m = Integer.parseInt(Class.forName("android.hardware.Camera").getMethod("getNumberOfCameras", new Class[0]).invoke(null, (Object[])null).toString());
      return m;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 2, "GetNumberOfCamera", localException);
      }
    }
    return 1;
  }
  
  private int j()
  {
    return 0;
  }
  
  private int k()
  {
    return 0;
  }
  
  public int a(int paramInt)
  {
    byte b1;
    switch (paramInt)
    {
    default: 
      b1 = 0;
    }
    for (;;)
    {
      return ConfigSystemImpl.a(this.jdField_a_of_type_AndroidContentContext, true, false, b1) * 90;
      b1 = 0;
      continue;
      b1 = 1;
      continue;
      b1 = 2;
      continue;
      b1 = 3;
    }
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean == true) {
      return this.j;
    }
    return this.k;
  }
  
  public Camera a()
  {
    return this.jdField_a_of_type_AndroidHardwareCamera;
  }
  
  public void a(int paramInt)
  {
    jdField_a_of_type_Bhf.c = ((this.i + paramInt) % 360);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      this.j = (paramInt % 360);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 2, "mFrontCameraAngle" + this.j + "mBackCameraAngle" + this.k);
      }
      return;
      this.k = (paramInt % 360);
    }
  }
  
  public boolean a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 2, "closeCamera begin.");
      }
      if ((this.jdField_a_of_type_AndroidHardwareCamera == null) && (!jdField_a_of_type_Boolean) && (QLog.isColorLevel())) {
        QLog.d("VcCamera", 2, "Camera not open.");
      }
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        if (jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(null);
          this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
          this.jdField_a_of_type_AndroidHardwareCamera.release();
        }
        this.jdField_a_of_type_AndroidHardwareCamera = null;
      }
      jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("VcCamera", 2, "closeCamera end.");
      }
      return true;
    }
    finally {}
  }
  
  public boolean a(SurfaceHolder paramSurfaceHolder)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VcCamera", 2, "openCamera begin.");
        }
        if (jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          if (QLog.isColorLevel()) {
            QLog.d("VcCamera", 2, "openCamera end.");
          }
          return bool1;
        }
        if (this.jdField_a_of_type_AndroidContentContext == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VcCamera", 2, "openCamera context == null");
          }
        }
        else if (this.d == 0)
        {
          if ((!d()) && (!e()))
          {
            if (!QLog.isColorLevel()) {
              break label291;
            }
            QLog.d("VcCamera", 2, "openCamera failed");
            break label291;
          }
          if (this.jdField_a_of_type_AndroidHardwareCamera == null)
          {
            if (!QLog.isColorLevel()) {
              break label296;
            }
            QLog.d("VcCamera", 2, "openCamera camera == null");
            break label296;
          }
          a(VideoChatSettings.b, VideoChatSettings.c);
          bool1 = true;
          if (bool1) {
            continue;
          }
          this.d = 0;
        }
        switch (this.d)
        {
        case 1: 
          if (!d()) {
            break label301;
          }
          a(VideoChatSettings.b, VideoChatSettings.c);
          bool1 = true;
          break;
        case 2: 
          if (!e()) {
            break label301;
          }
          a(VideoChatSettings.b, VideoChatSettings.c);
          bool1 = true;
          continue;
          try
          {
            this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback);
            this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(paramSurfaceHolder);
            this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
            bool1 = bool2;
          }
          catch (Exception paramSurfaceHolder)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VcCamera", 2, "setPreviewDisplay error", paramSurfaceHolder);
            }
            bool1 = false;
          }
          continue;
          bool1 = false;
        }
      }
      finally {}
      continue;
      label291:
      boolean bool1 = false;
      continue;
      label296:
      bool1 = false;
      continue;
      label301:
      bool1 = false;
    }
  }
  
  public int b()
  {
    return this.i;
  }
  
  public int b(int paramInt)
  {
    byte b1;
    switch (paramInt)
    {
    default: 
      b1 = 0;
    }
    for (;;)
    {
      return ConfigSystemImpl.a(this.jdField_a_of_type_AndroidContentContext, false, false, b1) * 90;
      b1 = 0;
      continue;
      b1 = 1;
      continue;
      b1 = 2;
      continue;
      b1 = 3;
    }
  }
  
  public boolean b()
  {
    if (this.d == 0) {}
    while (this.d == 1) {
      return true;
    }
    return false;
  }
  
  /* Error */
  public boolean b(SurfaceHolder paramSurfaceHolder)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/tencent/av/camera/VcCamera:e	I
    //   6: iconst_2
    //   7: if_icmplt +14 -> 21
    //   10: aload_0
    //   11: getfield 45	com/tencent/av/camera/VcCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   14: astore 5
    //   16: aload 5
    //   18: ifnonnull +9 -> 27
    //   21: iconst_0
    //   22: istore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_3
    //   26: ireturn
    //   27: new 125	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 611
    //   37: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: astore 6
    //   42: aload_0
    //   43: getfield 49	com/tencent/av/camera/VcCamera:d	I
    //   46: iconst_1
    //   47: if_icmpne +99 -> 146
    //   50: ldc_w 613
    //   53: astore 5
    //   55: ldc 11
    //   57: aload 6
    //   59: aload 5
    //   61: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 618	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   70: pop
    //   71: aload_0
    //   72: invokevirtual 620	com/tencent/av/camera/VcCamera:a	()Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 49	com/tencent/av/camera/VcCamera:d	I
    //   80: istore_2
    //   81: iload_2
    //   82: tableswitch	default:+22 -> 104, 1:+72->154, 2:+95->177
    //   105: istore 4
    //   107: iload 4
    //   109: istore_3
    //   110: iload 4
    //   112: ifeq -89 -> 23
    //   115: aload_0
    //   116: getfield 45	com/tencent/av/camera/VcCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   119: aload_0
    //   120: getfield 68	com/tencent/av/camera/VcCamera:jdField_a_of_type_AndroidHardwareCamera$PreviewCallback	Landroid/hardware/Camera$PreviewCallback;
    //   123: invokevirtual 578	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   126: aload_0
    //   127: getfield 45	com/tencent/av/camera/VcCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   130: aload_1
    //   131: invokevirtual 604	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   134: aload_0
    //   135: getfield 45	com/tencent/av/camera/VcCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   138: invokevirtual 607	android/hardware/Camera:startPreview	()V
    //   141: iconst_1
    //   142: istore_3
    //   143: goto -120 -> 23
    //   146: ldc_w 622
    //   149: astore 5
    //   151: goto -96 -> 55
    //   154: aload_0
    //   155: invokespecial 594	com/tencent/av/camera/VcCamera:e	()Z
    //   158: ifeq -54 -> 104
    //   161: aload_0
    //   162: getstatic 349	com/tencent/av/camera/VideoChatSettings:b	I
    //   165: getstatic 350	com/tencent/av/camera/VideoChatSettings:c	I
    //   168: invokespecial 600	com/tencent/av/camera/VcCamera:a	(II)V
    //   171: iconst_1
    //   172: istore 4
    //   174: goto -67 -> 107
    //   177: aload_0
    //   178: invokespecial 592	com/tencent/av/camera/VcCamera:d	()Z
    //   181: ifeq -77 -> 104
    //   184: aload_0
    //   185: getstatic 349	com/tencent/av/camera/VideoChatSettings:b	I
    //   188: getstatic 350	com/tencent/av/camera/VideoChatSettings:c	I
    //   191: invokespecial 600	com/tencent/av/camera/VcCamera:a	(II)V
    //   194: iconst_1
    //   195: istore 4
    //   197: goto -90 -> 107
    //   200: astore_1
    //   201: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +13 -> 217
    //   207: ldc 11
    //   209: iconst_2
    //   210: ldc_w 609
    //   213: aload_1
    //   214: invokestatic 425	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: iconst_0
    //   218: istore_3
    //   219: goto -196 -> 23
    //   222: astore_1
    //   223: aload_0
    //   224: monitorexit
    //   225: aload_1
    //   226: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	VcCamera
    //   0	227	1	paramSurfaceHolder	SurfaceHolder
    //   80	2	2	m	int
    //   22	197	3	bool1	boolean
    //   105	91	4	bool2	boolean
    //   14	136	5	localObject	Object
    //   40	18	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   115	141	200	java/lang/Exception
    //   2	16	222	finally
    //   27	50	222	finally
    //   55	81	222	finally
    //   115	141	222	finally
    //   154	171	222	finally
    //   177	194	222	finally
    //   201	217	222	finally
  }
  
  public int c()
  {
    return this.h;
  }
  
  /* Error */
  public boolean c(SurfaceHolder paramSurfaceHolder)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/tencent/av/camera/VcCamera:e	I
    //   6: iconst_2
    //   7: if_icmplt +14 -> 21
    //   10: aload_0
    //   11: getfield 45	com/tencent/av/camera/VcCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   14: astore 5
    //   16: aload 5
    //   18: ifnonnull +9 -> 27
    //   21: iconst_0
    //   22: istore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_3
    //   26: ireturn
    //   27: new 125	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 611
    //   37: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: astore 6
    //   42: aload_0
    //   43: getfield 49	com/tencent/av/camera/VcCamera:d	I
    //   46: iconst_1
    //   47: if_icmpne +99 -> 146
    //   50: ldc_w 613
    //   53: astore 5
    //   55: ldc 11
    //   57: aload 6
    //   59: aload 5
    //   61: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 618	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   70: pop
    //   71: aload_0
    //   72: invokevirtual 620	com/tencent/av/camera/VcCamera:a	()Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 49	com/tencent/av/camera/VcCamera:d	I
    //   80: istore_2
    //   81: iload_2
    //   82: tableswitch	default:+22 -> 104, 1:+95->177, 2:+72->154
    //   105: istore 4
    //   107: iload 4
    //   109: istore_3
    //   110: iload 4
    //   112: ifeq -89 -> 23
    //   115: aload_0
    //   116: getfield 45	com/tencent/av/camera/VcCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   119: aload_0
    //   120: getfield 68	com/tencent/av/camera/VcCamera:jdField_a_of_type_AndroidHardwareCamera$PreviewCallback	Landroid/hardware/Camera$PreviewCallback;
    //   123: invokevirtual 578	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   126: aload_0
    //   127: getfield 45	com/tencent/av/camera/VcCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   130: aload_1
    //   131: invokevirtual 604	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   134: aload_0
    //   135: getfield 45	com/tencent/av/camera/VcCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   138: invokevirtual 607	android/hardware/Camera:startPreview	()V
    //   141: iconst_1
    //   142: istore_3
    //   143: goto -120 -> 23
    //   146: ldc_w 622
    //   149: astore 5
    //   151: goto -96 -> 55
    //   154: aload_0
    //   155: invokespecial 594	com/tencent/av/camera/VcCamera:e	()Z
    //   158: ifeq -54 -> 104
    //   161: aload_0
    //   162: getstatic 349	com/tencent/av/camera/VideoChatSettings:b	I
    //   165: getstatic 350	com/tencent/av/camera/VideoChatSettings:c	I
    //   168: invokespecial 600	com/tencent/av/camera/VcCamera:a	(II)V
    //   171: iconst_1
    //   172: istore 4
    //   174: goto -67 -> 107
    //   177: aload_0
    //   178: invokespecial 592	com/tencent/av/camera/VcCamera:d	()Z
    //   181: ifeq -77 -> 104
    //   184: aload_0
    //   185: getstatic 349	com/tencent/av/camera/VideoChatSettings:b	I
    //   188: getstatic 350	com/tencent/av/camera/VideoChatSettings:c	I
    //   191: invokespecial 600	com/tencent/av/camera/VcCamera:a	(II)V
    //   194: iconst_1
    //   195: istore 4
    //   197: goto -90 -> 107
    //   200: astore_1
    //   201: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +13 -> 217
    //   207: ldc 11
    //   209: iconst_2
    //   210: ldc_w 609
    //   213: aload_1
    //   214: invokestatic 425	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: iconst_0
    //   218: istore_3
    //   219: goto -196 -> 23
    //   222: astore_1
    //   223: aload_0
    //   224: monitorexit
    //   225: aload_1
    //   226: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	VcCamera
    //   0	227	1	paramSurfaceHolder	SurfaceHolder
    //   80	2	2	m	int
    //   22	197	3	bool1	boolean
    //   105	91	4	bool2	boolean
    //   14	136	5	localObject	Object
    //   40	18	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   115	141	200	java/lang/Exception
    //   2	16	222	finally
    //   27	50	222	finally
    //   55	81	222	finally
    //   115	141	222	finally
    //   154	171	222	finally
    //   177	194	222	finally
    //   201	217	222	finally
  }
  
  public int d()
  {
    if (jdField_a_of_type_Bhf.b == -1)
    {
      if (this.d == 1) {
        return 270;
      }
      if (this.d == 2) {
        return 90;
      }
    }
    return jdField_a_of_type_Bhf.b;
  }
  
  public int e()
  {
    if (jdField_a_of_type_Bhf.c == -1) {
      return 0;
    }
    return jdField_a_of_type_Bhf.c;
  }
  
  public int f()
  {
    return i();
  }
  
  int g()
  {
    return 360 - ConfigSystemImpl.a(this.jdField_a_of_type_AndroidContentContext, true, true, (byte)0) * 90;
  }
  
  int h()
  {
    return ConfigSystemImpl.a(this.jdField_a_of_type_AndroidContentContext, false, true, (byte)0) * 90;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.camera.VcCamera
 * JD-Core Version:    0.7.0.1
 */