import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker.1;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker.2;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker.4;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

public class agll
  implements agkv.b, agpb
{
  private final String TAG = "OfflineSendWorker<FileAssistant>";
  private long YR;
  protected long YS;
  protected long YT;
  public aglc a;
  private VFSFile a;
  protected final String aBA = "actFileUp";
  protected final String bHN = "actFileUpDetail";
  private String bHY;
  public final FileManagerEntity c;
  protected int cXF;
  protected int cXp = 0;
  private boolean cdX;
  private boolean cdY;
  public boolean cdZ;
  protected boolean cea;
  protected byte[] dR;
  protected byte[] dS;
  protected byte[] dT;
  protected byte[] dU;
  private agie e = new aglm(this);
  public final QQAppInterface mApp;
  protected long mEndTime;
  protected boolean mIsStop = true;
  public long mStartTime;
  private int mStatus = -1;
  
  public agll(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.mApp = paramQQAppInterface;
    this.c = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMmVfsVFSFile = new VFSFile(paramFileManagerEntity.getFilePath());
    this.c.status = 0;
    paramQQAppInterface.a().u(this.c);
    this.c.fProgress = 0.0F;
    this.c.status = 2;
  }
  
  private void a(agib.b paramb, boolean paramBoolean, String paramString, short paramShort, List<String> paramList1, List<String> paramList2)
  {
    ThreadManager.post(new OfflineSendWorker.4(this, paramb, paramBoolean, paramString, paramList1, paramList2, paramShort), 5, null, false);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "start OfflineFileHitReq:" + anaz.gQ());
    }
    ahav.a.getExecutor().execute(new OfflineSendWorker.2(this, paramString, paramLong, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte2, paramArrayOfByte1));
    this.cdY = false;
    this.cXF = 1;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong, agie paramagie, FileManagerEntity paramFileManagerEntity)
  {
    paramagie = new agzw();
    paramagie.bJz = paramFileManagerEntity.peerUin;
    paramagie.ej = paramArrayOfByte2;
    paramagie.ei = paramArrayOfByte1;
    paramagie.fileSize = paramFileManagerEntity.fileSize;
    paramFileManagerEntity.strFileMd5 = agoy.t(paramArrayOfByte3);
    paramagie.md5 = paramArrayOfByte3;
    this.dS = paramArrayOfByte3;
    byte[] arrayOfByte = new byte[paramArrayOfByte3.length + 4];
    aqoj.b(arrayOfByte, 0, paramArrayOfByte3, paramArrayOfByte3.length);
    aqoj.DWord2Byte(arrayOfByte, paramArrayOfByte3.length, paramFileManagerEntity.fileSize);
    this.bHY = com.qq.taf.jce.HexUtil.bytes2HexStr(arrayOfByte).toLowerCase(Locale.US);
    int i;
    if (((agiq)this.mApp.getManager(317)).ald()) {
      if (alF())
      {
        i = 1;
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "SendOfflineFile: UseMediaPlatform enabled");
      }
    }
    while (i != 0)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "多媒体平台, 不管大小统一使用v3 协议，采用小文件策略");
      paramagie.bUseMediaPlatform = true;
      paramagie.cYU = 1700;
      paramString = ahav.x(new String(paramArrayOfByte1));
      if (paramString == null)
      {
        j(null, 0);
        return;
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "SendOfflineFile: UseMediaPlatform enabled, but is retry or not use Exciting Send");
        i = 0;
        continue;
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "SendOfflineFile: UseMediaPlatform not enabled");
        i = 0;
      }
      else
      {
        dhG();
        paramFileManagerEntity.strFileSHA = agoy.t(paramString);
        bd(paramString);
        paramagie.sha1 = paramString;
        b(false, paramagie.sha1);
        paramagie.ek = ahav.y(new String(paramArrayOfByte1));
        paramagie.el = ahav.B(new String(paramArrayOfByte1));
      }
    }
    for (;;)
    {
      this.mApp.a().a(paramagie, this.e, paramFileManagerEntity);
      return;
      if (paramLong <= 104857600L)
      {
        paramagie.cYU = 1700;
        paramString = ahav.x(new String(paramArrayOfByte1));
        if (paramString == null)
        {
          j(null, 0);
          return;
        }
        dhG();
        paramFileManagerEntity.strFileSHA = agoy.t(paramString);
        bd(paramString);
        paramagie.sha1 = paramString;
        b(false, paramagie.sha1);
      }
      else
      {
        paramagie.cYU = 1600;
        arrayOfByte = ahav.B(new String(paramArrayOfByte1));
        if (arrayOfByte == null)
        {
          j(null, 0);
          return;
        }
        paramFileManagerEntity.strFileSha3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(arrayOfByte);
        paramFileManagerEntity.str10Md5 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(paramArrayOfByte3);
        paramagie.el = arrayOfByte;
        this.dU = arrayOfByte;
        a(paramString, paramArrayOfByte1, paramArrayOfByte2, paramLong, paramArrayOfByte3, arrayOfByte);
      }
    }
  }
  
  private boolean a(agib.b paramb)
  {
    return (!paramb.bUseMediaPlatform) && ((paramb.strIP == null) || (paramb.strIP.length() == 0));
  }
  
  private boolean b(agib.b paramb)
  {
    return (!TextUtils.isEmpty(paramb.bHg)) && (agke.a().l(this.mApp, 1));
  }
  
  private void dhF()
  {
    clearTask();
    j(null, 0);
  }
  
  private void dhJ()
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [MiaoChuan] Id[" + this.c.nSessionId + "] is exist, Go [SetFileStatus Step]");
    dhE();
    this.mEndTime = System.currentTimeMillis();
    ahav.jR(this.c.nSessionId);
    this.mApp.a().a(this.c, 5, "");
    this.mApp.a().a(this.c, this.mApp.getAccount(), this.c.peerUin, this.c.Uuid, this.c.bUseMediaPlatform, this.c.fileIdCrc, this.e);
    ahau.a locala = new ahau.a();
    locala.bJE = "send_file_suc";
    locala.cYX = 1;
    ahau.a(this.mApp.getCurrentAccountUin(), locala);
    this.c.status = 1;
    this.mApp.a().u(this.c);
  }
  
  private void k(long paramLong, int paramInt, String paramString)
  {
    c(paramLong, paramInt, paramString, null);
  }
  
  private void l(long paramLong, int paramInt, String paramString)
  {
    d(paramLong, paramInt, paramString, null);
  }
  
  private void setStatus(int paramInt)
  {
    paramInt = ahav.hM(paramInt);
    if ((this.mStatus == paramInt) && (paramInt == 2)) {}
    do
    {
      return;
      this.mStatus = paramInt;
      this.c.status = paramInt;
    } while (paramInt == 2);
    this.mApp.a().u(this.c);
  }
  
  protected int Eo()
  {
    if (this.jdField_a_of_type_Aglc == null) {
      return 0;
    }
    return ahbr.dg(this.jdField_a_of_type_Aglc.getUrl());
  }
  
  public void IC(String paramString) {}
  
  protected void IQ(String paramString)
  {
    long l2 = 1L;
    long l1 = l2;
    if (!this.cdZ)
    {
      l1 = l2;
      if (this.jdField_a_of_type_Aglc != null)
      {
        l1 = l2;
        if (this.c.fileSize > this.jdField_a_of_type_Aglc.fG()) {
          l1 = this.c.fileSize - this.jdField_a_of_type_Aglc.fG();
        }
      }
    }
    Bundle localBundle = new Bundle();
    if (alF()) {
      localBundle.putInt("param_fromType", 1);
    }
    localBundle.putLong("param_transferTime", fH());
    localBundle.putInt("param_V6SelectType", this.cXp);
    localBundle.putInt("param_ipAddrType", Eo());
    int i;
    if (this.cea)
    {
      i = 1;
      localBundle.putInt("param_ishttps", i);
      if (this.jdField_a_of_type_Aglc == null) {
        break label327;
      }
      ahav.a(this.mApp, this.c.nSessionId, "actFileUp", this.mEndTime - this.mStartTime, this.jdField_a_of_type_Aglc.getUrl(), this.c.peerUin, this.c.Uuid, this.c.strFileMd5, l1, this.c.fileSize, this.c.fileSize, this.jdField_a_of_type_Aglc.getRetryCount(), paramString, localBundle);
      if (!alF()) {
        ahav.a(this.mApp, this.c.nSessionId, "actFileUpDetail", this.mEndTime - this.mStartTime, this.jdField_a_of_type_Aglc.getUrl(), this.c.peerUin, this.c.Uuid, this.c.strFileMd5, l1, this.c.fileSize, this.c.fileSize, this.jdField_a_of_type_Aglc.getRetryCount(), paramString, localBundle);
      }
    }
    label327:
    do
    {
      return;
      i = 0;
      break;
      ahav.a(this.mApp, this.c.nSessionId, "actFileUp", this.mEndTime - this.mStartTime, null, this.c.peerUin, this.c.Uuid, this.c.strFileMd5, l1, this.c.fileSize, this.c.fileSize, 0, paramString, localBundle);
    } while (alF());
    ahav.a(this.mApp, this.c.nSessionId, "actFileUpDetail", this.mEndTime - this.mStartTime, null, this.c.peerUin, this.c.Uuid, this.c.strFileMd5, l1, this.c.fileSize, this.c.fileSize, 0, paramString, localBundle);
  }
  
  public aglc a(agib.b paramb, List<String> paramList, int paramInt, boolean paramBoolean, String paramString)
  {
    return null;
  }
  
  public FileManagerEntity a()
  {
    return this.c;
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.mIsStop) {
      return;
    }
    if (paramInt == 0)
    {
      paramInt = 9001;
      paramString1 = "[Http_RespValue_Null]" + ahav.ti();
    }
    for (;;)
    {
      String str = paramString1;
      if (paramString1 == null) {
        str = "errMsgString_NUll_retCode[" + paramInt + "]";
      }
      if (!paramBoolean)
      {
        d(paramLong, paramInt, str, paramString2);
        return;
      }
      jr(System.currentTimeMillis());
      d(paramLong, paramInt, str, paramString2);
      dhF();
      return;
    }
  }
  
  public byte[] a(Bundle paramBundle)
  {
    if (((this.dT == null) || (this.dT.length == 0)) && (paramBundle != null)) {
      paramBundle.putInt("_shaCalcProgress_", this.cXF);
    }
    return this.dT;
  }
  
  protected boolean alD()
  {
    return false;
  }
  
  protected boolean alE()
  {
    return false;
  }
  
  public boolean alF()
  {
    return false;
  }
  
  public void b(boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void bd(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      this.dT = paramArrayOfByte;
      this.cXF = 2;
      return;
    }
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "setSha err sha=null. sessionid[" + this.c.nSessionId + "]");
  }
  
  protected void c(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    long l2 = 1L;
    long l1 = l2;
    if (!this.cdZ)
    {
      l1 = l2;
      if (this.jdField_a_of_type_Aglc != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Aglc.fF() > this.jdField_a_of_type_Aglc.fG()) {
          l1 = this.jdField_a_of_type_Aglc.fF() - this.jdField_a_of_type_Aglc.fG();
        }
      }
    }
    Bundle localBundle = new Bundle();
    if (alF()) {
      localBundle.putInt("param_fromType", 1);
    }
    localBundle.putLong("param_transferTime", fH());
    localBundle.putInt("param_V6SelectType", this.cXp);
    localBundle.putInt("param_ipAddrType", Eo());
    if (this.cea) {}
    for (int i = 1;; i = 0)
    {
      localBundle.putInt("param_ishttps", i);
      if (this.jdField_a_of_type_Aglc != null) {
        break;
      }
      ahav.a(this.mApp, this.c.nSessionId, "actFileUp", this.mStartTime, null, this.c.peerUin, this.c.Uuid, this.c.strFileMd5, paramInt, "", l1, paramLong, this.c.fileSize, null, paramString2, 0, paramString1, null, localBundle);
      return;
    }
    ahav.a(this.mApp, this.c.nSessionId, "actFileUp", this.mStartTime, this.jdField_a_of_type_Aglc.getUrl(), this.c.peerUin, this.c.Uuid, this.c.strFileMd5, paramInt, "", l1, paramLong, this.c.fileSize, this.jdField_a_of_type_Aglc.getUrl(), paramString2, this.jdField_a_of_type_Aglc.getRetryCount(), paramString1, null, localBundle);
  }
  
  public void c(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    if (this.mIsStop) {
      return;
    }
    if (!paramBoolean)
    {
      d(paramLong, 9009, paramString1, paramString2);
      return;
    }
    setStatus(1005);
    this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 15, null, 5, null);
    clearTask();
    c(paramLong, 9009, paramString1, paramString2);
  }
  
  public void clearTask()
  {
    this.mIsStop = true;
    if (this.jdField_a_of_type_Aglc != null) {
      this.jdField_a_of_type_Aglc.bme();
    }
    if (this.YS > 0L) {
      jr(System.currentTimeMillis());
    }
  }
  
  protected void d(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    long l2 = 1L;
    long l1 = l2;
    if (!this.cdZ)
    {
      l1 = l2;
      if (this.jdField_a_of_type_Aglc != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Aglc.fF() > this.jdField_a_of_type_Aglc.fG()) {
          l1 = this.jdField_a_of_type_Aglc.fF() - this.jdField_a_of_type_Aglc.fG();
        }
      }
    }
    Bundle localBundle = new Bundle();
    if (alF()) {
      localBundle.putInt("param_fromType", 1);
    }
    localBundle.putLong("param_transferTime", fH());
    localBundle.putInt("param_V6SelectType", this.cXp);
    localBundle.putInt("param_ipAddrType", Eo());
    if (this.cea) {}
    for (int i = 1;; i = 0)
    {
      localBundle.putInt("param_ishttps", i);
      if (this.jdField_a_of_type_Aglc != null) {
        break;
      }
      ahav.a(this.mApp, this.c.nSessionId, "actFileUpDetail", this.mStartTime, null, this.c.peerUin, this.c.Uuid, this.c.strFileMd5, paramInt, "", l1, paramLong, this.c.fileSize, null, null, 0, paramString2, null, localBundle);
      return;
    }
    ahav.a(this.mApp, this.c.nSessionId, "actFileUpDetail", this.mStartTime, this.jdField_a_of_type_Aglc.getUrl(), this.c.peerUin, this.c.Uuid, this.c.strFileMd5, paramInt, "", l1, paramLong, this.c.fileSize, this.jdField_a_of_type_Aglc.getUrl(), paramString2, this.jdField_a_of_type_Aglc.getRetryCount(), paramString1, null, localBundle);
  }
  
  public void dgA()
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [Upload Step]Id[" + this.c.nSessionId + "]onUpdate success, go [SetFileStatus Step]");
    dhE();
    this.mEndTime = System.currentTimeMillis();
    jr(System.currentTimeMillis());
    if ((!this.cdZ) && (this.jdField_a_of_type_Aglc != null)) {
      this.cdZ = this.jdField_a_of_type_Aglc.alC();
    }
    this.c.setCloudType(3);
    setStatus(1003);
    this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 14, new Object[] { this.c.getFilePath(), Long.valueOf(this.c.fileSize), Boolean.valueOf(true), this.jdField_a_of_type_Aglc.getUrl() }, 0, null);
    this.mApp.a().a(this.c, this.mApp.getAccount(), this.c.peerUin, this.c.Uuid, this.c.bUseMediaPlatform, this.c.fileIdCrc, this.e);
    ahau.a locala = new ahau.a();
    locala.bJE = "send_file_suc";
    locala.cYX = 1;
    ahau.a(this.mApp.getCurrentAccountUin(), locala);
    this.c.status = 1;
    this.mApp.a().u(this.c);
  }
  
  public void dgB()
  {
    if (this.cdX)
    {
      this.c.strServerPath = "";
      this.c.bombData = null;
      this.c.httpsDomain = "";
      dhI();
      return;
    }
    QLog.e("OfflineSendWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.c.nSessionId) + "]onOutDate, but not use last server path");
  }
  
  public void dgC() {}
  
  public void dgu()
  {
    this.mIsStop = false;
    this.cdZ = false;
    this.cea = false;
    ThreadManager.post(new Thread(new OfflineSendWorker.1(this)), 5, null, true);
  }
  
  public void dgv()
  {
    clearTask();
  }
  
  public void dgw()
  {
    clearTask();
    if (1 == this.c.status)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.c.nSessionId) + "] is Successed, return!");
      }
      return;
    }
    setStatus(3);
    this.mApp.a().b(true, 3, null);
    long l = System.currentTimeMillis();
    String str = "Now[" + l + "]startTime[" + this.mStartTime + "]notifyTime[" + this.YR + "]";
    l = 0L;
    if (this.jdField_a_of_type_Aglc != null) {
      l = this.jdField_a_of_type_Aglc.fF();
    }
    k(l, 9037, str);
    l(l, 9037, str);
  }
  
  public void dgx()
  {
    clearTask();
  }
  
  public void dgz()
  {
    jr(System.currentTimeMillis());
    if ((!this.cdZ) && (this.jdField_a_of_type_Aglc != null)) {
      this.cdZ = this.jdField_a_of_type_Aglc.alC();
    }
    dhJ();
  }
  
  public void dhE()
  {
    this.cdY = true;
    this.cXF = 3;
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "cancelShaReq. sessionid[" + this.c.nSessionId + "]");
  }
  
  public void dhG() {}
  
  protected void dhH() {}
  
  public void dhI()
  {
    this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 13, null, 0, null);
    this.mApp.a().o(this.c.nSessionId, 1002);
    this.c.status = 0;
    this.mApp.a().u(this.c);
    this.c.status = 2;
    this.c.fProgress = 0.0F;
    jq(0L);
    jr(0L);
    this.cdZ = false;
    if (this.c.getFilePath() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.c.nSessionId + "], strFilePath is null");
      }
      l(0L, 9005, ahav.ti());
      k(0L, 9005, ahav.ti());
      dhF();
    }
    label357:
    label761:
    do
    {
      return;
      dhH();
      if ((alF()) && (alE()) && (alD()))
      {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "re sendLocalFile, SessionId[" + this.c.nSessionId + "], custom uploader handled");
        return;
      }
      boolean bool1 = false;
      boolean bool3 = false;
      Object localObject1 = null;
      byte[] arrayOfByte = null;
      boolean bool2 = bool1;
      Object localObject2 = localObject1;
      int i;
      if (this.c.strServerPath != null)
      {
        bool2 = bool1;
        localObject2 = localObject1;
        if (this.c.bombData != null)
        {
          i = 0;
          if (!agmx.aE(this.mApp)) {
            break label785;
          }
          if (!this.c.strServerPath.startsWith("https")) {
            break label773;
          }
          if (TextUtils.isEmpty(this.c.httpsDomain)) {
            break label761;
          }
          bool1 = true;
          localObject1 = this.c.httpsDomain;
          bool2 = bool1;
          localObject2 = localObject1;
          if (i != 0)
          {
            QLog.w("OfflineSendWorker<FileAssistant>", 1, "sendLocalFile, SessionId[" + this.c.nSessionId + "], resend. but reReqCsSend");
            this.c.strServerPath = "";
            this.c.bombData = null;
            this.c.httpsDomain = "";
            localObject2 = localObject1;
            bool2 = bool1;
          }
        }
      }
      if (!TextUtils.isEmpty(this.c.strServerPath))
      {
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "sendLocalFile, SessionId[" + this.c.nSessionId + "], resend serverPath:" + this.c.strServerPath + " isHttpsOnResend:" + bool2 + " httpsDomainOnResend:" + (String)localObject2);
        if (this.c.bombData != null) {
          this.jdField_a_of_type_Aglc = agkv.a(this.mApp, this.c.nSessionId, this.c.peerType, 0, this.c.getFilePath(), new String(this.c.bombData), this.c.strFileSHA, this.c.strServerPath, bool2, (String)localObject2);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Aglc != null)
          {
            this.cdX = true;
            this.jdField_a_of_type_Aglc.a(this);
            if (!this.jdField_a_of_type_Aglc.cd(0L))
            {
              setStatus(1005);
              this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 15, null, 0, "");
              l(this.c.fileSize, 9045, "sendFile error");
              k(this.c.fileSize, 9045, "sendFile error");
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("OfflineSendWorker<FileAssistant>", 2, "nSessionID[" + this.c.nSessionId + "],sendFile return false");
              return;
              i = 1;
              bool1 = bool3;
              localObject1 = arrayOfByte;
              break label357;
              i = 1;
              bool1 = bool3;
              localObject1 = arrayOfByte;
              break label357;
              bool1 = bool3;
              localObject1 = arrayOfByte;
              if (!this.c.strServerPath.startsWith("https")) {
                break label357;
              }
              i = 1;
              bool1 = bool3;
              localObject1 = arrayOfByte;
              break label357;
              this.jdField_a_of_type_Aglc = agkv.a(this.mApp, this.c.nSessionId, this.c.peerType, 0, this.c.getFilePath(), this.c.strServerPath);
              continue;
            }
            jq(System.currentTimeMillis());
            return;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.c.nSessionId + "], serverPath is null, so get upload info");
      }
      if (this.c.tmpSessionType > 0L) {
        this.c.tmpSessionSig = ahav.a(this.mApp, this.c.peerUin, (int)this.c.tmpSessionType);
      }
      try
      {
        localObject1 = this.c.fileName.getBytes("utf-8");
        localObject2 = this.c.getFilePath().getBytes("utf-8");
        arrayOfByte = ahav.t(this.c.getFilePath());
        if (arrayOfByte == null)
        {
          setStatus(0);
          l(0L, 9042, "get md5 failed");
          k(0L, 9042, "get md5 failed");
          this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 15, null, 5, null);
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("OfflineSendWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.c.nSessionId + "], getMd5 failed");
        }
        setStatus(0);
        l(0L, 9005, ahav.ti());
        k(0L, 9005, ahav.ti());
        this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 15, null, 5, null);
        return;
      }
      a(this.c.peerUin, (byte[])localObject2, localUnsupportedEncodingException, arrayOfByte, this.c.fileSize, this.e, this.c);
    } while (!QLog.isColorLevel());
    label773:
    label785:
    QLog.e("##########", 2, "发送CS包,请求上传,nSessionID[" + String.valueOf(this.c.nSessionId) + "]");
  }
  
  protected long fH()
  {
    if ((this.YS == 0L) || (this.YT == 0L)) {}
    while (this.YT <= this.YS) {
      return 0L;
    }
    return this.YT - this.YS;
  }
  
  public int getActionType()
  {
    return 0;
  }
  
  public String getFileId()
  {
    return null;
  }
  
  public long getFileSize()
  {
    return this.c.fileSize;
  }
  
  public int getProgress()
  {
    if (this.c.fileSize <= 0L) {}
    while (this.jdField_a_of_type_Aglc == null) {
      return 0;
    }
    return (int)(this.jdField_a_of_type_Aglc.fF() * 100L / this.c.fileSize);
  }
  
  public int getStatus()
  {
    return this.c.status;
  }
  
  public boolean isStop()
  {
    return this.mIsStop;
  }
  
  public void j(Object paramObject, int paramInt)
  {
    paramInt = 0;
    this.mApp.a().dhl();
    this.c.isReaded = false;
    paramObject = this.c;
    if (this.c.status != 16) {}
    for (;;)
    {
      paramObject.status = paramInt;
      this.mApp.a().u(this.c);
      this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 15, null, 5, null);
      return;
      paramInt = 16;
    }
  }
  
  public void jm(long paramLong)
  {
    this.c.fProgress = ((float)paramLong / (float)this.c.fileSize);
    setStatus(1002);
    paramLong = System.currentTimeMillis();
    if (paramLong - this.YR >= 1000L)
    {
      this.YR = paramLong;
      this.c.setCloudType(3);
      this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 16, null, 0, null);
    }
  }
  
  public void jq(long paramLong)
  {
    this.YS = paramLong;
  }
  
  protected void jr(long paramLong)
  {
    this.YT = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agll
 * JD-Core Version:    0.7.0.1
 */