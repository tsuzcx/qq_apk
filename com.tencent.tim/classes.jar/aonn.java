import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.util.Log;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.1;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.2;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.3;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class aonn
  extends aojl
{
  private ArrayList<String> Bm = new ArrayList();
  protected acls a;
  MessageForShortVideo a;
  protected long apR;
  QQAppInterface app = (QQAppInterface)this.app;
  public boolean cNo;
  boolean cNp = false;
  public boolean cNq;
  private String cmg;
  protected int dPA;
  protected int dPz;
  protected int dQp;
  int dQq = -1;
  int dQr = 0;
  private int dQs;
  private int dQt;
  achq e = new aonq(this);
  private byte[] fZ;
  private byte[] ga;
  boolean isStoryVideo = false;
  protected String mThumbFilePath;
  private long yT;
  
  public aonn(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = null;
    if ((this.h != null) && (this.h.F != null) && ((this.h.F instanceof MessageForShortVideo)))
    {
      this.dQq = ((MessageForShortVideo)this.h.F).busiType;
      this.isStoryVideo = ((MessageForShortVideo)this.h.F).isStoryVideo;
      if (this.isStoryVideo) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)this.h.F);
      }
    }
    String[] arrayOfString;
    for (;;)
    {
      paramaooi = paramaool.dQ;
      arrayOfString = paramaooi.split("QQ_&_MoblieQQ_&_QQ");
      if (4 == arrayOfString.length) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "path was not set correctlly------path = " + paramaooi);
      }
      dN(9304, "path =" + paramaooi);
      onError();
      this.mIsCancel = true;
      return;
      this.dQq = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "init ShortVideoForwardProcessor=> " + Arrays.toString(arrayOfString));
    }
    paramaool.dQ = arrayOfString[0];
    this.mThumbFilePath = arrayOfString[1];
    this.dQp = Integer.parseInt(arrayOfString[2]);
    this.fG = HexUtil.hexStr2Bytes(arrayOfString[3]);
  }
  
  private aoql.a.m a()
  {
    aoql.a.m localm = new aoql.a.m();
    localm.seq = ((int)this.h.mUniseq);
    localm.selfUin = this.h.mSelfUin;
    localm.peerUin = this.h.mPeerUin;
    localm.uinType = this.h.mUinType;
    localm.dRn = 0;
    localm.troopUin = this.h.mPeerUin;
    localm.clientType = 2;
    if ((this.h.en != null) && ((this.h.en instanceof anfw)))
    {
      localObject = (anfw)this.h.en;
      localm.fromChatType = ((anfw)localObject).fromChatType;
      localm.toChatType = ((anfw)localObject).toChatType;
      localm.dFm = ((anfw)localObject).dFm;
      localm.dFn = ((anfw)localObject).dFn;
      this.dQq = localm.dFm;
      int i = ((anfw)localObject).dFo;
      this.dQp = i;
      localm.dFo = i;
      localm.uuid = ((anfw)localObject).uuid;
      localm.fileName = ((anfw)localObject).fileName;
      localm.format = ((anfw)localObject).fileFormat;
      localm.fromUin = ((anfw)localObject).fromUin;
      this.mM.put("param_fileFormat", String.valueOf(localm.format));
      this.mM.put("param_picResLength", String.valueOf(this.dPz));
      this.mM.put("param_picResWidth", String.valueOf(this.dPA));
      this.mM.put("param_fromChatType", String.valueOf(localm.fromChatType));
      this.mM.put("param_toChatType", String.valueOf(localm.toChatType));
      this.mM.put("param_fromBusiType", String.valueOf(localm.dFm));
      this.mM.put("param_toBusiType", String.valueOf(localm.dFn));
      if ((this.cmg != null) && (this.cmg.length() > 0)) {
        localm.fileName = this.cmg;
      }
      localm.fileSize = this.yT;
      localm.JW = this.apR;
      localm.dRp = this.dPA;
      localm.dRo = this.dPz;
      if (localm.fileName != null) {
        break label423;
      }
    }
    label423:
    for (Object localObject = "";; localObject = localm.fileName)
    {
      localm.fileName = ((String)localObject);
      localm.md5 = this.bL;
      localm.fG = this.fG;
      return localm;
      hM("sendRequest", "Error => mUiRequest.mExtraObj not ShortVideoForwardInfo");
      return null;
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
        if ((this.bL != null) && (this.bL.length > 0)) {
          localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(this.bL));
        }
        if ((this.mResid != null) && (this.mResid.length() > 0)) {
          localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mResid));
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoForwardProcessor", 2, "constructRichText(): mResid uuid=" + this.mResid);
        }
        if ((this.h.F instanceof MessageForShortVideo))
        {
          Object localObject1 = (MessageForShortVideo)this.h.F;
          if (localObject1 != null)
          {
            localVideoFile.uint32_file_format.set(((MessageForShortVideo)localObject1).videoFileFormat);
            localVideoFile.uint32_file_time.set(((MessageForShortVideo)localObject1).videoFileTime);
            if ((((MessageForShortVideo)localObject1).videoFileName != null) && (((MessageForShortVideo)localObject1).videoFileName.length() > 0)) {
              localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).videoFileName));
            }
            if ((((MessageForShortVideo)localObject1).fileSource != null) && (((MessageForShortVideo)localObject1).fileSource.length() > 0)) {
              localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).fileSource));
            }
            localVideoFile.uint32_busi_type.set(((MessageForShortVideo)localObject1).busiType);
            localVideoFile.uint32_from_chat_type.set(((MessageForShortVideo)localObject1).fromChatType);
            localVideoFile.uint32_to_chat_type.set(((MessageForShortVideo)localObject1).toChatType);
            localVideoFile.bool_support_progressive.set(((MessageForShortVideo)localObject1).supportProgressive);
            localVideoFile.uint32_file_width.set(((MessageForShortVideo)localObject1).fileWidth);
            localVideoFile.uint32_file_height.set(((MessageForShortVideo)localObject1).fileHeight);
          }
          if ((this.fG != null) && (this.fG.length > 0)) {
            localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.fG));
          }
          localVideoFile.uint32_thumb_file_size.set((int)this.apR);
          localVideoFile.uint32_file_size.set((int)this.yT);
          localVideoFile.uint32_thumb_width.set(this.dPA);
          localVideoFile.uint32_thumb_height.set(this.dPz);
          if ((this.cmg != null) && (this.cmg.length() > 0)) {
            localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.cmg));
          }
          Object localObject3 = new videoFile.ResvAttr();
          a((MessageForShortVideo)localObject1, (videoFile.ResvAttr)localObject3);
          if (this.cNo)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoForwardProcessor", 2, "videoSource report : 3 , from msg tab camera");
            }
            ((videoFile.ResvAttr)localObject3).uint32_source.set(3);
            localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((videoFile.ResvAttr)localObject3).toByteArray()));
            localVideoFile.uint32_video_attr.set(this.dQs);
            localObject3 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject3).setHasFlag(true);
            ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8(acfp.m(2131714496)));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
            localObject3 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject3).video_file.set(localVideoFile);
            localRichText.elems.add((MessageMicro)localObject1);
            localRichText.elems.add((MessageMicro)localObject3);
            return localRichText;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoForwardProcessor", 2, "videoSource report : 4 , from forward");
          }
          ((videoFile.ResvAttr)localObject3).uint32_source.set(4);
          continue;
        }
        Object localObject2 = null;
      }
      catch (Exception localException)
      {
        hM("Construct richtext", "Construct richtext error");
        localException.printStackTrace();
        return null;
      }
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, videoFile.ResvAttr paramResvAttr)
  {
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.CheckIsHotVideo()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "constructRichText MessageForHotVideo ");
      }
      if ((paramMessageForShortVideo.hotVideoIconUrl != null) && (paramMessageForShortVideo.hotVideoIconUrl.length() > 0)) {
        paramResvAttr.bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoIconUrl));
      }
      if ((paramMessageForShortVideo.hotVideoTitle != null) && (paramMessageForShortVideo.hotVideoTitle.length() > 0)) {
        paramResvAttr.bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoTitle));
      }
      if ((paramMessageForShortVideo.hotVideoUrl != null) && (paramMessageForShortVideo.hotVideoUrl.length() > 0)) {
        paramResvAttr.bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoUrl));
      }
      if ((paramMessageForShortVideo.hotVideoSubIconUrl != null) && (paramMessageForShortVideo.hotVideoSubIconUrl.length() > 0)) {
        paramResvAttr.bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoSubIconUrl));
      }
      paramResvAttr.uint32_special_video_type.set(paramMessageForShortVideo.specialVideoType);
    }
    Object localObject;
    if (paramMessageForShortVideo != null)
    {
      paramResvAttr.uint32_msg_tail_type.set(paramMessageForShortVideo.msgTailType);
      if (paramMessageForShortVideo.CheckIsDanceVideo()) {
        paramResvAttr.uint32_special_video_type.set(paramMessageForShortVideo.specialVideoType);
      }
      PBBytesField localPBBytesField = paramResvAttr.bytes_camera_templateid;
      if (paramMessageForShortVideo.templateId == null) {
        break label258;
      }
      localObject = paramMessageForShortVideo.templateId;
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localObject = paramResvAttr.bytes_camera_templateName;
      if (paramMessageForShortVideo.templateName == null) {
        break label265;
      }
    }
    label258:
    label265:
    for (paramMessageForShortVideo = paramMessageForShortVideo.templateName;; paramMessageForShortVideo = "")
    {
      ((PBBytesField)localObject).set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo));
      paramResvAttr.uint32_long_video_kandian_type.set(this.dQt);
      return;
      localObject = "";
      break;
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
  
  protected String AJ()
  {
    if (this.dPg == 1) {
      return "actShortVideoForwardBDH";
    }
    return "actShortVideoForward";
  }
  
  public int EN()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "resume()  + mIsPause : " + this.mIsPause);
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
      this.jdField_b_of_type_Auyc.initParam();
      dVp();
      this.jdField_a_of_type_Aojm.a.post(new ShortVideoForwardProcessor.1(this));
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
    localMessageForShortVideo.videoFileSize = ((int)this.mFileSize);
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
    int k = 2002;
    int i = 0;
    if (!azR()) {
      log("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.dPg);
    }
    Object localObject1;
    label238:
    do
    {
      do
      {
        return;
      } while (!this.cMb);
      this.c.dVf();
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.c);
        onError();
        return;
      }
      if (this.h.b != null)
      {
        localObject1 = this.h.b.a((im_msg_body.RichText)localObject2);
        if ((localObject1 != null) && ((localObject1 instanceof MessageForShortVideo))) {
          break label267;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label238;
        }
      }
      for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        a(9368, "msgtypeError", (String)localObject1, this.c);
        onError();
        return;
        if (this.h.F != null)
        {
          localObject1 = this.h.F;
          break;
        }
        localObject1 = this.app.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
        break;
      }
      ((MessageForShortVideo)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if (!azQ())
      {
        a(9366, "illegal app", null, this.c);
        onError();
        return;
      }
      if ((this.h.mBusiType == 1010) && (this.h.b != null))
      {
        super.onSuccess();
        localObject2 = new akyf.a();
        ((akyf.a)localObject2).result = 0;
        ((akyf.a)localObject2).size = this.yT;
        ((akyf.a)localObject2).md5 = this.clf;
        if (this.mResid == null) {}
        for (localObject1 = this.mUuid;; localObject1 = this.mResid)
        {
          ((akyf.a)localObject2).uuid = ((String)localObject1);
          ((akyf.a)localObject2).JW = this.apR;
          ((akyf.a)localObject2).videoAttr = this.dQs;
          ((akyf.a)localObject2).videoKandianType = this.dQt;
          this.h.b.a((akyf.a)localObject2);
          this.h.b.b((akyf.a)localObject2);
          return;
        }
      }
      ((ambj)this.app.getManager(326)).d((MessageRecord)localObject1, this.e);
    } while ((this.h.en == null) || (!(this.h.en instanceof anfw)));
    label267:
    Object localObject2 = (anfw)this.h.en;
    alyr localalyr = new alyr(BaseApplication.getContext());
    int j;
    switch (((anfw)localObject2).fromChatType)
    {
    default: 
      i = 5;
    case 0: 
      j = k;
      switch (((anfw)localObject2).dFn)
      {
      default: 
        j = k;
      }
      break;
    }
    for (;;)
    {
      localalyr.a(this.app, ((anfw)localObject2).localPath, j, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).frienduin, true, paramBoolean, i, ((anfw)localObject2).cdA, ((anfw)localObject2).dFo, ((anfw)localObject2).md5);
      return;
      i = 1;
      break;
      i = 3000;
      break;
      i = 5;
      break;
      j = 2001;
      continue;
      j = 2003;
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
    if (this.isStoryVideo) {
      axyl.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, paramInt, getProgress());
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
      QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - paramLong) + "ms");
    }
    I(paramHashMap);
    ThreadManager.post(new ShortVideoForwardProcessor.3(this, l2, l3, l4, l5), 5, null, true);
    a(paramInt, "OnFailed.", "", this.jdField_b_of_type_Aojn$a);
    onError();
  }
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    this.jdField_a_of_type_Aoql$a = null;
    if (paramb != null)
    {
      int i = 0;
      if (i < paramb.Hf.size())
      {
        parama = (aoql.b.o)paramb.Hf.get(i);
        hM("procUrl", parama.toString());
        a(this.jdField_a_of_type_Aojn$a, parama);
        this.mResid = parama.fileId;
        if (parama.result == 0)
        {
          this.dQs = parama.videoAttr;
          this.dQt = parama.videoKandianType;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoForwardProcessor", 2, "onBusiProtoResp()------response.videoAttr = " + parama.videoAttr + ", response.videoKandianType = " + parama.videoKandianType);
          }
          if (parama.isExist)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ShortVideoForwardProcessor", 2, "ShortVideo exist on server.");
            }
            this.cNp = true;
            VR(1007);
            Rb(true);
          }
          for (;;)
          {
            i += 1;
            break;
            a(parama);
          }
        }
        if (-5100026 == this.errCode) {
          dN(-5100026, "安全打击mUiRequest.mMd5:" + this.h.mMd5);
        }
        for (;;)
        {
          onError();
          break;
          dN(9045, acfp.m(2131714522));
        }
      }
    }
  }
  
  public void a(aoql.b.o paramo)
  {
    if (this.dQq == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoForwardProcessor", 2, "check ShortVideo before forward:" + this.h.dQ);
      }
      if ((aAk()) && (ShortVideoUtils.awL()))
      {
        dN(9305, "onBusiProtoResp=> video file can not play");
        onError();
        paramo = new HashMap();
        paramo.put(BaseConstants.RDM_NoChangeFailCode, "");
        paramo.put("filePath", this.h.dQ);
        paramo.put("uuid", this.mUuid);
        paramo.put("md5", this.h.mMd5);
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "actForwardVideoBroken", true, 0L, 0L, paramo, "");
      }
    }
    while (!aAl()) {
      return;
    }
    if ((this.mThumbFilePath != null) && (this.mThumbFilePath.length() > 0))
    {
      if ((this.ga == null) || (this.ga.length == 0)) {
        this.ga = HexUtil.hexStr2Bytes(aqhq.px(this.mThumbFilePath));
      }
      localObject = new File(this.mThumbFilePath);
      if ((((File)localObject).exists()) && (((File)localObject).length() > 0L))
      {
        this.apR = ((File)localObject).length();
        Sc(this.mThumbFilePath);
        this.mFileSize = (this.yT + this.apR);
        if ((this.bL != null) && (this.bL.length > 0) && (this.fZ != null) && (this.fZ.length > 0) && (this.fG != null) && (this.fG.length > 0) && (this.ga != null) && (this.ga.length > 0) && ((!Arrays.equals(this.bL, this.fZ)) || (!Arrays.equals(this.fG, this.ga))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoForwardProcessor", 2, "md5 diffrent : resend request !   mLocalMd5 : " + HexUtil.bytes2HexStr(this.bL) + " mVideoMd5_local : " + HexUtil.bytes2HexStr(this.fZ) + " thumbFileMd5 : " + HexUtil.bytes2HexStr(this.fG) + " mThumbMd5_local : " + HexUtil.bytes2HexStr(this.ga));
          }
          this.bL = this.fZ;
          this.fG = this.ga;
          sendRequest();
        }
      }
      else
      {
        dN(9042, "onBusiProtoResp=> thumb file not exists");
        onError();
      }
    }
    else
    {
      dN(9302, "onBusiProtoResp=> mThumbFilePath is null");
      onError();
      return;
    }
    Object localObject = this.jdField_b_of_type_Aoko;
    long l = this.yT + this.apR;
    this.mFileSize = l;
    ((aoko)localObject).fileSize = l;
    this.apw = paramo.startOffset;
    this.dPg = 1;
    dVt();
  }
  
  public void a(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, String paramString, long paramLong)
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
            QLog.d("ShortVideoForwardProcessor", 2, "set uuid from BDH ");
          }
        }
      }
      long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
      long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
      long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
      long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - paramLong) + "ms ,fileSize:" + this.jdField_b_of_type_Aoko.fileSize + " transInfo:" + (String)paramHashMap.get("rep_bdhTrans"));
      }
      I(paramHashMap);
      this.jdField_b_of_type_Aojn$a.dVg();
      this.jdField_b_of_type_Aojn$a.result = 1;
      this.bz = this.mFileSize;
      this.cNq = true;
      Rb(false);
      ThreadManager.post(new ShortVideoForwardProcessor.2(this, l2, l3, l4, l5), 5, null, true);
      this.jdField_b_of_type_Aoko.dVw();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      aqhq.deleteFile(paramString);
      f(true, 0, (String)paramHashMap.get("ip"), (String)paramHashMap.get("port"));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoForwardProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
        }
      }
    }
  }
  
  public byte[] a(aoql.a.m paramm)
  {
    PttShortVideo.PttShortVideoUploadReq localPttShortVideoUploadReq = new PttShortVideo.PttShortVideoUploadReq();
    localPttShortVideoUploadReq.setHasFlag(true);
    localPttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localPttShortVideoUploadReq.uint64_touin.set(Long.parseLong(paramm.peerUin));
    localPttShortVideoUploadReq.uint32_chat_type.set(paramm.toChatType);
    localPttShortVideoUploadReq.uint32_client_type.set(paramm.clientType);
    PttShortVideo.PttShortVideoFileInfo localPttShortVideoFileInfo;
    PBStringField localPBStringField;
    if (paramm.troopUin != null)
    {
      localPttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(paramm.troopUin));
      localPttShortVideoUploadReq.uint32_agent_type.set(paramm.dRn);
      localPttShortVideoUploadReq.uint32_business_type.set(paramm.dFn);
      localPttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
      localPttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
      localPBStringField = localPttShortVideoFileInfo.str_file_name;
      if (paramm.fileName != null) {
        break label277;
      }
    }
    label277:
    for (String str = "";; str = paramm.fileName)
    {
      localPBStringField.set(str);
      localPttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(paramm.md5));
      localPttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(paramm.fG));
      localPttShortVideoFileInfo.uint64_file_size.set(paramm.fileSize);
      localPttShortVideoFileInfo.uint32_file_res_length.set(paramm.dRo);
      localPttShortVideoFileInfo.uint32_file_res_width.set(paramm.dRp);
      localPttShortVideoFileInfo.uint32_file_format.set(paramm.format);
      localPttShortVideoFileInfo.uint32_file_time.set(paramm.dFo);
      localPttShortVideoFileInfo.uint64_thumb_file_size.set(paramm.JW);
      localPttShortVideoUploadReq.msg_PttShortVideoFileInfo.set(localPttShortVideoFileInfo);
      return localPttShortVideoUploadReq.toByteArray();
      localPttShortVideoUploadReq.uint64_group_code.set(0L);
      break;
    }
  }
  
  /* Error */
  public boolean aAk()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: new 1210	android/media/MediaPlayer
    //   7: dup
    //   8: invokespecial 1211	android/media/MediaPlayer:<init>	()V
    //   11: astore 5
    //   13: new 1213	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: getfield 76	aonn:h	Laool;
    //   21: getfield 91	aool:dQ	Ljava/lang/String;
    //   24: invokespecial 1214	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: astore 4
    //   29: aload 5
    //   31: aload 4
    //   33: invokevirtual 1218	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   36: invokevirtual 1222	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   39: aload 5
    //   41: invokevirtual 1225	android/media/MediaPlayer:prepare	()V
    //   44: aload 5
    //   46: ifnull +8 -> 54
    //   49: aload 5
    //   51: invokevirtual 1228	android/media/MediaPlayer:release	()V
    //   54: iload_2
    //   55: istore_1
    //   56: aload 4
    //   58: ifnull +10 -> 68
    //   61: aload 4
    //   63: invokevirtual 1231	java/io/FileInputStream:close	()V
    //   66: iload_2
    //   67: istore_1
    //   68: iload_1
    //   69: ireturn
    //   70: astore 4
    //   72: aconst_null
    //   73: astore 4
    //   75: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +12 -> 90
    //   81: ldc 107
    //   83: iconst_2
    //   84: ldc_w 1233
    //   87: invokestatic 971	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_1
    //   91: istore_1
    //   92: aload_3
    //   93: ifnull +7 -> 100
    //   96: aload_3
    //   97: invokevirtual 1228	android/media/MediaPlayer:release	()V
    //   100: aload 4
    //   102: ifnull -34 -> 68
    //   105: aload 4
    //   107: invokevirtual 1231	java/io/FileInputStream:close	()V
    //   110: iconst_1
    //   111: ireturn
    //   112: astore_3
    //   113: iconst_1
    //   114: ireturn
    //   115: astore_3
    //   116: aconst_null
    //   117: astore 4
    //   119: aconst_null
    //   120: astore 5
    //   122: aload 5
    //   124: ifnull +8 -> 132
    //   127: aload 5
    //   129: invokevirtual 1228	android/media/MediaPlayer:release	()V
    //   132: aload 4
    //   134: ifnull +8 -> 142
    //   137: aload 4
    //   139: invokevirtual 1231	java/io/FileInputStream:close	()V
    //   142: aload_3
    //   143: athrow
    //   144: astore 4
    //   146: goto -4 -> 142
    //   149: astore_3
    //   150: aconst_null
    //   151: astore 4
    //   153: goto -31 -> 122
    //   156: astore_3
    //   157: goto -35 -> 122
    //   160: astore 6
    //   162: aload_3
    //   163: astore 5
    //   165: aload 6
    //   167: astore_3
    //   168: goto -46 -> 122
    //   171: astore_3
    //   172: aconst_null
    //   173: astore 4
    //   175: aload 5
    //   177: astore_3
    //   178: goto -103 -> 75
    //   181: astore_3
    //   182: aload 5
    //   184: astore_3
    //   185: goto -110 -> 75
    //   188: astore_3
    //   189: iconst_0
    //   190: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	aonn
    //   55	37	1	bool1	boolean
    //   3	64	2	bool2	boolean
    //   1	96	3	localObject1	Object
    //   112	1	3	localException1	Exception
    //   115	28	3	localObject2	Object
    //   149	1	3	localObject3	Object
    //   156	7	3	localObject4	Object
    //   167	1	3	localObject5	Object
    //   171	1	3	localException2	Exception
    //   177	1	3	localObject6	Object
    //   181	1	3	localException3	Exception
    //   184	1	3	localObject7	Object
    //   188	1	3	localException4	Exception
    //   27	35	4	localFileInputStream	java.io.FileInputStream
    //   70	1	4	localException5	Exception
    //   73	65	4	localObject8	Object
    //   144	1	4	localException6	Exception
    //   151	23	4	localObject9	Object
    //   11	172	5	localObject10	Object
    //   160	6	6	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   4	13	70	java/lang/Exception
    //   96	100	112	java/lang/Exception
    //   105	110	112	java/lang/Exception
    //   4	13	115	finally
    //   127	132	144	java/lang/Exception
    //   137	142	144	java/lang/Exception
    //   13	29	149	finally
    //   29	44	156	finally
    //   75	90	160	finally
    //   13	29	171	java/lang/Exception
    //   29	44	181	java/lang/Exception
    //   49	54	188	java/lang/Exception
    //   61	66	188	java/lang/Exception
  }
  
  public boolean aAl()
  {
    if ((this.h.dQ != null) && (this.h.dQ.length() > 0))
    {
      if ((this.fZ == null) || (this.fZ.length == 0)) {
        this.fZ = HexUtil.hexStr2Bytes(aqhq.px(this.h.dQ));
      }
      File localFile = new File(this.h.dQ);
      if ((localFile.exists()) && (localFile.length() > 0L))
      {
        this.yT = localFile.length();
        this.cmg = localFile.getName();
        return true;
      }
      dN(9042, "onBusiProtoResp=> video file not exists");
      onError();
      return false;
    }
    dN(9302, "onBusiProtoResp=> video file path null");
    onError();
    return false;
  }
  
  public void dVG()
  {
    if (this.mIsCancel) {
      return;
    }
    if (this.mResid != null)
    {
      if (this.bz >= this.mFileSize)
      {
        Rb(false);
        return;
      }
      if ((this.dPg == 1) && (this.mTrans != null))
      {
        this.app.getHwEngine().resumeTransactionTask(this.mTrans);
        return;
      }
      start();
      return;
    }
    start();
  }
  
  public void dVt()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
    }
    this.jdField_b_of_type_Aojn$a.dVf();
    if (this.mTrans != null) {
      return;
    }
    if (this.mRaf == null) {
      try
      {
        this.mRaf = new RandomAccessFile(this.h.dQ, "r");
        if (this.mRaf == null)
        {
          dN(9303, "read video file error");
          onError();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          localFileNotFoundException1.printStackTrace();
          this.mRaf = null;
        }
      }
    }
    if (this.i == null) {
      try
      {
        this.i = new RandomAccessFile(this.mThumbFilePath, "r");
        if (this.i == null)
        {
          dN(9303, "read thumb file error");
          onError();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        for (;;)
        {
          localFileNotFoundException2.printStackTrace();
          this.i = null;
        }
      }
    }
    long l = SystemClock.uptimeMillis();
    Object localObject = AI();
    aoql.a.m localm = a();
    if (localm == null)
    {
      dN(9302, "makeShortVideoForwardReq failed");
      onError();
      return;
    }
    byte[] arrayOfByte = a(localm);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> sendFileByBDH . ,shortVideoReq.md5 :" + HexUtil.bytes2HexStr(localm.md5) + ",shortVideoReq.thumbFileMd5 = " + HexUtil.bytes2HexStr(localm.fG) + ",mLocalMd5 = " + HexUtil.bytes2HexStr(this.bL));
    }
    aono localaono = new aono(this, (String)localObject, l);
    if (localm.dFm == 0) {}
    for (int i = 25;; i = 12)
    {
      this.mTrans = new Transaction(this.app.getCurrentAccountUin(), i, (String)localObject, (int)this.apw, this.bL, localaono, arrayOfByte, true);
      localObject = new aonp(this);
      this.mTrans.cbForReport = ((ITransCallbackForReport)localObject);
      i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.h.mUniseq + " MD5:" + this.clf + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:" + 12);
      }
      if (i == 0) {
        break;
      }
      a(i, "sendFileByBDH SubmitError.", "", this.jdField_b_of_type_Aojn$a);
      onError();
      return;
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
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      str = this.jdField_a_of_type_Aojn$a.fB(1) + ";" + this.jdField_b_of_type_Aojn$a.fB(2) + ";" + this.c.fB(3);
      this.mM.put("param_step", str);
      HashMap localHashMap = this.mM;
      if (this.mResid != null) {
        break label498;
      }
      str = this.mUuid;
      label176:
      localHashMap.put("param_uuid", str);
      this.mM.put("param_toUin", this.h.mPeerUin);
      this.mM.put("param_grpUin", this.h.mPeerUin);
      if (this.xp.size() > 0) {
        this.mM.put("param_iplist", this.xp.toString());
      }
      this.mM.put("param_picSize", String.valueOf(this.mFileSize));
      this.mM.put("param_busiType", this.dQq + "");
      this.mM.put("param_fileMd5", HexUtil.bytes2HexStr(this.bL));
      this.mM.put("param_thumbSize", String.valueOf(this.apR));
      this.mM.put("param_videoDuration", String.valueOf(this.dQp));
      this.mM.put("param_isSecondTrans", this.cNp + "");
      if (!paramBoolean) {
        break label507;
      }
      P(true, l);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), true, l, this.mFileSize, this.mM, "");
    }
    for (;;)
    {
      dVc();
      Log.i("AutoMonitor", "ShortVideoForward, cost=" + (this.jdField_b_of_type_Aojn$a.finishTime - this.jdField_b_of_type_Aojn$a.startTime) / 1000000L + ", getReportTAG = " + AJ());
      return;
      i = 1;
      break;
      label498:
      str = this.mResid;
      break label176;
      label507:
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
  
  protected void f(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Aomy.aft = (this.dQq + "");
    this.jdField_a_of_type_Aomy.mMD5 = this.mFileName;
    aomy localaomy = this.jdField_a_of_type_Aomy;
    if (this.mResid == null) {}
    for (String str = this.mUuid;; str = this.mResid)
    {
      localaomy.bRd = str;
      this.jdField_a_of_type_Aomy.mServerIp = paramString1;
      this.jdField_a_of_type_Aomy.clZ = paramString2;
      this.jdField_a_of_type_Aomy.cma = String.valueOf(paramInt);
      this.jdField_a_of_type_Aomy.mFileSize = this.mFileSize;
      cZ("actRichMediaNetMonitor_videoUp", paramBoolean);
      return;
    }
  }
  
  void onError()
  {
    super.onError();
    if (-5100026 == this.errCode) {
      VR(5001);
    }
    for (;;)
    {
      if (this.h.b != null)
      {
        akyf.a locala = new akyf.a();
        locala.result = -1;
        locala.errCode = this.errCode;
        locala.errStr = this.errDesc;
        this.h.b.b(locala);
      }
      return;
      if (9042 == this.errCode) {
        VR(5002);
      } else {
        VR(1005);
      }
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
      locala.size = this.yT;
      locala.md5 = this.clf;
      if (this.mResid == null)
      {
        str = this.mUuid;
        locala.uuid = str;
        locala.JW = this.apR;
        locala.videoAttr = this.dQs;
        locala.videoKandianType = this.dQt;
        this.h.b.b(locala);
      }
    }
    for (;;)
    {
      VR(1003);
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
      QLog.d("ShortVideoForwardProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + this.h.mUniseq);
    }
    aoql.a.m localm = a();
    if (localm == null) {}
    do
    {
      return;
      locala.b = this;
      locala.cmy = "short_video_fw";
      locala.He.add(localm);
      locala.a = this.app.getProtoReqManager();
      if (!azQ())
      {
        a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
        onError();
        return;
      }
      hM("requestStart", locala.toString());
    } while (!azR());
    this.jdField_a_of_type_Aoql$a = locala;
    aoqm.c(locala);
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 136	aonn:mIsCancel	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +12 -> 23
    //   14: ldc 107
    //   16: iconst_2
    //   17: ldc_w 1528
    //   20: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: invokespecial 1529	aojl:start	()V
    //   27: aload_0
    //   28: sipush 1001
    //   31: invokevirtual 628	aonn:VR	(I)V
    //   34: aload_0
    //   35: getfield 572	aonn:jdField_b_of_type_Aoko	Laoko;
    //   38: invokevirtual 1116	aoko:dVw	()V
    //   41: aload_0
    //   42: getfield 76	aonn:h	Laool;
    //   45: getfield 982	aool:mMd5	Ljava/lang/String;
    //   48: invokestatic 1535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifne +40 -> 91
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 76	aonn:h	Laool;
    //   59: getfield 982	aool:mMd5	Ljava/lang/String;
    //   62: invokestatic 159	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   65: putfield 303	aonn:bL	[B
    //   68: aload_0
    //   69: getfield 572	aonn:jdField_b_of_type_Aoko	Laoko;
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 76	aonn:h	Laool;
    //   77: getfield 982	aool:mMd5	Ljava/lang/String;
    //   80: astore_2
    //   81: aload_1
    //   82: aload_2
    //   83: putfield 1538	aoko:fileMd5	Ljava/lang/String;
    //   86: aload_0
    //   87: aload_2
    //   88: putfield 701	aonn:clf	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 76	aonn:h	Laool;
    //   95: getfield 204	aool:en	Ljava/lang/Object;
    //   98: ifnull +105 -> 203
    //   101: aload_0
    //   102: getfield 76	aonn:h	Laool;
    //   105: getfield 204	aool:en	Ljava/lang/Object;
    //   108: instanceof 206
    //   111: ifeq +92 -> 203
    //   114: aload_0
    //   115: getfield 76	aonn:h	Laool;
    //   118: getfield 204	aool:en	Ljava/lang/Object;
    //   121: checkcast 206	anfw
    //   124: astore_1
    //   125: aload_0
    //   126: aload_1
    //   127: getfield 1540	anfw:fileSize	I
    //   130: i2l
    //   131: putfield 284	aonn:yT	J
    //   134: aload_0
    //   135: aload_1
    //   136: getfield 1543	anfw:thumbFileSize	I
    //   139: i2l
    //   140: putfield 289	aonn:apR	J
    //   143: aload_0
    //   144: aload_1
    //   145: getfield 1546	anfw:thumbWidth	I
    //   148: putfield 268	aonn:dPA	I
    //   151: aload_0
    //   152: aload_1
    //   153: getfield 1549	anfw:thumbHeight	I
    //   156: putfield 264	aonn:dPz	I
    //   159: aload_0
    //   160: aload_1
    //   161: getfield 1552	anfw:cFp	Z
    //   164: putfield 443	aonn:cNo	Z
    //   167: aload_0
    //   168: getfield 303	aonn:bL	[B
    //   171: ifnull +20 -> 191
    //   174: aload_0
    //   175: getfield 303	aonn:bL	[B
    //   178: arraylength
    //   179: ifeq +12 -> 191
    //   182: aload_0
    //   183: getfield 284	aonn:yT	J
    //   186: lconst_0
    //   187: lcmp
    //   188: ifgt +79 -> 267
    //   191: aload_0
    //   192: invokevirtual 1555	aonn:azT	()Z
    //   195: ifne +33 -> 228
    //   198: aload_0
    //   199: invokevirtual 133	aonn:onError	()V
    //   202: return
    //   203: aload_0
    //   204: ldc_w 1556
    //   207: ldc_w 311
    //   210: invokevirtual 315	aonn:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: sipush 9302
    //   217: ldc_w 1558
    //   220: invokevirtual 130	aonn:dN	(ILjava/lang/String;)V
    //   223: aload_0
    //   224: invokevirtual 133	aonn:onError	()V
    //   227: return
    //   228: aload_0
    //   229: aload_0
    //   230: getfield 303	aonn:bL	[B
    //   233: putfield 1040	aonn:fZ	[B
    //   236: new 1029	java/io/File
    //   239: dup
    //   240: aload_0
    //   241: getfield 76	aonn:h	Laool;
    //   244: getfield 91	aool:dQ	Ljava/lang/String;
    //   247: invokespecial 1031	java/io/File:<init>	(Ljava/lang/String;)V
    //   250: astore_1
    //   251: aload_0
    //   252: aload_1
    //   253: invokevirtual 1036	java/io/File:length	()J
    //   256: putfield 284	aonn:yT	J
    //   259: aload_0
    //   260: aload_1
    //   261: invokevirtual 1236	java/io/File:getName	()Ljava/lang/String;
    //   264: putfield 278	aonn:cmg	Ljava/lang/String;
    //   267: aload_0
    //   268: getfield 162	aonn:fG	[B
    //   271: ifnull +34 -> 305
    //   274: aload_0
    //   275: getfield 162	aonn:fG	[B
    //   278: arraylength
    //   279: ifeq +26 -> 305
    //   282: aload_0
    //   283: getfield 289	aonn:apR	J
    //   286: lconst_0
    //   287: lcmp
    //   288: ifle +17 -> 305
    //   291: aload_0
    //   292: getfield 268	aonn:dPA	I
    //   295: ifle +10 -> 305
    //   298: aload_0
    //   299: getfield 264	aonn:dPz	I
    //   302: ifgt +132 -> 434
    //   305: new 1213	java/io/FileInputStream
    //   308: dup
    //   309: aload_0
    //   310: getfield 145	aonn:mThumbFilePath	Ljava/lang/String;
    //   313: invokespecial 1214	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   316: astore_2
    //   317: aload_2
    //   318: astore_1
    //   319: aload_0
    //   320: aload_2
    //   321: lconst_0
    //   322: invokestatic 1564	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   325: putfield 162	aonn:fG	[B
    //   328: aload_2
    //   329: astore_1
    //   330: aload_0
    //   331: getfield 162	aonn:fG	[B
    //   334: ifnonnull +56 -> 390
    //   337: aload_2
    //   338: astore_1
    //   339: aload_0
    //   340: sipush 9041
    //   343: new 109	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   350: ldc_w 1566
    //   353: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_0
    //   357: getfield 145	aonn:mThumbFilePath	Ljava/lang/String;
    //   360: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokevirtual 130	aonn:dN	(ILjava/lang/String;)V
    //   369: aload_2
    //   370: astore_1
    //   371: aload_0
    //   372: invokevirtual 133	aonn:onError	()V
    //   375: aload_2
    //   376: ifnull -369 -> 7
    //   379: aload_2
    //   380: invokevirtual 1231	java/io/FileInputStream:close	()V
    //   383: return
    //   384: astore_1
    //   385: aload_1
    //   386: invokevirtual 1567	java/io/IOException:printStackTrace	()V
    //   389: return
    //   390: aload_2
    //   391: astore_1
    //   392: aload_0
    //   393: aload_0
    //   394: getfield 162	aonn:fG	[B
    //   397: putfield 1021	aonn:ga	[B
    //   400: aload_2
    //   401: ifnull +7 -> 408
    //   404: aload_2
    //   405: invokevirtual 1231	java/io/FileInputStream:close	()V
    //   408: aload_0
    //   409: new 1029	java/io/File
    //   412: dup
    //   413: aload_0
    //   414: getfield 145	aonn:mThumbFilePath	Ljava/lang/String;
    //   417: invokespecial 1031	java/io/File:<init>	(Ljava/lang/String;)V
    //   420: invokevirtual 1036	java/io/File:length	()J
    //   423: putfield 289	aonn:apR	J
    //   426: aload_0
    //   427: aload_0
    //   428: getfield 145	aonn:mThumbFilePath	Ljava/lang/String;
    //   431: invokevirtual 1038	aonn:Sc	(Ljava/lang/String;)V
    //   434: aload_0
    //   435: invokevirtual 1058	aonn:sendRequest	()V
    //   438: return
    //   439: astore_1
    //   440: aload_1
    //   441: invokevirtual 1567	java/io/IOException:printStackTrace	()V
    //   444: goto -36 -> 408
    //   447: astore_3
    //   448: aconst_null
    //   449: astore_2
    //   450: aload_2
    //   451: astore_1
    //   452: aload_0
    //   453: aconst_null
    //   454: putfield 162	aonn:fG	[B
    //   457: aload_2
    //   458: astore_1
    //   459: aload_0
    //   460: aload_3
    //   461: invokevirtual 1570	aonn:a	(Ljava/io/IOException;)V
    //   464: aload_2
    //   465: astore_1
    //   466: aload_0
    //   467: invokevirtual 133	aonn:onError	()V
    //   470: aload_2
    //   471: ifnull -464 -> 7
    //   474: aload_2
    //   475: invokevirtual 1231	java/io/FileInputStream:close	()V
    //   478: return
    //   479: astore_1
    //   480: aload_1
    //   481: invokevirtual 1567	java/io/IOException:printStackTrace	()V
    //   484: return
    //   485: astore_2
    //   486: aconst_null
    //   487: astore_1
    //   488: aload_1
    //   489: ifnull +7 -> 496
    //   492: aload_1
    //   493: invokevirtual 1231	java/io/FileInputStream:close	()V
    //   496: aload_2
    //   497: athrow
    //   498: astore_1
    //   499: aload_1
    //   500: invokevirtual 1567	java/io/IOException:printStackTrace	()V
    //   503: goto -7 -> 496
    //   506: astore_2
    //   507: goto -19 -> 488
    //   510: astore_3
    //   511: goto -61 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	aonn
    //   72	299	1	localObject1	Object
    //   384	2	1	localIOException1	java.io.IOException
    //   391	1	1	localObject2	Object
    //   439	2	1	localIOException2	java.io.IOException
    //   451	15	1	localObject3	Object
    //   479	2	1	localIOException3	java.io.IOException
    //   487	6	1	localObject4	Object
    //   498	2	1	localIOException4	java.io.IOException
    //   80	395	2	localObject5	Object
    //   485	12	2	localObject6	Object
    //   506	1	2	localObject7	Object
    //   447	14	3	localIOException5	java.io.IOException
    //   510	1	3	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   379	383	384	java/io/IOException
    //   404	408	439	java/io/IOException
    //   305	317	447	java/io/IOException
    //   474	478	479	java/io/IOException
    //   305	317	485	finally
    //   492	496	498	java/io/IOException
    //   319	328	506	finally
    //   330	337	506	finally
    //   339	369	506	finally
    //   371	375	506	finally
    //   392	400	506	finally
    //   452	457	506	finally
    //   459	464	506	finally
    //   466	470	506	finally
    //   319	328	510	java/io/IOException
    //   330	337	510	java/io/IOException
    //   339	369	510	java/io/IOException
    //   371	375	510	java/io/IOException
    //   392	400	510	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aonn
 * JD-Core Version:    0.7.0.1
 */