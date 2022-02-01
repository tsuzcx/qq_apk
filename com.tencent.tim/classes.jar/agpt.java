import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class agpt
  extends agpx
{
  final String TAG = "ExcitingTransfer.ExtfGroupSenderRP<FileAssistant>";
  ExcitingTransferUploaderRp b;
  int cXp = 0;
  int cYA = 0;
  int cYz = 0;
  
  public agpt(QQAppInterface paramQQAppInterface)
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
  
  public void Oo(int paramInt)
  {
    this.cXp = paramInt;
  }
  
  public void Op(int paramInt)
  {
    this.cYz = paramInt;
  }
  
  public void a(ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    this.b = paramExcitingTransferUploaderRp;
  }
  
  protected HashMap<String, String> getReportData()
  {
    HashMap localHashMap = super.getReportData();
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
      QLog.i("ExcitingTransfer.ExtfGroupSenderRP<FileAssistant>", 1, "Id[" + this.mSessionId + "] >>> GroupSenderDataReport:act=" + s(false) + localHashMap.toString());
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
  
  protected String s(boolean paramBoolean)
  {
    return "actGroupXTFUploadSender";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpt
 * JD-Core Version:    0.7.0.1
 */