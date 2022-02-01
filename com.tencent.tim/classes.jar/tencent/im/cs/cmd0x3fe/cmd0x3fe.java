package tencent.im.cs.cmd0x3fe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x3fe
{
  public static final class LevelInfo
    extends MessageMicro<LevelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 80, 88, 96, 106, 114 }, new String[] { "uint64_uin", "uint32_online_level", "uint32_show_level", "uint32_level_color", "uint32_score", "uint32_req_flag", "uint32_req_timer", "uint32_user_identity", "nickname", "rpt_medal_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null }, LevelInfo.class);
    public final PBStringField nickname = PBField.initString("");
    public final PBRepeatMessageField<cmd0x3fe.Medal> rpt_medal_list = PBField.initRepeatMessage(cmd0x3fe.Medal.class);
    public final PBUInt32Field uint32_level_color = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_timer = PBField.initUInt32(0);
    public final PBUInt32Field uint32_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_user_identity = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class LevelMsg
    extends MessageMicro<LevelMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 82, 90 }, new String[] { "uint32_subcmd", "msg_level_req", "msg_level_rsp" }, new Object[] { Integer.valueOf(0), null, null }, LevelMsg.class);
    public cmd0x3fe.ReqBody msg_level_req = new cmd0x3fe.ReqBody();
    public cmd0x3fe.RspBody msg_level_rsp = new cmd0x3fe.RspBody();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
  
  public static final class Medal
    extends MessageMicro<Medal>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "uint32_id", "uint32_level", "uint32_type", "str_icon_url", "str_head_icon_url", "str_name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "" }, Medal.class);
    public final PBStringField str_head_icon_url = PBField.initString("");
    public final PBStringField str_icon_url = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class NotifyMsg
    extends MessageMicro<NotifyMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint32_subcmd", "uint64_from_uin", "uint64_to_uin", "uint64_guin", "uint32_count" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, NotifyMsg.class);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_guin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_msg_user_info", "uint64_group_code" }, new Object[] { null, Long.valueOf(0L) }, ReqBody.class);
    public final PBRepeatMessageField<cmd0x3fe.UserInfo> rpt_msg_user_info = PBField.initRepeatMessage(cmd0x3fe.UserInfo.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 80 }, new String[] { "int32_ret", "rpt_msg_level_info", "uint32_subcmd" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, RspBody.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBRepeatMessageField<cmd0x3fe.LevelInfo> rpt_msg_level_info = PBField.initRepeatMessage(cmd0x3fe.LevelInfo.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
  
  public static final class TmemLevelInfo
    extends MessageMicro<TmemLevelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 122, 128, 136, 144, 152, 160, 168, 176, 186, 192, 200, 208, 216, 226 }, new String[] { "uint32_time_stamp", "uint32_day_socre", "uint32_online_time", "uint32_online_score", "uint32_send_flowers_score", "uint32_recv_flowers_score", "uint32_send_gift_score", "uint32_recv_gift_score", "uint32_upgrade_score", "msg_level_info", "uint32_send_flower_num", "uint32_recv_flower_num", "uint32_send_gift_num", "uint32_recv_gift_num", "uint32_recv_gift_total", "uint32_send_gift_total", "uint32_recv_flower_total", "recent_days", "uint32_identity_score", "uint32_identity_level", "uint32_identity_upgrade_score", "uint32_days_to_downgrade", "rpt_msg_event_medal" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, TmemLevelInfo.class);
    public cmd0x3fe.LevelInfo msg_level_info = new cmd0x3fe.LevelInfo();
    public final PBRepeatMessageField<cmd0x3fe.qun_video_identity_score> recent_days = PBField.initRepeatMessage(cmd0x3fe.qun_video_identity_score.class);
    public final PBRepeatMessageField<cmd0x3fe.event_medal> rpt_msg_event_medal = PBField.initRepeatMessage(cmd0x3fe.event_medal.class);
    public final PBUInt32Field uint32_day_socre = PBField.initUInt32(0);
    public final PBRepeatField<Integer> uint32_days_to_downgrade = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_identity_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_identity_score = PBField.initUInt32(0);
    public final PBRepeatField<Integer> uint32_identity_upgrade_score = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_online_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_flower_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_flower_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_flowers_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_gift_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_gift_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_gift_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_flower_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_flowers_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_gift_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_gift_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_gift_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time_stamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upgrade_score = PBField.initUInt32(0);
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24 }, new String[] { "uint64_uin", "uint32_online_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, UserInfo.class);
    public final PBUInt32Field uint32_online_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class event_medal
    extends MessageMicro<event_medal>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_id", "uint64_create_time" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, event_medal.class);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
  }
  
  public static final class qun_video_identity_score
    extends MessageMicro<qun_video_identity_score>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "uint32_identity_score", "uint32_time", "uint32_send_flower_num", "uint32_recv_flower_num", "uint32_send_gift_num", "uint32_recv_gift_num", "uint32_online_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, qun_video_identity_score.class);
    public final PBUInt32Field uint32_identity_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_flower_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_gift_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_flower_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_gift_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x3fe.cmd0x3fe
 * JD-Core Version:    0.7.0.1
 */