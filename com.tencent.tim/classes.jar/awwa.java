import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.a;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.core.AECameraManager.1;
import dov.com.qq.im.ae.camera.core.AECameraManager.10;
import dov.com.qq.im.ae.camera.core.AECameraManager.11;
import dov.com.qq.im.ae.camera.core.AECameraManager.12;
import dov.com.qq.im.ae.camera.core.AECameraManager.2;
import dov.com.qq.im.ae.camera.core.AECameraManager.3;
import dov.com.qq.im.ae.camera.core.AECameraManager.4;
import dov.com.qq.im.ae.camera.core.AECameraManager.5;
import dov.com.qq.im.ae.camera.core.AECameraManager.6;
import dov.com.qq.im.ae.camera.core.AECameraManager.7;
import dov.com.qq.im.ae.camera.core.AECameraManager.8;
import dov.com.qq.im.ae.camera.core.AECameraManager.9;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class awwa
  implements anho, anil.a, anim.d
{
  private View Go;
  private alxa.a jdField_a_of_type_Alxa$a;
  private alxa jdField_a_of_type_Alxa;
  private awvv jdField_a_of_type_Awvv;
  private AudioCapture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture;
  private aary jdField_b_of_type_Aary;
  private final anim jdField_b_of_type_Anim = new anim(null, null);
  private awwa.a jdField_b_of_type_Awwa$a;
  private boolean cAA;
  private boolean cAE;
  private boolean cAx;
  private boolean cAy;
  private boolean cAz;
  private final AtomicInteger cw = new AtomicInteger(0);
  private boolean dtf;
  private int dyL = 1;
  private int dyS;
  private int dyT;
  private int dzi;
  private int dzj;
  private int dzk;
  private int dzl;
  private int dzm;
  private final Handler eg;
  
  public awwa()
  {
    anil localanil = new anil(new Handler(Looper.getMainLooper()), this);
    if (!aeah.agb()) {
      this.dyL = 2;
    }
    HandlerThread localHandlerThread = new HandlerThread("AECameraManagerHandlerThread");
    localHandlerThread.start();
    this.eg = new Handler(localHandlerThread.getLooper());
    this.jdField_b_of_type_Anim.a(localanil);
    this.jdField_b_of_type_Anim.PU(true);
    this.jdField_b_of_type_Aary = new aary();
  }
  
  private void XN(boolean paramBoolean)
  {
    axiy.i("AECameraManager", "stopCameraInternal---ENTER, cameraCreated=" + aNY() + ", forceStop=" + paramBoolean);
    if ((!paramBoolean) && (!aNY()))
    {
      axiy.e("AECameraManager", "stopCameraInternal---EXIT, not created, do nothing");
      return;
    }
    this.jdField_b_of_type_Anim.PQ(false);
    this.jdField_b_of_type_Anim.PR(false);
    this.cw.set(0);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.dKa();
    }
    this.jdField_b_of_type_Anim.c(this);
    this.jdField_b_of_type_Anim.c(PeakAppInterface.a);
    axiy.i("AECameraManager", "stopCameraInternal---EXIT, normally");
  }
  
  private void a(anij.b paramb)
  {
    this.dyS = paramb.height;
    this.dyT = paramb.width;
    if (this.jdField_b_of_type_Awwa$a != null) {
      this.jdField_b_of_type_Awwa$a.lq(this.dyS, this.dyT);
    }
  }
  
  private boolean aNY()
  {
    return this.cw.get() >= 1;
  }
  
  private boolean aeN()
  {
    return this.cw.get() >= 3;
  }
  
  private void b(SurfaceTexture paramSurfaceTexture, aasq paramaasq)
  {
    axiy.i("AECameraManager", "realStartPreview---ENTER, previewTexture=" + paramSurfaceTexture + ", previewSize=" + paramaasq);
    this.cw.set(3);
    this.jdField_a_of_type_Awvv.setClipWidth(paramaasq.mWidth);
    this.jdField_a_of_type_Awvv.setClipHeight(paramaasq.mHeight);
    if (this.cAE) {
      this.jdField_b_of_type_Anim.a(new anij.b(paramaasq.mHeight, paramaasq.mWidth), new anij.b(paramaasq.mWidth, paramaasq.mHeight), 0, 30, true);
    }
    for (;;)
    {
      this.jdField_b_of_type_Anim.a(paramSurfaceTexture, null, this, true);
      this.cw.set(4);
      if (this.jdField_b_of_type_Awwa$a != null) {
        this.jdField_b_of_type_Awwa$a.eGn();
      }
      axiy.i("AECameraManager", "realStartPreview---EXIT");
      axgk.a().acy("startCameraPreview-end");
      return;
      this.jdField_b_of_type_Anim.a(new anij.b(this.jdField_a_of_type_Awvv.QH(), this.jdField_a_of_type_Awvv.QI()), new anij.b(this.jdField_a_of_type_Awvv.getClipWidth(), this.jdField_a_of_type_Awvv.getClipHeight()), 0, 30, false);
    }
  }
  
  private void b(awvv paramawvv)
  {
    this.jdField_a_of_type_Awvv = paramawvv;
  }
  
  /* Error */
  private void b(awwa.b paramb)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 118
    //   4: new 120	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 288
    //   14: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokespecial 130	awwa:aNY	()Z
    //   21: invokevirtual 133	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   24: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 145	axiy:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: invokespecial 130	awwa:aNY	()Z
    //   34: ifeq +30 -> 64
    //   37: ldc 118
    //   39: ldc_w 290
    //   42: invokestatic 150	axiy:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_1
    //   46: ifnull +17 -> 63
    //   49: aload_1
    //   50: aload_0
    //   51: getfield 58	awwa:dyL	I
    //   54: aload_0
    //   55: invokespecial 130	awwa:aNY	()Z
    //   58: invokeinterface 294 3 0
    //   63: return
    //   64: aload_0
    //   65: getfield 56	awwa:jdField_b_of_type_Anim	Lanim;
    //   68: aload_0
    //   69: invokevirtual 296	anim:b	(Lanho;)V
    //   72: aload_0
    //   73: getfield 56	awwa:jdField_b_of_type_Anim	Lanim;
    //   76: aload_0
    //   77: getfield 58	awwa:dyL	I
    //   80: invokevirtual 299	anim:UW	(I)V
    //   83: aload_0
    //   84: getfield 65	awwa:cw	Ljava/util/concurrent/atomic/AtomicInteger;
    //   87: iconst_2
    //   88: invokevirtual 159	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   91: ldc 118
    //   93: ldc_w 301
    //   96: invokestatic 145	axiy:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 161	awwa:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture;
    //   103: ifnull +10 -> 113
    //   106: aload_0
    //   107: getfield 161	awwa:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture;
    //   110: invokevirtual 304	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:dJZ	()V
    //   113: aload_0
    //   114: getfield 114	awwa:jdField_b_of_type_Aary	Laary;
    //   117: ifnull +21 -> 138
    //   120: aload_0
    //   121: getfield 114	awwa:jdField_b_of_type_Aary	Laary;
    //   124: astore_3
    //   125: aload_0
    //   126: getfield 58	awwa:dyL	I
    //   129: iconst_1
    //   130: if_icmpne +43 -> 173
    //   133: aload_3
    //   134: iload_2
    //   135: invokevirtual 307	aary:setMirror	(Z)V
    //   138: aload_0
    //   139: getfield 58	awwa:dyL	I
    //   142: putstatic 312	aaqh:cix	I
    //   145: invokestatic 268	axgk:a	()Laxgk;
    //   148: ldc_w 314
    //   151: invokevirtual 273	axgk:acy	(Ljava/lang/String;)V
    //   154: aload_1
    //   155: ifnull -92 -> 63
    //   158: aload_1
    //   159: aload_0
    //   160: getfield 58	awwa:dyL	I
    //   163: aload_0
    //   164: invokespecial 130	awwa:aNY	()Z
    //   167: invokeinterface 294 3 0
    //   172: return
    //   173: iconst_0
    //   174: istore_2
    //   175: goto -42 -> 133
    //   178: astore_3
    //   179: aload_1
    //   180: ifnull +17 -> 197
    //   183: aload_1
    //   184: aload_0
    //   185: getfield 58	awwa:dyL	I
    //   188: aload_0
    //   189: invokespecial 130	awwa:aNY	()Z
    //   192: invokeinterface 294 3 0
    //   197: aload_3
    //   198: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	awwa
    //   0	199	1	paramb	awwa.b
    //   1	174	2	bool	boolean
    //   124	10	3	localaary	aary
    //   178	20	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	45	178	finally
    //   64	113	178	finally
    //   113	133	178	finally
    //   133	138	178	finally
    //   138	154	178	finally
  }
  
  private void l(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.Go == null) {
        this.Go = new View(paramActivity);
      }
      this.Go.setBackgroundColor(-1);
      this.Go.setAlpha(0.7F);
      if (this.Go.getParent() != null) {
        ((ViewGroup)this.Go.getParent()).removeView(this.Go);
      }
      paramActivity.addContentView(this.Go, new ViewGroup.LayoutParams(-1, -1));
    }
    do
    {
      try
      {
        this.dzi = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness_mode");
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness_mode", 0);
        this.dzj = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness");
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness", 255);
        this.cAz = true;
        return;
      }
      catch (Exception paramActivity)
      {
        do
        {
          this.dzi = 1;
          this.dzj = 100;
        } while (!QLog.isColorLevel());
        QLog.e("AECameraManager", 2, "turn FrontFlash Error ", paramActivity);
        paramActivity.printStackTrace();
        return;
      }
      if (this.cAz)
      {
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness", this.dzj);
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness_mode", this.dzi);
        this.cAz = false;
      }
    } while ((this.Go == null) || (this.Go.getParent() == null));
    ((ViewGroup)this.Go.getParent()).removeView(this.Go);
  }
  
  public Handler D()
  {
    if (this.jdField_b_of_type_Anim == null) {
      return null;
    }
    return this.jdField_b_of_type_Anim.a();
  }
  
  public int Is()
  {
    return this.dyL;
  }
  
  public void XM(boolean paramBoolean)
  {
    this.eg.post(new AECameraManager.2(this, paramBoolean));
  }
  
  public void XO(boolean paramBoolean)
  {
    this.cAy = paramBoolean;
  }
  
  public void Y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_b_of_type_Aary != null) {
      this.jdField_b_of_type_Aary.G(paramInt2, paramInt1, paramInt3, paramInt4);
    }
  }
  
  public void a(int paramInt, awwa.b paramb)
  {
    this.eg.post(new AECameraManager.4(this, paramInt, paramb));
  }
  
  public void a(alxa paramalxa)
  {
    this.jdField_a_of_type_Alxa = paramalxa;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, aasq paramaasq)
  {
    axiy.i("AECameraManager", "startCameraPreview ENTER---previewTexture=" + paramSurfaceTexture + ", previewSize=" + paramaasq);
    if ((paramSurfaceTexture == null) || (paramaasq == null) || (Math.min(paramaasq.mWidth, paramaasq.mHeight) <= 0)) {
      return;
    }
    axgk.a().acy("startCameraPreview-begin");
    this.eg.post(new AECameraManager.5(this, paramSurfaceTexture, paramaasq));
  }
  
  public void a(awvv paramawvv)
  {
    this.jdField_a_of_type_Alxa = new alxa();
    b(paramawvv);
    this.dyL = paramawvv.QK();
    if ((this.dyL == 1) && (!aeah.agb())) {
      this.dyL = 2;
    }
  }
  
  public void a(awwa.a parama)
  {
    axiy.i("AECameraManager", "### setCameraManagerListener--- listener=" + parama);
    this.jdField_b_of_type_Awwa$a = parama;
  }
  
  public void a(awwa.b paramb)
  {
    axgk.a().acy("openCamera-begin");
    this.eg.post(new AECameraManager.1(this, paramb));
  }
  
  public void a(File paramFile, int paramInt, boolean paramBoolean, CameraCover.a parama, aasq paramaasq)
  {
    this.eg.post(new AECameraManager.7(this, paramFile, paramaasq, parama, paramInt, paramBoolean));
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    axgk.a().log("AECameraManager", "【CameraProxy notify】eventId=" + paramInt + ", args=" + Arrays.toString(paramVarArgs));
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!(paramVarArgs[0] instanceof anij.b)) {
                  break;
                }
                a((anij.b)paramVarArgs[0]);
              } while (this.jdField_b_of_type_Awwa$a == null);
              this.jdField_b_of_type_Awwa$a.ac(true, "");
              axiy.i("AECameraManager", "【Camera Open Success】EVENT_SET_CAMERA_PARAM");
              return;
            } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_b_of_type_Awwa$a == null));
            this.jdField_b_of_type_Awwa$a.ac(false, (String)paramVarArgs[0]);
            axiy.e("AECameraManager", "【Camera Open Error】EVENT_SET_CAMERA_PARAM:" + paramVarArgs[0]);
            return;
          } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_b_of_type_Awwa$a == null));
          this.jdField_b_of_type_Awwa$a.ac(false, (String)paramVarArgs[0]);
          axiy.e("AECameraManager", "【Camera Open Error】EVENT_CREATE_CAMERA:" + paramVarArgs[0]);
          return;
        } while ((!(paramVarArgs[0] instanceof Integer)) || (this.jdField_b_of_type_Awwa$a == null));
        this.jdField_b_of_type_Awwa$a.ac(false, "[Camera2]openCamera2 error:" + paramVarArgs[0]);
        axiy.e("AECameraManager", "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + paramVarArgs[0]);
        return;
        if (!(paramVarArgs[0] instanceof anij.b)) {
          break;
        }
        a((anij.b)paramVarArgs[0]);
        if (this.jdField_b_of_type_Awwa$a != null)
        {
          this.jdField_b_of_type_Awwa$a.ac(true, "");
          axiy.i("AECameraManager", "【Camera2 Open Success】EVENT_CAMERA2_PARAMS");
        }
      } while ((paramVarArgs.length < 2) || (!(paramVarArgs[1] instanceof anij.b)));
      paramObject = (anij.b)paramVarArgs[1];
      this.dzk = paramObject.width;
      this.dzl = paramObject.height;
      return;
    } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_b_of_type_Awwa$a == null));
    this.jdField_b_of_type_Awwa$a.ac(false, "[Camera2]setCamera2 Params error:" + paramVarArgs[0]);
    axiy.e("AECameraManager", "【Camera2 Open Error】setCamera2 Params error::" + paramVarArgs[0]);
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    if (paramRuntimeException != null)
    {
      axiy.e("AECameraManager", "onDispatchThreadException---" + paramRuntimeException.getMessage(), paramRuntimeException);
      return;
    }
    axiy.e("AECameraManager", "onDispatchThreadException---");
  }
  
  public boolean aNZ()
  {
    return (this.cAy) && (!this.cAx);
  }
  
  public boolean aOa()
  {
    return this.cAy;
  }
  
  public void adr(int paramInt)
  {
    this.dzm = paramInt;
  }
  
  public void ads(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1)) {}
    while ((paramInt == 1) && (!aeah.agb())) {
      return;
    }
    this.eg.post(new AECameraManager.12(this, paramInt));
  }
  
  public void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.eg.post(new AECameraManager.8(this, paramFloat1, paramFloat2, paramInt1, paramInt2));
  }
  
  public void c(awwa.b paramb)
  {
    if (!aeah.agb())
    {
      axiy.e("AECameraManager", "toggleCamera---front camera not exists, not support toggle");
      paramb.cv(this.dyL, false);
      return;
    }
    this.eg.post(new AECameraManager.3(this, paramb));
  }
  
  public void c(AudioCapture paramAudioCapture)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = paramAudioCapture;
  }
  
  public void cye()
  {
    this.eg.post(new AECameraManager.9(this));
  }
  
  public void d(Exception paramException)
  {
    if (paramException != null)
    {
      axiy.e("AECameraManager", "onCameraException---" + paramException.getMessage(), paramException);
      return;
    }
    axiy.e("AECameraManager", "onCameraException---");
  }
  
  public void dQk()
  {
    this.eg.post(new AECameraManager.6(this));
  }
  
  public void dQp()
  {
    this.eg.post(new AECameraManager.11(this));
  }
  
  public void eGO()
  {
    if (this.jdField_a_of_type_Alxa != null) {
      this.jdField_a_of_type_Alxa.czn();
    }
  }
  
  public boolean isFrontCamera()
  {
    return this.dyL == 1;
  }
  
  public void k(Activity paramActivity, boolean paramBoolean)
  {
    if (this.dyL == 1)
    {
      l(paramActivity, paramBoolean);
      return;
    }
    this.jdField_b_of_type_Anim.PS(paramBoolean);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (!this.dtf)
    {
      this.dtf = true;
      axgk.a().acy("onCameraPreviewFrameData");
    }
    anij.a().c(true, paramArrayOfByte);
    if (this.cAA)
    {
      int k = this.dyS;
      int m = this.dyT;
      int j = m;
      int i = k;
      if (this.dzk > 0)
      {
        j = m;
        i = k;
        if (this.dzl > 0)
        {
          i = this.dzl;
          j = this.dzk;
        }
      }
      this.jdField_a_of_type_Alxa.a(paramArrayOfByte, i, j, this.jdField_a_of_type_Alxa$a);
    }
  }
  
  public void setDarkModeEnable(boolean paramBoolean)
  {
    this.cAA = paramBoolean;
  }
  
  public void setDarkModeListener(alxa.a parama)
  {
    this.jdField_a_of_type_Alxa$a = parama;
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.cAE = paramBoolean;
  }
  
  public void setZoom(int paramInt)
  {
    this.eg.post(new AECameraManager.10(this, paramInt));
  }
  
  public static abstract interface a
  {
    public abstract void ac(boolean paramBoolean, String paramString);
    
    public abstract void eGn();
    
    public abstract void lq(int paramInt1, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract void cv(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awwa
 * JD-Core Version:    0.7.0.1
 */