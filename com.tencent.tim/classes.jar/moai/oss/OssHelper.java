package moai.oss;

import androidx.annotation.NonNull;
import moai.oss.annotation.OssReport;

public class OssHelper
{
  private static OssClient sClient;
  
  @OssReport(checkSum="73fe324", enable=true, fixed=true, logId=80000363, taskId="active_vid")
  public static void activeVid(Object... paramVarArgs)
  {
    report(true, 80000363, "active_vid", "", ";", true, ReportType.IMMEDIATELY_UPLOAD, "73fe324", paramVarArgs);
  }
  
  @OssReport(checkSum="0a062a0", enable=true, fixed=true, logId=80000363, taskId="append_after_sync_sent")
  public static void appendAfterSyncSent(Object... paramVarArgs)
  {
    report(true, 80000363, "append_after_sync_sent", "", ";", true, ReportType.NORMAL, "0a062a0", paramVarArgs);
  }
  
  @OssReport(checkSum="f101903", enable=true, fixed=true, logId=80000363, taskId="Attach_Decompress_Fail")
  public static void attachDecompressFail(Object... paramVarArgs)
  {
    report(true, 80000363, "Attach_Decompress_Fail", "", ",", true, ReportType.NORMAL, "f101903", paramVarArgs);
  }
  
  @OssReport(checkSum="3a703a7", enable=true, fixed=true, logId=80000363, taskId="Attach_Decompress_Suc")
  public static void attachDecompressSuc(Object... paramVarArgs)
  {
    report(true, 80000363, "Attach_Decompress_Suc", "", ",", true, ReportType.NORMAL, "3a703a7", paramVarArgs);
  }
  
  @OssReport(checkSum="ef91c75", enable=true, fixed=true, logId=80000363, taskId="Attach_Download_Fail")
  public static void attachDownloadFail(Object... paramVarArgs)
  {
    report(true, 80000363, "Attach_Download_Fail", "", ",", true, ReportType.NORMAL, "ef91c75", paramVarArgs);
  }
  
  @OssReport(checkSum="3fe2ee3", enable=true, fixed=true, logId=80000363, taskId="Attach_Download_Suc")
  public static void attachDownloadSuc(Object... paramVarArgs)
  {
    report(true, 80000363, "Attach_Download_Suc", "", ",", true, ReportType.NORMAL, "3fe2ee3", paramVarArgs);
  }
  
  @OssReport(checkSum="bd31ca6", enable=true, fixed=true, logId=80000363, taskId="Attach_Move_Save_As_Fail")
  public static void attachMoveSaveAsFail(Object... paramVarArgs)
  {
    report(true, 80000363, "Attach_Move_Save_As_Fail", "", ",", true, ReportType.NORMAL, "bd31ca6", paramVarArgs);
  }
  
  @OssReport(checkSum="0ee79d2", enable=true, fixed=true, logId=80000363, taskId="Attach_Open_Fail")
  public static void attachOpenFail(Object... paramVarArgs)
  {
    report(true, 80000363, "Attach_Open_Fail", "", ",", true, ReportType.NORMAL, "0ee79d2", paramVarArgs);
  }
  
  @OssReport(checkSum="930b9b4", enable=true, fixed=true, logId=80000363, taskId="Attach_Open_Suc")
  public static void attachOpenSuc(Object... paramVarArgs)
  {
    report(true, 80000363, "Attach_Open_Suc", "", ",", true, ReportType.NORMAL, "930b9b4", paramVarArgs);
  }
  
  @OssReport(checkSum="c5f295e", enable=true, fixed=true, logId=80000363, taskId="Attach_Write_Save_As_Fail")
  public static void attachWriteSaveAsFail(Object... paramVarArgs)
  {
    report(true, 80000363, "Attach_Write_Save_As_Fail", "", ",", true, ReportType.NORMAL, "c5f295e", paramVarArgs);
  }
  
  @OssReport(checkSum="376f37a", enable=true, fixed=true, logId=80000363, taskId="auto_correct_email")
  public static void autoCorrectEmail(Object... paramVarArgs)
  {
    report(true, 80000363, "auto_correct_email", "", ";", true, ReportType.NORMAL, "376f37a", paramVarArgs);
  }
  
