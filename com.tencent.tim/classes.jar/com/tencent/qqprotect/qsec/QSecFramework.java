package com.tencent.qqprotect.qsec;

import android.os.Handler;
import asxu;
import asyb;
import asye;
import asyj;
import asyv;
import asyy;
import asyz;
import asza;
import aszb;
import aszc;
import aszd;
import aszh;
import aszj;
import aszl;
import aszw;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public final class QSecFramework
{
  private static volatile QSecFramework jdField_a_of_type_ComTencentQqprotectQsecQSecFramework;
  private static Handler dT = new Handler(ThreadManager.getFileThreadLooper());
  private static ConcurrentHashMap<Long, a> jF = new ConcurrentHashMap();
  private static boolean mNativeLoaded;
  private asyv jdField_a_of_type_Asyv;
  private aszd jdField_a_of_type_Aszd;
  private aszh jdField_a_of_type_Aszh;
  private aszj jdField_a_of_type_Aszj = new aszj();
  private Handler dU;
  private boolean dgG;
  private int eom = -1;
  private boolean mStarted;
  
  static
  {
    new asyj("QSec", 86400000L).a(new asyy());
  }
  
  private QSecFramework()
  {
    this.jdField_a_of_type_Aszj.a(asye.a());
    this.jdField_a_of_type_Aszj.a(aszl.a());
    this.jdField_a_of_type_Aszj.a(asyb.a());
    new asyj("QSec", 86400000L).a(new asyz(this));
    this.jdField_a_of_type_Asyv = new asyv();
    this.jdField_a_of_type_Aszd = new aszd(this.jdField_a_of_type_Asyv);
    this.jdField_a_of_type_Aszh = new aszh(this.jdField_a_of_type_Aszd, this.jdField_a_of_type_Asyv);
    this.dU = new asza(this, ThreadManager.getFileThreadLooper());
    a(2L, new aszb(this));
  }
  
  public static Handler C()
  {
    return dT;
  }
  
  public static QSecFramework a()
  {
    if (jdField_a_of_type_ComTencentQqprotectQsecQSecFramework == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentQqprotectQsecQSecFramework == null) {
        jdField_a_of_type_ComTencentQqprotectQsecQSecFramework = new QSecFramework();
      }
      return jdField_a_of_type_ComTencentQqprotectQsecQSecFramework;
    }
    finally {}
  }
  
  public static void a(long paramLong, a parama)
  {
    if (parama != null) {
      jF.put(Long.valueOf(paramLong), parama);
    }
  }
  
  private static boolean aIP()
  {
    if (mNativeLoaded) {
      return true;
    }
    String str = asxu.El() + File.separator + "libQSec.so";
    File localFile = new File(str);
    if ((localFile.exists()) && (aszw.h(localFile, null))) {
      try
      {
        System.load(str);
        return true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
    return false;
  }
  
  public static int b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (!mNativeLoaded) {
      return 27;
    }
    try
    {
      int i = goingDownInternal(paramLong1, paramLong2, paramLong3, paramLong4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
      return i;
    }
    catch (UnsatisfiedLinkError paramObject1)
    {
      paramObject1.printStackTrace();
    }
    return 29;
  }
  
  private static native int goingDownInternal(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2);
  
  private static int goingUp(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    a locala = (a)jF.get(Long.valueOf(paramLong1));
    if (locala != null) {
      return locala.b(paramLong2, paramLong3, paramLong4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
    }
    return 30;
  }
  
  public int Oa()
  {
    return this.eom;
  }
  
  public void bW(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Aszh.bX(paramArrayOfByte);
  }
  
  public Boolean c(int paramInt)
  {
    Byte localByte = Byte.valueOf();
    if (this.jdField_a_of_type_Asyv != null) {
      localByte = Byte.valueOf(this.jdField_a_of_type_Asyv.f(paramInt));
    }
    if (1 == localByte.byteValue()) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public void esA()
  {
    if (!this.mStarted) {
      this.mStarted = true;
    }
    this.jdField_a_of_type_Asyv.Vj(false);
    this.jdField_a_of_type_Aszd.b(new aszc(this));
    this.jdField_a_of_type_Aszd.esJ();
    dT.postDelayed(new QSecFramework.6(this), 0L);
  }
  
  public void esB()
  {
    this.jdField_a_of_type_Aszd.esI();
  }
  
  public int sendCmdToLib(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return this.jdField_a_of_type_Aszd.b(paramInt1, paramInt2, paramInt3, paramArrayOfObject1, paramArrayOfObject2);
  }
  
  public static abstract interface a
  {
    public abstract int b(long paramLong1, long paramLong2, long paramLong3, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecFramework
 * JD-Core Version:    0.7.0.1
 */