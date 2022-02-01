package com.tencent.mobileqq.transfile;

import akxb;
import akxb.a;
import alif;
import alig;
import alip;
import anot;
import anpc;
import anvq;
import aoji;
import aojn.a;
import aokl;
import aoko;
import aoko.b;
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
import aoql.a.d;
import aoql.b;
import aoql.b.f;
import aoqm;
import aqhq;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;
import mqq.os.MqqHandler;

public class GroupPttDownloadProcessor
  extends aoji
  implements aolm.a, aolm.c, Runnable
{
  protected anvq a;
  private aool.e a;
  private long apF;
  long apQ;
  private boolean cMn;
  String clM;
  private String clh;
  private MessageForPtt e;
  byte[] fM;
  boolean mIsGroup = true;
  private long mMsgTime;
  String mTempPath;
  
  public GroupPttDownloadProcessor(aooi paramaooi, aool paramaool)
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
          boolean bool = azU();
          if (bool)
          {
            if (i != 0)
            {
              if (!this.cMn) {
                continue;
              }
              aokl.a().a().clear(0);
            }
            this.clh = null;
            if (!paramBoolean) {
              break label139;
            }
            VT(4);
            if (QLog.isDevelopLevel()) {
              QLog.d("SPD", 4, "directDownloadIfCan error");
            }
            if (!bool) {
              break label147;
            }
            this.e.fileSize = 2005L;
            a(this.e);
            onError();
          }
        }
        else
        {
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
      label139:
      continue;
      label147:
      dVq();
    }
  }
  
  private void VT(int paramInt)
  {
    boolean bool = true;
    String str = "DiscussPTTDirectUrl";
    try
    {
      if (this.h.mUinType == 1) {
        str = "GroupPTTDirectUrl";
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      anpc localanpc = anpc.a(BaseApplication.getContext());
      if (paramInt == 0) {}
      for (;;)
      {
        localanpc.collectPerformance(null, str, bool, 0L, 0L, localHashMap, null);
        return;
        bool = false;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private boolean azU()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.errCode == -9527)
    {
      bool1 = bool2;
      if (this.errDesc != null) {
        if ((!this.errDesc.equals("T_203")) && (!this.errDesc.equals("H_400_-5103017")))
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
  
  public String AJ()
  {
    if (this.h.mUinType == 1) {
      return "actGrpPttDown";
    }
    return "actDisscusPttDown";
  }
  
  public int KH()
  {
    int i = 0;
    hM("uiParam", this.h.toString());
    String str = this.h.cmo;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (aqhq.rq(str)) || (str.startsWith("http://")))
    {
      dN(9302, f(new Exception("uuid illegal " + str)));
      onError();
      i = -1;
      return i;
    }
    this.e = ((MessageForPtt)this.h.F);
    this.jdField_a_of_type_Aool$e = ((aool.e)this.h.en);
    this.mMsgTime = this.e.msgTime;
    this.apF = this.e.msgRecTime;
    int j = this.e.voiceType;
    if ((this.h.clR == null) || (!aqhq.rq(this.h.dQ)))
    {
      if ((this.e.fullLocalPath == null) || (this.e.fullLocalPath.equals("")))
      {
        this.h.clR = n("group", str, j);
        label235:
        this.mTempPath = (this.h.clR + "~tmp");
      }
    }
    else {
      if (1 != this.h.mUinType) {
        break label416;
      }
    }
    label416:
    for (boolean bool = true;; bool = false)
    {
      this.mIsGroup = bool;
      this.fM = h(this.h.mMd5, this.h.cmo);
      this.apQ = this.h.apQ;
      this.clM = this.h.clM;
      if (this.fM != null) {
        break;
      }
      dN(9302, f(new Exception("convert md5 error,md5:" + this.h.mMd5 + "  uuid:" + this.h.cmo)));
      onError();
      return -1;
      this.h.clR = this.e.fullLocalPath;
      break label235;
    }
  }
  
  void RV(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.contains("voice_codec="))
    {
      localObject = this.e;
      localObject = paramString + "&voice_codec=" + ((MessageForPtt)localObject).voiceType;
    }
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.jdField_a_of_type_Aolm$c = this;
    localaoll.bZ = ((String)localObject);
    localaoll.mHttpMethod = 0;
    localaoll.P = this.xp;
    localaoll.atY = this.h.clR;
    localaoll.jdField_a_of_type_Aolm$a = this;
    localaoll.mTempPath = this.mTempPath;
    localaoll.mMsgId = String.valueOf(this.h.mUniseq);
    localaoll.dPG = this.h.mUinType;
    localaoll.mFileType = this.h.mFileType;
    localaoll.apS = 0L;
    localaoll.cMU = true;
    localaoll.u.put("Accept-Encoding", "identity");
    if (this.clh != null)
    {
      localaoll.mExcuteTimeLimit = 60000L;
      localaoll.mContinuErrorLimit = 0;
    }
    localaoll.cMV = true;
    localaoll.cMJ = true;
    localObject = null;
    paramString = (String)localObject;
    if (this.xp != null)
    {
      paramString = (String)localObject;
      if (!this.xp.isEmpty()) {
        paramString = Arrays.toString(this.xp.toArray());
      }
    }
    hM("httpDown", "directMsgUrlDown:" + this.cLM + " ipList:" + paramString + " uuid:" + this.h.cmo + " FileID:" + this.h.apQ + " downOffset:" + localaoll.apS);
    if (!azR()) {
      return;
    }
    this.jdField_a_of_type_Aomg = localaoll;
    dVe();
    this.jdField_c_of_type_Aolm.a(localaoll);
  }
  
  public QQMessageFacade.Message a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.serial();
    this.app.b().c(this.h.mPeerUin, this.h.mUinType, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    return this.app.b().a(this.h.mPeerUin, this.h.mUinType);
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
        parama = (aoql.b.f)paramb.Hf.get(i);
        if (QLog.isColorLevel()) {
          hM("procUrl", parama.toString());
        }
        this.cLU = parama.cOc;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.cLU);
        }
        a(this.jdField_a_of_type_Aojn$a, parama);
        if (parama.result == 0)
        {
          this.ckY = parama.cmE;
          this.ckX = parama.urlPath;
          this.xp = i(parama.Bw, parama.xp);
          if (this.ckY != null)
          {
            parama = new aonh();
            parama.cNn = true;
            parama.mIp = this.ckY;
            this.xp.add(parama);
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
  
  void dVH()
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    aoql.a locala = new aoql.a();
    aoql.a.d locald = new aoql.a.d();
    locald.selfUin = this.h.mSelfUin;
    locald.peerUin = this.h.mPeerUin;
    locald.cmC = this.h.cmn;
    locald.uinType = this.h.mUinType;
    locald.groupFileID = this.apQ;
    hM("SendRequest", " SendRequest GrpFileKey:" + this.clM);
    locald.cmz = this.clM;
    locald.md5 = this.fM;
    locald.voiceType = this.e.voiceType;
    locald.dRl = this.h.dpB;
    locala.b = this;
    locala.cmy = "grp_ptt_dw";
    locala.He.add(locald);
    locala.a = this.app.getProtoReqManager();
    if (!azQ())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
      onError();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        hM("requestStart", locala.toString());
      }
    } while (!azR());
    this.jdField_a_of_type_Aoql$a = locala;
    aoqm.c(locala);
  }
  
  public void dVe()
  {
    if ((this.jdField_a_of_type_Aomg != null) && ((this.jdField_a_of_type_Aomg instanceof aoll)))
    {
      if (this.mIsGroup) {
        ((aoll)this.jdField_a_of_type_Aomg).bZ = MsfSdkUtils.insertMtype("pttGd", ((aoll)this.jdField_a_of_type_Aomg).bZ);
      }
    }
    else {
      return;
    }
    ((aoll)this.jdField_a_of_type_Aomg).bZ = MsfSdkUtils.insertMtype("pttDd", ((aoll)this.jdField_a_of_type_Aomg).bZ);
  }
  
  void dVq()
  {
    VR(2001);
    dVH();
  }
  
  void dVr()
  {
    this.jdField_b_of_type_Aojn$a.dVf();
    Object localObject = null;
    if (this.cLV)
    {
      this.ckY = "grouptalk.c2c.qq.com";
      this.xp.clear();
    }
    aonh localaonh;
    String str;
    if ((this.xp != null) && (this.xp.size() > 0))
    {
      localaonh = (aonh)this.xp.get(0);
      if ((localaonh.isIpv6) && (!localaonh.mIp.startsWith("[")))
      {
        str = "[" + localaonh.mIp + "]";
        localObject = str;
        if (localaonh.port != 80) {
          localObject = str + ":" + localaonh.port;
        }
        this.xp.remove(0);
      }
    }
    for (;;)
    {
      str = "http://" + (String)localObject;
      RV(str + this.ckX);
      return;
      str = localaonh.mIp;
      break;
      if (this.ckY != null) {
        localObject = this.ckY;
      }
    }
  }
  
  public void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (aona.lQ(this.errCode))) {
      break label14;
    }
    label14:
    while ((this.cLT) || ((paramBoolean) && ((this.dOZ & 0x2) > 0)) || ((!paramBoolean) && ((this.dOZ & 0x1) > 0))) {
      return;
    }
    int j = this.dOZ;
    label59:
    long l1;
    boolean bool;
    if (paramBoolean)
    {
      i = 2;
      this.dOZ = (i | j);
      l1 = (System.nanoTime() - this.mStartTime) / 1000000L;
      localObject = this.d.fB(1) + ";" + this.jdField_a_of_type_Aojn$a.fB(2) + ";" + this.jdField_b_of_type_Aojn$a.fB(3) + ";" + this.jdField_c_of_type_Aojn$a.fB(4);
      this.mM.put("param_step", localObject);
      this.mM.put("param_grpUin", this.h.mPeerUin);
      this.mM.put("param_uuid", this.h.cmo);
      this.mM.put("param_quickHttp", String.valueOf(this.cLU));
      this.mM.put("param_pttOpt", String.valueOf(alig.a(this.app, this.cMn)));
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder().append("GroupPttDownload success: ").append(paramBoolean).append(", cost: ").append(l1).append(" directDownloadIfCan: ");
        if (this.clh == null) {
          break label392;
        }
        bool = true;
        label298:
        QLog.d("SPD", 4, bool);
      }
      if (!paramBoolean) {
        break label398;
      }
      P(true, l1);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), true, l1, this.apq, this.mM, "");
    }
    label392:
    label398:
    do
    {
      dVc();
      if (this.e == null) {
        break;
      }
      alip.a(this.app).a(paramBoolean, this.errCode, this.jdField_a_of_type_Aool$e, this.e);
      return;
      i = 1;
      break label59;
      bool = false;
      break label298;
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
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), false, l1, 0L, this.mM, "");
    } while ((this.errCode != -9527) || (this.errDesc == null));
    int i = 0;
    if (this.errDesc.equals("T_203"))
    {
      i = 1;
      label561:
      if (i == 0) {
        break label804;
      }
      if (this.apF > this.mMsgTime) {
        if (!this.mIsGroup) {
          break label806;
        }
      }
    }
    label804:
    label806:
    for (Object localObject = "actGroupPTTOutOfTime";; localObject = "actDiscussionPTTOutOfTime")
    {
      HashMap localHashMap = new HashMap();
      long l3 = System.currentTimeMillis() / 1000L;
      l1 = (this.apF - this.mMsgTime) / 86400L;
      long l2 = (l3 - this.mMsgTime) / 86400L;
      l3 = (l3 - this.apF) / 86400L;
      localHashMap.put("MsgOff", String.valueOf(l1));
      localHashMap.put("PttOff", String.valueOf(l3));
      localHashMap.put("OutOfTimeReason", String.valueOf(i));
      localHashMap.put("param_FailCode", String.valueOf(l2));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, (String)localObject, false, 0L, 0L, localHashMap, null);
      if (this.h.en == null) {
        break;
      }
      localObject = (aool.e)this.h.en;
      anot.a(this.app, "CliOper", "", "", "0X80059B3", "0X80059B3", aomq.aP(((aool.e)localObject).mFromType, ((aool.e)localObject).dQP), 0, "", "", "", "3.4.4");
      break;
      if (!this.errDesc.equals("H_400_-5103017")) {
        break label561;
      }
      i = 16;
      break label561;
      break;
    }
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
    Object localObject;
    aoko.b localb;
    boolean bool;
    if (this.clh != null)
    {
      localObject = this.d;
      localb = this.jdField_b_of_type_Aoko.b;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      if (paramaomh.mResult != 0) {
        break label234;
      }
      bool = true;
      label37:
      a((aojn.a)localObject, paramaomh, bool);
      localObject = new StringBuilder().append(" result:");
      if (paramaomh.mResult != 0) {
        break label239;
      }
      bool = true;
      label67:
      hM("onHttpResp", bool);
      this.apq = paramaomh.apU;
      if (this.jdField_a_of_type_Aomg != null) {
        this.jdField_a_of_type_Aomg.f = null;
      }
      if (this.apq <= 0L) {
        this.apq = (paramaomh.apV + paramaomh.b.apS);
      }
      this.apr += paramaomh.apW;
      localb.clF = ((String)paramaomh.nR.get("param_rspHeader"));
      if (paramaomh.mResult != 0) {
        break label244;
      }
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
      localObject = this.jdField_b_of_type_Aojn$a;
      localb = this.jdField_b_of_type_Aoko.a;
      break;
      label234:
      bool = false;
      break label37;
      label239:
      bool = false;
      break label67;
      label244:
      if (this.clh != null)
      {
        QY(false);
      }
      else
      {
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
  }
  
  public void onSuccess()
  {
    this.e.url = MessageForPtt.getMsgFilePath(this.e.voiceType, this.h.clR);
    this.e.fileSize = this.apq;
    this.e.urlAtServer = this.h.cmo;
    super.onSuccess();
    Object localObject = a(this.e);
    if ((localObject != null) && (((QQMessageFacade.Message)localObject).pttUrl != null) && (((QQMessageFacade.Message)localObject).pttUrl.equals(this.h.cmo))) {
      ((QQMessageFacade.Message)localObject).pttUrl = this.h.clR;
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
    VR(2001);
    Object localObject = this.app;
    if (this.h.mUinType == 1) {}
    for (int i = 3;; i = 2)
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
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */