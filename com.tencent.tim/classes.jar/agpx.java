import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public abstract class agpx
  extends agpd
{
  protected long Ff;
  final String TAG = "ExcitingTransfer.UploadDataRP<FileAssistant>";
  protected long ZV;
  protected String mFileName;
  protected long mFileSize;
  protected String mFileSuffix;
  protected int mResult;
  protected long mSessionId;
  
  public agpx(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected abstract int EB();
  
  protected HashMap<String, String> K()
  {
    QLog.e("ExcitingTransfer.UploadDataRP<FileAssistant>", 1, "Id[" + this.mSessionId + "] getOldReportData no implement. please check call");
    return null;
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    this.ZV = paramLong1;
    this.Ff = paramLong2;
    this.mFileName = paramString1;
    this.mFileSuffix = paramString2;
    this.mFileSize = paramLong3;
  }
  
  protected boolean alQ()
  {
    return false;
  }
  
  public void diF()
  {
    QLog.e("ExcitingTransfer.UploadDataRP<FileAssistant>", 1, "Id[" + this.mSessionId + "] reportNetError no implement. please check call");
  }
  
  public void diG()
  {
    QLog.e("ExcitingTransfer.UploadDataRP<FileAssistant>", 1, "Id[" + this.mSessionId + "] reportUserCancel no implement. please check call");
  }
  
  protected HashMap<String, String> getReportData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_ReportVer", String.valueOf(1));
    localHashMap.put("param_TransferType", String.valueOf(EB()));
    localHashMap.put("param_Platform", String.valueOf(2));
    localHashMap.put("param_AppType", String.valueOf(0));
    localHashMap.put("param_Result", String.valueOf(this.mResult));
    localHashMap.put("param_FileName", String.valueOf(this.mFileName));
    localHashMap.put("param_Suffix", String.valueOf(this.mFileSuffix));
    localHashMap.put("param_TargetUin", String.valueOf(this.ZV));
    localHashMap.put("param_GroupCode", String.valueOf(this.Ff));
    localHashMap.put("param_FileSize", String.valueOf(this.mFileSize));
    return localHashMap;
  }
  
  public void p(long paramLong)
  {
    this.mSessionId = paramLong;
  }
  
  public void setResult(int paramInt)
  {
    this.mResult = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpx
 * JD-Core Version:    0.7.0.1
 */