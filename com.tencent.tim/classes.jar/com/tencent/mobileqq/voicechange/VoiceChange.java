package com.tencent.mobileqq.voicechange;

import alij;
import aliv.a;
import alix;
import android.content.Context;
import android.os.SystemClock;
import aomq;
import aqlv;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.PipedInputStream;

public class VoiceChange
  extends alix
{
  private static boolean cWO;
  private long atm;
  private int changeType;
  private long costTime;
  private int dZX;
  private int edx;
  private String mSoPath;
  
  public VoiceChange(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
    if (!cWO)
    {
      alij.X(paramContext, "codecsilk");
      cWO = true;
    }
    this.changeType = paramInt;
    try
    {
      this.mSoPath = new File(paramString).getCanonicalPath();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public native int Create(String paramString);
  
  public native int Init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native int Release(int paramInt);
  
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
  
  public native int doChange(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public void init(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    int i = -1;
    super.init(paramInt1, paramInt2, paramInt3);
    this.costTime = 0L;
    this.dZX = 0;
    this.atm = 0L;
    this.duG = aqlv.kg(paramInt1);
    this.edx = Create(this.mSoPath);
    if (this.edx == 0) {
      QLog.e("QQVoiceChanger", 1, "Create voiceChanger error with:" + this.mSoPath);
    }
    if (this.changeType == 1)
    {
      paramInt2 = 1;
      paramInt3 = i;
    }
    for (;;)
    {
      Init(this.edx, paramInt1, 1, paramInt2, paramInt3);
      this.fh = new byte[this.duG];
      this.fi = new byte[this.duG * 10];
      this.fj = new byte[this.fi.length * 2];
      this.jdField_a_of_type_Aliv$a = new aliv.a(this.fj, 0);
      return;
      if (this.changeType == 2)
      {
        paramInt2 = 2;
        paramInt3 = i;
      }
      else if (this.changeType == 3)
      {
        paramInt2 = 8;
        paramInt3 = 3;
      }
      else if (this.changeType == 4)
      {
        paramInt2 = 7;
        paramInt3 = i;
      }
      else if (this.changeType == 5)
      {
        paramInt2 = -1;
        paramInt3 = 2;
      }
      else if (this.changeType == 6)
      {
        paramInt2 = 6;
        paramInt3 = i;
      }
      else if (this.changeType == 7)
      {
        paramInt2 = 10;
        paramInt3 = 4;
      }
      else if (this.changeType == 8)
      {
        paramInt2 = 10;
        paramInt3 = 20;
      }
      else if (this.changeType == 9)
      {
        paramInt2 = 11;
        paramInt3 = i;
      }
      else if (this.changeType == 10)
      {
        paramInt2 = 12;
        paramInt3 = i;
      }
      else if (this.changeType == 11)
      {
        paramInt3 = 51;
        paramInt2 = 9;
      }
      else if (this.changeType == 12)
      {
        paramInt2 = 13;
        paramInt3 = 1;
      }
      else if (this.changeType == 13)
      {
        paramInt2 = 536936433;
        paramInt3 = 50;
      }
      else if (this.changeType == 14)
      {
        paramInt2 = -1;
        paramInt3 = 5;
      }
      else if (this.changeType == 15)
      {
        paramInt2 = -1;
        paramInt3 = 9;
      }
      else if (this.changeType == 16)
      {
        paramInt2 = 13;
        paramInt3 = i;
      }
      else
      {
        QLog.e("QQVoiceChanger", 1, "Init Error type=" + this.changeType);
        paramInt3 = 0;
        paramInt2 = 0;
      }
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.jdField_a_of_type_JavaIoPipedInputStream.read(this.fh, 0, this.duG) == -1) {
      return -1;
    }
    paramInt2 = doChange(this.edx, this.fh, this.fi);
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "change voice type=" + this.changeType + " changedSize=" + paramInt2);
    }
    System.arraycopy(this.fi, 0, paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  public void release()
    throws IOException
  {
    if ((this.costTime > 0L) && (this.dZX > 0) && (this.changeType > 0)) {
      aomq.c(this.costTime, this.dZX, this.atm, this.changeType + 2);
    }
    Release(this.edx);
    this.edx = 0;
    super.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.VoiceChange
 * JD-Core Version:    0.7.0.1
 */