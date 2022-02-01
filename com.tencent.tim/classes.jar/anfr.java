import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class anfr
{
  public static long akU;
  public static long akV;
  public static boolean cFn;
  
  static anfh a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
      return new anff();
    case 1: 
      return new szb();
    }
    return new sza();
  }
  
  public static anfw a(int paramInt, Object paramObject, angi paramangi)
  {
    anfh localanfh = a(paramInt);
    if (localanfh == null) {
      return null;
    }
    return localanfh.a(paramObject, paramangi);
  }
  
  public static angi a(int paramInt1, int paramInt2)
  {
    angi localangi = new angi();
    localangi.dFq = paramInt1;
    localangi.dFl = paramInt2;
    return localangi;
  }
  
  public static angi a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoBusiManager", 2, "createShortVideoReqByMsg expired");
      }
      return null;
    }
    angi localangi = a(2, paramMessageForShortVideo.busiType);
    anfu localanfu = paramMessageForShortVideo.getDownloadInfo(localangi.dFl);
    localanfu.localPath = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localanfu.mRequestType = paramInt;
    if ((paramMessageForShortVideo instanceof MessageForLightVideo))
    {
      localanfu.cFo = false;
      paramQQAppInterface = paramQQAppInterface.b();
      if ((!paramQQAppInterface.Op()) || (!paramQQAppInterface.oA().equals(paramMessageForShortVideo.frienduin))) {
        break label161;
      }
      localanfu.mSceneType = 2;
      label107:
      if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008)) {
        break label170;
      }
      localanfu.fileType = 1001;
    }
    for (;;)
    {
      localangi.c(localanfu);
      localangi.p(paramMessageForShortVideo);
      return localangi;
      if (paramMessageForShortVideo.busiType != 0) {
        break;
      }
      localanfu.cFo = true;
      break;
      label161:
      localanfu.mSceneType = 1;
      break label107;
      label170:
      if (paramMessageForShortVideo.istroop == 3000) {
        localanfu.fileType = 1005;
      } else if (paramMessageForShortVideo.istroop == 1) {
        localanfu.fileType = 1003;
      }
    }
  }
  
  public static angt a(int paramInt, Object paramObject, angi paramangi)
  {
    anfh localanfh = a(paramInt);
    if (localanfh == null) {
      return null;
    }
    return localanfh.a(paramObject, paramangi);
  }
  
  public static angt a(Object paramObject, angi paramangi)
  {
    anfh localanfh = a(paramangi.dFl);
    if (localanfh == null) {
      return null;
    }
    return localanfh.a(paramObject, paramangi);
  }
  
  static BaseShortVideoOprerator a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
      return new anff(paramQQAppInterface);
    case 1: 
      return new szb(paramQQAppInterface);
    }
    return new sza(paramQQAppInterface);
  }
  
  public static void a(angi paramangi, QQAppInterface paramQQAppInterface)
  {
    if (paramangi == null)
    {
      akxe.b("ShortVideoBusiManager", "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(paramangi.dFl, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      akxe.b("ShortVideoBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramangi.dFl);
      return;
    }
    localBaseShortVideoOprerator.mApp = paramQQAppInterface;
    localBaseShortVideoOprerator.b = paramangi;
    localBaseShortVideoOprerator.bUB = paramangi.cdE;
    localBaseShortVideoOprerator.logTag = paramangi.logTag;
    localBaseShortVideoOprerator.a(paramangi.c);
    akxe.a("ShortVideoBusiManager", "launch", "cmd:" + ShortVideoUtils.fg(paramangi.dFq) + ", reqBusiType" + paramangi.dFl + ", uuid:" + paramangi.cdE);
    switch (paramangi.dFq)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(paramangi.d);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(paramangi.jdField_b_of_type_Anfu);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(paramangi.d);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(paramangi.jdField_b_of_type_Anfw);
      return;
    case 4: 
      localBaseShortVideoOprerator.a(paramangi.jdField_b_of_type_Anfw);
      return;
    }
    localBaseShortVideoOprerator.eR(paramangi.yu);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, aoko paramaoko, aool paramaool)
  {
    if ((paramaoko == null) || (paramaool == null)) {
      akxe.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "fileMsg or req is null");
    }
    label498:
    do
    {
      MessageRecord localMessageRecord;
      MessageForShortVideo localMessageForShortVideo;
      do
      {
        do
        {
          return;
          if (paramaool.F != null) {
            localMessageRecord = paramaool.F;
          }
          while (localMessageRecord == null)
          {
            akxe.b("ShortVideoBusiManager", "updataMessageDataBaseContent", "msg null");
            return;
            localMessageRecord = paramQQAppInterface.b().a(paramaool.mPeerUin, paramaool.mUinType, paramaool.mUniseq);
            akxe.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "findmsgbyMsgId,need fix");
          }
        } while (!(localMessageRecord instanceof MessageForShortVideo));
        localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
        if (paramaoko.fileSize == 0L) {}
        for (int i = 0;; i = (int)(100L * paramaoko.transferedSize / paramaoko.fileSize))
        {
          if (localMessageForShortVideo.videoFileProgress < 0) {
            localMessageForShortVideo.videoFileProgress = 0;
          }
          int j = localMessageForShortVideo.videoFileProgress;
          if (((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) && (localMessageForShortVideo.videoFileStatus == paramaoko.status) && (i - j < 10)) {
            break;
          }
          if (localMessageForShortVideo.videoFileStatus == 1003) {
            localMessageForShortVideo.videoFileProgress = 100;
          }
          if ((paramaoko.fileType == 6) || (paramaoko.fileType == 17) || (paramaoko.fileType == 9) || (paramaoko.fileType == 20))
          {
            if (paramaoko.status == 2002) {
              localMessageForShortVideo.transferedSize = ((int)paramaoko.transferedSize);
            }
            if (paramaoko.status == 2003) {
              localMessageForShortVideo.transferedSize = 0;
            }
          }
          if (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((paramaoko.status == 1002) || (paramaoko.status == 2002))) {
            break;
          }
          localMessageForShortVideo.videoFileStatus = paramaoko.status;
          localMessageForShortVideo.fileType = paramaoko.fileType;
          if ((paramaoko.fileType != 7) && (paramaoko.fileType != 16) && (paramaoko.fileType != 18)) {
            localMessageForShortVideo.videoFileProgress = i;
          }
          if ((localMessageForShortVideo.mPreUpload) && (paramaoko.status == 1003) && (paramaool.mMd5 != null)) {
            localMessageForShortVideo.md5 = paramaool.mMd5;
          }
          if (paramaoko.status == 2003) {
            localMessageForShortVideo.lastModified = new File(paramaool.clR).lastModified();
          }
          localMessageForShortVideo.serial();
          if ((localMessageForShortVideo.isMultiMsg != true) && (paramaool.mBusiType != 1010)) {
            break label498;
          }
          if ((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) {
            break;
          }
          paramQQAppInterface = paramQQAppInterface.a();
          if (paramQQAppInterface == null) {
            break;
          }
          paramQQAppInterface.a(localMessageForShortVideo, null);
          return;
        }
      } while ((localMessageForShortVideo instanceof MessageForBlessPTV));
      paramQQAppInterface.b().c(paramaool.mPeerUin, paramaool.mUinType, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
    } while ((paramaoko.status != 1003) && (paramaoko.status != 2003));
    paramQQAppInterface.a().notifyUI(999, true, paramaool.mPeerUin);
    akxe.a("ShortVideoBusiManager", "updataMessageDataBaseContent", "app.getMsgHandler().notifyUI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anfr
 * JD-Core Version:    0.7.0.1
 */