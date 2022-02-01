import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import java.util.ArrayList;
import java.util.List;

public class amdj
{
  public static AIOFilePicData a(AIOFilePictureData paramAIOFilePictureData)
  {
    AIOFilePicData localAIOFilePicData = new AIOFilePicData();
    localAIOFilePicData.id = paramAIOFilePictureData.msgId;
    localAIOFilePicData.subId = paramAIOFilePictureData.subId;
    localAIOFilePicData.time = paramAIOFilePictureData.time;
    localAIOFilePicData.size = paramAIOFilePictureData.size;
    localAIOFilePicData.shmsgseq = paramAIOFilePictureData.shmsgseq;
    localAIOFilePicData.istroop = paramAIOFilePictureData.istroop;
    localAIOFilePicData.isMultiMsg = paramAIOFilePictureData.isMultiMsg;
    localAIOFilePicData.strUin = paramAIOFilePictureData.strUin;
    localAIOFilePicData.peerType = paramAIOFilePictureData.peerType;
    localAIOFilePicData.aVW = paramAIOFilePictureData.aVW;
    localAIOFilePicData.aVX = paramAIOFilePictureData.aVX;
    localAIOFilePicData.aVY = paramAIOFilePictureData.aVY;
    localAIOFilePicData.aVZ = paramAIOFilePictureData.aVZ;
    localAIOFilePicData.curUin = paramAIOFilePictureData.curUin;
    localAIOFilePicData.issend = paramAIOFilePictureData.issend;
    localAIOFilePicData.mFileName = paramAIOFilePictureData.mFileName;
    localAIOFilePicData.bip = paramAIOFilePictureData.bip;
    localAIOFilePicData.mFileSize = paramAIOFilePictureData.mFileSize;
    localAIOFilePicData.Jr = paramAIOFilePictureData.Jr;
    localAIOFilePicData.biq = paramAIOFilePictureData.biq;
    localAIOFilePicData.aWa = paramAIOFilePictureData.aWa;
    localAIOFilePicData.mMd5 = paramAIOFilePictureData.md5;
    return localAIOFilePicData;
  }
  
  public static com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData a(com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData paramAIOFileVideoData)
  {
    com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData localAIOFileVideoData = new com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData();
    localAIOFileVideoData.id = paramAIOFileVideoData.msgId;
    localAIOFileVideoData.subId = paramAIOFileVideoData.subId;
    localAIOFileVideoData.time = paramAIOFileVideoData.time;
    localAIOFileVideoData.size = paramAIOFileVideoData.size;
    localAIOFileVideoData.shmsgseq = paramAIOFileVideoData.shmsgseq;
    localAIOFileVideoData.istroop = paramAIOFileVideoData.istroop;
    localAIOFileVideoData.isMultiMsg = paramAIOFileVideoData.isMultiMsg;
    localAIOFileVideoData.bN = paramAIOFileVideoData.bN;
    localAIOFileVideoData.fileName = paramAIOFileVideoData.fileName;
    localAIOFileVideoData.mFilePath = paramAIOFileVideoData.mFilePath;
    localAIOFileVideoData.Js = paramAIOFileVideoData.Js;
    localAIOFileVideoData.width = paramAIOFileVideoData.width;
    localAIOFileVideoData.height = paramAIOFileVideoData.height;
    return localAIOFileVideoData;
  }
  
