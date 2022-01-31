package com.tencent.litetransfersdk;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import bqo;
import bqp;
import bqq;
import bqr;
import bqs;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class LiteTransferListenerCallback
{
  public static final String sTagName = "dataline.LiteTransferListenerCallback.Main";
  private DataLineHandler mHandler;
  private int msgItemImageHeight;
  private int msgItemImageWidth;
  
  public LiteTransferListenerCallback(DataLineHandler paramDataLineHandler)
  {
    this.mHandler = paramDataLineHandler;
    this.msgItemImageWidth = BaseApplication.getContext().getResources().getDimensionPixelSize(2131427365);
    this.msgItemImageHeight = BaseApplication.getContext().getResources().getDimensionPixelSize(2131427366);
  }
  
  private void _onSessionComplete(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferListenerCallback.Main", 2, "uSessionID[" + paramLong + "]" + "OnSessionComplete, Session结束, emTaskStatus[" + paramInt + "];");
    }
    DataLineMsgRecord localDataLineMsgRecord = this.mHandler.a().a().b(paramLong);
    if (localDataLineMsgRecord != null)
    {
      if (!localDataLineMsgRecord.isSend()) {
        break label385;
      }
      if (paramInt == 2)
      {
        this.mHandler.b(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Float.valueOf(1.0F) });
        localDataLineMsgRecord.fileMsgStatus = 0L;
        this.mHandler.a().a().c(localDataLineMsgRecord.msgId);
        this.mHandler.a.a().g();
        this.mHandler.a().a().a(localDataLineMsgRecord.msgId);
        this.mHandler.b(2, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      }
    }
    else
    {
      return;
    }
    if ((paramInt == 32) || (paramInt == 11) || (paramInt == 8))
    {
      localDataLineMsgRecord.fileMsgStatus = 2L;
      this.mHandler.a().a().c(localDataLineMsgRecord.msgId);
      this.mHandler.a().a().b(localDataLineMsgRecord.msgId);
      this.mHandler.b(2, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      return;
    }
    localDataLineMsgRecord.fileMsgStatus = 0L;
    this.mHandler.a().a().c(localDataLineMsgRecord.msgId);
    this.mHandler.a().a().b(localDataLineMsgRecord.msgId);
    this.mHandler.b(2, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
    return;
    label385:
    if (paramInt == 2)
    {
      this.mHandler.b(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Float.valueOf(1.0F) });
      localDataLineMsgRecord.fileMsgStatus = 0L;
      this.mHandler.a().a().c(localDataLineMsgRecord.msgId);
      this.mHandler.a().a().a(localDataLineMsgRecord.msgId);
      this.mHandler.a.a().g();
      this.mHandler.b(3, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      return;
    }
    if ((paramInt == 32) || (paramInt == 11) || (paramInt == 8))
    {
      localDataLineMsgRecord.fileMsgStatus = 2L;
      this.mHandler.a().a().c(localDataLineMsgRecord.msgId);
      this.mHandler.a().a().b(localDataLineMsgRecord.msgId);
      this.mHandler.b(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      return;
    }
    localDataLineMsgRecord.fileMsgStatus = 0L;
    this.mHandler.a().a().c(localDataLineMsgRecord.msgId);
    this.mHandler.a().a().b(localDataLineMsgRecord.msgId);
    this.mHandler.b(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
  }
  
  private void _onSessionProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 == 0L) {}
    for (float f = 0.0F;; f = (float)paramLong2 / (float)paramLong3)
    {
      DataLineMsgRecord localDataLineMsgRecord = this.mHandler.a().a().b(paramLong1);
      if (localDataLineMsgRecord != null) {
        localDataLineMsgRecord.progress = f;
      }
      this.mHandler.b(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong1), Float.valueOf(f) });
      return;
    }
  }
  
  private void _onSessionThumbUpdate(long paramLong, String paramString)
  {
    DataLineMsgRecord localDataLineMsgRecord = this.mHandler.a().a().b(paramLong);
    if (localDataLineMsgRecord != null)
    {
      localDataLineMsgRecord.thumbPath = paramString;
      if (!localDataLineMsgRecord.isSend())
      {
        if (QLog.isColorLevel()) {
          QLog.d("dataline.LiteTransferListenerCallback.Main", 2, "uSessionID[" + paramLong + "]" + "OnSessionThumbUpdate: update");
        }
        this.mHandler.b(10, true, new Object[] { Long.valueOf(paramLong) });
      }
    }
  }
  
  private void _startSession(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo, boolean paramBoolean)
  {
    if (paramSession == null) {
      return;
    }
    DataLineMsgRecord localDataLineMsgRecord = this.mHandler.a().a().b(paramSession.uSessionID);
    if (localDataLineMsgRecord == null)
    {
      localDataLineMsgRecord = new DataLineMsgRecord();
      localDataLineMsgRecord.msg = "";
      localDataLineMsgRecord.msgtype = DataLineHandler.a(DataLineHandler.EFILETYPE.values()[paramSession.emFileType]);
      localDataLineMsgRecord.sessionid = paramSession.uSessionID;
      int i;
      if (paramSession.bSend) {
        i = 1;
      }
      for (;;)
      {
        localDataLineMsgRecord.issend = i;
        if (paramSession.bSend)
        {
          bool = true;
          localDataLineMsgRecord.isread = bool;
          localDataLineMsgRecord.path = paramSession.strFilePathSrc;
          if (localDataLineMsgRecord.path == null) {
            break;
          }
          localDataLineMsgRecord.thumbPath = paramSession.strFilePathThumb;
          localDataLineMsgRecord.md5 = paramSession.vFileMD5Src;
          if (paramNFCInfo != null)
          {
            localDataLineMsgRecord.nServerIp = paramNFCInfo.dwServerIP;
            localDataLineMsgRecord.nServerPort = paramNFCInfo.wServerPort;
            localDataLineMsgRecord.vUrlNotify = paramNFCInfo.vUrlNotify;
            localDataLineMsgRecord.vTokenKey = paramNFCInfo.vTokenKey;
          }
          if (paramFTNInfo != null) {
            localDataLineMsgRecord.serverPath = paramFTNInfo.strFileIndex;
          }
        }
        try
        {
          localDataLineMsgRecord.filename = new File(localDataLineMsgRecord.path).getName();
          localDataLineMsgRecord.filesize = paramSession.uFileSizeSrc;
          localDataLineMsgRecord.issuc = false;
          localDataLineMsgRecord.vipBubbleID = this.mHandler.c();
          localDataLineMsgRecord.time = MessageCache.a();
          localDataLineMsgRecord.groupId = paramSession.dwGroupID;
          localDataLineMsgRecord.groupSize = paramSession.dwGroupSize;
          localDataLineMsgRecord.groupIndex = paramSession.dwGroupIndex;
          localDataLineMsgRecord.progress = 0.0F;
          if (paramBoolean)
          {
            localDataLineMsgRecord.fileMsgStatus = 0L;
            paramNFCInfo = this.mHandler.a().a();
            if (paramSession.bSend) {
              break label460;
            }
            bool = true;
            paramNFCInfo.a(localDataLineMsgRecord, bool);
            paramNFCInfo = localDataLineMsgRecord;
            paramNFCInfo.issuc = true;
            if (!paramSession.bSend) {
              break label530;
            }
            this.mHandler.b(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramSession.uSessionID), paramSession.strFilePathSrc, Byte.valueOf((byte)paramSession.emFileType), Boolean.valueOf(false), Boolean.valueOf(paramBoolean), Long.valueOf(paramNFCInfo.filesize) });
            return;
            i = 0;
            continue;
            bool = false;
          }
        }
        catch (Exception paramNFCInfo)
        {
          for (;;)
          {
            paramNFCInfo.printStackTrace();
            continue;
            localDataLineMsgRecord.fileMsgStatus = 2L;
            if (!paramSession.bSend)
            {
              localDataLineMsgRecord.fileMsgStatus = 1L;
              continue;
              label460:
              bool = false;
            }
          }
        }
      }
    }
    if (paramBoolean) {}
    for (localDataLineMsgRecord.fileMsgStatus = 0L;; localDataLineMsgRecord.fileMsgStatus = 2L)
    {
      this.mHandler.a().a().c(localDataLineMsgRecord.msgId);
      this.mHandler.a().a().b(localDataLineMsgRecord.msgId);
      paramNFCInfo = localDataLineMsgRecord;
      break;
    }
    label530:
    if (DataLineMsgSet.isSingle(this.mHandler.a().a().b(paramSession.uSessionID))) {
      if (this.mHandler.b != true) {
        break label725;
      }
    }
    label725:
    for (boolean bool = false;; bool = true)
    {
      this.mHandler.a().a(1, bool, false);
      do
      {
        this.mHandler.b(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramSession.uSessionID), paramSession.strFilePathSrc, Byte.valueOf((byte)paramSession.emFileType), Boolean.valueOf(false), Boolean.valueOf(paramBoolean), Long.valueOf(paramNFCInfo.filesize) });
        return;
        paramFTNInfo = this.mHandler.a().a().a(paramSession.dwGroupID);
      } while ((paramFTNInfo != null) && (paramFTNInfo.getComeCount() != 1));
      if (this.mHandler.b == true) {}
      for (bool = false;; bool = true)
      {
        this.mHandler.a().a(1, bool, false);
        break;
      }
    }
  }
  
  private void preloadImageThumb(Session paramSession)
  {
    DataLineHandler.EFILETYPE localEFILETYPE = DataLineHandler.EFILETYPE.values()[paramSession.emFileType];
    String str = paramSession.strFilePathSrc;
    if ((paramSession.dwGroupID == 0) && (paramSession.bSend) && (localEFILETYPE == DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE) && (str != null) && (new File(str).exists())) {
      URLDrawable.getDrawable(AsyncImageView.a(str, this.msgItemImageWidth, this.msgItemImageHeight, true), null, null, false).downloadImediatly();
    }
  }
  
  private void preloadImageThumb(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if ((paramDataLineMsgRecord != null) && (!paramDataLineMsgRecord.isSendFromLocal()) && (DataLineMsgSet.isSingle(paramDataLineMsgRecord)) && (paramDataLineMsgRecord.msgtype == -2000) && (paramDataLineMsgRecord.path != null) && (new File(paramDataLineMsgRecord.path).exists())) {
      URLDrawable.getDrawable(AsyncImageView.a(paramDataLineMsgRecord.path, this.msgItemImageWidth, this.msgItemImageHeight, true), null, null, false).downloadImediatly();
    }
  }
  
  public void OnGroupComplete(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferListenerCallback.Main", 2, "uGroupID[" + paramInt1 + "]" + "OnGroupComplete 分组结束" + " emGroupStatus[" + paramInt2 + "]");
    }
    if (paramInt1 == 0) {}
    DataLineMsgSet localDataLineMsgSet;
    do
    {
      return;
      localDataLineMsgSet = this.mHandler.a.a().a(paramInt1);
    } while (localDataLineMsgSet == null);
    localDataLineMsgSet.setTimeOut();
    this.mHandler.b(11, true, null);
  }
  
  public void OnGroupStart(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferListenerCallback.Main", 2, "uGroupID[" + paramInt + "]" + "OnGroupStart 分组开始");
    }
    this.mHandler.b(11, true, null);
  }
  
  public void OnSessionComplete(long paramLong, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2) {
      preloadImageThumb(this.mHandler.a().a().b(paramLong));
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new bqr(this, paramLong, paramInt1));
      return;
    }
    _onSessionComplete(paramLong, paramInt1);
  }
  
  public void OnSessionNew(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferListenerCallback.Main", 2, "uSessionID[" + paramSession.uSessionID + "]" + "OnSessionNew Session创建");
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new bqo(this, paramSession, paramNFCInfo, paramFTNInfo));
    }
    for (;;)
    {
      preloadImageThumb(paramSession);
      return;
      _startSession(paramSession, paramNFCInfo, paramFTNInfo, false);
    }
  }
  
  public void OnSessionProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new bqq(this, paramLong1, paramLong2, paramLong3));
      return;
    }
    _onSessionProgress(paramLong1, paramLong2, paramLong3);
  }
  
  public void OnSessionStart(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.LiteTransferListenerCallback.Main", 2, "uSessionID[" + paramLong + "]" + "OnSessionStart, Session开始");
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new bqp(this, paramLong));
      return;
    }
    _startSession(this.mHandler.a(paramLong), null, null, true);
  }
  
  public void OnSessionThumbUpdate(long paramLong, String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new bqs(this, paramLong, paramString));
      return;
    }
    _onSessionThumbUpdate(paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferListenerCallback
 * JD-Core Version:    0.7.0.1
 */