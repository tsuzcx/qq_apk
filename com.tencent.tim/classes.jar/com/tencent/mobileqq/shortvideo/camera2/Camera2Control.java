package com.tencent.mobileqq.shortvideo.camera2;

import aaqi;
import aeah;
import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.PreviewCallback;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import anha;
import anhb;
import anhc;
import anhd;
import anhe;
import anhf;
import anhg;
import anhj;
import anhk;
import anhl;
import anij.b;
import anim.e;
import anim.g;
import aqhu;
import axiy;
import com.samsung.android.sdk.camera.SCamera;
import com.samsung.android.sdk.camera.SCameraCaptureProcessor;
import com.samsung.android.sdk.camera.SCameraCaptureProcessor.CaptureParameter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<[I>;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import wja;

@TargetApi(23)
public class Camera2Control
{
  private static Camera2Control jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control;
  private static boolean cFW;
  private static boolean cFX;
  private static boolean cFY;
  private static boolean cFZ;
  private static String cdN = "";
  private static String cdO = "";
  public static String cdP;
  private static int dFW = -1;
  private static int dFX;
  private static HashMap<String, a> np = new HashMap();
  private HandlerThread V;
  private Camera.PreviewCallback jdField_a_of_type_AndroidHardwareCamera$PreviewCallback;
  public CameraCaptureSession.CaptureCallback a;
  private CameraCaptureSession jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
  private CameraDevice jdField_a_of_type_AndroidHardwareCamera2CameraDevice;
  private CaptureRequest.Builder jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder;
  private CaptureRequest jdField_a_of_type_AndroidHardwareCamera2CaptureRequest;
  private ImageReader jdField_a_of_type_AndroidMediaImageReader;
  private Range<Integer> jdField_a_of_type_AndroidUtilRange;
  private anhl jdField_a_of_type_Anhl = new anhl(this);
  private anij.b jdField_a_of_type_Anij$b;
  private SCameraCaptureProcessor jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor;
  private a jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$a;
  public b a;
  private c jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$c;
  private Semaphore jdField_a_of_type_JavaUtilConcurrentSemaphore = new Semaphore(1);
  private boolean aNE;
  private long alf;
  private long alg;
  private boolean aqw;
  private CameraCaptureSession.CaptureCallback jdField_b_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback = new anhe(this);
  private CaptureRequest jdField_b_of_type_AndroidHardwareCamera2CaptureRequest;
  private anij.b jdField_b_of_type_Anij$b;
  private anij.b c;
  private Rect cB = new Rect(0, 0, 1, 1);
  private Rect cC;
  private boolean cGa;
  private boolean cGb;
  private boolean cGc;
  public boolean cGd;
  private int dFY = -1;
  private int dFZ = -1;
  private int dGa;
  private Handler dq;
  private ImageReader mImageReader;
  private SurfaceTexture mSurfaceTexture;
  private int zoom = -1;
  
  public static int Js()
  {
    if (cFY) {
      return dFW;
    }
    int j = -2;
    int i = j;
    CameraManager localCameraManager;
    int k;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localCameraManager = (CameraManager)BaseApplicationImpl.getApplication().getSystemService("camera");
      k = j;
    }
    for (;;)
    {
      int m;
      try
      {
        String[] arrayOfString = localCameraManager.getCameraIdList();
        i = j;
        k = j;
        if (arrayOfString.length > 0)
        {
          k = j;
          int n = arrayOfString.length;
          m = 0;
          i = j;
          if (m < n)
          {
            k = j;
            localObject = localCameraManager.getCameraCharacteristics(arrayOfString[m]);
            k = j;
            Integer localInteger = (Integer)((CameraCharacteristics)localObject).get(CameraCharacteristics.LENS_FACING);
            if (localInteger != null)
            {
              k = j;
              if (localInteger.intValue() == 2)
              {
                i = j;
                break label249;
              }
            }
            k = j;
            localObject = (Integer)((CameraCharacteristics)localObject).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            k = j;
            anhj.dH(1, "[Camera2]initCamera2SupportLevel supportLevel:" + localObject);
            if (localObject != null) {
              continue;
            }
            i = -1;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int i1;
        i = k;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Camera2Control", 2, "[Camera2]initCamera2SupportLevel exception:", localThrowable);
        i = k;
        continue;
      }
      dFW = i;
      cFY = true;
      return dFW;
      k = j;
      j = ((Integer)localObject).intValue();
      i = j;
      k = j;
      if (((Integer)localObject).intValue() != 1)
      {
        k = j;
        i1 = ((Integer)localObject).intValue();
        i = j;
        if (i1 != 3)
        {
          i = j;
          label249:
          m += 1;
          j = i;
        }
      }
    }
  }
  
  private void Qw(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$a = ((a)np.get(paramString));
    }
  }
  
  public static Camera2Control a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control == null) {
        jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control = new Camera2Control();
      }
      return jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control;
    }
    finally {}
  }
  
  private static int[] a(List<int[]> paramList)
  {
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<int[]>)localObject;
    if (localIterator.hasNext())
    {
      int[] arrayOfInt = (int[])localIterator.next();
      if (paramList == null) {
        localObject = arrayOfInt;
      }
      for (;;)
      {
        paramList = (List<int[]>)localObject;
        break;
        if (arrayOfInt[0] <= 15)
        {
          localObject = arrayOfInt;
          if (arrayOfInt[1] - arrayOfInt[0] > paramList[1] - paramList[0]) {}
        }
        else
        {
          localObject = paramList;
        }
      }
    }
    return paramList;
  }
  
  private static int[] a(List<int[]> paramList, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      int[] arrayOfInt = (int[])localIterator.next();
      if (arrayOfInt[1] >= paramInt) {
        ((List)localObject2).add(arrayOfInt);
      }
    }
    localIterator = ((List)localObject2).iterator();
    paramInt = 0;
    if (localIterator.hasNext())
    {
      localObject2 = (int[])localIterator.next();
      int i = localObject2[1] - localObject2[0];
      if (i <= paramInt) {
        break label129;
      }
      localObject1 = localObject2;
      paramInt = i;
    }
    label129:
    for (;;)
    {
      break;
      if (localObject1 != null) {
        return localObject1;
      }
      return a(paramList);
    }
  }
  
  public static boolean awW()
  {
    boolean bool2 = true;
    if (cFX) {
      return cFW;
    }
    int i = Js();
    boolean bool1 = bool2;
    if (i != 1) {
      if (i != 3) {
        break label38;
      }
    }
    label38:
    for (bool1 = bool2;; bool1 = false)
    {
      cFW = bool1;
      return cFW;
    }
  }
  
  public static boolean awX()
  {
    return (dFX > 0) && (!TextUtils.isEmpty(cdO));
  }
  
  public static boolean awY()
  {
    return (dFX > 0) && (!TextUtils.isEmpty(cdN));
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
  
  private static void dPB()
  {
    if (cFZ) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        if ((VersionUtils.isM()) && (awW()))
        {
          CameraManager localCameraManager = (CameraManager)BaseApplicationImpl.getApplication().getSystemService("camera");
          String[] arrayOfString = localCameraManager.getCameraIdList();
          int j = arrayOfString.length;
          i = 0;
          if (i >= j) {
            break label216;
          }
          String str = arrayOfString[i];
          CameraCharacteristics localCameraCharacteristics = localCameraManager.getCameraCharacteristics(str);
          Integer localInteger = (Integer)localCameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
          if ((localInteger != null) && (localInteger.intValue() == 0) && ("1".equals(str)))
          {
            np.put(str, new a(str, localCameraCharacteristics));
            cdO = str;
            dFX += 1;
          }
          else if ((localInteger != null) && (localInteger.intValue() == 1) && ("0".equals(str)))
          {
            np.put(str, new a(str, localCameraCharacteristics));
            cdN = str;
            dFX += 1;
          }
        }
      }
      catch (Exception localException)
      {
        dFX = 1;
        cdN = "1";
        anhj.dH(2, "[Camera2]initCamera2Ability exception!");
      }
      for (;;)
      {
        cFZ = true;
        return;
        label216:
        anhj.dH(1, "[Camera2]initCamera2Ability front:" + cdO + ", back:" + cdN);
      }
      i += 1;
    }
  }
  
  private void dPC()
  {
    this.mImageReader = ImageReader.newInstance(this.jdField_b_of_type_Anij$b.width, this.jdField_b_of_type_Anij$b.height, 256, 2);
    this.mImageReader.setOnImageAvailableListener(new anhc(this), this.dq);
    this.jdField_a_of_type_AndroidMediaImageReader = ImageReader.newInstance(this.c.width, this.c.height, 35, 2);
    this.jdField_a_of_type_AndroidMediaImageReader.setOnImageAvailableListener(new anhd(this), null);
  }
  
  private void dPD()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice == null) {
      return;
    }
    for (;;)
    {
      try
      {
        CameraCaptureSession localCameraCaptureSession = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
        if (this.cGd)
        {
          CaptureRequest localCaptureRequest1 = this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.buildCaptureRequest(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder);
          localCameraCaptureSession.setRepeatingRequest(localCaptureRequest1, null, null);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        anhj.dH(2, "[Camera2]updatePreview exp:" + localException);
        return;
      }
      CaptureRequest localCaptureRequest2 = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build();
    }
  }
  
  private void dPG()
  {
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      this.jdField_a_of_type_Anhl.setState(1);
      CameraCaptureSession localCameraCaptureSession = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
      if (this.cGd) {}
      for (CaptureRequest localCaptureRequest = this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.buildCaptureRequest(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder);; localCaptureRequest = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build())
      {
        localCameraCaptureSession.capture(localCaptureRequest, this.jdField_a_of_type_Anhl, this.dq);
        return;
      }
      return;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      localCameraAccessException.printStackTrace();
    }
  }
  
  private void dPH()
  {
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
      this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
      CameraCaptureSession localCameraCaptureSession = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
      if (this.cGd)
      {
        localCaptureRequest = this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.buildCaptureRequest(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder);
        localCameraCaptureSession.capture(localCaptureRequest, null, null);
        localCameraCaptureSession = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
        if (!this.cGd) {
          break label97;
        }
      }
      label97:
      for (CaptureRequest localCaptureRequest = this.jdField_b_of_type_AndroidHardwareCamera2CaptureRequest;; localCaptureRequest = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest)
      {
        localCameraCaptureSession.setRepeatingRequest(localCaptureRequest, null, null);
        return;
        localCaptureRequest = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build();
        break;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void dPK()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession != null)
    {
      this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession.close();
      this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession = null;
    }
  }
  
  private void dPL()
  {
    this.V = new HandlerThread("Camera2_Background_Thread");
    this.V.start();
    this.dq = new Handler(this.V.getLooper());
  }
  
  private void dPM()
  {
    this.V.quitSafely();
    try
    {
      this.V.join();
      this.V = null;
      this.dq = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void dPN()
  {
    boolean bool1 = true;
    if ((wja.Rb()) && (Build.VERSION.SDK_INT >= 28)) {}
    try
    {
      boolean bool2;
      boolean bool3;
      if ((!TextUtils.isEmpty(cdO)) && (!TextUtils.isEmpty(cdN)))
      {
        bool2 = SCamera.getInstance().isFeatureEnabled(BaseApplicationImpl.getApplication(), cdO, 1);
        bool3 = SCamera.getInstance().isFeatureEnabled(BaseApplicationImpl.getApplication(), cdN, 1);
        if ((!bool2) || (!bool3)) {
          break label208;
        }
      }
      for (;;)
      {
        this.cGd = bool1;
        Size localSize = (Size)Collections.max(Arrays.asList(((StreamConfigurationMap)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$a.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(256)), new d());
        if (this.cGd)
        {
          this.dGa = (localSize.getHeight() * localSize.getWidth());
          this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor = SCameraCaptureProcessor.getInstance();
          this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.initialize(BaseApplicationImpl.getApplication(), cdP, localSize);
        }
        anhj.dH(1, "[Camera2]openCamera2 Samsung Sfront:" + bool2 + ", Sback:" + bool3 + ", picSize:" + localSize.toString());
        return;
        label208:
        bool1 = false;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      anhj.dH(2, "[Camera2]openCamera2 Samsung Phone e:" + localThrowable.getCause());
      this.cGd = false;
    }
  }
  
  public static String fi(int paramInt)
  {
    String str = "1";
    switch (paramInt)
    {
    default: 
      str = cdN;
    }
    do
    {
      do
      {
        return str;
      } while (!awX());
      return cdO;
    } while (!awY());
    return cdN;
  }
  
  private int jp(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      return (((Integer)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$a.a.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue() - paramInt + 360) % 360;
      paramInt = 0;
      continue;
      paramInt = 90;
      continue;
      paramInt = 180;
      continue;
      paramInt = 270;
    }
  }
  
  public boolean EQ()
  {
    return this.cGa;
  }
  
  public void PJ(boolean paramBoolean)
  {
    boolean bool = false;
    if ((!this.aNE) || (this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder == null))
    {
      anhj.dH(1, "[Camera2]setFlashOn error status!");
      return;
    }
    if ((paramBoolean) && (this.dFZ != 2))
    {
      this.dFZ = 2;
      bool = true;
    }
    for (;;)
    {
      anhj.dH(1, "[Camera2]setFlashOn: " + paramBoolean + ", mode:" + this.dFZ + ", needUpdateView:" + bool);
      if ((!bool) || (this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder == null)) {
        break;
      }
      this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.dFZ));
      dPD();
      return;
      if (!paramBoolean)
      {
        this.dFZ = 0;
        bool = true;
      }
    }
  }
  
  public int a(int paramInt, b paramb)
  {
    if (aaqi.WS())
    {
      anhj.dH(2, "[Camera2]openCamera2 AVcamera2Used!");
      return -101;
    }
    if ((this.aqw) || (this.cGa))
    {
      anhj.dH(2, "[Camera2]openCamera2 hasOpened!");
      return -104;
    }
    this.cGa = true;
    long l = System.currentTimeMillis();
    if (paramb == null)
    {
      anhj.dH(2, "[Camera2]openCamera2 params Error!");
      return -103;
    }
    dPB();
    a(paramb);
    dPL();
    CameraManager localCameraManager = (CameraManager)BaseApplicationImpl.getApplication().getSystemService("camera");
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentSemaphore.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
        throw new Exception("[Camera2]openCamera2 time out waiting to lock camera opening.");
      }
    }
    catch (Exception paramb)
    {
      anhj.dH(2, "[Camera2]openCamera2 exception:" + paramb);
      axiy.i("Camera2Control", "【Camera2 Open】openCamera2 exception:" + paramb);
      this.aqw = false;
      this.cGa = false;
      this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice = null;
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$b != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$b.UT(-102);
      }
    }
    for (;;)
    {
      return 0;
      String str = fi(paramInt);
      cdP = str;
      Qw(str);
      dPN();
      anha localanha = new anha(this, l);
      axiy.i("Camera2Control", "【Camera2 Open】");
      paramb = localanha;
      if (this.cGd) {
        paramb = this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.createStateCallback(localanha, this.dq);
      }
      localCameraManager.openCamera(str, paramb, this.dq);
    }
  }
  
  public Rect a(anim.e parame)
  {
    if ((parame == null) || (parame.a == null)) {
      return null;
    }
    double d5 = parame.a.x;
    double d4 = parame.a.y;
    parame.a.mOrientation = jp(parame.a.mOrientation);
    int j = this.jdField_a_of_type_Anij$b.width;
    int i = this.jdField_a_of_type_Anij$b.height;
    if ((90 == parame.a.mOrientation) || (270 == parame.a.mOrientation))
    {
      j = this.jdField_a_of_type_Anij$b.height;
      i = this.jdField_a_of_type_Anij$b.width;
    }
    double d2;
    double d1;
    double d3;
    if (parame.a.screenWidth * i > parame.a.dGb * j)
    {
      d2 = parame.a.screenWidth * 1.0D / j;
      d1 = (i - parame.a.dGb / d2) / 2.0D;
      d3 = 0.0D;
      d3 += d5 / d2;
      d1 += d4 / d2;
      if (90 != parame.a.mOrientation) {
        break label552;
      }
      d2 = this.jdField_a_of_type_Anij$b.height;
      d3 = d2 - d3;
      d2 = d1;
      d1 = d3;
    }
    for (;;)
    {
      label227:
      label239:
      Rect localRect;
      if (this.cGd)
      {
        parame = this.jdField_b_of_type_AndroidHardwareCamera2CaptureRequest;
        localRect = (Rect)parame.get(CaptureRequest.SCALER_CROP_REGION);
        parame = localRect;
        if (localRect == null)
        {
          anhj.dH(2, "[Camera2]getMeteringRect can't get crop region");
          parame = this.cB;
        }
        i = parame.width();
        j = parame.height();
        if (this.jdField_a_of_type_Anij$b.height * i <= this.jdField_a_of_type_Anij$b.width * j) {
          break label591;
        }
        d4 = j * 1.0D / this.jdField_a_of_type_Anij$b.height;
        d3 = 0.0D;
        d5 = (i - this.jdField_a_of_type_Anij$b.width * d4) / 2.0D;
      }
      for (;;)
      {
        d2 = d2 * d4 + d5 + parame.left;
        d1 = d1 * d4 + d3 + parame.top;
        localRect = new Rect();
        localRect.left = clamp((int)(d2 - 0.1D / 2.0D * parame.width()), 0, parame.width());
        localRect.right = clamp((int)(d2 + 0.1D / 2.0D * parame.width()), 0, parame.width());
        localRect.top = clamp((int)(d1 - 0.1D / 2.0D * parame.height()), 0, parame.height());
        localRect.bottom = clamp((int)(d1 + 0.1D / 2.0D * parame.height()), 0, parame.height());
        return localRect;
        d2 = parame.a.dGb * 1.0D / i;
        d3 = (j - parame.a.screenWidth / d2) / 2.0D;
        d1 = 0.0D;
        break;
        label552:
        if (270 != parame.a.mOrientation) {
          break label634;
        }
        d2 = this.jdField_a_of_type_Anij$b.width - d1;
        d1 = d3;
        break label227;
        parame = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest;
        break label239;
        label591:
        d4 = i * 1.0D / this.jdField_a_of_type_Anij$b.width;
        d5 = 0.0D;
        d3 = (j - this.jdField_a_of_type_Anij$b.height * d4) / 2.0D;
      }
      label634:
      d2 = d3;
    }
  }
  
  public anij.b a()
  {
    return this.c;
  }
  
  public anij.b a(anij.b paramb)
  {
    if ((paramb == null) || (paramb.width <= 0) || (paramb.height <= 0))
    {
      anhj.dH(2, "[Camera2] setViewSize params error!");
      return null;
    }
    c(paramb);
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2]setViewSize:" + paramb.toString());
    }
    return this.c;
  }
  
  public a a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$a;
  }
  
  public void a(Camera.PreviewCallback paramPreviewCallback)
  {
    this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback = paramPreviewCallback;
  }
  
  public void a(anim.e parame)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice == null) {
      return;
    }
    if ((!this.aNE) || (this.cGb))
    {
      anhj.dH(2, "[Camera2] autoFocus not preview, mPreview:" + this.aNE + ", mIsAutoFocusing:" + this.cGb);
      return;
    }
    this.cGb = true;
    this.cB = ((Rect)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$a.a.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    Object localObject = a(parame);
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[] { new MeteringRectangle((Rect)localObject, 1000) });
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[] { new MeteringRectangle((Rect)localObject, 1000) });
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.setTag(parame);
        localObject = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
        if (this.cGd)
        {
          parame = this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.buildCaptureRequest(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder);
          ((CameraCaptureSession)localObject).setRepeatingRequest(parame, this.jdField_b_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback, this.dq);
          return;
        }
      }
      catch (Exception parame)
      {
        anhj.dH(2, "[Camera2] autoFocus e:" + parame);
        parame.printStackTrace();
        return;
      }
      parame = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build();
    }
  }
  
  public void a(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$b = paramb;
  }
  
  public void a(c paramc)
  {
    if (!this.aqw)
    {
      anhj.dH(2, "[Camera2] camera not open");
      return;
    }
    if (this.cGc)
    {
      anhj.dH(2, "[Camera2] taking status!");
      return;
    }
    anhj.dH(1, "[Camera2] takePicture request!");
    if (paramc == null)
    {
      anhj.dH(2, "[Camera2] takePicture request exception!");
      return;
    }
    this.cGc = true;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$c = paramc;
    if (this.cGb)
    {
      anhj.dH(1, "[Camera2] takePicture AutoFocusing!");
      dPI();
      return;
    }
    dPG();
  }
  
  public boolean a(anij.b paramb)
  {
    if ((paramb == null) || (paramb.width <= 0) || (paramb.height <= 0))
    {
      anhj.dH(2, "[Camera2] setPreviewSize params error!");
      return false;
    }
    this.jdField_a_of_type_Anij$b = paramb;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2]setPreviewSize:" + paramb.toString());
    }
    return true;
  }
  
  public boolean a(anim.g paramg)
  {
    if (!this.aqw)
    {
      anhj.dH(2, "[Camera2] setCamera2ParamOnce mIsOpened:" + this.aqw);
      return false;
    }
    if ((paramg == null) || (paramg.jdField_a_of_type_Anij$b == null) || (paramg.f == null) || (paramg.c == null))
    {
      anhj.dH(2, "[Camera2] setCamera2ParamOnce error!");
      return false;
    }
    anhj.dH(1, "[Camera2] setCamera2ParamOnce!");
    a(paramg.jdField_a_of_type_Anij$b);
    b(paramg.f);
    b(paramg.c);
    return true;
  }
  
  public anij.b b()
  {
    return this.jdField_a_of_type_Anij$b;
  }
  
  public void b(anij.b paramb)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[Camera2]setDarkModeSize:");
      if (paramb == null) {
        break label49;
      }
    }
    label49:
    for (String str = paramb.toString();; str = "")
    {
      QLog.i("Camera2Control", 2, str);
      this.c = paramb;
      return;
    }
  }
  
  public boolean b(anij.b paramb)
  {
    if ((paramb == null) || (paramb.width <= 0) || (paramb.height <= 0))
    {
      anhj.dH(2, "[Camera2] setRawPictureSize params error!");
      return false;
    }
    this.jdField_b_of_type_Anij$b = paramb;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2]setRawPictureSize:" + paramb.toString());
    }
    return true;
  }
  
  public void c(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.acquire();
      if ((this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice == null) || (!this.aqw))
      {
        anhj.dH(2, "[Camera2] startPreview mCameraDevice null!");
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$b != null) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$b.UT(-203);
        }
        this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
        return;
      }
      if (paramSurfaceTexture == null)
      {
        anhj.dH(2, "[Camera2] startPreview params exception!");
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$b != null) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$b.UT(-203);
        }
        this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
        return;
      }
    }
    catch (Exception paramSurfaceTexture)
    {
      anhj.dH(2, "[Camera2]startPreview exception:" + paramSurfaceTexture);
      this.aNE = false;
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$b != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$b.UT(-202);
        return;
        d(paramSurfaceTexture);
        dPC();
        dPK();
        this.mSurfaceTexture.setDefaultBufferSize(this.jdField_a_of_type_Anij$b.width, this.jdField_a_of_type_Anij$b.height);
        paramSurfaceTexture = new Surface(this.mSurfaceTexture);
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder = this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.createCaptureRequest(3);
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.addTarget(paramSurfaceTexture);
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.addTarget(this.jdField_a_of_type_AndroidMediaImageReader.getSurface());
        anhb localanhb = new anhb(this);
        if (this.cGd)
        {
          this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.createCaptureSession(this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.createSessionConfiguration(Arrays.asList(new OutputConfiguration[] { new OutputConfiguration(paramSurfaceTexture), new OutputConfiguration(this.jdField_a_of_type_AndroidMediaImageReader.getSurface()) }), localanhb, this.dq));
          return;
        }
        this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.createCaptureSession(Arrays.asList(new Surface[] { paramSurfaceTexture, this.jdField_a_of_type_AndroidMediaImageReader.getSurface(), this.mImageReader.getSurface() }), localanhb, this.dq);
      }
    }
  }
  
  public void c(anij.b paramb)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = (StreamConfigurationMap)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$a.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject != null)
        {
          Size[] arrayOfSize = ((StreamConfigurationMap)localObject).getOutputSizes(35);
          if (arrayOfSize != null)
          {
            localObject = arrayOfSize[0];
            int j = arrayOfSize.length;
            i = 0;
            if (i < j)
            {
              Size localSize = arrayOfSize[i];
              if ((localSize.getHeight() < paramb.height / 3) || (localSize.getHeight() * localSize.getWidth() >= ((Size)localObject).getWidth() * ((Size)localObject).getHeight())) {
                break label145;
              }
              localObject = localSize;
              break label145;
            }
            b(new anij.b(((Size)localObject).getWidth(), ((Size)localObject).getHeight()));
          }
        }
        if (this.c == null) {
          b(this.jdField_a_of_type_Anij$b);
        }
        return;
      }
      catch (Exception paramb)
      {
        return;
      }
      label145:
      i += 1;
    }
  }
  
  public void cye()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice == null)
    {
      anhj.dH(2, "[Camera2] stopRecordVideo device null!");
      return;
    }
    this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
    dPD();
  }
  
  public void d(SurfaceTexture paramSurfaceTexture)
  {
    this.mSurfaceTexture = paramSurfaceTexture;
  }
  
  public void dPE()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder != null)
      {
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        dPD();
        anhj.dH(1, "[Camera2] setFocusDefaultMode!");
      }
      return;
    }
    catch (Exception localException)
    {
      anhj.dH(2, "[Camera2] setFocusDefaultMode exp:" + localException);
    }
  }
  
  public void dPF()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder != null)
      {
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(3));
        dPD();
        anhj.dH(1, "[Camera2] setFocusRecordMode!");
      }
      return;
    }
    catch (Exception localException)
    {
      anhj.dH(2, "[Camera2] setFocusRecordMode exp:" + localException);
    }
  }
  
  public void dPI()
  {
    try
    {
      anhj.dH(1, "[Camera2]captureStillPicture request!");
      if (this.alf > 0L)
      {
        anhj.dH(1, "[Camera2]captureStillPicture on id:" + this.alf);
        return;
      }
      this.alf = System.currentTimeMillis();
      if (!this.cGd)
      {
        localObject = this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.createCaptureRequest(2);
        ((CaptureRequest.Builder)localObject).addTarget(this.mImageReader.getSurface());
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        if (this.dFZ > -1) {
          ((CaptureRequest.Builder)localObject).set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.dFZ));
        }
        if (this.cC != null) {
          ((CaptureRequest.Builder)localObject).set(CaptureRequest.SCALER_CROP_REGION, this.cC);
        }
        this.alg = System.currentTimeMillis();
        anhf localanhf = new anhf(this);
        this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession.capture(((CaptureRequest.Builder)localObject).build(), localanhf, null);
        return;
      }
      Object localObject = new ArrayList();
      ((List)localObject).add(new SCameraCaptureProcessor.CaptureParameter(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4)));
      if (this.dFZ > -1) {
        ((List)localObject).add(new SCameraCaptureProcessor.CaptureParameter(CaptureRequest.FLASH_MODE, Integer.valueOf(this.dFZ)));
      }
      if (this.cC != null) {
        ((List)localObject).add(new SCameraCaptureProcessor.CaptureParameter(CaptureRequest.SCALER_CROP_REGION, this.cC));
      }
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.capture(this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession, new anhg(this, l), null, (List)localObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void dPJ()
  {
    try
    {
      if (this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor != null)
      {
        this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.deinitialize();
        this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor = null;
      }
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.acquire();
      dPK();
      if (this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice != null)
      {
        this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.close();
        this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$b != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$b = null;
      }
      if (this.mImageReader != null)
      {
        this.mImageReader.close();
        this.mImageReader = null;
      }
      if (this.jdField_a_of_type_AndroidMediaImageReader != null)
      {
        this.jdField_a_of_type_AndroidMediaImageReader.close();
        this.jdField_a_of_type_AndroidMediaImageReader = null;
      }
      if (this.mSurfaceTexture != null) {
        this.mSurfaceTexture = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$a = null;
      }
      if (this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback != null) {
        this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback = null;
      }
      if (this.cC != null) {
        this.cC = null;
      }
      if (this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest != null) {
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest = null;
      }
      if (this.jdField_b_of_type_AndroidHardwareCamera2CaptureRequest != null) {
        this.jdField_b_of_type_AndroidHardwareCamera2CaptureRequest = null;
      }
      if (this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback != null) {
        this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback = null;
      }
      dPM();
      this.dFY = -1;
      this.dFZ = -1;
      this.aqw = false;
      this.aNE = false;
      this.cGc = false;
      this.cGb = false;
      this.alf = 0L;
      anhj.dH(1, "[Camera2]closeCamera2!");
      return;
    }
    catch (Exception localException)
    {
      this.aqw = false;
      this.aNE = false;
      this.cGc = false;
      this.cGb = false;
      anhj.dH(1, "[Camera2]closeCamera2 exception:" + localException);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
    }
  }
  
  public List<int[]> gj()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$a == null) || (!this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$a.isValid()))
    {
      QLog.e("Camera2Control", 1, new Object[] { "[Camera2]getPreviewFps error, camera2Info: ", this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$a });
      return null;
    }
    Range[] arrayOfRange = (Range[])this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$a.a.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
    ArrayList localArrayList = new ArrayList();
    if (arrayOfRange != null)
    {
      int j = arrayOfRange.length;
      int i = 0;
      while (i < j)
      {
        Range localRange = arrayOfRange[i];
        localArrayList.add(new int[] { ((Integer)localRange.getLower()).intValue(), ((Integer)localRange.getUpper()).intValue() });
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public boolean lx(int paramInt)
  {
    Object localObject = a().gj();
    if (localObject == null) {
      QLog.e("Camera2Control", 1, "[Camera2]getPreviewFps error, listPreviewFpsRange null");
    }
    do
    {
      return false;
      localObject = a((List)localObject, paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("Camera2Control", 2, "setParamsPreviewFps[fps_wanted=" + paramInt + " force=false]");
      }
      if ((localObject != null) && (localObject.length >= 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Camera2Control", 2, "setParamsPreviewFps[getFpsRange=null]");
    return false;
    this.jdField_a_of_type_AndroidUtilRange = new Range(Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]));
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2]setPreviewFps:[" + localObject[0] + " " + localObject[1] + "]");
    }
    return true;
  }
  
  public void setZoom(int paramInt)
  {
    Rect localRect1 = (Rect)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$a.a.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    int i = ((Float)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$a.a.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).intValue();
    this.dFY += paramInt;
    if (this.dFY <= 0) {
      this.dFY = 0;
    }
    float f;
    int j;
    int k;
    int m;
    for (;;)
    {
      f = this.dFY / 100.0F;
      paramInt = localRect1.centerX();
      j = localRect1.centerY();
      k = (int)(localRect1.right - paramInt * f / 0.4F - 1.0F - (paramInt * f / 0.4F + 16.0F));
      m = (int)(localRect1.bottom - j * f / 0.4F - 1.0F - (j * f / 0.4F + 16.0F));
      if ((k >= localRect1.right / i) && (m >= localRect1.bottom / i)) {
        break;
      }
      anhj.dH(1, "[Camera2] setZoom out of region!");
      return;
      if (this.dFY >= 100) {
        this.dFY = 100;
      }
    }
    Rect localRect2 = new Rect((int)(paramInt * f / 0.4F + 40.0F), (int)(j * f / 0.4F + 40.0F), localRect1.right - (int)(paramInt * f / 0.4F) - 1, localRect1.bottom - (int)(f * j / 0.4F) - 1);
    anhj.dH(1, "[Camera2] setZoom mZoomValue:" + this.dFY + ", realRadio:" + i + ", minWidth:" + k + ", minHeight:" + m + ", rect:" + localRect1.toString() + ", destRect:" + localRect2.toString());
    this.cC = localRect2;
    this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.SCALER_CROP_REGION, localRect2);
    dPD();
  }
  
  public static class ImageSaveServer
    implements Runnable
  {
    private final Camera2Control.c a;
    private final byte[] mBytes;
    
    public ImageSaveServer(byte[] paramArrayOfByte, Camera2Control.c paramc)
    {
      this.mBytes = paramArrayOfByte;
      this.a = paramc;
    }
    
    public void run()
    {
      int i = 0;
      if (this.mBytes == null)
      {
        anhj.dH(2, "[Camera2]ImageSaveServer params error!");
        if (this.a.a != null) {
          this.a.a.AE(null);
        }
      }
      do
      {
        return;
        int j = anhj.a(this.a.mCharacteristics, this.a.mOrientation);
        boolean bool = this.a.mMirror;
        try
        {
          aqhu.a(aeah.b(this.mBytes, this.a.cD, bool, j), this.a.aM);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            CameraCover.a locala;
            String str;
            localException.printStackTrace();
            anhj.dH(2, "[Camera2]ImageSaveServer Exception:" + localException);
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            anhj.dH(2, "[Camera2]ImageSaveServer OutOfMemoryError:" + localOutOfMemoryError);
            continue;
            Object localObject = null;
          }
        }
      } while (this.a.a == null);
      locala = this.a.a;
      if (i != 0)
      {
        str = this.a.aM.getAbsolutePath();
        locala.AE(str);
        return;
      }
    }
  }
  
  public static class a
  {
    public CameraCharacteristics a;
    public String cdQ;
    
    public a(String paramString, CameraCharacteristics paramCameraCharacteristics)
    {
      this.cdQ = paramString;
      this.a = paramCameraCharacteristics;
    }
    
    public boolean isValid()
    {
      return (!TextUtils.isEmpty(this.cdQ)) && (this.a != null);
    }
  }
  
  public static abstract interface b
  {
    public abstract void UT(int paramInt);
    
    public abstract void bU(int paramInt, boolean paramBoolean);
  }
  
  public static class c
  {
    public CameraCover.a a;
    public File aM;
    public Rect cD;
    public CameraCharacteristics mCharacteristics;
    public boolean mMirror;
    public int mOrientation;
  }
  
  static class d
    implements Comparator<Size>
  {
    public int a(Size paramSize1, Size paramSize2)
    {
      return Long.signum(paramSize1.getWidth() * paramSize1.getHeight() - paramSize2.getWidth() * paramSize2.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control
 * JD-Core Version:    0.7.0.1
 */