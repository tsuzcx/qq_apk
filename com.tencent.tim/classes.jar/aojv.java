import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.LoginSigHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.NewServiceTicket;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.PicInfoExt;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.PicRspExtInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor.1;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor.2;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor.5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.ProxyIpManager;
import mqq.manager.TicketManager;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class aojv
  extends aojk
{
  protected CSDataHighwayHead.LoginSigHead a;
  public QQAppInterface app;
  protected aooi c;
  private MessageForPic c;
  protected boolean cMl;
  public boolean cMm;
  private int dPl;
  private byte[] de;
  achq jdField_e_of_type_Achq = new aojy(this);
  private aojn.a jdField_e_of_type_Aojn$a = new aojn.a();
  private aojn.a f = new aojn.a();
  private byte[] fH;
  protected byte[] fI;
  protected byte[] fJ;
  private boolean isStoryPhoto;
  
  public aojv(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    this.jdField_c_of_type_Aooi = paramaooi;
    this.app = ((QQAppInterface)this.app);
    this.jdField_b_of_type_Aoko.fileType = this.h.mFileType;
    this.jdField_b_of_type_Aoko.uniseq = this.h.mUniseq;
    this.jdField_b_of_type_Aoko.actionType = 0;
    this.jdField_b_of_type_Aoko.friendUin = this.h.mPeerUin;
    this.jdField_b_of_type_Aoko.uinType = 0;
    this.jdField_b_of_type_Aoko.cMv = true;
    this.Ha = ((ProxyIpManager)this.app.getManager(3)).getProxyIp(3);
    this.cMl = OpenUpConfig.isOpenUpEnable;
    this.dPl = OpenUpConfig.getPreSendDots(BaseApplication.getContext());
    if ((this.h.F != null) && ((this.h.F instanceof MessageForPic)))
    {
      this.isStoryPhoto = ((MessageForPic)this.h.F).isStoryPhoto;
      if (this.isStoryPhoto) {
        this.jdField_c_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)this.h.F);
      }
    }
  }
  
  private im_msg_body.RichText a()
  {
    label778:
    label798:
    label806:
    label820:
    for (int i = 1;; i = 0)
    {
      im_msg_body.RichText localRichText;
      for (;;)
      {
        Object localObject3;
        try
        {
          localRichText = new im_msg_body.RichText();
          localObject3 = new im_msg_body.NotOnlineImage();
          dUV();
          ((im_msg_body.NotOnlineImage)localObject3).file_path.set(ByteStringMicro.copyFromUtf8(this.mFileName));
          if (this.jdField_b_of_type_Aoko.cls != null) {
            ((im_msg_body.NotOnlineImage)localObject3).download_path.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_Aoko.cls));
          }
          if (this.jdField_b_of_type_Aoko.serverPath != null) {
            ((im_msg_body.NotOnlineImage)localObject3).res_id.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_Aoko.serverPath));
          }
          ((im_msg_body.NotOnlineImage)localObject3).file_len.set((int)this.mFileSize);
          ((im_msg_body.NotOnlineImage)localObject3).pic_md5.set(ByteStringMicro.copyFrom(this.bL));
          ((im_msg_body.NotOnlineImage)localObject3).pic_height.set(this.mHeight);
          ((im_msg_body.NotOnlineImage)localObject3).pic_width.set(this.mWidth);
          Object localObject1 = ((im_msg_body.NotOnlineImage)localObject3).original;
          if (!this.cLX) {
            break label820;
          }
          ((PBUInt32Field)localObject1).set(i);
          Object localObject4 = this.h.F;
          Object localObject5;
          if (MessageForPic.class.isInstance(localObject4))
          {
            localObject5 = (MessageForPic)localObject4;
            ((im_msg_body.NotOnlineImage)localObject3).uint32_show_len.set(((MessageForPic)localObject5).mShowLength);
            ((im_msg_body.NotOnlineImage)localObject3).uint32_download_len.set(((MessageForPic)localObject5).mDownloadLength);
            ((im_msg_body.NotOnlineImage)localObject3).img_type.set(((MessageForPic)localObject5).imageType);
            if (((MessageForPic)localObject5).picExtraData != null)
            {
              localObject1 = ((MessageForPic)localObject5).picExtraData.getOfflineImageResvAttr();
              ((NotOnlineImageExtPb.ResvAttr)localObject1).uint32_source.set(c((MessageForPic)localObject5));
              ((im_msg_body.NotOnlineImage)localObject3).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject1).get()).toByteArray()), true);
            }
          }
          else
          {
            ((im_msg_body.NotOnlineImage)localObject3).biz_type.set(KJ());
            if (QLog.isColorLevel()) {
              hM("busiTypeStat", "uiBusiType:" + this.h.mBusiType + " protoBusiType:" + ((im_msg_body.NotOnlineImage)localObject3).biz_type.get());
            }
            localObject1 = new im_msg_body.Elem();
            if (!acei.W((MessageRecord)localObject4)) {
              break label778;
            }
            localObject4 = new im_msg_body.CommonElem();
            ((im_msg_body.CommonElem)localObject4).uint32_service_type.set(3);
            localObject5 = new hummer_commelem.MsgElemInfo_servtype3();
            ((hummer_commelem.MsgElemInfo_servtype3)localObject5).flash_c2c_pic.set((MessageMicro)localObject3);
            ((im_msg_body.CommonElem)localObject4).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype3)localObject5).toByteArray()));
            ((im_msg_body.Elem)localObject1).common_elem.set((MessageMicro)localObject4);
            localRichText.elems.add((MessageMicro)localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("flash", 2, "C2CPicUploadProcessor constructPicRichText send flash");
            }
            localObject1 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8(acfp.m(2131703345)));
            localObject3 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject3).text.set((MessageMicro)localObject1);
            localRichText.elems.add((MessageMicro)localObject3);
            localObject5 = this.app.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
            if (!(localObject5 instanceof MessageForStructing)) {
              break;
            }
            localObject3 = (MessageForStructing)localObject5;
            if ((((MessageForStructing)localObject3).structingMsg == null) || (!(((MessageForStructing)localObject3).structingMsg instanceof StructMsgForImageShare))) {
              break;
            }
            StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)((MessageForStructing)localObject3).structingMsg;
            localObject4 = localStructMsgForImageShare.getFirstImageElement();
            if (localObject4 == null) {
              break;
            }
            ((ansu)localObject4).mMd5 = this.clf;
            if (this.mResid != null) {
              break label798;
            }
            localObject1 = this.mUuid;
            ((ansu)localObject4).mUuid = ((String)localObject1);
            ((ansu)localObject4).filesize = this.mFileSize;
            ((ansu)localObject4).time = ((MessageRecord)localObject5).time;
            if (!xtj.hR(localStructMsgForImageShare.mMsgActionData)) {
              break label806;
            }
            localObject5 = ((ansu)localObject4).cij;
            ((ansu)localObject4).cij = "";
            localObject1 = ((MessageForStructing)localObject3).structingMsg.getXmlBytes();
            ((ansu)localObject4).cij = ((String)localObject5);
            if ((TextUtils.isEmpty(((MessageForStructing)localObject3).frienduin)) || (localObject1 == null)) {
              break;
            }
            localObject3 = new im_msg_body.RichMsg();
            ((im_msg_body.RichMsg)localObject3).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).rich_msg.set((MessageMicro)localObject3);
            localRichText.elems.add((MessageMicro)localObject1);
            break;
          }
          localObject1 = new NotOnlineImageExtPb.ResvAttr();
          continue;
          localException.not_online_image.set((MessageMicro)localObject3);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("C2CPicUploadProcessor", 2, "Construct richtext error", localException);
          }
          localException.printStackTrace();
          return null;
        }
        localRichText.elems.add(localException);
        continue;
        Object localObject2 = this.mResid;
        continue;
        localObject2 = ((MessageForStructing)localObject3).structingMsg.getXmlBytes();
      }
      return localRichText;
    }
  }
  
  private void bA(byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return;
      Object localObject = new CSDataHighwayHead.PicRspExtInfo();
      try
      {
        ((CSDataHighwayHead.PicRspExtInfo)localObject).mergeFrom(paramArrayOfByte);
        if (((CSDataHighwayHead.PicRspExtInfo)localObject).bytes_skey.has())
        {
          paramArrayOfByte = ((CSDataHighwayHead.PicRspExtInfo)localObject).bytes_skey.get().toByteArray();
          localObject = new byte[paramArrayOfByte.length];
          System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramArrayOfByte.length);
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> byte_skey.length:" + paramArrayOfByte.length);
          }
          Cryptor localCryptor = new Cryptor();
          if (this.fH != null)
          {
            localObject = localCryptor.decrypt((byte[])localObject, 0, paramArrayOfByte.length, this.fH);
            if ((localObject != null) && (localObject.length > 36))
            {
              if (QLog.isColorLevel()) {
                QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> result.length:" + localObject.length);
              }
              paramArrayOfByte = new byte[localObject.length];
              System.arraycopy(localObject, 0, paramArrayOfByte, 0, localObject.length);
              int j = ByteBuffer.wrap(paramArrayOfByte).getShort(34);
              localObject = new char[j];
              while (i < j)
              {
                localObject[i] = ((char)paramArrayOfByte[(i + 36)]);
                i += 1;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, paramArrayOfByte.getMessage());
          }
        }
        paramArrayOfByte = String.valueOf((char[])localObject);
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> fileIdStr:" + paramArrayOfByte);
        }
        this.jdField_b_of_type_Aoko.serverPath = paramArrayOfByte;
        this.mResid = paramArrayOfByte;
        this.jdField_b_of_type_Aoko.cls = paramArrayOfByte;
        this.mUuid = paramArrayOfByte;
      }
    }
  }
  
  private void dVm()
  {
    this.jdField_c_of_type_Aooi.a.post(new C2CPicUploadProcessor.2(this));
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
      return "actC2CPicUploadV2";
    }
    return "actC2CPicUploadV1";
  }
  
  public int EN()
  {
    if (this.mIsPause)
    {
      this.mIsPause = false;
      this.mIsCancel = false;
      VR(1002);
      this.dPd = 0;
      this.QV = 0;
      if (this.dPg != 1)
      {
        this.mResid = null;
        this.mUuid = null;
        this.bz = 0L;
      }
      this.mUkey = null;
      this.dOO = 0;
      this.errCode = 0;
      this.errDesc = "";
      this.jdField_b_of_type_Auyc.initParam();
      dVp();
      this.jdField_c_of_type_Aooi.a.post(new C2CPicUploadProcessor.5(this));
    }
    return 0;
  }
  
  public int KH()
  {
    Object localObject = a();
    if ((localObject != null) && (((aool)localObject).cNC))
    {
      if ((this.h.en != null) && ((this.h.en instanceof aool.d))) {
        this.cLX = ((aool.d)this.h.en).cNJ;
      }
      return 0;
    }
    hM("uiParam", this.h.toString());
    localObject = this.h.dQ;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      dN(9302, f(new Exception("filePath null")));
      onError();
      return -1;
    }
    File localFile = new File((String)localObject);
    if (!localFile.exists())
    {
      dN(9042, f(new Exception("sendFile not exist " + (String)localObject)));
      onError();
      return -1;
    }
    if (!localFile.canRead())
    {
      dN(9070, f(new Exception("sendFile not readable " + this.jdField_b_of_type_Aoko.filePath)));
      onError();
      return -1;
    }
    long l = localFile.length();
    this.jdField_b_of_type_Aoko.fileSize = l;
    this.mFileSize = l;
    if (l <= 0L)
    {
      dN(9071, f(new Exception("file size 0 " + (String)localObject)));
      onError();
      return -1;
    }
    localObject = aqhq.estimateFileType((String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((((String)localObject).contains(aqhq.unKnownFileTypeMark)) || (!aqhq.rs((String)localObject)))
      {
        a(9072, (String)localObject, or((String)localObject), null);
        onError();
        new Handler(Looper.getMainLooper()).post(new C2CPicUploadProcessor.1(this));
        return -1;
      }
      this.clg = ((String)localObject);
    }
    if (l >= aopb.hm())
    {
      a(9063, (String)localObject, or((String)localObject), null);
      onError();
      return -1;
    }
    if ((this.h.en != null) && ((this.h.en instanceof aool.d))) {
      this.cLX = ((aool.d)this.h.en).cNJ;
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
    Object localObject;
    ansu localansu;
    do
    {
      do
      {
        do
        {
          return;
          localMessageRecord = this.app.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
          hM("updateDb", "findmsgbyMsgId,need fix");
          break;
          if (localMessageRecord.isMultiMsg)
          {
            hM("updateDb", "is multiMsg");
            return;
          }
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).size = this.mFileSize;
            if (this.mResid == null) {}
            for (str = this.mUuid;; str = this.mResid)
            {
              ((MessageForPic)localObject).uuid = str;
              ((MessageForPic)localObject).serial();
              this.app.b().c(this.h.mPeerUin, this.h.mUinType, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
              return;
            }
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localansu = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localansu == null);
    localansu.mMd5 = this.clf;
    if (this.mResid == null) {}
    for (String str = this.mUuid;; str = this.mResid)
    {
      localansu.mUuid = str;
      localansu.filesize = this.mFileSize;
      localansu.time = localMessageRecord.time;
      ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
      this.app.b().c(this.h.mPeerUin, this.h.mUinType, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
      return;
    }
  }
  
  protected void VR(int paramInt)
  {
    super.VR(paramInt);
    if (this.isStoryPhoto) {
      axyl.d(this.jdField_c_of_type_ComTencentMobileqqDataMessageForPic, paramInt, getProgress());
    }
  }
  
  protected CSDataHighwayHead.LoginSigHead a()
  {
    CSDataHighwayHead.LoginSigHead localLoginSigHead = new CSDataHighwayHead.LoginSigHead();
    Object localObject1 = (TicketManager)this.app.getManager(2);
    if ((localObject1 != null) && (!TextUtils.isEmpty(this.app.getAccount())))
    {
      localObject1 = ((TicketManager)localObject1).getA2(this.app.getAccount());
      if (localObject1 == null) {
        break label103;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((String)localObject1).getBytes("utf-8");
        if ((localObject1 == null) || (localObject1.length == 0)) {
          return null;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return null;
      }
      localLoginSigHead.bytes_loginsig.set(ByteStringMicro.copyFrom(localUnsupportedEncodingException));
      localLoginSigHead.uint32_loginsig_type.set(8);
      return localLoginSigHead;
      label103:
      Object localObject2 = null;
    }
  }
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    super.a(parama, paramb);
    b(parama, paramb);
  }
  
  protected byte[] au()
  {
    this.fH = SessionInfo.getInstance(this.h.mSelfUin).getSessionKey();
    if ((this.fH == null) || (this.fH.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("C2CPicUploadProcessor", 2, "<BDH_LOG> sessionKey is null ");
      }
    }
    byte[] arrayOfByte;
    do
    {
      long l1;
      long l2;
      int i;
      int j;
      for (;;)
      {
        return null;
        this.de = SessionInfo.getInstance(this.h.mSelfUin).getHttpconn_sig_session();
        if ((this.de == null) || (this.de.length == 0))
        {
          if (QLog.isColorLevel())
          {
            QLog.e("C2CPicUploadProcessor", 2, "<BDH_LOG> signature is null ");
            return null;
          }
        }
        else {
          try
          {
            l1 = Long.valueOf(this.h.mSelfUin).longValue();
            localObject2 = this.h.mPeerUin;
            Object localObject1 = localObject2;
            if (((String)localObject2).startsWith("+")) {
              localObject1 = ((String)localObject2).substring(1);
            }
            l2 = Long.valueOf((String)localObject1).longValue();
            i = (int)this.mFileSize;
            j = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = this.bL;
            if ((localObject1 == null) || (localObject1.length == 0))
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("C2CPicUploadProcessor", 2, "md5 is null ");
              return null;
            }
          }
          catch (Exception localException)
          {
            QLog.e("C2CPicUploadProcessor", 2, "makeOpenUpTicket error", localException);
            return null;
          }
        }
      }
      localObject2 = ByteBuffer.allocate(localException.length + 56 + 8);
      ((ByteBuffer)localObject2).putInt(0, 1).putLong(4, l1).putLong(12, l2).putInt(20, i).putInt(24, j);
      localObject2 = ((ByteBuffer)localObject2).array();
      System.arraycopy(localException, 0, localObject2, 28, localException.length);
      arrayOfByte = new Cryptor().encrypt((byte[])localObject2, this.fH);
      if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("C2CPicUploadProcessor", 2, "ukey is null ");
    return null;
    Object localObject2 = new CSDataHighwayHead.NewServiceTicket();
    ((CSDataHighwayHead.NewServiceTicket)localObject2).bytes_ukey.set(ByteStringMicro.copyFrom(arrayOfByte));
    ((CSDataHighwayHead.NewServiceTicket)localObject2).bytes_signature.set(ByteStringMicro.copyFrom(this.de));
    return ((CSDataHighwayHead.NewServiceTicket)localObject2).toByteArray();
  }
  
  protected byte[] av()
  {
    int j = 6;
    int k = 3;
    CSDataHighwayHead.PicInfoExt localPicInfoExt = new CSDataHighwayHead.PicInfoExt();
    localPicInfoExt.uint32_busi_type.set(1);
    localPicInfoExt.uint32_src_term.set(5);
    localPicInfoExt.uint32_plat_type.set(9);
    int i = j;
    switch (aomi.a().getNetType())
    {
    default: 
      i = j;
    case 2: 
      Object localObject = aomi.a().getApnType();
      j = i;
      if (localObject != null)
      {
        j = i;
        if (((String)localObject).contains("wap")) {
          j = 5;
        }
      }
      localPicInfoExt.uint32_net_type.set(j);
      localObject = this.h.F;
      if (MessageForPic.class.isInstance(localObject)) {
        localPicInfoExt.uint32_img_type.set(((MessageForPic)localObject).imageType);
      }
      localPicInfoExt.uint32_app_pic_type.set(1);
      localPicInfoExt.uint32_pic_width.set(this.mWidth);
      localPicInfoExt.uint32_pic_height.set(this.mHeight);
      if (!this.cLX) {
        break;
      }
    }
    for (i = k;; i = 1)
    {
      localPicInfoExt.uint32_pic_flag.set(i);
      return localPicInfoExt.toByteArray();
      i = 3;
      break;
      i = 7;
      break;
      i = 8;
      break;
    }
  }
  
  protected void b(aoql.a parama, aoql.b paramb)
  {
    this.jdField_a_of_type_Aoql$a = null;
    aoko localaoko;
    String str;
    if (paramb != null)
    {
      int i = 0;
      if (i < paramb.Hf.size())
      {
        parama = (aoql.b.b)paramb.Hf.get(i);
        if (QLog.isColorLevel()) {
          hM("procUrl", parama.toString());
        }
        this.cLU = parama.cOc;
        a(this.jdField_a_of_type_Aojn$a, parama);
        if (parama.result != 0) {
          break label432;
        }
        QU(parama.isExist);
        if (parama.isExist)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp picUpResp.isExist.");
          }
          this.cMe = true;
          this.jdField_b_of_type_Aoko.transferedSize = this.jdField_b_of_type_Aoko.fileSize;
          localaoko = this.jdField_b_of_type_Aoko;
          str = parama.mResid;
          localaoko.serverPath = str;
          this.mResid = str;
          localaoko = this.jdField_b_of_type_Aoko;
          parama = parama.mUuid;
          localaoko.cls = parama;
          this.mUuid = parama;
          if (this.cMl) {
            if ((!this.mTrans.isFinish.get()) || (!this.mTrans.isSuccess.get()))
            {
              this.mTrans.cancelTransaction();
              dDP();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            dDP();
          }
        }
        VR(1002);
        if (azN()) {
          break label249;
        }
      }
    }
    label249:
    do
    {
      do
      {
        return;
      } while ((this.cMl) && (this.mTrans.isFinish.get()) && (this.mTrans.isSuccess.get()));
      if (!this.cMl)
      {
        localaoko = this.jdField_b_of_type_Aoko;
        str = parama.mResid;
        localaoko.serverPath = str;
        this.mResid = str;
        localaoko = this.jdField_b_of_type_Aoko;
        str = parama.mUuid;
        localaoko.cls = str;
        this.mUuid = str;
      }
      for (;;)
      {
        this.mUkey = parama.mUkey;
        this.apw = parama.startOffset;
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> About to submit Transaction , from onBusiProtoResp.");
        }
        this.dPg = 1;
        if (!this.cMl) {
          break label425;
        }
        if (this.mTrans == null) {
          break;
        }
        this.mTrans.continueTrans();
        this.f.dVf();
        break;
        this.jdField_b_of_type_Aojn$a.startTime = 0L;
        this.jdField_b_of_type_Aojn$a.dVf();
      }
      dVn();
      break;
      log("<BDH_LOG> onBusiProtoResp() error : " + parama.result + " ,select HTTP channel");
      this.dPg = 2;
    } while ((this.cMl) && (this.mTrans.isFinish.get()) && (this.mTrans.isSuccess.get()));
    label425:
    label432:
    if ((this.cMl) && (this.mTrans != null)) {
      this.app.getHwEngine().cancelTransactionTask(this.mTrans);
    }
    onError();
  }
  
  void dDP()
  {
    if (!azR())
    {
      log("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.dPg);
      return;
    }
    Object localObject1 = this.h.F;
    if ((localObject1 != null) && ((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).DSKey != 0L))
    {
      onSuccess();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    if ((!this.cMb) || (this.h.cND))
    {
      if (this.h.cND) {
        ((MessageForPic)this.h.F).mPresendTransferedSize = this.bz;
      }
      localObject1 = a();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_Aojn$a);
        onError();
        return;
      }
      if (this.h.b != null) {
        this.h.b.a((im_msg_body.RichText)localObject1);
      }
      if ((this.h.cND) && (this.cMe)) {
        ((MessageForPic)this.h.F).mPresendTransferedSize = 0L;
      }
      dUW();
      onSuccess();
      return;
    }
    this.jdField_c_of_type_Aojn$a.dVf();
    Object localObject2 = a();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_Aojn$a);
      onError();
      return;
    }
    if (this.h.b != null)
    {
      localObject1 = this.h.b.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label469;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label442;
      }
    }
    label442:
    for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
    {
      a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Aojn$a);
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
    label469:
    if ((localObject1 instanceof MessageForPic))
    {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
      ((MessageForPic)localObject1).size = this.mFileSize;
      if (((MessageForPic)localObject1).isBlessPic)
      {
        ((MessageForPic)localObject1).uuid = this.mResid;
        this.app.a().notifyUI(999, true, ((MessageRecord)localObject1).frienduin);
        return;
      }
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if (!azQ())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_Aojn$a);
      onError();
      return;
    }
    dUW();
    ((ambj)this.app.getManager(326)).b((MessageRecord)localObject1, this.jdField_e_of_type_Achq, this);
  }
  
  public void dVn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction submit:sendFile:" + this.mTrans + "  this:" + this);
    }
    if (this.cMl) {
      this.jdField_e_of_type_Aojn$a.dVf();
    }
    while (this.mTrans != null)
    {
      return;
      this.jdField_b_of_type_Aojn$a.dVf();
    }
    Object localObject = aqhs.hexStr2Bytes(this.mUkey);
    aojw localaojw = new aojw(this, SystemClock.uptimeMillis());
    if (this.cMl) {}
    for (this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 4, this.h.dQ, (int)this.apw, this.fI, this.bL, localaojw, this.dPl, this.fJ, this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead);; this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 1, this.h.dQ, (int)this.apw, (byte[])localObject, this.bL, localaojw))
    {
      localObject = new aojx(this);
      this.mTrans.cbForReport = ((ITransCallbackForReport)localObject);
      int i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.h.mUniseq + " MD5:" + this.clf + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:" + 1);
      }
      if (i == 0) {
        break;
      }
      a(i, "SubmitError.", "", this.jdField_b_of_type_Aojn$a);
      onError();
      return;
    }
  }
  
  public void dVo()
  {
    if (this.mIsCancel) {
      return;
    }
    if ((this.mResid != null) || (this.mUuid != null))
    {
      if (this.bz >= this.mFileSize)
      {
        dDP();
        return;
      }
      dVm();
      return;
    }
    start();
  }
  
  protected void doReport(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (!paramBoolean)
    {
      localObject1 = "Q.richmedia." + aonc.fG(this.h.mUinType) + "." + aonc.gC(this.h.mFileType);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.h.mUniseq + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.errCode + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.errDesc);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if ((!paramBoolean) && (this.dPf == 1))
    {
      this.jdField_c_of_type_Aojn$a.result = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_Aojn$a.fB(1) + ";" + this.jdField_b_of_type_Aojn$a.fB(2) + ";" + this.jdField_c_of_type_Aojn$a.fB(3);
      localObject2 = this.jdField_e_of_type_Aojn$a.fB(21) + ";" + this.f.fB(22);
      if (QLog.isColorLevel())
      {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> stepParam: " + (String)localObject1);
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> openUpSetpParam: " + (String)localObject2);
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mStepUrl: " + this.jdField_a_of_type_Aojn$a.toString() + ";mStepTrans: " + this.jdField_b_of_type_Aojn$a.toString() + ";mStepMsg: " + this.jdField_c_of_type_Aojn$a.toString() + ";mStepTransPre: " + this.jdField_e_of_type_Aojn$a.toString() + ";mStepTransLeft: " + this.f.toString() + ";");
      }
      String str;
      if (!paramBoolean)
      {
        str = (String)this.mM.get("param_reason");
        if (!"connError_unreachable".equalsIgnoreCase(str)) {
          break label520;
        }
      }
      label520:
      do
      {
        this.mM.put("param_reason", "N_1");
        while (this.h.mBusiType == 1030)
        {
          return;
          if ("connError_noroute".equalsIgnoreCase(str)) {
            this.mM.put("param_reason", "N_2");
          }
        }
      } while (((!paramBoolean) && (aona.lQ(this.errCode))) || (this.cLT) || ((paramBoolean) && ((this.dOZ & 0x2) > 0)) || ((!paramBoolean) && ((this.dOZ & 0x1) > 0)));
      int j = this.dOZ;
      long l1;
      long l2;
      if (paramBoolean)
      {
        i = 2;
        this.dOZ = (i | j);
        this.mEndTime = System.currentTimeMillis();
        l1 = System.nanoTime();
        l2 = (l1 - this.mStartTime) / 1000000L;
        Log.i("AutoMonitor", "SendC2CPic, cost=" + (this.jdField_b_of_type_Aojn$a.finishTime - this.jdField_b_of_type_Aojn$a.startTime) / 1000000L);
        this.mM.put("param_step", localObject1);
        this.mM.put("param_openUpStep", localObject2);
        localObject2 = this.mM;
        if (this.mResid != null) {
          break label1072;
        }
        localObject1 = this.mUuid;
        label728:
        ((HashMap)localObject2).put("param_uuid", localObject1);
        this.mM.put("param_toUin", this.h.mPeerUin);
        this.mM.put("param_picmd5", this.mFileName);
        this.mM.put("param_isPresend", this.h.cND + "");
        this.mM.put("param_isSecondTrans", this.cMe + "");
        this.mM.put("param_PhoneType", zsz.getDeviceType() + "");
        this.mM.put("param_NetType", aqiw.getSystemNetwork(BaseApplication.getContext()) + "");
        this.mM.put("param_IsRawPic", this.cLX + "");
        this.mM.put("param_quickHttp", String.valueOf(this.cLU));
        this.mM.put("param_picType", String.valueOf(this.dPe));
        this.mM.put("param_busi", String.valueOf(this.h.mBusiType));
        this.mM.put("param_openUp", String.valueOf(this.cMl));
        localObject1 = this.mM;
        if (!this.h.isQzonePic) {
          break label1081;
        }
      }
      label1072:
      label1081:
      for (int i = 1;; i = 0)
      {
        ((HashMap)localObject1).put("param_source_type", String.valueOf(i));
        QX(paramBoolean);
        e(paramBoolean, l2, l1);
        return;
        i = 1;
        break;
        localObject1 = this.mResid;
        break label728;
      }
    }
  }
  
  protected void doStart()
  {
    VR(1000);
    this.jdField_b_of_type_Aoko.dVw();
    VR(1001);
    aool localaool = a();
    if ((localaool != null) && (localaool.cNC))
    {
      this.mWidth = localaool.dQJ;
      this.mHeight = localaool.dQK;
      this.mFileSize = localaool.aqp;
      this.bL = aqhs.hexStr2Bytes(localaool.mMd5);
      this.mFileName = localaool.mMd5;
      this.clf = this.mFileName;
      this.jdField_b_of_type_Aoko.fileMd5 = this.mFileName;
      this.mFileName = (this.mFileName + "." + this.clg);
      this.app.getHwEngine().preConnect();
      sendRequest();
    }
    while (!bt(true)) {
      return;
    }
    this.app.getHwEngine().preConnect();
    if (this.cMl)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mIsOpenUpEnable: " + this.cMl);
      }
      this.fI = au();
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead = a();
      this.fJ = av();
      if ((this.fI != null) && (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mOpenUpTicket: " + this.fI + " mLoginSigHead:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead);
        }
        sendRequest();
        dVn();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> set mIsOpenUpEnable false");
      }
      this.cMl = false;
      sendRequest();
      return;
    }
    sendRequest();
  }
  
  protected void e(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (paramBoolean)
    {
      dVi();
      if (this.h.cND)
      {
        long l = 0L;
        if (this.apy != 0L) {
          l = (paramLong2 - this.apy) / 1000000L;
        }
        if (this.h.cvb) {
          l = paramLong1;
        }
        double d = l / paramLong1;
        zsz.a(l, this.mFileSize, this.cMe, d);
        if ((d >= 0.0D) && (d <= 1.0D)) {
          this.mM.put("param_AIOPercent", d + "");
        }
        this.mM.put("param_AIODuration", l + "");
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "doReport ,mStartTime = " + this.mStartTime + ",mEnterAioTime = " + this.apy + ",finishTime  = " + paramLong2 + ", aioDuration = " + l + ", duration = " + paramLong1 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.h.cvb + ",Percent = " + d);
        }
      }
      P(true, paramLong1);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.mM.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), true, paramLong1, this.mFileSize, localHashMap, "");
    }
    for (;;)
    {
      dVc();
      super.doReport(paramBoolean);
      return;
      if (this.errCode != -9527) {
        this.mM.remove("param_rspHeader");
      }
      this.mM.remove("param_url");
      this.mM.put("param_FailCode", String.valueOf(this.errCode));
      this.mM.put("param_errorDesc", this.errDesc);
      this.mM.put("param_picSize", String.valueOf(this.mFileSize));
      this.mM.put("param_uinType", String.valueOf(this.h.mUinType));
      this.mM.put("param_uniseq", String.valueOf(this.h.mUniseq));
      P(false, paramLong1);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), false, paramLong1, this.mFileSize, this.mM, "");
    }
  }
  
  void onError()
  {
    super.onError();
    VR(1005);
    if (this.h.b != null)
    {
      akyf.a locala = new akyf.a();
      locala.result = -1;
      locala.errCode = this.errCode;
      locala.errStr = this.errDesc;
      this.h.b.b(locala);
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    String str;
    if (this.h.b != null)
    {
      akyf.a locala = new akyf.a();
      locala.result = 0;
      locala.size = this.mFileSize;
      locala.md5 = this.clf;
      if (this.mResid == null)
      {
        str = this.mUuid;
        locala.uuid = str;
        if (this.h.cNI) {
          locala.data = ad();
        }
        this.h.b.b(locala);
      }
    }
    for (;;)
    {
      VR(1003);
      if (this.jdField_a_of_type_Aoql$a != null)
      {
        aoqm.d(this.jdField_a_of_type_Aoql$a);
        this.jdField_a_of_type_Aoql$a = null;
      }
      return;
      str = this.mResid;
      break;
      QV(true);
    }
  }
  
  public void pause()
  {
    super.pause();
    if (!this.mIsPause)
    {
      this.mIsPause = true;
      if (QLog.isColorLevel()) {
        hM("pause", "");
      }
      VR(1006);
      if (this.jdField_a_of_type_Aoql$a != null)
      {
        aoqm.d(this.jdField_a_of_type_Aoql$a);
        this.jdField_a_of_type_Aoql$a = null;
      }
    }
    switch (this.dPg)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return;
        log("<BDH_LOG> pause() BUT current status is INIT");
        return;
        log("<BDH_LOG> pause() pause HTTP channel");
      } while (this.jdField_a_of_type_Aomg == null);
      this.jdField_c_of_type_Aolm.b(this.jdField_a_of_type_Aomg);
      this.jdField_a_of_type_Aomg = null;
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
  
  protected void sendRequest()
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    aoql.a locala = new aoql.a();
    aoql.a.i locali = new aoql.a.i();
    locali.selfUin = this.h.mSelfUin;
    locali.peerUin = this.h.mPeerUin;
    locali.cmC = this.h.cmn;
    locali.uinType = this.h.mUinType;
    locali.fileName = this.mFileName;
    locali.fileSize = this.mFileSize;
    locali.md5 = this.bL;
    locali.width = this.mWidth;
    locali.height = this.mHeight;
    boolean bool;
    if (this.h.mUinType == 1006)
    {
      bool = true;
      locali.cNW = bool;
      locali.cMs = this.cLX;
      locala.b = this;
      locala.cmy = "c2c_pic_up";
      locala.He.add(locali);
      locala.a = this.app.getProtoReqManager();
      a(locali);
      MessageRecord localMessageRecord = this.h.F;
      if (MessageForPic.class.isInstance(localMessageRecord))
      {
        locali.picType = ((MessageForPic)localMessageRecord).imageType;
        this.dPe = ((MessageForPic)localMessageRecord).imageType;
      }
      if (azQ()) {
        break label249;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
      onError();
    }
    label249:
    do
    {
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        hM("requestStart", locala.toString());
      }
    } while (!azR());
    this.jdField_a_of_type_Aoql$a = locala;
    aoqm.c(locala);
  }
  
  public void start()
  {
    super.start();
    doStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aojv
 * JD-Core Version:    0.7.0.1
 */