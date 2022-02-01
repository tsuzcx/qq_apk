import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.hardware.Camera.Size;>;

public class ilj
{
  private static boolean Sh;
  static ilj.a jdField_a_of_type_Ilj$a = new ilj.a();
  static int aoA = 15000;
  public static int aoB = 640;
  public static int aoC = 480;
  public static int aoD = 17;
  public static boolean isCameraOpened;
  static int nInFPS;
  int CUR_CAMERA = 0;
  int CameraId;
  int CompenSateRecvAngle = 0;
  int CompenSateSendAngle = 0;
  String DEV_MANUFACTURER;
  String DEV_MODEL;
  int NUM_CAMERA = 0;
  int SDK_VERSION;
  public boolean Si = true;
  boolean Sj = false;
  public boolean Sk;
  ilj.b jdField_a_of_type_Ilj$b = null;
  ilj.c jdField_a_of_type_Ilj$c = new ilj.c();
  Camera camera = null;
  private Camera.PreviewCallback cameraCallback = new ilk(this);
  Display devDisplay;
  int mBackCameraAngle = 0;
  Context mContext = null;
  int mFrontCameraAngle = 0;
  boolean mbIsTablet = false;
  
  public ilj(Context paramContext)
  {
    this.mContext = paramContext;
    this.devDisplay = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
    this.mbIsTablet = jkg.isTablet(this.mContext);
    this.Sj = jkg.xD();
    this.SDK_VERSION = aqgz.getOsVersion();
    this.DEV_MODEL = Build.MODEL;
    this.DEV_MANUFACTURER = Build.MANUFACTURER;
    jdField_a_of_type_Ilj$a.orientation = -1;
    jdField_a_of_type_Ilj$a.rotation = -1;
    if (QLog.isColorLevel()) {
      QLog.w("AndroidCamera", 1, "AndroidCamera, Device_Tag[" + this.DEV_MANUFACTURER + ": " + this.DEV_MODEL + "], Rom_Tag[" + Build.VERSION.INCREMENTAL + "]");
    }
  }
  
  private int a(long paramLong, Camera.Parameters paramParameters)
  {
    int j = 16;
    for (;;)
    {
      try
      {
        localList = paramParameters.getSupportedPreviewFormats();
        if (localList == null) {
          break label539;
        }
        if (AudioHelper.aCz())
        {
          StringBuilder localStringBuilder = new StringBuilder("setPreviewFormat[");
          i = 0;
          if (i < localList.size())
          {
            localStringBuilder.append(localList.get(i)).append(";");
            i += 1;
            continue;
          }
          localStringBuilder.append("]");
          QLog.w("AndroidCamera", 1, localStringBuilder.toString());
        }
        bool = localList.contains(Integer.valueOf(17));
        if (!bool) {
          continue;
        }
        i = 17;
      }
      catch (Exception localException)
      {
        List localList;
        boolean bool;
        i = 0;
        continue;
        if (!AudioHelper.aCz()) {
          continue;
        }
        QLog.w("AndroidCamera", 1, "setPreviewFormat, default supportFormat[" + 17 + "], seq[" + paramLong + "]");
        paramParameters.setPreviewFormat(17);
        return 17;
      }
      if (i != 0)
      {
        if (AudioHelper.aCz()) {
          QLog.w("AndroidCamera", 1, "setPreviewFormat, supportFormat[" + i + "], seq[" + paramLong + "]");
        }
        paramParameters.setPreviewFormat(i);
        return i;
        i = j;
        if (localList.contains(Integer.valueOf(16))) {
          continue;
        }
        if (localList.contains(Integer.valueOf(20)))
        {
          i = 20;
          continue;
        }
        if (localList.contains(Integer.valueOf(842094169)))
        {
          i = 842094169;
          continue;
        }
        if (localList.contains(Integer.valueOf(4)))
        {
          i = 4;
          continue;
        }
        if (localList.contains(Integer.valueOf(17)))
        {
          i = 17;
          continue;
        }
        i = j;
        if (localList.contains(Integer.valueOf(16))) {
          continue;
        }
        if (localList.contains(Integer.valueOf(3)))
        {
          i = 3;
          continue;
        }
        if (localList.contains(Integer.valueOf(2)))
        {
          i = 2;
          continue;
        }
        if (localList.contains(Integer.valueOf(4)))
        {
          i = 4;
          continue;
        }
        if (localList.contains(Integer.valueOf(100)))
        {
          i = 100;
          continue;
        }
        if (localList.contains(Integer.valueOf(101)))
        {
          i = 101;
          continue;
        }
        if (localList.contains(Integer.valueOf(102)))
        {
          i = 102;
          continue;
        }
        if (localList.contains(Integer.valueOf(103)))
        {
          i = 103;
          continue;
        }
        bool = localList.contains(Integer.valueOf(104));
        if (!bool) {
          break label539;
        }
        i = 104;
      }
      label539:
      int i = 0;
    }
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, Camera.Parameters paramParameters)
  {
    int i = aoB;
    int j = aoC;
    try
    {
      Object localObject = paramParameters.getSupportedPreviewSizes();
      if (localObject != null)
      {
        localObject = getOptimalEqualPreviewSize((List)localObject, paramInt1, paramInt2);
        if (localObject != null) {
          a("setPreviewSize_support", paramLong, ((Camera.Size)localObject).width, ((Camera.Size)localObject).height);
        }
      }
    }
    catch (Exception localException)
    {
      label55:
      break label55;
    }
    if (((this.DEV_MANUFACTURER.equalsIgnoreCase("samsung")) && (this.DEV_MODEL.equalsIgnoreCase("GT-I9003"))) || ((this.DEV_MANUFACTURER.equalsIgnoreCase("samsung")) && (this.DEV_MODEL.equalsIgnoreCase("GT-I9220"))) || ((this.DEV_MANUFACTURER.equalsIgnoreCase("samsung")) && (this.DEV_MODEL.equalsIgnoreCase("GT-I7000")))) {
      a("setPreviewSize_hardcode", paramLong, 320, 240);
    }
    if (AudioHelper.aCz()) {
      QLog.w("AndroidCamera", 1, "setPreviewSize, in[" + paramInt1 + "x" + paramInt2 + "], before[" + i + "x" + j + "], final[" + aoB + "x" + aoC + "], seq[" + paramLong + "]");
    }
    paramParameters.setPreviewSize(aoB, aoC);
  }
  
