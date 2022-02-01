package com.tencent.mobileqq.transfile;

import acfp;
import android.text.TextUtils;
import anpc;
import anre;
import aoji;
import aokl;
import aoll;
import aolm;
import aomh;
import aonc;
import aonh;
import aood;
import aooi;
import aool;
import aoql.a;
import aoql.a.e;
import aoql.a.f;
import aoql.b;
import aoql.b.h;
import aoql.b.i;
import aoqm;
import aqmr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import tencent.im.longconn.longmsg.LongMsg.MsgDownRsp;
import tencent.im.longconn.longmsg.LongMsg.RspBody;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;

public class StructLongMessageDownloadProcessor
  extends aoji
  implements Runnable
{
  private static final ArrayList<aool> Bs = new ArrayList();
  private static ConcurrentHashMap<Long, aoll> iH = new ConcurrentHashMap();
  private long OD;
  private long ahk;
  boolean cNw = true;
  private int dQA;
  private int dQz = 5;
  int errorCode = 4;
  private byte[] fR;
  AbsStructMsg g;
  int httpErrorCode = 200;
  String pUin = "";
  String selfUin = "";
  String url = "";
  
  public StructLongMessageDownloadProcessor(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
  }
  
  private byte[] E(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->null bodyData");
      }
      paramArrayOfByte = null;
      return paramArrayOfByte;
    }
    int i = paramArrayOfByte.length;
    Object localObject2;
    Object localObject1;
    if ((paramArrayOfByte[0] != 40) || (paramArrayOfByte[(i - 1)] != 41))
    {
      localObject2 = "unexpected body data, len=" + i + ", data=";
      localObject1 = paramArrayOfByte.toString();
      localObject2 = new StringBuilder().append((String)localObject2);
      paramArrayOfByte = (byte[])localObject1;
      if (((String)localObject1).length() > 20) {
        paramArrayOfByte = ((String)localObject1).substring(0, 20);
      }
      paramArrayOfByte = paramArrayOfByte;
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->" + paramArrayOfByte);
      }
      return null;
    }
    for (;;)
    {
      int j;
      try
      {
        paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
        paramArrayOfByte.readByte();
        int k = paramArrayOfByte.readInt();
        j = paramArrayOfByte.readInt();
        if ((k > i) || (j > i))
        {
          if (!QLog.isColorLevel()) {
            break label585;
          }
          QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->unexpected length, headLen=" + k + ", bodyLen=" + j);
          break label585;
        }
        if (k <= 0) {
          break label580;
        }
        localObject1 = new byte[k];
        paramArrayOfByte.read((byte[])localObject1);
        localObject2 = new im_msg_head.Head();
        ((im_msg_head.Head)localObject2).mergeFrom((byte[])localObject1);
        i = ((im_msg_head.HttpConnHead)((im_msg_head.Head)localObject2).msg_httpconn_head.get()).uint32_error_code.get();
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      if (!QLog.isColorLevel()) {
        break label598;
      }
      QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->bodyLen= " + j + " errCode= " + i);
      break label598;
      localObject1 = new byte[j];
      paramArrayOfByte.read((byte[])localObject1);
      paramArrayOfByte = new Cryptor().decrypt((byte[])localObject1, this.fR);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
      {
        if (!QLog.isColorLevel()) {
          break label600;
        }
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->after decrypt: dBodyBytes==null ||dBodyBytes.length<=0");
        break label600;
      }
      localObject1 = new LongMsg.RspBody();
      ((LongMsg.RspBody)localObject1).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (LongMsg.MsgDownRsp)((LongMsg.RspBody)localObject1).rpt_msg_down_rsp.get(0);
      if (paramArrayOfByte == null)
      {
        if (!QLog.isColorLevel()) {
          break label602;
        }
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->rspBody.rpt_msg_down_rsp == null");
        break label602;
      }
      if (!paramArrayOfByte.uint32_result.has())
      {
        if (!QLog.isColorLevel()) {
          break label604;
        }
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->uint32_result NOT exists");
        break label604;
      }
      if (paramArrayOfByte.uint32_result.get() != 0)
      {
        if (!QLog.isColorLevel()) {
          break label606;
        }
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->uint32_result != 0");
        break label606;
      }
      if (!paramArrayOfByte.bytes_msg_content.has())
      {
        if (!QLog.isColorLevel()) {
          break label608;
        }
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->bytes_msg_content NOT exists");
        break label608;
      }
      localObject1 = paramArrayOfByte.bytes_msg_content.get().toByteArray();
      if (localObject1 != null)
      {
        paramArrayOfByte = (byte[])localObject1;
        if (localObject1.length > 0) {
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "parseOldLongMsgContent->bytes_msg_content == null or empty");
      }
      return null;
      label580:
      i = 0;
      break label587;
      label585:
      return null;
      label587:
      if (j > 0) {
        if (i == 0) {}
      }
    }
    label598:
    return null;
    label600:
    return null;
    label602:
    return null;
    label604:
    return null;
    label606:
    return null;
    label608:
    return null;
  }
  
  private void Wa(int paramInt)
  {
    MessageForStructing localMessageForStructing;
    if ((this.h.F instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)this.h.F;
      if (localMessageForStructing != null)
      {
        if (paramInt != 2003) {
          break label279;
        }
        localMessageForStructing.removeExtInfoToExtStr("pub_long_msg_url");
        localMessageForStructing.removeExtInfoToExtStr("pub_long_msg_download_key");
        localMessageForStructing.removeExtInfoToExtStr("pub_long_msg_resid");
        if ((this.g instanceof StructMsgForGeneralShare))
        {
          str = ((StructMsgForGeneralShare)this.g).mWarningTips;
          if (!TextUtils.isEmpty(str)) {
            localMessageForStructing.saveExtInfoToExtStr("pa_phone_msg_tip", str);
          }
        }
        l = 0L;
        if (localMessageForStructing.structingMsg != null) {
          l = localMessageForStructing.structingMsg.msgId;
        }
        localMessageForStructing.structingMsg = this.g;
        localMessageForStructing.structingMsg.msgId = l;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage data size: " + this.g.getBytes().length);
        }
        localMessageForStructing.msgData = this.g.getBytes();
        this.app.b().c(this.h.mPeerUin, this.h.mUinType, localMessageForStructing.uniseq, localMessageForStructing.msgData);
        this.app.b().a(this.h.mPeerUin, this.h.mUinType, localMessageForStructing.uniseq, "extStr", localMessageForStructing.extStr);
        this.app.a().notifyUI(999, true, this.h.mPeerUin);
      }
    }
    label279:
    while (paramInt != 2005)
    {
      String str;
      long l;
      return;
    }
    localMessageForStructing.saveExtInfoToExtStr("longMsg_State", String.valueOf(2));
    localMessageForStructing.structingMsg.mMsgBrief = acfp.m(2131715009);
    localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
    this.app.b().c(this.h.mPeerUin, this.h.mUinType, localMessageForStructing.uniseq, localMessageForStructing.msgData);
    this.app.b().a(this.h.mPeerUin, this.h.mUinType, localMessageForStructing.uniseq, "extStr", localMessageForStructing.extStr);
    this.app.a().notifyUI(999, true, this.h.mPeerUin);
  }
  
  private static void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, aool paramaool)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Cancel");
      if (ba(paramaool.F)) {
        QLog.d("PaOldLongMsg", 2, "msgId=" + paramaool.F.uniseq + ", delete download task!");
      }
    }
    HashMap localHashMap;
    if (ba(paramaool.F))
    {
      paramaool = "actOldLongMessageDownload";
      localHashMap = new HashMap();
      localHashMap.put("param_uin", paramString1);
      localHashMap.put("param_puin", paramString2);
      localHashMap.put("param_channel", "0");
      if (!paramBoolean) {
        break label266;
      }
      localHashMap.put("param_errcode", String.valueOf(11));
    }
    for (;;)
    {
      localHashMap.put("param_resid", "" + paramLong);
      if (!QLog.isColorLevel()) {
        break label283;
      }
      paramString1 = localHashMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        Object localObject = (Map.Entry)paramString1.next();
        paramString2 = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, paramString2 + (String)localObject);
      }
      paramaool = "actLongMessageDownload";
      break;
      label266:
      localHashMap.put("param_errcode", String.valueOf(10));
    }
    label283:
    anpc.a(BaseApplication.getContext()).collectPerformance(null, paramaool, false, 0L, 0L, localHashMap, "", true);
  }
  
  private boolean aAq()
  {
    this.cNw = true;
    this.dQz = 5;
    MessageRecord localMessageRecord = this.h.F;
    if (localMessageRecord == null) {}
    do
    {
      return false;
      localObject = localMessageRecord.getExtInfoFromExtStr("pub_long_msg_url");
      str1 = localMessageRecord.getExtInfoFromExtStr("pub_long_msg_download_key");
      this.selfUin = localMessageRecord.selfuin;
      this.pUin = localMessageRecord.frienduin;
    } while ((localObject == null) || ("".equals(localObject)) || (str1 == null) || ("".equals(str1)));
    String str2 = (String)localObject + "&rkey=" + str1;
    String str1 = aokl.a().AL();
    Object localObject = str1;
    if (str1 == null)
    {
      localObject = aokl.a().a().getIp();
      this.dQz = 10;
      this.dQA = aokl.a().a().KR();
    }
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      switch (aokl.a().getState())
      {
      default: 
        this.dQz = 7;
        return false;
      }
      this.dQz = 6;
      return false;
    }
    localObject = (String)localObject + str2;
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "directUrl = " + str2 + ",url:" + (String)localObject);
    }
    aJ(localMessageRecord.uniseq, (String)localObject);
    ThreadManager.getSubThreadHandler().postDelayed(this, 30000L);
    return true;
  }
  
  private void aJ(long paramLong, String paramString)
  {
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.bZ = paramString;
    localaoll.mHttpMethod = 0;
    localaoll.P = this.xp;
    this.c.a(localaoll);
    iH.put(Long.valueOf(paramLong), localaoll);
    this.jdField_a_of_type_Aomg = localaoll;
    aokl.a().a().b(aonc.a(paramString));
    this.url = paramString;
    this.ahk = System.nanoTime();
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "receiveFile->msgid:" + paramLong + ", url:" + paramString);
      if (ba(this.h.F)) {
        QLog.d("PaOldLongMsg", 2, "msgId=" + paramLong + ", receiveFile->url:" + paramString);
      }
    }
  }
  
  public static void aP(QQAppInterface paramQQAppInterface, String paramString)
  {
    ArrayList localArrayList2;
    synchronized (Bs)
    {
      if ((Bs == null) || (Bs.size() == 0) || (paramString == null) || (paramQQAppInterface == null)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "deleteAllTask uin" + paramString);
      }
      localArrayList2 = new ArrayList();
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null)
      {
        Iterator localIterator = Bs.iterator();
        while (localIterator.hasNext())
        {
          aool localaool = (aool)localIterator.next();
          if (paramString.equalsIgnoreCase(localaool.mPeerUin))
          {
            paramQQAppInterface.bb(localaool.mPeerUin, localaool.mUniseq);
            localArrayList2.add(localaool);
            a(true, localaool.mSelfUin, localaool.mPeerUin, localaool.mUniseq, localaool);
          }
        }
      }
    }
    Bs.removeAll(localArrayList2);
  }
  
  public static boolean aZ(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return false;
      str1 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_url");
      str2 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_download_key");
      str3 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid");
    } while ((aqmr.isEmpty(str1)) || (aqmr.isEmpty(str2)) || (aqmr.isEmpty(str3)));
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "isPALongMsg , messageRecord,msgid= " + paramMessageRecord.msgId + " uid= " + paramMessageRecord.msgUid + " msgseq= " + paramMessageRecord.msgseq + " uniseq=" + paramMessageRecord.uniseq);
    }
    return true;
  }
  
  public static boolean ba(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (aqmr.isEmpty(paramMessageRecord.getExtInfoFromExtStr("pub_old_long_msg"))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "isOldLongMsg , messageRecord,msgid= " + paramMessageRecord.msgId + " uid= " + paramMessageRecord.msgUid + " msgseq= " + paramMessageRecord.msgseq + " uniseq=" + paramMessageRecord.uniseq);
    }
    return true;
  }
  
  public static boolean bb(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return false;
      str1 = paramMessageRecord.getExtInfoFromExtStr("pub_old_long_msg");
      str2 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid");
      str3 = paramMessageRecord.getExtInfoFromExtStr("longMsg_State");
    } while ((aqmr.isEmpty(str1)) || (aqmr.isEmpty(str3)) || (aqmr.isEmpty(str2)));
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "needFetchOldLongMsg , messageRecord,msgid= " + paramMessageRecord.msgId + " uid= " + paramMessageRecord.msgUid + " msgseq= " + paramMessageRecord.msgseq + " uniseq=" + paramMessageRecord.uniseq);
    }
    return true;
  }
  
  public static String bytesToHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void czy()
  {
    if ((this.h.F instanceof MessageForStructing)) {
      synchronized (Bs)
      {
        Iterator localIterator = Bs.iterator();
        while (localIterator.hasNext())
        {
          aool localaool = (aool)localIterator.next();
          if (localaool.mUniseq == this.h.F.uniseq) {
            Bs.remove(localaool);
          }
        }
        return;
      }
    }
  }
  
  private void dVq()
  {
    this.cNw = false;
    this.dQA = 0;
    Object localObject1 = this.h.F;
    if (localObject1 == null)
    {
      this.errorCode = 15;
      onError();
    }
    String str;
    Object localObject2;
    do
    {
      do
      {
        return;
        str = ((MessageRecord)localObject1).getExtInfoFromExtStr("pub_long_msg_resid");
        if ((str != null) && (!str.equals(""))) {
          break;
        }
      } while ((!aZ((MessageRecord)localObject1)) && (!ba((MessageRecord)localObject1)));
      this.errorCode = 13;
      onError();
      return;
      if (!ba((MessageRecord)localObject1)) {
        break;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("StructLongMessageDownloadProcessor", 2, "sendGetUrlReq->oldLongMsg");
        QLog.d("PaOldLongMsg", 2, "msgId=" + ((MessageRecord)localObject1).uniseq + ", sendGetUrlReq");
      }
      localObject2 = new aoql.a.f();
      ((aoql.a.f)localObject2).selfUin = ((MessageRecord)localObject1).selfuin;
      ((aoql.a.f)localObject2).peerUin = ((MessageRecord)localObject1).frienduin;
      ((aoql.a.f)localObject2).cmC = ((MessageRecord)localObject1).frienduin;
      ((aoql.a.f)localObject2).uinType = ((MessageRecord)localObject1).istroop;
      ((aoql.a.f)localObject2).gd = str.getBytes();
      localObject1 = new aoql.a();
      ((aoql.a)localObject1).b = this;
      ((aoql.a)localObject1).cmy = "multi_msg_dw";
      ((aoql.a)localObject1).He.add(localObject2);
      ((aoql.a)localObject1).a = this.app.getProtoReqManager();
      if (!azQ())
      {
        a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
        this.errorCode = 16;
        onError();
        return;
      }
    } while (!azR());
    this.jdField_a_of_type_Aoql$a = ((aoql.a)localObject1);
    aoqm.c((aoql.a)localObject1);
    for (;;)
    {
      this.OD = System.nanoTime();
      return;
      localObject2 = new aoql.a();
      ((aoql.a)localObject2).b = this;
      ((aoql.a)localObject2).cmy = "pa_long_message";
      ((aoql.a)localObject2).a = this.app.getProtoReqManager();
      if (!azQ())
      {
        a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
        this.errorCode = 16;
        onError();
        return;
      }
      if (!azR()) {
        break;
      }
      this.jdField_a_of_type_Aoql$a = ((aoql.a)localObject2);
      aoql.a.e locale = new aoql.a.e();
      locale.cmA = str;
      locale.peerUin = ((MessageRecord)localObject1).frienduin;
      ((aoql.a)localObject2).He.add(locale);
      aoqm.c((aoql.a)localObject2);
    }
  }
  
  private void dWk()
  {
    dVq();
  }
  
  private void dWm()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Cancel");
      if (ba(this.h.F)) {
        QLog.d("PaOldLongMsg", 2, "msgId=" + this.h.F.uniseq + ", cancle download task!");
      }
    }
    if (ba(this.h.F)) {}
    HashMap localHashMap;
    for (String str1 = "actOldLongMessageDownload";; str1 = "actLongMessageDownload")
    {
      localHashMap = new HashMap();
      localHashMap.put("param_uin", this.selfUin);
      localHashMap.put("param_puin", this.pUin);
      localHashMap.put("param_channel", "0");
      localHashMap.put("param_errcode", String.valueOf(7));
      localHashMap.put("param_url", this.url);
      if (!QLog.isColorLevel()) {
        break;
      }
      Iterator localIterator = localHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str2 = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, str2 + (String)localObject);
      }
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(null, str1, false, 0L, 0L, localHashMap, "", true);
  }
  
  public static void m(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    for (;;)
    {
      synchronized (Bs)
      {
        Object localObject = Bs.iterator();
        if (((Iterator)localObject).hasNext())
        {
          if (((aool)((Iterator)localObject).next()).mUniseq != paramMessageRecord.uniseq) {
            continue;
          }
          return;
        }
        localObject = new aool();
        ((aool)localObject).cNy = false;
        ((aool)localObject).mPeerUin = paramMessageRecord.frienduin;
        ((aool)localObject).mBusiType = 131079;
        ((aool)localObject).mFileType = 131079;
        ((aool)localObject).mUniseq = paramMessageRecord.uniseq;
        ((aool)localObject).F = paramMessageRecord;
        ((aool)localObject).mSelfUin = paramMessageRecord.selfuin;
        if (paramQQAppInterface.a().a((aool)localObject)) {
          Bs.add(localObject);
        }
        if (QLog.isColorLevel())
        {
          if (ba(paramMessageRecord))
          {
            QLog.d("StructLongMessageDownloadProcessor", 2, "getStructLongMessage(oldLongMsg) , messageRecord,msgid= " + paramMessageRecord.uniseq);
            QLog.d("PaOldLongMsg", 2, "msgId=" + paramMessageRecord.uniseq + ", getStructLongMessage");
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download time start: " + System.currentTimeMillis());
          return;
        }
      }
      QLog.d("StructLongMessageDownloadProcessor", 2, "getStructLongMessage , messageRecord,msgid= " + paramMessageRecord.uniseq);
    }
  }
  
  public static void u(QQAppInterface paramQQAppInterface, long paramLong)
  {
    synchronized (Bs)
    {
      if ((Bs == null) || (Bs.size() == 0) || (paramQQAppInterface == null)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "deleteAllTask msgid" + paramLong);
      }
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null)
      {
        Iterator localIterator = Bs.iterator();
        while (localIterator.hasNext())
        {
          aool localaool = (aool)localIterator.next();
          if (localaool.mUniseq == paramLong)
          {
            paramQQAppInterface.bb(localaool.mPeerUin, localaool.mUniseq);
            Bs.remove(localaool);
            a(false, localaool.mSelfUin, localaool.mPeerUin, localaool.mUniseq, localaool);
          }
        }
      }
      return;
    }
  }
  
  public int KH()
  {
    return super.KH();
  }
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    if ((paramb != null) && (paramb.Hf != null) && (paramb.Hf.size() > 0) && ((paramb.Hf.get(0) instanceof aoql.b.h)))
    {
      parama = (aoql.b.h)paramb.Hf.get(0);
      if ((parama.a != null) && (parama.a.ret_code.get() == 0))
      {
        aJ(this.h.F.uniseq, parama.cmF);
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "actLongMessageTimeSSO", true, (System.nanoTime() - this.OD) / 1000000L, 0L, null, "", true);
        return;
      }
      this.errorCode = 1;
      onError();
      return;
    }
    if ((paramb != null) && (paramb.Hf != null) && (paramb.Hf.size() > 0) && ((paramb.Hf.get(0) instanceof aoql.b.i)))
    {
      paramb = (aoql.b.i)paramb.Hf.get(0);
      if (QLog.isColorLevel())
      {
        QLog.d("StructLongMessageDownloadProcessor", 2, "onBusiProtoResp->oldLongMsg procUrl:" + paramb.toString());
        QLog.d("PaOldLongMsg", 2, "msgId=" + this.h.F.uniseq + ", onBusiProtoResp->oldLongMsg procUrl:" + paramb.toString());
      }
      if (paramb.result == 0) {
        switch (paramb.mChannelType)
        {
        case 1: 
        default: 
          parama = "http://";
          aonh localaonh = (aonh)paramb.ipList.get(0);
          parama = parama + localaonh.mIp;
          if (localaonh.port != 80) {
            parama = parama + ":" + localaonh.port;
          }
          break;
        }
      }
    }
    for (;;)
    {
      parama = parama + paramb.cmH;
      this.fR = paramb.gi;
      aJ(this.h.F.uniseq, parama);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actOldLongMessageTimeSSO", true, (System.nanoTime() - this.OD) / 1000000L, 0L, null, "", true);
      return;
      parama = "http://";
      break;
      parama = "https://";
      break;
      this.errorCode = 1;
      onError();
      return;
      this.errorCode = 1;
      onError();
      return;
    }
  }
  
  public void aH(MessageRecord paramMessageRecord)
  {
    this.errorCode = 3;
    paramMessageRecord.saveExtInfoToExtStr("longMsg_State", String.valueOf(3));
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      localMessageForStructing.structingMsg.mMsgBrief = acfp.m(2131715008);
      localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
      this.app.b().c(this.h.mPeerUin, this.h.mUinType, localMessageForStructing.uniseq, localMessageForStructing.msgData);
      this.app.b().a(this.h.mPeerUin, this.h.mUinType, localMessageForStructing.uniseq, "extStr", localMessageForStructing.extStr);
      this.app.a().notifyUI(999, true, this.h.mPeerUin);
    }
    czy();
    d(this.errorCode, paramMessageRecord);
  }
  
  public boolean aY(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    long l;
    do
    {
      return false;
      l = NetConnInfoCenter.getServerTime();
    } while (paramMessageRecord.time >= l - 604800L);
    return true;
  }
  
  public void d(int paramInt, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Expired");
      if (ba(this.h.F)) {
        QLog.d("PaOldLongMsg", 2, "msgId=" + this.h.F.uniseq + ", resource expired!");
      }
    }
    if (ba(this.h.F)) {}
    HashMap localHashMap;
    for (String str1 = "actOldLongMessageDownload";; str1 = "actLongMessageDownload")
    {
      localHashMap = new HashMap();
      localHashMap.put("param_uin", paramMessageRecord.selfuin);
      localHashMap.put("param_puin", paramMessageRecord.frienduin);
      localHashMap.put("param_resid", paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid"));
      localHashMap.put("param_channel", "0");
      localHashMap.put("param_errcode", String.valueOf(paramInt));
      localHashMap.put("param_url", this.url);
      if (!QLog.isColorLevel()) {
        break;
      }
      paramMessageRecord = localHashMap.entrySet().iterator();
      while (paramMessageRecord.hasNext())
      {
        Object localObject = (Map.Entry)paramMessageRecord.next();
        String str2 = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, str2 + (String)localObject);
      }
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(null, str1, false, 0L, 0L, localHashMap, "", true);
  }
  
  public void dUR()
  {
    l(this.h.mUniseq);
    this.errorCode = 7;
    dWl();
  }
  
  public void dWl()
  {
    dWm();
  }
  
  public void doReport(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, String.format("LongMessage Download Beacon Report ErrCode=%d mReportedFlag=%x ", new Object[] { Integer.valueOf(this.errorCode), Integer.valueOf(this.dOZ) }) + hashCode());
    }
    if ((this.cLT) || ((paramBoolean) && ((this.dOZ & 0x2) > 0)) || ((!paramBoolean) && ((this.dOZ & 0x1) > 0))) {
      return;
    }
    int j = this.dOZ;
    int i;
    if (paramBoolean)
    {
      i = 2;
      this.dOZ = (i | j);
      if (!ba(this.h.F)) {
        break label435;
      }
    }
    long l;
    label435:
    for (String str1 = "actOldLongMessageDownload";; str1 = "actLongMessageDownload")
    {
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      this.mM.put("param_uin", this.h.F.selfuin);
      this.mM.put("param_puin", this.h.F.senderuin);
      this.mM.put("param_resid", this.h.F.getExtInfoFromExtStr("pub_long_msg_resid"));
      this.mM.put("param_ip_source", "" + this.dQz);
      this.mM.put("param_channel", "0");
      this.mM.put("param_errcode", String.valueOf(this.errorCode));
      this.mM.put("param_url", this.url);
      this.mM.put("param_http_error_code", String.valueOf(this.httpErrorCode));
      this.mM.put("param_android_error_code", String.valueOf(this.errCode));
      if (!QLog.isColorLevel()) {
        break label443;
      }
      Iterator localIterator = this.mM.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str2 = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, str2 + (String)localObject);
      }
      i = 1;
      break;
    }
    label443:
    if (paramBoolean) {
      anpc.a(BaseApplication.getContext()).collectPerformance(null, str1, true, l, this.apq, this.mM, "", true);
    }
    for (;;)
    {
      dVc();
      return;
      anpc.a(BaseApplication.getContext()).collectPerformance(null, str1, false, l, 0L, this.mM, "", true);
    }
  }
  
  public void l(long paramLong)
  {
    synchronized (Bs)
    {
      if ((Bs == null) || (Bs.size() == 0)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "cancelAllTask msgid" + paramLong);
      }
      aooi localaooi = this.app.a();
      if (localaooi != null)
      {
        Iterator localIterator = Bs.iterator();
        while (localIterator.hasNext())
        {
          aool localaool = (aool)localIterator.next();
          if (localaool.mUniseq == paramLong)
          {
            localaooi.bb(localaool.mPeerUin, localaool.mUniseq);
            Bs.remove(localaool);
          }
        }
      }
      return;
    }
  }
  
  public void onError()
  {
    super.onError();
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "msgId=" + this.h.F.uniseq + ", receiveError");
      if (ba(this.h.F)) {
        QLog.d("PaOldLongMsg", 2, "msgId=" + this.h.F.uniseq + ", receiveError");
      }
    }
    Wa(2005);
    VR(2005);
    czy();
  }
  
  public void onResp(aomh paramaomh)
  {
    i = 1;
    if (this.cNw) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
    }
    if (paramaomh == null) {
      return;
    }
    super.onResp(paramaomh);
    this.errCode = paramaomh.mErrCode;
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download time end: " + System.currentTimeMillis());
    }
    if ((paramaomh.b instanceof aoll))
    {
      hM("onResp", "result:" + paramaomh.mResult + " errCode:" + paramaomh.dPy + " errDesc:" + paramaomh.clO);
      this.httpErrorCode = paramaomh.dPy;
      aoll localaoll = (aoll)paramaomh.b;
      if (localaoll.bZ != null)
      {
        Iterator localIterator = iH.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (localaoll.bZ.equals(((aoll)localEntry.getValue()).bZ)) {
            iH.remove(localEntry.getKey());
          }
        }
      }
    }
    if (this.jdField_a_of_type_Aomg != null) {
      this.jdField_a_of_type_Aomg.f = null;
    }
    this.jdField_a_of_type_Aomg = null;
    if ((paramaomh.mResult == 0) && (paramaomh.mRespData != null) && (paramaomh.mRespData.length > 0))
    {
      paramaomh = paramaomh.mRespData;
      this.apq = paramaomh.length;
      if ((!(this.h.F instanceof MessageForStructing)) || (ba(this.h.F))) {}
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("StructLongMessageDownloadProcessor", 2, "onResp->oldLongMsg");
            QLog.d("PaOldLongMsg", 2, "msgId=" + this.h.F.uniseq + ", onResp->getStructMsgFromXmlBuff");
          }
          this.g = anre.a(E(paramaomh), -1);
        }
        catch (Exception paramaomh)
        {
          continue;
          i = 0;
          continue;
        }
        if ((this.h.F.istroop == 1008) && (this.g != null) && ((TextUtils.isEmpty(this.g.mMsgBrief)) || (this.g.mEmptyMsgBriefModified))) {
          this.g.mMsgBrief = AbsStructMsg.PA_DEFAULT_MSG_BRIEF;
        }
        if (this.g == null) {
          continue;
        }
        this.errorCode = 0;
        onSuccess();
        if (!ba(this.h.F)) {
          continue;
        }
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "actOldLongMessageTimeDownload", true, (System.nanoTime() - this.ahk) / 1000000L, 0L, null, "", true);
        return;
        this.g = anre.a(paramaomh, -1);
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actLongMessageTimeDownload", true, (System.nanoTime() - this.ahk) / 1000000L, 0L, null, "", true);
      return;
      if ((this.url != null) && (!"".equals(this.url))) {
        aokl.a().a().a(aonc.a(this.url));
      }
      if (this.cNw)
      {
        if (this.dQz == 5) {}
        for (i = 9;; i = 12)
        {
          this.dQz = i;
          dWk();
          return;
        }
      }
      this.errorCode = 12;
      onError();
      return;
    }
    if ((this.url != null) && (!"".equals(this.url))) {
      aokl.a().a().a(aonc.a(this.url));
    }
    if (((this.h.F instanceof MessageForStructing)) && (aY(this.h.F)) && (399 < this.httpErrorCode) && (this.httpErrorCode < 500))
    {
      if (i != 0)
      {
        aH(this.h.F);
        return;
      }
      if ((paramaomh.mErrCode == 9364) && (this.dOY < 3))
      {
        this.dOY += 1;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Fail. Net Changed. Retry " + this.dOY);
        }
        dVd();
        this.dQz = 15;
        dVq();
        return;
      }
      if (this.cNw)
      {
        if (this.dQz == 5) {}
        for (i = 8;; i = 11)
        {
          this.dQz = i;
          dWk();
          return;
        }
      }
      this.errorCode = 14;
      onError();
      return;
    }
  }
  
  public void onSuccess()
  {
    super.onSuccess();
    if (QLog.isColorLevel())
    {
      QLog.d("StructLongMessageDownloadProcessor", 2, "msgId=" + this.h.F.uniseq + ", receiveSuccess");
      if (ba(this.h.F)) {
        QLog.d("PaOldLongMsg", 2, "msgId=" + this.h.F.uniseq + ", receiveSuccess");
      }
    }
    Wa(2003);
    VR(2003);
    czy();
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Aomg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("StructLongMessageDownloadProcessor", 2, "Direct download failed timeout");
      }
      this.c.b(this.jdField_a_of_type_Aomg);
      this.jdField_a_of_type_Aomg = null;
    }
    if (this.dQz == 5) {}
    for (int i = 13;; i = 14)
    {
      this.dQz = i;
      if ((this.url != null) && (!"".equals(this.url))) {
        aokl.a().a().a(aonc.a(this.url));
      }
      dVq();
      return;
    }
  }
  
  public void start()
  {
    super.start();
    if (!aAq()) {
      dVq();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */