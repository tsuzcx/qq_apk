import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class aoju
  extends aojj
{
  public aoju() {}
  
  public aoju(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    this.jdField_b_of_type_Aoko.fileType = this.h.mFileType;
    this.jdField_b_of_type_Aoko.uniseq = this.h.mUniseq;
    this.jdField_b_of_type_Aoko.apI = this.h.apI;
  }
  
  protected String AJ()
  {
    if (this.h.mFileType == 65537) {
      return "actC2CPicSmallDownV1";
    }
    return "actC2CPicDownloadV1";
  }
  
  public int KH()
  {
    hM("uiParam", this.h.toString());
    String str = this.h.cmo;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (aqhq.rq(str)) || (str.startsWith("http")))
    {
      dN(9302, f(new Exception("uuid illegal " + str)));
      onError();
      return -1;
    }
    if ((this.h.mOut == null) && (this.h.cNA))
    {
      dN(9302, f(new Exception("no output stream")));
      onError();
      return -1;
    }
    if ((this.h.en == null) || (!(this.h.en instanceof aool.c)))
    {
      dN(9302, f(new Exception("extra obj")));
      onError();
      return -1;
    }
    this.jdField_a_of_type_Aool$c = ((aool.c)this.h.en);
    this.apr = this.jdField_a_of_type_Aool$c.dQO;
    return 0;
  }
  
  void QS(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    this.cLM = false;
    aoql.a locala = new aoql.a();
    aoql.a.a locala1 = new aoql.a.a();
    locala1.selfUin = this.h.mSelfUin;
    locala1.peerUin = this.h.mPeerUin;
    locala1.cmC = this.h.cmn;
    locala1.uinType = this.h.mUinType;
    locala1.uuid = this.h.cmo;
    locala1.msgTime = ((int)this.h.mMsgTime);
    MessageRecord localMessageRecord2 = this.h.F;
    MessageRecord localMessageRecord1 = localMessageRecord2;
    if (localMessageRecord2 == null) {
      localMessageRecord1 = this.app.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
    }
    boolean bool;
    if ((localMessageRecord1 != null) && ((localMessageRecord1 instanceof MessageForPic)))
    {
      this.ckZ = ((MessageForPic)localMessageRecord1).serverStoreSource;
      locala1.storageSource = this.ckZ;
      locala1.fileType = this.h.mFileType;
      if (this.h.mUinType != 1006) {
        break label311;
      }
      bool = true;
      label210:
      locala1.cNW = bool;
      if (!paramBoolean) {
        break label316;
      }
      locala1.protocolType = 0;
      label226:
      locala.b = this;
      locala.cmy = "c2c_pic_dw";
      locala.He.add(locala1);
      locala.a = this.app.getProtoReqManager();
      if (azQ()) {
        break label325;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
      onError();
    }
    label311:
    label316:
    label325:
    do
    {
      return;
      this.ckZ = "picplatform";
      hM("findDbRec", "not found");
      break;
      bool = false;
      break label210;
      locala1.protocolType = 1;
      break label226;
      if (QLog.isColorLevel()) {
        hM("requestStart", locala.toString());
      }
    } while (!azR());
    this.jdField_a_of_type_Aoql$a = locala;
    aoqm.c(locala);
  }
  
  void QT(boolean paramBoolean)
  {
    this.jdField_b_of_type_Aojn$a.dVf();
    if (this.mIsCancel) {
      return;
    }
    if (TextUtils.isEmpty(this.ckY)) {
      this.ckY = "c2cpicdw.qpic.cn";
    }
    aoll localaoll = new aoll();
    Object localObject;
    label49:
    label98:
    int i;
    String str;
    if (paramBoolean)
    {
      localObject = "https://";
      if (!this.cLV) {
        break label686;
      }
      this.xp.clear();
      localaoll.cML = false;
      localaoll.clP = "c2cpicdw.qpic.cn";
      localObject = (String)localObject + "c2cpicdw.qpic.cn";
      localObject = aB((String)localObject + this.ckX, this.h.dpB);
      localaoll.jdField_f_of_type_Aolm$b = this;
      localaoll.jdField_a_of_type_Aolm$c = this;
      localaoll.bZ = ((String)localObject);
      localaoll.mIsHttps = paramBoolean;
      localaoll.clP = this.ckY;
      localaoll.mHttpMethod = 0;
      k(this.xp, this.ckY);
      localaoll.P = this.xp;
      localaoll.atY = this.h.clR;
      if (this.h.cNA) {
        localaoll.jdField_f_of_type_JavaIoOutputStream = this.h.mOut;
      }
      localaoll.mMsgId = String.valueOf(this.h.mUniseq);
      localaoll.dPG = this.h.mUinType;
      localaoll.mFileType = this.h.mFileType;
      localaoll.apS = 0L;
      localaoll.cMU = true;
      i = a(this.h);
      if (i != 4) {
        break label884;
      }
      localaoll.apS = this.h.dQG;
      localaoll.apT = 0L;
      localaoll.cMT = false;
      str = "bytes=" + this.h.dQG + "-";
      localaoll.u.put("Range", str);
    }
    for (;;)
    {
      a(localaoll, (String)localObject);
      localaoll.u.put("Accept-Encoding", "identity");
      localaoll.u.put("mType", "picCd");
      localaoll.u.put("Referer", "http://im.qq.com/mobileqq");
      localaoll.jdField_a_of_type_Aolm$a = jdField_b_of_type_Aolm$a;
      localaoll.dPo = this.h.dPo;
      if (this.jdField_a_of_type_Aona$d != null) {
        localaoll.b = this.jdField_a_of_type_Aona$d.b();
      }
      localaoll.hq = new String[] { "image" };
      localaoll.cMV = true;
      localaoll.cMJ = true;
      if (this.cLM) {
        localaoll.mExcuteTimeLimit = 0L;
      }
      str = null;
      localObject = str;
      if (this.xp != null)
      {
        localObject = str;
        if (!this.xp.isEmpty()) {
          localObject = Arrays.toString(this.xp.toArray());
        }
      }
      hM("httpDown", "directMsgUrlDown:" + this.cLM + " ipList:" + (String)localObject + " uniSeq:" + localaoll.mMsgId + " uuid:" + this.h.cmo + ",downOffset:" + localaoll.apS + ",isEncryptUrl:" + this.cLQ + ",isEncryptPic:" + this.cLP + ",isEncryptRollbackReq:" + this.cLR);
      if (!azR()) {
        break;
      }
      this.jdField_a_of_type_Aomg = localaoll;
      this.c.a(localaoll);
      return;
      localObject = "http://";
      break label49;
      label686:
      if ((this.xp != null) && (this.xp.size() > 0))
      {
        localaoll.cML = true;
        aonh localaonh = (aonh)this.xp.get(0);
        if ((localaonh.isIpv6) && (!localaonh.mIp.startsWith("["))) {}
        for (str = (String)localObject + "[" + localaonh.mIp + "]";; str = (String)localObject + localaonh.mIp)
        {
          localObject = str;
          if (localaonh.port == 80) {
            break;
          }
          localObject = str + ":" + localaonh.port;
          break;
        }
      }
      localaoll.cML = false;
      localObject = (String)localObject + this.ckY;
      break label98;
      label884:
      if ((i == 3) || (i == 2))
      {
        localaoll.apS = this.h.dQG;
        localaoll.apT = (this.h.dQG + this.h.dQH - 1);
        localaoll.cMT = false;
        str = "bytes=" + this.h.dQG + "-" + localaoll.apT;
        localaoll.u.put("Range", str);
      }
      else
      {
        localaoll.apT = 0L;
        localaoll.u.put("Range", "bytes=" + localaoll.apS + "-");
      }
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
        parama = (aoql.b.l)paramb.Hf.get(i);
        if (QLog.isColorLevel()) {
          hM("procUrl", parama.toString());
        }
        this.cLU = parama.cOc;
        a(this.jdField_a_of_type_Aojn$a, parama);
        if (parama.result == 0)
        {
          this.xp = i(parama.Bw, parama.xp);
          this.ckY = parama.domain;
          this.ckX = parama.urlPath;
          if (QLog.isColorLevel()) {
            hM("proUrl", "picResp.protocolType = " + parama.protocolType);
          }
          if (parama.protocolType == 1)
          {
            this.cLS = true;
            QT(true);
          }
          for (;;)
          {
            i += 1;
            break;
            this.cLS = false;
            QT(false);
          }
        }
        onError();
      }
    }
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return (this.h.bEnableEnc) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x1) != 0);
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
    if (!this.h.mNeedReport) {}
    while ((this.h.mBusiType == 1030) || ((!paramBoolean) && (aona.lQ(this.errCode))) || (this.cLT) || ((paramBoolean) && ((this.dOZ & 0x2) > 0)) || ((!paramBoolean) && ((this.dOZ & 0x1) > 0))) {
      return;
    }
    int j = this.dOZ;
    int i;
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.dOZ = (i | j);
      l1 = (System.nanoTime() - this.mStartTime) / 1000000L;
      localObject1 = this.d.fB(1) + ";" + this.jdField_a_of_type_Aojn$a.fB(2) + ";" + this.jdField_b_of_type_Aojn$a.fB(3);
      this.mM.put("param_step", localObject1);
      this.mM.put("param_toUin", this.h.mPeerUin);
      this.mM.put("param_uuid", this.h.cmo);
      this.mM.put("param_DownMode", String.valueOf(this.h.dpB));
      this.mM.put("param_uinType", String.valueOf(this.h.mUinType));
      this.mM.put("param_quickHttp", String.valueOf(this.cLU));
      localObject1 = this.mM;
      long l2 = this.apr;
      if (this.jdField_a_of_type_Aool$c != null) {
        break label911;
      }
      i = 0;
      label466:
      ((HashMap)localObject1).put("param_recvDataLen", String.valueOf(l2 - i));
      this.mM.put("param_directFailCode", String.valueOf(this.dOQ));
      this.mM.put("param_directFailDesc", "" + this.cla);
      this.mM.put("param_inQueueCost", "" + this.apv);
      this.mM.put("ipFromDns", "" + this.cLO);
      this.mM.put("param_encryptRollback", "" + this.cLR + ",decryptErrorMsg:" + this.clb);
      localObject2 = this.mM;
      if (!this.cLR) {
        break label922;
      }
      localObject1 = "1";
      label664:
      ((HashMap)localObject2).put("param_encRetry", localObject1);
      localObject2 = this.mM;
      if (!this.cLS) {
        break label930;
      }
      localObject1 = "1";
      label693:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      if ((this.jdField_a_of_type_Aomg != null) && (((aoll)this.jdField_a_of_type_Aomg).jdField_a_of_type_Aoll$b != null))
      {
        localObject1 = (aoll)this.jdField_a_of_type_Aomg;
        this.mM.put("param_picDecryptTime", String.valueOf(((PicCryptor)((aoll)localObject1).jdField_a_of_type_Aoll$b).asW));
      }
      localObject2 = this.h.F;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.app.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.mM.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      QX(paramBoolean);
      if (!paramBoolean) {
        break label938;
      }
      P(true, l1);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), true, l1, this.apq, this.mM, "");
    }
    for (;;)
    {
      dVc();
      super.a(paramBoolean, "C2CPicDownloadErrorCode", l1, this.mM);
      return;
      i = 1;
      break;
      label911:
      i = this.jdField_a_of_type_Aool$c.dQO;
      break label466;
      label922:
      localObject1 = "0";
      break label664;
      label930:
      localObject1 = "0";
      break label693;
      label938:
      if (this.errCode != -9527) {
        this.mM.remove("param_rspHeader");
      }
      this.mM.put("param_FailCode", String.valueOf(this.errCode));
      this.mM.put("param_errorDesc", this.errDesc);
      P(false, l1);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), false, l1, 0L, this.mM, "");
    }
  }
  
  public void start()
  {
    super.start();
    if ((this.cLQ) && (this.cLP) && (!azM()))
    {
      this.cLQ = false;
      this.cLP = false;
      QS(true);
      return;
    }
    try
    {
      ge("c2cpicdw.qpic.cn", 1004);
      return;
    }
    catch (Exception localException)
    {
      hM("reportFailed", aokf.e(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoju
 * JD-Core Version:    0.7.0.1
 */