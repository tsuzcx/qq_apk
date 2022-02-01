import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.1;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.2;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.3;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.4;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.6;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.7;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.8;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController.a;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

public class adcl
  implements adcn.a, Handler.Callback, VideoRecordController.a
{
  public static final String brP = acfp.m(2131702896);
  public static final String brQ = acfp.m(2131702897);
  public static final String brR = acfp.m(2131702892);
  public static final String brS = acfp.m(2131702893);
  public static final String brT = acfp.m(2131702895);
  public static final String brU = acfp.m(2131702899);
  public static final String brV = acfp.m(2131702894);
  public static final String brW = acfp.m(2131702898);
  @Deprecated
  private Context E;
  private HandlerThread F;
  private final int MSG_RECORD_ERROR = 5;
  private volatile adck jdField_a_of_type_Adck;
  private volatile adcn jdField_a_of_type_Adcn;
  private boolean bLm;
  private boolean bLn;
  private boolean bLo;
  private boolean bLp;
  private boolean bLq = true;
  private boolean bLr = true;
  private boolean bLs;
  private final int cCj = 1;
  private final int cCk = 2;
  private final int cCl = 3;
  private final int cCm = 4;
  private final int cCn = 6;
  private final int cCo = 7;
  private final int cCp = 8;
  private final int cCq = 9;
  private final int cCr = 10;
  private final int cCs = 12;
  private final int cCt = 13;
  private int cCu = -1;
  private Activity mActivity;
  private Handler mHandler;
  
  private adcl()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "ARVideoRecordUIControllerImpl mIsEnableVideoRecord" + this.bLq);
    }
  }
  
  private void KC(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleInterruptARVideoRecord " + paramInt);
    }
    if (adC())
    {
      if (this.jdField_a_of_type_Adcn != null)
      {
        this.jdField_a_of_type_Adcn.KE(0);
        this.jdField_a_of_type_Adcn.hide();
      }
      if ((paramInt == 2) || (paramInt == 4) || (paramInt == 6) || (paramInt == 1) || (paramInt == 3))
      {
        this.jdField_a_of_type_Adck.k(false, true);
        this.cCu = paramInt;
        this.bLp = true;
        if (QLog.isColorLevel()) {
          QLog.i("ARVideoRecordUIControllerImpl", 2, "handleInterruptARVideoRecord normal record running");
        }
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Adck.k(false, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ARVideoRecordUIControllerImpl", 2, "error branch ,should not happen");
      break;
      if (this.jdField_a_of_type_Adcn != null) {
        this.jdField_a_of_type_Adcn.hide();
      }
      if (this.jdField_a_of_type_Adck != null) {
        this.jdField_a_of_type_Adck.k(false, false);
      }
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordUIControllerImpl", 2, "handleInterruptARVideoRecord other condition");
  }
  
  private void KD(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleVideoRecordErrorStatus " + paramInt);
    }
    if (this.bLm)
    {
      this.jdField_a_of_type_Adcn.KE(0);
      if (!this.bLo) {
        if (paramInt == 11) {
          adch.bU(brP, false);
        }
      }
      for (;;)
      {
        this.bLp = false;
        this.cCu = -1;
        lO("0X8008A57");
        return;
        ThreadManager.getUIHandler().post(new ARVideoRecordUIControllerImpl.3(this));
        continue;
        this.bLo = false;
      }
    }
    if (this.jdField_a_of_type_Adcn != null)
    {
      this.jdField_a_of_type_Adcn.KE(0);
      this.jdField_a_of_type_Adcn.hide();
    }
    if (!this.bLo) {
      if (paramInt == 11) {
        adch.bU(brP, false);
      }
    }
    for (;;)
    {
      this.bLp = false;
      cQg();
      break;
      ThreadManager.getUIHandler().post(new ARVideoRecordUIControllerImpl.4(this));
      continue;
      this.bLo = false;
    }
  }
  
  private void Y(Runnable paramRunnable)
  {
    if (this.mHandler != null) {
      this.mHandler.post(paramRunnable);
    }
  }
  
  public static adcl a()
  {
    return adcl.a.b();
  }
  
  private boolean adC()
  {
    return (adA()) && (this.jdField_a_of_type_Adck.isRecording());
  }
  
  private void cPZ()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleDoOnResume");
    }
    this.bLp = false;
    this.cCu = -1;
  }
  
  private void cQd()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleExternalAnimationStart");
    }
    if (!this.bLq) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Adck != null) && (this.jdField_a_of_type_Adck.isRecording())) {
        this.jdField_a_of_type_Adck.k(false, true);
      }
    } while (this.jdField_a_of_type_Adcn == null);
    this.jdField_a_of_type_Adcn.hide();
  }
  
  private void cQe()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleExternalAnimationEnd");
    }
    if (this.jdField_a_of_type_Adcn != null) {
      this.jdField_a_of_type_Adcn.show();
    }
  }
  
  private void cQf()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleOnPause");
    }
    if ((adC()) && (this.cCu == -1))
    {
      this.jdField_a_of_type_Adck.k(false, false);
      this.cCu = 5;
      this.bLp = false;
      lO("0X8008A57");
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordUIControllerImpl", 2, "handleOnPause mInterruptAnimationReason EXTERNAL_INTERRUPT");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Adcn != null)
      {
        this.jdField_a_of_type_Adcn.KE(0);
        this.jdField_a_of_type_Adcn.hide();
      }
      return;
      if ((this.cCu == -1) && (this.jdField_a_of_type_Adck != null)) {
        this.jdField_a_of_type_Adck.k(false, false);
      }
    }
  }
  
  private void cQg()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("ARVideoRecordUIControllerImpl", 2, "finalizeDestroy " + this.bLn);
        }
        if (this.bLn)
        {
          boolean bool = this.bLp;
          if (!bool) {}
        }
        else
        {
          return;
        }
        if (this.mHandler != null)
        {
          this.mHandler.removeCallbacksAndMessages(null);
          this.mHandler = null;
        }
        if (this.F != null) {
          if (Build.VERSION.SDK_INT >= 18)
          {
            this.F.quitSafely();
            this.F = null;
          }
          else
          {
            try
            {
              this.F.interrupt();
              this.F.quit();
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
      }
      finally {}
    }
  }
  
  private void cQi()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleMonitorUserOperationInternal");
    }
    if ((this.jdField_a_of_type_Adck == null) || (this.jdField_a_of_type_Adcn == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordUIControllerImpl", 2, "handleMonitorUserOperationInternal with value null");
      }
    }
    label145:
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Adcn.Bw() != 0) {
            break label145;
          }
          if (!adch.bO(104857600L))
          {
            adch.fm(brR, brS);
            return;
          }
          if (this.jdField_a_of_type_Adck.a(true, null)) {
            break;
          }
          adch.bU(brP, false);
        } while (!QLog.isColorLevel());
        QLog.i("ARVideoRecordUIControllerImpl", 2, "startVideoRecord failed");
        return;
        lO("0X8008A54");
        this.jdField_a_of_type_Adcn.KE(1);
      } while (!QLog.isColorLevel());
      QLog.i("ARVideoRecordUIControllerImpl", 2, "startVideoRecord end");
      return;
      if (adC())
      {
        this.jdField_a_of_type_Adck.k(true, true);
        this.cCu = 7;
        this.bLp = true;
        lO("0X8008A55");
        if (QLog.isColorLevel()) {
          QLog.i("ARVideoRecordUIControllerImpl", 2, "stopVideoRecord and doReport");
        }
      }
      this.jdField_a_of_type_Adcn.KE(0);
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordUIControllerImpl", 2, "stopVideoRecord end");
  }
  
  public static void lO(String paramString)
  {
    anot.a(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public void FW(boolean paramBoolean)
  {
    if (!this.bLq) {
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordUIControllerImpl", 2, "do nothing apart from return ");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramBoolean != this.bLr) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("ARVideoRecordUIControllerImpl", 2, "value equal return value:" + this.bLr);
        return;
        this.bLr = paramBoolean;
        if (!this.bLr) {
          break;
        }
        this.bLp = false;
        this.cCu = -1;
      } while (!QLog.isColorLevel());
      QLog.i("ARVideoRecordUIControllerImpl", 2, "call after onResume, from disable to enable");
      return;
      this.jdField_a_of_type_Adcn = null;
      this.jdField_a_of_type_Adck = null;
      this.E = null;
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordUIControllerImpl", 2, "call after onResume, from enable to disable");
  }
  
  public void KA(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "startPreRecord " + paramInt);
    }
    if (this.mActivity == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {}
    for (paramInt = ((BaseActivity)this.mActivity).checkSelfPermission("android.permission.RECORD_AUDIO");; paramInt = 0)
    {
      if ((paramInt == 0) && (Build.VERSION.SDK_INT >= 23))
      {
        int i = ((BaseActivity)this.mActivity).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        int j = ((BaseActivity)this.mActivity).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
        if ((i != 0) || (j != 0)) {
          paramInt = -1;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("startPreRecord permission=%s", new Object[] { Integer.valueOf(paramInt) }));
        }
        if ((!this.bLq) || (!this.bLr) || (paramInt != 0) || (this.mHandler == null)) {
          break;
        }
        this.mHandler.sendEmptyMessage(1);
        return;
      }
    }
  }
  
  public void KB(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "interruptARVideoRecordIfNeed");
    }
    if ((!this.bLq) || (!this.bLr)) {}
    while ((this.mHandler == null) || (this.F == null)) {
      return;
    }
    this.mHandler.removeMessages(7);
    Message localMessage = this.mHandler.obtainMessage(7);
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  public boolean adA()
  {
    return (this.jdField_a_of_type_Adck != null) && (this.jdField_a_of_type_Adck.adz());
  }
  
  public boolean adB()
  {
    return (this.jdField_a_of_type_Adck != null) && (this.jdField_a_of_type_Adck.adz()) && (!this.jdField_a_of_type_Adck.isRecording());
  }
  
  public void bf(Object paramObject)
  {
    if ((paramObject == null) || (!this.bLq)) {}
    do
    {
      return;
      if ((paramObject instanceof adcn))
      {
        this.jdField_a_of_type_Adcn = ((adcn)paramObject);
        this.jdField_a_of_type_Adcn.a(this);
        return;
      }
    } while (!(paramObject instanceof adck));
    this.jdField_a_of_type_Adck = ((adck)paramObject);
    this.jdField_a_of_type_Adck.a(this);
  }
  
  public void bg(Object paramObject)
  {
    if ((paramObject == null) || (!this.bLq) || (!this.bLr)) {}
    do
    {
      return;
      if ((paramObject instanceof adcn))
      {
        this.jdField_a_of_type_Adcn = null;
        return;
      }
    } while (!(paramObject instanceof adck));
    this.jdField_a_of_type_Adck = null;
  }
  
  public void bv(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "start");
    }
    if (!this.bLq) {
      return;
    }
    if (this.F == null)
    {
      this.F = ThreadManager.newFreeHandlerThread("ARVideoRecordThread-P", 0);
      this.F.start();
      this.mHandler = new Handler(this.F.getLooper(), this);
    }
    this.mActivity = paramActivity;
    this.bLn = false;
  }
  
  public void cQa()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "showVideoRecordButton");
    }
    if ((!this.bLq) || (!this.bLr)) {
      return;
    }
    Y(new ARVideoRecordUIControllerImpl.1(this));
  }
  
  public void cQb()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "hideVideoRecordButton");
    }
    if ((!this.bLq) || (!this.bLr)) {
      return;
    }
    Y(new ARVideoRecordUIControllerImpl.2(this));
  }
  
  public void cQc()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "recordAnimationStartTimeStamp");
    }
    if ((!this.bLq) || (!this.bLr)) {}
    while (this.jdField_a_of_type_Adck == null) {
      return;
    }
    this.jdField_a_of_type_Adck.iz(System.currentTimeMillis());
  }
  
  public void cQh()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "onMonitorUserOperation");
    }
    if ((!this.bLq) || (!this.bLr)) {}
    while (this.mHandler == null) {
      return;
    }
    this.mHandler.sendEmptyMessage(6);
  }
  
  public void cg(int paramInt, String paramString)
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordFinish finishType=%s", new Object[] { Integer.valueOf(paramInt) }));
    Y(new ARVideoRecordUIControllerImpl.8(this, paramInt));
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "doOnPause");
    }
    this.bLm = false;
    if ((!this.bLq) || (!this.bLr)) {}
    while (this.mHandler == null) {
      return;
    }
    this.mHandler.removeMessages(13);
    this.mHandler.sendEmptyMessage(13);
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "doOnResume");
    }
    this.bLm = true;
    if ((!this.bLq) || (!this.bLr)) {}
    while (this.mHandler == null) {
      return;
    }
    this.mHandler.removeMessages(12);
    this.mHandler.sendEmptyMessage(12);
  }
  
  @Deprecated
  public Context getContext()
  {
    return this.E;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, "CheckPermission user grant");
    if (this.bLs) {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    case 4: 
    case 5: 
    case 11: 
    default: 
      return true;
    case 6: 
      if (this.jdField_a_of_type_Adcn.Bw() == 0)
      {
        this.bLs = true;
        QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION UI displayMode normal");
        if (Build.VERSION.SDK_INT < 23) {
          break label441;
        }
      }
      break;
    }
    label441:
    for (int i = ((BaseActivity)this.mActivity).checkSelfPermission("android.permission.RECORD_AUDIO");; i = 0)
    {
      if (Build.VERSION.SDK_INT >= 23) {}
      for (int j = ((BaseActivity)this.mActivity).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");; j = 0)
      {
        if (Build.VERSION.SDK_INT >= 23) {}
        for (int k = ((BaseActivity)this.mActivity).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");; k = 0)
        {
          if ((i == 0) && (j == 0) && (k == 0)) {}
          for (i = 0; i == 0; i = -1)
          {
            QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION has permission");
            cQi();
            return true;
          }
          QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION need request permission");
          ((BaseActivity)this.mActivity).requestPermissions(new adcm(this), 1, new String[] { "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
          return true;
          QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION UI displayMode pressed");
          cQi();
          return true;
          cQd();
          return true;
          cQe();
          return true;
          KC(paramMessage.arg1);
          return true;
          KD(paramMessage.arg1);
          return true;
          if ((((BaseActivity)this.mActivity).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) || (((BaseActivity)this.mActivity).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (((BaseActivity)this.mActivity).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))
          {
            QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_START_PRE_RECORD permmit");
            return true;
          }
          if (adA()) {
            break;
          }
          this.bLs = false;
          if (this.jdField_a_of_type_Adck == null) {
            break;
          }
          this.jdField_a_of_type_Adck.a(false, null);
          return true;
          if (this.jdField_a_of_type_Adck == null) {
            break;
          }
          this.jdField_a_of_type_Adck.k(false, false);
          return true;
          cPZ();
          return true;
          cQf();
          return true;
        }
      }
    }
  }
  
  public void onRecordError(int paramInt)
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    if (this.mHandler != null)
    {
      Message localMessage = this.mHandler.obtainMessage(8);
      localMessage.arg1 = paramInt;
      localMessage.sendToTarget();
    }
  }
  
  public void onRecordStart()
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, "onRecordStart");
    Y(new ARVideoRecordUIControllerImpl.6(this));
  }
  
  public void onRecordUpdate(int paramInt1, int paramInt2)
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordUpdate duration=%s fileSize=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    Y(new ARVideoRecordUIControllerImpl.7(this, paramInt1, paramInt2));
  }
  
  @Deprecated
  public void setActivityContext(Context paramContext)
  {
    this.E = paramContext;
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "stop");
    }
    if ((!this.bLq) || (!this.bLr)) {}
    do
    {
      return;
      if (!this.bLm) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordUIControllerImpl", 2, "stop has been refused because of ActivityLifeCircle ERROR");
    return;
    this.jdField_a_of_type_Adcn = null;
    this.jdField_a_of_type_Adck = null;
    this.E = null;
    this.mActivity = null;
    this.bLn = true;
    cQg();
  }
  
  static class a
  {
    private static final adcl a = new adcl(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adcl
 * JD-Core Version:    0.7.0.1
 */