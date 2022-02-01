package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class topic_info
{
  public static final class CooperatorUser
    extends MessageMicro<CooperatorUser>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "str_head_url", "nick_name", "latest_op_time", "uid" }, new Object[] { "", "", Long.valueOf(0L), Long.valueOf(0L) }, CooperatorUser.class);
    public final PBUInt64Field latest_op_time = PBField.initUInt64(0L);
    public final PBStringField nick_name = PBField.initString("");
    public final PBStringField str_head_url = PBField.initString("");
    public final PBUInt64Field uid = PBField.initUInt64(0L);
  }
  
  public static final class ModuleInfo
    extends MessageMicro<ModuleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "id", "name" }, new Object[] { Integer.valueOf(0), "" }, ModuleInfo.class);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
  }
  
  public static final class PaymentInfo
    extends MessageMicro<PaymentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 29, 37, 40, 48, 56 }, new String[] { "update_status", "plan_content_count", "current_price", "original_price", "discount_start_time", "discount_end_time", "sale_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0F), Float.valueOf(0.0F), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false) }, PaymentInfo.class);
    public final PBFloatField current_price = PBField.initFloat(0.0F);
    public final PBUInt64Field discount_end_time = PBField.initUInt64(0L);
    public final PBUInt64Field discount_start_time = PBField.initUInt64(0L);
    public final PBFloatField original_price = PBField.initFloat(0.0F);
    public final PBUInt32Field plan_content_count = PBField.initUInt32(0);
    public final PBBoolField sale_flag = PBField.initBool(false);
    public final PBUInt32Field update_status = PBField.initUInt32(0);
  }
  
  public static final class RowkeyInfo
    extends MessageMicro<RowkeyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 74 }, new String[] { "add_time", "rowkey", "start_ts", "end_ts", "content_type", "pay_type", "weight", "chapter", "show_text" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, RowkeyInfo.class);
    public final PBUInt64Field add_time = PBField.initUInt64(0L);
    public final PBUInt32Field chapter = PBField.initUInt32(0);
    public final PBUInt32Field content_type = PBField.initUInt32(0);
    public final PBUInt32Field end_ts = PBField.initUInt32(0);
    public final PBUInt32Field pay_type = PBField.initUInt32(0);
    public final PBStringField rowkey = PBField.initString("");
    public final PBStringField show_text = PBField.initString("");
    public final PBUInt32Field start_ts = PBField.initUInt32(0);
    public final PBUInt32Field weight = PBField.initUInt32(0);
  }
  
  public static final class SyncCookie
    extends MessageMicro<SyncCookie>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "start", "is_end", "module_id", "type", "end_rowkey", "end_rowkey_score" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L) }, SyncCookie.class);
    public final PBStringField end_rowkey = PBField.initString("");
    public final PBUInt64Field end_rowkey_score = PBField.initUInt64(0L);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBUInt32Field module_id = PBField.initUInt32(0);
    public final PBUInt64Field start = PBField.initUInt64(0L);
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class TopicBubbleInfo
    extends MessageMicro<TopicBubbleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_topic_id", "uint32_up_ts" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, TopicBubbleInfo.class);
    public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_up_ts = PBField.initUInt32(0);
  }
  
  public static final class TopicFeedsCountInfo
    extends MessageMicro<TopicFeedsCountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "topic_id", "content_count", "end_rowkey", "end_score" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L) }, TopicFeedsCountInfo.class);
    public final PBUInt32Field content_count = PBField.initUInt32(0);
    public final PBStringField end_rowkey = PBField.initString("");
    public final PBUInt64Field end_score = PBField.initUInt64(0L);
    public final PBUInt32Field topic_id = PBField.initUInt32(0);
  }
  
  public static final class TopicFeedsRecentInfo
    extends MessageMicro<TopicFeedsRecentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "topic_id", "rowkey_info", "module_type" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, TopicFeedsRecentInfo.class);
    public final PBUInt32Field module_type = PBField.initUInt32(0);
    public topic_info.RowkeyInfo rowkey_info = new topic_info.RowkeyInfo();
    public final PBUInt32Field topic_id = PBField.initUInt32(0);
  }
  
  public static final class TopicInfo
    extends MessageMicro<TopicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 72, 80, 90, 96, 104, 120, 130, 138, 144, 152, 160, 170, 176, 184, 192, 200, 208, 216, 242, 248, 256, 264, 274, 280, 288 }, new String[] { "id", "title", "intro", "cover_img", "icon_img", "pendant_img", "type1", "type2", "type3", "create_time", "tags", "source", "status", "ui_type", "cover_color", "video_url", "topic_type", "topic_valid", "creator_uid", "rowkey", "is_default", "is_undistribute", "audit_status", "submit_permission", "last_update_ts", "version", "ext", "super_submit_permission", "is_show_timestamp", "payment_type", "payinfo", "sort_type", "is_high_quality" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Boolean.valueOf(false) }, TopicInfo.class);
    public final PBUInt32Field audit_status = PBField.initUInt32(0);
    public final PBStringField cover_color = PBField.initString("");
    public final PBStringField cover_img = PBField.initString("");
    public final PBUInt32Field create_time = PBField.initUInt32(0);
    public final PBUInt64Field creator_uid = PBField.initUInt64(0L);
    public topic_info.TopicInfoExt ext = new topic_info.TopicInfoExt();
    public final PBStringField icon_img = PBField.initString("");
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBStringField intro = PBField.initString("");
    public final PBBoolField is_default = PBField.initBool(false);
    public final PBBoolField is_high_quality = PBField.initBool(false);
    public final PBUInt32Field is_show_timestamp = PBField.initUInt32(0);
    public final PBBoolField is_undistribute = PBField.initBool(false);
    public final PBUInt64Field last_update_ts = PBField.initUInt64(0L);
    public topic_info.PaymentInfo payinfo = new topic_info.PaymentInfo();
    public final PBUInt32Field payment_type = PBField.initUInt32(0);
    public final PBStringField pendant_img = PBField.initString("");
    public final PBStringField rowkey = PBField.initString("");
    public final PBUInt32Field sort_type = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt32Field submit_permission = PBField.initUInt32(0);
    public final PBUInt32Field super_submit_permission = PBField.initUInt32(0);
    public final PBStringField tags = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field topic_type = PBField.initUInt32(0);
    public final PBUInt32Field topic_valid = PBField.initUInt32(0);
    public final PBUInt32Field type1 = PBField.initUInt32(0);
    public final PBUInt32Field type2 = PBField.initUInt32(0);
    public final PBUInt32Field type3 = PBField.initUInt32(0);
    public final PBUInt32Field ui_type = PBField.initUInt32(0);
    public final PBUInt64Field version = PBField.initUInt64(0L);
    public final PBStringField video_url = PBField.initString("");
  }
  
  public static final class TopicInfoExt
    extends MessageMicro<TopicInfoExt>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 56, 64, 72, 82, 88, 96, 106, 114, 120, 128, 136, 144, 154 }, new String[] { "has_subscribe", "modules", "content_count", "subscribe_num", "share_url", "algorithm_id", "is_top", "topic_view", "feeds_up_time", "feed_up_time_text", "topic_feed_audit_status", "comment_num", "creator_nickname", "creator_avatar_url", "new_num", "my_topic_flag", "auditing_video_cnt", "cooperator_cnt", "lastest_cooperator_user" }, new Object[] { Boolean.valueOf(false), null, Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), null }, TopicInfoExt.class);
    public final PBInt64Field algorithm_id = PBField.initInt64(0L);
    public final PBUInt32Field auditing_video_cnt = PBField.initUInt32(0);
    public final PBUInt32Field comment_num = PBField.initUInt32(0);
    public final PBUInt32Field content_count = PBField.initUInt32(0);
    public final PBUInt32Field cooperator_cnt = PBField.initUInt32(0);
    public final PBStringField creator_avatar_url = PBField.initString("");
    public final PBStringField creator_nickname = PBField.initString("");
    public final PBStringField feed_up_time_text = PBField.initString("");
    public final PBUInt32Field feeds_up_time = PBField.initUInt32(0);
    public final PBBoolField has_subscribe = PBField.initBool(false);
    public final PBBoolField is_top = PBField.initBool(false);
    public final PBRepeatMessageField<topic_info.CooperatorUser> lastest_cooperator_user = PBField.initRepeatMessage(topic_info.CooperatorUser.class);
    public final PBRepeatMessageField<topic_info.ModuleInfo> modules = PBField.initRepeatMessage(topic_info.ModuleInfo.class);
    public final PBBoolField my_topic_flag = PBField.initBool(false);
    public final PBUInt32Field new_num = PBField.initUInt32(0);
    public final PBStringField share_url = PBField.initString("");
    public final PBUInt32Field subscribe_num = PBField.initUInt32(0);
    public final PBUInt32Field topic_feed_audit_status = PBField.initUInt32(0);
    public final PBUInt32Field topic_view = PBField.initUInt32(0);
  }
  
  public static final class TopicModuleFeedsCookie
    extends MessageMicro<TopicModuleFeedsCookie>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 120 }, new String[] { "info", "source", "live_rowkeys" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, TopicModuleFeedsCookie.class);
    public final PBRepeatMessageField<topic_info.SyncCookie> info = PBField.initRepeatMessage(topic_info.SyncCookie.class);
    public final PBRepeatField<Integer> live_rowkeys = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field source = PBField.initUInt32(0);
  }
  
  public static final class TopicRocommend
    extends MessageMicro<TopicRocommend>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "topic_id", "pos_score", "start_ts", "end_ts" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TopicRocommend.class);
    public final PBUInt32Field end_ts = PBField.initUInt32(0);
    public final PBUInt32Field pos_score = PBField.initUInt32(0);
    public final PBUInt32Field start_ts = PBField.initUInt32(0);
    public final PBUInt32Field topic_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.kandian.ugc.topic_info
 * JD-Core Version:    0.7.0.1
 */