  public static AIOImageData a(AIOPictureData paramAIOPictureData)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.id = paramAIOPictureData.msgId;
    localAIOImageData.subId = paramAIOPictureData.subId;
    localAIOImageData.time = paramAIOPictureData.time;
    localAIOImageData.size = paramAIOPictureData.size;
    localAIOImageData.shmsgseq = paramAIOPictureData.shmsgseq;
    localAIOImageData.istroop = paramAIOPictureData.istroop;
    localAIOImageData.isMultiMsg = paramAIOPictureData.isMultiMsg;
    localAIOImageData.aVW = paramAIOPictureData.aVW;
    localAIOImageData.aVX = paramAIOPictureData.aVX;
    localAIOImageData.aVY = paramAIOPictureData.aVY;
    localAIOImageData.aVZ = paramAIOPictureData.aVZ;
    localAIOImageData.uuid = paramAIOPictureData.uuid;
    localAIOImageData.timestamp = paramAIOPictureData.timestamp;
    localAIOImageData.groupFileID = paramAIOPictureData.groupFileID;
    localAIOImageData.width = paramAIOPictureData.width;
    localAIOImageData.height = paramAIOPictureData.height;
    localAIOImageData.bjc = paramAIOPictureData.bjc;
    localAIOImageData.bjd = paramAIOPictureData.bjd;
    localAIOImageData.bje = paramAIOPictureData.bje;
    localAIOImageData.mImageType = paramAIOPictureData.mImageType;
    localAIOImageData.EP = paramAIOPictureData.EP;
    localAIOImageData.bQ = paramAIOPictureData.bQ;
    localAIOImageData.bjf = paramAIOPictureData.bjf;
    localAIOImageData.Jx = paramAIOPictureData.Jx;
    localAIOImageData.fileName = paramAIOPictureData.fileName;
    localAIOImageData.filePath = paramAIOPictureData.filePath;
    localAIOImageData.busId = paramAIOPictureData.busId;
    localAIOImageData.bWU = paramAIOPictureData.bWU;
    localAIOImageData.aWi = paramAIOPictureData.aWi;
    localAIOImageData.md5 = paramAIOPictureData.md5;
    localAIOImageData.aWj = paramAIOPictureData.aWj;
    localAIOImageData.send_uin = paramAIOPictureData.send_uin;
    localAIOImageData.bjg = paramAIOPictureData.bjg;
    localAIOImageData.imageBizType = paramAIOPictureData.imageBizType;
    localAIOImageData.isSend = paramAIOPictureData.isSend;
    localAIOImageData.aWk = paramAIOPictureData.aWk;
    localAIOImageData.bdq = paramAIOPictureData.bdq;
    localAIOImageData.TI = paramAIOPictureData.TI;
    localAIOImageData.content = paramAIOPictureData.content;
    localAIOImageData.mTemplateId = paramAIOPictureData.templateId;
    localAIOImageData.mTemplateName = paramAIOPictureData.templateName;
    return localAIOImageData;
  }
  
  public static AIORichMediaData a(AIOBrowserBaseData paramAIOBrowserBaseData)
  {
    if (paramAIOBrowserBaseData == null) {}
    do
    {
      return null;
      if ((paramAIOBrowserBaseData instanceof AIOPictureData)) {
        return a((AIOPictureData)paramAIOBrowserBaseData);
      }
      if ((paramAIOBrowserBaseData instanceof AIOFilePictureData)) {
        return a((AIOFilePictureData)paramAIOBrowserBaseData);
      }
      if ((paramAIOBrowserBaseData instanceof AIOVideoData)) {
        return a((AIOVideoData)paramAIOBrowserBaseData);
      }
    } while (!(paramAIOBrowserBaseData instanceof com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData));
    return a((com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData)paramAIOBrowserBaseData);
  }
  
  public static AIOShortVideoData a(AIOVideoData paramAIOVideoData)
  {
    AIOShortVideoData localAIOShortVideoData = new AIOShortVideoData();
    localAIOShortVideoData.id = paramAIOVideoData.msgId;
    localAIOShortVideoData.subId = paramAIOVideoData.subId;
    localAIOShortVideoData.time = paramAIOVideoData.time;
    localAIOShortVideoData.size = paramAIOVideoData.size;
    localAIOShortVideoData.shmsgseq = paramAIOVideoData.shmsgseq;
    localAIOShortVideoData.istroop = paramAIOVideoData.istroop;
    localAIOShortVideoData.isMultiMsg = paramAIOVideoData.isMultiMsg;
    localAIOShortVideoData.aWo = paramAIOVideoData.aWo;
    localAIOShortVideoData.aWp = paramAIOVideoData.aWp;
    localAIOShortVideoData.bqB = paramAIOVideoData.bqB;
    localAIOShortVideoData.mBusiType = paramAIOVideoData.mBusiType;
    localAIOShortVideoData.width = paramAIOVideoData.width;
    localAIOShortVideoData.height = paramAIOVideoData.height;
    localAIOShortVideoData.uniseq = paramAIOVideoData.uniseq;
    localAIOShortVideoData.redBagType = paramAIOVideoData.redBagType;
    localAIOShortVideoData.shortVideoId = paramAIOVideoData.shortVideoId;
    localAIOShortVideoData.senderUin = paramAIOVideoData.senderUin;
    localAIOShortVideoData.redBagStat = paramAIOVideoData.redBagStat;
    localAIOShortVideoData.friendUin = paramAIOVideoData.friendUin;
    localAIOShortVideoData.isSend = paramAIOVideoData.isSend;
    localAIOShortVideoData.specialVideoType = paramAIOVideoData.specialVideoType;
    localAIOShortVideoData.videoFileStatus = paramAIOVideoData.videoFileStatus;
    localAIOShortVideoData.mTemplateId = paramAIOVideoData.templateId;
    localAIOShortVideoData.mTemplateName = paramAIOVideoData.templateName;
    return localAIOShortVideoData;
  }
  
  public static AIOBrowserBaseData a(AIORichMediaData paramAIORichMediaData)
  {
    if (paramAIORichMediaData == null) {}
    do
    {
      return null;
      if ((paramAIORichMediaData instanceof AIOImageData)) {
        return a((AIOImageData)paramAIORichMediaData);
      }
      if ((paramAIORichMediaData instanceof AIOFilePicData)) {
        return a((AIOFilePicData)paramAIORichMediaData);
      }
      if ((paramAIORichMediaData instanceof AIOShortVideoData)) {
        return a((AIOShortVideoData)paramAIORichMediaData);
      }
    } while (!(paramAIORichMediaData instanceof com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData));
    return a((com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData)paramAIORichMediaData);
  }
  
  public static AIOFilePictureData a(AIOFilePicData paramAIOFilePicData)
  {
    AIOFilePictureData localAIOFilePictureData = new AIOFilePictureData();
    localAIOFilePictureData.msgId = paramAIOFilePicData.id;
    localAIOFilePictureData.subId = paramAIOFilePicData.subId;
    localAIOFilePictureData.time = paramAIOFilePicData.time;
    localAIOFilePictureData.size = paramAIOFilePicData.size;
    localAIOFilePictureData.shmsgseq = paramAIOFilePicData.shmsgseq;
    localAIOFilePictureData.istroop = paramAIOFilePicData.istroop;
    localAIOFilePictureData.isMultiMsg = paramAIOFilePicData.isMultiMsg;
    localAIOFilePictureData.isInMixedMsg = paramAIOFilePicData.isInMixedMsg;
    localAIOFilePictureData.bjq = paramAIOFilePicData.bjq;
    localAIOFilePictureData.strUin = paramAIOFilePicData.strUin;
    localAIOFilePictureData.peerType = paramAIOFilePicData.peerType;
    localAIOFilePictureData.aVW = paramAIOFilePicData.aVW;
    localAIOFilePictureData.aVX = paramAIOFilePicData.aVX;
    localAIOFilePictureData.aVY = paramAIOFilePicData.aVY;
    localAIOFilePictureData.aVZ = paramAIOFilePicData.aVZ;
    localAIOFilePictureData.curUin = paramAIOFilePicData.curUin;
    localAIOFilePictureData.issend = paramAIOFilePicData.issend;
    localAIOFilePictureData.mFileName = paramAIOFilePicData.mFileName;
    localAIOFilePictureData.bip = paramAIOFilePicData.bip;
    localAIOFilePictureData.mFileSize = paramAIOFilePicData.mFileSize;
    localAIOFilePictureData.Jr = paramAIOFilePicData.Jr;
    localAIOFilePictureData.biq = paramAIOFilePicData.biq;
    localAIOFilePictureData.aWa = paramAIOFilePicData.aWa;
    localAIOFilePictureData.md5 = paramAIOFilePicData.mMd5;
    localAIOFilePictureData.picWidth = paramAIOFilePicData.picWidth;
    localAIOFilePictureData.picHeight = paramAIOFilePicData.picHeight;
    localAIOFilePictureData.bWF = paramAIOFilePicData.bWF;
    return localAIOFilePictureData;
  }
  
  public static com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData a(com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData paramAIOFileVideoData)
  {
    com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData localAIOFileVideoData = new com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData();
    localAIOFileVideoData.msgId = paramAIOFileVideoData.id;
    localAIOFileVideoData.subId = paramAIOFileVideoData.subId;
    localAIOFileVideoData.time = paramAIOFileVideoData.time;
    localAIOFileVideoData.size = paramAIOFileVideoData.size;
    localAIOFileVideoData.shmsgseq = paramAIOFileVideoData.shmsgseq;
    localAIOFileVideoData.istroop = paramAIOFileVideoData.istroop;
    localAIOFileVideoData.isMultiMsg = paramAIOFileVideoData.isMultiMsg;
    localAIOFileVideoData.isInMixedMsg = paramAIOFileVideoData.isInMixedMsg;
    localAIOFileVideoData.bjq = paramAIOFileVideoData.bjq;
    localAIOFileVideoData.bN = paramAIOFileVideoData.bN;
    localAIOFileVideoData.fileName = paramAIOFileVideoData.fileName;
    localAIOFileVideoData.mFilePath = paramAIOFileVideoData.mFilePath;
    localAIOFileVideoData.Js = paramAIOFileVideoData.Js;
    localAIOFileVideoData.width = paramAIOFileVideoData.width;
    localAIOFileVideoData.height = paramAIOFileVideoData.height;
    localAIOFileVideoData.bit = paramAIOFileVideoData.bit;
    localAIOFileVideoData.strUin = paramAIOFileVideoData.strUin;
    localAIOFileVideoData.peerType = paramAIOFileVideoData.peerType;
    localAIOFileVideoData.isSend = paramAIOFileVideoData.isSend;
    localAIOFileVideoData.fileUuid = paramAIOFileVideoData.fileUuid;
    localAIOFileVideoData.md5 = paramAIOFileVideoData.md5;
    return localAIOFileVideoData;
  }
  
  public static AIOPictureData a(AIOImageData paramAIOImageData)
  {
    AIOPictureData localAIOPictureData = new AIOPictureData();
    localAIOPictureData.msgId = paramAIOImageData.id;
    localAIOPictureData.subId = paramAIOImageData.subId;
    localAIOPictureData.time = paramAIOImageData.time;
    localAIOPictureData.size = paramAIOImageData.size;
    localAIOPictureData.shmsgseq = paramAIOImageData.shmsgseq;
    localAIOPictureData.istroop = paramAIOImageData.istroop;
    localAIOPictureData.isMultiMsg = paramAIOImageData.isMultiMsg;
    localAIOPictureData.isInMixedMsg = paramAIOImageData.isInMixedMsg;
    localAIOPictureData.bjq = paramAIOImageData.bjq;
    localAIOPictureData.aVW = paramAIOImageData.aVW;
    localAIOPictureData.aVX = paramAIOImageData.aVX;
    localAIOPictureData.aVY = paramAIOImageData.aVY;
    localAIOPictureData.aVZ = paramAIOImageData.aVZ;
    localAIOPictureData.uuid = paramAIOImageData.uuid;
    localAIOPictureData.timestamp = paramAIOImageData.timestamp;
    localAIOPictureData.groupFileID = paramAIOImageData.groupFileID;
    localAIOPictureData.width = paramAIOImageData.width;
    localAIOPictureData.height = paramAIOImageData.height;
    localAIOPictureData.bjc = paramAIOImageData.bjc;
    localAIOPictureData.bjd = paramAIOImageData.bjd;
    localAIOPictureData.bje = paramAIOImageData.bje;
    localAIOPictureData.mImageType = paramAIOImageData.mImageType;
    localAIOPictureData.EP = paramAIOImageData.EP;
    localAIOPictureData.bQ = paramAIOImageData.bQ;
    localAIOPictureData.bjf = paramAIOImageData.bjf;
    localAIOPictureData.Jx = paramAIOImageData.Jx;
    localAIOPictureData.fileName = paramAIOImageData.fileName;
    localAIOPictureData.filePath = paramAIOImageData.filePath;
    localAIOPictureData.busId = paramAIOImageData.busId;
    localAIOPictureData.bWU = paramAIOImageData.bWU;
    localAIOPictureData.aWi = paramAIOImageData.aWi;
    localAIOPictureData.md5 = paramAIOImageData.md5;
    localAIOPictureData.aWj = paramAIOImageData.aWj;
    localAIOPictureData.send_uin = paramAIOImageData.send_uin;
    localAIOPictureData.bjg = paramAIOImageData.bjg;
    localAIOPictureData.imageBizType = paramAIOImageData.imageBizType;
    localAIOPictureData.isSend = paramAIOImageData.isSend;
    localAIOPictureData.aWk = paramAIOImageData.aWk;
    localAIOPictureData.bdq = paramAIOImageData.bdq;
    localAIOPictureData.TI = paramAIOImageData.TI;
    localAIOPictureData.content = paramAIOImageData.content;
    localAIOPictureData.templateId = paramAIOImageData.mTemplateId;
    localAIOPictureData.templateName = paramAIOImageData.mTemplateName;
    return localAIOPictureData;
  }
  
  public static AIOVideoData a(AIOShortVideoData paramAIOShortVideoData)
  {
    AIOVideoData localAIOVideoData = new AIOVideoData();
    localAIOVideoData.msgId = paramAIOShortVideoData.id;
    localAIOVideoData.subId = paramAIOShortVideoData.subId;
    localAIOVideoData.time = paramAIOShortVideoData.time;
    localAIOVideoData.size = paramAIOShortVideoData.size;
    localAIOVideoData.shmsgseq = paramAIOShortVideoData.shmsgseq;
    localAIOVideoData.istroop = paramAIOShortVideoData.istroop;
    localAIOVideoData.isMultiMsg = paramAIOShortVideoData.isMultiMsg;
    localAIOVideoData.isInMixedMsg = paramAIOShortVideoData.isInMixedMsg;
    localAIOVideoData.bjq = paramAIOShortVideoData.bjq;
    localAIOVideoData.aWo = paramAIOShortVideoData.aWo;
    localAIOVideoData.aWp = paramAIOShortVideoData.aWp;
    localAIOVideoData.bqB = paramAIOShortVideoData.bqB;
    localAIOVideoData.mBusiType = paramAIOShortVideoData.mBusiType;
    localAIOVideoData.width = paramAIOShortVideoData.width;
    localAIOVideoData.height = paramAIOShortVideoData.height;
    localAIOVideoData.uniseq = paramAIOShortVideoData.uniseq;
    localAIOVideoData.redBagType = paramAIOShortVideoData.redBagType;
    localAIOVideoData.shortVideoId = paramAIOShortVideoData.shortVideoId;
    localAIOVideoData.senderUin = paramAIOShortVideoData.senderUin;
    localAIOVideoData.redBagStat = paramAIOShortVideoData.redBagStat;
    localAIOVideoData.friendUin = paramAIOShortVideoData.friendUin;
    localAIOVideoData.isSend = paramAIOShortVideoData.isSend;
    localAIOVideoData.specialVideoType = paramAIOShortVideoData.specialVideoType;
    localAIOVideoData.videoFileStatus = paramAIOShortVideoData.videoFileStatus;
    localAIOVideoData.templateId = paramAIOShortVideoData.mTemplateId;
    localAIOVideoData.templateName = paramAIOShortVideoData.mTemplateName;
    return localAIOVideoData;
  }
  
  public static AIOBrowserBaseData[] a(AIORichMediaData[] paramArrayOfAIORichMediaData)
  {
    if (paramArrayOfAIORichMediaData == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfAIORichMediaData.length)
    {
      AIOBrowserBaseData localAIOBrowserBaseData = a(paramArrayOfAIORichMediaData[i]);
      if (localAIOBrowserBaseData != null) {
        localArrayList.add(localAIOBrowserBaseData);
      }
      i += 1;
    }
    if (localArrayList.size() > 0) {
      return (AIOBrowserBaseData[])localArrayList.toArray(new AIOBrowserBaseData[localArrayList.size()]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amdj
 * JD-Core Version:    0.7.0.1
 */