  @OssReport(checkSum="d3dedb9", enable=true, fixed=true, logId=80000363, taskId="auto_query_domain_config")
  public static void autoQueryDomainConfig(Object... paramVarArgs)
  {
    report(true, 80000363, "auto_query_domain_config", "", ";", true, ReportType.NORMAL, "d3dedb9", paramVarArgs);
  }
  
  @OssReport(checkSum="8be077b", enable=true, fixed=true, logId=80000363, taskId="BigAttach_Decompress_Fail")
  public static void bigattachDecompressFail(Object... paramVarArgs)
  {
    report(true, 80000363, "BigAttach_Decompress_Fail", "", ",", true, ReportType.NORMAL, "8be077b", paramVarArgs);
  }
  
  @OssReport(checkSum="33beefc", enable=true, fixed=true, logId=80000363, taskId="BigAttach_Decompress_Suc")
  public static void bigattachDecompressSuc(Object... paramVarArgs)
  {
    report(true, 80000363, "BigAttach_Decompress_Suc", "", ",", true, ReportType.NORMAL, "33beefc", paramVarArgs);
  }
  
  @OssReport(checkSum="112d745", enable=true, fixed=true, logId=80000363, taskId="BigAttach_Download_Fail")
  public static void bigattachDownloadFail(Object... paramVarArgs)
  {
    report(true, 80000363, "BigAttach_Download_Fail", "", ",", true, ReportType.NORMAL, "112d745", paramVarArgs);
  }
  
  @OssReport(checkSum="2de828e", enable=true, fixed=true, logId=80000363, taskId="BigAttach_Download_Suc")
  public static void bigattachDownloadSuc(Object... paramVarArgs)
  {
    report(true, 80000363, "BigAttach_Download_Suc", "", ",", true, ReportType.NORMAL, "2de828e", paramVarArgs);
  }
  
  @OssReport(checkSum="deb5d83", enable=true, fixed=true, logId=80000363, taskId="BigAttach_Open_Fail")
  public static void bigattachOpenFail(Object... paramVarArgs)
  {
    report(true, 80000363, "BigAttach_Open_Fail", "", ",", true, ReportType.NORMAL, "deb5d83", paramVarArgs);
  }
  
  @OssReport(checkSum="24a4ca8", enable=true, fixed=true, logId=80000363, taskId="BigAttach_Open_Suc")
  public static void bigattachOpenSuc(Object... paramVarArgs)
  {
    report(true, 80000363, "BigAttach_Open_Suc", "", ",", true, ReportType.NORMAL, "24a4ca8", paramVarArgs);
  }
  
  @OssReport(checkSum="addbaad", enable=true, fixed=true, logId=80000363, taskId="cgi_sendmail_info")
  public static void cgiSendmailInfo(Object... paramVarArgs)
  {
    report(true, 80000363, "cgi_sendmail_info", "", ";", true, ReportType.NORMAL, "addbaad", paramVarArgs);
  }
  
  @OssReport(checkSum="2fc7f14", enable=true, fixed=true, logId=80000363, taskId="crash")
  public static void crash(Object... paramVarArgs)
  {
    report(true, 80000363, "crash", "", ";", true, ReportType.IMMEDIATELY_FILED, "2fc7f14", paramVarArgs);
  }
  
  @OssReport(checkSum="7ab8666", enable=true, fixed=true, logId=80000363, taskId="db_on_corruption")
  public static void dbOnCorruption(Object... paramVarArgs)
  {
    report(true, 80000363, "db_on_corruption", "", ";", true, ReportType.IMMEDIATELY_FILED, "7ab8666", paramVarArgs);
  }
  
  @OssReport(checkSum="b3da73b", enable=true, fixed=true, logId=80000363, taskId="db_open_failed")
  public static void dbOpenFailed(Object... paramVarArgs)
  {
    report(true, 80000363, "db_open_failed", "", ";", true, ReportType.IMMEDIATELY_FILED, "b3da73b", paramVarArgs);
  }
  
  @OssReport(checkSum="d159b8a", enable=true, fixed=true, logId=80000363, taskId="enable_upgrade_fts")
  public static void enableUpgradeFts(Object... paramVarArgs)
  {
    report(true, 80000363, "enable_upgrade_fts", "", ";", true, ReportType.IMMEDIATELY_UPLOAD, "d159b8a", paramVarArgs);
  }
  
  @OssReport(checkSum="303d9eb", enable=true, fixed=true, logId=80000363, taskId="ERROR_REPORT")
  public static void errorReport(Object... paramVarArgs)
  {
    report(true, 80000363, "", "", ",", false, ReportType.IMMEDIATELY_UPLOAD, "303d9eb", paramVarArgs);
  }
  
