import android.content.Context;
import android.graphics.PointF;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARNativeBridge.ARWorldCupCallback;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.1;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.10;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.11;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.12;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.13;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.14;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.15;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.16;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.17;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.18;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.19;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.20;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.21;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.3;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.6;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.8;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.9;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import java.io.File;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class addg
  implements adbk.a, adbn.a, adcy, Handler.Callback, View.OnTouchListener, ARNativeBridge.ARWorldCupCallback
{
  private TextView QE;
  volatile long Sp = -1L;
  private adbk jdField_a_of_type_Adbk = new adbk(this, 1);
  private adbl jdField_a_of_type_Adbl;
  private adbm.a jdField_a_of_type_Adbm$a;
  private adbn jdField_a_of_type_Adbn;
  private adbo jdField_a_of_type_Adbo;
  private adda jdField_a_of_type_Adda;
  private addi jdField_a_of_type_Addi;
  private adgu jdField_a_of_type_Adgu;
  private aduv jdField_a_of_type_Aduv = new addh(this);
  private ARNativeBridge jdField_a_of_type_ComTencentMobileqqArARNativeBridge;
  private ISPlayerPreDownloader b;
  private boolean bLL;
  private boolean bLM;
  private boolean bLN = true;
  private volatile boolean bLO;
  private volatile boolean bLP;
  private boolean bLQ;
  private boolean bLR;
  public volatile int cCI = 0;
  public volatile int cCJ = 0;
  private int cCK;
  private volatile int cCL;
  private int cCM;
  private volatile int count;
  private final Runnable fU = new ARTransferPromotionRenderable.1(this);
  public aurf h;
  private Context mContext;
  private volatile int mCurrentState;
  private ArrayList<Runnable> mEventQueue = new ArrayList();
  private int mHeight;
  private adus mSensorManager;
  private int mTaskId = -1;
  private int mWidth;
  
  public addg(adda paramadda, addi paramaddi)
  {
    this.jdField_a_of_type_Adda = paramadda;
    this.jdField_a_of_type_Addi = paramaddi;
    this.mContext = this.jdField_a_of_type_Adda.n();
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = ((ARNativeBridge)paramadda.m(0));
    this.jdField_a_of_type_Adbn = ((adbn)paramadda.m(8));
    boolean bool = addz.adJ();
    if (this.bLL)
    {
      paramadda = this.mContext;
      if (!bool) {
        break label269;
      }
    }
    label269:
    for (int i = 5;; i = 4)
    {
      this.mSensorManager = new adus(paramadda, i);
      this.mCurrentState = 1;
      this.h = new aurf(ThreadManager.getSubThreadLooper(), this);
      this.bLN = addz.bMk;
      this.b = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getApplication(), 108);
      paramadda = this.jdField_a_of_type_Addi.sj();
      if (!TextUtils.isEmpty(paramadda))
      {
        paramadda = SuperPlayerFactory.createVideoInfoForUrl(paramadda, 101, arwv.toMD5(paramadda));
        this.mTaskId = this.b.startPreDownload(paramadda, 3000L, 1000L);
      }
      ThreadManager.post(new ARTransferPromotionRenderable.3(this), 8, null, true);
      return;
    }
  }
  
  private int By()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge != null) {
      this.cCJ = this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.native_getNativeGameStatus();
    }
    return this.cCJ;
  }
  
  private void KI(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransferPromotionRenderable", 2, String.format("setNativeState mCurrentState=%s state=%s", new Object[] { Integer.valueOf(this.mCurrentState), Integer.valueOf(paramInt) }));
    }
    this.mCurrentState = paramInt;
    switch (this.mCurrentState)
    {
    case 5: 
    default: 
    case 2: 
    case 3: 
    case 6: 
      do
      {
        return;
        ARGLSurfaceView.nativeSetLogLevel(QLog.getUIN_REPORTLOG_LEVEL());
        this.cCK = this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.getIndentification();
        this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeCreateEngineBusiness(this.cCK, "test.scene", this.mContext, this.mContext.getAssets(), this.jdField_a_of_type_Addi.bse, this.mWidth, this.mHeight, 88);
        this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.native_setARWorldCupCallBack(this);
        this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setPreLoadTransferDoorFlags();
        if (this.jdField_a_of_type_Adgu != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setARCoreSupport(1);
        }
        for (;;)
        {
          KI(3);
          return;
          this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setARCoreSupport(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeResume(this.cCK);
        KI(5);
        this.cCL = 0;
        return;
        this.jdField_a_of_type_Adda.Z(new ARTransferPromotionRenderable.11(this));
      } while (!QLog.isColorLevel());
      QLog.d("ARTransferPromotionRenderable", 2, "enter STATE_ENGINE_DRAW status");
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativePause(this.cCK);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeDestroyCertainEngine(this.cCK);
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setupActionCallback(null);
    this.cCK = 0;
    this.mCurrentState = 1;
  }
  
  private void a(int paramInt1, String paramString, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    int j = 1;
    QLog.d("ARTransferPromotionRenderable", 1, "tryPlayGameVideoAndSwitchStatus  " + paramInt1 + "|" + paramString);
    File localFile = new File(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      i = j;
      if (!paramString.startsWith("http")) {
        if (!paramString.startsWith("https")) {
          break label119;
        }
      }
    }
    label119:
    for (int i = j;; i = 0)
    {
      if ((localFile.exists()) || (i != 0))
      {
        this.cCI = paramInt1;
        this.jdField_a_of_type_Adbk.a(paramString, 123456L, paramBoolean1, paramInt2, paramBoolean2);
      }
      return;
    }
  }
  
  private void a(float[] arg1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5)
  {
    if ((this.bLN) && (this.bLO) && (paramArrayOfFloat5 != null) && (this.cCJ < 6))
    {
      if (this.jdField_a_of_type_Adgu != null) {
        break label157;
      }
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.native_setARWorldCupQuaternion(paramArrayOfFloat5[0], paramArrayOfFloat5[1], paramArrayOfFloat5[2], paramArrayOfFloat5[3]);
    }
    for (;;)
    {
      synchronized (this.mEventQueue)
      {
        if (this.mEventQueue.isEmpty()) {
          break;
        }
        paramArrayOfFloat3 = (Runnable)this.mEventQueue.remove(0);
        if (paramArrayOfFloat3 == null) {
          continue;
        }
        long l1 = System.currentTimeMillis();
        paramArrayOfFloat3.run();
        long l2 = System.currentTimeMillis();
        if (l2 - l1 < 200L) {
          continue;
        }
        QLog.d("ARTransferPromotionRenderable", 1, "event queue cost too long: " + (l2 - l1));
      }
      label157:
      c(paramArrayOfFloat5);
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeOnDrawFrame(this.cCK, paramArrayOfFloat2, paramArrayOfFloat4);
    this.bLO = true;
    if (this.bLP)
    {
      int i = this.count + 1;
      this.count = i;
      if (i >= 1)
      {
        ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.9(this));
        this.jdField_a_of_type_Adbn.FT(true);
        ??? = this.jdField_a_of_type_Adbn;
        this.jdField_a_of_type_Adbn.getClass();
        ???.Kx(6);
        ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.10(this));
        this.bLP = false;
      }
    }
  }
  
  private boolean c(float[] paramArrayOfFloat)
  {
    if (this.jdField_a_of_type_Adgu == null) {}
    while ((!this.jdField_a_of_type_Adgu.aeq()) || (this.jdField_a_of_type_Adda.a() == null)) {
      return false;
    }
    paramArrayOfFloat = new float[4];
    float[] arrayOfFloat = new float[3];
    int i = this.jdField_a_of_type_Adda.a().BQ();
    FloatBuffer localFloatBuffer = this.jdField_a_of_type_Adgu.a(i, paramArrayOfFloat, arrayOfFloat);
    if ((i == -1) || (localFloatBuffer == null))
    {
      h(-1.0F, -1.0F, -1.0F);
      return false;
    }
    this.jdField_a_of_type_Adda.a().Lk(i);
    this.jdField_a_of_type_Adda.a().b(localFloatBuffer, this.jdField_a_of_type_Adgu.a());
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.native_setARWorldCupQuaternion(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]);
    if ((this.cCJ <= 5) && (this.cCJ >= 3))
    {
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.updateCameraTranslate(arrayOfFloat, paramArrayOfFloat);
      h(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
    }
    return true;
  }
  
  private void cQv()
  {
    if (this.jdField_a_of_type_Adgu != null)
    {
      QLog.d("ARTransferPromotionRenderable", 1, "tryCreatARCore ");
      queueEvent(new ARTransferPromotionRenderable.15(this));
    }
  }
  
  private void cQw()
  {
    if (this.jdField_a_of_type_Adgu != null)
    {
      QLog.d("ARTransferPromotionRenderable", 1, "checkAndStartARCore ");
      adkt.a().closeCamera();
      this.jdField_a_of_type_Adgu.onSurfaceChange(this.mWidth, this.mHeight);
      this.jdField_a_of_type_Adgu.onResume();
    }
  }
  
  private void cQy()
  {
    if ((this.h != null) && (!this.h.hasMessages(1105))) {
      this.h.sendEmptyMessageDelayed(1105, 200L);
    }
    QLog.d("ARTransferPromotionRenderable", 2, "startMediaTimeListener ");
  }
  
  private void cQz()
  {
    if (this.h != null)
    {
      this.h.removeMessages(1105);
      this.jdField_a_of_type_Adbn.ay(false, "");
    }
    QLog.d("ARTransferPromotionRenderable", 2, "stopMediaTimeListener ");
  }
  
  private void h(float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  private void queueEvent(Runnable paramRunnable)
  {
    synchronized (this.mEventQueue)
    {
      this.mEventQueue.add(paramRunnable);
      return;
    }
  }
  
  public int Bv()
  {
    if (this.mCurrentState != 6) {
      return 0;
    }
    return this.cCJ;
  }
  
  public int Bx()
  {
    return this.jdField_a_of_type_Addi.cCF;
  }
  
  public void K(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    queueEvent(new ARTransferPromotionRenderable.19(this, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void X(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Adda != null) {
      this.jdField_a_of_type_Adda.Z(paramRunnable);
    }
  }
  
  public void a(addf.a parama)
  {
    a((float[])parama.r("TARGET_SIZE"), (float[])parama.r("POSE"), (float[])parama.r("CAMERA_MATRIX"), (float[])parama.r("CAMERA_POSITION"), parama.bB);
  }
  
  public void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, boolean paramBoolean)
  {
    queueEvent(new ARTransferPromotionRenderable.20(this, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3));
  }
  
  public void aK(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ARTransferPromotionRenderable", 1, "onMediaPlayerStatusChange mCurrentPrePareChangeStatus " + this.cCI + "|" + paramInt1 + "|" + this.cCJ + "|status" + paramInt2);
    queueEvent(new ARTransferPromotionRenderable.14(this, paramInt1, paramInt2, paramInt3));
  }
  
  public boolean adF()
  {
    return false;
  }
  
  public boolean adr()
  {
    return (this.mCurrentState == 6) && (this.cCK != 0);
  }
  
  public boolean ads()
  {
    return this.bLO;
  }
  
  public boolean adt()
  {
    return !this.jdField_a_of_type_Addi.ao.booleanValue();
  }
  
  public void cPP()
  {
    queueEvent(new ARTransferPromotionRenderable.21(this));
  }
  
  public void cPQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransferPromotionRenderable", 2, "directlyEnterTransferDoor");
    }
    this.jdField_a_of_type_Adbn.cPO();
    this.jdField_a_of_type_Adbn.ay(false, "");
    anot.a(null, "CliOper", "", "", "0X80098C8", "0X80098C8", 0, 0, this.jdField_a_of_type_Addi.key, "0", "0", "");
    queueEvent(new ARTransferPromotionRenderable.12(this));
  }
  
  public void cQx()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "startCameraAniamtion ");
    queueEvent(new ARTransferPromotionRenderable.18(this));
  }
  
  public boolean canRender()
  {
    return (this.mCurrentState == 6) && (this.cCK != 0);
  }
  
  public int gN(int paramInt)
  {
    if (this.cCJ == paramInt) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARTransferPromotionRenderable", 2, "switchGameStatus status " + paramInt);
    }
    queueEvent(new ARTransferPromotionRenderable.13(this, paramInt));
    return 0;
  }
  
  public int getType()
  {
    return this.jdField_a_of_type_Addi.cCE;
  }
  
  public String getUniqueKey()
  {
    return this.jdField_a_of_type_Addi.key;
  }
  
  public void gp(View paramView)
  {
    if (paramView != null)
    {
      paramView.setOnTouchListener(this);
      QLog.d("ARTransferPromotionRenderable", 2, "setContainer  success");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_Adbk != null) && (this.jdField_a_of_type_Adbk.isPlaying()) && (this.jdField_a_of_type_Adbo != null))
    {
      long l = this.jdField_a_of_type_Adbk.getCurrentPosition();
      paramMessage = this.jdField_a_of_type_Adbo.a(l);
      if (paramMessage != null) {
        break label98;
      }
      this.jdField_a_of_type_Adbn.ay(false, "");
    }
    for (;;)
    {
      this.h.sendEmptyMessageDelayed(1105, 200L);
      return false;
      label98:
      this.jdField_a_of_type_Adbn.ay(true, paramMessage.brL);
    }
  }
  
  public void init()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "init test start +" + this);
    this.Sp = Thread.currentThread().getId();
    this.jdField_a_of_type_Adbn.a(this);
    if (!this.jdField_a_of_type_Addi.ao.booleanValue()) {
      this.jdField_a_of_type_Adbn.cPN();
    }
    if ((this.mSensorManager != null) && (this.bLL)) {
      QLog.d("ARTransferPromotionRenderable", 2, String.format("setNativeState start sensor result=%s", new Object[] { Boolean.valueOf(this.mSensorManager.a(this.jdField_a_of_type_Aduv)) }));
    }
  }
  
  public void nativeCallBack(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ARTransferPromotionRenderable", 1, "nativeCallBack  " + paramInt1 + "|" + paramInt2);
    queueEvent(new ARTransferPromotionRenderable.16(this, paramInt1));
  }
  
  public void onDestroy()
  {
    QLog.d("ARTransferPromotionRenderable", 2, String.format("onDestroy mCurrentState=%s mCallDestroyFromPause=%s", new Object[] { Integer.valueOf(this.mCurrentState), Boolean.valueOf(this.bLM) }));
    if (this.h != null) {
      this.h.removeCallbacks(this.fU);
    }
    ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.6(this));
    ARTransferPromotionRenderable.7 local7 = new ARTransferPromotionRenderable.7(this);
    if (this.Sp == Thread.currentThread().getId())
    {
      local7.run();
      QLog.e("ARTransferPromotionRenderable", 1, "onDestroy in GLThread.");
      return;
    }
    if (this.jdField_a_of_type_Adda != null) {
      this.jdField_a_of_type_Adda.Z(local7);
    }
    QLog.e("ARTransferPromotionRenderable", 1, "onDestroy not in GLThread.");
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QLog.d("ARTransferPromotionRenderable", 2, String.format("onTouch mNativeGameStatus=%d", new Object[] { Integer.valueOf(this.cCJ) }));
    paramView.getWidth();
    new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    case 2: 
    default: 
      return false;
    }
    if (this.cCJ == 3)
    {
      cQx();
      paramView.setVisibility(8);
      QLog.d("ARTransferPromotionRenderable", 2, "start cameraAnimation here");
      return false;
    }
    if (this.cCJ == 4)
    {
      if (this.bLR)
      {
        QLog.d("ARTransferPromotionRenderable", 2, "onTouch event not deal ready");
        return false;
      }
      this.bLR = true;
      if ((this.jdField_a_of_type_Adda != null) && (this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge != null)) {
        this.jdField_a_of_type_Adda.Z(new ARTransferPromotionRenderable.17(this, paramView));
      }
      QLog.d("ARTransferPromotionRenderable", 1, "switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER click operation");
      return false;
    }
    QLog.d("ARTransferPromotionRenderable", 1, "onTouch doNothing");
    return false;
  }
  
  public void onUpdate()
  {
    if (this.mCurrentState == 5)
    {
      int i = this.cCL + 1;
      this.cCL = i;
      if (i >= 2) {
        KI(6);
      }
    }
  }
  
  public void setWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    if (this.jdField_a_of_type_Adgu != null) {
      queueEvent(new ARTransferPromotionRenderable.8(this));
    }
  }
  
  public String sf()
  {
    return this.jdField_a_of_type_Addi.key;
  }
  
  public String sg()
  {
    return this.jdField_a_of_type_Addi.bsf;
  }
  
  public void start()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "start from this cluase second");
    if (1 == this.mCurrentState) {
      KI(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addg
 * JD-Core Version:    0.7.0.1
 */