package com.tencent.qqmail.protocol;

import android.content.Context;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.calendar.model.CCalendar;
import com.tencent.qqmail.model.ConvertFromProtobuf;
import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protocol.ART.ExchangeContent;
import com.tencent.qqmail.protocol.ART.FolderOperationResult;
import com.tencent.qqmail.protocol.ART.ImapCommandStatusResult;
import java.io.Serializable;

public class ProtocolResult
  implements Serializable
{
  public static final int PEC_ABORTED = 18;
  public static final int PEC_ACTIVESYNC_LAST = 1005;
  public static final int PEC_ACTIVESYNC_NEED_FOLDERSYNC = 1006;
  public static final int PEC_ACTIVESYNC_NEED_SYNC = 1500;
  public static final int PEC_ACTIVESYNC_POLICY_KEY = 1002;
  public static final int PEC_ACTIVESYNC_POLICY_KEY_ACK = 1003;
  public static final int PEC_ACTIVESYNC_REDIRECT = 1004;
  public static final int PEC_ACTIVESYNC_START = 1000;
  public static final int PEC_ACTIVESYNC_SYNC_KEY_ERROR = 1001;
  public static final int PEC_ACTIVESYNC_WT_A2_AUTHERR = 1501;
  public static final int PEC_AUTH_ERROR = 4;
  public static final int PEC_COULDNT_CONNECT = 15;
  public static final int PEC_EAGAIN = 12;
  public static final int PEC_EML_LOAD_ERROR = 2001;
  public static final int PEC_EML_PARAM_ERROR = 2004;
  public static final int PEC_EML_PARSEATTACH_ERROR = 2005;
  public static final int PEC_EML_PARSECONTENT_ERROR = 2003;
  public static final int PEC_EML_PARSEHEAD_ERROR = 2002;
  public static final int PEC_EML_WRONG_PATH = 2000;
  public static final int PEC_FAILED_INIT = 2;
  public static final int PEC_FAILED_RESPONSE = 11;
  public static final int PEC_GMAIL_ERROR = 3003;
  public static final int PEC_IMAP_DENIED_DEL_FOLDER = 4000;
  public static final int PEC_INTERRUPT = 6;
  public static final int PEC_INVALID_CREDENTIALS_ERROR = 2006;
  public static final int PEC_ITEM_NOT_FOUND = 9;
  public static final int PEC_LAST = 17;
  public static final int PEC_LOGIN_DEFAULT_ERROR = 5002;
  public static final int PEC_LOGIN_DENIED_ERROR = 5001;
  public static final int PEC_LOGIN_USER_PASS_ERROR = 5003;
  public static final int PEC_NETWORK_ERROR = 5;
  public static final int PEC_NOT_COMPLETE = -1;
  public static final int PEC_OK = 0;
  public static final int PEC_OPERATION_TIMEOUT = 3;
  public static final int PEC_PARTIAL_FAILURE = 7;
  public static final int PEC_REMOTE_WIPED = 13;
  public static final int PEC_REMOTE_WIPED_ACK = 14;
  public static final int PEC_RESOLVE_ERROR = 10;
  public static final int PEC_RESOLVE_PROXY_ERROR = 5000;
  public static final int PEC_RESPONSE_PARSE_ERROR = 19;
  public static final int PEC_SERVER_NOT_FOUND = 21;
  public static final int PEC_SOCKETSELECT_ERROR = 16;
  public static final int PEC_SSL_ERROR = 8;
  public static final int PEC_SSL_JAVA_ERROR = 20;
  public static final int PEC_TOKEN_EXCEEDED = 3002;
  public static final int PEC_TOKEN_EXPIRED = 3001;
  public static final int PEC_TOKEN_REVOKED = 3000;
  public static final int PEC_UNKNOW_ERROR = -2;
  public static final int PEC_UNSUPPORTED_PROTOCOL = 1;
  public static final String[] desps = { "Unsupported protocol", "Failed to init", "Operation timeout", "Authentication error", "Network error", "Operation interrupt", "Unknown error", "Partial failure", "SSL error", "item not found", "could not resolve server", "response error", "request again", "remote wipe", "Never use!" };
  private static final long serialVersionUID = 1L;
  @ConvertFromProtobuf(getProtoType=com.tencent.qqmail.protocol.ART.ASContact.class, isConvert=true)
  public ASContact[] as_contact_result_list_;
  @ConvertFromProtobuf
  public CCalendar calendar;
  public int detail_code_;
  public String detail_msg_;
  public boolean end_of_result_;
  public int error_code_;
  public String ews_server_address_;
  @ConvertFromProtobuf(getProtoType=ExchangeContent.class, isConvert=true)
  public Exchange.ExchangeContent exchange_content_;
  public String folder_name_;
  @ConvertFromProtobuf(getProtoType=FolderOperationResult.class, isConvert=true)
  public FolderOperationResult folder_operation_result_;
  @ConvertFromProtobuf(getProtoType=ImapCommandStatusResult.class, isConvert=true)
  public ImapCommandStatusResult imap_status_result_;
  public String mail_content_size_;
  public int mail_flags_;
  public int mail_index_;
  public String mail_section_;
  public String mail_uid_;
  public int[] mail_uid_list_;
  protected byte[][] pb_as_contact_result_list_;
  protected byte[] pb_calendar;
  protected byte[] pb_exchange_content_;
  protected byte[] pb_folder_operation_result_;
  protected byte[] pb_imap_status_result_;
  protected byte[][] pb_protocol_info_list_;
  public String ping_response_folder_id_;
  @ConvertFromProtobuf(getProtoType=com.tencent.qqmail.protocol.ART.ProtocolInfo.class, isConvert=true)
  public ProtocolInfo[] protocol_info_list_;
  public String result_;
  public int status_;
  public String url_;
  
  public static String getErrorDesp(int paramInt)
  {
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    switch (paramInt)
    {
    case -1: 
    case 0: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    default: 
      return localQMApplicationContext.getString(2131697352);
    case 1: 
      return localQMApplicationContext.getString(2131697365);
    case 2: 
      return localQMApplicationContext.getString(2131689733);
    case 3: 
      return localQMApplicationContext.getString(2131689729);
    case 4: 
      return localQMApplicationContext.getString(2131689706);
    case 5: 
      return localQMApplicationContext.getString(2131697354);
    case 6: 
      return localQMApplicationContext.getString(2131697355);
    case -2: 
      return localQMApplicationContext.getString(2131689751);
    case 7: 
      return localQMApplicationContext.getString(2131697356);
    case 8: 
      return localQMApplicationContext.getString(2131697364);
    case 9: 
      return localQMApplicationContext.getString(2131697353);
    case 10: 
      return localQMApplicationContext.getString(2131697351);
    case 11: 
      return localQMApplicationContext.getString(2131697360);
    case 12: 
      return localQMApplicationContext.getString(2131697359);
    case 13: 
      return localQMApplicationContext.getString(2131697357);
    }
    return localQMApplicationContext.getString(2131697361);
  }
  
  public static int mapToProtocolResult(int paramInt)
  {
    int i = 5;
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 10: 
    default: 
      i = -2;
    case 1: 
    case 3: 
    case 5: 
      return i;
    case 4: 
      return 4;
    case 2: 
      return 19;
    case 8: 
      return 3001;
    case 9: 
      return 20;
    }
    return 21;
  }
  
  public static class FolderOperationResult
    implements ARTConvert
  {
    public Mail.Folder added_folder_;
    public Mail.Folder deleted_folder_;
    public Mail.Folder update_folder_;
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
    {
      paramBaseProtoBuf = (FolderOperationResult)paramBaseProtoBuf;
      if (paramBaseProtoBuf.added_folder_ != null)
      {
        this.added_folder_ = new Mail.Folder();
        this.added_folder_.ART_ParseProto(paramBaseProtoBuf.added_folder_);
      }
      if (paramBaseProtoBuf.deleted_folder_ != null)
      {
        this.deleted_folder_ = new Mail.Folder();
        this.deleted_folder_.ART_ParseProto(paramBaseProtoBuf.deleted_folder_);
      }
      if (paramBaseProtoBuf.update_folder_ != null)
      {
        this.update_folder_ = new Mail.Folder();
        this.update_folder_.ART_ParseProto(paramBaseProtoBuf.update_folder_);
      }
    }
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  }
  
  public static class ImapCommandStatusResult
    implements ARTConvert
  {
    public String folder_;
    public int messages_;
    public int uidvalidity_;
    public int unseen_;
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
    {
      paramBaseProtoBuf = (ImapCommandStatusResult)paramBaseProtoBuf;
      this.folder_ = paramBaseProtoBuf.folder_;
      this.messages_ = paramBaseProtoBuf.messages_;
      this.unseen_ = paramBaseProtoBuf.unseen_;
      this.uidvalidity_ = paramBaseProtoBuf.uidvalidity_;
    }
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ProtocolResult
 * JD-Core Version:    0.7.0.1
 */