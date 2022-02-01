package com.tencent.av.camera;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import iiv;
import ilj.b;
import ilm;
import iln;
import ilq;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import jjb;
import jlc;

public class CameraUtils
{
  static volatile CameraUtils jdField_a_of_type_ComTencentAvCameraCameraUtils;
  public boolean Sl = false;
  boolean Sm = true;
  boolean Sn = false;
  public VideoController a;
  CloseCameraRunnable jdField_a_of_type_ComTencentAvCameraCameraUtils$CloseCameraRunnable = new CloseCameraRunnable();
  NoPreviewRunnable jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable = new NoPreviewRunnable();
  OpenCameraRunnable jdField_a_of_type_ComTencentAvCameraCameraUtils$OpenCameraRunnable = new OpenCameraRunnable();
  SwitchCameraRunnable jdField_a_of_type_ComTencentAvCameraCameraUtils$SwitchCameraRunnable = new SwitchCameraRunnable();
  private a jdField_a_of_type_ComTencentAvCameraCameraUtils$a;
  private b jdField_a_of_type_ComTencentAvCameraCameraUtils$b;
  private c jdField_a_of_type_ComTencentAvCameraCameraUtils$c;
  ilq jdField_a_of_type_Ilq = null;
  int aoI = 0;
  ilj.b b = new ilm(this);
  private Map<String, Integer> cU = new HashMap(2);
  HandlerThread l = null;
  private Handler mCameraHandler;
  Context mContext = null;
  SurfaceTexture mSurfaceTexture = new SurfaceTexture(0);
  private HandlerThread mWorkThread;
  
  private CameraUtils(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    if (Build.MODEL.equals("HUAWEI GRA-TL00")) {
      this.Sl = true;
    }
    this.mContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Ilq = new ilq(this.mContext);
    this.jdField_a_of_type_Ilq.a(this.b);
    this.aoI = this.jdField_a_of_type_Ilq.getCameraNum();
    if (this.aoI > 0)
    {
      paramContext = this.mContext.getSharedPreferences("cameracfg", 0);
      int i = paramContext.getInt("frontCameraRotation", 0);
      int j = paramContext.getInt("backCameraRotation", 0);
      this.jdField_a_of_type_Ilq.setCameraAngleFix(true, i);
      this.jdField_a_of_type_Ilq.setCameraAngleFix(false, j);
    }
    this.mWorkThread = new HandlerThread("AppStoreWorkThread");
    this.mWorkThread.start();
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils$c = new c(this, this.mWorkThread.getLooper());
    this.cU.put("0", Integer.valueOf(1));
    this.cU.put("1", Integer.valueOf(1));
    if ((this.Sm) && (this.l == null))
    {
      this.l = ThreadManager.newFreeHandlerThread("QAV_Camera_Handler_Thread", 0);
      this.l.start();
      this.mCameraHandler = new iln(this, this.l.getLooper());
    }
  }
  
