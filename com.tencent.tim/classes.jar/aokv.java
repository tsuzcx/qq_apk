import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor.1;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor.4;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype13;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class aokv
  extends aojk
  implements aqxt.a, INetEventHandler
{
  private long apG;
  long jdField_app_of_type_Long;
  QQAppInterface jdField_app_of_type_ComTencentMobileqqAppQQAppInterface;
  aooi jdField_c_of_type_Aooi;
  private MessageForPic jdField_c_of_type_ComTencentMobileqqDataMessageForPic;
  boolean cMB = false;
  boolean cMc = false;
  public boolean cMm;
  private boolean cMo;
  private boolean cMp;
  String clM;
  achq e = new aoky(this);
  private boolean isStoryPhoto;
  boolean mIsGroup = true;
  private long startTime = -1L;
  private long timeStamp;
  
  public aokv(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    if (!this.cMB) {
      this.jdField_b_of_type_Auyc = alii.a();
    }
    this.jdField_c_of_type_Aooi = paramaooi;
    this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.app);
    AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
    if ((this.h.F != null) && ((this.h.F instanceof MessageForPic)))
    {
      this.isStoryPhoto = ((MessageForPic)this.h.F).isStoryPhoto;
      if (this.isStoryPhoto) {
        this.jdField_c_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)this.h.F);
      }
    }
  }
  
  private int KN()
  {
    switch (this.h.mBusiType)
    {
    default: 
      return 200;
    case 1008: 
      return 105;
    case 1007: 
      return 101;
    case 1009: 
      return 104;
    case 1006: 
      return 103;
    }
    return 106;
  }
  
  private im_msg_body.Elem a()
  {
    Object localObject = (aczr)this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getManager(199);
    if ((localObject != null) && (((aczr)localObject).adh()) && (((aczr)localObject).fl() == 1L))
    {
      localObject = ((aczr)localObject).a();
      if (localObject != null)
      {
        int i = ((Setting)localObject).systemHeadID;
        int j = ((Setting)localObject).bHeadType;
        localObject = new im_msg_body.Elem();
        im_msg_body.CommonElem localCommonElem = new im_msg_body.CommonElem();
        localCommonElem.uint32_service_type.set(13);
        hummer_commelem.MsgElemInfo_servtype13 localMsgElemInfo_servtype13 = new hummer_commelem.MsgElemInfo_servtype13();
        localMsgElemInfo_servtype13.uint32_sys_head_id.set(i);
        localMsgElemInfo_servtype13.uint32_head_flag.set(j);
        localCommonElem.bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype13.toByteArray()));
        ((im_msg_body.Elem)localObject).common_elem.set(localCommonElem);
        return localObject;
      }
    }
    return null;
  }
  
  private void a(im_msg_body.RichText paramRichText, MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt != null) && (paramRichText != null))
    {
      paramRichText.ptt.uint32_format.set(paramMessageForPtt.voiceType);
      paramRichText.ptt.uint32_time.set(aqft.ag(paramMessageForPtt.voiceLength));
    }
  }
  
  public static byte[] b(MessageForPtt paramMessageForPtt)
  {
    Object localObject = new ptt_reserve.ReserveStruct();
    if (paramMessageForPtt != null)
    {
      ((ptt_reserve.ReserveStruct)localObject).uint32_change_voice.set(paramMessageForPtt.voiceChangeFlag);
      ((ptt_reserve.ReserveStruct)localObject).uint32_redpack_type.set(aagm.b(paramMessageForPtt));
      ((ptt_reserve.ReserveStruct)localObject).uint32_autototext_voice.set(paramMessageForPtt.autoToText);
      if (paramMessageForPtt.hasSttTxt()) {
        ((ptt_reserve.ReserveStruct)localObject).bytes_voice_text_abs.set(ByteStringMicro.copyFrom(paramMessageForPtt.sttText.getBytes()));
      }
      ByteStringMicro localByteStringMicro = aagm.a(paramMessageForPtt);
      if (localByteStringMicro != null) {
        ((ptt_reserve.ReserveStruct)localObject).bytes_redpack_score_id.set(localByteStringMicro);
      }
    }
    localObject = ((ptt_reserve.ReserveStruct)localObject).toByteArray();
    if ((QLog.isColorLevel()) && (paramMessageForPtt != null)) {
      QLog.d("pttchangevoice", 2, "change flag is " + paramMessageForPtt.voiceChangeFlag);
    }
    return localObject;
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
  
  private void e(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("/cgi-bin/httpconn?htcmd=0x6ff0071&ver=5468&term=android&ukey=");
    paramStringBuilder.append(this.mUkey);
    paramStringBuilder.append("&filesize=");
    paramStringBuilder.append(this.mFileSize);
    paramStringBuilder.append("&range=");
    paramStringBuilder.append(this.bz);
    paramStringBuilder.append("&uin=");
    paramStringBuilder.append(this.h.mSelfUin);
    paramStringBuilder.append("&groupcode=");
    paramStringBuilder.append(this.h.mPeerUin);
  }
  
  public static int eD(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramString = paramString.split("\\.");
      arrayOfByte[0] = ((byte)(Integer.parseInt(paramString[0]) & 0xFF));
      arrayOfByte[1] = ((byte)(Integer.parseInt(paramString[1]) & 0xFF));
      arrayOfByte[2] = ((byte)(Integer.parseInt(paramString[2]) & 0xFF));
      arrayOfByte[3] = ((byte)(Integer.parseInt(paramString[3]) & 0xFF));
      int i = arrayOfByte[3];
      int j = arrayOfByte[2];
      int k = arrayOfByte[1];
      int m = arrayOfByte[0];
      return m << 24 & 0xFF000000 | i & 0xFF | j << 8 & 0xFF00 | k << 16 & 0xFF0000;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private void f(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("/?ver=4679&ukey=");
    paramStringBuilder.append(this.mUkey);
    paramStringBuilder.append("&filekey=");
    paramStringBuilder.append(this.clf);
    paramStringBuilder.append("&filesize=");
    paramStringBuilder.append(this.mFileSize);
    paramStringBuilder.append("&range=");
    paramStringBuilder.append(this.bz);
    paramStringBuilder.append("&bmd5=");
    paramStringBuilder.append(this.clf);
    paramStringBuilder.append("&mType=");
    if (this.mIsGroup)
    {
      paramStringBuilder.append("pttGu");
      return;
    }
    paramStringBuilder.append("pttDu");
  }
  
  protected String AJ()
  {
    if (this.mIsGroup)
    {
      if (this.dPg == 1) {
        return "actGroupPicUploadV2";
      }
      return "actGroupPicUploadV1";
    }
    if (this.dPg == 1) {
      return "actDiscussPicUploadV2";
    }
    return "actDiscussPicUpload";
  }
  
  public int EN()
  {
    if ((!this.cMB) && (this.h.cNG) && (this.h.cNH))
    {
      dUZ();
      dDP();
    }
    while (!this.mIsPause) {
      return 0;
    }
    this.mIsPause = false;
    this.mIsCancel = false;
    VR(1002);
    if (this.dPg != 1)
    {
      this.bz = 0L;
      this.mUkey = null;
    }
    this.dPd = 0;
    this.QV = 0;
    this.dOO = 0;
    this.errCode = 0;
    this.errDesc = "";
    this.jdField_b_of_type_Auyc.initParam();
    dVp();
    this.jdField_c_of_type_Aooi.a.post(new GroupPicUploadProcessor.4(this));
    return 0;
  }
  
  public int KH()
  {
    super.KH();
    if ((!this.cMB) && (!this.h.cNF)) {
      return 0;
    }
    return KL();
  }
  
  protected int KL()
  {
    boolean bool = true;
    int j = 0;
    hM("uiParam", this.h.toString());
    int i;
    switch (this.h.mUinType)
    {
    default: 
      this.mIsGroup = false;
      if (2 == this.h.mFileType) {
        bool = false;
      }
      this.cMB = bool;
      if ((!this.cMB) && (this.h.F == null))
      {
        dN(9302, f(new Exception("message null")));
        onError();
        i = -1;
      }
      break;
    }
    label193:
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            this.mIsGroup = true;
            break;
            localObject = a();
            if ((localObject == null) || (!((aool)localObject).cNC)) {
              break label193;
            }
            i = j;
          } while (this.h.en == null);
          i = j;
        } while (!(this.h.en instanceof aool.d));
        this.cLX = ((aool.d)this.h.en).cNJ;
        return 0;
        Object localObject = this.h.dQ;
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
        if (this.cMB)
        {
          localObject = aqhq.estimateFileType((String)localObject);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            if ((((String)localObject).contains(aqhq.unKnownFileTypeMark)) || (!aqhq.rs((String)localObject)))
            {
              a(9072, (String)localObject, or((String)localObject), null);
              onError();
              new Handler(Looper.getMainLooper()).post(new GroupPicUploadProcessor.1(this));
              return -1;
            }
            this.clg = ((String)localObject);
          }
          if (l >= aopb.hn())
          {
            a(9063, (String)localObject, or((String)localObject), null);
            onError();
            return -1;
          }
        }
        else
        {
          this.clg = "amr";
        }
        i = j;
      } while (this.h.en == null);
      i = j;
    } while (!(this.h.en instanceof aool.d));
    this.cLX = ((aool.d)this.h.en).cNJ;
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
          localMessageRecord = this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
          hM("updateDb", "findmsgbyMsgId,need fix");
          break;
          if (localMessageRecord.isMultiMsg)
          {
            hM("updateDb", "is multiMsg");
            return;
          }
          if ((this.h.mFileType == 2) && ((localMessageRecord instanceof MessageForPtt)))
          {
            localObject = (MessageForPtt)localMessageRecord;
            if (!this.h.cNG) {
              ((MessageForPtt)localObject).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject).voiceType, this.h.dQ);
            }
            ((MessageForPtt)localObject).fileSize = this.mFileSize;
            ((MessageForPtt)localObject).urlAtServer = this.mFileName;
            ((MessageForPtt)localObject).itemType = 2;
            ((MessageForPtt)localObject).groupFileID = this.jdField_app_of_type_Long;
            ((MessageForPtt)localObject).groupFileKeyStr = this.clM;
            ((MessageForPtt)localObject).md5 = this.clf;
            ((MessageForPtt)localObject).serial();
            this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.b().c(this.h.mPeerUin, this.h.mUinType, localMessageRecord.uniseq, ((MessageForPtt)localObject).msgData);
            return;
          }
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).path = this.h.dQ;
            ((MessageForPic)localObject).size = this.mFileSize;
            ((MessageForPic)localObject).uuid = this.mFileName;
            ((MessageForPic)localObject).groupFileID = this.jdField_app_of_type_Long;
            ((MessageForPic)localObject).md5 = this.clf;
            ((MessageForPic)localObject).type = 1;
            ((MessageForPic)localObject).serial();
            this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.b().c(this.h.mPeerUin, this.h.mUinType, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
            return;
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localansu = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localansu == null);
    localansu.mMd5 = this.clf;
    localansu.mUuid = this.mFileName;
    localansu.filesize = this.mFileSize;
    localansu.anV = this.jdField_app_of_type_Long;
    localansu.time = localMessageRecord.time;
    ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
    this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.b().c(this.h.mPeerUin, this.h.mUinType, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
  }
  
  protected void QZ(boolean paramBoolean)
  {
    if (!paramBoolean) {
      VR(1001);
    }
    VR(1000);
    this.jdField_b_of_type_Aoko.dVw();
    VR(1001);
    Object localObject = a();
    if ((localObject != null) && (((aool)localObject).cNC))
    {
      this.mWidth = ((aool)localObject).dQJ;
      this.mHeight = ((aool)localObject).dQK;
      this.mFileSize = ((aool)localObject).aqp;
      this.bL = aqhs.hexStr2Bytes(((aool)localObject).mMd5);
      this.mFileName = ((aool)localObject).mMd5;
      this.clf = this.mFileName;
      this.jdField_b_of_type_Aoko.fileMd5 = this.mFileName;
      this.mFileName = (this.mFileName + "." + this.clg);
      this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      sendRequest();
    }
    while (!bt(this.cMB)) {
      return;
    }
    String str;
    int i;
    if (!this.cMB)
    {
      localObject = (MessageForPtt)this.h.F;
      str = this.h.dQ;
      if (localObject != null) {
        break label244;
      }
      i = 0;
      if (localObject != null) {
        break label253;
      }
    }
    label244:
    label253:
    for (long l = 0L;; l = ((MessageForPtt)localObject).fileSize)
    {
      aomq.a(str, false, false, i, l);
      this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      sendRequest();
      return;
      i = ((MessageForPtt)localObject).voiceChangeFlag;
      break;
    }
  }
  
  protected long U(long paramLong)
  {
    paramLong = this.mFileSize - paramLong;
    long l;
    if (!this.cMc)
    {
      l = this.jdField_b_of_type_Auyc.a(BaseApplication.getContext(), this.mFileSize, this.bz, -1);
      if (QLog.isColorLevel()) {
        QLog.e("GroupPicUploadProcessor", 2, "get sscm size =" + l);
      }
    }
    for (paramLong = Math.min(paramLong, l);; paramLong = Math.min(paramLong, 14600L))
    {
      paramLong = Math.min(paramLong, 131072L);
      if (QLog.isColorLevel()) {
        QLog.e("GroupPicUploadProcessor", 2, "real sscm=" + paramLong);
      }
      return paramLong;
    }
  }
  
  protected void VR(int paramInt)
  {
    super.VR(paramInt);
    if (this.isStoryPhoto) {
      axyl.d(this.jdField_c_of_type_ComTencentMobileqqDataMessageForPic, paramInt, getProgress());
    }
  }
  
  protected aoll a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = super.a(paramArrayOfByte);
    paramArrayOfByte.cMJ = true;
    paramArrayOfByte.cMJ = true;
    return paramArrayOfByte;
  }
  
  public im_msg_body.RichText a(MessageForPtt paramMessageForPtt)
  {
    im_msg_body.RichText localRichText = c();
    a(localRichText, paramMessageForPtt);
    return localRichText;
  }
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    super.a(parama, paramb);
    c(parama, paramb);
  }
  
  /* Error */
  public void aI(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 86	aokv:h	Laool;
    //   6: iconst_1
    //   7: putfield 471	aool:cNF	Z
    //   10: aload_0
    //   11: getfield 86	aokv:h	Laool;
    //   14: getfield 92	aool:F	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 203	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 212	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 206	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 830	aokv:cMo	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokevirtual 474	aokv:KL	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokevirtual 832	aokv:QZ	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokevirtual 474	aokv:KL	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokevirtual 832	aokv:QZ	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	aokv
    //   0	73	1	paramString	String
    //   0	73	2	paramInt1	int
    //   0	73	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	50	68	finally
    //   50	52	68	finally
    //   53	65	68	finally
    //   69	71	68	finally
  }
  
  /* Error */
  protected im_msg_body.RichText c()
  {
    // Byte code:
    //   0: new 198	tencent/im/msg/im_msg_body$Ptt
    //   3: dup
    //   4: invokespecial 835	tencent/im/msg/im_msg_body$Ptt:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: getfield 838	tencent/im/msg/im_msg_body$Ptt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12: iconst_4
    //   13: invokevirtual 154	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   16: aload_2
    //   17: getfield 842	tencent/im/msg/im_msg_body$Ptt:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   20: aload_0
    //   21: getfield 86	aokv:h	Laool;
    //   24: getfield 351	aool:mSelfUin	Ljava/lang/String;
    //   27: invokestatic 848	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   30: invokevirtual 853	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   33: aload_2
    //   34: getfield 856	tencent/im/msg/im_msg_body$Ptt:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   37: aload_0
    //   38: getfield 646	aokv:jdField_app_of_type_Long	J
    //   41: l2i
    //   42: invokevirtual 154	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   45: aload_0
    //   46: getfield 651	aokv:clM	Ljava/lang/String;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +23 -> 74
    //   54: aload_2
    //   55: getfield 859	tencent/im/msg/im_msg_body$Ptt:bytes_group_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   58: aload_0
    //   59: getfield 651	aokv:clM	Ljava/lang/String;
    //   62: ldc_w 861
    //   65: invokevirtual 863	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   68: invokestatic 177	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   71: invokevirtual 182	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   74: aload_0
    //   75: getfield 867	aokv:xp	Ljava/util/ArrayList;
    //   78: ifnull +50 -> 128
    //   81: aload_0
    //   82: getfield 867	aokv:xp	Ljava/util/ArrayList;
    //   85: invokevirtual 871	java/util/ArrayList:size	()I
    //   88: ifle +40 -> 128
    //   91: aload_0
    //   92: getfield 867	aokv:xp	Ljava/util/ArrayList;
    //   95: iconst_0
    //   96: invokevirtual 875	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   99: checkcast 877	aonh
    //   102: astore_3
    //   103: aload_2
    //   104: getfield 880	tencent/im/msg/im_msg_body$Ptt:uint32_server_ip	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: aload_3
    //   108: getfield 883	aonh:mIp	Ljava/lang/String;
    //   111: invokestatic 885	aokv:eD	(Ljava/lang/String;)I
    //   114: invokevirtual 154	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   117: aload_2
    //   118: getfield 888	tencent/im/msg/im_msg_body$Ptt:uint32_server_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   121: aload_3
    //   122: getfield 891	aonh:port	I
    //   125: invokevirtual 154	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   128: aload_0
    //   129: getfield 70	aokv:jdField_app_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   132: aload_0
    //   133: getfield 70	aokv:jdField_app_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   136: invokevirtual 894	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   139: invokestatic 900	anbk:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)I
    //   142: istore_1
    //   143: new 138	tencent/im/msg/im_msg_body$Elem
    //   146: dup
    //   147: invokespecial 141	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   150: astore 4
    //   152: new 902	tencent/im/msg/im_msg_body$ElemFlags2
    //   155: dup
    //   156: invokespecial 903	tencent/im/msg/im_msg_body$ElemFlags2:<init>	()V
    //   159: astore_3
    //   160: aload_3
    //   161: getfield 906	tencent/im/msg/im_msg_body$ElemFlags2:uint32_vip_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   164: iload_1
    //   165: invokevirtual 154	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   168: aload 4
    //   170: getfield 910	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   173: aload_3
    //   174: invokevirtual 911	tencent/im/msg/im_msg_body$ElemFlags2:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   177: aload_2
    //   178: getfield 915	tencent/im/msg/im_msg_body$Ptt:bool_valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   181: iconst_1
    //   182: invokevirtual 919	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   185: aload_2
    //   186: getfield 922	tencent/im/msg/im_msg_body$Ptt:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   189: aload_0
    //   190: getfield 338	aokv:mFileSize	J
    //   193: l2i
    //   194: invokevirtual 154	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   197: aload_2
    //   198: getfield 925	tencent/im/msg/im_msg_body$Ptt:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   201: aload_0
    //   202: getfield 749	aokv:bL	[B
    //   205: invokestatic 177	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   208: invokevirtual 182	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   211: aload_2
    //   212: getfield 928	tencent/im/msg/im_msg_body$Ptt:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: aload_0
    //   216: getfield 638	aokv:mFileName	Ljava/lang/String;
    //   219: invokestatic 932	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   222: invokevirtual 182	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   225: aload_0
    //   226: getfield 86	aokv:h	Laool;
    //   229: getfield 92	aool:F	Lcom/tencent/mobileqq/data/MessageRecord;
    //   232: checkcast 203	com/tencent/mobileqq/data/MessageForPtt
    //   235: invokestatic 934	aokv:b	(Lcom/tencent/mobileqq/data/MessageForPtt;)[B
    //   238: astore_3
    //   239: aload_3
    //   240: ifnull +14 -> 254
    //   243: aload_2
    //   244: getfield 937	tencent/im/msg/im_msg_body$Ptt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   247: aload_3
    //   248: invokestatic 177	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   251: invokevirtual 182	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   254: new 192	tencent/im/msg/im_msg_body$RichText
    //   257: dup
    //   258: invokespecial 938	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   261: astore_3
    //   262: aload_3
    //   263: getfield 196	tencent/im/msg/im_msg_body$RichText:ptt	Ltencent/im/msg/im_msg_body$Ptt;
    //   266: aload_2
    //   267: invokevirtual 939	tencent/im/msg/im_msg_body$Ptt:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   270: aload_3
    //   271: getfield 943	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   274: aload 4
    //   276: invokevirtual 948	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   279: aload_0
    //   280: invokespecial 950	aokv:a	()Ltencent/im/msg/im_msg_body$Elem;
    //   283: astore 4
    //   285: aload_3
    //   286: astore_2
    //   287: aload_3
    //   288: ifnull +48 -> 336
    //   291: aload_3
    //   292: astore_2
    //   293: aload_3
    //   294: getfield 943	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   297: ifnull +39 -> 336
    //   300: aload_3
    //   301: astore_2
    //   302: aload 4
    //   304: ifnull +32 -> 336
    //   307: aload_3
    //   308: getfield 943	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   311: aload 4
    //   313: invokevirtual 948	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   316: aload_3
    //   317: astore_2
    //   318: invokestatic 269	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +15 -> 336
    //   324: ldc_w 782
    //   327: iconst_2
    //   328: ldc_w 952
    //   331: invokestatic 786	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: aload_3
    //   335: astore_2
    //   336: aload_2
    //   337: areturn
    //   338: astore_3
    //   339: aconst_null
    //   340: astore_2
    //   341: invokestatic 269	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq -8 -> 336
    //   347: ldc_w 782
    //   350: iconst_2
    //   351: ldc_w 954
    //   354: aload_3
    //   355: invokestatic 957	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   358: aconst_null
    //   359: areturn
    //   360: astore_3
    //   361: goto -287 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	this	aokv
    //   142	23	1	i	int
    //   7	334	2	localObject1	Object
    //   49	286	3	localObject2	Object
    //   338	17	3	localException	Exception
    //   360	1	3	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   150	162	4	localElem	im_msg_body.Elem
    // Exception table:
    //   from	to	target	type
    //   0	50	338	java/lang/Exception
    //   54	74	338	java/lang/Exception
    //   74	128	338	java/lang/Exception
    //   128	239	338	java/lang/Exception
    //   243	254	338	java/lang/Exception
    //   254	285	338	java/lang/Exception
    //   293	300	338	java/lang/Exception
    //   307	316	338	java/lang/Exception
    //   318	334	338	java/lang/Exception
    //   54	74	360	java/io/UnsupportedEncodingException
  }
  
  protected void c(aoql.a parama, aoql.b paramb)
  {
    this.jdField_a_of_type_Aoql$a = null;
    int i;
    if (paramb != null)
    {
      i = 0;
      if (i < paramb.Hf.size())
      {
        parama = (aoql.b.m)paramb.Hf.get(i);
        if (QLog.isColorLevel()) {
          hM("procUrl", parama.toString());
        }
        this.cLU = parama.cOc;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.cLU);
        }
        a(this.jdField_a_of_type_Aojn$a, parama);
        if ((parama instanceof aoql.b.e))
        {
          parama = (aoql.b.e)parama;
          if (parama.result != 0) {
            break label297;
          }
          QU(parama.isExist);
          if (!parama.isExist) {
            break label204;
          }
          if (QLog.isColorLevel()) {
            QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp GroupPicUpResp.isExist.");
          }
          this.cMe = true;
          this.jdField_b_of_type_Aoko.transferedSize = this.jdField_b_of_type_Aoko.fileSize;
          this.jdField_app_of_type_Long = parama.groupFileID;
          this.xp = parama.xp;
          dDP();
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      label204:
      VR(1002);
      if (!azN()) {
        return;
      }
      this.jdField_app_of_type_Long = parama.groupFileID;
      this.mUkey = parama.mUkey;
      this.xp = parama.xp;
      this.bz = parama.transferedSize;
      this.apx = parama.blockSize;
      this.apw = parama.startOffset;
      this.dPg = 1;
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> About to submit Transaction , from onBusiProtoResp.");
      }
      dVn();
    }
    label297:
    log("<BDH_LOG> onBusiProtoResp() error : " + parama.result + " ,select HTTP channel");
    this.dPg = 2;
    onError();
  }
  
  public int cancel()
  {
    AppNetConnInfo.unregisterNetEventHandler(this);
    return super.cancel();
  }
  
  protected im_msg_body.RichText d()
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject4 = new im_msg_body.CustomFace();
        ((im_msg_body.CustomFace)localObject4).uint32_file_id.set((int)this.jdField_app_of_type_Long);
        if ((this.xp != null) && (this.xp.size() > 0))
        {
          localObject1 = (aonh)this.xp.get(0);
          ((im_msg_body.CustomFace)localObject4).uint32_server_ip.set(eD(((aonh)localObject1).mIp));
          ((im_msg_body.CustomFace)localObject4).uint32_server_port.set(((aonh)localObject1).port);
        }
        dUV();
        ((im_msg_body.CustomFace)localObject4).uint32_file_type.set(Integer.valueOf(66).intValue());
        ((im_msg_body.CustomFace)localObject4).uint32_useful.set(1);
        if (this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getSessionKey() != null) {
          ((im_msg_body.CustomFace)localObject4).bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getSessionKey()));
        }
        ((im_msg_body.CustomFace)localObject4).bytes_md5.set(ByteStringMicro.copyFrom(this.bL));
        ((im_msg_body.CustomFace)localObject4).str_file_path.set(this.mFileName);
        Object localObject1 = ((im_msg_body.CustomFace)localObject4).uint32_origin;
        if (!this.cLX) {
          break label999;
        }
        i = 1;
        ((PBUInt32Field)localObject1).set(i);
        localObject5 = this.h.F;
        if (MessageForPic.class.isInstance(localObject5))
        {
          localObject3 = (MessageForPic)localObject5;
          ((im_msg_body.CustomFace)localObject4).uint32_show_len.set(((MessageForPic)localObject3).mShowLength);
          ((im_msg_body.CustomFace)localObject4).uint32_download_len.set(((MessageForPic)localObject3).mDownloadLength);
          ((im_msg_body.CustomFace)localObject4).image_type.set(((MessageForPic)localObject3).imageType);
          if (((MessageForPic)localObject3).picExtraData != null)
          {
            localObject1 = ((MessageForPic)localObject3).picExtraData.getCustomFaceResvAttr();
            ((CustomFaceExtPb.ResvAttr)localObject1).uint32_source.set(c((MessageForPic)localObject3));
            ((im_msg_body.CustomFace)localObject4).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)((CustomFaceExtPb.ResvAttr)localObject1).get()).toByteArray()), true);
          }
        }
        else
        {
          ((im_msg_body.CustomFace)localObject4).biz_type.set(KJ());
          ((im_msg_body.CustomFace)localObject4).uint32_width.set(this.mWidth);
          ((im_msg_body.CustomFace)localObject4).uint32_height.set(this.mHeight);
          ((im_msg_body.CustomFace)localObject4).uint32_size.set((int)this.mFileSize);
          ((im_msg_body.CustomFace)localObject4).uint32_source.set(KN());
          if (QLog.isColorLevel()) {
            hM("busiTypeStat", "uiBusiType:" + this.h.mBusiType + " protoBusiType:" + ((im_msg_body.CustomFace)localObject4).biz_type.get());
          }
          localObject3 = new im_msg_body.RichText();
          localObject1 = new im_msg_body.Elem();
          if (!acfx.W((MessageRecord)localObject5)) {
            break label817;
          }
          ((im_msg_body.Elem)localObject1).hc_flash_pic.set((MessageMicro)localObject4);
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject1);
          localObject1 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8(acfp.m(2131707041)));
          localObject4 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject4).text.set((MessageMicro)localObject1);
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject4);
          localObject1 = this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
          if ((localObject1 instanceof MessageForStructing))
          {
            localObject4 = (MessageForStructing)localObject1;
            if ((((MessageForStructing)localObject4).structingMsg != null) && ((((MessageForStructing)localObject4).structingMsg instanceof StructMsgForImageShare)))
            {
              localObject6 = (StructMsgForImageShare)((MessageForStructing)localObject4).structingMsg;
              localObject5 = ((StructMsgForImageShare)localObject6).getFirstImageElement();
              if (localObject5 != null)
              {
                ((ansu)localObject5).mMd5 = this.clf;
                ((ansu)localObject5).mUuid = this.mFileName;
                ((ansu)localObject5).anV = this.jdField_app_of_type_Long;
                ((ansu)localObject5).time = ((MessageRecord)localObject1).time;
                ((ansu)localObject5).filesize = this.mFileSize;
                if (!xtj.hR(((StructMsgForImageShare)localObject6).mMsgActionData)) {
                  break label985;
                }
                localObject6 = ((ansu)localObject5).cij;
                ((ansu)localObject5).cij = "";
                localObject1 = ((MessageForStructing)localObject4).structingMsg.getXmlBytes();
                ((ansu)localObject5).cij = ((String)localObject6);
                if ((!TextUtils.isEmpty(((MessageForStructing)localObject4).frienduin)) && (localObject1 != null))
                {
                  localObject4 = new im_msg_body.RichMsg();
                  ((im_msg_body.RichMsg)localObject4).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
                  localObject1 = new im_msg_body.Elem();
                  ((im_msg_body.Elem)localObject1).rich_msg.set((MessageMicro)localObject4);
                  ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject1);
                }
              }
            }
          }
          localObject1 = a();
          if ((localObject3 == null) || (((im_msg_body.RichText)localObject3).elems == null) || (localObject1 == null)) {
            break label997;
          }
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject1);
          if (!QLog.isColorLevel()) {
            break label997;
          }
          QLog.e("GroupPicUploadProcessor", 2, "QQ 18 constructPicRichText add richtext common_elem headid and type");
          break label997;
        }
        localObject1 = new CustomFaceExtPb.ResvAttr();
        continue;
        if (!acei.W((MessageRecord)localObject5)) {
          break label965;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GroupPicUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      label817:
      Object localObject5 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject5).uint32_service_type.set(3);
      Object localObject6 = new hummer_commelem.MsgElemInfo_servtype3();
      ((hummer_commelem.MsgElemInfo_servtype3)localObject6).flash_troop_pic.set((MessageMicro)localObject4);
      ((im_msg_body.CommonElem)localObject5).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype3)localObject6).toByteArray()));
      localException.common_elem.set((MessageMicro)localObject5);
      ((im_msg_body.RichText)localObject3).elems.add(localException);
      if (QLog.isColorLevel()) {
        QLog.d("flash", 2, "GroupPicUploadProcessor constructPicRichText send flash");
      }
      Object localObject2 = new im_msg_body.Text();
      ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(acfp.m(2131707040)));
      Object localObject4 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject4).text.set((MessageMicro)localObject2);
      ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject4);
      continue;
      label965:
      ((im_msg_body.Elem)localObject2).custom_face.set((MessageMicro)localObject4);
      ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject2);
      continue;
      label985:
      localObject2 = ((MessageForStructing)localObject4).structingMsg.getXmlBytes();
      continue;
      label997:
      return localObject3;
      label999:
      int i = 0;
    }
  }
  
  void dDP()
  {
    if (!azR())
    {
      log("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.dPg);
      return;
    }
    this.jdField_c_of_type_Aojn$a.dVf();
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    dVF();
  }
  
  void dVF()
  {
    if ((!this.cMb) || (this.h.cND))
    {
      if (this.h.cND) {
        ((MessageForPic)this.h.F).mPresendTransferedSize = this.bz;
      }
      localObject1 = d();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_Aojn$a);
        onError();
      }
      for (;;)
      {
        if ((this.h.cND) && (this.cMe)) {
          ((MessageForPic)this.h.F).mPresendTransferedSize = 0L;
        }
        dUW();
        onSuccess();
        return;
        if (!azQ())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_Aojn$a);
          onError();
          return;
        }
        if (this.h.b != null) {
          this.h.b.a((im_msg_body.RichText)localObject1);
        }
      }
    }
    Object localObject2 = d();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_Aojn$a);
      onError();
      return;
    }
    if (!azQ())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_Aojn$a);
      onError();
      return;
    }
    if (this.h.b != null)
    {
      localObject1 = this.h.b.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label402;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label375;
      }
    }
    label375:
    for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
    {
      a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Aojn$a);
      onError();
      return;
      if (this.h.F != null)
      {
        localObject1 = this.h.F;
        break;
      }
      localObject1 = this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
      break;
    }
    label402:
    if ((localObject1 instanceof MessageForPic))
    {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
      ((MessageForPic)localObject1).size = this.mFileSize;
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    dUW();
    ((ambj)this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).b((MessageRecord)localObject1, this.e, this);
  }
  
  public void dVG()
  {
    if (this.mIsCancel) {
      return;
    }
    if ((this.mUkey != null) && (this.jdField_app_of_type_Long != 0L))
    {
      if (this.bz >= this.mFileSize)
      {
        dDP();
        return;
      }
      if ((this.dPg == 1) && (this.mTrans != null))
      {
        log("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
        this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().resumeTransactionTask(this.mTrans);
        return;
      }
      start();
      return;
    }
    start();
  }
  
  protected void dVe()
  {
    int i = this.h.mFileType;
    if ((this.jdField_a_of_type_Aomg instanceof aoll))
    {
      if (!this.mIsGroup) {
        break label58;
      }
      if (i != 2) {
        break label31;
      }
    }
    label31:
    label58:
    while (i == 2)
    {
      return;
      ((aoll)this.jdField_a_of_type_Aomg).bZ = MsfSdkUtils.insertMtype("picGu", ((aoll)this.jdField_a_of_type_Aomg).bZ);
      return;
    }
    ((aoll)this.jdField_a_of_type_Aomg).bZ = MsfSdkUtils.insertMtype("picDu", ((aoll)this.jdField_a_of_type_Aomg).bZ);
  }
  
  public void dVn()
  {
    if (this.startTime == -1L) {
      this.startTime = SystemClock.uptimeMillis();
    }
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit:sendFile:" + this.mTrans + "  this:" + this);
    }
    if (this.mTrans != null) {}
    int i;
    do
    {
      return;
      this.jdField_b_of_type_Aojn$a.dVf();
      Object localObject = aqhs.hexStr2Bytes(this.mUkey);
      aokw localaokw = new aokw(this);
      this.mTrans = new Transaction(this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 2, this.h.dQ, (int)this.apw, (byte[])localObject, this.bL, localaokw);
      localObject = new aokx(this);
      this.mTrans.cbForReport = ((ITransCallbackForReport)localObject);
      i = this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.h.mUniseq + " MD5:" + this.clf + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:" + 2);
      }
    } while (i == 0);
    a(i, "SubmitError.", "", this.jdField_b_of_type_Aojn$a);
    onError();
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
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
      }
      if (!paramBoolean)
      {
        localObject2 = (String)this.mM.get("param_reason");
        if (!"connError_unreachable".equalsIgnoreCase((String)localObject2)) {
          break label351;
        }
        this.mM.put("param_reason", "N_1");
      }
      while (this.h.mBusiType == 1030)
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
        label351:
        if ("connError_noroute".equalsIgnoreCase((String)localObject2)) {
          this.mM.put("param_reason", "N_2");
        }
      }
      if ((!paramBoolean) && (aona.lQ(this.errCode)))
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
      }
      if ((this.cLT) || ((paramBoolean) && ((this.dOZ & 0x2) > 0)) || ((!paramBoolean) && ((this.dOZ & 0x1) > 0)))
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
      }
      int j = this.dOZ;
      label504:
      long l1;
      label512:
      long l2;
      if (paramBoolean)
      {
        i = 2;
        this.dOZ = (i | j);
        if ((!this.cMB) && (!TextUtils.isEmpty(this.h.dQ)))
        {
          localObject2 = (MessageForPtt)this.h.F;
          String str = this.h.dQ;
          if (localObject2 != null) {
            break label964;
          }
          i = 0;
          if (localObject2 != null) {
            break label973;
          }
          l1 = 0L;
          aomq.a(str, true, paramBoolean, i, l1);
        }
        this.mEndTime = System.currentTimeMillis();
        l1 = System.nanoTime();
        l2 = (l1 - this.mStartTime) / 1000000L;
        Log.i("AutoMonitor", "SendGrpPic, cost=" + (this.jdField_b_of_type_Aojn$a.finishTime - this.jdField_b_of_type_Aojn$a.startTime) / 1000000L);
        this.mM.put("param_step", localObject1);
        this.mM.put("param_grpUin", this.h.mPeerUin);
        this.mM.put("param_fileid", String.valueOf(this.jdField_app_of_type_Long));
        this.mM.put("param_picmd5", this.mFileName);
        this.mM.put("param_isPresend", this.h.cND + "");
        this.mM.put("param_isSecondTrans", this.cMe + "");
        this.mM.put("param_PhoneType", zsz.getDeviceType() + "");
        this.mM.put("param_NetType", aqiw.getSystemNetwork(BaseApplication.getContext()) + "");
        this.mM.put("param_IsRawPic", this.cLX + "");
        this.mM.put("param_uinType", String.valueOf(this.h.mUinType));
        this.mM.put("param_quickHttp", String.valueOf(this.cLU));
        this.mM.put("param_picType", String.valueOf(this.dPe));
        this.mM.put("param_busi", String.valueOf(this.h.mBusiType));
        localObject1 = this.mM;
        if (!this.h.isQzonePic) {
          break label983;
        }
      }
      label964:
      label973:
      label983:
      for (int i = 1;; i = 0)
      {
        ((HashMap)localObject1).put("param_source_type", String.valueOf(i));
        QX(paramBoolean);
        e(paramBoolean, l2, l1);
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
        i = 1;
        break;
        i = ((MessageForPtt)localObject2).voiceChangeFlag;
        break label504;
        l1 = ((MessageForPtt)localObject2).fileSize;
        break label512;
      }
    }
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
          QLog.d("GroupPicUploadProcessor", 2, "doReport ,mStartTime = " + this.mStartTime + ",mEnterAioTime = " + this.apy + ",finishTime  = " + paramLong2 + ", aioDuration = " + l + ", duration = " + paramLong1 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.h.cvb + ",Percent = " + d);
        }
      }
      P(true, paramLong1);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), true, paramLong1, this.mFileSize, this.mM, "");
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
      this.mM.put("param_uniseq", String.valueOf(this.h.mUniseq));
      P(false, paramLong1);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), false, paramLong1, this.mFileSize, this.mM, "");
    }
  }
  
  public long hh()
  {
    if ((this.cMB) || (this.h.cNF)) {
      return super.hh();
    }
    return 7000L;
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
    if (this.h.cNG) {
      alit.a(this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface).Oj(getKey());
    }
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.timeStamp > 0L) {
        this.apG += System.nanoTime() - this.timeStamp;
      }
    }
    for (this.timeStamp = 0L;; this.timeStamp = System.nanoTime())
    {
      this.cMp = true;
      return;
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (this.h.b != null)
    {
      localObject = new akyf.a();
      ((akyf.a)localObject).size = this.mFileSize;
      ((akyf.a)localObject).md5 = this.clf;
      ((akyf.a)localObject).uuid = this.mFileName;
      ((akyf.a)localObject).path = this.h.dQ;
      ((akyf.a)localObject).groupFileID = this.jdField_app_of_type_Long;
      if (this.h.cNI) {
        ((akyf.a)localObject).data = ad();
      }
      this.h.b.b((akyf.a)localObject);
      VR(1003);
      if (!this.cMB) {
        if (this.h.F == null) {
          break label224;
        }
      }
    }
    label224:
    for (Object localObject = this.h.F;; localObject = this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq))
    {
      if ((localObject != null) && ((localObject instanceof MessageForPtt)) && (((anvq)this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17)).m((MessageForPtt)localObject)))
      {
        anot.a(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
        ((anvq)this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17)).b((MessageForPtt)localObject, 2);
      }
      return;
      QV(true);
      break;
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
      this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().stopTransactionTask(this.mTrans);
      return;
    }
    log("<BDH_LOG> pause() pause BDH channel, but trans == null");
  }
  
  protected void sendRequest()
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    aoql.a locala = new aoql.a();
    Object localObject1;
    Object localObject2;
    if (this.cMB)
    {
      localObject1 = new aoql.a.i();
      ((aoql.a.i)localObject1).fileName = this.mFileName;
      ((aoql.a.i)localObject1).fileSize = this.mFileSize;
      ((aoql.a.i)localObject1).md5 = this.bL;
      ((aoql.a.i)localObject1).width = this.mWidth;
      ((aoql.a.i)localObject1).height = this.mHeight;
      ((aoql.a.i)localObject1).cMs = this.cLX;
      ((aoql.a.i)localObject1).busiType = this.h.mBusiType;
      a((aoql.a.i)localObject1);
      localObject2 = this.h.F;
      if (MessageForPic.class.isInstance(localObject2))
      {
        ((aoql.a.i)localObject1).picType = ((MessageForPic)localObject2).imageType;
        this.dPe = ((MessageForPic)localObject2).imageType;
      }
      ((aoql.a.k)localObject1).selfUin = this.h.mSelfUin;
      ((aoql.a.k)localObject1).peerUin = this.h.mPeerUin;
      ((aoql.a.k)localObject1).cmC = this.h.cmn;
      ((aoql.a.k)localObject1).uinType = this.h.mUinType;
      if (this.h.mUinType == 1026)
      {
        ((aoql.a.k)localObject1).uinType = 1;
        if (QLog.isColorLevel()) {
          QLog.i("PttShow", 2, "sendRequest, UIN_TYPE_HOTCHAT_TOPIC");
        }
      }
      locala.b = this;
      if (!this.cMB) {
        break label359;
      }
      localObject2 = "grp_pic_up";
      label227:
      locala.cmy = ((String)localObject2);
      locala.He.add(localObject1);
      locala.a = this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (azQ()) {
        break label366;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
      onError();
    }
    label359:
    label366:
    do
    {
      return;
      localObject1 = new aoql.a.j();
      ((aoql.a.j)localObject1).fileName = this.mFileName;
      ((aoql.a.j)localObject1).fileSize = ((int)this.mFileSize);
      ((aoql.a.j)localObject1).md5 = this.bL;
      ((aoql.a.j)localObject1).voiceLength = QQRecorder.n(this.h.F);
      ((aoql.a.j)localObject1).audioPanelType = this.h.dQL;
      ((aoql.a.j)localObject1).voiceType = ((MessageForPtt)this.h.F).voiceType;
      break;
      localObject2 = "grp_ptt_up";
      break label227;
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
    if ((!this.cMB) && (!this.h.cNF))
    {
      if (aqxp.a(this.h.dQ, this)) {
        try
        {
          if (this.cMo)
          {
            VR(1001);
            this.cMo = true;
          }
          return;
        }
        finally {}
      }
      if (KL() == 0) {
        QZ(false);
      }
    }
    else
    {
      QZ(false);
    }
  }
  
  protected String z(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    Object localObject = (aonh)this.xp.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(((aonh)localObject).mIp);
    if (((aonh)localObject).port != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(((aonh)localObject).port);
    }
    if (!this.cMB) {
      f(paramArrayOfByte);
    }
    for (;;)
    {
      if (!this.cMB)
      {
        localObject = (MessageForPtt)this.h.F;
        paramArrayOfByte.append("&voice_codec=" + ((MessageForPtt)localObject).voiceType);
      }
      paramArrayOfByte = j(paramArrayOfByte.toString(), this.xp);
      aojn.m(this.Ha, this.xp);
      return paramArrayOfByte;
      e(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aokv
 * JD-Core Version:    0.7.0.1
 */