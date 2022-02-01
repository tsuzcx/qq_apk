import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.BasePicOprerator.2;
import com.tencent.mobileqq.pic.BasePicOprerator.3;
import com.tencent.mobileqq.pic.BasePicOprerator.4;
import com.tencent.mobileqq.pic.BasePicOprerator.5;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.ReportInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;

public abstract class akwv
  implements akxb, akxd, akxi, akyf
{
  protected static int dpu = 20;
  public MessageRecord F;
  protected akye a;
  public String bUB;
  protected int dpt;
  public akxq e;
  protected Handler handler;
  protected ArrayList<akxm> iG;
  public String logTag;
  public QQAppInterface mApp;
  public ArrayList<akxr> ys;
  
  public akwv() {}
  
  public akwv(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    if (this.handler == null) {
      this.handler = new akww(this, Looper.getMainLooper());
    }
  }
  
  private aool a(akxl paramakxl, String paramString)
  {
    paramakxl.selfUin = this.mApp.getCurrentAccountUin();
    aool localaool = new aool();
    localaool.cNy = false;
    localaool.mUinType = paramakxl.uinType;
    boolean bool;
    if (paramakxl.fileSizeFlag == 1)
    {
      bool = true;
      localaool.mFileType = aoop.n(paramString, bool);
      localaool.mUniseq = paramakxl.uniseq;
      localaool.apI = paramakxl.subMsgId;
      localaool.mSelfUin = paramakxl.selfUin;
      localaool.mPeerUin = paramakxl.peerUin;
      localaool.cmo = paramakxl.uuid;
      localaool.dQ = null;
      localaool.jdField_b_of_type_Akxb = this;
      localaool.cNA = false;
      localaool.bEnableEnc = paramakxl.bEnableEnc;
      localaool.clR = paramakxl.getFilePath();
      if ((this.e != null) && (this.e.j != null)) {
        localaool.F = this.e.j;
      }
      akxe.M(this.logTag, this.bUB, "convert2TranferRequest", "outFilePath:" + localaool.clR + "info.protocol:" + paramakxl.protocol);
      paramString = new aool.c();
      localaool.en = paramString;
      if (localaool.mFileType != 65537) {
        break label385;
      }
      if (paramakxl.reportInfo != null)
      {
        paramakxl.reportInfo.dpV = paramakxl.dpC;
        paramakxl.reportInfo.dpU = akxo.Hi();
        paramakxl.reportInfo.afB = (System.currentTimeMillis() - paramakxl.reportInfo.afA);
        paramakxl.reportInfo.dpS = 1;
      }
      if (!anof.ayA()) {
        break label374;
      }
      paramString.cms = paramakxl.bUH;
    }
    for (;;)
    {
      localaool.mMd5 = paramakxl.md5;
      localaool.apQ = paramakxl.groupFileID;
      localaool.dQF = paramakxl.subVersion;
      localaool.mBusiType = paramakxl.busiType;
      localaool.mNeedReport = true;
      localaool.dpB = paramakxl.dpC;
      localaool.mMsgTime = paramakxl.time;
      return localaool;
      bool = false;
      break;
      label374:
      paramString.cms = paramakxl.thumbMsgUrl;
      continue;
      label385:
      if (localaool.mFileType == 1)
      {
        paramString.cms = paramakxl.bigMsgUrl;
        if (paramakxl.reportInfo != null)
        {
          paramakxl.reportInfo.dpW = paramakxl.dpC;
          paramakxl.reportInfo.dpX = akxo.Hi();
          paramakxl.reportInfo.afC = (System.currentTimeMillis() - paramakxl.reportInfo.afA);
          paramakxl.reportInfo.dpS = 2;
        }
      }
      else if (localaool.mFileType == 131075)
      {
        paramString.cms = paramakxl.rawMsgUrl;
        if (paramakxl.reportInfo != null)
        {
          paramakxl.reportInfo.dpW = paramakxl.dpC;
          paramakxl.reportInfo.dpX = akxo.Hi();
          paramakxl.reportInfo.afC = (System.currentTimeMillis() - paramakxl.reportInfo.afA);
          paramakxl.reportInfo.dpS = 2;
        }
      }
    }
  }
  
  private void a(akxq paramakxq, long paramLong)
  {
    long l;
    Map localMap;
    if (paramakxq.j != null)
    {
      l = paramakxq.j.uniseq;
      Integer localInteger2 = Integer.valueOf(-1);
      if (paramakxq.j == null) {
        break label108;
      }
      localMap = paramakxq.j.forwardId;
      localInteger1 = localInteger2;
      if (localMap != null)
      {
        localInteger1 = localInteger2;
        if (localMap.size() <= 0) {}
      }
    }
    label108:
    for (Integer localInteger1 = (Integer)localMap.remove(paramakxq);; localInteger1 = Integer.valueOf(paramakxq.bEW))
    {
      if ((localInteger1 != null) && (localInteger1.intValue() > 0)) {
        wte.a().i(paramLong, l, localInteger1.intValue());
      }
      return;
      l = 0L;
      break;
    }
  }
  
  private boolean a(akxl paramakxl)
  {
    if (paramakxl != null)
    {
      akxe.M(this.logTag, this.bUB, "checkPicDownloadInfo", "info:" + paramakxl);
      return paramakxl.check();
    }
    akxe.N(this.logTag, this.bUB, "checkPicDownloadInfo", "info == null");
    return false;
  }
  
  private boolean a(akxm paramakxm)
  {
    if (paramakxm != null)
    {
      akxe.M(this.logTag, this.bUB, "checkFowardPicInfo", "info:" + paramakxm);
      return paramakxm.check();
    }
    akxe.N(this.logTag, this.bUB, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void b(akxb.a parama)
  {
    MessageForPic localMessageForPic;
    if ((parama != null) && (this.e.j != null) && (parama.bUF != null))
    {
      localMessageForPic = this.e.j;
      parama = new File(parama.bUF);
      if ((localMessageForPic.imageType != 2000) && (GifDrawable.isGifFile(parama)))
      {
        localMessageForPic.imageType = 2000;
        localMessageForPic.serial();
        if (localMessageForPic.subMsgId != MessageForPic.defaultSuMsgId) {
          break label235;
        }
        parama = this.mApp.b().b(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
        if (!(parama instanceof MessageForStructing)) {
          break label191;
        }
        parama = (MessageForStructing)parama;
        if ((parama.structingMsg instanceof StructMsgForImageShare))
        {
          ansu localansu = ((StructMsgForImageShare)parama.structingMsg).getFirstImageElement();
          if (localansu != null)
          {
            akxe.M(this.logTag, this.bUB, "onDownload", "Update GIF flag of StructMsgForImageShare");
            localansu.j = localMessageForPic;
            this.mApp.b().c(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, parama.structingMsg.getBytes());
          }
        }
      }
    }
    label191:
    label235:
    do
    {
      do
      {
        return;
        akxe.M(this.logTag, this.bUB, "onDownload", "Update GIF flag of MessageForPic");
        this.mApp.b().c(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, localMessageForPic.msgData);
        return;
        parama = this.mApp.b().b(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
      } while (!(parama instanceof MessageForMixedMsg));
      parama = ((MessageForMixedMsg)parama).upateMessageForPic(localMessageForPic);
    } while (parama == null);
    akxe.M(this.logTag, this.bUB, "onDownload", "Update GIF flag of MessageForMixedMsg");
    this.mApp.b().c(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq, parama);
  }
  
  private void c(akxb.a parama)
  {
    ThreadManager.getFileThreadHandler().post(new BasePicOprerator.4(this, parama));
  }
  
  private void e(akxq paramakxq)
  {
    int i = 0;
    akxl localakxl = paramakxq.a;
    if (!a(localakxl))
    {
      paramakxq = new akxb.a();
      paramakxq.result = -1;
      paramakxq.a = localakxl.jdField_b_of_type_Akxn$a;
      a(paramakxq);
    }
    String str;
    label457:
    do
    {
      MessageForPic localMessageForPic;
      int j;
      aool localaool;
      long l;
      do
      {
        return;
        localMessageForPic = paramakxq.j;
        j = paramakxq.dpF;
        localaool = a(localakxl, localakxl.protocol);
        str = localaool.clR;
        l = new File(str).length();
        if ((1537 != j) || (l <= 0L) || (l >= paramakxq.j.size)) {
          break;
        }
        paramakxq = new akxb.a();
        paramakxq.result = 0;
        paramakxq.bUF = localaool.clR;
        paramakxq.md5 = localaool.mMd5;
        paramakxq.dpA = localaool.mFileType;
        paramakxq.dpB = localakxl.dpC;
        paramakxq.bjc = true;
        a(paramakxq);
      } while (!QLog.isDevelopLevel());
      QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():head download second pass " + str);
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      if (l == 0L)
      {
        localaool.dQG = 0;
        if (localMessageForPic.mDownloadLength == paramakxq.j.size)
        {
          localaool.dQH = 0;
          localStringBuilder.append("nofile:");
        }
      }
      for (;;)
      {
        localStringBuilder.append("mRequestOffset is " + localaool.dQG + ", mRequestLength is " + localaool.dQH + ", ");
        localStringBuilder.append("outPath is " + str);
        if (QLog.isDevelopLevel()) {
          QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
        }
        localaool.dQI = localMessageForPic.mShowLength;
        localaool.cmq = localakxl.xO();
        this.mApp.a().b(localaool);
        return;
        if (j != 1536) {
          i = localMessageForPic.mDownloadLength;
        }
        localaool.dQH = i;
        break;
        if (l >= paramakxq.j.size) {
          break label457;
        }
        localaool.dQG = localMessageForPic.mDownloadLength;
        localaool.dQH = 0;
        localStringBuilder.append("part1:");
      }
      paramakxq = new akxb.a();
      paramakxq.result = 0;
      paramakxq.bUF = localaool.clR;
      paramakxq.md5 = localaool.mMd5;
      paramakxq.dpA = localaool.mFileType;
      paramakxq.dpB = localakxl.dpC;
      paramakxq.bjc = false;
      a(paramakxq);
    } while (!QLog.isDevelopLevel());
    QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():complete download second pass" + str);
  }
  
  private void f(akxq paramakxq)
  {
    ThreadManager.post(new BasePicOprerator.2(this, paramakxq.c, paramakxq), 8, null, true);
  }
  
  private void g(akxq paramakxq)
  {
    ThreadManager.post(new BasePicOprerator.3(this, paramakxq), 8, null, true);
  }
  
  public static void p(MessageForPic paramMessageForPic)
  {
    int i = 1;
    if (paramMessageForPic.md5 == null) {}
    for (;;)
    {
      return;
      if (paramMessageForPic.fileSizeFlag == 1) {
        i = 131075;
      }
      Object localObject = aoop.b(paramMessageForPic.md5, i);
      if (localObject != null) {}
      for (localObject = ((URL)localObject).toString(); !aoiz.hasFile((String)localObject); localObject = null)
      {
        localObject = aoiz.getFilePath((String)localObject);
        aqhq.copyFile(paramMessageForPic.path, (String)localObject);
        return;
      }
    }
  }
  
  public aoom a(akxl paramakxl, URLDrawableHandler paramURLDrawableHandler, String paramString)
  {
    akxe.M(this.logTag, this.bUB, "downloadPicSync", "start " + Thread.currentThread().getId());
    if (a(paramakxl))
    {
      this.bUB = (this.bUB + "|" + paramakxl.uniseq);
      aooi localaooi = this.mApp.a();
      paramakxl.protocol = paramString;
      paramakxl = a(paramakxl, paramString);
      paramakxl.a = paramURLDrawableHandler;
      if ((paramakxl.en != null) && ((paramakxl.en instanceof aool.c))) {
        ((aool.c)paramakxl.en).a = paramURLDrawableHandler;
      }
      return localaooi.a(paramakxl);
    }
    paramURLDrawableHandler = new akxb.a();
    paramURLDrawableHandler.result = -1;
    paramURLDrawableHandler.a = paramakxl.jdField_b_of_type_Akxn$a;
    a(paramURLDrawableHandler);
    paramURLDrawableHandler = new aoom();
    paramURLDrawableHandler.mResult = -1;
    paramURLDrawableHandler.aqr = 9302L;
    if (paramakxl.jdField_b_of_type_Akxn$a != null)
    {
      paramURLDrawableHandler.clO = ("downloadPicSync," + paramakxl.jdField_b_of_type_Akxn$a.bUJ);
      return paramURLDrawableHandler;
    }
    paramURLDrawableHandler.clO = "downloadPicSync param check error";
    return paramURLDrawableHandler;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return this.F;
  }
  
  public void a(int paramInt, akxn.a parama)
  {
    akxr localakxr = new akxr();
    localakxr.e = this.e;
    localakxr.c = parama;
    localakxr.mResult = -1;
    m(paramInt, -1, localakxr);
    if (parama != null)
    {
      akxe.N(this.logTag, this.bUB, parama.bUI, parama.bUJ);
      return;
    }
    akxe.N(this.logTag, this.bUB, "handleError", "unkown err,err == null");
  }
  
  public void a(akxb.a parama)
  {
    if (this.e != null)
    {
      b(parama);
      c(parama);
      if (parama != null) {
        break label50;
      }
      parama = new akxn.a();
      parama.bUJ = "result == null";
      parama.bUI = "onDownload";
      a(0, parama);
    }
    for (;;)
    {
      return;
      label50:
      akxe.M(this.logTag, this.bUB, "onDownload", "result:" + parama.result);
      Object localObject = new akxr();
      ((akxr)localObject).mResult = parama.result;
      ((akxr)localObject).en = parama;
      ((akxr)localObject).bjc = parama.bjc;
      if (parama.result == 0) {
        e(0, (akxr)localObject);
      }
      while (this.e.dpE == 3)
      {
        if (parama.result != 0) {
          break label267;
        }
        this.e.c.jdField_b_of_type_Akxy.localPath = parama.bUF;
        akxe.M(this.logTag, this.bUB, "onDownload", "dowanload pic success,is to forward the pic");
        g(this.e);
        return;
        if (parama.a == null)
        {
          localObject = new akxn.a();
          ((akxn.a)localObject).bUJ = (parama.errCode + "_" + parama.errStr);
          ((akxn.a)localObject).bUI = "onDownload";
          a(0, (akxn.a)localObject);
        }
        else
        {
          a(0, parama.a);
        }
      }
    }
    label267:
    a(4, this.e.c.jdField_b_of_type_Akxn$a);
  }
  
  public void a(akxq paramakxq)
  {
    akxe.M(this.logTag, this.bUB, "sendPic.start", "");
    if (b(paramakxq.jdField_b_of_type_Akxy))
    {
      b(paramakxq);
      return;
    }
    a(3, paramakxq.jdField_b_of_type_Akxy.jdField_b_of_type_Akxn$a);
  }
  
  public void a(akxq paramakxq, akxy paramakxy)
  {
    this.mApp.getHwEngine().preConnect();
    Object localObject = new CompressInfo(paramakxy.localPath, 0);
    akyj.c((CompressInfo)localObject);
    if (((CompressInfo)localObject).destPath != null)
    {
      paramakxy.thumbPath = ((CompressInfo)localObject).destPath;
      paramakxy.thumbWidth = ((CompressInfo)localObject).dpx;
      paramakxy.thumbHeight = ((CompressInfo)localObject).dpy;
    }
    if ((paramakxy.isBlessPic) && (paramakxy.message != null)) {}
    for (localObject = (MessageForPic)paramakxy.message; localObject == null; localObject = a(paramakxy))
    {
      akxe.a(this.logTag, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject).msgVia);
    }
    wte.a().i(((MessageRecord)localObject).uniseq, 0L, paramakxq.bEW);
    if (MessageForPic.class.isInstance(localObject))
    {
      a(paramakxq, (MessageRecord)localObject, paramakxy);
      p((MessageForPic)localObject);
    }
    if ((((MessageRecord)localObject).istroop == 1) && (paramakxy.jdField_a_of_type_Akxy$b == null)) {
      jof.a().a((MessageRecord)localObject);
    }
    if (paramakxy.cuZ) {
      try
      {
        paramakxy.picExtraObject = localObject;
        paramakxy.notifyAll();
        akxe.a(this.logTag, "doSendPic ", "PresendStatus: destPath:" + paramakxy.localPath + ",uuid:" + this.bUB + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (paramakxy.picExtraFlag == 3)
        {
          akxe.M(this.logTag, this.bUB, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          akxe.a(this.logTag, "doSendPic", "PresendStatus: destPath:" + paramakxy.localPath + ",uuid:" + this.bUB + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
      finally {}
    }
    this.F = ((MessageRecord)localObject);
    long l = System.currentTimeMillis();
    paramakxq = new aool();
    paramakxq.mSelfUin = this.mApp.getAccount();
    paramakxq.mPeerUin = ((MessageRecord)localObject).frienduin;
    paramakxq.cmn = ((MessageRecord)localObject).senderuin;
    paramakxq.mUinType = ((MessageRecord)localObject).istroop;
    paramakxq.mFileType = 1;
    paramakxq.mUniseq = ((MessageRecord)localObject).uniseq;
    paramakxq.cNy = true;
    paramakxq.mBusiType = paramakxy.busiType;
    paramakxq.dQ = paramakxy.localPath;
    paramakxq.mMd5 = paramakxy.md5;
    aool.d locald = new aool.d();
    if (paramakxy.getProtocolType() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      locald.cNJ = bool;
      paramakxq.en = locald;
      paramakxq.jdField_b_of_type_Akyf = this;
      paramakxq.F = this.F;
      paramakxq.cND = paramakxy.cuZ;
      paramakxq.cvb = paramakxy.cvb;
      if (!paramakxy.cuZ) {
        break label822;
      }
      try
      {
        if (!paramakxy.cva) {
          break;
        }
        akxe.M(this.logTag, this.bUB, "PresendPic doSendPic cancel transferAsync!", "");
        akxe.a(this.logTag, "doSendPic ", "PresendStatus: destPath:" + paramakxy.localPath + ",uuid:" + this.bUB + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
      finally {}
    }
    akxe.M(this.logTag, this.bUB, "PresendPic doSendPic start transferAsync!", "");
    this.mApp.a().a(paramakxq);
    akxe.a(this.logTag, "doSendPic ", "PresendStatus: destPath:" + paramakxy.localPath + ",uuid:" + this.bUB + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      akxe.M(this.logTag, this.bUB, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((paramakxy.cuY) && (!paramakxy.cuZ))
      {
        akxe.M(this.logTag, this.bUB, "sendPic", "@#addMsg");
        b((MessageRecord)localObject, paramakxy.aeM);
      }
      akxe.M(this.logTag, this.bUB, "getSendTask.start", "");
      return;
      label822:
      this.mApp.a().a(paramakxq);
    }
  }
  
  protected void a(akxq paramakxq, MessageRecord paramMessageRecord, akxy paramakxy)
  {
    if (paramakxq.jdField_b_of_type_ComTencentMobileqqDataPicMessageExtraData != null)
    {
      ((MessageForPic)paramMessageRecord).picExtraData = paramakxq.jdField_b_of_type_ComTencentMobileqqDataPicMessageExtraData;
      paramakxq = paramakxq.jdField_b_of_type_ComTencentMobileqqDataPicMessageExtraData;
      if (paramakxq.stickerInfo != null) {
        paramMessageRecord.saveExtInfoToExtStr("sticker_info", paramakxq.stickerInfo.toJsonString());
      }
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sticker_info")))
      {
        EmojiStickerManager.a(paramMessageRecord, null);
        EmojiStickerManager.a().aj(paramMessageRecord);
      }
    }
    if (((MessageForPic)paramMessageRecord).checkGif())
    {
      paramakxq = ((MessageForPic)paramMessageRecord).picExtraData;
      if (paramakxq != null) {
        break label257;
      }
      paramakxq = new PicMessageExtraData();
    }
    label257:
    for (;;)
    {
      if (TextUtils.isEmpty(paramakxq.textSummary)) {
        paramakxq.textSummary = BaseApplicationImpl.getApplication().getString(2131692307);
      }
      paramakxq.emojiPkgId = String.valueOf(paramakxy.dpN);
      paramakxq.from = paramakxy.from;
      paramakxq.source = paramakxy.source;
      paramakxq.webUrl = paramakxy.webUrl;
      paramakxq.iconUrl = paramakxy.iconUrl;
      paramakxq.packageName = paramakxy.packageName;
      ((MessageForPic)paramMessageRecord).picExtraData = paramakxq;
      if ((paramakxy.jdField_a_of_type_Akxx != null) && (!TextUtils.isEmpty(paramakxy.jdField_a_of_type_Akxx.bUK)))
      {
        PicMessageExtraData localPicMessageExtraData = ((MessageForPic)paramMessageRecord).picExtraData;
        paramakxq = localPicMessageExtraData;
        if (localPicMessageExtraData == null) {
          paramakxq = new PicMessageExtraData();
        }
        paramakxq.mTemplateId = paramakxy.jdField_a_of_type_Akxx.bUK;
        paramakxq.mTemplateName = paramakxy.jdField_a_of_type_Akxx.bUL;
        ((MessageForPic)paramMessageRecord).picExtraData = paramakxq;
      }
      return;
    }
  }
  
  public void a(akye paramakye)
  {
    this.a = paramakye;
  }
  
  public void aS(int paramInt, boolean paramBoolean)
  {
    akxr localakxr = new akxr();
    localakxr.mResult = 0;
    localakxr.en = Integer.valueOf(paramInt);
    localakxr.Wl = paramBoolean;
    m(1, 0, localakxr);
  }
  
  public void ar(MessageRecord paramMessageRecord)
  {
    ((ambj)this.mApp.getManager(326)).d(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  protected void b(akxq paramakxq)
  {
    akxy localakxy = paramakxq.jdField_b_of_type_Akxy;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new BasePicOprerator.5(this, paramakxq, localakxy), 8, null, false);
      return;
    }
    a(paramakxq, localakxy);
  }
  
  public void b(akyf.a parama)
  {
    if (parama == null) {
      a(3, null);
    }
    do
    {
      do
      {
        return;
      } while (this.e == null);
      if ((this.e.dpE == 2) || (this.e.dpE == 4))
      {
        if (parama.result == 0)
        {
          a(parama);
          localObject = (akxv)this.mApp.getManager(73);
          if (localObject != null) {
            ((akxv)localObject).al(13057, parama.size);
          }
          localObject = new akxr();
          ((akxr)localObject).mResult = 0;
          ((akxr)localObject).en = parama;
          e(3, (akxr)localObject);
          return;
        }
        localObject = new akxn.a();
        ((akxn.a)localObject).bUJ = parama.errStr;
        a(3, (akxn.a)localObject);
        return;
      }
    } while (this.e.dpE != 3);
    if (parama.result == 0)
    {
      a(parama);
      localObject = (akxv)this.mApp.getManager(73);
      if (localObject != null) {
        ((akxv)localObject).al(13058, parama.size);
      }
      localObject = new akxr();
      ((akxr)localObject).mResult = 0;
      ((akxr)localObject).en = parama;
      e(4, (akxr)localObject);
      return;
    }
    if (parama.errCode == 9333)
    {
      this.e.c.a.busiType = 3;
      this.e.c.a.protocol = "chatimg";
      if (this.e.c.jdField_b_of_type_Akxy.dpK == 1) {}
      for (int i = 7;; i = 6)
      {
        akxe.M(this.logTag, this.bUB, "onSend", "fastForward md5 missed,is to Download the pic");
        this.mApp.b().b(this.F, false);
        parama = akxj.a(i, 3);
        this.F = a(this.e.c);
        parama.a((MessageForPic)this.F, this.e.c.a);
        d(parama);
        return;
      }
    }
    Object localObject = new akxn.a();
    ((akxn.a)localObject).bUJ = parama.errStr;
    ((akxn.a)localObject).bUI = String.valueOf(parama.errCode);
    a(4, (akxn.a)localObject);
  }
  
  public void b(MessageRecord paramMessageRecord, long paramLong)
  {
    ambj localambj = (ambj)this.mApp.getManager(326);
    localambj.p(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localambj.d(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  protected boolean b(akxy paramakxy)
  {
    if (paramakxy != null)
    {
      akxe.M(this.logTag, this.bUB, "checkPicUploadInfo", "info:" + paramakxy);
      return paramakxy.check();
    }
    akxe.N(this.logTag, this.bUB, "checkPicUploadInfo", "info == null");
    return false;
  }
  
  public void c(akxq paramakxq)
  {
    akxm localakxm = paramakxq.c;
    if (!a(localakxm))
    {
      a(4, localakxm.jdField_b_of_type_Akxn$a);
      return;
    }
    if (aqhq.fileExistsAndNotEmpty(localakxm.jdField_b_of_type_Akxy.localPath))
    {
      localakxm.cuW = true;
      this.F = a(localakxm);
      g(paramakxq);
      return;
    }
    if (localakxm.jdField_b_of_type_Akxy.hasFile())
    {
      File localFile = localakxm.jdField_b_of_type_Akxy.getFile();
      if (localFile != null) {
        localakxm.jdField_b_of_type_Akxy.localPath = localFile.toString();
      }
      localakxm.cuW = true;
      this.F = a(localakxm);
      g(paramakxq);
      return;
    }
    localakxm.cuW = true;
    this.F = a(localakxm);
    if ((localakxm.jdField_b_of_type_Akxy.md5 == null) || (localakxm.jdField_b_of_type_Akxy.aeI == 0L) || (localakxm.jdField_b_of_type_Akxy.dpI == 0) || (localakxm.jdField_b_of_type_Akxy.dpJ == 0))
    {
      localakxm.a.busiType = 3;
      localakxm.a.protocol = "chatimg";
      if (localakxm.jdField_b_of_type_Akxy.dpK == 1) {}
      for (int i = 7;; i = 6)
      {
        paramakxq = akxj.a(i, 3);
        paramakxq.a((MessageForPic)this.F, localakxm.a);
        d(paramakxq);
        return;
      }
    }
    f(paramakxq);
  }
  
  public void d(akxq paramakxq)
  {
    akxe.M(this.logTag, this.bUB, "downloadPic", "start " + Thread.currentThread().getId());
    akxl localakxl = paramakxq.a;
    if (a(localakxl))
    {
      this.bUB = (this.bUB + "|" + localakxl.uniseq);
      if (!localakxl.protocol.equals("chatimg"))
      {
        paramakxq = a(localakxl, localakxl.protocol);
        if (!new File(paramakxq.clR).exists())
        {
          this.mApp.a().b(paramakxq);
          return;
        }
        akxb.a locala = new akxb.a();
        locala.result = 0;
        locala.bUF = paramakxq.clR;
        locala.md5 = paramakxq.mMd5;
        locala.dpA = paramakxq.mFileType;
        locala.dpB = localakxl.dpC;
        a(locala);
        return;
      }
      e(paramakxq);
      return;
    }
    paramakxq = new akxb.a();
    paramakxq.result = -1;
    paramakxq.a = localakxl.jdField_b_of_type_Akxn$a;
    a(paramakxq);
  }
  
  public void dDH()
  {
    if (this.dpt >= this.iG.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, String.format("createPicsUploadTask total:%d finished and notifyUI", new Object[] { Integer.valueOf(this.iG.size()) }));
      }
      m(5, 0, this.ys);
      return;
    }
    if (this.dpt + dpu < this.iG.size()) {}
    for (int i = this.dpt + dpu;; i = this.iG.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, String.format("createPicsUploadTask startIdx:%d, finishIdx:%d", new Object[] { Integer.valueOf(this.dpt), Integer.valueOf(i) }));
      }
      List localList = this.iG.subList(this.dpt, i);
      this.dpt = i;
      new akwv.a(this.mApp, localList).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return;
    }
  }
  
  protected void e(int paramInt, akxr paramakxr)
  {
    akxr localakxr = paramakxr;
    if (paramakxr == null) {
      localakxr = new akxr();
    }
    localakxr.mResult = 0;
    localakxr.e = this.e;
    m(paramInt, 0, localakxr);
    akxe.M(this.logTag, this.bUB, "handleSuccess", "what:" + paramInt);
  }
  
  public void eE(ArrayList<akxm> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      m(5, -1, null);
      return;
    }
    ((akxm)paramArrayList.get(0)).cuW = true;
    this.F = a((akxm)paramArrayList.get(0));
    this.ys = new ArrayList(paramArrayList.size());
    this.iG = paramArrayList;
    this.dpt = 0;
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] start");
    }
    dDH();
  }
  
  protected void m(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.handler.sendMessage(localMessage);
  }
  
  public class a
    extends AsyncTask<Void, Void, Void>
  {
    final aoqm.a a = new akwx(this);
    boolean cuL = false;
    WeakReference<QQAppInterface> n;
    List<akxm> xq;
    ArrayList<akxr> yt;
    
    public a(List<akxm> paramList)
    {
      this.n = new WeakReference(paramList);
      Object localObject;
      this.xq = localObject;
    }
    
    private String a(im_msg_body.CustomFace paramCustomFace)
    {
      if ((!QLog.isColorLevel()) || (paramCustomFace == null)) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[CustomFace]uint32_server_ip:" + paramCustomFace.uint32_server_ip.get());
      localStringBuilder.append(",uint32_server_port:" + paramCustomFace.uint32_server_port.get());
      localStringBuilder.append(",uint32_file_id:" + paramCustomFace.uint32_file_id.get());
      localStringBuilder.append(",bytes_md5:" + HexUtil.bytes2HexStr(paramCustomFace.bytes_md5.get().toByteArray()));
      localStringBuilder.append(",str_file_path:" + paramCustomFace.str_file_path.get());
      localStringBuilder.append(",uint32_origin:" + paramCustomFace.uint32_origin.get());
      localStringBuilder.append(",uint32_width:" + paramCustomFace.uint32_width.get());
      localStringBuilder.append(",uint32_height:" + paramCustomFace.uint32_height.get());
      localStringBuilder.append(",uint32_height:" + paramCustomFace.uint32_height.get());
      localStringBuilder.append(",image_type:" + paramCustomFace.image_type.get());
      return localStringBuilder.toString();
    }
    
    private String a(im_msg_body.NotOnlineImage paramNotOnlineImage)
    {
      if ((!QLog.isColorLevel()) || (paramNotOnlineImage == null)) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[NotOnlineImage]file_path:" + paramNotOnlineImage.file_path.get().toStringUtf8());
      localStringBuilder.append(",file_len:" + paramNotOnlineImage.file_len.get());
      localStringBuilder.append(",download_path:" + paramNotOnlineImage.download_path.get().toStringUtf8());
      localStringBuilder.append(",res_id:" + paramNotOnlineImage.res_id.get().toStringUtf8());
      localStringBuilder.append(",pic_md5:" + HexUtil.bytes2HexStr(paramNotOnlineImage.pic_md5.get().toByteArray()));
      localStringBuilder.append(",pic_height:" + paramNotOnlineImage.pic_height.get());
      localStringBuilder.append(",pic_width:" + paramNotOnlineImage.pic_width.get());
      localStringBuilder.append(",original:" + paramNotOnlineImage.original.get());
      localStringBuilder.append(",img_type:" + paramNotOnlineImage.img_type.get());
      localStringBuilder.append(",uint32_file_id:" + paramNotOnlineImage.uint32_file_id.get());
      return localStringBuilder.toString();
    }
    
    private void dDI()
    {
      akwv.this.ys.addAll(this.yt);
      akwv.this.dDH();
    }
    
    im_msg_body.CustomFace a(aoql.a.i parami, aoql.b.e parame, int paramInt)
    {
      im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
      for (;;)
      {
        akxm localakxm;
        try
        {
          localakxm = (akxm)this.xq.get(paramInt);
          if (parame != null)
          {
            localCustomFace.uint32_file_id.set((int)parame.groupFileID);
            if ((parame.xp != null) && (parame.xp.size() > 0))
            {
              parame = (aonh)parame.xp.get(0);
              localCustomFace.uint32_server_ip.set(aokv.eD(parame.mIp));
              localCustomFace.uint32_server_port.set(parame.port);
            }
            localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
            localCustomFace.uint32_useful.set(1);
            if (((QQAppInterface)this.n.get()).getSessionKey() != null) {
              localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.n.get()).getSessionKey()));
            }
            if (parami == null) {
              break label451;
            }
            localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(parami.md5));
            localCustomFace.str_file_path.set(parami.fileName);
            parame = localCustomFace.uint32_origin;
            if (parami.cMs)
            {
              i = 1;
              parame.set(i);
              localCustomFace.uint32_width.set(parami.width);
              localCustomFace.uint32_height.set(parami.height);
              localCustomFace.uint32_size.set((int)parami.fileSize);
              localCustomFace.biz_type.set(4);
              localCustomFace.uint32_source.set(104);
              localCustomFace.uint32_thumb_width.set(localakxm.b.thumbWidth);
              localCustomFace.uint32_thumb_height.set(localakxm.b.thumbHeight);
              localCustomFace.image_type.set(localakxm.b.dpL);
              akxe.M(akwv.this.logTag, akwv.this.bUB, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] OK, " + a(localCustomFace));
              return localCustomFace;
            }
          }
          else
          {
            localCustomFace.uint32_file_id.set(0);
            continue;
          }
          int i = 0;
        }
        catch (Exception parami)
        {
          akxe.N(akwv.this.logTag, akwv.this.bUB, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] failed, Exception, " + parami.toString());
          return null;
        }
        continue;
        label451:
        localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
        localCustomFace.str_file_path.set("bad");
        localCustomFace.uint32_origin.set(0);
        localCustomFace.uint32_width.set(localakxm.b.dpI);
        localCustomFace.uint32_height.set(localakxm.b.dpJ);
        localCustomFace.uint32_size.set(0);
      }
    }
    
    im_msg_body.NotOnlineImage a(aoql.a.i parami, aoql.b.b paramb, int paramInt)
    {
      int i = 0;
      im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
      for (;;)
      {
        try
        {
          akxm localakxm = (akxm)this.xq.get(paramInt);
          if (parami != null)
          {
            localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(parami.fileName));
            localNotOnlineImage.file_len.set((int)parami.fileSize);
            localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(parami.md5));
            localNotOnlineImage.pic_height.set(parami.height);
            localNotOnlineImage.pic_width.set(parami.width);
            PBUInt32Field localPBUInt32Field = localNotOnlineImage.original;
            if (parami.cMs) {
              i = 1;
            }
            localPBUInt32Field.set(i);
            if (paramb != null)
            {
              if (paramb.mUuid != null) {
                localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8(paramb.mUuid));
              }
              if (paramb.mResid != null) {
                localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8(paramb.mResid));
              }
              localNotOnlineImage.img_type.set(localakxm.b.dpL);
              localNotOnlineImage.biz_type.set(4);
              localNotOnlineImage.uint32_thumb_width.set(localakxm.b.thumbWidth);
              localNotOnlineImage.uint32_thumb_height.set(localakxm.b.thumbHeight);
              akxe.M(akwv.this.logTag, akwv.this.bUB, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] OK, " + a(localNotOnlineImage));
              return localNotOnlineImage;
            }
          }
          else
          {
            localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8("bad"));
            localNotOnlineImage.file_len.set(0);
            localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
            localNotOnlineImage.pic_height.set(localakxm.b.dpJ);
            localNotOnlineImage.pic_width.set(localakxm.b.dpI);
            localNotOnlineImage.original.set(0);
            continue;
          }
          localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("bad"));
        }
        catch (Exception parami)
        {
          akxe.M(akwv.this.logTag, akwv.this.bUB, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] failed, Exception" + parami.toString());
          return null;
        }
        localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8("bad"));
      }
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "doInBackground start isReMiao =  " + this.cuL);
      }
      if (!this.cuL) {
        this.yt = new ArrayList(this.xq.size());
      }
      aoql.a locala = new aoql.a();
      int i = 0;
      if (i < this.xq.size())
      {
        akxm localakxm = (akxm)this.xq.get(i);
        if (!this.cuL)
        {
          paramVarArgs = new akxr();
          paramVarArgs.e = akwv.this.e;
          this.yt.add(paramVarArgs);
        }
        aoql.a.i locali = new aoql.a.i();
        locali.selfUin = ((QQAppInterface)this.n.get()).getAccount();
        locali.peerUin = akwv.this.F.frienduin;
        locali.uinType = akwv.this.F.istroop;
        locali.cmC = akwv.this.F.senderuin;
        boolean bool;
        if (locali.uinType == 1006)
        {
          bool = true;
          label222:
          locali.cNW = bool;
          locali.md5 = HexUtil.hexStr2Bytes(localakxm.b.md5);
          if (localakxm.b.dpK != 1) {
            break label511;
          }
          bool = true;
          label258:
          locali.cMs = bool;
          if (localakxm.dpD == 2) {
            locali.cMs = true;
          }
          if ((localakxm.b.dpI == 0) || (localakxm.b.dpJ == 0) || (0L == localakxm.b.aeI)) {
            break label516;
          }
          akxe.M(akwv.this.logTag, akwv.this.bUB, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from UploadInfo");
          locali.width = localakxm.b.dpI;
          locali.height = localakxm.b.dpJ;
          locali.fileSize = localakxm.b.aeI;
          label399:
          if ((locali.uinType != 1) && (locali.uinType != 3000)) {
            break label748;
          }
          akxe.M(akwv.this.logTag, akwv.this.bUB, "uploadForwardMultiMsgPics", "[" + i + "] is Troop/Discussion message");
        }
        for (locala.cmy = "grp_pic_up";; locala.cmy = "c2c_pic_up")
        {
          locali.fileName = localakxm.b.md5;
          locala.He.add(locali);
          i += 1;
          break;
          bool = false;
          break label222;
          label511:
          bool = false;
          break label258;
          label516:
          akxe.M(akwv.this.logTag, akwv.this.bUB, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File");
          if (aqhq.fileExistsAndNotEmpty(localakxm.b.localPath)) {
            paramVarArgs = localakxm.b.localPath;
          }
          for (;;)
          {
            if (!aqhq.fileExistsAndNotEmpty(paramVarArgs)) {
              break label695;
            }
            BitmapFactory.Options localOptions = new BitmapFactory.Options();
            localOptions.inJustDecodeBounds = true;
            SafeBitmapFactory.decodeFile(paramVarArgs, localOptions);
            locali.width = localOptions.outWidth;
            locali.height = localOptions.outHeight;
            locali.fileSize = ahbj.getFileSize(paramVarArgs);
            break;
            if (locali.cMs) {}
            for (paramVarArgs = aoop.a(localakxm, 131075, null);; paramVarArgs = aoop.a(localakxm, 1, null))
            {
              if (paramVarArgs == null) {
                break label690;
              }
              paramVarArgs = aoiz.getFilePath(paramVarArgs.toString());
              break;
            }
            label690:
            paramVarArgs = null;
          }
          label695:
          akxe.M(akwv.this.logTag, akwv.this.bUB, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File failed, targetPicFilepath = " + paramVarArgs);
          break label399;
          label748:
          akxe.M(akwv.this.logTag, akwv.this.bUB, "uploadForwardMultiMsgPics", "[" + i + "] is C2C message");
        }
      }
      if (!locala.He.isEmpty())
      {
        locala.b = this.a;
        locala.a = ((QQAppInterface)this.n.get()).getProtoReqManager();
        akxe.M(akwv.this.logTag, akwv.this.bUB, "uploadForwardMultiMsgPics", "requestStart:" + locala.toString());
        aoqm.c(locala);
        return null;
      }
      dDI();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akwv
 * JD-Core Version:    0.7.0.1
 */