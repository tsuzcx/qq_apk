import android.content.SharedPreferences;
import android.support.annotation.RequiresApi;
import android.util.ArrayMap;
import com.tencent.cloudfile.CloudFileContext;
import com.tencent.cloudfile.CloudFileContext.Logger;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.TMCFileReportData.TMCListReportData;
import com.tencent.tim.cloudfile.TMCFileReportData.TMCRecursiveListReportData;
import com.tencent.tim.cloudfile.TMCFileReportData.TMCTransferData;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

class atgk
  extends CloudFileContext
{
  atgk(atgi paramatgi, CloudFileContext.Logger paramLogger)
  {
    super(paramLogger);
  }
  
  public void a(TMCFileReportData.TMCTransferData paramTMCTransferData)
  {
    if (!QLog.isColorLevel()) {
      return;
    }
    int i = paramTMCTransferData.transfer_type.get();
    long l2 = paramTMCTransferData.result.get();
    long l1 = paramTMCTransferData.user_return_code.get();
    long l4 = paramTMCTransferData.weiyun_task_id.get();
    long l3 = 10001L;
    String str;
    switch (i)
    {
    case 9: 
    default: 
      return;
    case 1: 
      str = "TMC_Download_Src";
      l1 = l2;
      l2 = l3;
    }
    for (;;)
    {
      audw.a locala = new audw.a();
      locala.biz = str;
      locala.LE = l1;
      if (paramTMCTransferData.file_name.has()) {
        locala.filename = paramTMCTransferData.file_name.get();
      }
      locala.sessionId = l2;
      locala.uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      locala.qi = new HashMap();
      locala.qi.put("transferType", String.valueOf(paramTMCTransferData.transfer_type.get()));
      locala.qi.put("sdkVersion", String.valueOf(paramTMCTransferData.sdk_version.get()));
      if (paramTMCTransferData.weiyun_file_id.has()) {
        locala.qi.put("weiyunFileId", paramTMCTransferData.weiyun_file_id.get());
      }
      locala.qi.put("result", String.valueOf(paramTMCTransferData.result.get()));
      locala.qi.put("subResult", String.valueOf(paramTMCTransferData.sub_reason.get()));
      locala.qi.put("httpStatusCode", String.valueOf(paramTMCTransferData.srv_code.get()));
      locala.qi.put("srvReturnCode", String.valueOf(paramTMCTransferData.user_return_code.get()));
      locala.qi.put("peerType", String.valueOf(paramTMCTransferData.peer_type.get()));
      locala.qi.put("peerUin", String.valueOf(paramTMCTransferData.peer_uin.get()));
      audw.a(locala);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("CloudFileSDKWrapper", 2, "ReportTMCTransferDataByColorLever done");
      return;
      str = "TMC_Download_Thum";
      l1 = l2;
      l2 = l3;
      continue;
      l1 = l2;
      str = "TMC_Upload_File";
      l2 = l4;
      continue;
      str = "TMC_AirCopyIn_Manual";
      l2 = l3;
      continue;
      str = "TMC_AirCopyIn_Auto";
      l2 = l3;
      continue;
      str = "TMC_AirCopyOut";
      l2 = l3;
      continue;
      str = "TMC_TimCloud_Copy";
      l2 = l3;
    }
  }
  
  public void bY(byte[] paramArrayOfByte)
  {
    TMCFileReportData.TMCTransferData localTMCTransferData = new TMCFileReportData.TMCTransferData();
    try
    {
      localTMCTransferData.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new HashMap();
      paramArrayOfByte.put("Param_sdk_version", String.valueOf(localTMCTransferData.sdk_version.get()));
      paramArrayOfByte.put("Param_qq_version", String.valueOf(localTMCTransferData.qq_version.get()));
      paramArrayOfByte.put("Param_terminal_type", String.valueOf(localTMCTransferData.terminal_type.get()));
      paramArrayOfByte.put("Param_transfer_type", String.valueOf(localTMCTransferData.transfer_type.get()));
      paramArrayOfByte.put("Param_file_name", localTMCTransferData.file_name.get());
      paramArrayOfByte.put("Param_weiyun_id", localTMCTransferData.weiyun_file_id.get());
      paramArrayOfByte.put("Param_task_id", String.valueOf(localTMCTransferData.weiyun_task_id.get()));
      paramArrayOfByte.put("Param_suffix", localTMCTransferData.suffix.get());
      paramArrayOfByte.put("Param_file_size", String.valueOf(localTMCTransferData.file_size.get()));
      paramArrayOfByte.put("Param_life_left_second", String.valueOf(localTMCTransferData.life_left_second.get()));
      paramArrayOfByte.put("Param_result", String.valueOf(localTMCTransferData.result.get()));
      paramArrayOfByte.put("Param_sub_reason", String.valueOf(localTMCTransferData.sub_reason.get()));
      paramArrayOfByte.put("Param_srv_code", String.valueOf(localTMCTransferData.srv_code.get()));
      paramArrayOfByte.put("Param_user_return_code", String.valueOf(localTMCTransferData.user_return_code.get()));
      paramArrayOfByte.put("Param_server_ip", String.valueOf(localTMCTransferData.server_ip.get()));
      paramArrayOfByte.put("Param_server_port", String.valueOf(localTMCTransferData.server_port.get()));
      paramArrayOfByte.put("Param_file_url", String.valueOf(localTMCTransferData.file_url.get()));
      paramArrayOfByte.put("Param_proxy_type", String.valueOf(localTMCTransferData.proxy_type.get()));
      paramArrayOfByte.put("Param_security_time", String.valueOf(localTMCTransferData.security_time.get()));
      paramArrayOfByte.put("Param_check_time", String.valueOf(localTMCTransferData.check_time.get()));
      paramArrayOfByte.put("Param_peer_uin", String.valueOf(localTMCTransferData.peer_uin.get()));
      paramArrayOfByte.put("Param_peer_type", String.valueOf(localTMCTransferData.peer_type.get()));
      paramArrayOfByte.put("Param_is_online", String.valueOf(localTMCTransferData.is_online.get()));
      paramArrayOfByte.put("Param_online_type", String.valueOf(localTMCTransferData.online_type.get()));
      paramArrayOfByte.put("Param_is_online_create_in_TMC", String.valueOf(localTMCTransferData.is_online_create_in_TMC.get()));
      paramArrayOfByte.put("Param_start_size", String.valueOf(localTMCTransferData.start_size.get()));
      paramArrayOfByte.put("Param_transfer_size", String.valueOf(localTMCTransferData.transfer_size.get()));
      paramArrayOfByte.put("Param_transfer_time", String.valueOf(localTMCTransferData.transfer_time.get()));
      paramArrayOfByte.put("Param_transfer_speed", String.valueOf(localTMCTransferData.transfer_speed.get()));
      paramArrayOfByte.put("Param_retry_count", String.valueOf(localTMCTransferData.retry_count.get()));
      paramArrayOfByte.put("Param_timeout_duration", String.valueOf(localTMCTransferData.timeout_duration.get()));
      paramArrayOfByte.put("Param_flash_transfer", String.valueOf(localTMCTransferData.flash_transfer.get()));
      paramArrayOfByte.put("Param_airCopy_type", String.valueOf(localTMCTransferData.airCopy_type.get()));
      paramArrayOfByte.put("Param_self_uin", String.valueOf(localTMCTransferData.self_uin.get()));
      anpc.a(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actTMCTransfer", true, 0L, 0L, paramArrayOfByte, "reserved");
      a(localTMCTransferData);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("CloudFileSDKWrapper", 2, "ReportTMCTransferData : TMCTransferData[0x7] failed", paramArrayOfByte);
    }
  }
  
  public void bZ(byte[] paramArrayOfByte)
  {
    TMCFileReportData.TMCListReportData localTMCListReportData = new TMCFileReportData.TMCListReportData();
    try
    {
      localTMCListReportData.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new HashMap();
      paramArrayOfByte.put("Param_sdk_version", String.valueOf(localTMCListReportData.sdk_version.get()));
      paramArrayOfByte.put("Param_qq_version", String.valueOf(localTMCListReportData.qq_version.get()));
      paramArrayOfByte.put("Param_terminal_type", String.valueOf(localTMCListReportData.terminal_type.get()));
      paramArrayOfByte.put("Param_report_group_id", String.valueOf(localTMCListReportData.report_group_id.get()));
      paramArrayOfByte.put("Param_cmd_type", String.valueOf(localTMCListReportData.cmd_type.get()));
      paramArrayOfByte.put("Param_cmd_error_code", String.valueOf(localTMCListReportData.cmd_error_code.get()));
      paramArrayOfByte.put("Param_upward", String.valueOf(localTMCListReportData.upward.get()));
      paramArrayOfByte.put("Param_dir_key", String.valueOf(localTMCListReportData.dir_key.get()));
      paramArrayOfByte.put("Param_version", String.valueOf(localTMCListReportData.version.get()));
      paramArrayOfByte.put("Param_fetched_item_count", String.valueOf(localTMCListReportData.fetched_item_count.get()));
      paramArrayOfByte.put("Param_time_elapsed", String.valueOf(localTMCListReportData.time_elapsed.get()));
      paramArrayOfByte.put("Param_self_uin", String.valueOf(localTMCListReportData.self_uin.get()));
      anpc.a(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actTMCLisCmd", true, 0L, 0L, paramArrayOfByte, "reserved");
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("CloudFileSDKWrapper", 2, "ReportTMCListData : TMCListReportData[0x7] failed", paramArrayOfByte);
    }
  }
  
  public void ca(byte[] paramArrayOfByte)
  {
    TMCFileReportData.TMCRecursiveListReportData localTMCRecursiveListReportData = new TMCFileReportData.TMCRecursiveListReportData();
    try
    {
      localTMCRecursiveListReportData.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new HashMap();
      paramArrayOfByte.put("Param_sdk_version", String.valueOf(localTMCRecursiveListReportData.sdk_version.get()));
      paramArrayOfByte.put("Param_qq_version", String.valueOf(localTMCRecursiveListReportData.qq_version.get()));
      paramArrayOfByte.put("Param_terminal_type", String.valueOf(localTMCRecursiveListReportData.terminal_type.get()));
      paramArrayOfByte.put("Param_report_group_id", String.valueOf(localTMCRecursiveListReportData.report_group_id.get()));
      paramArrayOfByte.put("Param_recursive_fetch_type", String.valueOf(localTMCRecursiveListReportData.recursive_fetch_type.get()));
      paramArrayOfByte.put("Param_total_cmd_count", String.valueOf(localTMCRecursiveListReportData.total_cmd_count.get()));
      paramArrayOfByte.put("Param_last_cmd_error", String.valueOf(localTMCRecursiveListReportData.last_cmd_error.get()));
      paramArrayOfByte.put("Param_fetched_item_count", String.valueOf(localTMCRecursiveListReportData.fetched_item_count.get()));
      paramArrayOfByte.put("Param_time_out", String.valueOf(localTMCRecursiveListReportData.time_out.get()));
      paramArrayOfByte.put("Param_time_elapsed", String.valueOf(localTMCRecursiveListReportData.time_elapsed.get()));
      paramArrayOfByte.put("Param_self_uin", String.valueOf(localTMCRecursiveListReportData.self_uin.get()));
      anpc.a(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actTMCRecursiveListCmd", true, 0L, 0L, paramArrayOfByte, "reserved");
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("CloudFileSDKWrapper", 2, "ReportTMCRecursiveListData : TMCRecursiveListReportData[0x7] failed", paramArrayOfByte);
    }
  }
  
  public String getCachePath()
  {
    return BaseApplicationImpl.getApplication().getFilesDir().getParent() + "/databases/";
  }
  
  @RequiresApi(api=19)
  public Map<String, String> getCgiCookies()
  {
    String str1 = UUID.randomUUID().toString().replace("-", "");
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str2 = String.valueOf(localAppRuntime.getLongAccountUin());
    boolean bool = localAppRuntime.getApplication().getSharedPreferences("key_tencent_docs_env", 0).getBoolean("key_tencent_docs_env_enable", true);
    String str3 = ((TicketManager)localAppRuntime.getManager(2)).getPskey(str2, "docs.qq.com");
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put("TOK", str1);
    localArrayMap.put("p_uin", str2);
    localArrayMap.put("p_skey", str3);
    if (bool)
    {
      str1 = localAppRuntime.getApplication().getSharedPreferences("key_tencent_docs_env", 0).getString("key_tencent_docs_env_id", "409");
      localArrayMap.put("dev_rtx", "tencent_pdm");
      if (str1 == null) {
        localArrayMap.put("dev_route_id", "");
      }
    }
    else
    {
      return localArrayMap;
    }
    localArrayMap.put("dev_route_id", str1);
    return localArrayMap;
  }
  
  public String getDBKeyPath()
  {
    return BaseApplicationImpl.getApplication().getFilesDir().getPath();
  }
  
  public byte[] getDataKey()
  {
    return new String(SecurityUtile.getKey()).getBytes();
  }
  
  public String getDownloadPath()
  {
    return acbn.bmg;
  }
  
  public String getDownloadTempPath()
  {
    return acbn.bmi;
  }
  
  public long getSelfUin()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileSDKWrapper", 2, "getSelfUin:" + BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    }
    return BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
  }
  
  public long getServerCalTime()
  {
    return NetConnInfoCenter.getServerTimeMillis();
  }
  
  public int getTIMVersion()
  {
    return AppSetting.getAppId();
  }
  
  public String getThumbPath()
  {
    return acbn.bmh;
  }
  
  public String getUploadTempPath()
  {
    return acbn.bmi;
  }
  
  public void reportTransferData(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt == 1) {
      bY(paramArrayOfByte);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        bZ(paramArrayOfByte);
        return;
      }
    } while (paramInt != 3);
    ca(paramArrayOfByte);
  }
  
  public void sendRequest(byte[] paramArrayOfByte, long paramLong)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      ((ateh)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(180)).l(paramArrayOfByte, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgk
 * JD-Core Version:    0.7.0.1
 */