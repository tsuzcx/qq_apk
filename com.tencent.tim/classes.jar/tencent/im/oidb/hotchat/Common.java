package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Common
{
  public static final class SeatsInfo
    extends MessageMicro<SeatsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_seat_flag", "uint64_guest_uin", "uint32_seat_id", "uint32_seat_seq" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, SeatsInfo.class);
    public final PBUInt32Field uint32_seat_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seat_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seat_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_guest_uin = PBField.initUInt64(0L);
  }
  
  public static final class WifiPOIInfo
    extends MessageMicro<WifiPOIInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField banner_url = PBField.initString("");
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField face_url = PBField.initString("");
    public final PBUInt32Field hot_theme_group_flag = PBField.initUInt32(0);
    public final PBInt32Field latitude = PBField.initInt32(0);
    public final PBInt32Field longitude = PBField.initInt32(0);
    public final PBRepeatMessageField<Common.SeatsInfo> rpt_msg_seats_info = PBField.initRepeatMessage(Common.SeatsInfo.class);
    public final PBStringField smemo = PBField.initString("");
    public final PBStringField string_join_group_url = PBField.initString("");
    public final PBUInt32Field uint32_audit_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_creater_city_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_distance = PBField.initUInt32(0);
    public final PBUInt32Field uint32_face_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_favorites_expired = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_flag_ext2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_is_not_exist = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_type_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_uin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_guest_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_high_quality_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_admin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_all_country = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_member = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_robot_group = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_user_create = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_tab_switch_off = PBField.initUInt32(0);
    public final PBUInt32Field uint32_special_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_num_limit = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tv_pk_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_visitor_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wifi_poi_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_exit_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_favorites_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_flower_num = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_flower_point = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_get_praise_gap_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_msg_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_praise_nums = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_report_praise_gap_frequency = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_report_praise_gap_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_robot_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_vistor_join_group_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56, 64, 72, 80, 88, 98, 104, 114, 120, 128, 136, 146, 152, 160, 168, 176, 184, 192, 200, 208, 218, 224, 232, 248, 256, 264, 272, 280, 288, 296, 304, 312, 320, 328, 336, 344, 352, 362, 368, 376, 384, 392 }, new String[] { "bytes_uid", "bytes_name", "uint32_face_id", "bytes_sig", "uint32_group_code", "uint32_group_uin", "uint32_visitor_num", "uint32_wifi_poi_type", "uint32_is_member", "uint32_distance", "uint32_msg_tab_switch_off", "face_url", "hot_theme_group_flag", "banner_url", "uint32_special_flag", "uint32_total_num_limit", "uint32_is_admin", "string_join_group_url", "uint32_group_type_flag", "uint32_creater_city_id", "uint32_is_user_create", "uint64_owner_uin", "uint32_audit_flag", "uint32_tv_pk_flag", "uint32_sub_type", "uint64_last_msg_seq", "rpt_msg_seats_info", "uint64_flower_num", "uint64_flower_point", "uint64_favorites_time", "uint32_favorites_expired", "uint32_group_id", "uint64_praise_nums", "uint64_report_praise_gap_time", "uint64_report_praise_gap_frequency", "uint64_get_praise_gap_time", "uint64_vistor_join_group_time", "uint32_group_is_not_exist", "uint32_guest_num", "uint32_high_quality_flag", "uint64_exit_group_code", "latitude", "longitude", "smemo", "uint32_is_all_country", "uint32_group_flag_ext2", "uint32_is_robot_group", "uint64_robot_uin" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, WifiPOIInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.hotchat.Common
 * JD-Core Version:    0.7.0.1
 */