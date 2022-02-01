package com.tencent.qqmail.protocol;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protocol.ART.Actions;
import com.tencent.qqmail.protocol.ART.ActiveSyncOptions;
import com.tencent.qqmail.protocol.ART.Conditions;
import com.tencent.qqmail.protocol.ART.ExchangeContact;
import com.tencent.qqmail.protocol.ART.ExchangeContent;
import com.tencent.qqmail.protocol.ART.ExchangeFolder;
import com.tencent.qqmail.protocol.ART.ExchangeIdentity;
import com.tencent.qqmail.protocol.ART.ExchangeMailAttachment;
import com.tencent.qqmail.protocol.ART.ExchangeMailBody;
import com.tencent.qqmail.protocol.ART.ExchangeMailSummary;
import com.tencent.qqmail.protocol.ART.ExchangeRule;
import com.tencent.qqmail.protocol.ART.MailAddr;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class Exchange
{
  public static final int ACTIVESYNC_FILTER_FILTER_BY_INCOMPLETE_TASKS = 8;
  public static final int ACTIVESYNC_FILTER_NO_FILTER = 0;
  public static final int ACTIVESYNC_FILTER_ONE_DAY = 1;
  public static final int ACTIVESYNC_FILTER_ONE_MONTH = 5;
  public static final int ACTIVESYNC_FILTER_ONE_WEEKS = 3;
  public static final int ACTIVESYNC_FILTER_SIX_MONTH = 7;
  public static final int ACTIVESYNC_FILTER_THREE_DAYS = 2;
  public static final int ACTIVESYNC_FILTER_THREE_MONTH = 6;
  public static final int ACTIVESYNC_FILTER_TWO_WEEKS = 4;
  public static final int EFS_BLUE_FLAG = 6;
  public static final int EFS_FOLLOWUP_ACTIVE = 1;
  public static final int EFS_FOLLOWUP_COMPLETE = 0;
  public static final int EFS_GREEN_FLAG = 4;
  public static final int EFS_NO_FLAG = -1;
  public static final int EFS_ORANGE_FLAG = 3;
  public static final int EFS_PURPLE_FLAG = 2;
  public static final int EFS_RED_FLAG = 7;
  public static final int EFS_YELLOW_FLAG = 5;
  public static final int EFT_DELETEDITEMS = 2;
  public static final int EFT_DRAFTS = 1;
  public static final int EFT_INBOX = 0;
  public static final int EFT_INVALI = 7;
  public static final int EFT_JUNKEMAIL = 6;
  public static final int EFT_MSGFOLDERROOT = 5;
  public static final int EFT_OUTBOX = 3;
  public static final int EFT_SENTITEMS = 4;
  public static final int EIT_CALENDAR_ITEM = 5;
  public static final int EIT_CONTACT = 6;
  public static final int EIT_GROUP_MAIL = 50;
  public static final int EIT_ITEM = 7;
  public static final int EIT_MAIL = 0;
  public static final int EIT_MEETING_CANCELLATION = 4;
  public static final int EIT_MEETING_MESSAGE = 3;
  public static final int EIT_MEETING_REQUEST = 1;
  public static final int EIT_MEETING_RESPONSE = 2;
  public static final int EMCT_HTML = 1;
  public static final int EMCT_TEXT = 2;
  public static final int EMCT_UNKNOWN = 0;
  public static final int EMR_ACCEPT = 0;
  public static final int EMR_DECLINE = 1;
  public static final int EMR_NONE = 4;
  public static final int EMR_TENTATIVE = 2;
  public static final int EMR_UNKNOWN = 3;
  public static final int ESV_2007 = 0;
  public static final int ESV_2010 = 1;
  
  public static class ActiveSyncExtraInfo
  {
    public int filter_type;
    public String folder_id_;
    public boolean hard_delete;
    public boolean isHtml;
    public boolean isItemOperation;
    public boolean isLongId;
    public int limitLen;
    public int local_folder_id_;
    public int mark_type;
    public String parent_id_;
    public boolean replace;
    public boolean save_in_send;
  }
  
  public static class ActiveSyncMobileInfo
  {
    public String imei_;
    public String mobile_operator_;
    public String model_;
    public String name_;
    public String os_;
    public String os_lang_;
    public String phone_number_;
    public String user_agent_;
  }
  
  public static class ActiveSyncOptions
    implements ARTConvert
  {
    public String[] allow_methods_;
    public String[] commands_;
    public String host_;
    public String[] versions_;
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
    {
      paramBaseProtoBuf = (ActiveSyncOptions)paramBaseProtoBuf;
      this.host_ = paramBaseProtoBuf.host_;
      this.versions_ = ((String[])paramBaseProtoBuf.versions_.toArray(new String[paramBaseProtoBuf.versions_.size()]));
      this.commands_ = ((String[])paramBaseProtoBuf.commands_.toArray(new String[paramBaseProtoBuf.commands_.size()]));
      this.allow_methods_ = ((String[])paramBaseProtoBuf.allow_methods_.toArray(new String[paramBaseProtoBuf.allow_methods_.size()]));
    }
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  }
  
  public static class ExchangeContact
    implements ARTConvert
  {
    String email_address_;
    public Exchange.ExchangeIdentity identity_;
    String name_;
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
    {
      paramBaseProtoBuf = (ExchangeContact)paramBaseProtoBuf;
      this.name_ = paramBaseProtoBuf.name_;
      this.email_address_ = paramBaseProtoBuf.email_address_;
    }
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  }
  
  public static class ExchangeContent
    implements ARTConvert
  {
    public String activesync_attach_path_;
    public int activesync_estimate_;
    public HashMap<String, String> activesync_moveitem_mapping_;
    public Exchange.ActiveSyncOptions activesync_options_;
    public boolean activesync_updateaccount_;
    public Exchange.ExchangeMailAttachment[] attachment_list_;
    public Exchange.ExchangeContact[] contact_list_;
    public Exchange.ExchangeMailSummary[] created_mail_list_;
    public Exchange.ExchangeIdentity[] deleted_mail_list_;
    public boolean end_of_result_;
    public boolean end_of_sync_;
    public Exchange.ExchangeIdentity[] failed_mail_list_;
    public Exchange.ExchangeIdentity[] flag_mail_list_;
    public Exchange.ExchangeFolder[] folder_list_;
    public Exchange.ExchangeMailBody mail_body_;
    public Exchange.ExchangeIdentity[] read_mail_list_;
    public Exchange.ExchangeRule[] rule_list_;
    public Exchange.ExchangeMailSummary[] searched_mail_list_;
    public int searched_mail_total_count;
    public String subscription_id_;
    public String sync_state_;
    public Exchange.ExchangeIdentity[] unflag_mail_list_;
    public Exchange.ExchangeIdentity[] unread_mail_list_;
    public Exchange.ExchangeIdentity[] updated_mail_list_;
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
    {
      int j = 0;
      paramBaseProtoBuf = (ExchangeContent)paramBaseProtoBuf;
      this.folder_list_ = new Exchange.ExchangeFolder[paramBaseProtoBuf.folder_list_.size()];
      Iterator localIterator = paramBaseProtoBuf.folder_list_.iterator();
      int i = 0;
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (ExchangeFolder)localIterator.next();
        this.folder_list_[i] = new Exchange.ExchangeFolder();
        this.folder_list_[i].ART_ParseProto((BaseProtoBuf)localObject);
        i += 1;
      }
      this.sync_state_ = paramBaseProtoBuf.sync_state_;
      this.end_of_sync_ = paramBaseProtoBuf.end_of_sync_;
      this.created_mail_list_ = new Exchange.ExchangeMailSummary[paramBaseProtoBuf.created_mail_list_.size()];
      localIterator = paramBaseProtoBuf.created_mail_list_.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (ExchangeMailSummary)localIterator.next();
        this.created_mail_list_[i] = new Exchange.ExchangeMailSummary();
        this.created_mail_list_[i].ART_ParseProto((BaseProtoBuf)localObject);
        i += 1;
      }
      this.deleted_mail_list_ = new Exchange.ExchangeIdentity[paramBaseProtoBuf.deleted_mail_list_.size()];
      localIterator = paramBaseProtoBuf.deleted_mail_list_.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (ExchangeIdentity)localIterator.next();
        this.deleted_mail_list_[i] = new Exchange.ExchangeIdentity();
        this.deleted_mail_list_[i].ART_ParseProto((BaseProtoBuf)localObject);
        i += 1;
      }
      this.updated_mail_list_ = new Exchange.ExchangeIdentity[paramBaseProtoBuf.updated_mail_list_.size()];
      localIterator = paramBaseProtoBuf.updated_mail_list_.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (ExchangeIdentity)localIterator.next();
        this.updated_mail_list_[i] = new Exchange.ExchangeIdentity();
        this.updated_mail_list_[i].ART_ParseProto((BaseProtoBuf)localObject);
        i += 1;
      }
      this.read_mail_list_ = new Exchange.ExchangeIdentity[paramBaseProtoBuf.read_mail_list_.size()];
      localIterator = paramBaseProtoBuf.read_mail_list_.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (ExchangeIdentity)localIterator.next();
        this.read_mail_list_[i] = new Exchange.ExchangeIdentity();
        this.read_mail_list_[i].ART_ParseProto((BaseProtoBuf)localObject);
        i += 1;
      }
      this.unread_mail_list_ = new Exchange.ExchangeIdentity[paramBaseProtoBuf.unread_mail_list_.size()];
      localIterator = paramBaseProtoBuf.unread_mail_list_.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (ExchangeIdentity)localIterator.next();
        this.unread_mail_list_[i] = new Exchange.ExchangeIdentity();
        this.unread_mail_list_[i].ART_ParseProto((BaseProtoBuf)localObject);
        i += 1;
      }
      this.unread_mail_list_ = new Exchange.ExchangeIdentity[paramBaseProtoBuf.unread_mail_list_.size()];
      localIterator = paramBaseProtoBuf.unread_mail_list_.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (ExchangeIdentity)localIterator.next();
        this.unread_mail_list_[i] = new Exchange.ExchangeIdentity();
        this.unread_mail_list_[i].ART_ParseProto((BaseProtoBuf)localObject);
        i += 1;
      }
      this.flag_mail_list_ = new Exchange.ExchangeIdentity[paramBaseProtoBuf.flag_mail_list_.size()];
      localIterator = paramBaseProtoBuf.flag_mail_list_.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (ExchangeIdentity)localIterator.next();
        this.flag_mail_list_[i] = new Exchange.ExchangeIdentity();
        this.flag_mail_list_[i].ART_ParseProto((BaseProtoBuf)localObject);
        i += 1;
      }
      this.unflag_mail_list_ = new Exchange.ExchangeIdentity[paramBaseProtoBuf.unflag_mail_list_.size()];
      localIterator = paramBaseProtoBuf.unflag_mail_list_.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (ExchangeIdentity)localIterator.next();
        this.unflag_mail_list_[i] = new Exchange.ExchangeIdentity();
        this.unflag_mail_list_[i].ART_ParseProto((BaseProtoBuf)localObject);
        i += 1;
      }
      this.failed_mail_list_ = new Exchange.ExchangeIdentity[paramBaseProtoBuf.failed_mail_list_.size()];
      localIterator = paramBaseProtoBuf.failed_mail_list_.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (ExchangeIdentity)localIterator.next();
        this.failed_mail_list_[i] = new Exchange.ExchangeIdentity();
        this.failed_mail_list_[i].ART_ParseProto((BaseProtoBuf)localObject);
        i += 1;
      }
      this.mail_body_ = new Exchange.ExchangeMailBody();
      this.mail_body_.ART_ParseProto(paramBaseProtoBuf.mail_body_);
      this.searched_mail_list_ = new Exchange.ExchangeMailSummary[paramBaseProtoBuf.searched_mail_list_.size()];
      localIterator = paramBaseProtoBuf.searched_mail_list_.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (ExchangeMailSummary)localIterator.next();
        this.searched_mail_list_[i] = new Exchange.ExchangeMailSummary();
        this.searched_mail_list_[i].ART_ParseProto((BaseProtoBuf)localObject);
        i += 1;
      }
      this.searched_mail_total_count = paramBaseProtoBuf.searched_mail_total_count_;
      this.contact_list_ = new Exchange.ExchangeContact[paramBaseProtoBuf.contact_list_.size()];
      localIterator = paramBaseProtoBuf.contact_list_.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (ExchangeContact)localIterator.next();
        this.contact_list_[i] = new Exchange.ExchangeContact();
        this.contact_list_[i].ART_ParseProto((BaseProtoBuf)localObject);
        i += 1;
      }
      this.rule_list_ = new Exchange.ExchangeRule[paramBaseProtoBuf.rule_list_.size()];
      localIterator = paramBaseProtoBuf.rule_list_.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (ExchangeRule)localIterator.next();
        this.rule_list_[i] = new Exchange.ExchangeRule();
        this.rule_list_[i].ART_ParseProto((BaseProtoBuf)localObject);
        i += 1;
      }
      this.end_of_result_ = paramBaseProtoBuf.end_of_result_;
      this.attachment_list_ = new Exchange.ExchangeMailAttachment[paramBaseProtoBuf.attachment_list_.size()];
      localIterator = paramBaseProtoBuf.attachment_list_.iterator();
      i = j;
      while (localIterator.hasNext())
      {
        localObject = (ExchangeMailAttachment)localIterator.next();
        this.attachment_list_[i] = new Exchange.ExchangeMailAttachment();
        this.attachment_list_[i].ART_ParseProto((BaseProtoBuf)localObject);
        i += 1;
      }
      this.subscription_id_ = paramBaseProtoBuf.subscription_id_;
      this.activesync_options_ = new Exchange.ActiveSyncOptions();
      this.activesync_options_.ART_ParseProto(paramBaseProtoBuf.activesync_options_);
      this.activesync_estimate_ = paramBaseProtoBuf.activesync_estimate_;
      this.activesync_attach_path_ = paramBaseProtoBuf.activesync_attach_path_;
      this.activesync_updateaccount_ = paramBaseProtoBuf.activesync_updateaccount_;
    }
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  }
  
  public static class ExchangeFolder
    implements ARTConvert
  {
    public int children_folder_count_;
    public int folder_type_;
    public Exchange.ExchangeIdentity identity_;
    public int mail_total_count_;
    public String name_;
    public String parent_id_;
    public String size_;
    public String sync_state_;
    public int unread_count_;
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
    {
      paramBaseProtoBuf = (ExchangeFolder)paramBaseProtoBuf;
      this.identity_ = new Exchange.ExchangeIdentity();
      this.identity_.ART_ParseProto(paramBaseProtoBuf.identity_);
      this.name_ = paramBaseProtoBuf.name_;
      this.parent_id_ = paramBaseProtoBuf.parent_id_;
      this.sync_state_ = paramBaseProtoBuf.sync_state_;
      this.mail_total_count_ = paramBaseProtoBuf.mail_total_count_;
      this.size_ = paramBaseProtoBuf.size_;
      this.folder_type_ = paramBaseProtoBuf.folder_type_;
      this.children_folder_count_ = paramBaseProtoBuf.children_folder_count_;
      this.unread_count_ = paramBaseProtoBuf.unread_count_;
    }
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  }
  
  public static class ExchangeIdentity
    implements ARTConvert
  {
    public String change_key_;
    public String folder_id_;
    public String id_;
    public long item_manager_id_;
    public String title_;
    public int type_;
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf) {}
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  }
  
  public static class ExchangeMailAttachment
    implements ARTConvert
  {
    public boolean base64_;
    public byte[] content_;
    public String content_id_;
    public String content_location_;
    public String content_type_;
    public String filename_;
    public String filepath_;
    public Exchange.ExchangeIdentity identity_;
    public boolean isInline_;
    public boolean isSuccessDownload_;
    public int size_;
    public int type_;
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
    {
      paramBaseProtoBuf = (ExchangeMailAttachment)paramBaseProtoBuf;
      this.identity_ = new Exchange.ExchangeIdentity();
      this.identity_.ART_ParseProto(paramBaseProtoBuf.identity_);
      this.filename_ = paramBaseProtoBuf.filename_;
      this.content_id_ = paramBaseProtoBuf.content_id_;
      this.content_location_ = paramBaseProtoBuf.content_location_;
      this.content_type_ = paramBaseProtoBuf.content_type_;
      this.size_ = paramBaseProtoBuf.size_;
      this.isInline_ = paramBaseProtoBuf.isInline_;
      this.isSuccessDownload_ = paramBaseProtoBuf.isSuccessDownload_;
      this.type_ = paramBaseProtoBuf.type_;
      this.base64_ = paramBaseProtoBuf.base64_;
      this.filepath_ = paramBaseProtoBuf.filepath_;
    }
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  }
  
  public static class ExchangeMailBody
    implements ARTConvert
  {
    public Exchange.ExchangeMailAttachment[] attachments_list_;
    public String avatar_code_;
    public Exchange.MailAddr[] bcc_;
    public String body_;
    public Exchange.MailAddr[] cc_;
    public String charset_;
    public Date date_time_sent_;
    public String display_to_;
    public String duration_;
    public Date end_time_;
    public int flag_status_;
    public boolean has_attachments_;
    public Exchange.ExchangeIdentity identity_;
    public boolean is_cancelled_;
    public boolean is_out_of_date_;
    public boolean is_read_;
    public boolean is_read_receipt_request_;
    public boolean is_response_requested_;
    public String location_;
    public int meeting_response_;
    public String message_id_;
    public String mime_header_;
    public String reference_;
    public Exchange.MailAddr[] reply_to_;
    public Exchange.MailAddr sender_;
    public int size_;
    public Date start_time_;
    public String subject_;
    public String time_zone_;
    public Exchange.MailAddr[] to_;
    public int type_;
    public String visible_content_;
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
    {
      int j = 0;
      paramBaseProtoBuf = (ExchangeMailBody)paramBaseProtoBuf;
      this.identity_ = new Exchange.ExchangeIdentity();
      this.identity_.ART_ParseProto(paramBaseProtoBuf.identity_);
      this.subject_ = paramBaseProtoBuf.subject_;
      this.size_ = paramBaseProtoBuf.size_;
      this.type_ = paramBaseProtoBuf.type_;
      this.has_attachments_ = paramBaseProtoBuf.has_attachments_;
      this.date_time_sent_ = new Date(paramBaseProtoBuf.date_time_sent_);
      this.body_ = paramBaseProtoBuf.body_;
      this.charset_ = paramBaseProtoBuf.charset_;
      this.message_id_ = paramBaseProtoBuf.message_id_;
      this.is_read_ = paramBaseProtoBuf.is_read_;
      this.reference_ = paramBaseProtoBuf.reference_;
      this.display_to_ = paramBaseProtoBuf.display_to_;
      this.is_out_of_date_ = paramBaseProtoBuf.is_out_of_date_;
      this.start_time_ = new Date(paramBaseProtoBuf.start_time_);
      this.end_time_ = new Date(paramBaseProtoBuf.end_time_);
      this.duration_ = paramBaseProtoBuf.duration_;
      this.time_zone_ = paramBaseProtoBuf.time_zone_;
      this.location_ = paramBaseProtoBuf.location_;
      this.is_cancelled_ = paramBaseProtoBuf.is_cancelled_;
      this.is_response_requested_ = paramBaseProtoBuf.is_response_requested_;
      this.meeting_response_ = paramBaseProtoBuf.meeting_response_;
      this.flag_status_ = paramBaseProtoBuf.flag_status_;
      this.visible_content_ = paramBaseProtoBuf.visible_content_;
      this.mime_header_ = paramBaseProtoBuf.mime_header_;
      this.avatar_code_ = paramBaseProtoBuf.avatar_code_;
      this.is_read_receipt_request_ = paramBaseProtoBuf.is_read_receipt_request_;
      this.attachments_list_ = new Exchange.ExchangeMailAttachment[paramBaseProtoBuf.attachments_list_.size()];
      Object localObject1 = paramBaseProtoBuf.attachments_list_.iterator();
      int i = 0;
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ExchangeMailAttachment)((Iterator)localObject1).next();
        this.attachments_list_[i] = new Exchange.ExchangeMailAttachment();
        this.attachments_list_[i].ART_ParseProto((BaseProtoBuf)localObject2);
        i += 1;
      }
      this.sender_ = new Exchange.MailAddr();
      this.sender_.ART_ParseProto(paramBaseProtoBuf.sender_);
      this.to_ = new Exchange.MailAddr[paramBaseProtoBuf.to_.size()];
      localObject1 = paramBaseProtoBuf.to_.iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MailAddr)((Iterator)localObject1).next();
        this.to_[i] = new Exchange.MailAddr();
        this.to_[i].ART_ParseProto((BaseProtoBuf)localObject2);
        i += 1;
      }
      this.cc_ = new Exchange.MailAddr[paramBaseProtoBuf.cc_.size()];
      localObject1 = paramBaseProtoBuf.cc_.iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MailAddr)((Iterator)localObject1).next();
        this.cc_[i] = new Exchange.MailAddr();
        this.cc_[i].ART_ParseProto((BaseProtoBuf)localObject2);
        i += 1;
      }
      this.bcc_ = new Exchange.MailAddr[paramBaseProtoBuf.bcc_.size()];
      localObject1 = paramBaseProtoBuf.bcc_.iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MailAddr)((Iterator)localObject1).next();
        this.bcc_[i] = new Exchange.MailAddr();
        this.bcc_[i].ART_ParseProto((BaseProtoBuf)localObject2);
        i += 1;
      }
      this.reply_to_ = new Exchange.MailAddr[paramBaseProtoBuf.reply_to_.size()];
      paramBaseProtoBuf = paramBaseProtoBuf.reply_to_.iterator();
      i = j;
      while (paramBaseProtoBuf.hasNext())
      {
        localObject1 = (MailAddr)paramBaseProtoBuf.next();
        this.reply_to_[i] = new Exchange.MailAddr();
        this.reply_to_[i].ART_ParseProto((BaseProtoBuf)localObject1);
        i += 1;
      }
    }
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  }
  
  public static class ExchangeMailSummary
    implements ARTConvert
  {
    public String abstract_;
    public Exchange.ExchangeMailAttachment[] attachments_list_;
    public Exchange.MailAddr[] cc_;
    public Date date_time_sent_;
    public String display_to_;
    public String duration_;
    public Date end_time_;
    public int flag_status_;
    public boolean has_attachments_;
    public Exchange.ExchangeIdentity identity_;
    public boolean is_cancelled_;
    public boolean is_out_of_date_;
    public boolean is_read_;
    public boolean is_read_receipt_request_;
    public boolean is_response_requested_;
    public String location_;
    public int meeting_response_;
    public String message_id_;
    public Exchange.MailAddr sender_;
    public int size_;
    public Date start_time_;
    public String subject_;
    public String time_zone_;
    public Exchange.MailAddr[] to_;
    public int type_;
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
    {
      int j = 0;
      paramBaseProtoBuf = (ExchangeMailSummary)paramBaseProtoBuf;
      this.identity_ = new Exchange.ExchangeIdentity();
      this.identity_.ART_ParseProto(paramBaseProtoBuf.identity_);
      this.subject_ = paramBaseProtoBuf.subject_;
      this.size_ = paramBaseProtoBuf.size_;
      this.type_ = paramBaseProtoBuf.type_;
      this.has_attachments_ = paramBaseProtoBuf.has_attachments_;
      this.date_time_sent_ = new Date(paramBaseProtoBuf.date_time_sent_);
      this.display_to_ = paramBaseProtoBuf.display_to_;
      this.abstract_ = paramBaseProtoBuf.abstract_;
      this.message_id_ = paramBaseProtoBuf.message_id_;
      this.is_read_ = paramBaseProtoBuf.is_read_;
      this.is_out_of_date_ = paramBaseProtoBuf.is_out_of_date_;
      this.start_time_ = new Date(paramBaseProtoBuf.start_time_);
      this.end_time_ = new Date(paramBaseProtoBuf.end_time_);
      this.duration_ = paramBaseProtoBuf.duration_;
      this.time_zone_ = paramBaseProtoBuf.time_zone_;
      this.location_ = paramBaseProtoBuf.location_;
      this.is_cancelled_ = paramBaseProtoBuf.is_cancelled_;
      this.is_response_requested_ = paramBaseProtoBuf.is_response_requested_;
      this.meeting_response_ = paramBaseProtoBuf.meeting_response_;
      this.flag_status_ = paramBaseProtoBuf.flag_status_;
      this.is_read_receipt_request_ = paramBaseProtoBuf.is_read_receipt_request_;
      this.attachments_list_ = new Exchange.ExchangeMailAttachment[paramBaseProtoBuf.attachments_list_.size()];
      Object localObject1 = paramBaseProtoBuf.attachments_list_.iterator();
      int i = 0;
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ExchangeMailAttachment)((Iterator)localObject1).next();
        this.attachments_list_[i] = new Exchange.ExchangeMailAttachment();
        this.attachments_list_[i].ART_ParseProto((BaseProtoBuf)localObject2);
        i += 1;
      }
      this.sender_ = new Exchange.MailAddr();
      this.sender_.ART_ParseProto(paramBaseProtoBuf.sender_);
      this.to_ = new Exchange.MailAddr[paramBaseProtoBuf.to_.size()];
      localObject1 = paramBaseProtoBuf.to_.iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MailAddr)((Iterator)localObject1).next();
        this.to_[i] = new Exchange.MailAddr();
        this.to_[i].ART_ParseProto((BaseProtoBuf)localObject2);
        i += 1;
      }
      this.cc_ = new Exchange.MailAddr[paramBaseProtoBuf.cc_.size()];
      paramBaseProtoBuf = paramBaseProtoBuf.cc_.iterator();
      i = j;
      while (paramBaseProtoBuf.hasNext())
      {
        localObject1 = (MailAddr)paramBaseProtoBuf.next();
        this.cc_[i] = new Exchange.MailAddr();
        this.cc_[i].ART_ParseProto((BaseProtoBuf)localObject1);
        i += 1;
      }
    }
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  }
  
  public static class ExchangeMeetingInvitation
  {
    public Exchange.ExchangeMailAttachment attachments;
    public Map.Entry<String, String>[] attendees_address;
    public int content_type;
    public Date end;
    public boolean is_all_day_event;
    public boolean is_set_reminder;
    public String location;
    public String mail_content;
    public Map.Entry<String, String>[] optional_attendees_address;
    public String reminder_minutes_before_start;
    public Date start;
    public String subject;
  }
  
  public static class ExchangeRule
    implements ARTConvert
  {
    public Actions actions_;
    public Conditions conditions_;
    public String display_name_;
    public String id_;
    public boolean is_enabled_;
    public int priority_;
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
    {
      paramBaseProtoBuf = (ExchangeRule)paramBaseProtoBuf;
      this.id_ = paramBaseProtoBuf.id_;
      this.display_name_ = paramBaseProtoBuf.display_name_;
      this.priority_ = paramBaseProtoBuf.priority_;
      this.is_enabled_ = paramBaseProtoBuf.is_enabled_;
      this.conditions_ = new Conditions();
      this.conditions_.ART_ParseProto(paramBaseProtoBuf.conditions_);
      this.actions_ = new Actions();
      this.actions_.ART_ParseProto(paramBaseProtoBuf.actions_);
    }
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
    
    public static class Actions
      implements ARTConvert
    {
      public String des_folder_id_;
      public int des_folder_type_;
      public boolean mark_as_read_;
      public boolean soft_delete_mail_;
      public boolean stop_subsequent_rules;
      
      public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
      {
        paramBaseProtoBuf = (Actions)paramBaseProtoBuf;
        this.des_folder_id_ = paramBaseProtoBuf.des_folder_id_;
        this.des_folder_type_ = paramBaseProtoBuf.des_folder_type_;
        this.mark_as_read_ = paramBaseProtoBuf.mark_as_read_;
        this.soft_delete_mail_ = paramBaseProtoBuf.soft_delete_mail_;
        this.soft_delete_mail_ = paramBaseProtoBuf.soft_delete_mail_;
      }
      
      public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
    }
    
    public static class Conditions
      implements ARTConvert
    {
      public String sender_;
      public String subject_;
      public String to_;
      
      public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
      {
        paramBaseProtoBuf = (Conditions)paramBaseProtoBuf;
        this.sender_ = paramBaseProtoBuf.sender_;
        this.to_ = paramBaseProtoBuf.to_;
        this.subject_ = paramBaseProtoBuf.subject_;
      }
      
      public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
    }
  }
  
  public static class MailAddr
    implements ARTConvert
  {
    String addr_;
    String label_;
    
    public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
    {
      paramBaseProtoBuf = (MailAddr)paramBaseProtoBuf;
      this.label_ = paramBaseProtoBuf.label_;
      this.addr_ = paramBaseProtoBuf.addr_;
    }
    
    public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.Exchange
 * JD-Core Version:    0.7.0.1
 */