package tencent.im.oidb.cmd0xde0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xde0
{
  public static final class ActiveZoneFeature
    extends MessageMicro<ActiveZoneFeature>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "top", "bottom" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ActiveZoneFeature.class);
    public final PBUInt32Field bottom = PBField.initUInt32(0);
    public final PBUInt32Field top = PBField.initUInt32(0);
  }
  
  public static final class FeedExpInfo
    extends MessageMicro<FeedExpInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 106 }, new String[] { "feeds_id", "rec_reason", "style", "word_cnt_for_display", "feed_card_height", "is_first_scrn", "is_last_scrn", "exp_pos_in_list", "is_clicked", "read_duratiion", "exp_duration", "exp_duration_in_active_zone", "exp_orientation" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "" }, FeedExpInfo.class);
    public final PBUInt64Field exp_duration = PBField.initUInt64(0L);
    public final PBUInt64Field exp_duration_in_active_zone = PBField.initUInt64(0L);
    public final PBStringField exp_orientation = PBField.initString("");
    public final PBUInt32Field exp_pos_in_list = PBField.initUInt32(0);
    public final PBUInt32Field feed_card_height = PBField.initUInt32(0);
    public final PBStringField feeds_id = PBField.initString("");
    public final PBBoolField is_clicked = PBField.initBool(false);
    public final PBBoolField is_first_scrn = PBField.initBool(false);
    public final PBBoolField is_last_scrn = PBField.initBool(false);
    public final PBUInt64Field read_duratiion = PBField.initUInt64(0L);
    public final PBStringField rec_reason = PBField.initString("");
    public final PBUInt32Field style = PBField.initUInt32(0);
    public final PBUInt32Field word_cnt_for_display = PBField.initUInt32(0);
  }
  
  public static final class FeedScrollStateInfo
    extends MessageMicro<FeedScrollStateInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 53, 56, 64, 72, 80 }, new String[] { "feeds_id", "enter_active_zone_speed", "start_top", "start_bottom", "stop_top", "stop_bottom" }, new Object[] { "", Float.valueOf(0.0F), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, FeedScrollStateInfo.class);
    public final PBFloatField enter_active_zone_speed = PBField.initFloat(0.0F);
    public final PBStringField feeds_id = PBField.initString("");
    public final PBInt64Field start_bottom = PBField.initInt64(0L);
    public final PBInt64Field start_top = PBField.initInt64(0L);
    public final PBInt64Field stop_bottom = PBField.initInt64(0L);
    public final PBInt64Field stop_top = PBField.initInt64(0L);
  }
  
  public static final class FeedsCtxFeature
    extends MessageMicro<FeedsCtxFeature>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 53, 58, 69, 77, 80, 88 }, new String[] { "ctx_device_id", "timestamp", "ctx_enter_reason", "ctx_device_model", "ctx_network_type", "ctx_power", "ctx_screen_info", "ctx_lightness", "ctx_volume", "ctx_headset", "ctx_scene" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), Float.valueOf(0.0F), "", Float.valueOf(0.0F), Float.valueOf(0.0F), Boolean.valueOf(false), Long.valueOf(0L) }, FeedsCtxFeature.class);
    public final PBStringField ctx_device_id = PBField.initString("");
    public final PBStringField ctx_device_model = PBField.initString("");
    public final PBUInt32Field ctx_enter_reason = PBField.initUInt32(0);
    public final PBBoolField ctx_headset = PBField.initBool(false);
    public final PBFloatField ctx_lightness = PBField.initFloat(0.0F);
    public final PBUInt32Field ctx_network_type = PBField.initUInt32(0);
    public final PBFloatField ctx_power = PBField.initFloat(0.0F);
    public final PBUInt64Field ctx_scene = PBField.initUInt64(0L);
    public final PBStringField ctx_screen_info = PBField.initString("");
    public final PBFloatField ctx_volume = PBField.initFloat(0.0F);
    public final PBUInt64Field timestamp = PBField.initUInt64(0L);
  }
  
  public static final class FeedsExpFeature
    extends MessageMicro<FeedsExpFeature>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "exp_feeds", "exp_chnl_duration", "is_user_active", "exp_first_scrn_duration", "exp_last_scrn_duration" }, new Object[] { null, Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L) }, FeedsExpFeature.class);
    public final PBUInt64Field exp_chnl_duration = PBField.initUInt64(0L);
    public final PBRepeatMessageField<oidb_cmd0xde0.FeedExpInfo> exp_feeds = PBField.initRepeatMessage(oidb_cmd0xde0.FeedExpInfo.class);
    public final PBUInt64Field exp_first_scrn_duration = PBField.initUInt64(0L);
    public final PBUInt64Field exp_last_scrn_duration = PBField.initUInt64(0L);
    public final PBBoolField is_user_active = PBField.initBool(false);
  }
  
  public static final class GestureEvent
    extends MessageMicro<GestureEvent>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 29, 32, 45, 50, 58, 66 }, new String[] { "ges_scroll_direction", "delta_ts_from_last_scroll_mills", "ges_scroll_distance", "ges_scroll_mills", "ges_scroll_speed", "ges_scroll_downNup", "ges_click_point", "get_scroll_feeds_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Float.valueOf(0.0F), Long.valueOf(0L), Float.valueOf(0.0F), "", "", null }, GestureEvent.class);
    public final PBUInt64Field delta_ts_from_last_scroll_mills = PBField.initUInt64(0L);
    public final PBStringField ges_click_point = PBField.initString("");
    public final PBUInt32Field ges_scroll_direction = PBField.initUInt32(0);
    public final PBFloatField ges_scroll_distance = PBField.initFloat(0.0F);
    public final PBStringField ges_scroll_downNup = PBField.initString("");
    public final PBUInt64Field ges_scroll_mills = PBField.initUInt64(0L);
    public final PBFloatField ges_scroll_speed = PBField.initFloat(0.0F);
    public final PBRepeatMessageField<oidb_cmd0xde0.FeedScrollStateInfo> get_scroll_feeds_info = PBField.initRepeatMessage(oidb_cmd0xde0.FeedScrollStateInfo.class);
  }
  
  public static final class GestureFeature
    extends MessageMicro<GestureFeature>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "gesture_event" }, new Object[] { null }, GestureFeature.class);
    public final PBRepeatMessageField<oidb_cmd0xde0.GestureEvent> gesture_event = PBField.initRepeatMessage(oidb_cmd0xde0.GestureEvent.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "ctx_feature", "usr_gesture_feature", "feeds_exp_feature", "active_zone" }, new Object[] { null, null, null, null }, ReqBody.class);
    public oidb_cmd0xde0.ActiveZoneFeature active_zone = new oidb_cmd0xde0.ActiveZoneFeature();
    public oidb_cmd0xde0.FeedsCtxFeature ctx_feature = new oidb_cmd0xde0.FeedsCtxFeature();
    public oidb_cmd0xde0.FeedsExpFeature feeds_exp_feature = new oidb_cmd0xde0.FeedsExpFeature();
    public oidb_cmd0xde0.GestureFeature usr_gesture_feature = new oidb_cmd0xde0.GestureFeature();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "isSuccess" }, new Object[] { Boolean.valueOf(false) }, RspBody.class);
    public final PBBoolField isSuccess = PBField.initBool(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xde0.oidb_cmd0xde0
 * JD-Core Version:    0.7.0.1
 */