package moai.oss;

import moai.oss.annotation.KvReport;

public class KvHelper
{
  private static OssClient sClient;
  
  @KvReport(checkSum="a777d17", enable=true, itemName="app_has_badge", merge=true, statKey=78503071, table=false)
  public static void appHasBadge(double... paramVarArgs)
  {
    report(true, 78503071, "app_has_badge", "", ReportType.NORMAL, "a777d17", paramVarArgs);
  }
  
  @KvReport(checkSum="199812c", enable=true, itemName="app_wake_up", merge=true, statKey=78503071, table=false)
  public static void appWakeUp(double... paramVarArgs)
  {
    report(true, 78503071, "app_wake_up", "", ReportType.NORMAL, "199812c", paramVarArgs);
  }
  
  @KvReport(checkSum="5c09de0", enable=true, itemName="APPLICATION_LAUNCHER_TIME", merge=false, statKey=78503071, table=false)
  public static void applicationLauncherTime(double... paramVarArgs)
  {
    report(true, 78503071, "APPLICATION_LAUNCHER_TIME", "", ReportType.NORMAL, "5c09de0", paramVarArgs);
  }
  
  @KvReport(checkSum="6434fe2", enable=true, itemName="auto_sync_off", merge=true, statKey=78503071, table=false)
  public static void autoSyncOff(double... paramVarArgs)
  {
    report(true, 78503071, "auto_sync_off", "", ReportType.NORMAL, "6434fe2", paramVarArgs);
  }
  
  @KvReport(checkSum="cfb1da4", enable=true, itemName="auto_sync_on", merge=true, statKey=78503071, table=false)
  public static void autoSyncOn(double... paramVarArgs)
  {
    report(true, 78503071, "auto_sync_on", "", ReportType.NORMAL, "cfb1da4", paramVarArgs);
  }
  
  @KvReport(checkSum="1a0083f", enable=true, itemName="Calendar_Remind_Click", merge=true, statKey=78503071, table=false)
  public static void calendarRemindClick(double... paramVarArgs)
  {
    report(true, 78503071, "Calendar_Remind_Click", "", ReportType.NORMAL, "1a0083f", paramVarArgs);
  }
  
  @KvReport(checkSum="35561ab", enable=true, itemName="Calendar_Remind_Confirm", merge=true, statKey=78503071, table=false)
  public static void calendarRemindConfirm(double... paramVarArgs)
  {
    report(true, 78503071, "Calendar_Remind_Confirm", "", ReportType.NORMAL, "35561ab", paramVarArgs);
  }
  
  @KvReport(checkSum="b4ed652", enable=true, itemName="Calendar_Remind_Date", merge=true, statKey=78503071, table=false)
  public static void calendarRemindDate(double... paramVarArgs)
  {
    report(true, 78503071, "Calendar_Remind_Date", "", ReportType.NORMAL, "b4ed652", paramVarArgs);
  }
  
  @KvReport(checkSum="ad3e5aa", enable=true, itemName="cancel_trust_ssl_certificate", merge=true, statKey=78503071, table=false)
  public static void cancelTrustSslCertificate(double... paramVarArgs)
  {
    report(true, 78503071, "cancel_trust_ssl_certificate", "", ReportType.NORMAL, "ad3e5aa", paramVarArgs);
  }
  
  @KvReport(checkSum="636b7c6", enable=true, itemName="CGI_RTT_ACTIVESYNC", merge=false, statKey=78503071, table=false)
  public static void cgiRttActivesync(double... paramVarArgs)
  {
    report(true, 78503071, "CGI_RTT_ACTIVESYNC", "", ReportType.NORMAL, "636b7c6", paramVarArgs);
  }
  
  @KvReport(checkSum="885b817", enable=true, itemName="CGI_RTT_BIRTH_LIST", merge=false, statKey=78503071, table=false)
  public static void cgiRttBirthList(double... paramVarArgs)
  {
    report(true, 78503071, "CGI_RTT_BIRTH_LIST", "", ReportType.NORMAL, "885b817", paramVarArgs);
  }
  
  @KvReport(checkSum="67aecde", enable=true, itemName="CGI_RTT_COMPOSE_SEND", merge=false, statKey=78503071, table=false)
  public static void cgiRttComposeSend(double... paramVarArgs)
  {
    report(true, 78503071, "CGI_RTT_COMPOSE_SEND", "", ReportType.NORMAL, "67aecde", paramVarArgs);
  }
  
  @KvReport(checkSum="6a7906a", enable=true, itemName="CGI_RTT_MAIL_MGR", merge=false, statKey=78503071, table=false)
  public static void cgiRttMailMgr(double... paramVarArgs)
  {
    report(true, 78503071, "CGI_RTT_MAIL_MGR", "", ReportType.NORMAL, "6a7906a", paramVarArgs);
  }
  
  @KvReport(checkSum="6b8322c", enable=true, itemName="CGI_RTT_MAILLIST", merge=false, statKey=78503071, table=false)
  public static void cgiRttMaillist(double... paramVarArgs)
  {
    report(true, 78503071, "CGI_RTT_MAILLIST", "", ReportType.NORMAL, "6b8322c", paramVarArgs);
  }
  
  @KvReport(checkSum="9432c53", enable=true, itemName="CGI_RTT_MOBILE_SYNC", merge=false, statKey=78503071, table=false)
  public static void cgiRttMobileSync(double... paramVarArgs)
  {
    report(true, 78503071, "CGI_RTT_MOBILE_SYNC", "", ReportType.NORMAL, "9432c53", paramVarArgs);
  }
  
  @KvReport(checkSum="a192c30", enable=true, itemName="CGI_RTT_OSS_LOG", merge=false, statKey=78503071, table=false)
  public static void cgiRttOssLog(double... paramVarArgs)
  {
    report(true, 78503071, "CGI_RTT_OSS_LOG", "", ReportType.NORMAL, "a192c30", paramVarArgs);
  }
  
  @KvReport(checkSum="bfc8d16", enable=true, itemName="CGI_RTT_PHOTO_SYNC", merge=false, statKey=78503071, table=false)
  public static void cgiRttPhotoSync(double... paramVarArgs)
  {
    report(true, 78503071, "CGI_RTT_PHOTO_SYNC", "", ReportType.NORMAL, "bfc8d16", paramVarArgs);
  }
  
  @KvReport(checkSum="a0713ef", enable=true, itemName="CGI_RTT_READMAIL", merge=false, statKey=78503071, table=false)
  public static void cgiRttReadmail(double... paramVarArgs)
  {
    report(true, 78503071, "CGI_RTT_READMAIL", "", ReportType.NORMAL, "a0713ef", paramVarArgs);
  }
  
  @KvReport(checkSum="bd20f41", enable=true, itemName="CGI_RTT_UMA_DATA_REPORT", merge=false, statKey=78503071, table=false)
  public static void cgiRttUmaDataReport(double... paramVarArgs)
  {
    report(true, 78503071, "CGI_RTT_UMA_DATA_REPORT", "", ReportType.NORMAL, "bd20f41", paramVarArgs);
  }
  
  @KvReport(checkSum="851d86b", enable=true, itemName="check_ssl_detail", merge=true, statKey=78503071, table=false)
  public static void checkSslDetail(double... paramVarArgs)
  {
    report(true, 78503071, "check_ssl_detail", "", ReportType.NORMAL, "851d86b", paramVarArgs);
  }
  
  @KvReport(checkSum="517de26", enable=true, itemName="click_notify_login_invalid", merge=true, statKey=78503071, table=false)
  public static void clickNotifyLoginInvalid(double... paramVarArgs)
  {
    report(true, 78503071, "click_notify_login_invalid", "", ReportType.NORMAL, "517de26", paramVarArgs);
  }
  
  @KvReport(checkSum="94cba47", enable=true, itemName="click_ssl_notification", merge=true, statKey=78503071, table=false)
  public static void clickSslNotification(double... paramVarArgs)
  {
    report(true, 78503071, "click_ssl_notification", "", ReportType.NORMAL, "94cba47", paramVarArgs);
  }
  
  @KvReport(checkSum="3c44482", enable=true, itemName="compose_crash_protect_for_compose_mail", merge=true, statKey=78503071, table=false)
  public static void composeCrashProtectForComposeMail(double... paramVarArgs)
  {
    report(true, 78503071, "compose_crash_protect_for_compose_mail", "", ReportType.NORMAL, "3c44482", paramVarArgs);
  }
  
  @KvReport(checkSum="28f7093", enable=true, itemName="compose_crash_protect_for_compose_note", merge=true, statKey=78503071, table=false)
  public static void composeCrashProtectForComposeNote(double... paramVarArgs)
  {
    report(true, 78503071, "compose_crash_protect_for_compose_note", "", ReportType.NORMAL, "28f7093", paramVarArgs);
  }
  
  @KvReport(checkSum="f756b16", enable=true, itemName="compose_crash_protect_for_feedback", merge=true, statKey=78503071, table=false)
  public static void composeCrashProtectForFeedback(double... paramVarArgs)
  {
    report(true, 78503071, "compose_crash_protect_for_feedback", "", ReportType.NORMAL, "f756b16", paramVarArgs);
  }
  
  @KvReport(checkSum="a3d95ab", enable=true, itemName="confirm_trust_ssl_certificate", merge=true, statKey=78503071, table=false)
  public static void confirmTrustSslCertificate(double... paramVarArgs)
  {
    report(true, 78503071, "confirm_trust_ssl_certificate", "", ReportType.NORMAL, "a3d95ab", paramVarArgs);
  }
  
  @KvReport(checkSum="0e7e3b2", enable=true, itemName="CREDIT_CARD_BILL_CLICK", merge=false, statKey=78503071, table=false)
  public static void creditCardBillClick(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_CLICK", "", ReportType.NORMAL, "0e7e3b2", paramVarArgs);
  }
  
  @KvReport(checkSum="4023c94", enable=true, itemName="CREDIT_CARD_BILL_CLICK_IN_CONTENT_DATE", merge=false, statKey=78503071, table=false)
  public static void creditCardBillClickInContentDate(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_CLICK_IN_CONTENT_DATE", "", ReportType.NORMAL, "4023c94", paramVarArgs);
  }
  
  @KvReport(checkSum="8e3d3d2", enable=true, itemName="CREDIT_CARD_BILL_REMINGD_CANCEL_FROM_NOW_ON", merge=false, statKey=78503071, table=false)
  public static void creditCardBillRemingdCancelFromNowOn(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_REMINGD_CANCEL_FROM_NOW_ON", "", ReportType.NORMAL, "8e3d3d2", paramVarArgs);
  }
  
  @KvReport(checkSum="526c295", enable=true, itemName="CREDIT_CARD_BILL_REMINGD_CANCEL_ONCE", merge=false, statKey=78503071, table=false)
  public static void creditCardBillRemingdCancelOnce(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_REMINGD_CANCEL_ONCE", "", ReportType.NORMAL, "526c295", paramVarArgs);
  }
  
  @KvReport(checkSum="e1eacff", enable=true, itemName="CREDIT_CARD_BILL_REMINGD_FOREGROUND_DIALOG", merge=false, statKey=78503071, table=false)
  public static void creditCardBillRemingdForegroundDialog(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_REMINGD_FOREGROUND_DIALOG", "", ReportType.NORMAL, "e1eacff", paramVarArgs);
  }
  
  @KvReport(checkSum="e82492e", enable=true, itemName="CREDIT_CARD_BILL_REMINGD_NONE", merge=false, statKey=78503071, table=false)
  public static void creditCardBillRemingdNone(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_REMINGD_NONE", "", ReportType.NORMAL, "e82492e", paramVarArgs);
  }
  
  @KvReport(checkSum="e377de9", enable=true, itemName="CREDIT_CARD_BILL_REMINGD_ONE_DAY", merge=false, statKey=78503071, table=false)
  public static void creditCardBillRemingdOneDay(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_REMINGD_ONE_DAY", "", ReportType.NORMAL, "e377de9", paramVarArgs);
  }
  
  @KvReport(checkSum="6da42ab", enable=true, itemName="CREDIT_CARD_BILL_REMINGD_ONE_WEEK", merge=false, statKey=78503071, table=false)
  public static void creditCardBillRemingdOneWeek(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_REMINGD_ONE_WEEK", "", ReportType.NORMAL, "6da42ab", paramVarArgs);
  }
  
  @KvReport(checkSum="48206f8", enable=true, itemName="CREDIT_CARD_BILL_REMINGD_POP_PERMISSION_DIALOG", merge=false, statKey=78503071, table=false)
  public static void creditCardBillRemingdPopPermissionDialog(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_REMINGD_POP_PERMISSION_DIALOG", "", ReportType.NORMAL, "48206f8", paramVarArgs);
  }
  
  @KvReport(checkSum="97d4cc1", enable=true, itemName="CREDIT_CARD_BILL_REMINGD_POP_PERMISSION_DIALOG_ACCEPT", merge=false, statKey=78503071, table=false)
  public static void creditCardBillRemingdPopPermissionDialogAccept(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_REMINGD_POP_PERMISSION_DIALOG_ACCEPT", "", ReportType.NORMAL, "97d4cc1", paramVarArgs);
  }
  
  @KvReport(checkSum="f36fbde", enable=true, itemName="CREDIT_CARD_BILL_REMINGD_PUSH", merge=false, statKey=78503071, table=false)
  public static void creditCardBillRemingdPush(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_REMINGD_PUSH", "", ReportType.NORMAL, "f36fbde", paramVarArgs);
  }
  
  @KvReport(checkSum="0f2a58c", enable=true, itemName="CREDIT_CARD_BILL_REMINGD_PUSH_CLICK", merge=false, statKey=78503071, table=false)
  public static void creditCardBillRemingdPushClick(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_REMINGD_PUSH_CLICK", "", ReportType.NORMAL, "0f2a58c", paramVarArgs);
  }
  
  @KvReport(checkSum="9f44320", enable=true, itemName="CREDIT_CARD_BILL_REMINGD_SETTING_CLOSE", merge=false, statKey=78503071, table=false)
  public static void creditCardBillRemingdSettingClose(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_REMINGD_SETTING_CLOSE", "", ReportType.NORMAL, "9f44320", paramVarArgs);
  }
  
  @KvReport(checkSum="0e8f695", enable=true, itemName="CREDIT_CARD_BILL_REMINGD_SETTING_OPEN", merge=false, statKey=78503071, table=false)
  public static void creditCardBillRemingdSettingOpen(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_REMINGD_SETTING_OPEN", "", ReportType.NORMAL, "0e8f695", paramVarArgs);
  }
  
  @KvReport(checkSum="2e3cd0a", enable=true, itemName="CREDIT_CARD_BILL_REMINGD_THE_DAY", merge=false, statKey=78503071, table=false)
  public static void creditCardBillRemingdTheDay(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_REMINGD_THE_DAY", "", ReportType.NORMAL, "2e3cd0a", paramVarArgs);
  }
  
  @KvReport(checkSum="e947e35", enable=true, itemName="CREDIT_CARD_BILL_REMINGD_THREE_DAY", merge=false, statKey=78503071, table=false)
  public static void creditCardBillRemingdThreeDay(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_REMINGD_THREE_DAY", "", ReportType.NORMAL, "e947e35", paramVarArgs);
  }
  
  @KvReport(checkSum="2ab42c3", enable=true, itemName="CREDIT_CARD_BILL_REMINGD_TWO_DAY", merge=false, statKey=78503071, table=false)
  public static void creditCardBillRemingdTwoDay(double... paramVarArgs)
  {
    report(true, 78503071, "CREDIT_CARD_BILL_REMINGD_TWO_DAY", "", ReportType.NORMAL, "2ab42c3", paramVarArgs);
  }
  
  @KvReport(checkSum="618350b", enable=true, itemName="decode_error_after_encode", merge=true, statKey=78503071, table=false)
  public static void decodeErrorAfterEncode(double... paramVarArgs)
  {
    report(true, 78503071, "decode_error_after_encode", "", ReportType.NORMAL, "618350b", paramVarArgs);
  }
  
  @KvReport(checkSum="12d8d9e", enable=true, itemName="decode_pwd_error", merge=true, statKey=78503071, table=false)
  public static void decodePwdError(double... paramVarArgs)
  {
    report(true, 78503071, "decode_pwd_error", "", ReportType.NORMAL, "12d8d9e", paramVarArgs);
  }
  
  @KvReport(checkSum="4a8e923", enable=true, itemName="DetailEvent_AD_Mail_Watch_Time_New", merge=false, statKey=78503071, table=false)
  public static void detaileventAdMailWatchTimeNew(double... paramVarArgs)
  {
    report(true, 78503071, "DetailEvent_AD_Mail_Watch_Time_New", "", ReportType.NORMAL, "4a8e923", paramVarArgs);
  }
  
  @KvReport(checkSum="3bc3d9e", enable=true, itemName="DetailEvent_New_Wt_Login_On_Quick_Result_", merge=true, statKey=78503071, table=false)
  public static void detaileventNewWtLoginOnQuickResult(String paramString, double... paramVarArgs)
  {
    report(true, 78503071, "DetailEvent_New_Wt_Login_On_Quick_Result_", paramString, ReportType.NORMAL, "3bc3d9e", paramVarArgs);
  }
  
