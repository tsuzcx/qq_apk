import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor.2;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.ProxyIpManager;
import mqq.util.WeakReference;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.TmpPtt;

public class aojz
  extends aojr
  implements aqxt.a, INetEventHandler
{
  private static int dPm;
  WeakReference<QQAppInterface> K = new WeakReference((QQAppInterface)this.app);
  private long apG;
  private boolean cMo;
  private boolean cMp;
  private String cli;
  achq e = new aoka(this);
  private long timeStamp;
  
  public aojz(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    this.Ha = ((ProxyIpManager)((QQAppInterface)this.K.get()).getManager(3)).getProxyIp(4);
    this.jdField_b_of_type_Auyc = alii.a();
    AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
  }
  
  private int KL()
  {
    hM("uiParam", this.h.toString());
    String str = this.h.dQ;
    if ((str == null) || ("".equals(str)))
    {
      dN(9302, f(new Exception("filePath null")));
      onError();
      return -1;
    }
    if (str != null)
    {
      this.cli = str;
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
      this.clg = "amr";
      long l = localFile.length();
      this.jdField_b_of_type_Aoko.fileSize = l;
      this.mFileSize = l;
      if (l <= 0L)
      {
        dN(9071, f(new Exception("file size 0 " + str)));
        onError();
        return -1;
      }
    }
    return 0;
  }
  
  private void QZ(boolean paramBoolean)
  {
    if (!paramBoolean) {
      VR(1001);
    }
    this.jdField_b_of_type_Aoko.dVw();
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
        break label158;
      }
    }
    label158:
    for (long l = 0L;; l = localMessageForPtt.fileSize)
    {
      aomq.a(str, false, false, i, l);
      dVt();
      return;
      i = localMessageForPtt.voiceChangeFlag;
      break;
    }
  }
  
  private aoql.a.j a()
  {
    aoql.a.j localj = new aoql.a.j();
    localj.selfUin = this.h.mSelfUin;
    localj.peerUin = this.h.mPeerUin;
    localj.cmC = this.h.cmn;
    localj.uinType = this.h.mUinType;
    localj.fileName = this.mFileName;
    localj.fileSize = ((int)this.mFileSize);
    localj.md5 = this.bL;
    MessageForPtt localMessageForPtt = (MessageForPtt)this.h.F;
    if (localMessageForPtt != null)
    {
      localj.voiceType = localMessageForPtt.voiceType;
      localj.voiceLength = localMessageForPtt.voiceLength;
      localj.autoToText = localMessageForPtt.autoToText;
    }
    localj.audioPanelType = this.h.dQL;
    return localj;
  }
  
  public static byte[] a(MessageForPtt paramMessageForPtt)
  {
    ptt_reserve.ReserveStruct localReserveStruct = new ptt_reserve.ReserveStruct();
    localReserveStruct.uint32_change_voice.set(paramMessageForPtt.voiceChangeFlag);
    localReserveStruct.uint32_redpack_type.set(aagm.b(paramMessageForPtt));
    localReserveStruct.uint32_autototext_voice.set(paramMessageForPtt.autoToText);
    if (paramMessageForPtt.hasSttTxt()) {
      localReserveStruct.bytes_voice_text_abs.set(ByteStringMicro.copyFrom(paramMessageForPtt.sttText.getBytes()));
    }
    paramMessageForPtt = aagm.a(paramMessageForPtt);
    if (paramMessageForPtt != null) {
      localReserveStruct.bytes_redpack_score_id.set(paramMessageForPtt);
    }
    return localReserveStruct.toByteArray();
  }
  
  public static byte[] b(MessageForPtt paramMessageForPtt)
  {
    byte[] arrayOfByte1 = a(paramMessageForPtt);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 3 + 15];
    arrayOfByte2[0] = 3;
    arrayOfByte2[1] = 8;
    byte[] arrayOfByte3 = aqoj.b((short)4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 2, arrayOfByte3.length);
    int i = arrayOfByte3.length + 2;
    arrayOfByte3 = aqoj.l(paramMessageForPtt.voiceType);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, i, arrayOfByte3.length);
    i += arrayOfByte3.length;
    arrayOfByte2[i] = 9;
    i += 1;
    arrayOfByte3 = aqoj.b((short)4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, i, 2);
    i += arrayOfByte3.length;
    paramMessageForPtt = aqoj.l(aqft.ag(paramMessageForPtt.voiceLength));
    System.arraycopy(paramMessageForPtt, 0, arrayOfByte2, i, paramMessageForPtt.length);
    i += paramMessageForPtt.length;
    arrayOfByte2[i] = 10;
    i += 1;
    paramMessageForPtt = aqoj.b((short)arrayOfByte1.length);
    System.arraycopy(paramMessageForPtt, 0, arrayOfByte2, i, 2);
    i += paramMessageForPtt.length;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, i, arrayOfByte1.length);
    i = arrayOfByte1.length;
    return arrayOfByte2;
  }
  
  protected String AJ()
  {
    return "actC2CPttUpload";
  }
  
  public int EN()
  {
    if ((this.h.cNG) && (this.h.cNH))
    {
      dUZ();
      dDP();
    }
    return super.EN();
  }
  
  public int KH()
  {
    super.KH();
    if (!this.h.cNF) {
      return 0;
    }
    return KL();
  }
  
  public void QV(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.h.F != null)
    {
      localMessageRecord = this.h.F;
      if (localMessageRecord != null) {
        break label101;
      }
      hM("updateDb", "msg null");
    }
    label101:
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.K == null) || (this.K.get() == null));
        localMessageRecord = ((QQAppInterface)this.K.get()).b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
        hM("updateDb", "findmsgbyMsgId,need fix");
        break;
      } while (!(localMessageRecord instanceof MessageForPtt));
      MessageForPtt localMessageForPtt = (MessageForPtt)localMessageRecord;
      if (!this.h.cNG) {
        localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.h.dQ);
      }
      localMessageForPtt.fileSize = this.mFileSize;
      localMessageForPtt.urlAtServer = this.mResid;
      localMessageForPtt.itemType = 2;
      localMessageForPtt.md5 = this.clf;
      localMessageForPtt.serial();
      if ((this.K != null) && (this.K.get() != null)) {
        ((QQAppInterface)this.K.get()).b().c(this.h.mPeerUin, this.h.mUinType, localMessageRecord.uniseq, localMessageForPtt.msgData);
      }
    } while ((this.K == null) || (this.K.get() == null) || (localMessageRecord == null) || (!(localMessageRecord instanceof MessageForPtt)) || (!((anvq)((QQAppInterface)this.K.get()).getManager(17)).m((MessageForPtt)localMessageRecord)));
    anot.a(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
    ((anvo)((QQAppInterface)this.K.get()).getManager(17)).a((MessageForPtt)localMessageRecord, 2);
  }
  
  protected aoll a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = super.a(paramArrayOfByte);
    paramArrayOfByte.cMJ = true;
    return paramArrayOfByte;
  }
  
  public void a(aoql.a.j paramj, cmd0x346.ExtensionReq paramExtensionReq)
  {
    int j = 0;
    int i = j;
    switch (paramj.uinType)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      paramExtensionReq.uint64_type.set(i);
      return;
      i = j;
      if (paramj.cNZ)
      {
        i = 500;
        continue;
        i = 102;
        paramExtensionReq.str_dst_phonenum.set(paramj.peerUin);
        continue;
        i = 104;
        continue;
        i = 104;
        continue;
        i = 105;
        continue;
        i = 101;
        continue;
        i = 103;
        continue;
        i = 114;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, long paramLong)
  {
    long l1 = SystemClock.uptimeMillis();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (cmd0x346.RspBody)new cmd0x346.RspBody().mergeFrom(paramArrayOfByte);
        if ((paramArrayOfByte.msg_apply_upload_rsp != null) && (paramArrayOfByte.msg_apply_upload_rsp.get() != null))
        {
          paramArrayOfByte = (cmd0x346.ApplyUploadRsp)paramArrayOfByte.msg_apply_upload_rsp.get();
          if ((paramArrayOfByte.bytes_uuid != null) && (paramArrayOfByte.bytes_uuid.get() != null))
          {
            paramArrayOfByte = paramArrayOfByte.bytes_uuid.get().toStringUtf8();
            if (paramArrayOfByte.length() > 0)
            {
              this.mResid = paramArrayOfByte;
              if (QLog.isColorLevel()) {
                QLog.d("C2CPicUploadProcessor", 2, "set uuid from BDH ");
              }
            }
          }
        }
        l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
        l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
        l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
        l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - paramLong) + "ms ,fileSize:" + this.jdField_b_of_type_Aoko.fileSize + " transInfo:" + (String)paramHashMap.get("rep_bdhTrans"));
        }
        I(paramHashMap);
        this.jdField_b_of_type_Aojn$a.dVg();
        this.jdField_b_of_type_Aojn$a.result = 1;
        this.bz = this.mFileSize;
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          long l2;
          long l3;
          long l4;
          long l5;
          if ((!this.h.cNG) || (this.h.cNH))
          {
            dUZ();
            dDP();
            if (this.h.cNG)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("PttPreSendManager", 4, "presend file success, can send msg, direct send");
              }
              if ((this.K != null) && (this.K.get() != null)) {
                alit.a((QQAppInterface)this.K.get()).Oj(getKey());
              }
            }
            ThreadManager.post(new C2CPttUploadProcessor.2(this, l2, l3, l4, l5), 5, null, true);
            this.jdField_b_of_type_Aoko.dVw();
            if (QLog.isColorLevel()) {
              QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
            }
            String str1 = (String)paramHashMap.get("ip");
            paramHashMap = (String)paramHashMap.get("port");
            String str2 = this.clf;
            if (this.mResid == null)
            {
              paramArrayOfByte = this.mUuid;
              a("actRichMediaNetMonitor_pttUp", true, 0, str1, paramHashMap, str2, paramArrayOfByte, null);
              return;
              paramArrayOfByte = paramArrayOfByte;
              paramArrayOfByte.printStackTrace();
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("C2CPicUploadProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
            }
          }
          else
          {
            this.h.cNH = true;
            if (!QLog.isDevelopLevel()) {
              continue;
            }
            QLog.d("PttPreSendManager", 4, "presend file success, wait for send msg");
            continue;
          }
          paramArrayOfByte = this.mResid;
        }
        finally {}
      }
    }
  }
  
  /* Error */
  public void aI(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 97	aojz:h	Laool;
    //   6: iconst_1
    //   7: putfield 400	aool:cNF	Z
    //   10: aload_0
    //   11: getfield 97	aojz:h	Laool;
    //   14: getfield 224	aool:F	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 226	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 284	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 280	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 660	aojz:cMo	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokespecial 402	aojz:KL	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokespecial 662	aojz:QZ	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokespecial 402	aojz:KL	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokespecial 662	aojz:QZ	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	aojz
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
  
  public im_msg_body.RichText b()
  {
    return c();
  }
  
  protected im_msg_body.RichText c()
  {
    try
    {
      int i;
      if (this.h.mUinType == 0)
      {
        localObject1 = new im_msg_body.Ptt();
        ((im_msg_body.Ptt)localObject1).uint32_file_type.set(4);
        ((im_msg_body.Ptt)localObject1).uint64_src_uin.set(Long.parseLong(this.h.mSelfUin));
        if ((this.xp != null) && (this.xp.size() > 0))
        {
          localObject2 = (aonh)this.xp.get(0);
          ((im_msg_body.Ptt)localObject1).uint32_server_ip.set(aokv.eD(((aonh)localObject2).mIp));
          ((im_msg_body.Ptt)localObject1).uint32_server_port.set(((aonh)localObject2).port);
        }
        localObject2 = new im_msg_body.Elem();
        Object localObject3 = new im_msg_body.ElemFlags2();
        if ((this.K != null) && (this.K.get() != null))
        {
          i = anbk.k((QQAppInterface)this.K.get(), ((QQAppInterface)this.K.get()).getCurrentAccountUin());
          ((im_msg_body.ElemFlags2)localObject3).uint32_vip_status.set(i);
        }
        ((im_msg_body.Elem)localObject2).elem_flags2.set((MessageMicro)localObject3);
        ((im_msg_body.Ptt)localObject1).bool_valid.set(true);
        ((im_msg_body.Ptt)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mResid));
        ((im_msg_body.Ptt)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(this.bL));
        ((im_msg_body.Ptt)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.mFileName));
        ((im_msg_body.Ptt)localObject1).uint32_file_size.set((int)this.mFileSize);
        localObject3 = b((MessageForPtt)this.h.F);
        if (localObject3 != null) {
          ((im_msg_body.Ptt)localObject1).bytes_reserve.set(ByteStringMicro.copyFrom((byte[])localObject3));
        }
        localObject3 = new im_msg_body.RichText();
        ((im_msg_body.RichText)localObject3).ptt.set((MessageMicro)localObject1);
        ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject2);
        return localObject3;
      }
      Object localObject1 = new im_msg_body.TmpPtt();
      ((im_msg_body.TmpPtt)localObject1).uint32_file_type.set(4);
      ((im_msg_body.TmpPtt)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mResid));
      ((im_msg_body.TmpPtt)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(this.bL));
      ((im_msg_body.TmpPtt)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.mFileName));
      ((im_msg_body.TmpPtt)localObject1).uint32_file_size.set((int)this.mFileSize);
      if ((this.K != null) && (this.K.get() != null))
      {
        localObject2 = ((QQAppInterface)this.K.get()).getCurrentAccountUin();
        i = anbk.k((QQAppInterface)this.K.get(), (String)localObject2);
        ((im_msg_body.TmpPtt)localObject1).uint32_user_type.set(i);
      }
      ((im_msg_body.TmpPtt)localObject1).uint64_ptt_times.set(QQRecorder.n(this.h.F));
      if (this.h.mUinType == 1008) {
        ((im_msg_body.TmpPtt)localObject1).uint32_busi_type.set(3);
      }
      Object localObject2 = a((MessageForPtt)this.h.F);
      if (localObject2 != null) {
        ((im_msg_body.TmpPtt)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      if (localObject2 != null) {
        ((im_msg_body.TmpPtt)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      localObject2 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject2).tmp_ptt.set((MessageMicro)localObject1);
      return localObject2;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CPicUploadProcessor", 2, "Construct richtext error");
      }
      localException.printStackTrace();
    }
    return null;
  }
  
  public int cancel()
  {
    AppNetConnInfo.unregisterNetEventHandler(this);
    return super.cancel();
  }
  
  void dDP()
  {
    if (!azR()) {}
    Object localObject1;
    MessageRecord localMessageRecord;
    label173:
    Object localObject2;
    do
    {
      return;
      this.c.dVf();
      localObject1 = c();
      if (localObject1 == null)
      {
        a(9360, "constructpberror", null, this.c);
        onError();
        return;
      }
      if (this.h.F != null) {
        localMessageRecord = this.h.F;
      }
      for (;;)
      {
        if ((localMessageRecord instanceof MessageForPtt)) {
          break label173;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("accost_ptt", 4, "mr not ptt?......");
        }
        a(9360, "constructpberror", null, this.c);
        onError();
        return;
        if ((this.K == null) || (this.K.get() == null)) {
          break;
        }
        localMessageRecord = ((QQAppInterface)this.K.get()).b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
        hM("updateDb", "findmsgbyMsgId,need fix");
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("accost_ptt", 4, "mr is ptt......");
      }
      localObject2 = (MessageForPtt)localMessageRecord;
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---sendC2CMsg voiceType：" + ((MessageForPtt)localObject2).voiceType + " voiceLengh:" + ((MessageForPtt)localObject2).voiceLength);
      }
      ((MessageForPtt)localObject2).richText = ((im_msg_body.RichText)localObject1);
      if (!azQ())
      {
        a(9366, "illegal app", null, this.c);
        onError();
        return;
      }
      if (this.h.b != null)
      {
        QV(true);
        this.h.b.a((im_msg_body.RichText)localObject1);
        return;
      }
    } while ((this.K == null) || (this.K.get() == null));
    if (aagm.S(localMessageRecord))
    {
      localObject2 = aagm.a();
      achq localachq = this.e;
      byte[] arrayOfByte = this.bL;
      if (this.mResid == null) {}
      for (localObject1 = this.mUuid;; localObject1 = this.mResid)
      {
        ((aagm)localObject2).a(localMessageRecord, localachq, 0L, arrayOfByte, (String)localObject1, this);
        return;
      }
    }
    ((QQAppInterface)this.K.get()).b().b(localMessageRecord, this.e);
  }
  
  protected void dVe()
  {
    if ((this.jdField_a_of_type_Aomg != null) && ((this.jdField_a_of_type_Aomg instanceof aoll))) {
      ((aoll)this.jdField_a_of_type_Aomg).bZ = MsfSdkUtils.insertMtype("pttCu", ((aoll)this.jdField_a_of_type_Aomg).bZ);
    }
  }
  
  public void dVt()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
    }
    this.jdField_b_of_type_Aojn$a.dVf();
    if (this.mTrans != null) {}
    int i;
    do
    {
      return;
      long l1 = SystemClock.uptimeMillis();
      localj = a();
      cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
      localReqBody.uint32_cmd.set(500);
      Object localObject1 = localReqBody.uint32_seq;
      i = dPm;
      dPm = i + 1;
      ((PBUInt32Field)localObject1).set(i);
      localReqBody.uint32_business_id.set(17);
      localReqBody.uint32_client_type.set(104);
      cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
      localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localj.selfUin));
      try
      {
        localObject2 = localj.peerUin;
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("+")) {
          localObject1 = ((String)localObject2).substring(1);
        }
        long l2 = Long.valueOf((String)localObject1).longValue();
        localApplyUploadReq.uint64_recver_uin.set(l2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          localException.printStackTrace();
          continue;
          if (localj.uinType == 9999) {
            localException.uint32_file_type.set(102);
          }
        }
      }
      localApplyUploadReq.uint32_file_type.set(2);
      localApplyUploadReq.str_file_name.set(localj.fileName);
      localApplyUploadReq.uint64_file_size.set(localj.fileSize);
      localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localj.md5));
      localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
      localObject1 = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject1).uint64_id.set(3L);
      ((cmd0x346.ExtensionReq)localObject1).uint32_ptt_format.set(localj.voiceType);
      ((cmd0x346.ExtensionReq)localObject1).uint32_ptt_time.set(localj.voiceLength);
      i = aopw.KW();
      ((cmd0x346.ExtensionReq)localObject1).uint32_net_type.set(i);
      ((cmd0x346.ExtensionReq)localObject1).uint32_voice_type.set(localj.audioPanelType);
      if (QLog.isColorLevel())
      {
        QLog.d("RecordParams", 2, "C2CPttUp: panel[" + localj.audioPanelType + "] type[" + localj.voiceType + "] length[" + localj.voiceLength + "] size[" + localj.fileSize + "]");
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "C2CPttUp: net[" + i + "]");
        }
      }
      a(localj, (cmd0x346.ExtensionReq)localObject1);
      if (localj.uinType != 1008) {
        break;
      }
      ((cmd0x346.ExtensionReq)localObject1).uint32_file_type.set(3);
      localReqBody.msg_extension_req.set((MessageMicro)localObject1);
      localObject1 = localReqBody.toByteArray();
      localObject2 = new aokb(this, l1);
      this.mTrans = new Transaction(((QQAppInterface)this.K.get()).getCurrentAccountUin(), 26, this.cli, (int)this.apw, this.bL, (ITransactionCallback)localObject2, (byte[])localObject1, false);
      localObject1 = new aokc(this);
      this.mTrans.cbForReport = ((ITransCallbackForReport)localObject1);
      i = ((QQAppInterface)this.K.get()).getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.h.mUniseq + " MD5:" + this.clf + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:" + 26);
      }
    } while (i == 0);
    a(i, "sendFileByBDH SubmitError.", "", this.jdField_b_of_type_Aojn$a);
    onError();
  }
  
  protected void doReport(boolean paramBoolean)
  {
    alii.a(this.jdField_b_of_type_Auyc);
    if ((!paramBoolean) && (aona.lQ(this.errCode))) {}
    while ((this.cLT) || ((paramBoolean) && ((this.dOZ & 0x2) > 0)) || ((!paramBoolean) && ((this.dOZ & 0x1) > 0))) {
      return;
    }
    int j = this.dOZ;
    int i;
    long l2;
    Object localObject1;
    label215:
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.dOZ = (i | j);
      this.mEndTime = System.currentTimeMillis();
      l2 = (System.nanoTime() - this.mStartTime) / 1000000L;
      if (this.h.cNG)
      {
        this.jdField_a_of_type_Aojn$a.lF(this.mStartTime);
        this.jdField_b_of_type_Aojn$a.lF(this.mStartTime);
      }
      localObject1 = this.jdField_a_of_type_Aojn$a.fB(1) + ";" + this.jdField_b_of_type_Aojn$a.fB(2) + ";" + this.c.fB(3);
      this.mM.put("param_step", localObject1);
      Object localObject2 = this.mM;
      if (this.mResid != null) {
        break label510;
      }
      localObject1 = this.mUuid;
      ((HashMap)localObject2).put("param_uuid", localObject1);
      this.mM.put("param_toUin", this.h.mPeerUin);
      this.mM.put("param_uinType", String.valueOf(this.h.mUinType));
      this.mM.put("param_quickHttp", String.valueOf(this.cLU));
      if ((this.K != null) && (this.K.get() != null)) {
        this.mM.put("param_pttOpt", String.valueOf(alig.m((QQAppInterface)this.K.get())));
      }
      if (this.cMp)
      {
        this.mM.put("param_pttNetDown", String.valueOf(this.apG / 1000000L));
        if (QLog.isColorLevel()) {
          QLog.d("weak_net", 2, String.valueOf(this.apG / 1000000L));
        }
      }
      aomq.a(paramBoolean, this.h.mUinType, l2, this.mFileSize);
      if (!TextUtils.isEmpty(this.h.dQ))
      {
        localObject1 = (MessageForPtt)this.h.F;
        localObject2 = this.h.dQ;
        if (localObject1 != null) {
          break label519;
        }
        i = 0;
        label439:
        if (localObject1 != null) {
          break label528;
        }
        l1 = 0L;
        label447:
        aomq.a((String)localObject2, true, paramBoolean, i, l1);
      }
      if (!paramBoolean) {
        break label538;
      }
      P(true, l2);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), true, l2, this.mFileSize, this.mM, "");
    }
    for (;;)
    {
      dVc();
      AppNetConnInfo.unregisterNetEventHandler(this);
      return;
      i = 1;
      break;
      label510:
      localObject1 = this.mResid;
      break label215;
      label519:
      i = ((MessageForPtt)localObject1).voiceChangeFlag;
      break label439;
      label528:
      l1 = ((MessageForPtt)localObject1).fileSize;
      break label447;
      label538:
      if (this.errCode != -9527) {
        this.mM.remove("param_rspHeader");
      }
      this.mM.put("param_FailCode", String.valueOf(this.errCode));
      this.mM.put("param_errorDesc", this.errDesc);
      this.mM.put("param_picSize", String.valueOf(this.mFileSize));
      P(false, l2);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), false, l2, this.mFileSize, this.mM, "");
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
    if ((this.K != null) && (this.K.get() != null) && (this.h.cNG)) {
      alit.a((QQAppInterface)this.K.get()).Oj(getKey());
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
    QV(true);
    VR(1003);
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
 * Qualified Name:     aojz
 * JD-Core Version:    0.7.0.1
 */