import android.net.NetworkInfo;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.subtitles.EncodeRunnable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class aath
  implements aatt
{
  private static String TAG = "AudioTranslator";
  private static aath jdField_a_of_type_Aath;
  private long Mu;
  private aaun jdField_a_of_type_Aaun;
  private amca jdField_a_of_type_Amca;
  private boolean bzo;
  private boolean bzp;
  private WeakReference<AudioCapture> eY;
  private boolean mEnable;
  
  private void Dc(boolean paramBoolean)
  {
    boolean bool;
    try
    {
      if (this.jdField_a_of_type_Aaun == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "checksession state:" + this.jdField_a_of_type_Aaun.mState + "  withenglish:" + paramBoolean + " old:" + this.jdField_a_of_type_Aaun.bzD);
      }
      bool = this.jdField_a_of_type_Aaun.bzD;
      this.jdField_a_of_type_Aaun.bzD = paramBoolean;
      if (this.jdField_a_of_type_Aaun.mState == 1)
      {
        if (this.jdField_a_of_type_Aaun.bzD != bool) {
          this.jdField_a_of_type_Aaun.bzE = true;
        }
        return;
      }
    }
    finally {}
    if (this.jdField_a_of_type_Aaun.mState == 3)
    {
      if (this.jdField_a_of_type_Aaun.bzD != bool) {
        cys();
      }
      return;
    }
    this.jdField_a_of_type_Aaun.mState = 1;
    ((amby)QQStoryContext.c().getBusinessHandler(0)).a(null, "TransInfoCreate.CreateSession", null, 0, 0, paramBoolean);
    this.bzo = true;
    this.Mu = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "send create session cmd");
    }
  }
  
  private void Gv(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "tryReconnect, start");
    }
    try
    {
      if (this.jdField_a_of_type_Aaun == null) {
        return;
      }
      if (this.jdField_a_of_type_Aaun.mListenerRef == null) {
        return;
      }
    }
    finally {}
    restart();
  }
  
  public static aath a()
  {
    try
    {
      if (jdField_a_of_type_Aath == null) {
        jdField_a_of_type_Aath = new aath();
      }
      return jdField_a_of_type_Aath;
    }
    finally {}
  }
  
  /* Error */
  private void a(aaun paramaaun, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: iload_2
    //   10: ifeq +58 -> 68
    //   13: iload_3
    //   14: ifgt +11 -> 25
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    //   25: aload_1
    //   26: getfield 151	aaun:cp	Landroid/os/Handler;
    //   29: ifnonnull +17 -> 46
    //   32: aload_1
    //   33: new 153	android/os/Handler
    //   36: dup
    //   37: invokestatic 159	com/tencent/mobileqq/app/ThreadManager:getSubThreadLooper	()Landroid/os/Looper;
    //   40: invokespecial 162	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   43: putfield 151	aaun:cp	Landroid/os/Handler;
    //   46: aload_1
    //   47: getfield 151	aaun:cp	Landroid/os/Handler;
    //   50: new 164	com/tencent/mobileqq/activity/richmedia/subtitles/AudioTranslator$3
    //   53: dup
    //   54: aload_0
    //   55: iload_3
    //   56: invokespecial 166	com/tencent/mobileqq/activity/richmedia/subtitles/AudioTranslator$3:<init>	(Laath;I)V
    //   59: iload_3
    //   60: i2l
    //   61: invokevirtual 170	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   64: pop
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_1
    //   69: getfield 151	aaun:cp	Landroid/os/Handler;
    //   72: ifnull +16 -> 88
    //   75: aload_1
    //   76: getfield 151	aaun:cp	Landroid/os/Handler;
    //   79: aconst_null
    //   80: invokevirtual 174	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   83: aload_1
    //   84: aconst_null
    //   85: putfield 151	aaun:cp	Landroid/os/Handler;
    //   88: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq -26 -> 65
    //   94: getstatic 29	aath:TAG	Ljava/lang/String;
    //   97: iconst_2
    //   98: ldc 176
    //   100: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: goto -38 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	aath
    //   0	106	1	paramaaun	aaun
    //   0	106	2	paramBoolean	boolean
    //   0	106	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   6	8	20	finally
    //   17	19	20	finally
    //   21	23	20	finally
    //   25	46	20	finally
    //   46	65	20	finally
    //   65	67	20	finally
    //   68	88	20	finally
    //   88	103	20	finally
  }
  
  public static boolean aI(boolean paramBoolean)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null) {}
    boolean bool;
    do
    {
      return false;
      bool = localNetworkInfo.isConnected();
      if (!paramBoolean) {
        break;
      }
    } while (!AppNetConnInfo.isWifiConn());
    return true;
    return bool;
  }
  
  private void cyq()
  {
    if (this.jdField_a_of_type_Aaun == null) {
      return;
    }
    this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new aati(this);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void cyr()
  {
    try
    {
      if (this.jdField_a_of_type_Amca != null) {
        return;
      }
      this.jdField_a_of_type_Amca = new aatj(this);
      QQStoryContext.c().addObserver(this.jdField_a_of_type_Amca);
      return;
    }
    finally {}
  }
  
  private void cys()
  {
    String str1 = "";
    try
    {
      if (this.jdField_a_of_type_Aaun == null) {
        return;
      }
      if (this.jdField_a_of_type_Aaun.mState != 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, " changesession state error:" + this.jdField_a_of_type_Aaun.mState);
        }
        return;
      }
    }
    finally {}
    boolean bool = this.jdField_a_of_type_Aaun.bzD;
    String str2;
    if (this.jdField_a_of_type_Aaun.ME != -1L) {
      str2 = String.valueOf(this.jdField_a_of_type_Aaun.ME);
    }
    ((amby)QQStoryContext.c().getBusinessHandler(0)).a(str2, "TransInfo.ChangeSession", null, 0, 0, bool);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "changesession start:" + bool + " sessionid:" + str2);
    }
  }
  
  private void cyt()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Aaun == null) {
          return;
        }
        if (this.jdField_a_of_type_Aaun.mState == 0) {
          break label173;
        }
        i = 1;
        if (this.jdField_a_of_type_Aaun.ME != -1L)
        {
          l = this.jdField_a_of_type_Aaun.ME;
          String str1 = String.valueOf(this.jdField_a_of_type_Aaun.ME);
          this.jdField_a_of_type_Aaun.mState = 0;
          this.jdField_a_of_type_Aaun.ME = -1L;
          this.jdField_a_of_type_Aaun.ckd = 0;
          this.jdField_a_of_type_Aaun.jdField_a_of_type_Alyj = null;
          if (i != 0)
          {
            ((amby)QQStoryContext.c().getBusinessHandler(0)).lb(l);
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "send stop tcp cmd:" + str1);
            }
          }
          a(this.jdField_a_of_type_Aaun, false, 0);
          return;
        }
      }
      finally {}
      String str2 = "";
      long l = 0L;
      continue;
      label173:
      int i = 0;
    }
  }
  
  private void cyu()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Aaun == null) {
          return;
        }
        if (this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable != null) {
          break;
        }
        this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable = new EncodeRunnable(this, this.jdField_a_of_type_Aaun.mSampleRate);
        EncodeRunnable localEncodeRunnable1 = this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable;
        if (!this.jdField_a_of_type_Aaun.bzF)
        {
          localEncodeRunnable1.De(bool1);
          if (this.jdField_a_of_type_Aaun.mState == 3) {
            this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.ap(this.jdField_a_of_type_Aaun.ME, this.jdField_a_of_type_Aaun.ckd);
          }
          this.jdField_a_of_type_Aaun.k = ThreadManager.newFreeThread(this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable, "TransAudio", 8);
          this.jdField_a_of_type_Aaun.k.start();
          return;
        }
      }
      finally {}
      bool1 = false;
    }
    if ((this.jdField_a_of_type_Aaun.k.isAlive()) && (!this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.isStop()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "encode thread is running");
      }
      return;
    }
    this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.stop();
    this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable = null;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "create new EncodeThread ");
    }
    this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable = new EncodeRunnable(this, this.jdField_a_of_type_Aaun.mSampleRate);
    EncodeRunnable localEncodeRunnable2 = this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable;
    if (!this.jdField_a_of_type_Aaun.bzF) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localEncodeRunnable2.De(bool1);
      if (this.jdField_a_of_type_Aaun.mState == 3) {
        this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.ap(this.jdField_a_of_type_Aaun.ME, this.jdField_a_of_type_Aaun.ckd);
      }
      this.jdField_a_of_type_Aaun.k = ThreadManager.newFreeThread(this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable, "TransAudio", 8);
      this.jdField_a_of_type_Aaun.k.start();
      return;
    }
  }
  
  private void enable(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  private void restart()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "restart begin");
    }
    try
    {
      if (this.jdField_a_of_type_Aaun == null) {
        return;
      }
      if (this.jdField_a_of_type_Aaun.mListenerRef != null)
      {
        aath.a locala = (aath.a)this.jdField_a_of_type_Aaun.mListenerRef.get();
        if (locala != null) {
          a(locala, this.jdField_a_of_type_Aaun.bzD, this.jdField_a_of_type_Aaun.bzF, true);
        }
      }
      return;
    }
    finally {}
  }
  
  public void Dd(boolean paramBoolean)
  {
    this.bzp = paramBoolean;
  }
  
  public void a(long paramLong, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      return;
    }
    String str1 = "";
    try
    {
      if (this.jdField_a_of_type_Aaun == null) {
        return;
      }
    }
    finally {}
    if (this.jdField_a_of_type_Aaun.mState != 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onEncodePackage, state not match:" + this.jdField_a_of_type_Aaun.mState);
      }
      return;
    }
    if (this.jdField_a_of_type_Aaun.ME != paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onEncodePackage, session not match:" + this.jdField_a_of_type_Aaun.ME + "-" + paramLong);
      }
      return;
    }
    boolean bool = this.jdField_a_of_type_Aaun.bzD;
    if (this.jdField_a_of_type_Aaun.ME != -1L) {
      str1 = String.valueOf(this.jdField_a_of_type_Aaun.ME);
    }
    this.jdField_a_of_type_Aaun.MF = System.currentTimeMillis();
    amby localamby = (amby)QQStoryContext.c().getBusinessHandler(0);
    String str2 = "";
    if (this.jdField_a_of_type_Aaun.jdField_a_of_type_Alyj != null) {
      str2 = this.jdField_a_of_type_Aaun.jdField_a_of_type_Alyj.host;
    }
    for (int i = this.jdField_a_of_type_Aaun.jdField_a_of_type_Alyj.port;; i = 0)
    {
      localamby.a(str1, "TransInfo.RawData", str2, i, paramByteBuffer.array(), 0, paramByteBuffer.limit(), bool, 2);
      return;
    }
  }
  
  public void a(aath.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      if (this.jdField_a_of_type_Aaun == null) {
        return;
      }
      this.jdField_a_of_type_Aaun.mListenerRef = new WeakReference(parama);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "start, state:" + this.jdField_a_of_type_Aaun.mState + " withenglish:" + paramBoolean1 + " rocordmode:" + paramBoolean2 + " resumecapture:" + paramBoolean3);
      }
      this.jdField_a_of_type_Aaun.bzF = paramBoolean2;
      Dc(paramBoolean1);
      this.jdField_a_of_type_Aaun.hZ.clear();
      cyu();
      enable(true);
      if ((paramBoolean3) && (this.eY != null))
      {
        parama = (AudioCapture)this.eY.get();
        if (parama != null) {
          parama.resume();
        }
      }
      this.jdField_a_of_type_Aaun.MG = System.currentTimeMillis();
      return;
    }
    finally {}
  }
  
  public void a(AudioCapture paramAudioCapture)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "registAudioRecord :" + paramAudioCapture);
    }
    if (paramAudioCapture == null) {}
    try
    {
      this.eY = null;
      bn(false, this.bzp);
      this.bzp = false;
      return;
    }
    finally {}
    this.eY = new WeakReference(paramAudioCapture);
    if ((this.jdField_a_of_type_Aaun != null) && (this.jdField_a_of_type_Aaun.mListenerRef != null)) {
      restart();
    }
  }
  
  public void bn(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "stop, pausecapture:" + paramBoolean1 + " canrestart:" + paramBoolean2);
    }
    try
    {
      enable(false);
      if (this.jdField_a_of_type_Aaun == null) {
        return;
      }
      if ((paramBoolean1) && (this.eY != null))
      {
        AudioCapture localAudioCapture = (AudioCapture)this.eY.get();
        if (localAudioCapture != null) {
          localAudioCapture.pause();
        }
      }
      if (!paramBoolean2) {
        this.jdField_a_of_type_Aaun.mListenerRef = null;
      }
      if ((this.jdField_a_of_type_Aaun != null) && (this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "stop begin:" + this.jdField_a_of_type_Aaun.mState);
        }
        this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable.stop();
        this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable = null;
      }
      cyt();
      return;
    }
    finally {}
  }
  
  public boolean isEnable()
  {
    return this.mEnable;
  }
  
  public void k(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!isEnable()) {}
    EncodeRunnable localEncodeRunnable;
    do
    {
      do
      {
        return;
      } while (paramInt2 <= 0);
      try
      {
        if (this.jdField_a_of_type_Aaun == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "transcontext is null");
          }
          return;
        }
      }
      finally {}
      localEncodeRunnable = this.jdField_a_of_type_Aaun.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesEncodeRunnable;
    } while (localEncodeRunnable == null);
    localEncodeRunnable.l(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean l(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "init, samplerate:" + paramInt1 + " channel:" + paramInt2 + " format:" + paramInt3);
    }
    try
    {
      if (this.jdField_a_of_type_Aaun != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "create error, transcontext not null!");
        }
        return false;
      }
      this.jdField_a_of_type_Aaun = new aaun();
      this.jdField_a_of_type_Aaun.mSampleRate = paramInt1;
      this.jdField_a_of_type_Aaun.ckG = paramInt2;
      this.jdField_a_of_type_Aaun.mAudioFormat = paramInt3;
      cyr();
      cyq();
      return true;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong1, long paramLong2, String paramString1, String paramString2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aath
 * JD-Core Version:    0.7.0.1
 */