  @KvReport(checkSum="20f9734", enable=true, itemName="DetailEvent_New_Wt_Login_QQ_Back_Result_", merge=true, statKey=78503071, table=false)
  public static void detaileventNewWtLoginQqBackResult(String paramString, double... paramVarArgs)
  {
    report(true, 78503071, "DetailEvent_New_Wt_Login_QQ_Back_Result_", paramString, ReportType.NORMAL, "20f9734", paramVarArgs);
  }
  
  @KvReport(checkSum="6e393ec", enable=true, itemName="DetailEvent_Read_Mail_Ad_Read_Time_New", merge=false, statKey=78503071, table=false)
  public static void detaileventReadMailAdReadTimeNew(double... paramVarArgs)
  {
    report(true, 78503071, "DetailEvent_Read_Mail_Ad_Read_Time_New", "", ReportType.NORMAL, "6e393ec", paramVarArgs);
  }
  
  @KvReport(checkSum="8031ee5", enable=true, itemName="DetailEvent_Read_Mail_Normal_Read_Time_New", merge=false, statKey=78503071, table=false)
  public static void detaileventReadMailNormalReadTimeNew(double... paramVarArgs)
  {
    report(true, 78503071, "DetailEvent_Read_Mail_Normal_Read_Time_New", "", ReportType.NORMAL, "8031ee5", paramVarArgs);
  }
  
  @KvReport(checkSum="b1db5c6", enable=true, itemName="digital_login_error_cancel", merge=false, statKey=78503071, table=false)
  public static void digitalLoginErrorCancel(double... paramVarArgs)
  {
    report(true, 78503071, "digital_login_error_cancel", "", ReportType.NORMAL, "b1db5c6", paramVarArgs);
  }
  
  @KvReport(checkSum="5b8e6f2", enable=true, itemName="digital_login_error_jump", merge=false, statKey=78503071, table=false)
  public static void digitalLoginErrorJump(double... paramVarArgs)
  {
    report(true, 78503071, "digital_login_error_jump", "", ReportType.NORMAL, "5b8e6f2", paramVarArgs);
  }
  
