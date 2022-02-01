import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agpv
  extends agll
  implements agqd
{
  final String TAG = "ExcitingTransfer.OfflineSendWorker<FileAssistant>";
  protected long ZW;
  protected long ZX;
  private boolean ceI;
  private boolean ceJ = true;
  
  public agpv(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
  }
  
  private int EC()
  {
    if ((this.a != null) && ((this.a instanceof agpz))) {
      return ((agpz)this.a).EF();
    }
    return 0;
  }
  
  private void Jx(boolean paramBoolean)
  {
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.c.nSessionId) + "] setCloseExtfAbility:" + this.ceI + "->" + paramBoolean);
    this.ceI = paramBoolean;
  }
  
  private void Or(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramInt == 9037)
    {
      diM();
      return;
    }
    int i = EC();
    agpu localagpu = null;
    Object localObject = localagpu;
    if (this.a != null)
    {
      localObject = localagpu;
      if ((this.a instanceof agpz)) {
        localObject = ((agpz)this.a).b();
      }
    }
    localagpu = new agpu(this.mApp);
    if (localObject != null)
    {
      paramInt = ahbr.df(((ExcitingTransferUploadResultRp)localObject).m_strServerIp);
      if (((ExcitingTransferUploadResultRp)localObject).m_nResult == 0L)
      {
        localagpu.a((ExcitingTransferUploadResultRp)localObject);
        label106:
        localagpu.p(this.c.nSessionId);
        localObject = ahav.lb(this.c.fileName);
        localagpu.a(Long.valueOf(this.c.peerUin).longValue(), 0L, this.c.fileName, (String)localObject, this.c.fileSize);
        localagpu.Jw(this.cdZ);
        long l = this.mEndTime - this.mStartTime;
        if (l <= 0L) {
          break label316;
        }
        localagpu.jJ(l);
        label199:
        l = this.ZX - this.ZW;
        if (l <= 0L) {
          break label325;
        }
        localagpu.jI(l);
      }
    }
    for (;;)
    {
      localagpu.Oo(i);
      localagpu.Op(paramInt);
      localagpu.Ju(this.cea);
      localagpu.Js(bool1);
      return;
      bool1 = false;
      break;
      if (paramInt == 0) {
        bool1 = bool2;
      }
      for (;;)
      {
        if (!bool1)
        {
          if (this.YS == 0L)
          {
            localagpu.setResult(paramInt);
            paramInt = 0;
            break;
            bool1 = false;
            continue;
          }
          localagpu.setResult(17);
          paramInt = 0;
          break;
        }
      }
      localagpu.setResult(0);
      paramInt = 0;
      break label106;
      label316:
      localagpu.jJ(0L);
      break label199;
      label325:
      localagpu.jI(0L);
    }
  }
  
  private aglc a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, agpv.a parama)
  {
    Object localObject2 = this.dT;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (parama.bufSha != null)
      {
        localObject1 = localObject2;
        if (parama.bufSha.length > 0) {
          localObject1 = parama.bufSha;
        }
      }
    }
    localObject1 = new agpz.a(this.c.getFilePath(), null, this.dR, this.dS, this.dU, (byte[])localObject1, parama.bufUuid, parama.bufUploadKey, parama.bUseMediaPlatform);
    localObject2 = new ArrayList();
    if (parama.By != null)
    {
      Iterator localIterator = parama.By.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str)) {
          ((List)localObject2).add(new ExcitingTransferHostInfo(str, parama.port));
        }
      }
    }
    return agpz.a(paramQQAppInterface, paramLong1, paramLong2, (agpz.a)localObject1, new agqc((List)localObject2, null, parama.bSupportHttps, parama.bHe, parama.dI));
  }
  
  private void diM()
  {
    agpu localagpu = new agpu(this.mApp);
    localagpu.setResult(33);
    localagpu.p(this.c.nSessionId);
    Object localObject = ahav.lb(this.c.fileName);
    localagpu.a(Long.valueOf(this.c.peerUin).longValue(), 0L, this.c.fileName, (String)localObject, this.c.fileSize);
    localagpu.Jw(this.cdZ);
    long l = this.mEndTime - this.mStartTime;
    if (l > 0L)
    {
      localagpu.jJ(l);
      l = this.ZX - this.ZW;
      if (l <= 0L) {
        break label184;
      }
      localagpu.jI(l);
    }
    for (;;)
    {
      localObject = new ExcitingTransferUploadResultRp();
      ((ExcitingTransferUploadResultRp)localObject).m_bIsXTFValid = true;
      ((ExcitingTransferUploadResultRp)localObject).m_nResult = 33;
      localagpu.a((ExcitingTransferUploadResultRp)localObject);
      localagpu.Oo(EC());
      localagpu.Ju(this.cea);
      localagpu.Js(false);
      return;
      localagpu.jJ(0L);
      break;
      label184:
      localagpu.jI(0L);
    }
  }
  
  protected void IQ(String paramString)
  {
    if (alF()) {
      this.cXp = EC();
    }
    super.IQ(paramString);
    if (alF()) {
      Or(0);
    }
  }
  
  protected aglc a(agib.b paramb, List<String> paramList, int paramInt, boolean paramBoolean, String paramString)
  {
    QLog.i("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.c.nSessionId) + "] get ExtfFileUploader. bIsHttps:" + paramBoolean + " strHttpsDomain:" + paramString + " strlanIp:" + paramb.bHh);
    paramList = new agpv.a();
    if ((paramb.sha != null) && (paramb.sha.length > 0))
    {
      paramList.bufSha = paramb.sha;
      dhE();
      bd(paramb.sha);
    }
    paramList.bSupportHttps = paramBoolean;
    paramList.bHe = paramString;
    paramList.bUseMediaPlatform = paramb.bUseMediaPlatform;
    if (paramb.bUseMediaPlatform) {}
    for (paramList.bufUploadKey = paramb.dJ;; paramList.bufUploadKey = paramb.key)
    {
      paramList.port = paramInt;
      paramList.dI = paramb.dI;
      paramList.bufUuid = paramb.uuid;
      paramb = a(this.mApp, this.c.nSessionId, Long.valueOf(this.c.peerUin).longValue(), paramList);
      if (paramb == null) {
        break;
      }
      ((agpz)paramb).a(this);
      return paramb;
    }
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.c.nSessionId) + "] get ExtfFileUploader fail.");
    return paramb;
  }
  
  public void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp) {}
  
  public void a(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    this.cXp = EC();
    int i;
    Object localObject;
    if (paramInt != 0)
    {
      i = agpz.hI(paramInt);
      d(this.a.fF(), i, "subsender_err", "");
      if (paramExcitingTransferUploaderRp == null) {
        break label340;
      }
      localObject = new agpw(this.mApp);
      ((agpw)localObject).p(this.c.nSessionId);
      String str = ahav.lb(this.c.fileName);
      ((agpw)localObject).setResult(paramInt);
      ((agpw)localObject).a(Long.valueOf(this.c.peerUin).longValue(), 0L, this.c.fileName, str, this.c.fileSize);
      ((agpw)localObject).a(paramExcitingTransferUploaderRp);
      ((agpw)localObject).Oo(EC());
      ((agpw)localObject).Op(ahbr.df(paramExcitingTransferUploaderRp.m_strServerIp));
      ((agpw)localObject).Ju(this.cea);
      if (paramInt != 0) {
        break label334;
      }
    }
    label334:
    for (boolean bool = true;; bool = false)
    {
      ((agpw)localObject).Js(bool);
      return;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("param_fromType", 1);
      long l = fH();
      ((Bundle)localObject).putLong("param_transferTime", l);
      ((Bundle)localObject).putInt("param_V6SelectType", this.cXp);
      ((Bundle)localObject).putInt("param_ipAddrType", Eo());
      if (this.cea) {}
      for (i = 1;; i = 0)
      {
        ((Bundle)localObject).putInt("param_ishttps", i);
        ahav.a(this.mApp, this.c.nSessionId, "actFileUpDetail", l, this.a.getUrl(), this.c.peerUin, this.c.Uuid, this.c.strFileMd5, 1L, this.a.fF(), this.c.fileSize, this.a.getRetryCount(), "", (Bundle)localObject);
        break;
      }
    }
    label340:
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.c.nSessionId) + "] onExtfSubUploaderResult datareport fail. no rp");
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.mIsStop) {
      return;
    }
    if ((this.ceJ) && (paramBoolean) && (alF()))
    {
      QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "*_* nSessionID[" + String.valueOf(this.c.nSessionId) + "] exciting tansfer fail. ftnUploader try again");
      Or(paramInt);
      Jx(true);
      this.cea = false;
      dhI();
      return;
    }
    super.a(paramBoolean, paramLong, paramInt, paramString1, paramString2);
  }
  
  protected boolean alD()
  {
    return false;
  }
  
  protected boolean alE()
  {
    return false;
  }
  
  protected boolean alF()
  {
    return !amb();
  }
  
  public boolean amb()
  {
    return this.ceI;
  }
  
  protected void b(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (this.mIsStop) {}
    do
    {
      return;
      this.ZX = System.currentTimeMillis();
      long l1 = this.ZX;
      long l2 = this.ZW;
      QLog.i("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.c.nSessionId) + "] onFullShaCalcDone costTime:" + (l1 - l2) + " bigFile:" + paramBoolean + ". useExtfUploader:" + alF());
    } while ((!paramBoolean) || (!alF()) || (this.a == null));
    this.a.bb(paramArrayOfByte);
  }
  
  protected void c(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (alF()) {
      this.cXp = EC();
    }
    super.c(paramLong, paramInt, paramString1, paramString2);
    if (alF()) {
      Or(paramInt);
    }
  }
  
  public void dgA()
  {
    if ((this.a instanceof agpz))
    {
      ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = ((agpz)this.a).b();
      if (localExcitingTransferUploadResultRp == null) {
        break label41;
      }
      this.c.fileIdCrc = localExcitingTransferUploadResultRp.m_strFileIdCrc;
    }
    for (;;)
    {
      super.dgA();
      return;
      label41:
      QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.c.nSessionId) + "] onSendSuccess: UploadResultRp is null");
    }
  }
  
  public void dgu()
  {
    super.dgu();
  }
  
  public void dgw()
  {
    if ((alF()) && (this.a != null) && ((this.a instanceof agpz))) {
      agpz localagpz = (agpz)this.a;
    }
    super.dgw();
  }
  
  protected void dhG()
  {
    super.dhG();
    this.ZW = System.currentTimeMillis();
  }
  
  protected void dhH()
  {
    super.dhH();
    if (alF())
    {
      this.c.strServerPath = "";
      this.c.bombData = null;
    }
  }
  
  public void dja() {}
  
  public void u(long paramLong1, long paramLong2, long paramLong3)
  {
    float f;
    String str;
    if (this.c != null)
    {
      if (paramLong3 <= 1048576L) {
        break label82;
      }
      f = (float)paramLong3 / 1048576.0F;
      str = new DecimalFormat("0.00").format(f);
      str = "加速上传 " + str + "MB/s";
    }
    for (;;)
    {
      this.c.mExcitingSpeed = str;
      return;
      label82:
      if (paramLong3 > 1024L)
      {
        f = (float)paramLong3 / 1024.0F;
        str = new DecimalFormat("0.00").format(f);
        str = "加速上传 " + str + "KB/s";
      }
      else
      {
        str = "加速上传 " + paramLong3 + "KB/s";
      }
    }
  }
  
  public class a
  {
    public List<String> By;
    public String bHe;
    public boolean bSupportHttps;
    public boolean bUseMediaPlatform;
    public byte[] bufSha;
    public byte[] bufUploadKey;
    public byte[] bufUuid;
    public byte[] dI;
    public int port;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpv
 * JD-Core Version:    0.7.0.1
 */