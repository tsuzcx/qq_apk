package com.tencent.biz.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlite.R.styleable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import sy;
import sz;
import ta;
import tb;
import th;

public class ScannerView
  extends ViewGroup
  implements Camera.PreviewCallback, SurfaceHolder.Callback, Comparator
{
  static final int jdField_a_of_type_Int = 1;
  public static final String a;
  static final int jdField_b_of_type_Int = 2;
  static final int jdField_c_of_type_Int = 3;
  static final int jdField_d_of_type_Int = 4;
  static final int e = 5;
  static final int f = 6;
  static final int g = 7;
  static final int h = 8;
  static final int i = 9;
  static final int j = 10;
  static final int k = 76800;
  static final int l = 921600;
  static final int m = 250;
  static final int n = 1024;
  private int A = -1;
  private int B = -1;
  private int C = 17;
  public Rect a;
  Camera jdField_a_of_type_AndroidHardwareCamera;
  Handler jdField_a_of_type_AndroidOsHandler;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private ScannerView.FileDecodeListener jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener;
  private ScannerView.ScannerListener jdField_a_of_type_ComTencentBizWidgetsScannerView$ScannerListener;
  ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private sz jdField_a_of_type_Sz;
  tb jdField_a_of_type_Tb;
  private th jdField_a_of_type_Th;
  private boolean jdField_a_of_type_Boolean = false;
  public Rect b;
  public Handler b;
  String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_c_of_type_Boolean = false;
  private boolean jdField_d_of_type_Boolean;
  public int o;
  public int p;
  int q;
  int r;
  public int s;
  public int t;
  public int u;
  public int v = 0;
  private int w = 0;
  private int x = 0;
  private int y = 0;
  private int z = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = ScannerView.class.getSimpleName();
  }
  
  public ScannerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.d = false;
    this.jdField_b_of_type_AndroidOsHandler = new sy(this);
    a(paramContext, null);
  }
  
  public ScannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.d = false;
    this.jdField_b_of_type_AndroidOsHandler = new sy(this);
    a(paramContext, paramAttributeSet);
  }
  
  private Point a(Camera paramCamera, int paramInt1, int paramInt2)
  {
    paramCamera = paramCamera.getParameters();
    Camera.Size localSize1 = paramCamera.getPreviewSize();
    if (("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && ("GT-I9008L".equalsIgnoreCase(Build.MODEL)))
    {
      localObject1 = new Point(localSize1.width, localSize1.height);
      return localObject1;
    }
    paramCamera = paramCamera.getSupportedPreviewSizes();
    if (paramCamera == null) {
      return new Point(localSize1.width, localSize1.height);
    }
    Object localObject1 = new ArrayList(paramCamera);
    Collections.sort((List)localObject1, this);
    Object localObject2;
    if (QLog.isDevelopLevel())
    {
      paramCamera = new StringBuilder("manufacturer:").append(Build.MANUFACTURER).append(" model:").append(Build.MODEL).append("\ndefault size:").append(localSize1.width).append(" x ").append(localSize1.height).append("\nsizes:");
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Camera.Size localSize2 = (Camera.Size)((Iterator)localObject2).next();
        paramCamera.append(localSize2.width).append(" x ").append(localSize2.height).append(" | ");
      }
      QLog.d(jdField_a_of_type_JavaLangString, 4, paramCamera.toString());
    }
    paramCamera = null;
    float f3 = paramInt1 / paramInt2;
    float f1 = (1.0F / 1.0F);
    localObject1 = ((List)localObject1).iterator();
    label257:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Camera.Size)((Iterator)localObject1).next();
      int i1 = ((Camera.Size)localObject2).width;
      int i2 = ((Camera.Size)localObject2).height;
      int i3 = i1 * i2;
      if ((i3 >= 76800) && (i3 <= 921600) && ((i1 != 900) || (i2 != 800) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"GT-I9220".equalsIgnoreCase(Build.MODEL)) && (!"GT-N7000".equalsIgnoreCase(Build.MODEL)))) && (((i1 == 1184) && (i2 == 666)) || ((i1 != 704) || (i2 != 576) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9300".equalsIgnoreCase(Build.MODEL)))))
      {
        if (paramInt1 > paramInt2)
        {
          i3 = 1;
          if (i1 >= i2) {
            break label480;
          }
          i4 = 1;
          label435:
          if (i3 != i4) {
            break label486;
          }
          i3 = i1;
        }
        for (int i4 = i2;; i4 = i1)
        {
          if ((i4 != paramInt1) || (i3 != paramInt2)) {
            break label497;
          }
          return new Point(i1, i2);
          i3 = 0;
          break;
          label480:
          i4 = 0;
          break label435;
          label486:
          i3 = i2;
        }
        label497:
        if ((i4 >= paramInt1 >> 1) && (i4 >> 1 <= paramInt1) && (i3 >= paramInt2 >> 1) && (i3 >> 1 <= paramInt2))
        {
          float f2 = Math.abs(i4 / i3 - f3);
          if (f2 >= f1) {
            break label596;
          }
          paramCamera = new Point(i1, i2);
          f1 = f2;
        }
      }
    }
    label596:
    for (;;)
    {
      break label257;
      localObject1 = paramCamera;
      if (paramCamera != null) {
        break;
      }
      return new Point(localSize1.width, localSize1.height);
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i1 = 0;
    setKeepScreenOn(true);
    this.jdField_a_of_type_AndroidViewSurfaceView = new SurfaceView(paramContext, paramAttributeSet);
    addView(this.jdField_a_of_type_AndroidViewSurfaceView);
    Object localObject = this.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    ((SurfaceHolder)localObject).addCallback(this);
    if (Build.VERSION.SDK_INT < 11) {
      ((SurfaceHolder)localObject).setType(3);
    }
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeBooleanValue(0, true)))
    {
      localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.q);
      int i2 = ((TypedArray)localObject).getIndexCount();
      if (i1 < i2)
      {
        int i3 = ((TypedArray)localObject).getIndex(i1);
        switch (i3)
        {
        }
        for (;;)
        {
          i1 += 1;
          break;
          this.z = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.z);
          continue;
          this.x = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.x);
          continue;
          this.y = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.y);
          continue;
          this.w = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.w);
          continue;
          this.A = ((TypedArray)localObject).getLayoutDimension(i3, this.A);
          continue;
          this.B = ((TypedArray)localObject).getLayoutDimension(i3, this.B);
          continue;
          this.C = ((TypedArray)localObject).getInt(i3, this.C);
        }
      }
      ((TypedArray)localObject).recycle();
      this.jdField_a_of_type_Th = new th(paramContext);
      addView(this.jdField_a_of_type_Th);
    }
    if (paramAttributeSet != null) {
      this.jdField_a_of_type_Boolean = paramAttributeSet.getAttributeBooleanValue(8, true);
    }
  }
  
  @TargetApi(9)
  private boolean b()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    label312:
    label319:
    label324:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidHardwareCamera != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "camera already opened");
          }
          return true;
        }
        if (Build.VERSION.SDK_INT >= 9)
        {
          i2 = Camera.getNumberOfCameras();
          if (i2 <= 0) {
            break label319;
          }
          Object localObject1 = new Camera.CameraInfo();
          i1 = 0;
          if (i1 < i2)
          {
            Camera.getCameraInfo(i1, (Camera.CameraInfo)localObject1);
            if (((Camera.CameraInfo)localObject1).facing != 0) {}
          }
          else
          {
            if (i1 < i2) {
              break label312;
            }
            Camera.getCameraInfo(0, (Camera.CameraInfo)localObject1);
            i2 = 0;
            i1 = 1;
            this.jdField_a_of_type_AndroidHardwareCamera = Camera.open(i2);
            i2 = ((Camera.CameraInfo)localObject1).orientation;
            break label324;
            this.q = i2;
            this.r = i1;
            if (QLog.isColorLevel())
            {
              localObject1 = jdField_a_of_type_JavaLangString;
              StringBuilder localStringBuilder = new StringBuilder().append("camera open:");
              if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
                continue;
              }
              bool1 = true;
              QLog.d((String)localObject1, 2, bool1 + " orientation:" + i2 + " facing:" + i1);
            }
            localObject1 = this.jdField_a_of_type_AndroidHardwareCamera;
            bool1 = bool2;
            if (localObject1 != null) {
              bool1 = true;
            }
            return bool1;
          }
          i1 += 1;
          continue;
        }
        else
        {
          this.jdField_a_of_type_AndroidHardwareCamera = Camera.open();
          i1 = 0;
          i2 = 90;
          continue;
        }
        boolean bool1 = false;
        continue;
        i2 = i1;
      }
      catch (RuntimeException localRuntimeException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "camera open failed:" + localRuntimeException.getMessage());
        }
        return false;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
      int i1 = 0;
      continue;
      int i2 = 90;
      i1 = 0;
    }
  }
  
  /* Error */
  @TargetApi(8)
  private boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 345	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull +12 -> 25
    //   16: aload_0
    //   17: getfield 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   20: invokevirtual 355	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 118	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Boolean	Z
    //   29: ifeq +34 -> 63
    //   32: aload_0
    //   33: getfield 402	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Sz	Lsz;
    //   36: ifnull +20 -> 56
    //   39: aload_0
    //   40: getfield 402	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Sz	Lsz;
    //   43: invokevirtual 407	sz:isAlive	()Z
    //   46: ifeq +10 -> 56
    //   49: aload_0
    //   50: getfield 402	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Sz	Lsz;
    //   53: invokevirtual 410	sz:interrupt	()V
    //   56: aload_0
    //   57: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   60: invokevirtual 413	android/hardware/Camera:stopPreview	()V
    //   63: aload_0
    //   64: invokevirtual 417	com/tencent/biz/widgets/ScannerView:getContext	()Landroid/content/Context;
    //   67: ldc_w 419
    //   70: invokevirtual 423	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   73: checkcast 425	android/view/WindowManager
    //   76: invokeinterface 429 1 0
    //   81: invokevirtual 434	android/view/Display:getOrientation	()I
    //   84: bipush 90
    //   86: imul
    //   87: istore_2
    //   88: aload_0
    //   89: getfield 379	com/tencent/biz/widgets/ScannerView:r	I
    //   92: ifne +368 -> 460
    //   95: aload_0
    //   96: getfield 377	com/tencent/biz/widgets/ScannerView:q	I
    //   99: iload_2
    //   100: isub
    //   101: sipush 360
    //   104: iadd
    //   105: sipush 360
    //   108: irem
    //   109: istore_1
    //   110: aload_0
    //   111: iload_1
    //   112: putfield 436	com/tencent/biz/widgets/ScannerView:u	I
    //   115: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +40 -> 158
    //   121: getstatic 76	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   124: iconst_2
    //   125: new 199	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 380	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 438
    //   135: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iload_2
    //   139: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: ldc_w 440
    //   145: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload_1
    //   149: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload_0
    //   159: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   162: invokevirtual 139	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   165: astore_3
    //   166: getstatic 289	android/os/Build$VERSION:SDK_INT	I
    //   169: bipush 8
    //   171: if_icmplt +303 -> 474
    //   174: aload_0
    //   175: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   178: iload_1
    //   179: invokevirtual 443	android/hardware/Camera:setDisplayOrientation	(I)V
    //   182: aload_3
    //   183: invokevirtual 446	android/hardware/Camera$Parameters:isZoomSupported	()Z
    //   186: ifeq +15 -> 201
    //   189: aload_3
    //   190: iconst_2
    //   191: aload_3
    //   192: invokevirtual 449	android/hardware/Camera$Parameters:getMaxZoom	()I
    //   195: invokestatic 452	java/lang/Math:min	(II)I
    //   198: invokevirtual 455	android/hardware/Camera$Parameters:setZoom	(I)V
    //   201: aload_0
    //   202: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   205: aload_3
    //   206: invokevirtual 459	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   209: aload_0
    //   210: aload_0
    //   211: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   214: aload_0
    //   215: getfield 461	com/tencent/biz/widgets/ScannerView:s	I
    //   218: aload_0
    //   219: getfield 463	com/tencent/biz/widgets/ScannerView:t	I
    //   222: invokespecial 465	com/tencent/biz/widgets/ScannerView:a	(Landroid/hardware/Camera;II)Landroid/graphics/Point;
    //   225: astore_3
    //   226: aload_0
    //   227: aload_3
    //   228: getfield 466	android/graphics/Point:x	I
    //   231: putfield 468	com/tencent/biz/widgets/ScannerView:o	I
    //   234: aload_0
    //   235: aload_3
    //   236: getfield 469	android/graphics/Point:y	I
    //   239: putfield 471	com/tencent/biz/widgets/ScannerView:p	I
    //   242: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +45 -> 290
    //   248: getstatic 76	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   251: iconst_2
    //   252: new 199	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 380	java/lang/StringBuilder:<init>	()V
    //   259: ldc_w 473
    //   262: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_3
    //   266: getfield 466	android/graphics/Point:x	I
    //   269: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: ldc 217
    //   274: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_3
    //   278: getfield 469	android/graphics/Point:y	I
    //   281: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: aload_0
    //   291: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   294: invokevirtual 139	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   297: astore 4
    //   299: aload 4
    //   301: aload_3
    //   302: getfield 466	android/graphics/Point:x	I
    //   305: aload_3
    //   306: getfield 469	android/graphics/Point:y	I
    //   309: invokevirtual 476	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   312: aload_0
    //   313: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   316: aload 4
    //   318: invokevirtual 459	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   321: aload_0
    //   322: getfield 478	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   325: astore 5
    //   327: aload 5
    //   329: astore_3
    //   330: aload 5
    //   332: ifnonnull +51 -> 383
    //   335: aload_0
    //   336: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   339: invokevirtual 139	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   342: astore 6
    //   344: aload 6
    //   346: invokevirtual 481	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   349: astore 7
    //   351: aload 7
    //   353: ifnonnull +220 -> 573
    //   356: aload 5
    //   358: astore_3
    //   359: aload_3
    //   360: ifnull +288 -> 648
    //   363: aload_3
    //   364: astore 4
    //   366: aload_0
    //   367: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   370: aload 6
    //   372: invokevirtual 459	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   375: aload_3
    //   376: astore 4
    //   378: aload_0
    //   379: aload_3
    //   380: putfield 478	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   383: aload_0
    //   384: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   387: aload_0
    //   388: getfield 270	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidViewSurfaceView	Landroid/view/SurfaceView;
    //   391: invokevirtual 278	android/view/SurfaceView:getHolder	()Landroid/view/SurfaceHolder;
    //   394: invokevirtual 485	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   397: aload_0
    //   398: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   401: invokevirtual 488	android/hardware/Camera:startPreview	()V
    //   404: aload_0
    //   405: iconst_1
    //   406: putfield 118	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Boolean	Z
    //   409: ldc_w 490
    //   412: aload_3
    //   413: invokevirtual 494	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   416: ifne +13 -> 429
    //   419: ldc_w 496
    //   422: aload_3
    //   423: invokevirtual 494	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   426: ifeq +25 -> 451
    //   429: aload_0
    //   430: new 404	sz
    //   433: dup
    //   434: aload_0
    //   435: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   438: invokespecial 499	sz:<init>	(Landroid/hardware/Camera;)V
    //   441: putfield 402	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Sz	Lsz;
    //   444: aload_0
    //   445: getfield 402	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Sz	Lsz;
    //   448: invokevirtual 502	sz:start	()V
    //   451: aload_0
    //   452: getfield 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   455: invokevirtual 355	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   458: iconst_1
    //   459: ireturn
    //   460: aload_0
    //   461: getfield 377	com/tencent/biz/widgets/ScannerView:q	I
    //   464: iload_2
    //   465: iadd
    //   466: sipush 360
    //   469: irem
    //   470: istore_1
    //   471: goto -361 -> 110
    //   474: iload_2
    //   475: sipush 180
    //   478: irem
    //   479: ifne +13 -> 492
    //   482: aload_3
    //   483: ldc_w 503
    //   486: ldc_w 505
    //   489: invokevirtual 509	android/hardware/Camera$Parameters:set	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: aload_3
    //   493: iload_1
    //   494: invokevirtual 512	android/hardware/Camera$Parameters:setRotation	(I)V
    //   497: goto -296 -> 201
    //   500: astore_3
    //   501: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   504: ifeq +13 -> 517
    //   507: getstatic 76	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   510: iconst_2
    //   511: ldc_w 514
    //   514: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: aload_0
    //   518: getfield 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   521: invokevirtual 355	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   524: iconst_0
    //   525: ireturn
    //   526: astore_3
    //   527: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   530: ifeq -209 -> 321
    //   533: getstatic 76	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   536: iconst_2
    //   537: ldc_w 516
    //   540: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   543: goto -222 -> 321
    //   546: astore_3
    //   547: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq +13 -> 563
    //   553: getstatic 76	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   556: iconst_2
    //   557: ldc_w 514
    //   560: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   563: aload_0
    //   564: getfield 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   567: invokevirtual 355	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   570: goto -46 -> 524
    //   573: aload 5
    //   575: astore 4
    //   577: aload 7
    //   579: ldc_w 490
    //   582: invokeinterface 519 2 0
    //   587: ifeq +10 -> 597
    //   590: ldc_w 490
    //   593: astore_3
    //   594: goto -235 -> 359
    //   597: aload 5
    //   599: astore 4
    //   601: aload 7
    //   603: ldc_w 496
    //   606: invokeinterface 519 2 0
    //   611: ifeq +10 -> 621
    //   614: ldc_w 496
    //   617: astore_3
    //   618: goto -259 -> 359
    //   621: aload 5
    //   623: astore_3
    //   624: aload 5
    //   626: astore 4
    //   628: aload 7
    //   630: ldc_w 521
    //   633: invokeinterface 519 2 0
    //   638: ifeq -279 -> 359
    //   641: ldc_w 521
    //   644: astore_3
    //   645: goto -286 -> 359
    //   648: aload_3
    //   649: astore 4
    //   651: aload_0
    //   652: ldc_w 523
    //   655: putfield 478	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   658: goto -275 -> 383
    //   661: astore_3
    //   662: aload 4
    //   664: astore_3
    //   665: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   668: ifeq -285 -> 383
    //   671: getstatic 76	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   674: iconst_2
    //   675: new 199	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 380	java/lang/StringBuilder:<init>	()V
    //   682: ldc_w 525
    //   685: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: aload 4
    //   690: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: ldc_w 527
    //   696: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   705: aload 4
    //   707: astore_3
    //   708: goto -325 -> 383
    //   711: astore_3
    //   712: aload_0
    //   713: getfield 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   716: invokevirtual 355	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   719: aload_3
    //   720: athrow
    //   721: astore_3
    //   722: goto -513 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	725	0	this	ScannerView
    //   109	385	1	i1	int
    //   87	392	2	i2	int
    //   11	482	3	localObject1	Object
    //   500	1	3	localIOException	java.io.IOException
    //   526	1	3	localRuntimeException1	RuntimeException
    //   546	1	3	localRuntimeException2	RuntimeException
    //   593	56	3	localObject2	Object
    //   661	1	3	localRuntimeException3	RuntimeException
    //   664	44	3	localObject3	Object
    //   711	9	3	localObject4	Object
    //   721	1	3	localRuntimeException4	RuntimeException
    //   297	409	4	localObject5	Object
    //   325	300	5	str	String
    //   342	29	6	localParameters	Camera.Parameters
    //   349	280	7	localList	List
    // Exception table:
    //   from	to	target	type
    //   7	12	500	java/io/IOException
    //   25	56	500	java/io/IOException
    //   56	63	500	java/io/IOException
    //   63	110	500	java/io/IOException
    //   110	158	500	java/io/IOException
    //   158	201	500	java/io/IOException
    //   201	209	500	java/io/IOException
    //   209	290	500	java/io/IOException
    //   290	321	500	java/io/IOException
    //   321	327	500	java/io/IOException
    //   335	351	500	java/io/IOException
    //   366	375	500	java/io/IOException
    //   378	383	500	java/io/IOException
    //   383	429	500	java/io/IOException
    //   429	451	500	java/io/IOException
    //   460	471	500	java/io/IOException
    //   482	492	500	java/io/IOException
    //   492	497	500	java/io/IOException
    //   527	543	500	java/io/IOException
    //   577	590	500	java/io/IOException
    //   601	614	500	java/io/IOException
    //   628	641	500	java/io/IOException
    //   651	658	500	java/io/IOException
    //   665	705	500	java/io/IOException
    //   290	321	526	java/lang/RuntimeException
    //   7	12	546	java/lang/RuntimeException
    //   25	56	546	java/lang/RuntimeException
    //   56	63	546	java/lang/RuntimeException
    //   63	110	546	java/lang/RuntimeException
    //   110	158	546	java/lang/RuntimeException
    //   158	201	546	java/lang/RuntimeException
    //   209	290	546	java/lang/RuntimeException
    //   321	327	546	java/lang/RuntimeException
    //   335	351	546	java/lang/RuntimeException
    //   383	429	546	java/lang/RuntimeException
    //   429	451	546	java/lang/RuntimeException
    //   460	471	546	java/lang/RuntimeException
    //   482	492	546	java/lang/RuntimeException
    //   492	497	546	java/lang/RuntimeException
    //   527	543	546	java/lang/RuntimeException
    //   665	705	546	java/lang/RuntimeException
    //   366	375	661	java/lang/RuntimeException
    //   378	383	661	java/lang/RuntimeException
    //   577	590	661	java/lang/RuntimeException
    //   601	614	661	java/lang/RuntimeException
    //   628	641	661	java/lang/RuntimeException
    //   651	658	661	java/lang/RuntimeException
    //   7	12	711	finally
    //   25	56	711	finally
    //   56	63	711	finally
    //   63	110	711	finally
    //   110	158	711	finally
    //   158	201	711	finally
    //   201	209	711	finally
    //   209	290	711	finally
    //   290	321	711	finally
    //   321	327	711	finally
    //   335	351	711	finally
    //   366	375	711	finally
    //   378	383	711	finally
    //   383	429	711	finally
    //   429	451	711	finally
    //   460	471	711	finally
    //   482	492	711	finally
    //   492	497	711	finally
    //   501	517	711	finally
    //   527	543	711	finally
    //   547	563	711	finally
    //   577	590	711	finally
    //   601	614	711	finally
    //   628	641	711	finally
    //   651	658	711	finally
    //   665	705	711	finally
    //   201	209	721	java/lang/RuntimeException
  }
  
  private void d()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new RuntimeException("This method must be called on UI thread");
    }
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 345	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +11 -> 24
    //   16: aload_0
    //   17: getfield 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   20: invokevirtual 355	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   23: return
    //   24: aload_0
    //   25: getfield 402	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Sz	Lsz;
    //   28: ifnull +20 -> 48
    //   31: aload_0
    //   32: getfield 402	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Sz	Lsz;
    //   35: invokevirtual 407	sz:isAlive	()Z
    //   38: ifeq +10 -> 48
    //   41: aload_0
    //   42: getfield 402	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Sz	Lsz;
    //   45: invokevirtual 410	sz:interrupt	()V
    //   48: aload_0
    //   49: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   52: invokevirtual 139	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   55: astore_1
    //   56: aload_1
    //   57: ldc_w 541
    //   60: invokevirtual 544	android/hardware/Camera$Parameters:setFlashMode	(Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   67: aload_1
    //   68: invokevirtual 459	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 120	com/tencent/biz/widgets/ScannerView:d	Z
    //   76: aload_0
    //   77: getfield 118	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Boolean	Z
    //   80: ifeq +15 -> 95
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 118	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Boolean	Z
    //   88: aload_0
    //   89: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   92: invokevirtual 413	android/hardware/Camera:stopPreview	()V
    //   95: aload_0
    //   96: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   99: invokevirtual 547	android/hardware/Camera:release	()V
    //   102: aload_0
    //   103: aconst_null
    //   104: putfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   107: aload_0
    //   108: getfield 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   111: invokevirtual 355	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   114: return
    //   115: astore_1
    //   116: aload_0
    //   117: getfield 87	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   120: invokevirtual 355	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: goto -50 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	ScannerView
    //   11	57	1	localObject1	Object
    //   115	9	1	localObject2	Object
    //   125	1	1	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   7	12	115	finally
    //   24	48	115	finally
    //   48	76	115	finally
    //   76	95	115	finally
    //   95	107	115	finally
    //   48	76	125	java/lang/RuntimeException
  }
  
  public int a(Camera.Size paramSize1, Camera.Size paramSize2)
  {
    int i1 = paramSize1.height * paramSize1.width;
    int i2 = paramSize2.height * paramSize2.width;
    if (i2 < i1) {
      return 1;
    }
    if (i2 > i1) {
      return -1;
    }
    return 0;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean)
    {
      if ((b()) && (c()))
      {
        if (this.jdField_a_of_type_Th != null) {
          this.jdField_a_of_type_Th.a();
        }
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(7);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  public void a(String paramString)
  {
    paramString = Uri.parse("file://" + paramString);
    if (this.jdField_a_of_type_Tb == null) {}
    try
    {
      if (this.jdField_a_of_type_Tb == null)
      {
        this.jdField_a_of_type_Tb = new tb("ScannerDecodeThread");
        this.jdField_a_of_type_Tb.start();
        this.jdField_a_of_type_AndroidOsHandler = new ta(this, this.jdField_a_of_type_Tb.getLooper());
      }
      if (this.jdField_a_of_type_Tb.jdField_a_of_type_Boolean) {
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, paramString).sendToTarget();
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
          if ((((Camera.Parameters)localObject).getSupportedFlashModes() == null) || (!getContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash")))
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
    boolean bool;
    if (localCamera == null) {
      bool = false;
    }
    do
    {
      return bool;
      bool = paramBoolean;
    } while (this.d == paramBoolean);
    if ((this.jdField_a_of_type_Sz != null) && (this.jdField_a_of_type_Sz.isAlive())) {
      this.jdField_a_of_type_Sz.interrupt();
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
      if ((this.jdField_c_of_type_Boolean) && (("auto".equals(this.jdField_b_of_type_JavaLangString)) || ("macro".equals(this.jdField_b_of_type_JavaLangString))))
      {
        this.jdField_a_of_type_Sz = new sz(this.jdField_a_of_type_AndroidHardwareCamera);
        this.jdField_a_of_type_Sz.start();
      }
      this.d = paramBoolean;
      return paramBoolean;
      str = "off";
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    e();
    if (this.jdField_a_of_type_Th != null) {
      this.jdField_a_of_type_Th.b();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Tb == null) {}
    do
    {
      try
      {
        if (this.jdField_a_of_type_Tb == null)
        {
          this.jdField_a_of_type_Tb = new tb("ScannerDecodeThread");
          this.jdField_a_of_type_Tb.start();
          this.jdField_a_of_type_AndroidOsHandler = new ta(this, this.jdField_a_of_type_Tb.getLooper());
        }
        if (this.jdField_a_of_type_Tb.jdField_a_of_type_Boolean) {
          return;
        }
      }
      finally {}
    } while (!this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.tryLock());
    try
    {
      Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
      if (localCamera == null) {
        return;
      }
      this.jdField_a_of_type_AndroidHardwareCamera.setOneShotPreviewCallback(this);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    try
    {
      if ((this.jdField_a_of_type_Tb != null) && (!this.jdField_a_of_type_Tb.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Tb.quit();
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return;
    }
    finally {}
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewSurfaceView.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (this.jdField_a_of_type_Th != null)
    {
      this.jdField_a_of_type_Th.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
      if (this.A != -1) {
        break label167;
      }
      int i1 = this.x;
      paramInt1 = paramInt3 - paramInt1 - this.y;
      paramInt3 = i1;
      if (this.B != -1) {
        break label249;
      }
      i1 = this.w;
      paramInt2 = paramInt4 - paramInt2 - this.z;
      paramInt4 = i1;
    }
    for (;;)
    {
      Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.jdField_c_of_type_AndroidGraphicsRect == null) {
        this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
      }
      this.jdField_c_of_type_AndroidGraphicsRect.set(paramInt3, paramInt4, paramInt1, paramInt2);
      this.jdField_a_of_type_AndroidGraphicsRect = this.jdField_c_of_type_AndroidGraphicsRect;
      this.jdField_c_of_type_AndroidGraphicsRect = localRect;
      this.jdField_b_of_type_AndroidGraphicsRect = null;
      this.jdField_a_of_type_Th.a(paramInt3, paramInt4, paramInt1, paramInt2);
      return;
      label167:
      if ((this.C & 0x3) == 3)
      {
        paramInt3 = this.x;
        paramInt1 = this.A + paramInt3;
        break;
      }
      if ((this.C & 0x5) == 5)
      {
        paramInt1 = paramInt3 - paramInt1 - this.y;
        paramInt3 = paramInt1 - this.A;
        break;
      }
      paramInt3 = paramInt3 - paramInt1 - this.A >> 1;
      paramInt1 = this.A + paramInt3;
      break;
      label249:
      if ((this.C & 0x30) == 48)
      {
        paramInt4 = this.w;
        paramInt2 = this.B + paramInt4;
      }
      else if ((this.C & 0x50) == 80)
      {
        paramInt2 = paramInt4 - paramInt2 - this.z;
        paramInt4 = paramInt2 - this.B;
      }
      else
      {
        paramInt4 = paramInt4 - paramInt2 - this.B >> 1;
        paramInt2 = this.B + paramInt4;
      }
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, this.o, this.p, paramArrayOfByte).sendToTarget();
    }
  }
  
  public void setFileDecodeListener(ScannerView.FileDecodeListener paramFileDecodeListener)
  {
    d();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener = paramFileDecodeListener;
  }
  
  public void setScanListener(ScannerView.ScannerListener paramScannerListener)
  {
    d();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView$ScannerListener = paramScannerListener;
  }
  
  public void setViewFinder(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    d();
    this.C = 51;
    this.x = paramInt1;
    this.w = paramInt2;
    this.A = (paramInt3 - paramInt1);
    this.B = (paramInt4 - paramInt2);
    this.y = 0;
    this.z = 0;
    if (this.jdField_a_of_type_Th == null)
    {
      this.jdField_a_of_type_Th = new th(getContext());
      addView(this.jdField_a_of_type_Th);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_Th.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.s = paramInt2;
    this.t = paramInt3;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_c_of_type_Boolean) {
        break label75;
      }
      if ((!b()) || (!c())) {
        break label64;
      }
      if (this.jdField_a_of_type_Th != null) {
        this.jdField_a_of_type_Th.a();
      }
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(7);
    }
    label64:
    label75:
    while (c())
    {
      return;
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(8);
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_b_of_type_Boolean = false;
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView
 * JD-Core Version:    0.7.0.1
 */