  private b a()
  {
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils$b == null) {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils$b = new b();
    }
    return this.jdField_a_of_type_ComTencentAvCameraCameraUtils$b;
  }
  
  public static CameraUtils a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentAvCameraCameraUtils == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvCameraCameraUtils == null) {
        jdField_a_of_type_ComTencentAvCameraCameraUtils = new CameraUtils(paramContext);
      }
      return jdField_a_of_type_ComTencentAvCameraCameraUtils;
    }
    finally {}
  }
  
  private void cd(long paramLong)
  {
    if (AudioHelper.aCz()) {
      QLog.w("CameraUtils", 1, "switchCamera begin, mCamera[" + this.jdField_a_of_type_Ilq + "], seq[" + paramLong + "]");
    }
    jjb.a("switch_camera", "SwitchCameraRunnable", 3, new Object[] { Long.valueOf(paramLong) });
    a().m(new Object[] { Integer.valueOf(5) });
    if (this.jdField_a_of_type_Ilq != null) {}
    for (boolean bool = this.jdField_a_of_type_Ilq.b(paramLong, this.mSurfaceTexture);; bool = false)
    {
      a().m(new Object[] { Integer.valueOf(6), Boolean.valueOf(bool) });
      if (AudioHelper.aCz()) {
        QLog.w("CameraUtils", 1, "switchCamera end, result[" + bool + "], mCamera[" + this.jdField_a_of_type_Ilq + "], seq[" + paramLong + "]");
      }
      return;
    }
  }
  
  private void ce(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    QLog.w("CameraUtils", 1, "openCamera begin, mCamera[" + this.jdField_a_of_type_Ilq + "], seq[" + paramLong + "]");
    a().m(new Object[] { Integer.valueOf(1), Boolean.valueOf(this.jdField_a_of_type_Ilq.tT()), Long.valueOf(paramLong) });
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.alu = 0;
      this.jdField_a_of_type_ComTencentAvVideoController.OE = false;
    }
    boolean bool = this.jdField_a_of_type_Ilq.a(paramLong, this.mSurfaceTexture);
    int j;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      j = this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
      if (this.jdField_a_of_type_Ilq.ld() != 0) {
        this.jdField_a_of_type_ComTencentAvVideoController.b().Qe = true;
      }
      i = j;
      if (bool)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.b().Qb = false;
        this.jdField_a_of_type_ComTencentAvVideoController.b().QE = false;
        this.jdField_a_of_type_ComTencentAvVideoController.b().n(paramLong, true);
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 1) {
          break label376;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.b().e(paramLong, "OpenCameraRunnable.1", 2);
        this.jdField_a_of_type_ComTencentAvVideoController.kp(this.jdField_a_of_type_ComTencentAvVideoController.b().amI);
        q(paramLong, "OpenCameraRunnable.run");
      }
    }
    for (int i = j;; i = 0)
    {
      a().m(new Object[] { Integer.valueOf(2), Boolean.valueOf(bool), Integer.valueOf(i), Long.valueOf(paramLong) });
      if (bool) {
        anZ();
      }
      long l2 = System.currentTimeMillis();
      QLog.w("CameraUtils", 1, "openCamera end. result[" + bool + "], cost[" + (l2 - l1) + "], seq[" + paramLong + "]");
      return;
      label376:
      if ((this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 3) && (this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 4)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.b().e(paramLong, "OpenCameraRunnable.2", 4);
      break;
    }
  }
  
  private void p(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ilq != null) {}
    for (boolean bool = this.jdField_a_of_type_Ilq.a(paramLong, this.mSurfaceTexture, paramInt1, paramInt2);; bool = false)
    {
      if (bool) {
        q(paramLong, "reopenCameraInSubThread");
      }
      for (;;)
      {
        a().m(new Object[] { Integer.valueOf(8), Boolean.valueOf(bool) });
        return;
        jd("reopenCameraInSubThread");
      }
    }
  }
  
  private void u(long paramLong, boolean paramBoolean)
  {
    QLog.w("CameraUtils", 1, "closeCamera begin, mCamera[" + this.jdField_a_of_type_Ilq + "], seq[" + paramLong + "]");
    a().m(new Object[] { Integer.valueOf(3), Long.valueOf(paramLong) });
    if (this.jdField_a_of_type_Ilq != null) {
      this.jdField_a_of_type_Ilq.ap(paramLong);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      jd("CloseCameraRunnable.run");
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 2) {
        break label268;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.b().n(paramLong, false);
        if (!this.jdField_a_of_type_ComTencentAvVideoController.b().PZ)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.b().e(paramLong, "CloseCameraRunnable.1", 1);
          this.jdField_a_of_type_ComTencentAvVideoController.b().QE = true;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.kp(this.jdField_a_of_type_ComTencentAvVideoController.b().amI);
      a().m(new Object[] { Integer.valueOf(4), Boolean.valueOf(true), Long.valueOf(paramLong) });
      aoa();
      QLog.w("CameraUtils", 1, "closeCamera end, mCamera[" + this.jdField_a_of_type_Ilq + "], seq[" + paramLong + "]");
      return;
      label268:
      if ((this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4) && (!this.jdField_a_of_type_ComTencentAvVideoController.b().PZ)) {
        this.jdField_a_of_type_ComTencentAvVideoController.b().e(paramLong, "CloseCameraRunnable.2", 3);
      }
    }
  }
  
  private void v(long paramLong, int paramInt)
  {
    if ((AudioHelper.aCz()) || (this.jdField_a_of_type_Ilq == null)) {
      QLog.w("CameraUtils", 1, "setCameraParaInSubThread begin, mCamera[" + this.jdField_a_of_type_Ilq + "], seq[" + paramLong + "]");
    }
    if (this.jdField_a_of_type_Ilq == null) {
      return;
    }
    this.jdField_a_of_type_Ilq.t(paramLong, paramInt);
  }
  
  public Camera.Parameters a()
  {
    if (this.jdField_a_of_type_Ilq != null) {
      return this.jdField_a_of_type_Ilq.a();
    }
    return null;
  }
  
  public void a(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  public void addObserver(Observer paramObserver)
  {
    if (paramObserver != null) {
      a().addObserver(paramObserver);
    }
  }
  
  public void anW()
  {
    if ((this.jdField_a_of_type_Ilq != null) && (this.aoI > 0))
    {
      if ((this.aoI == 1) || (!this.jdField_a_of_type_Ilq.isFrontCamera()))
      {
        i = this.jdField_a_of_type_Ilq.getUserCameraAngle(false) + 90;
        j = i % 360 / 90;
        this.jdField_a_of_type_Ilq.setCameraAngleFix(false, i);
      }
    }
    else {
      return;
    }
    int i = this.jdField_a_of_type_Ilq.getUserCameraAngle(true) + 90;
    int j = i % 360 / 90;
    this.jdField_a_of_type_Ilq.setCameraAngleFix(true, i);
  }
  
  public void anX()
  {
    SharedPreferences.Editor localEditor = this.mContext.getSharedPreferences("cameracfg", 0).edit();
    int i = this.jdField_a_of_type_Ilq.getUserCameraAngle(true);
    int j = this.jdField_a_of_type_Ilq.getUserCameraAngle(false);
    localEditor.putInt("frontCameraRotation", i);
    localEditor.putInt("backCameraRotation", j);
    localEditor.commit();
  }
  
  void anY()
  {
    this.mCameraHandler.removeMessages(1);
    this.mCameraHandler.removeMessages(2);
    this.mCameraHandler.removeMessages(3);
    this.mCameraHandler.removeMessages(4);
    this.mCameraHandler.removeMessages(5);
  }
  
  void anZ()
  {
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils$a == null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils$a = new a();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.qav.camera.availability");
      this.mContext.registerReceiver(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$a, localIntentFilter);
    }
  }
  
  void aoa()
  {
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils$a != null) {}
    try
    {
      this.mContext.unregisterReceiver(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$a);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils$a = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean aq(long paramLong)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_Ilq != null) {}
    for (boolean bool1 = this.jdField_a_of_type_Ilq.tS();; bool1 = false)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("isCameraOpening[").append(bool1).append("], mCamera[");
        if (this.jdField_a_of_type_Ilq != null) {
          bool2 = true;
        }
        QLog.w("CameraUtils", 2, bool2 + "], seq[" + paramLong + "]");
      }
      return bool1;
    }
  }
  
  public boolean ar(long paramLong)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Ilq != null) {
      bool = this.jdField_a_of_type_Ilq.tT();
    }
    QLog.w("CameraUtils", 1, "isCameraOpened, isCameraOpened[" + bool + "], seq[" + paramLong + "]");
    return bool;
  }
  
  public void b(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    if (this.Sm) {
      o(paramLong, paramInt1, paramInt2);
    }
    while (this.jdField_a_of_type_ComTencentAvCameraCameraUtils$c == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils$c.c(paramString, paramLong, paramInt1, paramInt2);
  }
  
  public void ca(long paramLong)
  {
    QLog.w("CameraUtils", 1, "openCamera, seq[" + paramLong + "], openCamera[" + this.jdField_a_of_type_ComTencentAvCameraCameraUtils$OpenCameraRunnable + "], closeCamera[" + this.jdField_a_of_type_ComTencentAvCameraCameraUtils$CloseCameraRunnable + "], mCamera[" + this.jdField_a_of_type_Ilq + "]");
    if (this.Sm)
    {
      if (Build.MODEL.equalsIgnoreCase("HWI-AL00"))
      {
        Object localObject = Build.MODEL + "_SP_QAV_CAMERA_OPENED";
        localObject = this.mContext.getSharedPreferences((String)localObject, 4);
        boolean bool = ((SharedPreferences)localObject).getBoolean("KEY_OPENED", false);
        QLog.w("CameraUtils", 1, "AVTest. openCamera. hasOpened = " + bool);
        if (!bool)
        {
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putBoolean("KEY_OPENED", true);
          ((SharedPreferences.Editor)localObject).commit();
          this.jdField_a_of_type_ComTencentAvVideoController.a().getHandler().postDelayed(new CameraUtils.3(this, paramLong), 1000L);
          return;
        }
        cb(paramLong);
        return;
      }
      cb(paramLong);
      return;
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils$OpenCameraRunnable.seq = paramLong;
    ThreadManager.remove(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$CloseCameraRunnable);
    ThreadManager.post(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$OpenCameraRunnable, 8, null, false);
  }
  
  public void cb(long paramLong)
  {
    anY();
    Message localMessage = this.mCameraHandler.obtainMessage(1);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.sendToTarget();
  }
  
  public void cc(long paramLong)
  {
    anY();
    Message localMessage = this.mCameraHandler.obtainMessage(4);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.sendToTarget();
  }
  
  public void cf(long paramLong)
  {
    if (this.jdField_a_of_type_Ilq.tT())
    {
      if (this.Sm) {
        cc(paramLong);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils$SwitchCameraRunnable.seq = paramLong;
    ThreadManager.post(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$SwitchCameraRunnable, 8, null, false);
  }
  
  public void deleteObserver(Observer paramObserver)
  {
    a().deleteObserver(paramObserver);
  }
  
  public boolean f(long paramLong, boolean paramBoolean)
  {
    String str = "null";
    if (this.jdField_a_of_type_Ilq != null) {
      str = this.jdField_a_of_type_Ilq.tT() + "";
    }
    if (QLog.isColorLevel()) {}
    for (Throwable localThrowable = new Throwable();; localThrowable = null)
    {
      QLog.w("CameraUtils", 1, "closeCamera, changeStatus[" + paramBoolean + "], isCameraOpened[" + str + "], openCamera[" + this.jdField_a_of_type_ComTencentAvCameraCameraUtils$OpenCameraRunnable + "], seq[" + paramLong + "]", localThrowable);
      if ((this.jdField_a_of_type_Ilq != null) && (this.jdField_a_of_type_Ilq.tT()))
      {
        if (this.Sm) {
          t(paramLong, paramBoolean);
        }
        for (;;)
        {
          return true;
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils$CloseCameraRunnable.seq = paramLong;
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils$CloseCameraRunnable.ir(paramBoolean);
          ThreadManager.remove(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$OpenCameraRunnable);
          ThreadManager.post(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$CloseCameraRunnable, 8, null, false);
        }
      }
      return false;
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        jd("finalize");
      }
      this.jdField_a_of_type_ComTencentAvVideoController = null;
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getCameraNum()
  {
    return this.aoI;
  }
  
  public boolean isFrontCamera()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Ilq != null) {
      bool = this.jdField_a_of_type_Ilq.isFrontCamera();
    }
    if (QLog.isColorLevel()) {
      QLog.w("CameraUtils", 1, "isFrontCamera[" + bool + "], mCamera[" + this.jdField_a_of_type_Ilq + "]");
    }
    return bool;
  }
  
  public void jd(String paramString)
  {
    if (!this.Sn)
    {
      if (AudioHelper.aCz()) {
        QLog.w("CameraUtils", 2, "stopNoPreviewRunnable[" + paramString + "], noPreview[" + this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable.seq + "]");
      }
      this.Sn = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable);
    }
  }
  
  public void o(long paramLong, int paramInt1, int paramInt2)
  {
    anY();
    Message localMessage = this.mCameraHandler.obtainMessage(3);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.sendToTarget();
  }
  
  public void q(long paramLong, String paramString)
  {
    if (AudioHelper.aCz()) {
      QLog.w("CameraUtils", 2, "startNoPreviewRunnable[" + paramString + "], seq[" + paramLong + "], noPreview[" + this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable.seq + "]");
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable.seq = paramLong;
    this.jdField_a_of_type_ComTencentAvVideoController.a().getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable);
    this.jdField_a_of_type_ComTencentAvVideoController.a().getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable, 10000L);
    this.Sn = false;
  }
  
  public void setRotation(int paramInt)
  {
    if (this.jdField_a_of_type_Ilq != null) {
      this.jdField_a_of_type_Ilq.kW(paramInt);
    }
  }
  
  public void setSupportLandscape(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ilq != null)
    {
      if (this.jdField_a_of_type_Ilq.Sk != paramBoolean) {
        QLog.w("CameraUtils", 1, "setSupportLandscape, value[" + this.jdField_a_of_type_Ilq.Sk + "->" + paramBoolean + "]");
      }
      this.jdField_a_of_type_Ilq.Sk = paramBoolean;
    }
  }
  
  public void t(long paramLong, boolean paramBoolean)
  {
    anY();
    Message localMessage = this.mCameraHandler.obtainMessage(2);
    localMessage.obj = Long.valueOf(paramLong);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      localMessage.sendToTarget();
      return;
    }
  }
  
  public void u(long paramLong, int paramInt)
  {
    this.mCameraHandler.removeMessages(5);
    Message localMessage = this.mCameraHandler.obtainMessage(5);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  public void w(long paramLong, int paramInt)
  {
    if ((this.jdField_a_of_type_Ilq != null) && (this.jdField_a_of_type_Ilq.tT()))
    {
      if (this.Sm) {
        u(paramLong, paramInt);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ilq.t(paramLong, paramInt);
  }
  
  class CloseCameraRunnable
    implements Runnable
  {
    private boolean So = true;
    public long seq;
    
    CloseCameraRunnable() {}
    
    public void ir(boolean paramBoolean)
    {
      this.So = paramBoolean;
    }
    
    public void run()
    {
      CameraUtils.a(CameraUtils.this, this.seq, this.So);
    }
    
    public String toString()
    {
      return this.seq + "";
    }
  }
  
  class NoPreviewRunnable
    implements Runnable
  {
    public long seq;
    
    NoPreviewRunnable() {}
    
    public void run()
    {
      if (CameraUtils.this.jdField_a_of_type_Ilq != null) {}
      for (boolean bool = CameraUtils.this.jdField_a_of_type_Ilq.tT();; bool = false)
      {
        if (AudioHelper.aCz()) {
          QLog.w("CameraUtils", 1, "NoPreviewRunnable.run, seq[" + this.seq + "], isCameraOpened[" + bool + "], seq[" + this.seq + "]");
        }
        CameraUtils.this.jdField_a_of_type_ComTencentAvVideoController.a().l(new Object[] { Integer.valueOf(38), Integer.valueOf(2), Long.valueOf(this.seq) });
        return;
      }
    }
  }
  
  class OpenCameraRunnable
    implements Runnable
  {
    boolean Sp = false;
    long seq = 0L;
    
    OpenCameraRunnable() {}
    
    @TargetApi(14)
    public void run()
    {
      if (this.Sp)
      {
        QLog.w("CameraUtils", 1, "openCamera begin, mCamera[" + CameraUtils.this.a + "], mOpening[" + this.Sp + "], seq[" + this.seq + "]");
        return;
      }
      CameraUtils.a(CameraUtils.this, this.seq);
      this.Sp = false;
    }
    
    public String toString()
    {
      return "mOpening[" + this.Sp + "], seq[" + this.seq + "]";
    }
  }
  
  class SwitchCameraRunnable
    implements Runnable
  {
    long seq = 0L;
    
    SwitchCameraRunnable() {}
    
    @TargetApi(14)
    public void run()
    {
      CameraUtils.b(CameraUtils.this, this.seq);
    }
    
    public String toString()
    {
      return this.seq + "";
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent == null) {
        return;
      }
      paramContext = paramIntent.getStringExtra("camera_id");
      int i = paramIntent.getIntExtra("availability", 1);
      long l = jlc.a(paramIntent);
      CameraUtils.a(CameraUtils.this).put(paramContext, Integer.valueOf(i));
      if ((i == 1) && (CameraUtils.this.ar(l)))
      {
        paramContext = CameraUtils.a(CameraUtils.this).entrySet().iterator();
        do
        {
          if (!paramContext.hasNext()) {
            break;
          }
        } while (((Integer)((Map.Entry)paramContext.next()).getValue()).intValue() != 0);
      }
      for (boolean bool = false;; bool = true)
      {
        if (AudioHelper.aCz()) {
          QLog.w("CameraUtils", 1, "CameraAvailabilityReceiver, sendReopenCameraMsg, result[" + bool + "], seq[" + l + "]");
        }
        if (!bool) {
          break;
        }
        CameraUtils.a(CameraUtils.this).c("CameraAvailabilityReceiver", l, -1, -1);
        return;
        if (AudioHelper.aCz()) {
          QLog.w("CameraUtils", 1, "CameraAvailabilityReceiver, removeReopenCameraMsg, seq[" + i + "]");
        }
        CameraUtils.a(CameraUtils.this).cg(l);
        return;
      }
    }
  }
  
  class b
    extends Observable
  {
    public b() {}
    
    public void m(Object[] paramArrayOfObject)
    {
      try
      {
        super.setChanged();
        super.notifyObservers(paramArrayOfObject);
        return;
      }
      finally
      {
        paramArrayOfObject = finally;
        throw paramArrayOfObject;
      }
    }
  }
  
  static class c
    extends Handler
  {
    WeakReference<CameraUtils> bs;
    
    public c(CameraUtils paramCameraUtils, Looper paramLooper)
    {
      super();
      this.bs = new WeakReference(paramCameraUtils);
    }
    
    public void c(String paramString, long paramLong, int paramInt1, int paramInt2)
    {
      QLog.w("CameraUtils", 1, "sendReopenCameraMsg[" + paramString + "], size[" + paramInt1 + ", " + paramInt2 + "], subthread[" + getLooper().getThread().getId() + "], seq[" + paramLong + "]");
      cg(paramLong);
      paramString = obtainMessage(1);
      paramString.arg1 = paramInt1;
      paramString.arg2 = paramInt2;
      paramString.obj = Long.valueOf(paramLong);
      sendMessageDelayed(paramString, 1000L);
    }
    
    public void cg(long paramLong)
    {
      removeMessages(1);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((this.bs != null) && (this.bs.get() != null) && (paramMessage != null) && (paramMessage.what == 1)) {
        if (!(paramMessage.obj instanceof Long)) {
          break label75;
        }
      }
      label75:
      for (long l = Long.valueOf(0L).longValue();; l = 0L)
      {
        CameraUtils.a((CameraUtils)this.bs.get(), l, paramMessage.arg1, paramMessage.arg2);
        super.handleMessage(paramMessage);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.camera.CameraUtils
 * JD-Core Version:    0.7.0.1
 */