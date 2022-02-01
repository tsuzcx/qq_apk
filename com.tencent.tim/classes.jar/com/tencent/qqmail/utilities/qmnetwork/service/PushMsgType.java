package com.tencent.qqmail.utilities.qmnetwork.service;

public class PushMsgType
{
  public static final int PushMsgTypeActiveSync = 155;
  public static final int PushMsgTypeAttachFolderRequest = 157;
  public static final int PushMsgTypeBottleRequest = 156;
  public static final int PushMsgTypeCalendarRequest = 158;
  public static final int PushMsgTypeConfig = 154;
  public static final int PushMsgTypeConnect = 21;
  public static final int PushMsgTypeConnect_V2 = 22;
  public static final int PushMsgTypeFtnRequest = 150;
  public static final int PushMsgTypeGmailAuthExpire = 161;
  public static final int PushMsgTypeHeart = 101;
  public static final int PushMsgTypeHeartReply_V2 = 104;
  public static final int PushMsgTypeHeartSend_V2 = 103;
  public static final int PushMsgTypeLogin = 1;
  public static final int PushMsgTypeLoginRequest = 149;
  public static final int PushMsgTypeMail = 148;
  public static final int PushMsgTypeMailReminder = 171;
  public static final int PushMsgTypeMissingCall = 165;
  public static final int PushMsgTypeNormalRequest = 148;
  public static final int PushMsgTypeNoteRequest = 151;
  public static final int PushMsgTypePhoneRequest = 160;
  public static final int PushMsgTypePullPush = 6;
  public static final int PushMsgTypeReachTest = 168;
  public static final int PushMsgTypeSaveToWeiYun = 164;
  public static final int PushMsgTypeSchema = 162;
  public static final int PushMsgTypeSync = 166;
  public static final int PushMsgTypeTelephone = 163;
  public static final int PushMsgTypeUpdateConfig = 167;
  public static final int PushMsgTypeUploadDebugLog = 159;
  public static final int PushMsgTypeWebmailImage = 152;
  public static final int PushMsgTypeWebmailScanFile = 170;
  public static final int PushRemoteWipe = 153;
  
  public static final String getNameByType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "others";
    case 103: 
      return "server_detect";
    case 104: 
      return "heartbeat_reply";
    case 21: 
    case 22: 
      return "login_reply";
    case 154: 
      return "config";
    case 148: 
      return "mail";
    case 152: 
      return "image";
    case 151: 
      return "note";
    case 150: 
      return "ftn";
    case 149: 
      return "relogin";
    case 156: 
      return "bottle";
    case 158: 
      return "calendar";
    case 160: 
      return "phone";
    case 153: 
      return "wipe";
    case 157: 
      return "attach_folder";
    case 159: 
      return "upload_debug_log";
    case 161: 
      return "gmail_expire";
    case 162: 
      return "schema";
    case 163: 
      return "we_call";
    case 164: 
      return "weiyun";
    case 165: 
      return "missing_call";
    case 166: 
      return "sync";
    case 167: 
      return "update_config";
    }
    return "active_sync";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.PushMsgType
 * JD-Core Version:    0.7.0.1
 */