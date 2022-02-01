package com.tencent.mobileqq.shortvideo;

import acrb;
import akxb;
import akxb.a;
import akxe;
import akxn.a;
import akyf;
import akyf.a;
import ambj;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import anfg;
import anfh;
import anfq;
import anfu;
import anfw;
import angi;
import angq;
import angt;
import angu;
import aooi;
import aool;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;
import wte;

public abstract class BaseShortVideoOprerator
  implements akxb, akyf, anfh, anfq
{
  static int dpu = 3;
  public MessageRecord F;
  protected angu a;
  public angi b;
  public String bUB;
  protected Handler handler;
  public String logTag;
  public QQAppInterface mApp;
  
  public BaseShortVideoOprerator() {}
  
  public BaseShortVideoOprerator(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    if (this.handler == null) {
      this.handler = new anfg(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, angi paramangi)
  {
    ThreadManager.post(new BaseShortVideoOprerator.2(paramQQAppInterface, paramangi), 8, null, false);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return this.F;
  }
  
  protected void a(int paramInt, akxn.a parama)
  {
    angq localangq = new angq();
    localangq.b = this.b;
    localangq.c = parama;
    localangq.mResult = -1;
    m(paramInt, -1, localangq);
    if (parama != null)
    {
      akxe.N(this.logTag, this.bUB, parama.bUI, parama.bUJ);
      return;
    }
    akxe.N(this.logTag, this.bUB, "handleError", "unkown err,err == null");
  }
  
  public void a(akxb.a parama)
  {
    if (parama == null)
    {
      parama = new akxn.a();
      parama.bUJ = "result == null";
      parama.bUI = "onDownload";
      a(0, parama);
      return;
    }
    a(this.mApp, this.b);
    akxe.M(this.logTag, this.bUB, "onDownload", "result:" + parama.result);
    Object localObject = new angq();
    ((angq)localObject).mResult = parama.result;
    ((angq)localObject).en = parama;
    if (parama.result == 0)
    {
      c(0, (angq)localObject);
      return;
    }
    if (parama.a == null)
    {
      localObject = new akxn.a();
      ((akxn.a)localObject).bUJ = (parama.errCode + "_" + parama.errStr);
      ((akxn.a)localObject).bUI = "onDownload";
      a(0, (akxn.a)localObject);
      return;
    }
    a(0, parama.a);
  }
  
  public void a(anfu paramanfu)
  {
    akxe.M(this.logTag, this.bUB, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramanfu))
    {
      b(paramanfu);
      return;
    }
    akxb.a locala = new akxb.a();
    locala.result = -1;
    locala.a = paramanfu.b;
    a(locala);
  }
  
  public void a(anfw paramanfw)
  {
    akxe.M(this.logTag, this.bUB, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramanfw)) {
      ThreadManager.getSubThreadHandler().post(new ForwardShortVideoTask(paramanfw));
    }
    while (paramanfw == null) {
      return;
    }
    a(3, paramanfw.b);
  }
  
  public void a(angt paramangt)
  {
    akxe.M(this.logTag, this.bUB, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramangt)) {
      ThreadManager.getSubThreadHandler().post(new SendShortVideoTask(paramangt));
    }
    while (paramangt == null) {
      return;
    }
    a(2, paramangt.b);
  }
  
  public void a(angu paramangu)
  {
    this.a = paramangu;
  }
  
  boolean a(anfu paramanfu)
  {
    if (paramanfu != null)
    {
      akxe.M(this.logTag, this.bUB, "checkShortVideoDownloadInfo", "info:" + paramanfu);
      return paramanfu.check();
    }
    akxe.N(this.logTag, this.bUB, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(anfw paramanfw)
  {
    if (paramanfw != null)
    {
      akxe.M(this.logTag, this.bUB, "checkShortVideoForwardInfo", "info:" + paramanfw);
      return paramanfw.check();
    }
    akxe.N(this.logTag, this.bUB, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(angt paramangt)
  {
    if (paramangt != null)
    {
      akxe.M(this.logTag, this.bUB, "checkShortVideoUploadInfo", "info:" + paramangt);
      return paramangt.check();
    }
    akxe.N(this.logTag, this.bUB, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public void aS(int paramInt, boolean paramBoolean)
  {
    angq localangq = new angq();
    localangq.mResult = 0;
    localangq.en = Integer.valueOf(paramInt);
    m(1, 0, localangq);
  }
  
  public void ar(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ((ambj)this.mApp.getManager(326)).d(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void b(akyf.a parama)
  {
    if (parama == null)
    {
      a(2, null);
      return;
    }
    if (parama.result == 0)
    {
      a(parama);
      localObject = new angq();
      ((angq)localObject).mResult = 0;
      ((angq)localObject).en = parama;
      c(2, (angq)localObject);
      return;
    }
    Object localObject = new akxn.a();
    ((akxn.a)localObject).bUJ = parama.errStr;
    a(2, (akxn.a)localObject);
  }
  
  void b(anfu paramanfu)
  {
    long l = System.currentTimeMillis();
    paramanfu.selfUin = this.mApp.getCurrentAccountUin();
    aool localaool = new aool();
    localaool.mSelfUin = paramanfu.selfUin;
    localaool.mPeerUin = paramanfu.peerUin;
    localaool.cmn = paramanfu.bUG;
    localaool.mUinType = paramanfu.uinType;
    localaool.mUniseq = paramanfu.uniseq;
    localaool.cNy = false;
    localaool.mBusiType = paramanfu.dFl;
    localaool.dpB = paramanfu.mRequestType;
    localaool.en = Integer.valueOf(paramanfu.mSceneType);
    localaool.cFo = paramanfu.cFo;
    if ((paramanfu.fileType == 1001) || (paramanfu.fileType == 1003) || (paramanfu.fileType == 1005) || (paramanfu.fileType == 1002) || (paramanfu.fileType == 1004) || (paramanfu.fileType == 1006)) {
      localaool.mMd5 = paramanfu.md5;
    }
    if (this.a != null) {
      localaool.b = this;
    }
    switch (paramanfu.fileType)
    {
    }
    for (;;)
    {
      if ((this.b != null) && (this.b.o != null)) {
        localaool.F = this.b.o;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + paramanfu.fileType + "downloadvideo MD5==" + paramanfu.md5);
      }
      this.mApp.a().a(localaool);
      akxe.M(this.logTag, this.bUB, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      akxe.M(this.logTag, this.bUB, "doDownloadShortVideo.start", "TransferRequest: " + localaool.toString());
      return;
      localaool.mFileType = 7;
      localaool.dQ = (paramanfu.thumbPath + "QQ_&_MoblieQQ_&_QQ" + paramanfu.uuid + "QQ_&_MoblieQQ_&_QQ" + paramanfu.fileType);
      continue;
      localaool.mFileType = 16;
      localaool.dQ = (paramanfu.thumbPath + "QQ_&_MoblieQQ_&_QQ" + paramanfu.uuid + "QQ_&_MoblieQQ_&_QQ" + paramanfu.fileType);
      continue;
      localaool.mFileType = 18;
      localaool.dQ = (paramanfu.thumbPath + "QQ_&_MoblieQQ_&_QQ" + paramanfu.uuid + "QQ_&_MoblieQQ_&_QQ" + paramanfu.fileType);
      continue;
      localaool.mFileType = 6;
      localaool.dQ = (paramanfu.localPath + "QQ_&_MoblieQQ_&_QQ" + paramanfu.uuid + "QQ_&_MoblieQQ_&_QQ" + paramanfu.fileType + "QQ_&_MoblieQQ_&_QQ" + paramanfu.time);
      continue;
      localaool.mFileType = 9;
      localaool.dQ = (paramanfu.localPath + "QQ_&_MoblieQQ_&_QQ" + paramanfu.uuid + "QQ_&_MoblieQQ_&_QQ" + paramanfu.fileType + "QQ_&_MoblieQQ_&_QQ" + paramanfu.time);
      continue;
      localaool.mFileType = 17;
      localaool.dQ = (paramanfu.localPath + "QQ_&_MoblieQQ_&_QQ" + paramanfu.uuid + "QQ_&_MoblieQQ_&_QQ" + paramanfu.fileType + "QQ_&_MoblieQQ_&_QQ" + paramanfu.time);
    }
  }
  
  public void b(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ambj localambj = (ambj)this.mApp.getManager(326);
    localambj.p(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localambj.d(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  protected void c(int paramInt, angq paramangq)
  {
    angq localangq = paramangq;
    if (paramangq == null) {
      localangq = new angq();
    }
    localangq.mResult = 0;
    localangq.b = this.b;
    m(paramInt, 0, localangq);
    akxe.M(this.logTag, this.bUB, "handleSuccess", "what:" + paramInt);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    akxe.M(this.logTag, this.bUB, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.a == null) {}
    int i;
    do
    {
      return;
      i = paramMessage.arg1;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        paramMessage = (angq)paramMessage.obj;
        this.a.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (angq)paramMessage.obj;
      }
    } while (!(paramMessage.en instanceof Integer));
    this.a.onUpdateProgress(((Integer)paramMessage.en).intValue());
    return;
    paramMessage = (angq)paramMessage.obj;
    this.a.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.a.h(i, paramMessage);
        return;
      }
      catch (ClassCastException paramMessage)
      {
        paramMessage = null;
        continue;
      }
      paramMessage = null;
    }
  }
  
  public void eR(ArrayList<anfw> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseShortVideoOprerator", 2, "multiForwardShortVideo start:" + Thread.currentThread().getId());
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      m(3, -1, null);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new MultiForwardShortVideoTask(paramArrayList));
  }
  
  protected void m(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.handler.sendMessage(localMessage);
  }
  
  class ForwardShortVideoTask
    implements Runnable
  {
    anfw a;
    
    public ForwardShortVideoTask(anfw paramanfw)
    {
      this.a = paramanfw;
    }
    
    public void run()
    {
      if (this.a == null) {}
      for (;;)
      {
        return;
        anfw localanfw = this.a;
        long l = localanfw.uniseq;
        int j = localanfw.forwardID;
        Object localObject;
        int i;
        if (localanfw.dFp == 3)
        {
          localObject = BaseShortVideoOprerator.this.a(localanfw);
          i = 1;
        }
        while (localObject != null)
        {
          wte.a().i(((MessageRecord)localObject).uniseq, l, j);
          BaseShortVideoOprerator.this.F = ((MessageRecord)localObject);
          l = System.currentTimeMillis();
          aool localaool = new aool();
          localaool.mSelfUin = ((MessageRecord)localObject).selfuin;
          localaool.mPeerUin = ((MessageRecord)localObject).frienduin;
          localaool.mUinType = ((MessageRecord)localObject).istroop;
          localaool.mFileType = 20;
          localaool.en = localanfw;
          localaool.mUniseq = ((MessageRecord)localObject).uniseq;
          localaool.cNy = true;
          localaool.mBusiType = 0;
          localaool.mMd5 = localanfw.md5;
          localaool.dQ = (localanfw.localPath + "QQ_&_MoblieQQ_&_QQ" + localanfw.thumbPath + "QQ_&_MoblieQQ_&_QQ" + localanfw.dFo + "QQ_&_MoblieQQ_&_QQ" + localanfw.thumbMD5);
          localaool.b = BaseShortVideoOprerator.this;
          localaool.F = BaseShortVideoOprerator.this.F;
          BaseShortVideoOprerator.this.mApp.a().a(localaool);
          if (i != 0) {
            BaseShortVideoOprerator.this.b((MessageRecord)localObject, localanfw.aeM);
          }
          akxe.M(BaseShortVideoOprerator.this.logTag, BaseShortVideoOprerator.this.bUB, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
          akxe.M(BaseShortVideoOprerator.this.logTag, BaseShortVideoOprerator.this.bUB, "doForwardShortVideo.start", "TransferRequest: " + localaool.toString());
          return;
          if (localanfw.dFp == 4)
          {
            localObject = (MessageForShortVideo)localanfw.message;
            i = 0;
          }
          else
          {
            localObject = null;
            i = 0;
          }
        }
      }
    }
  }
  
  class MultiForwardShortVideoTask
    implements Runnable
  {
    ArrayList<angq> aQ;
    int dpt = 0;
    ArrayList<anfw> iG;
    
    public MultiForwardShortVideoTask()
    {
      Object localObject;
      this.iG = localObject;
    }
    
    private int Jj()
    {
      ArrayList localArrayList = this.aQ;
      int i = 0;
      for (;;)
      {
        try
        {
          Iterator localIterator = this.aQ.iterator();
          if (localIterator.hasNext())
          {
            if (((angq)localIterator.next()).mResult == -2) {
              i += 1;
            }
          }
          else {
            return i;
          }
        }
        finally {}
      }
    }
    
    public void dPd()
    {
      if (this.dpt >= this.iG.size()) {
        return;
      }
      int i;
      int j;
      label105:
      anfw localanfw;
      Object localObject;
      if (this.dpt + BaseShortVideoOprerator.dpu < this.iG.size())
      {
        i = this.dpt + BaseShortVideoOprerator.dpu;
        if (QLog.isColorLevel()) {
          QLog.d("BaseShortVideoOprerator", 2, "mInfoList:" + this.iG.size() + " ,uploadStartIndex:" + this.dpt + " ,finishIndex:" + i);
        }
        j = this.dpt;
        if (j >= i) {
          break label456;
        }
        localanfw = (anfw)this.iG.get(j);
        if (localanfw.message == null) {
          break label178;
        }
        localObject = (MessageForShortVideo)localanfw.message;
        label141:
        if (localObject != null) {
          break label192;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BaseShortVideoOprerator", 2, "mr is null");
        }
      }
      for (;;)
      {
        j += 1;
        break label105;
        i = this.iG.size();
        break;
        label178:
        localObject = BaseShortVideoOprerator.this.a(localanfw);
        break label141;
        label192:
        BaseShortVideoOprerator.this.F = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        aool localaool = new aool();
        localaool.mSelfUin = ((MessageRecord)localObject).selfuin;
        localaool.mPeerUin = ((MessageRecord)localObject).frienduin;
        localaool.mUinType = ((MessageRecord)localObject).istroop;
        localaool.mFileType = 20;
        localaool.en = localanfw;
        localaool.mUniseq = ((MessageRecord)localObject).uniseq;
        localaool.cNy = true;
        localaool.mBusiType = 1010;
        localaool.mMd5 = localanfw.md5;
        localaool.dQ = (localanfw.localPath + "QQ_&_MoblieQQ_&_QQ" + localanfw.thumbPath + "QQ_&_MoblieQQ_&_QQ" + localanfw.dFo + "QQ_&_MoblieQQ_&_QQ" + localanfw.thumbMD5);
        localaool.b = new a(j);
        localaool.F = BaseShortVideoOprerator.this.F;
        BaseShortVideoOprerator.this.mApp.a().a(localaool);
        if (QLog.isColorLevel()) {
          QLog.d("BaseShortVideoOprerator", 2, "MultiForwardShortVideo req" + j + ": " + localaool.toString() + " ,cost:" + (System.currentTimeMillis() - l));
        }
      }
      label456:
      this.dpt += BaseShortVideoOprerator.dpu;
    }
    
    public void run()
    {
      if (this.iG == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseShortVideoOprerator", 2, "mInfoList is null");
        }
        return;
      }
      if (this.aQ == null) {
        this.aQ = new ArrayList(this.iG.size());
      }
      Iterator localIterator = this.iG.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (anfw)localIterator.next();
        localObject = new angq();
        ((angq)localObject).mResult = -2;
        ((angq)localObject).b = BaseShortVideoOprerator.this.b;
        this.aQ.add(localObject);
      }
      dPd();
    }
    
    class a
      implements akyf
    {
      angq jdField_a_of_type_Angq;
      final int aDT;
      
      a(int paramInt)
      {
        this.aDT = paramInt;
        this.jdField_a_of_type_Angq = ((angq)BaseShortVideoOprerator.MultiForwardShortVideoTask.this.aQ.get(this.aDT));
      }
      
      public MessageRecord a(im_msg_body.RichText paramRichText)
      {
        return (MessageForShortVideo)((anfw)BaseShortVideoOprerator.MultiForwardShortVideoTask.this.iG.get(this.aDT)).message;
      }
      
      public void a(akyf.a parama)
      {
        MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((anfw)BaseShortVideoOprerator.MultiForwardShortVideoTask.this.iG.get(this.aDT)).message;
        localMessageForShortVideo.videoFileStatus = 1003;
        localMessageForShortVideo.md5 = parama.md5;
        localMessageForShortVideo.uuid = parama.uuid;
        localMessageForShortVideo.thumbFileSize = ((int)parama.JW);
        localMessageForShortVideo.videoAttr = parama.videoAttr;
        localMessageForShortVideo.videoKandianType = parama.videoKandianType;
        localMessageForShortVideo.serial();
        parama = BaseShortVideoOprerator.this.mApp.a();
        if (parama != null) {
          parama.a(localMessageForShortVideo, null);
        }
      }
      
      public void b(akyf.a parama)
      {
        for (;;)
        {
          int i;
          synchronized (BaseShortVideoOprerator.MultiForwardShortVideoTask.this.aQ)
          {
            if (parama.result == 0)
            {
              a(parama);
              this.jdField_a_of_type_Angq.mResult = 0;
              if (QLog.isColorLevel()) {
                QLog.d("BaseShortVideoOprerator", 2, "onsend success!");
              }
              i = BaseShortVideoOprerator.MultiForwardShortVideoTask.a(BaseShortVideoOprerator.MultiForwardShortVideoTask.this);
              if (i == 0) {
                BaseShortVideoOprerator.this.m(3, 0, BaseShortVideoOprerator.MultiForwardShortVideoTask.this.aQ);
              }
            }
            else
            {
              this.jdField_a_of_type_Angq.mResult = -1;
              this.jdField_a_of_type_Angq.c = new akxn.a();
              this.jdField_a_of_type_Angq.c.bUJ = parama.errStr;
              this.jdField_a_of_type_Angq.c.errCode = parama.errCode;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("BaseShortVideoOprerator", 2, "onsend fail! err:" + parama.errStr);
            }
          }
          if (BaseShortVideoOprerator.MultiForwardShortVideoTask.this.dpt == BaseShortVideoOprerator.MultiForwardShortVideoTask.this.iG.size() - i) {
            BaseShortVideoOprerator.MultiForwardShortVideoTask.this.dPd();
          }
        }
      }
    }
  }
  
  class SendShortVideoTask
    implements Runnable
  {
    angt c;
    
    public SendShortVideoTask(angt paramangt)
    {
      this.c = paramangt;
    }
    
    public void run()
    {
      if (this.c == null) {}
      for (;;)
      {
        return;
        angt localangt = this.c;
        Object localObject;
        int i;
        if (!localangt.cFz)
        {
          localObject = (MessageForShortVideo)localangt.message;
          i = 0;
        }
        while (localObject != null)
        {
          BaseShortVideoOprerator.this.F = ((MessageRecord)localObject);
          long l = System.currentTimeMillis();
          aool localaool = new aool();
          localaool.mSelfUin = ((MessageRecord)localObject).selfuin;
          localaool.mPeerUin = ((MessageRecord)localObject).frienduin;
          localaool.mUinType = ((MessageRecord)localObject).istroop;
          if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008))
          {
            localaool.mFileType = 6;
            label117:
            localaool.mUniseq = ((MessageRecord)localObject).uniseq;
            localaool.cNy = true;
            localaool.mBusiType = localangt.dFl;
            localaool.mMd5 = localangt.md5;
            localaool.dQ = (localangt.localPath + "QQ_&_MoblieQQ_&_QQ" + localangt.thumbPath + "QQ_&_MoblieQQ_&_QQ" + localangt.dFo + "QQ_&_MoblieQQ_&_QQ" + localangt.thumbMD5);
            localaool.b = BaseShortVideoOprerator.this;
            localaool.F = ((MessageRecord)localObject);
            localaool.en = this.c;
            BaseShortVideoOprerator.this.mApp.a().a(localaool);
            if ((!localangt.cFA) && (!localangt.cFB))
            {
              if (localangt.cFz) {
                break label468;
              }
              BaseShortVideoOprerator.this.mApp.b().as(localObject);
            }
          }
          for (;;)
          {
            akxe.M(BaseShortVideoOprerator.this.logTag, BaseShortVideoOprerator.this.bUB, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
            akxe.M(BaseShortVideoOprerator.this.logTag, BaseShortVideoOprerator.this.bUB, "doSendShortVideo.start", "TransferRequest: " + localaool.toString());
            return;
            if (localangt.dFp == 0)
            {
              localObject = BaseShortVideoOprerator.this.a(localangt);
              i = 1;
              break;
            }
            if (localangt.dFp != 1) {
              break label484;
            }
            localObject = (MessageForShortVideo)localangt.message;
            i = 0;
            break;
            if (((MessageRecord)localObject).istroop == 3000)
            {
              localaool.mFileType = 17;
              break label117;
            }
            if (((MessageRecord)localObject).istroop != 1) {
              break label117;
            }
            localaool.mFileType = 9;
            break label117;
            label468:
            if (i != 0) {
              BaseShortVideoOprerator.this.ar((MessageRecord)localObject);
            }
          }
          label484:
          localObject = null;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */