package com.tencent.litetransfersdk;

import android.os.Handler;
import android.os.Looper;
import bqu;
import bqv;
import bqw;
import bqx;
import bqy;
import bqz;
import bra;
import brb;
import brc;
import brd;
import bre;
import brf;
import brg;
import brh;
import bri;
import brj;
import brk;
import com.dataline.util.HttpUtil;
import com.dataline.util.HttpUtil.NetworkProxy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.ActionInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FTNNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FileControl;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.NFCNotify;

public class LiteTransferWrapper
{
  public static final String sTagName = "dataline.LiteTransferWrapper.Main";
  private DataLineHandler mHandler;
  private long mLiteTransferOperator;
  private LiteTransferListenerCallback pListenerCallback;
  private LiteTransferOperatorCallback pOperatorCallback;
  
  static
  {
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getContext(), "xplatform", 0, false);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        try
        {
          SoLoadUtil.a(BaseApplicationImpl.getContext(), "litetransfer", 0, false);
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
  
  public LiteTransferWrapper(DataLineHandler paramDataLineHandler)
  {
    this.mHandler = paramDataLineHandler;
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
        QLog.e("dataline.LiteTransferWrapper.Main", 4, "native log encoding utf8 failed");
        return;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d(paramArrayOfByte1, 4, paramArrayOfByte2);
  }
  
  private void _PbMsgRecive(MsgCSBody paramMsgCSBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "_PbMsgRecive " + this.mLiteTransferOperator);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new brb(this, paramMsgCSBody));
      return;
    }
    SetProxyToJni();
    PbMsgReciveToJNI(this.mLiteTransferOperator, paramMsgCSBody);
  }
  
  private void _convertFileComing0x210_0x2To0x211_0x2(long paramLong1, long paramLong2, long paramLong3, String paramString1, long paramLong4, byte[] paramArrayOfByte1, String paramString2, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong5, long paramLong6, long paramLong7, boolean paramBoolean)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = this.mHandler.a;
    ArrayList localArrayList = new ArrayList();
    Object localObject = localMsgCSBody.msgBody0x211.msgBody0x211_0x7;
    int i;
    if (paramArrayOfByte2 == null)
    {
      i = 9;
      ((MsgCSBody0x211_0x7)localObject).uMsgSubCmd = i;
      localObject = new FTNNotify();
      ((FTNNotify)localObject).uint64_sessionid = paramLong1;
      ((FTNNotify)localObject).str_file_name = paramString1;
      ((FTNNotify)localObject).str_file_index = paramString2;
      ((FTNNotify)localObject).bytes_file_md5 = paramArrayOfByte1;
      ((FTNNotify)localObject).uint64_file_len = paramLong4;
      ((FTNNotify)localObject).bytes_originfile_md5 = paramArrayOfByte2;
      ((FTNNotify)localObject).uint32_originfiletype = ((int)paramLong2);
      ((FTNNotify)localObject).uint32_group_id = paramInt1;
      ((FTNNotify)localObject).uint32_group_size = paramInt2;
      ((FTNNotify)localObject).uint32_group_curindex = paramInt3;
      ((FTNNotify)localObject).uint32_batchID = paramInt4;
      ((FTNNotify)localObject).msg_ActionInfo = new ActionInfo();
      localArrayList.add(localObject);
      if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd != 9) {
        break label277;
      }
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb = ((FTNNotify[])localArrayList.toArray(new FTNNotify[localArrayList.size()]));
    }
    for (;;)
    {
      _PbMsgRecive(localMsgCSBody);
      return;
      i = 1;
      break;
      label277:
      if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd == 1) {
        localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc = ((FTNNotify[])localArrayList.toArray(new FTNNotify[localArrayList.size()]));
      }
    }
  }
  
  private void _convertFileComing0x210_0xaTo0x211_0xa(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, byte[] paramArrayOfByte1, long paramLong5, long paramLong6, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong7, long paramLong8, long paramLong9, boolean paramBoolean)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = this.mHandler.a;
    ArrayList localArrayList = new ArrayList();
    Object localObject = localMsgCSBody.msgBody0x211.msgBody0x211_0x7;
    int i;
    if (paramArrayOfByte4 == null)
    {
      i = 10;
      ((MsgCSBody0x211_0x7)localObject).uMsgSubCmd = i;
      localObject = new NFCNotify();
      ((NFCNotify)localObject).uint64_sessionid = paramLong1;
      ((NFCNotify)localObject).str_file_name = paramString;
      ((NFCNotify)localObject).bytes_file_md5 = paramArrayOfByte1;
      ((NFCNotify)localObject).fixed32_ip = ((int)paramLong5);
      ((NFCNotify)localObject).uint32_port = ((int)paramLong6);
      ((NFCNotify)localObject).bytes_url_notify = paramArrayOfByte2;
      ((NFCNotify)localObject).bytes_tokenkey = paramArrayOfByte3;
      ((NFCNotify)localObject).uint64_file_len = paramLong4;
      ((NFCNotify)localObject).bytes_originfile_md5 = paramArrayOfByte4;
      ((NFCNotify)localObject).uint32_originfiletype = ((int)paramLong2);
      ((NFCNotify)localObject).uint32_group_id = paramInt1;
      ((NFCNotify)localObject).uint32_group_size = paramInt2;
      ((NFCNotify)localObject).uint32_group_curindex = paramInt3;
      ((NFCNotify)localObject).uint32_batchID = paramInt4;
      ((NFCNotify)localObject).msg_ActionInfo = new ActionInfo();
      localArrayList.add(localObject);
      if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd != 10) {
        break label318;
      }
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb = ((NFCNotify[])localArrayList.toArray(new NFCNotify[localArrayList.size()]));
    }
    for (;;)
    {
      _PbMsgRecive(localMsgCSBody);
      return;
      i = 2;
      break;
      label318:
      if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd == 2) {
        localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc = ((NFCNotify[])localArrayList.toArray(new NFCNotify[localArrayList.size()]));
      }
    }
  }
  
  private void _convertOperate0x210To0x211(long paramLong1, long paramLong2, int paramInt1, int paramInt2, short paramShort)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "uSessionID[" + paramLong1 + "]" + "onFileOpdrate: 210  operate = " + paramLong2);
    }
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = this.mHandler.a;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd = 3;
    ArrayList localArrayList = new ArrayList();
    FileControl localFileControl = new FileControl();
    localFileControl.uint64_sessionid = paramLong1;
    localFileControl.uint32_operate = ((int)paramLong2);
    localFileControl.uint32_seq = paramShort;
    localFileControl.uint32_code = 0;
    localFileControl.str_msg = null;
    localFileControl.uint32_group_id = paramInt2;
    localFileControl.uint32_group_curindex = 0;
    localFileControl.uint32_batchID = 0;
    localArrayList.add(localFileControl);
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl = ((FileControl[])localArrayList.toArray(new FileControl[localArrayList.size()]));
    _PbMsgRecive(localMsgCSBody);
  }
  
  public static long getCurrentMillisTime()
  {
    return NetConnInfoCenter.getServerTimeMillis();
  }
  
  public static int getNetType()
  {
    return NetworkCenter.a().a();
  }
  
  public void CancelAll(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "CancelAll " + this.mLiteTransferOperator);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new brh(this, paramInt));
      return;
    }
    CancelAllToJNI(this.mLiteTransferOperator, paramInt);
  }
  
  public native void CancelAllToJNI(long paramLong, int paramInt);
  
  public void CancelGroup(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "CancelGroup " + this.mLiteTransferOperator);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new bqv(this, paramInt1, paramLong, paramInt2, paramBoolean));
      return;
    }
    CancelGroupToJNI(this.mLiteTransferOperator, paramInt1, paramLong, paramInt2, paramBoolean);
  }
  
  public native void CancelGroupToJNI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, boolean paramBoolean);
  
  public void DoGetThumbFilePathReply(int paramInt, String paramString)
  {
    checkTransferAlive();
    DoGetThumbFilePathReplyToJNI(this.mLiteTransferOperator, paramInt, paramString);
  }
  
  public native void DoGetThumbFilePathReplyToJNI(long paramLong, int paramInt, String paramString);
  
  public native void DoPbMsgReplyToJNI(long paramLong, int paramInt, MsgSCBody paramMsgSCBody);
  
  public void OnFileComing210_0x2(long paramLong1, long paramLong2, long paramLong3, String paramString1, long paramLong4, byte[] paramArrayOfByte1, String paramString2, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong5, long paramLong6, long paramLong7, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "OnFileComing_0x2 ");
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new brd(this, paramLong1, paramLong2, paramLong3, paramString1, paramLong4, paramArrayOfByte1, paramString2, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4, paramLong5, paramLong6, paramLong7, paramBoolean));
      return;
    }
    _convertFileComing0x210_0x2To0x211_0x2(paramLong1, paramLong2, paramLong3, paramString1, paramLong4, paramArrayOfByte1, paramString2, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4, paramLong5, paramLong6, paramLong7, paramBoolean);
  }
  
  public boolean OnQueryAutoDownload(long paramLong, byte paramByte)
  {
    boolean bool2 = false;
    if (paramByte == 2)
    {
      boolean bool1 = NetworkUtil.g(BaseApplication.getContext());
      if (paramLong <= 5242880L) {}
      for (paramByte = 1;; paramByte = 0)
      {
        if (!bool1)
        {
          bool1 = bool2;
          if (this.mHandler.c())
          {
            bool1 = bool2;
            if (paramByte == 0) {}
          }
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
    }
    return true;
  }
  
  public native void PbMsgReciveToJNI(long paramLong, MsgCSBody paramMsgCSBody);
  
  public void RecvGroup(Session[] paramArrayOfSession, NFCInfo[] paramArrayOfNFCInfo, FTNInfo[] paramArrayOfFTNInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "RecvGroup " + this.mLiteTransferOperator);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new brk(this, paramArrayOfSession, paramArrayOfNFCInfo, paramArrayOfFTNInfo, paramBoolean));
      return;
    }
    SetProxyToJni();
    RecvGroupToJNI(this.mLiteTransferOperator, paramArrayOfSession, paramArrayOfNFCInfo, paramArrayOfFTNInfo, paramBoolean);
  }
  
  public native void RecvGroupToJNI(long paramLong, Session[] paramArrayOfSession, NFCInfo[] paramArrayOfNFCInfo, FTNInfo[] paramArrayOfFTNInfo, boolean paramBoolean);
  
  public void SendGroup(ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new brj(this, paramArrayList, paramBoolean1, paramBoolean2));
      return;
    }
    SetProxyToJni();
    SendGroupToJNI(this.mLiteTransferOperator, (Session[])paramArrayList.toArray(new Session[paramArrayList.size()]), paramBoolean1, paramBoolean2);
  }
  
  public native void SendGroupToJNI(long paramLong, Session[] paramArrayOfSession, boolean paramBoolean1, boolean paramBoolean2);
  
  public void SetDefaultPath(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "SetDefaultPath " + paramString);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new bqw(this, paramString));
      return;
    }
    SetDefaultPathToJNI(this.mLiteTransferOperator, paramString);
  }
  
  public native void SetDefaultPathToJNI(long paramLong, String paramString);
  
  public void SetProxyToJni()
  {
    HttpUtil.NetworkProxy localNetworkProxy = HttpUtil.a();
    if (localNetworkProxy != null)
    {
      setGlobalProxyInfo(1, localNetworkProxy.jdField_a_of_type_JavaLangString, (short)localNetworkProxy.jdField_a_of_type_Int, "", "");
      return;
    }
    setGlobalProxyInfo(0, "", (short)0, "", "");
  }
  
  public void SetServicePath(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "SetServicePath " + paramString1);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new bqy(this, paramString1, paramString2));
      return;
    }
    SetServicePathToJNI(this.mLiteTransferOperator, paramString1, paramString2);
  }
  
  public native void SetServicePathToJNI(long paramLong, String paramString1, String paramString2);
  
  public void SetTempPath(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "SetTempPath " + paramString);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new bqz(this, paramString));
      return;
    }
    SetTempPathToJNI(this.mLiteTransferOperator, paramString);
  }
  
  public native void SetTempPathToJNI(long paramLong, String paramString);
  
  public void SetThumbPath(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "SetThumbPath " + paramString);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new bqx(this, paramString));
      return;
    }
    SetThumbPathToJNI(this.mLiteTransferOperator, paramString);
  }
  
  public native void SetThumbPathToJNI(long paramLong, String paramString);
  
  public void SetThumbTempPath(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "SetThumbTempPath " + paramString);
    }
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new bra(this, paramString));
      return;
    }
    SetThumbTempPathToJNI(this.mLiteTransferOperator, paramString);
  }
  
  public native void SetThumbTempPathToJNI(long paramLong, String paramString);
  
  public void SyncGroup(Session[] paramArrayOfSession)
  {
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new bri(this, paramArrayOfSession));
      return;
    }
    SyncGroupToJNI(this.mLiteTransferOperator, paramArrayOfSession);
  }
  
  public native void SyncGroupToJNI(long paramLong, Session[] paramArrayOfSession);
  
  public void beginLiteTransfer()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new brf(this));
    }
    while (this.mLiteTransferOperator != 0L) {
      return;
    }
    initGlobalFuncCallback();
    this.pOperatorCallback = new LiteTransferOperatorCallback(this.mHandler);
    this.pListenerCallback = new LiteTransferListenerCallback(this.mHandler);
    this.mLiteTransferOperator = createOperator(this.pOperatorCallback, this.pListenerCallback);
    checkPathExist();
    SetProxyToJni();
  }
  
  public void checkPathExist()
  {
    File localFile = new File(AppConstants.as);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    SetDefaultPath(AppConstants.as);
    localFile = new File(AppConstants.at);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    SetThumbPath(AppConstants.at);
    localFile = new File(AppConstants.au);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    SetTempPath(AppConstants.au);
    localFile = new File(AppConstants.au);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    SetThumbTempPath(AppConstants.au);
  }
  
  public void checkTransferAlive()
  {
    if (this.mLiteTransferOperator == 0L) {
      beginLiteTransfer();
    }
  }
  
  public native long createOperator(LiteTransferOperatorCallback paramLiteTransferOperatorCallback, LiteTransferListenerCallback paramLiteTransferListenerCallback);
  
  public native void destryOperator(long paramLong);
  
  public void doPbMsgReply(int paramInt, MsgSCBody paramMsgSCBody)
  {
    checkTransferAlive();
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new brc(this, paramInt, paramMsgSCBody));
      return;
    }
    DoPbMsgReplyToJNI(this.mLiteTransferOperator, paramInt, paramMsgSCBody);
  }
  
  public void endLiteTransfer()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new brg(this));
      return;
    }
    if (this.mLiteTransferOperator != 0L)
    {
      destryOperator(this.mLiteTransferOperator);
      this.mLiteTransferOperator = 0L;
    }
    this.pOperatorCallback = null;
    this.pListenerCallback = null;
    releaseGlobalFuncCallback();
  }
  
  public native int generateGroupID();
  
  public native long generateSessionID(int paramInt);
  
  public native long generateTaskID(long paramLong, byte paramByte);
  
  public void handleFTNNotifyReply(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    paramObject = new MsgSCBody();
    paramObject.uMsgType = 529;
    paramObject.msgBody0x211 = new MsgSCBody0x211();
    paramObject.msgBody0x211.uMsgSubType = 7;
    paramObject.msgBody0x211.msgBody0x211_0x7 = new MsgSCBody0x211_0x7();
    paramToServiceMsg = (Long)paramToServiceMsg.getAttribute("cookie");
    MsgSCBody0x211_0x7 localMsgSCBody0x211_0x7;
    if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.LiteTransferWrapper.Main", 2, "handleFTNNotify " + paramToServiceMsg.intValue() + " 发送中转信令，发送失败");
      }
      paramObject.bTimeOut = true;
      if (paramFromServiceMsg != null)
      {
        localMsgSCBody0x211_0x7 = paramObject.msgBody0x211.msgBody0x211_0x7;
        if (!paramFromServiceMsg.isSuccess()) {
          break label206;
        }
      }
    }
    for (;;)
    {
      localMsgSCBody0x211_0x7.uResult = i;
      doPbMsgReply(paramToServiceMsg.intValue(), paramObject);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("dataline.LiteTransferWrapper.Main", 2, "handleFTNNotify " + paramToServiceMsg.intValue() + " 发送中转信令，发送成功");
      }
      paramObject.bTimeOut = false;
      break;
      label206:
      i = 1;
    }
  }
  
  public void handleFileDeleteReply(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = (Long)paramToServiceMsg.getAttribute("cookie");
    if ((this.mHandler.a(paramToServiceMsg.longValue()) == null) && (QLog.isColorLevel())) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "uSessionID[" + paramToServiceMsg + "]" + "handleFileDelete: session not found");
    }
  }
  
  public void handleFileOperateReply(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = (Long)paramToServiceMsg.getAttribute("cookie");
    if ((this.mHandler.a(paramToServiceMsg.longValue()) == null) && (QLog.isColorLevel())) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "uSessionID[" + paramToServiceMsg + "]" + "handleFileOperate: session not found");
    }
  }
  
  public void handleNFCNotifyReply(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    paramObject = new MsgSCBody();
    paramObject.uMsgType = 529;
    paramObject.msgBody0x211 = new MsgSCBody0x211();
    paramObject.msgBody0x211.uMsgSubType = 7;
    paramObject.msgBody0x211.msgBody0x211_0x7 = new MsgSCBody0x211_0x7();
    paramToServiceMsg = (Long)paramToServiceMsg.getAttribute("cookie");
    MsgSCBody0x211_0x7 localMsgSCBody0x211_0x7;
    if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.LiteTransferWrapper.Main", 2, "handleNFCNotify " + paramToServiceMsg.intValue() + " 发送近场信令，发送失败");
      }
      paramObject.bTimeOut = true;
      if (paramFromServiceMsg != null)
      {
        localMsgSCBody0x211_0x7 = paramObject.msgBody0x211.msgBody0x211_0x7;
        if (!paramFromServiceMsg.isSuccess()) {
          break label206;
        }
      }
    }
    for (;;)
    {
      localMsgSCBody0x211_0x7.uResult = i;
      doPbMsgReply(paramToServiceMsg.intValue(), paramObject);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("dataline.LiteTransferWrapper.Main", 2, "handleNFCNotify " + paramToServiceMsg.intValue() + " 发送近场信令，发送成功");
      }
      paramObject.bTimeOut = false;
      break;
      label206:
      i = 1;
    }
  }
  
  public void handleRecvFileReply(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "handleRecvFile, receive pbmsg from msf");
    }
    paramFromServiceMsg = this.pOperatorCallback.handleMsgBody0x346_0xe_Rsp(paramToServiceMsg, paramFromServiceMsg, paramObject);
    doPbMsgReply(((Integer)paramToServiceMsg.getAttribute("cookie")).intValue(), paramFromServiceMsg);
  }
  
  public void handleSendFileReply(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = this.pOperatorCallback.handleMsgBody0x346_0x7_Rsp(paramToServiceMsg, paramFromServiceMsg, paramObject);
    paramToServiceMsg = (Integer)paramToServiceMsg.getAttribute("cookie");
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "handleSendFile, receive pbmsg from msf, cookie" + paramToServiceMsg.intValue());
    }
    doPbMsgReply(paramToServiceMsg.intValue(), paramFromServiceMsg);
  }
  
  public native void initGlobalFuncCallback();
  
  public void onFileComing0x211_0x1_0x9(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList, boolean paramBoolean)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = paramMsgHeader.uint32_src_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = paramMsgHeader.uint32_src_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_app_id = paramMsgHeader.uint32_dst_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_inst_id = paramMsgHeader.uint32_dst_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = paramMsgHeader.uint64_dst_uin.get();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SubMsgType0x7.MsgBody.FTNNotify localFTNNotify = (SubMsgType0x7.MsgBody.FTNNotify)paramList.next();
      if (localFTNNotify.uint64_sessionid.has())
      {
        paramMsgHeader = localMsgCSBody.msgBody0x211.msgBody0x211_0x7;
        label241:
        FTNNotify localFTNNotify1;
        if (paramBoolean)
        {
          i = 9;
          paramMsgHeader.uMsgSubCmd = i;
          localFTNNotify1 = new FTNNotify();
          localFTNNotify1.uint64_sessionid = localFTNNotify.uint64_sessionid.get();
          localFTNNotify1.str_file_name = localFTNNotify.str_file_name.get();
          localFTNNotify1.str_file_index = localFTNNotify.str_file_index.get();
          localFTNNotify1.bytes_file_md5 = localFTNNotify.bytes_file_md5.get().toByteArray();
          localFTNNotify1.uint64_file_len = localFTNNotify.uint64_file_len.get();
          if (!paramBoolean) {
            break label757;
          }
          paramMsgHeader = null;
          label330:
          localFTNNotify1.bytes_originfile_md5 = paramMsgHeader;
          localFTNNotify1.uint32_originfiletype = localFTNNotify.uint32_originfiletype.get();
          if (!localFTNNotify.uint32_group_id.has()) {
            break label772;
          }
          i = localFTNNotify.uint32_group_id.get();
          label370:
          localFTNNotify1.uint32_group_id = i;
          if (!localFTNNotify.uint32_group_size.has()) {
            break label778;
          }
          i = localFTNNotify.uint32_group_size.get();
          label398:
          localFTNNotify1.uint32_group_size = i;
          if (!localFTNNotify.uint32_group_curindex.has()) {
            break label784;
          }
          i = localFTNNotify.uint32_group_curindex.get();
          label426:
          localFTNNotify1.uint32_group_curindex = i;
          localFTNNotify1.msg_ActionInfo = new ActionInfo();
          ActionInfo localActionInfo = localFTNNotify1.msg_ActionInfo;
          if (!localFTNNotify.msg_ActionInfo.has()) {
            break label790;
          }
          paramMsgHeader = ((SubMsgType0x7.MsgBody.ActionInfo)localFTNNotify.msg_ActionInfo.get()).str_service_name.get();
          label481:
          localActionInfo.strServiceName = paramMsgHeader;
          localActionInfo = localFTNNotify1.msg_ActionInfo;
          if (!localFTNNotify.msg_ActionInfo.has()) {
            break label795;
          }
          paramMsgHeader = ((SubMsgType0x7.MsgBody.ActionInfo)localFTNNotify.msg_ActionInfo.get()).bytes_buf.get().toByteArray();
          label526:
          localActionInfo.vServiceInfo = paramMsgHeader;
          if (!localFTNNotify.uint32_batchID.has()) {
            break label800;
          }
          i = localFTNNotify.uint32_batchID.get();
          label553:
          localFTNNotify1.uint32_batchID = i;
          if (!localFTNNotify.uint32_groupflag.has()) {
            break label806;
          }
        }
        label772:
        label778:
        label784:
        label790:
        label795:
        label800:
        label806:
        for (int i = localFTNNotify.uint32_groupflag.get();; i = 0)
        {
          localFTNNotify1.uint32_groupflag = i;
          localArrayList.add(localFTNNotify1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("dataline.LiteTransferWrapper.Main", 2, "onFileComing0x211_0x1_0x9, 中转信令[" + paramBoolean + "]; sessionid[" + localFTNNotify1.uint64_sessionid + "]; curindex[" + localFTNNotify1.uint32_group_curindex + "]; group_id[" + localFTNNotify1.uint32_group_id + "]; group_size[" + localFTNNotify1.uint32_group_size + "]; batchID[" + localFTNNotify1.uint32_batchID + "]; groupflag[" + localFTNNotify1.uint32_groupflag + "]; file_name[" + localFTNNotify1.str_file_name + "]; file_len[" + localFTNNotify1.uint64_file_len + "];");
          break;
          i = 1;
          break label241;
          label757:
          paramMsgHeader = localFTNNotify.bytes_originfile_md5.get().toByteArray();
          break label330;
          i = 0;
          break label370;
          i = 0;
          break label398;
          i = 0;
          break label426;
          paramMsgHeader = null;
          break label481;
          paramMsgHeader = null;
          break label526;
          i = 0;
          break label553;
        }
      }
    }
    if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd == 9) {
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb = ((FTNNotify[])localArrayList.toArray(new FTNNotify[localArrayList.size()]));
    }
    for (;;)
    {
      _PbMsgRecive(localMsgCSBody);
      return;
      if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd == 1) {
        localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc = ((FTNNotify[])localArrayList.toArray(new FTNNotify[localArrayList.size()]));
      }
    }
  }
  
  public void onFileComing0x211_0x2_0xa(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList, boolean paramBoolean)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = paramMsgHeader.uint32_src_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = paramMsgHeader.uint32_src_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_app_id = paramMsgHeader.uint32_dst_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_inst_id = paramMsgHeader.uint32_dst_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = paramMsgHeader.uint64_dst_uin.get();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SubMsgType0x7.MsgBody.NFCNotify localNFCNotify = (SubMsgType0x7.MsgBody.NFCNotify)paramList.next();
      if (localNFCNotify.uint64_sessionid.has())
      {
        paramMsgHeader = localMsgCSBody.msgBody0x211.msgBody0x211_0x7;
        label241:
        NFCNotify localNFCNotify1;
        if (paramBoolean)
        {
          i = 10;
          paramMsgHeader.uMsgSubCmd = i;
          localNFCNotify1 = new NFCNotify();
          localNFCNotify1.uint64_sessionid = localNFCNotify.uint64_sessionid.get();
          localNFCNotify1.str_file_name = localNFCNotify.str_file_name.get();
          localNFCNotify1.bytes_file_md5 = localNFCNotify.bytes_file_md5.get().toByteArray();
          localNFCNotify1.fixed32_ip = localNFCNotify.fixed32_ip.get();
          localNFCNotify1.uint32_port = localNFCNotify.uint32_port.get();
          localNFCNotify1.bytes_url_notify = localNFCNotify.bytes_url_notify.get().toByteArray();
          localNFCNotify1.bytes_tokenkey = localNFCNotify.bytes_tokenkey.get().toByteArray();
          localNFCNotify1.uint64_file_len = localNFCNotify.uint64_file_len.get();
          if (!paramBoolean) {
            break label802;
          }
          paramMsgHeader = null;
          label375:
          localNFCNotify1.bytes_originfile_md5 = paramMsgHeader;
          localNFCNotify1.uint32_originfiletype = localNFCNotify.uint32_originfiletype.get();
          if (!localNFCNotify.uint32_group_id.has()) {
            break label817;
          }
          i = localNFCNotify.uint32_group_id.get();
          label415:
          localNFCNotify1.uint32_group_id = i;
          if (!localNFCNotify.uint32_group_size.has()) {
            break label823;
          }
          i = localNFCNotify.uint32_group_size.get();
          label443:
          localNFCNotify1.uint32_group_size = i;
          if (!localNFCNotify.uint32_group_curindex.has()) {
            break label829;
          }
          i = localNFCNotify.uint32_group_curindex.get();
          label471:
          localNFCNotify1.uint32_group_curindex = i;
          localNFCNotify1.msg_ActionInfo = new ActionInfo();
          ActionInfo localActionInfo = localNFCNotify1.msg_ActionInfo;
          if (!localNFCNotify.msg_ActionInfo.has()) {
            break label835;
          }
          paramMsgHeader = ((SubMsgType0x7.MsgBody.ActionInfo)localNFCNotify.msg_ActionInfo.get()).str_service_name.get();
          label526:
          localActionInfo.strServiceName = paramMsgHeader;
          localActionInfo = localNFCNotify1.msg_ActionInfo;
          if (!localNFCNotify.msg_ActionInfo.has()) {
            break label840;
          }
          paramMsgHeader = ((SubMsgType0x7.MsgBody.ActionInfo)localNFCNotify.msg_ActionInfo.get()).bytes_buf.get().toByteArray();
          label571:
          localActionInfo.vServiceInfo = paramMsgHeader;
          if (!localNFCNotify.uint32_batchID.has()) {
            break label845;
          }
          i = localNFCNotify.uint32_batchID.get();
          label598:
          localNFCNotify1.uint32_batchID = i;
          if (!localNFCNotify.uint32_groupflag.has()) {
            break label851;
          }
        }
        label802:
        label817:
        label823:
        label829:
        label835:
        label840:
        label845:
        label851:
        for (int i = localNFCNotify.uint32_groupflag.get();; i = 0)
        {
          localNFCNotify1.uint32_groupflag = i;
          localArrayList.add(localNFCNotify1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("dataline.LiteTransferWrapper.Main", 2, "onFileComing0x211_0xa_0x2, 近场信令[" + paramBoolean + "]; sessionid[" + localNFCNotify1.uint64_sessionid + "]; curindex[" + localNFCNotify1.uint32_group_curindex + "]; group_id[" + localNFCNotify1.uint32_group_id + "]; group_size[" + localNFCNotify1.uint32_group_size + "]; batchID[" + localNFCNotify1.uint32_batchID + "]; groupflag[" + localNFCNotify1.uint32_groupflag + "]; file_name[" + localNFCNotify1.str_file_name + "]; file_len[" + localNFCNotify1.uint64_file_len + "];");
          break;
          i = 2;
          break label241;
          paramMsgHeader = localNFCNotify.bytes_originfile_md5.get().toByteArray();
          break label375;
          i = 0;
          break label415;
          i = 0;
          break label443;
          i = 0;
          break label471;
          paramMsgHeader = null;
          break label526;
          paramMsgHeader = null;
          break label571;
          i = 0;
          break label598;
        }
      }
    }
    if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd == 10) {
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb = ((NFCNotify[])localArrayList.toArray(new NFCNotify[localArrayList.size()]));
    }
    for (;;)
    {
      _PbMsgRecive(localMsgCSBody);
      return;
      if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd == 2) {
        localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc = ((NFCNotify[])localArrayList.toArray(new NFCNotify[localArrayList.size()]));
      }
    }
  }
  
  public void onFileComing210_0xa(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, byte[] paramArrayOfByte1, long paramLong5, long paramLong6, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong7, long paramLong8, long paramLong9, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferWrapper.Main", 2, "onFileComing_0xa ");
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new bre(this, paramLong1, paramLong2, paramLong3, paramString, paramLong4, paramArrayOfByte1, paramLong5, paramLong6, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramInt1, paramInt2, paramInt3, paramInt4, paramLong7, paramLong8, paramLong9, paramBoolean));
      return;
    }
    _convertFileComing0x210_0xaTo0x211_0xa(paramLong1, paramLong2, paramLong3, paramString, paramLong4, paramArrayOfByte1, paramLong5, paramLong6, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramInt1, paramInt2, paramInt3, paramInt4, paramLong7, paramLong8, paramLong9, paramBoolean);
  }
  
  public void onFileOperate0x210(long paramLong1, long paramLong2, int paramInt1, int paramInt2, short paramShort)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new bqu(this, paramLong1, paramLong2, paramInt1, paramInt2, paramShort));
      return;
    }
    _convertOperate0x210To0x211(paramLong1, paramLong2, paramInt1, paramInt2, paramShort);
  }
  
  public void onFileOperate0x211(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd = 3;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = paramMsgHeader.uint32_src_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = paramMsgHeader.uint32_src_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_app_id = paramMsgHeader.uint32_dst_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_inst_id = paramMsgHeader.uint32_dst_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = paramMsgHeader.uint64_dst_uin.get();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SubMsgType0x7.MsgBody.FileControl localFileControl = (SubMsgType0x7.MsgBody.FileControl)paramList.next();
      if ((localFileControl.uint64_sessionid.has()) && (localFileControl.uint32_operate.has()))
      {
        FileControl localFileControl1 = new FileControl();
        localFileControl1.uint64_sessionid = localFileControl.uint64_sessionid.get();
        localFileControl1.uint32_operate = localFileControl.uint32_operate.get();
        if (localFileControl.uint32_seq.has())
        {
          i = localFileControl.uint32_seq.get();
          label302:
          localFileControl1.uint32_seq = i;
          if (!localFileControl.uint32_code.has()) {
            break label554;
          }
          i = localFileControl.uint32_code.get();
          label328:
          localFileControl1.uint32_code = i;
          if (!localFileControl.str_msg.has()) {
            break label559;
          }
          paramMsgHeader = localFileControl.str_msg.get();
          label354:
          localFileControl1.str_msg = paramMsgHeader;
          if (!localFileControl.uint32_group_id.has()) {
            break label564;
          }
          i = localFileControl.uint32_group_id.get();
          label380:
          localFileControl1.uint32_group_id = i;
          if (!localFileControl.uint32_group_curindex.has()) {
            break label569;
          }
          i = localFileControl.uint32_group_curindex.get();
          label406:
          localFileControl1.uint32_group_curindex = i;
          if (!localFileControl.uint32_batchID.has()) {
            break label574;
          }
        }
        label554:
        label559:
        label564:
        label569:
        label574:
        for (int i = localFileControl.uint32_batchID.get();; i = 0)
        {
          localFileControl1.uint32_batchID = i;
          localArrayList.add(localFileControl1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("dataline.LiteTransferWrapper.Main", 2, "onFileOperate0x211, 控制信令, sessionid[" + localFileControl1.uint64_sessionid + "]; curindex[" + localFileControl1.uint32_group_curindex + "]; group_id[" + localFileControl1.uint32_group_id + "]; batchID[" + localFileControl1.uint32_batchID + "]; operate[" + localFileControl1.uint32_operate + "];");
          break;
          i = 0;
          break label302;
          i = 0;
          break label328;
          paramMsgHeader = null;
          break label354;
          i = 0;
          break label380;
          i = 0;
          break label406;
        }
      }
    }
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl = ((FileControl[])localArrayList.toArray(new FileControl[localArrayList.size()]));
    _PbMsgRecive(localMsgCSBody);
  }
  
  public boolean recvGroup(List paramList, boolean paramBoolean)
  {
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    Object localObject2 = null;
    Object localObject3 = null;
    paramList = (List)localObject1;
    if (localIterator.hasNext())
    {
      localObject1 = (Long)localIterator.next();
      DataLineMsgRecord localDataLineMsgRecord = this.mHandler.a().a().b(((Long)localObject1).longValue());
      if (localDataLineMsgRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("dataline.LiteTransferWrapper.Main", 2, "uSessionID[" + localObject1 + "]" + "prepareMsg: session not found");
        }
        return false;
      }
      if ((localDataLineMsgRecord.filename == null) || (localDataLineMsgRecord.filesize == 0L) || (localDataLineMsgRecord.md5 == null)) {
        return false;
      }
      Object localObject4 = this.mHandler.a(localDataLineMsgRecord.sessionid);
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new ArrayList();
      }
      ((List)localObject1).add(localObject4);
      localObject4 = new FTNInfo();
      ((FTNInfo)localObject4).strFileIndex = localDataLineMsgRecord.serverPath;
      localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = new ArrayList();
      }
      ((List)localObject3).add(localObject4);
      localObject2 = new NFCInfo();
      ((NFCInfo)localObject2).dwServerIP = ((int)localDataLineMsgRecord.nServerIp);
      ((NFCInfo)localObject2).wServerPort = ((short)(int)localDataLineMsgRecord.nServerPort);
      ((NFCInfo)localObject2).vTokenKey = localDataLineMsgRecord.vTokenKey;
      ((NFCInfo)localObject2).vUrlNotify = localDataLineMsgRecord.vUrlNotify;
      if (paramList != null) {
        break label385;
      }
      paramList = new ArrayList();
    }
    label385:
    for (;;)
    {
      paramList.add(localObject2);
      localObject2 = localObject3;
      localObject3 = localObject1;
      break;
      if (localObject3 != null) {
        RecvGroup((Session[])((List)localObject3).toArray(new Session[((List)localObject3).size()]), (NFCInfo[])paramList.toArray(new NFCInfo[paramList.size()]), (FTNInfo[])((List)localObject2).toArray(new FTNInfo[((List)localObject2).size()]), paramBoolean);
      }
      return true;
    }
  }
  
  public native void releaseGlobalFuncCallback();
  
  public native void setGlobalProxyInfo(int paramInt, String paramString1, short paramShort, String paramString2, String paramString3);
  
  public native void setWanIP(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper
 * JD-Core Version:    0.7.0.1
 */