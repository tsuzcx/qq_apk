package com.tencent.qqmail.protocol;

import android.util.Log;
import com.tencent.qqmail.model.ConvertFromProtobuf;
import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protocol.UMA.AppMiscConfig;
import com.tencent.qqmail.protocol.UMA.AppNotNotify;
import com.tencent.qqmail.protocol.UMA.AppNotToOpenFile;
import com.tencent.qqmail.protocol.UMA.BatchGetCardsRsp;
import com.tencent.qqmail.protocol.UMA.CmdGetRsaRsp;
import com.tencent.qqmail.protocol.UMA.CmdLstADBWContactRsp;
import com.tencent.qqmail.protocol.UMA.CmdLstContactWithTypeRsp;
import com.tencent.qqmail.protocol.UMA.CmdOpenMobileAcctRsp;
import com.tencent.qqmail.protocol.UMA.CmdQueryConfigUpdateRsp_ResponseField;
import com.tencent.qqmail.protocol.UMA.CmdQueryDomainConfigRsp;
import com.tencent.qqmail.protocol.UMA.CmdQueryEmailTypeRsp.EmailTypeInfo;
import com.tencent.qqmail.protocol.UMA.CmdQuerySecAppRsp;
import com.tencent.qqmail.protocol.UMA.ContactCreateResp;
import com.tencent.qqmail.protocol.UMA.ContactDelResp;
import com.tencent.qqmail.protocol.UMA.ContactListInfo;
import com.tencent.qqmail.protocol.UMA.ContactModifyResp;
import com.tencent.qqmail.protocol.UMA.DebugLogSetting;
import com.tencent.qqmail.protocol.UMA.DelEMailNicknameRspInfo;
import com.tencent.qqmail.protocol.UMA.DelEMailPhotoRspInfo;
import com.tencent.qqmail.protocol.UMA.DigestInfo;
import com.tencent.qqmail.protocol.UMA.DomainConfig;
import com.tencent.qqmail.protocol.UMA.EmailAccountInfo;
import com.tencent.qqmail.protocol.UMA.EmailAccountState;
import com.tencent.qqmail.protocol.UMA.GetBirthFriendListRsp;
import com.tencent.qqmail.protocol.UMA.GetThanksListRsp;
import com.tencent.qqmail.protocol.UMA.HolidayPicConfig;
import com.tencent.qqmail.protocol.UMA.LongConnSig;
import com.tencent.qqmail.protocol.UMA.PhoneCallDelRecordResp;
import com.tencent.qqmail.protocol.UMA.PhoneCallRecordConfigDomain;
import com.tencent.qqmail.protocol.UMA.PhoneCallSyncRecordListInfo;
import com.tencent.qqmail.protocol.UMA.PhonecallRetInfo;
import com.tencent.qqmail.protocol.UMA.PhotoParseRsp;
import com.tencent.qqmail.protocol.UMA.PopularizeConfig;
import com.tencent.qqmail.protocol.UMA.PushConfig;
import com.tencent.qqmail.protocol.UMA.PushConfigHandleResp;
import com.tencent.qqmail.protocol.UMA.QueryConfigUpdateRspForOCWrap;
import com.tencent.qqmail.protocol.UMA.QueryConfigUpdateRspForProtocolWrap;
import com.tencent.qqmail.protocol.UMA.SaveCardRsp;
import com.tencent.qqmail.protocol.UMA.SetEMailNicknameRspInfo;
import com.tencent.qqmail.protocol.UMA.SetEMailPhotoRspInfo;
import com.tencent.qqmail.protocol.UMA.SpreadResult;
import com.tencent.qqmail.protocol.UMA.SyncCardRsp;
import com.tencent.qqmail.protocol.UMA.SyncEMailNicknameRspInfo;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoRspInfo;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoUrlRspInfo;
import com.tencent.qqmail.protocol.UMA.TranslationResp;
import com.tencent.qqmail.protocol.UMA.UpdateInfo;
import com.tencent.qqmail.protocol.UMA.UserSetting;
import java.util.LinkedList;

