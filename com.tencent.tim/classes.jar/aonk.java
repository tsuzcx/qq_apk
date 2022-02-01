import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class aonk
  extends aoji
  implements aolm.c
{
  static HashSet<String> bB = new HashSet();
  private ArrayList<String> Bm = new ArrayList();
  long apZ = 0L;
  private String cmf;
  private aolm.a d;
  int dPI = 0;
  private int dQp;
  int dQq = -1;
  private int downloadType;
  private String fileMd5 = "";
  private String mFileId;
  
  public aonk(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    this.jdField_d_of_type_Aolm$a = new aonl(this);
    paramaooi = paramaool.dQ;
    if (paramaooi != null)
    {
      String[] arrayOfString = paramaooi.split("QQ_&_MoblieQQ_&_QQ");
      if (arrayOfString.length < 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "path was not set correctlly------path = " + paramaooi);
        }
        throw new IllegalArgumentException("path was not set correctlly.");
      }
      paramaool.clR = arrayOfString[0];
      this.mFileId = arrayOfString[1];
      this.cmf = (this.mFileId + paramaool.mFileType + paramaool.mUniseq);
      this.downloadType = Integer.parseInt(arrayOfString[2]);
      if (arrayOfString.length > 3) {
        this.dQp = Integer.parseInt(arrayOfString[3]);
      }
    }
  }
  
  private boolean aAj()
  {
    if ((aaze.ce.get()) && ((this.h.F instanceof MessageForShortVideo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.h.F;
      if ((localMessageForShortVideo.busiType != 0) || (!localMessageForShortVideo.supportProgressive)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "isSupportProgressive() : " + bool);
      }
      return bool;
    }
  }
  
  protected String AJ()
  {
    String str = "actShortVideoDownloadVideo";
    if (this.h.mFileType == 7) {
      str = "actShortVideoDownloadThumb";
    }
    do
    {
      return str;
      if (this.h.mFileType == 6) {
        return "actShortVideoDownloadVideo";
      }
      if ((this.h.mFileType == 16) || (this.h.mFileType == 18))
      {
        this.mM.put("param_grpUin", this.h.mPeerUin);
        return "actShortVideoDiscussgroupDownloadThumb";
      }
    } while ((this.h.mFileType != 9) && (this.h.mFileType != 17));
    this.mM.put("param_grpUin", this.h.mPeerUin);
    return "actShortVideoDiscussgroupDownloadVideo";
  }
  
  public int EN()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "resume()");
    }
    if (this.mIsPause)
    {
      this.mIsPause = false;
      this.mIsCancel = false;
      VR(2001);
      this.errCode = 0;
      this.errDesc = "";
      this.jdField_a_of_type_Aojm.a.post(new ShortVideoDownloadProcessor.1(this));
    }
    return 0;
  }
  
  public int KH()
  {
    if ((this.h == null) || (this.h.clR == null))
    {
      dN(9302, acfp.m(2131714483));
      onError();
      return -1;
    }
    if ((this.h != null) && (this.h.F != null) && (((MessageForShortVideo)this.h.F).busiType == 0)) {
      this.cLZ = true;
    }
    return 0;
  }
  
  protected void VR(int paramInt)
  {
    super.VR(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendMessageToUpdate state = " + paramInt);
    }
    if ((this.mIsPause) && (2004 != paramInt)) {
      return;
    }
    anfr.a(this.app, this.jdField_b_of_type_Aoko, this.h);
  }
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    this.jdField_a_of_type_Aoql$a = null;
    if (paramb != null)
    {
      int i = 0;
      if (i < paramb.Hf.size())
      {
        aoql.b.n localn = (aoql.b.n)paramb.Hf.get(i);
        hM("procUrl", localn.toString());
        a(this.jdField_a_of_type_Aojn$a, localn);
        this.xp = i(localn.Bw, localn.xp);
        this.ckY = localn.mDomain;
        if (this.cLV)
        {
          this.ckY = "grouptalk.c2c.qq.com";
          if (this.xp != null) {
            this.xp.clear();
          }
        }
        if (localn.result == 0)
        {
          if (QLog.isColorLevel()) {
            if ("onBusiProtoResp() cdn ---- mIpListSize:" + this.xp != null) {
              break label265;
            }
          }
          label265:
          for (parama = Integer.valueOf(0);; parama = this.xp.size() + " mHostType:" + localn.dRr + " domain:" + localn.mDomain + " url:" + localn.mUrl)
          {
            QLog.d("ShortVideoDownloadProcessor", 2, new Object[] { parama });
            QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- mUiRequest.mMd5:" + this.h.mMd5);
            QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- downResp.md5:" + HexUtil.bytes2HexStr(localn.md5));
            this.bMt = localn.mUrl;
            bB(localn.gm);
            i += 1;
            break;
          }
        }
        if ((!localn.cOd) && (this.h.F != null) && ((this.h.F instanceof MessageForShortVideo)))
        {
          ((MessageForShortVideo)this.h.F).isAllowAutoDown = false;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()-- server return not allow auto retry");
          }
        }
        if (-5100026 != this.errCode) {
          break label477;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 安全打击mUiRequest.mMd5:" + this.h.mMd5);
        }
        dN(-5100026, "安全打击mUiRequest.mMd5:" + this.h.mMd5);
      }
    }
    for (;;)
    {
      onError();
      return;
      label477:
      if ((-9527 == this.errCode) && ((this.errDesc.equals("H_400_-5103017")) || (this.errDesc.equals("H_400_-5103059"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 视频文件过期errCode=" + this.errCode);
        }
        dN(this.errCode, acfp.m(2131714506));
      }
      else if (-5100528 == this.errCode)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 后台不允许自动下载, errCode = " + this.errCode);
        }
        dN(-5100528, acfp.m(2131714511));
      }
      else
      {
        dN(9045, acfp.m(2131714513));
      }
    }
  }
  
  void bB(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile encrypted ! ");
      }
      this.mM.put("param_encrypt", String.valueOf(1));
    }
    String str;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      if (TextUtils.isEmpty(this.ckY)) {
        this.ckY = "grouptalk.c2c.qq.com";
      }
      this.jdField_b_of_type_Aojn$a.dVf();
      str = wM();
      localObject1 = new aoll();
      if (!aqmr.isEmpty(this.ckY)) {
        ((aoll)localObject1).u.put("host", this.ckY);
      }
      ((aoll)localObject1).f = this;
      ((aoll)localObject1).jdField_a_of_type_Aolm$c = this;
      ((aoll)localObject1).bZ = str;
      ((aoll)localObject1).mHttpMethod = 0;
      k(this.xp, this.ckY);
      ((aoll)localObject1).P = this.xp;
      ((aoll)localObject1).atY = this.h.clR;
      ((aoll)localObject1).mMsgId = String.valueOf(this.h.mUniseq);
      ((aoll)localObject1).dPG = this.h.mUinType;
      ((aoll)localObject1).mFileType = this.h.mFileType;
      if ((this.h.mFileType == 6) || (this.h.mFileType == 9) || (this.h.mFileType == 17))
      {
        localObject2 = aqmj.bo(BaseApplication.getContext());
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localObject2 = ((String)localObject2).split("\\|");
          if ((localObject2 != null) && (localObject2.length > 0)) {
            ((aoll)localObject1).hq = ((String[])localObject2);
          }
        }
      }
      if (paramArrayOfByte != null) {
        ((aoll)localObject1).jdField_a_of_type_Aoll$a = new aoll.a(paramArrayOfByte);
      }
      ((aoll)localObject1).apS = 0L;
      ((aoll)localObject1).cMU = true;
      ((aoll)localObject1).u.put("Accept-Encoding", "identity");
      ((aoll)localObject1).jdField_a_of_type_Aolm$a = this.jdField_d_of_type_Aolm$a;
      ((aoll)localObject1).mTempPath = (this.h.clR + "." + MD5.toMD5(this.mFileId) + ".tmp");
      if (aAj())
      {
        paramArrayOfByte = (MessageForShortVideo)this.h.F;
        ((aoll)localObject1).cMS = true;
        ((aoll)localObject1).cMT = false;
        if (new File(((aoll)localObject1).mTempPath).exists()) {
          ((aoll)localObject1).apS = paramArrayOfByte.transferedSize;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile mUseRaf =>>>");
        }
      }
      hM("httpDown", "url:" + str + ",downOffset:" + ((aoll)localObject1).apS);
      if (azR()) {
        break;
      }
      bB.remove(this.cmf);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile unencrypted ! ");
      }
      this.mM.put("param_encrypt", String.valueOf(0));
    }
    this.jdField_a_of_type_Aomg = ((aomg)localObject1);
    dVe();
    ((aoll)localObject1).cMI = true;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile mIsOnlyGetUrl " + this.h.cFo + " domain=" + this.ckY + " ipsize=" + this.xp.size());
    }
    if (this.h.cFo)
    {
      paramArrayOfByte = new String[this.xp.size()];
      while (i < this.xp.size())
      {
        localObject1 = (aonh)this.xp.get(i);
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("http://");
        ((StringBuffer)localObject2).append(((aonh)localObject1).mIp);
        if (((aonh)localObject1).port != 80)
        {
          ((StringBuffer)localObject2).append(":");
          ((StringBuffer)localObject2).append(((aonh)localObject1).port);
        }
        ((StringBuffer)localObject2).append("/");
        paramArrayOfByte[i] = aonc.bJ(str, ((StringBuffer)localObject2).toString());
        i += 1;
      }
      this.jdField_b_of_type_Aoko.urls = paramArrayOfByte;
      this.jdField_b_of_type_Aoko.domain = this.ckY;
      this.jdField_b_of_type_Aoko.apK = this.jdField_a_of_type_Aojn$a.hj();
      VR(2002);
      this.jdField_a_of_type_Aojm.oy(getKey());
      bB.remove(this.cmf);
      return;
    }
    this.jdField_c_of_type_Aolm.a((aomg)localObject1);
  }
  
  public int cancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "cancel()");
    }
    bB.remove(this.cmf);
    return super.cancel();
  }
  
  protected void dVe()
  {
    String str;
    if ((this.jdField_a_of_type_Aomg != null) && ((this.jdField_a_of_type_Aomg instanceof aoll)))
    {
      if (!top.fv(this.h.mUinType)) {
        break label59;
      }
      str = "videoCd";
    }
    for (;;)
    {
      ((aoll)this.jdField_a_of_type_Aomg).bZ = MsfSdkUtils.insertMtype(str, ((aoll)this.jdField_a_of_type_Aomg).bZ);
      return;
      label59:
      if (this.h.mUinType == 1) {
        str = "videoGd";
      } else if (this.h.mUinType == 3000) {
        str = "videoDd";
      } else {
        str = "videoOd";
      }
    }
  }
  
  public void dVq()
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    aoql.a locala = new aoql.a();
    aoql.a.l locall = new aoql.a.l();
    locall.seq = ((int)this.h.mUniseq);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + locall.seq);
    }
    locall.selfUin = this.h.mSelfUin;
    locall.peerUin = this.h.mPeerUin;
    locall.cmC = this.h.cmn;
    locall.uinType = this.h.mUinType;
    locall.troopUin = this.h.mPeerUin;
    locall.dRn = 0;
    if (locall.uinType == 0)
    {
      locall.chatType = 0;
      if ((locall.uinType != 0) && (1008 != locall.uinType)) {
        break label480;
      }
      locall.troopUin = null;
      label164:
      locall.clientType = 2;
      locall.fileId = this.mFileId;
      locall.md5 = HexUtil.hexStr2Bytes(this.h.mMd5);
      if ((this.h.F == null) || (!(this.h.F instanceof MessageForShortVideo))) {
        break label494;
      }
      locall.busiType = ((MessageForShortVideo)this.h.F).busiType;
      label231:
      this.dQq = locall.busiType;
      locall.subBusiType = 0;
      if ((this.h.F != null) && ((this.h.F instanceof MessageForShortVideo)))
      {
        if (!(this.h.F instanceof MessageForLightVideo)) {
          break label526;
        }
        locall.subBusiType = 3;
      }
      label285:
      if ((this.h.mFileType != 7) && (this.h.mFileType != 16) && (this.h.mFileType != 18)) {
        break label551;
      }
    }
    label526:
    label551:
    for (locall.fileType = 1;; locall.fileType = 2) {
      label480:
      label494:
      do
      {
        locall.dRl = this.h.dpB;
        if ((this.h.en != null) && ((this.h.en instanceof Integer))) {
          locall.IH = ((Integer)this.h.en).intValue();
        }
        locala.b = this;
        locala.cmy = "short_video_dw";
        locala.He.add(locall);
        locala.a = this.app.getProtoReqManager();
        if (azQ()) {
          break label595;
        }
        a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
        onError();
        return;
        if (1 == locall.uinType)
        {
          locall.chatType = 1;
          break;
        }
        if (3000 == locall.uinType)
        {
          locall.chatType = 2;
          break;
        }
        locall.chatType = 3;
        break;
        locall.troopUin = this.h.mPeerUin;
        break label164;
        if (1008 == locall.uinType)
        {
          locall.busiType = this.h.mBusiType;
          break label231;
        }
        locall.busiType = 0;
        break label231;
        if (((MessageForShortVideo)this.h.F).subBusiType != 1) {
          break label285;
        }
        locall.subBusiType = 1;
        break label285;
      } while ((this.h.mFileType != 6) && (this.h.mFileType != 9) && (this.h.mFileType != 17));
    }
    label595:
    hM("requestStart", locala.toString());
    if (!azR())
    {
      bB.remove(this.cmf);
      return;
    }
    this.jdField_a_of_type_Aoql$a = locala;
    aoqm.c(locala);
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if (this.h.cFo) {}
    while (((!paramBoolean) && (aona.lQ(this.errCode))) || (this.cLT) || ((paramBoolean) && ((this.dOZ & 0x2) > 0)) || ((!paramBoolean) && ((this.dOZ & 0x1) > 0))) {
      return;
    }
    int j = this.dOZ;
    int i;
    long l;
    if (paramBoolean)
    {
      i = 2;
      this.dOZ = (i | j);
      if (this.dPI > 0)
      {
        new HashMap().put("businessType", String.valueOf(this.h.mFileType));
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "actShortVideoRedirect", true, this.apZ, this.dPI, this.mM, "");
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "mRedirectReportInfo = " + this.dPI + " " + this.apZ + " " + this.h.mFileType);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "reportTag = " + AJ());
      }
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      String str = this.jdField_a_of_type_Aojn$a.fB(1) + ";" + this.jdField_b_of_type_Aojn$a.fB(2) + ";" + this.jdField_c_of_type_Aojn$a.fB(3);
      this.mM.put("param_step", str);
      this.mM.put("param_fromUin", this.h.mPeerUin);
      if (this.xp.size() > 0) {
        this.mM.put("param_iplist", this.xp.toString());
      }
      this.mM.put("param_uuid", this.mFileId);
      this.mM.put("param_picSize", String.valueOf(this.jdField_b_of_type_Aoko.fileSize));
      this.mM.put("param_fileMd5", this.h.mMd5);
      this.mM.put("param_busiType", this.dQq + "");
      this.mM.put("param_videoDuration", String.valueOf(this.dQp));
      this.mM.put("param_DownMode", String.valueOf(this.h.dpB));
      if (!paramBoolean) {
        break label539;
      }
      P(true, l);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), true, l, this.apq, this.mM, "");
    }
    for (;;)
    {
      dVc();
      return;
      i = 1;
      break;
      label539:
      if (this.errCode != -9527) {
        this.mM.remove("param_rspHeader");
      }
      this.mM.put("param_FailCode", String.valueOf(this.errCode));
      this.mM.put("param_errorDesc", this.errDesc);
      if (this.errCode == -6103066) {
        this.mM.put("param_picmd5", "uierquest md5=" + this.h.mMd5 + "fileMd5=" + this.fileMd5);
      }
      P(false, l);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), false, l, 0L, this.mM, "");
    }
  }
  
  public void g(aomh paramaomh)
  {
    this.jdField_a_of_type_Aomy.aft = (this.dQq + "");
    this.jdField_a_of_type_Aomy.mFileSize = this.jdField_b_of_type_Aoko.fileSize;
    a(paramaomh, false, "actRichMediaNetMonitor_videoDown", this.mFileId);
  }
  
  /* Error */
  public void i(aomh paramaomh)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 153	aonk:h	Laool;
    //   10: getfield 346	aool:mMd5	Ljava/lang/String;
    //   13: astore 7
    //   15: aload 7
    //   17: invokestatic 421	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +557 -> 577
    //   23: aload_0
    //   24: getfield 153	aonk:h	Laool;
    //   27: getfield 107	aool:clR	Ljava/lang/String;
    //   30: astore 6
    //   32: aconst_null
    //   33: astore 8
    //   35: new 908	java/io/FileInputStream
    //   38: dup
    //   39: aload 6
    //   41: invokespecial 909	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   44: astore 6
    //   46: aload 6
    //   48: aload 6
    //   50: invokevirtual 912	java/io/FileInputStream:available	()I
    //   53: i2l
    //   54: invokestatic 916	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   57: astore 8
    //   59: aload 8
    //   61: ifnull +511 -> 572
    //   64: aload_0
    //   65: aload 8
    //   67: invokestatic 358	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   70: putfield 42	aonk:fileMd5	Ljava/lang/String;
    //   73: aload_0
    //   74: getfield 42	aonk:fileMd5	Ljava/lang/String;
    //   77: aload 7
    //   79: invokevirtual 399	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifne +490 -> 572
    //   85: aload_0
    //   86: getfield 153	aonk:h	Laool;
    //   89: getfield 112	aool:mFileType	I
    //   92: bipush 6
    //   94: if_icmpeq +27 -> 121
    //   97: aload_0
    //   98: getfield 153	aonk:h	Laool;
    //   101: getfield 112	aool:mFileType	I
    //   104: bipush 9
    //   106: if_icmpeq +15 -> 121
    //   109: aload_0
    //   110: getfield 153	aonk:h	Laool;
    //   113: getfield 112	aool:mFileType	I
    //   116: bipush 17
    //   118: if_icmpne +454 -> 572
    //   121: aload_0
    //   122: ldc_w 878
    //   125: ldc_w 918
    //   128: invokevirtual 244	aonk:dN	(ILjava/lang/String;)V
    //   131: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +43 -> 177
    //   137: ldc 81
    //   139: iconst_2
    //   140: new 83	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 920
    //   150: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 7
    //   155: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc_w 922
    //   161: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_0
    //   165: getfield 42	aonk:fileMd5	Ljava/lang/String;
    //   168: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 925	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: iconst_0
    //   178: istore_2
    //   179: iload_2
    //   180: istore_3
    //   181: aload 6
    //   183: ifnull +10 -> 193
    //   186: aload 6
    //   188: invokevirtual 928	java/io/FileInputStream:close	()V
    //   191: iload_2
    //   192: istore_3
    //   193: aload_0
    //   194: getfield 180	aonk:mM	Ljava/util/HashMap;
    //   197: astore 6
    //   199: iload_3
    //   200: ifeq +320 -> 520
    //   203: iconst_1
    //   204: istore_2
    //   205: aload 6
    //   207: ldc_w 930
    //   210: iload_2
    //   211: invokestatic 415	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   214: invokevirtual 191	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   217: pop
    //   218: aload_0
    //   219: invokespecial 138	aonk:aAj	()Z
    //   222: ifeq +100 -> 322
    //   225: new 541	java/io/File
    //   228: dup
    //   229: aload_0
    //   230: getfield 567	aonk:jdField_a_of_type_Aomg	Laomg;
    //   233: getfield 933	aomg:mTempPath	Ljava/lang/String;
    //   236: invokespecial 542	java/io/File:<init>	(Ljava/lang/String;)V
    //   239: astore 6
    //   241: new 541	java/io/File
    //   244: dup
    //   245: aload_0
    //   246: getfield 153	aonk:h	Laool;
    //   249: getfield 107	aool:clR	Ljava/lang/String;
    //   252: invokespecial 542	java/io/File:<init>	(Ljava/lang/String;)V
    //   255: astore 7
    //   257: aload 6
    //   259: aload 7
    //   261: invokestatic 939	dx:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   264: pop
    //   265: iload 4
    //   267: istore 5
    //   269: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +50 -> 322
    //   275: ldc 81
    //   277: iconst_2
    //   278: new 83	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   285: ldc_w 941
    //   288: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_0
    //   292: getfield 153	aonk:h	Laool;
    //   295: getfield 107	aool:clR	Ljava/lang/String;
    //   298: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc_w 943
    //   304: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: iload 4
    //   309: invokevirtual 171	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   312: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 925	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: iload 4
    //   320: istore 5
    //   322: iload 5
    //   324: ifne +7 -> 331
    //   327: aload_0
    //   328: invokevirtual 946	aonk:onSuccess	()V
    //   331: aload_0
    //   332: getfield 889	aonk:jdField_a_of_type_Aomy	Laomy;
    //   335: new 83	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   342: aload_0
    //   343: getfield 44	aonk:dQq	I
    //   346: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   349: ldc 40
    //   351: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: putfield 894	aomy:aft	Ljava/lang/String;
    //   360: aload_0
    //   361: getfield 889	aonk:jdField_a_of_type_Aomy	Laomy;
    //   364: aload_0
    //   365: getfield 261	aonk:jdField_b_of_type_Aoko	Laoko;
    //   368: getfield 851	aoko:fileSize	J
    //   371: putfield 897	aomy:mFileSize	J
    //   374: aload_0
    //   375: aload_1
    //   376: iconst_1
    //   377: ldc_w 899
    //   380: aload_0
    //   381: getfield 109	aonk:mFileId	Ljava/lang/String;
    //   384: invokevirtual 902	aonk:a	(Laomh;ZLjava/lang/String;Ljava/lang/String;)V
    //   387: return
    //   388: astore 6
    //   390: iload_2
    //   391: istore_3
    //   392: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   395: ifeq -202 -> 193
    //   398: ldc 81
    //   400: iconst_2
    //   401: ldc_w 948
    //   404: aload 6
    //   406: invokestatic 951	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   409: iload_2
    //   410: istore_3
    //   411: goto -218 -> 193
    //   414: astore 7
    //   416: iconst_1
    //   417: istore_2
    //   418: aload 8
    //   420: astore 6
    //   422: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +14 -> 439
    //   428: ldc 81
    //   430: iconst_2
    //   431: ldc_w 948
    //   434: aload 7
    //   436: invokestatic 951	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   439: iload_2
    //   440: istore_3
    //   441: aload 6
    //   443: ifnull -250 -> 193
    //   446: aload 6
    //   448: invokevirtual 928	java/io/FileInputStream:close	()V
    //   451: iload_2
    //   452: istore_3
    //   453: goto -260 -> 193
    //   456: astore 6
    //   458: iload_2
    //   459: istore_3
    //   460: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   463: ifeq -270 -> 193
    //   466: ldc 81
    //   468: iconst_2
    //   469: ldc_w 948
    //   472: aload 6
    //   474: invokestatic 951	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   477: iload_2
    //   478: istore_3
    //   479: goto -286 -> 193
    //   482: astore_1
    //   483: aconst_null
    //   484: astore 6
    //   486: aload 6
    //   488: ifnull +8 -> 496
    //   491: aload 6
    //   493: invokevirtual 928	java/io/FileInputStream:close	()V
    //   496: aload_1
    //   497: athrow
    //   498: astore 6
    //   500: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq -7 -> 496
    //   506: ldc 81
    //   508: iconst_2
    //   509: ldc_w 948
    //   512: aload 6
    //   514: invokestatic 951	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   517: goto -21 -> 496
    //   520: iconst_0
    //   521: istore_2
    //   522: goto -317 -> 205
    //   525: astore 6
    //   527: aload_0
    //   528: sipush -30000
    //   531: ldc_w 952
    //   534: invokestatic 240	acfp:m	(I)Ljava/lang/String;
    //   537: invokevirtual 244	aonk:dN	(ILjava/lang/String;)V
    //   540: aload_0
    //   541: invokevirtual 247	aonk:onError	()V
    //   544: iconst_1
    //   545: istore 4
    //   547: goto -282 -> 265
    //   550: astore_1
    //   551: goto -65 -> 486
    //   554: astore_1
    //   555: goto -69 -> 486
    //   558: astore 7
    //   560: iconst_1
    //   561: istore_2
    //   562: goto -140 -> 422
    //   565: astore 7
    //   567: iconst_0
    //   568: istore_2
    //   569: goto -147 -> 422
    //   572: iconst_1
    //   573: istore_2
    //   574: goto -395 -> 179
    //   577: iconst_1
    //   578: istore_3
    //   579: goto -386 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	aonk
    //   0	582	1	paramaomh	aomh
    //   178	396	2	i	int
    //   180	399	3	j	int
    //   4	542	4	bool	boolean
    //   1	322	5	k	int
    //   30	228	6	localObject1	Object
    //   388	17	6	localIOException1	java.io.IOException
    //   420	27	6	localObject2	Object
    //   456	17	6	localIOException2	java.io.IOException
    //   484	8	6	localObject3	Object
    //   498	15	6	localIOException3	java.io.IOException
    //   525	1	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   13	247	7	localObject4	Object
    //   414	21	7	localIOException4	java.io.IOException
    //   558	1	7	localIOException5	java.io.IOException
    //   565	1	7	localIOException6	java.io.IOException
    //   33	386	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   186	191	388	java/io/IOException
    //   35	46	414	java/io/IOException
    //   446	451	456	java/io/IOException
    //   35	46	482	finally
    //   491	496	498	java/io/IOException
    //   257	265	525	java/lang/OutOfMemoryError
    //   46	59	550	finally
    //   64	121	550	finally
    //   121	131	550	finally
    //   131	177	550	finally
    //   422	439	554	finally
    //   46	59	558	java/io/IOException
    //   64	121	558	java/io/IOException
    //   121	131	558	java/io/IOException
    //   131	177	565	java/io/IOException
  }
  
  void onError()
  {
    super.onError();
    bB.remove(this.cmf);
    this.jdField_b_of_type_Aoko.errorCode = this.errCode;
    if (-5100026 == this.errCode) {
      VR(5001);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errCode:" + this.errCode);
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errDesc:" + this.errDesc);
      }
      Object localObject = null;
      if (this.h != null) {
        localObject = this.h.a;
      }
      if (localObject != null)
      {
        ((aoom)localObject).mResult = -1;
        ((aoom)localObject).aqr = this.errCode;
        ((aoom)localObject).clO = this.errDesc;
        ((aoom)localObject).i = this.h;
      }
      localObject = this.Bl.iterator();
      while (((Iterator)localObject).hasNext())
      {
        akxb localakxb = (akxb)((Iterator)localObject).next();
        akxb.a locala = new akxb.a();
        locala.result = -1;
        locala.errCode = this.errCode;
        locala.errStr = this.errDesc;
        localakxb.a(locala);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideo.TAG", 2, "onError ");
        }
      }
      if ((-9527 == this.errCode) && ((this.errDesc.equals("H_400_-5103017")) || (this.errDesc.equals("H_400_-5103059")))) {
        VR(5002);
      } else {
        VR(2005);
      }
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    boolean bool2 = true;
    super.onResp(paramaomh);
    Object localObject = new StringBuilder().append("directMsgUrlDown:").append(this.cLM).append(" result:");
    boolean bool1;
    if (paramaomh.mResult == 0)
    {
      bool1 = true;
      hM("onHttpResp", bool1);
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoDownloadProcessor", 2, "onResp()---- result:" + paramaomh.mResult);
        QLog.d("ShortVideoDownloadProcessor", 2, "onResp()---- errCode:" + paramaomh.mErrCode);
        QLog.d("ShortVideoDownloadProcessor", 2, "onResp()---- errDesc:" + paramaomh.clO);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "decrypt cost : " + paramaomh.aqa / 1000L);
      }
      if (!this.cLM) {
        break label307;
      }
      localObject = this.jdField_d_of_type_Aojn$a;
      label205:
      if (paramaomh.mResult != 0) {
        break label316;
      }
      bool1 = bool2;
      label214:
      a((aojn.a)localObject, paramaomh, bool1);
      this.apq = paramaomh.apU;
      if (this.apq <= 0L) {
        this.apq = (paramaomh.apV + paramaomh.b.apS);
      }
      this.apr += paramaomh.apW;
      this.apZ = paramaomh.apZ;
      this.dPI = paramaomh.dPI;
      if (paramaomh.mResult != 0) {
        break label321;
      }
      i(paramaomh);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aomg = null;
      return;
      bool1 = false;
      break;
      label307:
      localObject = this.jdField_b_of_type_Aojn$a;
      break label205;
      label316:
      bool1 = false;
      break label214;
      label321:
      if (this.cLM)
      {
        dVq();
      }
      else
      {
        if (paramaomh.nR.get("X-RtFlag") == null) {}
        for (long l = 9223372036854775807L;; l = Long.parseLong((String)paramaomh.nR.get("X-RtFlag")))
        {
          this.mM.put("param_xRtFlag", String.valueOf(l));
          if ((paramaomh.mErrCode != 9364) || (this.dOY >= 3)) {
            break;
          }
          hM("[netChg]", "failed.but net change detect.so retry");
          this.dOY += 1;
          dVd();
          dVq();
          return;
        }
        localObject = (String)paramaomh.nR.get(aqog.cuy);
        a(paramaomh.mErrCode, paramaomh.clO, (String)localObject, this.jdField_b_of_type_Aojn$a);
        onError();
      }
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "successfully downloaded.");
    }
    bB.remove(this.cmf);
    VR(2003);
    Object localObject = this.h.a;
    if (localObject != null)
    {
      ((aoom)localObject).mResult = 0;
      ((aoom)localObject).i = this.h;
    }
    localObject = this.Bl.iterator();
    while (((Iterator)localObject).hasNext())
    {
      akxb localakxb = (akxb)((Iterator)localObject).next();
      akxb.a locala = new akxb.a();
      locala.result = 0;
      locala.bUF = this.h.clR;
      locala.md5 = this.h.mMd5;
      locala.dpB = this.h.dpB;
      localakxb.a(locala);
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    if (this.mIsPause) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoDownloadProcessor", 2, "onUpdateProgeress: mIsPause=true, should not notify UI, just return!");
      }
    }
    for (;;)
    {
      return;
      this.jdField_b_of_type_Aoko.transferedSize = paramLong1;
      this.jdField_b_of_type_Aoko.fileSize = paramLong2;
      VR(2002);
      int i = (int)(10000L * paramLong1 / paramLong2);
      paramaomg = this.Bl.iterator();
      while (paramaomg.hasNext()) {
        ((akxb)paramaomg.next()).aS(i, false);
      }
    }
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "pause() mIsPause : " + this.mIsPause);
    }
    if (!this.mIsPause)
    {
      this.mIsPause = true;
      VR(2004);
      if (this.jdField_a_of_type_Aoql$a != null)
      {
        aoqm.d(this.jdField_a_of_type_Aoql$a);
        this.jdField_a_of_type_Aoql$a = null;
      }
      if (this.jdField_a_of_type_Aomg != null)
      {
        this.jdField_c_of_type_Aolm.b(this.jdField_a_of_type_Aomg);
        this.jdField_a_of_type_Aomg = null;
      }
    }
  }
  
  public void start()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "start()----runningTasks.contains(mTaskKey) = " + bB.contains(this.cmf));
    }
    if ((this.h.F != null) && ((this.h.F instanceof MessageForShortVideo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.h.F;
      hM("start", "[tvk] videoFileSize = " + localMessageForShortVideo.videoFileSize);
    }
    if ((this.h.dpB == 2) && (this.h.F != null) && ((this.h.F instanceof MessageForShortVideo)) && (!((MessageForShortVideo)this.h.F).isAllowAutoDown) && ((this.h.mFileType == 6) || (this.h.mFileType == 9) || (this.h.mFileType == 17)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "start()-- server not allow auto down video");
      }
      bB.remove(this.cmf);
      super.cancel();
    }
    while (bB.contains(this.cmf)) {
      return;
    }
    bB.add(this.cmf);
    VR(2001);
    dVq();
  }
  
  protected String wM()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    aonh localaonh;
    if (this.xp.size() > 0)
    {
      localaonh = (aonh)this.xp.get(0);
      localStringBuilder.append("http://");
      if ((localaonh.isIpv6) && (!localaonh.mIp.startsWith("[")))
      {
        localStringBuilder.append("[" + localaonh.mIp + "]");
        if ((localaonh.port != 80) && (localaonh.port != 0))
        {
          localStringBuilder.append(":");
          localStringBuilder.append(localaonh.port);
        }
        localStringBuilder.append("/");
      }
    }
    for (;;)
    {
      localStringBuilder.append(this.bMt);
      hM("getConnUrl", "cdn url = " + localStringBuilder.toString());
      return localStringBuilder.toString();
      localStringBuilder.append(localaonh.mIp);
      break;
      if (!this.ckY.startsWith("http://")) {
        localStringBuilder.append("http://");
      }
      localStringBuilder.append(this.ckY);
      if (!this.ckY.endsWith("/")) {
        localStringBuilder.append("/");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aonk
 * JD-Core Version:    0.7.0.1
 */