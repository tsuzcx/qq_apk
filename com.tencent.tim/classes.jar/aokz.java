import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.GroupPttUploadProcessor.4;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpPttReq;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;

public class aokz
  extends aojr
  implements aqxt.a, INetEventHandler
{
  private long apG;
  long jdField_app_of_type_Long;
  QQAppInterface jdField_app_of_type_ComTencentMobileqqAppQQAppInterface;
  aooi c;
  private boolean cMo;
  private boolean cMp;
  String clM;
  private String cli;
  achq e = new aolc(this);
  boolean mIsGroup = true;
  private long timeStamp;
  
  public aokz(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    this.jdField_c_of_type_Aooi = paramaooi;
    this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.app);
    AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
  }
  
  private void Ra(boolean paramBoolean)
  {
    String str = "Q.richmedia." + aonc.fG(this.h.mUinType) + "." + aonc.gC(this.h.mFileType);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:" + this.h.mUniseq + "  ");
    localStringBuilder.append("errCode:" + this.errCode + "  ");
    localStringBuilder.append("errDesc:" + this.errDesc);
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  private aoql.a.j a()
  {
    aoql.a.j localj = new aoql.a.j();
    localj.fileName = this.mFileName;
    localj.fileSize = ((int)this.mFileSize);
    localj.md5 = this.bL;
    localj.voiceLength = QQRecorder.n(this.h.F);
    localj.audioPanelType = this.h.dQL;
    localj.voiceType = ((MessageForPtt)this.h.F).voiceType;
    localj.selfUin = this.h.mSelfUin;
    localj.peerUin = this.h.mPeerUin;
    localj.cmC = this.h.cmn;
    localj.uinType = this.h.mUinType;
    if (this.h.mUinType == 1026)
    {
      localj.uinType = 1;
      if (QLog.isColorLevel()) {
        QLog.i("PttShow", 2, "sendRequest, UIN_TYPE_HOTCHAT_TOPIC");
      }
    }
    return localj;
  }
  
  private void a(im_msg_body.RichText paramRichText, MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt != null) && (paramRichText != null))
    {
      paramRichText.ptt.uint32_format.set(paramMessageForPtt.voiceType);
      paramRichText.ptt.uint32_time.set(aqft.ag(paramMessageForPtt.voiceLength));
    }
  }
  
  private byte[] b(MessageForPtt paramMessageForPtt)
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
  
  private void dVI()
  {
    if (this.h.cNG)
    {
      this.jdField_a_of_type_Aojn$a.lF(this.mStartTime);
      this.jdField_b_of_type_Aojn$a.lF(this.mStartTime);
    }
  }
  
  private void dVJ()
  {
    String str;
    if (this.errCode == 9004)
    {
      str = (String)this.mM.get("param_reason");
      if (!"connError_unreachable".equalsIgnoreCase(str)) {
        break label49;
      }
      this.mM.put("param_reason", "N_1");
    }
    label49:
    while (!"connError_noroute".equalsIgnoreCase(str)) {
      return;
    }
    this.mM.put("param_reason", "N_2");
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
    if (this.mIsGroup) {
      return "actGrpPttUp";
    }
    return "actDisscusPttUp";
  }
  
  public int EN()
  {
    if ((this.h.cNG) && (this.h.cNH))
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
    if (this.dPg != 1) {
      this.mUkey = null;
    }
    this.dPd = 0;
    this.QV = 0;
    this.dOO = 0;
    this.errCode = 0;
    this.errDesc = "";
    dVp();
    this.jdField_c_of_type_Aooi.a.post(new GroupPttUploadProcessor.4(this));
    return 0;
  }
  
  public int KH()
  {
    super.KH();
    if (!this.h.cNF) {
      return 0;
    }
    return KL();
  }
  
  protected int KL()
  {
    hM("uiParam", this.h.toString());
    switch (this.h.mUinType)
    {
    }
    for (this.mIsGroup = false; this.h.F == null; this.mIsGroup = true)
    {
      dN(9302, f(new Exception("message null")));
      onError();
      return -1;
    }
    String str = this.h.dQ;
    if (TextUtils.isEmpty(str))
    {
      dN(9302, f(new Exception("filePath null")));
      onError();
      return -1;
    }
    File localFile = new File(str);
    if (!localFile.exists())
    {
      dN(9042, f(new Exception("sendFile not exist " + str)));
      onError();
      return -1;
    }
    if (!localFile.canRead())
    {
      dN(9070, f(new Exception("sendFile not readable " + this.jdField_b_of_type_Aoko.filePath)));
      onError();
      return -1;
    }
    this.cli = str;
    long l = localFile.length();
    this.jdField_b_of_type_Aoko.fileSize = l;
    this.mFileSize = l;
    if (l <= 0L)
    {
      dN(9071, f(new Exception("file size 0 " + str)));
      onError();
      return -1;
    }
    this.clg = "amr";
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
    label316:
    ansu localansu;
    do
    {
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
            if ((this.h.mFileType != 2) || (!(localMessageRecord instanceof MessageForPtt))) {
              break label316;
            }
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
          } while ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForPtt)) || (!((anvq)this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17)).m((MessageForPtt)localMessageRecord)));
          anot.a(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
          ((anvo)this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17)).b((MessageForPtt)localMessageRecord, 2);
          return;
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
    if ((this.bL == null) && (!azT()))
    {
      onError();
      return;
    }
    if (this.mRaf == null) {
      try
      {
        this.mRaf = new RandomAccessFile(this.h.dQ, "r");
        if (this.mRaf == null)
        {
          dN(9303, "read file error");
          onError();
          return;
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
    MessageForPtt localMessageForPtt = (MessageForPtt)this.h.F;
    String str = this.h.dQ;
    int i;
    if (localMessageForPtt == null)
    {
      i = 0;
      if (localMessageForPtt != null) {
        break label184;
      }
    }
    label184:
    for (long l = 0L;; l = localMessageForPtt.fileSize)
    {
      aomq.a(str, false, false, i, l);
      this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      dVt();
      return;
      i = localMessageForPtt.voiceChangeFlag;
      break;
    }
  }
  
  public im_msg_body.RichText a(MessageForPtt paramMessageForPtt)
  {
    im_msg_body.RichText localRichText = c();
    a(localRichText, paramMessageForPtt);
    return localRichText;
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 713	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 5
    //   5: new 715	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   8: dup
    //   9: invokespecial 716	tencent/im/cs/cmd0x388/cmd0x388$RspBody:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 720	tencent/im/cs/cmd0x388/cmd0x388$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16: checkcast 715	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   19: getfield 724	tencent/im/cs/cmd0x388/cmd0x388$RspBody:rpt_msg_tryup_ptt_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   22: invokevirtual 729	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +12 -> 39
    //   30: aload_1
    //   31: invokeinterface 733 1 0
    //   36: ifne +366 -> 402
    //   39: new 465	java/lang/Exception
    //   42: dup
    //   43: ldc_w 735
    //   46: invokespecial 470	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   49: athrow
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 736	java/lang/Exception:printStackTrace	()V
    //   55: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +14 -> 72
    //   61: ldc_w 738
    //   64: iconst_2
    //   65: ldc_w 740
    //   68: aload_1
    //   69: invokestatic 743	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   72: aload_2
    //   73: ldc_w 745
    //   76: invokevirtual 337	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 278	java/lang/String
    //   82: invokestatic 751	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   85: invokevirtual 754	java/lang/Long:longValue	()J
    //   88: lstore 7
    //   90: aload_2
    //   91: ldc_w 756
    //   94: invokevirtual 337	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast 278	java/lang/String
    //   100: invokestatic 751	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   103: invokevirtual 754	java/lang/Long:longValue	()J
    //   106: lstore 9
    //   108: aload_2
    //   109: ldc_w 758
    //   112: invokevirtual 337	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: checkcast 278	java/lang/String
    //   118: invokestatic 751	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   121: invokevirtual 754	java/lang/Long:longValue	()J
    //   124: lstore 11
    //   126: aload_2
    //   127: ldc_w 760
    //   130: invokevirtual 337	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   133: checkcast 278	java/lang/String
    //   136: invokestatic 751	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   139: invokevirtual 754	java/lang/Long:longValue	()J
    //   142: lstore 13
    //   144: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +68 -> 215
    //   150: ldc_w 738
    //   153: iconst_2
    //   154: new 64	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 762
    //   164: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: lload 5
    //   169: lload_3
    //   170: lsub
    //   171: invokevirtual 113	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   174: ldc_w 764
    //   177: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: getfield 357	aokz:jdField_b_of_type_Aoko	Laoko;
    //   184: getfield 515	aoko:fileSize	J
    //   187: invokevirtual 113	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   190: ldc_w 766
    //   193: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_2
    //   197: ldc_w 768
    //   200: invokevirtual 337	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   203: checkcast 278	java/lang/String
    //   206: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload_0
    //   216: aload_2
    //   217: invokevirtual 771	aokz:I	(Ljava/util/HashMap;)V
    //   220: aload_0
    //   221: getfield 324	aokz:jdField_b_of_type_Aojn$a	Laojn$a;
    //   224: invokevirtual 774	aojn$a:dVg	()V
    //   227: aload_0
    //   228: getfield 324	aokz:jdField_b_of_type_Aojn$a	Laojn$a;
    //   231: iconst_1
    //   232: putfield 777	aojn$a:result	I
    //   235: aload_0
    //   236: aload_0
    //   237: getfield 145	aokz:mFileSize	J
    //   240: putfield 780	aokz:bz	J
    //   243: aload_0
    //   244: monitorenter
    //   245: aload_0
    //   246: getfield 77	aokz:h	Laool;
    //   249: getfield 310	aool:cNG	Z
    //   252: ifeq +13 -> 265
    //   255: aload_0
    //   256: getfield 77	aokz:h	Laool;
    //   259: getfield 399	aool:cNH	Z
    //   262: ifeq +209 -> 471
    //   265: aload_0
    //   266: invokevirtual 405	aokz:dDP	()V
    //   269: aload_0
    //   270: getfield 357	aokz:jdField_b_of_type_Aoko	Laoko;
    //   273: invokevirtual 666	aoko:dVw	()V
    //   276: aload_0
    //   277: getfield 77	aokz:h	Laool;
    //   280: getfield 310	aool:cNG	Z
    //   283: ifeq +33 -> 316
    //   286: invokestatic 783	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   289: ifeq +13 -> 302
    //   292: ldc_w 785
    //   295: iconst_4
    //   296: ldc_w 787
    //   299: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: aload_0
    //   303: getfield 47	aokz:jdField_app_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   306: invokestatic 792	alit:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lalit;
    //   309: aload_0
    //   310: invokevirtual 795	aokz:getKey	()Ljava/lang/String;
    //   313: invokevirtual 798	alit:Oj	(Ljava/lang/String;)V
    //   316: aload_0
    //   317: monitorexit
    //   318: new 800	com/tencent/mobileqq/transfile/GroupPttUploadProcessor$1
    //   321: dup
    //   322: aload_0
    //   323: lload 7
    //   325: lload 9
    //   327: lload 11
    //   329: lload 13
    //   331: invokespecial 803	com/tencent/mobileqq/transfile/GroupPttUploadProcessor$1:<init>	(Laokz;JJJJ)V
    //   334: iconst_5
    //   335: aconst_null
    //   336: iconst_1
    //   337: invokestatic 808	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   340: aload_0
    //   341: getfield 357	aokz:jdField_b_of_type_Aoko	Laoko;
    //   344: invokevirtual 666	aoko:dVw	()V
    //   347: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq +13 -> 363
    //   353: ldc_w 738
    //   356: iconst_2
    //   357: ldc_w 810
    //   360: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload_0
    //   364: ldc_w 812
    //   367: iconst_1
    //   368: iconst_0
    //   369: aload_2
    //   370: ldc_w 814
    //   373: invokevirtual 337	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   376: checkcast 278	java/lang/String
    //   379: aload_2
    //   380: ldc_w 816
    //   383: invokevirtual 337	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   386: checkcast 278	java/lang/String
    //   389: aload_0
    //   390: getfield 570	aokz:clf	Ljava/lang/String;
    //   393: aload_0
    //   394: getfield 817	aokz:mUuid	Ljava/lang/String;
    //   397: aconst_null
    //   398: invokevirtual 820	aokz:a	(Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   401: return
    //   402: aload_1
    //   403: iconst_0
    //   404: invokeinterface 823 2 0
    //   409: checkcast 825	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp
    //   412: astore_1
    //   413: aload_1
    //   414: getfield 829	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:uint64_fileid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   417: invokevirtual 834	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   420: ifeq +14 -> 434
    //   423: aload_0
    //   424: aload_1
    //   425: getfield 829	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:uint64_fileid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   428: invokevirtual 836	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   431: putfield 559	aokz:jdField_app_of_type_Long	J
    //   434: aload_1
    //   435: getfield 839	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:bytes_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   438: invokevirtual 840	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   441: ifeq -369 -> 72
    //   444: aload_0
    //   445: new 278	java/lang/String
    //   448: dup
    //   449: aload_1
    //   450: getfield 839	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:bytes_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   453: invokevirtual 843	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   456: invokevirtual 844	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   459: ldc_w 846
    //   462: invokespecial 849	java/lang/String:<init>	([BLjava/lang/String;)V
    //   465: putfield 564	aokz:clM	Ljava/lang/String;
    //   468: goto -396 -> 72
    //   471: aload_0
    //   472: getfield 77	aokz:h	Laool;
    //   475: iconst_1
    //   476: putfield 399	aool:cNH	Z
    //   479: invokestatic 783	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   482: ifeq -166 -> 316
    //   485: ldc_w 785
    //   488: iconst_4
    //   489: ldc_w 851
    //   492: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: goto -179 -> 316
    //   498: astore_1
    //   499: aload_0
    //   500: monitorexit
    //   501: aload_1
    //   502: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	this	aokz
    //   0	503	1	paramArrayOfByte	byte[]
    //   0	503	2	paramHashMap	HashMap<String, String>
    //   0	503	3	paramLong	long
    //   3	165	5	l1	long
    //   88	236	7	l2	long
    //   106	220	9	l3	long
    //   124	204	11	l4	long
    //   142	188	13	l5	long
    // Exception table:
    //   from	to	target	type
    //   5	26	50	java/lang/Exception
    //   30	39	50	java/lang/Exception
    //   39	50	50	java/lang/Exception
    //   402	434	50	java/lang/Exception
    //   434	468	50	java/lang/Exception
    //   245	265	498	finally
    //   265	302	498	finally
    //   302	316	498	finally
    //   316	318	498	finally
    //   471	495	498	finally
    //   499	501	498	finally
  }
  
  /* Error */
  public void aI(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 77	aokz:h	Laool;
    //   6: iconst_1
    //   7: putfield 453	aool:cNF	Z
    //   10: aload_0
    //   11: getfield 77	aokz:h	Laool;
    //   14: getfield 159	aool:F	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 176	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 235	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 179	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 857	aokz:cMo	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokevirtual 456	aokz:KL	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokevirtual 859	aokz:QZ	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokevirtual 456	aokz:KL	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokevirtual 859	aokz:QZ	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	aokz
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
    //   0: new 221	tencent/im/msg/im_msg_body$Ptt
    //   3: dup
    //   4: invokespecial 862	tencent/im/msg/im_msg_body$Ptt:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: getfield 865	tencent/im/msg/im_msg_body$Ptt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12: iconst_4
    //   13: invokevirtual 231	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   16: aload_3
    //   17: getfield 868	tencent/im/msg/im_msg_body$Ptt:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   20: aload_0
    //   21: getfield 77	aokz:h	Laool;
    //   24: getfield 183	aool:mSelfUin	Ljava/lang/String;
    //   27: invokestatic 872	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   30: invokevirtual 874	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   33: aload_3
    //   34: getfield 877	tencent/im/msg/im_msg_body$Ptt:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   37: aload_0
    //   38: getfield 559	aokz:jdField_app_of_type_Long	J
    //   41: l2i
    //   42: invokevirtual 231	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   45: aload_0
    //   46: getfield 564	aokz:clM	Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +23 -> 74
    //   54: aload_3
    //   55: getfield 880	tencent/im/msg/im_msg_body$Ptt:bytes_group_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   58: aload_0
    //   59: getfield 564	aokz:clM	Ljava/lang/String;
    //   62: ldc_w 846
    //   65: invokevirtual 883	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   68: invokestatic 288	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   71: invokevirtual 293	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   74: aload_0
    //   75: getfield 47	aokz:jdField_app_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   78: aload_0
    //   79: getfield 47	aokz:jdField_app_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   82: invokevirtual 886	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   85: invokestatic 892	anbk:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)I
    //   88: istore_1
    //   89: new 894	tencent/im/msg/im_msg_body$Elem
    //   92: dup
    //   93: invokespecial 895	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   96: astore 4
    //   98: new 897	tencent/im/msg/im_msg_body$ElemFlags2
    //   101: dup
    //   102: invokespecial 898	tencent/im/msg/im_msg_body$ElemFlags2:<init>	()V
    //   105: astore_2
    //   106: aload_2
    //   107: getfield 901	tencent/im/msg/im_msg_body$ElemFlags2:uint32_vip_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: iload_1
    //   111: invokevirtual 231	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   114: aload 4
    //   116: getfield 905	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   119: aload_2
    //   120: invokevirtual 908	tencent/im/msg/im_msg_body$ElemFlags2:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   123: aload_3
    //   124: getfield 912	tencent/im/msg/im_msg_body$Ptt:bool_valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   127: iconst_1
    //   128: invokevirtual 916	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   131: aload_3
    //   132: getfield 919	tencent/im/msg/im_msg_body$Ptt:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   135: aload_0
    //   136: getfield 145	aokz:mFileSize	J
    //   139: l2i
    //   140: invokevirtual 231	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   143: aload_3
    //   144: getfield 922	tencent/im/msg/im_msg_body$Ptt:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   147: aload_0
    //   148: getfield 152	aokz:bL	[B
    //   151: invokestatic 288	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   154: invokevirtual 293	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   157: aload_3
    //   158: getfield 925	tencent/im/msg/im_msg_body$Ptt:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   161: aload_0
    //   162: getfield 139	aokz:mFileName	Ljava/lang/String;
    //   165: invokestatic 929	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   168: invokevirtual 293	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   171: aload_0
    //   172: aload_0
    //   173: getfield 77	aokz:h	Laool;
    //   176: getfield 159	aool:F	Lcom/tencent/mobileqq/data/MessageRecord;
    //   179: checkcast 176	com/tencent/mobileqq/data/MessageForPtt
    //   182: invokespecial 931	aokz:b	(Lcom/tencent/mobileqq/data/MessageForPtt;)[B
    //   185: astore_2
    //   186: aload_2
    //   187: ifnull +14 -> 201
    //   190: aload_3
    //   191: getfield 934	tencent/im/msg/im_msg_body$Ptt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   194: aload_2
    //   195: invokestatic 288	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   198: invokevirtual 293	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   201: new 215	tencent/im/msg/im_msg_body$RichText
    //   204: dup
    //   205: invokespecial 935	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   208: astore_2
    //   209: aload_2
    //   210: getfield 219	tencent/im/msg/im_msg_body$RichText:ptt	Ltencent/im/msg/im_msg_body$Ptt;
    //   213: aload_3
    //   214: invokevirtual 936	tencent/im/msg/im_msg_body$Ptt:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   217: aload_2
    //   218: getfield 939	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   221: aload 4
    //   223: invokevirtual 942	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   226: aload_2
    //   227: areturn
    //   228: astore_3
    //   229: aconst_null
    //   230: astore_2
    //   231: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq -8 -> 226
    //   237: ldc_w 738
    //   240: iconst_2
    //   241: ldc_w 944
    //   244: aload_3
    //   245: invokestatic 743	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   248: aconst_null
    //   249: areturn
    //   250: astore_2
    //   251: goto -177 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	aokz
    //   88	23	1	i	int
    //   49	182	2	localObject	Object
    //   250	1	2	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   7	207	3	localPtt	im_msg_body.Ptt
    //   228	17	3	localException	Exception
    //   96	126	4	localElem	tencent.im.msg.im_msg_body.Elem
    // Exception table:
    //   from	to	target	type
    //   0	50	228	java/lang/Exception
    //   54	74	228	java/lang/Exception
    //   74	186	228	java/lang/Exception
    //   190	201	228	java/lang/Exception
    //   201	226	228	java/lang/Exception
    //   54	74	250	java/io/UnsupportedEncodingException
  }
  
  public int cancel()
  {
    AppNetConnInfo.unregisterNetEventHandler(this);
    return super.cancel();
  }
  
  void dDP()
  {
    if (!azR()) {
      return;
    }
    this.jdField_c_of_type_Aojn$a.dVf();
    if (QLog.isColorLevel()) {
      QLog.d("GroupPttUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    if (this.mIsGroup)
    {
      dVF();
      return;
    }
    dVK();
  }
  
  void dVF()
  {
    Object localObject2 = c();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_Aojn$a);
      onError();
    }
    label165:
    label192:
    MessageForPtt localMessageForPtt;
    do
    {
      return;
      if (!azQ())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_Aojn$a);
        onError();
        return;
      }
      if (this.h.F != null)
      {
        localObject1 = this.h.F;
        if ((localObject1 instanceof MessageForPtt)) {
          break label192;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label165;
        }
      }
      for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Aojn$a);
        onError();
        return;
        localObject1 = this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
        break;
      }
      localMessageForPtt = (MessageForPtt)this.h.F;
      a((im_msg_body.RichText)localObject2, localMessageForPtt);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---sendGroupMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
      }
      ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if ((this.h.mUinType == 1026) && (QLog.isColorLevel())) {
        QLog.i("PttShow", 2, "sendGroupMsg, UIN_TYPE_HOTCHAT_TOPIC");
      }
      if (this.cMb)
      {
        if (aagm.S((MessageRecord)localObject1))
        {
          aagm.a().a((MessageRecord)localObject1, this.e, this.jdField_app_of_type_Long, this.bL, null, this);
          return;
        }
        this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.b().b((MessageRecord)localObject1, this.e);
        return;
      }
    } while (this.h.b == null);
    localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.h.dQ);
    localMessageForPtt.fileSize = this.mFileSize;
    localMessageForPtt.urlAtServer = this.mFileName;
    localMessageForPtt.itemType = 2;
    localMessageForPtt.groupFileID = this.jdField_app_of_type_Long;
    localMessageForPtt.groupFileKeyStr = this.clM;
    localMessageForPtt.md5 = this.clf;
    localMessageForPtt.serial();
    this.h.b.a((im_msg_body.RichText)localObject2);
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
  
  void dVK()
  {
    Object localObject2 = c();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_Aojn$a);
      onError();
    }
    label169:
    label196:
    MessageForPtt localMessageForPtt;
    do
    {
      return;
      if (!azQ())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_Aojn$a);
        onError();
        return;
      }
      if (this.h.F != null)
      {
        localObject1 = this.h.F;
        if ((localObject1 != null) && ((localObject1 instanceof MessageForPtt))) {
          break label196;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label169;
        }
      }
      for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Aojn$a);
        onError();
        return;
        localObject1 = this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
        break;
      }
      localMessageForPtt = (MessageForPtt)this.h.F;
      a((im_msg_body.RichText)localObject2, localMessageForPtt);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---sendDiscussMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
      }
      ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if (this.cMb)
      {
        if (aagm.S((MessageRecord)localObject1))
        {
          aagm.a().a((MessageRecord)localObject1, this.e, this.jdField_app_of_type_Long, this.bL, null, this);
          return;
        }
        this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.b().b((MessageRecord)localObject1, this.e);
        return;
      }
    } while (this.h.b == null);
    localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.h.dQ);
    localMessageForPtt.fileSize = this.mFileSize;
    localMessageForPtt.urlAtServer = this.mFileName;
    localMessageForPtt.itemType = 2;
    localMessageForPtt.groupFileID = this.jdField_app_of_type_Long;
    localMessageForPtt.groupFileKeyStr = this.clM;
    localMessageForPtt.md5 = this.clf;
    localMessageForPtt.serial();
    this.h.b.a((im_msg_body.RichText)localObject2);
  }
  
  public void dVt()
  {
    int i = 3;
    if (QLog.isColorLevel()) {
      QLog.d("GroupPttUploadProcessor", 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
    }
    this.jdField_b_of_type_Aojn$a.dVf();
    if (this.mTrans != null) {
      return;
    }
    long l = SystemClock.uptimeMillis();
    Object localObject1 = new cmd0x388.ReqBody();
    ((cmd0x388.ReqBody)localObject1).setHasFlag(true);
    ((cmd0x388.ReqBody)localObject1).uint32_subcmd.set(3);
    int j = aopw.KW();
    ((cmd0x388.ReqBody)localObject1).uint32_net_type.set(j);
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "GroupPttUp: net[" + j + "]");
    }
    Object localObject2 = a();
    cmd0x388.TryUpPttReq localTryUpPttReq = new cmd0x388.TryUpPttReq();
    localTryUpPttReq.setHasFlag(true);
    localTryUpPttReq.uint64_src_uin.set(Long.valueOf(((aoql.a.j)localObject2).selfUin).longValue());
    localTryUpPttReq.uint64_group_code.set(Long.valueOf(((aoql.a.j)localObject2).peerUin).longValue());
    localTryUpPttReq.uint64_file_id.set(0L);
    localTryUpPttReq.uint64_file_size.set(((aoql.a.j)localObject2).fileSize);
    localTryUpPttReq.bytes_file_md5.set(ByteStringMicro.copyFrom(((aoql.a.j)localObject2).md5));
    localTryUpPttReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(((aoql.a.j)localObject2).fileName));
    localTryUpPttReq.uint32_src_term.set(5);
    localTryUpPttReq.uint32_platform_type.set(9);
    PBUInt32Field localPBUInt32Field = localTryUpPttReq.uint32_bu_type;
    if (((aoql.a.j)localObject2).uinType == 1) {}
    for (;;)
    {
      localPBUInt32Field.set(i);
      localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(aonc.getVersionCode()));
      localTryUpPttReq.uint32_voice_length.set(((aoql.a.j)localObject2).voiceLength);
      localTryUpPttReq.uint32_codec.set(((aoql.a.j)localObject2).voiceType);
      localTryUpPttReq.uint32_voice_type.set(((aoql.a.j)localObject2).audioPanelType);
      localTryUpPttReq.bool_new_up_chan.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "GroupPttUp: panel[" + ((aoql.a.j)localObject2).audioPanelType + "] type[" + ((aoql.a.j)localObject2).voiceType + "] length[" + ((aoql.a.j)localObject2).voiceLength + "] size[" + ((aoql.a.j)localObject2).fileSize + "]");
      }
      ((cmd0x388.ReqBody)localObject1).rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
      localObject1 = ((cmd0x388.ReqBody)localObject1).toByteArray();
      localObject2 = new aola(this, l);
      this.mTrans = new Transaction(this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 29, this.cli, (int)this.apw, this.bL, (ITransactionCallback)localObject2, (byte[])localObject1, false);
      localObject1 = new aolb(this);
      this.mTrans.cbForReport = ((ITransCallbackForReport)localObject1);
      i = this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPttUploadProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.h.mUniseq + " MD5:" + this.clf + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:" + 29);
      }
      if (i == 0) {
        break;
      }
      a(i, "sendFileByBDH SubmitError.", "", this.jdField_b_of_type_Aojn$a);
      onError();
      return;
      i = 4;
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Ra(paramBoolean);
      dVJ();
      if (this.dPf == 1)
      {
        this.jdField_c_of_type_Aojn$a.result = 1;
        paramBoolean = true;
      }
    }
    for (;;)
    {
      dVI();
      Object localObject = this.jdField_a_of_type_Aojn$a.fB(1) + ";" + this.jdField_b_of_type_Aojn$a.fB(2) + ";" + this.jdField_c_of_type_Aojn$a.fB(3);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPttUploadProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
      }
      if (this.h.mBusiType == 1030)
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
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
      MessageForPtt localMessageForPtt;
      label262:
      long l1;
      label270:
      long l2;
      if (paramBoolean)
      {
        i = 2;
        this.dOZ = (i | j);
        if (!TextUtils.isEmpty(this.h.dQ))
        {
          localMessageForPtt = (MessageForPtt)this.h.F;
          String str = this.h.dQ;
          if (localMessageForPtt != null) {
            break label796;
          }
          i = 0;
          if (localMessageForPtt != null) {
            break label805;
          }
          l1 = 0L;
          aomq.a(str, true, paramBoolean, i, l1);
        }
        this.mEndTime = System.currentTimeMillis();
        l1 = System.nanoTime();
        l2 = (l1 - this.mStartTime) / 1000000L;
        Log.i("AutoMonitor", "SendGrpPic, cost=" + (this.jdField_b_of_type_Aojn$a.finishTime - this.jdField_b_of_type_Aojn$a.startTime) / 1000000L);
        this.mM.put("param_step", localObject);
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
        localObject = this.mM;
        if (!this.h.isQzonePic) {
          break label815;
        }
      }
      label796:
      label805:
      label815:
      for (int i = 1;; i = 0)
      {
        ((HashMap)localObject).put("param_source_type", String.valueOf(i));
        if (this.cMp)
        {
          this.mM.put("param_pttNetDown", String.valueOf(this.apG / 1000000L));
          if (QLog.isColorLevel()) {
            QLog.d("weak_net", 2, String.valueOf(this.apG / 1000000L));
          }
        }
        this.mM.put("param_pttOpt", String.valueOf(alig.m(this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface)));
        QX(paramBoolean);
        e(paramBoolean, l2, l1);
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
        i = 1;
        break;
        i = localMessageForPtt.voiceChangeFlag;
        break label262;
        l1 = localMessageForPtt.fileSize;
        break label270;
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
          QLog.d("GroupPttUploadProcessor", 2, "doReport ,mStartTime = " + this.mStartTime + ",mEnterAioTime = " + this.apy + ",finishTime  = " + paramLong2 + ", aioDuration = " + l + ", duration = " + paramLong1 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.h.cvb + ",Percent = " + d);
        }
      }
      P(true, paramLong1);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), true, paramLong1, this.mFileSize, this.mM, "");
    }
    for (;;)
    {
      dVc();
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
    if (this.h.cNF) {
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
      akyf.a locala = new akyf.a();
      locala.size = this.mFileSize;
      locala.md5 = this.clf;
      locala.uuid = this.mFileName;
      locala.path = this.h.dQ;
      locala.groupFileID = this.jdField_app_of_type_Long;
      this.h.b.b(locala);
    }
    for (;;)
    {
      VR(1003);
      return;
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
      return;
    case 0: 
      log("<BDH_LOG> pause() BUT current status is INIT");
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
  
  public void start()
  {
    super.start();
    if (!this.h.cNF)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aokz
 * JD-Core Version:    0.7.0.1
 */