import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.OcrCamera.4;
import com.tencent.mobileqq.ocr.OcrCamera.5;
import com.tencent.mobileqq.ocr.OcrCamera.8;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class akmz
  implements Handler.Callback
{
  public akmz.a a;
  OrientationEventListener a;
  public RectF aF;
  private long adV;
  private long adW;
  adhe jdField_b_of_type_Adhe;
  aeab jdField_b_of_type_Aeab;
  public int cjn;
  private volatile boolean csZ;
  private boolean cta = true;
  public volatile boolean ctb = true;
  public volatile boolean ctc = true;
  private int dnD;
  private int dnE;
  private int dnF;
  private int dnG;
  int dnH;
  int dnI;
  int dnJ = 0;
  byte[] eV;
  byte[] eW;
  private boolean isOpen;
  private boolean isStop;
  private Camera mCamera;
  public int mCameraId;
  public int mMode = 0;
  private int mPicHeight;
  private int mPicWidth;
  Camera.PreviewCallback mPreviewCallback = new aknc(this);
  SurfaceHolder mSurfaceHolder;
  auru o;
  
  public akmz(Context paramContext, akmz.a parama, SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Akmz$a = parama;
    this.mSurfaceHolder = paramSurfaceHolder;
    this.o = new auru(ThreadManager.getSubThreadLooper(), this);
    this.jdField_b_of_type_Aeab = aeab.a();
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new akna(this, paramContext);
    paramContext = aknv.a();
    if (paramContext != null)
    {
      this.dnH = paramContext.dnW;
      int i = paramContext.dnR;
      this.dnI = (paramContext.dnS * i);
      if (this.dnI >= 76800) {}
    }
    for (this.dnI = 921600;; this.dnI = 921600)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.camera", 2, "OcrCamera mFrameGap:" + this.dnH + ",mMaxPreviewPixels:" + this.dnI);
      }
      return;
      this.dnH = 100;
    }
  }
  
  private int GT()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        if (ilp.checkAVCameraUsed(BaseApplicationImpl.getContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.camera", 2, "openCamera take up!");
          }
          i = -1001;
          return i;
        }
        try
        {
          this.mCamera = auqz.a();
          if (this.mCamera == null)
          {
            if (!QLog.isColorLevel()) {
              break label610;
            }
            QLog.d("Q.ocr.camera", 2, "openCamera failed!");
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          continue;
        }
        this.mCameraId = anih.JC();
      }
      finally {}
      lx.a(this.mCamera, 0, 0);
      int i = 90;
      if (anii.isFoundProduct(anii.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL)) {
        i = 270;
      }
      this.mCamera.setDisplayOrientation(i);
      Object localObject2 = this.mCamera.getParameters();
      PixelFormat localPixelFormat = new PixelFormat();
      i = ((Camera.Parameters)localObject2).getPreviewFormat();
      PixelFormat.getPixelFormatInfo(i, localPixelFormat);
      Object localObject3 = a(this.mCamera, ankt.SCREEN_WIDTH, ankt.cIE, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.camera", 2, "openCamera bestPreviewSize:" + ((Point)localObject3).x + "," + ((Point)localObject3).y);
      }
      try
      {
        ((Camera.Parameters)localObject2).setPreviewSize(((Point)localObject3).x, ((Point)localObject3).y);
        this.mCamera.setParameters((Camera.Parameters)localObject2);
        int k = this.mMode;
        if (k != 1) {}
      }
      catch (Exception localException3)
      {
        try
        {
          Camera.Parameters localParameters = this.mCamera.getParameters();
          localParameters.setPictureFormat(256);
          localParameters.setJpegQuality(100);
          Point localPoint = a(this.mCamera, ankt.SCREEN_WIDTH, ankt.cIE, true);
          if ((localPoint.x >= ((Point)localObject3).x) && (localPoint.y >= ((Point)localObject3).y))
          {
            localParameters.setPictureSize(localPoint.x, localPoint.y);
            this.mCamera.setParameters(localParameters);
            localObject3 = localParameters.getPictureSize();
            this.dnD = ((Camera.Size)localObject3).width;
            this.dnE = ((Camera.Size)localObject3).height;
            this.cta = true;
          }
          localObject2 = ((Camera.Parameters)localObject2).getPreviewSize();
          this.mPicWidth = ((Camera.Size)localObject2).width;
          this.mPicHeight = ((Camera.Size)localObject2).height;
          this.dnF = i;
          this.dnG = localPixelFormat.bitsPerPixel;
          if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.camera", 2, "openCamera picWidth:" + this.mPicWidth + ",picHeight:" + this.mPicHeight + ",picFormat:" + this.dnF + "  mTakePicWidth:" + this.dnD + "   mTakePicHeight:" + this.dnE);
          }
          if (!arZ())
          {
            i = -1003;
            continue;
            localException3 = localException3;
            localException3.printStackTrace();
            QLog.d("Q.ocr.camera", 1, "openInternal setCamera Params1 exp " + localException3.getMessage());
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
            QLog.d("Q.ocr.camera", 1, "openInternal setCamera Params2 exp " + localException2.getMessage());
            this.cta = false;
          }
          this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
          i = j;
        }
      }
      continue;
      label610:
      i = -1002;
    }
  }
  
  private Point a(Camera paramCamera, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = paramCamera.getParameters();
    Camera.Size localSize1 = ((Camera.Parameters)localObject).getPreviewSize();
    if (("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && ("GT-I9008L".equalsIgnoreCase(Build.MODEL)))
    {
      localObject = new Point(localSize1.width, localSize1.height);
      return localObject;
    }
    paramCamera = ((Camera.Parameters)localObject).getSupportedPreviewSizes();
    if (paramBoolean) {
      paramCamera = ((Camera.Parameters)localObject).getSupportedPictureSizes();
    }
    if (paramCamera == null) {
      return new Point(localSize1.width, localSize1.height);
    }
    localObject = new ArrayList(paramCamera);
    Collections.sort((List)localObject, new aknb(this));
    paramCamera = null;
    float f3 = paramInt1 / paramInt2;
    float f1 = (1.0F / 1.0F);
    int i = this.dnI;
    if (paramBoolean) {
      i = 3686400;
    }
    for (;;)
    {
      localObject = ((List)localObject).iterator();
      label160:
      while (((Iterator)localObject).hasNext())
      {
        Camera.Size localSize2 = (Camera.Size)((Iterator)localObject).next();
        int j = localSize2.width;
        int k = localSize2.height;
        int m = j * k;
        if ((m >= 76800) && (m <= i) && ((j != 980) || (k != 800) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"GT-I9220".equalsIgnoreCase(Build.MODEL)) && (!"GT-N7000".equalsIgnoreCase(Build.MODEL)))) && (((j == 1184) && (k == 666)) || ((j != 704) || (k != 576) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9300".equalsIgnoreCase(Build.MODEL)))))
        {
          if (paramInt1 > paramInt2)
          {
            m = 1;
            if (j >= k) {
              break label388;
            }
            n = 1;
            label343:
            if (m != n) {
              break label394;
            }
            m = j;
          }
          for (int n = k;; n = j)
          {
            if ((n != paramInt1) || (m != paramInt2)) {
              break label405;
            }
            return new Point(j, k);
            m = 0;
            break;
            n = 0;
            break label343;
            m = k;
          }
          if ((n >= paramInt1 >> 1) && (n >> 1 <= paramInt1) && (m >= paramInt2 >> 1) && (m >> 1 <= paramInt2))
          {
            float f2 = Math.abs(n / m - f3);
            if (f2 > f1) {
              break label504;
            }
            paramCamera = new Point(j, k);
            f1 = f2;
          }
        }
      }
      label388:
      label394:
      label405:
      label504:
      for (;;)
      {
        break label160;
        localObject = paramCamera;
        if (paramCamera != null) {
          break;
        }
        return new Point(localSize1.width, localSize1.height);
      }
    }
  }
  
  private boolean a(Camera paramCamera, int paramInt)
  {
    if ((paramCamera == null) || (paramInt <= 0))
    {
      QLog.d("Q.ocr.camera", 1, "addCallbackBuffer camera == null || bufSize <= 0");
      return false;
    }
    int i = 0;
    int j = 0;
    if (i < 5) {}
    for (;;)
    {
      try
      {
        paramCamera.addCallbackBuffer(new byte[paramInt]);
        j += 1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("Q.ocr.camera", 1, "addCallbackBuffer failed. exp msg:" + localException.getMessage());
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (j <= 1) {
          break label148;
        }
      }
      i += 1;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.camera", 2, "addCallbackBuffer count:" + j + ",bufSize:" + paramInt);
      }
      if (j <= 1) {
        break label180;
      }
      return true;
      label148:
      URLDrawable.clearMemoryCache();
      QLog.d("Q.ocr.camera", 1, "addCallbackBuffer failed. oom i:" + i);
    }
    label180:
    return false;
  }
  
  private void aW(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        if (this.ctc)
        {
          this.ctc = false;
          if (QLog.isDebugVersion()) {
            ThreadManager.getUIHandler().post(new OcrCamera.4(this));
          }
          anot.a(null, "dc00898", "", "", "0X80082C1", "0X80082C1", 0, 0, "", "", "", "");
          this.adW = System.currentTimeMillis();
        }
        if (this.jdField_b_of_type_Adhe == null) {
          this.jdField_b_of_type_Adhe = new adhe(adhe.cFE);
        }
        int i = this.dnJ;
        if (i < 5) {
          continue;
        }
      }
      finally
      {
        try
        {
          bool = this.jdField_b_of_type_Adhe.c(paramArrayOfByte, this.mPicWidth, this.mPicHeight);
        }
        catch (Throwable paramArrayOfByte)
        {
          long l;
          boolean bool = false;
        }
        try
        {
          this.dnJ = 0;
          if (!bool) {
            continue;
          }
          l = System.currentTimeMillis() - this.adW;
          QLog.d("Q.ocr.camera", 4, "select image isBest:" + bool + ",costTime:" + l);
          anot.a(null, "dc00898", "", "", "0X80082C3", "0X80082C3", 0, 0, "", "", "", "");
          anot.a(null, "dc00898", "", "", "0X80082C5", "0X80082C5", 0, 0, String.valueOf(l), "", "", "");
          ThreadManager.post(new OcrCamera.5(this, l), 5, null, false);
          if (aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
            break label352;
          }
          QLog.d("Q.ocr.camera", 1, "selectImage best but error!");
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131701459, 0).show();
        }
        catch (Throwable paramArrayOfByte)
        {
          break label310;
        }
        paramArrayOfByte = finally;
      }
      return;
      label310:
      this.dnJ += 1;
      QLog.d("Q.ocr.camera", 4, "selectImage error " + paramArrayOfByte.getMessage());
      continue;
      label352:
      this.ctb = false;
      this.ctc = true;
      paramArrayOfByte = this.jdField_b_of_type_Adhe.T();
      if (paramArrayOfByte == null)
      {
        this.ctb = true;
        QLog.d("Q.ocr.camera", 1, "postUploadTask imageData == null");
      }
      else
      {
        if (this.jdField_a_of_type_Akmz$a != null) {
          this.jdField_a_of_type_Akmz$a.dCj();
        }
        paramArrayOfByte = akng.a(paramArrayOfByte, this.mPicWidth, this.mPicHeight, this.dnF, this.mCameraId, this.cjn);
        if (this.jdField_a_of_type_Akmz$a != null) {
          this.jdField_a_of_type_Akmz$a.NG(paramArrayOfByte);
        }
      }
    }
  }
  
  /* Error */
  private boolean arZ()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_3
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 179	akmz:mCamera	Landroid/hardware/Camera;
    //   13: ifnull +191 -> 204
    //   16: aload_0
    //   17: getfield 76	akmz:mSurfaceHolder	Landroid/view/SurfaceHolder;
    //   20: astore 5
    //   22: aload 5
    //   24: ifnull +180 -> 204
    //   27: aload_0
    //   28: getfield 72	akmz:mPreviewCallback	Landroid/hardware/Camera$PreviewCallback;
    //   31: ifnull +52 -> 83
    //   34: aload_0
    //   35: getfield 289	akmz:mPicWidth	I
    //   38: aload_0
    //   39: getfield 291	akmz:mPicHeight	I
    //   42: imul
    //   43: aload_0
    //   44: getfield 298	akmz:dnG	I
    //   47: imul
    //   48: bipush 8
    //   50: idiv
    //   51: istore_1
    //   52: aload_0
    //   53: aload_0
    //   54: getfield 179	akmz:mCamera	Landroid/hardware/Camera;
    //   57: iload_1
    //   58: invokespecial 546	akmz:a	(Landroid/hardware/Camera;I)Z
    //   61: istore 4
    //   63: iload 4
    //   65: ifne +7 -> 72
    //   68: aload_0
    //   69: monitorexit
    //   70: iload_3
    //   71: ireturn
    //   72: aload_0
    //   73: getfield 179	akmz:mCamera	Landroid/hardware/Camera;
    //   76: aload_0
    //   77: getfield 72	akmz:mPreviewCallback	Landroid/hardware/Camera$PreviewCallback;
    //   80: invokevirtual 550	android/hardware/Camera:setPreviewCallbackWithBuffer	(Landroid/hardware/Camera$PreviewCallback;)V
    //   83: aload_0
    //   84: getfield 179	akmz:mCamera	Landroid/hardware/Camera;
    //   87: aload_0
    //   88: getfield 76	akmz:mSurfaceHolder	Landroid/view/SurfaceHolder;
    //   91: invokevirtual 554	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   94: aload_0
    //   95: getfield 179	akmz:mCamera	Landroid/hardware/Camera;
    //   98: invokevirtual 557	android/hardware/Camera:startPreview	()V
    //   101: aload_0
    //   102: invokevirtual 560	akmz:dCh	()V
    //   105: iconst_1
    //   106: istore_2
    //   107: iload_2
    //   108: ifeq +8 -> 116
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 562	akmz:isStop	Z
    //   116: iload_2
    //   117: istore_3
    //   118: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq -53 -> 68
    //   124: ldc 131
    //   126: iconst_2
    //   127: new 133	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 564
    //   137: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: iload_2
    //   141: invokevirtual 483	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   144: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: iload_2
    //   151: istore_3
    //   152: goto -84 -> 68
    //   155: astore 5
    //   157: aload_0
    //   158: monitorexit
    //   159: aload 5
    //   161: athrow
    //   162: astore 5
    //   164: iconst_0
    //   165: istore_2
    //   166: aload 5
    //   168: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   171: ldc 131
    //   173: iconst_1
    //   174: new 133	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   181: ldc_w 566
    //   184: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 5
    //   189: invokevirtual 316	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   192: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: goto -94 -> 107
    //   204: ldc 131
    //   206: iconst_1
    //   207: ldc_w 568
    //   210: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: iload 4
    //   215: istore_2
    //   216: goto -109 -> 107
    //   219: astore 5
    //   221: goto -55 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	akmz
    //   51	7	1	i	int
    //   1	215	2	bool1	boolean
    //   6	146	3	bool2	boolean
    //   3	211	4	bool3	boolean
    //   20	3	5	localSurfaceHolder	SurfaceHolder
    //   155	5	5	localObject	Object
    //   162	26	5	localException1	Exception
    //   219	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   9	22	155	finally
    //   27	63	155	finally
    //   72	83	155	finally
    //   83	101	155	finally
    //   101	105	155	finally
    //   111	116	155	finally
    //   118	150	155	finally
    //   166	201	155	finally
    //   204	213	155	finally
    //   27	63	162	java/lang/Exception
    //   72	83	162	java/lang/Exception
    //   83	101	162	java/lang/Exception
    //   101	105	219	java/lang/Exception
  }
  
  private boolean asa()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        Camera localCamera = this.mCamera;
        if (localCamera != null)
        {
          try
          {
            this.mCamera.setPreviewCallbackWithBuffer(null);
            this.mCamera.stopPreview();
            QLog.d("Q.ocr.camera", 1, "stopPreview failed. error msg: " + localException1.getMessage());
          }
          catch (Exception localException1)
          {
            try
            {
              this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
              dCi();
              if (bool1) {
                this.isStop = true;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.ocr.camera", 2, "stopPreviewInternal isSuc:" + bool1);
              }
              return bool1;
            }
            catch (Exception localException2)
            {
              bool1 = bool2;
              continue;
            }
            localException1 = localException1;
            bool1 = false;
          }
          continue;
        }
        bool1 = false;
      }
      finally {}
    }
  }
  
  /* Error */
  private boolean asb()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 179	akmz:mCamera	Landroid/hardware/Camera;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +59 -> 69
    //   13: aload_0
    //   14: getfield 179	akmz:mCamera	Landroid/hardware/Camera;
    //   17: invokevirtual 586	android/hardware/Camera:release	()V
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 588	akmz:eW	[B
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: astore_2
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 179	akmz:mCamera	Landroid/hardware/Camera;
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 76	akmz:mSurfaceHolder	Landroid/view/SurfaceHolder;
    //   40: ldc 131
    //   42: iconst_1
    //   43: new 133	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 590
    //   53: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_2
    //   57: invokevirtual 316	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   60: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: iconst_0
    //   70: istore_1
    //   71: goto -51 -> 20
    //   74: astore_2
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	akmz
    //   1	70	1	bool	boolean
    //   8	2	2	localCamera	Camera
    //   29	28	2	localException	Exception
    //   74	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	20	29	java/lang/Exception
    //   4	9	74	finally
    //   13	20	74	finally
    //   20	25	74	finally
    //   30	69	74	finally
  }
  
  public void Sb(int paramInt)
  {
    this.mMode = paramInt;
    if (this.mMode == 1)
    {
      this.dnI = 2073600;
      if (QLog.isColorLevel()) {
        QLog.i("Q.ocr.camera", 1, "setOcrMode device model: " + aqgz.getModel());
      }
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (this.o == null) || (this.mCamera == null)) {
      return false;
    }
    this.o.post(new OcrCamera.8(this, paramBoolean, paramArrayOfByte));
    return true;
  }
  
  public boolean asc()
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("takePicture, isOpen:").append(this.isOpen).append(",mNeedSelectImage:").append(this.ctb).append(",isStop:").append(this.isStop).append(",picData:");
      if (this.eV == null)
      {
        bool = true;
        QLog.d("Q.ocr.camera", 2, bool);
      }
    }
    else
    {
      if (aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
        break label122;
      }
      QLog.d("Q.ocr.camera", 1, "takePicture but net error!");
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131701459, 0).show();
    }
    label122:
    while ((!this.isOpen) || (this.isStop) || ((!this.ctb) && (this.mMode != 1)) || (this.eV == null) || (this.csZ) || (this.mCamera == null))
    {
      return false;
      bool = false;
      break;
    }
    this.csZ = true;
    if ((this.mMode == 1) && (this.cta) && (this.dnD * this.dnE >= this.mPicWidth * this.mPicHeight)) {
      this.mCamera.takePicture(null, null, null, new aknd(this));
    }
    for (;;)
    {
      return true;
      if ((this.eW == null) || (this.eW.length != this.eV.length)) {}
      try
      {
        this.eW = new byte[this.eV.length];
        if (this.eW != null)
        {
          System.arraycopy(this.eV, 0, this.eW, 0, this.eV.length);
          localObject = this.eW;
          a((byte[])localObject, false);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("Q.ocr.camera", 1, new Object[] { "takePicture error: ", localThrowable.getMessage() });
          this.eW = null;
          continue;
          byte[] arrayOfByte = this.eV;
        }
      }
    }
  }
  
  public void c(RectF paramRectF)
  {
    this.aF = paramRectF;
  }
  
  public void close()
  {
    this.o.removeCallbacksAndMessages(null);
    Message localMessage = this.o.obtainMessage(3);
    this.o.sendMessage(localMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.camera", 2, "close");
    }
  }
  
  public void dCg()
  {
    try
    {
      this.ctb = true;
      this.ctc = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void dCh()
  {
    try
    {
      this.ctb = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void dCi()
  {
    try
    {
      this.ctb = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    boolean bool;
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return false;
              if (!this.isOpen) {
                try
                {
                  i = GT();
                  if (i == 0) {
                    this.isOpen = true;
                  }
                  if (this.jdField_a_of_type_Akmz$a != null)
                  {
                    this.jdField_a_of_type_Akmz$a.R(i, this.mPicWidth, this.mPicHeight, this.dnF);
                    return false;
                  }
                }
                catch (Exception paramMessage)
                {
                  for (;;)
                  {
                    int i = -1004;
                    paramMessage.printStackTrace();
                  }
                }
              }
            }
            bool = arZ();
          } while (this.jdField_a_of_type_Akmz$a == null);
          this.jdField_a_of_type_Akmz$a.MS(bool);
          return false;
          bool = asa();
        } while (this.jdField_a_of_type_Akmz$a == null);
        this.jdField_a_of_type_Akmz$a.MT(bool);
        return false;
      } while (!this.isOpen);
      bool = asb();
      if (bool) {
        this.isOpen = false;
      }
    } while (this.jdField_a_of_type_Akmz$a == null);
    this.jdField_a_of_type_Akmz$a.ki(bool);
    return false;
  }
  
  public void open()
  {
    if (this.isOpen) {
      if (this.isStop)
      {
        dCg();
        startPreview();
      }
    }
    do
    {
      return;
      this.o.removeMessages(0);
      Message localMessage = this.o.obtainMessage(0);
      this.o.sendMessage(localMessage);
    } while (!QLog.isColorLevel());
    QLog.d("Q.ocr.camera", 2, "open isStop:" + this.isStop + ",isOpen:" + this.isOpen);
  }
  
  public void startPreview()
  {
    this.o.removeMessages(1);
    Message localMessage = this.o.obtainMessage(1);
    this.o.sendMessage(localMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.camera", 2, "startPreview");
    }
  }
  
  public void stopPreview()
  {
    this.o.removeMessages(2);
    Message localMessage = this.o.obtainMessage(2);
    this.o.sendMessage(localMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.camera", 2, "stopPreview");
    }
  }
  
  public static abstract interface a
  {
    public abstract void MS(boolean paramBoolean);
    
    public abstract void MT(boolean paramBoolean);
    
    public abstract void NG(String paramString);
    
    public abstract void R(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void dCj();
    
    public abstract void ki(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmz
 * JD-Core Version:    0.7.0.1
 */