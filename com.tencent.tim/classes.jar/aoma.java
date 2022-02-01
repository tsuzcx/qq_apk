import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.MultiMsgUpProcessor.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import tencent.im.longconn.longmsg.LongMsg.MsgUpReq;
import tencent.im.longconn.longmsg.LongMsg.ReqBody;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;
import tencent.im.msg.im_msg_head.LoginSig;

public class aoma
  extends aojr
{
  public static boolean cMR = true;
  private static int seq;
  private long akr;
  private auyc b;
  private String bRd;
  private byte[] bc;
  public boolean cMQ = true;
  public int dPD;
  private String dQ = this.h.dQ;
  private byte[] fR;
  private byte[] fT;
  private byte[] fU;
  private byte[] fV;
  private int mUinType = this.h.mUinType;
  private byte[] mUkey;
  private long startTime = -1L;
  
  public aoma(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    this.jdField_b_of_type_Auyc = new auyc();
    this.fT = paramaool.fT;
    this.dPD = paramaool.dPD;
    if (this.fT != null) {}
    for (this.mFileSize = paramaool.fT.length;; this.mFileSize = 0L) {
      try
      {
        this.akr = Long.parseLong(this.h.mSelfUin);
        return;
      }
      catch (Exception paramaooi)
      {
        paramaooi.printStackTrace();
        this.akr = 0L;
      }
    }
  }
  
  private boolean aAb()
  {
    Object localObject1 = new LongMsg.MsgUpReq();
    ((LongMsg.MsgUpReq)localObject1).setHasFlag(true);
    ((LongMsg.MsgUpReq)localObject1).uint64_dst_uin.set(Long.valueOf(this.h.mPeerUin).longValue());
    ((LongMsg.MsgUpReq)localObject1).bytes_msg_content.set(ByteStringMicro.copyFrom(this.fT));
    if (!cMR) {
      ((LongMsg.MsgUpReq)localObject1).bytes_msg_ukey.set(ByteStringMicro.copyFrom(this.mUkey));
    }
    ((LongMsg.MsgUpReq)localObject1).uint32_store_type.set(2);
    ((LongMsg.MsgUpReq)localObject1).uint32_msg_type.set(ju(this.mUinType));
    Object localObject2 = new LongMsg.ReqBody();
    ((LongMsg.ReqBody)localObject2).setHasFlag(true);
    ((LongMsg.ReqBody)localObject2).uint32_subcmd.set(1);
    ((LongMsg.ReqBody)localObject2).uint32_term_type.set(5);
    ((LongMsg.ReqBody)localObject2).uint32_platform_type.set(9);
    ((LongMsg.ReqBody)localObject2).rpt_msg_up_req.add((MessageMicro)localObject1);
    if ((this.cMQ) && (this.dPD == 0)) {
      ((LongMsg.ReqBody)localObject2).uint32_agent_type.set(1);
    }
    this.fU = ((LongMsg.ReqBody)localObject2).toByteArray();
    if (this.cMQ) {
      return true;
    }
    byte[] arrayOfByte = new Cryptor().encrypt(((LongMsg.ReqBody)localObject2).toByteArray(), this.fR);
    Object localObject3 = new im_msg_head.LoginSig();
    ((im_msg_head.LoginSig)localObject3).uint32_type.set(22);
    ((im_msg_head.LoginSig)localObject3).bytes_sig.set(ByteStringMicro.copyFrom(this.bc));
    localObject1 = new String();
    int i = 0;
    while (i < "3.4.4".length())
    {
      localObject2 = localObject1;
      if ("3.4.4".charAt(i) != '.') {
        localObject2 = ((String)localObject1).concat(Character.toString("3.4.4".charAt(i)));
      }
      i += 1;
      localObject1 = localObject2;
    }
    localObject2 = new im_msg_head.HttpConnHead();
    ((im_msg_head.HttpConnHead)localObject2).uint64_uin.set(this.akr);
    ((im_msg_head.HttpConnHead)localObject2).uint32_command.set(1791);
    ((im_msg_head.HttpConnHead)localObject2).uint32_sub_command.set(1291);
    ((im_msg_head.HttpConnHead)localObject2).uint32_seq.set(getSeq());
    ((im_msg_head.HttpConnHead)localObject2).uint32_version.set(Integer.parseInt((String)localObject1));
    ((im_msg_head.HttpConnHead)localObject2).uint32_flag.set(1);
    ((im_msg_head.HttpConnHead)localObject2).uint32_compress_type.set(0);
    ((im_msg_head.HttpConnHead)localObject2).uint32_error_code.set(0);
    localObject1 = new im_msg_head.Head();
    ((im_msg_head.Head)localObject1).uint32_head_type.set(4);
    ((im_msg_head.Head)localObject1).msg_login_sig.set((MessageMicro)localObject3);
    ((im_msg_head.Head)localObject1).msg_httpconn_head.set((MessageMicro)localObject2);
    localObject1 = ((im_msg_head.Head)localObject1).toByteArray();
    localObject2 = new ByteArrayOutputStream();
    try
    {
      localObject3 = new DataOutputStream((OutputStream)localObject2);
      ((DataOutputStream)localObject3).write(40);
      ((DataOutputStream)localObject3).writeInt(localObject1.length);
      ((DataOutputStream)localObject3).writeInt(arrayOfByte.length);
      ((DataOutputStream)localObject3).write((byte[])localObject1);
      ((DataOutputStream)localObject3).write(arrayOfByte);
      ((DataOutputStream)localObject3).write(41);
      ((DataOutputStream)localObject3).flush();
      this.fU = ((ByteArrayOutputStream)localObject2).toByteArray();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsgUpProcessor", 2, localException.getMessage());
      }
      dN(9360, "constructToSendData() dos.write()");
    }
    return false;
  }
  
  private static int getSeq()
  {
    int i = seq;
    seq = i + 1;
    return i;
  }
  
  public static int ju(int paramInt)
  {
    int i = 3;
    switch (paramInt)
    {
    default: 
      i = 1;
    case 1: 
    case 3000: 
      return i;
    case 1040: 
      return 15;
    }
    return 255;
  }
  
  private void sendRequest()
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    aoql.a.g localg = new aoql.a.g();
    localg.size = this.mFileSize;
    localg.md5 = this.bL;
    localg.dPD = this.dPD;
    localg.selfUin = this.h.mSelfUin;
    localg.peerUin = this.h.mPeerUin;
    localg.cmC = this.h.cmn;
    localg.uinType = this.h.mUinType;
    aoql.a locala = new aoql.a();
    locala.b = this;
    locala.cmy = "multi_msg_up";
    locala.He.add(localg);
    locala.a = this.app.getProtoReqManager();
    if (!azQ())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
      onError();
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          hM("requestStart", locala.toString());
        }
      } while (!azR());
      this.jdField_a_of_type_Aoql$a = locala;
    } while (!cMR);
    if (aAb())
    {
      diB();
      return;
    }
    onError();
  }
  
  public int EN()
  {
    if (this.mIsPause)
    {
      this.mIsPause = false;
      this.mIsCancel = false;
      VR(1002);
      this.dPd = 0;
      this.QV = 0;
      this.mUkey = null;
      this.dOO = 0;
      this.bz = 0L;
      this.errCode = 0;
      this.errDesc = "";
      this.jdField_b_of_type_Auyc.initParam();
      this.jdField_a_of_type_Aojm.a.post(new MultiMsgUpProcessor.2(this));
    }
    return 0;
  }
  
  public int KH()
  {
    super.KH();
    hM("uiParam", this.h.toString());
    if ((this.fT == null) || (0L >= this.mFileSize) || (0L == this.akr)) {
      return -1;
    }
    this.clg = "";
    return 0;
  }
  
  protected long U(long paramLong)
  {
    return this.fU.length;
  }
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    this.jdField_a_of_type_Aoql$a = null;
    if ((paramb == null) || (paramb.Hf == null) || (paramb.Hf.size() == 0))
    {
      dN(9006, "resp == null || resp.resps == null || resp.resps.size() == 0");
      onError();
    }
    for (;;)
    {
      return;
      parama = paramb.Hf.iterator();
      while (parama.hasNext())
      {
        paramb = (aoql.b.m)parama.next();
        if (QLog.isColorLevel()) {
          hM("procUrl", paramb.toString());
        }
        a(this.jdField_a_of_type_Aojn$a, paramb);
        paramb = (aoql.b.j)paramb;
        if (paramb.result != 0) {
          break label197;
        }
        this.fV = paramb.gh;
        this.mUkey = paramb.gj;
        this.xp = paramb.ipList;
        this.fR = paramb.gk;
        this.bc = paramb.gl;
        try
        {
          this.bRd = new String(this.fV, "utf-8");
          if (aAb()) {
            diB();
          }
        }
        catch (UnsupportedEncodingException paramb)
        {
          for (;;)
          {
            paramb.printStackTrace();
          }
          onError();
        }
      }
    }
    label197:
    dN(9007, "upResp.result=" + paramb.result);
    onError();
  }
  
  public boolean azT()
  {
    this.bL = MD5.toMD5Byte(this.fT);
    if (this.bL == null)
    {
      dN(9041, "getMd5 error");
      return false;
    }
    this.mFileName = HexUtil.bytes2HexStr(this.bL);
    this.clf = this.mFileName;
    this.jdField_b_of_type_Aoko.fileMd5 = this.mFileName;
    this.mFileName = (this.mFileName + "." + this.clg);
    return true;
  }
  
  public byte[] b(int paramInt1, int paramInt2)
  {
    return this.fU;
  }
  
  protected void dVe()
  {
    String str;
    if ((this.jdField_a_of_type_Aomg != null) && ((this.jdField_a_of_type_Aomg instanceof aoll)))
    {
      if (!top.fv(this.mUinType)) {
        break label56;
      }
      str = "multimsgCu";
    }
    for (;;)
    {
      ((aoll)this.jdField_a_of_type_Aomg).bZ = MsfSdkUtils.insertMtype(str, ((aoll)this.jdField_a_of_type_Aomg).bZ);
      return;
      label56:
      if (this.mUinType == 1) {
        str = "multimsgGu";
      } else {
        str = "multimsgDu";
      }
    }
  }
  
  public void diB()
  {
    if (this.startTime == -1L) {
      this.startTime = SystemClock.uptimeMillis();
    }
    this.jdField_b_of_type_Aojn$a.dVf();
    long l1 = this.bz;
    long l2 = U(l1);
    Object localObject = b((int)l1, (int)l2);
    if (localObject == null) {
      onError();
    }
    do
    {
      int i;
      do
      {
        return;
        hM("sendingdata", "pos:" + l1 + "  transferData len:" + localObject.length);
        if (!this.cMQ) {
          break;
        }
        this.bRd = UUID.randomUUID().toString();
        localObject = aoiz.getFilePath(this.bRd);
        File localFile = new File((String)localObject);
        if (localFile.exists()) {
          localFile.delete();
        }
        aqhq.writeFile(this.fU, (String)localObject);
        this.dQ = ((String)localObject);
        this.h.dQ = this.dQ;
        super.azT();
        localObject = new aomb(this);
        i = 77;
        if (!cMR) {
          i = 27;
        }
        this.mTrans = new Transaction(this.app.getCurrentAccountUin(), i, this.dQ, 0, this.bL, (ITransactionCallback)localObject, null, false);
        i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
        if (QLog.isColorLevel()) {
          QLog.i("MultiMsg_TAG", 2, "Multimsg upload file by BDH and retCode = " + i);
        }
      } while (i == 0);
      a(i, "SubmitError.", "", this.jdField_b_of_type_Aojn$a);
      onError();
      return;
      localObject = a((byte[])localObject);
      if (l1 + l2 >= this.mFileSize) {
        ((aoll)localObject).u.put("Connection", "close");
      }
    } while (!azR());
    this.jdField_a_of_type_Aomg = ((aomg)localObject);
    dVe();
    this.jdField_c_of_type_Aolm.a((aomg)localObject);
  }
  
  protected void doReport(boolean paramBoolean)
  {
    int i = 2;
    String str = this.jdField_a_of_type_Aojn$a.fB(1) + ";" + this.jdField_b_of_type_Aojn$a.fB(2) + ";" + this.jdField_c_of_type_Aojn$a.fB(3);
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsgUpProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
    }
    if (this.h.mBusiType == 1030) {}
    while (((!paramBoolean) && (aona.lQ(this.errCode))) || (this.cLT) || ((paramBoolean) && ((this.dOZ & 0x2) > 0)) || ((!paramBoolean) && ((this.dOZ & 0x1) > 0))) {
      return;
    }
    int j = this.dOZ;
    long l;
    if (paramBoolean)
    {
      this.dOZ = (i | j);
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      this.mM.put("param_step", str);
      this.mM.put("param_grpUin", this.h.mPeerUin);
      if (!paramBoolean) {
        break label426;
      }
      if ((this.apt <= 0L) || (this.apu <= 0L)) {
        break label421;
      }
      i = 1;
      label245:
      if ((this.cMa) && (i != 0))
      {
        this.W = new StringBuilder();
        this.W.append("s").append(this.dPa).append("_").append("tr").append(this.apt).append("_").append("ht").append(this.aps).append("_").append("pic").append(this.apu).append(";");
        this.mM.put("param_CostEach", this.W.toString());
        this.mM.put("param_sliceNum", String.valueOf(this.dPa));
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actMultiMsgUpload", true, l, this.mFileSize, this.mM, "");
    }
    for (;;)
    {
      dVc();
      return;
      i = 1;
      break;
      label421:
      i = 0;
      break label245;
      label426:
      if (this.errCode != -9527) {
        this.mM.remove("param_rspHeader");
      }
      this.mM.remove("param_url");
      this.mM.put("param_FailCode", String.valueOf(this.errCode));
      this.mM.put("param_errorDesc", this.errDesc);
      this.mM.put("param_picmd5", this.mFileName);
      this.mM.put("param_picSize", String.valueOf(this.mFileSize));
      this.mM.put("param_busi", String.valueOf(this.h.mBusiType));
      this.mM.put("param_uinType", String.valueOf(this.h.mUinType));
      this.mM.put("param_uniseq", String.valueOf(this.h.mUniseq));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actMultiMsgUpload", false, l, this.mFileSize, this.mM, "");
    }
  }
  
  public void onError()
  {
    super.onError();
    VR(1005);
    if (this.h.b != null)
    {
      akyf.a locala = new akyf.a();
      locala.result = -1;
      locala.errCode = this.errCode;
      locala.errStr = this.errDesc;
      locala.data = Long.valueOf(this.h.mUniseq);
      this.h.b.b(locala);
    }
  }
  
  /* Error */
  public void onResp(aomh paramaomh)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 907	aojr:onResp	(Laomh;)V
    //   5: aload_0
    //   6: getfield 439	aoma:mIsCancel	Z
    //   9: ifne +10 -> 19
    //   12: aload_0
    //   13: getfield 436	aoma:mIsPause	Z
    //   16: ifeq +4 -> 20
    //   19: return
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 607	aoma:jdField_a_of_type_Aomg	Laomg;
    //   25: aload_0
    //   26: ldc_w 908
    //   29: new 560	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 561	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 910
    //   39: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: getfield 915	aomh:mResult	I
    //   46: invokevirtual 570	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc_w 917
    //   52: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 920	aomh:mErrCode	I
    //   59: invokevirtual 570	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 922
    //   65: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: getfield 925	aomh:clO	Ljava/lang/String;
    //   72: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 571	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokevirtual 421	aoma:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_1
    //   82: getfield 915	aomh:mResult	I
    //   85: ifne +209 -> 294
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 928	aoma:dOY	I
    //   93: aload_1
    //   94: getfield 931	aomh:nR	Ljava/util/HashMap;
    //   97: ldc_w 933
    //   100: invokevirtual 936	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: astore 8
    //   105: aload 8
    //   107: ifnull +162 -> 269
    //   110: aload_1
    //   111: getfield 931	aomh:nR	Ljava/util/HashMap;
    //   114: ldc_w 933
    //   117: invokevirtual 936	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   120: checkcast 213	java/lang/String
    //   123: invokestatic 261	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   126: istore_2
    //   127: iload_2
    //   128: ifeq +10 -> 138
    //   131: iload_2
    //   132: ldc_w 937
    //   135: if_icmpne +141 -> 276
    //   138: iconst_1
    //   139: istore_3
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 637	aoma:jdField_b_of_type_Aojn$a	Laojn$a;
    //   145: aload_1
    //   146: iload_3
    //   147: invokevirtual 940	aoma:a	(Laojn$a;Laomh;Z)V
    //   150: invokestatic 635	android/os/SystemClock:uptimeMillis	()J
    //   153: lstore 4
    //   155: aload_0
    //   156: getfield 42	aoma:startTime	J
    //   159: lstore 6
    //   161: iload_3
    //   162: ifeq +119 -> 281
    //   165: aload_0
    //   166: ldc_w 908
    //   169: new 560	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 561	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 942
    //   179: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: lload 4
    //   184: lload 6
    //   186: lsub
    //   187: invokevirtual 648	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   190: ldc_w 944
    //   193: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: getfield 595	aoma:jdField_b_of_type_Aoko	Laoko;
    //   200: getfield 947	aoko:fileSize	J
    //   203: invokevirtual 648	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: ldc_w 949
    //   209: invokevirtual 567	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: iload_2
    //   213: invokevirtual 570	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: invokevirtual 571	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokevirtual 421	aoma:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_0
    //   223: invokevirtual 952	aoma:onSuccess	()V
    //   226: return
    //   227: astore_1
    //   228: aload_0
    //   229: sipush 9343
    //   232: new 35	java/lang/Exception
    //   235: dup
    //   236: ldc_w 954
    //   239: invokespecial 955	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   242: invokestatic 961	aoja:e	(Ljava/lang/Exception;)Ljava/lang/String;
    //   245: ldc_w 459
    //   248: aload_0
    //   249: getfield 637	aoma:jdField_b_of_type_Aojn$a	Laojn$a;
    //   252: invokevirtual 410	aoma:a	(ILjava/lang/String;Ljava/lang/String;Laojn$a;)V
    //   255: aload_0
    //   256: invokevirtual 413	aoma:onError	()V
    //   259: return
    //   260: astore 8
    //   262: ldc_w 962
    //   265: istore_2
    //   266: goto -139 -> 127
    //   269: ldc_w 937
    //   272: istore_2
    //   273: goto -146 -> 127
    //   276: iconst_0
    //   277: istore_3
    //   278: goto -138 -> 140
    //   281: aload_0
    //   282: iload_2
    //   283: ldc_w 964
    //   286: invokevirtual 330	aoma:dN	(ILjava/lang/String;)V
    //   289: aload_0
    //   290: invokevirtual 413	aoma:onError	()V
    //   293: return
    //   294: aload_0
    //   295: aload_0
    //   296: getfield 637	aoma:jdField_b_of_type_Aojn$a	Laojn$a;
    //   299: aload_1
    //   300: iconst_0
    //   301: invokevirtual 940	aoma:a	(Laojn$a;Laomh;Z)V
    //   304: aload_0
    //   305: aload_1
    //   306: getfield 920	aomh:mErrCode	I
    //   309: aload_1
    //   310: getfield 925	aomh:clO	Ljava/lang/String;
    //   313: invokevirtual 330	aoma:dN	(ILjava/lang/String;)V
    //   316: aload_0
    //   317: invokevirtual 413	aoma:onError	()V
    //   320: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	aoma
    //   0	321	1	paramaomh	aomh
    //   126	157	2	i	int
    //   139	139	3	bool	boolean
    //   153	30	4	l1	long
    //   159	26	6	l2	long
    //   103	3	8	localObject	Object
    //   260	1	8	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   81	105	227	java/lang/Exception
    //   110	127	227	java/lang/Exception
    //   140	161	227	java/lang/Exception
    //   165	226	227	java/lang/Exception
    //   281	293	227	java/lang/Exception
    //   294	320	227	java/lang/Exception
    //   110	127	260	java/lang/NumberFormatException
  }
  
  public void onSuccess()
  {
    super.onSuccess();
    akyf.a locala;
    if (this.h.b != null)
    {
      locala = new akyf.a();
      locala.errCode = 0;
      locala.size = this.mFileSize;
      locala.md5 = this.clf;
      locala.data = Long.valueOf(this.h.mUniseq);
    }
    try
    {
      locala.uuid = new String(this.fV, "UTF-8");
      this.h.b.b(locala);
      VR(1003);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        locala.errCode = -1;
        locala.errStr = ("Failed. Convert ResID to UTF-8 string failed, resID = " + this.fV.toString());
        hM("onSuccess", locala.errStr);
      }
    }
  }
  
  public void start()
  {
    super.start();
    VR(1000);
    if ((this.fT == null) || (this.fT.length == 0))
    {
      dN(9042, "data is empty");
      onError();
      return;
    }
    if ((this.bL == null) && (!azT()))
    {
      onError();
      return;
    }
    sendRequest();
  }
  
  protected String z(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    aonh localaonh = (aonh)this.xp.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(localaonh.mIp);
    if (localaonh.port != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(localaonh.port);
    }
    paramArrayOfByte.append("/cgi-bin/httpconn");
    return paramArrayOfByte.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoma
 * JD-Core Version:    0.7.0.1
 */