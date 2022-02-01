import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;

public class aolq
  extends aojr
{
  public aolq(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    this.Ha = ((ProxyIpManager)this.app.getManager(3)).getProxyIp(4);
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
    sendRequest();
  }
  
  public int KH()
  {
    super.KH();
    return KL();
  }
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    this.jdField_a_of_type_Aoql$a = null;
    if (paramb != null)
    {
      int i = 0;
      if (i < paramb.Hf.size())
      {
        parama = (aoql.b.d)paramb.Hf.get(i);
        if (QLog.isColorLevel()) {
          hM("procUrl", parama.toString());
        }
        this.cLU = parama.cOc;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "JSPttUpProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.cLU);
        }
        a(this.jdField_a_of_type_Aojn$a, parama);
        if (parama.result == 0)
        {
          if (parama.isExist) {
            this.mResid = parama.uuid;
          }
          for (;;)
          {
            i += 1;
            break;
            this.mResid = parama.uuid;
            this.mUkey = parama.mUkey;
            this.xp = parama.ipList;
            this.bz = 0L;
            this.apx = parama.blockSize;
            obu.pd(this.mResid);
            diB();
          }
        }
        onError();
      }
    }
  }
  
  protected void dVe()
  {
    if ((this.jdField_a_of_type_Aomg != null) && ((this.jdField_a_of_type_Aomg instanceof aoll))) {
      ((aoll)this.jdField_a_of_type_Aomg).bZ = MsfSdkUtils.insertMtype("pttCu", ((aoll)this.jdField_a_of_type_Aomg).bZ);
    }
  }
  
  void onError()
  {
    super.onError();
    VR(1005);
    doReport(false);
  }
  
  public void onResp(aomh paramaomh)
  {
    Object localObject1 = null;
    super.onResp(paramaomh);
    this.jdField_a_of_type_Aomg = null;
    int i = paramaomh.dPy;
    for (;;)
    {
      long l2;
      try
      {
        if (paramaomh.mResult != 0) {
          break label505;
        }
        if (paramaomh.nR.get("User-ReturnCode") == null) {
          break label579;
        }
        l3 = Long.parseLong((String)paramaomh.nR.get("User-ReturnCode"));
        if ((l3 != 0L) && (l3 != 9223372036854775807L))
        {
          a(this.jdField_b_of_type_Aojn$a, paramaomh, false);
          a(-9527, null, e(i, l3), this.jdField_b_of_type_Aojn$a);
          onError();
          return;
        }
        str2 = (String)paramaomh.nR.get("Range");
        if (str2 == null) {
          break label587;
        }
      }
      catch (Exception paramaomh)
      {
        String str2;
        String str1;
        a(9343, aoja.e(new Exception("decode unknown exception")), "", this.jdField_b_of_type_Aojn$a);
        onError();
        return;
      }
      try
      {
        i = Integer.parseInt(str2);
        l1 = i;
        l2 = l1;
        if (l1 == 9223372036854775807L)
        {
          str1 = (String)paramaomh.nR.get("X-Range");
          localObject1 = str1;
          l2 = l1;
          if (str1 == null) {}
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      try
      {
        i = Integer.parseInt(str1);
        l2 = i;
        localObject1 = str1;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        l2 = 9223372036854775807L;
        Object localObject2 = localException2;
        continue;
        hM("decodeHttpResp", "from " + this.bz + " to " + l2 + " userReturnCode:" + l3);
        if (l2 > this.bz) {
          break label420;
        }
        if (this.dPd >= 3) {
          break label460;
        }
        hM("procHttpRespBody", "server offset rollback");
        this.dPd += 1;
        this.jdField_b_of_type_Aoko.transferedSize = l2;
        this.bz = l2;
        a(this.jdField_b_of_type_Aojn$a, paramaomh, true);
        if (l2 >= this.mFileSize) {
          break label500;
        }
        diB();
        return;
        a(this.jdField_b_of_type_Aojn$a, paramaomh, false);
        a(-9527, "", x(this.cld, this.dOT), this.jdField_b_of_type_Aojn$a);
        onError();
        return;
        onSuccess();
        return;
      }
      if (l2 == 9223372036854775807L)
      {
        a(this.jdField_b_of_type_Aojn$a, paramaomh, false);
        a(-9527, "no header range:" + str2 + " x-range:" + localObject1, x(this.cld, this.dOU), this.jdField_b_of_type_Aojn$a);
        aomq.Rd(true);
        onError();
        return;
      }
      label420:
      label460:
      label500:
      label505:
      if ((paramaomh.mErrCode == 9364) && (this.dOY < 3))
      {
        hM("[netChg]", "failed.but net change detect.so retry");
        this.dOY += 1;
        dVd();
        sendRequest();
        return;
      }
      a(this.jdField_b_of_type_Aojn$a, paramaomh, false);
      dN(paramaomh.mErrCode, paramaomh.clO);
      onError();
      return;
      label579:
      long l3 = 9223372036854775807L;
      continue;
      label587:
      long l1 = 9223372036854775807L;
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    VR(1003);
    doReport(true);
  }
  
  void sendRequest()
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    aoql.a locala = new aoql.a();
    aoql.a.j localj = new aoql.a.j();
    localj.selfUin = this.h.mSelfUin;
    localj.peerUin = this.h.mPeerUin;
    localj.cmC = this.h.cmn;
    localj.uinType = this.h.mUinType;
    localj.fileName = this.mFileName;
    localj.fileSize = ((int)this.mFileSize);
    localj.md5 = this.bL;
    localj.voiceType = 0;
    localj.voiceLength = 1;
    localj.audioPanelType = this.h.dQL;
    locala.b = this;
    locala.cmy = "c2c_ptt_up";
    locala.He.add(localj);
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
  
  public void start()
  {
    super.start();
    QZ(false);
  }
  
  protected String z(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    aonh localaonh = (aonh)this.xp.get(0);
    localStringBuilder.append("http://");
    localStringBuilder.append(localaonh.mIp);
    if (localaonh.port != 80)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(localaonh.port);
    }
    localStringBuilder.append("/qqcommfileupload?ver=");
    localStringBuilder.append(100);
    localStringBuilder.append("&ukey=");
    localStringBuilder.append(this.mUkey);
    localStringBuilder.append("&filekey=");
    localStringBuilder.append(this.clf);
    localStringBuilder.append("&filesize=");
    localStringBuilder.append(this.mFileSize);
    localStringBuilder.append("&bmd5=");
    localStringBuilder.append(MD5.toMD5(paramArrayOfByte));
    localStringBuilder.append("&range=");
    localStringBuilder.append(this.bz);
    localStringBuilder.append("&voice_codec=0");
    paramArrayOfByte = j(localStringBuilder.toString(), this.xp);
    aojn.m(this.Ha, this.xp);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aolq
 * JD-Core Version:    0.7.0.1
 */