  @KvReport(checkSum="4ea83ed", enable=true, itemName="digital_login_error_jump_success", merge=false, statKey=78503071, table=false)
  public static void digitalLoginErrorJumpSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "digital_login_error_jump_success", "", ReportType.NORMAL, "4ea83ed", paramVarArgs);
  }
  
  @KvReport(checkSum="e49ef4c", enable=true, itemName="digital_login_error_show", merge=false, statKey=78503071, table=false)
  public static void digitalLoginErrorShow(double... paramVarArgs)
  {
    report(true, 78503071, "digital_login_error_show", "", ReportType.NORMAL, "e49ef4c", paramVarArgs);
  }
  
  @KvReport(checkSum="4bcd30c", enable=true, itemName="Event_AD_Mail_Mail_List_Show", merge=true, statKey=78503071, table=false)
  public static void eventAdMailMailListShow(double... paramVarArgs)
  {
    report(true, 78503071, "Event_AD_Mail_Mail_List_Show", "", ReportType.NORMAL, "4bcd30c", paramVarArgs);
  }
  
  @KvReport(checkSum="347d5b3", enable=true, itemName="Event_Add_Image_To_Content", merge=true, statKey=78503071, table=false)
  public static void eventAddImageToContent(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Add_Image_To_Content", "", ReportType.NORMAL, "347d5b3", paramVarArgs);
  }
  
  @KvReport(checkSum="b2327a8", enable=true, itemName="Event_Add_Image_To_Content_Below_Kitkat", merge=true, statKey=78503071, table=false)
  public static void eventAddImageToContentBelowKitkat(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Add_Image_To_Content_Below_Kitkat", "", ReportType.NORMAL, "b2327a8", paramVarArgs);
  }
  
  @KvReport(checkSum="0ddc75f", enable=true, itemName="Event_Add_Note_Category_From_Move_Note", merge=true, statKey=78503071, table=false)
  public static void eventAddNoteCategoryFromMoveNote(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Add_Note_Category_From_Move_Note", "", ReportType.NORMAL, "0ddc75f", paramVarArgs);
  }
  
  @KvReport(checkSum="39d28e8", enable=true, itemName="Event_Add_Note_Category_From_Setting", merge=true, statKey=78503071, table=false)
  public static void eventAddNoteCategoryFromSetting(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Add_Note_Category_From_Setting", "", ReportType.NORMAL, "39d28e8", paramVarArgs);
  }
  
  @KvReport(checkSum="6c2d44d", enable=true, itemName="Event_APP_LINK", merge=true, statKey=78503071, table=false)
  public static void eventAppLink(double... paramVarArgs)
  {
    report(true, 78503071, "Event_APP_LINK", "", ReportType.NORMAL, "6c2d44d", paramVarArgs);
  }
  
  @KvReport(checkSum="51b2fc7", enable=true, itemName="Event_Calendar_Add_Calendar", merge=true, statKey=78503071, table=false)
  public static void eventCalendarAddCalendar(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Calendar_Add_Calendar", "", ReportType.NORMAL, "51b2fc7", paramVarArgs);
  }
  
  @KvReport(checkSum="ab43305", enable=true, itemName="Event_Calendar_Close_System_Calendar", merge=true, statKey=78503071, table=false)
  public static void eventCalendarCloseSystemCalendar(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Calendar_Close_System_Calendar", "", ReportType.NORMAL, "ab43305", paramVarArgs);
  }
  
  @KvReport(checkSum="a819055", enable=true, itemName="Event_Calendar_Delete_Calendar", merge=true, statKey=78503071, table=false)
  public static void eventCalendarDeleteCalendar(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Calendar_Delete_Calendar", "", ReportType.NORMAL, "a819055", paramVarArgs);
  }
  
  @KvReport(checkSum="3d28f63", enable=true, itemName="Event_Calendar_Modify_Calendar", merge=true, statKey=78503071, table=false)
  public static void eventCalendarModifyCalendar(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Calendar_Modify_Calendar", "", ReportType.NORMAL, "3d28f63", paramVarArgs);
  }
  
  @KvReport(checkSum="16f96a2", enable=true, itemName="Event_Calendar_Open_System_Calendar", merge=true, statKey=78503071, table=false)
  public static void eventCalendarOpenSystemCalendar(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Calendar_Open_System_Calendar", "", ReportType.NORMAL, "16f96a2", paramVarArgs);
  }
  
  @KvReport(checkSum="d0d29bf", enable=true, itemName="Event_Calendar_Share_Calendar_By_Email", merge=true, statKey=78503071, table=false)
  public static void eventCalendarShareCalendarByEmail(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Calendar_Share_Calendar_By_Email", "", ReportType.NORMAL, "d0d29bf", paramVarArgs);
  }
  
  @KvReport(checkSum="7c2e73a", enable=true, itemName="Event_Calendar_Share_Calendar_By_QQ", merge=true, statKey=78503071, table=false)
  public static void eventCalendarShareCalendarByQq(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Calendar_Share_Calendar_By_QQ", "", ReportType.NORMAL, "7c2e73a", paramVarArgs);
  }
  
  @KvReport(checkSum="a487ad4", enable=true, itemName="Event_Calendar_Share_Calendar_By_WEWORK", merge=true, statKey=78503071, table=false)
  public static void eventCalendarShareCalendarByWework(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Calendar_Share_Calendar_By_WEWORK", "", ReportType.NORMAL, "a487ad4", paramVarArgs);
  }
  
  @KvReport(checkSum="638a9b8", enable=true, itemName="Event_Calendar_Share_Calendar_By_WX", merge=true, statKey=78503071, table=false)
  public static void eventCalendarShareCalendarByWx(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Calendar_Share_Calendar_By_WX", "", ReportType.NORMAL, "638a9b8", paramVarArgs);
  }
  
  @KvReport(checkSum="5818914", enable=true, itemName="Event_Calendar_Share_Calendar_Cancel", merge=true, statKey=78503071, table=false)
  public static void eventCalendarShareCalendarCancel(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Calendar_Share_Calendar_Cancel", "", ReportType.NORMAL, "5818914", paramVarArgs);
  }
  
  @KvReport(checkSum="dd1998f", enable=true, itemName="Event_Calendar_Share_Calendar_Follow", merge=true, statKey=78503071, table=false)
  public static void eventCalendarShareCalendarFollow(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Calendar_Share_Calendar_Follow", "", ReportType.NORMAL, "dd1998f", paramVarArgs);
  }
  
  @KvReport(checkSum="596348a", enable=true, itemName="Event_Calendar_Share_Calendar_Stop", merge=true, statKey=78503071, table=false)
  public static void eventCalendarShareCalendarStop(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Calendar_Share_Calendar_Stop", "", ReportType.NORMAL, "596348a", paramVarArgs);
  }
  
  @KvReport(checkSum="ef7388b", enable=true, itemName="Event_Calendar_Widget_Week_Start_Monday", merge=true, statKey=78503071, table=false)
  public static void eventCalendarWidgetWeekStartMonday(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Calendar_Widget_Week_Start_Monday", "", ReportType.NORMAL, "ef7388b", paramVarArgs);
  }
  
  @KvReport(checkSum="87a2fc2", enable=true, itemName="Event_Calendar_Widget_Week_Start_Saturday", merge=true, statKey=78503071, table=false)
  public static void eventCalendarWidgetWeekStartSaturday(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Calendar_Widget_Week_Start_Saturday", "", ReportType.NORMAL, "87a2fc2", paramVarArgs);
  }
  
  @KvReport(checkSum="f1478cf", enable=true, itemName="Event_Calendar_Widget_Week_Start_Sunday", merge=true, statKey=78503071, table=false)
  public static void eventCalendarWidgetWeekStartSunday(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Calendar_Widget_Week_Start_Sunday", "", ReportType.NORMAL, "f1478cf", paramVarArgs);
  }
  
  @KvReport(checkSum="10682fc", enable=true, itemName="Event_CGI_Compose", merge=true, statKey=78503071, table=false)
  public static void eventCgiCompose(double... paramVarArgs)
  {
    report(true, 78503071, "Event_CGI_Compose", "", ReportType.NORMAL, "10682fc", paramVarArgs);
  }
  
  @KvReport(checkSum="52b9533", enable=true, itemName="Event_CGI_Compose_Fail", merge=true, statKey=78503071, table=false)
  public static void eventCgiComposeFail(double... paramVarArgs)
  {
    report(true, 78503071, "Event_CGI_Compose_Fail", "", ReportType.NORMAL, "52b9533", paramVarArgs);
  }
  
  @KvReport(checkSum="344d8f1", enable=true, itemName="Event_Clear_All_New_Mail_Notification_By_APP", merge=true, statKey=78503071, table=false)
  public static void eventClearAllNewMailNotificationByApp(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Clear_All_New_Mail_Notification_By_APP", "", ReportType.NORMAL, "344d8f1", paramVarArgs);
  }
  
  @KvReport(checkSum="2839afa", enable=true, itemName="Event_Clear_All_New_Mail_Notification_Of_OneAccount_By_APP", merge=true, statKey=78503071, table=false)
  public static void eventClearAllNewMailNotificationOfOneaccountByApp(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Clear_All_New_Mail_Notification_Of_OneAccount_By_APP", "", ReportType.NORMAL, "2839afa", paramVarArgs);
  }
  
  @KvReport(checkSum="e09155f", enable=true, itemName="Event_Clear_All_Notification", merge=true, statKey=78503071, table=false)
  public static void eventClearAllNotification(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Clear_All_Notification", "", ReportType.NORMAL, "e09155f", paramVarArgs);
  }
  
  @KvReport(checkSum="942672f", enable=true, itemName="Event_Clear_Single_New_Mail_Notification", merge=true, statKey=78503071, table=false)
  public static void eventClearSingleNewMailNotification(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Clear_Single_New_Mail_Notification", "", ReportType.NORMAL, "942672f", paramVarArgs);
  }
  
  @KvReport(checkSum="682e4ae", enable=true, itemName="Event_Click_New_Mail_Notification", merge=true, statKey=78503071, table=false)
  public static void eventClickNewMailNotification(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Click_New_Mail_Notification", "", ReportType.NORMAL, "682e4ae", paramVarArgs);
  }
  
  @KvReport(checkSum="c7e6c41", enable=true, itemName="Event_Close_Show_Push_Mail_Detail", merge=true, statKey=78503071, table=false)
  public static void eventCloseShowPushMailDetail(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Close_Show_Push_Mail_Detail", "", ReportType.NORMAL, "c7e6c41", paramVarArgs);
  }
  
  @KvReport(checkSum="df535c8", enable=true, itemName="Event_Commercial_Mail_Mail_List_Click_With_Data", merge=true, statKey=78503071, table=false)
  public static void eventCommercialMailMailListClickWithData(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Commercial_Mail_Mail_List_Click_With_Data", "", ReportType.NORMAL, "df535c8", paramVarArgs);
  }
  
  @KvReport(checkSum="91f6ab0", enable=true, itemName="Event_Compose_Add_Album_Attach", merge=true, statKey=78503071, table=false)
  public static void eventComposeAddAlbumAttach(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Add_Album_Attach", "", ReportType.NORMAL, "91f6ab0", paramVarArgs);
  }
  
  @KvReport(checkSum="259467f", enable=true, itemName="Event_Compose_Add_Fav_Attach", merge=true, statKey=78503071, table=false)
  public static void eventComposeAddFavAttach(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Add_Fav_Attach", "", ReportType.NORMAL, "259467f", paramVarArgs);
  }
  
  @KvReport(checkSum="48d4e5b", enable=true, itemName="Event_Compose_Add_Ftn_Attach", merge=true, statKey=78503071, table=false)
  public static void eventComposeAddFtnAttach(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Add_Ftn_Attach", "", ReportType.NORMAL, "48d4e5b", paramVarArgs);
  }
  
  @KvReport(checkSum="02db7e0", enable=true, itemName="Event_Compose_Add_QQ_Browser_Attach", merge=true, statKey=78503071, table=false)
  public static void eventComposeAddQqBrowserAttach(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Add_QQ_Browser_Attach", "", ReportType.NORMAL, "02db7e0", paramVarArgs);
  }
  
  @KvReport(checkSum="193cad3", enable=true, itemName="Event_Compose_Add_Video_Or_File_Attach", merge=true, statKey=78503071, table=false)
  public static void eventComposeAddVideoOrFileAttach(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Add_Video_Or_File_Attach", "", ReportType.NORMAL, "193cad3", paramVarArgs);
  }
  
  @KvReport(checkSum="763869b", enable=true, itemName="Event_Compose_Attach_Rename", merge=true, statKey=78503071, table=false)
  public static void eventComposeAttachRename(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Attach_Rename", "", ReportType.NORMAL, "763869b", paramVarArgs);
  }
  
  @KvReport(checkSum="8d8e2ac", enable=true, itemName="Event_Compose_QQBrowser_File_Explorer", merge=true, statKey=78503071, table=false)
  public static void eventComposeQqbrowserFileExplorer(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_QQBrowser_File_Explorer", "", ReportType.NORMAL, "8d8e2ac", paramVarArgs);
  }
  
  @KvReport(checkSum="2564781", enable=true, itemName="Event_Compose_Receiver_Edit_Nick_Type", merge=true, statKey=78503071, table=false)
  public static void eventComposeReceiverEditNickType(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Receiver_Edit_Nick_Type", "", ReportType.NORMAL, "2564781", paramVarArgs);
  }
  
  @KvReport(checkSum="3b72c99", enable=true, itemName="Event_Compose_Receiver_Nick_Type", merge=true, statKey=78503071, table=false)
  public static void eventComposeReceiverNickType(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Receiver_Nick_Type", "", ReportType.NORMAL, "3b72c99", paramVarArgs);
  }
  
  @KvReport(checkSum="2e3edc9", enable=true, itemName="Event_Compose_Scan", merge=true, statKey=78503071, table=false)
  public static void eventComposeScan(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan", "", ReportType.NORMAL, "2e3edc9", paramVarArgs);
  }
  
  @KvReport(checkSum="97e5c38", enable=true, itemName="Event_Compose_Scan_Complete_More", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanCompleteMore(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Complete_More", "", ReportType.NORMAL, "97e5c38", paramVarArgs);
  }
  
  @KvReport(checkSum="7513a04", enable=true, itemName="Event_Compose_Scan_Complete_One", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanCompleteOne(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Complete_One", "", ReportType.NORMAL, "7513a04", paramVarArgs);
  }
  
  @KvReport(checkSum="ad16a74", enable=true, itemName="Event_Compose_Scan_Delete", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanDelete(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Delete", "", ReportType.NORMAL, "ad16a74", paramVarArgs);
  }
  
  @KvReport(checkSum="f5b182b", enable=true, itemName="Event_Compose_Scan_Duration_One_Second", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanDurationOneSecond(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Duration_One_Second", "", ReportType.NORMAL, "f5b182b", paramVarArgs);
  }
  
  @KvReport(checkSum="64d52b0", enable=true, itemName="Event_Compose_Scan_Duration_Three_Seconds", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanDurationThreeSeconds(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Duration_Three_Seconds", "", ReportType.NORMAL, "64d52b0", paramVarArgs);
  }
  
  @KvReport(checkSum="bdf7a23", enable=true, itemName="Event_Compose_Scan_Duration_Two_Seconds", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanDurationTwoSeconds(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Duration_Two_Seconds", "", ReportType.NORMAL, "bdf7a23", paramVarArgs);
  }
  
  @KvReport(checkSum="3135a0a", enable=true, itemName="Event_Compose_Scan_Edit", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanEdit(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Edit", "", ReportType.NORMAL, "3135a0a", paramVarArgs);
  }
  
  @KvReport(checkSum="e1b7fa2", enable=true, itemName="Event_Compose_Scan_Giveip_One", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanGiveipOne(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Giveip_One", "", ReportType.NORMAL, "e1b7fa2", paramVarArgs);
  }
  
  @KvReport(checkSum="9281ea6", enable=true, itemName="Event_Compose_Scan_Jpg", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanJpg(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Jpg", "", ReportType.NORMAL, "9281ea6", paramVarArgs);
  }
  
  @KvReport(checkSum="63c9e3b", enable=true, itemName="Event_Compose_Scan_Jpg_From_HomePage_Entrance", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanJpgFromHomepageEntrance(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Jpg_From_HomePage_Entrance", "", ReportType.NORMAL, "63c9e3b", paramVarArgs);
  }
  
  @KvReport(checkSum="aa18cdc", enable=true, itemName="Event_Compose_Scan_Left_close", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanLeftClose(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Left_close", "", ReportType.NORMAL, "aa18cdc", paramVarArgs);
  }
  
  @KvReport(checkSum="819dd8b", enable=true, itemName="Event_Compose_Scan_Next", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanNext(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Next", "", ReportType.NORMAL, "819dd8b", paramVarArgs);
  }
  
  @KvReport(checkSum="8c005de", enable=true, itemName="Event_Compose_Scan_Offlight", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanOfflight(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Offlight", "", ReportType.NORMAL, "8c005de", paramVarArgs);
  }
  
  @KvReport(checkSum="8df3981", enable=true, itemName="Event_Compose_Scan_Onlight", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanOnlight(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Onlight", "", ReportType.NORMAL, "8df3981", paramVarArgs);
  }
  
  @KvReport(checkSum="3331415", enable=true, itemName="Event_Compose_Scan_Page_Success", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanPageSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Page_Success", "", ReportType.NORMAL, "3331415", paramVarArgs);
  }
  
  @KvReport(checkSum="2b89e4b", enable=true, itemName="Event_Compose_Scan_Pdf", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanPdf(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Pdf", "", ReportType.NORMAL, "2b89e4b", paramVarArgs);
  }
  
  @KvReport(checkSum="93e0e2d", enable=true, itemName="Event_Compose_Scan_Pdf_From_HomePage_Entrance", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanPdfFromHomepageEntrance(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Pdf_From_HomePage_Entrance", "", ReportType.NORMAL, "93e0e2d", paramVarArgs);
  }
  
  @KvReport(checkSum="1fec1da", enable=true, itemName="Event_Compose_Scan_Rescan", merge=true, statKey=78503071, table=false)
  public static void eventComposeScanRescan(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Rescan", "", ReportType.NORMAL, "1fec1da", paramVarArgs);
  }
  
  @KvReport(checkSum="0e95722", enable=true, itemName="Event_Compose_Scan_Speed", merge=false, statKey=78503071, table=false)
  public static void eventComposeScanSpeed(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Speed", "", ReportType.NORMAL, "0e95722", paramVarArgs);
  }
  
  @KvReport(checkSum="5881b0b", enable=true, itemName="Event_Compose_Scan_Total", merge=false, statKey=78503071, table=false)
  public static void eventComposeScanTotal(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_Scan_Total", "", ReportType.NORMAL, "5881b0b", paramVarArgs);
  }
  
  @KvReport(checkSum="d57d871", enable=true, itemName="Event_Compose_System_File_Explorer", merge=true, statKey=78503071, table=false)
  public static void eventComposeSystemFileExplorer(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Compose_System_File_Explorer", "", ReportType.NORMAL, "d57d871", paramVarArgs);
  }
  
  @KvReport(checkSum="e7e2d18", enable=true, itemName="Event_Eml_Click_Attach_All_Save_As", merge=true, statKey=78503071, table=false)
  public static void eventEmlClickAttachAllSaveAs(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Eml_Click_Attach_All_Save_As", "", ReportType.NORMAL, "e7e2d18", paramVarArgs);
  }
  
  @KvReport(checkSum="1678b96", enable=true, itemName="Event_Eml_Click_Attach_More_Btn", merge=true, statKey=78503071, table=false)
  public static void eventEmlClickAttachMoreBtn(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Eml_Click_Attach_More_Btn", "", ReportType.NORMAL, "1678b96", paramVarArgs);
  }
  
  @KvReport(checkSum="03c778a", enable=true, itemName="Event_Eml_Click_Attach_Save_As", merge=true, statKey=78503071, table=false)
  public static void eventEmlClickAttachSaveAs(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Eml_Click_Attach_Save_As", "", ReportType.NORMAL, "03c778a", paramVarArgs);
  }
  
  @KvReport(checkSum="9bf1c73", enable=true, itemName="Event_Eml_Click_Attach_Save_To_Ftn", merge=true, statKey=78503071, table=false)
  public static void eventEmlClickAttachSaveToFtn(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Eml_Click_Attach_Save_To_Ftn", "", ReportType.NORMAL, "9bf1c73", paramVarArgs);
  }
  
  @KvReport(checkSum="a4c36ac", enable=true, itemName="Event_Eml_Click_Attach_Send_To", merge=true, statKey=78503071, table=false)
  public static void eventEmlClickAttachSendTo(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Eml_Click_Attach_Send_To", "", ReportType.NORMAL, "a4c36ac", paramVarArgs);
  }
  
  @KvReport(checkSum="22e5224", enable=true, itemName="Event_Eml_Click_Attach_Share", merge=true, statKey=78503071, table=false)
  public static void eventEmlClickAttachShare(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Eml_Click_Attach_Share", "", ReportType.NORMAL, "22e5224", paramVarArgs);
  }
  
  @KvReport(checkSum="b64e256", enable=true, itemName="Event_Eml_Click_Big_Attach", merge=true, statKey=78503071, table=false)
  public static void eventEmlClickBigAttach(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Eml_Click_Big_Attach", "", ReportType.NORMAL, "b64e256", paramVarArgs);
  }
  
  @KvReport(checkSum="fdc6c61", enable=true, itemName="Event_Eml_Click_Normal_Attach", merge=true, statKey=78503071, table=false)
  public static void eventEmlClickNormalAttach(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Eml_Click_Normal_Attach", "", ReportType.NORMAL, "fdc6c61", paramVarArgs);
  }
  
  @KvReport(checkSum="9d2e9bb", enable=true, itemName="Event_Eml_Click_Self_Del_Favourite", merge=true, statKey=78503071, table=false)
  public static void eventEmlClickSelfDelFavourite(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Eml_Click_Self_Del_Favourite", "", ReportType.NORMAL, "9d2e9bb", paramVarArgs);
  }
  
  @KvReport(checkSum="a8862fb", enable=true, itemName="Event_Eml_Click_Self_Favourite", merge=true, statKey=78503071, table=false)
  public static void eventEmlClickSelfFavourite(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Eml_Click_Self_Favourite", "", ReportType.NORMAL, "a8862fb", paramVarArgs);
  }
  
  @KvReport(checkSum="2967cb4", enable=true, itemName="Event_Eml_Click_Self_Open_Dir", merge=true, statKey=78503071, table=false)
  public static void eventEmlClickSelfOpenDir(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Eml_Click_Self_Open_Dir", "", ReportType.NORMAL, "2967cb4", paramVarArgs);
  }
  
  @KvReport(checkSum="04f6a52", enable=true, itemName="Event_Eml_Click_Self_Save_As", merge=true, statKey=78503071, table=false)
  public static void eventEmlClickSelfSaveAs(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Eml_Click_Self_Save_As", "", ReportType.NORMAL, "04f6a52", paramVarArgs);
  }
  
  @KvReport(checkSum="7dfc50b", enable=true, itemName="Event_Eml_Click_Self_Save_To_Ftn", merge=true, statKey=78503071, table=false)
  public static void eventEmlClickSelfSaveToFtn(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Eml_Click_Self_Save_To_Ftn", "", ReportType.NORMAL, "7dfc50b", paramVarArgs);
  }
  
  @KvReport(checkSum="bee28fb", enable=true, itemName="Event_Eml_Click_Self_Send_To", merge=true, statKey=78503071, table=false)
  public static void eventEmlClickSelfSendTo(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Eml_Click_Self_Send_To", "", ReportType.NORMAL, "bee28fb", paramVarArgs);
  }
  
  @KvReport(checkSum="92a2805", enable=true, itemName="Event_fingerprint_overtry", merge=true, statKey=78503071, table=false)
  public static void eventFingerprintOvertry(double... paramVarArgs)
  {
    report(true, 78503071, "Event_fingerprint_overtry", "", ReportType.NORMAL, "92a2805", paramVarArgs);
  }
  
  @KvReport(checkSum="86e62c1", enable=true, itemName="Event_Folder_Bar_Show_Mail_Box", merge=true, statKey=78503071, table=false)
  public static void eventFolderBarShowMailBox(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Folder_Bar_Show_Mail_Box", "", ReportType.NORMAL, "86e62c1", paramVarArgs);
  }
  
  @KvReport(checkSum="ea61d67", enable=true, itemName="Event_Folder_Bar_Show_Mail_Box_Click", merge=true, statKey=78503071, table=false)
  public static void eventFolderBarShowMailBoxClick(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Folder_Bar_Show_Mail_Box_Click", "", ReportType.NORMAL, "ea61d67", paramVarArgs);
  }
  
  @KvReport(checkSum="2d9fad0", enable=true, itemName="Event_Folder_Bar_Show_Set_Top", merge=true, statKey=78503071, table=false)
  public static void eventFolderBarShowSetTop(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Folder_Bar_Show_Set_Top", "", ReportType.NORMAL, "2d9fad0", paramVarArgs);
  }
  
  @KvReport(checkSum="f46d1be", enable=true, itemName="Event_Folder_Bar_Show_Set_Top_Click", merge=true, statKey=78503071, table=false)
  public static void eventFolderBarShowSetTopClick(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Folder_Bar_Show_Set_Top_Click", "", ReportType.NORMAL, "f46d1be", paramVarArgs);
  }
  
  @KvReport(checkSum="05f8e60", enable=true, itemName="Event_Folder_Swipe_Not_Show_Mail_Box", merge=true, statKey=78503071, table=false)
  public static void eventFolderSwipeNotShowMailBox(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Folder_Swipe_Not_Show_Mail_Box", "", ReportType.NORMAL, "05f8e60", paramVarArgs);
  }
  
  @KvReport(checkSum="99a59a0", enable=true, itemName="Event_Folder_Swipe_Not_Show_Mail_Box_Click", merge=true, statKey=78503071, table=false)
  public static void eventFolderSwipeNotShowMailBoxClick(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Folder_Swipe_Not_Show_Mail_Box_Click", "", ReportType.NORMAL, "99a59a0", paramVarArgs);
  }
  
  @KvReport(checkSum="2ffab57", enable=true, itemName="Event_Folder_Swipe_Show_Mail_Box", merge=true, statKey=78503071, table=false)
  public static void eventFolderSwipeShowMailBox(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Folder_Swipe_Show_Mail_Box", "", ReportType.NORMAL, "2ffab57", paramVarArgs);
  }
  
  @KvReport(checkSum="b631d15", enable=true, itemName="Event_Folder_Swipe_Show_Mail_Box_Click", merge=true, statKey=78503071, table=false)
  public static void eventFolderSwipeShowMailBoxClick(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Folder_Swipe_Show_Mail_Box_Click", "", ReportType.NORMAL, "b631d15", paramVarArgs);
  }
  
  @KvReport(checkSum="2cb3fb4", enable=true, itemName="Event_Folder_Swipe_Show_Set_Top", merge=true, statKey=78503071, table=false)
  public static void eventFolderSwipeShowSetTop(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Folder_Swipe_Show_Set_Top", "", ReportType.NORMAL, "2cb3fb4", paramVarArgs);
  }
  
  @KvReport(checkSum="9b3773e", enable=true, itemName="Event_Folder_Swipe_Show_Set_Top_Click", merge=true, statKey=78503071, table=false)
  public static void eventFolderSwipeShowSetTopClick(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Folder_Swipe_Show_Set_Top_Click", "", ReportType.NORMAL, "9b3773e", paramVarArgs);
  }
  
  @KvReport(checkSum="546bc04", enable=true, itemName="Event_Home_Page_Compose", merge=true, statKey=78503071, table=false)
  public static void eventHomePageCompose(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Home_Page_Compose", "", ReportType.NORMAL, "546bc04", paramVarArgs);
  }
  
  @KvReport(checkSum="bdca567", enable=true, itemName="Event_Home_Page_Note", merge=true, statKey=78503071, table=false)
  public static void eventHomePageNote(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Home_Page_Note", "", ReportType.NORMAL, "bdca567", paramVarArgs);
  }
  
  @KvReport(checkSum="27f4010", enable=true, itemName="Event_Java_ActiveSync_Close", merge=true, statKey=78503071, table=false)
  public static void eventJavaActivesyncClose(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Java_ActiveSync_Close", "", ReportType.NORMAL, "27f4010", paramVarArgs);
  }
  
  @KvReport(checkSum="5f213a6", enable=true, itemName="Event_Java_ActiveSync_Open", merge=true, statKey=78503071, table=false)
  public static void eventJavaActivesyncOpen(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Java_ActiveSync_Open", "", ReportType.NORMAL, "5f213a6", paramVarArgs);
  }
  
  @KvReport(checkSum="36b6a19", enable=true, itemName="Event_Java_Exchange_Close", merge=true, statKey=78503071, table=false)
  public static void eventJavaExchangeClose(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Java_Exchange_Close", "", ReportType.NORMAL, "36b6a19", paramVarArgs);
  }
  
  @KvReport(checkSum="3fce7e4", enable=true, itemName="Event_Java_Exchange_Open", merge=true, statKey=78503071, table=false)
  public static void eventJavaExchangeOpen(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Java_Exchange_Open", "", ReportType.NORMAL, "3fce7e4", paramVarArgs);
  }
  
  @KvReport(checkSum="080a796", enable=true, itemName="Event_Java_Imap_Close", merge=true, statKey=78503071, table=false)
  public static void eventJavaImapClose(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Java_Imap_Close", "", ReportType.NORMAL, "080a796", paramVarArgs);
  }
  
  @KvReport(checkSum="e2fbe03", enable=true, itemName="Event_Java_Imap_Open", merge=true, statKey=78503071, table=false)
  public static void eventJavaImapOpen(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Java_Imap_Open", "", ReportType.NORMAL, "e2fbe03", paramVarArgs);
  }
  
  @KvReport(checkSum="654e585", enable=true, itemName="Event_Java_Pop3_Close", merge=true, statKey=78503071, table=false)
  public static void eventJavaPop3Close(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Java_Pop3_Close", "", ReportType.NORMAL, "654e585", paramVarArgs);
  }
  
  @KvReport(checkSum="5d7b56f", enable=true, itemName="Event_Java_Pop3_Open", merge=true, statKey=78503071, table=false)
  public static void eventJavaPop3Open(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Java_Pop3_Open", "", ReportType.NORMAL, "5d7b56f", paramVarArgs);
  }
  
  @KvReport(checkSum="521ba59", enable=true, itemName="Event_Java_Smtp_Close", merge=true, statKey=78503071, table=false)
  public static void eventJavaSmtpClose(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Java_Smtp_Close", "", ReportType.NORMAL, "521ba59", paramVarArgs);
  }
  
  @KvReport(checkSum="6993a76", enable=true, itemName="Event_Java_Smtp_Open", merge=true, statKey=78503071, table=false)
  public static void eventJavaSmtpOpen(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Java_Smtp_Open", "", ReportType.NORMAL, "6993a76", paramVarArgs);
  }
  
  @KvReport(checkSum="4d12dbe", enable=true, itemName="Event_Login_QQ_Use_Protocol_Account", merge=true, statKey=78503071, table=false)
  public static void eventLoginQqUseProtocolAccount(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Login_QQ_Use_Protocol_Account", "", ReportType.NORMAL, "4d12dbe", paramVarArgs);
  }
  
  @KvReport(checkSum="0f94f88", enable=true, itemName="Event_Login_Recover_Number_Error_Click_Help", merge=true, statKey=78503071, table=false)
  public static void eventLoginRecoverNumberErrorClickHelp(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Login_Recover_Number_Error_Click_Help", "", ReportType.NORMAL, "0f94f88", paramVarArgs);
  }
  
  @KvReport(checkSum="843d0b3", enable=true, itemName="Event_Login_Recover_Number_Error_Dialog", merge=true, statKey=78503071, table=false)
  public static void eventLoginRecoverNumberErrorDialog(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Login_Recover_Number_Error_Dialog", "", ReportType.NORMAL, "843d0b3", paramVarArgs);
  }
  
  @KvReport(checkSum="f33be9d", enable=true, itemName="Event_Maillist_Expose", merge=true, statKey=78503071, table=false)
  public static void eventMaillistExpose(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Maillist_Expose", "", ReportType.NORMAL, "f33be9d", paramVarArgs);
  }
  
  @KvReport(checkSum="4d416b7", enable=true, itemName="Event_New_Action_Sheet_Translate_Off", merge=true, statKey=78503071, table=false)
  public static void eventNewActionSheetTranslateOff(double... paramVarArgs)
  {
    report(true, 78503071, "Event_New_Action_Sheet_Translate_Off", "", ReportType.NORMAL, "4d416b7", paramVarArgs);
  }
  
  @KvReport(checkSum="de9e26a", enable=true, itemName="Event_New_Action_Sheet_Translate_On", merge=true, statKey=78503071, table=false)
  public static void eventNewActionSheetTranslateOn(double... paramVarArgs)
  {
    report(true, 78503071, "Event_New_Action_Sheet_Translate_On", "", ReportType.NORMAL, "de9e26a", paramVarArgs);
  }
  
  @KvReport(checkSum="7fd1e3d", enable=true, itemName="Event_New_Compose_Failed_With_Attach", merge=true, statKey=78503071, table=false)
  public static void eventNewComposeFailedWithAttach(double... paramVarArgs)
  {
    report(true, 78503071, "Event_New_Compose_Failed_With_Attach", "", ReportType.NORMAL, "7fd1e3d", paramVarArgs);
  }
  
  @KvReport(checkSum="e549683", enable=true, itemName="Event_New_Compose_Success_With_Attach", merge=true, statKey=78503071, table=false)
  public static void eventNewComposeSuccessWithAttach(double... paramVarArgs)
  {
    report(true, 78503071, "Event_New_Compose_Success_With_Attach", "", ReportType.NORMAL, "e549683", paramVarArgs);
  }
  
  @KvReport(checkSum="5fc8be0", enable=true, itemName="Event_New_Wt_Login_Fail", merge=true, statKey=78503071, table=false)
  public static void eventNewWtLoginFail(double... paramVarArgs)
  {
    report(true, 78503071, "Event_New_Wt_Login_Fail", "", ReportType.NORMAL, "5fc8be0", paramVarArgs);
  }
  
  @KvReport(checkSum="ddf8342", enable=true, itemName="Event_New_Wt_Login_QQ_Back_Fail", merge=true, statKey=78503071, table=false)
  public static void eventNewWtLoginQqBackFail(double... paramVarArgs)
  {
    report(true, 78503071, "Event_New_Wt_Login_QQ_Back_Fail", "", ReportType.NORMAL, "ddf8342", paramVarArgs);
  }
  
  @KvReport(checkSum="0a1527d", enable=true, itemName="Event_New_Wt_Login_QQ_Back_Success", merge=true, statKey=78503071, table=false)
  public static void eventNewWtLoginQqBackSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "Event_New_Wt_Login_QQ_Back_Success", "", ReportType.NORMAL, "0a1527d", paramVarArgs);
  }
  
  @KvReport(checkSum="d4736fd", enable=true, itemName="Event_New_Wt_Login_Success", merge=true, statKey=78503071, table=false)
  public static void eventNewWtLoginSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "Event_New_Wt_Login_Success", "", ReportType.NORMAL, "d4736fd", paramVarArgs);
  }
  
  @KvReport(checkSum="174908f", enable=true, itemName="Event_Notification_Mark_Delete_New_Mail", merge=true, statKey=78503071, table=false)
  public static void eventNotificationMarkDeleteNewMail(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Notification_Mark_Delete_New_Mail", "", ReportType.NORMAL, "174908f", paramVarArgs);
  }
  
  @KvReport(checkSum="e045b56", enable=true, itemName="Event_Notification_Mark_Read_New_Mail", merge=true, statKey=78503071, table=false)
  public static void eventNotificationMarkReadNewMail(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Notification_Mark_Read_New_Mail", "", ReportType.NORMAL, "e045b56", paramVarArgs);
  }
  
  @KvReport(checkSum="7933567", enable=true, itemName="Event_Old_Compose_Failed_With_Attach", merge=true, statKey=78503071, table=false)
  public static void eventOldComposeFailedWithAttach(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Old_Compose_Failed_With_Attach", "", ReportType.NORMAL, "7933567", paramVarArgs);
  }
  
  @KvReport(checkSum="4e9420d", enable=true, itemName="Event_Old_Compose_Success_With_Attach", merge=true, statKey=78503071, table=false)
  public static void eventOldComposeSuccessWithAttach(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Old_Compose_Success_With_Attach", "", ReportType.NORMAL, "4e9420d", paramVarArgs);
  }
  
  @KvReport(checkSum="03cad9a", enable=true, itemName="Event_Open_File_By_X5_Core_Fail", merge=true, statKey=78503071, table=false)
  public static void eventOpenFileByX5CoreFail(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Open_File_By_X5_Core_Fail", "", ReportType.NORMAL, "03cad9a", paramVarArgs);
  }
  
  @KvReport(checkSum="8b82381", enable=true, itemName="Event_Open_File_By_X5_Core_Success", merge=true, statKey=78503071, table=false)
  public static void eventOpenFileByX5CoreSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Open_File_By_X5_Core_Success", "", ReportType.NORMAL, "8b82381", paramVarArgs);
  }
  
  @KvReport(checkSum="bc171bd", enable=true, itemName="Event_Open_File_By_X5_Sdk", merge=true, statKey=78503071, table=false)
  public static void eventOpenFileByX5Sdk(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Open_File_By_X5_Sdk", "", ReportType.NORMAL, "bc171bd", paramVarArgs);
  }
  
  @KvReport(checkSum="16dfa4c", enable=true, itemName="Event_Open_File_By_X5_Sdk_Use_QQBrowser", merge=true, statKey=78503071, table=false)
  public static void eventOpenFileByX5SdkUseQqbrowser(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Open_File_By_X5_Sdk_Use_QQBrowser", "", ReportType.NORMAL, "16dfa4c", paramVarArgs);
  }
  
  @KvReport(checkSum="bc55d7d", enable=true, itemName="Event_Open_File_By_X5_Sdk_Use_System_Core", merge=true, statKey=78503071, table=false)
  public static void eventOpenFileByX5SdkUseSystemCore(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Open_File_By_X5_Sdk_Use_System_Core", "", ReportType.NORMAL, "bc55d7d", paramVarArgs);
  }
  
  @KvReport(checkSum="49d5475", enable=true, itemName="Event_Open_Show_Push_Mail_Detail", merge=true, statKey=78503071, table=false)
  public static void eventOpenShowPushMailDetail(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Open_Show_Push_Mail_Detail", "", ReportType.NORMAL, "49d5475", paramVarArgs);
  }
  
  @KvReport(checkSum="2338761", enable=true, itemName="Event_Openin_Bigattachment_Confirm", merge=true, statKey=78503071, table=false)
  public static void eventOpeninBigattachmentConfirm(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Openin_Bigattachment_Confirm", "", ReportType.NORMAL, "2338761", paramVarArgs);
  }
  
  @KvReport(checkSum="3a4aeb9", enable=true, itemName="Event_Openin_Bigattachment_Show", merge=true, statKey=78503071, table=false)
  public static void eventOpeninBigattachmentShow(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Openin_Bigattachment_Show", "", ReportType.NORMAL, "3a4aeb9", paramVarArgs);
  }
  
  @KvReport(checkSum="067d87f", enable=true, itemName="Event_PaintPad_From_Attach_Preview", merge=true, statKey=78503071, table=false)
  public static void eventPaintpadFromAttachPreview(double... paramVarArgs)
  {
    report(true, 78503071, "Event_PaintPad_From_Attach_Preview", "", ReportType.NORMAL, "067d87f", paramVarArgs);
  }
  
  @KvReport(checkSum="595be07", enable=true, itemName="Event_PaintPad_From_ReadMail", merge=true, statKey=78503071, table=false)
  public static void eventPaintpadFromReadmail(double... paramVarArgs)
  {
    report(true, 78503071, "Event_PaintPad_From_ReadMail", "", ReportType.NORMAL, "595be07", paramVarArgs);
  }
  
  @KvReport(checkSum="155b7f9", enable=true, itemName="Event_Permission_Accept_Calendar", merge=true, statKey=78503071, table=false)
  public static void eventPermissionAcceptCalendar(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Accept_Calendar", "", ReportType.NORMAL, "155b7f9", paramVarArgs);
  }
  
  @KvReport(checkSum="a9201bf", enable=true, itemName="Event_Permission_Accept_Camera", merge=true, statKey=78503071, table=false)
  public static void eventPermissionAcceptCamera(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Accept_Camera", "", ReportType.NORMAL, "a9201bf", paramVarArgs);
  }
  
  @KvReport(checkSum="c2fa881", enable=true, itemName="Event_Permission_Accept_Contacts", merge=true, statKey=78503071, table=false)
  public static void eventPermissionAcceptContacts(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Accept_Contacts", "", ReportType.NORMAL, "c2fa881", paramVarArgs);
  }
  
  @KvReport(checkSum="b825d48", enable=true, itemName="Event_Permission_Accept_Location", merge=true, statKey=78503071, table=false)
  public static void eventPermissionAcceptLocation(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Accept_Location", "", ReportType.NORMAL, "b825d48", paramVarArgs);
  }
  
  @KvReport(checkSum="47de868", enable=true, itemName="Event_Permission_Accept_RECORD", merge=true, statKey=78503071, table=false)
  public static void eventPermissionAcceptRecord(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Accept_RECORD", "", ReportType.NORMAL, "47de868", paramVarArgs);
  }
  
  @KvReport(checkSum="f655ce8", enable=true, itemName="Event_Permission_Accept_Required_Items", merge=true, statKey=78503071, table=false)
  public static void eventPermissionAcceptRequiredItems(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Accept_Required_Items", "", ReportType.NORMAL, "f655ce8", paramVarArgs);
  }
  
  @KvReport(checkSum="77588c7", enable=true, itemName="Event_Permission_Cancel_Setting", merge=true, statKey=78503071, table=false)
  public static void eventPermissionCancelSetting(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Cancel_Setting", "", ReportType.NORMAL, "77588c7", paramVarArgs);
  }
  
  @KvReport(checkSum="c971304", enable=true, itemName="Event_Permission_Deny_Calendar", merge=true, statKey=78503071, table=false)
  public static void eventPermissionDenyCalendar(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Deny_Calendar", "", ReportType.NORMAL, "c971304", paramVarArgs);
  }
  
  @KvReport(checkSum="15cc3f9", enable=true, itemName="Event_Permission_Deny_Camera", merge=true, statKey=78503071, table=false)
  public static void eventPermissionDenyCamera(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Deny_Camera", "", ReportType.NORMAL, "15cc3f9", paramVarArgs);
  }
  
  @KvReport(checkSum="6ce338a", enable=true, itemName="Event_Permission_Deny_Contacts", merge=true, statKey=78503071, table=false)
  public static void eventPermissionDenyContacts(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Deny_Contacts", "", ReportType.NORMAL, "6ce338a", paramVarArgs);
  }
  
  @KvReport(checkSum="1e6dcf1", enable=true, itemName="Event_Permission_Deny_Location", merge=true, statKey=78503071, table=false)
  public static void eventPermissionDenyLocation(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Deny_Location", "", ReportType.NORMAL, "1e6dcf1", paramVarArgs);
  }
  
  @KvReport(checkSum="e712580", enable=true, itemName="Event_Permission_Deny_RECORD", merge=true, statKey=78503071, table=false)
  public static void eventPermissionDenyRecord(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Deny_RECORD", "", ReportType.NORMAL, "e712580", paramVarArgs);
  }
  
  @KvReport(checkSum="48c9a70", enable=true, itemName="Event_Permission_Deny_Required_Itmes", merge=true, statKey=78503071, table=false)
  public static void eventPermissionDenyRequiredItmes(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Deny_Required_Itmes", "", ReportType.NORMAL, "48c9a70", paramVarArgs);
  }
  
  @KvReport(checkSum="0573db0", enable=true, itemName="Event_Permission_Deny_Required_Sdcard", merge=true, statKey=78503071, table=false)
  public static void eventPermissionDenyRequiredSdcard(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Deny_Required_Sdcard", "", ReportType.NORMAL, "0573db0", paramVarArgs);
  }
  
  @KvReport(checkSum="a6a0362", enable=true, itemName="Event_Permission_Go_To_Setting", merge=true, statKey=78503071, table=false)
  public static void eventPermissionGoToSetting(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Go_To_Setting", "", ReportType.NORMAL, "a6a0362", paramVarArgs);
  }
  
  @KvReport(checkSum="1c371d9", enable=true, itemName="Event_Permission_Kill_App", merge=true, statKey=78503071, table=false)
  public static void eventPermissionKillApp(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Permission_Kill_App", "", ReportType.NORMAL, "1c371d9", paramVarArgs);
  }
  
  @KvReport(checkSum="4cc634c", enable=true, itemName="Event_Pulldown_Icon_Show", merge=true, statKey=78503071, table=false)
  public static void eventPulldownIconShow(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Pulldown_Icon_Show", "", ReportType.NORMAL, "4cc634c", paramVarArgs);
  }
  
  @KvReport(checkSum="165abcc", enable=true, itemName="Event_Readmail_Cancel_Mobile_Download", merge=true, statKey=78503071, table=false)
  public static void eventReadmailCancelMobileDownload(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Readmail_Cancel_Mobile_Download", "", ReportType.NORMAL, "165abcc", paramVarArgs);
  }
  
  @KvReport(checkSum="ff89f77", enable=true, itemName="Event_Readmail_Continue_Mobile_Download", merge=true, statKey=78503071, table=false)
  public static void eventReadmailContinueMobileDownload(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Readmail_Continue_Mobile_Download", "", ReportType.NORMAL, "ff89f77", paramVarArgs);
  }
  
  @KvReport(checkSum="d5bb4b8", enable=true, itemName="Event_Readmail_Show_Mobile_Download", merge=true, statKey=78503071, table=false)
  public static void eventReadmailShowMobileDownload(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Readmail_Show_Mobile_Download", "", ReportType.NORMAL, "d5bb4b8", paramVarArgs);
  }
  
  @KvReport(checkSum="5d20dbe", enable=true, itemName="Event_Reply_Forward_Subject_Use_Auto", merge=true, statKey=78503071, table=false)
  public static void eventReplyForwardSubjectUseAuto(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Reply_Forward_Subject_Use_Auto", "", ReportType.NORMAL, "5d20dbe", paramVarArgs);
  }
  
  @KvReport(checkSum="c1ad1b6", enable=true, itemName="Event_Reply_Forward_Subject_Use_Chn", merge=true, statKey=78503071, table=false)
  public static void eventReplyForwardSubjectUseChn(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Reply_Forward_Subject_Use_Chn", "", ReportType.NORMAL, "c1ad1b6", paramVarArgs);
  }
  
  @KvReport(checkSum="a6f1734", enable=true, itemName="Event_Reply_Forward_Subject_Use_Eng", merge=true, statKey=78503071, table=false)
  public static void eventReplyForwardSubjectUseEng(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Reply_Forward_Subject_Use_Eng", "", ReportType.NORMAL, "a6f1734", paramVarArgs);
  }
  
  @KvReport(checkSum="df892f5", enable=true, itemName="Event_Reply_With_Origin", merge=true, statKey=78503071, table=false)
  public static void eventReplyWithOrigin(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Reply_With_Origin", "", ReportType.NORMAL, "df892f5", paramVarArgs);
  }
  
  @KvReport(checkSum="f5b4c8e", enable=true, itemName="Event_Reply_Without_Origin", merge=true, statKey=78503071, table=false)
  public static void eventReplyWithoutOrigin(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Reply_Without_Origin", "", ReportType.NORMAL, "f5b4c8e", paramVarArgs);
  }
  
  @KvReport(checkSum="71d3153", enable=true, itemName="Event_Rich_Editor_Mail_All", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailAll(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_All", "", ReportType.NORMAL, "71d3153", paramVarArgs);
  }
  
  @KvReport(checkSum="cb1c7ce", enable=true, itemName="Event_Rich_Editor_Mail_Bold", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailBold(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Bold", "", ReportType.NORMAL, "cb1c7ce", paramVarArgs);
  }
  
  @KvReport(checkSum="300a056", enable=true, itemName="Event_Rich_Editor_Mail_Center", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailCenter(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Center", "", ReportType.NORMAL, "300a056", paramVarArgs);
  }
  
  @KvReport(checkSum="6c3cd93", enable=true, itemName="Event_Rich_Editor_Mail_Contains_Bold", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailContainsBold(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Contains_Bold", "", ReportType.NORMAL, "6c3cd93", paramVarArgs);
  }
  
  @KvReport(checkSum="c7dfef8", enable=true, itemName="Event_Rich_Editor_Mail_Contains_Center", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailContainsCenter(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Contains_Center", "", ReportType.NORMAL, "c7dfef8", paramVarArgs);
  }
  
  @KvReport(checkSum="d070bd2", enable=true, itemName="Event_Rich_Editor_Mail_Contains_List", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailContainsList(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Contains_List", "", ReportType.NORMAL, "d070bd2", paramVarArgs);
  }
  
  @KvReport(checkSum="2cfcc8a", enable=true, itemName="Event_Rich_Editor_Mail_Contains_MIDLINE", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailContainsMidline(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Contains_MIDLINE", "", ReportType.NORMAL, "2cfcc8a", paramVarArgs);
  }
  
  @KvReport(checkSum="783634e", enable=true, itemName="Event_Rich_Editor_Mail_Contains_Quote", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailContainsQuote(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Contains_Quote", "", ReportType.NORMAL, "783634e", paramVarArgs);
  }
  
  @KvReport(checkSum="1a10a5e", enable=true, itemName="Event_Rich_Editor_Mail_Contains_Title", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailContainsTitle(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Contains_Title", "", ReportType.NORMAL, "1a10a5e", paramVarArgs);
  }
  
  @KvReport(checkSum="5009a1f", enable=true, itemName="Event_Rich_Editor_Mail_Font_Color_Black", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailFontColorBlack(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Font_Color_Black", "", ReportType.NORMAL, "5009a1f", paramVarArgs);
  }
  
  @KvReport(checkSum="d1c8509", enable=true, itemName="Event_Rich_Editor_Mail_Font_Color_Blue", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailFontColorBlue(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Font_Color_Blue", "", ReportType.NORMAL, "d1c8509", paramVarArgs);
  }
  
  @KvReport(checkSum="b250dcd", enable=true, itemName="Event_Rich_Editor_Mail_Font_Color_Gray", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailFontColorGray(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Font_Color_Gray", "", ReportType.NORMAL, "b250dcd", paramVarArgs);
  }
  
  @KvReport(checkSum="f884cfb", enable=true, itemName="Event_Rich_Editor_Mail_Font_Color_RED", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailFontColorRed(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Font_Color_RED", "", ReportType.NORMAL, "f884cfb", paramVarArgs);
  }
  
  @KvReport(checkSum="367ef0a", enable=true, itemName="Event_Rich_Editor_Mail_Font_Size_Big", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailFontSizeBig(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Font_Size_Big", "", ReportType.NORMAL, "367ef0a", paramVarArgs);
  }
  
  @KvReport(checkSum="b5dfda0", enable=true, itemName="Event_Rich_Editor_Mail_Font_Size_Default", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailFontSizeDefault(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Font_Size_Default", "", ReportType.NORMAL, "b5dfda0", paramVarArgs);
  }
  
  @KvReport(checkSum="692a919", enable=true, itemName="Event_Rich_Editor_Mail_Font_Size_Small", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailFontSizeSmall(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Font_Size_Small", "", ReportType.NORMAL, "692a919", paramVarArgs);
  }
  
  @KvReport(checkSum="45d27aa", enable=true, itemName="Event_Rich_Editor_Mail_List", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailList(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_List", "", ReportType.NORMAL, "45d27aa", paramVarArgs);
  }
  
  @KvReport(checkSum="f0f9b4a", enable=true, itemName="Event_Rich_Editor_Mail_MIDLINE", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailMidline(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_MIDLINE", "", ReportType.NORMAL, "f0f9b4a", paramVarArgs);
  }
  
  @KvReport(checkSum="7b134a5", enable=true, itemName="Event_Rich_Editor_Mail_Quote", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailQuote(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Quote", "", ReportType.NORMAL, "7b134a5", paramVarArgs);
  }
  
  @KvReport(checkSum="89416f2", enable=true, itemName="Event_Rich_Editor_Mail_Title", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorMailTitle(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Mail_Title", "", ReportType.NORMAL, "89416f2", paramVarArgs);
  }
  
  @KvReport(checkSum="255d89a", enable=true, itemName="Event_Rich_Editor_Note_All", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorNoteAll(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Note_All", "", ReportType.NORMAL, "255d89a", paramVarArgs);
  }
  
  @KvReport(checkSum="144c96e", enable=true, itemName="Event_Rich_Editor_Note_Bold", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorNoteBold(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Note_Bold", "", ReportType.NORMAL, "144c96e", paramVarArgs);
  }
  
  @KvReport(checkSum="912c5a0", enable=true, itemName="Event_Rich_Editor_Note_Center", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorNoteCenter(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Note_Center", "", ReportType.NORMAL, "912c5a0", paramVarArgs);
  }
  
  @KvReport(checkSum="6934bad", enable=true, itemName="Event_Rich_Editor_Note_Font_Color_Black", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorNoteFontColorBlack(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Note_Font_Color_Black", "", ReportType.NORMAL, "6934bad", paramVarArgs);
  }
  
  @KvReport(checkSum="e20effc", enable=true, itemName="Event_Rich_Editor_Note_Font_Color_Blue", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorNoteFontColorBlue(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Note_Font_Color_Blue", "", ReportType.NORMAL, "e20effc", paramVarArgs);
  }
  
  @KvReport(checkSum="651a1d0", enable=true, itemName="Event_Rich_Editor_Note_Font_Color_Gray", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorNoteFontColorGray(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Note_Font_Color_Gray", "", ReportType.NORMAL, "651a1d0", paramVarArgs);
  }
  
  @KvReport(checkSum="be7dff8", enable=true, itemName="Event_Rich_Editor_Note_Font_Color_RED", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorNoteFontColorRed(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Note_Font_Color_RED", "", ReportType.NORMAL, "be7dff8", paramVarArgs);
  }
  
  @KvReport(checkSum="0c50019", enable=true, itemName="Event_Rich_Editor_Note_Font_Size_Big", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorNoteFontSizeBig(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Note_Font_Size_Big", "", ReportType.NORMAL, "0c50019", paramVarArgs);
  }
  
  @KvReport(checkSum="5bccf6a", enable=true, itemName="Event_Rich_Editor_Note_Font_Size_Default", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorNoteFontSizeDefault(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Note_Font_Size_Default", "", ReportType.NORMAL, "5bccf6a", paramVarArgs);
  }
  
  @KvReport(checkSum="8119648", enable=true, itemName="Event_Rich_Editor_Note_Font_Size_Small", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorNoteFontSizeSmall(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Note_Font_Size_Small", "", ReportType.NORMAL, "8119648", paramVarArgs);
  }
  
  @KvReport(checkSum="aea2385", enable=true, itemName="Event_Rich_Editor_Note_List", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorNoteList(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Note_List", "", ReportType.NORMAL, "aea2385", paramVarArgs);
  }
  
  @KvReport(checkSum="b605ab1", enable=true, itemName="Event_Rich_Editor_Note_MIDLINE", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorNoteMidline(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Note_MIDLINE", "", ReportType.NORMAL, "b605ab1", paramVarArgs);
  }
  
  @KvReport(checkSum="b0bd87c", enable=true, itemName="Event_Rich_Editor_Note_Quote", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorNoteQuote(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Note_Quote", "", ReportType.NORMAL, "b0bd87c", paramVarArgs);
  }
  
  @KvReport(checkSum="a801852", enable=true, itemName="Event_Rich_Editor_Note_Title", merge=true, statKey=78503071, table=false)
  public static void eventRichEditorNoteTitle(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Rich_Editor_Note_Title", "", ReportType.NORMAL, "a801852", paramVarArgs);
  }
  
  @KvReport(checkSum="1c04f97", enable=true, itemName="Event_Scan_Attach_Overlimit", merge=true, statKey=78503071, table=false)
  public static void eventScanAttachOverlimit(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Scan_Attach_Overlimit", "", ReportType.NORMAL, "1c04f97", paramVarArgs);
  }
  
  @KvReport(checkSum="c1aa406", enable=true, itemName="Event_Scan_Foreground_Show", merge=true, statKey=78503071, table=false)
  public static void eventScanForegroundShow(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Scan_Foreground_Show", "", ReportType.NORMAL, "c1aa406", paramVarArgs);
  }
  
  @KvReport(checkSum="64514b3", enable=true, itemName="Event_Scan_From_Home_Page", merge=true, statKey=78503071, table=false)
  public static void eventScanFromHomePage(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Scan_From_Home_Page", "", ReportType.NORMAL, "64514b3", paramVarArgs);
  }
  
  @KvReport(checkSum="5c4c0ea", enable=true, itemName="Event_Scan_Push_Click", merge=true, statKey=78503071, table=false)
  public static void eventScanPushClick(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Scan_Push_Click", "", ReportType.NORMAL, "5c4c0ea", paramVarArgs);
  }
  
  @KvReport(checkSum="ff0330d", enable=true, itemName="Event_Scan_Push_Show", merge=true, statKey=78503071, table=false)
  public static void eventScanPushShow(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Scan_Push_Show", "", ReportType.NORMAL, "ff0330d", paramVarArgs);
  }
  
  @KvReport(checkSum="c478f73", enable=true, itemName="Event_Scan_Upload_Fail", merge=true, statKey=78503071, table=false)
  public static void eventScanUploadFail(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Scan_Upload_Fail", "", ReportType.NORMAL, "c478f73", paramVarArgs);
  }
  
  @KvReport(checkSum="84d851c", enable=true, itemName="Event_Scan_Upload_Success", merge=true, statKey=78503071, table=false)
  public static void eventScanUploadSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Scan_Upload_Success", "", ReportType.NORMAL, "84d851c", paramVarArgs);
  }
  
  @KvReport(checkSum="c4edbb3", enable=true, itemName="Event_Search_History_Click", merge=true, statKey=78503071, table=false)
  public static void eventSearchHistoryClick(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Search_History_Click", "", ReportType.NORMAL, "c4edbb3", paramVarArgs);
  }
  
  @KvReport(checkSum="37c2d46", enable=true, itemName="Event_Search_History_Delete", merge=true, statKey=78503071, table=false)
  public static void eventSearchHistoryDelete(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Search_History_Delete", "", ReportType.NORMAL, "37c2d46", paramVarArgs);
  }
  
  @KvReport(checkSum="18d1620", enable=true, itemName="Event_Search_History_Finish", merge=true, statKey=78503071, table=false)
  public static void eventSearchHistoryFinish(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Search_History_Finish", "", ReportType.NORMAL, "18d1620", paramVarArgs);
  }
  
  @KvReport(checkSum="5f65dde", enable=true, itemName="Event_Search_Switch_All_New", merge=true, statKey=78503071, table=false)
  public static void eventSearchSwitchAllNew(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Search_Switch_All_New", "", ReportType.NORMAL, "5f65dde", paramVarArgs);
  }
  
  @KvReport(checkSum="e182610", enable=true, itemName="Event_Search_Switch_Receiver_New", merge=true, statKey=78503071, table=false)
  public static void eventSearchSwitchReceiverNew(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Search_Switch_Receiver_New", "", ReportType.NORMAL, "e182610", paramVarArgs);
  }
  
  @KvReport(checkSum="6cd7433", enable=true, itemName="Event_Search_Switch_Sender_New", merge=true, statKey=78503071, table=false)
  public static void eventSearchSwitchSenderNew(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Search_Switch_Sender_New", "", ReportType.NORMAL, "6cd7433", paramVarArgs);
  }
  
  @KvReport(checkSum="1ef4cd2", enable=true, itemName="Event_Search_Switch_Subject_New", merge=true, statKey=78503071, table=false)
  public static void eventSearchSwitchSubjectNew(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Search_Switch_Subject_New", "", ReportType.NORMAL, "1ef4cd2", paramVarArgs);
  }
  
  @KvReport(checkSum="00a6493", enable=true, itemName="Event_Send_Bigattachment_Confirm", merge=true, statKey=78503071, table=false)
  public static void eventSendBigattachmentConfirm(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Send_Bigattachment_Confirm", "", ReportType.NORMAL, "00a6493", paramVarArgs);
  }
  
  @KvReport(checkSum="0109f68", enable=true, itemName="Event_Send_Bigattachment_Show", merge=true, statKey=78503071, table=false)
  public static void eventSendBigattachmentShow(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Send_Bigattachment_Show", "", ReportType.NORMAL, "0109f68", paramVarArgs);
  }
  
  @KvReport(checkSum="39750f5", enable=true, itemName="Event_Send_Draft_Cancel", merge=true, statKey=78503071, table=false)
  public static void eventSendDraftCancel(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Send_Draft_Cancel", "", ReportType.NORMAL, "39750f5", paramVarArgs);
  }
  
  @KvReport(checkSum="3d70a58", enable=true, itemName="Event_Send_Mail_Need_VerifyKey", merge=true, statKey=78503071, table=false)
  public static void eventSendMailNeedVerifykey(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Send_Mail_Need_VerifyKey", "", ReportType.NORMAL, "3d70a58", paramVarArgs);
  }
  
  @KvReport(checkSum="ce8f672", enable=true, itemName="Event_Send_Mail_With_VerifyKey_Error", merge=true, statKey=78503071, table=false)
  public static void eventSendMailWithVerifykeyError(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Send_Mail_With_VerifyKey_Error", "", ReportType.NORMAL, "ce8f672", paramVarArgs);
  }
  
  @KvReport(checkSum="f2a0d2e", enable=true, itemName="Event_Send_Mail_With_VerifyKey_First_Success", merge=true, statKey=78503071, table=false)
  public static void eventSendMailWithVerifykeyFirstSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Send_Mail_With_VerifyKey_First_Success", "", ReportType.NORMAL, "f2a0d2e", paramVarArgs);
  }
  
  @KvReport(checkSum="a3dac12", enable=true, itemName="Event_Sendmail_Use_Mobile_Network", merge=true, statKey=78503071, table=false)
  public static void eventSendmailUseMobileNetwork(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Sendmail_Use_Mobile_Network", "", ReportType.NORMAL, "a3dac12", paramVarArgs);
  }
  
  @KvReport(checkSum="ed55c4b", enable=true, itemName="Event_Sendmail_Use_Wifi", merge=true, statKey=78503071, table=false)
  public static void eventSendmailUseWifi(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Sendmail_Use_Wifi", "", ReportType.NORMAL, "ed55c4b", paramVarArgs);
  }
  
  @KvReport(checkSum="c1914b1", enable=true, itemName="Event_Show_New_Mail_Notification", merge=true, statKey=78503071, table=false)
  public static void eventShowNewMailNotification(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Show_New_Mail_Notification", "", ReportType.NORMAL, "c1914b1", paramVarArgs);
  }
  
  @KvReport(checkSum="53b3bd0", enable=true, itemName="Event_Tile_Service_ComposeMail_OnAdd", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceComposemailOnadd(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_ComposeMail_OnAdd", "", ReportType.NORMAL, "53b3bd0", paramVarArgs);
  }
  
  @KvReport(checkSum="643399d", enable=true, itemName="Event_Tile_Service_ComposeMail_OnCLick", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceComposemailOnclick(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_ComposeMail_OnCLick", "", ReportType.NORMAL, "643399d", paramVarArgs);
  }
  
  @KvReport(checkSum="653aed8", enable=true, itemName="Event_Tile_Service_ComposeMail_OnRemove", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceComposemailOnremove(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_ComposeMail_OnRemove", "", ReportType.NORMAL, "653aed8", paramVarArgs);
  }
  
  @KvReport(checkSum="1cef9bb", enable=true, itemName="Event_Tile_Service_ComposeMail_OnStartListen", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceComposemailOnstartlisten(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_ComposeMail_OnStartListen", "", ReportType.NORMAL, "1cef9bb", paramVarArgs);
  }
  
  @KvReport(checkSum="8d3fc98", enable=true, itemName="Event_Tile_Service_ComposeMail_OnStopListen", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceComposemailOnstoplisten(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_ComposeMail_OnStopListen", "", ReportType.NORMAL, "8d3fc98", paramVarArgs);
  }
  
  @KvReport(checkSum="5495cea", enable=true, itemName="Event_Tile_Service_ComposeNote_OnAdd", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceComposenoteOnadd(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_ComposeNote_OnAdd", "", ReportType.NORMAL, "5495cea", paramVarArgs);
  }
  
  @KvReport(checkSum="ba8253e", enable=true, itemName="Event_Tile_Service_ComposeNote_OnCLick", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceComposenoteOnclick(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_ComposeNote_OnCLick", "", ReportType.NORMAL, "ba8253e", paramVarArgs);
  }
  
  @KvReport(checkSum="4b16702", enable=true, itemName="Event_Tile_Service_ComposeNote_OnRemove", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceComposenoteOnremove(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_ComposeNote_OnRemove", "", ReportType.NORMAL, "4b16702", paramVarArgs);
  }
  
  @KvReport(checkSum="b44ec8a", enable=true, itemName="Event_Tile_Service_ComposeNote_OnStartListen", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceComposenoteOnstartlisten(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_ComposeNote_OnStartListen", "", ReportType.NORMAL, "b44ec8a", paramVarArgs);
  }
  
  @KvReport(checkSum="60b48fa", enable=true, itemName="Event_Tile_Service_ComposeNote_OnStopListen", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceComposenoteOnstoplisten(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_ComposeNote_OnStopListen", "", ReportType.NORMAL, "60b48fa", paramVarArgs);
  }
  
  @KvReport(checkSum="8dfbb9f", enable=true, itemName="Event_Tile_Service_Ftn_OnAdd", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceFtnOnadd(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_Ftn_OnAdd", "", ReportType.NORMAL, "8dfbb9f", paramVarArgs);
  }
  
  @KvReport(checkSum="62b2d4e", enable=true, itemName="Event_Tile_Service_Ftn_OnCLick", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceFtnOnclick(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_Ftn_OnCLick", "", ReportType.NORMAL, "62b2d4e", paramVarArgs);
  }
  
  @KvReport(checkSum="0fc9b36", enable=true, itemName="Event_Tile_Service_Ftn_OnRemove", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceFtnOnremove(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_Ftn_OnRemove", "", ReportType.NORMAL, "0fc9b36", paramVarArgs);
  }
  
  @KvReport(checkSum="dca10d7", enable=true, itemName="Event_Tile_Service_Ftn_OnStartListen", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceFtnOnstartlisten(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_Ftn_OnStartListen", "", ReportType.NORMAL, "dca10d7", paramVarArgs);
  }
  
  @KvReport(checkSum="96bb613", enable=true, itemName="Event_Tile_Service_Ftn_OnStopListen", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceFtnOnstoplisten(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_Ftn_OnStopListen", "", ReportType.NORMAL, "96bb613", paramVarArgs);
  }
  
  @KvReport(checkSum="e257f01", enable=true, itemName="Event_Tile_Service_OnAdd", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceOnadd(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_OnAdd", "", ReportType.NORMAL, "e257f01", paramVarArgs);
  }
  
  @KvReport(checkSum="90894b2", enable=true, itemName="Event_Tile_Service_OnCLick", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceOnclick(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_OnCLick", "", ReportType.NORMAL, "90894b2", paramVarArgs);
  }
  
  @KvReport(checkSum="e630d23", enable=true, itemName="Event_Tile_Service_OnRemove", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceOnremove(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_OnRemove", "", ReportType.NORMAL, "e630d23", paramVarArgs);
  }
  
  @KvReport(checkSum="0facae4", enable=true, itemName="Event_Tile_Service_OnStartListen", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceOnstartlisten(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_OnStartListen", "", ReportType.NORMAL, "0facae4", paramVarArgs);
  }
  
  @KvReport(checkSum="c25f49b", enable=true, itemName="Event_Tile_Service_OnStopListen", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceOnstoplisten(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_OnStopListen", "", ReportType.NORMAL, "c25f49b", paramVarArgs);
  }
  
  @KvReport(checkSum="ff67f96", enable=true, itemName="Event_Tile_Service_Scan_OnAdd", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceScanOnadd(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_Scan_OnAdd", "", ReportType.NORMAL, "ff67f96", paramVarArgs);
  }
  
  @KvReport(checkSum="f9cbac7", enable=true, itemName="Event_Tile_Service_Scan_OnCLick", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceScanOnclick(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_Scan_OnCLick", "", ReportType.NORMAL, "f9cbac7", paramVarArgs);
  }
  
  @KvReport(checkSum="9b804f7", enable=true, itemName="Event_Tile_Service_Scan_OnRemove", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceScanOnremove(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_Scan_OnRemove", "", ReportType.NORMAL, "9b804f7", paramVarArgs);
  }
  
  @KvReport(checkSum="3e8e204", enable=true, itemName="Event_Tile_Service_Scan_OnStartListen", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceScanOnstartlisten(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_Scan_OnStartListen", "", ReportType.NORMAL, "3e8e204", paramVarArgs);
  }
  
  @KvReport(checkSum="395e5b1", enable=true, itemName="Event_Tile_Service_Scan_OnStopListen", merge=true, statKey=78503071, table=false)
  public static void eventTileServiceScanOnstoplisten(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Tile_Service_Scan_OnStopListen", "", ReportType.NORMAL, "395e5b1", paramVarArgs);
  }
  
  @KvReport(checkSum="56383fb", enable=true, itemName="Event_Toggle_Calendar_List", merge=true, statKey=78503071, table=false)
  public static void eventToggleCalendarList(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Toggle_Calendar_List", "", ReportType.NORMAL, "56383fb", paramVarArgs);
  }
  
  @KvReport(checkSum="276b879", enable=true, itemName="Event_Upload_File_Use_Mobile_Network", merge=true, statKey=78503071, table=false)
  public static void eventUploadFileUseMobileNetwork(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Upload_File_Use_Mobile_Network", "", ReportType.NORMAL, "276b879", paramVarArgs);
  }
  
  @KvReport(checkSum="1590fc0", enable=true, itemName="Event_Upload_File_Use_Wifi", merge=true, statKey=78503071, table=false)
  public static void eventUploadFileUseWifi(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Upload_File_Use_Wifi", "", ReportType.NORMAL, "1590fc0", paramVarArgs);
  }
  
  @KvReport(checkSum="5a65579", enable=true, itemName="Event_Web_Scanner_Over_Size", merge=true, statKey=78503071, table=false)
  public static void eventWebScannerOverSize(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Web_Scanner_Over_Size", "", ReportType.NORMAL, "5a65579", paramVarArgs);
  }
  
  @KvReport(checkSum="754ffda", enable=true, itemName="Event_Widget_click", merge=true, statKey=78503071, table=false)
  public static void eventWidgetClick(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Widget_click", "", ReportType.NORMAL, "754ffda", paramVarArgs);
  }
  
  @KvReport(checkSum="ec623d1", enable=true, itemName="Event_Widget_disable", merge=true, statKey=78503071, table=false)
  public static void eventWidgetDisable(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Widget_disable", "", ReportType.NORMAL, "ec623d1", paramVarArgs);
  }
  
  @KvReport(checkSum="915df26", enable=true, itemName="Event_Widget_enable", merge=true, statKey=78503071, table=false)
  public static void eventWidgetEnable(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Widget_enable", "", ReportType.NORMAL, "915df26", paramVarArgs);
  }
  
  @KvReport(checkSum="3640c75", enable=true, itemName="Event_Widget_update", merge=true, statKey=78503071, table=false)
  public static void eventWidgetUpdate(double... paramVarArgs)
  {
    report(true, 78503071, "Event_Widget_update", "", ReportType.NORMAL, "3640c75", paramVarArgs);
  }
  
  @KvReport(checkSum="b27100a", enable=true, itemName="Event_X5_Core_Init_Fail", merge=true, statKey=78503071, table=false)
  public static void eventX5CoreInitFail(double... paramVarArgs)
  {
    report(true, 78503071, "Event_X5_Core_Init_Fail", "", ReportType.NORMAL, "b27100a", paramVarArgs);
  }
  
  @KvReport(checkSum="06370b7", enable=true, itemName="Event_X5_Core_Reset", merge=true, statKey=78503071, table=false)
  public static void eventX5CoreReset(double... paramVarArgs)
  {
    report(true, 78503071, "Event_X5_Core_Reset", "", ReportType.NORMAL, "06370b7", paramVarArgs);
  }
  
  @KvReport(checkSum="e12fdca", enable=true, itemName="EXTERNAL_SHARE", merge=false, statKey=78503071, table=false)
  public static void externalShare(double... paramVarArgs)
  {
    report(true, 78503071, "EXTERNAL_SHARE", "", ReportType.NORMAL, "e12fdca", paramVarArgs);
  }
  
  @KvReport(checkSum="a4fb4a8", enable=true, itemName="EXTERNAL_SHARE_COMPOSE_MAIL", merge=false, statKey=78503071, table=false)
  public static void externalShareComposeMail(double... paramVarArgs)
  {
    report(true, 78503071, "EXTERNAL_SHARE_COMPOSE_MAIL", "", ReportType.NORMAL, "a4fb4a8", paramVarArgs);
  }
  
  @KvReport(checkSum="002d99b", enable=true, itemName="EXTERNAL_SHARE_COMPOSE_MAIL_FROM_QQ", merge=false, statKey=78503071, table=false)
  public static void externalShareComposeMailFromQq(double... paramVarArgs)
  {
    report(true, 78503071, "EXTERNAL_SHARE_COMPOSE_MAIL_FROM_QQ", "", ReportType.NORMAL, "002d99b", paramVarArgs);
  }
  
  @KvReport(checkSum="c9d679b", enable=true, itemName="EXTERNAL_SHARE_COMPOSE_MAIL_FROM_WECHAT", merge=false, statKey=78503071, table=false)
  public static void externalShareComposeMailFromWechat(double... paramVarArgs)
  {
    report(true, 78503071, "EXTERNAL_SHARE_COMPOSE_MAIL_FROM_WECHAT", "", ReportType.NORMAL, "c9d679b", paramVarArgs);
  }
  
  @KvReport(checkSum="a5f52ba", enable=true, itemName="EXTERNAL_SHARE_COMPOSE_NOTE", merge=false, statKey=78503071, table=false)
  public static void externalShareComposeNote(double... paramVarArgs)
  {
    report(true, 78503071, "EXTERNAL_SHARE_COMPOSE_NOTE", "", ReportType.NORMAL, "a5f52ba", paramVarArgs);
  }
  
  @KvReport(checkSum="4a830a8", enable=true, itemName="EXTERNAL_SHARE_FROM_VIEW_OR_EDIT_ACTION", merge=false, statKey=78503071, table=false)
  public static void externalShareFromViewOrEditAction(double... paramVarArgs)
  {
    report(true, 78503071, "EXTERNAL_SHARE_FROM_VIEW_OR_EDIT_ACTION", "", ReportType.NORMAL, "4a830a8", paramVarArgs);
  }
  
  @KvReport(checkSum="13be2d7", enable=true, itemName="EXTERNAL_SHARE_FTN", merge=false, statKey=78503071, table=false)
  public static void externalShareFtn(double... paramVarArgs)
  {
    report(true, 78503071, "EXTERNAL_SHARE_FTN", "", ReportType.NORMAL, "13be2d7", paramVarArgs);
  }
  
  @KvReport(checkSum="9709aeb", enable=true, itemName="EXTERNAL_SHARE_FTN_FROM_QQ", merge=false, statKey=78503071, table=false)
  public static void externalShareFtnFromQq(double... paramVarArgs)
  {
    report(true, 78503071, "EXTERNAL_SHARE_FTN_FROM_QQ", "", ReportType.NORMAL, "9709aeb", paramVarArgs);
  }
  
  @KvReport(checkSum="58e673f", enable=true, itemName="EXTERNAL_SHARE_FTN_FROM_WECHAT", merge=false, statKey=78503071, table=false)
  public static void externalShareFtnFromWechat(double... paramVarArgs)
  {
    report(true, 78503071, "EXTERNAL_SHARE_FTN_FROM_WECHAT", "", ReportType.NORMAL, "58e673f", paramVarArgs);
  }
  
  @KvReport(checkSum="8ea55bb", enable=true, itemName="first_time_native_crash_by_app", merge=true, statKey=78503071, table=false)
  public static void firstTimeNativeCrashByApp(double... paramVarArgs)
  {
    report(true, 78503071, "first_time_native_crash_by_app", "", ReportType.IMMEDIATELY_FILED, "8ea55bb", paramVarArgs);
  }
  
  @KvReport(checkSum="9ba0386", enable=true, itemName="Ftn_Response_Error", merge=true, statKey=78503071, table=false)
  public static void ftnResponseError(double... paramVarArgs)
  {
    report(true, 78503071, "Ftn_Response_Error", "", ReportType.NORMAL, "9ba0386", paramVarArgs);
  }
  
  @KvReport(checkSum="7e5c143", enable=true, itemName="Gmail_Access_Token_Null", merge=true, statKey=78503071, table=false)
  public static void gmailAccessTokenNull(double... paramVarArgs)
  {
    report(true, 78503071, "Gmail_Access_Token_Null", "", ReportType.NORMAL, "7e5c143", paramVarArgs);
  }
  
  @KvReport(checkSum="bb494bf", enable=true, itemName="Gmail_Refresh_Token_Null", merge=true, statKey=78503071, table=false)
  public static void gmailRefreshTokenNull(double... paramVarArgs)
  {
    report(true, 78503071, "Gmail_Refresh_Token_Null", "", ReportType.NORMAL, "bb494bf", paramVarArgs);
  }
  
  @KvReport(checkSum="59273cb", enable=true, itemName="click_go_setting", merge=true, statKey=78503071, table=false)
  public static void guideClickGoSetting(double... paramVarArgs)
  {
    report(true, 78503071, "click_go_setting", "", ReportType.NORMAL, "59273cb", paramVarArgs);
  }
  
  @KvReport(checkSum="3c33fba", enable=true, itemName="click_ignore", merge=true, statKey=78503071, table=false)
  public static void guideClickIgnore(double... paramVarArgs)
  {
    report(true, 78503071, "click_ignore", "", ReportType.NORMAL, "3c33fba", paramVarArgs);
  }
  
  @KvReport(checkSum="92df16a", enable=true, itemName="click_no_show", merge=true, statKey=78503071, table=false)
  public static void guideClickNoShow(double... paramVarArgs)
  {
    report(true, 78503071, "click_no_show", "", ReportType.NORMAL, "92df16a", paramVarArgs);
  }
  
  @KvReport(checkSum="c08cb5f", enable=true, itemName="click_ok", merge=true, statKey=78503071, table=false)
  public static void guideClickOk(double... paramVarArgs)
  {
    report(true, 78503071, "click_ok", "", ReportType.NORMAL, "c08cb5f", paramVarArgs);
  }
  
  @KvReport(checkSum="dc30c19", enable=true, itemName="click_on_sync", merge=true, statKey=78503071, table=false)
  public static void guideClickOnSync(double... paramVarArgs)
  {
    report(true, 78503071, "click_on_sync", "", ReportType.NORMAL, "dc30c19", paramVarArgs);
  }
  
  @KvReport(checkSum="133d925", enable=true, itemName="less_scheduled_job", merge=true, statKey=78503071, table=false)
  public static void guideLessScheduledJob(double... paramVarArgs)
  {
    report(true, 78503071, "less_scheduled_job", "", ReportType.NORMAL, "133d925", paramVarArgs);
  }
  
  @KvReport(checkSum="7a0c146", enable=true, itemName="show_reason_add_account", merge=true, statKey=78503071, table=false)
  public static void guideShowReasonAddAccount(double... paramVarArgs)
  {
    report(true, 78503071, "show_reason_add_account", "", ReportType.NORMAL, "7a0c146", paramVarArgs);
  }
  
  @KvReport(checkSum="dfde0ec", enable=true, itemName="show_reason_delay", merge=true, statKey=78503071, table=false)
  public static void guideShowReasonDelay(double... paramVarArgs)
  {
    report(true, 78503071, "show_reason_delay", "", ReportType.NORMAL, "dfde0ec", paramVarArgs);
  }
  
  @KvReport(checkSum="430f30b", enable=true, itemName="show_reason_exist_short_time", merge=true, statKey=78503071, table=false)
  public static void guideShowReasonExistShortTime(double... paramVarArgs)
  {
    report(true, 78503071, "show_reason_exist_short_time", "", ReportType.NORMAL, "430f30b", paramVarArgs);
  }
  
  @KvReport(checkSum="2e5e784", enable=true, itemName="hotfix_crash_revert", merge=true, statKey=78503071, table=false)
  public static void hotfixCrashRevert(double... paramVarArgs)
  {
    report(true, 78503071, "hotfix_crash_revert", "", ReportType.IMMEDIATELY_FILED, "2e5e784", paramVarArgs);
  }
  
  @KvReport(checkSum="d72a569", enable=true, itemName="hotfix_download_failed_invalid_md5", merge=true, statKey=78503071, table=false)
  public static void hotfixDownloadFailedInvalidMd5(double... paramVarArgs)
  {
    report(true, 78503071, "hotfix_download_failed_invalid_md5", "", ReportType.NORMAL, "d72a569", paramVarArgs);
  }
  
  @KvReport(checkSum="612604f", enable=true, itemName="hotfix_download_failed_invalid_size", merge=true, statKey=78503071, table=false)
  public static void hotfixDownloadFailedInvalidSize(double... paramVarArgs)
  {
    report(true, 78503071, "hotfix_download_failed_invalid_size", "", ReportType.NORMAL, "612604f", paramVarArgs);
  }
  
  @KvReport(checkSum="1caecf0", enable=true, itemName="hotfix_res_check_failed", merge=true, statKey=78503071, table=false)
  public static void hotfixResCheckFailed(double... paramVarArgs)
  {
    report(true, 78503071, "hotfix_res_check_failed", "", ReportType.NORMAL, "1caecf0", paramVarArgs);
  }
  
  @KvReport(checkSum="a8d154b", enable=true, itemName="connect_fail", merge=true, statKey=78503071, table=false)
  public static void httpConnectFail(double... paramVarArgs)
  {
    report(true, 78503071, "connect_fail", "", ReportType.NORMAL, "a8d154b", paramVarArgs);
  }
  
  @KvReport(checkSum="246b2b7", enable=true, itemName="connect_success", merge=true, statKey=78503071, table=false)
  public static void httpConnectSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "connect_success", "", ReportType.NORMAL, "246b2b7", paramVarArgs);
  }
  
  @KvReport(checkSum="75df91b", enable=true, itemName="post_fail", merge=true, statKey=78503071, table=false)
  public static void httpPostFail(double... paramVarArgs)
  {
    report(true, 78503071, "post_fail", "", ReportType.NORMAL, "75df91b", paramVarArgs);
  }
  
  @KvReport(checkSum="fee0fe3", enable=true, itemName="post_success", merge=true, statKey=78503071, table=false)
  public static void httpPostSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "post_success", "", ReportType.NORMAL, "fee0fe3", paramVarArgs);
  }
  
  @KvReport(checkSum="aefd715", enable=true, itemName="read_fail", merge=true, statKey=78503071, table=false)
  public static void httpReadFail(double... paramVarArgs)
  {
    report(true, 78503071, "read_fail", "", ReportType.NORMAL, "aefd715", paramVarArgs);
  }
  
  @KvReport(checkSum="0b5bf96", enable=true, itemName="read_success", merge=true, statKey=78503071, table=false)
  public static void httpReadSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "read_success", "", ReportType.NORMAL, "0b5bf96", paramVarArgs);
  }
  
  @KvReport(checkSum="0bbb04d", enable=true, itemName="response_fail", merge=true, statKey=78503071, table=false)
  public static void httpResponseFail(double... paramVarArgs)
  {
    report(true, 78503071, "response_fail", "", ReportType.NORMAL, "0bbb04d", paramVarArgs);
  }
  
  @KvReport(checkSum="50e7cf0", enable=true, itemName="response_success", merge=true, statKey=78503071, table=false)
  public static void httpResponseSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "response_success", "", ReportType.NORMAL, "50e7cf0", paramVarArgs);
  }
  
  @KvReport(checkSum="f5ba1db", enable=true, itemName="hwpush_click_no_arrived", merge=true, statKey=78503071, table=false)
  public static void hwpushClickNoArrived(double... paramVarArgs)
  {
    report(true, 78503071, "hwpush_click_no_arrived", "", ReportType.NORMAL, "f5ba1db", paramVarArgs);
  }
  
  @KvReport(checkSum="3659d5f", enable=true, itemName="hwpush_error", merge=true, statKey=78503071, table=false)
  public static void hwpushError(String paramString, double... paramVarArgs)
  {
    report(true, 78503071, "hwpush_error", paramString, ReportType.NORMAL, "3659d5f", paramVarArgs);
  }
  
  @KvReport(checkSum="602b936", enable=true, itemName="hwpush_notification_arrived", merge=true, statKey=78503071, table=false)
  public static void hwpushNotificationArrived(double... paramVarArgs)
  {
    report(true, 78503071, "hwpush_notification_arrived", "", ReportType.NORMAL, "602b936", paramVarArgs);
  }
  
  @KvReport(checkSum="3dfd732", enable=true, itemName="hwpush_notification_clicked", merge=true, statKey=78503071, table=false)
  public static void hwpushNotificationClicked(double... paramVarArgs)
  {
    report(true, 78503071, "hwpush_notification_clicked", "", ReportType.NORMAL, "3dfd732", paramVarArgs);
  }
  
  @KvReport(checkSum="6bbeab7", enable=true, itemName="hwpush_passthrough", merge=true, statKey=78503071, table=false)
  public static void hwpushPassthrough(double... paramVarArgs)
  {
    report(true, 78503071, "hwpush_passthrough", "", ReportType.NORMAL, "6bbeab7", paramVarArgs);
  }
  
  @KvReport(checkSum="5cb6382", enable=true, itemName="hwpush_register", merge=true, statKey=78503071, table=false)
  public static void hwpushRegister(double... paramVarArgs)
  {
    report(true, 78503071, "hwpush_register", "", ReportType.NORMAL, "5cb6382", paramVarArgs);
  }
  
  @KvReport(checkSum="4ea732c", enable=true, itemName="hwpush_resolved_error", merge=true, statKey=78503071, table=false)
  public static void hwpushResolvedError(double... paramVarArgs)
  {
    report(true, 78503071, "hwpush_resolved_error", "", ReportType.NORMAL, "4ea732c", paramVarArgs);
  }
  
  @KvReport(checkSum="2caf959", enable=true, itemName="Image_Scan_Open_After_Install_Plugin", merge=false, statKey=78503071, table=false)
  public static void imageScanOpenAfterInstallPlugin(double... paramVarArgs)
  {
    report(true, 78503071, "Image_Scan_Open_After_Install_Plugin", "", ReportType.NORMAL, "2caf959", paramVarArgs);
  }
  
  @KvReport(checkSum="cd4e44e", enable=true, itemName="Image_Scan_Plugin_Download_Fail", merge=false, statKey=78503071, table=false)
  public static void imageScanPluginDownloadFail(double... paramVarArgs)
  {
    report(true, 78503071, "Image_Scan_Plugin_Download_Fail", "", ReportType.NORMAL, "cd4e44e", paramVarArgs);
  }
  
  @KvReport(checkSum="09d4747", enable=true, itemName="Image_Scan_Plugin_Download_Success", merge=false, statKey=78503071, table=false)
  public static void imageScanPluginDownloadSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "Image_Scan_Plugin_Download_Success", "", ReportType.NORMAL, "09d4747", paramVarArgs);
  }
  
  @KvReport(checkSum="072b10f", enable=true, itemName="Image_Scan_Plugin_Download_Verify_Fail", merge=false, statKey=78503071, table=false)
  public static void imageScanPluginDownloadVerifyFail(double... paramVarArgs)
  {
    report(true, 78503071, "Image_Scan_Plugin_Download_Verify_Fail", "", ReportType.NORMAL, "072b10f", paramVarArgs);
  }
  
  @KvReport(checkSum="6de52a4", enable=true, itemName="invalid_signature", merge=true, statKey=78503071, table=false)
  public static void invalidSignature(double... paramVarArgs)
  {
    report(true, 78503071, "invalid_signature", "", ReportType.IMMEDIATELY_UPLOAD, "6de52a4", paramVarArgs);
  }
  
  @KvReport(checkSum="7fa251e", enable=true, itemName="invisible_activity_exist_time", merge=true, statKey=78503071, table=false)
  public static void invisibleActivityExistTime(double... paramVarArgs)
  {
    report(true, 78503071, "invisible_activity_exist_time", "", ReportType.NORMAL, "7fa251e", paramVarArgs);
  }
  
  @KvReport(checkSum="0c57b98", enable=true, itemName="java_crash_by_app", merge=true, statKey=78503071, table=false)
  public static void javaCrashByApp(double... paramVarArgs)
  {
    report(true, 78503071, "java_crash_by_app", "", ReportType.IMMEDIATELY_FILED, "0c57b98", paramVarArgs);
  }
  
  @KvReport(checkSum="eda4f2f", enable=true, itemName="java_crash_by_rdm", merge=true, statKey=78503071, table=false)
  public static void javaCrashByRdm(double... paramVarArgs)
  {
    report(true, 78503071, "java_crash_by_rdm", "", ReportType.IMMEDIATELY_FILED, "eda4f2f", paramVarArgs);
  }
  
  @KvReport(checkSum="81a3bc0", enable=true, itemName="job_scheduler", merge=true, statKey=78503071, table=false)
  public static void jobScheduler(double... paramVarArgs)
  {
    report(true, 78503071, "job_scheduler", "", ReportType.NORMAL, "81a3bc0", paramVarArgs);
  }
  
  @KvReport(checkSum="00a4162", enable=true, itemName="kvlog_upload_meet", merge=true, statKey=78503071, table=false)
  public static void kvlogUploadMeet(double... paramVarArgs)
  {
    report(true, 78503071, "kvlog_upload_meet", "", ReportType.NORMAL, "00a4162", paramVarArgs);
  }
  
  @KvReport(checkSum="101a057", enable=true, itemName="kvlog_upload_no_meet", merge=true, statKey=78503071, table=false)
  public static void kvlogUploadNoMeet(double... paramVarArgs)
  {
    report(true, 78503071, "kvlog_upload_no_meet", "", ReportType.NORMAL, "101a057", paramVarArgs);
  }
  
  @KvReport(checkSum="47ec608", enable=true, itemName="Login_With_Detect_Provider_Error", merge=true, statKey=78503071, table=false)
  public static void loginWithDetectProviderError(double... paramVarArgs)
  {
    report(true, 78503071, "Login_With_Detect_Provider_Error", "", ReportType.NORMAL, "47ec608", paramVarArgs);
  }
  
  @KvReport(checkSum="f20bcc0", enable=true, itemName="Login_With_Detect_Provider_Success", merge=true, statKey=78503071, table=false)
  public static void loginWithDetectProviderSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "Login_With_Detect_Provider_Success", "", ReportType.NORMAL, "f20bcc0", paramVarArgs);
  }
  
  @KvReport(checkSum="ef0e4e1", enable=true, itemName="Mail_Appear_Time", merge=false, statKey=78503071, table=false)
  public static void mailAppearTime(double... paramVarArgs)
  {
    report(true, 78503071, "Mail_Appear_Time", "", ReportType.NORMAL, "ef0e4e1", paramVarArgs);
  }
  
  @KvReport(checkSum="550826c", enable=true, itemName="mail_delay", merge=true, statKey=78503071, table=false)
  public static void mailDelay(double... paramVarArgs)
  {
    report(true, 78503071, "mail_delay", "", ReportType.NORMAL, "550826c", paramVarArgs);
  }
  
  @KvReport(checkSum="77f0f4a", enable=true, itemName="master_sync_off", merge=true, statKey=78503071, table=false)
  public static void masterSyncOff(double... paramVarArgs)
  {
    report(true, 78503071, "master_sync_off", "", ReportType.NORMAL, "77f0f4a", paramVarArgs);
  }
  
  @KvReport(checkSum="20cd8a0", enable=true, itemName="master_sync_on", merge=true, statKey=78503071, table=false)
  public static void masterSyncOn(double... paramVarArgs)
  {
    report(true, 78503071, "master_sync_on", "", ReportType.NORMAL, "20cd8a0", paramVarArgs);
  }
  
  @KvReport(checkSum="3d25259", enable=true, itemName="click_no_arrived", merge=true, statKey=78503071, table=false)
  public static void mipushClickNoArrived(double... paramVarArgs)
  {
    report(true, 78503071, "click_no_arrived", "", ReportType.NORMAL, "3d25259", paramVarArgs);
  }
  
  @KvReport(checkSum="8d0f488", enable=true, itemName="notification_arrived", merge=true, statKey=78503071, table=false)
  public static void mipushNotificationArrived(double... paramVarArgs)
  {
    report(true, 78503071, "notification_arrived", "", ReportType.NORMAL, "8d0f488", paramVarArgs);
  }
  
  @KvReport(checkSum="e488a32", enable=true, itemName="notification_clicked", merge=true, statKey=78503071, table=false)
  public static void mipushNotificationClicked(double... paramVarArgs)
  {
    report(true, 78503071, "notification_clicked", "", ReportType.NORMAL, "e488a32", paramVarArgs);
  }
  
  @KvReport(checkSum="ee240e4", enable=true, itemName="passthrough", merge=true, statKey=78503071, table=false)
  public static void mipushPassthrough(double... paramVarArgs)
  {
    report(true, 78503071, "passthrough", "", ReportType.NORMAL, "ee240e4", paramVarArgs);
  }
  
  @KvReport(checkSum="922a2ca", enable=true, itemName="register", merge=true, statKey=78503071, table=false)
  public static void mipushRegister(double... paramVarArgs)
  {
    report(true, 78503071, "register", "", ReportType.NORMAL, "922a2ca", paramVarArgs);
  }
  
  @KvReport(checkSum="e951cb7", enable=true, itemName="mobile_sync_b", merge=true, statKey=78503071, table=false)
  public static void mobileSyncB(double... paramVarArgs)
  {
    report(true, 78503071, "mobile_sync_b", "", ReportType.NORMAL, "e951cb7", paramVarArgs);
  }
  
  @KvReport(checkSum="bbadd75", enable=true, itemName="mobile_sync_f", merge=true, statKey=78503071, table=false)
  public static void mobileSyncF(double... paramVarArgs)
  {
    report(true, 78503071, "mobile_sync_f", "", ReportType.NORMAL, "bbadd75", paramVarArgs);
  }
  
  @KvReport(checkSum="b7a5ed4", enable=true, itemName="NATIVE_ADS_PARSE_XML_FAIL", merge=true, statKey=78503071, table=false)
  public static void nativeAdsParseXmlFail(double... paramVarArgs)
  {
    report(true, 78503071, "NATIVE_ADS_PARSE_XML_FAIL", "", ReportType.NORMAL, "b7a5ed4", paramVarArgs);
  }
  
  @KvReport(checkSum="2bc4d21", enable=true, itemName="native_crash_by_rdm", merge=true, statKey=78503071, table=false)
  public static void nativeCrashByRdm(double... paramVarArgs)
  {
    report(true, 78503071, "native_crash_by_rdm", "", ReportType.IMMEDIATELY_FILED, "2bc4d21", paramVarArgs);
  }
  
  @KvReport(checkSum="1793e26", enable=true, itemName="no_notification_permission", merge=true, statKey=78503071, table=false)
  public static void noNotificationPermission(double... paramVarArgs)
  {
    report(true, 78503071, "no_notification_permission", "", ReportType.NORMAL, "1793e26", paramVarArgs);
  }
  
  @KvReport(checkSum="e17bf52", enable=true, itemName="notification_guide_click_go_setting", merge=true, statKey=78503071, table=false)
  public static void notificationGuideClickGoSetting(double... paramVarArgs)
  {
    report(true, 78503071, "notification_guide_click_go_setting", "", ReportType.NORMAL, "e17bf52", paramVarArgs);
  }
  
  @KvReport(checkSum="b2bb3ef", enable=true, itemName="notification_guide_click_ignore", merge=true, statKey=78503071, table=false)
  public static void notificationGuideClickIgnore(double... paramVarArgs)
  {
    report(true, 78503071, "notification_guide_click_ignore", "", ReportType.NORMAL, "b2bb3ef", paramVarArgs);
  }
  
  @KvReport(checkSum="321958d", enable=true, itemName="notification_guide_click_no_show", merge=true, statKey=78503071, table=false)
  public static void notificationGuideClickNoShow(double... paramVarArgs)
  {
    report(true, 78503071, "notification_guide_click_no_show", "", ReportType.NORMAL, "321958d", paramVarArgs);
  }
  
  @KvReport(checkSum="3c28a28", enable=true, itemName="NOTIFICATION_PANEL_CALENDAR", merge=false, statKey=78503071, table=false)
  public static void notificationPanelCalendar(double... paramVarArgs)
  {
    report(true, 78503071, "NOTIFICATION_PANEL_CALENDAR", "", ReportType.NORMAL, "3c28a28", paramVarArgs);
  }
  
  @KvReport(checkSum="228d1e8", enable=true, itemName="NOTIFICATION_PANEL_CLOSE", merge=false, statKey=78503071, table=false)
  public static void notificationPanelClose(double... paramVarArgs)
  {
    report(true, 78503071, "NOTIFICATION_PANEL_CLOSE", "", ReportType.NORMAL, "228d1e8", paramVarArgs);
  }
  
  @KvReport(checkSum="1af4b3d", enable=true, itemName="NOTIFICATION_PANEL_COMPOSE_MAIL", merge=false, statKey=78503071, table=false)
  public static void notificationPanelComposeMail(double... paramVarArgs)
  {
    report(true, 78503071, "NOTIFICATION_PANEL_COMPOSE_MAIL", "", ReportType.NORMAL, "1af4b3d", paramVarArgs);
  }
  
  @KvReport(checkSum="21c004a", enable=true, itemName="NOTIFICATION_PANEL_COMPOSE_NOTE", merge=false, statKey=78503071, table=false)
  public static void notificationPanelComposeNote(double... paramVarArgs)
  {
    report(true, 78503071, "NOTIFICATION_PANEL_COMPOSE_NOTE", "", ReportType.NORMAL, "21c004a", paramVarArgs);
  }
  
  @KvReport(checkSum="34077d0", enable=true, itemName="NOTIFICATION_PANEL_OPEN", merge=false, statKey=78503071, table=false)
  public static void notificationPanelOpen(double... paramVarArgs)
  {
    report(true, 78503071, "NOTIFICATION_PANEL_OPEN", "", ReportType.NORMAL, "34077d0", paramVarArgs);
  }
  
  @KvReport(checkSum="0a43f83", enable=true, itemName="NOTIFICATION_PANEL_POP_GUIDE", merge=false, statKey=78503071, table=false)
  public static void notificationPanelPopGuide(double... paramVarArgs)
  {
    report(true, 78503071, "NOTIFICATION_PANEL_POP_GUIDE", "", ReportType.NORMAL, "0a43f83", paramVarArgs);
  }
  
  @KvReport(checkSum="4e99851", enable=true, itemName="NOTIFICATION_PANEL_POP_GUIDE_CANCEL", merge=false, statKey=78503071, table=false)
  public static void notificationPanelPopGuideCancel(double... paramVarArgs)
  {
    report(true, 78503071, "NOTIFICATION_PANEL_POP_GUIDE_CANCEL", "", ReportType.NORMAL, "4e99851", paramVarArgs);
  }
  
  @KvReport(checkSum="633aa18", enable=true, itemName="NOTIFICATION_PANEL_POP_GUIDE_CLICK_OK_WITHOUT_PERMISSION", merge=false, statKey=78503071, table=false)
  public static void notificationPanelPopGuideClickOkWithoutPermission(double... paramVarArgs)
  {
    report(true, 78503071, "NOTIFICATION_PANEL_POP_GUIDE_CLICK_OK_WITHOUT_PERMISSION", "", ReportType.NORMAL, "633aa18", paramVarArgs);
  }
  
  @KvReport(checkSum="d580ec7", enable=true, itemName="NOTIFICATION_PANEL_POP_GUIDE_OK", merge=false, statKey=78503071, table=false)
  public static void notificationPanelPopGuideOk(double... paramVarArgs)
  {
    report(true, 78503071, "NOTIFICATION_PANEL_POP_GUIDE_OK", "", ReportType.NORMAL, "d580ec7", paramVarArgs);
  }
  
  @KvReport(checkSum="a09b0d6", enable=true, itemName="NOTIFICATION_PANEL_POP_PERMISSION", merge=false, statKey=78503071, table=false)
  public static void notificationPanelPopPermission(double... paramVarArgs)
  {
    report(true, 78503071, "NOTIFICATION_PANEL_POP_PERMISSION", "", ReportType.NORMAL, "a09b0d6", paramVarArgs);
  }
  
  @KvReport(checkSum="058497c", enable=true, itemName="NOTIFICATION_PANEL_SCAN", merge=false, statKey=78503071, table=false)
  public static void notificationPanelScan(double... paramVarArgs)
  {
    report(true, 78503071, "NOTIFICATION_PANEL_SCAN", "", ReportType.NORMAL, "058497c", paramVarArgs);
  }
  
  @KvReport(checkSum="1f90d01", enable=true, itemName="NOTIFICATION_PANEL_SETTING", merge=false, statKey=78503071, table=false)
  public static void notificationPanelSetting(double... paramVarArgs)
  {
    report(true, 78503071, "NOTIFICATION_PANEL_SETTING", "", ReportType.NORMAL, "1f90d01", paramVarArgs);
  }
  
  @KvReport(checkSum="b1e5fc0", enable=true, itemName="notify_login_invalid", merge=true, statKey=78503071, table=false)
  public static void notifyLoginInvalid(double... paramVarArgs)
  {
    report(true, 78503071, "notify_login_invalid", "", ReportType.NORMAL, "b1e5fc0", paramVarArgs);
  }
  
  @KvReport(checkSum="a33c874", enable=true, itemName="notify_mail", merge=true, statKey=78503071, table=false)
  public static void notifyMail(double... paramVarArgs)
  {
    report(true, 78503071, "notify_mail", "", ReportType.NORMAL, "a33c874", paramVarArgs);
  }
  
  @KvReport(checkSum="c29fdbd", enable=true, itemName="previous_install", merge=true, statKey=78503071, table=false)
  public static void previousInstall(double... paramVarArgs)
  {
    report(true, 78503071, "previous_install", "", ReportType.IMMEDIATELY_UPLOAD, "c29fdbd", paramVarArgs);
  }
  
  @KvReport(checkSum="4f8e67d", enable=true, itemName="connect_fail", merge=true, statKey=78503071, table=false)
  public static void pushConnectFail(double... paramVarArgs)
  {
    report(true, 78503071, "connect_fail", "", ReportType.NORMAL, "4f8e67d", paramVarArgs);
  }
  
  @KvReport(checkSum="0e031c3", enable=true, itemName="connect_success", merge=true, statKey=78503071, table=false)
  public static void pushConnectSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "connect_success", "", ReportType.NORMAL, "0e031c3", paramVarArgs);
  }
  
  @KvReport(checkSum="4ecbe23", enable=true, itemName="exist_time", merge=true, statKey=78503071, table=false)
  public static void pushExistTime(double... paramVarArgs)
  {
    report(true, 78503071, "exist_time", "", ReportType.NORMAL, "4ecbe23", paramVarArgs);
  }
  
  @KvReport(checkSum="b61825e", enable=true, itemName="heartbeat_fail", merge=true, statKey=78503071, table=false)
  public static void pushHeartbeatFail(double... paramVarArgs)
  {
    report(true, 78503071, "heartbeat_fail", "", ReportType.NORMAL, "b61825e", paramVarArgs);
  }
  
  @KvReport(checkSum="bb32d1b", enable=true, itemName="heartbeat_success", merge=true, statKey=78503071, table=false)
  public static void pushHeartbeatSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "heartbeat_success", "", ReportType.NORMAL, "bb32d1b", paramVarArgs);
  }
  
  @KvReport(checkSum="e730d2c", enable=true, itemName="login_fail", merge=true, statKey=78503071, table=false)
  public static void pushLoginFail(double... paramVarArgs)
  {
    report(true, 78503071, "login_fail", "", ReportType.NORMAL, "e730d2c", paramVarArgs);
  }
  
  @KvReport(checkSum="0482b91", enable=true, itemName="login_success", merge=true, statKey=78503071, table=false)
  public static void pushLoginSuccess(double... paramVarArgs)
  {
    report(true, 78503071, "login_success", "", ReportType.NORMAL, "0482b91", paramVarArgs);
  }
  
  @KvReport(checkSum="03c20d7", enable=true, itemName="mem_times", merge=true, statKey=78503071, table=false)
  public static void pushMemTimes(double... paramVarArgs)
  {
    report(true, 78503071, "mem_times", "", ReportType.NORMAL, "03c20d7", paramVarArgs);
  }
  
  @KvReport(checkSum="3e6cd8f", enable=true, itemName="pd", merge=true, statKey=78503071, table=false)
  public static void pushPd(double... paramVarArgs)
  {
    report(true, 78503071, "pd", "", ReportType.NORMAL, "3e6cd8f", paramVarArgs);
  }
  
  @KvReport(checkSum="72c1ff8", enable=true, itemName="pss", merge=true, statKey=78503071, table=false)
  public static void pushPss(double... paramVarArgs)
  {
    report(true, 78503071, "pss", "", ReportType.NORMAL, "72c1ff8", paramVarArgs);
  }
  
  @KvReport(checkSum="aa796a3", enable=true, itemName="start_up", merge=true, statKey=78503071, table=false)
  public static void pushStartUp(double... paramVarArgs)
  {
    report(true, 78503071, "start_up", "", ReportType.NORMAL, "aa796a3", paramVarArgs);
  }
  
  @KvReport(checkSum="e531bc4", enable=true, itemName="push_start_up_reason_", merge=true, statKey=78503071, table=false)
  public static void pushStartUpReason(String paramString, double... paramVarArgs)
  {
    report(true, 78503071, "push_start_up_reason_", paramString, ReportType.NORMAL, "e531bc4", paramVarArgs);
  }
  
  @KvReport(checkSum="2028ff9", enable=true, itemName="register_vid", merge=true, statKey=78503071, table=false)
  public static void registerVid(double... paramVarArgs)
  {
    report(true, 78503071, "register_vid", "", ReportType.NORMAL, "2028ff9", paramVarArgs);
  }
  
  @KvReport(checkSum="88bd529", enable=true, itemName="remove_sync_account", merge=true, statKey=78503071, table=false)
  public static void removeSyncAccount(double... paramVarArgs)
  {
    report(true, 78503071, "remove_sync_account", "", ReportType.NORMAL, "88bd529", paramVarArgs);
  }
  
  public static void report(boolean paramBoolean, int paramInt, String paramString1, String paramString2, ReportType paramReportType, String paramString3, double... paramVarArgs)
  {
    OssClient localOssClient = sClient;
    if (localOssClient == null) {
      return;
    }
    if (!paramBoolean)
    {
      localOssClient.log("Disable kv report! statKey: " + paramInt + ", itemName: " + paramString1);
      return;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    for (double d = 1.0D;; d = paramVarArgs[0])
    {
      localOssClient.reportKv(paramInt, paramString1 + paramString2, d, paramReportType, paramString3);
      return;
    }
  }
  
  @KvReport(checkSum="ffd0e77", enable=true, itemName="report_in_datacollect", merge=true, statKey=78503071, table=false)
  public static void reportInDatacollect(double... paramVarArgs)
  {
    report(true, 78503071, "report_in_datacollect", "", ReportType.NORMAL, "ffd0e77", paramVarArgs);
  }
  
  @KvReport(checkSum="1287e21", enable=true, itemName="report_in_osslog", merge=true, statKey=78503071, table=false)
  public static void reportInOsslog(double... paramVarArgs)
  {
    report(true, 78503071, "report_in_osslog", "", ReportType.NORMAL, "1287e21", paramVarArgs);
  }
  
  @KvReport(checkSum="bee8d01", enable=true, itemName="second_time_native_crash_by_app", merge=true, statKey=78503071, table=false)
  public static void secondTimeNativeCrashByApp(double... paramVarArgs)
  {
    report(true, 78503071, "second_time_native_crash_by_app", "", ReportType.IMMEDIATELY_FILED, "bee8d01", paramVarArgs);
  }
  
  @KvReport(checkSum="ce6fba0", enable=true, itemName="sendmail_by_ftn_skip_attach_size", merge=true, statKey=78503071, table=false)
  public static void sendmailByFtnSkipAttachSize(double... paramVarArgs)
  {
    report(true, 78503071, "sendmail_by_ftn_skip_attach_size", "", ReportType.NORMAL, "ce6fba0", paramVarArgs);
  }
  
  public static void setClient(OssClient paramOssClient)
  {
    sClient = paramOssClient;
  }
  
  @KvReport(checkSum="d727c5c", enable=true, itemName="show_guide", merge=true, statKey=78503071, table=false)
  public static void showGuide(double... paramVarArgs)
  {
    report(true, 78503071, "show_guide", "", ReportType.NORMAL, "d727c5c", paramVarArgs);
  }
  
  @KvReport(checkSum="54057e0", enable=true, itemName="show_notification_guide", merge=true, statKey=78503071, table=false)
  public static void showNotificationGuide(double... paramVarArgs)
  {
    report(true, 78503071, "show_notification_guide", "", ReportType.NORMAL, "54057e0", paramVarArgs);
  }
  
  @KvReport(checkSum="e834281", enable=true, itemName="show_ssl_dialog", merge=true, statKey=78503071, table=false)
  public static void showSslDialog(double... paramVarArgs)
  {
    report(true, 78503071, "show_ssl_dialog", "", ReportType.NORMAL, "e834281", paramVarArgs);
  }
  
  @KvReport(checkSum="349d3da", enable=true, itemName="show_ssl_notification", merge=true, statKey=78503071, table=false)
  public static void showSslNotification(double... paramVarArgs)
  {
    report(true, 78503071, "show_ssl_notification", "", ReportType.NORMAL, "349d3da", paramVarArgs);
  }
  
  @KvReport(checkSum="570f23d", enable=true, itemName="sync_server_error_click", merge=true, statKey=78503071, table=false)
  public static void syncServerErrorClick(double... paramVarArgs)
  {
    report(true, 78503071, "sync_server_error_click", "", ReportType.NORMAL, "570f23d", paramVarArgs);
  }
  
  @KvReport(checkSum="428ba75", enable=true, itemName="sync_server_error_show", merge=true, statKey=78503071, table=false)
  public static void syncServerErrorShow(double... paramVarArgs)
  {
    report(true, 78503071, "sync_server_error_show", "", ReportType.NORMAL, "428ba75", paramVarArgs);
  }
  
  @KvReport(checkSum="9dd95de", enable=true, itemName="sync_unauth_click", merge=true, statKey=78503071, table=false)
  public static void syncUnauthClick(double... paramVarArgs)
  {
    report(true, 78503071, "sync_unauth_click", "", ReportType.NORMAL, "9dd95de", paramVarArgs);
  }
  
  @KvReport(checkSum="14c5fe7", enable=true, itemName="sync_unauth_show", merge=true, statKey=78503071, table=false)
  public static void syncUnauthShow(double... paramVarArgs)
  {
    report(true, 78503071, "sync_unauth_show", "", ReportType.NORMAL, "14c5fe7", paramVarArgs);
  }
  
  @KvReport(checkSum="335d3f0", enable=true, itemName="sync_with_unavailable_network_click", merge=true, statKey=78503071, table=false)
  public static void syncWithUnavailableNetworkClick(double... paramVarArgs)
  {
    report(true, 78503071, "sync_with_unavailable_network_click", "", ReportType.NORMAL, "335d3f0", paramVarArgs);
  }
  
  @KvReport(checkSum="ac03be5", enable=true, itemName="sync_with_unavailable_network_show", merge=true, statKey=78503071, table=false)
  public static void syncWithUnavailableNetworkShow(double... paramVarArgs)
  {
    report(true, 78503071, "sync_with_unavailable_network_show", "", ReportType.NORMAL, "ac03be5", paramVarArgs);
  }
  
  @KvReport(checkSum="b8fbd14", enable=true, itemName="sync_without_network_click", merge=true, statKey=78503071, table=false)
  public static void syncWithoutNetworkClick(double... paramVarArgs)
  {
    report(true, 78503071, "sync_without_network_click", "", ReportType.NORMAL, "b8fbd14", paramVarArgs);
  }
  
  @KvReport(checkSum="a467551", enable=true, itemName="sync_without_network_show", merge=true, statKey=78503071, table=false)
  public static void syncWithoutNetworkShow(double... paramVarArgs)
  {
    report(true, 78503071, "sync_without_network_show", "", ReportType.NORMAL, "a467551", paramVarArgs);
  }
  
  @KvReport(checkSum="e4e8d3e", enable=true, itemName="TIM_LAUNCH_QQMAIL_PLUGIN", merge=false, statKey=78503071, table=false)
  public static void timLaunchQqmailPlugin(double... paramVarArgs)
  {
    report(true, 78503071, "TIM_LAUNCH_QQMAIL_PLUGIN", "", ReportType.IMMEDIATELY_UPLOAD, "e4e8d3e", paramVarArgs);
  }
  
  @KvReport(checkSum="53804be", enable=true, itemName="Uma_Via_Proxy", merge=true, statKey=78503071, table=false)
  public static void umaViaProxy(double... paramVarArgs)
  {
    report(true, 78503071, "Uma_Via_Proxy", "", ReportType.NORMAL, "53804be", paramVarArgs);
  }
  
  @KvReport(checkSum="4ace060", enable=true, itemName="watchdog_alive", merge=true, statKey=78503071, table=false)
  public static void watchdogAlive(double... paramVarArgs)
  {
    report(true, 78503071, "watchdog_alive", "", ReportType.NORMAL, "4ace060", paramVarArgs);
  }
  
  @KvReport(checkSum="75665c8", enable=true, itemName="watchdog_exist_time", merge=true, statKey=78503071, table=false)
  public static void watchdogExistTime(double... paramVarArgs)
  {
    report(true, 78503071, "watchdog_exist_time", "", ReportType.NORMAL, "75665c8", paramVarArgs);
  }
  
  @KvReport(checkSum="dd604ef", enable=true, itemName="WEBVIEW_AUTHORIZE", merge=false, statKey=78503071, table=false)
  public static void webviewAuthorize(double... paramVarArgs)
  {
    report(true, 78503071, "WEBVIEW_AUTHORIZE", "", ReportType.NORMAL, "dd604ef", paramVarArgs);
  }
  
  @KvReport(checkSum="c065e6c", enable=true, itemName="WELCOME_LAUNCHER_TIME", merge=false, statKey=78503071, table=false)
  public static void welcomeLauncherTime(double... paramVarArgs)
  {
    report(true, 78503071, "WELCOME_LAUNCHER_TIME", "", ReportType.NORMAL, "c065e6c", paramVarArgs);
  }
  
  @KvReport(checkSum="4333998", enable=true, itemName="Wt_Login_Account_Exist", merge=true, statKey=78503071, table=false)
  public static void wtLoginAccountExist(double... paramVarArgs)
  {
    report(true, 78503071, "Wt_Login_Account_Exist", "", ReportType.NORMAL, "4333998", paramVarArgs);
  }
  
  @KvReport(checkSum="9d4ffe1", enable=true, itemName="Wt_Login_Different_Seq", merge=true, statKey=78503071, table=false)
  public static void wtLoginDifferentSeq(double... paramVarArgs)
  {
    report(true, 78503071, "Wt_Login_Different_Seq", "", ReportType.NORMAL, "9d4ffe1", paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.oss.KvHelper
 * JD-Core Version:    0.7.0.1
 */