import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class aoku
  extends aojj
{
  long apQ;
  byte[] fM;
  boolean mIsGroup = true;
  
  public aoku() {}
  
  public aoku(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    this.jdField_b_of_type_Aoko.fileType = this.h.mFileType;
    this.jdField_b_of_type_Aoko.uniseq = this.h.mUniseq;
    this.jdField_b_of_type_Aoko.apI = this.h.apI;
  }
  
  protected String AJ()
  {
    if (this.h.mUinType == 1)
    {
      if (this.h.mFileType == 65537) {
        return "actGroupPicSmallDownV1";
      }
      return "actGroupPicDownloadV1";
    }
    if (this.h.mFileType == 65537) {
      return "actDiscussPicSmallDown";
    }
    return "actDiscussPicDown";
  }
  
  public int KH()
  {
    int i = 0;
    hM("uiParam", this.h.toString());
    String str1 = this.h.cmo;
    if ((str1 == null) || (str1.equals("")) || (str1.equals("null")) || (aqhq.rq(str1)) || (str1.startsWith("http://")))
    {
      if ((str1 == null) || (!str1.startsWith("http://"))) {
        break label184;
      }
      String str2 = ot(str1);
      if (str2 != null) {
        this.h.cmo = str2;
      }
    }
    else
    {
      if ((this.h.mOut != null) || (!this.h.cNA)) {
        break label226;
      }
      dN(9302, f(new Exception("no output stream")));
      onError();
      i = -1;
      return i;
    }
    dN(9302, f(new Exception("uuid illegal " + str1)));
    onError();
    return -1;
    label184:
    dN(9302, f(new Exception("uuid illegal " + str1)));
    onError();
    return -1;
    label226:
    if ((this.h.en == null) || (!(this.h.en instanceof aool.c)))
    {
      dN(9302, f(new Exception("extra obj")));
      onError();
      return -1;
    }
    this.jdField_a_of_type_Aool$c = ((aool.c)this.h.en);
    this.apr = this.jdField_a_of_type_Aool$c.dQO;
    if (this.h.mUinType == 1) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        this.mIsGroup = bool;
        try
        {
          this.fM = h(this.h.mMd5, this.h.cmo);
          this.apQ = this.h.apQ;
          if (this.fM != null) {
            break;
          }
          dN(9302, f(new Exception("convert md5 error,md5:" + this.h.mMd5 + "  uuid:" + this.h.cmo)));
          onError();
          return -1;
        }
        catch (Exception localException)
        {
          dN(9302, f(new Exception("convert md5 error,md5:" + this.h.mMd5 + "  uuid:" + this.h.cmo)));
          onError();
        }
      }
    }
    return -1;
  }
  
  void QS(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    this.cLM = false;
    aoql.a locala = new aoql.a();
    aoql.a.c localc = new aoql.a.c();
    localc.selfUin = this.h.mSelfUin;
    localc.peerUin = this.h.mPeerUin;
    localc.cmC = this.h.cmn;
    localc.uinType = this.h.mUinType;
    localc.fileType = this.h.mFileType;
    localc.groupFileID = this.apQ;
    localc.md5 = this.fM;
    localc.msgTime = ((int)this.h.mMsgTime);
    if (paramBoolean)
    {
      localc.protocolType = 0;
      locala.b = this;
      locala.cmy = "grp_pic_dw";
      locala.He.add(localc);
      locala.a = this.app.getProtoReqManager();
      if (azQ()) {
        break label188;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
      onError();
    }
    label188:
    do
    {
      return;
      localc.protocolType = 1;
      break;
      QLog.d("BaseTransProcessor", 1, "sendGroupPicDownRequest:" + this.h.mUniseq);
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
      this.ckY = "gchat.qpic.cn";
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
        break label691;
      }
      this.xp.clear();
      localaoll.cML = false;
      localaoll.clP = "gchat.qpic.cn";
      localObject = (String)localObject + "gchat.qpic.cn";
      localObject = aB((String)localObject + this.ckX, this.h.dpB);
      localaoll.jdField_f_of_type_Aolm$b = this;
      localaoll.jdField_a_of_type_Aolm$c = this;
      localaoll.bZ = ((String)localObject);
      localaoll.mIsHttps = paramBoolean;
      localaoll.clP = this.ckY;
      localaoll.mHttpMethod = 0;
      k(this.xp, this.ckY);
      localaoll.P = this.xp;
      if (this.jdField_a_of_type_Aona$d != null) {
        localaoll.b = this.jdField_a_of_type_Aona$d.b();
      }
      localaoll.atY = this.h.clR;
      if (this.h.cNA) {
        localaoll.jdField_f_of_type_JavaIoOutputStream = this.h.mOut;
      }
      localaoll.mMsgId = String.valueOf(this.h.mUniseq);
      localaoll.dPG = this.h.mUinType;
      localaoll.mFileType = this.h.mFileType;
      localaoll.cMU = true;
      localaoll.apS = 0L;
      localaoll.hq = new String[] { "image" };
      i = a(this.h);
      if (i != 4) {
        break label889;
      }
      localaoll.apS = this.h.dQG;
      localaoll.apT = 0L;
      localaoll.cMT = false;
      str = "bytes=" + this.h.dQG + "-";
      localaoll.u.put("Range", str);
    }
    for (;;)
    {
      localaoll.u.put("Accept-Encoding", "identity");
      localaoll.jdField_a_of_type_Aolm$a = jdField_b_of_type_Aolm$a;
      localaoll.u.put("Referer", "http://im.qq.com/mobileqq");
      a(localaoll, (String)localObject);
      localaoll.cMV = true;
      localaoll.cMJ = true;
      localaoll.u.put("mType", "picCu");
      localaoll.dPo = this.h.dPo;
      if (this.cLM) {
        localaoll.mContinuErrorLimit = 0;
      }
      localObject = null;
      if (!this.xp.isEmpty()) {
        localObject = Arrays.toString(this.xp.toArray());
      }
      hM("httpDown", "directMsgUrlDown:" + this.cLM + ",req.mReqUrl = " + localaoll.bZ + " ipList:" + (String)localObject + " uuid:" + this.h.cmo + " FileID:" + this.h.apQ + " downOffset:" + localaoll.apS + ",isEncryptUrl:" + this.cLQ + ",isEncryptPic:" + this.cLP + ",isEncryptRollbackReq:" + this.cLR);
      if (!azR()) {
        break;
      }
      this.jdField_a_of_type_Aomg = localaoll;
      dVe();
      this.c.a(localaoll);
      return;
      localObject = "http://";
      break label49;
      label691:
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
      label889:
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
    return (this.h.bEnableEnc) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x2) != 0);
  }
  
  public void dN(int paramInt, String paramString)
  {
    super.dN(paramInt, paramString);
    if ((paramInt != 9302) || (!QLog.isColorLevel())) {
      return;
    }
    paramString = this.h.cmo;
    paramString = "setError,uuid:" + paramString + " md5:" + this.h.mMd5;
    QLog.d("BaseTransProcessor", 1, paramString);
    anow.report("Download_Pic_Error_Param_Check", paramString);
  }
  
  protected void dVe()
  {
    int i = this.h.mFileType;
    if ((this.jdField_a_of_type_Aomg instanceof aoll))
    {
      if (!this.mIsGroup) {
        break label72;
      }
      if (i == 2) {
        ((aoll)this.jdField_a_of_type_Aomg).u.put("mType", "pttGd");
      }
    }
    else
    {
      return;
    }
    ((aoll)this.jdField_a_of_type_Aomg).u.put("mType", "picGd");
    return;
    label72:
    if (i == 2)
    {
      ((aoll)this.jdField_a_of_type_Aomg).u.put("mType", "pttDd");
      return;
    }
    ((aoll)this.jdField_a_of_type_Aomg).u.put("mType", "picDd");
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
      this.mM.put("param_grpUin", this.h.mPeerUin);
      this.mM.put("param_uuid", this.h.cmo);
      this.mM.put("param_DownMode", String.valueOf(this.h.dpB));
      this.mM.put("param_uinType", String.valueOf(this.h.mUinType));
      this.mM.put("param_quickHttp", String.valueOf(this.cLU));
      localObject1 = this.mM;
      long l2 = this.apr;
      if (this.jdField_a_of_type_Aool$c != null) {
        break label978;
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
        break label989;
      }
      localObject1 = "1";
      label664:
      ((HashMap)localObject2).put("param_encRetry", localObject1);
      localObject2 = this.mM;
      if (!this.cLS) {
        break label997;
      }
      localObject1 = "1";
      label693:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      if ((this.jdField_a_of_type_Aomg != null) && (((aoll)this.jdField_a_of_type_Aomg).jdField_a_of_type_Aoll$b != null))
      {
        localObject1 = (aoll)this.jdField_a_of_type_Aomg;
        this.mM.put("param_picDecryptTime", String.valueOf(((PicCryptor)((aoll)localObject1).jdField_a_of_type_Aoll$b).asW));
      }
      if (this.h.mUinType != 1) {
        break label1005;
      }
      i = 1;
      label771:
      if (i != 0)
      {
        i = -1;
        if (this.app != null) {
          i = this.app.cs(this.h.mPeerUin);
        }
        this.mM.put("param_groupPolicy", String.valueOf(i));
      }
      localObject2 = this.h.F;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.app != null) {
          localObject1 = this.app.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
        }
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.mM.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      QX(paramBoolean);
      if (!paramBoolean) {
        break label1010;
      }
      P(true, l1);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), true, l1, this.apq, this.mM, "");
    }
    for (;;)
    {
      dVc();
      super.a(paramBoolean, "GroupPicDownloadErrorCode", l1, this.mM);
      return;
      i = 1;
      break;
      label978:
      i = this.jdField_a_of_type_Aool$c.dQO;
      break label466;
      label989:
      localObject1 = "0";
      break label664;
      label997:
      localObject1 = "0";
      break label693;
      label1005:
      i = 0;
      break label771;
      label1010:
      if (this.errCode != -9527) {
        this.mM.remove("param_rspHeader");
      }
      this.mM.put("param_FailCode", String.valueOf(this.errCode));
      this.mM.put("param_errorDesc", this.errDesc);
      P(false, l1);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), false, l1, 0L, this.mM, "");
    }
  }
  
  String ot(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null) {
      localObject = paramString;
    }
    try
    {
      if (paramString.startsWith("/")) {
        localObject = paramString.substring(1);
      }
      if ((localObject != null) && (!((String)localObject).equals("null")) && (!((String)localObject).startsWith("http://"))) {}
      do
      {
        do
        {
          do
          {
            return null;
          } while ((localObject == null) || (((String)localObject).length() <= 0) || (!((String)localObject).contains("?")));
          i = ((String)localObject).indexOf("?");
        } while ((i < 0) || (i >= ((String)localObject).length() - 1));
        localObject = ((String)localObject).substring(i + 1).split("\\&");
      } while (localObject == null);
      paramString = null;
      int i = 0;
      while (i < localObject.length)
      {
        if (localObject[i].startsWith("pic=")) {
          paramString = localObject[i].substring(4);
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = paramString;
      }
    }
    return paramString;
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
    ge("gchat.qpic.cn", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoku
 * JD-Core Version:    0.7.0.1
 */