  private void a(long paramLong, Camera.Parameters paramParameters, int paramInt1, int paramInt2)
  {
    Object localObject2 = paramParameters.getSupportedPreviewFpsRange();
    aoA = paramInt2;
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject1 = (int[])((List)localObject2).get(0);
      int i = 2147483647;
      Iterator localIterator = ((List)localObject2).iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (int[])localIterator.next();
        if (AudioHelper.aCz()) {
          QLog.w("AndroidCamera", 1, "setPreviewRate2, Range[" + localObject2[0] + "->" + localObject2[1] + "], seq[" + paramLong + "]");
        }
        int j = Math.abs(localObject2[0] - aoA) + Math.abs(localObject2[1] - aoA);
        if (i <= j) {
          break label277;
        }
        localObject1 = localObject2;
        i = j;
      }
    }
    label277:
    for (;;)
    {
      break;
      if (AudioHelper.aCz()) {
        QLog.w("AndroidCamera", 1, "setPreviewRate2, Range[" + localObject1[0] + "->" + localObject1[1] + "], supportFormat[" + paramInt1 + "], newFps[" + paramInt2 + "], seq[" + paramLong + "]");
      }
      paramParameters.setPreviewFpsRange(localObject1[0], localObject1[1]);
      return;
    }
  }
  
  public static void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      if ((aoB != paramInt1) || (aoC != paramInt2) || (QLog.isDevelopLevel())) {
        QLog.w("AndroidCamera", 1, "resetPreViewSize, from[" + paramString + "], src[" + aoB + "x" + aoC + "], final[" + paramInt1 + "x" + paramInt2 + "], seq[" + paramLong + "]");
      }
      aoB = paramInt1;
      aoC = paramInt2;
      return;
    }
    finally {}
  }
  
  private void anP()
  {
    if ((this.DEV_MANUFACTURER.equalsIgnoreCase("meizu")) && (this.DEV_MODEL.equalsIgnoreCase("meizu_m9"))) {
      aoD = 18;
    }
    while ((!this.DEV_MANUFACTURER.equalsIgnoreCase("ZTE")) || (!this.DEV_MODEL.equalsIgnoreCase("ZTE-T U880"))) {
      return;
    }
    aoD = 100;
  }
  
  private void anQ()
  {
    int i = 0;
    this.CameraId = 0;
    try
    {
      if (this.NUM_CAMERA == 0) {
        this.NUM_CAMERA = GetNumberOfCamera();
      }
      if (this.NUM_CAMERA > 0)
      {
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        for (;;)
        {
          if (i < this.NUM_CAMERA)
          {
            Camera.getCameraInfo(i, localCameraInfo);
            int j = localCameraInfo.facing;
            if (j == 0) {}
            try
            {
              this.CameraId = i;
              i += 1;
            }
            catch (RuntimeException localRuntimeException)
            {
              for (;;)
              {
                this.CameraId = 0;
                if (AudioHelper.aCz()) {
                  QLog.w("AndroidCamera", 1, "findBackCameraId, RuntimeException", localRuntimeException);
                }
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (AudioHelper.aCz()) {
        QLog.w("AndroidCamera", 1, "findBackCameraId, Exception", localException);
      }
    }
  }
  
  @TargetApi(9)
  private void b(Camera.Parameters paramParameters, int paramInt)
  {
    Object localObject2 = paramParameters.getSupportedPreviewFpsRange();
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject1 = (int[])((List)localObject2).get(0);
      int i = 2147483647;
      Iterator localIterator = ((List)localObject2).iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (int[])localIterator.next();
        if (AudioHelper.aCz()) {
          QLog.w("AndroidCamera", 1, "setPreviewRate1, Range[" + localObject2[0] + "->" + localObject2[1] + "]");
        }
        int j = Math.abs(localObject2[0] - aoA) + Math.abs(localObject2[1] - aoA);
        if (i <= j) {
          break label239;
        }
        localObject1 = localObject2;
        i = j;
      }
    }
    label239:
    for (;;)
    {
      break;
      if (AudioHelper.aCz()) {
        QLog.w("AndroidCamera", 1, "setPreviewRate1, Range[" + localObject1[0] + "->" + localObject1[1] + "], supportFormat[" + paramInt + "]");
      }
      paramParameters.setPreviewFpsRange(localObject1[0], localObject1[1]);
      return;
    }
  }
  
  private void bY(long paramLong)
  {
    this.jdField_a_of_type_Ilj$c.anS();
    int j;
    int k;
    int i;
    if ((this.Si) && (a() != null)) {
      if (cm(cr(a().getPreviewFormat())))
      {
        j = 0;
        k = 0;
        if (j < ilo.a().lc())
        {
          byte[] arrayOfByte = ilo.a().c(0);
          i = k;
          if (arrayOfByte != null)
          {
            ilo.a().d(arrayOfByte, 1);
            this.camera.addCallbackBuffer(arrayOfByte);
            k += 1;
            i = k;
            if (k < 2) {}
          }
        }
        else
        {
          this.camera.setPreviewCallbackWithBuffer(this.cameraCallback);
          i = 1;
        }
      }
    }
    for (;;)
    {
      QLog.w("AndroidCamera", 1, "setPreviewCallback, type[" + i + "], seq[" + paramLong + "]");
      return;
      j += 1;
      k = i;
      break;
      this.camera.setPreviewCallback(this.cameraCallback);
      i = 2;
      continue;
      i = 3;
      this.camera.setPreviewCallback(this.cameraCallback);
    }
  }
  
  private boolean cm(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    try
    {
      ilo.a().cn(paramInt);
      return true;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        URLDrawable.clearMemoryCache();
        try
        {
          ilo.a().cn(paramInt);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          QLog.e("AndroidCamera", 2, "allocateFrame failed , size:" + paramInt + ", " + localOutOfMemoryError2.getMessage());
        }
      }
    }
    return false;
  }
  
  private int cr(int paramInt)
  {
    int i = ImageFormat.getBitsPerPixel(paramInt);
    float f = i * 1.0F / 8.0F;
    int j = (int)(aoC * aoB * f);
    if (AudioHelper.aCz()) {
      QLog.w("AndroidCamera", 1, "getPreviewBufferSize, previewFormat[" + paramInt + "], bitpixel[" + i + "], byteNum[" + f + "], bufSize[" + j + "]");
    }
    return j;
  }
  
  private int kZ()
  {
    try
    {
      int i = this.devDisplay.getRotation();
      return i;
    }
    catch (Exception localException)
    {
      QLog.w("AndroidCamera", 1, "getDisplayRotation Exception", localException);
    }
    return 0;
  }
  
  protected int GetNumberOfCamera()
  {
    int i;
    if (!aqoq.cVl)
    {
      if (AudioHelper.aCz()) {
        QLog.w("AndroidCamera", 1, "GetNumberOfCamera, hardcode[" + aqoo.a().getNumberOfCamera() + "]");
      }
      i = aqoo.a().getNumberOfCamera();
    }
    do
    {
      for (;;)
      {
        return i;
        try
        {
          j = Camera.getNumberOfCameras();
          i = j;
          try
          {
            if (AudioHelper.aCz())
            {
              QLog.w("AndroidCamera", 1, "GetNumberOfCamera, count[" + j + "]");
              return j;
            }
          }
          catch (Exception localException1) {}
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int j = 1;
          }
        }
      }
      i = j;
    } while (!AudioHelper.aCz());
    QLog.w("AndroidCamera", 1, "GetNumberOfCamera, Exception", localException1);
    return j;
  }
  
  public Camera.Parameters a()
  {
    try
    {
      Camera.Parameters localParameters = this.camera.getParameters();
      return localParameters;
    }
    catch (Exception localException)
    {
      if (AudioHelper.aCz()) {
        QLog.w("AndroidCamera", 1, "GetCameraParams, Exception", localException);
      }
    }
    return null;
  }
  
  protected Camera a(long paramLong)
  {
    return b(paramLong);
  }
  
  protected ilj.a a(int paramInt, Camera paramCamera)
  {
    paramCamera = new ilj.a();
    try
    {
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(paramInt, localCameraInfo);
      paramCamera.facing = localCameraInfo.facing;
      paramCamera.orientation = localCameraInfo.orientation;
      if (this.devDisplay == null)
      {
        paramCamera.rotation = -1;
        return paramCamera;
      }
      switch (kZ())
      {
      case 0: 
        paramCamera.rotation = 0;
        return paramCamera;
      }
    }
    catch (Exception localException)
    {
      paramCamera.rotation = 0;
      return paramCamera;
    }
    paramCamera.rotation = 90;
    return paramCamera;
    paramCamera.rotation = 180;
    return paramCamera;
    paramCamera.rotation = 270;
    return paramCamera;
    return paramCamera;
  }
  
  public void a(ilj.b paramb)
  {
    this.jdField_a_of_type_Ilj$b = paramb;
  }
  
  protected boolean a(long paramLong, int paramInt, Camera paramCamera)
  {
    ilj.a locala = a(paramInt, paramCamera);
    this.CompenSateSendAngle = getSendAngleCompensation();
    this.CompenSateRecvAngle = getRecvAngleCompensation();
    int j = la();
    int k = lb();
    int m;
    int n;
    if (locala.facing == 1)
    {
      i = (360 - (j + k) % 360) % 360;
      m = h(this.Sk);
      n = i(this.Sk);
      if (locala.facing != 1) {
        break label347;
      }
    }
    label347:
    for (int i = (i + m) % 360;; i = (i + n) % 360)
    {
      QLog.w("AndroidCamera", 1, "setCameraDisplayOrientation, cameraId[" + paramInt + "], orientation[" + jdField_a_of_type_Ilj$a.orientation + "->" + locala.orientation + "], rotation[" + jdField_a_of_type_Ilj$a.rotation + "->" + locala.rotation + "], CompenSateSendAngle[" + this.CompenSateSendAngle + "], CompenSateRecvAngle[" + this.CompenSateRecvAngle + "], mSupportLandscape[" + this.Sk + "], previewAngleForFrontCamera[" + m + "], previewAngleForBackCamera[" + n + "], cameraImageOrientation[" + j + "], mobileRotation[" + k + "], result[" + i + "], seq[" + paramLong + "]");
      setDisplayOrientation(paramCamera, i);
      jdField_a_of_type_Ilj$a.facing = locala.facing;
      jdField_a_of_type_Ilj$a.orientation = locala.orientation;
      return true;
      i = (j - k + 360) % 360;
      break;
    }
  }
  
  @TargetApi(11)
  public boolean a(long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    boolean bool2 = true;
    label154:
    label321:
    StringBuilder localStringBuilder;
    for (;;)
    {
      try
      {
        QLog.w("AndroidCamera", 1, "openCamera begin, Camera[" + toString() + "], PreViewSize[" + aoB + "x" + aoC + "], seq[" + paramLong + "]");
        if (isCameraOpened)
        {
          bool1 = true;
          isCameraOpened = bool1;
          QLog.w("AndroidCamera", 1, "openCamera end, result[" + bool1 + "], Camera[" + toString() + "], seq[" + paramLong + "]");
          if (!bool1) {
            break label563;
          }
          ilp.ay(BaseApplicationImpl.getContext(), "openCamera");
          return bool1;
        }
        if (this.mContext == null)
        {
          QLog.w("AndroidCamera", 1, "openCamera, context为空, seq[" + paramLong + "]");
          bool1 = false;
          continue;
        }
        if (this.CUR_CAMERA == 0)
        {
          if ((!an(paramLong)) && (!ao(paramLong)))
          {
            QLog.w("AndroidCamera", 1, "openCamera failed, seq[" + paramLong + "]");
            bool1 = false;
            continue;
          }
          if (this.camera == null)
          {
            QLog.w("AndroidCamera", 1, "openCamera camera为空,setPreviewSize seq[" + paramLong + "]");
            bool1 = false;
            continue;
          }
          n(paramLong, aoB, aoC);
          bool1 = true;
          if (bool1) {
            break label414;
          }
          this.CUR_CAMERA = 0;
          continue;
        }
        switch (this.CUR_CAMERA)
        {
        }
      }
      finally {}
      if (an(paramLong))
      {
        n(paramLong, aoB, aoC);
        bool1 = true;
        continue;
        if (ao(paramLong))
        {
          n(paramLong, aoB, aoC);
          bool1 = true;
          continue;
          try
          {
            label414:
            bY(paramLong);
            this.camera.setPreviewTexture(paramSurfaceTexture);
            this.camera.startPreview();
            bool1 = true;
          }
          catch (Exception paramSurfaceTexture)
          {
            localStringBuilder = new StringBuilder().append("setPreviewDisplay Exception, camera[");
            if (this.camera == null) {}
          }
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.w("AndroidCamera", 1, bool1 + "], isCameraOpened[" + isCameraOpened + "], seq[" + paramLong + "]", paramSurfaceTexture);
      if (this.camera != null)
      {
        this.camera.release();
        this.camera = null;
        QLog.w("AndroidCamera", 1, "setPreviewDisplay fail, set camera null, seq[" + paramLong + "]");
        break label581;
        label563:
        ilp.az(BaseApplicationImpl.getContext(), "openCamera");
        break label154;
        bool1 = false;
        break label321;
      }
      label581:
      bool1 = false;
      break;
    }
  }
  
  public boolean a(long paramLong, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        int i;
        if (this.NUM_CAMERA >= 1) {
          if (this.camera == null)
          {
            break label359;
            if (bool1)
            {
              ilp.ay(BaseApplicationImpl.getContext(), "reopenCamera");
              return bool1;
            }
          }
          else
          {
            QLog.w("AndroidCamera", 1, "reopenCamera, size[" + aoB + ", " + aoC + "], CUR_CAMERA[" + this.CUR_CAMERA + "], isCameraOpened[" + isCameraOpened + "], sizeFromParameter[" + paramInt1 + ", " + paramInt2 + "], seq[" + paramLong + "]");
            if (paramInt1 != -1)
            {
              i = paramInt1;
              paramInt1 = paramInt2;
              if (paramInt2 != -1) {}
            }
            else
            {
              i = aoB;
              paramInt1 = aoC;
            }
            ap(paramLong);
          }
        }
        switch (this.CUR_CAMERA)
        {
        case 2: 
          bool1 = bool2;
          if (!bool2) {
            continue;
          }
          a("reopenCamera", paramLong, i, paramInt1);
        case 1: 
          try
          {
            bY(paramLong);
            if (paramSurfaceTexture != null) {
              this.camera.setPreviewTexture(paramSurfaceTexture);
            }
            this.camera.startPreview();
            bool1 = true;
          }
          catch (Exception paramSurfaceTexture)
          {
            if (!AudioHelper.aCz()) {
              break label371;
            }
          }
          if (!ao(paramLong)) {
            break label365;
          }
          n(paramLong, i, paramInt1);
          bool2 = true;
          continue;
          if (!an(paramLong)) {
            break label365;
          }
          n(paramLong, i, paramInt1);
          bool2 = true;
          continue;
          QLog.w("AndroidCamera", 1, "reopenCamera, Exception, seq[" + paramLong + "]", paramSurfaceTexture);
          break label371;
          ilp.az(BaseApplicationImpl.getContext(), "reopenCamera");
          continue;
          bool1 = false;
        }
      }
      finally {}
      label359:
      continue;
      label365:
      boolean bool2 = false;
      continue;
      label371:
      boolean bool1 = false;
    }
  }
  
  protected boolean an(long paramLong)
  {
    Sh = true;
    this.camera = a(paramLong);
    if (this.camera == null)
    {
      if (AudioHelper.aCz()) {
        QLog.w("AndroidCamera", 1, "openFrontCamera, fail, seq[" + paramLong + "]");
      }
      isCameraOpened = false;
      Sh = false;
      return false;
    }
    if (this.NUM_CAMERA == 0) {
      this.NUM_CAMERA = 2;
    }
    this.CUR_CAMERA = 1;
    isCameraOpened = true;
    Sh = false;
    if (AudioHelper.aCz()) {
      QLog.w("AndroidCamera", 1, "openFrontCamera, success, seq[" + paramLong + "]");
    }
    return true;
  }
  
  public void anR()
  {
    ilo.a().clear();
    if (QLog.isColorLevel()) {
      QLog.i("AndroidCamera", 2, "releasePreviewFrameBuffer");
    }
  }
  
  protected boolean ao(long paramLong)
  {
    boolean bool = isCameraOpened;
    try
    {
      Sh = true;
      this.camera = Camera.open();
      if (AudioHelper.aCz()) {
        QLog.w("AndroidCamera", 1, "openBackCamera, camera[" + this.camera + "], seq[" + paramLong + "]");
      }
      if (this.camera != null)
      {
        this.CUR_CAMERA = 2;
        isCameraOpened = true;
        Sh = false;
        anQ();
        if (AudioHelper.aCz()) {
          QLog.w("AndroidCamera", 1, "openBackCamera, success, seq[" + paramLong + "]");
        }
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        isCameraOpened = false;
        if (this.camera != null)
        {
          this.camera.release();
          this.camera = null;
          QLog.w("AndroidCamera", 1, "openBackCamera Exception, set camera null, seq[" + paramLong + "]");
        }
        QLog.w("AndroidCamera", 1, "openBackCamera Exception, srcIsCameraOpened[" + bool + "], seq[" + paramLong + "]", localException);
      }
      Sh = false;
    }
    return false;
  }
  
  public boolean ap(long paramLong)
  {
    try
    {
      QLog.w("AndroidCamera", 1, "closeCamera begin, camera[" + toString() + "], seq[" + paramLong + "]");
      try
      {
        if (this.camera != null)
        {
          if (isCameraOpened)
          {
            this.camera.setPreviewCallbackWithBuffer(null);
            this.camera.stopPreview();
            this.camera.release();
          }
          anR();
          this.camera = null;
          QLog.w("AndroidCamera", 1, "closeCamera, set camera null, seq[" + paramLong + "]");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w("AndroidCamera", 1, "closeCamera, Exception, seq[" + paramLong + "]", localException);
        }
      }
      isCameraOpened = false;
      QLog.w("AndroidCamera", 1, "closeCamera end, camera[" + toString() + "], seq[" + paramLong + "]");
      ilp.az(BaseApplicationImpl.getContext(), "closeCamera");
      return true;
    }
    finally {}
  }
  
  /* Error */
  protected Camera b(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 358	ilj:CameraId	I
    //   11: aload_0
    //   12: getfield 76	ilj:NUM_CAMERA	I
    //   15: ifne +11 -> 26
    //   18: aload_0
    //   19: aload_0
    //   20: invokevirtual 361	ilj:GetNumberOfCamera	()I
    //   23: putfield 76	ilj:NUM_CAMERA	I
    //   26: aload_0
    //   27: getfield 76	ilj:NUM_CAMERA	I
    //   30: ifle +240 -> 270
    //   33: new 363	android/hardware/Camera$CameraInfo
    //   36: dup
    //   37: invokespecial 364	android/hardware/Camera$CameraInfo:<init>	()V
    //   40: astore 8
    //   42: iconst_0
    //   43: istore_3
    //   44: iload_3
    //   45: aload_0
    //   46: getfield 76	ilj:NUM_CAMERA	I
    //   49: if_icmpge +319 -> 368
    //   52: iload_3
    //   53: aload 8
    //   55: invokestatic 370	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   58: aload 8
    //   60: getfield 373	android/hardware/Camera$CameraInfo:facing	I
    //   63: istore 4
    //   65: invokestatic 201	com/tencent/mobileqq/utils/AudioHelper:aCz	()Z
    //   68: ifeq +54 -> 122
    //   71: ldc 159
    //   73: iconst_1
    //   74: new 161	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 690
    //   84: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: iload_3
    //   88: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: ldc_w 692
    //   94: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: iload 4
    //   99: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: ldc 237
    //   104: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: lload_1
    //   108: invokevirtual 240	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   111: ldc 179
    //   113: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 187	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: iload 4
    //   124: iconst_1
    //   125: if_icmpne +249 -> 374
    //   128: iload_3
    //   129: invokestatic 695	android/hardware/Camera:open	(I)Landroid/hardware/Camera;
    //   132: astore 5
    //   134: aload_0
    //   135: iload_3
    //   136: putfield 358	ilj:CameraId	I
    //   139: aload 5
    //   141: astore 6
    //   143: invokestatic 201	com/tencent/mobileqq/utils/AudioHelper:aCz	()Z
    //   146: ifeq +74 -> 220
    //   149: ldc 159
    //   151: iconst_1
    //   152: new 161	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   159: ldc_w 697
    //   162: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 5
    //   167: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   170: ldc_w 699
    //   173: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 358	ilj:CameraId	I
    //   180: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc_w 701
    //   186: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_0
    //   190: getfield 76	ilj:NUM_CAMERA	I
    //   193: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: ldc 237
    //   198: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: lload_1
    //   202: invokevirtual 240	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   205: ldc 179
    //   207: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 187	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aload 5
    //   218: astore 6
    //   220: aload 6
    //   222: astore 5
    //   224: aload 5
    //   226: areturn
    //   227: astore 5
    //   229: aload_0
    //   230: iconst_0
    //   231: putfield 358	ilj:CameraId	I
    //   234: ldc 159
    //   236: iconst_1
    //   237: new 161	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 703
    //   247: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: lload_1
    //   251: invokevirtual 240	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   254: ldc 179
    //   256: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: aload 5
    //   264: invokestatic 378	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   267: goto +107 -> 374
    //   270: invokestatic 201	com/tencent/mobileqq/utils/AudioHelper:aCz	()Z
    //   273: ifeq -49 -> 224
    //   276: ldc 159
    //   278: iconst_1
    //   279: new 161	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 705
    //   289: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_0
    //   293: getfield 76	ilj:NUM_CAMERA	I
    //   296: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   299: ldc 237
    //   301: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: lload_1
    //   305: invokevirtual 240	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   308: ldc 179
    //   310: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 187	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aconst_null
    //   320: areturn
    //   321: astore 6
    //   323: aload 7
    //   325: astore 5
    //   327: ldc 159
    //   329: iconst_1
    //   330: new 161	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   337: ldc_w 707
    //   340: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: lload_1
    //   344: invokevirtual 240	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   347: ldc 179
    //   349: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: aload 6
    //   357: invokestatic 378	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   360: aload 5
    //   362: areturn
    //   363: astore 6
    //   365: goto -38 -> 327
    //   368: aconst_null
    //   369: astore 6
    //   371: goto -151 -> 220
    //   374: iload_3
    //   375: iconst_1
    //   376: iadd
    //   377: istore_3
    //   378: goto -334 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	ilj
    //   0	381	1	paramLong	long
    //   43	335	3	i	int
    //   63	63	4	j	int
    //   4	221	5	localObject1	Object
    //   227	36	5	localRuntimeException	RuntimeException
    //   325	36	5	localObject2	Object
    //   141	80	6	localObject3	Object
    //   321	35	6	localException1	Exception
    //   363	1	6	localException2	Exception
    //   369	1	6	localObject4	Object
    //   1	323	7	localObject5	Object
    //   40	19	8	localCameraInfo	Camera.CameraInfo
    // Exception table:
    //   from	to	target	type
    //   128	134	227	java/lang/RuntimeException
    //   134	139	227	java/lang/RuntimeException
    //   143	216	227	java/lang/RuntimeException
    //   11	26	321	java/lang/Exception
    //   26	42	321	java/lang/Exception
    //   44	122	321	java/lang/Exception
    //   128	134	321	java/lang/Exception
    //   229	267	321	java/lang/Exception
    //   270	319	321	java/lang/Exception
    //   134	139	363	java/lang/Exception
    //   143	216	363	java/lang/Exception
  }
  
  @TargetApi(11)
  public boolean b(long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    for (;;)
    {
      try
      {
        if (this.NUM_CAMERA >= 1)
        {
          if (this.camera == null)
          {
            break label266;
            if (bool1)
            {
              ilp.ay(BaseApplicationImpl.getContext(), "switchCamera");
              return bool1;
            }
          }
          else
          {
            QLog.w("AndroidCamera", 1, "switchCamera, CUR_CAMERA[" + this.CUR_CAMERA + "], seq[" + paramLong + "]");
            ap(paramLong);
            int i = this.CUR_CAMERA;
            boolean bool2;
            switch (i)
            {
            default: 
              bool2 = false;
              bool1 = bool2;
              if (!bool2) {
                continue;
              }
            case 1: 
            case 2: 
              try
              {
                bY(paramLong);
                this.camera.setPreviewTexture(paramSurfaceTexture);
                this.camera.startPreview();
                bool1 = true;
              }
              catch (Exception paramSurfaceTexture)
              {
                if (!AudioHelper.aCz()) {
                  break label272;
                }
              }
              if (!ao(paramLong)) {
                continue;
              }
              n(paramLong, aoB, aoC);
              bool2 = true;
              continue;
              if (!an(paramLong)) {
                continue;
              }
              n(paramLong, aoB, aoC);
              bool2 = true;
              continue;
              QLog.w("AndroidCamera", 1, "switchCamera, Exception, seq[" + paramLong + "]");
              break;
            }
          }
          ilp.az(BaseApplicationImpl.getContext(), "switchCamera");
          continue;
        }
        bool1 = false;
      }
      finally {}
      label266:
      continue;
      label272:
      boolean bool1 = false;
    }
  }
  
  int g(int paramInt, boolean paramBoolean)
  {
    byte b;
    switch (paramInt)
    {
    default: 
      b = 0;
    }
    while (paramBoolean)
    {
      return imh.a(this.mContext, true, false, b, false) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
    return imh.b(this.mContext, true, false, b, false) * 90;
  }
  
  public int getCameraNum()
  {
    return GetNumberOfCamera();
  }
  
  protected Camera.Size getOptimalEqualPreviewSize(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    int k = -1;
    Iterator localIterator = paramList.iterator();
    Object localObject;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (Camera.Size)localIterator.next();
        if ((((Camera.Size)localObject).width == paramInt1) && (((Camera.Size)localObject).height == paramInt2))
        {
          paramList = (List<Camera.Size>)localObject;
          if (AudioHelper.aCz())
          {
            QLog.w("AndroidCamera", 1, "getOptimalEqualPreviewSize1, width[" + ((Camera.Size)localObject).width + "], height[" + ((Camera.Size)localObject).height + "]");
            paramList = (List<Camera.Size>)localObject;
          }
        }
      }
    }
    int i;
    int j;
    do
    {
      return paramList;
      i = paramInt1;
      j = paramInt2;
      if (paramInt1 != 320) {
        break;
      }
      i = paramInt1;
      j = paramInt2;
      if (paramInt2 != 240) {
        break;
      }
      paramInt1 = 640;
      paramInt2 = 480;
      localIterator = paramList.iterator();
      do
      {
        i = paramInt1;
        j = paramInt2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Camera.Size)localIterator.next();
      } while ((((Camera.Size)localObject).width != 640) || (((Camera.Size)localObject).height != 480));
      paramList = (List<Camera.Size>)localObject;
    } while (!AudioHelper.aCz());
    QLog.w("AndroidCamera", 1, "getOptimalEqualPreviewSize2, width[" + ((Camera.Size)localObject).width + "], height[" + ((Camera.Size)localObject).height + "]");
    return localObject;
    if (0 == 0)
    {
      paramInt2 = aoB;
      int m = aoC;
      paramList = getOptimalPreviewSize(paramList, paramInt2, m);
      if (AudioHelper.aCz())
      {
        localObject = new StringBuilder().append("getOptimalEqualPreviewSize3, width[");
        if (paramList == null) {
          break label410;
        }
      }
      label410:
      for (paramInt1 = paramList.width;; paramInt1 = -1)
      {
        localObject = ((StringBuilder)localObject).append(paramInt1).append("], height[");
        paramInt1 = k;
        if (paramList != null) {
          paramInt1 = paramList.height;
        }
        QLog.w("AndroidCamera", 1, paramInt1 + "], srcW[" + i + "], srcH[" + j + "], fw[" + paramInt2 + "], fh[" + m + "]");
        return paramList;
      }
    }
    return null;
  }
  
  protected Camera.Size getOptimalPreviewSize(List<Camera.Size> paramList, int paramInt1, int paramInt2)
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
      d1 = 1.7976931348623157E+308D;
      localIterator = paramList.iterator();
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
        paramList = (List<Camera.Size>)localObject1;
      }
    }
  }
  
  protected int getRecvAngleCompensation()
  {
    return 0;
  }
  
  protected int getSendAngleCompensation()
  {
    return 0;
  }
  
  public int getUserCameraAngle(boolean paramBoolean)
  {
    if (paramBoolean == true) {
      return this.mFrontCameraAngle;
    }
    return this.mBackCameraAngle;
  }
  
  int h(int paramInt, boolean paramBoolean)
  {
    byte b;
    switch (paramInt)
    {
    default: 
      b = 0;
    }
    while (paramBoolean)
    {
      return imh.a(this.mContext, false, false, b, false) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
    return imh.b(this.mContext, false, false, b, false) * 90;
  }
  
  int h(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 360 - imh.a(this.mContext, true, true, (byte)0, false) * 90;
    }
    return 360 - imh.b(this.mContext, true, true, (byte)0, false) * 90;
  }
  
  int i(boolean paramBoolean)
  {
    if (paramBoolean) {
      return imh.a(this.mContext, false, true, (byte)0, false) * 90;
    }
    return imh.b(this.mContext, false, true, (byte)0, false) * 90;
  }
  
  public boolean isFrontCamera()
  {
    if (this.CUR_CAMERA == 0) {}
    while (this.CUR_CAMERA == 1) {
      return true;
    }
    return false;
  }
  
  public void kW(int paramInt)
  {
    int i = jdField_a_of_type_Ilj$a.rotation;
    jdField_a_of_type_Ilj$a.rotation = ((this.CompenSateSendAngle + paramInt) % 360);
    if (i != jdField_a_of_type_Ilj$a.rotation) {
      QLog.w("AndroidCamera", 1, "setMobileRotation, rotation[" + i + "->" + jdField_a_of_type_Ilj$a.rotation + "], CompenSateSendAngle[" + this.CompenSateSendAngle + "]");
    }
  }
  
  public int la()
  {
    if (jdField_a_of_type_Ilj$a.orientation == -1)
    {
      if (this.CUR_CAMERA == 1) {
        return 270;
      }
      if (this.CUR_CAMERA == 2) {
        return 90;
      }
    }
    return jdField_a_of_type_Ilj$a.orientation;
  }
  
  public int lb()
  {
    if (jdField_a_of_type_Ilj$a.rotation == -1) {
      return 0;
    }
    return jdField_a_of_type_Ilj$a.rotation;
  }
  
  @TargetApi(9)
  protected void n(long paramLong, int paramInt1, int paramInt2)
    throws RuntimeException
  {
    if (this.camera == null) {}
    for (;;)
    {
      return;
      synchronized (jdField_a_of_type_Ilj$a)
      {
        a(paramLong, this.CameraId, this.camera);
        Object localObject2 = null;
      }
      try
      {
        ??? = this.camera.getParameters();
        if (??? == null)
        {
          if (!AudioHelper.aCz()) {
            continue;
          }
          QLog.w("AndroidCamera", 1, "setCameraPara, parameters为空");
          return;
          localObject3 = finally;
          throw localObject3;
        }
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          ??? = localObject3;
          if (AudioHelper.aCz())
          {
            QLog.w("AndroidCamera", 1, "setCameraPara, Exception", localException3);
            ??? = localObject3;
          }
        }
        b((Camera.Parameters)???, a(paramLong, (Camera.Parameters)???));
        a(paramLong, paramInt1, paramInt2, (Camera.Parameters)???);
      }
    }
    try
    {
      ((Camera.Parameters)???).setRotation(180);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.camera.setParameters((Camera.Parameters)???);
          label144:
          Object localObject4 = ((Camera.Parameters)???).getPreviewSize();
          int i = ((Camera.Parameters)???).getPreviewFormat();
          a("setCameraPara", paramLong, ((Camera.Size)localObject4).width, ((Camera.Size)localObject4).height);
          aoD = i;
          localObject4 = new int[2];
          ((Camera.Parameters)???).getPreviewFpsRange((int[])localObject4);
          nInFPS = (localObject4[0] + localObject4[1]) / 2 / 1000;
          anP();
          QLog.w("AndroidCamera", 1, "setCameraPara, size[" + aoB + "x" + aoC + "], src[" + paramInt1 + "x" + paramInt2 + "], nInFPS[" + nInFPS + "], fpsRange[" + localObject4[0] + "~" + localObject4[1] + "], videoFormat[" + aoD + "], seq[" + paramLong + "]");
          return;
          localException1 = localException1;
          ((Camera.Parameters)???).set("Rotation", 180);
        }
      }
      catch (Exception localException2)
      {
        break label144;
      }
    }
  }
  
  public void setCameraAngleFix(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      this.mFrontCameraAngle = (paramInt % 360);
    }
    for (;;)
    {
      igd.aJ("AndroidCamera", "mFrontCameraAngle: " + this.mFrontCameraAngle + ", mBackCameraAngle: " + this.mBackCameraAngle);
      return;
      this.mBackCameraAngle = (paramInt % 360);
    }
  }
  
  protected void setDisplayOrientation(Camera paramCamera, int paramInt)
  {
    try
    {
      paramCamera.setDisplayOrientation(paramInt);
      return;
    }
    catch (Exception paramCamera)
    {
      while (!AudioHelper.aCz()) {}
      QLog.w("AndroidCamera", 1, "setDisplayOrientation, Exception", paramCamera);
    }
  }
  
  public void t(long paramLong, int paramInt)
    throws RuntimeException
  {
    if (this.camera == null) {}
    for (;;)
    {
      return;
      synchronized (jdField_a_of_type_Ilj$a)
      {
        a(paramLong, this.CameraId, this.camera);
        Object localObject2 = null;
      }
      int i;
      try
      {
        ??? = this.camera.getParameters();
        if (??? == null)
        {
          if (!AudioHelper.aCz()) {
            continue;
          }
          QLog.w("AndroidCamera", 1, "setCameraParaFPS, parameters为空");
          return;
          localObject3 = finally;
          throw localObject3;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ??? = localObject3;
          if (AudioHelper.aCz())
          {
            QLog.w("AndroidCamera", 1, "setCameraParaFPS, Exception", localException2);
            ??? = localObject3;
          }
        }
        i = a(paramLong, (Camera.Parameters)???);
        a(paramLong, (Camera.Parameters)???, i, paramInt);
        ((Camera.Parameters)???).set("Rotation", 180);
      }
      try
      {
        this.camera.setParameters((Camera.Parameters)???);
        label143:
        Camera.Size localSize = ((Camera.Parameters)???).getPreviewSize();
        paramInt = ((Camera.Parameters)???).getPreviewFormat();
        if (localSize != null) {
          a("setCameraParaFPS", paramLong, localSize.width, localSize.height);
        }
        for (;;)
        {
          aoD = paramInt;
          int[] arrayOfInt = new int[2];
          ((Camera.Parameters)???).getPreviewFpsRange(arrayOfInt);
          nInFPS = (arrayOfInt[0] + arrayOfInt[1]) / 2 / 1000;
          anP();
          if ((!AudioHelper.aCz()) && (localSize != null)) {
            break;
          }
          QLog.w("AndroidCamera", 1, "setCameraParaFPS, width[" + aoB + "], height[" + aoC + "], nInFPS[" + nInFPS + "], fpsRange[" + arrayOfInt[0] + "|" + arrayOfInt[1] + "], videoFormat[" + aoD + "], supportFormat[" + i + "], seq[" + paramLong + "]");
          return;
          QLog.w("AndroidCamera", 1, "setCameraParaFPS, getPreviewSize fail, size[" + ((Camera.Parameters)???).get("preview-size") + "]");
        }
      }
      catch (Exception localException1)
      {
        break label143;
      }
    }
  }
  
  public boolean tS()
  {
    return Sh;
  }
  
  public boolean tT()
  {
    return isCameraOpened;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("isCameraOpened[").append(isCameraOpened).append("], CameraId[").append(this.CameraId).append("], NUM[").append(this.NUM_CAMERA).append("], CUR[").append(this.CUR_CAMERA).append("], camera[");
    if (this.camera != null) {}
    for (boolean bool = true;; bool = false) {
      return bool + "]";
    }
  }
  
  static class a
  {
    int facing;
    int orientation;
    int rotation;
  }
  
  public static abstract interface b
  {
    public abstract void a(long paramLong1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, boolean paramBoolean);
  }
  
  static class c
  {
    int CUR_CAMERA = -99;
    boolean Sk = false;
    int aoF = -99;
    int aoG = -99;
    int aoH = -99;
    int dataLength = -99;
    int degree = -99;
    int frameIndex = -99;
    int h = -99;
    int nInFPS = -99;
    int w = -99;
    
    void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      long l = this.frameIndex;
      if (paramInt1 <= -99) {}
      for (this.frameIndex = 0;; this.frameIndex += 1)
      {
        if ((this.degree != paramInt1) || (this.CUR_CAMERA != paramInt2) || (this.nInFPS != paramInt3) || (this.Sk != paramBoolean) || (this.aoF != paramInt4) || (this.aoG != paramInt5) || (this.aoH != paramInt6) || (this.dataLength != paramInt7) || (this.w != paramInt8) || (this.h != paramInt9)) {
          QLog.w("AndroidCamera", 1, "PreviewCallback, Index[" + l + "->" + this.frameIndex + "], degree[" + this.degree + "->" + paramInt1 + "], CUR_CAMERA[" + this.CUR_CAMERA + "->" + paramInt2 + "], nInFPS[" + this.nInFPS + "->" + paramInt3 + "], mSupportLandscape[" + this.Sk + "->" + paramBoolean + "], cameraImageOrientation[" + this.aoF + "->" + paramInt4 + "], displayRotation[" + this.aoG + "->" + paramInt5 + "], mobileRotation[" + this.aoH + "->" + paramInt6 + "], dataLength[" + this.dataLength + "->" + paramInt7 + "], w[" + this.w + "->" + paramInt8 + "], h[" + this.h + "->" + paramInt9 + "]");
        }
        this.degree = paramInt1;
        this.CUR_CAMERA = paramInt2;
        this.nInFPS = paramInt3;
        this.Sk = paramBoolean;
        this.aoF = paramInt4;
        this.aoG = paramInt5;
        this.aoH = paramInt6;
        this.dataLength = paramInt7;
        this.w = paramInt8;
        this.h = paramInt9;
        return;
      }
    }
    
    void anS()
    {
      a(-101, this.CUR_CAMERA, this.nInFPS, this.Sk, -101, -101, -101, -101, -101, -101);
    }
    
    void anT()
    {
      a(-100, this.CUR_CAMERA, this.nInFPS, this.Sk, -100, -100, -100, -100, -100, -100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ilj
 * JD-Core Version:    0.7.0.1
 */