  @OssReport(checkSum="8aaa54b", enable=true, fixed=true, logId=80000363, taskId="FtnAttach_Decompress_Fail")
  public static void ftnattachDecompressFail(Object... paramVarArgs)
  {
    report(true, 80000363, "FtnAttach_Decompress_Fail", "", ",", true, ReportType.NORMAL, "8aaa54b", paramVarArgs);
  }
  
  @OssReport(checkSum="1c8a79d", enable=true, fixed=true, logId=80000363, taskId="FtnAttach_Decompress_Suc")
  public static void ftnattachDecompressSuc(Object... paramVarArgs)
  {
    report(true, 80000363, "FtnAttach_Decompress_Suc", "", ",", true, ReportType.NORMAL, "1c8a79d", paramVarArgs);
  }
  
  @OssReport(checkSum="70ec375", enable=true, fixed=true, logId=80000363, taskId="FtnAttach_Download_Fail")
  public static void ftnattachDownloadFail(Object... paramVarArgs)
  {
    report(true, 80000363, "FtnAttach_Download_Fail", "", ",", true, ReportType.NORMAL, "70ec375", paramVarArgs);
  }
  
  @OssReport(checkSum="4889cc1", enable=true, fixed=true, logId=80000363, taskId="FtnAttach_Download_Suc")
  public static void ftnattachDownloadSuc(Object... paramVarArgs)
  {
    report(true, 80000363, "FtnAttach_Download_Suc", "", ",", true, ReportType.NORMAL, "4889cc1", paramVarArgs);
  }
  
  @OssReport(checkSum="a6026f0", enable=true, fixed=true, logId=80000363, taskId="FtnAttach_Open_Fail")
  public static void ftnattachOpenFail(Object... paramVarArgs)
  {
    report(true, 80000363, "FtnAttach_Open_Fail", "", ",", true, ReportType.NORMAL, "a6026f0", paramVarArgs);
  }
  
  @OssReport(checkSum="18b6477", enable=true, fixed=true, logId=80000363, taskId="FtnAttach_Open_Suc")
  public static void ftnattachOpenSuc(Object... paramVarArgs)
  {
    report(true, 80000363, "FtnAttach_Open_Suc", "", ",", true, ReportType.NORMAL, "18b6477", paramVarArgs);
  }
  
  @OssReport(checkSum="5732830", enable=true, fixed=true, logId=80000363, taskId="guide_click")
  public static void guideClick(Object... paramVarArgs)
  {
    report(true, 80000363, "guide_click", "", ";", true, ReportType.NORMAL, "5732830", paramVarArgs);
  }
  
  @OssReport(checkSum="acf6c03", enable=true, fixed=true, logId=80000363, taskId="guide_go_setting_failed")
  public static void guideGoSettingFailed(Object... paramVarArgs)
  {
    report(true, 80000363, "guide_go_setting_failed", "", ";", true, ReportType.NORMAL, "acf6c03", paramVarArgs);
  }
  
  @OssReport(checkSum="8c80e5d", enable=true, fixed=true, logId=80000363, taskId="handle_data_fail")
  public static void handleDataFail(Object... paramVarArgs)
  {
    report(true, 80000363, "handle_data_fail", "", ";", true, ReportType.NORMAL, "8c80e5d", paramVarArgs);
  }
  
  @OssReport(checkSum="be66ce6", enable=true, fixed=true, logId=80000363, taskId="heartbeat_detect")
  public static void heartbeatDetect(Object... paramVarArgs)
  {
    report(true, 80000363, "heartbeat_detect", "", ";", true, ReportType.NORMAL, "be66ce6", paramVarArgs);
  }
  
  @OssReport(checkSum="74ce1ea", enable=true, fixed=true, logId=80000363, taskId="hotfix_detail_log")
  public static void hotfixDetailLog(Object... paramVarArgs)
  {
    report(true, 80000363, "hotfix_detail_log", "", ";", true, ReportType.NORMAL, "74ce1ea", paramVarArgs);
  }
  
  @OssReport(checkSum="15dc6da", enable=true, fixed=true, logId=80000363, taskId="HTTP_DNS")
  public static void httpDns(Object... paramVarArgs)
  {
    report(true, 80000363, "", "", ",", false, ReportType.IMMEDIATELY_UPLOAD, "15dc6da", paramVarArgs);
  }
  
  @OssReport(checkSum="47c6ac1", enable=true, fixed=false, logId=80000363, taskId="hw_push_abtest_")
  public static void hwPushAbtest(String paramString, Object... paramVarArgs)
  {
    report(true, 80000363, "hw_push_abtest_", paramString, ";", true, ReportType.IMMEDIATELY_UPLOAD, "47c6ac1", paramVarArgs);
  }
  
  @OssReport(checkSum="9d624e6", enable=true, fixed=false, logId=80000363, taskId="hw_push_delay_")
  public static void hwPushDelay(String paramString, Object... paramVarArgs)
  {
    report(true, 80000363, "hw_push_delay_", paramString, ";", true, ReportType.IMMEDIATELY_UPLOAD, "9d624e6", paramVarArgs);
  }
  
  @OssReport(checkSum="c694f52", enable=true, fixed=false, logId=80000363, taskId="hw_push_wake_up_")
  public static void hwPushWakeUp(String paramString, Object... paramVarArgs)
  {
    report(true, 80000363, "hw_push_wake_up_", paramString, ";", true, ReportType.IMMEDIATELY_UPLOAD, "c694f52", paramVarArgs);
  }
  
  @OssReport(checkSum="e09fc38", enable=true, fixed=true, logId=80000363, taskId="idle_detect_new")
  public static void idleDetectNew(Object... paramVarArgs)
  {
    report(true, 80000363, "idle_detect_new", "", ";", true, ReportType.NORMAL, "e09fc38", paramVarArgs);
  }
  
  @OssReport(checkSum="7e18574", enable=true, fixed=true, logId=80000363, taskId="idle_heartbeat_detect")
  public static void idleHeartbeatDetect(Object... paramVarArgs)
  {
    report(true, 80000363, "idle_heartbeat_detect", "", ";", true, ReportType.NORMAL, "7e18574", paramVarArgs);
  }
  
  @OssReport(checkSum="340f06c", enable=true, fixed=true, logId=80000363, taskId="idle_support")
  public static void idleSupport(Object... paramVarArgs)
  {
    report(true, 80000363, "idle_support", "", ";", true, ReportType.NORMAL, "340f06c", paramVarArgs);
  }
  
  @OssReport(checkSum="0471f0a", enable=true, fixed=true, logId=80000363, taskId="imap_attach_name_null")
  public static void imapAttachNameNull(Object... paramVarArgs)
  {
    report(true, 80000363, "imap_attach_name_null", "", ";", true, ReportType.NORMAL, "0471f0a", paramVarArgs);
  }
  
  @NonNull
  public static String joinParams(String paramString, Object... paramVarArgs)
  {
    int j = 0;
    if (paramVarArgs != null) {}
    for (int i = paramVarArgs.length; i == 0; i = 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(i * 16);
    while (j < i)
    {
      if (j > 0) {
        localStringBuilder.append(paramString);
      }
      localStringBuilder.append(paramVarArgs[j]);
      j += 1;
    }
    return localStringBuilder.toString();
  }
  
  @OssReport(checkSum="1af18a4", enable=true, fixed=true, logId=80000363, taskId="mail_login")
  public static void mailLogin(Object... paramVarArgs)
  {
    report(true, 80000363, "mail_login", "", ";", true, ReportType.NORMAL, "1af18a4", paramVarArgs);
  }
  
  @OssReport(checkSum="8904e67", enable=true, fixed=true, logId=80000363, taskId="mail_login_config")
  public static void mailLoginConfig(Object... paramVarArgs)
  {
    report(true, 80000363, "mail_login_config", "", ",", true, ReportType.NORMAL, "8904e67", paramVarArgs);
  }
  
  @OssReport(checkSum="08c29f3", enable=true, fixed=true, logId=80000363, taskId="mail_query_provider")
  public static void mailQueryProvider(Object... paramVarArgs)
  {
    report(true, 80000363, "mail_query_provider", "", ";", true, ReportType.NORMAL, "08c29f3", paramVarArgs);
  }
  
  @OssReport(checkSum="bf2de2a", enable=true, fixed=true, logId=80000363, taskId="match_subject_not_time")
  public static void matchSubjectNotTime(Object... paramVarArgs)
  {
    report(true, 80000363, "match_subject_not_time", "", ";", true, ReportType.NORMAL, "bf2de2a", paramVarArgs);
  }
  
  @OssReport(checkSum="89a575d", enable=true, fixed=false, logId=80000363, taskId="mi_push_abtest_")
  public static void miPushAbtest(String paramString, Object... paramVarArgs)
  {
    report(true, 80000363, "mi_push_abtest_", paramString, ";", true, ReportType.IMMEDIATELY_UPLOAD, "89a575d", paramVarArgs);
  }
  
  @OssReport(checkSum="e3d0836", enable=true, fixed=false, logId=80000363, taskId="mi_push_delay_")
  public static void miPushDelay(String paramString, Object... paramVarArgs)
  {
    report(true, 80000363, "mi_push_delay_", paramString, ";", true, ReportType.IMMEDIATELY_UPLOAD, "e3d0836", paramVarArgs);
  }
  
  @OssReport(checkSum="f703be9", enable=true, fixed=false, logId=80000363, taskId="mi_push_wake_up_")
  public static void miPushWakeUp(String paramString, Object... paramVarArgs)
  {
    report(true, 80000363, "mi_push_wake_up_", paramString, ";", true, ReportType.IMMEDIATELY_UPLOAD, "f703be9", paramVarArgs);
  }
  
  @OssReport(checkSum="f54efb2", enable=true, fixed=true, logId=80000363, taskId="NATIVE_ADS_DETAIL")
  public static void nativeAdsDetail(Object... paramVarArgs)
  {
    report(true, 80000363, "", "", ";", true, ReportType.IMMEDIATELY_UPLOAD, "f54efb2", paramVarArgs);
  }
  
  @OssReport(checkSum="f76f2c6", enable=true, fixed=true, logId=80000363, taskId="no_append_in_domain")
  public static void noAppendInDomain(Object... paramVarArgs)
  {
    report(true, 80000363, "no_append_in_domain", "", ";", true, ReportType.NORMAL, "f76f2c6", paramVarArgs);
  }
  
  @OssReport(checkSum="8ae64c7", enable=true, fixed=true, logId=80000363, taskId="no_sent_box")
  public static void noSentBox(Object... paramVarArgs)
  {
    report(true, 80000363, "no_sent_box", "", ";", true, ReportType.NORMAL, "8ae64c7", paramVarArgs);
  }
  
  @OssReport(checkSum="5921146", enable=true, fixed=false, logId=80000363, taskId="notify_sub_abtest_")
  public static void notifySubAbtest(String paramString, Object... paramVarArgs)
  {
    report(true, 80000363, "notify_sub_abtest_", paramString, ";", true, ReportType.IMMEDIATELY_UPLOAD, "5921146", paramVarArgs);
  }
  
  @OssReport(checkSum="b785518", enable=true, fixed=false, logId=80000363, taskId="notify_sub_receive_")
  public static void notifySubReceive(String paramString, Object... paramVarArgs)
  {
    report(true, 80000363, "notify_sub_receive_", paramString, ";", true, ReportType.IMMEDIATELY_UPLOAD, "b785518", paramVarArgs);
  }
  
  @OssReport(checkSum="b9544d2", enable=true, fixed=false, logId=80000363, taskId="notify_sub_wake_up_")
  public static void notifySubWakeUp(String paramString, Object... paramVarArgs)
  {
    report(true, 80000363, "notify_sub_wake_up_", paramString, ";", true, ReportType.IMMEDIATELY_UPLOAD, "b9544d2", paramVarArgs);
  }
  
  @OssReport(checkSum="e90ee60", enable=true, fixed=true, logId=80000363, taskId="package_size")
  public static void packageSize(Object... paramVarArgs)
  {
    report(true, 80000363, "package_size", "", ";", true, ReportType.NORMAL, "e90ee60", paramVarArgs);
  }
  
  @OssReport(checkSum="aaf8a07", enable=true, fixed=true, logId=80000363, taskId="parse_bodystructure_fail")
  public static void parseBodystructureFail(Object... paramVarArgs)
  {
    report(true, 80000363, "parse_bodystructure_fail", "", ";", true, ReportType.NORMAL, "aaf8a07", paramVarArgs);
  }
  
  @OssReport(checkSum="c29fdbd", enable=true, fixed=true, logId=80000363, taskId="previous_install")
  public static void previousInstall(Object... paramVarArgs)
  {
    report(true, 80000363, "previous_install", "", ";", true, ReportType.IMMEDIATELY_UPLOAD, "c29fdbd", paramVarArgs);
  }
  
  @OssReport(checkSum="c9269f7", enable=true, fixed=true, logId=80000363, taskId="Protocol_Attach_Download_Fail")
  public static void protocolAttachDownloadFail(Object... paramVarArgs)
  {
    report(true, 80000363, "Protocol_Attach_Download_Fail", "", ",", true, ReportType.NORMAL, "c9269f7", paramVarArgs);
  }
  
  @OssReport(checkSum="457081c", enable=true, fixed=true, logId=80000363, taskId="Protocol_Attach_Download_Suc")
  public static void protocolAttachDownloadSuc(Object... paramVarArgs)
  {
    report(true, 80000363, "Protocol_Attach_Download_Suc", "", ",", true, ReportType.NORMAL, "457081c", paramVarArgs);
  }
  
  @OssReport(checkSum="a77248f", enable=true, fixed=true, logId=80000363, taskId="protocol_mail")
  public static void protocolMail(Object... paramVarArgs)
  {
    report(true, 80000363, "protocol_mail", "", ";", true, ReportType.NORMAL, "a77248f", paramVarArgs);
  }
  
  @OssReport(checkSum="8e2cfef", enable=true, fixed=true, logId=80000363, taskId="protocol_mail_login")
  public static void protocolMailLogin(Object... paramVarArgs)
  {
    report(true, 80000363, "protocol_mail_login", "", ";", true, ReportType.IMMEDIATELY_UPLOAD, "8e2cfef", paramVarArgs);
  }
  
  @OssReport(checkSum="e6431f3", enable=true, fixed=true, logId=80000363, taskId="protocol_osslog")
  public static void protocolOsslog(Object... paramVarArgs)
  {
    report(true, 80000363, "protocol_osslog", "", ";", true, ReportType.NORMAL, "e6431f3", paramVarArgs);
  }
  
  @OssReport(checkSum="31bc857", enable=true, fixed=true, logId=80000363, taskId="push_config")
  public static void pushConfig(Object... paramVarArgs)
  {
    report(true, 80000363, "push_config", "", ";", true, ReportType.NORMAL, "31bc857", paramVarArgs);
  }
  
  @OssReport(checkSum="f26a6e2", enable=true, fixed=true, logId=80000363, taskId="reach_test_push")
  public static void reachTestPush(Object... paramVarArgs)
  {
    report(true, 80000363, "reach_test_push", "", ";", true, ReportType.IMMEDIATELY_UPLOAD, "f26a6e2", paramVarArgs);
  }
  
  @OssReport(checkSum="1a2391e", enable=true, fixed=true, logId=80000363, taskId="REAL_TIME_REPORT")
  public static void realTimeReport(Object... paramVarArgs)
  {
    report(true, 80000363, "", "", ",", false, ReportType.IMMEDIATELY_UPLOAD, "1a2391e", paramVarArgs);
  }
  
  @OssReport(checkSum="db6ba9b", enable=true, fixed=true, logId=80000363, taskId="receive_mail")
  public static void receiveMail(Object... paramVarArgs)
  {
    report(true, 80000363, "receive_mail", "", ";", true, ReportType.NORMAL, "db6ba9b", paramVarArgs);
  }
  
  public static void report(boolean paramBoolean1, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, ReportType paramReportType, String paramString4, Object... paramVarArgs)
  {
    OssClient localOssClient = sClient;
    if (localOssClient == null) {
      return;
    }
    if (!paramBoolean1)
    {
      localOssClient.log("Disable oss report! logId: " + paramInt + ", taskId: " + paramString1);
      return;
    }
    int i;
    int j;
    if (paramVarArgs != null)
    {
      i = paramVarArgs.length;
      paramString1 = new StringBuilder((i + 1) * 16).append(paramString1).append(paramString2);
      if (i <= 0) {
        break label232;
      }
      if (paramString1.length() > 0) {
        paramString1.append(",");
      }
      j = 0;
      label108:
      if (j >= i) {
        break label232;
      }
      if (j > 0) {
        paramString1.append(paramString3);
      }
      paramString2 = String.valueOf(paramVarArgs[j]).replace("\r\n", "|").replace("\r", "|").replace("\n", "|");
      if ((!paramBoolean2) || (!"true".equalsIgnoreCase(paramString2))) {
        break label199;
      }
      paramString1.append(1);
    }
    for (;;)
    {
      j += 1;
      break label108;
      i = 0;
      break;
      label199:
      if ((paramBoolean2) && ("false".equalsIgnoreCase(paramString2))) {
        paramString1.append(0);
      } else {
        paramString1.append(paramString2);
      }
    }
    label232:
    localOssClient.reportOss(paramInt, paramReportType, paramString1.toString(), paramString4);
  }
  
  @OssReport(checkSum="da8ba54", enable=true, fixed=true, logId=80000363, taskId="search_content")
  public static void searchContent(Object... paramVarArgs)
  {
    report(true, 80000363, "search_content", "", ";", true, ReportType.NORMAL, "da8ba54", paramVarArgs);
  }
  
  @OssReport(checkSum="50169a4", enable=true, fixed=true, logId=80000363, taskId="select_detect_new")
  public static void selectDetectNew(Object... paramVarArgs)
  {
    report(true, 80000363, "select_detect_new", "", ";", true, ReportType.NORMAL, "50169a4", paramVarArgs);
  }
  
  @OssReport(checkSum="8e3c841", enable=true, fixed=true, logId=80000363, taskId="sendmail_crash")
  public static void sendmailCrash(Object... paramVarArgs)
  {
    report(true, 80000363, "sendmail_crash", "", ";", true, ReportType.NORMAL, "8e3c841", paramVarArgs);
  }
  
  public static void setClient(OssClient paramOssClient)
  {
    sClient = paramOssClient;
  }
  
  @OssReport(checkSum="d939129", enable=true, fixed=true, logId=80000363, taskId="so_invalid")
  public static void soInvalid(Object... paramVarArgs)
  {
    report(true, 80000363, "so_invalid", "", ";", true, ReportType.NORMAL, "d939129", paramVarArgs);
  }
  
  @OssReport(checkSum="d88c448", enable=true, fixed=true, logId=80000363, taskId="ssl_error_host")
  public static void sslErrorHost(Object... paramVarArgs)
  {
    report(true, 80000363, "ssl_error_host", "", ";", true, ReportType.NORMAL, "d88c448", paramVarArgs);
  }
  
  @OssReport(checkSum="557c6e1", enable=true, fixed=true, logId=80000363, taskId="startup_app_oncreate")
  public static void startupAppOncreate(Object... paramVarArgs)
  {
    report(true, 80000363, "startup_app_oncreate", "", ";", true, ReportType.NORMAL, "557c6e1", paramVarArgs);
  }
  
  @OssReport(checkSum="e07405c", enable=true, fixed=true, logId=80000363, taskId="startup_patch_attach_base_context")
  public static void startupPatchAttachBaseContext(Object... paramVarArgs)
  {
    report(true, 80000363, "startup_patch_attach_base_context", "", ";", true, ReportType.NORMAL, "e07405c", paramVarArgs);
  }
  
  @OssReport(checkSum="413d12f", enable=true, fixed=true, logId=80000363, taskId="startup_patch_attach_real_context")
  public static void startupPatchAttachRealContext(Object... paramVarArgs)
  {
    report(true, 80000363, "startup_patch_attach_real_context", "", ";", true, ReportType.NORMAL, "413d12f", paramVarArgs);
  }
  
  @OssReport(checkSum="1fc75dc", enable=true, fixed=true, logId=80000363, taskId="startup_welcome_visible")
  public static void startupWelcomeVisible(Object... paramVarArgs)
  {
    report(true, 80000363, "startup_welcome_visible", "", ";", true, ReportType.NORMAL, "1fc75dc", paramVarArgs);
  }
  
  @OssReport(checkSum="9415f8c", enable=true, fixed=true, logId=80000363, taskId="sync_adapter")
  public static void syncAdapter(Object... paramVarArgs)
  {
    report(true, 80000363, "sync_adapter", "", ";", true, ReportType.NORMAL, "9415f8c", paramVarArgs);
  }
  
  @OssReport(checkSum="f7d4c07", enable=true, fixed=true, logId=80000363, taskId="upgrade_fts_time")
  public static void upgradeFtsTime(Object... paramVarArgs)
  {
    report(true, 80000363, "upgrade_fts_time", "", ";", true, ReportType.IMMEDIATELY_UPLOAD, "f7d4c07", paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.oss.OssHelper
 * JD-Core Version:    0.7.0.1
 */