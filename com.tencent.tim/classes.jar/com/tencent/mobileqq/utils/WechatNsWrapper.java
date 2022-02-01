package com.tencent.mobileqq.utils;

import aliv.a;
import alix;
import android.content.Context;
import anpc;
import aqlv;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.PipedInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.HashMap;

public final class WechatNsWrapper
  extends alix
{
  public static boolean soLoaded;
  long atl;
  private boolean cUK;
  short[] q;
  
  public WechatNsWrapper(Context paramContext)
  {
    super(paramContext);
    eet();
  }
  
  private void eet()
  {
    if (!soLoaded) {}
    try
    {
      boolean bool = SoLoadUtil.loadNativeLibrary(this.context, "stlport_shared", 0, false);
      if (QLog.isColorLevel()) {
        QLog.d("SilkCodecWrapper", 2, "load stlport_shared " + bool);
      }
      bool = SoLoadUtilNew.loadSoByName(this.context, "voicemessagedenoise");
      if (QLog.isColorLevel()) {
        QLog.d("SilkCodecWrapper", 2, "load voicemessagedenoise " + bool);
      }
      bool = SoLoadUtilNew.loadSoByName(this.context, "wechatns");
      if (QLog.isColorLevel()) {
        QLog.d("SilkCodecWrapper", 2, "load wechatns " + bool);
      }
      soLoaded = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      HashMap localHashMap = new HashMap();
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      localHashMap.put("throwable", localThrowable.getMessage());
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actWechatNsLoadFail", false, 0L, 0L, localHashMap, "");
    }
  }
  
  public void b(byte[] paramArrayOfByte, short[] paramArrayOfShort)
  {
    ByteBuffer.wrap(paramArrayOfByte, 0, paramArrayOfByte.length).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(paramArrayOfShort, 0, paramArrayOfByte.length / 2);
  }
  
  public void b(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(paramArrayOfShort);
  }
  
  public void close()
    throws IOException
  {
    super.close();
    eer();
  }
  
  public void eer()
  {
    if (this.atl != 0L)
    {
      int i = nsDelete(this.atl);
      if (QLog.isColorLevel()) {
        QLog.d("SilkCodecWrapper", 2, "deleteCodec =" + i);
      }
    }
    this.atl = 0L;
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    int i = 960;
    super.init(paramInt1, paramInt2, paramInt3);
    if (this.atl == 0L) {}
    for (;;)
    {
      try
      {
        this.atl = nsNew();
        if (QLog.isColorLevel()) {
          QLog.d("SilkCodecWrapper", 2, "silkEncoderNew =" + this.atl);
        }
        paramInt2 = nsInit(this.atl, paramInt1);
        if (paramInt2 != 0) {
          continue;
        }
        bool = true;
        this.cUK = bool;
        if (QLog.isColorLevel()) {
          QLog.d("SilkCodecWrapper", 2, "silkEncoderInit =" + paramInt2);
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SilkCodecWrapper", 2, "init silk codec =" + localException.toString());
        this.atl = 0L;
        soLoaded = false;
        continue;
      }
      this.duG = aqlv.kg(paramInt1);
      this.q = new short[this.duG / 2];
      this.fh = new byte[this.duG];
      this.fi = new byte[this.duG];
      paramInt1 = i;
      if (this.duG * 2 > 960) {
        paramInt1 = this.duG * 2;
      }
      this.fj = new byte[paramInt1];
      this.jdField_a_of_type_Aliv$a = new aliv.a(this.fj, 0);
      return;
      bool = false;
    }
  }
  
  public native int nsDelete(long paramLong);
  
  public native int nsInit(long paramLong, int paramInt);
  
  public native long nsNew();
  
  public native int nsProcess(long paramLong, short[] paramArrayOfShort, int paramInt);
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if ((this.atl != 0L) && (this.cUK)) {
      if (this.jdField_a_of_type_JavaIoPipedInputStream.read(this.fh, 0, this.duG) != -1) {}
    }
    while (this.jdField_a_of_type_JavaIoPipedInputStream.read(this.fh, 0, this.duG) == -1)
    {
      return -1;
      b(this.fh, this.q);
      nsProcess(this.atl, this.q, this.fh.length);
      b(this.q, this.fh);
      System.arraycopy(this.fh, 0, paramArrayOfByte, paramInt1, this.duG);
      return this.duG;
    }
    System.arraycopy(this.fh, 0, paramArrayOfByte, paramInt1, this.duG);
    return this.duG;
  }
  
  public void release()
    throws IOException
  {
    super.release();
    eer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.WechatNsWrapper
 * JD-Core Version:    0.7.0.1
 */