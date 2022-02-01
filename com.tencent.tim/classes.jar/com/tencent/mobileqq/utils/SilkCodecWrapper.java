package com.tencent.mobileqq.utils;

import alij;
import aliv.a;
import alix;
import android.content.Context;
import android.os.SystemClock;
import aomq;
import aqlv;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.PipedInputStream;

public final class SilkCodecWrapper
  extends alix
{
  private static boolean soLoaded;
  long atl;
  long atm;
  boolean cUE;
  long costTime;
  private int count;
  int dZX;
  
  public SilkCodecWrapper(Context paramContext)
  {
    super(paramContext);
    SN(true);
  }
  
  public SilkCodecWrapper(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    SN(paramBoolean);
  }
  
  private void SN(boolean paramBoolean)
  {
    if (!soLoaded)
    {
      alij.X(this.context, "codecsilk");
      soLoaded = true;
    }
    this.cUE = paramBoolean;
    this.costTime = 0L;
    this.dZX = 0;
    this.atm = 0L;
  }
  
  public static boolean aCf()
  {
    return soLoaded;
  }
  
  public native long SilkDecoderNew(int paramInt1, int paramInt2);
  
  public native long SilkEncoderNew(int paramInt1, int paramInt2);
  
  public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    if (this.atl == 0L) {
      return 0;
    }
    try
    {
      paramInt1 = decode(this.atl, paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
      l = SystemClock.uptimeMillis() - l;
      this.costTime += l;
      if (l > this.atm) {
        this.atm = l;
      }
      this.dZX += 1;
      return paramInt1;
    }
    catch (Throwable paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return 0;
  }
  
  public aliv.a a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    long l = SystemClock.uptimeMillis();
    paramArrayOfByte = super.a(paramArrayOfByte, paramInt1, paramInt2);
    l = SystemClock.uptimeMillis() - l;
    if (l > this.atm) {
      this.atm = l;
    }
    this.costTime = (l + this.costTime);
    this.dZX += 1;
    return paramArrayOfByte;
  }
  
  public void close()
    throws IOException
  {
    super.close();
    eer();
  }
  
  public native int decode(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public native void deleteCodec(long paramLong);
  
  public void eer()
  {
    if (this.atl != 0L)
    {
      deleteCodec(this.atl);
      if ((this.costTime > 0L) && (this.dZX > 0))
      {
        if (!this.cUE) {
          break label62;
        }
        aomq.c(this.costTime, this.dZX, this.atm, 0);
      }
    }
    for (;;)
    {
      this.atl = 0L;
      return;
      label62:
      aomq.c(this.costTime, this.dZX, this.atm, 1);
    }
  }
  
  public native int encode(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt);
  
  public void init(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    super.init(paramInt1, paramInt2, paramInt3);
    try
    {
      if (this.cUE) {}
      for (this.atl = SilkEncoderNew(paramInt1, paramInt2);; this.atl = SilkDecoderNew(paramInt1, paramInt2))
      {
        this.duG = aqlv.kg(paramInt1);
        this.fh = new byte[this.duG];
        this.fi = new byte[this.duG];
        this.fj = new byte[this.duG];
        this.jdField_a_of_type_Aliv$a = new aliv.a(this.fj, 0);
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SilkCodecWrapper", 2, "init silk codec =" + localUnsatisfiedLinkError.toString());
        }
        this.atl = 0L;
        soLoaded = false;
      }
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.atl == 0L) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaIoPipedInputStream.read(this.fh, 0, this.duG) == -1) {
      return -1;
    }
    if (this.cUE) {
      this.count = encode(this.atl, this.fh, this.fi, this.duG);
    }
    aqlv.a(this.count, paramArrayOfByte, paramInt1);
    System.arraycopy(this.fi, 0, paramArrayOfByte, paramInt1 + 2, this.count);
    return this.count + 2;
  }
  
  public void release()
    throws IOException
  {
    super.release();
    eer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SilkCodecWrapper
 * JD-Core Version:    0.7.0.1
 */