import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class atwe
{
  public final String TAG = "FilePreviewDataReporter<FileAssistant>";
  public long Zk;
  public long Zl;
  public String bGx;
  public final String bIn = "actFilePreview";
  public String bIo;
  public String bIp;
  public String bIq;
  public String bIr;
  public String bIs;
  public String bIt;
  public String bIu;
  public String bIv;
  public String bIw;
  String bIx = null;
  public boolean cew;
  public long endTime;
  public long mFileSize;
  public long mInitTime;
  public int mRetryTimes;
  public long startTime;
  
  public atwe(String paramString)
  {
    this.bIx = paramString;
  }
  
  private HashMap<String, String> I()
  {
    HashMap localHashMap = new HashMap();
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.bIq = String.valueOf(9004);
      this.bIu += "_NotNetWork";
    }
    localHashMap.put("param_serverip", String.valueOf(this.bIo));
    localHashMap.put("param_uuid", String.valueOf(this.bIp));
    localHashMap.put("param_FailCode", String.valueOf(this.bIq));
    localHashMap.put("param_fsizeo", String.valueOf(this.mFileSize));
    localHashMap.put("param_url", String.valueOf(this.bIr));
    localHashMap.put("param_key", String.valueOf(this.bIs));
    localHashMap.put("param_retry", String.valueOf(this.mRetryTimes));
    localHashMap.put("param_errMsg", String.valueOf(this.bIu));
    localHashMap.put("param_fileName", String.valueOf(this.bIt));
    localHashMap.put("param_fileExt", String.valueOf(this.bIv));
    localHashMap.put("param_source", String.valueOf(this.bGx));
    localHashMap.put("param_stage", String.valueOf(this.bIw));
    localHashMap.put("param_stagetimelen", String.valueOf(this.Zk));
    localHashMap.put("param_staytimelen", String.valueOf(this.Zl));
    this.bIu = "";
    return localHashMap;
  }
  
  public void doReport()
  {
    HashMap localHashMap = I();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doReport:bSuccess[" + this.cew + "],");
      localStringBuilder.append("strReportUin[" + this.bIx + "],");
      localStringBuilder.append("startTime[" + this.startTime + "],");
      localStringBuilder.append("endTime[" + this.endTime + "],");
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str + "[" + (String)localHashMap.get(str) + "]");
      }
      QLog.i("FilePreviewDataReporter<FileAssistant>", 4, "doReport:" + localStringBuilder.toString());
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(this.bIx, "actFilePreview", this.cew, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atwe
 * JD-Core Version:    0.7.0.1
 */