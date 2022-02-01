package dov.com.tencent.mobileqq.shortvideo;

import acle;
import acrb;
import akxb;
import akxb.a;
import akxe;
import akxn.a;
import akyf;
import akyf.a;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import aooi;
import aool;
import ayzi;
import ayzz;
import azab;
import azac;
import azaf;
import azag;
import azai;
import azal;
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

public abstract class BaseShortVideoOprerator
  implements akxb, akyf, ayzz
{
  static int dpu = 3;
  public MessageRecord F;
  public azaf a;
  protected azal a;
  public String bUB;
  protected Handler handler;
  public String logTag;
  public QQAppInterface mApp;
  
  public BaseShortVideoOprerator() {}
  
  public BaseShortVideoOprerator(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    if (this.handler == null) {
      this.handler = new ayzi(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, azaf paramazaf)
  {
    ThreadManager.post(new BaseShortVideoOprerator.2(), 8, null, false);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return this.F;
  }
  
  protected void a(int paramInt, akxn.a parama)
  {
    azag localazag = new azag();
    localazag.jdField_a_of_type_Azaf = this.jdField_a_of_type_Azaf;
    localazag.c = parama;
    localazag.mResult = -1;
    m(paramInt, -1, localazag);
    if (parama != null)
    {
      akxe.N(this.logTag, this.bUB, parama.bUI, parama.bUJ);
      return;
    }
    akxe.N(this.logTag, this.bUB, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, azag paramazag)
  {
    azag localazag = paramazag;
    if (paramazag == null) {
      localazag = new azag();
    }
    localazag.mResult = 0;
    localazag.jdField_a_of_type_Azaf = this.jdField_a_of_type_Azaf;
    m(paramInt, 0, localazag);
    akxe.M(this.logTag, this.bUB, "handleSuccess", "what:" + paramInt);
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
    a(this.mApp, this.jdField_a_of_type_Azaf);
    akxe.M(this.logTag, this.bUB, "onDownload", "result:" + parama.result);
    Object localObject = new azag();
    ((azag)localObject).mResult = parama.result;
    ((azag)localObject).en = parama;
    if (parama.result == 0)
    {
      a(0, (azag)localObject);
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
  
  public void a(azab paramazab)
  {
    akxe.M(this.logTag, this.bUB, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramazab))
    {
      b(paramazab);
      return;
    }
    akxb.a locala = new akxb.a();
    locala.result = -1;
    locala.a = paramazab.b;
    a(locala);
  }
  
  public void a(azac paramazac)
  {
    akxe.M(this.logTag, this.bUB, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramazac)) {
      ThreadManager.getSubThreadHandler().post(new ForwardShortVideoTask(paramazac));
    }
    while (paramazac == null) {
      return;
    }
    a(3, paramazac.b);
  }
  
  public void a(azai paramazai)
  {
    akxe.M(this.logTag, this.bUB, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramazai)) {
      ThreadManager.getSubThreadHandler().post(new SendShortVideoTask(paramazai));
    }
    while (paramazai == null) {
      return;
    }
    a(2, paramazai.b);
  }
  
  public void a(azal paramazal)
  {
    this.jdField_a_of_type_Azal = paramazal;
  }
  
  boolean a(azab paramazab)
  {
    if (paramazab != null)
    {
      akxe.M(this.logTag, this.bUB, "checkShortVideoDownloadInfo", "info:" + paramazab);
      return paramazab.check();
    }
    akxe.N(this.logTag, this.bUB, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(azac paramazac)
  {
    if (paramazac != null)
    {
      akxe.M(this.logTag, this.bUB, "checkShortVideoForwardInfo", "info:" + paramazac);
      return paramazac.check();
    }
    akxe.N(this.logTag, this.bUB, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(azai paramazai)
  {
    if (paramazai != null)
    {
      akxe.M(this.logTag, this.bUB, "checkShortVideoUploadInfo", "info:" + paramazai);
      return paramazai.check();
    }
    akxe.N(this.logTag, this.bUB, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public void aS(int paramInt, boolean paramBoolean)
  {
    azag localazag = new azag();
    localazag.mResult = 0;
    localazag.en = Integer.valueOf(paramInt);
    m(1, 0, localazag);
  }
  
  public void ar(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ((acle)this.mApp.getBusinessHandler(13)).W(paramMessageRecord);
    this.mApp.b().b(paramMessageRecord, this.mApp.getCurrentAccountUin());
    akxe.M(this.logTag, this.bUB, "addMsg", "cost:" + (System.currentTimeMillis() - l));
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
      localObject = new azag();
      ((azag)localObject).mResult = 0;
      ((azag)localObject).en = parama;
      a(2, (azag)localObject);
      return;
    }
    Object localObject = new akxn.a();
    ((akxn.a)localObject).bUJ = parama.errStr;
    a(2, (akxn.a)localObject);
  }
  
  void b(azab paramazab)
  {
    long l = System.currentTimeMillis();
    paramazab.selfUin = this.mApp.getCurrentAccountUin();
    aool localaool = new aool();
    localaool.mSelfUin = paramazab.selfUin;
    localaool.mPeerUin = paramazab.peerUin;
    localaool.cmn = paramazab.bUG;
    localaool.mUinType = paramazab.uinType;
    localaool.mUniseq = paramazab.uniseq;
    localaool.cNy = false;
    localaool.mBusiType = paramazab.dFl;
    localaool.dpB = paramazab.mRequestType;
    localaool.en = Integer.valueOf(paramazab.mSceneType);
    localaool.cFo = paramazab.cFo;
    if ((paramazab.fileType == 1001) || (paramazab.fileType == 1003) || (paramazab.fileType == 1005) || (paramazab.fileType == 1002) || (paramazab.fileType == 1004) || (paramazab.fileType == 1006)) {
      localaool.mMd5 = paramazab.md5;
    }
    if (this.jdField_a_of_type_Azal != null) {
      localaool.b = this;
    }
    switch (paramazab.fileType)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Azaf != null) && (this.jdField_a_of_type_Azaf.o != null)) {
        localaool.F = this.jdField_a_of_type_Azaf.o;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + paramazab.fileType + "downloadvideo MD5==" + paramazab.md5);
      }
      this.mApp.a().a(localaool);
      akxe.M(this.logTag, this.bUB, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      akxe.M(this.logTag, this.bUB, "doDownloadShortVideo.start", "TransferRequest: " + localaool.toString());
      return;
      localaool.mFileType = 7;
      localaool.dQ = (paramazab.thumbPath + "QQ_&_MoblieQQ_&_QQ" + paramazab.uuid + "QQ_&_MoblieQQ_&_QQ" + paramazab.fileType);
      continue;
      localaool.mFileType = 16;
      localaool.dQ = (paramazab.thumbPath + "QQ_&_MoblieQQ_&_QQ" + paramazab.uuid + "QQ_&_MoblieQQ_&_QQ" + paramazab.fileType);
      continue;
      localaool.mFileType = 18;
      localaool.dQ = (paramazab.thumbPath + "QQ_&_MoblieQQ_&_QQ" + paramazab.uuid + "QQ_&_MoblieQQ_&_QQ" + paramazab.fileType);
      continue;
      localaool.mFileType = 6;
      localaool.dQ = (paramazab.localPath + "QQ_&_MoblieQQ_&_QQ" + paramazab.uuid + "QQ_&_MoblieQQ_&_QQ" + paramazab.fileType + "QQ_&_MoblieQQ_&_QQ" + paramazab.time);
      continue;
      localaool.mFileType = 9;
      localaool.dQ = (paramazab.localPath + "QQ_&_MoblieQQ_&_QQ" + paramazab.uuid + "QQ_&_MoblieQQ_&_QQ" + paramazab.fileType + "QQ_&_MoblieQQ_&_QQ" + paramazab.time);
      continue;
      localaool.mFileType = 17;
      localaool.dQ = (paramazab.localPath + "QQ_&_MoblieQQ_&_QQ" + paramazab.uuid + "QQ_&_MoblieQQ_&_QQ" + paramazab.fileType + "QQ_&_MoblieQQ_&_QQ" + paramazab.time);
    }
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    akxe.M(this.logTag, this.bUB, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Azal == null) {}
    int i;
    do
    {
      return;
      i = paramMessage.arg1;
      switch (paramMessage.what)
      {
      case 4: 
      default: 
        return;
      case 0: 
        paramMessage = (azag)paramMessage.obj;
        this.jdField_a_of_type_Azal.b(i, paramMessage);
        return;
      case 1: 
        paramMessage = (azag)paramMessage.obj;
      }
    } while (!(paramMessage.en instanceof Integer));
    this.jdField_a_of_type_Azal.onUpdateProgress(((Integer)paramMessage.en).intValue());
    return;
    paramMessage = (azag)paramMessage.obj;
    this.jdField_a_of_type_Azal.c(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Azal.h(i, paramMessage);
        return;
      }
      catch (ClassCastException paramMessage)
      {
        paramMessage = null;
        continue;
      }
      paramMessage = (azag)paramMessage.obj;
      this.jdField_a_of_type_Azal.c(paramMessage.urls, paramMessage.domain);
      return;
      paramMessage = null;
    }
  }
  
  public void eR(ArrayList<azac> paramArrayList)
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
    azac a;
    
    public ForwardShortVideoTask(azac paramazac)
    {
      this.a = paramazac;
    }
    
    public void run()
    {
      if (this.a == null) {}
      for (;;)
      {
        return;
        azac localazac = this.a;
        Object localObject;
        int i;
        if (localazac.dFp == 3)
        {
          localObject = BaseShortVideoOprerator.this.a(localazac);
          i = 1;
        }
        while (localObject != null)
        {
          BaseShortVideoOprerator.this.F = ((MessageRecord)localObject);
          long l = System.currentTimeMillis();
          aool localaool = new aool();
          localaool.mSelfUin = ((MessageRecord)localObject).selfuin;
          localaool.mPeerUin = ((MessageRecord)localObject).frienduin;
          localaool.mUinType = ((MessageRecord)localObject).istroop;
          localaool.mFileType = 20;
          localaool.en = localazac;
          localaool.mUniseq = ((MessageRecord)localObject).uniseq;
          localaool.cNy = true;
          localaool.mBusiType = 0;
          localaool.mMd5 = localazac.md5;
          localaool.dQ = (localazac.localPath + "QQ_&_MoblieQQ_&_QQ" + localazac.thumbPath + "QQ_&_MoblieQQ_&_QQ" + localazac.dFo + "QQ_&_MoblieQQ_&_QQ" + localazac.thumbMD5);
          localaool.b = BaseShortVideoOprerator.this;
          localaool.F = BaseShortVideoOprerator.this.F;
          BaseShortVideoOprerator.this.mApp.a().a(localaool);
          if (i != 0) {
            BaseShortVideoOprerator.this.ar((MessageRecord)localObject);
          }
          akxe.M(BaseShortVideoOprerator.this.logTag, BaseShortVideoOprerator.this.bUB, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
          akxe.M(BaseShortVideoOprerator.this.logTag, BaseShortVideoOprerator.this.bUB, "doForwardShortVideo.start", "TransferRequest: " + localaool.toString());
          return;
          if (localazac.dFp == 4)
          {
            localObject = (MessageForShortVideo)localazac.message;
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
    ArrayList<azag> aQ;
    int dpt = 0;
    ArrayList<azac> iG;
    
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
            if (((azag)localIterator.next()).mResult == -2) {
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
      azac localazac;
      if (this.dpt + BaseShortVideoOprerator.dpu < this.iG.size())
      {
        i = this.dpt + BaseShortVideoOprerator.dpu;
        if (QLog.isColorLevel()) {
          QLog.d("BaseShortVideoOprerator", 2, "mInfoList:" + this.iG.size() + " ,uploadStartIndex:" + this.dpt + " ,finishIndex:" + i);
        }
        j = this.dpt;
        if (j >= i) {
          break label515;
        }
        localazac = (azac)this.iG.get(j);
        if (localazac.message == null) {
          break label178;
        }
      }
      label178:
      for (Object localObject = (MessageForShortVideo)localazac.message;; localObject = BaseShortVideoOprerator.this.a(localazac))
      {
        if (localObject != null) {
          break label192;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BaseShortVideoOprerator", 2, "mr is null");
        }
        j += 1;
        break label105;
        i = this.iG.size();
        break;
      }
      label192:
      BaseShortVideoOprerator.this.F = ((MessageRecord)localObject);
      long l = System.currentTimeMillis();
      aool localaool = new aool();
      localaool.mSelfUin = ((MessageRecord)localObject).selfuin;
      localaool.mPeerUin = ((MessageRecord)localObject).frienduin;
      localaool.mUinType = ((MessageRecord)localObject).istroop;
      if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008)) {
        localaool.mFileType = 6;
      }
      for (;;)
      {
        localaool.en = localazac;
        localaool.mUniseq = ((MessageRecord)localObject).uniseq;
        localaool.cNy = true;
        localaool.mBusiType = 1010;
        localaool.mMd5 = localazac.md5;
        localaool.dQ = (localazac.localPath + "QQ_&_MoblieQQ_&_QQ" + localazac.thumbPath + "QQ_&_MoblieQQ_&_QQ" + localazac.dFo + "QQ_&_MoblieQQ_&_QQ" + localazac.thumbMD5);
        localaool.b = new a(j);
        localaool.F = BaseShortVideoOprerator.this.F;
        BaseShortVideoOprerator.this.mApp.a().a(localaool);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BaseShortVideoOprerator", 2, "MultiForwardShortVideo req" + j + ": " + localaool.toString() + " ,cost:" + (System.currentTimeMillis() - l));
        break;
        if (((MessageRecord)localObject).istroop == 3000) {
          localaool.mFileType = 17;
        } else if (((MessageRecord)localObject).istroop == 1) {
          localaool.mFileType = 9;
        }
      }
      label515:
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
        Object localObject = (azac)localIterator.next();
        localObject = new azag();
        ((azag)localObject).mResult = -2;
        ((azag)localObject).a = BaseShortVideoOprerator.this.a;
        this.aQ.add(localObject);
      }
      dPd();
    }
    
    class a
      implements akyf
    {
      azag jdField_a_of_type_Azag;
      final int aDT;
      
      a(int paramInt)
      {
        this.aDT = paramInt;
        this.jdField_a_of_type_Azag = ((azag)BaseShortVideoOprerator.MultiForwardShortVideoTask.this.aQ.get(this.aDT));
      }
      
      public MessageRecord a(im_msg_body.RichText paramRichText)
      {
        return (MessageForShortVideo)((azac)BaseShortVideoOprerator.MultiForwardShortVideoTask.this.iG.get(this.aDT)).message;
      }
      
      public void a(akyf.a parama)
      {
        MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((azac)BaseShortVideoOprerator.MultiForwardShortVideoTask.this.iG.get(this.aDT)).message;
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
              this.jdField_a_of_type_Azag.mResult = 0;
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
              this.jdField_a_of_type_Azag.mResult = -1;
              this.jdField_a_of_type_Azag.c = new akxn.a();
              this.jdField_a_of_type_Azag.c.bUJ = parama.errStr;
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
    azai a;
    
    public SendShortVideoTask(azai paramazai)
    {
      this.a = paramazai;
    }
    
    public void run()
    {
      if (this.a == null) {}
      for (;;)
      {
        return;
        azai localazai = this.a;
        Object localObject;
        int i;
        if (!localazai.cFz)
        {
          localObject = (MessageForShortVideo)localazai.message;
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
            localaool.mBusiType = localazai.dFl;
            localaool.mMd5 = localazai.md5;
            localaool.dQ = (localazai.localPath + "QQ_&_MoblieQQ_&_QQ" + localazai.thumbPath + "QQ_&_MoblieQQ_&_QQ" + localazai.dFo + "QQ_&_MoblieQQ_&_QQ" + localazai.thumbMD5);
            localaool.b = BaseShortVideoOprerator.this;
            localaool.F = ((MessageRecord)localObject);
            localaool.en = this.a;
            localaool.cMb = localazai.cMb;
            BaseShortVideoOprerator.this.mApp.a().a(localaool);
            if (!localazai.cFA)
            {
              if (localazai.cFz) {
                break label470;
              }
              BaseShortVideoOprerator.this.mApp.b().as(localObject);
            }
          }
          for (;;)
          {
            akxe.M(BaseShortVideoOprerator.this.logTag, BaseShortVideoOprerator.this.bUB, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
            akxe.M(BaseShortVideoOprerator.this.logTag, BaseShortVideoOprerator.this.bUB, "doSendShortVideo.start", "TransferRequest: " + localaool.toString());
            return;
            if (localazai.dFp == 0)
            {
              localObject = BaseShortVideoOprerator.this.a(localazai);
              i = 1;
              break;
            }
            if (localazai.dFp != 1) {
              break label486;
            }
            localObject = (MessageForShortVideo)localazai.message;
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
            label470:
            if (i != 0) {
              BaseShortVideoOprerator.this.ar((MessageRecord)localObject);
            }
          }
          label486:
          localObject = null;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */