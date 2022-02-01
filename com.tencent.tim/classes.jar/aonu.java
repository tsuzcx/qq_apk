import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForDanceMachine;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.PTVUpConfigInfo;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.1;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.2;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.3;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.7;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class aonu
  extends aojl
{
  protected acls a;
  Boolean aF = Boolean.valueOf(false);
  protected long apR;
  QQAppInterface app = (QQAppInterface)this.app;
  public boolean cFC;
  private volatile boolean cNk;
  boolean cNp = false;
  private boolean cNs;
  public boolean cNt;
  private int cqe = 1;
  protected int dPA;
  protected int dPz;
  protected int dQp;
  int dQq = -1;
  private int dQs;
  private int dQt;
  private byte[] de;
  achq e = new aonx(this);
  private byte[] fH;
  aojn.a g = new aojn.a();
  protected String mThumbFilePath;
  
  public aonu(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    if ((this.h.F != null) && ((this.h.F instanceof MessageForShortVideo))) {}
    for (this.dQq = ((MessageForShortVideo)this.h.F).busiType;; this.dQq = 0)
    {
      if (!this.h.cND)
      {
        paramaooi = this.h.dQ;
        paramaool = paramaooi.split("QQ_&_MoblieQQ_&_QQ");
        if (4 == paramaool.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "path was not set correctlly------path = " + paramaooi);
        }
        dN(9304, "path =" + paramaooi);
        onError();
        this.mIsCancel = true;
      }
      return;
    }
    this.h.dQ = paramaool[0];
    this.mThumbFilePath = paramaool[1];
    this.dQp = Integer.parseInt(paramaool[2]);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "Init params videoTime : " + this.dQp);
    }
    this.fG = HexUtil.hexStr2Bytes(paramaool[3]);
  }
  
  private aoql.a.n a()
  {
    aoql.a.n localn = new aoql.a.n();
    localn.seq = ((int)this.h.mUniseq);
    localn.selfUin = this.h.mSelfUin;
    String str;
    int i;
    if ((this.h.F != null) && ((this.h.F instanceof MessageForBlessPTV)))
    {
      Object localObject = (MessageForBlessPTV)this.h.F;
      if (((MessageForBlessPTV)localObject).uinList != null)
      {
        str = (String)((MessageForBlessPTV)localObject).uinList.get(0);
        localn.peerUin = str;
        localn.subBusiType = 1;
        if (((MessageForBlessPTV)localObject).uinList == null) {
          break label450;
        }
        i = ((MessageForBlessPTV)localObject).uinList.size();
        label121:
        localn.dRq = i;
        label127:
        localn.uinType = this.h.mUinType;
        localn.dRn = 0;
        if ((localn.uinType != 0) && (1008 != localn.uinType)) {
          break label535;
        }
        localn.troopUin = null;
        label170:
        if (localn.uinType != 0) {
          break label550;
        }
        localn.chatType = 0;
        label184:
        localn.clientType = 2;
        localObject = new File(this.h.dQ);
        str = ((File)localObject).getName();
        localn.fileName = str;
        localn.fileSize = ((File)localObject).length();
        localn.md5 = this.bL;
        localn.fG = this.fG;
        localn.dRp = this.dPA;
        localn.dRo = this.dPz;
        localn.dFo = this.dQp;
        localn.JW = this.apR;
        localObject = this.jdField_b_of_type_Aoko;
        long l = localn.fileSize + this.apR;
        this.mFileSize = l;
        ((aoko)localObject).fileSize = l;
        i = eG(str.substring(str.lastIndexOf(".") + 1));
        localn.format = i;
        this.mM.put("param_fileFormat", String.valueOf(i));
        this.mM.put("param_picResLength", String.valueOf(this.dPz));
        this.mM.put("param_picResWidth", String.valueOf(this.dPA));
        if ((this.h.F == null) || (!(this.h.F instanceof MessageForShortVideo))) {
          break label597;
        }
      }
    }
    label450:
    label597:
    for (localn.busiType = ((MessageForShortVideo)this.h.F).busiType;; localn.busiType = 0)
    {
      this.dQq = localn.busiType;
      return localn;
      str = "0";
      break;
      i = 1;
      break label121;
      if ((this.h.F != null) && (((MessageForShortVideo)this.h.F).CheckIsHotVideo()))
      {
        localn.peerUin = this.h.mPeerUin;
        localn.subBusiType = 0;
        localn.dRq = 1;
        break label127;
      }
      localn.peerUin = this.h.mPeerUin;
      localn.subBusiType = 0;
      localn.dRq = 1;
      break label127;
      localn.troopUin = this.h.mPeerUin;
      break label170;
      if (1 == localn.uinType)
      {
        localn.chatType = 1;
        break label184;
      }
      if (3000 == localn.uinType)
      {
        localn.chatType = 2;
        break label184;
      }
      localn.chatType = 3;
      break label184;
    }
  }
  
  private im_msg_body.RichText a()
  {
    for (;;)
    {
      try
      {
        im_msg_body.RichText localRichText = new im_msg_body.RichText();
        im_msg_body.VideoFile localVideoFile = new im_msg_body.VideoFile();
        localVideoFile.setHasFlag(true);
        if (this.mResid != null) {
          localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mResid));
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "mResid uuid=" + this.mResid);
        }
        if (!(this.h.F instanceof MessageForShortVideo)) {
          break label614;
        }
        Object localObject1 = (MessageForShortVideo)this.h.F;
        videoFile.ResvAttr localResvAttr;
        if (localObject1 != null)
        {
          localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).fileSource));
          localVideoFile.uint32_busi_type.set(((MessageForShortVideo)localObject1).busiType);
          localVideoFile.bool_support_progressive.set(((MessageForShortVideo)localObject1).supportProgressive);
          localVideoFile.uint32_file_width.set(((MessageForShortVideo)localObject1).fileWidth);
          localVideoFile.uint32_file_height.set(((MessageForShortVideo)localObject1).fileHeight);
          localVideoFile.uint32_sub_busi_type.set(((MessageForShortVideo)localObject1).subBusiType);
          localResvAttr = new videoFile.ResvAttr();
          localResvAttr.uint32_msg_tail_type.set(((MessageForShortVideo)localObject1).msgTailType);
          if ((localObject1 != null) && (((MessageForShortVideo)localObject1).CheckIsHotVideo()))
          {
            a(localResvAttr, (MessageForShortVideo)localObject1, localVideoFile);
            PBBytesField localPBBytesField = localResvAttr.bytes_camera_templateid;
            if (((MessageForShortVideo)localObject1).templateId == null) {
              break label600;
            }
            localObject3 = ((MessageForShortVideo)localObject1).templateId;
            localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject3));
            localPBBytesField = localResvAttr.bytes_camera_templateName;
            if (((MessageForShortVideo)localObject1).templateName == null) {
              break label607;
            }
            localObject3 = ((MessageForShortVideo)localObject1).templateName;
            localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject3));
            localResvAttr.uint32_long_video_kandian_type.set(this.dQt);
            b((MessageForShortVideo)localObject1, localResvAttr);
            localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(localResvAttr.toByteArray()));
            localVideoFile.uint32_video_attr.set(this.dQs);
          }
        }
        else
        {
          localVideoFile.uint32_file_format.set(2);
          localVideoFile.uint32_file_size.set((int)(this.mFileSize - this.apR));
          localVideoFile.uint32_file_time.set(this.dQp);
          localVideoFile.uint32_thumb_width.set(this.dPA);
          localVideoFile.uint32_thumb_height.set(this.dPz);
          localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.fG));
          localVideoFile.uint32_thumb_file_size.set((int)this.apR);
          localVideoFile.uint32_from_chat_type.set(-1);
          localVideoFile.uint32_to_chat_type.set(-1);
          localObject3 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject3).setHasFlag(true);
          ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8(acfp.m(2131714526)));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
          localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).video_file.set(localVideoFile);
          localRichText.elems.add((MessageMicro)localObject1);
          localRichText.elems.add((MessageMicro)localObject3);
          return localRichText;
        }
        if (((MessageForShortVideo)localObject1).CheckIsDanceVideo()) {
          localResvAttr.uint32_special_video_type.set(((MessageForShortVideo)localObject1).specialVideoType);
        }
        localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.h.dQ));
        localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.h.mMd5)));
        continue;
        localObject3 = "";
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      label600:
      continue;
      label607:
      Object localObject3 = "";
      continue;
      label614:
      Object localObject2 = null;
    }
  }
  
  private void a(angt paramangt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    alyr localalyr;
    int i;
    if (paramangt != null)
    {
      localalyr = new alyr(BaseApplication.getContext());
      i = 2002;
      switch (((MessageForShortVideo)paramMessageRecord).busiType)
      {
      }
    }
    for (;;)
    {
      if ((paramangt.originalFilePath == null) || (paramangt.originalFilePath.length() <= 0)) {
        paramangt.originalFilePath = paramangt.localPath;
      }
      localalyr.a(this.app, paramangt.originalFilePath, i, paramMessageRecord.istroop, paramMessageRecord.frienduin, false, paramBoolean, -1, null, paramangt.dFo, paramangt.md5);
      return;
      i = 2002;
      continue;
      i = 2001;
      continue;
      i = 2003;
    }
  }
  
  private void a(videoFile.ResvAttr paramResvAttr, MessageForShortVideo paramMessageForShortVideo, im_msg_body.VideoFile paramVideoFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "constructRichText MessageForHotVideo ");
    }
    paramResvAttr.bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoIconUrl));
    paramResvAttr.bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoTitle));
    paramResvAttr.bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoUrl));
    paramResvAttr.bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoSubIconUrl));
    paramResvAttr.uint32_special_video_type.set(paramMessageForShortVideo.specialVideoType);
    label162:
    StringBuilder localStringBuilder;
    if (this.mUuid != null)
    {
      paramVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mUuid));
      if ((this.clf == null) || (this.clf.length() <= 0)) {
        break label262;
      }
      paramVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.clf)));
      if ((paramMessageForShortVideo.md5 == null) || (paramMessageForShortVideo.md5.length() == 0)) {
        paramMessageForShortVideo.md5 = this.clf;
      }
      r(paramMessageForShortVideo);
      if ((paramMessageForShortVideo.videoFileName == null) || (paramMessageForShortVideo.videoFileName.length() == 0))
      {
        localStringBuilder = new StringBuilder();
        if (this.clf != null) {
          break label289;
        }
      }
    }
    label262:
    label289:
    for (paramResvAttr = "HotVideo";; paramResvAttr = this.clf)
    {
      paramMessageForShortVideo.videoFileName = (paramResvAttr + ".mp4");
      paramVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.videoFileName));
      return;
      if (paramMessageForShortVideo.uuid == null) {
        break;
      }
      paramVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.uuid));
      break;
      if (paramMessageForShortVideo.md5 == null) {
        break label162;
      }
      paramVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(paramMessageForShortVideo.md5)));
      break label162;
    }
  }
  
  private void a(im_msg_body.RichText paramRichText, angt paramangt, boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.h.b != null)
    {
      localMessageRecord = this.h.b.a(paramRichText);
      if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForShortVideo))) {
        break label174;
      }
      paramangt = new StringBuilder().append("Mr_");
      if (localMessageRecord != null) {
        break label146;
      }
    }
    label146:
    for (paramRichText = "null";; paramRichText = "" + localMessageRecord.msgtype)
    {
      a(9368, "msgtypeError", paramRichText, this.c);
      onError();
      return;
      if (this.h.F != null)
      {
        localMessageRecord = this.h.F;
        break;
      }
      localMessageRecord = this.app.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
      break;
    }
    label174:
    ((MessageForShortVideo)localMessageRecord).richText = paramRichText;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start, subBusiType = " + ((MessageForShortVideo)localMessageRecord).subBusiType);
    }
    if ((this.h.mBusiType == 1010) && (this.h.b != null))
    {
      onSuccess();
      return;
    }
    if ((localMessageRecord instanceof MessageForBlessPTV))
    {
      ((MessageForBlessPTV)localMessageRecord).uuid = this.mResid;
      this.app.a().notifyUI(999, true, localMessageRecord.frienduin);
      akxe.a("ShortVideoUploadProcessor", "updataMessageDataBaseContent", "notifyUI bless ptv data send finished");
      return;
    }
    if ((localMessageRecord instanceof MessageForDanceMachine))
    {
      ((MessageForDanceMachine)localMessageRecord).uuid = this.mResid;
      this.app.a().notifyUI(8034, true, localMessageRecord);
      akxe.a("ShortVideoUploadProcessor", "updataMessageDataBaseContent", "notifyUI dance machine data send finished");
      return;
    }
    if (!azQ())
    {
      a(9366, "illegal app", null, this.c);
      onError();
      return;
    }
    aqip.bj(String.valueOf(this.h.mUniseq), "message", "sendMsg() []. mr = " + localMessageRecord.toString());
    ((ambj)this.app.getManager(326)).d(localMessageRecord, this.e);
    a(paramangt, localMessageRecord, paramBoolean);
  }
  
  private void b(MessageForShortVideo paramMessageForShortVideo, videoFile.ResvAttr paramResvAttr)
  {
    int i = 6;
    String str = "unknown";
    if (this.cFC)
    {
      i = 7;
      str = "favorite";
    }
    for (;;)
    {
      paramResvAttr.uint32_source.set(2);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, new Object[] { "videoSource report: ", Integer.valueOf(i), ", from ", str });
      }
      return;
      if (paramMessageForShortVideo.busiType == 0)
      {
        str = "gallery";
        i = 2;
      }
      else if (paramMessageForShortVideo.busiType == 1)
      {
        str = "aio camera";
        i = 1;
      }
    }
  }
  
  private void dVp()
  {
    this.jdField_b_of_type_Aoko.jdField_a_of_type_Aoko$a.reset();
    this.jdField_b_of_type_Aoko.b.reset();
    this.jdField_b_of_type_Aoko.jdField_a_of_type_Aoko$b.reset();
    this.jdField_b_of_type_Aoko.c.reset();
    aoko localaoko = this.jdField_b_of_type_Aoko;
    long l = System.nanoTime();
    localaoko.startTime = l;
    this.mStartTime = l;
    this.jdField_b_of_type_Aoko.endTime = 0L;
  }
  
  private void dWg()
  {
    if (this.h.F != null) {}
    for (MessageRecord localMessageRecord = this.h.F;; localMessageRecord = this.app.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq))
    {
      if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForShortVideo)) && (((MessageForShortVideo)localMessageRecord).redBagType == LocalMediaInfo.REDBAG_TYPE_GET)) {
        anjo.dS(this.app);
      }
      return;
    }
  }
  
  private int eG(String paramString)
  {
    int i = -1;
    if ("avi".equals(paramString)) {
      i = 2;
    }
    do
    {
      return i;
      if ("mp4".equals(paramString)) {
        return 3;
      }
      if ("wmv".equals(paramString)) {
        return 4;
      }
      if ("mkv".equals(paramString)) {
        return 5;
      }
      if ("rmvb".equals(paramString)) {
        return 6;
      }
      if ("rm".equals(paramString)) {
        return 7;
      }
      if ("afs".equals(paramString)) {
        return 8;
      }
      if ("mov".equals(paramString)) {
        return 9;
      }
      if ("mod".equals(paramString)) {
        return 10;
      }
      if ("ts".equals(paramString)) {
        return 1;
      }
    } while (!"mts".equals(paramString));
    return 11;
  }
  
  private void r(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((this.apR == 0L) && (paramMessageForShortVideo.thumbFileSize != 0)) {
      this.apR = paramMessageForShortVideo.thumbFileSize;
    }
    if ((this.mFileSize == 0L) && (paramMessageForShortVideo.videoFileSize != 0)) {
      this.mFileSize = (paramMessageForShortVideo.videoFileSize + this.apR);
    }
    if ((this.dPA == 0) && (paramMessageForShortVideo.thumbWidth != 0)) {
      this.dPA = paramMessageForShortVideo.thumbWidth;
    }
    if ((this.dPz == 0) && (paramMessageForShortVideo.thumbHeight != 0)) {
      this.dPz = paramMessageForShortVideo.thumbHeight;
    }
  }
  
  protected String AJ()
  {
    if ((this.h.mUinType == 1) || (this.h.mUinType == 3000))
    {
      if (this.dPg == 1) {
        return "actShortVideoDiscussgroupUploadBDH";
      }
      return "actShortVideoDiscussgroupUpload";
    }
    if (this.dPg == 1) {
      return "actShortVideoUploadBDH";
    }
    return "actShortVideoUpload";
  }
  
  public int EN()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "resume()  + mIsPause : " + this.mIsPause);
    }
    if (this.mIsPause)
    {
      this.mIsPause = false;
      this.mIsCancel = false;
      VR(1002);
      this.dPd = 0;
      this.QV = 0;
      this.dOO = 0;
      this.errCode = 0;
      this.errDesc = "";
      dVp();
      VR(1001);
      this.jdField_a_of_type_Aojm.a.post(new ShortVideoUploadProcessor.1(this));
    }
    return 0;
  }
  
  public int KH()
  {
    if ((this.h != null) && (this.h.F != null) && (((MessageForShortVideo)this.h.F).busiType == 0)) {
      this.cLY = true;
    }
    return 0;
  }
  
  protected void Q(boolean paramBoolean, long paramLong)
  {
    if ((this.mTrans != null) && (this.dPg == 1) && (this.app != null) && (this.app.getHwEngine() != null) && (this.app.getHwEngine().getCurrentConfig().segNum > 32L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("segNum", String.valueOf(this.app.getHwEngine().getCurrentConfig().segNum));
      localHashMap.put("param_FailCode", String.valueOf(this.errCode));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "tempVideoUploadBDH", paramBoolean, paramLong, this.mFileSize, localHashMap, "");
    }
  }
  
  public void QV(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.h.F != null)
    {
      localMessageRecord = this.h.F;
      if (localMessageRecord != null) {
        break label78;
      }
      hM("updateDb", "msg null");
    }
    label78:
    while (!(localMessageRecord instanceof MessageForShortVideo))
    {
      return;
      localMessageRecord = this.app.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
      hM("updateDb", "findmsgbyMsgId,need fix");
      break;
    }
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
    localMessageForShortVideo.videoFileSize = ((int)(this.mFileSize - this.apR));
    if (this.mResid == null) {}
    for (String str = this.mUuid;; str = this.mResid)
    {
      localMessageForShortVideo.uuid = str;
      localMessageForShortVideo.md5 = this.clf;
      localMessageForShortVideo.videoAttr = this.dQs;
      localMessageForShortVideo.videoKandianType = this.dQt;
      localMessageForShortVideo.serial();
      this.app.b().c(this.h.mPeerUin, this.h.mUinType, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
      return;
    }
  }
  
  void Rb(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start.");
    }
    if (!azR())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "do not send message, due to mIsCancel=true || mIsPause=true.");
      }
      return;
    }
    Object localObject2;
    if ((this.h.en != null) && ((this.h.en instanceof angt)))
    {
      localObject2 = (angt)this.h.en;
      this.cNs = ((angt)localObject2).syncToStory;
      localObject1 = localObject2;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start, mNeedSyncStory = " + this.cNs);
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start, isHotVideo = " + localObject1.cjw);
        }
        if (localObject1.cjw)
        {
          this.mUuid = localObject1.uuid;
          this.clf = localObject1.md5;
          this.bL = HexUtil.hexStr2Bytes(localObject1.md5);
          this.mFileSize = (localObject1.ceG + localObject1.akZ);
          this.dQp = localObject1.dFo;
          this.apR = localObject1.akZ;
          this.fG = HexUtil.hexStr2Bytes(localObject1.thumbMD5);
          this.dPz = localObject1.thumbHeight;
          this.dPA = localObject1.thumbWidth;
        }
      }
      if (!this.cMb) {
        break;
      }
      aqip.bj(String.valueOf(this.h.mUniseq), "message", "sendMsg() start.");
      this.c.dVf();
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.c);
        onError();
        return;
      }
      a((im_msg_body.RichText)localObject2, localObject1, paramBoolean);
      return;
    }
  }
  
  protected void Sc(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    this.dPA = localOptions.outWidth;
    this.dPz = localOptions.outHeight;
  }
  
  protected void VR(int paramInt)
  {
    super.VR(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMessageToUpdate------state = " + paramInt + ", str= " + ShortVideoUtils.ff(paramInt));
    }
    if ((this.mIsPause) && (1004 != paramInt)) {
      return;
    }
    anfr.a(this.app, this.jdField_b_of_type_Aoko, this.h);
  }
  
  public void a(int paramInt, HashMap<String, String> paramHashMap, long paramLong)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - paramLong) + "ms");
    }
    I(paramHashMap);
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      this.cNk = true;
    }
    ThreadManager.post(new ShortVideoUploadProcessor.3(this, l2, l3, l4, l5), 5, null, true);
    a(paramInt, "OnFailed.", "", this.jdField_b_of_type_Aojn$a);
    if ((this.cqe == 3) && (this.g != null))
    {
      this.g.dVg();
      this.g.result = 0;
    }
    if (!QLog.isColorLevel()) {}
    for (;;)
    {
      onError();
      return;
      anow.report("Upload_Video_Error", String.valueOf(paramInt));
    }
  }
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    this.jdField_a_of_type_Aoql$a = null;
    if (paramb != null)
    {
      int i = 0;
      if (i < paramb.Hf.size())
      {
        parama = (aoql.b.p)paramb.Hf.get(i);
        if (QLog.isColorLevel()) {
          hM("procUrl", parama.toString());
        }
        a(this.jdField_a_of_type_Aojn$a, parama);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.result = " + parama.result);
        }
        this.mResid = parama.fileId;
        if (parama.result == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.isExist = " + parama.isExist);
          }
          this.dQs = parama.videoAttr;
          this.dQt = parama.videoKandianType;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.videoAttr = " + parama.videoAttr + ", response.videoKandianType = " + parama.videoKandianType);
          }
          if (parama.isExist)
          {
            this.cNp = true;
            VR(1007);
            Rb(true);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.apw = parama.startOffset;
          log("<BDH_LOG> onBusiProtoResp() send by bdh");
          this.dPg = 1;
          dVt();
          continue;
          onError();
        }
      }
    }
  }
  
  public byte[] a(aoql.a.n paramn)
  {
    PttShortVideo.PttShortVideoUploadReq localPttShortVideoUploadReq = new PttShortVideo.PttShortVideoUploadReq();
    localPttShortVideoUploadReq.setHasFlag(true);
    localPttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(paramn.selfUin));
    localPttShortVideoUploadReq.uint64_touin.set(Long.parseLong(paramn.peerUin));
    localPttShortVideoUploadReq.uint32_chat_type.set(paramn.chatType);
    localPttShortVideoUploadReq.uint32_client_type.set(paramn.clientType);
    if (paramn.troopUin != null) {
      localPttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(paramn.troopUin));
    }
    for (;;)
    {
      localPttShortVideoUploadReq.uint32_agent_type.set(paramn.dRn);
      localPttShortVideoUploadReq.uint32_business_type.set(paramn.busiType);
      localPttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
      PttShortVideo.PttShortVideoFileInfo localPttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
      localPttShortVideoFileInfo.str_file_name.set(paramn.fileName);
      localPttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(paramn.md5));
      localPttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(paramn.fG));
      localPttShortVideoFileInfo.uint64_file_size.set(paramn.fileSize);
      localPttShortVideoFileInfo.uint32_file_res_length.set(paramn.dRo);
      localPttShortVideoFileInfo.uint32_file_res_width.set(paramn.dRp);
      localPttShortVideoFileInfo.uint32_file_format.set(paramn.format);
      localPttShortVideoFileInfo.uint32_file_time.set(paramn.dFo);
      localPttShortVideoFileInfo.uint64_thumb_file_size.set(paramn.JW);
      localPttShortVideoUploadReq.msg_PttShortVideoFileInfo.set(localPttShortVideoFileInfo);
      return localPttShortVideoUploadReq.toByteArray();
      localPttShortVideoUploadReq.uint64_group_code.set(0L);
    }
  }
  
  /* Error */
  public boolean aAn()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 165	aonu:fG	[B
    //   4: ifnonnull +98 -> 102
    //   7: new 1245	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 143	aonu:mThumbFilePath	Ljava/lang/String;
    //   15: invokespecial 1246	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: lconst_0
    //   24: invokestatic 1252	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   27: putfield 165	aonu:fG	[B
    //   30: aload_2
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 165	aonu:fG	[B
    //   36: ifnonnull +58 -> 94
    //   39: aload_2
    //   40: astore_1
    //   41: aload_0
    //   42: sipush 9041
    //   45: new 114	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 1254
    //   55: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 143	aonu:mThumbFilePath	Ljava/lang/String;
    //   62: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokevirtual 135	aonu:dN	(ILjava/lang/String;)V
    //   71: aload_2
    //   72: astore_1
    //   73: aload_0
    //   74: invokevirtual 138	aonu:onError	()V
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 1257	java/io/FileInputStream:close	()V
    //   85: iconst_0
    //   86: ireturn
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 1258	java/io/IOException:printStackTrace	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 1257	java/io/FileInputStream:close	()V
    //   102: aload_0
    //   103: getfield 1262	aonu:i	Ljava/io/RandomAccessFile;
    //   106: ifnonnull +126 -> 232
    //   109: aload_0
    //   110: new 1264	java/io/RandomAccessFile
    //   113: dup
    //   114: aload_0
    //   115: getfield 143	aonu:mThumbFilePath	Ljava/lang/String;
    //   118: ldc_w 1265
    //   121: invokespecial 1267	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: putfield 1262	aonu:i	Ljava/io/RandomAccessFile;
    //   127: aload_0
    //   128: getfield 1262	aonu:i	Ljava/io/RandomAccessFile;
    //   131: ifnonnull +101 -> 232
    //   134: aload_0
    //   135: sipush 9303
    //   138: ldc_w 1269
    //   141: invokevirtual 135	aonu:dN	(ILjava/lang/String;)V
    //   144: aload_0
    //   145: invokevirtual 138	aonu:onError	()V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 1258	java/io/IOException:printStackTrace	()V
    //   155: goto -53 -> 102
    //   158: astore_3
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_2
    //   162: astore_1
    //   163: aload_0
    //   164: aconst_null
    //   165: putfield 165	aonu:fG	[B
    //   168: aload_2
    //   169: astore_1
    //   170: aload_0
    //   171: aload_3
    //   172: invokevirtual 1272	aonu:a	(Ljava/io/IOException;)V
    //   175: aload_2
    //   176: astore_1
    //   177: aload_0
    //   178: invokevirtual 138	aonu:onError	()V
    //   181: aload_2
    //   182: ifnull -97 -> 85
    //   185: aload_2
    //   186: invokevirtual 1257	java/io/FileInputStream:close	()V
    //   189: iconst_0
    //   190: ireturn
    //   191: astore_1
    //   192: aload_1
    //   193: invokevirtual 1258	java/io/IOException:printStackTrace	()V
    //   196: iconst_0
    //   197: ireturn
    //   198: astore_2
    //   199: aconst_null
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull +7 -> 209
    //   205: aload_1
    //   206: invokevirtual 1257	java/io/FileInputStream:close	()V
    //   209: aload_2
    //   210: athrow
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 1258	java/io/IOException:printStackTrace	()V
    //   216: goto -7 -> 209
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 1273	java/io/FileNotFoundException:printStackTrace	()V
    //   224: aload_0
    //   225: aconst_null
    //   226: putfield 1262	aonu:i	Ljava/io/RandomAccessFile;
    //   229: goto -102 -> 127
    //   232: aload_0
    //   233: new 227	java/io/File
    //   236: dup
    //   237: aload_0
    //   238: getfield 143	aonu:mThumbFilePath	Ljava/lang/String;
    //   241: invokespecial 230	java/io/File:<init>	(Ljava/lang/String;)V
    //   244: invokevirtual 240	java/io/File:length	()J
    //   247: putfield 265	aonu:apR	J
    //   250: aload_0
    //   251: aload_0
    //   252: getfield 143	aonu:mThumbFilePath	Ljava/lang/String;
    //   255: invokevirtual 1275	aonu:Sc	(Ljava/lang/String;)V
    //   258: iconst_1
    //   259: ireturn
    //   260: astore_2
    //   261: goto -60 -> 201
    //   264: astore_3
    //   265: goto -104 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	aonu
    //   20	53	1	localFileInputStream1	java.io.FileInputStream
    //   87	2	1	localIOException1	java.io.IOException
    //   150	2	1	localIOException2	java.io.IOException
    //   162	15	1	localFileInputStream2	java.io.FileInputStream
    //   191	2	1	localIOException3	java.io.IOException
    //   200	6	1	localObject1	Object
    //   211	2	1	localIOException4	java.io.IOException
    //   219	2	1	localFileNotFoundException	FileNotFoundException
    //   18	168	2	localFileInputStream3	java.io.FileInputStream
    //   198	12	2	localObject2	Object
    //   260	1	2	localObject3	Object
    //   158	14	3	localIOException5	java.io.IOException
    //   264	1	3	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   81	85	87	java/io/IOException
    //   98	102	150	java/io/IOException
    //   7	19	158	java/io/IOException
    //   185	189	191	java/io/IOException
    //   7	19	198	finally
    //   205	209	211	java/io/IOException
    //   109	127	219	java/io/FileNotFoundException
    //   21	30	260	finally
    //   32	39	260	finally
    //   41	71	260	finally
    //   73	77	260	finally
    //   163	168	260	finally
    //   170	175	260	finally
    //   177	181	260	finally
    //   21	30	264	java/io/IOException
    //   32	39	264	java/io/IOException
    //   41	71	264	java/io/IOException
    //   73	77	264	java/io/IOException
  }
  
  public boolean aAo()
  {
    if (!TextUtils.isEmpty(this.h.mMd5))
    {
      this.bL = HexUtil.hexStr2Bytes(this.h.mMd5);
      aoko localaoko = this.jdField_b_of_type_Aoko;
      String str = this.h.mMd5;
      localaoko.fileMd5 = str;
      this.clf = str;
    }
    if ((this.bL == null) && (!azT()))
    {
      onError();
      return false;
    }
    if (!aqhq.fileExistsAndNotEmpty(this.h.dQ))
    {
      dN(9042, "video file not exists");
      onError();
      return false;
    }
    if (this.mRaf == null) {
      try
      {
        this.mRaf = new RandomAccessFile(this.h.dQ, "r");
        if (this.mRaf == null)
        {
          dN(9303, "read video file error");
          onError();
          return false;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.mRaf = null;
        }
      }
    }
    return true;
  }
  
  public boolean aAp()
  {
    dWf();
    if ((this.de == null) || (this.de.length == 0) || (this.fH == null) || (this.fH.length == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUploadProcessor", 2, "sessionKey or sigSession is null ! ");
      }
      HwServlet.getConfig(this.app, this.h.mSelfUin);
    }
    return true;
  }
  
  public void b(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, String paramString, long paramLong)
  {
    long l1 = SystemClock.uptimeMillis();
    try
    {
      paramArrayOfByte = (PttShortVideo.PttShortVideoUploadResp)new PttShortVideo.PttShortVideoUploadResp().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte.str_fileid.has())
      {
        paramArrayOfByte = paramArrayOfByte.str_fileid.get();
        if (paramArrayOfByte.length() > 0)
        {
          this.mResid = paramArrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "set uuid from BDH ");
          }
        }
      }
      long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
      long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
      long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
      long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - paramLong) + "ms ,fileSize:" + this.jdField_b_of_type_Aoko.fileSize + " transInfo:" + (String)paramHashMap.get("rep_bdhTrans"));
      }
      I(paramHashMap);
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        this.cNk = true;
      }
      this.jdField_b_of_type_Aojn$a.dVg();
      this.jdField_b_of_type_Aojn$a.result = 1;
      this.bz = this.mFileSize;
      this.cNt = true;
      VR(1007);
      Rb(false);
      ThreadManager.post(new ShortVideoUploadProcessor.2(this, l2, l3, l4, l5), 5, null, true);
      this.jdField_b_of_type_Aoko.dVw();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      aqhq.deleteFile(paramString);
      paramString = (String)paramHashMap.get("ip");
      paramHashMap = (String)paramHashMap.get("port");
      String str = this.mFileName;
      if (this.mResid == null)
      {
        paramArrayOfByte = this.mUuid;
        a("actRichMediaNetMonitor_videoUp", true, 0, paramString, paramHashMap, str, paramArrayOfByte, this.dQq + "");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.e("ShortVideoUploadProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
          continue;
          paramArrayOfByte = this.mResid;
        }
      }
    }
  }
  
  public void dVG()
  {
    if (this.mIsCancel) {
      return;
    }
    if ((this.dPg == 1) && (this.mTrans != null))
    {
      if (this.mTrans.isSuccess.get())
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoUploadProcessor", 2, "inter_retry resume sendMsg!");
        }
        Rb(false);
        return;
      }
      this.app.getHwEngine().resumeTransactionTask(this.mTrans);
      return;
    }
    if ((this.mResid != null) && (this.bz >= this.mFileSize))
    {
      Rb(false);
      return;
    }
    start();
  }
  
  public void dVt()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
    }
    this.jdField_b_of_type_Aojn$a.dVf();
    if (this.mTrans != null) {}
    int j;
    do
    {
      return;
      long l = SystemClock.uptimeMillis();
      Object localObject = AI();
      aoql.a.n localn = a();
      byte[] arrayOfByte = a(localn);
      aonv localaonv = new aonv(this, (String)localObject, l);
      int i = 12;
      if (localn.busiType == 0) {
        i = 25;
      }
      this.mTrans = new Transaction(this.app.getCurrentAccountUin(), i, (String)localObject, (int)this.apw, this.bL, localaonv, arrayOfByte, true);
      localObject = new aonw(this);
      this.mTrans.cbForReport = ((ITransCallbackForReport)localObject);
      j = this.app.getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + j + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.h.mUniseq + " MD5:" + this.clf + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:" + i);
      }
    } while (j == 0);
    a(j, "sendFileByBDH SubmitError.", "", this.jdField_b_of_type_Aojn$a);
    onError();
  }
  
  public void dWe()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "start() isHotVideo");
    }
    if ((this.h.en == null) || ((this.h.en instanceof anfw)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.h.F;
      if ((localMessageForShortVideo.md5 != null) && (localMessageForShortVideo.md5.length() > 0)) {
        this.clf = localMessageForShortVideo.md5;
      }
      if ((localMessageForShortVideo.uuid != null) && (localMessageForShortVideo.uuid.length() > 0)) {
        this.mUuid = localMessageForShortVideo.uuid;
      }
      if ((localMessageForShortVideo.thumbMD5 != null) && (localMessageForShortVideo.thumbMD5.length() > 0)) {
        this.fG = HexUtil.hexStr2Bytes(localMessageForShortVideo.thumbMD5);
      }
    }
    VR(1001);
    Rb(false);
  }
  
  public void dWf()
  {
    try
    {
      int i;
      if (SessionInfo.getInstance(this.h.mSelfUin).getHttpconn_sig_session() != null)
      {
        i = SessionInfo.getInstance(this.h.mSelfUin).getHttpconn_sig_session().length;
        this.de = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.h.mSelfUin).getHttpconn_sig_session(), 0, this.de, 0, i);
      }
      if (SessionInfo.getInstance(this.h.mSelfUin).getSessionKey() != null)
      {
        i = SessionInfo.getInstance(this.h.mSelfUin).getSessionKey().length;
        this.fH = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.h.mSelfUin).getSessionKey(), 0, this.fH, 0, i);
      }
      return;
    }
    finally {}
  }
  
  protected void dWh()
  {
    if (((MessageForShortVideo)this.h.F).busiType == 0) {
      ThreadManager.post(new ShortVideoUploadProcessor.7(this, this.h.dQ), 5, null, true);
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (aona.lQ(this.errCode))) {}
    while ((this.cLT) || ((paramBoolean) && ((this.dOZ & 0x2) > 0)) || ((!paramBoolean) && ((this.dOZ & 0x1) > 0))) {
      return;
    }
    int j = this.dOZ;
    int i;
    long l;
    String str;
    if (paramBoolean)
    {
      i = 2;
      this.dOZ = (i | j);
      if ((this.h.mUinType == 1) || (this.h.mUinType == 3000)) {
        this.mM.put("param_grpUin", this.h.mPeerUin);
      }
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      str = this.jdField_a_of_type_Aojn$a.fB(1) + ";" + this.jdField_b_of_type_Aojn$a.fB(2) + ";" + this.c.fB(3);
      this.mM.put("param_step", str);
      this.mM.put("param_busiType", this.dQq + "");
      HashMap localHashMap = this.mM;
      if (this.mResid != null) {
        break label516;
      }
      str = this.mUuid;
      label252:
      localHashMap.put("param_uuid", str);
      this.mM.put("param_toUin", this.h.mPeerUin);
      this.mM.put("param_picSize", String.valueOf(this.mFileSize));
      this.mM.put("param_thumbSize", String.valueOf(this.apR));
      this.mM.put("param_isSecondTrans", this.cNp + "");
      if (this.h.mBusiType == 0) {
        this.mM.put("param_BDHExistBeforeVideoUpload", String.valueOf(this.aF));
      }
      if (this.cqe != 3) {
        this.mM.put("param_videoDuration", String.valueOf(this.dQp));
      }
      this.mM.put("param_fileMd5", this.h.mMd5);
      this.mM.put("param_BDH_Cache_Diff", String.valueOf(this.cNk));
      if (!paramBoolean) {
        break label525;
      }
      P(true, l);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), true, l, this.mFileSize, this.mM, "");
    }
    for (;;)
    {
      dVc();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "AutoMonitor_fragment MineFragment onAttach");
      }
      dWh();
      Q(paramBoolean, l);
      return;
      i = 1;
      break;
      label516:
      str = this.mResid;
      break label252;
      label525:
      if (this.errCode != -9527) {
        this.mM.remove("param_rspHeader");
      }
      this.mM.put("param_FailCode", String.valueOf(this.errCode));
      this.mM.put("param_errorDesc", this.errDesc);
      this.mM.put("param_uinType", String.valueOf(this.h.mUinType));
      P(false, l);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), false, l, this.mFileSize, this.mM, "");
    }
  }
  
  public void doStart()
  {
    if (this.h.cND)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "is Presend ");
      }
      this.cqe = 3;
      this.mThumbFilePath = this.h.bN;
      this.fG = HexUtil.hexStr2Bytes(this.h.aIf);
      if (aAn()) {
        break label159;
      }
    }
    label157:
    label159:
    while (!aAp())
    {
      do
      {
        return;
      } while (!aAo());
      if (((MessageForShortVideo)this.h.F).busiType == 1) {
        if (VideoUpConfigInfo.sSwitch != 2) {}
      }
      for (this.cqe = 2;; this.cqe = 2) {
        do
        {
          if (aonr.aqi <= 0L) {
            break label157;
          }
          this.mM.put("param_cost_c_comp", String.valueOf(aonr.aqi));
          break;
        } while ((((MessageForShortVideo)this.h.F).busiType != 2) || (PTVUpConfigInfo.sSwitch != 2));
      }
      break;
    }
    QLog.d("ShortVideoUploadProcessor", 1, "<BDH_LOG>mSwitch : " + this.cqe);
    switch (this.cqe)
    {
    default: 
      sendRequest();
      return;
    }
    this.dPg = 1;
    dVt();
  }
  
  void onError()
  {
    super.onError();
    if ((this.cqe == 3) && (this.clf != null) && (this.clf.length() > 0)) {
      if (this.h.F == null) {
        break label320;
      }
    }
    label320:
    for (Object localObject = this.h.F;; localObject = this.app.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq))
    {
      if ((localObject != null) && ((localObject instanceof MessageForShortVideo))) {
        ((MessageForShortVideo)localObject).md5 = this.clf;
      }
      VR(1005);
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errCode:" + this.errCode);
        QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errDesc:" + this.errDesc);
      }
      if (this.h.b != null)
      {
        localObject = new akyf.a();
        ((akyf.a)localObject).result = -1;
        ((akyf.a)localObject).errCode = this.errCode;
        ((akyf.a)localObject).errStr = this.errDesc;
        this.h.b.b((akyf.a)localObject);
      }
      if ((this.h.F != null) && ((this.h.F instanceof MessageForBlessPTV)))
      {
        this.app.a().notifyUI(999, false, this.h.F.frienduin);
        akxe.a("ShortVideoUploadProcessor", "onError", "notifyUI bless ptv send error");
      }
      if ((this.h.F != null) && ((this.h.F instanceof MessageForDanceMachine)))
      {
        ((MessageForDanceMachine)this.h.F).errorCode = 1;
        this.app.a().notifyUI(8034, false, this.h.F);
        akxe.a("ShortVideoUploadProcessor", "onError", "notifyUI dance machine send error");
      }
      return;
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (this.jdField_a_of_type_Acls != null) {
      this.jdField_a_of_type_Acls.kr(this.h.mMd5 + this.h.mPeerUin + this.h.mUniseq);
    }
    String str;
    if (this.h.b != null)
    {
      akyf.a locala = new akyf.a();
      locala.result = 0;
      locala.size = (this.mFileSize - this.apR);
      locala.md5 = this.clf;
      if (this.mResid == null)
      {
        str = this.mUuid;
        locala.uuid = str;
        locala.JW = this.apR;
        locala.videoAttr = this.dQs;
        locala.videoKandianType = this.dQt;
        this.h.b.b(locala);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "onSuccess uuid = " + locala.uuid);
        }
      }
    }
    for (;;)
    {
      VR(1003);
      if (this.h.mBusiType == 2) {
        dWg();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "onSuccess().");
      }
      return;
      str = this.mResid;
      break;
      QV(true);
    }
  }
  
  public void pause()
  {
    if (!this.mIsPause)
    {
      this.mIsPause = true;
      if (QLog.isColorLevel()) {
        hM("pause", "");
      }
      VR(1004);
      if ((this.h.mBusiType == 1010) && (this.h.b != null))
      {
        akyf.a locala = new akyf.a();
        locala.result = -1;
        locala.errCode = 9037;
        locala.errStr = "cancel";
        this.h.b.b(locala);
      }
      if (this.jdField_a_of_type_Aoql$a != null)
      {
        aoqm.d(this.jdField_a_of_type_Aoql$a);
        this.jdField_a_of_type_Aoql$a = null;
      }
    }
    switch (this.dPg)
    {
    default: 
      return;
    case 0: 
      log("<BDH_LOG> pause() BUT current status is INIT");
      return;
    }
    if (this.mTrans != null)
    {
      log("<BDH_LOG> pause() pause BDH channel, transation id=" + this.mTrans.getTransationId());
      this.app.getHwEngine().stopTransactionTask(this.mTrans);
      return;
    }
    log("<BDH_LOG> pause() pause BDH channel, but trans == null");
  }
  
  void sendRequest()
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    aoql.a locala = new aoql.a();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + this.h.mUniseq);
    }
    aoql.a.n localn = a();
    locala.b = this;
    locala.cmy = "short_video_up";
    locala.He.add(localn);
    locala.a = this.app.getProtoReqManager();
    if (!azQ())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
      onError();
    }
    do
    {
      return;
      if (localn.fileSize == 0L)
      {
        dN(9303, "video filesize is 0");
        onError();
        return;
      }
      if (this.apR == 0L)
      {
        dN(9303, "thumbfile filesize is 0");
        onError();
        return;
      }
      if ((localn.busiType == 0) && (this.app.getHwEngine().mConnManager.getCurrentConnNum() > 0)) {
        this.aF = Boolean.valueOf(true);
      }
      hM("requestStart", locala.toString());
    } while (!azR());
    this.jdField_a_of_type_Aoql$a = locala;
    aoqm.c(locala);
  }
  
  public void start()
  {
    if (this.mIsCancel) {
      return;
    }
    if ((((MessageForShortVideo)this.h.F).busiType == 0) && (((MessageForShortVideo)this.h.F).isPause))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "video send pause!");
      }
      pause();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "start()");
    }
    super.start();
    if (((MessageForShortVideo)this.h.F).CheckIsHotVideo())
    {
      dWe();
      return;
    }
    if ((this.h.en != null) && ((this.h.en instanceof angt))) {
      this.cFC = ((angt)this.h.en).cFC;
    }
    VR(1001);
    this.jdField_b_of_type_Aoko.dVw();
    doStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aonu
 * JD-Core Version:    0.7.0.1
 */