public class CloudProtocolResult
{
  @ConvertFromProtobuf
  public EmailAccountInfo[] account_list_;
  @ConvertFromProtobuf
  public PushConfig check_upgrade_resp_;
  @ConvertFromProtobuf
  public ContactCreateResp contact_create_resp_;
  @ConvertFromProtobuf
  public ContactDelResp contact_del_resp_;
  @ConvertFromProtobuf
  public ContactModifyResp contact_modify_resp_;
  @ConvertFromProtobuf
  public ContactListInfo[] contact_sync_info_list_;
  @ConvertFromProtobuf
  public DebugLogSetting debug_log_settiong_;
  @ConvertFromProtobuf
  public DelEMailNicknameRspInfo[] del_nick_list_;
  @ConvertFromProtobuf
  public DelEMailPhotoRspInfo[] del_photo_rsp_list_;
  @ConvertFromProtobuf
  public CmdQueryEmailTypeRsp.EmailTypeInfo[] email_type_info_list_;
  public int error_code_;
  @ConvertFromProtobuf
  public GetBirthFriendListRsp get_birthfriend_list_rsp_;
  @ConvertFromProtobuf
  public BatchGetCardsRsp get_cards_rsp_;
  @ConvertFromProtobuf
  public CmdGetRsaRsp get_rsa_rsp_;
  @ConvertFromProtobuf
  public GetThanksListRsp get_thank_list_rsp_;
  public int id_;
  public boolean is_found_;
  @ConvertFromProtobuf
  public LongConnSig longconn_sig_;
  @ConvertFromProtobuf
  public CmdLstADBWContactRsp lst_bw_contact_rsp_;
  @ConvertFromProtobuf
  CmdLstContactWithTypeRsp lst_contact_with_type_rsp_;
  public String new_pubkey_;
  @ConvertFromProtobuf
  public CmdOpenMobileAcctRsp open_mobile_acct_rsp_;
  protected byte[][] pb_account_list_;
  protected byte[] pb_check_upgrade_resp_;
  protected byte[] pb_contact_create_resp_;
  protected byte[] pb_contact_del_resp_;
  protected byte[] pb_contact_modify_resp_;
  protected byte[][] pb_contact_sync_info_list_;
  protected byte[] pb_debug_log_settiong_;
  protected byte[][] pb_del_nick_list_;
  protected byte[][] pb_del_photo_rsp_list_;
  protected byte[][] pb_email_type_info_list_;
  protected byte[] pb_get_birthfriend_list_rsp_;
  protected byte[] pb_get_cards_rsp_;
  protected byte[] pb_get_rsa_rsp_;
  protected byte[] pb_get_thank_list_rsp_;
  protected byte[] pb_longconn_sig_;
  protected byte[] pb_lst_bw_contact_rsp_;
  protected byte[] pb_lst_contact_with_type_rsp_;
  protected byte[] pb_open_mobile_acct_rsp_;
  protected byte[] pb_phonecall_del_record_resp_;
  protected byte[][] pb_phonecall_record_sync_list_;
  protected byte[][] pb_phonecall_ret_info_list_;
  protected byte[] pb_photo_parse_rsp_;
  protected byte[] pb_push_config_handle_resp_;
  protected byte[][] pb_query_config_update_for_oc_list_;
  protected byte[] pb_query_config_update_rsp_;
  protected byte[] pb_query_domain_rsp_;
  protected byte[] pb_query_sec_app_rsp_;
  protected byte[] pb_save_card_rsp_;
  protected byte[][] pb_set_nick_list_;
  protected byte[][] pb_set_photo_rsp_list_;
  protected byte[] pb_sync_card_rsp_;
  protected byte[][] pb_sync_nick_list_;
  protected byte[][] pb_sync_photo_list_;
  protected byte[][] pb_sync_photo_url_list_;
  protected byte[] pb_translate_resp_;
  protected byte[][] pb_update_info_list_;
  protected byte[] pb_user_setting_;
  public String phoneCode;
  @ConvertFromProtobuf
  public PhoneCallDelRecordResp phonecall_del_record_resp_;
  @ConvertFromProtobuf
  public PhoneCallSyncRecordListInfo[] phonecall_record_sync_list_;
  @ConvertFromProtobuf
  public PhonecallRetInfo[] phonecall_ret_info_list_;
  @ConvertFromProtobuf
  public PhotoParseRsp photo_parse_rsp_;
  public String proxy_login_password_;
  public String psw_;
  @ConvertFromProtobuf
  public PushConfigHandleResp push_config_handle_resp_;
  @ConvertFromProtobuf(getProtoType=QueryConfigUpdateRspForOCWrap.class, isConvert=true)
  public QueryConfigUpdateRspForOC[] query_config_update_for_oc_list_;
  @ConvertFromProtobuf(getProtoType=QueryConfigUpdateRspForProtocolWrap.class, isConvert=true)
  public QueryConfigUpdateRspForProtocol query_config_update_rsp_;
  @ConvertFromProtobuf
  public CmdQueryDomainConfigRsp query_domain_rsp_;
  @ConvertFromProtobuf
  public CmdQuerySecAppRsp query_sec_app_rsp_;
  @ConvertFromProtobuf
  public SaveCardRsp save_card_rsp_;
  public String session_key_hex_;
  @ConvertFromProtobuf
  public SetEMailNicknameRspInfo[] set_nick_list_;
  @ConvertFromProtobuf
  public SetEMailPhotoRspInfo[] set_photo_rsp_list_;
  public String set_user_setting_rsp_version_;
  @ConvertFromProtobuf
  public SyncCardRsp sync_card_rsp_;
  @ConvertFromProtobuf
  public SyncEMailNicknameRspInfo[] sync_nick_list_;
  @ConvertFromProtobuf
  public SyncEMailPhotoRspInfo[] sync_photo_list_;
  @ConvertFromProtobuf
  public SyncEMailPhotoUrlRspInfo[] sync_photo_url_list_;
  @ConvertFromProtobuf
  public TranslationResp translate_resp_;
  public long uma_id_;
  @ConvertFromProtobuf
  public UpdateInfo[] update_info_list_;
  @ConvertFromProtobuf
  public UserSetting user_setting_;
  public String verify_code_bin_;
  public String verify_code_sid_;
  public String[] vip_contact_list_;
  
