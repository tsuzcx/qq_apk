import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.Base64;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOLightVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class xtm
{
  public static int a(Context paramContext, String paramString, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)paramContext).getAppRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Object localObject = (afhu)localQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
    }
    List localList = ((afhu)localObject).ez();
    if (localList != null)
    {
      int i = 1;
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= localList.size()) {
          break;
        }
        int m = ((CustomEmotionData)localList.get(j)).emoId;
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(j)).emoPath)))
        {
          a(localQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)localList.get(j));
          return 2;
        }
        if ((str != null) && (((CustomEmotionData)localList.get(j)).md5 != null) && (str.equals(((CustomEmotionData)localList.get(j)).md5)))
        {
          a(localQQAppInterface, paramStructMsgForImageShare, (CustomEmotionData)localList.get(j));
          if ("needDel".equals(((CustomEmotionData)localList.get(j)).RomaingType))
          {
            ((afhu)localObject).a((CustomEmotionData)localList.get(j), j);
            paramContext = localQQAppInterface.getHandler(ChatActivity.class);
            if (paramContext != null) {
              paramContext.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          return 2;
        }
        k = i;
        if (i < m) {
          k = m;
        }
        j += 1;
        i = k;
      }
    }
    int k = 1;
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = localQQAppInterface.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = (k + 1);
    ((CustomEmotionData)localObject).emoPath = paramString;
    ((CustomEmotionData)localObject).md5 = str;
    if ((paramPicMessageExtraData != null) && (paramPicMessageExtraData.isDiyDouTu())) {
      ((CustomEmotionData)localObject).eId = paramPicMessageExtraData.emojiPkgId;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(acbn.bmO))) {
      anot.a(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
    }
    paramContext = new afhf(localQQAppInterface, paramContext, (CustomEmotionData)localObject, paramStructMsgForImageShare, 0);
    paramString = (afhv)localQQAppInterface.getManager(103);
    if (paramString != null) {
      paramString.b((CustomEmotionData)localObject, paramContext);
    }
    return 0;
  }
  
  public static int a(AIORichMediaData paramAIORichMediaData)
  {
    if (AIOLightVideoData.class.isInstance(paramAIORichMediaData)) {
      return 3;
    }
    if ((AIOShortVideoData.class.isInstance(paramAIORichMediaData)) || (AIOFileVideoData.class.isInstance(paramAIORichMediaData))) {
      return 2;
    }
    return 1;
  }
  
  public static AIOFilePicData a(MessageForTroopFile paramMessageForTroopFile, QQAppInterface paramQQAppInterface)
  {
    apcy localapcy = apsv.a(paramQQAppInterface, paramMessageForTroopFile);
    if (localapcy == null) {
      if (QLog.isDevelopLevel()) {
        QLog.d("AIOGalleryUtils", 4, "get fileStatusInfo fail ");
      }
    }
    do
    {
      do
      {
        do
        {
          return null;
          if (ahav.getFileType(paramMessageForTroopFile.fileName) != 0)
          {
            QLog.e("AIOGalleryUtils", 1, "unknow file Type");
            return null;
          }
          if (localapcy.Status != 12) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localapcy.Id + " file is deleted!");
        return null;
        if ((localapcy.Status != 4) && (localapcy.Status != 5)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localapcy.Id + " file is:" + localapcy.Status);
      return null;
      if ((!aqhq.fileExistsAndNotEmpty(localapcy.LocalFile)) || ((localapcy.Status != 1) && (localapcy.Status != 2) && (localapcy.Status != 3))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("AIOGalleryUtilstoTroopAIOFilePicData", 1, "id:" + localapcy.Id + " file is:" + localapcy.Status);
    return null;
    ((agiq)paramQQAppInterface.getManager(317)).a(apqz.lb(localapcy.FileName));
    Object localObject = localapcy.coc;
    if ((paramMessageForTroopFile.isMultiMsg) && (TextUtils.isEmpty((CharSequence)localObject))) {
      ahav.g(paramMessageForTroopFile);
    }
    localObject = new AIOFilePicData();
    ((AIOFilePicData)localObject).id = paramMessageForTroopFile.uniseq;
    ((AIOFilePicData)localObject).time = paramMessageForTroopFile.time;
    ((AIOFilePicData)localObject).shmsgseq = paramMessageForTroopFile.shmsgseq;
    ((AIOFilePicData)localObject).size = paramMessageForTroopFile.fileSize;
    ((AIOFilePicData)localObject).strUin = paramMessageForTroopFile.frienduin;
    ((AIOFilePicData)localObject).peerType = paramMessageForTroopFile.istroop;
    ((AIOFilePicData)localObject).curUin = paramQQAppInterface.getCurrentAccountUin();
    ((AIOFilePicData)localObject).issend = paramMessageForTroopFile.issend;
    ((AIOFilePicData)localObject).istroop = paramMessageForTroopFile.istroop;
    ((AIOFilePicData)localObject).isMultiMsg = paramMessageForTroopFile.isMultiMsg;
    ((AIOFilePicData)localObject).picWidth = paramMessageForTroopFile.width;
    ((AIOFilePicData)localObject).picHeight = paramMessageForTroopFile.height;
    ((AIOFilePicData)localObject).bWF = localapcy.thumbInvalidCode;
    ((AIOFilePicData)localObject).aWa = paramMessageForTroopFile.url;
    if (localapcy.Status == 8) {}
    for (boolean bool = true;; bool = false)
    {
      ((AIOFilePicData)localObject).bir = bool;
      ((AIOFilePicData)localObject).a(localapcy);
      ((AIOFilePicData)localObject).bjq = achp.aa(paramMessageForTroopFile);
      return localObject;
    }
  }
  
  public static AIOImageData a(MessageForPic paramMessageForPic)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.id = paramMessageForPic.uniseq;
    localAIOImageData.subId = paramMessageForPic.subMsgId;
    localAIOImageData.time = paramMessageForPic.time;
    localAIOImageData.shmsgseq = paramMessageForPic.shmsgseq;
    localAIOImageData.size = paramMessageForPic.size;
    localAIOImageData.istroop = paramMessageForPic.istroop;
    localAIOImageData.md5 = paramMessageForPic.md5;
    localAIOImageData.aWj = paramMessageForPic.rawMsgUrl;
    localAIOImageData.send_uin = paramMessageForPic.senderuin;
    localAIOImageData.aWk = paramMessageForPic.frienduin;
    Object localObject1;
    if (jof.a(paramMessageForPic))
    {
      localObject1 = jof.a(paramMessageForPic);
      if ((((jof.a)localObject1).TF != null) || (((jof.a)localObject1).flags == 2)) {
        break label437;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryUtils", 2, "toAIOImageData anonymousExtInfo : an_id is null");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "toAIOImageData, pic_server_url = " + localAIOImageData.aWj + "  send_uin = " + localAIOImageData.send_uin);
    }
    if (paramMessageForPic.picExtraData != null) {
      localAIOImageData.aWi = paramMessageForPic.picExtraData.doutuSupplier;
    }
    int i;
    if (paramMessageForPic.isMixed)
    {
      i = 1;
      label222:
      localAIOImageData.aVW = aoiz.getFilePath(aoop.a(paramMessageForPic, i, "chatthumb").toString());
      if (!paramMessageForPic.isMixed) {
        break label515;
      }
      localAIOImageData.aVX = localAIOImageData.aVW;
    }
    for (;;)
    {
      if (paramMessageForPic.fileSizeFlag == 1) {
        localAIOImageData.aVY = aoiz.getFilePath(aoop.a(paramMessageForPic, 131075, null).toString());
      }
      localAIOImageData.uuid = paramMessageForPic.uuid;
      localAIOImageData.groupFileID = paramMessageForPic.groupFileID;
      localAIOImageData.width = paramMessageForPic.width;
      localAIOImageData.height = paramMessageForPic.height;
      localAIOImageData.bjd = paramMessageForPic.isSendFromLocal();
      localAIOImageData.mImageType = paramMessageForPic.imageType;
      localAIOImageData.isMultiMsg = paramMessageForPic.isMultiMsg;
      localAIOImageData.isSend = paramMessageForPic.isSend();
      if (paramMessageForPic.picExtraData != null)
      {
        if (paramMessageForPic.picExtraData.isHotPics()) {
          localAIOImageData.EP = 4;
        }
        localAIOImageData.imageBizType = paramMessageForPic.picExtraData.imageBizType;
        localAIOImageData.mTemplateId = paramMessageForPic.picExtraData.mTemplateId;
        localAIOImageData.mTemplateName = paramMessageForPic.picExtraData.mTemplateName;
      }
      localAIOImageData.isInMixedMsg = paramMessageForPic.isInMixedMsg;
      localAIOImageData.bjq = achp.aa(paramMessageForPic);
      return localAIOImageData;
      label437:
      Object localObject2 = ((jof.a)localObject1).B();
      if ((localObject2 == null) || (((jof.a)localObject1).flags == 2)) {
        break;
      }
      localObject1 = URLEncoder.encode(Base64.encodeToString((byte[])localObject2, 2));
      jof.a().a(paramMessageForPic.frienduin, (String)localObject1, paramMessageForPic);
      localAIOImageData.bdq = true;
      localAIOImageData.content = jof.a().I(paramMessageForPic.frienduin, (String)localObject1);
      break;
      i = 65537;
      break label222;
      label515:
      localObject1 = aoop.a(paramMessageForPic, 1, null);
      localAIOImageData.aVX = aoiz.getFilePath(((URL)localObject1).toString());
      if (paramMessageForPic.fileSizeFlag != 1)
      {
        long l = paramMessageForPic.size;
        localObject2 = new File(localAIOImageData.aVX);
        if ((((File)localObject2).exists()) && (((File)localObject2).length() < l)) {
          localAIOImageData.bjc = true;
        }
        localAIOImageData.aVZ = aoiz.oo(((URL)localObject1).toString());
        if ((paramMessageForPic.mShowLength > 0) && (paramMessageForPic.mShowLength < paramMessageForPic.mDownloadLength)) {
          localAIOImageData.bje = true;
        }
      }
    }
  }
  
  public static AIOImageData a(MessageForTroopFile paramMessageForTroopFile, QQAppInterface paramQQAppInterface)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.id = paramMessageForTroopFile.uniseq;
    localAIOImageData.subId = 0;
    localAIOImageData.time = paramMessageForTroopFile.time;
    localAIOImageData.shmsgseq = paramMessageForTroopFile.shmsgseq;
    localAIOImageData.size = paramMessageForTroopFile.fileSize;
    localAIOImageData.istroop = paramMessageForTroopFile.istroop;
    localAIOImageData.bjg = true;
    localAIOImageData.send_uin = paramMessageForTroopFile.senderuin;
    localAIOImageData.isMultiMsg = paramMessageForTroopFile.isMultiMsg;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "toAIOImageData file, isFromFile = " + localAIOImageData.bjg + "  send_uin = " + localAIOImageData.send_uin);
    }
    apcy localapcy = apsv.a(paramQQAppInterface, paramMessageForTroopFile);
    Object localObject;
    if (localapcy.coc != null)
    {
      localObject = localapcy.coc;
      localAIOImageData.aVW = ((String)localObject);
      if (localAIOImageData.aVW == null) {
        localAIOImageData.aVW = "I:N";
      }
      if (!TextUtils.isEmpty(localapcy.ThumbnailFile_Large)) {
        localAIOImageData.aVX = localapcy.ThumbnailFile_Large;
      }
      if ((!TextUtils.isEmpty(localapcy.LocalFile)) && (aqhq.fileExists(localapcy.LocalFile))) {
        localAIOImageData.aVY = localapcy.LocalFile;
      }
      if (localapcy.Status != 8) {
        break label400;
      }
    }
    label400:
    for (boolean bool = true;; bool = false)
    {
      localAIOImageData.bje = bool;
      localAIOImageData.uuid = paramMessageForTroopFile.uuid;
      localAIOImageData.groupFileID = localapcy.SeqId;
      try
      {
        localObject = xpw.a(paramQQAppInterface.getApplication(), localapcy, paramMessageForTroopFile);
        paramQQAppInterface = (QQAppInterface)localObject;
        if (localObject == null) {
          paramQQAppInterface = aoop.am();
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          paramQQAppInterface = aoop.am();
        }
      }
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject = aoop.am();
      }
      localAIOImageData.width = ((Drawable)localObject).getIntrinsicWidth();
      localAIOImageData.height = ((Drawable)localObject).getIntrinsicHeight();
      localAIOImageData.bjd = paramMessageForTroopFile.isSendFromLocal();
      localAIOImageData.mImageType = 1000;
      localAIOImageData.bjf = true;
      localAIOImageData.fileName = localapcy.FileName;
      localAIOImageData.filePath = localapcy.FilePath;
      localAIOImageData.Jx = localapcy.ProgressTotal;
      localAIOImageData.busId = localapcy.BusId;
      localAIOImageData.EP = 3;
      return localAIOImageData;
      localObject = localapcy.ThumbnailFile_Small;
      break;
    }
  }
  
  public static AIOLightVideoData a(MessageForLightVideo paramMessageForLightVideo)
  {
    AIOLightVideoData localAIOLightVideoData = new AIOLightVideoData();
    localAIOLightVideoData.id = paramMessageForLightVideo.uniseq;
    localAIOLightVideoData.time = paramMessageForLightVideo.time;
    localAIOLightVideoData.shmsgseq = paramMessageForLightVideo.shmsgseq;
    localAIOLightVideoData.size = paramMessageForLightVideo.videoFileSize;
    String str1 = ShortVideoUtils.bw(paramMessageForLightVideo.thumbMD5, "jpg");
    String str2 = ShortVideoUtils.a(paramMessageForLightVideo, "mp4");
    localAIOLightVideoData.aWo = str1;
    localAIOLightVideoData.aWp = str2;
    localAIOLightVideoData.bqB = paramMessageForLightVideo.videoFileTime;
    localAIOLightVideoData.mBusiType = paramMessageForLightVideo.busiType;
    localAIOLightVideoData.width = paramMessageForLightVideo.thumbWidth;
    localAIOLightVideoData.height = paramMessageForLightVideo.thumbHeight;
    localAIOLightVideoData.uniseq = paramMessageForLightVideo.uniseq;
    localAIOLightVideoData.isMultiMsg = paramMessageForLightVideo.isMultiMsg;
    return localAIOLightVideoData;
  }
  
  public static AIORichMediaData a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramChatMessage == null)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      return paramQQAppInterface;
    }
    if ((paramChatMessage instanceof MessageForFile)) {
      localObject1 = b(paramChatMessage, paramQQAppInterface);
    }
    for (;;)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (localObject1 == null) {
        break;
      }
      ((AIORichMediaData)localObject1).bjq = achp.aa(paramChatMessage);
      return localObject1;
      localObject1 = localObject2;
      if ((paramChatMessage instanceof MessageForTroopFile)) {
        localObject1 = c(paramChatMessage, paramQQAppInterface);
      }
    }
  }
  
  public static AIOShortVideoData a(MessageForShortVideo paramMessageForShortVideo)
  {
    AIOShortVideoData localAIOShortVideoData = new AIOShortVideoData();
    localAIOShortVideoData.id = paramMessageForShortVideo.uniseq;
    localAIOShortVideoData.time = paramMessageForShortVideo.time;
    localAIOShortVideoData.size = paramMessageForShortVideo.videoFileSize;
    localAIOShortVideoData.shmsgseq = paramMessageForShortVideo.shmsgseq;
    String str1 = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
    String str2 = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localAIOShortVideoData.aWo = str1;
    localAIOShortVideoData.aWp = str2;
    localAIOShortVideoData.bqB = paramMessageForShortVideo.videoFileTime;
    localAIOShortVideoData.mBusiType = paramMessageForShortVideo.busiType;
    localAIOShortVideoData.width = paramMessageForShortVideo.thumbWidth;
    localAIOShortVideoData.height = paramMessageForShortVideo.thumbHeight;
    localAIOShortVideoData.uniseq = paramMessageForShortVideo.uniseq;
    localAIOShortVideoData.redBagType = paramMessageForShortVideo.redBagType;
    localAIOShortVideoData.shortVideoId = paramMessageForShortVideo.shortVideoId;
    localAIOShortVideoData.senderUin = top.g(paramMessageForShortVideo);
    localAIOShortVideoData.redBagStat = paramMessageForShortVideo.redBagStat;
    localAIOShortVideoData.friendUin = paramMessageForShortVideo.frienduin;
    localAIOShortVideoData.istroop = paramMessageForShortVideo.istroop;
    if (paramMessageForShortVideo.isSend()) {}
    for (int i = 1;; i = 0)
    {
      localAIOShortVideoData.isSend = i;
      localAIOShortVideoData.specialVideoType = paramMessageForShortVideo.specialVideoType;
      localAIOShortVideoData.videoFileStatus = paramMessageForShortVideo.videoFileStatus;
      localAIOShortVideoData.isMultiMsg = paramMessageForShortVideo.isMultiMsg;
      localAIOShortVideoData.mTemplateId = paramMessageForShortVideo.templateId;
      localAIOShortVideoData.mTemplateName = paramMessageForShortVideo.templateName;
      localAIOShortVideoData.bjq = achp.aa(paramMessageForShortVideo);
      return localAIOShortVideoData;
    }
  }
  
  public static CustomEmotionData a(Context paramContext, String paramString)
  {
    paramContext = (afhu)((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from getExitInCustomEmotionResp.");
    }
    List localList = paramContext.ez();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(i)).emoPath)))
        {
          paramString = (CustomEmotionData)localList.get(i);
          paramContext.a(paramString, i);
          return paramString;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static void a(Activity paramActivity, File paramFile, String paramString)
  {
    amdf.a(paramActivity, paramFile, paramString, null);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, List<xuf> paramList, boolean paramBoolean, String paramString3)
  {
    if (paramList == null) {
      return;
    }
    avpw.d locald = avpw.d.a();
    locald.cMP = paramString1;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    AIOImageData localAIOImageData;
    while (localIterator.hasNext())
    {
      paramString1 = (xuf)localIterator.next();
      if (AIOImageData.class.isInstance(paramString1.e))
      {
        localAIOImageData = (AIOImageData)paramString1.e;
        localArrayList2.add(localAIOImageData.uuid);
        localArrayList3.add(Long.valueOf(localAIOImageData.timestamp));
        if (paramBoolean) {
          localArrayList4.add(Long.valueOf(localAIOImageData.groupFileID));
        }
        paramString1 = localAIOImageData.aVW;
        if (paramString1.endsWith("_hd")) {
          break label298;
        }
        paramList = paramString1 + "_hd";
        if (!new File(paramList).exists()) {
          break label298;
        }
        paramString1 = paramList;
      }
    }
    label298:
    for (;;)
    {
      localArrayList1.add(paramString1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryUtils", 2, "fowardToQZoneGroupAlbums(), uuid:" + localAIOImageData.uuid + " time:" + localAIOImageData.timestamp + " path:" + paramString1);
      break;
      avpw.a(paramActivity, locald, paramBoolean, paramString3, paramString2, paramInt, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 98);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, xuf paramxuf, boolean paramBoolean, String paramString3)
  {
    if ((paramxuf == null) || (!AIOImageData.class.isInstance(paramxuf.e))) {
      return;
    }
    avpw.d locald = avpw.d.a();
    locald.cMP = paramString1;
    AIOImageData localAIOImageData = (AIOImageData)paramxuf.e;
    paramString1 = localAIOImageData.aVW;
    if (!paramString1.endsWith("_hd"))
    {
      paramxuf = paramString1 + "_hd";
      if (new File(paramxuf).exists()) {
        paramString1 = paramxuf;
      }
    }
    for (;;)
    {
      paramxuf = localAIOImageData.uuid;
      long l2 = localAIOImageData.timestamp;
      long l1 = 0L;
      if (paramBoolean) {
        l1 = localAIOImageData.groupFileID;
      }
      avpw.a(paramActivity, locald, paramBoolean, paramString3, paramString2, paramInt, paramString1, paramxuf, l2, l1, -1);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt)
  {
    avpw.d locald = avpw.d.a();
    locald.cMP = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbum(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3 + " uuid:" + paramString5 + " time:" + paramLong + " path:" + paramInt);
    }
    avpw.a(paramActivity, locald, paramString2, paramString3, paramString4, paramString5, paramLong, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Long> paramArrayList, int paramInt, String paramString4, String paramString5)
  {
    avpw.d locald = avpw.d.a();
    locald.cMP = paramString1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "fowardToGroupAlbumEx(),uin:" + paramString1 + " qunId:" + paramString2 + " qunCode:" + paramString3);
    }
    avpw.a(paramActivity, locald, paramString2, paramString3, paramArrayList1, paramArrayList2, paramArrayList, paramInt, paramString4, paramString5);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, String paramString, int paramInt, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData)
  {
    new xtn(paramContext, paramInt, paramURLDrawable, paramQQAppInterface, paramStructMsgForImageShare, paramPicMessageExtraData).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = xtj.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (afim)paramQQAppInterface.getManager(141);
      VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
      localVipComicFavorEmoStructMsgInfo.picMd5 = paramCustomEmotionData.md5;
      localVipComicFavorEmoStructMsgInfo.actionData = paramStructMsgForImageShare;
      if (!localVipComicFavorEmoStructMsgInfo.equals(paramQQAppInterface.a(paramCustomEmotionData.md5)))
      {
        paramStructMsgForImageShare = new ArrayList();
        paramStructMsgForImageShare.add(localVipComicFavorEmoStructMsgInfo);
        paramQQAppInterface.ao(paramStructMsgForImageShare, true);
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryUtils", 2, "handleOldComicStructMsg , emoStructMsgInfo = " + localVipComicFavorEmoStructMsgInfo);
        }
      }
    }
  }
  
  /* Error */
  private static AIORichMediaData b(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: checkcast 714	com/tencent/mobileqq/data/MessageForFile
    //   7: astore 4
    //   9: aload_1
    //   10: invokevirtual 933	com/tencent/mobileqq/app/QQAppInterface:a	()Lagkf;
    //   13: aload 4
    //   15: getfield 934	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   18: aload 4
    //   20: getfield 935	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   23: aload 4
    //   25: getfield 936	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   28: invokevirtual 941	agkf:a	(JLjava/lang/String;I)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   31: astore 7
    //   33: aload 7
    //   35: ifnonnull +5 -> 40
    //   38: aconst_null
    //   39: areturn
    //   40: aload 7
    //   42: getfield 946	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   45: ifne +190 -> 235
    //   48: new 282	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData
    //   51: dup
    //   52: invokespecial 283	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:<init>	()V
    //   55: astore 5
    //   57: aload 5
    //   59: aload 4
    //   61: getfield 934	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   64: putfield 290	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:id	J
    //   67: aload 5
    //   69: aload 4
    //   71: getfield 947	com/tencent/mobileqq/data/MessageForFile:time	J
    //   74: putfield 294	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:time	J
    //   77: aload 5
    //   79: aload 4
    //   81: getfield 948	com/tencent/mobileqq/data/MessageForFile:shmsgseq	J
    //   84: putfield 298	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:shmsgseq	J
    //   87: aload 5
    //   89: aload 4
    //   91: getfield 949	com/tencent/mobileqq/data/MessageForFile:fileSize	J
    //   94: putfield 303	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:size	J
    //   97: aload 5
    //   99: aload 4
    //   101: getfield 935	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   104: putfield 309	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:strUin	Ljava/lang/String;
    //   107: aload 5
    //   109: aload 4
    //   111: getfield 936	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   114: putfield 315	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:peerType	I
    //   117: aload 5
    //   119: aload_1
    //   120: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   123: putfield 318	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:curUin	Ljava/lang/String;
    //   126: aload 5
    //   128: aload 4
    //   130: getfield 950	com/tencent/mobileqq/data/MessageForFile:issend	I
    //   133: putfield 322	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:issend	I
    //   136: aload 5
    //   138: aload_0
    //   139: getfield 953	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   142: putfield 323	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:istroop	I
    //   145: aload 5
    //   147: aload_0
    //   148: getfield 954	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   151: putfield 324	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:isMultiMsg	Z
    //   154: aload 5
    //   156: aload 7
    //   158: getfield 957	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   161: putfield 348	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:aWa	Ljava/lang/String;
    //   164: aload 7
    //   166: getfield 960	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   169: iconst_2
    //   170: if_icmpne +60 -> 230
    //   173: iconst_1
    //   174: istore_3
    //   175: aload 5
    //   177: iload_3
    //   178: putfield 351	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:bir	Z
    //   181: aload 5
    //   183: aload 7
    //   185: getfield 963	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   188: putfield 966	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:mMd5	Ljava/lang/String;
    //   191: aload 5
    //   193: aload 7
    //   195: getfield 969	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   198: putfield 330	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:picWidth	I
    //   201: aload 5
    //   203: aload 7
    //   205: getfield 972	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   208: putfield 336	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:picHeight	I
    //   211: aload 5
    //   213: aload 7
    //   215: getfield 973	com/tencent/mobileqq/filemanager/data/FileManagerEntity:thumbInvalidCode	I
    //   218: putfield 342	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:bWF	I
    //   221: aload 5
    //   223: aload_1
    //   224: invokevirtual 977	com/tencent/mobileqq/activity/aio/photo/AIOFilePicData:aZ	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   227: aload 5
    //   229: areturn
    //   230: iconst_0
    //   231: istore_3
    //   232: goto -57 -> 175
    //   235: aload 7
    //   237: getfield 946	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nFileType	I
    //   240: iconst_2
    //   241: if_icmpne +602 -> 843
    //   244: aload 7
    //   246: getfield 960	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   249: bipush 16
    //   251: if_icmpne +47 -> 298
    //   254: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -219 -> 38
    //   260: ldc_w 979
    //   263: iconst_1
    //   264: new 220	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   271: ldc 223
    //   273: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 7
    //   278: getfield 982	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   281: invokevirtual 857	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   284: ldc_w 984
    //   287: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 242	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: aconst_null
    //   297: areturn
    //   298: aload 7
    //   300: invokevirtual 987	com/tencent/mobileqq/filemanager/data/FileManagerEntity:sendCloudUnsuccessful	()Z
    //   303: ifeq +47 -> 350
    //   306: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq -271 -> 38
    //   312: ldc_w 979
    //   315: iconst_1
    //   316: new 220	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   323: ldc 223
    //   325: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload 7
    //   330: getfield 982	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   333: invokevirtual 857	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   336: ldc_w 989
    //   339: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 242	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: aconst_null
    //   349: areturn
    //   350: aload 7
    //   352: invokevirtual 991	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   355: invokestatic 255	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   358: istore_3
    //   359: iload_3
    //   360: ifeq +56 -> 416
    //   363: aload 7
    //   365: getfield 960	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   368: iconst_1
    //   369: if_icmpeq +47 -> 416
    //   372: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq -337 -> 38
    //   378: ldc_w 979
    //   381: iconst_1
    //   382: new 220	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   389: ldc 223
    //   391: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload 7
    //   396: getfield 982	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   399: invokevirtual 857	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   402: ldc_w 993
    //   405: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokestatic 242	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   414: aconst_null
    //   415: areturn
    //   416: aload_1
    //   417: sipush 317
    //   420: invokevirtual 30	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   423: checkcast 257	agiq
    //   426: aload 7
    //   428: getfield 994	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   431: invokestatic 266	apqz:lb	(Ljava/lang/String;)Ljava/lang/String;
    //   434: invokevirtual 269	agiq:a	(Ljava/lang/String;)Laepv$a;
    //   437: astore 8
    //   439: aload 7
    //   441: getfield 997	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strLargeThumPath	Ljava/lang/String;
    //   444: invokestatic 1000	ahbj:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   447: ifeq +302 -> 749
    //   450: aload 7
    //   452: getfield 997	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strLargeThumPath	Ljava/lang/String;
    //   455: astore_1
    //   456: aload_1
    //   457: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   460: ifeq +39 -> 499
    //   463: ldc 40
    //   465: iconst_1
    //   466: new 220	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 1002
    //   476: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload 7
    //   481: getfield 982	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   484: invokevirtual 857	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   487: ldc_w 1004
    //   490: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 242	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   499: new 181	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData
    //   502: dup
    //   503: aload_1
    //   504: invokespecial 1005	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:<init>	(Ljava/lang/String;)V
    //   507: astore 6
    //   509: aload 6
    //   511: aload 4
    //   513: getfield 935	com/tencent/mobileqq/data/MessageForFile:frienduin	Ljava/lang/String;
    //   516: putfield 1006	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:strUin	Ljava/lang/String;
    //   519: aload 6
    //   521: aload 4
    //   523: getfield 936	com/tencent/mobileqq/data/MessageForFile:istroop	I
    //   526: putfield 1007	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:peerType	I
    //   529: aload 6
    //   531: aload 4
    //   533: getfield 950	com/tencent/mobileqq/data/MessageForFile:issend	I
    //   536: putfield 1008	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:isSend	I
    //   539: aload 6
    //   541: aload 7
    //   543: getfield 957	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   546: putfield 1011	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:fileUuid	Ljava/lang/String;
    //   549: aload 6
    //   551: aload 7
    //   553: getfield 963	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   556: putfield 1012	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:md5	Ljava/lang/String;
    //   559: aload 6
    //   561: aload 4
    //   563: getfield 934	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   566: putfield 1013	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:id	J
    //   569: aload 6
    //   571: aload 4
    //   573: getfield 947	com/tencent/mobileqq/data/MessageForFile:time	J
    //   576: putfield 1014	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:time	J
    //   579: aload 6
    //   581: aload 4
    //   583: getfield 948	com/tencent/mobileqq/data/MessageForFile:shmsgseq	J
    //   586: putfield 1015	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:shmsgseq	J
    //   589: aload 6
    //   591: aload 7
    //   593: getfield 1016	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileSize	J
    //   596: putfield 1017	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:size	J
    //   599: aload 6
    //   601: aload 7
    //   603: getfield 994	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   606: putfield 1018	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:fileName	Ljava/lang/String;
    //   609: aload 6
    //   611: aload_0
    //   612: getfield 953	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   615: putfield 1019	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:istroop	I
    //   618: aload 6
    //   620: aload 8
    //   622: getfield 1024	aepv$a:cOv	I
    //   625: i2l
    //   626: putfield 1027	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:Js	J
    //   629: iload_3
    //   630: ifeq +107 -> 737
    //   633: aload 6
    //   635: aload 7
    //   637: invokevirtual 991	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   640: putfield 1030	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:mFilePath	Ljava/lang/String;
    //   643: aload 6
    //   645: iconst_1
    //   646: putfield 1033	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:bit	Z
    //   649: new 1035	android/media/MediaMetadataRetriever
    //   652: dup
    //   653: invokespecial 1036	android/media/MediaMetadataRetriever:<init>	()V
    //   656: astore_1
    //   657: aload_1
    //   658: aload 6
    //   660: getfield 1030	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:mFilePath	Ljava/lang/String;
    //   663: invokevirtual 1039	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   666: aload_1
    //   667: bipush 24
    //   669: invokevirtual 1043	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   672: astore 4
    //   674: aload_1
    //   675: bipush 19
    //   677: invokevirtual 1043	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   680: astore 5
    //   682: aload_1
    //   683: bipush 18
    //   685: invokevirtual 1043	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   688: astore 7
    //   690: aload 4
    //   692: invokestatic 1048	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   695: istore_2
    //   696: iload_2
    //   697: bipush 90
    //   699: if_icmpeq +10 -> 709
    //   702: iload_2
    //   703: sipush 270
    //   706: if_icmpne +83 -> 789
    //   709: aload 6
    //   711: aload 5
    //   713: invokestatic 1048	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   716: putfield 1049	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:width	I
    //   719: aload 6
    //   721: aload 7
    //   723: invokestatic 1048	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   726: putfield 1050	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:height	I
    //   729: aload_1
    //   730: ifnull +7 -> 737
    //   733: aload_1
    //   734: invokevirtual 1053	android/media/MediaMetadataRetriever:release	()V
    //   737: aload 6
    //   739: aload_0
    //   740: getfield 954	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   743: putfield 1054	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:isMultiMsg	Z
    //   746: aload 6
    //   748: areturn
    //   749: aload 7
    //   751: getfield 1057	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strMiddleThumPath	Ljava/lang/String;
    //   754: invokestatic 1000	ahbj:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   757: ifeq +12 -> 769
    //   760: aload 7
    //   762: getfield 1057	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strMiddleThumPath	Ljava/lang/String;
    //   765: astore_1
    //   766: goto -310 -> 456
    //   769: aload 7
    //   771: getfield 1060	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   774: invokestatic 1000	ahbj:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   777: ifeq +92 -> 869
    //   780: aload 7
    //   782: getfield 1060	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   785: astore_1
    //   786: goto -330 -> 456
    //   789: aload 6
    //   791: aload 7
    //   793: invokestatic 1048	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   796: putfield 1049	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:width	I
    //   799: aload 6
    //   801: aload 5
    //   803: invokestatic 1048	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   806: putfield 1050	com/tencent/mobileqq/activity/aio/photo/AIOFileVideoData:height	I
    //   809: goto -80 -> 729
    //   812: astore 4
    //   814: aload 4
    //   816: invokevirtual 1063	java/lang/Exception:printStackTrace	()V
    //   819: aload_1
    //   820: ifnull -83 -> 737
    //   823: aload_1
    //   824: invokevirtual 1053	android/media/MediaMetadataRetriever:release	()V
    //   827: goto -90 -> 737
    //   830: astore_0
    //   831: aconst_null
    //   832: astore_1
    //   833: aload_1
    //   834: ifnull +7 -> 841
    //   837: aload_1
    //   838: invokevirtual 1053	android/media/MediaMetadataRetriever:release	()V
    //   841: aload_0
    //   842: athrow
    //   843: ldc 40
    //   845: iconst_1
    //   846: ldc 208
    //   848: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   851: aconst_null
    //   852: areturn
    //   853: astore_0
    //   854: goto -21 -> 833
    //   857: astore_0
    //   858: goto -25 -> 833
    //   861: astore 4
    //   863: aload 5
    //   865: astore_1
    //   866: goto -52 -> 814
    //   869: aconst_null
    //   870: astore_1
    //   871: goto -415 -> 456
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	874	0	paramChatMessage	ChatMessage
    //   0	874	1	paramQQAppInterface	QQAppInterface
    //   695	12	2	i	int
    //   174	456	3	bool	boolean
    //   7	684	4	localObject1	Object
    //   812	3	4	localException1	Exception
    //   861	1	4	localException2	Exception
    //   1	863	5	localObject2	Object
    //   507	293	6	localAIOFileVideoData	AIOFileVideoData
    //   31	761	7	localObject3	Object
    //   437	184	8	locala	aepv.a
    // Exception table:
    //   from	to	target	type
    //   657	696	812	java/lang/Exception
    //   709	729	812	java/lang/Exception
    //   789	809	812	java/lang/Exception
    //   649	657	830	finally
    //   657	696	853	finally
    //   709	729	853	finally
    //   789	809	853	finally
    //   814	819	857	finally
    //   649	657	861	java/lang/Exception
  }
  
  public static void b(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, CustomEmotionData paramCustomEmotionData)
  {
    paramStructMsgForImageShare = xtj.a(paramStructMsgForImageShare);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramStructMsgForImageShare)) && (paramStructMsgForImageShare.startsWith("comic_plugin.apk")) && (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)))
    {
      paramQQAppInterface = (afim)paramQQAppInterface.getManager(141);
      VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
      localVipComicFavorEmoStructMsgInfo.picMd5 = paramCustomEmotionData.md5;
      localVipComicFavorEmoStructMsgInfo.actionData = paramStructMsgForImageShare;
      paramStructMsgForImageShare = new ArrayList();
      paramStructMsgForImageShare.add(localVipComicFavorEmoStructMsgInfo);
      paramQQAppInterface.ao(paramStructMsgForImageShare, true);
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryUtils", 2, "handleComicStructMsg , emoStructMsgInfo = " + localVipComicFavorEmoStructMsgInfo);
      }
    }
  }
  
  private static AIORichMediaData c(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
    apcy localapcy = apsv.a(paramQQAppInterface, localMessageForTroopFile);
    if (localapcy == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AIOGalleryUtils", 4, "get fileStatusInfo fail ");
      }
      return null;
    }
    if (ahav.getFileType(((MessageForTroopFile)paramChatMessage).fileName) != 2)
    {
      QLog.e("AIOGalleryUtils", 1, "unknow file Type");
      return null;
    }
    if (localapcy.Status == 12)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AIOGalleryUtilsFileVideo", 1, "id:" + localapcy.Id + " file is deleted!");
      }
      return null;
    }
    if ((localapcy.Status == 4) || (localapcy.Status == 5))
    {
      if (QLog.isColorLevel()) {
        QLog.w("AIOGalleryUtilsFileVideo", 1, "id:" + localapcy.Id + " file is:" + localapcy.Status);
      }
      return null;
    }
    if ((aqhq.fileExistsAndNotEmpty(localapcy.LocalFile)) && ((localapcy.Status == 1) || (localapcy.Status == 2) || (localapcy.Status == 3)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("AIOGalleryUtilsFileVideo", 1, "id:" + localapcy.Id + " file is:" + localapcy.Status);
      }
      return null;
    }
    aepv.a locala = ((agiq)paramQQAppInterface.getManager(317)).a(apqz.lb(localapcy.FileName));
    Object localObject = localapcy.coc;
    paramQQAppInterface = (QQAppInterface)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramQQAppInterface = localapcy.ThumbnailFile_Large;
    }
    localObject = paramQQAppInterface;
    if (localMessageForTroopFile.isMultiMsg)
    {
      localObject = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject = ahav.g(localMessageForTroopFile);
      }
    }
    paramQQAppInterface = new AIOFileVideoData((String)localObject);
    paramQQAppInterface.strUin = localMessageForTroopFile.frienduin;
    paramQQAppInterface.peerType = localMessageForTroopFile.istroop;
    paramQQAppInterface.isSend = localMessageForTroopFile.issend;
    paramQQAppInterface.id = localMessageForTroopFile.uniseq;
    paramQQAppInterface.time = localMessageForTroopFile.time;
    paramQQAppInterface.shmsgseq = localMessageForTroopFile.shmsgseq;
    paramQQAppInterface.size = localMessageForTroopFile.fileSize;
    paramQQAppInterface.fileName = localMessageForTroopFile.fileName;
    paramQQAppInterface.istroop = localMessageForTroopFile.istroop;
    paramQQAppInterface.Js = locala.cOv;
    paramQQAppInterface.width = localMessageForTroopFile.width;
    paramQQAppInterface.height = localMessageForTroopFile.height;
    if (aqhq.fileExistsAndNotEmpty(localapcy.LocalFile))
    {
      paramQQAppInterface.mFilePath = localapcy.LocalFile;
      paramQQAppInterface.bit = true;
    }
    paramQQAppInterface.isMultiMsg = paramChatMessage.isMultiMsg;
    return paramQQAppInterface;
  }
  
  public static int g(QQAppInterface paramQQAppInterface, String paramString)
  {
    int m = 0;
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Object localObject = (afhu)paramQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForAIO.");
    }
    List localList = ((afhu)localObject).ez();
    int j;
    int i;
    int k;
    int n;
    if (localList != null)
    {
      j = 0;
      i = 1;
      k = i;
      if (j >= localList.size()) {
        break label250;
      }
      n = ((CustomEmotionData)localList.get(j)).emoId;
      if ((paramString != null) && (paramString.equals(((CustomEmotionData)localList.get(j)).emoPath))) {
        i = 2;
      }
    }
    label224:
    label250:
    do
    {
      do
      {
        return i;
        if ((str == null) || (((CustomEmotionData)localList.get(j)).md5 == null) || (!str.equals(((CustomEmotionData)localList.get(j)).md5))) {
          break label224;
        }
        if (!"needDel".equals(((CustomEmotionData)localList.get(j)).RomaingType)) {
          break;
        }
        ((afhu)localObject).a((CustomEmotionData)localList.get(j), j);
        paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
        i = m;
      } while (paramQQAppInterface == null);
      paramQQAppInterface.obtainMessage(10).sendToTarget();
      return 0;
      return 2;
      k = i;
      if (i < n) {
        k = n;
      }
      j += 1;
      i = k;
      break;
      k = 1;
      localObject = new CustomEmotionData();
      ((CustomEmotionData)localObject).uin = paramQQAppInterface.getCurrentAccountUin();
      ((CustomEmotionData)localObject).emoId = (k + 1);
      ((CustomEmotionData)localObject).emoPath = paramString;
      ((CustomEmotionData)localObject).md5 = str;
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(acbn.bmO))) {
        anot.a(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
      }
      paramString = new afhf(paramQQAppInterface, BaseApplicationImpl.getContext(), (CustomEmotionData)localObject, null, 3);
      paramQQAppInterface = (afhv)paramQQAppInterface.getManager(103);
      i = m;
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b((CustomEmotionData)localObject, paramString);
    return 0;
  }
  
  public static int s(Context paramContext, String paramString)
  {
    int m = 0;
    paramContext = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    afhu localafhu = (afhu)paramContext.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryUtils", 2, "Call getEmoticonDataList from addCustomEmotionForEmoGroup.");
    }
    Object localObject = localafhu.ez();
    int j;
    int i;
    int k;
    int n;
    if (localObject != null)
    {
      j = 0;
      i = 1;
      k = i;
      if (j >= ((List)localObject).size()) {
        break label261;
      }
      n = ((CustomEmotionData)((List)localObject).get(j)).emoId;
      if ((paramString != null) && (paramString.equals(((CustomEmotionData)((List)localObject).get(j)).emoPath))) {
        i = 2;
      }
    }
    label235:
    do
    {
      do
      {
        return i;
        if ((str == null) || (((CustomEmotionData)((List)localObject).get(j)).md5 == null) || (!str.equals(((CustomEmotionData)((List)localObject).get(j)).md5))) {
          break label235;
        }
        if (!"needDel".equals(((CustomEmotionData)((List)localObject).get(j)).RomaingType)) {
          break;
        }
        localafhu.a((CustomEmotionData)((List)localObject).get(j), j);
        paramContext = paramContext.getHandler(ChatActivity.class);
        i = m;
      } while (paramContext == null);
      paramContext.obtainMessage(10).sendToTarget();
      return 0;
      return 2;
      k = i;
      if (i < n) {
        k = n;
      }
      j += 1;
      i = k;
      break;
      k = 1;
      localObject = new CustomEmotionData();
      ((CustomEmotionData)localObject).uin = paramContext.getCurrentAccountUin();
      ((CustomEmotionData)localObject).emoId = (k + 1);
      ((CustomEmotionData)localObject).emoPath = paramString;
      ((CustomEmotionData)localObject).md5 = str;
      localafhu.c((CustomEmotionBase)localObject);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(acbn.bmO))) {
        anot.a(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
      }
      paramContext = (afhv)paramContext.getManager(103);
      i = m;
    } while (paramContext == null);
    label261:
    paramContext.d((CustomEmotionData)localObject);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xtm
 * JD-Core Version:    0.7.0.1
 */