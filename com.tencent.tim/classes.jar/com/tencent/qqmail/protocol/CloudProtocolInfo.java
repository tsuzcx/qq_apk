package com.tencent.qqmail.protocol;

import com.tencent.qqmail.protocol.UMA.AckCardReq;
import com.tencent.qqmail.protocol.UMA.AddressSyncKeyDomain;
import com.tencent.qqmail.protocol.UMA.BatchGetCardsReq;
import com.tencent.qqmail.protocol.UMA.CheckUpgradeReq;
import com.tencent.qqmail.protocol.UMA.CmdAddADBWContactReq;
import com.tencent.qqmail.protocol.UMA.CmdClrContactTypeReq;
import com.tencent.qqmail.protocol.UMA.CmdDelADBWContactReq;
import com.tencent.qqmail.protocol.UMA.CmdGetRsaReq;
import com.tencent.qqmail.protocol.UMA.CmdLstADBWContactReq;
import com.tencent.qqmail.protocol.UMA.CmdLstContactWithTypeReq;
import com.tencent.qqmail.protocol.UMA.CmdQueryConfigUpdateReq.RequestField;
import com.tencent.qqmail.protocol.UMA.CmdQueryEmailTypeReq.EmailInfo;
import com.tencent.qqmail.protocol.UMA.CmdQuerySecAppReq;
import com.tencent.qqmail.protocol.UMA.CmdSetContactTypeReq;
import com.tencent.qqmail.protocol.UMA.ContactCreateInfo;
import com.tencent.qqmail.protocol.UMA.ContactDelInfo;
import com.tencent.qqmail.protocol.UMA.ContactSyncKeyDomain;
import com.tencent.qqmail.protocol.UMA.DataReport;
import com.tencent.qqmail.protocol.UMA.DelEMailNicknameReqInfo;
import com.tencent.qqmail.protocol.UMA.DelEMailPhotoReqInfo;
import com.tencent.qqmail.protocol.UMA.EmailProtocolInfo;
import com.tencent.qqmail.protocol.UMA.GetBirthFriendListReq;
import com.tencent.qqmail.protocol.UMA.GetThanksListReq;
import com.tencent.qqmail.protocol.UMA.PhoneCallDelRecordReq;
import com.tencent.qqmail.protocol.UMA.PhonecallCheckInfo;
import com.tencent.qqmail.protocol.UMA.PhotoParseReq;
import com.tencent.qqmail.protocol.UMA.PushConfigHandle;
import com.tencent.qqmail.protocol.UMA.PushInfo;
import com.tencent.qqmail.protocol.UMA.RejectAdmailReportReq;
import com.tencent.qqmail.protocol.UMA.SaveCardReq;
import com.tencent.qqmail.protocol.UMA.SetEMailNicknameReqInfo;
import com.tencent.qqmail.protocol.UMA.SetEMailPhotoReqInfo;
import com.tencent.qqmail.protocol.UMA.SyncCardReq;
import com.tencent.qqmail.protocol.UMA.SyncEMailNicknameReqInfo;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoContentReq;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoReqInfo;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoUrlReqInfo;
import com.tencent.qqmail.protocol.UMA.TranslationReq;
import com.tencent.qqmail.protocol.UMA.UserSetting.Account;
import com.tencent.qqmail.protocol.UMA.UserSetting.Global;
import com.tencent.qqmail.protocol.UMA.VerifyCodeAnswer;
import java.io.Serializable;

public class CloudProtocolInfo
  implements Serializable
{
  private static final long serialVersionUID = -5371773084138783855L;
  public int account_id_;
  public String account_name_;
  public String account_password_;
  public AccountInfo add_account_info_;
  public CmdAddADBWContactReq add_bw_contact_req_;
  public CheckUpgradeReq check_upgrade_req_;
  public CmdClrContactTypeReq clr_contact_type_req_;
  public CmdQuerySecAppReq cmd_query_sec_app_req_;
  public String cmd_unique_id_;
  public ContactCreateInfo contact_create_req_;
  public ContactDelInfo contact_del_req_;
  public ContactCreateInfo contact_modify_req_;
  public ContactSyncKeyDomain[] contact_sync_list_req_;
  public DataReport[] data_report_list_;
  public CmdDelADBWContactReq del_bw_contact_req_;
  public DelEMailNicknameReqInfo[] del_nick_list_;
  public DelEMailPhotoReqInfo[] del_photo_list_;
  public String delete_card_req_;
  public String device_id_;
  public String device_info_;
  public String domain_;
  public CmdQueryEmailTypeReq.EmailInfo[] email_info_list_;
  public GetBirthFriendListReq get_birth_friend_req_;
  public BatchGetCardsReq get_cards_req_;
  public SyncEMailPhotoContentReq get_email_photo_req_;
  public CmdGetRsaReq get_rsa_req_;
  public GetThanksListReq get_thank_list_req_;
  public String ios_token_;
  public int latest_tip_seq_;
  public CmdLstADBWContactReq lst_bw_contact_req_;
  public CmdLstContactWithTypeReq lst_contact_with_type_req_;
  public String[] mail_url_list_;
  public String[] mobilenum_list_;
  public String phone_type_;
  public PhonecallCheckInfo[] phonecall_check_info_list_;
  public PhoneCallDelRecordReq phonecall_del_record_req_;
  public AddressSyncKeyDomain[] phonecall_sync_record_list_;
  public String photo_data_;
  public PhotoParseReq photo_parse_req_;
  public String pubkey_path_;
  public PushConfigHandle[] push_config_list_req_;
  public PushInfo push_info_;
  public QueryConfigUpdateRequest query_config_update_req_;
  public RejectAdmailReportReq rejectAdmailReportReq;
  public String rsp_key_;
  public SaveCardReq save_card_req_;
  public String session_key_hex_;
  public CmdSetContactTypeReq set_contact_type_req_;
  public SetEMailNicknameReqInfo[] set_nick_list_;
  public SetEMailPhotoReqInfo[] set_photo_list_;
  public SyncCardReq sync_card_req_;
  public SyncEMailNicknameReqInfo[] sync_nick_list_;
  public SyncEMailPhotoReqInfo[] sync_photo_list_;
  public SyncEMailPhotoUrlReqInfo[] sync_photo_url_list_;
  public String sys_version_;
  public AckCardReq thank_card_req_;
  public TranslationReq translate_req_;
  public long uma_id_;
  public String uma_psw_md5_sum_;
  public int unread_count_;
  public boolean use_gzip_;
  public UserSettingA user_setting_a_;
  public String user_setting_version_;
  public boolean user_triggered_;
  public VerifyCodeAnswer verify_code_answer_;
  public int verify_code_type_;
  public String[] vip_contact_list_;
  
  public CloudProtocolInfo() {}
  
  public CloudProtocolInfo(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this.uma_id_ = paramLong;
    this.device_id_ = paramString2;
    this.uma_psw_md5_sum_ = paramString1;
    this.phone_type_ = paramString3;
  }
  
  public static class AccountInfo
  {
    public String email_;
    public int id_;
    public EmailProtocolInfo recv_;
    public EmailProtocolInfo send_;
  }
  
  public static class QueryConfigUpdateRequest
  {
    public int call_scene;
    public CmdQueryConfigUpdateReq.RequestField[] request_list_;
  }
  
  public static class UserSettingA
  {
    public UserSetting.Account[] account_list_;
    public UserSetting.Global global_;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.CloudProtocolInfo
 * JD-Core Version:    0.7.0.1
 */