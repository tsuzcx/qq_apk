package com.tencent.mobileqq.transfile;

import akxb;
import akxb.a;
import alif;
import alig;
import alip;
import android.text.TextUtils;
import anot;
import anpc;
import anqo;
import anqp;
import anvq;
import aoji;
import aojn.a;
import aokl;
import aoll;
import aolm;
import aolm.a;
import aolm.c;
import aomg;
import aomh;
import aomq;
import aona;
import aonc;
import aonh;
import aooi;
import aool;
import aool.e;
import aoql.a;
import aoql.a.b;
import aoql.b;
import aoql.b.c;
import aoqm;
import aqhq;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import mqq.manager.ProxyIpManager;
import mqq.os.MqqHandler;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;

public class C2CPttDownloadProcessor
  extends aoji
  implements aolm.a, aolm.c, Runnable
{
  protected anvq a;
  private aool.e a;
  private long apF;
  private boolean cMn;
  private String clh;
  private MessageForPtt e;
  String[] hm = null;
  private long mMsgTime;
  String mTempPath;
  
  public C2CPttDownloadProcessor(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    this.Ha = ((ProxyIpManager)this.app.getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_Anvq = ((anvq)this.app.getManager(17));
  }
  
  private void QY(boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.clh != null)
        {
          if ((this.errCode == -9527) && (this.errDesc != null) && (this.errDesc.equals("H_400_-5103017")))
          {
            if (i != 0)
            {
              if (!this.cMn) {
                continue;
              }
              aokl.a().a().clear(0);
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("SPD", 4, "c2c directDownloadIfCan error");
            }
            if (!paramBoolean) {
              break label160;
            }
            VT(4);
            if (!azU()) {
              break label168;
            }
            this.e.fileSize = 2005L;
            a(this.e);
            onError();
            this.clh = null;
          }
        }
        else {
          return;
        }
        if (this.errCode == 9366) {
          continue;
        }
        i = 1;
        continue;
        aokl.a().onFailed(16, this.clh);
        continue;
        VT(3);
      }
      finally {}
      label160:
      continue;
      label168:
      dVq();
    }
  }
  
  private void VT(int paramInt)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      anpc localanpc = anpc.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext());
      if (paramInt == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localanpc.collectPerformance(null, "C2CPTTDirectUrl", bool, 0L, 0L, localHashMap, null);
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private cmd0x346.ReqBody a()
  {
    int j = 17;
    cmd0x346.DownloadSuccReq localDownloadSuccReq = new cmd0x346.DownloadSuccReq();
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(this.h.mSelfUin));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.h.cmo));
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(1000);
    localReqBody.uint32_seq.set(0);
    int i;
    if ("ftn".equals(this.ckZ)) {
      i = 3;
    }
    for (;;)
    {
      localReqBody.uint32_business_id.set(i);
      localReqBody.uint32_client_type.set(104);
      localReqBody.msg_download_succ_req.set(localDownloadSuccReq);
      return localReqBody;
      i = j;
      if ("pttcenter".equals(this.ckZ)) {
        i = j;
      }
    }
  }
  
  private boolean azU()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.errCode == -9527)
    {
      bool1 = bool2;
      if (this.errDesc != null) {
        if (!this.errDesc.equals("H_400_-5103017"))
        {
          bool1 = bool2;
          if (!this.errDesc.equals("H_400_-5103039")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private File b(long paramLong1, long paramLong2)
  {
    Object localObject = anqo.a(paramLong1, paramLong2);
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, "try get stream info " + paramLong1 + " " + paramLong2 + " " + localObject);
    }
    if (localObject != null)
    {
      anqp localanqp = (anqp)((Map.Entry)localObject).getValue();
      if (localanqp != null)
      {
        anqo.py((String)((Map.Entry)localObject).getKey());
        localanqp.Qs(false);
        localObject = localanqp.getFile();
        if ((localObject != null) && (((File)localObject).exists())) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void dVs()
  {
    hM("setSuccess", "req");
    String str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    if ("pttcenter".equals(this.ckZ)) {
      str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    }
    ProtoReqManager.c localc;
    for (;;)
    {
      cmd0x346.ReqBody localReqBody = a();
      localc = new ProtoReqManager.c();
      localc.clW = str;
      localc.fW = localReqBody.toByteArray();
      localc.dPR = 1;
      localc.daB = 30000;
      localc.tryCount = 1;
      localc.a = this;
      if (azQ()) {
        break;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
      onError();
      return;
      if ("ftn".equals(this.ckZ)) {
        str = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_DOWNLOAD_SUCC-1000";
      }
    }
    this.app.getProtoReqManager().b(localc);
  }
  
  public String AJ()
  {
    return "actC2CPttDownload";
  }
  
  public int KH()
  {
    super.KH();
    hM("uiParam", this.h.toString());
    Object localObject1 = this.h.cmo;
    Object localObject2 = this.app.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
    if ((localObject2 != null) && (((MessageRecord)localObject2).getPttStreamFlag() == 10001)) {
      this.cLT = true;
    }
    if ((localObject1 == null) || (((String)localObject1).equals("")) || (((String)localObject1).equals("null")) || (aqhq.rq((String)localObject1)) || (((String)localObject1).startsWith("http://")))
    {
      dN(9302, f(new Exception("uuid illegal " + (String)localObject1)));
      onError();
      return -1;
    }
    this.e = ((MessageForPtt)this.h.F);
    this.jdField_a_of_type_Aool$e = ((aool.e)this.h.en);
    this.mMsgTime = this.e.msgTime;
    this.apF = this.e.msgRecTime;
    int i = this.e.voiceType;
    if ((this.h.clR == null) || (!aqhq.rq(this.h.dQ))) {
      if ((this.e.fullLocalPath != null) && (!this.e.fullLocalPath.equals(""))) {
        break label383;
      }
    }
    label383:
    for (this.h.clR = n("c2c", (String)localObject1, i);; this.h.clR = this.e.fullLocalPath)
    {
      this.mTempPath = (this.h.clR + "~tmp");
      localObject1 = b(this.h.F.msgUid, this.h.F.shmsgseq);
      if (localObject1 != null)
      {
        localObject2 = new File(this.mTempPath);
        if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
          ((File)localObject2).delete();
        }
        ((File)localObject1).renameTo((File)localObject2);
      }
      return 0;
    }
  }
  
  void RV(String paramString)
  {
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.jdField_a_of_type_Aolm$c = this;
    localaoll.bZ = paramString;
    localaoll.mHttpMethod = 0;
    localaoll.P = this.xp;
    localaoll.atY = this.h.clR;
    localaoll.mMsgId = String.valueOf(this.h.mUniseq);
    localaoll.dPG = this.h.mUinType;
    localaoll.mFileType = this.h.mFileType;
    localaoll.apS = 0L;
    localaoll.cMU = true;
    localaoll.u.put("Accept-Encoding", "identity");
    localaoll.cMV = true;
    localaoll.jdField_a_of_type_Aolm$a = this;
    localaoll.mTempPath = this.mTempPath;
    localaoll.cMJ = true;
    if (this.clh != null)
    {
      localaoll.mExcuteTimeLimit = 120000L;
      localaoll.mContinuErrorLimit = 0;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.xp != null)
    {
      localObject1 = localObject2;
      if (!this.xp.isEmpty()) {
        localObject1 = Arrays.toString(this.xp.toArray());
      }
    }
    paramString = aonc.ow(paramString);
    hM("httpDown", "RespDomain: " + paramString + " ipList:" + (String)localObject1 + " uuid:" + this.h.cmo + " downOffset:" + localaoll.apS);
    if (!azR()) {
      return;
    }
    this.jdField_a_of_type_Aomg = localaoll;
    dVe();
    this.jdField_c_of_type_Aolm.a(localaoll);
  }
  
  QQMessageFacade.Message a(MessageForPtt paramMessageForPtt)
  {
    Object localObject = null;
    try
    {
      paramMessageForPtt.serial();
      this.app.b().c(this.h.mPeerUin, this.h.mUinType, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      paramMessageForPtt = this.app.b().a(this.h.mPeerUin, 0);
      return paramMessageForPtt;
    }
    catch (Exception localException)
    {
      do
      {
        paramMessageForPtt = localObject;
      } while (!QLog.isColorLevel());
      QLog.d("BaseTransProcessor", 2, "updatedb", localException);
    }
    return null;
  }
  
  public void a(aomg paramaomg, aomh paramaomh)
  {
    if ((paramaomg == null) || (paramaomh == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramaomg instanceof aoll));
      paramaomg = (aoll)paramaomg;
      paramaomg.apS += paramaomh.apW;
    } while (0L != paramaomg.apT);
    paramaomh.apW = 0L;
    paramaomh = "bytes=" + paramaomg.apS + "-";
    paramaomg.u.put("Range", paramaomh);
  }
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    this.jdField_a_of_type_Aoql$a = null;
    if (paramb != null)
    {
      int i = 0;
      while (i < paramb.Hf.size())
      {
        parama = (aoql.b.c)paramb.Hf.get(i);
        if (QLog.isColorLevel()) {
          hM("procUrl", parama.toString());
        }
        this.cLU = parama.cOc;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.cLU);
        }
        a(this.jdField_a_of_type_Aojn$a, parama);
        if (parama.result == 0)
        {
          this.bMt = parama.downloadUrl;
          this.jdField_b_of_type_Aoko.fileUrl = this.bMt;
          if ((parama.cmE != null) && (parama.cmE.length() > 0)) {
            this.ckY = parama.cmE;
          }
          this.xp = i(parama.Bw, parama.xp);
          if ((this.Ha != null) && (!this.Ha.isEmpty()))
          {
            parama = aonc.a(this.bMt);
            if (parama != null) {
              this.xp.add(parama);
            }
          }
          if (this.cLV)
          {
            this.ckY = "grouptalk.c2c.qq.com";
            this.xp.clear();
          }
          dVr();
          i += 1;
        }
        else
        {
          onError();
        }
      }
    }
  }
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    f(null, paramd.g, paramd.g.getWupBuffer());
  }
  
  public void dVe()
  {
    if ((this.jdField_a_of_type_Aomg != null) && ((this.jdField_a_of_type_Aomg instanceof aoll))) {
      ((aoll)this.jdField_a_of_type_Aomg).bZ = MsfSdkUtils.insertMtype("pttCd", ((aoll)this.jdField_a_of_type_Aomg).bZ);
    }
  }
  
  void dVq()
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    Object localObject = this.app.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
    if ((localObject != null) && ((localObject instanceof MessageForPtt)))
    {
      this.ckZ = ((MessageForPtt)localObject).storageSource;
      localObject = new aoql.a();
      aoql.a.b localb = new aoql.a.b();
      localb.selfUin = this.h.mSelfUin;
      localb.peerUin = this.h.mPeerUin;
      localb.cmC = this.h.cmn;
      localb.uinType = this.h.mUinType;
      localb.uuid = this.h.cmo;
      localb.storageSource = this.ckZ;
      localb.cNX = this.h.cNz;
      MessageForPtt localMessageForPtt = this.e;
      localb.voiceType = localMessageForPtt.voiceType;
      localb.autoToText = localMessageForPtt.autoToText;
      if (1008 == localb.uinType) {
        localb.busiType = this.e.busiType;
      }
      localb.dRl = this.h.dpB;
      ((aoql.a)localObject).b = this;
      ((aoql.a)localObject).cmy = "c2c_ptt_dw";
      ((aoql.a)localObject).He.add(localb);
      ((aoql.a)localObject).a = this.app.getProtoReqManager();
      if (azQ()) {
        break label284;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
      onError();
    }
    label284:
    do
    {
      return;
      this.ckZ = "pttcenter";
      hM("findDbRec", "not found");
      break;
      if (QLog.isColorLevel()) {
        hM("requestStart", ((aoql.a)localObject).toString());
      }
    } while (!azR());
    this.jdField_a_of_type_Aoql$a = ((aoql.a)localObject);
    aoqm.c((aoql.a)localObject);
  }
  
  void dVr()
  {
    this.jdField_b_of_type_Aojn$a.dVf();
    String str = this.bMt;
    if (TextUtils.isEmpty(this.ckY)) {
      this.ckY = "grouptalk.c2c.qq.com";
    }
    if ((this.xp != null) && (this.xp.size() > 0))
    {
      str = aonc.bJ(str, ((aonh)this.xp.get(0)).ox(str));
      this.xp.remove(0);
    }
    for (;;)
    {
      k(this.xp, this.ckY);
      RV(str);
      return;
      str = os(str);
    }
  }
  
  public void doReport(boolean paramBoolean)
  {
    boolean bool = true;
    if ((!paramBoolean) && (aona.lQ(this.errCode))) {
      break label17;
    }
    label17:
    while ((this.cLT) || ((paramBoolean) && ((this.dOZ & 0x2) > 0)) || ((!paramBoolean) && ((this.dOZ & 0x1) > 0))) {
      return;
    }
    int j = this.dOZ;
    int i;
    label62:
    long l1;
    Object localObject;
    if (paramBoolean)
    {
      i = 2;
      this.dOZ = (i | j);
      l1 = (System.nanoTime() - this.mStartTime) / 1000000L;
      localObject = this.d.fB(1) + ";" + this.jdField_a_of_type_Aojn$a.fB(2) + ";" + this.jdField_b_of_type_Aojn$a.fB(3) + ";" + this.jdField_c_of_type_Aojn$a.fB(4);
      this.mM.put("param_step", localObject);
      this.mM.put("param_fromUin", this.h.mPeerUin);
      this.mM.put("param_uuid", this.h.cmo);
      this.mM.put("param_writtenSize", String.valueOf(this.apr));
      this.mM.put("param_quickHttp", String.valueOf(this.cLU));
      this.mM.put("param_pttOpt", String.valueOf(alig.a(this.app, this.cMn)));
      if (QLog.isColorLevel()) {
        QLog.d("BaseTransProcessor", 2, "totle=" + this.apq + " written=" + this.apr);
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder().append("C2cPttDownload success: ").append(paramBoolean).append(", cost: ").append(l1).append(" directDownloadIfCan: ");
        if (this.clh == null) {
          break label461;
        }
        label364:
        QLog.d("SPD", 4, bool);
      }
      if (!paramBoolean) {
        break label467;
      }
    }
    for (;;)
    {
      try
      {
        P(true, l1);
        anpc.a(com.tencent.qphone.base.util.BaseApplication.getContext()).collectPerformance(null, AJ(), true, l1, this.apq, this.mM, "");
        dVc();
      }
      catch (Exception localException)
      {
        label461:
        label467:
        long l3;
        long l2;
        aool.e locale;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("BaseTransProcessor", 2, "report exception =" + localException.toString());
        continue;
        String str = "0X80059B4";
        continue;
      }
      localObject = this.e;
      if (localObject == null) {
        break;
      }
      alip.a(this.app).a(paramBoolean, this.errCode, this.jdField_a_of_type_Aool$e, (MessageForPtt)localObject);
      return;
      i = 1;
      break label62;
      bool = false;
      break label364;
      if (this.errCode != -9527) {
        this.mM.remove("param_rspHeader");
      }
      this.mM.put("param_FailCode", String.valueOf(this.errCode));
      this.mM.put("param_errorDesc", this.errDesc);
      if ((this.jdField_a_of_type_Aomg instanceof aoll))
      {
        localObject = aonc.a(((aoll)this.jdField_a_of_type_Aomg).bZ);
        if (localObject != null) {
          this.mM.put("param_reqIp", ((aonh)localObject).mIp);
        }
      }
      P(false, l1);
      anpc.a(com.tencent.qphone.base.util.BaseApplication.getContext()).collectPerformance(null, AJ(), false, l1, 0L, this.mM, "");
      if ((this.errCode == -9527) && (this.errDesc != null) && (this.errDesc.equals("H_400_-5103017")))
      {
        if (this.apF > this.mMsgTime)
        {
          localObject = new HashMap();
          l3 = System.currentTimeMillis() / 1000L;
          l1 = (this.apF - this.mMsgTime) / 86400L;
          l2 = (l3 - this.mMsgTime) / 86400L;
          l3 = (l3 - this.apF) / 86400L;
          ((HashMap)localObject).put("MsgOff", String.valueOf(l1));
          ((HashMap)localObject).put("PttOff", String.valueOf(l3));
          ((HashMap)localObject).put("OutOfTimeReason", String.valueOf(256));
          ((HashMap)localObject).put("param_FailCode", String.valueOf(l2));
          anpc.a(com.tencent.qphone.base.util.BaseApplication.getContext()).collectPerformance(null, "actC2CPTTOutOfTime", false, 0L, 0L, (HashMap)localObject, null);
        }
        if (this.h.en != null)
        {
          if (this.h.mUinType != 0) {
            continue;
          }
          localObject = "0X80059B2";
          locale = (aool.e)this.h.en;
          anot.a(this.app, "CliOper", "", "", (String)localObject, (String)localObject, aomq.aP(locale.mFromType, locale.dQP), 0, "", "", "", "3.4.4");
        }
      }
    }
  }
  
  /* Error */
  protected void f(com.tencent.qphone.base.remote.ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 313
    //   4: ldc_w 1023
    //   7: invokevirtual 319	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokevirtual 1026	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   14: sipush 1000
    //   17: if_icmpeq +38 -> 55
    //   20: aload_2
    //   21: invokevirtual 1026	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   24: istore 4
    //   26: aload_0
    //   27: ldc_w 1028
    //   30: new 264	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 1030
    //   40: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload 4
    //   45: invokevirtual 1033	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 319	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: return
    //   55: new 1035	tencent/im/cs/cmd0x346/cmd0x346$RspBody
    //   58: dup
    //   59: invokespecial 1036	tencent/im/cs/cmd0x346/cmd0x346$RspBody:<init>	()V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_3
    //   65: invokevirtual 1040	tencent/im/cs/cmd0x346/cmd0x346$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   68: pop
    //   69: aload_1
    //   70: getfield 1041	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   73: invokevirtual 1044	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   76: ifeq +91 -> 167
    //   79: aload_1
    //   80: getfield 1041	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   83: invokevirtual 1046	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   86: i2l
    //   87: lstore 5
    //   89: lload 5
    //   91: ldc2_w 1047
    //   94: lcmp
    //   95: ifne -41 -> 54
    //   98: aload_1
    //   99: getfield 1052	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   102: invokevirtual 1055	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:has	()Z
    //   105: ifeq -51 -> 54
    //   108: aload_1
    //   109: getfield 1052	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   112: invokevirtual 1058	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: checkcast 1054	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp
    //   118: getfield 1062	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   121: invokevirtual 1065	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   124: istore 4
    //   126: invokestatic 262	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq -75 -> 54
    //   132: aload_0
    //   133: ldc_w 1028
    //   136: new 264	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 1067
    //   146: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload 4
    //   151: invokevirtual 1033	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 319	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: return
    //   161: astore_1
    //   162: aload_1
    //   163: invokevirtual 1070	java/lang/Exception:printStackTrace	()V
    //   166: return
    //   167: ldc2_w 1071
    //   170: lstore 5
    //   172: goto -83 -> 89
    //   175: astore_1
    //   176: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	C2CPttDownloadProcessor
    //   0	177	1	paramToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   0	177	2	paramFromServiceMsg	FromServiceMsg
    //   0	177	3	paramArrayOfByte	byte[]
    //   24	126	4	i	int
    //   87	84	5	l	long
    // Exception table:
    //   from	to	target	type
    //   55	63	161	java/lang/Exception
    //   69	89	161	java/lang/Exception
    //   98	160	161	java/lang/Exception
    //   63	69	175	java/lang/Exception
  }
  
  public void g(aomh paramaomh)
  {
    this.jdField_a_of_type_Aomy.mFileSize = this.apr;
    a(paramaomh, false, "actRichMediaNetMonitor_pttDown", this.h.cmo);
  }
  
  public void onError()
  {
    super.onError();
    if (this.h.b != null)
    {
      akxb.a locala = new akxb.a();
      locala.result = -1;
      this.h.b.a(locala);
      return;
    }
    VR(2005);
  }
  
  public void onResp(aomh paramaomh)
  {
    super.onResp(paramaomh);
    aojn.a locala;
    boolean bool;
    if (this.clh != null)
    {
      locala = this.d;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      StringBuilder localStringBuilder = new StringBuilder().append(" result:");
      if (paramaomh.mResult != 0) {
        break label194;
      }
      bool = true;
      label48:
      hM("onHttpResp", bool);
      if (paramaomh.mResult != 0) {
        break label199;
      }
      bool = true;
      label73:
      a(locala, paramaomh, bool);
      this.apq = paramaomh.apU;
      if (this.apq <= 0L) {
        this.apq = (paramaomh.apV + paramaomh.b.apS);
      }
      this.apr += paramaomh.apW;
      if (paramaomh.mResult != 0) {
        break label204;
      }
      dVs();
      onSuccess();
      this.jdField_a_of_type_Aomy.mFileSize = this.apr;
      a(paramaomh, true, "actRichMediaNetMonitor_pttDown", this.h.cmo);
      if (this.clh != null) {
        VT(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aomg = null;
      return;
      locala = this.jdField_b_of_type_Aojn$a;
      break;
      label194:
      bool = false;
      break label48;
      label199:
      bool = false;
      break label73;
      label204:
      if (this.clh != null)
      {
        QY(false);
        return;
      }
      if ((paramaomh.mErrCode == 9364) && (this.dOY < 3))
      {
        hM("[netChg]", "failed.but net change detect.so retry");
        this.jdField_a_of_type_Aomg = null;
        this.dOY += 1;
        dVd();
        dVq();
        return;
      }
      onError();
    }
  }
  
  public void onSuccess()
  {
    super.onSuccess();
    this.e.url = MessageForPtt.getMsgFilePath(this.e.voiceType, this.h.clR);
    this.e.fileSize = this.apq;
    this.e.urlAtServer = this.h.cmo;
    Object localObject = a(this.e);
    if ((localObject != null) && (this.h.cmo != null) && (this.h.cmo.equals(((QQMessageFacade.Message)localObject).pttUrl))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.h.clR;
    }
    if (this.jdField_a_of_type_Anvq.m(this.e))
    {
      anot.a(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Anvq.b(this.e, 2);
    }
    if (this.h.b != null)
    {
      localObject = new akxb.a();
      ((akxb.a)localObject).result = 0;
      this.h.b.a((akxb.a)localObject);
      return;
    }
    VR(2003);
  }
  
  public String os(String paramString)
  {
    String str = null;
    if (paramString.startsWith("http://")) {
      str = "http://" + this.ckY;
    }
    for (;;)
    {
      return aonc.bJ(paramString, str + "/");
      if (paramString.startsWith("https://")) {
        str = "https://" + this.ckY;
      }
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Aomg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.clh);
      }
      this.jdField_c_of_type_Aolm.b(this.jdField_a_of_type_Aomg);
      this.jdField_a_of_type_Aomg = null;
    }
    QY(true);
  }
  
  public void start()
  {
    if (this.e.extFlag == -1L) {
      this.e.extFlag = 0L;
    }
    if (this.jdField_a_of_type_Aool$e.mFromType == 6)
    {
      localObject = this.e;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.start();
    Object localObject = this.app;
    if (this.h.mUinType == 0) {}
    for (int i = 1;; i = 4)
    {
      aomq.b((QQAppInterface)localObject, i, false, 2);
      if (!this.h.clR.equals(this.e.fullLocalPath))
      {
        this.e.fullLocalPath = this.h.clR;
        a(this.e);
      }
      dVq();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */