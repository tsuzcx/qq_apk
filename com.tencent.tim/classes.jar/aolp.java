import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;

public class aolp
  extends aoji
  implements aolm.a
{
  String[] hm = null;
  String mTempPath;
  
  public aolp(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    this.Ha = ((ProxyIpManager)this.app.getManager(3)).getProxyIp(4);
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
  
  public int KH()
  {
    super.KH();
    hM("uiParam", this.h.toString());
    String str = this.h.cmo;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (aqhq.rq(str)) || (str.startsWith("http://")))
    {
      dN(9302, f(new Exception("uuid illegal " + str)));
      onError();
      return -1;
    }
    return 0;
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
          if ((this.Ha != null) && (!this.Ha.isEmpty()))
          {
            parama = aonc.a(this.bMt);
            if (parama != null) {
              this.xp.add(parama);
            }
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
    g(null, paramd.g, paramd.g.getWupBuffer());
  }
  
  protected void dVe()
  {
    if ((this.jdField_a_of_type_Aomg != null) && ((this.jdField_a_of_type_Aomg instanceof aoll))) {
      ((aoll)this.jdField_a_of_type_Aomg).bZ = MsfSdkUtils.insertMtype("pttCd", ((aoll)this.jdField_a_of_type_Aomg).bZ);
    }
  }
  
  void dVq()
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    this.ckZ = "pttcenter";
    hM("findDbRec", "not found");
    aoql.a locala = new aoql.a();
    aoql.a.b localb = new aoql.a.b();
    localb.selfUin = this.h.mSelfUin;
    localb.peerUin = this.h.mPeerUin;
    localb.cmC = this.h.cmn;
    localb.uinType = this.h.mUinType;
    localb.uuid = this.h.cmo;
    localb.storageSource = this.ckZ;
    localb.cNX = this.h.cNz;
    localb.voiceType = 0;
    localb.busiType = 102;
    locala.b = this;
    locala.cmy = "c2c_ptt_dw";
    locala.He.add(localb);
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
  
  void dVr()
  {
    this.jdField_b_of_type_Aojn$a.dVf();
    String str3 = j(this.bMt, this.xp);
    aojn.m(this.Ha, this.xp);
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.bZ = str3;
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
    localaoll.a = this;
    localaoll.mTempPath = this.mTempPath;
    String str2 = null;
    String str1 = str2;
    if (this.xp != null)
    {
      str1 = str2;
      if (!this.xp.isEmpty()) {
        str1 = Arrays.toString(this.xp.toArray());
      }
    }
    str2 = aonc.ow(str3);
    hM("httpDown", "RespDomain: " + str2 + " ipList:" + str1 + " uuid:" + this.h.cmo + " downOffset:" + localaoll.apS);
    if (!azR()) {
      return;
    }
    this.jdField_a_of_type_Aomg = localaoll;
    dVe();
    this.c.a(localaoll);
  }
  
  /* Error */
  protected void g(com.tencent.qphone.base.remote.ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 131
    //   3: ldc_w 572
    //   6: invokevirtual 137	aolp:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_2
    //   10: invokevirtual 575	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   13: sipush 1000
    //   16: if_icmpeq +38 -> 54
    //   19: aload_2
    //   20: invokevirtual 575	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   23: istore 4
    //   25: aload_0
    //   26: ldc_w 577
    //   29: new 224	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 579
    //   39: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload 4
    //   44: invokevirtual 582	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokevirtual 137	aolp:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: return
    //   54: new 584	tencent/im/cs/cmd0x346/cmd0x346$RspBody
    //   57: dup
    //   58: invokespecial 585	tencent/im/cs/cmd0x346/cmd0x346$RspBody:<init>	()V
    //   61: astore_1
    //   62: aload_1
    //   63: aload_3
    //   64: invokevirtual 589	tencent/im/cs/cmd0x346/cmd0x346$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: pop
    //   68: aload_1
    //   69: getfield 590	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   72: invokevirtual 593	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   75: ifeq +91 -> 166
    //   78: aload_1
    //   79: getfield 590	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 595	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: i2l
    //   86: lstore 5
    //   88: lload 5
    //   90: ldc2_w 596
    //   93: lcmp
    //   94: ifne -41 -> 53
    //   97: aload_1
    //   98: getfield 601	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   101: invokevirtual 604	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:has	()Z
    //   104: ifeq -51 -> 53
    //   107: aload_1
    //   108: getfield 601	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   111: invokevirtual 607	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   114: checkcast 603	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp
    //   117: getfield 611	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   120: invokevirtual 614	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   123: istore 4
    //   125: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq -75 -> 53
    //   131: aload_0
    //   132: ldc_w 577
    //   135: new 224	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 616
    //   145: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload 4
    //   150: invokevirtual 582	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokevirtual 137	aolp:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: return
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 619	java/lang/Exception:printStackTrace	()V
    //   165: return
    //   166: ldc2_w 620
    //   169: lstore 5
    //   171: goto -83 -> 88
    //   174: astore_1
    //   175: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	aolp
    //   0	176	1	paramToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   0	176	2	paramFromServiceMsg	FromServiceMsg
    //   0	176	3	paramArrayOfByte	byte[]
    //   23	126	4	i	int
    //   86	84	5	l	long
    // Exception table:
    //   from	to	target	type
    //   54	62	160	java/lang/Exception
    //   68	88	160	java/lang/Exception
    //   97	159	160	java/lang/Exception
    //   62	68	174	java/lang/Exception
  }
  
  void onError()
  {
    super.onError();
    VR(2005);
  }
  
  public void onResp(aomh paramaomh)
  {
    boolean bool2 = true;
    super.onResp(paramaomh);
    this.jdField_a_of_type_Aomg = null;
    Object localObject = new StringBuilder().append(" result:");
    if (paramaomh.mResult == 0)
    {
      bool1 = true;
      hM("onHttpResp", bool1);
      localObject = this.jdField_b_of_type_Aojn$a;
      if (paramaomh.mResult != 0) {
        break label152;
      }
    }
    label152:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a((aojn.a)localObject, paramaomh, bool1);
      this.apq = paramaomh.apU;
      if (this.apq <= 0L) {
        this.apq = (paramaomh.apV + paramaomh.b.apS);
      }
      this.apr += paramaomh.apW;
      if (paramaomh.mResult != 0) {
        break label157;
      }
      obu.pe(this.h.clR);
      dVs();
      onSuccess();
      return;
      bool1 = false;
      break;
    }
    label157:
    if ((paramaomh.mErrCode == 9364) && (this.dOY < 3))
    {
      hM("[netChg]", "failed.but net change detect.so retry");
      this.dOY += 1;
      dVd();
      dVq();
      return;
    }
    onError();
  }
  
  void onSuccess()
  {
    super.onSuccess();
    VR(2003);
  }
  
  public void start()
  {
    super.start();
    VR(2001);
    dVq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aolp
 * JD-Core Version:    0.7.0.1
 */