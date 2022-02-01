package com.tencent.litetransfersdk;

import ahaf;
import android.os.Handler;
import android.os.Looper;
import aomi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import dj;
import dj.a;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class LiteTransferWrapper
{
  static final int Business_ID_C2C = 3;
  static final int Business_ID_DataLine = 38;
  static final int Business_ID_Disc = 106;
  static final int Business_ID_Group = 102;
  public static final String sTagName = "dataline.LiteTTransferWrapper";
  private LiteTransferListenerCallback mListener;
  private long mLiteTransferOperator;
  private LiteTransferOperatorCallback mOperator;
  
  static
  {
    try
    {
      SoLoadUtil.loadNativeLibrary(BaseApplicationImpl.getContext(), "xplatform", 0, false);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        try
        {
          SoLoadUtil.loadNativeLibrary(BaseApplicationImpl.getContext(), "litetransfer", 0, false);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          localUnsatisfiedLinkError2.printStackTrace();
        }
        localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
        localUnsatisfiedLinkError1.printStackTrace();
      }
    }
  }
  
  public LiteTransferWrapper(LiteTransferOperatorCallback paramLiteTransferOperatorCallback, LiteTransferListenerCallback paramLiteTransferListenerCallback)
  {
    this.mOperator = paramLiteTransferOperatorCallback;
    this.mListener = paramLiteTransferListenerCallback;
    this.mLiteTransferOperator = 0L;
  }
  
  public static void OnLog(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    do
    {
      try
      {
        paramArrayOfByte1 = new String(paramArrayOfByte1, "UTF-8");
        paramArrayOfByte2 = new String(paramArrayOfByte2, "UTF-8");
        if ((paramInt == 0) || (paramInt == 1))
        {
          QLog.d(paramArrayOfByte1, 1, paramArrayOfByte2);
          return;
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte1)
      {
        do
        {
          paramArrayOfByte1.printStackTrace();
        } while (!QLog.isDevelopLevel());
        QLog.e("dataline.LiteTTransferWrapper", 4, "native log encoding utf8 failed");
        return;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d(paramArrayOfByte1, 4, paramArrayOfByte2);
  }
  
  public static long getCurrentMillisTime()
  {
    return NetConnInfoCenter.getServerTimeMillis();
  }
  
  public static int getNetType()
  {
    return aomi.a().getNetType();
  }
  
  public void CancelAll(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "CancelAll " + this.mLiteTransferOperator);
    }
    if (this.mLiteTransferOperator == 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.LiteTTransferWrapper", 2, "CancelAll mLiteTransferOperator is 0, maybe not inited, so has nothing to cancel");
      }
    }
    do
    {
      return;
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread())
      {
        new Handler(localLooper).post(new LiteTransferWrapper.3(this, paramInt, paramBoolean));
        return;
      }
    } while (this.mLiteTransferOperator == 0L);
    CancelAllToJNI(this.mLiteTransferOperator, paramInt, paramBoolean);
  }
  
  public native void CancelAllToJNI(long paramLong, int paramInt, boolean paramBoolean);
  
  public void CancelGroup(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "CancelGroup " + this.mLiteTransferOperator);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new LiteTransferWrapper.7(this, paramInt1, paramLong, paramInt2, paramBoolean));
    }
    while (this.mLiteTransferOperator == 0L) {
      return;
    }
    CancelGroupToJNI(this.mLiteTransferOperator, paramInt1, paramLong, paramInt2, paramBoolean);
  }
  
  public native void CancelGroupToJNI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, boolean paramBoolean);
  
  public native void DoGetThumbFilePathReplyToJNI(long paramLong, int paramInt, String paramString);
  
  public native void DoPbMsgReplyToJNI(long paramLong, int paramInt, MsgSCBody paramMsgSCBody);
  
  public void OnGetThumbFilePathReply(int paramInt, String paramString)
  {
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new LiteTransferWrapper.8(this, paramInt, paramString));
    }
    while (this.mLiteTransferOperator == 0L) {
      return;
    }
    DoGetThumbFilePathReplyToJNI(this.mLiteTransferOperator, paramInt, paramString);
  }
  
  public void OnPbMsgReceive(MsgCSBody paramMsgCSBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "_PbMsgRecive " + this.mLiteTransferOperator);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new LiteTransferWrapper.10(this, paramMsgCSBody));
    }
    while (this.mLiteTransferOperator == 0L) {
      return;
    }
    PbMsgReciveToJNI(this.mLiteTransferOperator, paramMsgCSBody);
  }
  
  public void OnPbMsgReply(int paramInt, MsgSCBody paramMsgSCBody)
  {
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new LiteTransferWrapper.9(this, paramInt, paramMsgSCBody));
    }
    while (this.mLiteTransferOperator == 0L) {
      return;
    }
    DoPbMsgReplyToJNI(this.mLiteTransferOperator, paramInt, paramMsgSCBody);
  }
  
  public native void PbMsgReciveToJNI(long paramLong, MsgCSBody paramMsgCSBody);
  
  public void RecvGroup(Session[] paramArrayOfSession, NFCInfo[] paramArrayOfNFCInfo, FTNInfo[] paramArrayOfFTNInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "RecvGroup " + this.mLiteTransferOperator);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new LiteTransferWrapper.6(this, paramArrayOfSession, paramArrayOfNFCInfo, paramArrayOfFTNInfo, paramBoolean));
    }
    while (this.mLiteTransferOperator == 0L) {
      return;
    }
    SetProxyToJni();
    RecvGroupToJNI(this.mLiteTransferOperator, paramArrayOfSession, paramArrayOfNFCInfo, paramArrayOfFTNInfo, paramBoolean);
  }
  
  public native void RecvGroupToJNI(long paramLong, Session[] paramArrayOfSession, NFCInfo[] paramArrayOfNFCInfo, FTNInfo[] paramArrayOfFTNInfo, boolean paramBoolean);
  
  public void SendGroup(ArrayList<Session> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new LiteTransferWrapper.5(this, paramArrayList, paramBoolean1, paramBoolean2));
    }
    while (this.mLiteTransferOperator == 0L) {
      return;
    }
    SetProxyToJni();
    SendGroupToJNI(this.mLiteTransferOperator, (Session[])paramArrayList.toArray(new Session[paramArrayList.size()]), paramBoolean1, paramBoolean2);
  }
  
  public native void SendGroupToJNI(long paramLong, Session[] paramArrayOfSession, boolean paramBoolean1, boolean paramBoolean2);
  
  public native void SetBusinessID(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void SetDefaultPath(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "SetDefaultPath " + paramString);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new LiteTransferWrapper.11(this, paramString));
    }
    while (this.mLiteTransferOperator == 0L) {
      return;
    }
    SetDefaultPathToJNI(this.mLiteTransferOperator, paramString);
  }
  
  public native void SetDefaultPathToJNI(long paramLong, String paramString);
  
  public void SetProxyToJni()
  {
    dj.a locala = dj.a();
    if (locala != null) {
      try
      {
        setGlobalProxyInfo(1, locala.host, (short)locala.port, "", "");
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        localUnsatisfiedLinkError1.printStackTrace();
        return;
      }
    }
    try
    {
      setGlobalProxyInfo(0, "", (short)0, "", "");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      localUnsatisfiedLinkError2.printStackTrace();
    }
  }
  
  public void SetServicePath(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "SetServicePath " + paramString1);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new LiteTransferWrapper.13(this, paramString1, paramString2));
    }
    while (this.mLiteTransferOperator == 0L) {
      return;
    }
    SetServicePathToJNI(this.mLiteTransferOperator, paramString1, paramString2);
  }
  
  public native void SetServicePathToJNI(long paramLong, String paramString1, String paramString2);
  
  public void SetTempPath(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "SetTempPath " + paramString);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new LiteTransferWrapper.14(this, paramString));
    }
    while (this.mLiteTransferOperator == 0L) {
      return;
    }
    SetTempPathToJNI(this.mLiteTransferOperator, paramString);
  }
  
  public native void SetTempPathToJNI(long paramLong, String paramString);
  
  public void SetThumbPath(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "SetThumbPath " + paramString);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new LiteTransferWrapper.12(this, paramString));
    }
    while (this.mLiteTransferOperator == 0L) {
      return;
    }
    SetThumbPathToJNI(this.mLiteTransferOperator, paramString);
  }
  
  public native void SetThumbPathToJNI(long paramLong, String paramString);
  
  public void SetThumbTempPath(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTTransferWrapper", 2, "SetThumbTempPath " + paramString);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new LiteTransferWrapper.15(this, paramString));
    }
    while (this.mLiteTransferOperator == 0L) {
      return;
    }
    SetThumbTempPathToJNI(this.mLiteTransferOperator, paramString);
  }
  
  public native void SetThumbTempPathToJNI(long paramLong, String paramString);
  
  public void SyncGroup(Session[] paramArrayOfSession)
  {
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new LiteTransferWrapper.4(this, paramArrayOfSession));
    }
    while (this.mLiteTransferOperator == 0L) {
      return;
    }
    SyncGroupToJNI(this.mLiteTransferOperator, paramArrayOfSession);
  }
  
  public native void SyncGroupToJNI(long paramLong, Session[] paramArrayOfSession);
  
  public void beginLiteTransfer()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new LiteTransferWrapper.1(this));
    }
    do
    {
      do
      {
        return;
        if ((this.mOperator != null) && (this.mListener != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("dataline.LiteTTransferWrapper", 2, "litetransfer callback is null, do nothing");
      return;
    } while (this.mLiteTransferOperator != 0L);
    try
    {
      this.mLiteTransferOperator = createOperator(this.mOperator, this.mListener);
      SetBusinessID(38, 3, 106, 102);
      QLog.i("dataline.LiteTTransferWrapper", 1, "createOperator mLiteTransferOperator:" + this.mLiteTransferOperator + " threadId:" + Thread.currentThread().getId());
      checkPathExist();
      SetProxyToJni();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public void checkPathExist()
  {
    try
    {
      File localFile = new File(ahaf.a().vZ());
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      SetDefaultPath(ahaf.a().vZ());
      localFile = new File(ahaf.a().wb());
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      SetThumbPath(ahaf.a().wb());
      localFile = new File(ahaf.a().wa());
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      SetTempPath(ahaf.a().wa());
      localFile = new File(ahaf.a().wa());
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      SetThumbTempPath(ahaf.a().wa());
      return;
    }
    catch (Exception localException) {}
  }
  
  public void checkTransferAlive()
  {
    if (this.mLiteTransferOperator == 0L) {
      beginLiteTransfer();
    }
  }
  
  public native long createOperator(LiteTransferOperatorCallback paramLiteTransferOperatorCallback, LiteTransferListenerCallback paramLiteTransferListenerCallback);
  
  public native void destryOperator(long paramLong, boolean paramBoolean);
  
  public void endLiteTransfer(boolean paramBoolean)
  {
    if (this.mLiteTransferOperator == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.LiteTTransferWrapper", 2, "endLiteTransfer mLiteTransferOperator is 0, maybe not inited, so has nothing to cancel");
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new LiteTransferWrapper.2(this, paramBoolean));
      return;
    }
    try
    {
      if (this.mLiteTransferOperator != 0L)
      {
        QLog.i("dataline.LiteTTransferWrapper", 1, "destryOperator mLiteTransferOperator:" + this.mLiteTransferOperator + " threadId:" + Thread.currentThread().getId());
        long l = this.mLiteTransferOperator;
        this.mLiteTransferOperator = 0L;
        destryOperator(l, paramBoolean);
      }
      this.mOperator = null;
      this.mListener = null;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("dataline.LiteTTransferWrapper", 2, "cannot endLiteTransfer, load litetranfer library error?" + QLog.getStackTraceString(localUnsatisfiedLinkError));
        }
      }
    }
  }
  
  public native int generateGroupID();
  
  public native long generateSessionID(int paramInt);
  
  public native long generateSessionIDByDev(int paramInt1, int paramInt2);
  
  public native long generateTaskID(long paramLong, byte paramByte);
  
  public native long initGlobalFunc();
  
  public native void setGlobalProxyInfo(int paramInt, String paramString1, short paramShort, String paramString2, String paramString3);
  
  public native void setWanIP(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper
 * JD-Core Version:    0.7.0.1
 */