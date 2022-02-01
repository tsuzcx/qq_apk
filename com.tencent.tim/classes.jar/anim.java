import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.a;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.a;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.b;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.c;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable.1;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class anim
  implements Camera.PreviewCallback, Camera2Control.b
{
  public static HandlerThread l;
  private Camera.FaceDetectionListener jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener;
  public final anim.a a;
  public final anim.c a;
  private anim.d jdField_a_of_type_Anim$d;
  anim.f jdField_a_of_type_Anim$f = new anim.f();
  public boolean aZC;
  public anil b;
  public anim.f b;
  public anim.f c = new anim.f();
  private volatile boolean cAr;
  public boolean cFW;
  private boolean cGR;
  private boolean cGS;
  private boolean cGT;
  private String ceg = "";
  private String ceh;
  private String cei;
  anim.f d = new anim.f();
  public volatile int dGT;
  private int dGU = 2147483647;
  anim.f e = new anim.f();
  anim.f f = new anim.f();
  anim.f g = new anim.f();
  private String[] gJ;
  anim.f h = new anim.f();
  public int mScreenHeight;
  public int mScreenWidth;
  private int[] nC;
  private int[] nD;
  public Map<String, anim.f> nc = new HashMap();
  public Map<String, anim.g> nd = new HashMap();
  
  public anim(Context paramContext, Handler paramHandler)
  {
    this.jdField_b_of_type_Anim$f = new anim.f();
    if (l == null)
    {
      l = ThreadManager.newFreeHandlerThread("Camera2 Handler Thread", 0);
      l.start();
    }
    this.jdField_a_of_type_Anim$c = new anim.c(paramHandler);
    this.jdField_a_of_type_Anim$a = new anim.a(l.getLooper());
  }
  
  private void UX(int paramInt)
  {
    try
    {
      axiy.i("CameraProxy", "camera2 open out.");
      this.jdField_a_of_type_Anim$a.obtainMessage(1001, new Object[] { Integer.valueOf(paramInt), this }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_b_of_type_Anil == null) {}
      this.jdField_b_of_type_Anil.a(localRuntimeException);
    }
  }
  
  private String a(Camera.Parameters paramParameters)
  {
    if (!this.cGR) {
      b(paramParameters);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.cGS)
    {
      localObject1 = localObject2;
      if (this.cei != null) {
        localObject1 = paramParameters.get(this.cei);
      }
    }
    if (aqmr.isEmpty((String)localObject1)) {
      this.cGS = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "getCurrentISO=" + (String)localObject1);
    }
    return localObject1;
  }
  
  private void a(SurfaceTexture paramSurfaceTexture, anim.d paramd, boolean paramBoolean)
  {
    if (paramSurfaceTexture != null) {
      setPreviewTexture(paramSurfaceTexture);
    }
    if (paramd != null)
    {
      a(paramd);
      a(this, paramBoolean);
    }
    try
    {
      this.jdField_a_of_type_Anim$a.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_b_of_type_Anil == null) {}
      this.jdField_b_of_type_Anil.a(paramSurfaceTexture);
    }
  }
  
  private void a(anim.d paramd)
  {
    this.jdField_a_of_type_Anim$d = paramd;
  }
  
  private boolean a(Camera.Parameters paramParameters, String paramString)
  {
    if ((!aqmr.isEmpty(paramString)) && (this.cei != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "set iso to =" + paramString);
      }
      paramParameters.set(this.cei, paramString);
      return true;
    }
    return false;
  }
  
  @TargetApi(9)
  private boolean a(Camera.Parameters paramParameters, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length != 2)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "setFpsRange " + paramArrayOfInt[0] + " " + paramArrayOfInt[1]);
    }
    paramParameters.setPreviewFpsRange(paramArrayOfInt[0], paramArrayOfInt[1]);
    return true;
  }
  
  @TargetApi(9)
  private int[] a(Camera.Parameters paramParameters)
  {
    int[] arrayOfInt = new int[2];
    paramParameters.getPreviewFpsRange(arrayOfInt);
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "getCurrentFpsRange " + arrayOfInt[0] + " " + arrayOfInt[1]);
    }
    return arrayOfInt;
  }
  
  private void b(Camera.Parameters paramParameters)
  {
    this.cGR = true;
    paramParameters = paramParameters.flatten();
    if (paramParameters.contains("iso-values"))
    {
      this.ceh = "iso-values";
      this.cei = "iso";
      if (this.cei == null) {
        break label244;
      }
      paramParameters = paramParameters.substring(paramParameters.indexOf(this.ceh));
      String str = paramParameters.substring(paramParameters.indexOf("=") + 1);
      paramParameters = str;
      if (str.contains(";")) {
        paramParameters = str.substring(0, str.indexOf(";"));
      }
      this.gJ = paramParameters.split(",");
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "init iso key=" + this.cei + " value key" + this.ceh + " Values=" + paramParameters);
      }
    }
    label244:
    do
    {
      return;
      if (paramParameters.contains("iso-mode-values"))
      {
        this.ceh = "iso-mode-values";
        this.cei = "iso";
        break;
      }
      if (paramParameters.contains("iso-speed-values"))
      {
        this.ceh = "iso-speed-values";
        this.cei = "iso-speed";
        break;
      }
      if (!paramParameters.contains("nv-picture-iso-values")) {
        break;
      }
      this.ceh = "nv-picture-iso-values";
      this.cei = "nv-picture-iso";
      break;
      this.cGS = false;
    } while (!QLog.isColorLevel());
    QLog.i("CameraProxy", 2, "init iso not support");
  }
  
  private boolean b(Camera.Parameters paramParameters)
  {
    if (!this.cGR) {
      b(paramParameters);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.cGS)
    {
      localObject1 = localObject2;
      if (this.gJ != null)
      {
        localObject1 = localObject2;
        if (this.gJ.length > 0) {
          localObject1 = this.gJ[(this.gJ.length - 1)];
        }
      }
    }
    if ((!aqmr.isEmpty((String)localObject1)) && (this.cei != null)) {
      return a(paramParameters, (String)localObject1);
    }
    return false;
  }
  
  @TargetApi(9)
  private int[] b(Camera.Parameters paramParameters)
  {
    new ArrayList();
    Object localObject = paramParameters.getSupportedPreviewFpsRange();
    paramParameters = new int[2];
    if (localObject != null)
    {
      Iterator localIterator = ((List)localObject).iterator();
      int i = 2147483647;
      localObject = paramParameters;
      if (!localIterator.hasNext()) {
        break label73;
      }
      localObject = (int[])localIterator.next();
      if (localObject[0] >= i) {
        break label120;
      }
      i = localObject[0];
      paramParameters = (Camera.Parameters)localObject;
    }
    label73:
    label120:
    for (;;)
    {
      break;
      localObject = paramParameters;
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "getCurrentFpsRange " + localObject[0] + " " + localObject[1]);
      }
      return localObject;
    }
  }
  
  private boolean c(Camera.Parameters paramParameters)
  {
    if (!this.cGR) {
      b(paramParameters);
    }
    return this.cGS;
  }
  
  private void dQm()
  {
    try
    {
      this.jdField_a_of_type_Anim$a.obtainMessage(1060, new Object[] { this }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_b_of_type_Anil == null) {}
      this.jdField_b_of_type_Anil.a(localRuntimeException);
    }
  }
  
  @TargetApi(14)
  private void dQr()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "enterNightMode");
    }
    Camera.Parameters localParameters = anij.a().b();
    if (c(localParameters))
    {
      if (aqmr.isEmpty(this.ceg)) {
        this.ceg = a(localParameters);
      }
      b(localParameters);
    }
    if (this.dGU == 2147483647) {
      this.dGU = localParameters.getExposureCompensation();
    }
    localParameters.setExposureCompensation(localParameters.getMaxExposureCompensation());
    if (this.nC == null) {
      this.nC = a(localParameters);
    }
    if (this.nD == null) {
      this.nD = b(localParameters);
    }
    a(localParameters, this.nD);
    anij.a().mCamera.setParameters(localParameters);
  }
  
  @TargetApi(14)
  private void dQs()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "leaveNightMode");
    }
    Camera.Parameters localParameters = anij.a().b();
    if ((c(localParameters)) && (!aqmr.isEmpty(this.ceg))) {
      a(localParameters, this.ceg);
    }
    if (this.dGU != 2147483647) {
      localParameters.setExposureCompensation(this.dGU);
    }
    if (this.nC != null) {
      a(localParameters, this.nC);
    }
    anij.a().mCamera.setParameters(localParameters);
  }
  
  private void dQt()
  {
    if (!this.cGT)
    {
      anhj.dH(1, "[Camera2]initIsSupportCamera2:" + this.cGT);
      this.cFW = false;
      return;
    }
    int k = anki.JP();
    int j = anki.JQ();
    anhj.dH(1, "[Camera2]initIsSupportCamera2 sdkVersion:" + k + ", camera2Switch:" + j + ", version:" + Build.VERSION.SDK_INT);
    if (Build.VERSION.SDK_INT < 23)
    {
      this.cFW = false;
      return;
    }
    if ((k <= -1) || (j <= -1))
    {
      this.cFW = false;
      return;
    }
    int i = j;
    if (wja.Rb())
    {
      i = j;
      if (Build.VERSION.SDK_INT >= 28)
      {
        i = j;
        if (aywy.a().aRo()) {
          i = 1;
        }
      }
    }
    if ((k >= 23) && (Build.VERSION.SDK_INT >= k) && (i != 2))
    {
      this.cFW = Camera2Control.awW();
      return;
    }
    if (i == 0)
    {
      this.cFW = false;
      return;
    }
    this.cFW = Camera2Control.awW();
    anhj.dH(1, "[Camera2]initIsSupportCamera2 result:" + this.cFW);
  }
  
  private void e(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      dQm();
      this.jdField_a_of_type_Anim$a.obtainMessage(1002, new Object[] { paramSurfaceTexture }).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_b_of_type_Anil == null) {}
      this.jdField_b_of_type_Anil.a(paramSurfaceTexture);
    }
  }
  
  public void PQ(boolean paramBoolean)
  {
    try
    {
      a(null);
      if (!this.cFW)
      {
        if (!paramBoolean)
        {
          this.jdField_a_of_type_Anim$a.sendEmptyMessage(205);
          return;
        }
        this.jdField_a_of_type_Anim$a.obtainMessage(205).sendToTarget();
        aI(3500L, "stop preview");
        return;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_b_of_type_Anil != null) {
        this.jdField_b_of_type_Anil.a(localRuntimeException);
      }
    }
  }
  
  public void PR(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("CameraProxy", 2, new Object[] { "cameraDestroyed, cameraCreate has created, ", Boolean.valueOf(this.cAr) });
        }
        boolean bool = this.cAr;
        if (!bool) {
          return;
        }
        this.cAr = false;
        try
        {
          if (!this.cFW) {
            break label89;
          }
          dQl();
        }
        catch (RuntimeException localRuntimeException) {}
        if (this.jdField_b_of_type_Anil == null) {
          continue;
        }
        this.jdField_b_of_type_Anil.a(localRuntimeException);
        continue;
        if (paramBoolean) {
          break label105;
        }
      }
      finally {}
      label89:
      this.jdField_a_of_type_Anim$a.sendEmptyMessage(2);
      continue;
      label105:
      this.jdField_a_of_type_Anim$a.obtainMessage(2).sendToTarget();
      aI(3500L, "release camera");
    }
  }
  
  public void PS(boolean paramBoolean)
  {
    int i = 1;
    if (this.cFW)
    {
      this.jdField_a_of_type_Anim$a.obtainMessage(1050, new Object[] { Boolean.valueOf(paramBoolean) }).sendToTarget();
      return;
    }
    anim.a locala = this.jdField_a_of_type_Anim$a;
    if (paramBoolean) {}
    for (;;)
    {
      locala.obtainMessage(401, i, 0).sendToTarget();
      return;
      i = 2;
    }
  }
  
  public void PT(boolean paramBoolean)
  {
    if (this.cFW) {
      return;
    }
    anim.a locala = this.jdField_a_of_type_Anim$a;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      locala.obtainMessage(402, i, 0).sendToTarget();
      return;
    }
  }
  
  public void PU(boolean paramBoolean)
  {
    this.cGT = paramBoolean;
    anhj.dH(1, "[Camera2]setCamera2Usable:" + this.cGT);
  }
  
  public void UT(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_Anim$a.obtainMessage(1070, paramInt, 0).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_b_of_type_Anil == null) {}
      this.jdField_b_of_type_Anil.a(localRuntimeException);
    }
  }
  
  public void UW(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("CameraProxy", 2, new Object[] { "cameraCreate, cameraCreate has created, ", Boolean.valueOf(this.cAr), " id:", Integer.valueOf(paramInt) });
        }
        if (this.cAr)
        {
          Object localObject1 = PeakAppInterface.a;
          if (axpk.cAr)
          {
            localObject1 = PeakAppInterface.a;
            if (!axpk.dvR) {
              continue;
            }
            localObject1 = PeakAppInterface.a;
            localObject1 = Boolean.valueOf(axpk.dvR);
            this.jdField_a_of_type_Anim$c.notify(1, new Object[] { localObject1 });
            if (QLog.isColorLevel()) {
              QLog.d("CameraProxy", 2, "cameraCreate, cameraCreate has created and notify");
            }
          }
          return;
          localObject1 = PeakAppInterface.a;
          localObject1 = axpk.cVF;
          continue;
        }
        this.cAr = true;
        dQt();
        if (this.cFW)
        {
          UX(paramInt);
          continue;
        }
        try
        {
          this.jdField_a_of_type_Anim$a.obtainMessage(1, new Object[] { Integer.valueOf(paramInt) }).sendToTarget();
        }
        catch (RuntimeException localRuntimeException) {}
      }
      finally {}
      if (this.jdField_b_of_type_Anil != null) {
        this.jdField_b_of_type_Anil.a(localRuntimeException);
      }
    }
  }
  
  public anim.a a()
  {
    return this.jdField_a_of_type_Anim$a;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, anim.d paramd, boolean paramBoolean)
  {
    if (this.cFW)
    {
      if (paramSurfaceTexture == null)
      {
        UT(-201);
        return;
      }
      if (paramd != null) {
        a(paramd);
      }
      e(paramSurfaceTexture);
      return;
    }
    if (paramSurfaceTexture != null)
    {
      a(paramSurfaceTexture, paramd, paramBoolean);
      return;
    }
    a(paramSurfaceHolder, paramd, paramBoolean);
  }
  
  public void a(Camera.FaceDetectionListener paramFaceDetectionListener)
  {
    this.jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener = paramFaceDetectionListener;
  }
  
  public void a(Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    int i = 0;
    try
    {
      anim.a locala = this.jdField_a_of_type_Anim$a;
      if (paramBoolean) {
        i = 1;
      }
      locala.obtainMessage(203, i, 0, paramPreviewCallback).sendToTarget();
      return;
    }
    catch (RuntimeException paramPreviewCallback)
    {
      while (this.jdField_b_of_type_Anil == null) {}
      this.jdField_b_of_type_Anil.a(paramPreviewCallback);
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, anim.d paramd, boolean paramBoolean)
  {
    if (paramSurfaceHolder != null) {
      setSurfaceHolder(paramSurfaceHolder);
    }
    if (paramd != null)
    {
      a(paramd);
      a(this, paramBoolean);
    }
    try
    {
      this.jdField_a_of_type_Anim$a.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      while (this.jdField_b_of_type_Anil == null) {}
      this.jdField_b_of_type_Anil.a(paramSurfaceHolder);
    }
  }
  
  public void a(anhk paramanhk, anim.b paramb)
  {
    try
    {
      locale = new anim.e();
      if (!this.cFW) {
        break label118;
      }
      i = 1030;
      if ((paramanhk != null) && (paramanhk.cGe) && (paramb != null))
      {
        paramb.bm(true, true);
        return;
      }
      anhh localanhh = new anhh();
      localanhh.Type = 1;
      localanhh.b = new anin(this, paramb);
      locale.jdField_a_of_type_Anhh = localanhh;
      locale.jdField_a_of_type_Anhk = paramanhk;
    }
    catch (RuntimeException paramanhk)
    {
      anim.e locale;
      int i;
      while (this.jdField_b_of_type_Anil != null)
      {
        this.jdField_b_of_type_Anil.a(paramanhk);
        return;
        label118:
        if ((paramanhk != null) && (paramanhk.awZ()))
        {
          locale.cF = paramanhk.c.a(paramanhk.x, paramanhk.y, paramanhk.screenWidth, paramanhk.dGb, 1.0F);
          locale.cG = paramanhk.c.a(paramanhk.x, paramanhk.y, paramanhk.screenWidth, paramanhk.dGb, 1.5F);
        }
        locale.b = new anio(this, paramb);
        i = 103;
      }
    }
    this.jdField_a_of_type_Anim$a.obtainMessage(i, locale).sendToTarget();
    return;
  }
  
  public void a(anij.b paramb1, anij.b paramb2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      if (this.cFW)
      {
        this.jdField_a_of_type_Anim$a.obtainMessage(1005, new Object[] { paramb1, paramb2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }).sendToTarget();
        return;
      }
      this.jdField_a_of_type_Anim$a.obtainMessage(7, new Object[] { paramb1, paramb2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }).sendToTarget();
      return;
    }
    catch (RuntimeException paramb1)
    {
      if (this.jdField_b_of_type_Anil != null) {
        this.jdField_b_of_type_Anil.a(paramb1);
      }
    }
  }
  
  public void a(anil paramanil)
  {
    this.jdField_b_of_type_Anil = paramanil;
  }
  
  public void a(File paramFile, Rect paramRect, CameraCover.a parama, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    anim.h localh = new anim.h(null);
    localh.mFile = paramFile;
    localh.cD = paramRect;
    localh.c = parama;
    localh.mOrientation = paramInt1;
    localh.mMirror = paramBoolean;
    localh.dGX = paramInt2;
    if (this.cFW)
    {
      localh.mOrientation = paramInt3;
      this.jdField_a_of_type_Anim$a.obtainMessage(1010, localh).sendToTarget();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraProxy", 2, "takePicture : file = " + paramFile + " ; orientation = " + paramInt1);
      }
      return;
      localh.mOrientation = paramInt1;
      this.jdField_a_of_type_Anim$a.obtainMessage(301, localh).sendToTarget();
    }
  }
  
  public void aI(long paramLong, String paramString)
  {
    paramString = "Timeout waiting " + paramLong + "ms for " + paramString;
    long l1 = SystemClock.uptimeMillis() + paramLong;
    try
    {
      anim.i locali = new anim.i();
      this.jdField_a_of_type_Anim$a.post(locali.hA);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      synchronized (locali.bi)
      {
        locali.bi.wait(paramLong);
        if (SystemClock.uptimeMillis() > l1)
        {
          throw new IllegalStateException(paramString);
          localInterruptedException = localInterruptedException;
          if (SystemClock.uptimeMillis() > l1) {
            throw new IllegalStateException(paramString);
          }
        }
      }
    }
  }
  
  public void b(anho paramanho)
  {
    this.jdField_a_of_type_Anim$c.a(paramanho, new int[] { 1, 2, 3, 4, 6, 7, 10, 11, 12, 13, 14 });
  }
  
  public void bU(int paramInt, boolean paramBoolean) {}
  
  @Deprecated
  public void bb(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      this.jdField_a_of_type_Anim$a.obtainMessage(6, paramInt2, paramInt3, Integer.valueOf(paramInt1)).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_b_of_type_Anil == null) {}
      this.jdField_b_of_type_Anil.a(localRuntimeException);
    }
  }
  
  public void c(anho paramanho)
  {
    this.jdField_a_of_type_Anim$c.a(paramanho);
  }
  
  public void cye()
  {
    try
    {
      if (this.cFW) {
        this.jdField_a_of_type_Anim$a.obtainMessage(1021).sendToTarget();
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_b_of_type_Anil == null) {}
      this.jdField_b_of_type_Anil.a(localRuntimeException);
    }
  }
  
  public void dQj()
  {
    UW(aaqh.cix);
  }
  
  public void dQk()
  {
    PQ(false);
  }
  
  public void dQl()
  {
    try
    {
      this.jdField_a_of_type_Anim$a.obtainMessage(1003).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_b_of_type_Anil == null) {}
      this.jdField_b_of_type_Anil.a(localRuntimeException);
    }
  }
  
  public void dQn()
  {
    this.jdField_a_of_type_Anim$a.obtainMessage(502, 2, 0).sendToTarget();
  }
  
  public void dQo()
  {
    try
    {
      this.jdField_a_of_type_Anim$a.obtainMessage(102).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_b_of_type_Anil == null) {}
      this.jdField_b_of_type_Anil.a(localRuntimeException);
    }
  }
  
  public void dQp()
  {
    try
    {
      if (this.cFW)
      {
        this.jdField_a_of_type_Anim$a.obtainMessage(1032).sendToTarget();
        return;
      }
      this.jdField_a_of_type_Anim$a.obtainMessage(104).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_b_of_type_Anil != null) {
        this.jdField_b_of_type_Anil.a(localRuntimeException);
      }
    }
  }
  
  public void dQq()
  {
    try
    {
      if (this.cFW)
      {
        this.jdField_a_of_type_Anim$a.obtainMessage(1031).sendToTarget();
        return;
      }
      this.jdField_a_of_type_Anim$a.obtainMessage(101).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_b_of_type_Anil != null) {
        this.jdField_b_of_type_Anil.a(localRuntimeException);
      }
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    anim.d locald = this.jdField_a_of_type_Anim$d;
    if (locald != null) {
      locald.onPreviewFrame(paramArrayOfByte, paramCamera);
    }
  }
  
  public void setPreviewTexture(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.jdField_a_of_type_Anim$a.obtainMessage(201, paramSurfaceTexture).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_b_of_type_Anil == null) {}
      this.jdField_b_of_type_Anil.a(paramSurfaceTexture);
    }
  }
  
  public void setSceneMode(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Anim$a.obtainMessage(701, new Object[] { paramString }).sendToTarget();
      return;
    }
    catch (RuntimeException paramString)
    {
      while (this.jdField_b_of_type_Anil == null) {}
      this.jdField_b_of_type_Anil.a(paramString);
    }
  }
  
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      this.jdField_a_of_type_Anim$a.obtainMessage(202, paramSurfaceHolder).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      while (this.jdField_b_of_type_Anil == null) {}
      this.jdField_b_of_type_Anil.a(paramSurfaceHolder);
    }
  }
  
  public void setZoom(int paramInt)
  {
    int i = 601;
    try
    {
      if (this.cFW) {
        i = 1040;
      }
      this.jdField_a_of_type_Anim$a.obtainMessage(i, new Object[] { Integer.valueOf(paramInt) }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_b_of_type_Anil == null) {}
      this.jdField_b_of_type_Anil.a(localRuntimeException);
    }
  }
  
  public class a
    extends Handler
    implements Camera.AutoFocusCallback
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    @TargetApi(14)
    private void a(Rect paramRect1, Rect paramRect2, Camera.AutoFocusCallback paramAutoFocusCallback)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS");
      }
      Camera.Parameters localParameters = anij.a().b();
      if ((Build.VERSION.SDK_INT >= 14) && (paramRect1 != null))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage] focus area = " + paramRect1);
        }
        localParameters.setFocusMode("auto");
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new Camera.Area(paramRect1, 1000));
        localParameters.setFocusAreas(localArrayList);
        if ((localParameters.getMaxNumMeteringAreas() > 0) && (paramRect2 != null))
        {
          paramRect1 = new ArrayList(1);
          paramRect1.add(new Camera.Area(new Rect(paramRect2), 1000));
          localParameters.setMeteringAreas(paramRect1);
        }
        anij.a().mCamera.setParameters(localParameters);
      }
      paramRect1 = paramAutoFocusCallback;
      if (paramAutoFocusCallback == null) {
        paramRect1 = new anip(this);
      }
      anij.a().a(paramRect1);
    }
    
    public String getDefaultFocusMode()
    {
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[@] getDefaultFocusMode: Build.MANUFACTURER=" + Build.MANUFACTURER + "VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.VERSION.SDK_INT >= 14)) {}
      return "continuous-picture";
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool1 = false;
      boolean bool3 = false;
      boolean bool4 = false;
      boolean bool5 = false;
      boolean bool2 = false;
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        try
        {
          throw new RuntimeException("Unimplemented CameraProxy message=" + paramMessage.what);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[Camera2Handler.handleMessage]", localException);
          }
          return;
          axiy.i("CameraProxy", "[handleMessage] OPEN_CAMERA + BEGIN");
          i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] OPEN_CAMERA");
          }
          i = anij.a().jr(i);
          axiy.i("CameraProxy", "[handleMessage] OPEN_CAMERA, result = " + i);
          if (i == 5)
          {
            anim.this.jdField_a_of_type_Anim$c.notify(1, new Object[] { Boolean.valueOf(true) });
            return;
          }
          if (i != 0)
          {
            anim.this.jdField_a_of_type_Anim$c.notify(1, new Object[] { "open camera failed:errcode=" + anij.fj(i) });
            return;
          }
          if (!anij.a().axr())
          {
            anim.this.jdField_a_of_type_Anim$c.notify(1, new Object[] { "open camera failed, orientation error." });
            return;
          }
          anim.this.jdField_a_of_type_Anim$c.notify(1, new Object[] { Boolean.valueOf(true) });
          anim.this.aZC = false;
          return;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]CHANGED");
          }
          int k = Integer.parseInt(paramMessage.obj.toString());
          i = paramMessage.arg1;
          j = paramMessage.arg2;
          anim.this.aZC = false;
          anim.a(anim.this, false);
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[@] surfaceChanged start, format = " + k + ",width = " + i + ",height = " + j);
          }
          if ((anim.this.mScreenWidth <= 0) || (i <= anim.this.mScreenWidth)) {
            break label5339;
          }
          i = anim.this.mScreenWidth;
          if ((anim.this.mScreenHeight <= 0) || (j <= anim.this.mScreenHeight)) {
            break label5336;
          }
          j = anim.this.mScreenHeight;
          localObject7 = anij.a();
          if (Build.VERSION.SDK_INT <= 10) {
            anij.a().axq();
          }
          if (anim.this.dGT == 1)
          {
            localObject1 = anim.this.jdField_a_of_type_Anim$f;
            if (((anim.f)localObject1).bn.get()) {
              continue;
            }
            if (!anij.a().axt()) {
              anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set preview format failed" });
            }
          }
          else
          {
            if (anim.this.dGT == 3)
            {
              if (aaqh.cix == 1)
              {
                localObject1 = anim.this.c;
                continue;
              }
              if (aaqh.cix == 2)
              {
                localObject1 = anim.this.b;
                continue;
              }
              anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
              return;
            }
            if (anim.this.dGT == 2)
            {
              if (aaqh.cix == 1)
              {
                localObject1 = anim.this.e;
                continue;
              }
              if (aaqh.cix == 2)
              {
                localObject1 = anim.this.d;
                continue;
              }
              anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set preview format failed[Camera Kind error:RATIO_SCREEN]" });
              return;
            }
            if (anim.this.dGT == 4)
            {
              if (aaqh.cix == 1)
              {
                localObject1 = anim.this.g;
                continue;
              }
              if (aaqh.cix == 2)
              {
                localObject1 = anim.this.f;
                continue;
              }
              anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
              return;
            }
            if (anim.this.dGT == 5)
            {
              localObject1 = anim.this.h;
              continue;
            }
            anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set preview format failed[Preview Selector Error]" });
            return;
          }
          localObject6 = null;
          if ((anim.this.dGT == 1) || (anim.this.dGT == 3) || (anim.this.dGT == 4))
          {
            localObject6 = ((anij)localObject7).c(aniq.dHf, aniq.dHg, anim.this.mScreenWidth, anim.this.mScreenHeight);
            localObject5 = localObject6[0];
            localObject6 = localObject6[1];
            if (localObject5 == null) {
              break label5330;
            }
            bool1 = anij.a().c((anij.b)localObject5);
            break label5342;
            if (!bool1) {
              anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set preview size failed" + (String)localObject5 });
            }
          }
          else
          {
            if (anim.this.dGT == 2)
            {
              localObject5 = ((anij)localObject7).a(aniq.dHf, aniq.dHg, i, j);
              bool1 = bool4;
              if (localObject5 == null) {
                break label5350;
              }
              bool1 = anij.a().c((anij.b)localObject5);
              break label5350;
            }
            if (anim.this.dGT != 5) {
              break label5366;
            }
            if ((Build.MANUFACTURER.equals("Xiaomi")) && (Build.MODEL.equals("MI 3")))
            {
              localObject5 = new anij.b();
              ((anij.b)localObject5).width = 640;
              ((anij.b)localObject5).height = 480;
              bool1 = bool5;
              if (localObject5 == null) {
                break label5358;
              }
              bool1 = anij.a().c((anij.b)localObject5);
              break label5358;
            }
            localObject5 = ((anij)localObject7).a(480);
            continue;
          }
          if (!anij.a().lA(aniq.dHc))
          {
            anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set preview fps failed" });
            return;
          }
          if ((anim.this.dGT != 1) && (anim.this.dGT != 4) && (anim.this.dGT != 5) && (localObject6 != null) && (!((anij)localObject7).b((anij.b)localObject6))) {}
          ((anim.f)localObject1).cFs = anij.a().getPreviewFormat();
          ((anim.f)localObject1).e = anij.a().c();
          localObject5 = anij.a().d();
          if (localObject5 != null)
          {
            ((anim.f)localObject1).f = ((anij.b)localObject5);
            ((anim.f)localObject1).cGV = true;
          }
          localObject5 = anij.a().Z();
          ((anim.f)localObject1).dGV = localObject5[0];
          ((anim.f)localObject1).dGW = localObject5[1];
          if ((anim.this.dGT != 1) && (anim.this.dGT != 3) && (anim.this.dGT != 4) && (anim.this.dGT != 5))
          {
            ((anim.f)localObject1).f = anij.a().d();
            ((anim.f)localObject1).cGV = true;
          }
          if (anim.this.dGT == 4) {
            ((anim.f)localObject1).cGV = false;
          }
          ((anim.f)localObject1).bn.getAndSet(true);
          Object localObject1 = getDefaultFocusMode();
          if ((!anij.a().setParamsFocusMode((String)localObject1)) && (!anij.a().setParamsFocusMode("auto")) && (!anij.a().a(this))) {
            anim.this.jdField_a_of_type_Anim$c.notify(9, new Object[] { acfp.m(2131703381) });
          }
          if (!anij.a().axr())
          {
            anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set display orientation failed" });
            return;
            if (!anij.a().a((anim.f)localObject1))
            {
              anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set Camera Params failed" });
              return;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("CameraProxy", 2, "[handleMessage]Set camera param by cache params");
            continue;
          }
        }
        finally
        {
          anim.i.aS(paramMessage);
        }
        Object localObject3 = anij.a().Z();
        int i = anij.a().getPreviewFormat();
        Object localObject5 = anij.a().c();
        anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
        continue;
        localObject3 = (Object[])paramMessage.obj;
        localObject5 = (anij.b)localObject3[0];
        Object localObject7 = (anij.b)localObject3[1];
        i = ((Integer)localObject3[2]).intValue();
        int j = ((Integer)localObject3[3]).intValue();
        bool2 = ((Boolean)localObject3[4]).booleanValue();
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage] SET_PARAMS, , wantedSize = " + localObject5 + " , viewSize = " + localObject7 + " , selectMode = " + i + " , resolutionMode = " + bool2);
        }
        anim.this.aZC = false;
        anim.a(anim.this, false);
        Object localObject6 = anij.a();
        Object localObject8 = anij.a().dGP + "#" + localObject5 + "#" + localObject7 + "#" + i;
        localObject3 = (anim.f)anim.this.nc.get(localObject8);
        if (localObject3 == null)
        {
          localObject3 = new anim.f();
          anim.this.nc.put(localObject8, localObject3);
        }
        for (;;)
        {
          for (;;)
          {
            if (!((anim.f)localObject3).bn.get())
            {
              if (!anij.a().axt())
              {
                anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set preview format failed" });
                anim.i.aS(paramMessage);
                return;
              }
              if (!bool2) {}
              for (localObject5 = ((anij)localObject6).a(((anij.b)localObject5).width, ((anij.b)localObject5).height, ((anij.b)localObject7).width, ((anij.b)localObject7).height);; localObject5 = ((anij)localObject6).b(((anij.b)localObject5).width, ((anij.b)localObject5).height, ((anij.b)localObject7).width, ((anij.b)localObject7).height))
              {
                localObject7 = localObject5[0];
                localObject5 = localObject5[1];
                if (localObject7 != null) {
                  bool1 = anij.a().c((anij.b)localObject7);
                }
                if (bool1) {
                  break;
                }
                anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set preview size failed" + "" });
                anim.i.aS(paramMessage);
                return;
              }
              if (((localObject5 == null) || (((anij)localObject6).b((anij.b)localObject5))) || (!anij.a().lA(j)))
              {
                anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set preview fps failed" });
                anim.i.aS(paramMessage);
                return;
              }
              ((anim.f)localObject3).cFs = anij.a().getPreviewFormat();
              ((anim.f)localObject3).e = anij.a().c();
              localObject5 = anij.a().d();
              if (localObject5 != null)
              {
                ((anim.f)localObject3).f = ((anij.b)localObject5);
                ((anim.f)localObject3).cGV = true;
              }
              localObject5 = anij.a().Z();
              ((anim.f)localObject3).dGV = localObject5[0];
              ((anim.f)localObject3).dGW = localObject5[1];
              ((anim.f)localObject3).bn.getAndSet(true);
            }
            for (;;)
            {
              localObject3 = getDefaultFocusMode();
              if ((!anij.a().setParamsFocusMode((String)localObject3)) && (!anij.a().setParamsFocusMode("auto")) && (!anij.a().a(this))) {
                anim.this.jdField_a_of_type_Anim$c.notify(9, new Object[] { acfp.m(2131703378) });
              }
              if (anij.a().axr()) {
                break;
              }
              anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set display orientation failed" });
              anim.i.aS(paramMessage);
              return;
              if (!anij.a().a((anim.f)localObject3))
              {
                anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set Camera Params failed" });
                anim.i.aS(paramMessage);
                return;
              }
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage] Set camera param by cache params");
              }
            }
            localObject3 = anij.a().Z();
            i = anij.a().getPreviewFormat();
            localObject5 = anij.a().c();
            anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_DEFAULT");
            }
            localObject3 = getDefaultFocusMode();
            if ((anij.a().setParamsFocusMode((String)localObject3)) || (anij.a().setParamsFocusMode("auto")) || (anij.a().a(this))) {
              break;
            }
            anim.this.jdField_a_of_type_Anim$c.notify(9, new Object[] { acfp.m(2131703380) });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_AUTO");
            }
            if (anij.a().setParamsFocusMode("auto")) {
              break;
            }
            anim.this.jdField_a_of_type_Anim$c.notify(9, new Object[] { acfp.m(2131703379) });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_RECORDING");
            }
            localObject3 = zW();
            if (anij.a().setParamsFocusMode((String)localObject3)) {
              break;
            }
            anim.this.jdField_a_of_type_Anim$c.notify(9, new Object[] { acfp.m(2131703374) });
            break;
            localObject3 = (anim.e)paramMessage.obj;
            a(((anim.e)localObject3).cF, ((anim.e)localObject3).cG, ((anim.e)localObject3).b);
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_SET_SURFACE");
            }
            localObject3 = (SurfaceTexture)paramMessage.obj;
            if (anij.a().a((SurfaceTexture)localObject3)) {
              break;
            }
            anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set preview texture failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_SURFACE_HOLDER");
            }
            localObject3 = (SurfaceHolder)paramMessage.obj;
            if (anij.a().a((SurfaceHolder)localObject3)) {
              break;
            }
            anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set surface holder failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_CALLBACK");
            }
            localObject3 = (Camera.PreviewCallback)paramMessage.obj;
            bool1 = bool3;
            if (paramMessage.arg1 > 0) {
              bool1 = true;
            }
            if (anij.a().a((Camera.PreviewCallback)localObject3, bool1)) {
              break;
            }
            anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "set preview callback failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START");
            }
            if (!anij.a().axp())
            {
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START error");
              }
              axiy.i("CameraProxy", "[handleMessage] PREVIEW_START");
              anim.this.jdField_a_of_type_Anim$c.notify(3, new Object[] { "start preview failed" });
              break;
            }
            localObject3 = anij.a();
            if (((anij)localObject3).dGP != 1) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, cameraId = " + ((anij)localObject3).dGP);
            }
            axiy.i("CameraProxy", "【Camera 】PREVIEW_START success cameraID:" + ((anij)localObject3).dGP);
            if ((!((anij)localObject3).axs()) || (anim.a(anim.this) == null)) {
              break;
            }
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, startFaceDetection");
            ((anij)localObject3).setFaceDetectionListener(anim.a(anim.this));
            ((anij)localObject3).startFaceDetection();
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH" + paramMessage.arg1);
            }
            localObject3 = anij.a();
            if ((!((anij)localObject3).axs()) || (anim.a(anim.this) == null)) {
              break;
            }
            if (paramMessage.arg1 == 1)
            {
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH " + ((anij)localObject3).dGP);
              }
              if (((anij)localObject3).dGP != 1) {
                break;
              }
              ((anij)localObject3).setFaceDetectionListener(anim.a(anim.this));
              ((anij)localObject3).startFaceDetection();
              break;
            }
            if (paramMessage.arg1 != 2) {
              break;
            }
            ((anij)localObject3).stopFaceDetection();
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_STOP");
            }
            axiy.i("CameraProxy", "【Camera】PREVIEW_STOP success");
            if (!anij.a().axq())
            {
              anim.this.jdField_a_of_type_Anim$c.notify(4, new Object[] { "stop preview failed" });
              break;
            }
            localObject3 = anij.a();
            if ((!((anij)localObject3).axs()) || (anim.a(anim.this) == null)) {
              break;
            }
            ((anij)localObject3).stopFaceDetection();
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]RELEASE");
            }
            anij.a().releaseCamera();
            anim.this.aZC = true;
            try
            {
              Thread.sleep(50L);
              axiy.i("CameraProxy", "【Camera】RELEASE success");
              anim.this.jdField_a_of_type_Anim$c.notify(11, new Object[] { "camera destory" });
              break;
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]NIGHT_MODE_ON_OFF" + paramMessage.arg1);
              }
              if (paramMessage.arg1 == 1)
              {
                anim.b(anim.this);
                break;
              }
              if (paramMessage.arg1 != 2) {
                break;
              }
              anim.c(anim.this);
              break;
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_ON_OFF");
              }
              if (paramMessage.arg1 == 1)
              {
                if (anij.a().bn(true)) {
                  break;
                }
                anim.this.jdField_a_of_type_Anim$c.notify(6, new Object[] { "turn on flash light failed" });
                break;
              }
              if ((paramMessage.arg1 != 2) || (anij.a().bn(false))) {
                break;
              }
              anim.this.jdField_a_of_type_Anim$c.notify(6, new Object[] { "turn off flash light failed" });
              break;
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_SWITCH");
              }
              if (paramMessage.arg1 == 0)
              {
                if (anij.a().axu()) {
                  break;
                }
                anim.this.jdField_a_of_type_Anim$c.notify(6, new Object[] { "switch flash light failed" });
                break;
              }
              if (paramMessage.arg1 == 1)
              {
                if (anij.a().bo(true)) {
                  break;
                }
                anim.this.jdField_a_of_type_Anim$c.notify(6, new Object[] { "turn on flash light failed" });
                break;
              }
              if ((paramMessage.arg1 != 2) || (anij.a().bo(false))) {
                break;
              }
              anim.this.jdField_a_of_type_Anim$c.notify(6, new Object[] { "turn off flash light failed" });
              break;
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]PICTURE_TAKE");
              }
              aarz.AK("received");
              localObject3 = (anim.h)paramMessage.obj;
              localObject5 = anij.a();
              if (!((anij)localObject5).aNE)
              {
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[takePicture]Camera is not previewing...");
                }
                anim.i.aS(paramMessage);
                return;
              }
              if (((anim.h)localObject3).mFile == null)
              {
                anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "take picture error" });
                anim.i.aS(paramMessage);
                return;
              }
              ((anij)localObject5).a(((anim.h)localObject3).mFile, ((anim.h)localObject3).cD, ((anim.h)localObject3).c, ((anim.h)localObject3).mOrientation, ((anim.h)localObject3).mMirror, ((anim.h)localObject3).dGX);
              break;
              i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
              anij.a().lB(i);
              break;
              localObject3 = (String)((Object[])(Object[])paramMessage.obj)[0];
              anij.a().pk((String)localObject3);
              break;
              axiy.i("CameraProxy", "camera2 open in.");
              localObject3 = (Object[])paramMessage.obj;
              i = ((Integer)localObject3[0]).intValue();
              if ((localObject3[1] instanceof Camera2Control.b))
              {
                localObject3 = (Camera2Control.b)localObject3[1];
                if (Camera2Control.a().EQ())
                {
                  anhj.dH(1, "[Camera2] camera2 is opening!");
                  anim.i.aS(paramMessage);
                  return;
                }
                i = Camera2Control.a().a(i, (Camera2Control.b)localObject3);
                if (i == 0) {
                  break;
                }
                axiy.e("CameraProxy", "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + i);
                anim.this.jdField_a_of_type_Anim$c.notify(13, new Object[] { Integer.valueOf(i) });
                break;
                localObject3 = (SurfaceTexture)((Object[])(Object[])paramMessage.obj)[0];
                Camera2Control.a().c((SurfaceTexture)localObject3);
                axiy.i("CameraProxy", "【Camera2】PREVIEW_START");
                break;
                localObject3 = (Camera.PreviewCallback)((Object[])(Object[])paramMessage.obj)[0];
                Camera2Control.a().a((Camera.PreviewCallback)localObject3);
                break;
                Camera2Control.a().dPJ();
                axiy.i("CameraProxy", "【Camera2】CAMERA2_RELEASE");
                break;
                localObject7 = (Object[])paramMessage.obj;
                localObject5 = (anij.b)localObject7[0];
                localObject8 = (anij.b)localObject7[1];
                bool1 = ((Boolean)localObject7[4]).booleanValue();
                localObject3 = new StringBuilder();
                Camera2Control.a();
                localObject6 = Camera2Control.cdP + "#" + localObject5 + "#" + localObject8;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_SET_PARAMS,wantedSize = " + localObject5 + " , viewSize = " + localObject8 + ",resolutionMode:" + bool1);
                }
                localObject3 = (anim.g)anim.this.nd.get(localObject6);
                if (localObject3 == null)
                {
                  localObject3 = new anim.g();
                  anim.this.nd.put(localObject6, localObject3);
                  if (!((anim.g)localObject3).bn.get())
                  {
                    localObject6 = Camera2Control.a().a();
                    if (!bool1) {}
                    for (localObject5 = anhj.a(((anij.b)localObject5).width, ((anij.b)localObject5).height, ((anij.b)localObject8).width, ((anij.b)localObject8).height, (Camera2Control.a)localObject6);; localObject5 = anhj.b(((anij.b)localObject5).width, ((anij.b)localObject5).height, ((anij.b)localObject8).width, ((anij.b)localObject8).height, (Camera2Control.a)localObject6))
                    {
                      if ((localObject5 == null) || (localObject5.length < 2)) {
                        break label5309;
                      }
                      localObject6 = localObject5[0];
                      localObject5 = localObject5[1];
                      localObject8 = new anij.b(Math.max(((anij.b)localObject8).width, ((anij.b)localObject8).height), Math.min(((anij.b)localObject8).width, ((anij.b)localObject8).height));
                      localObject8 = Camera2Control.a().a((anij.b)localObject8);
                      if (Camera2Control.a().a((anij.b)localObject6)) {
                        break;
                      }
                      anim.this.jdField_a_of_type_Anim$c.notify(14, new Object[] { "[Camera2]setCamera2 previewSize error!" });
                      anim.i.aS(paramMessage);
                      return;
                    }
                    if (!Camera2Control.a().b((anij.b)localObject5))
                    {
                      anim.this.jdField_a_of_type_Anim$c.notify(14, new Object[] { "[Camera2]setCamera2 pictureSize error!" });
                      anim.i.aS(paramMessage);
                      return;
                    }
                    if (!Camera2Control.a().lx(((Integer)localObject7[3]).intValue()))
                    {
                      anim.this.jdField_a_of_type_Anim$c.notify(14, new Object[] { "[Camera2]setCamera2 fps error!" });
                      anim.i.aS(paramMessage);
                      return;
                    }
                    ((anim.g)localObject3).a = ((anij.b)localObject6);
                    ((anim.g)localObject3).f = ((anij.b)localObject5);
                    ((anim.g)localObject3).c = ((anij.b)localObject8);
                    ((anim.g)localObject3).bn.getAndSet(true);
                  }
                  while (Camera2Control.a().a((anim.g)localObject3))
                  {
                    localObject3 = Camera2Control.a().b();
                    localObject5 = Camera2Control.a().a();
                    anim.this.jdField_a_of_type_Anim$c.notify(14, new Object[] { localObject3, localObject5 });
                    break;
                  }
                  anim.this.jdField_a_of_type_Anim$c.notify(14, new Object[] { "[Camera2]setCamera2ParamOnce error!" });
                  anim.i.aS(paramMessage);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_PICTURE_TAKE");
                  }
                  localObject3 = (anim.h)paramMessage.obj;
                  if (((anim.h)localObject3).mFile == null)
                  {
                    anim.this.jdField_a_of_type_Anim$c.notify(2, new Object[] { "take picture error" });
                    anim.i.aS(paramMessage);
                    return;
                  }
                  localObject5 = new Camera2Control.c();
                  ((Camera2Control.c)localObject5).a = ((anim.h)localObject3).c;
                  ((Camera2Control.c)localObject5).mMirror = ((anim.h)localObject3).mMirror;
                  ((Camera2Control.c)localObject5).mOrientation = ((anim.h)localObject3).mOrientation;
                  ((Camera2Control.c)localObject5).aM = ((anim.h)localObject3).mFile;
                  ((Camera2Control.c)localObject5).cD = ((anim.h)localObject3).cD;
                  Camera2Control.a().a((Camera2Control.c)localObject5);
                  break;
                  if (QLog.isColorLevel()) {
                    QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_STOP_VIDEO");
                  }
                  Camera2Control.a().cye();
                  break;
                  localObject3 = (anim.e)paramMessage.obj;
                  Camera2Control.a().a((anim.e)localObject3);
                  break;
                  i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
                  Camera2Control.a().setZoom(i);
                  break;
                  bool1 = ((Boolean)((Object[])(Object[])paramMessage.obj)[0]).booleanValue();
                  Camera2Control.a().PJ(bool1);
                  break;
                  Camera2Control.a().dPE();
                  break;
                  if (QLog.isColorLevel()) {
                    QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_START_VIDEO");
                  }
                  Camera2Control.a().dPF();
                  break;
                  anhj.dH(2, "[Camera2] error:" + paramMessage.arg1);
                  axiy.e("CameraProxy", "【Camera2 Open Error】CAMERA2_ERROR_CALLBACK:" + paramMessage.arg1);
                  i = paramMessage.arg1;
                  switch (i)
                  {
                  case -203: 
                  case -202: 
                  case -201: 
                    anim.this.jdField_a_of_type_Anim$c.notify(14, new Object[] { "[Camera2]setCamera2 previewSize error:" + i });
                    break;
                  case -105: 
                  case -102: 
                    anim.this.jdField_a_of_type_Anim$c.notify(13, new Object[] { Integer.valueOf(i) });
                  }
                }
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                continue;
                label5309:
                localObject5 = null;
                localObject6 = null;
                continue;
                continue;
                Object localObject4 = null;
              }
            }
          }
        }
        label5330:
        bool1 = false;
        break label5342;
        label5336:
        continue;
        label5339:
        continue;
        label5342:
        localObject5 = "";
        continue;
        label5350:
        localObject5 = "";
        continue;
        label5358:
        localObject5 = "";
        continue;
        label5366:
        localObject5 = " :[Preview Selector Error]";
        bool1 = bool2;
      }
    }
    
    public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[onAutoFocus]success " + paramBoolean);
      }
      paramCamera = getDefaultFocusMode();
      anij.a().setParamsFocusMode(paramCamera);
    }
    
    public String zW()
    {
      String str2 = "continuous-video";
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[@] getRecordingFocusMode: Build.MANUFACTURER=" + Build.MANUFACTURER + "VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
      }
      String str1 = str2;
      if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
      {
        str1 = str2;
        if (Build.VERSION.SDK_INT >= 14) {
          str1 = "continuous-picture";
        }
      }
      return str1;
    }
  }
  
  public static abstract interface b
  {
    public abstract void bm(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  public static class c
    extends anhn
  {
    public Handler mHandler;
    
    public c(Handler paramHandler)
    {
      if (paramHandler != null)
      {
        this.mHandler = paramHandler;
        return;
      }
      this.mHandler = new Handler(Looper.getMainLooper());
    }
    
    public void notify(int paramInt, Object... paramVarArgs)
    {
      if (this.mHandler == null) {
        return;
      }
      this.mHandler.post(new CameraProxy.CameraPreviewObservable.1(this, paramInt, paramVarArgs));
    }
  }
  
  public static abstract interface d
  {
    public abstract void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera);
  }
  
  public class e
  {
    public anhh a;
    public anhk a;
    Camera.AutoFocusCallback b;
    Rect cF;
    Rect cG;
    public boolean cGU;
    
    public e() {}
  }
  
  public static class f
  {
    public AtomicBoolean bn = new AtomicBoolean(false);
    int cFs;
    boolean cGV = false;
    int dGV;
    int dGW;
    public anij.b e;
    anij.b f;
  }
  
  public static class g
  {
    public anij.b a;
    public AtomicBoolean bn = new AtomicBoolean(false);
    public anij.b c;
    public anij.b f;
  }
  
  class h
  {
    CameraCover.a jdField_c_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$a;
    Rect cD;
    int dGX;
    File mFile;
    boolean mMirror;
    int mOrientation;
    
    private h() {}
  }
  
  public static class i
  {
    public final Object bi = new Object();
    public final Runnable hA = new CameraProxy.WaitDoneBundle.1(this);
    
    static void aS(Message paramMessage)
    {
      if (paramMessage == null) {}
      while (!(paramMessage.obj instanceof i)) {
        return;
      }
      ((i)paramMessage.obj).hA.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anim
 * JD-Core Version:    0.7.0.1
 */