  public static class QueryConfigUpdateRspForOC
    implements ARTConvert
  {
    public CmdLstADBWContactRsp adbw_contact_resp_;
    public AppMiscConfig app_misc_config_;
    public AppNotNotify[] app_not_notify_list_;
    public AppNotToOpenFile[] app_not_to_open_file_list_;
    public boolean available_;
    public int config_type_;
    public DomainConfig[] domain_config_list_;
    public EmailAccountState[] email_account_state_list_;
    public String email_type_rule_;
    public HolidayPicConfig[] holidaypic_list_;
    public DigestInfo new_config_digest_;
    public int new_config_part_pos_;
    public int new_config_size_;
    public String new_config_version_;
    public PopularizeConfig[] popularize_list_;
    public PushConfig[] push_config_list_;
    public PhoneCallRecordConfigDomain[] query_call_record_list_;
    public SpreadResult[] spreadresult_list_;
    public UpdateInfo[] updateinfo_list_;
    public UserSetting[] user_setting_list_;
    
    private boolean isArrayEmpty(LinkedList<?> paramLinkedList)
    {
      return (paramLinkedList == null) || (paramLinkedList.size() <= 0);
    }
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
    {
      int j = 0;
      paramBaseProtoBuf = (QueryConfigUpdateRspForOCWrap)paramBaseProtoBuf;
      if (paramBaseProtoBuf != null)
      {
        this.config_type_ = paramBaseProtoBuf.config_type;
        this.available_ = paramBaseProtoBuf.available;
        this.new_config_version_ = paramBaseProtoBuf.new_config_version;
        this.email_type_rule_ = paramBaseProtoBuf.email_type_rule;
        this.new_config_digest_ = paramBaseProtoBuf.new_config_digest;
        this.new_config_size_ = paramBaseProtoBuf.new_config_size;
        this.new_config_part_pos_ = paramBaseProtoBuf.new_config_part_pos;
        this.app_misc_config_ = paramBaseProtoBuf.app_misc_config;
        int i;
        Object localObject;
        if (!isArrayEmpty(paramBaseProtoBuf.domain_config_list))
        {
          this.domain_config_list_ = new DomainConfig[paramBaseProtoBuf.domain_config_list.size()];
          i = 0;
          while (i < paramBaseProtoBuf.domain_config_list.size())
          {
            localObject = (DomainConfig)paramBaseProtoBuf.domain_config_list.get(i);
            this.domain_config_list_[i] = localObject;
            i += 1;
          }
        }
        this.domain_config_list_ = new DomainConfig[0];
        if (!isArrayEmpty(paramBaseProtoBuf.user_setting_list))
        {
          this.user_setting_list_ = new UserSetting[paramBaseProtoBuf.user_setting_list.size()];
          i = 0;
          while (i < paramBaseProtoBuf.user_setting_list.size())
          {
            localObject = (UserSetting)paramBaseProtoBuf.user_setting_list.get(i);
            this.user_setting_list_[i] = localObject;
            i += 1;
          }
        }
        this.user_setting_list_ = new UserSetting[0];
        if (!isArrayEmpty(paramBaseProtoBuf.email_account_state_list))
        {
          this.email_account_state_list_ = new EmailAccountState[paramBaseProtoBuf.email_account_state_list.size()];
          i = 0;
          while (i < paramBaseProtoBuf.email_account_state_list.size())
          {
            localObject = (EmailAccountState)paramBaseProtoBuf.email_account_state_list.get(i);
            this.email_account_state_list_[i] = localObject;
            i += 1;
          }
        }
        this.email_account_state_list_ = new EmailAccountState[0];
        if (!isArrayEmpty(paramBaseProtoBuf.updateinfo_list))
        {
          this.updateinfo_list_ = new UpdateInfo[paramBaseProtoBuf.updateinfo_list.size()];
          i = 0;
          while (i < paramBaseProtoBuf.updateinfo_list.size())
          {
            localObject = (UpdateInfo)paramBaseProtoBuf.updateinfo_list.get(i);
            Log.d("ARTCompatibility", "UpdateInfo desc: " + ((UpdateInfo)localObject).description + " title: " + ((UpdateInfo)localObject).title + " type: " + ((UpdateInfo)localObject).type + " url: " + ((UpdateInfo)localObject).url + " url_title: " + ((UpdateInfo)localObject).url_title);
            this.updateinfo_list_[i] = localObject;
            i += 1;
          }
        }
        this.updateinfo_list_ = new UpdateInfo[0];
        if (!isArrayEmpty(paramBaseProtoBuf.holidaypic_list))
        {
          this.holidaypic_list_ = new HolidayPicConfig[paramBaseProtoBuf.holidaypic_list.size()];
          i = 0;
          while (i < paramBaseProtoBuf.holidaypic_list.size())
          {
            localObject = (HolidayPicConfig)paramBaseProtoBuf.holidaypic_list.get(i);
            this.holidaypic_list_[i] = localObject;
            i += 1;
          }
        }
        this.holidaypic_list_ = new HolidayPicConfig[0];
        if (!isArrayEmpty(paramBaseProtoBuf.spreadresult_list))
        {
          this.spreadresult_list_ = new SpreadResult[paramBaseProtoBuf.spreadresult_list.size()];
          i = 0;
          while (i < paramBaseProtoBuf.spreadresult_list.size())
          {
            localObject = (SpreadResult)paramBaseProtoBuf.spreadresult_list.get(i);
            this.spreadresult_list_[i] = localObject;
            i += 1;
          }
        }
        this.spreadresult_list_ = new SpreadResult[0];
        if (!isArrayEmpty(paramBaseProtoBuf.popularize_list))
        {
          this.popularize_list_ = new PopularizeConfig[paramBaseProtoBuf.popularize_list.size()];
          i = 0;
          while (i < paramBaseProtoBuf.popularize_list.size())
          {
            localObject = (PopularizeConfig)paramBaseProtoBuf.popularize_list.get(i);
            this.popularize_list_[i] = localObject;
            i += 1;
          }
        }
        this.popularize_list_ = new PopularizeConfig[0];
        if (!isArrayEmpty(paramBaseProtoBuf.query_call_record_list))
        {
          this.query_call_record_list_ = new PhoneCallRecordConfigDomain[paramBaseProtoBuf.query_call_record_list.size()];
          i = 0;
          while (i < paramBaseProtoBuf.query_call_record_list.size())
          {
            localObject = (PhoneCallRecordConfigDomain)paramBaseProtoBuf.query_call_record_list.get(i);
            this.query_call_record_list_[i] = localObject;
            i += 1;
          }
        }
        this.query_call_record_list_ = new PhoneCallRecordConfigDomain[0];
        if (!isArrayEmpty(paramBaseProtoBuf.push_config_list))
        {
          this.push_config_list_ = new PushConfig[paramBaseProtoBuf.push_config_list.size()];
          i = 0;
          while (i < paramBaseProtoBuf.push_config_list.size())
          {
            localObject = (PushConfig)paramBaseProtoBuf.push_config_list.get(i);
            this.push_config_list_[i] = localObject;
            i += 1;
          }
        }
        this.push_config_list_ = new PushConfig[0];
        if (!isArrayEmpty(paramBaseProtoBuf.app_not_notify))
        {
          this.app_not_notify_list_ = new AppNotNotify[paramBaseProtoBuf.app_not_notify.size()];
          i = 0;
          while (i < paramBaseProtoBuf.app_not_notify.size())
          {
            localObject = (AppNotNotify)paramBaseProtoBuf.app_not_notify.get(i);
            this.app_not_notify_list_[i] = localObject;
            i += 1;
          }
        }
        this.app_not_notify_list_ = new AppNotNotify[0];
        if (!isArrayEmpty(paramBaseProtoBuf.app_not_to_open_file))
        {
          this.app_not_notify_list_ = new AppNotNotify[paramBaseProtoBuf.app_not_to_open_file.size()];
          i = j;
          while (i < paramBaseProtoBuf.app_not_to_open_file.size())
          {
            localObject = (AppNotToOpenFile)paramBaseProtoBuf.app_not_to_open_file.get(i);
            this.app_not_to_open_file_list_[i] = localObject;
            i += 1;
          }
        }
        this.app_not_to_open_file_list_ = new AppNotToOpenFile[0];
      }
    }
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  }
  
  public static class QueryConfigUpdateRspForProtocol
    implements ARTConvert
  {
    public CmdQueryConfigUpdateRsp_ResponseField[] response_list_;
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
    {
      paramBaseProtoBuf = (QueryConfigUpdateRspForProtocolWrap)paramBaseProtoBuf;
      if (paramBaseProtoBuf.response_list_ != null) {
        this.response_list_ = ((CmdQueryConfigUpdateRsp_ResponseField[])paramBaseProtoBuf.response_list_.toArray(new CmdQueryConfigUpdateRsp_ResponseField[paramBaseProtoBuf.response_list_.size()]));
      }
    }
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.CloudProtocolResult
 * JD-Core Version:    0.7.0.1
 */