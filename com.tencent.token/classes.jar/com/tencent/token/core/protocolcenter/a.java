package com.tencent.token.core.protocolcenter;

import com.tencent.token.core.protocolcenter.protocol.ProtoAutoIDCardDetect;
import com.tencent.token.core.protocolcenter.protocol.ProtoBindTokenH5;
import com.tencent.token.core.protocolcenter.protocol.ProtoCheckUpSMS;
import com.tencent.token.core.protocolcenter.protocol.ProtoCopyFace;
import com.tencent.token.core.protocolcenter.protocol.ProtoDelDevice;
import com.tencent.token.core.protocolcenter.protocol.ProtoDelMbInfo;
import com.tencent.token.core.protocolcenter.protocol.ProtoDelUnverifyUin;
import com.tencent.token.core.protocolcenter.protocol.ProtoDeviceInfoReport;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoActiveToken;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoBindToken;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoBindTokenByRealName;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoBindTokenByUniverify;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoExchangeKey;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoGeneralBindToken;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoLoginV2;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoSendFeedback;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoSendSmscode;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoSessionInfo;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoUnbindToken;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoVerifyOriginalMobile;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoVerifyQQToken;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoVerifyQuestion;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoVerifySmscode;
import com.tencent.token.core.protocolcenter.protocol.ProtoDoWtLogin;
import com.tencent.token.core.protocolcenter.protocol.ProtoFaceCommon;
import com.tencent.token.core.protocolcenter.protocol.ProtoFacePK;
import com.tencent.token.core.protocolcenter.protocol.ProtoFaceVryOnOff;
import com.tencent.token.core.protocolcenter.protocol.ProtoFeedbackAbnormalLogin;
import com.tencent.token.core.protocolcenter.protocol.ProtoFeedbackMobileUsing;
import com.tencent.token.core.protocolcenter.protocol.ProtoFreezeUin;
import com.tencent.token.core.protocolcenter.protocol.ProtoGeneralGetMobileCode;
import com.tencent.token.core.protocolcenter.protocol.ProtoGeneralVryMobileCode;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetAccountLockStatus;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetBmpByUrl;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetConfig;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetDeterminVerifyFactors;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetDeviceLock;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetDomain;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetDualMsgList;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetEvalAccountResult;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetGameLockStatus;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetLoginProtect;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetMbInfo;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetMbMobileCode;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetMessage;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetOperateMsg;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetQQFaceUrl;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetRealNameStatus;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetRealNameVerify;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetRealUin;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetSMSChannel;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetSafeProtection;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetStartUpImg;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetStrConfig;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetUinList;
import com.tencent.token.core.protocolcenter.protocol.ProtoKickOff;
import com.tencent.token.core.protocolcenter.protocol.ProtoLiveFaceDetect;
import com.tencent.token.core.protocolcenter.protocol.ProtoModifyQQPwd;
import com.tencent.token.core.protocolcenter.protocol.ProtoQryBindNotifyMsg;
import com.tencent.token.core.protocolcenter.protocol.ProtoQueryCaptcha;
import com.tencent.token.core.protocolcenter.protocol.ProtoQueryFreezeStatus;
import com.tencent.token.core.protocolcenter.protocol.ProtoQueryMaliciousURL;
import com.tencent.token.core.protocolcenter.protocol.ProtoQueryRealName;
import com.tencent.token.core.protocolcenter.protocol.ProtoQuerySpecialVerify;
import com.tencent.token.core.protocolcenter.protocol.ProtoQuerySuperCodeInfo;
import com.tencent.token.core.protocolcenter.protocol.ProtoRealNameCardCheck;
import com.tencent.token.core.protocolcenter.protocol.ProtoRealNameReg;
import com.tencent.token.core.protocolcenter.protocol.ProtoReportDnsInfo;
import com.tencent.token.core.protocolcenter.protocol.ProtoReportLocation;
import com.tencent.token.core.protocolcenter.protocol.ProtoSetMbMobile;
import com.tencent.token.core.protocolcenter.protocol.ProtoSetSuperCode;
import com.tencent.token.core.protocolcenter.protocol.ProtoUploadLogFile;
import com.tencent.token.core.protocolcenter.protocol.ProtoUploadRealNameFile;
import com.tencent.token.core.protocolcenter.protocol.ProtoVryCaptcha;
import com.tencent.token.core.protocolcenter.protocol.ProtoVryMbMobileCode;

