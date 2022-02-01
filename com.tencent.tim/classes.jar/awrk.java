import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.uploader.UploadRequest;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class awrk
{
  public static void a(String paramString1, String paramString2, awqb.a parama, boolean paramBoolean, long paramLong)
  {
    try
    {
      awrk.a locala = new awrk.a();
      locala.errorCode = parama.errorCode;
      locala.errorMsg = parama.errorMsg;
      awqb localawqb2 = parama.a;
      awqb localawqb1 = localawqb2;
      if (localawqb2 == null) {
        localawqb1 = awqd.a().a(paramLong);
      }
      if (localawqb1 != null)
      {
        locala.fileName = localawqb1.b().fileName;
        locala.fileSize = localawqb1.b().fileSize;
        locala.fileId = localawqb1.b().fileId;
        locala.sha = localawqb1.b().sha;
        locala.localPath = parama.filePath;
        parama = localawqb1.b();
        if (parama != null) {
          locala.bLs = parama.bZ;
        }
      }
      a(paramString1, paramString2, locala, paramBoolean, true);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WyReportUtils", 2, "report download exception =" + paramString1.getMessage(), paramString1);
    }
  }
  
  private static void a(String paramString1, String paramString2, awrk.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(parama.errorCode));
    localHashMap.put("serverip", parama.serverIp);
    localHashMap.put("param_errMsg", parama.errorMsg);
    localHashMap.put("param_errorDesc", String.valueOf(parama.errorMsg));
    localHashMap.put("param_Server", parama.serverIp);
    localHashMap.put("param_ftnIP", parama.serverIp);
    localHashMap.put("param_innerServerIp", parama.cSl);
    localHashMap.put("param_serverPort", String.valueOf(parama.serverPort));
    localHashMap.put("param_url", parama.bLs);
    localHashMap.put("param_MD5", parama.sha);
    Object localObject;
    if (parama.drg) {
      localObject = "0";
    }
    for (;;)
    {
      localHashMap.put("param_isDowngrade", localObject);
      localHashMap.put("param_fsizeo", String.valueOf(parama.fileSize));
      anpc.a(BaseApplication.getContext()).collectPerformance(paramString1, paramString2, paramBoolean1, 0L, 0L, localHashMap, null);
      try
      {
        paramString2 = new JSONArray();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("t_server_ip", parama.serverIp);
        ((JSONObject)localObject).put("t_server_port", parama.serverPort);
        ((JSONObject)localObject).put("t_url", parama.bLs);
        ((JSONObject)localObject).put("t_file_name", parama.fileName);
        ((JSONObject)localObject).put("t_file_id", parama.fileId);
        ((JSONObject)localObject).put("t_file_path", parama.localPath);
        ((JSONObject)localObject).put("t_file_size", parama.fileSize);
        ((JSONObject)localObject).put("t_file_sha", parama.sha);
        ((JSONObject)localObject).put("t_err_code", parama.errorCode);
        if (paramString1 != null)
        {
          if (paramString1.startsWith("weiyun_")) {
            l = Long.parseLong(paramString1.substring(7));
          }
        }
        else
        {
          label343:
          ((JSONObject)localObject).put("t_uin", l);
          ((JSONObject)localObject).put("t_terminal", "Android_mobileQQ");
          if (!paramBoolean2) {
            break label468;
          }
        }
        label468:
        for (int i = 1;; i = 2)
        {
          ((JSONObject)localObject).put("t_action", i);
          ((JSONObject)localObject).put("t_app_ver", aewh.getVersionName(BaseApplication.getContext()));
          if (!paramBoolean1) {
            ((JSONObject)localObject).put("t_err_msg", parama.errorMsg);
          }
          paramString2.put(localObject);
          paramString1 = new JSONObject();
          paramString1.put("count", 1);
          paramString1.put("data", paramString2);
          awpn.s("https://user.weiyun.com/ftn_report/weiyun?op=all", paramString1);
          return;
          localObject = "1";
          break;
          l = Long.parseLong(paramString1);
          break label343;
        }
        return;
      }
      catch (Exception paramString1) {}
    }
  }
  
  public static void a(String paramString1, String paramString2, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean, long paramLong)
  {
    boolean bool = false;
    try
    {
      awrk.a locala = new awrk.a();
      locala.errorCode = paramStatusInfo.errorCode;
      locala.errorMsg = paramStatusInfo.errorMsg;
      UploadJobContext localUploadJobContext2 = paramStatusInfo.jobContext;
      UploadJobContext localUploadJobContext1 = localUploadJobContext2;
      if (localUploadJobContext2 == null) {
        localUploadJobContext1 = UploadManager.getInstance().getJobContext(paramLong);
      }
      if (localUploadJobContext1 != null)
      {
        locala.fileName = localUploadJobContext1.file().fileName;
        locala.fileSize = localUploadJobContext1.file().fileSize;
        locala.fileId = paramStatusInfo.fileId;
        locala.sha = localUploadJobContext1.file().sha;
        paramStatusInfo = localUploadJobContext1.uploadRequest();
        if (paramStatusInfo != null)
        {
          locala.serverIp = paramStatusInfo.serverIp();
          locala.serverPort = paramStatusInfo.serverPort();
          locala.bLs = paramStatusInfo.serverName();
        }
      }
      if (!WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {
        bool = true;
      }
      locala.drg = bool;
      a(paramString1, paramString2, locala, paramBoolean, false);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WyReportUtils", 2, "report upload exception =" + paramString1.getMessage(), paramString1);
    }
  }
  
  public static class a
  {
    public String bLs;
    public String cSl;
    public boolean drg;
    public int errorCode;
    public String errorMsg;
    public String fileId;
    public String fileName;
    public long fileSize;
    public String localPath;
    public String serverIp;
    public int serverPort;
    public String sha;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awrk
 * JD-Core Version:    0.7.0.1
 */