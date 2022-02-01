import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class agpw
  extends agpd
{
  long Ff = 0L;
  final String TAG = "ExcitingTransfer.OfflineSenderRP<FileAssistant>";
  long ZV = 0L;
  ExcitingTransferUploaderRp b;
  int cXp = 0;
  int cYA = 0;
  int cYz = 0;
  String mFileName;
  long mFileSize = 0L;
  String mFileSuffix;
  int mResult = 0;
  long mSessionId = 0L;
  
  public agpw(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
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
  
  protected HashMap<String, String> K()
  {
    return null;
  }
  
  public void Oo(int paramInt)
  {
    this.cXp = paramInt;
  }
  
  public void Op(int paramInt)
  {
    this.cYz = paramInt;
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    this.ZV = paramLong1;
    this.Ff = paramLong2;
    this.mFileName = paramString1;
    this.mFileSuffix = paramString2;
    this.mFileSize = paramLong3;
  }
  
  public void a(ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    this.b = paramExcitingTransferUploaderRp;
  }
  
  protected boolean alQ()
  {
    return false;
  }
  
  public void diF() {}
  
  public void diG() {}
  
  protected HashMap<String, String> getReportData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_TransferType", String.valueOf(0));
    localHashMap.put("param_Platform", String.valueOf(2));
    localHashMap.put("param_AppType", String.valueOf(0));
    localHashMap.put("param_Result", String.valueOf(this.mResult));
    localHashMap.put("param_FileName", String.valueOf(this.mFileName));
    localHashMap.put("param_Suffix", String.valueOf(this.mFileSuffix));
    localHashMap.put("param_TargetUin", String.valueOf(this.ZV));
    localHashMap.put("param_GroupCode", String.valueOf(this.Ff));
    localHashMap.put("param_FileSize", String.valueOf(this.mFileSize));
    if (this.b != null)
    {
      localHashMap.put("param_Result", String.valueOf(this.b.m_nResult));
      localHashMap.put("param_IsBigData", String.valueOf(this.b.m_bIsBigData));
      localHashMap.put("param_HttpTime", String.valueOf(this.b.m_u64HttpTime));
      localHashMap.put("param_SrvReturCode", String.valueOf(this.b.m_nSrvReturCode));
      localHashMap.put("param_TransferSpeed", String.valueOf(this.b.m_u64TransferSpeed));
      localHashMap.put("param_TransferSize", String.valueOf(this.b.m_u64TransferSize));
      localHashMap.put("param_ServerIp", String.valueOf(this.b.m_strServerIp));
      localHashMap.put("param_ServerPort", String.valueOf(this.b.m_wServerPort));
      localHashMap.put("param_FileUrl", String.valueOf(this.b.m_strFileUrl));
    }
    for (;;)
    {
      localHashMap.put("param_V6SelectType", String.valueOf(this.cXp));
      localHashMap.put("param_ipAddrType", String.valueOf(this.cYz));
      localHashMap.put("param_stackType", String.valueOf(ahbr.EL()));
      localHashMap.put("param_loginType", String.valueOf(ahbr.EM()));
      localHashMap.put("param_ishttps", String.valueOf(this.cYA));
      QLog.d("ExcitingTransfer.OfflineSenderRP<FileAssistant>", 1, "Id[" + this.mSessionId + "] >>> SenderDataReport:" + localHashMap.toString());
      return localHashMap;
      localHashMap.put("param_IsBigData", String.valueOf(false));
      localHashMap.put("param_HttpTime", String.valueOf(0));
      localHashMap.put("param_SrvReturCode", String.valueOf(0));
      localHashMap.put("param_TransferSpeed", String.valueOf(0));
      localHashMap.put("param_TransferSize", String.valueOf(0));
      localHashMap.put("param_ServerIp", String.valueOf(0));
      localHashMap.put("param_ServerPort", String.valueOf(0));
      localHashMap.put("param_FileUrl", "");
    }
  }
  
  public void p(long paramLong)
  {
    this.mSessionId = paramLong;
  }
  
  protected String s(boolean paramBoolean)
  {
    return "actC2CXTFUploadSender";
  }
  
  public void setResult(int paramInt)
  {
    this.mResult = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpw
 * JD-Core Version:    0.7.0.1
 */