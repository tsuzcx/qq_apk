package dov.com.tencent.mobileqq.activity.richmedia.state;

import acfp;
import aman;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import anim.c;
import aqhq;
import awed;
import aytq;
import ayvc;
import ayvd;
import ayve;
import ayvf;
import ayvg;
import ayvh;
import ayvi;
import ayvk;
import ayvl;
import azam;
import azan.a;
import azao.a;
import azbo;
import azce;
import azce.a;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture.a;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class RMVideoStateMgr
  implements azan.a, azao.a, azce.a, AVCodec.AVCodecCallback, AudioCapture.a
{
  private static RMVideoStateMgr jdField_b_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
  public static boolean byW = true;
  private static final int[] jF = { 850, 780, 650, 480 };
  public ayvc a;
  public ayvd a;
  final ayve jdField_a_of_type_Ayve = new ayve();
  final ayvf jdField_a_of_type_Ayvf = new ayvf();
  final ayvg jdField_a_of_type_Ayvg = new ayvg();
  final ayvh jdField_a_of_type_Ayvh = new ayvh();
  public final ayvk a;
  public ayvl a;
  public azbo a;
  public a a;
  public final RMVideoSwitchCameraPicMgr a;
  public AudioCapture.a a;
  public AudioCapture a;
  public PreviewContext a;
  public AtomicInteger aK = new AtomicInteger(0);
  public AtomicInteger aL = new AtomicInteger(1);
  private aman jdField_b_of_type_Aman;
  public double bL;
  public String bdG;
  public String bdT;
  public boolean byV;
  public boolean byX;
  public boolean byY;
  private boolean byZ;
  public boolean bza = true;
  public boolean bzc;
  private volatile boolean bze;
  private boolean bzg;
  private volatile boolean bzh;
  private boolean bzi = true;
  public AtomicBoolean cb = new AtomicBoolean(false);
  private int cjK = 1;
  public int cjL = 480;
  private int cjM;
  private int[] jG = new int[8];
  private Object mAudioLock = new Object();
  public Context mContext;
  public Handler mHandler = new Handler(Looper.getMainLooper());
  public long mStartTime;
  private Object mlock = new Object();
  
  private RMVideoStateMgr()
  {
    this.jdField_a_of_type_Ayvk = new ayvk();
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr = new RMVideoSwitchCameraPicMgr();
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$a = new a();
    this.jdField_a_of_type_Ayvd = new ayvd();
  }
  
  public static void AR(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "clearVideoDataFile:" + paramString);
    }
    ThreadManager.post(new RMVideoStateMgr.4(paramString), 5, null, true);
  }
  
  public static RMVideoStateMgr a()
  {
    try
    {
      if (jdField_b_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) {
        jdField_b_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = new RMVideoStateMgr();
      }
      RMVideoStateMgr localRMVideoStateMgr = jdField_b_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
      return localRMVideoStateMgr;
    }
    finally {}
  }
  
  private void changeState(int paramInt)
  {
    this.aL.getAndSet(paramInt);
  }
  
  private native void setBeautyLevelNative(int paramInt);
  
  private native void setResolutionAlignedByteNative(int paramInt);
  
  private native void setVideoClipSpec(int[] paramArrayOfInt);
  
  private static void y(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString1.trim().length() == 0)) {}
    do
    {
      do
      {
        return;
        paramString1 = new File(paramString1);
      } while (!paramString1.exists());
      File[] arrayOfFile = paramString1.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        if (i < arrayOfFile.length)
        {
          if ((paramString2 != null) && (!"".equals(paramString2)) && (arrayOfFile[i].getAbsolutePath().equals(paramString2))) {}
          for (;;)
          {
            i += 1;
            break;
            if (arrayOfFile[i].isDirectory()) {
              y(arrayOfFile[i].getAbsolutePath(), paramString2, true);
            } else {
              arrayOfFile[i].delete();
            }
          }
        }
      }
    } while (!paramBoolean);
    paramString1.delete();
  }
  
  public void AQ(String paramString)
  {
    stopWatching();
    if (QLog.isColorLevel()) {
      QLog.d("" + paramString, 2, "[@][deleteCacheFile] [RMFileEventNotify]stopWatching");
    }
    if (this.bdG != null) {
      aqhq.delete(this.bdG, false);
    }
  }
  
  public void CW(boolean paramBoolean)
  {
    this.byZ = paramBoolean;
  }
  
  public void CZ(boolean paramBoolean)
  {
    this.byX = paramBoolean;
  }
  
  public void H(int paramInt, String paramString)
  {
    try
    {
      
      label3:
      a().onPause();
      if (paramInt == 0)
      {
        j(0, acfp.m(2131713965), false);
        if (1 == aytq.ciB) {
          awed.ad(azam.sUin + "", "qzone_video_record", "1", null);
        }
      }
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      break label3;
    }
  }
  
  boolean WV()
  {
    long l = azce.s(azce.a().JE);
    if (l <= azce.ama)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@] checkDiskSpaceIsOK,freeSpace <= FREESPACE_LIMIT_EXIT freeSpace=" + l + "StorageManager.FREESPACE_LIMIT_EXIT=" + azce.ama + " 手机剩余存储空间不足");
      }
      j(0, acfp.m(2131713964), false);
      return false;
    }
    return true;
  }
  
  public boolean Xc()
  {
    return this.aL.get() == 3;
  }
  
  public boolean Xg()
  {
    if (!this.bzh) {
      synchronized (this.mlock)
      {
        boolean bool = this.bzh;
        if (!bool) {}
        try
        {
          this.mlock.wait(1000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    return true;
  }
  
  public boolean Xh()
  {
    return (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture != null) && (this.byX);
  }
  
  public boolean Xi()
  {
    return this.bzi;
  }
  
  public int a(azan.a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i = -1;
    if (parama == this)
    {
      a().a(parama, paramBoolean, paramInt1, paramInt2);
      i = 0;
    }
    return i;
  }
  
  public ayvi a()
  {
    int i = this.aL.get();
    ayvf localayvf = this.jdField_a_of_type_Ayvf;
    switch (i)
    {
    default: 
      return localayvf;
    case 2: 
      return this.jdField_a_of_type_Ayve;
    case 3: 
      return this.jdField_a_of_type_Ayvh;
    }
    return this.jdField_a_of_type_Ayvg;
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      a().a(paramObject, paramInt, paramVarArgs);
    }
    do
    {
      return;
    } while ((!anim.c.class.isInstance(paramObject)) || (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext == null));
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
  }
  
  public void cyh()
  {
    this.bze = true;
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "startHwRecorder");
    }
  }
  
  public void cyi()
  {
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "stopHwRecorder");
    }
    this.bze = false;
    if (this.jdField_b_of_type_Aman != null) {
      this.jdField_b_of_type_Aman.stopRecording();
    }
    this.cjM = 0;
  }
  
  public void cyk()
  {
    synchronized (this.mlock)
    {
      this.bzh = true;
      this.mlock.notifyAll();
      return;
    }
  }
  
  public void cyl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]mIsAudioReady=" + this.byX + " mAI=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture);
    }
    if (!Xh())
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture = new AudioCapture(this.mContext);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.a(this);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.init();
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]");
    }
  }
  
  public void cym()
  {
    ThreadManager.post(new RMVideoStateMgr.2(this), 10, null, false);
  }
  
  public void cyn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]mIsAudioReady=" + this.byX + " mAI=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture);
    }
    ThreadManager.post(new RMVideoStateMgr.3(this), 10, null, false);
  }
  
  public boolean hB(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "mediacodec from:" + paramInt + ", isMediaCodecSupport:" + this.bzg);
    }
    return this.bzg;
  }
  
  public void j(int paramInt, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ayvl != null) {
      this.jdField_a_of_type_Ayvl.k(paramInt, paramString, paramBoolean);
    }
  }
  
  public void l(int paramInt, String paramString, boolean paramBoolean)
  {
    this.mHandler.post(new RMVideoStateMgr.1(this, paramString));
  }
  
  public void onAVCodecEvent(AVCodec.AVCodecCallback arg1, MessageStruct paramMessageStruct)
  {
    a().onAVCodecEvent(???, paramMessageStruct);
    if (paramMessageStruct.mId == 33554451)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK");
      }
      synchronized (this.cb)
      {
        this.cb.set(true);
        this.cb.notifyAll();
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK ,notifyAll");
        }
        return;
      }
    }
  }
  
  public void runOnUiThread(Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }
  
  public void startWatching()
  {
    if ((this.jdField_a_of_type_Ayvc != null) && (this.bL > 0.0D)) {
      this.jdField_a_of_type_Ayvc.startWatching();
    }
  }
  
  public void stopWatching()
  {
    if (this.jdField_a_of_type_Ayvc != null) {
      this.jdField_a_of_type_Ayvc.stopWatching();
    }
  }
  
  public void tl(int paramInt)
  {
    changeState(paramInt);
    a().initState();
  }
  
  public static class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
 * JD-Core Version:    0.7.0.1
 */