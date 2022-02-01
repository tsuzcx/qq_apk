import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.PicInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoReqExtInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoSureReqInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.VideoInfo;
import com.tencent.mobileqq.highway.segment.RequestAck;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.LightVideoUploadProcessor.2;
import com.tencent.mobileqq.transfile.LightVideoUploadProcessor.5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype27;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class aolt
  extends aojl
{
  public static boolean cMO;
  public ArrayList<ambv> Bq = new ArrayList();
  List<Transaction> Hc = new ArrayList();
  private ambw jdField_a_of_type_Ambw;
  Bdh_extinfo.PicInfo jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo;
  RequestAck jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck;
  private long apR;
  QQAppInterface app = (QQAppInterface)this.app;
  achq b;
  String bkm;
  ambv jdField_c_of_type_Ambv;
  private MessageForLightVideo jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo;
  boolean cMP = false;
  protected int dPA;
  int dPB;
  private volatile int dPC;
  protected int dPz;
  private byte[] fN;
  protected RandomAccessFile i;
  private Handler mHandler;
  long mSessionId;
  private String mThumbFilePath;
  int mUploadType = -1;
  Map<Integer, Bdh_extinfo.VideoInfo> mVideoInfos = new HashMap();
  private long mVideoTime;
  public Map<Integer, ambv> nw = new HashMap();
  
  public aolt(aojm paramaojm, aool paramaool)
  {
    super(paramaojm, paramaool);
    this.jdField_b_of_type_Achq = new aolu(this);
    paramaojm = paramaool.extraObject;
    if ((paramaojm != null) && ((paramaojm instanceof ambw))) {
      this.jdField_a_of_type_Ambw = ((ambw)paramaool.extraObject);
    }
    if ((this.jdField_a_of_type_Aojm != null) && (this.jdField_a_of_type_Aojm.a != null)) {
      this.mHandler = this.jdField_a_of_type_Aojm.a;
    }
    this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo = ((MessageForLightVideo)paramaool.F);
    cMO = VideoUpConfigInfo.sIsPreSendSignal;
  }
  
  private aoql.a.n a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "makeShortVideoUpReq");
    }
    aoql.a.n localn = new aoql.a.n();
    localn.seq = ((int)this.h.mUniseq);
    localn.selfUin = this.h.mSelfUin;
    localn.peerUin = this.h.mPeerUin;
    localn.uinType = this.h.mUinType;
    localn.dRn = 0;
    if ((localn.uinType == 0) || (1008 == localn.uinType))
    {
      localn.troopUin = null;
      if (localn.uinType != 0) {
        break label254;
      }
      localn.chatType = 0;
    }
    for (;;)
    {
      localn.clientType = 2;
      Object localObject = new File(this.bkm);
      localn.fileName = ((File)localObject).getName();
      localn.fileSize = ((File)localObject).length();
      localn.md5 = this.bL;
      localn.fG = this.fN;
      localn.dRp = this.dPA;
      localn.dRo = this.dPz;
      localn.dFo = this.dPB;
      localn.JW = this.apR;
      localObject = this.jdField_b_of_type_Aoko;
      long l = localn.fileSize + this.apR;
      this.mFileSize = l;
      ((aoko)localObject).fileSize = l;
      localn.format = 3;
      localn.subBusiType = 3;
      localn.busiType = this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.busiType;
      return localn;
      localn.troopUin = this.h.mPeerUin;
      break;
      label254:
      if (1 == localn.uinType) {
        localn.chatType = 1;
      } else if (3000 == localn.uinType) {
        localn.chatType = 2;
      } else {
        localn.chatType = 3;
      }
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
          QLog.d("LightVideoUploadProcessor", 2, "constructRichText ,mResid uuid=" + this.mResid + " mLocalVideoTime:" + this.dPB + " mVideoTime:" + this.mVideoTime);
        }
        if (!(this.h.F instanceof MessageForLightVideo)) {
          break label660;
        }
        Object localObject1 = (MessageForLightVideo)this.h.F;
        Object localObject3;
        if (localObject1 != null)
        {
          localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForLightVideo)localObject1).fileSource));
          localVideoFile.uint32_busi_type.set(((MessageForLightVideo)localObject1).busiType);
          localVideoFile.bool_support_progressive.set(((MessageForLightVideo)localObject1).supportProgressive);
          localVideoFile.uint32_file_width.set(((MessageForLightVideo)localObject1).fileWidth);
          localVideoFile.uint32_file_height.set(((MessageForLightVideo)localObject1).fileHeight);
          localVideoFile.uint32_sub_busi_type.set(((MessageForLightVideo)localObject1).subBusiType);
          localObject3 = new videoFile.ResvAttr();
          ((videoFile.ResvAttr)localObject3).uint32_msg_tail_type.set(((MessageForLightVideo)localObject1).msgTailType);
          localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.h.dQ));
          localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.h.mMd5)));
          localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((videoFile.ResvAttr)localObject3).toByteArray()));
          localVideoFile.uint32_video_attr.set(0);
        }
        localVideoFile.uint32_file_format.set(2);
        localVideoFile.uint32_file_size.set((int)(this.mFileSize - this.apR));
        if (this.dPB == 0)
        {
          if ((this.jdField_a_of_type_Ambw != null) && (this.jdField_a_of_type_Ambw.mVideoDuration != 0))
          {
            localVideoFile.uint32_file_time.set(this.jdField_a_of_type_Ambw.mVideoDuration / 1000);
            localVideoFile.uint32_thumb_width.set(this.dPA);
            localVideoFile.uint32_thumb_height.set(this.dPz);
            localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.fN));
            localVideoFile.uint32_thumb_file_size.set((int)this.apR);
            localVideoFile.uint32_from_chat_type.set(-1);
            localVideoFile.uint32_to_chat_type.set(-1);
            localObject3 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject3).setHasFlag(true);
            localObject1 = acfp.m(2131707682);
            ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8(BaseApplication.getContext().getString(2131692312)));
            Object localObject4 = new TextMsgExtPb.ResvAttr();
            ((TextMsgExtPb.ResvAttr)localObject4).wording.set(ByteStringMicro.copyFromUtf8((String)localObject1));
            ((im_msg_body.Text)localObject3).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((TextMsgExtPb.ResvAttr)localObject4).toByteArray()));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
            localObject3 = new im_msg_body.Elem();
            localObject4 = new im_msg_body.CommonElem();
            ((im_msg_body.CommonElem)localObject4).uint32_service_type.set(27);
            ((im_msg_body.CommonElem)localObject4).uint32_business_type.set(1);
            hummer_commelem.MsgElemInfo_servtype27 localMsgElemInfo_servtype27 = new hummer_commelem.MsgElemInfo_servtype27();
            localMsgElemInfo_servtype27.video_file.set(localVideoFile);
            ((im_msg_body.CommonElem)localObject4).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype27.toByteArray()));
            ((im_msg_body.Elem)localObject3).common_elem.set((MessageMicro)localObject4);
            localRichText.elems.add((MessageMicro)localObject1);
            localRichText.elems.add((MessageMicro)localObject3);
            return localRichText;
          }
          localVideoFile.uint32_file_time.set((int)this.mVideoTime);
          continue;
        }
        localVideoFile.uint32_file_time.set(this.dPB);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LightVideoUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      continue;
      label660:
      Object localObject2 = null;
    }
  }
  
  private boolean aAa()
  {
    if ((this.i != null) && (this.mRaf != null)) {}
    for (;;)
    {
      return true;
      if (this.i == null) {
        try
        {
          this.i = new RandomAccessFile(this.mThumbFilePath, "r");
          if (this.i == null) {
            return false;
          }
        }
        catch (FileNotFoundException localFileNotFoundException1)
        {
          for (;;)
          {
            localFileNotFoundException1.printStackTrace();
            this.i = null;
          }
        }
      }
      if (this.mRaf != null) {
        continue;
      }
      try
      {
        this.mRaf = new RandomAccessFile(this.bkm, "r");
        if (this.mRaf != null) {
          continue;
        }
        return false;
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        for (;;)
        {
          localFileNotFoundException2.printStackTrace();
          this.mRaf = null;
        }
      }
    }
  }
  
  private void dVt()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendFileByBDH");
    }
    long l = SystemClock.uptimeMillis();
    if (!aAa())
    {
      dN(9303, "read  file error");
      onError();
      return;
    }
    String str = AI();
    Object localObject1 = a();
    Object localObject2 = new PttShortVideo.PttShortVideoUploadReq();
    ((PttShortVideo.PttShortVideoUploadReq)localObject2).setHasFlag(true);
    ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint64_fromuin.set(Long.parseLong(((aoql.a.n)localObject1).selfUin));
    ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint64_touin.set(Long.parseLong(((aoql.a.n)localObject1).peerUin));
    ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_chat_type.set(((aoql.a.n)localObject1).chatType);
    ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_client_type.set(((aoql.a.n)localObject1).clientType);
    if (((aoql.a.n)localObject1).troopUin != null) {
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint64_group_code.set(Long.parseLong(((aoql.a.n)localObject1).troopUin));
    }
    for (;;)
    {
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_agent_type.set(((aoql.a.n)localObject1).dRn);
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_business_type.set(((aoql.a.n)localObject1).busiType);
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_flag_support_large_size.set(1);
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_sub_business_type.set(3);
      PttShortVideo.PttShortVideoFileInfo localPttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
      localPttShortVideoFileInfo.str_file_name.set(((aoql.a.n)localObject1).fileName);
      localPttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(((aoql.a.n)localObject1).md5));
      localPttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(((aoql.a.n)localObject1).fG));
      localPttShortVideoFileInfo.uint64_file_size.set(((aoql.a.n)localObject1).fileSize);
      localPttShortVideoFileInfo.uint32_file_res_length.set(((aoql.a.n)localObject1).dRo);
      localPttShortVideoFileInfo.uint32_file_res_width.set(((aoql.a.n)localObject1).dRp);
      localPttShortVideoFileInfo.uint32_file_format.set(((aoql.a.n)localObject1).format);
      localPttShortVideoFileInfo.uint32_file_time.set(((aoql.a.n)localObject1).dFo);
      localPttShortVideoFileInfo.uint64_thumb_file_size.set(((aoql.a.n)localObject1).JW);
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).msg_PttShortVideoFileInfo.set(localPttShortVideoFileInfo);
      localObject1 = ((PttShortVideo.PttShortVideoUploadReq)localObject2).toByteArray();
      localObject1 = new Cryptor().encrypt((byte[])localObject1, this.fH);
      localObject2 = new aolv(this, str, l);
      this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 12, str, (int)this.apw, this.de, this.bL, (ITransactionCallback)localObject2, (byte[])localObject1);
      int j = this.app.getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + j + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.h.mUniseq + " MD5:" + this.clf + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:" + 12);
      }
      if (j == 0) {
        break;
      }
      a(j, "sendFileByBDH SubmitError.", "", this.jdField_b_of_type_Aojn$a);
      onError();
      return;
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint64_group_code.set(0L);
    }
  }
  
  public void Rb(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ambw != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "confirm send:" + this.jdField_a_of_type_Ambw.avp());
      }
      if (!this.jdField_a_of_type_Ambw.avp()) {
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendMsg() start.");
    }
    im_msg_body.RichText localRichText = a();
    if (localRichText == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_Aojn$a);
      onError();
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.richText = localRichText;
    ((ambj)this.app.getManager(326)).d(this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo, this.jdField_b_of_type_Achq);
  }
  
  public void VR(int paramInt)
  {
    super.VR(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendMessageToUpdate,state = " + paramInt);
    }
    this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileStatus = paramInt;
    this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.serial();
    this.app.b().c(this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.istroop, this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.msgData);
  }
  
  void VU(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "onSendFileSliceFailed, mSendFileSliceFailed:" + this.cMP + " mUploadType:" + this.mUploadType + " errCode:" + paramInt);
    }
    this.cMP = true;
    this.mM.put("segment_error_code", String.valueOf(paramInt));
    Iterator localIterator = this.Hc.iterator();
    while (localIterator.hasNext()) {
      ((Transaction)localIterator.next()).cancelTransaction();
    }
    if (this.mUploadType == 0) {
      dVM();
    }
  }
  
  /* Error */
  void a(aolt.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 822	aolt$a:path	Ljava/lang/String;
    //   6: astore 5
    //   8: aload_1
    //   9: getfield 825	aolt$a:ticket	[B
    //   12: astore 6
    //   14: aload_1
    //   15: getfield 828	aolt$a:fO	[B
    //   18: astore 7
    //   20: aload_1
    //   21: getfield 831	aolt$a:extendInfo	[B
    //   24: astore 8
    //   26: aload_1
    //   27: getfield 834	aolt$a:index	I
    //   30: istore_2
    //   31: aload_1
    //   32: getfield 837	aolt$a:fP	[B
    //   35: astore 9
    //   37: aload_1
    //   38: getfield 839	aolt$a:e	Lambv;
    //   41: astore 9
    //   43: aload_1
    //   44: getfield 840	aolt$a:fileSize	J
    //   47: lstore_3
    //   48: new 9	aolt$b
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 841	aolt$b:<init>	(Laolt;)V
    //   56: astore_1
    //   57: new 654	com/tencent/mobileqq/highway/transaction/Transaction
    //   60: dup
    //   61: aload_0
    //   62: getfield 90	aolt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   65: invokevirtual 657	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   68: bipush 16
    //   70: aload 5
    //   72: iconst_0
    //   73: aload 6
    //   75: aload 7
    //   77: aload_1
    //   78: aload 8
    //   80: invokespecial 666	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[B[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[B)V
    //   83: astore 5
    //   85: aload_0
    //   86: getfield 129	aolt:dPC	I
    //   89: ifeq +12 -> 101
    //   92: aload 5
    //   94: aload_0
    //   95: getfield 129	aolt:dPC	I
    //   98: putfield 844	com/tencent/mobileqq/highway/transaction/Transaction:cacheIp	I
    //   101: aload_1
    //   102: aload 5
    //   104: putfield 846	aolt$b:a	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   107: aload_1
    //   108: iload_2
    //   109: putfield 847	aolt$b:index	I
    //   112: aload_1
    //   113: aload 9
    //   115: putfield 848	aolt$b:e	Lambv;
    //   118: aload_0
    //   119: getfield 90	aolt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   122: invokevirtual 674	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   125: aload 5
    //   127: invokevirtual 680	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   130: istore_2
    //   131: iload_2
    //   132: ifeq +11 -> 143
    //   135: aload_0
    //   136: iload_2
    //   137: invokevirtual 850	aolt:VU	(I)V
    //   140: aload_0
    //   141: monitorexit
    //   142: return
    //   143: aload_0
    //   144: getfield 65	aolt:Hc	Ljava/util/List;
    //   147: aload 5
    //   149: invokeinterface 853 2 0
    //   154: pop
    //   155: goto -15 -> 140
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	aolt
    //   0	163	1	parama	aolt.a
    //   30	107	2	j	int
    //   47	1	3	l	long
    //   6	142	5	localObject1	Object
    //   12	62	6	arrayOfByte1	byte[]
    //   18	58	7	arrayOfByte2	byte[]
    //   24	55	8	arrayOfByte3	byte[]
    //   35	79	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	101	158	finally
    //   101	131	158	finally
    //   135	140	158	finally
    //   143	155	158	finally
  }
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    this.jdField_a_of_type_Aoql$a = null;
    if (paramb != null)
    {
      int j = 0;
      if (j < paramb.Hf.size())
      {
        parama = (aoql.b.p)paramb.Hf.get(j);
        if (QLog.isColorLevel()) {
          hM("procUrl", parama.toString());
        }
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoUploadProcessor", 2, "onBusiProtoResp()------response.result = " + parama.result);
        }
        this.mResid = parama.fileId;
        if (parama.result == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LightVideoUploadProcessor", 2, "onBusiProtoResp()------response.isExist = " + parama.isExist);
          }
          if (parama.isExist)
          {
            VR(1007);
            Rb(true);
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if (azS())
          {
            dVt();
          }
          else
          {
            onError();
            continue;
            dN(parama.result, "onBusiProtoResp error");
            onError();
          }
        }
      }
    }
  }
  
  public void a(Bdh_extinfo.ShortVideoReqExtInfo paramShortVideoReqExtInfo)
  {
    paramShortVideoReqExtInfo = new Cryptor().encrypt(paramShortVideoReqExtInfo.toByteArray(), this.fH);
    aolw localaolw = new aolw(this);
    paramShortVideoReqExtInfo = new RequestAck(this.h.mSelfUin, 16, this.de, 30000L, localaolw, paramShortVideoReqExtInfo, this.fN, this.dPC);
    this.app.getHwEngine().SubmitAckRequest(paramShortVideoReqExtInfo);
    this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck = paramShortVideoReqExtInfo;
  }
  
  public void b(ambv paramambv)
  {
    if (paramambv.avl())
    {
      c(paramambv);
      return;
    }
    if (paramambv.avm())
    {
      e(paramambv);
      return;
    }
    d(paramambv);
  }
  
  void c(ambv paramambv)
  {
    String str = paramambv.mPath;
    int j = (int)this.apR;
    byte[] arrayOfByte1 = this.de;
    byte[] arrayOfByte3 = this.fH;
    byte[] arrayOfByte2 = this.fN;
    long l = this.mSessionId;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>sendVideoThumbByBDH  filePath:" + str + " index :" + paramambv.mIndex + " md5:" + HexUtil.bytes2HexStr(arrayOfByte2) + " fileSize:" + j);
    }
    Object localObject = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint32_cmd.set(1);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint64_session_id.set(l);
    if (cMO) {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(true);
    }
    for (;;)
    {
      Bdh_extinfo.PicInfo localPicInfo = new Bdh_extinfo.PicInfo();
      localPicInfo.uint32_idx.set(0);
      localPicInfo.uint32_size.set(j);
      localPicInfo.uint32_type.set(1);
      localPicInfo.bytes_bin_md5.set(ByteStringMicro.copyFrom(arrayOfByte2));
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo = localPicInfo;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).msg_thumbinfo.set(localPicInfo);
      arrayOfByte3 = new Cryptor().encrypt(((Bdh_extinfo.ShortVideoReqExtInfo)localObject).toByteArray(), arrayOfByte3);
      localObject = new aolt.a();
      ((aolt.a)localObject).path = str;
      ((aolt.a)localObject).ticket = arrayOfByte1;
      ((aolt.a)localObject).fO = arrayOfByte2;
      ((aolt.a)localObject).extendInfo = arrayOfByte3;
      ((aolt.a)localObject).index = 0;
      ((aolt.a)localObject).fP = arrayOfByte2;
      ((aolt.a)localObject).e = paramambv;
      ((aolt.a)localObject).fileSize = j;
      a((aolt.a)localObject);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(false);
    }
  }
  
  public int cancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "cancel");
    }
    Iterator localIterator = this.Hc.iterator();
    while (localIterator.hasNext()) {
      ((Transaction)localIterator.next()).cancelTransaction();
    }
    if (this.mTrans != null) {
      this.mTrans.cancelTransaction();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck != null)
    {
      this.app.getHwEngine().cancelAckRequest(this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck);
      this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck = null;
    }
    this.jdField_a_of_type_Ambw = null;
    return super.cancel();
  }
  
  void d(ambv paramambv)
  {
    String str = paramambv.mPath;
    int j = (int)new File(str).length();
    byte[] arrayOfByte1 = this.fN;
    byte[] arrayOfByte2 = HexUtil.hexStr2Bytes(paramambv.mMd5);
    int k = paramambv.mIndex;
    int m = paramambv.mHeight;
    int n = paramambv.mWidth;
    int i1 = paramambv.mVideoDuration;
    long l = paramambv.mTimestamp;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>sendVideoSegByBDH  filePath:" + str + " index :" + k + " md5:" + HexUtil.bytes2HexStr(arrayOfByte2) + " fileSize:" + j);
    }
    Object localObject1 = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).uint32_cmd.set(2);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).uint64_session_id.set(this.mSessionId);
    if (cMO) {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).bool_is_merge_cmd_before_data.set(true);
    }
    for (;;)
    {
      Object localObject2 = new Bdh_extinfo.VideoInfo();
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_idx.set(k);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_size.set(j);
      ((Bdh_extinfo.VideoInfo)localObject2).bytes_bin_md5.set(ByteStringMicro.copyFrom(arrayOfByte2));
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_format.set(2);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_res_len.set(m);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_res_width.set(n);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_time.set(i1);
      ((Bdh_extinfo.VideoInfo)localObject2).uint64_starttime.set(l);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_is_audio.set(0);
      this.mVideoInfos.put(Integer.valueOf(k), localObject2);
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).msg_videoinfo.set((MessageMicro)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo != null) {
        ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).msg_thumbinfo.set(this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo);
      }
      localObject1 = new Cryptor().encrypt(((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).toByteArray(), this.fH);
      localObject2 = new aolt.a();
      ((aolt.a)localObject2).path = str;
      ((aolt.a)localObject2).ticket = this.de;
      ((aolt.a)localObject2).fO = arrayOfByte1;
      ((aolt.a)localObject2).extendInfo = ((byte[])localObject1);
      ((aolt.a)localObject2).index = k;
      ((aolt.a)localObject2).fP = arrayOfByte2;
      ((aolt.a)localObject2).e = paramambv;
      ((aolt.a)localObject2).fileSize = j;
      a((aolt.a)localObject2);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).bool_is_merge_cmd_before_data.set(false);
    }
  }
  
  protected void dUZ()
  {
    super.dUZ();
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendProgressMessage,progress;" + this.mProgress + " transferedSize:" + this.jdField_b_of_type_Aoko.transferedSize + " fileSize:" + this.jdField_b_of_type_Aoko.fileSize);
    }
  }
  
  public void dVL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG> sendCompleteFile Start.   this:" + this);
    }
    if (!azS()) {
      dVh();
    }
    if (!azS())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "session is null, sendRequest ");
      }
      sendRequest();
      return;
    }
    dVt();
  }
  
  public void dVM()
  {
    int k = 1;
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "checkNeedSendCompleteFile check, mUploadType:" + this.mUploadType + " mSendFileSliceFailed:" + this.cMP + " mCombineInfo:" + this.jdField_c_of_type_Ambv);
    }
    int j;
    if (this.mUploadType == 0) {
      if (this.cMP)
      {
        this.mUploadType = 1;
        j = k;
      }
    }
    for (;;)
    {
      if ((j != 0) && (this.jdField_c_of_type_Ambv != null))
      {
        this.h.dQ = this.jdField_c_of_type_Ambv.mPath;
        this.h.mMd5 = this.jdField_c_of_type_Ambv.mMd5;
        this.h.cND = false;
        this.bkm = this.jdField_c_of_type_Ambv.mPath;
        this.bL = HexUtil.hexStr2Bytes(this.jdField_c_of_type_Ambv.mMd5);
        aoko localaoko = this.jdField_b_of_type_Aoko;
        String str = this.jdField_c_of_type_Ambv.mMd5;
        localaoko.fileMd5 = str;
        this.clf = str;
        this.mFileSize = this.jdField_c_of_type_Ambv.mFileLength;
        this.dPB = (this.jdField_c_of_type_Ambv.mVideoDuration / 1000);
        dVL();
      }
      return;
      if ((this.jdField_c_of_type_Ambv != null) && (!this.jdField_c_of_type_Ambv.cCb))
      {
        this.mUploadType = 4;
        j = k;
        continue;
        j = k;
        if (this.mUploadType != 2)
        {
          j = k;
          if (this.mUploadType == 1) {}
        }
      }
      else
      {
        j = 0;
      }
    }
  }
  
  public void dVN()
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendAckToBDHServer");
    }
    long l1 = this.mSessionId;
    Bdh_extinfo.PicInfo localPicInfo = this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo;
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j <= this.mVideoInfos.size())
    {
      localObject = (Bdh_extinfo.VideoInfo)this.mVideoInfos.get(Integer.valueOf(j));
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      j += 1;
    }
    Object localObject = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint32_cmd.set(3);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint64_session_id.set(l1);
    Bdh_extinfo.ShortVideoSureReqInfo localShortVideoSureReqInfo;
    long l2;
    if (cMO)
    {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(true);
      localShortVideoSureReqInfo = new Bdh_extinfo.ShortVideoSureReqInfo();
      l1 = Long.parseLong(this.h.mSelfUin);
      l2 = Long.parseLong(this.h.mPeerUin);
      localShortVideoSureReqInfo.uint64_fromuin.set(l1);
      localShortVideoSureReqInfo.uint64_touin.set(l2);
      if ((this.h.mUinType != 0) && (1008 != this.h.mUinType)) {
        break label328;
      }
      localShortVideoSureReqInfo.uint64_group_code.set(0L);
      label217:
      if (this.h.mUinType != 0) {
        break label341;
      }
      j = k;
    }
    for (;;)
    {
      k = ((MessageForLightVideo)this.h.F).busiType;
      localShortVideoSureReqInfo.uint32_chat_type.set(j);
      localShortVideoSureReqInfo.uint32_business_type.set(k);
      localShortVideoSureReqInfo.uint32_sub_business_type.set(3);
      localShortVideoSureReqInfo.uint32_client_type.set(2);
      localShortVideoSureReqInfo.msg_thumbinfo.set(localPicInfo);
      localShortVideoSureReqInfo.rpt_msg_merge_videoinfo.set(localArrayList);
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).msg_shortvideo_sure_req.set(localShortVideoSureReqInfo);
      a((Bdh_extinfo.ShortVideoReqExtInfo)localObject);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(false);
      break;
      label328:
      localShortVideoSureReqInfo.uint64_group_code.set(l2);
      break label217;
      label341:
      if (1 == this.h.mUinType) {
        j = 1;
      } else if (3000 == this.h.mUinType) {
        j = 2;
      } else {
        j = 3;
      }
    }
  }
  
  public void dVO()
  {
    if (this.nw.size() >= 3) {}
    label144:
    for (;;)
    {
      return;
      for (;;)
      {
        if ((this.nw.size() >= 3) || (this.Bq.size() <= 0)) {
          break label144;
        }
        ambv localambv = (ambv)this.Bq.remove(0);
        if (localambv == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoSend", 2, "sendSlice, info:" + localambv + " mSendingInfos:" + this.nw.size() + " mReadyToSendInfos:" + this.Bq.size());
        }
        this.nw.put(Integer.valueOf(localambv.mIndex), localambv);
        b(localambv);
      }
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    long l;
    if ((this.jdField_a_of_type_Ambw != null) && (this.jdField_a_of_type_Ambw.aiv != 0L))
    {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Ambw.aiv;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "doReport, timeCost:" + l + " mFileSize:" + this.mFileSize + " mUploadType:" + this.mUploadType + " errorCode:" + this.errCode);
      }
      this.mM.put("param_errorDesc", this.errDesc);
      if (!paramBoolean) {
        break label197;
      }
      this.mM.put("upload_suc_flag", "1");
    }
    while ((this.mUploadType == 0) || (this.mUploadType == 1))
    {
      if (this.mUploadType == 1) {
        this.mM.put("upload_segment_fail_flag", "1");
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "LightVideoSend", paramBoolean, l, this.mFileSize, this.mM, null);
      return;
      label197:
      this.mM.put("param_FailCode", String.valueOf(this.errCode));
    }
    this.mM.put("upload_type", String.valueOf(this.mUploadType));
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "LightVideoSendComplete", paramBoolean, l, this.mFileSize, this.mM, null);
  }
  
  void e(ambv paramambv)
  {
    String str = paramambv.mPath;
    int j = (int)new File(str).length();
    byte[] arrayOfByte1 = this.fN;
    byte[] arrayOfByte2 = HexUtil.hexStr2Bytes(paramambv.mMd5);
    int k = paramambv.mIndex;
    int m = paramambv.mHeight;
    int n = paramambv.mWidth;
    int i1 = paramambv.mVideoDuration;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>sendVideoSegByBDH  filePath:" + str + " index :" + k + " md5:" + HexUtil.bytes2HexStr(arrayOfByte2) + "fileSize:" + j);
    }
    Object localObject1 = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).uint32_cmd.set(2);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).uint64_session_id.set(this.mSessionId);
    if (cMO) {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).bool_is_merge_cmd_before_data.set(true);
    }
    for (;;)
    {
      Object localObject2 = new Bdh_extinfo.VideoInfo();
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_size.set(j);
      ((Bdh_extinfo.VideoInfo)localObject2).bytes_bin_md5.set(ByteStringMicro.copyFrom(arrayOfByte2));
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_format.set(2);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_res_len.set(m);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_res_width.set(n);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_time.set(i1);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_idx.set(k);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_is_audio.set(1);
      this.mVideoInfos.put(Integer.valueOf(k), localObject2);
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).msg_videoinfo.set((MessageMicro)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo != null) {
        ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).msg_thumbinfo.set(this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo);
      }
      localObject1 = new Cryptor().encrypt(((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).toByteArray(), this.fH);
      localObject2 = new aolt.a();
      ((aolt.a)localObject2).path = str;
      ((aolt.a)localObject2).ticket = this.de;
      ((aolt.a)localObject2).fO = arrayOfByte1;
      ((aolt.a)localObject2).extendInfo = ((byte[])localObject1);
      ((aolt.a)localObject2).index = k;
      ((aolt.a)localObject2).fP = arrayOfByte2;
      ((aolt.a)localObject2).e = paramambv;
      ((aolt.a)localObject2).fileSize = j;
      a((aolt.a)localObject2);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).bool_is_merge_cmd_before_data.set(false);
    }
  }
  
  public void f(ambv paramambv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "addToSendQuene, info:" + paramambv + " mSendingInfos:" + this.nw.size() + " mReadyToSendInfos:" + this.Bq.size() + " mUploadType" + this.mUploadType);
    }
    if (paramambv.avn())
    {
      this.jdField_c_of_type_Ambv = paramambv;
      dVM();
    }
    while (this.mUploadType != 0) {
      return;
    }
    aoko localaoko = this.jdField_b_of_type_Aoko;
    localaoko.fileSize += paramambv.mFileLength;
    this.mFileSize += paramambv.mFileLength;
    this.Bq.add(paramambv);
    dVO();
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    if (this.i != null) {}
    try
    {
      this.i.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    finally
    {
      this.i = null;
    }
  }
  
  public void g(ambv paramambv)
  {
    this.mHandler.post(new LightVideoUploadProcessor.5(this, paramambv));
  }
  
  void onError()
  {
    super.onError();
    VR(1005);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "onError");
    }
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
    this.errCode = 0;
    super.onSuccess();
    akyf.a locala = new akyf.a();
    locala.result = 0;
    locala.size = (this.mFileSize - this.apR);
    locala.md5 = this.clf;
    if (this.mResid == null) {}
    for (String str = this.mUuid;; str = this.mResid)
    {
      locala.uuid = str;
      locala.JW = this.apR;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "onSuccess uuid = " + locala.uuid);
      }
      if (this.h.b == null) {
        break;
      }
      this.h.b.b(locala);
      this.mHandler.post(new LightVideoUploadProcessor.2(this));
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.uuid = locala.uuid;
    this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.md5 = locala.md5;
    VR(1003);
  }
  
  public void sendRequest()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendRequest");
    }
    aoql.a locala = new aoql.a();
    aoql.a.n localn = a();
    locala.b = this;
    locala.cmy = "short_video_up";
    locala.He.add(localn);
    locala.a = this.app.getProtoReqManager();
    this.jdField_a_of_type_Aoql$a = locala;
    aoqm.c(locala);
  }
  
  public void start()
  {
    super.start();
    this.mThumbFilePath = this.h.bN;
    this.mSessionId = this.h.mUniseq;
    if (this.h.aIf == null) {
      this.fN = HexUtil.hexStr2Bytes(amjg.calcMD5(this.mThumbFilePath));
    }
    this.fN = HexUtil.hexStr2Bytes(this.h.aIf);
    Object localObject;
    if ((this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbFileSize == 0) || (this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbWidth == 0) || (this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbHeight == 0))
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.mThumbFilePath);
      this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbWidth = ((BitmapFactory.Options)localObject).outWidth;
      this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbHeight = ((BitmapFactory.Options)localObject).outHeight;
      this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbFileSize = ((int)new File(this.mThumbFilePath).length());
    }
    this.apR = this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbFileSize;
    this.dPA = this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbWidth;
    this.dPz = this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbHeight;
    dVh();
    if (azS()) {
      if (this.jdField_a_of_type_Ambw != null) {
        if (this.h.cND)
        {
          this.mUploadType = 0;
          this.jdField_a_of_type_Ambw.a(this);
          label234:
          VR(1001);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "start, mUploadType = " + this.mUploadType);
      }
      return;
      this.mUploadType = 2;
      break;
      this.mUploadType = 2;
      this.bkm = this.h.dQ;
      if (this.h.mMd5 == null) {
        this.h.mMd5 = amjg.calcMD5(this.bkm);
      }
      localObject = this.jdField_b_of_type_Aoko;
      String str = this.h.mMd5;
      ((aoko)localObject).fileMd5 = str;
      this.clf = str;
      this.bL = HexUtil.hexStr2Bytes(this.h.mMd5);
      if ((this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileSize == 0) || (this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileTime == 0))
      {
        localObject = new ankk.a();
        ankk.a(this.bkm, (ankk.a)localObject);
        int j = localObject.mMetaData[3];
        this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileSize = ((int)new File(this.bkm).length());
        this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileTime = (j / 1000);
      }
      this.mFileSize = this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileSize;
      this.dPB = this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileTime;
      sendRequest();
      break label234;
      HwServlet.getConfig(this.app, this.h.mSelfUin);
      this.mUploadType = 2;
      this.jdField_a_of_type_Ambw.a(this);
    }
  }
  
  class a
  {
    ambv e;
    byte[] extendInfo;
    byte[] fO;
    byte[] fP;
    long fileSize;
    int index;
    String path;
    byte[] ticket;
    
    a() {}
  }
  
  class b
    implements ITransactionCallback
  {
    public Transaction a;
    public ambv e;
    public int index;
    
    b() {}
    
    public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener.onFailed  erroCode: " + paramInt + " sendInfo:" + this.e);
      }
      aolt.this.VU(paramInt);
    }
    
    public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener.onSuccess  erroCode:  sendInfo:" + this.e);
      }
      paramArrayOfByte = aolt.this.b;
      paramArrayOfByte.transferedSize += this.a.totalLength;
      if (aolt.this.c != null) {
        aolt.this.dUZ();
      }
      aolt.this.g(this.e);
    }
    
    public void onSwitch2BackupChannel() {}
    
    public void onTransStart() {}
    
    public void onUpdateProgress(int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aolt
 * JD-Core Version:    0.7.0.1
 */