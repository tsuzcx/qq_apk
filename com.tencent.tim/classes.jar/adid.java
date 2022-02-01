import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARLocalControl.1;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog.a;
import com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecog.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class adid
  implements adie.a, ARLocalGestureCircleRecog.a, ARLocalMarkerRecog.a
{
  private static final Object cX = new Object();
  private long SQ = 0L;
  adid.a jdField_a_of_type_Adid$a = null;
  public adie a;
  ARLocalGestureCircleRecog jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog = null;
  ARLocalMarkerRecog jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog = null;
  private boolean bNk;
  private boolean bNl;
  Object cW = new Object();
  private boolean mIsInited;
  private boolean mIsStarted;
  
  private void a(Context paramContext, int paramInt1, int paramInt2, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo)
  {
    QLog.i("AREngine_ARLocalControl", 1, "initFaceRecogAsync start.");
    ThreadManager.postImmediately(new ARLocalControl.1(this, paramInt1, paramInt2, paramContext, paramARScanStarFaceConfigInfo, System.currentTimeMillis()), null, true);
  }
  
  public void a(long paramLong, adim paramadim)
  {
    synchronized (this.cW)
    {
      if ((this.mIsStarted) && (this.jdField_a_of_type_Adid$a != null)) {
        this.jdField_a_of_type_Adid$a.a(paramLong, paramadim);
      }
      return;
    }
  }
  
  public void a(adig paramadig)
  {
    a(4L, paramadig);
  }
  
  public void a(adii paramadii)
  {
    a(4096L, paramadii);
  }
  
  public void a(adik paramadik)
  {
    a(1L, paramadik);
  }
  
  public boolean a(Context arg1, long paramLong, int paramInt1, int paramInt2, ArConfigInfo paramArConfigInfo, ArrayList<ArCloudConfigInfo> paramArrayList, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, adid.a parama)
  {
    long l = System.currentTimeMillis();
    QLog.i("AREngine_ARLocalControl", 1, String.format("init start. mIsInited=%s recogType=%s imageWidth=%s imageHeight=%s", new Object[] { Boolean.valueOf(this.mIsInited), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (this.mIsInited) {
      return true;
    }
    this.SQ = paramLong;
    this.jdField_a_of_type_Adid$a = parama;
    a(???, paramInt1, paramInt2, paramARScanStarFaceConfigInfo);
    QLog.i("AREngine_ARLocalControl", 1, "init running. marker recog start.");
    paramLong = System.currentTimeMillis();
    if ((this.SQ & 1L) != 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog = new ARLocalMarkerRecog();
      if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.a(paramInt1, paramInt2, paramArConfigInfo, paramArrayList, this)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog = null;
      }
    }
    if ((this.SQ & 0x1000) != 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog = new ARLocalGestureCircleRecog();
      if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.a(paramInt1, paramInt2, this)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog = null;
      }
    }
    QLog.i("AREngine_ARLocalControl", 1, String.format("init running. marker recog end. time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong) }));
    synchronized (cX)
    {
      if (!this.bNk) {
        QLog.i("AREngine_ARLocalControl", 1, "init running. face recog has not init complete, wait...");
      }
    }
    try
    {
      cX.wait();
      label239:
      QLog.i("AREngine_ARLocalControl", 1, "init running. face recog init complete.");
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null) || (this.jdField_a_of_type_Adie != null) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null)) {}
      for (this.mIsInited = true;; this.mIsInited = false)
      {
        this.mIsStarted = false;
        QLog.i("AREngine_ARLocalControl", 1, String.format("init end. mIsInited=%s time cost:%sms", new Object[] { Boolean.valueOf(this.mIsInited), Long.valueOf(System.currentTimeMillis() - l) }));
        adix.a().ap(System.currentTimeMillis() - l, this.mIsInited);
        return this.mIsInited;
        paramArConfigInfo = finally;
        throw paramArConfigInfo;
      }
    }
    catch (Exception paramArConfigInfo)
    {
      break label239;
    }
  }
  
  public boolean a(String paramString1, String paramString2, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (!this.mIsStarted) {}
    while (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.a(paramString1, paramString2, paramArCloudConfigInfo);
  }
  
  public float[] a(int paramInt1, int paramInt2)
  {
    if (!this.mIsInited) {}
    while (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.a(paramInt1, paramInt2);
  }
  
  public boolean b(adht paramadht)
  {
    if (!this.mIsStarted) {}
    while (this.jdField_a_of_type_Adie == null) {
      return false;
    }
    return this.jdField_a_of_type_Adie.b(paramadht);
  }
  
  public boolean b(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog = new ARLocalGestureCircleRecog();
        if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.a(paramInt1, paramInt2, this))
        {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog = null;
          return false;
        }
        this.mIsInited = true;
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.start();
        this.mIsStarted = true;
      }
    }
    for (this.SQ |= 0x1000;; this.SQ &= 0xFFFFEFFF)
    {
      this.bNl = paramBoolean;
      return this.bNl;
    }
  }
  
  public boolean bR(long paramLong)
  {
    if (((1L & paramLong) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.isPause();
    }
    if (((0x4 & paramLong) != 0L) && (this.jdField_a_of_type_Adie != null)) {
      return this.jdField_a_of_type_Adie.isPause();
    }
    if (((0x1000 & paramLong) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.isPause();
    }
    return true;
  }
  
  public boolean bS(long paramLong)
  {
    if (((0x4 & paramLong) != 0L) && (this.jdField_a_of_type_Adie != null)) {
      return this.jdField_a_of_type_Adie.aew();
    }
    return true;
  }
  
  public void iG(long paramLong)
  {
    QLog.i("AREngine_ARLocalControl", 1, "pause. recogType = " + paramLong);
    if (((1L & paramLong) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.pause();
    }
    if (((0x4 & paramLong) != 0L) && (this.jdField_a_of_type_Adie != null)) {
      this.jdField_a_of_type_Adie.pause();
    }
    if (((0x1000 & paramLong) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.pause();
    }
  }
  
  public void iH(long paramLong)
  {
    QLog.i("AREngine_ARLocalControl", 1, "resume. recogType = " + paramLong);
    if (((1L & paramLong) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.resume();
    }
    if (((0x4 & paramLong) != 0L) && (this.jdField_a_of_type_Adie != null)) {
      this.jdField_a_of_type_Adie.resume();
    }
    if (((0x1000 & paramLong) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.resume();
    }
  }
  
  public void k(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!this.mIsStarted)) {}
    do
    {
      do
      {
        return;
        if (!this.bNl) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog == null);
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.k(paramLong, paramArrayOfByte);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.k(paramLong, paramArrayOfByte);
      }
    } while (this.jdField_a_of_type_Adie == null);
    this.jdField_a_of_type_Adie.k(paramLong, paramArrayOfByte);
  }
  
  public void reset()
  {
    if ((this.bNl) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null) && (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.isPause())) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.reset();
    }
  }
  
  public boolean start()
  {
    QLog.i("AREngine_ARLocalControl", 1, "start start.");
    if (!this.mIsInited) {
      return false;
    }
    if (this.mIsStarted) {
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null) && (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.start()))
    {
      this.mIsStarted = false;
      QLog.i("AREngine_ARLocalControl", 1, "start end. marker recog start failed. mIsStarted = " + this.mIsStarted);
      return this.mIsStarted;
    }
    if ((this.jdField_a_of_type_Adie != null) && (!this.jdField_a_of_type_Adie.start()))
    {
      this.mIsStarted = false;
      QLog.i("AREngine_ARLocalControl", 1, "start end. face recog start failed. mIsStarted = " + this.mIsStarted);
      return this.mIsStarted;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null) && (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.start()))
    {
      this.mIsStarted = false;
      QLog.i("AREngine_ARLocalControl", 1, "start end. gesture circle recog start failed. mIsStarted = " + this.mIsStarted);
      return this.mIsStarted;
    }
    this.mIsStarted = true;
    QLog.i("AREngine_ARLocalControl", 1, "start end. mIsStarted = " + this.mIsStarted);
    return true;
  }
  
  public void stop()
  {
    QLog.i("AREngine_ARLocalControl", 1, "stop start.");
    if (!this.mIsInited) {}
    while (!this.mIsStarted) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.stop();
    }
    if (this.jdField_a_of_type_Adie != null) {
      this.jdField_a_of_type_Adie.stop();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.stop();
    }
    this.mIsStarted = false;
    QLog.i("AREngine_ARLocalControl", 1, "stop end. mIsStarted = " + this.mIsStarted);
  }
  
  public void uninit()
  {
    QLog.i("AREngine_ARLocalControl", 1, "uninit start.");
    if (!this.mIsInited) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.uninit();
    }
    if (this.jdField_a_of_type_Adie != null) {
      this.jdField_a_of_type_Adie.uninit();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.uninit();
    }
    this.mIsInited = false;
    QLog.i("AREngine_ARLocalControl", 1, "uninit end. mIsInited = " + this.mIsInited);
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, adim paramadim);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adid
 * JD-Core Version:    0.7.0.1
 */