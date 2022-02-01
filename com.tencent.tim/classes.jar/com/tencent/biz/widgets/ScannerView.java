package com.tencent.biz.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup;
import aqoo;
import aqoq;
import asfh;
import atau.a;
import auqz;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;
import swd;

public class ScannerView
  extends ViewGroup
  implements Camera.PreviewCallback, SurfaceHolder.Callback, Comparator<Camera.Size>
{
  public StringBuilder B;
  protected long DG;
  private AutoFocusThread jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread;
  DecodeThread jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread;
  private b jdField_a_of_type_ComTencentBizWidgetsScannerView$b;
  private c jdField_a_of_type_ComTencentBizWidgetsScannerView$c;
  private d jdField_a_of_type_ComTencentBizWidgetsScannerView$d;
  private e jdField_a_of_type_ComTencentBizWidgetsScannerView$e;
  private ViewFinderView jdField_a_of_type_ComTencentBizWidgetsViewFinderView;
  String aHC;
  Handler aJ = new swd(this);
  private boolean aND;
  private boolean aNE;
  private boolean aNF;
  private boolean aNG = true;
  private boolean aNH = true;
  private boolean aNI;
  Rect aO = null;
  Rect aP = null;
  Rect aQ = new Rect();
  Handler by;
  private int bzA;
  private int bzB;
  private int bzC;
  private int bzD = -1;
  private int bzE = -1;
  private int bzF = 17;
  int bzw;
  int bzx;
  int bzy = 0;
  private int bzz;
  Camera mCamera;
  int mCameraFacing;
  private boolean mHasSurface;
  private boolean mInitialized;
  private float mLastX;
  private float mLastY;
  ReentrantLock mLock = new ReentrantLock();
  int mPreviewHeight;
  int mPreviewWidth;
  private SensorManager mSensorManager;
  protected long mStartTime;
  int mSurfaceHeight;
  private SurfaceView mSurfaceView;
  int mSurfaceWidth;
  private float ov;
  
  public ScannerView(Context paramContext)
  {
    super(paramContext);
    b(paramContext, null);
  }
  
  public ScannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
  }
  
  @TargetApi(9)
  private boolean Nq()
  {
    boolean bool2 = false;
    this.mLock.lock();
    label325:
    label332:
    label337:
    for (;;)
    {
      try
      {
        if (this.mCamera != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ScannerView", 2, "camera already opened");
          }
          return true;
        }
        if (Build.VERSION.SDK_INT >= 9)
        {
          j = Camera.getNumberOfCameras();
          if (j <= 0) {
            break label332;
          }
          Object localObject1 = new Camera.CameraInfo();
          i = 0;
          if (i < j)
          {
            Camera.getCameraInfo(i, (Camera.CameraInfo)localObject1);
            if (((Camera.CameraInfo)localObject1).facing != 0) {}
          }
          else
          {
            if (i < j) {
              break label325;
            }
            Camera.getCameraInfo(0, (Camera.CameraInfo)localObject1);
            j = 0;
            i = 1;
            this.mCamera = auqz.a(j);
            k = ((Camera.CameraInfo)localObject1).orientation;
            j = i;
            i = k;
            break label337;
            if (aqoq.eaK <= 0) {
              continue;
            }
            k = aqoq.eaK;
            this.bzw = k;
            this.mCameraFacing = j;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder().append("camera open:");
              if (this.mCamera == null) {
                continue;
              }
              bool1 = true;
              QLog.d("ScannerView", 2, bool1 + " orientation:" + i + " facing:" + j);
            }
            localObject1 = this.mCamera;
            bool1 = bool2;
            if (localObject1 != null) {
              bool1 = true;
            }
            return bool1;
          }
          i += 1;
          continue;
        }
        else
        {
          this.mCamera = auqz.a();
          j = 0;
          i = 90;
          continue;
        }
        int k = i;
        continue;
        boolean bool1 = false;
        continue;
        j = i;
      }
      catch (RuntimeException localRuntimeException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScannerView", 2, "camera open failed:" + localRuntimeException.getMessage());
        }
        return false;
      }
      finally
      {
        this.mLock.unlock();
      }
      int i = 0;
      continue;
      i = 90;
      int j = 0;
    }
  }
  
  /* Error */
  @TargetApi(8)
  private boolean Nr()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 101	com/tencent/biz/widgets/ScannerView:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 145	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull +12 -> 25
    //   16: aload_0
    //   17: getfield 101	com/tencent/biz/widgets/ScannerView:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   20: invokevirtual 162	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 238	com/tencent/biz/widgets/ScannerView:aNE	Z
    //   29: ifeq +34 -> 63
    //   32: aload_0
    //   33: getfield 240	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   36: ifnull +20 -> 56
    //   39: aload_0
    //   40: getfield 240	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   43: invokevirtual 243	com/tencent/biz/widgets/ScannerView$AutoFocusThread:isAlive	()Z
    //   46: ifeq +10 -> 56
    //   49: aload_0
    //   50: getfield 240	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   53: invokevirtual 246	com/tencent/biz/widgets/ScannerView$AutoFocusThread:interrupt	()V
    //   56: aload_0
    //   57: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   60: invokevirtual 249	android/hardware/Camera:stopPreview	()V
    //   63: aload_0
    //   64: invokevirtual 253	com/tencent/biz/widgets/ScannerView:getContext	()Landroid/content/Context;
    //   67: ldc 255
    //   69: invokevirtual 261	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   72: checkcast 263	android/view/WindowManager
    //   75: invokeinterface 267 1 0
    //   80: invokevirtual 272	android/view/Display:getOrientation	()I
    //   83: bipush 90
    //   85: imul
    //   86: istore_2
    //   87: aload_0
    //   88: getfield 200	com/tencent/biz/widgets/ScannerView:mCameraFacing	I
    //   91: ifne +368 -> 459
    //   94: aload_0
    //   95: getfield 198	com/tencent/biz/widgets/ScannerView:bzw	I
    //   98: iload_2
    //   99: isub
    //   100: sipush 360
    //   103: iadd
    //   104: sipush 360
    //   107: irem
    //   108: istore_1
    //   109: aload_0
    //   110: iload_1
    //   111: putfield 274	com/tencent/biz/widgets/ScannerView:bzx	I
    //   114: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +39 -> 156
    //   120: ldc 154
    //   122: iconst_2
    //   123: new 202	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 276
    //   133: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload_2
    //   137: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: ldc_w 278
    //   143: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: iload_1
    //   147: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload_0
    //   157: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   160: invokevirtual 282	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   163: astore_3
    //   164: getstatic 167	android/os/Build$VERSION:SDK_INT	I
    //   167: bipush 8
    //   169: if_icmplt +304 -> 473
    //   172: aload_0
    //   173: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   176: iload_1
    //   177: invokevirtual 286	android/hardware/Camera:setDisplayOrientation	(I)V
    //   180: aload_3
    //   181: invokevirtual 291	android/hardware/Camera$Parameters:isZoomSupported	()Z
    //   184: ifeq +15 -> 199
    //   187: aload_3
    //   188: iconst_2
    //   189: aload_3
    //   190: invokevirtual 294	android/hardware/Camera$Parameters:getMaxZoom	()I
    //   193: invokestatic 300	java/lang/Math:min	(II)I
    //   196: invokevirtual 303	android/hardware/Camera$Parameters:setZoom	(I)V
    //   199: aload_0
    //   200: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   203: aload_3
    //   204: invokevirtual 307	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   207: aload_0
    //   208: aload_0
    //   209: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   212: aload_0
    //   213: getfield 309	com/tencent/biz/widgets/ScannerView:mSurfaceWidth	I
    //   216: aload_0
    //   217: getfield 311	com/tencent/biz/widgets/ScannerView:mSurfaceHeight	I
    //   220: invokespecial 314	com/tencent/biz/widgets/ScannerView:a	(Landroid/hardware/Camera;II)Landroid/graphics/Point;
    //   223: astore_3
    //   224: aload_0
    //   225: aload_3
    //   226: getfield 319	android/graphics/Point:x	I
    //   229: putfield 321	com/tencent/biz/widgets/ScannerView:mPreviewWidth	I
    //   232: aload_0
    //   233: aload_3
    //   234: getfield 324	android/graphics/Point:y	I
    //   237: putfield 326	com/tencent/biz/widgets/ScannerView:mPreviewHeight	I
    //   240: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +45 -> 288
    //   246: ldc 154
    //   248: iconst_2
    //   249: new 202	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 328
    //   259: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_3
    //   263: getfield 319	android/graphics/Point:x	I
    //   266: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   269: ldc_w 330
    //   272: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_3
    //   276: getfield 324	android/graphics/Point:y	I
    //   279: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload_0
    //   289: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   292: invokevirtual 282	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   295: astore 4
    //   297: aload 4
    //   299: aload_3
    //   300: getfield 319	android/graphics/Point:x	I
    //   303: aload_3
    //   304: getfield 324	android/graphics/Point:y	I
    //   307: invokevirtual 334	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   310: aload_0
    //   311: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   314: aload 4
    //   316: invokevirtual 307	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   319: aload_0
    //   320: getfield 336	com/tencent/biz/widgets/ScannerView:aHC	Ljava/lang/String;
    //   323: astore 5
    //   325: aload 5
    //   327: astore_3
    //   328: aload 5
    //   330: ifnonnull +51 -> 381
    //   333: aload_0
    //   334: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   337: invokevirtual 282	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   340: astore 6
    //   342: aload 6
    //   344: invokevirtual 340	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   347: astore 7
    //   349: aload 7
    //   351: ifnonnull +218 -> 569
    //   354: aload 5
    //   356: astore_3
    //   357: aload_3
    //   358: ifnull +262 -> 620
    //   361: aload_3
    //   362: astore 4
    //   364: aload_0
    //   365: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   368: aload 6
    //   370: invokevirtual 307	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   373: aload_3
    //   374: astore 4
    //   376: aload_0
    //   377: aload_3
    //   378: putfield 336	com/tencent/biz/widgets/ScannerView:aHC	Ljava/lang/String;
    //   381: aload_0
    //   382: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   385: aload_0
    //   386: getfield 342	com/tencent/biz/widgets/ScannerView:mSurfaceView	Landroid/view/SurfaceView;
    //   389: invokevirtual 348	android/view/SurfaceView:getHolder	()Landroid/view/SurfaceHolder;
    //   392: invokevirtual 352	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   395: aload_0
    //   396: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   399: invokevirtual 355	android/hardware/Camera:startPreview	()V
    //   402: aload_0
    //   403: iconst_1
    //   404: putfield 238	com/tencent/biz/widgets/ScannerView:aNE	Z
    //   407: ldc_w 357
    //   410: aload_3
    //   411: invokevirtual 363	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   414: ifne +13 -> 427
    //   417: ldc_w 365
    //   420: aload_3
    //   421: invokevirtual 363	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   424: ifeq +26 -> 450
    //   427: aload_0
    //   428: new 13	com/tencent/biz/widgets/ScannerView$AutoFocusThread
    //   431: dup
    //   432: aload_0
    //   433: aload_0
    //   434: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   437: invokespecial 368	com/tencent/biz/widgets/ScannerView$AutoFocusThread:<init>	(Lcom/tencent/biz/widgets/ScannerView;Landroid/hardware/Camera;)V
    //   440: putfield 240	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   443: aload_0
    //   444: getfield 240	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   447: invokevirtual 371	com/tencent/biz/widgets/ScannerView$AutoFocusThread:start	()V
    //   450: aload_0
    //   451: getfield 101	com/tencent/biz/widgets/ScannerView:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   454: invokevirtual 162	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   457: iconst_1
    //   458: ireturn
    //   459: aload_0
    //   460: getfield 198	com/tencent/biz/widgets/ScannerView:bzw	I
    //   463: iload_2
    //   464: iadd
    //   465: sipush 360
    //   468: irem
    //   469: istore_1
    //   470: goto -361 -> 109
    //   473: iload_2
    //   474: sipush 180
    //   477: irem
    //   478: ifne +13 -> 491
    //   481: aload_3
    //   482: ldc_w 372
    //   485: ldc_w 374
    //   488: invokevirtual 378	android/hardware/Camera$Parameters:set	(Ljava/lang/String;Ljava/lang/String;)V
    //   491: aload_3
    //   492: iload_1
    //   493: invokevirtual 381	android/hardware/Camera$Parameters:setRotation	(I)V
    //   496: goto -297 -> 199
    //   499: astore_3
    //   500: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +12 -> 515
    //   506: ldc 154
    //   508: iconst_2
    //   509: ldc_w 383
    //   512: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: aload_0
    //   516: getfield 101	com/tencent/biz/widgets/ScannerView:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   519: invokevirtual 162	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   522: iconst_0
    //   523: ireturn
    //   524: astore_3
    //   525: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   528: ifeq -209 -> 319
    //   531: ldc 154
    //   533: iconst_2
    //   534: ldc_w 385
    //   537: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   540: goto -221 -> 319
    //   543: astore_3
    //   544: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +12 -> 559
    //   550: ldc 154
    //   552: iconst_2
    //   553: ldc_w 383
    //   556: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: aload_0
    //   560: getfield 101	com/tencent/biz/widgets/ScannerView:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   563: invokevirtual 162	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   566: goto -44 -> 522
    //   569: aload 5
    //   571: astore 4
    //   573: aload 7
    //   575: ldc_w 357
    //   578: invokeinterface 390 2 0
    //   583: ifeq +10 -> 593
    //   586: ldc_w 357
    //   589: astore_3
    //   590: goto -233 -> 357
    //   593: aload 5
    //   595: astore_3
    //   596: aload 5
    //   598: astore 4
    //   600: aload 7
    //   602: ldc_w 392
    //   605: invokeinterface 390 2 0
    //   610: ifeq -253 -> 357
    //   613: ldc_w 392
    //   616: astore_3
    //   617: goto -260 -> 357
    //   620: aload_3
    //   621: astore 4
    //   623: aload_0
    //   624: ldc_w 394
    //   627: putfield 336	com/tencent/biz/widgets/ScannerView:aHC	Ljava/lang/String;
    //   630: goto -249 -> 381
    //   633: astore_3
    //   634: aload 4
    //   636: astore_3
    //   637: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   640: ifeq -259 -> 381
    //   643: ldc 154
    //   645: iconst_2
    //   646: new 202	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   653: ldc_w 396
    //   656: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload 4
    //   661: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: ldc_w 398
    //   667: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   676: aload 4
    //   678: astore_3
    //   679: goto -298 -> 381
    //   682: astore_3
    //   683: aload_0
    //   684: getfield 101	com/tencent/biz/widgets/ScannerView:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   687: invokevirtual 162	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   690: aload_3
    //   691: athrow
    //   692: astore_3
    //   693: goto -486 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	696	0	this	ScannerView
    //   108	385	1	i	int
    //   86	392	2	j	int
    //   11	481	3	localObject1	Object
    //   499	1	3	localIOException	java.io.IOException
    //   524	1	3	localRuntimeException1	RuntimeException
    //   543	1	3	localRuntimeException2	RuntimeException
    //   589	32	3	localObject2	Object
    //   633	1	3	localRuntimeException3	RuntimeException
    //   636	43	3	localObject3	Object
    //   682	9	3	localObject4	Object
    //   692	1	3	localRuntimeException4	RuntimeException
    //   295	382	4	localObject5	Object
    //   323	274	5	str	String
    //   340	29	6	localParameters	Camera.Parameters
    //   347	254	7	localList	List
    // Exception table:
    //   from	to	target	type
    //   7	12	499	java/io/IOException
    //   25	56	499	java/io/IOException
    //   56	63	499	java/io/IOException
    //   63	109	499	java/io/IOException
    //   109	156	499	java/io/IOException
    //   156	199	499	java/io/IOException
    //   199	207	499	java/io/IOException
    //   207	288	499	java/io/IOException
    //   288	319	499	java/io/IOException
    //   319	325	499	java/io/IOException
    //   333	349	499	java/io/IOException
    //   364	373	499	java/io/IOException
    //   376	381	499	java/io/IOException
    //   381	427	499	java/io/IOException
    //   427	450	499	java/io/IOException
    //   459	470	499	java/io/IOException
    //   481	491	499	java/io/IOException
    //   491	496	499	java/io/IOException
    //   525	540	499	java/io/IOException
    //   573	586	499	java/io/IOException
    //   600	613	499	java/io/IOException
    //   623	630	499	java/io/IOException
    //   637	676	499	java/io/IOException
    //   288	319	524	java/lang/RuntimeException
    //   7	12	543	java/lang/RuntimeException
    //   25	56	543	java/lang/RuntimeException
    //   56	63	543	java/lang/RuntimeException
    //   63	109	543	java/lang/RuntimeException
    //   109	156	543	java/lang/RuntimeException
    //   156	199	543	java/lang/RuntimeException
    //   207	288	543	java/lang/RuntimeException
    //   319	325	543	java/lang/RuntimeException
    //   333	349	543	java/lang/RuntimeException
    //   381	427	543	java/lang/RuntimeException
    //   427	450	543	java/lang/RuntimeException
    //   459	470	543	java/lang/RuntimeException
    //   481	491	543	java/lang/RuntimeException
    //   491	496	543	java/lang/RuntimeException
    //   525	540	543	java/lang/RuntimeException
    //   637	676	543	java/lang/RuntimeException
    //   364	373	633	java/lang/RuntimeException
    //   376	381	633	java/lang/RuntimeException
    //   573	586	633	java/lang/RuntimeException
    //   600	613	633	java/lang/RuntimeException
    //   623	630	633	java/lang/RuntimeException
    //   7	12	682	finally
    //   25	56	682	finally
    //   56	63	682	finally
    //   63	109	682	finally
    //   109	156	682	finally
    //   156	199	682	finally
    //   199	207	682	finally
    //   207	288	682	finally
    //   288	319	682	finally
    //   319	325	682	finally
    //   333	349	682	finally
    //   364	373	682	finally
    //   376	381	682	finally
    //   381	427	682	finally
    //   427	450	682	finally
    //   459	470	682	finally
    //   481	491	682	finally
    //   491	496	682	finally
    //   500	515	682	finally
    //   525	540	682	finally
    //   544	559	682	finally
    //   573	586	682	finally
    //   600	613	682	finally
    //   623	630	682	finally
    //   637	676	682	finally
    //   199	207	692	java/lang/RuntimeException
  }
  
  private static boolean Ns()
  {
    if (("Lenovo K50-t5".equalsIgnoreCase(Build.MODEL)) && ("LENOVO".equalsIgnoreCase(Build.MANUFACTURER))) {}
    while (("Redmi Note 3".equalsIgnoreCase(Build.MODEL)) && ("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER))) {
      return true;
    }
    return false;
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
      QLog.d("ScannerView", 4, paramCamera.toString());
    }
    paramCamera = null;
    float f3 = paramInt1 / paramInt2;
    float f1 = (1.0F / 1.0F);
    localObject1 = ((List)localObject1).iterator();
    label266:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Camera.Size)((Iterator)localObject1).next();
      int i = ((Camera.Size)localObject2).width;
      int j = ((Camera.Size)localObject2).height;
      int k = i * j;
      if ((k >= 76800) && (k <= 921600) && ((i != 980) || (j != 800) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"GT-I9220".equalsIgnoreCase(Build.MODEL)) && (!"GT-N7000".equalsIgnoreCase(Build.MODEL)))) && (((i == 1184) && (j == 666)) || ((i != 704) || (j != 576) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9300".equalsIgnoreCase(Build.MODEL)))))
      {
        if (paramInt1 > paramInt2)
        {
          k = 1;
          if (i >= j) {
            break label496;
          }
          m = 1;
          label451:
          if (k != m) {
            break label502;
          }
          k = i;
        }
        for (int m = j;; m = i)
        {
          if ((m != paramInt1) || (k != paramInt2)) {
            break label513;
          }
          return new Point(i, j);
          k = 0;
          break;
          label496:
          m = 0;
          break label451;
          label502:
          k = j;
        }
        if ((m >= paramInt1 >> 1) && (m >> 1 <= paramInt1) && (k >= paramInt2 >> 1) && (k >> 1 <= paramInt2))
        {
          float f2 = Math.abs(m / k - f3);
          if (f2 >= f1) {
            break label612;
          }
          paramCamera = new Point(i, j);
          f1 = f2;
        }
      }
    }
    label513:
    label612:
    for (;;)
    {
      break label266;
      localObject1 = paramCamera;
      if (paramCamera != null) {
        break;
      }
      return new Point(localSize1.width, localSize1.height);
    }
  }
  
  private void a(Camera paramCamera, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localParameters = paramCamera.getParameters();
        localObject = "torch";
        if (aqoq.cVn) {
          continue;
        }
        localObject = aqoo.a().setFlashMode_TORCH(localParameters);
      }
      catch (RuntimeException paramCamera)
      {
        Camera.Parameters localParameters;
        Object localObject;
        paramBoolean = false;
        continue;
        paramCamera = Boolean.FALSE;
        continue;
        if (!paramBoolean) {
          continue;
        }
        continue;
      }
      localParameters.setFlashMode((String)localObject);
      paramCamera.setParameters(localParameters);
      if ((this.aNE) && (("auto".equals(this.aHC)) || ("macro".equals(this.aHC))))
      {
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread = new AutoFocusThread(this.mCamera);
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread.start();
      }
      this.aNF = paramBoolean;
      localObject = this.aJ;
      if (!paramBoolean) {
        continue;
      }
      paramCamera = Boolean.TRUE;
      ((Handler)localObject).obtainMessage(10, paramCamera).sendToTarget();
      return;
      localObject = "off";
    }
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    setKeepScreenOn(true);
    cN(paramContext);
    this.mSurfaceView = new SurfaceView(paramContext, paramAttributeSet);
    addView(this.mSurfaceView);
    Object localObject = this.mSurfaceView.getHolder();
    ((SurfaceHolder)localObject).addCallback(this);
    if (Build.VERSION.SDK_INT < 11) {
      ((SurfaceHolder)localObject).setType(3);
    }
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeBooleanValue(1, true)))
    {
      localObject = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rW);
      int j = ((TypedArray)localObject).getIndexCount();
      int i = 0;
      if (i < j)
      {
        int k = ((TypedArray)localObject).getIndex(i);
        switch (k)
        {
        }
        for (;;)
        {
          i += 1;
          break;
          this.bzC = ((TypedArray)localObject).getDimensionPixelOffset(k, this.bzC);
          continue;
          this.bzA = ((TypedArray)localObject).getDimensionPixelOffset(k, this.bzA);
          continue;
          this.bzB = ((TypedArray)localObject).getDimensionPixelOffset(k, this.bzB);
          continue;
          this.bzz = ((TypedArray)localObject).getDimensionPixelOffset(k, this.bzz);
          continue;
          this.bzD = ((TypedArray)localObject).getLayoutDimension(k, this.bzD);
          continue;
          this.bzE = ((TypedArray)localObject).getLayoutDimension(k, this.bzE);
          continue;
          this.bzF = ((TypedArray)localObject).getInt(k, this.bzF);
        }
      }
      ((TypedArray)localObject).recycle();
      this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView = new ViewFinderView(paramContext);
      addView(this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView);
    }
    if (paramAttributeSet != null) {
      this.aND = paramAttributeSet.getAttributeBooleanValue(0, true);
    }
  }
  
  private void checkThread()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new RuntimeException("This method must be called on UI thread");
    }
  }
  
  /* Error */
  private void closeCamera()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 101	com/tencent/biz/widgets/ScannerView:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 145	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +11 -> 24
    //   16: aload_0
    //   17: getfield 101	com/tencent/biz/widgets/ScannerView:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   20: invokevirtual 162	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   23: return
    //   24: aload_0
    //   25: getfield 240	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   28: ifnull +25 -> 53
    //   31: aload_0
    //   32: getfield 240	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   35: invokevirtual 243	com/tencent/biz/widgets/ScannerView$AutoFocusThread:isAlive	()Z
    //   38: ifeq +15 -> 53
    //   41: aload_0
    //   42: getfield 240	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   45: invokevirtual 246	com/tencent/biz/widgets/ScannerView$AutoFocusThread:interrupt	()V
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 240	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   53: aload_0
    //   54: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   57: invokevirtual 282	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   60: astore_1
    //   61: aload_1
    //   62: ldc_w 544
    //   65: invokevirtual 523	android/hardware/Camera$Parameters:setFlashMode	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   72: aload_1
    //   73: invokevirtual 307	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 525	com/tencent/biz/widgets/ScannerView:aNF	Z
    //   81: aload_0
    //   82: getfield 238	com/tencent/biz/widgets/ScannerView:aNE	Z
    //   85: ifeq +15 -> 100
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 238	com/tencent/biz/widgets/ScannerView:aNE	Z
    //   93: aload_0
    //   94: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   97: invokevirtual 249	android/hardware/Camera:stopPreview	()V
    //   100: aload_0
    //   101: getfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   104: invokevirtual 648	android/hardware/Camera:release	()V
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield 147	com/tencent/biz/widgets/ScannerView:mCamera	Landroid/hardware/Camera;
    //   112: aload_0
    //   113: getfield 101	com/tencent/biz/widgets/ScannerView:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   116: invokevirtual 162	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   119: return
    //   120: astore_1
    //   121: aload_0
    //   122: getfield 101	com/tencent/biz/widgets/ScannerView:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   125: invokevirtual 162	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: goto -50 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	ScannerView
    //   11	62	1	localObject1	Object
    //   120	9	1	localObject2	Object
    //   130	1	1	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   7	12	120	finally
    //   24	53	120	finally
    //   53	81	120	finally
    //   81	100	120	finally
    //   100	112	120	finally
    //   53	81	130	java/lang/RuntimeException
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
  
  public void bBr()
  {
    if (this.mSensorManager != null)
    {
      this.mSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentBizWidgetsScannerView$e);
      this.mSensorManager = null;
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView$e = null;
    }
  }
  
  public void bBs()
  {
    this.aND = false;
    if (this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView != null) {
      this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView.stop();
    }
    ThreadManager.post(new ScannerView.7(this), 8, null, false);
  }
  
  public void bBt()
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread == null) {}
    do
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread == null)
        {
          this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread = new DecodeThread("ScannerDecodeThread");
          this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread.start();
          this.by = new a(this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread.getLooper());
        }
        if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread.mIsQuited) {
          return;
        }
      }
      finally {}
    } while (!this.mLock.tryLock());
    try
    {
      Camera localCamera = this.mCamera;
      if (localCamera == null) {
        return;
      }
      this.mCamera.setOneShotPreviewCallback(this);
      return;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public void bxa()
  {
    this.aND = true;
    if (this.mHasSurface) {
      ThreadManager.post(new ScannerView.5(this), 8, null, true);
    }
  }
  
  public void cN(Context paramContext)
  {
    if (Ns()) {}
    do
    {
      return;
      this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    } while (this.mSensorManager == null);
    if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$e == null) {
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView$e = new e(this);
    }
    paramContext = this.mSensorManager.getDefaultSensor(1);
    this.mSensorManager.registerListener(this.jdField_a_of_type_ComTencentBizWidgetsScannerView$e, paramContext, 2);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    bBr();
    try
    {
      if ((this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread != null) && (!this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread.mIsQuited))
      {
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread.quit();
        this.by.removeCallbacksAndMessages(null);
        this.by = null;
      }
      this.aJ.removeCallbacksAndMessages(null);
      return;
    }
    finally {}
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mSurfaceView.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
      if (this.bzD != -1) {
        break label167;
      }
      int i = this.bzA;
      paramInt1 = paramInt3 - paramInt1 - this.bzB;
      paramInt3 = i;
      if (this.bzE != -1) {
        break label249;
      }
      i = this.bzz;
      paramInt2 = paramInt4 - paramInt2 - this.bzC;
      paramInt4 = i;
    }
    for (;;)
    {
      Rect localRect = this.aO;
      if (this.aQ == null) {
        this.aQ = new Rect();
      }
      this.aQ.set(paramInt3, paramInt4, paramInt1, paramInt2);
      this.aO = this.aQ;
      this.aQ = localRect;
      this.aP = null;
      this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView.setRect(paramInt3, paramInt4, paramInt1, paramInt2);
      return;
      label167:
      if ((this.bzF & 0x3) == 3)
      {
        paramInt3 = this.bzA;
        paramInt1 = this.bzD + paramInt3;
        break;
      }
      if ((this.bzF & 0x5) == 5)
      {
        paramInt1 = paramInt3 - paramInt1 - this.bzB;
        paramInt3 = paramInt1 - this.bzD;
        break;
      }
      paramInt3 = paramInt3 - paramInt1 - this.bzD >> 1;
      paramInt1 = this.bzD + paramInt3;
      break;
      label249:
      if ((this.bzF & 0x30) == 48)
      {
        paramInt4 = this.bzz;
        paramInt2 = this.bzE + paramInt4;
      }
      else if ((this.bzF & 0x50) == 80)
      {
        paramInt2 = paramInt4 - paramInt2 - this.bzC;
        paramInt4 = paramInt2 - this.bzE;
      }
      else
      {
        paramInt4 = paramInt4 - paramInt2 - this.bzE >> 1;
        paramInt2 = this.bzE + paramInt4;
      }
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.by != null) {
      this.by.obtainMessage(5, this.mPreviewWidth, this.mPreviewHeight, paramArrayOfByte).sendToTarget();
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((this.mCamera == null) || (!this.mHasSurface) || (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread == null) || (this.aNG)) {
      return;
    }
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if (!this.mInitialized)
    {
      this.mLastX = f1;
      this.mLastY = f2;
      this.ov = f3;
      this.mInitialized = true;
    }
    float f4 = Math.abs(this.mLastX - f1);
    float f5 = Math.abs(this.mLastY - f2);
    float f6 = Math.abs(this.ov - f3);
    if (((f4 > 0.5D) || (f5 > 0.5D) || (f6 > 0.5D)) && (this.aNH)) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread.bBu();
      label157:
      this.mLastX = f1;
      this.mLastY = f2;
      this.ov = f3;
      return;
    }
    catch (RuntimeException paramSensorEvent)
    {
      break label157;
    }
  }
  
  public void setFileDecodeListener(b paramb)
  {
    checkThread();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView$b = paramb;
  }
  
  public void setFlashLightListener(c paramc)
  {
    checkThread();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView$c = paramc;
  }
  
  public void setScanListener(d paramd)
  {
    checkThread();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView$d = paramd;
  }
  
  public void setViewFinder(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    checkThread();
    this.bzF = 51;
    this.bzA = paramInt1;
    this.bzz = paramInt2;
    this.bzD = (paramInt3 - paramInt1);
    this.bzE = (paramInt4 - paramInt2);
    this.bzB = 0;
    this.bzC = 0;
    if (this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView == null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView = new ViewFinderView(getContext());
      addView(this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView);
      return;
    }
    this.aO = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    this.aP = null;
    this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView.setRect(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mSurfaceWidth = paramInt2;
    this.mSurfaceHeight = paramInt3;
    if (this.aND)
    {
      if (!this.aNE) {
        ThreadManager.post(new ScannerView.2(this), 8, null, true);
      }
    }
    else {
      return;
    }
    ThreadManager.post(new ScannerView.3(this), 8, null, true);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.mHasSurface = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.mHasSurface = false;
    ThreadManager.post(new ScannerView.4(this), 8, null, false);
  }
  
  public void vf(boolean paramBoolean)
  {
    if ((this.aNI) && (Nr()))
    {
      ThreadManager.getUIHandler().post(new ScannerView.6(this));
      this.mStartTime = System.currentTimeMillis();
      this.DG = 0L;
      this.aJ.sendEmptyMessage(7);
      return;
    }
    this.aJ.sendEmptyMessage(8);
  }
  
  class AutoFocusThread
    extends Thread
    implements Camera.AutoFocusCallback
  {
    Handler bD;
    protected Runnable dA = new ScannerView.AutoFocusThread.1(this);
    Camera mCamera;
    
    public AutoFocusThread(Camera paramCamera)
    {
      this.mCamera = paramCamera;
      this.bD = new Handler(Looper.getMainLooper());
    }
    
    public void bBu()
    {
      try
      {
        if ((ScannerView.e(ScannerView.this)) && (this.mCamera != null) && (ScannerView.f(ScannerView.this)))
        {
          this.bD.postDelayed(this.dA, 2500L);
          this.mCamera.autoFocus(this);
          ScannerView.b(ScannerView.this, false);
        }
        return;
      }
      finally {}
    }
    
    public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ScannerView", 4, "onAutoFocus");
      }
      ScannerView.b(ScannerView.this, true);
      this.bD.removeCallbacks(this.dA);
    }
    
    public void run()
    {
      try
      {
        if (ScannerView.d(ScannerView.this)) {
          ScannerView.c(ScannerView.this, false);
        }
        for (;;)
        {
          try
          {
            bBu();
          }
          catch (RuntimeException localRuntimeException1) {}
          break;
          Thread.sleep(3000L);
        }
        try
        {
          this.mCamera.cancelAutoFocus();
          ScannerView.b(ScannerView.this, true);
          this.bD.removeCallbacks(this.dA);
          this.mCamera = null;
          return;
        }
        catch (RuntimeException localRuntimeException2)
        {
          break label77;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        if (ScannerView.e(ScannerView.this)) {}
      }
    }
  }
  
  class DecodeThread
    extends HandlerThread
  {
    public boolean mIsQuited;
    
    public DecodeThread(String paramString)
    {
      super();
    }
    
    public boolean quit()
    {
      this.mIsQuited = true;
      if (QLog.isColorLevel()) {
        QLog.d("ScannerView", 2, "decode thread quit");
      }
      try
      {
        asfh.Nn();
        return super.quit();
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("ScannerView", 2, localUnsatisfiedLinkError.toString());
          }
        }
      }
    }
    
    public void run()
    {
      Process.setThreadPriority(-20);
      try
      {
        int i = asfh.c(0, "ANY", "UTF-8");
        Object localObject = new int[2];
        localObject[0] = 2;
        localObject[1] = 1;
        int j = asfh.d((int[])localObject, localObject.length);
        localObject = asfh.GetVersion();
        if (QLog.isDevelopLevel())
        {
          QLog.d("ScannerView", 4, "init for camera init_result1:" + i + ",init_result2:" + j);
          QLog.d("ScannerView", 4, "version:" + (String)localObject);
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("ScannerView", 2, localUnsatisfiedLinkError.toString());
          }
        }
      }
      super.run();
    }
  }
  
  class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    /* Error */
    public void handleMessage(Message paramMessage)
    {
      // Byte code:
      //   0: aload_1
      //   1: getfield 29	android/os/Message:what	I
      //   4: tableswitch	default:+24 -> 28, 5:+25->29, 6:+1148->1152
      //   29: aload_0
      //   30: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   33: astore 12
      //   35: aload 12
      //   37: aload 12
      //   39: getfield 33	com/tencent/biz/widgets/ScannerView:DG	J
      //   42: lconst_1
      //   43: ladd
      //   44: putfield 33	com/tencent/biz/widgets/ScannerView:DG	J
      //   47: aload_1
      //   48: getfield 37	android/os/Message:obj	Ljava/lang/Object;
      //   51: ifnull +13 -> 64
      //   54: aload_1
      //   55: getfield 37	android/os/Message:obj	Ljava/lang/Object;
      //   58: instanceof 39
      //   61: ifne +16 -> 77
      //   64: aload_0
      //   65: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   68: getfield 43	com/tencent/biz/widgets/ScannerView:aJ	Landroid/os/Handler;
      //   71: iconst_2
      //   72: invokevirtual 47	android/os/Handler:sendEmptyMessage	(I)Z
      //   75: pop
      //   76: return
      //   77: aload_1
      //   78: getfield 37	android/os/Message:obj	Ljava/lang/Object;
      //   81: checkcast 39	[B
      //   84: checkcast 39	[B
      //   87: astore 13
      //   89: aload_0
      //   90: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   93: getfield 50	com/tencent/biz/widgets/ScannerView:bzy	I
      //   96: iconst_3
      //   97: if_icmpge +49 -> 146
      //   100: iconst_0
      //   101: istore 8
      //   103: aload 13
      //   105: arraylength
      //   106: istore 9
      //   108: iconst_0
      //   109: istore 6
      //   111: iload 8
      //   113: istore 7
      //   115: iload 6
      //   117: iload 9
      //   119: if_icmpge +14 -> 133
      //   122: aload 13
      //   124: iload 6
      //   126: baload
      //   127: ifeq +577 -> 704
      //   130: iconst_1
      //   131: istore 7
      //   133: iload 7
      //   135: ifeq +578 -> 713
      //   138: aload_0
      //   139: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   142: iconst_3
      //   143: putfield 50	com/tencent/biz/widgets/ScannerView:bzy	I
      //   146: aload_0
      //   147: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   150: getfield 54	com/tencent/biz/widgets/ScannerView:aP	Landroid/graphics/Rect;
      //   153: astore_1
      //   154: aload_0
      //   155: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   158: getfield 57	com/tencent/biz/widgets/ScannerView:aO	Landroid/graphics/Rect;
      //   161: astore 12
      //   163: aload_1
      //   164: ifnonnull +1068 -> 1232
      //   167: aload 12
      //   169: astore_1
      //   170: aload 12
      //   172: ifnonnull +39 -> 211
      //   175: aload_0
      //   176: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   179: astore 12
      //   181: new 59	android/graphics/Rect
      //   184: dup
      //   185: iconst_0
      //   186: iconst_0
      //   187: aload_0
      //   188: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   191: getfield 62	com/tencent/biz/widgets/ScannerView:mSurfaceWidth	I
      //   194: aload_0
      //   195: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   198: getfield 65	com/tencent/biz/widgets/ScannerView:mSurfaceHeight	I
      //   201: invokespecial 68	android/graphics/Rect:<init>	(IIII)V
      //   204: astore_1
      //   205: aload 12
      //   207: aload_1
      //   208: putfield 57	com/tencent/biz/widgets/ScannerView:aO	Landroid/graphics/Rect;
      //   211: aload_0
      //   212: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   215: getfield 71	com/tencent/biz/widgets/ScannerView:bzx	I
      //   218: bipush 90
      //   220: if_icmpne +534 -> 754
      //   223: aload_0
      //   224: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   227: getfield 74	com/tencent/biz/widgets/ScannerView:mPreviewWidth	I
      //   230: i2f
      //   231: aload_0
      //   232: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   235: getfield 65	com/tencent/biz/widgets/ScannerView:mSurfaceHeight	I
      //   238: i2f
      //   239: fdiv
      //   240: fstore 4
      //   242: aload_0
      //   243: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   246: getfield 77	com/tencent/biz/widgets/ScannerView:mPreviewHeight	I
      //   249: i2f
      //   250: aload_0
      //   251: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   254: getfield 62	com/tencent/biz/widgets/ScannerView:mSurfaceWidth	I
      //   257: i2f
      //   258: fdiv
      //   259: fstore 5
      //   261: new 59	android/graphics/Rect
      //   264: dup
      //   265: aload_1
      //   266: getfield 80	android/graphics/Rect:top	I
      //   269: i2f
      //   270: fload 4
      //   272: fmul
      //   273: f2i
      //   274: aload_0
      //   275: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   278: getfield 62	com/tencent/biz/widgets/ScannerView:mSurfaceWidth	I
      //   281: aload_1
      //   282: getfield 83	android/graphics/Rect:right	I
      //   285: isub
      //   286: i2f
      //   287: fload 5
      //   289: fmul
      //   290: f2i
      //   291: fload 4
      //   293: aload_1
      //   294: getfield 86	android/graphics/Rect:bottom	I
      //   297: i2f
      //   298: fmul
      //   299: f2i
      //   300: aload_0
      //   301: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   304: getfield 62	com/tencent/biz/widgets/ScannerView:mSurfaceWidth	I
      //   307: aload_1
      //   308: getfield 89	android/graphics/Rect:left	I
      //   311: isub
      //   312: i2f
      //   313: fload 5
      //   315: fmul
      //   316: f2i
      //   317: invokespecial 68	android/graphics/Rect:<init>	(IIII)V
      //   320: astore_1
      //   321: aload_0
      //   322: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   325: aload_1
      //   326: putfield 54	com/tencent/biz/widgets/ScannerView:aP	Landroid/graphics/Rect;
      //   329: invokestatic 95	java/lang/System:currentTimeMillis	()J
      //   332: lstore 10
      //   334: iconst_2
      //   335: newarray int
      //   337: astore 14
      //   339: aload_1
      //   340: invokevirtual 99	android/graphics/Rect:width	()I
      //   343: aload_1
      //   344: invokevirtual 102	android/graphics/Rect:height	()I
      //   347: imul
      //   348: iconst_3
      //   349: imul
      //   350: iconst_1
      //   351: ishr
      //   352: newarray byte
      //   354: astore 12
      //   356: aload 12
      //   358: ifnull +868 -> 1226
      //   361: aload_0
      //   362: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   365: getfield 74	com/tencent/biz/widgets/ScannerView:mPreviewWidth	I
      //   368: ifle +858 -> 1226
      //   371: aload_0
      //   372: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   375: getfield 77	com/tencent/biz/widgets/ScannerView:mPreviewHeight	I
      //   378: ifle +848 -> 1226
      //   381: aload_1
      //   382: getfield 89	android/graphics/Rect:left	I
      //   385: iflt +841 -> 1226
      //   388: aload_1
      //   389: getfield 80	android/graphics/Rect:top	I
      //   392: iflt +834 -> 1226
      //   395: aload_1
      //   396: invokevirtual 99	android/graphics/Rect:width	()I
      //   399: ifle +827 -> 1226
      //   402: aload_1
      //   403: invokevirtual 102	android/graphics/Rect:height	()I
      //   406: ifle +820 -> 1226
      //   409: aload_1
      //   410: getfield 83	android/graphics/Rect:right	I
      //   413: aload_0
      //   414: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   417: getfield 74	com/tencent/biz/widgets/ScannerView:mPreviewWidth	I
      //   420: if_icmpgt +806 -> 1226
      //   423: aload_1
      //   424: getfield 86	android/graphics/Rect:bottom	I
      //   427: aload_0
      //   428: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   431: getfield 77	com/tencent/biz/widgets/ScannerView:mPreviewHeight	I
      //   434: if_icmpgt +792 -> 1226
      //   437: aload 13
      //   439: arraylength
      //   440: aload_0
      //   441: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   444: getfield 74	com/tencent/biz/widgets/ScannerView:mPreviewWidth	I
      //   447: aload_0
      //   448: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   451: getfield 77	com/tencent/biz/widgets/ScannerView:mPreviewHeight	I
      //   454: imul
      //   455: iconst_3
      //   456: imul
      //   457: iconst_1
      //   458: ishr
      //   459: if_icmpne +767 -> 1226
      //   462: aload 12
      //   464: aload 14
      //   466: aload 13
      //   468: aload_0
      //   469: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   472: getfield 74	com/tencent/biz/widgets/ScannerView:mPreviewWidth	I
      //   475: aload_0
      //   476: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   479: getfield 77	com/tencent/biz/widgets/ScannerView:mPreviewHeight	I
      //   482: aload_1
      //   483: getfield 89	android/graphics/Rect:left	I
      //   486: aload_1
      //   487: getfield 80	android/graphics/Rect:top	I
      //   490: aload_1
      //   491: invokevirtual 99	android/graphics/Rect:width	()I
      //   494: aload_1
      //   495: invokevirtual 102	android/graphics/Rect:height	()I
      //   498: aload_0
      //   499: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   502: getfield 71	com/tencent/biz/widgets/ScannerView:bzx	I
      //   505: iconst_0
      //   506: invokestatic 108	com/tencent/imageboost/ImgProcessScan:gray_rotate_crop_sub	([B[I[BIIIIIIII)I
      //   509: ifne +717 -> 1226
      //   512: aload 12
      //   514: aload 14
      //   516: iconst_0
      //   517: iaload
      //   518: aload 14
      //   520: iconst_1
      //   521: iaload
      //   522: iconst_0
      //   523: invokestatic 113	asfh:a	([BIII)I
      //   526: istore 6
      //   528: invokestatic 95	java/lang/System:currentTimeMillis	()J
      //   531: lload 10
      //   533: lsub
      //   534: l2d
      //   535: dstore_2
      //   536: iload 6
      //   538: istore 7
      //   540: invokestatic 119	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   543: ifeq +32 -> 575
      //   546: ldc 121
      //   548: iconst_4
      //   549: new 123	java/lang/StringBuilder
      //   552: dup
      //   553: invokespecial 126	java/lang/StringBuilder:<init>	()V
      //   556: ldc 128
      //   558: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   561: dload_2
      //   562: invokevirtual 135	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   565: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   568: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   571: iload 6
      //   573: istore 7
      //   575: iload 7
      //   577: iconst_1
      //   578: if_icmpne +561 -> 1139
      //   581: new 123	java/lang/StringBuilder
      //   584: dup
      //   585: invokespecial 126	java/lang/StringBuilder:<init>	()V
      //   588: astore_1
      //   589: new 123	java/lang/StringBuilder
      //   592: dup
      //   593: invokespecial 126	java/lang/StringBuilder:<init>	()V
      //   596: astore 12
      //   598: aload_1
      //   599: aload 12
      //   601: invokestatic 147	asfh:b	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
      //   604: pop
      //   605: aconst_null
      //   606: ldc 149
      //   608: ldc 151
      //   610: ldc 153
      //   612: ldc 155
      //   614: ldc 157
      //   616: iconst_0
      //   617: iconst_0
      //   618: new 123	java/lang/StringBuilder
      //   621: dup
      //   622: invokespecial 126	java/lang/StringBuilder:<init>	()V
      //   625: ldc 153
      //   627: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   630: invokestatic 95	java/lang/System:currentTimeMillis	()J
      //   633: aload_0
      //   634: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   637: getfield 160	com/tencent/biz/widgets/ScannerView:mStartTime	J
      //   640: lsub
      //   641: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   644: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   647: new 123	java/lang/StringBuilder
      //   650: dup
      //   651: invokespecial 126	java/lang/StringBuilder:<init>	()V
      //   654: ldc 153
      //   656: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   659: aload_0
      //   660: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   663: getfield 33	com/tencent/biz/widgets/ScannerView:DG	J
      //   666: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   669: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   672: ldc 153
      //   674: ldc 153
      //   676: invokestatic 168	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   679: aload_0
      //   680: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   683: aload_1
      //   684: putfield 172	com/tencent/biz/widgets/ScannerView:B	Ljava/lang/StringBuilder;
      //   687: aload_0
      //   688: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   691: getfield 43	com/tencent/biz/widgets/ScannerView:aJ	Landroid/os/Handler;
      //   694: iconst_1
      //   695: aload 12
      //   697: invokevirtual 176	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   700: invokevirtual 179	android/os/Message:sendToTarget	()V
      //   703: return
      //   704: iload 6
      //   706: iconst_1
      //   707: iadd
      //   708: istore 6
      //   710: goto -599 -> 111
      //   713: aload_0
      //   714: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   717: astore_1
      //   718: aload_1
      //   719: getfield 50	com/tencent/biz/widgets/ScannerView:bzy	I
      //   722: iconst_1
      //   723: iadd
      //   724: istore 6
      //   726: aload_1
      //   727: iload 6
      //   729: putfield 50	com/tencent/biz/widgets/ScannerView:bzy	I
      //   732: iload 6
      //   734: iconst_3
      //   735: if_icmpne -589 -> 146
      //   738: aload_0
      //   739: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   742: getfield 43	com/tencent/biz/widgets/ScannerView:aJ	Landroid/os/Handler;
      //   745: bipush 9
      //   747: invokevirtual 47	android/os/Handler:sendEmptyMessage	(I)Z
      //   750: pop
      //   751: goto -605 -> 146
      //   754: aload_0
      //   755: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   758: getfield 71	com/tencent/biz/widgets/ScannerView:bzx	I
      //   761: sipush 180
      //   764: if_icmpne +120 -> 884
      //   767: aload_0
      //   768: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   771: getfield 74	com/tencent/biz/widgets/ScannerView:mPreviewWidth	I
      //   774: i2f
      //   775: aload_0
      //   776: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   779: getfield 62	com/tencent/biz/widgets/ScannerView:mSurfaceWidth	I
      //   782: i2f
      //   783: fdiv
      //   784: fstore 4
      //   786: aload_0
      //   787: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   790: getfield 77	com/tencent/biz/widgets/ScannerView:mPreviewHeight	I
      //   793: i2f
      //   794: aload_0
      //   795: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   798: getfield 65	com/tencent/biz/widgets/ScannerView:mSurfaceHeight	I
      //   801: i2f
      //   802: fdiv
      //   803: fstore 5
      //   805: new 59	android/graphics/Rect
      //   808: dup
      //   809: aload_0
      //   810: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   813: getfield 62	com/tencent/biz/widgets/ScannerView:mSurfaceWidth	I
      //   816: aload_1
      //   817: getfield 83	android/graphics/Rect:right	I
      //   820: isub
      //   821: i2f
      //   822: fload 4
      //   824: fmul
      //   825: f2i
      //   826: aload_0
      //   827: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   830: getfield 65	com/tencent/biz/widgets/ScannerView:mSurfaceHeight	I
      //   833: aload_1
      //   834: getfield 86	android/graphics/Rect:bottom	I
      //   837: isub
      //   838: i2f
      //   839: fload 5
      //   841: fmul
      //   842: f2i
      //   843: fload 4
      //   845: aload_0
      //   846: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   849: getfield 62	com/tencent/biz/widgets/ScannerView:mSurfaceWidth	I
      //   852: aload_1
      //   853: getfield 89	android/graphics/Rect:left	I
      //   856: isub
      //   857: i2f
      //   858: fmul
      //   859: f2i
      //   860: aload_0
      //   861: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   864: getfield 65	com/tencent/biz/widgets/ScannerView:mSurfaceHeight	I
      //   867: aload_1
      //   868: getfield 80	android/graphics/Rect:top	I
      //   871: isub
      //   872: i2f
      //   873: fload 5
      //   875: fmul
      //   876: f2i
      //   877: invokespecial 68	android/graphics/Rect:<init>	(IIII)V
      //   880: astore_1
      //   881: goto -560 -> 321
      //   884: aload_0
      //   885: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   888: getfield 71	com/tencent/biz/widgets/ScannerView:bzx	I
      //   891: sipush 270
      //   894: if_icmpne +104 -> 998
      //   897: aload_0
      //   898: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   901: getfield 74	com/tencent/biz/widgets/ScannerView:mPreviewWidth	I
      //   904: i2f
      //   905: aload_0
      //   906: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   909: getfield 65	com/tencent/biz/widgets/ScannerView:mSurfaceHeight	I
      //   912: i2f
      //   913: fdiv
      //   914: fstore 4
      //   916: aload_0
      //   917: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   920: getfield 77	com/tencent/biz/widgets/ScannerView:mPreviewHeight	I
      //   923: i2f
      //   924: aload_0
      //   925: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   928: getfield 62	com/tencent/biz/widgets/ScannerView:mSurfaceWidth	I
      //   931: i2f
      //   932: fdiv
      //   933: fstore 5
      //   935: new 59	android/graphics/Rect
      //   938: dup
      //   939: aload_0
      //   940: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   943: getfield 65	com/tencent/biz/widgets/ScannerView:mSurfaceHeight	I
      //   946: aload_1
      //   947: getfield 86	android/graphics/Rect:bottom	I
      //   950: isub
      //   951: i2f
      //   952: fload 4
      //   954: fmul
      //   955: f2i
      //   956: aload_1
      //   957: getfield 89	android/graphics/Rect:left	I
      //   960: i2f
      //   961: fload 5
      //   963: fmul
      //   964: f2i
      //   965: fload 4
      //   967: aload_0
      //   968: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   971: getfield 65	com/tencent/biz/widgets/ScannerView:mSurfaceHeight	I
      //   974: aload_1
      //   975: getfield 80	android/graphics/Rect:top	I
      //   978: isub
      //   979: i2f
      //   980: fmul
      //   981: f2i
      //   982: aload_1
      //   983: getfield 83	android/graphics/Rect:right	I
      //   986: i2f
      //   987: fload 5
      //   989: fmul
      //   990: f2i
      //   991: invokespecial 68	android/graphics/Rect:<init>	(IIII)V
      //   994: astore_1
      //   995: goto -674 -> 321
      //   998: aload_0
      //   999: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   1002: getfield 74	com/tencent/biz/widgets/ScannerView:mPreviewWidth	I
      //   1005: i2f
      //   1006: aload_0
      //   1007: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   1010: getfield 62	com/tencent/biz/widgets/ScannerView:mSurfaceWidth	I
      //   1013: i2f
      //   1014: fdiv
      //   1015: fstore 4
      //   1017: aload_0
      //   1018: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   1021: getfield 77	com/tencent/biz/widgets/ScannerView:mPreviewHeight	I
      //   1024: i2f
      //   1025: aload_0
      //   1026: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   1029: getfield 65	com/tencent/biz/widgets/ScannerView:mSurfaceHeight	I
      //   1032: i2f
      //   1033: fdiv
      //   1034: fstore 5
      //   1036: new 59	android/graphics/Rect
      //   1039: dup
      //   1040: aload_1
      //   1041: getfield 89	android/graphics/Rect:left	I
      //   1044: i2f
      //   1045: fload 4
      //   1047: fmul
      //   1048: f2i
      //   1049: aload_1
      //   1050: getfield 80	android/graphics/Rect:top	I
      //   1053: i2f
      //   1054: fload 5
      //   1056: fmul
      //   1057: f2i
      //   1058: fload 4
      //   1060: aload_1
      //   1061: getfield 83	android/graphics/Rect:right	I
      //   1064: i2f
      //   1065: fmul
      //   1066: f2i
      //   1067: aload_1
      //   1068: getfield 86	android/graphics/Rect:bottom	I
      //   1071: i2f
      //   1072: fload 5
      //   1074: fmul
      //   1075: f2i
      //   1076: invokespecial 68	android/graphics/Rect:<init>	(IIII)V
      //   1079: astore_1
      //   1080: goto -759 -> 321
      //   1083: astore 12
      //   1085: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1088: ifeq +14 -> 1102
      //   1091: ldc 121
      //   1093: iconst_2
      //   1094: aload 12
      //   1096: invokevirtual 183	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
      //   1099: invokestatic 186	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
      //   1102: aconst_null
      //   1103: astore 12
      //   1105: goto -749 -> 356
      //   1108: astore_1
      //   1109: iconst_0
      //   1110: istore 6
      //   1112: iload 6
      //   1114: istore 7
      //   1116: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1119: ifeq -544 -> 575
      //   1122: ldc 121
      //   1124: iconst_2
      //   1125: aload_1
      //   1126: invokevirtual 187	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
      //   1129: invokestatic 186	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
      //   1132: iload 6
      //   1134: istore 7
      //   1136: goto -561 -> 575
      //   1139: aload_0
      //   1140: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   1143: getfield 43	com/tencent/biz/widgets/ScannerView:aJ	Landroid/os/Handler;
      //   1146: iconst_2
      //   1147: invokevirtual 47	android/os/Handler:sendEmptyMessage	(I)Z
      //   1150: pop
      //   1151: return
      //   1152: aconst_null
      //   1153: astore 12
      //   1155: aload_1
      //   1156: getfield 37	android/os/Message:obj	Ljava/lang/Object;
      //   1159: instanceof 189
      //   1162: ifeq +22 -> 1184
      //   1165: aload_1
      //   1166: getfield 37	android/os/Message:obj	Ljava/lang/Object;
      //   1169: checkcast 189	android/net/Uri
      //   1172: aload_0
      //   1173: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   1176: invokevirtual 193	com/tencent/biz/widgets/ScannerView:getContext	()Landroid/content/Context;
      //   1179: invokestatic 198	rvx:a	(Landroid/net/Uri;Landroid/content/Context;)Landroid/util/Pair;
      //   1182: astore 12
      //   1184: aload 12
      //   1186: ifnull +23 -> 1209
      //   1189: aload_0
      //   1190: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   1193: getfield 43	com/tencent/biz/widgets/ScannerView:aJ	Landroid/os/Handler;
      //   1196: iconst_3
      //   1197: aload 12
      //   1199: getfield 203	android/util/Pair:first	Ljava/lang/Object;
      //   1202: invokevirtual 176	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   1205: invokevirtual 179	android/os/Message:sendToTarget	()V
      //   1208: return
      //   1209: aload_0
      //   1210: getfield 13	com/tencent/biz/widgets/ScannerView$a:this$0	Lcom/tencent/biz/widgets/ScannerView;
      //   1213: getfield 43	com/tencent/biz/widgets/ScannerView:aJ	Landroid/os/Handler;
      //   1216: iconst_4
      //   1217: invokevirtual 47	android/os/Handler:sendEmptyMessage	(I)Z
      //   1220: pop
      //   1221: return
      //   1222: astore_1
      //   1223: goto -111 -> 1112
      //   1226: iconst_0
      //   1227: istore 6
      //   1229: goto -701 -> 528
      //   1232: goto -903 -> 329
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1235	0	this	a
      //   0	1235	1	paramMessage	Message
      //   535	27	2	d	double
      //   240	819	4	f1	float
      //   259	814	5	f2	float
      //   109	1119	6	i	int
      //   113	1022	7	j	int
      //   101	11	8	k	int
      //   106	14	9	m	int
      //   332	200	10	l	long
      //   33	663	12	localObject	Object
      //   1083	12	12	localOutOfMemoryError	java.lang.OutOfMemoryError
      //   1103	95	12	localPair	android.util.Pair
      //   87	380	13	arrayOfByte	byte[]
      //   337	182	14	arrayOfInt	int[]
      // Exception table:
      //   from	to	target	type
      //   339	356	1083	java/lang/OutOfMemoryError
      //   329	339	1108	java/lang/UnsatisfiedLinkError
      //   339	356	1108	java/lang/UnsatisfiedLinkError
      //   361	528	1108	java/lang/UnsatisfiedLinkError
      //   1085	1102	1108	java/lang/UnsatisfiedLinkError
      //   528	536	1222	java/lang/UnsatisfiedLinkError
      //   540	571	1222	java/lang/UnsatisfiedLinkError
    }
  }
  
  public static abstract interface b
  {
    public abstract void yc(int paramInt);
    
    public abstract void z(String paramString, int paramInt1, int paramInt2);
  }
  
  public static abstract interface c
  {
    public abstract void vg(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void bBv();
    
    public abstract void bBw();
    
    public abstract void bBx();
    
    public abstract void tU(String paramString);
  }
  
  static class e
    implements SensorEventListener
  {
    private WeakReference<ScannerView> mRef;
    
    public e(ScannerView paramScannerView)
    {
      this.mRef = new WeakReference(paramScannerView);
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      ScannerView localScannerView = (ScannerView)this.mRef.get();
      if (localScannerView != null) {
        localScannerView.onSensorChanged(paramSensorEvent);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("ScannerView", 2, "onSensorChanged but mRef got null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView
 * JD-Core Version:    0.7.0.1
 */