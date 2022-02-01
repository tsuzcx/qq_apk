import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import tencent.im.msg.im_msg_body.RichText;

public class ayzh
  extends BaseShortVideoOprerator
{
  public ayzh() {}
  
  public ayzh(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public MessageRecord a(azac paramazac)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = anbi.a(this.mApp, paramazac.peerUin, paramazac.bUG, paramazac.uinType);
    localMessageForShortVideo.videoFileName = paramazac.localPath;
    if (paramazac.uuid == null) {
      paramazac.uuid = "";
    }
    localMessageForShortVideo.uuid = paramazac.uuid;
    if (paramazac.md5 == null) {
      paramazac.md5 = "";
    }
    localMessageForShortVideo.md5 = paramazac.md5;
    localMessageForShortVideo.mLocalMd5 = paramazac.mLocalMd5;
    localMessageForShortVideo.videoFileName = paramazac.fileName;
    localMessageForShortVideo.videoFileFormat = paramazac.fileFormat;
    localMessageForShortVideo.videoFileSize = paramazac.fileSize;
    localMessageForShortVideo.videoFileTime = paramazac.dFo;
    localMessageForShortVideo.thumbWidth = paramazac.thumbWidth;
    localMessageForShortVideo.thumbHeight = paramazac.thumbHeight;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    if (paramazac.uinType == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = paramazac.thumbMD5;
      if (paramazac.fileSource == null) {
        paramazac.fileSource = "";
      }
      localMessageForShortVideo.fileSource = paramazac.fileSource;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.thumbFileSize = paramazac.thumbFileSize;
      localMessageForShortVideo.busiType = paramazac.dFn;
      localMessageForShortVideo.fromChatType = paramazac.fromChatType;
      localMessageForShortVideo.toChatType = paramazac.toChatType;
      localMessageForShortVideo.uiOperatorFlag = 2;
      localMessageForShortVideo.supportProgressive = paramazac.supportProgressive;
      localMessageForShortVideo.fileWidth = paramazac.fileWidth;
      localMessageForShortVideo.fileHeight = paramazac.fileHeight;
      if (paramazac.a == null) {
        break label468;
      }
      label284:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = paramazac.a.msgseq;
        localMessageForShortVideo.shmsgseq = paramazac.a.shmsgseq;
        localMessageForShortVideo.msgUid = paramazac.a.msgUid;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label473;
      }
    }
    label468:
    label473:
    for (localMessageForShortVideo.msg = anft.cdz;; localMessageForShortVideo.msg = anft.cdy)
    {
      localMessageForShortVideo.serial();
      paramazac.uniseq = localMessageForShortVideo.uniseq;
      akxe.M(this.logTag, this.bUB, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      akxe.M(this.logTag, this.bUB, "packForwardMsg", "mr: " + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      if (paramazac.uinType == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break;
      }
      if (paramazac.uinType != 1) {
        break;
      }
      localMessageForShortVideo.fileType = 9;
      break;
      i = 0;
      break label284;
    }
  }
  
  public MessageRecord a(azai paramazai)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    label233:
    label251:
    String str1;
    label323:
    int i;
    if (paramazai.cFA)
    {
      localMessageForShortVideo = anbi.b(this.mApp, paramazai.peerUin, paramazai.bUG, paramazai.uinType);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = paramazai.localPath;
      if (paramazai.uuid == null) {
        paramazai.uuid = "";
      }
      localMessageForShortVideo.uuid = paramazai.uuid;
      if (paramazai.md5 == null) {
        paramazai.md5 = "";
      }
      localMessageForShortVideo.md5 = paramazai.md5;
      localMessageForShortVideo.videoFileFormat = 2;
      localMessageForShortVideo.videoFileSize = paramazai.ceG;
      localMessageForShortVideo.videoFileTime = paramazai.dFo;
      localMessageForShortVideo.thumbWidth = paramazai.thumbWidth;
      localMessageForShortVideo.thumbHeight = paramazai.thumbHeight;
      localMessageForShortVideo.mThumbFilePath = paramazai.thumbPath;
      localMessageForShortVideo.mVideoFileSourceDir = paramazai.cdH;
      localMessageForShortVideo.videoFileStatus = 999;
      localMessageForShortVideo.videoFileProgress = 0;
      localMessageForShortVideo.extraflag = 32772;
      localMessageForShortVideo.thumbMD5 = paramazai.thumbMD5;
      if (paramazai.fileSource == null) {
        paramazai.fileSource = "";
      }
      localMessageForShortVideo.fileSource = paramazai.fileSource;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.mediacodecEncode = paramazai.mediacodecEncode;
      if (localMessageForShortVideo.istroop != 0) {
        break label551;
      }
      localMessageForShortVideo.fileType = 6;
      if (paramazai.uinType != 1008) {
        break label591;
      }
      localMessageForShortVideo.busiType = 1007;
      localMessageForShortVideo.fromChatType = -1;
      localMessageForShortVideo.toChatType = -1;
      localMessageForShortVideo.uiOperatorFlag = 1;
      localMessageForShortVideo.supportProgressive = paramazai.supportProgressive;
      localMessageForShortVideo.fileWidth = paramazai.fileWidth;
      localMessageForShortVideo.fileHeight = paramazai.fileHeight;
      localMessageForShortVideo.syncToStory = paramazai.syncToStory;
      String str2 = anbb.ccW;
      if (!localMessageForShortVideo.syncToStory) {
        break label634;
      }
      str1 = "1";
      localMessageForShortVideo.saveExtInfoToExtStr(str2, str1);
      if (paramazai.a == null) {
        break label642;
      }
      i = 1;
      label341:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = paramazai.a.msgseq;
        localMessageForShortVideo.shmsgseq = paramazai.a.shmsgseq;
        localMessageForShortVideo.msgUid = paramazai.a.msgUid;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label647;
      }
      localMessageForShortVideo.msg = anft.cdz;
      label398:
      if (!paramazai.dAH) {
        break label658;
      }
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "true");
    }
    for (;;)
    {
      localMessageForShortVideo.serial();
      paramazai.uniseq = localMessageForShortVideo.uniseq;
      akxe.M(this.logTag, this.bUB, "packmsg", "cost:" + (System.currentTimeMillis() - l));
      akxe.M(this.logTag, this.bUB, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      localMessageForShortVideo = anbi.a(this.mApp, paramazai.peerUin, paramazai.bUG, paramazai.uinType);
      localMessageForShortVideo.subBusiType = 0;
      break;
      label551:
      if (localMessageForShortVideo.istroop == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break label233;
      }
      if (localMessageForShortVideo.istroop != 1) {
        break label233;
      }
      localMessageForShortVideo.fileType = 9;
      break label233;
      label591:
      if (2 == paramazai.dFl)
      {
        localMessageForShortVideo.busiType = 1;
        break label251;
      }
      if (3 == paramazai.dFl)
      {
        localMessageForShortVideo.busiType = 2;
        break label251;
      }
      localMessageForShortVideo.busiType = 0;
      break label251;
      label634:
      str1 = "0";
      break label323;
      label642:
      i = 0;
      break label341;
      label647:
      localMessageForShortVideo.msg = anft.cdy;
      break label398;
      label658:
      localMessageForShortVideo.saveExtInfoToExtStr("video_send_aio_key_is_qim", "false");
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    akxe.M(this.logTag, this.bUB, "attachRichText2Msg", "");
    if ((this.F instanceof MessageForRichText)) {
      ((MessageForRichText)this.F).richText = paramRichText;
    }
    return this.F;
  }
  
  public void a(akyf.a parama)
  {
    akxe.M(this.logTag, this.bUB, "updateMsg", "resut:" + parama);
    if (parama != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.F;
      localMessageForShortVideo.videoFileSize = ((int)parama.size);
      localMessageForShortVideo.uuid = parama.uuid;
      localMessageForShortVideo.md5 = parama.md5;
      localMessageForShortVideo.thumbFileSize = ((int)parama.JW);
      localMessageForShortVideo.videoAttr = parama.videoAttr;
      localMessageForShortVideo.videoKandianType = parama.videoKandianType;
      localMessageForShortVideo.serial();
      this.mApp.b().c(this.F.frienduin, this.F.istroop, this.F.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayzh
 * JD-Core Version:    0.7.0.1
 */