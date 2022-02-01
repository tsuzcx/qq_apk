import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class agpr
  extends agpx
{
  final String TAG = "ExcitingTransfer.ExtfGroupRP<FileAssistant>";
  long ZR = 0L;
  long ZS = 0L;
  long ZT;
  ExcitingTransferUploadResultRp b;
  int cXp = 0;
  int cYA = 0;
  int cYz = 0;
  boolean cdZ = false;
  
  public agpr(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected int EB()
  {
    return 2;
  }
  
  public void Ju(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.cYA = i;
      return;
    }
  }
  
  public void Jw(boolean paramBoolean)
  {
    this.cdZ = paramBoolean;
  }
  
  public void Oo(int paramInt)
  {
    this.cXp = paramInt;
  }
  
  public void Op(int paramInt)
  {
    this.cYz = paramInt;
  }
  
  public void a(ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    this.b = paramExcitingTransferUploadResultRp;
  }
  
  protected HashMap<String, String> getReportData()
  {
    HashMap localHashMap = super.getReportData();
    localHashMap.put("param_IsFlashFile", String.valueOf(this.cdZ));
    localHashMap.put("param_TotalCostTime", String.valueOf(this.ZT));
    localHashMap.put("param_CalcShaCostTime", String.valueOf(this.ZR));
    localHashMap.put("param_CalcHashCostTime", String.valueOf(this.ZS));
    if (this.b != null)
    {
      localHashMap.put("param_Result", String.valueOf(this.b.m_nResult));
      localHashMap.put("param_IsXTFValid", String.valueOf(this.b.m_bIsXTFValid));
      localHashMap.put("param_HttpTime", String.valueOf(this.b.m_u64HttpTime));
      localHashMap.put("param_SrvReturCode", String.valueOf(this.b.m_nSrvReturCode));
      localHashMap.put("param_TransferSpeed", String.valueOf(this.b.m_u64TransferSpeed));
      localHashMap.put("param_TransferSize", String.valueOf(this.b.m_u64TransferSize));
      localHashMap.put("param_StartSize", String.valueOf(this.b.m_u64StartSize));
      localHashMap.put("param_ServerIp", String.valueOf(this.b.m_strServerIp));
      localHashMap.put("param_ServerPort", String.valueOf(this.b.m_wServerPort));
      localHashMap.put("param_FileUrl", String.valueOf(this.b.m_strFileUrl));
      localHashMap.put("param_MaxUploadingFtnNum", String.valueOf(this.b.m_uMaxUploadingFtnNum));
      localHashMap.put("param_RetryCount", String.valueOf(this.b.m_uRetryCount));
      localHashMap.put("param_IpChangeCount", String.valueOf(this.b.m_uIpChangeCount));
      localHashMap.put("param_RollBackCount", String.valueOf(this.b.m_uRollBackCount));
      localHashMap.put("param_QueryHoleCount", String.valueOf(this.b.m_uQueryHoleCount));
      localHashMap.put("param_RangDiffCount", String.valueOf(this.b.m_uRangDiffCount));
      localHashMap.put("param_DelayTotoalCount", String.valueOf(this.b.m_uDelayTotoalCount));
      localHashMap.put("param_TcpCnnCode", String.valueOf(this.b.m_nTcpCnnCode));
      localHashMap.put("param_TcpSocketCode", String.valueOf(this.b.m_nTcpSocketCode));
      localHashMap.put("param_HttpsSupport", String.valueOf(this.b.m_wHttpsSupport));
    }
    for (;;)
    {
      localHashMap.put("param_V6SelectType", String.valueOf(this.cXp));
      localHashMap.put("param_ipAddrType", String.valueOf(this.cYz));
      localHashMap.put("param_stackType", String.valueOf(ahbr.EL()));
      localHashMap.put("param_loginType", String.valueOf(ahbr.EM()));
      localHashMap.put("param_ishttps", String.valueOf(this.cYA));
      QLog.i("ExcitingTransfer.ExtfGroupRP<FileAssistant>", 1, "Id[" + this.mSessionId + "] >>> GroupSendDataReport:act=" + s(false) + localHashMap.toString());
      return localHashMap;
      localHashMap.put("param_IsXTFValid", String.valueOf(false));
      localHashMap.put("param_HttpTime", String.valueOf(0));
      localHashMap.put("param_SrvReturCode", String.valueOf(0));
      localHashMap.put("param_TransferSpeed", String.valueOf(0));
      localHashMap.put("param_TransferSize", String.valueOf(0));
      localHashMap.put("param_StartSize", String.valueOf(0));
      localHashMap.put("param_ServerIp", "");
      localHashMap.put("param_ServerPort", String.valueOf(0));
      localHashMap.put("param_FileUrl", "");
      localHashMap.put("param_MaxUploadingFtnNum", String.valueOf(0));
      localHashMap.put("param_RetryCount", String.valueOf(0));
      localHashMap.put("param_IpChangeCount", String.valueOf(0));
      localHashMap.put("param_RollBackCount", String.valueOf(0));
      localHashMap.put("param_QueryHoleCount", String.valueOf(0));
      localHashMap.put("param_RangDiffCount", String.valueOf(0));
      localHashMap.put("param_DelayTotoalCount", String.valueOf(0));
      localHashMap.put("param_TcpCnnCode", String.valueOf(0));
      localHashMap.put("param_TcpSocketCode", String.valueOf(0));
      localHashMap.put("param_HttpsSupport", String.valueOf(0));
    }
  }
  
  public void jI(long paramLong)
  {
    this.ZR = paramLong;
  }
  
  public void jJ(long paramLong)
  {
    this.ZT = paramLong;
  }
  
  protected String s(boolean paramBoolean)
  {
    return "actGroupXTFUpload";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpr
 * JD-Core Version:    0.7.0.1
 */