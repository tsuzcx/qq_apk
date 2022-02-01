package appoint.define;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define
{
  public static final class ADFeed
    extends MessageMicro<ADFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_task_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_task_id", "uint32_style", "bytes_content" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, ADFeed.class);
    }
  }
  
  public static final class ADFeedContent
    extends MessageMicro<ADFeedContent>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 66, 74 }, new String[] { "msg_user_info", "rpt_str_pic_url", "msg_text", "str_attend_info", "str_action_url", "uint32_publish_time", "msg_hot_topic_list", "str_more_url", "str_record_duration" }, new Object[] { null, "", null, "", "", Integer.valueOf(0), null, "", "" }, ADFeedContent.class);
    public appoint_define.HotTopicList msg_hot_topic_list = new appoint_define.HotTopicList();
    public appoint_define.RichText msg_text = new appoint_define.RichText();
    public appoint_define.UserInfo msg_user_info = new appoint_define.UserInfo();
    public final PBRepeatField<String> rpt_str_pic_url = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField str_action_url = PBField.initString("");
    public final PBStringField str_attend_info = PBField.initString("");
    public final PBStringField str_more_url = PBField.initString("");
    public final PBStringField str_record_duration = PBField.initString("");
    public final PBUInt32Field uint32_publish_time = PBField.initUInt32(0);
  }
  
  public static final class ActivityInfo
    extends MessageMicro<ActivityInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 58, 64, 72, 80, 90, 96 }, new String[] { "id", "name", "cover", "url", "start_time", "end_time", "loc_name", "enroll", "create_uin", "create_time", "organizer_info", "uint64_flag" }, new Object[] { "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, Long.valueOf(0L) }, ActivityInfo.class);
    public final PBStringField cover = PBField.initString("");
    public final PBUInt32Field create_time = PBField.initUInt32(0);
    public final PBUInt64Field create_uin = PBField.initUInt64(0L);
    public final PBUInt32Field end_time = PBField.initUInt32(0);
    public final PBUInt64Field enroll = PBField.initUInt64(0L);
    public final PBStringField id = PBField.initString("");
    public final PBStringField loc_name = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public appoint_define.OrganizerInfo organizer_info = new appoint_define.OrganizerInfo();
    public final PBUInt32Field start_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_flag = PBField.initUInt64(0L);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class AddressInfo
    extends MessageMicro<AddressInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "str_company_zone", "str_company_name", "str_company_addr", "str_company_pic_url", "str_company_url", "msg_company_id" }, new Object[] { "", "", "", "", "", null }, AddressInfo.class);
    public appoint_define.ShopID msg_company_id = new appoint_define.ShopID();
    public final PBStringField str_company_addr = PBField.initString("");
    public final PBStringField str_company_name = PBField.initString("");
    public final PBStringField str_company_pic_url = PBField.initString("");
    public final PBStringField str_company_url = PBField.initString("");
    public final PBStringField str_company_zone = PBField.initString("");
  }
  
  public static final class AppointContent
    extends MessageMicro<AppointContent>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58 }, new String[] { "uint32_appoint_subject", "uint32_pay_type", "uint32_appoint_date", "uint32_appoint_gender", "str_appoint_introduce", "msg_appoint_address", "msg_travel_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null, null }, AppointContent.class);
    public appoint_define.AddressInfo msg_appoint_address = new appoint_define.AddressInfo();
    public appoint_define.TravelInfo msg_travel_info = new appoint_define.TravelInfo();
    public final PBStringField str_appoint_introduce = PBField.initString("");
    public final PBUInt32Field uint32_appoint_date = PBField.initUInt32(0);
    public final PBUInt32Field uint32_appoint_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_appoint_subject = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pay_type = PBField.initUInt32(0);
  }
  
  public static final class AppointID
    extends MessageMicro<AppointID>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_request_id" }, new Object[] { "" }, AppointID.class);
    public final PBStringField str_request_id = PBField.initString("");
  }
  
  public static final class AppointInfo
    extends MessageMicro<AppointInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 56, 64, 72, 82, 88, 96, 106 }, new String[] { "msg_appoint_id", "msg_appointment", "uint32_appoint_status", "str_join_wording", "str_view_wording", "uint32_unread_count", "uint32_owner", "uint32_join", "uint32_view", "str_comment_wording", "uint32_comment_num", "uint32_attend_status", "msg_appointment_ex" }, new Object[] { null, null, Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), null }, AppointInfo.class);
    public appoint_define.AppointID msg_appoint_id = new appoint_define.AppointID();
    public appoint_define.AppointContent msg_appointment = new appoint_define.AppointContent();
    public appoint_define.AppointInfoEx msg_appointment_ex = new appoint_define.AppointInfoEx();
    public final PBStringField str_comment_wording = PBField.initString("");
    public final PBStringField str_join_wording = PBField.initString("");
    public final PBStringField str_view_wording = PBField.initString("");
    public final PBUInt32Field uint32_appoint_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_attend_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comment_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_join = PBField.initUInt32(0);
    public final PBUInt32Field uint32_owner = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_view = PBField.initUInt32(0);
  }
  
  public static final class AppointInfoEx
    extends MessageMicro<AppointInfoEx>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 64 }, new String[] { "str_feeds_pic_url", "str_feeds_url", "str_detail_title", "str_detail_describe", "uint32_show_publisher", "str_detail_pic_url", "str_detail_url", "uint32_show_attend" }, new Object[] { "", "", "", "", Integer.valueOf(0), "", "", Integer.valueOf(0) }, AppointInfoEx.class);
    public final PBStringField str_detail_describe = PBField.initString("");
    public final PBStringField str_detail_pic_url = PBField.initString("");
    public final PBStringField str_detail_title = PBField.initString("");
    public final PBStringField str_detail_url = PBField.initString("");
    public final PBStringField str_feeds_pic_url = PBField.initString("");
    public final PBStringField str_feeds_url = PBField.initString("");
    public final PBUInt32Field uint32_show_attend = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_publisher = PBField.initUInt32(0);
  }
  
  public static final class Cell
    extends MessageMicro<Cell>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "int32_mcc", "int32_mnc", "int32_lac", "int32_cellid", "int32_rssi" }, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(0) }, Cell.class);
    public final PBInt32Field int32_cellid = PBField.initInt32(-1);
    public final PBInt32Field int32_lac = PBField.initInt32(-1);
    public final PBInt32Field int32_mcc = PBField.initInt32(-1);
    public final PBInt32Field int32_mnc = PBField.initInt32(-1);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
  }
  
  public static final class CommonLabel
    extends MessageMicro<CommonLabel>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_lable_msg_last = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_lable_msg_pre = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> rpt_interst_name = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_interst_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_lable_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "uint32_lable_id", "bytes_lable_msg_pre", "bytes_lable_msg_last", "rpt_interst_name", "rpt_interst_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, CommonLabel.class);
    }
  }
  
  public static final class DateComment
    extends MessageMicro<DateComment>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 50, 56, 66 }, new String[] { "str_comment_id", "msg_appoint_id", "msg_publisher_info", "uint32_time", "msg_reply_info", "uint32_flag", "msg_content" }, new Object[] { "", null, null, Integer.valueOf(0), null, Integer.valueOf(0), null }, DateComment.class);
    public appoint_define.AppointID msg_appoint_id = new appoint_define.AppointID();
    public appoint_define.RichText msg_content = new appoint_define.RichText();
    public appoint_define.StrangerInfo msg_publisher_info = new appoint_define.StrangerInfo();
    public appoint_define.ReplyInfo msg_reply_info = new appoint_define.ReplyInfo();
    public final PBStringField str_comment_id = PBField.initString("");
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  }
  
  public static final class DateEvent
    extends MessageMicro<DateEvent>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58, 66, 72 }, new String[] { "uint64_event_id", "uint32_time", "uint32_type", "msg_user_info", "msg_date_info", "uint32_attend_idx", "str_event_tips", "msg_comment", "uint64_cancel_event_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0), "", null, Long.valueOf(0L) }, DateEvent.class);
    public appoint_define.DateComment msg_comment = new appoint_define.DateComment();
    public appoint_define.AppointInfo msg_date_info = new appoint_define.AppointInfo();
    public appoint_define.StrangerInfo msg_user_info = new appoint_define.StrangerInfo();
    public final PBStringField str_event_tips = PBField.initString("");
    public final PBUInt32Field uint32_attend_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_cancel_event_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_event_id = PBField.initUInt64(0L);
  }
  
  public static final class Elem
    extends MessageMicro<Elem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_content", "msg_face_info" }, new Object[] { "", null }, Elem.class);
    public appoint_define.Face msg_face_info = new appoint_define.Face();
    public final PBStringField str_content = PBField.initString("");
  }
  
  public static final class Face
    extends MessageMicro<Face>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_index" }, new Object[] { Integer.valueOf(0) }, Face.class);
    public final PBUInt32Field uint32_index = PBField.initUInt32(0);
  }
  
  public static final class Feed
    extends MessageMicro<Feed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_user_info", "msg_feed_info", "uint32_owner_flag" }, new Object[] { null, null, Integer.valueOf(0) }, Feed.class);
    public appoint_define.FeedInfo msg_feed_info = new appoint_define.FeedInfo();
    public appoint_define.PublisherInfo msg_user_info = new appoint_define.PublisherInfo();
    public final PBUInt32Field uint32_owner_flag = PBField.initUInt32(0);
  }
  
  public static final class FeedComment
    extends MessageMicro<FeedComment>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 50, 56, 66, 72 }, new String[] { "str_comment_id", "str_feed_id", "msg_publisher_info", "uint32_time", "msg_reply_info", "uint32_flag", "msg_content", "uint32_hot" }, new Object[] { "", "", null, Integer.valueOf(0), null, Integer.valueOf(0), null, Integer.valueOf(0) }, FeedComment.class);
    public appoint_define.RichText msg_content = new appoint_define.RichText();
    public appoint_define.StrangerInfo msg_publisher_info = new appoint_define.StrangerInfo();
    public appoint_define.ReplyInfo msg_reply_info = new appoint_define.ReplyInfo();
    public final PBStringField str_comment_id = PBField.initString("");
    public final PBStringField str_feed_id = PBField.initString("");
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_hot = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  }
  
  public static final class FeedContent
    extends MessageMicro<FeedContent>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_private_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public appoint_define.ADFeed msg_ad = new appoint_define.ADFeed();
    public appoint_define.LocaleInfo msg_locale = new appoint_define.LocaleInfo();
    public appoint_define.RichText msg_text = new appoint_define.RichText();
    public final PBRepeatField<String> rpt_str_pic_url = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField str_group_bulletin = PBField.initString("");
    public final PBStringField str_group_name = PBField.initString("");
    public final PBStringField str_href_url = PBField.initString("");
    public final PBStringField str_poi_id = PBField.initString("");
    public final PBStringField str_poi_title = PBField.initString("");
    public final PBUInt32Field uint32_effective_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expiation_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feed_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feeds_index = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 42, 50, 56, 66, 74, 160, 168, 178, 184, 194, 202 }, new String[] { "rpt_str_pic_url", "msg_text", "str_href_url", "str_group_name", "str_group_bulletin", "uint32_feed_type", "str_poi_id", "str_poi_title", "uint32_effective_time", "uint32_expiation_time", "msg_locale", "uint32_feeds_index", "msg_ad", "bytes_private_data" }, new Object[] { "", null, "", "", "", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null, localByteStringMicro }, FeedContent.class);
    }
  }
  
  public static final class FeedEvent
    extends MessageMicro<FeedEvent>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64 }, new String[] { "uint64_event_id", "uint32_time", "uint32_eventtype", "msg_user_info", "msg_feed_info", "str_event_tips", "msg_comment", "uint64_cancel_event_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null, "", null, Long.valueOf(0L) }, FeedEvent.class);
    public appoint_define.FeedComment msg_comment = new appoint_define.FeedComment();
    public appoint_define.FeedInfo msg_feed_info = new appoint_define.FeedInfo();
    public appoint_define.StrangerInfo msg_user_info = new appoint_define.StrangerInfo();
    public final PBStringField str_event_tips = PBField.initString("");
    public final PBUInt32Field uint32_eventtype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_cancel_event_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_event_id = PBField.initUInt64(0L);
  }
  
  public static final class FeedInfo
    extends MessageMicro<FeedInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 66, 72, 82, 88, 96, 104, 114 }, new String[] { "uint64_feed_type", "str_feed_id", "msg_feed_content", "msg_topic_info", "uint32_publish_time", "uint32_praise_count", "uint32_praise_flag", "rpt_msg_praise_user", "uint32_comment_count", "rpt_msg_comment_list", "uint32_comment_ret_all", "uint32_hot_flag", "uint64_svr_reserved", "msg_hot_entry" }, new Object[] { Long.valueOf(0L), "", null, null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null }, FeedInfo.class);
    public appoint_define.FeedContent msg_feed_content = new appoint_define.FeedContent();
    public appoint_define.HotEntry msg_hot_entry = new appoint_define.HotEntry();
    public appoint_define.NearbyTopic msg_topic_info = new appoint_define.NearbyTopic();
    public final PBRepeatMessageField<appoint_define.FeedComment> rpt_msg_comment_list = PBField.initRepeatMessage(appoint_define.FeedComment.class);
    public final PBRepeatMessageField<appoint_define.StrangerInfo> rpt_msg_praise_user = PBField.initRepeatMessage(appoint_define.StrangerInfo.class);
    public final PBStringField str_feed_id = PBField.initString("");
    public final PBUInt32Field uint32_comment_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comment_ret_all = PBField.initUInt32(0);
    public final PBUInt32Field uint32_hot_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint32_publish_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feed_type = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_svr_reserved = PBField.initUInt64(0L);
  }
  
  public static final class FeedsCookie
    extends MessageMicro<FeedsCookie>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<String> rpt_str_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uint64_topics = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_pose = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "rpt_str_list", "uint32_pose", "bytes_cookie", "rpt_uint64_topics" }, new Object[] { "", Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L) }, FeedsCookie.class);
    }
  }
  
  public static final class FreshFeedInfo
    extends MessageMicro<FreshFeedInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_uin", "uint32_time", "str_feed_id", "uint64_feed_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L) }, FreshFeedInfo.class);
    public final PBStringField str_feed_id = PBField.initString("");
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feed_type = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GPS
    extends MessageMicro<GPS>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int32_lat", "int32_lon", "int32_alt", "int32_type" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), Integer.valueOf(-10000000), Integer.valueOf(0) }, GPS.class);
    public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public final PBInt32Field int32_type = PBField.initInt32(0);
  }
  
  public static final class HotEntry
    extends MessageMicro<HotEntry>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_open_flag", "uint32_rest_time", "str_foreword", "str_background_src" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "" }, HotEntry.class);
    public final PBStringField str_background_src = PBField.initString("");
    public final PBStringField str_foreword = PBField.initString("");
    public final PBUInt32Field uint32_open_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rest_time = PBField.initUInt32(0);
  }
  
  public static final class HotFreshFeedList
    extends MessageMicro<HotFreshFeedList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_msg_feeds", "uint32_update_time" }, new Object[] { null, Integer.valueOf(0) }, HotFreshFeedList.class);
    public final PBRepeatMessageField<appoint_define.HotUserFeed> rpt_msg_feeds = PBField.initRepeatMessage(appoint_define.HotUserFeed.class);
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
  }
  
  public static final class HotTopic
    extends MessageMicro<HotTopic>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 58, 66, 74 }, new String[] { "uint64_id", "str_title", "uint64_topic_type", "uint64_total", "uint64_times", "uint64_history_times", "str_bg_url", "str_url", "str_extra_info" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", "" }, HotTopic.class);
    public final PBStringField str_bg_url = PBField.initString("");
    public final PBStringField str_extra_info = PBField.initString("");
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt64Field uint64_history_times = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_times = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_topic_type = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_total = PBField.initUInt64(0L);
  }
  
  public static final class HotTopicList
    extends MessageMicro<HotTopicList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_topic_list" }, new Object[] { null }, HotTopicList.class);
    public final PBRepeatMessageField<appoint_define.HotTopic> rpt_topic_list = PBField.initRepeatMessage(appoint_define.HotTopic.class);
  }
  
  public static final class HotUserFeed
    extends MessageMicro<HotUserFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "str_feed_id", "uint32_praise_count", "uint64_publish_uid", "uint32_publish_time" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, HotUserFeed.class);
    public final PBStringField str_feed_id = PBField.initString("");
    public final PBUInt32Field uint32_praise_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_publish_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_publish_uid = PBField.initUInt64(0L);
  }
  
  public static final class InterestItem
    extends MessageMicro<InterestItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 64, 72, 82, 90, 96 }, new String[] { "uint64_tag_id", "str_tag_name", "str_tag_icon_url", "str_tag_href", "str_tag_back_color", "str_tag_font_color", "str_tag_vid", "uint32_tag_type", "uint32_add_time", "str_tag_category", "str_tag_other_url", "uint32_bid" }, new Object[] { Long.valueOf(0L), "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) }, InterestItem.class);
    public final PBStringField str_tag_back_color = PBField.initString("");
    public final PBStringField str_tag_category = PBField.initString("");
    public final PBStringField str_tag_font_color = PBField.initString("");
    public final PBStringField str_tag_href = PBField.initString("");
    public final PBStringField str_tag_icon_url = PBField.initString("");
    public final PBStringField str_tag_name = PBField.initString("");
    public final PBStringField str_tag_other_url = PBField.initString("");
    public final PBStringField str_tag_vid = PBField.initString("");
    public final PBUInt32Field uint32_add_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tag_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tag_id = PBField.initUInt64(0L);
  }
  
  public static final class InterestTag
    extends MessageMicro<InterestTag>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_tag_type", "rpt_msg_tag_list" }, new Object[] { Integer.valueOf(0), null }, InterestTag.class);
    public final PBRepeatMessageField<appoint_define.InterestItem> rpt_msg_tag_list = PBField.initRepeatMessage(appoint_define.InterestItem.class);
    public final PBUInt32Field uint32_tag_type = PBField.initUInt32(0);
  }
  
  public static final class LBSInfo
    extends MessageMicro<LBSInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_gps", "rpt_msg_wifis", "rpt_msg_cells" }, new Object[] { null, null, null }, LBSInfo.class);
    public appoint_define.GPS msg_gps = new appoint_define.GPS();
    public final PBRepeatMessageField<appoint_define.Cell> rpt_msg_cells = PBField.initRepeatMessage(appoint_define.Cell.class);
    public final PBRepeatMessageField<appoint_define.Wifi> rpt_msg_wifis = PBField.initRepeatMessage(appoint_define.Wifi.class);
  }
  
  public static final class LocaleInfo
    extends MessageMicro<LocaleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "str_name", "str_country", "str_province", "str_city", "str_region", "str_poi", "msg_gps", "str_address" }, new Object[] { "", "", "", "", "", "", null, "" }, LocaleInfo.class);
    public appoint_define.GPS msg_gps = new appoint_define.GPS();
    public final PBStringField str_address = PBField.initString("");
    public final PBStringField str_city = PBField.initString("");
    public final PBStringField str_country = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_poi = PBField.initString("");
    public final PBStringField str_province = PBField.initString("");
    public final PBStringField str_region = PBField.initString("");
  }
  
  public static final class NearbyEvent
    extends MessageMicro<NearbyEvent>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_eventtype", "msg_rankevent", "uint64_event_uin", "uint64_event_tinyid" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L) }, NearbyEvent.class);
    public appoint_define.RankEvent msg_rankevent = new appoint_define.RankEvent();
    public final PBUInt32Field uint32_eventtype = PBField.initUInt32(0);
    public final PBUInt64Field uint64_event_tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_event_uin = PBField.initUInt64(0L);
  }
  
  public static final class NearbyTopic
    extends MessageMicro<NearbyTopic>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 66, 74, 82, 88, 96, 104, 112, 120, 128, 136, 146 }, new String[] { "uint64_topic_id", "str_topic", "str_foreword", "uint32_create_time", "uint32_update_time", "uint32_hot_flag", "uint32_button_style", "str_button_src", "str_background_src", "str_attendee_info", "uint32_index", "uint32_publish_scope", "uint32_effective_time", "uint32_expiation_time", "uint32_pushed_usr_count", "uint32_timerange_left", "uint32_timerange_right", "str_area" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, NearbyTopic.class);
    public final PBStringField str_area = PBField.initString("");
    public final PBStringField str_attendee_info = PBField.initString("");
    public final PBStringField str_background_src = PBField.initString("");
    public final PBStringField str_button_src = PBField.initString("");
    public final PBStringField str_foreword = PBField.initString("");
    public final PBStringField str_topic = PBField.initString("");
    public final PBUInt32Field uint32_button_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_effective_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expiation_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_hot_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_publish_scope = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pushed_usr_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timerange_left = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timerange_right = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
  }
  
  public static final class OrganizerInfo
    extends MessageMicro<OrganizerInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "host_name", "host_url", "host_cover" }, new Object[] { "", "", "" }, OrganizerInfo.class);
    public final PBStringField host_cover = PBField.initString("");
    public final PBStringField host_name = PBField.initString("");
    public final PBStringField host_url = PBField.initString("");
  }
  
  public static final class PublisherInfo
    extends MessageMicro<PublisherInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_stranger_declare = PBField.initBytes(ByteStringMicro.EMPTY);
    public appoint_define.CommonLabel msg_common_label = new appoint_define.CommonLabel();
    public final PBStringField str_constellation = PBField.initString("");
    public final PBStringField str_distance = PBField.initString("");
    public final PBStringField str_vipinfo = PBField.initString("");
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charm_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chatflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chatup_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_godflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_history_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_marriage = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pub_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recent_vistor_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recommend = PBField.initUInt32(0);
    public final PBUInt64Field uint64_followflag = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_friend_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 58, 64, 74, 80, 88, 96, 104, 112, 120, 128, 138, 144, 154, 160, 168, 176 }, new String[] { "uint64_tinyid", "bytes_nickname", "uint32_age", "uint32_gender", "str_constellation", "uint32_profession", "str_distance", "uint32_marriage", "str_vipinfo", "uint32_recommend", "uint32_godflag", "uint32_chatflag", "uint32_chatup_count", "uint32_charm", "uint32_charm_level", "uint32_pub_number", "msg_common_label", "uint32_recent_vistor_time", "bytes_stranger_declare", "uint64_friend_uin", "uint32_history_flag", "uint64_followflag" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, PublisherInfo.class);
    }
  }
  
  public static final class RankEvent
    extends MessageMicro<RankEvent>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint32_listtype", "uint32_notifytype", "uint32_eventtime", "uint32_seq", "str_notify_tips" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, RankEvent.class);
    public final PBStringField str_notify_tips = PBField.initString("");
    public final PBUInt32Field uint32_eventtime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_listtype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_notifytype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
  
  public static final class RecentFreshFeed
    extends MessageMicro<RecentFreshFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_fresh_feed_info", "uint64_uid" }, new Object[] { null, Long.valueOf(0L) }, RecentFreshFeed.class);
    public final PBRepeatMessageField<appoint_define.FreshFeedInfo> rpt_fresh_feed_info = PBField.initRepeatMessage(appoint_define.FreshFeedInfo.class);
    public final PBUInt64Field uint64_uid = PBField.initUInt64(0L);
  }
  
  public static final class RecentVistorEvent
    extends MessageMicro<RecentVistorEvent>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_eventtype", "uint64_event_tinyid", "uint64_unread_count" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, RecentVistorEvent.class);
    public final PBUInt32Field uint32_eventtype = PBField.initUInt32(0);
    public final PBUInt64Field uint64_event_tinyid = PBField.initUInt64(0L);
    public final PBUInt32Field uint64_unread_count = PBField.initUInt32(0);
  }
  
  public static final class ReplyInfo
    extends MessageMicro<ReplyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_comment_id", "msg_stranger_info" }, new Object[] { "", null }, ReplyInfo.class);
    public appoint_define.StrangerInfo msg_stranger_info = new appoint_define.StrangerInfo();
    public final PBStringField str_comment_id = PBField.initString("");
  }
  
  public static final class RichText
    extends MessageMicro<RichText>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_elems" }, new Object[] { null }, RichText.class);
    public final PBRepeatMessageField<appoint_define.Elem> rpt_msg_elems = PBField.initRepeatMessage(appoint_define.Elem.class);
  }
  
  public static final class RptInterestTag
    extends MessageMicro<RptInterestTag>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_interest_tags" }, new Object[] { null }, RptInterestTag.class);
    public final PBRepeatMessageField<appoint_define.InterestTag> rpt_interest_tags = PBField.initRepeatMessage(appoint_define.InterestTag.class);
  }
  
  public static final class ShopID
    extends MessageMicro<ShopID>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_shopid", "uint32_sp" }, new Object[] { "", Integer.valueOf(0) }, ShopID.class);
    public final PBStringField str_shopid = PBField.initString("");
    public final PBUInt32Field uint32_sp = PBField.initUInt32(0);
  }
  
  public static final class StrangerInfo
    extends MessageMicro<StrangerInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_constellation = PBField.initString("");
    public final PBStringField str_vipinfo = PBField.initString("");
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charm_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dating = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_godflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_list_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_marriage = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recommend = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 58, 64, 72, 82, 88, 96, 104, 112, 120 }, new String[] { "uint64_tinyid", "bytes_nickname", "uint32_age", "uint32_gender", "uint32_dating", "uint32_list_idx", "str_constellation", "uint32_profession", "uint32_marriage", "str_vipinfo", "uint32_recommend", "uint32_godflag", "uint32_charm", "uint32_charm_level", "uint64_uin" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, StrangerInfo.class);
    }
  }
  
  public static final class TravelInfo
    extends MessageMicro<TravelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50 }, new String[] { "msg_depart_locale", "msg_destination", "uint32_vehicle", "uint32_partner_count", "str_place_pic_url", "str_place_url" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), "", "" }, TravelInfo.class);
    public appoint_define.LocaleInfo msg_depart_locale = new appoint_define.LocaleInfo();
    public appoint_define.LocaleInfo msg_destination = new appoint_define.LocaleInfo();
    public final PBStringField str_place_pic_url = PBField.initString("");
    public final PBStringField str_place_url = PBField.initString("");
    public final PBUInt32Field uint32_partner_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vehicle = PBField.initUInt32(0);
  }
  
  public static final class UserFeed
    extends MessageMicro<UserFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "msg_user_info", "msg_feed_info", "uint32_owner_flag", "msg_activity_info" }, new Object[] { null, null, Integer.valueOf(0), null }, UserFeed.class);
    public appoint_define.ActivityInfo msg_activity_info = new appoint_define.ActivityInfo();
    public appoint_define.FeedInfo msg_feed_info = new appoint_define.FeedInfo();
    public appoint_define.PublisherInfo msg_user_info = new appoint_define.PublisherInfo();
    public final PBUInt32Field uint32_owner_flag = PBField.initUInt32(0);
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_avatar = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "uint64_uin", "bytes_nickname", "uint32_age", "uint32_gender", "bytes_avatar" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, UserInfo.class);
    }
  }
  
  public static final class Wifi
    extends MessageMicro<Wifi>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_mac", "int32_rssi" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, Wifi.class);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
    public final PBUInt64Field uint64_mac = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     appoint.define.appoint_define
 * JD-Core Version:    0.7.0.1
 */