public abstract interface a
{
  @n(a=ProtoCheckUpSMS.class)
  public static final String CMD_CHECK_UP_SMS = "mbtoken3_check_up_sms";
  @n(a=ProtoDelDevice.class)
  public static final String CMD_DEL_DEVICE = "mbtoken3_device_lock_del_device_v2";
  @n(a=ProtoDelMbInfo.class)
  public static final String CMD_DEL_MB_INFO = "mbtoken3_del_mbitem";
  @n(a=ProtoDelUnverifyUin.class)
  public static final String CMD_DEL_UNVERIFYUIN = "mbtoken3_del_unvfy_uin";
  @n(a=ProtoDeviceInfoReport.class)
  public static final String CMD_DEVICE_INFO_REPORT = "mbtoken3_device_info_report_encrypt";
  @n(a=ProtoDoActiveToken.class)
  public static final String CMD_DO_ACTIVETOKEN = "mbtoken3_activate_token";
  @n(a=ProtoAutoIDCardDetect.class)
  public static final String CMD_DO_AUTO_IDCARD_DETECT = "mbtoken3_auto_idcard_detect";
  @n(a=ProtoDoBindToken.class)
  public static final String CMD_DO_BINDTOKEN = "mbtoken3_bind_token_by_app_v3";
  @n(a=ProtoBindTokenH5.class)
  public static final String CMD_DO_BINDTOKENH5 = "mbtoken3_bind_token_h5";
  @n(a=ProtoDoBindTokenByRealName.class)
  public static final String CMD_DO_BINDTOKEN_BYREALNAME = "mbtoken3_bind_token_by_realname";
  @n(a=ProtoDoBindTokenByUniverify.class)
  public static final String CMD_DO_BINDTOKEN_BYUNIVERIFY = "mbtoken3_bind_token_by_univerify";
  @n(a=ProtoCopyFace.class)
  public static final String CMD_DO_COPY_FACE = "mbtoken3_copy_face";
  @n(a=ProtoDoExchangeKey.class)
  public static final String CMD_DO_EXCHANGEKEY = "mbtoken3_exchange_key_v3";
  @n(a=ProtoDoSendFeedback.class)
  public static final String CMD_DO_FEEDBACK_COMMENT = "mbtoken3_feedback_v2";
  @n(a=ProtoFreezeUin.class)
  public static final String CMD_DO_FREEZE_UIN = "mbtoken3_freeze_action";
  @n(a=ProtoDoGeneralBindToken.class)
  public static final String CMD_DO_GENERAL_BINDTOKEN = "mbtoken3_general_bind";
  @n(a=ProtoDoVerifyOriginalMobile.class)
  public static final String CMD_DO_GENERAL_VERIFY_FACTOR = "mbtoken3_verify_original_mobile";
  @n(a=ProtoLiveFaceDetect.class)
  public static final String CMD_DO_LIVE_VIDEO_DETECT = "mbtoken3_live_video_detect";
  @n(a=ProtoDoLoginV2.class)
  public static final String CMD_DO_LOGIN_V2 = "mbtoken3_login_v2";
  @n(a=ProtoRealNameCardCheck.class)
  public static final String CMD_DO_REALNAME_CARD_CHECK = "mbtoken3_card_check";
  @n(a=ProtoReportLocation.class)
  public static final String CMD_DO_REPORT_LOCATION = "mbtoken3_report_location";
  @n(a=ProtoDoSendSmscode.class)
  public static final String CMD_DO_SEND_SMSCODE = "mbtoken3_get_mobile_code_v2";
  @n(a=ProtoDoSessionInfo.class)
  public static final String CMD_DO_SESSIONINFO = "mbtoken3_session_info";
  @n(a=ProtoDoUnbindToken.class)
  public static final String CMD_DO_UNBINDTOKEN = "mbtoken3_unbind_token";
  @n(a=ProtoDoVerifyQQToken.class)
  public static final String CMD_DO_VERIFYQQTOKEN = "mbtoken3_verify_qqtoken_v2";
  @n(a=ProtoDoVerifyQuestion.class)
  public static final String CMD_DO_VERIFYQUESTION = "mbtoken3_vry_ques_v2";
  @n(a=ProtoDoVerifySmscode.class)
  public static final String CMD_DO_VERIFY_SMSCODE = "mbtoken3_verify_mobile_code_v2";
  @n(a=ProtoDoWtLogin.class)
  public static final String CMD_DO_WTLOGIN = "mbtoken3_vfy_wtlogin";
  @n(a=ProtoFacePK.class)
  public static final String CMD_FACEPK = "mbtoken3_face_pk";
  @n(a=ProtoFaceCommon.class)
  public static final String CMD_FACERECOGNITION = "mbtoken3_face_reg_v2";
  @n(a=ProtoFeedbackAbnormalLogin.class)
  public static final String CMD_FEEDBACK_ABNORMAL_LOGIN = "mbtoken3_feedback_abnormal_login";
  @n(a=ProtoFeedbackMobileUsing.class)
  public static final String CMD_FEEDBACK_MOBILE_USING = "mbtoken3_feedback_mobile_using";
  @n(a=ProtoGeneralGetMobileCode.class)
  public static final String CMD_GENERAL_GET_MOBILE_CODE = "mbtoken3_general_get_mobile_code";
  @n(a=ProtoGeneralVryMobileCode.class)
  public static final String CMD_GENERAL_VRY_MOBILE_CODE = "mbtoken3_general_verify_mobile_code";
  @n(a=ProtoGetAccountLockStatus.class)
  public static final String CMD_GET_ACCOUNT_LOCK_STATUS = "mbtoken3_get_ac_lock_status_v2";
  @n(a=ProtoGetBmpByUrl.class)
  public static final String CMD_GET_COMMON_IMG = "token.getcommonimg";
  @n(a=ProtoGetConfig.class)
  public static final String CMD_GET_CONFIG = "mbtoken3_get_config_v2";
  @n(a=ProtoGetDeterminVerifyFactors.class)
  public static final String CMD_GET_DETERMIN_VERIFY_FACTORS = "mbtoken3_determine_verify_factors";
  @n(a=ProtoGetDeviceLock.class)
  public static final String CMD_GET_DEVICE_LOCK = "mbtoken3_get_device_lock_status_v2";
  @n(a=ProtoGetDomain.class)
  public static final String CMD_GET_DOMAIN = "mbtoken3_get_domain";
  @n(a=ProtoGetDualMsgList.class)
  public static final String CMD_GET_DUAL_MSG_LIST = "mbtoken3_get_dual_msg_list_v2";
  @n(a=ProtoGetEvalAccountResult.class)
  public static final String CMD_GET_EVAL_ACCOUNT_RESULT = "mbtoken3_eval_account_v3";
  @n(a=ProtoGetGameLockStatus.class)
  public static final String CMD_GET_GAME_LOCK_STATUS = "mbtoken3_get_game_lock_status_v2";
  @n(a=ProtoGetLoginProtect.class)
  public static final String CMD_GET_LOGIN_PROTECT = "mbtoken3_get_login_prot";
  @n(a=ProtoGetMbInfo.class)
  public static final String CMD_GET_MB_INFO = "mbtoken3_get_mbinfo";
  @n(a=ProtoGetMbMobileCode.class)
  public static final String CMD_GET_MB_MOBILE_CODE = "mbtoken3_mbop_get_mobile_code";
  @n(a=ProtoGetMessage.class)
  public static final String CMD_GET_MESSAGE = "mbtoken3_get_message_v2";
  @n(a=ProtoGetOperateMsg.class)
  public static final String CMD_GET_OPERATEMSG = "mbtoken3_get_ads_info";
  @n(a=ProtoGetQQFaceUrl.class)
  public static final String CMD_GET_QQFACEURL = "mbtoken3_get_photo_v3";
  @n(a=ProtoGetRealNameVerify.class)
  public static final String CMD_GET_REALNAME_VERIFY = "mbtoken3_realname_lip";
  @n(a=ProtoGetRealUin.class)
  public static final String CMD_GET_REALUIN = "mbtoken3_query_real_uin_v2";
  @n(a=ProtoGetRealNameStatus.class)
  public static final String CMD_GET_REAL_NAME_STATUS = "mbtoken3_realname_status_v2";
  @n(a=ProtoGetSafeProtection.class)
  public static final String CMD_GET_SAFE_PROTECTION = "mbtoken3_get_safe_protection_v2";
  @n(a=ProtoGetSMSChannel.class)
  public static final String CMD_GET_SMS_CHANNEL = "mbtoken3_get_sms_port_v2";
  @n(a=ProtoGetStartUpImg.class)
  public static final String CMD_GET_STARTUP_IMG = "token.getstartupimg";
  @n(a=ProtoGetStrConfig.class)
  public static final String CMD_GET_STR_CONFIG = "mbtoken3_get_key_value_conf";
  @n(a=ProtoGetUinList.class)
  public static final String CMD_GET_UIN_LIST = "mbtoken3_get_uin_list_v2";
  @n(a=ProtoFaceVryOnOff.class)
  public static final String CMD_GET_VRY_ON_OFF = "mbtoken3_face_verify_on_off";
  @n(a=ProtoKickOff.class)
  public static final String CMD_KICK_ONLINE_DEVICE_OFF = "mbtoken3_kickoff_v2";
  @n(a=ProtoModifyQQPwd.class)
  public static final String CMD_MOD_QQ_PWD = "mbtoken3_modify_pwd";
  @n(a=ProtoQryBindNotifyMsg.class)
  public static final String CMD_QRY_BIND_NOTIFY_MSG = "mbtoken3_qry_bind_notify_msg";
  @n(a=ProtoQueryCaptcha.class)
  public static final String CMD_QUERY_CAPTCHA = "mbtoken3_query_captcha";
  @n(a=ProtoQueryFreezeStatus.class)
  public static final String CMD_QUERY_FREEZE_STATUS = "mbtoken3_query_freeze_status";
  @n(a=ProtoQueryMaliciousURL.class)
  public static final String CMD_QUERY_MALICIOUS_URL = "mbtoken3_query_malicious_url";
  @n(a=ProtoQueryRealName.class)
  public static final String CMD_QUERY_REALNAME = "mbtoken3_realname_qry";
  @n(a=ProtoQuerySpecialVerify.class)
  public static final String CMD_QUERY_SPE_VERIFY = "mbtoken3_qry_spec_verify";
  @n(a=ProtoQuerySuperCodeInfo.class)
  public static final String CMD_QUERY_SUPER_CODE_INFO = "mbtoken3_qry_super_code_info";
  @n(a=ProtoRealNameReg.class)
  public static final String CMD_REAL_NAME_REG = "mbtoken3_realname_reg_v2";
  @n(a=ProtoReportDnsInfo.class)
  public static final String CMD_REPORT_DNS_INFO = "mbtoken3_report_dns_v2";
  @n(a=ProtoSetMbMobile.class)
  public static final String CMD_SET_MB_MOBILE = "mbtoken3_set_mod_mobile";
  @n(a=ProtoSetServiceStatusV2.class)
  public static final String CMD_SET_SERVICES_STATUS_V2 = "mbtoken3_set_service_status_v2";
  @n(a=ProtoSetSuperCode.class)
  public static final String CMD_SET_SUPER_CODE = "mbtoken3_set_super_code";
  @n(a=ProtoUploadLogFile.class)
  public static final String CMD_UPLOAD_LOGFILE = "mbtoken3_log_upload";
  @n(a=ProtoUploadRealNameFile.class)
  public static final String CMD_UPLOAD_REALNAME_FILE = "mbtoken3_realname_check";
  @n(a=ProtoVryCaptcha.class)
  public static final String CMD_VRY_CAPTCHA = "mbtoken3_verify_captcha_v3";
  @n(a=ProtoVryMbMobileCode.class)
  public static final String CMD_VRY_MB_MOBILE_CODE = "mbtoken3_mbop_verify_mobile_code";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.a
 * JD-Core Version:    0.7.0.1
 */