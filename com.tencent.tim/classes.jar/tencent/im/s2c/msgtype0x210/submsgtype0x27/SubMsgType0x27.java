package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27
{
  public static final class AddGroup
    extends MessageMicro<AddGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_groupname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_groupid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sortid = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_groupid", "uint32_sortid", "bytes_groupname" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, AddGroup.class);
    }
  }
  
  public static final class AppointmentNotify
    extends MessageMicro<AppointmentNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_event_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_feed_event_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nearby_event_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_appoint_id = PBField.initString("");
    public final PBStringField str_join_wording = PBField.initString("");
    public final PBStringField str_tips_content = PBField.initString("");
    public final PBStringField str_view_wording = PBField.initString("");
    public final PBUInt32Field uint32_notifytype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50, 58, 66, 74, 82, 90 }, new String[] { "uint64_from_uin", "str_appoint_id", "uint32_notifytype", "str_tips_content", "uint32_unread_count", "str_join_wording", "str_view_wording", "bytes_sig", "bytes_event_info", "bytes_nearby_event_info", "bytes_feed_event_info" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), "", Integer.valueOf(0), "", "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, AppointmentNotify.class);
    }
  }
  
  public static final class BinaryMsg
    extends MessageMicro<BinaryMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_op_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_op_type", "bytes_op_value" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, BinaryMsg.class);
    }
  }
  
  public static final class ChatMatchInfo
    extends MessageMicro<ChatMatchInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tips_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_c2c_expired_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_left_chat_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_match_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_match_expired_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_match_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_time_stamp = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 64, 72, 82 }, new String[] { "bytes_sig", "uint64_uin", "uint64_match_uin", "bytes_tips_wording", "uint32_left_chat_time", "uint64_time_stamp", "uint32_match_expired_time", "uint32_c2c_expired_time", "uint32_match_count", "bytes_nick" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, ChatMatchInfo.class);
    }
  }
  
  public static final class ConfMsgRoamFlag
    extends MessageMicro<ConfMsgRoamFlag>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_confid", "uint32_flag", "uint64_timestamp" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, ConfMsgRoamFlag.class);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_confid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  }
  
  public static final class DaRenNotify
    extends MessageMicro<DaRenNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_uin", "uint32_login_days", "uint32_days", "uint32_is_yestoday_login", "uint32_is_today_login" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, DaRenNotify.class);
    public final PBUInt32Field uint32_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_today_login = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_yestoday_login = PBField.initUInt32(0);
    public final PBUInt32Field uint32_login_days = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class DelFriend
    extends MessageMicro<DelFriend>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_uins" }, new Object[] { Long.valueOf(0L) }, DelFriend.class);
    public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class DelGroup
    extends MessageMicro<DelGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_groupid" }, new Object[] { Integer.valueOf(0) }, DelGroup.class);
    public final PBUInt32Field uint32_groupid = PBField.initUInt32(0);
  }
  
  public static final class FanpaiziNotify
    extends MessageMicro<FanpaiziNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tips_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_from_nick = PBField.initString("");
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint64_from_uin", "str_from_nick", "bytes_tips_content", "bytes_sig" }, new Object[] { Long.valueOf(0L), "", localByteStringMicro1, localByteStringMicro2 }, FanpaiziNotify.class);
    }
  }
  
  public static final class ForwardBody
    extends MessageMicro<ForwardBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_redpoint_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public SubMsgType0x27.AddGroup msg_add_group = new SubMsgType0x27.AddGroup();
    public SubMsgType0x27.AppointmentNotify msg_appointment_notify = new SubMsgType0x27.AppointmentNotify();
    public SubMsgType0x27.BinaryMsg msg_bin_pkg = new SubMsgType0x27.BinaryMsg();
    public SubMsgType0x27.MQQCampusNotify msg_campus_notify = new SubMsgType0x27.MQQCampusNotify();
    public SubMsgType0x27.ChatMatchInfo msg_chat_match_info = new SubMsgType0x27.ChatMatchInfo();
    public SubMsgType0x27.ConfMsgRoamFlag msg_conf_msg_roam_flag = new SubMsgType0x27.ConfMsgRoamFlag();
    public SubMsgType0x27.DaRenNotify msg_daren_notify = new SubMsgType0x27.DaRenNotify();
    public SubMsgType0x27.DelFriend msg_del_friend = new SubMsgType0x27.DelFriend();
    public SubMsgType0x27.DelGroup msg_del_group = new SubMsgType0x27.DelGroup();
    public SubMsgType0x27.FanpaiziNotify msg_fanpanzi_notify = new SubMsgType0x27.FanpaiziNotify();
    public SubMsgType0x27.FrdCustomOnlineStatusChange msg_frd_custom_online_status_change = new SubMsgType0x27.FrdCustomOnlineStatusChange();
    public SubMsgType0x27.GrpMsgRoamFlag msg_grp_msg_roam_flag = new SubMsgType0x27.GrpMsgRoamFlag();
    public SubMsgType0x27.HotFriendNotify msg_hot_friend_notify = new SubMsgType0x27.HotFriendNotify();
    public SubMsgType0x27.ModConfProfile msg_mod_conf_profile = new SubMsgType0x27.ModConfProfile();
    public SubMsgType0x27.ModCustomFace msg_mod_custom_face = new SubMsgType0x27.ModCustomFace();
    public SubMsgType0x27.SnsUpdateFlag msg_mod_friend_flag = new SubMsgType0x27.SnsUpdateFlag();
    public SubMsgType0x27.ModFriendGroup msg_mod_friend_group = new SubMsgType0x27.ModFriendGroup();
    public SubMsgType0x27.ModFriendRemark msg_mod_friend_remark = new SubMsgType0x27.ModFriendRemark();
    public SubMsgType0x27.ModSnsGeneralInfo msg_mod_friend_rings = new SubMsgType0x27.ModSnsGeneralInfo();
    public SubMsgType0x27.ModGroupMemberProfile msg_mod_group_member_profile = new SubMsgType0x27.ModGroupMemberProfile();
    public SubMsgType0x27.ModGroupName msg_mod_group_name = new SubMsgType0x27.ModGroupName();
    public SubMsgType0x27.ModGroupProfile msg_mod_group_profile = new SubMsgType0x27.ModGroupProfile();
    public SubMsgType0x27.ModGroupSort msg_mod_group_sort = new SubMsgType0x27.ModGroupSort();
    public SubMsgType0x27.ModLongNick msg_mod_long_nick = new SubMsgType0x27.ModLongNick();
    public SubMsgType0x27.ModProfile msg_mod_profile = new SubMsgType0x27.ModProfile();
    public SubMsgType0x27.ModLongNick msg_mod_rich_long_nick = new SubMsgType0x27.ModLongNick();
    public SubMsgType0x27.ModLongNick msg_mod_rich_long_nick_ex = new SubMsgType0x27.ModLongNick();
    public SubMsgType0x27.NewComeinUserNotify msg_new_comein_user_notify = new SubMsgType0x27.NewComeinUserNotify();
    public SubMsgType0x27.PraiseRankNotify msg_praise_rank_notify = new SubMsgType0x27.PraiseRankNotify();
    public SubMsgType0x27.PushReportDev msg_push_report_dev = new SubMsgType0x27.PushReportDev();
    public SubMsgType0x27.PushSearchDev msg_push_search_dev = new SubMsgType0x27.PushSearchDev();
    public SubMsgType0x27.QQPayPush msg_qq_pay_push = new SubMsgType0x27.QQPayPush();
    public SubMsgType0x27.ModFrdRoamPriv msg_roam_priv = new SubMsgType0x27.ModFrdRoamPriv();
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 186, 202, 210, 1602, 1610, 1618, 1626, 1634, 1642, 1682, 1690, 1698, 1714, 16002 }, new String[] { "uint32_notify_type", "uint32_op_type", "msg_add_group", "msg_del_group", "msg_mod_group_name", "msg_mod_group_sort", "msg_mod_friend_group", "msg_mod_profile", "msg_mod_friend_remark", "msg_mod_long_nick", "msg_mod_custom_face", "msg_mod_group_profile", "msg_mod_group_member_profile", "msg_del_friend", "msg_roam_priv", "msg_grp_msg_roam_flag", "msg_conf_msg_roam_flag", "msg_mod_rich_long_nick", "msg_bin_pkg", "msg_mod_friend_rings", "msg_mod_conf_profile", "msg_mod_friend_flag", "msg_appointment_notify", "msg_daren_notify", "msg_new_comein_user_notify", "msg_push_search_dev", "msg_push_report_dev", "msg_qq_pay_push", "bytes_redpoint_info", "msg_hot_friend_notify", "msg_praise_rank_notify", "msg_campus_notify", "msg_mod_rich_long_nick_ex", "msg_chat_match_info", "msg_frd_custom_online_status_change", "msg_fanpanzi_notify" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, localByteStringMicro, null, null, null, null, null, null, null }, ForwardBody.class);
    }
  }
  
  public static final class FrdCustomOnlineStatusChange
    extends MessageMicro<FrdCustomOnlineStatusChange>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, FrdCustomOnlineStatusChange.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class FriendGroup
    extends MessageMicro<FriendGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_fuin", "rpt_uint32_old_group_id", "rpt_uint32_new_group_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, FriendGroup.class);
    public final PBRepeatField<Integer> rpt_uint32_new_group_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_old_group_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0L);
  }
  
  public static final class FriendRemark
    extends MessageMicro<FriendRemark>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rmk_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint32_type", "uint64_fuin", "bytes_rmk_name", "uint64_group_code" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, Long.valueOf(0L) }, FriendRemark.class);
    }
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
  
  public static final class GroupMemberProfileInfo
    extends MessageMicro<GroupMemberProfileInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_field = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_field", "bytes_value" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GroupMemberProfileInfo.class);
    }
  }
  
  public static final class GroupProfileInfo
    extends MessageMicro<GroupProfileInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_field = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_field", "bytes_value" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GroupProfileInfo.class);
    }
  }
  
  public static final class GroupSort
    extends MessageMicro<GroupSort>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_groupid", "uint32_sortid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GroupSort.class);
    public final PBUInt32Field uint32_groupid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sortid = PBField.initUInt32(0);
  }
  
  public static final class GrpMsgRoamFlag
    extends MessageMicro<GrpMsgRoamFlag>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_groupcode", "uint32_flag", "uint64_timestamp" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, GrpMsgRoamFlag.class);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_groupcode = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  }
  
  public static final class HotFriendNotify
    extends MessageMicro<HotFriendNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136 }, new String[] { "uint64_dst_uin", "uint32_praise_hot_level", "uint32_chat_hot_level", "uint32_praise_hot_days", "uint32_chat_hot_days", "uint32_close_level", "uint32_close_days", "uint32_praise_flag", "uint32_chat_flag", "uint32_close_flag", "uint64_notify_time", "uint64_last_praise_time", "uint64_last_chat_time", "uint32_qzone_hot_level", "uint32_qzone_hot_days", "uint32_qzone_flag", "uint64_last_qzone_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, HotFriendNotify.class);
    public final PBUInt32Field uint32_chat_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chat_hot_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chat_hot_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_close_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_close_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_close_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_hot_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_hot_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qzone_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qzone_hot_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qzone_hot_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_chat_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_praise_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_qzone_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_notify_time = PBField.initUInt64(0L);
  }
  
  public static final class MQQCampusNotify
    extends MessageMicro<MQQCampusNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "uint64_from_uin", "str_wording", "str_target", "uint32_type", "str_source" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), "" }, MQQCampusNotify.class);
    public final PBStringField str_source = PBField.initString("");
    public final PBStringField str_target = PBField.initString("");
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  }
  
  public static final class ModConfProfile
    extends MessageMicro<ModConfProfile>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uin", "uint32_conf_uin", "rpt_msg_profile_infos" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, ModConfProfile.class);
    public final PBRepeatMessageField<SubMsgType0x27.ProfileInfo> rpt_msg_profile_infos = PBField.initRepeatMessage(SubMsgType0x27.ProfileInfo.class);
    public final PBUInt32Field uint32_conf_uin = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ModCustomFace
    extends MessageMicro<ModCustomFace>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_type", "uint64_uin", "uint64_group_code", "uint64_cmd_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, ModCustomFace.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ModFrdRoamPriv
    extends MessageMicro<ModFrdRoamPriv>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_roam_priv" }, new Object[] { null }, ModFrdRoamPriv.class);
    public final PBRepeatMessageField<SubMsgType0x27.OneRoamPriv> rpt_msg_roam_priv = PBField.initRepeatMessage(SubMsgType0x27.OneRoamPriv.class);
  }
  
  public static final class ModFriendGroup
    extends MessageMicro<ModFriendGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_frd_group" }, new Object[] { null }, ModFriendGroup.class);
    public final PBRepeatMessageField<SubMsgType0x27.FriendGroup> rpt_msg_frd_group = PBField.initRepeatMessage(SubMsgType0x27.FriendGroup.class);
  }
  
  public static final class ModFriendRemark
    extends MessageMicro<ModFriendRemark>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_frd_rmk" }, new Object[] { null }, ModFriendRemark.class);
    public final PBRepeatMessageField<SubMsgType0x27.FriendRemark> rpt_msg_frd_rmk = PBField.initRepeatMessage(SubMsgType0x27.FriendRemark.class);
  }
  
  public static final class ModGroupMemberProfile
    extends MessageMicro<ModGroupMemberProfile>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_group_uin", "uint64_uin", "rpt_msg_group_member_profile_infos", "uint64_group_code" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(0L) }, ModGroupMemberProfile.class);
    public final PBRepeatMessageField<SubMsgType0x27.GroupMemberProfileInfo> rpt_msg_group_member_profile_infos = PBField.initRepeatMessage(SubMsgType0x27.GroupMemberProfileInfo.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ModGroupName
    extends MessageMicro<ModGroupName>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_groupname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_groupid = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_groupid", "bytes_groupname" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ModGroupName.class);
    }
  }
  
  public static final class ModGroupProfile
    extends MessageMicro<ModGroupProfile>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint64_group_uin", "rpt_msg_group_profile_infos", "uint64_group_code", "uint64_cmd_uin" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L) }, ModGroupProfile.class);
    public final PBRepeatMessageField<SubMsgType0x27.GroupProfileInfo> rpt_msg_group_profile_infos = PBField.initRepeatMessage(SubMsgType0x27.GroupProfileInfo.class);
    public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  }
  
  public static final class ModGroupSort
    extends MessageMicro<ModGroupSort>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_groupsort" }, new Object[] { null }, ModGroupSort.class);
    public final PBRepeatMessageField<SubMsgType0x27.GroupSort> rpt_msg_groupsort = PBField.initRepeatMessage(SubMsgType0x27.GroupSort.class);
  }
  
  public static final class ModLongNick
    extends MessageMicro<ModLongNick>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "bytes_value" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, ModLongNick.class);
    }
  }
  
  public static final class ModProfile
    extends MessageMicro<ModProfile>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "rpt_msg_profile_infos" }, new Object[] { Long.valueOf(0L), null }, ModProfile.class);
    public final PBRepeatMessageField<SubMsgType0x27.ProfileInfo> rpt_msg_profile_infos = PBField.initRepeatMessage(SubMsgType0x27.ProfileInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ModSnsGeneralInfo
    extends MessageMicro<ModSnsGeneralInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_sns_general_infos" }, new Object[] { null }, ModSnsGeneralInfo.class);
    public final PBRepeatMessageField<SubMsgType0x27.SnsUpateBuffer> rpt_msg_sns_general_infos = PBField.initRepeatMessage(SubMsgType0x27.SnsUpateBuffer.class);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_mod_infos" }, new Object[] { null }, MsgBody.class);
    public final PBRepeatMessageField<SubMsgType0x27.ForwardBody> rpt_msg_mod_infos = PBField.initRepeatMessage(SubMsgType0x27.ForwardBody.class);
  }
  
  public static final class NewComeinUser
    extends MessageMicro<NewComeinUser>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_is_frd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint64_uin", "uint32_is_frd", "bytes_remark", "bytes_nick" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, NewComeinUser.class);
    }
  }
  
  public static final class NewComeinUserNotify
    extends MessageMicro<NewComeinUserNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "uint32_msg_type", "bool_strong_notify", "uint32_push_time", "msg_new_comein_user", "msg_new_group", "msg_new_group_user" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), null, null, null }, NewComeinUserNotify.class);
    public final PBBoolField bool_strong_notify = PBField.initBool(false);
    public SubMsgType0x27.NewComeinUser msg_new_comein_user = new SubMsgType0x27.NewComeinUser();
    public SubMsgType0x27.NewGroup msg_new_group = new SubMsgType0x27.NewGroup();
    public SubMsgType0x27.NewGroupUser msg_new_group_user = new SubMsgType0x27.NewGroupUser();
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_push_time = PBField.initUInt32(0);
  }
  
  public static final class NewGroup
    extends MessageMicro<NewGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_distance = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_owner_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "uint64_group_code", "bytes_group_name", "uint64_owner_uin", "bytes_owner_nick", "bytes_distance" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3 }, NewGroup.class);
    }
  }
  
  public static final class NewGroupUser
    extends MessageMicro<NewGroupUser>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_distance = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_age = PBField.initInt32(0);
    public final PBInt32Field int32_sex = PBField.initInt32(0);
    public final PBStringField str_nick = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uint64_uin", "int32_sex", "int32_age", "str_nick", "bytes_distance" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro }, NewGroupUser.class);
    }
  }
  
  public static final class OneRoamPriv
    extends MessageMicro<OneRoamPriv>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_fuin", "uint32_priv_tag", "uint32_priv_value" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, OneRoamPriv.class);
    public final PBUInt32Field uint32_priv_tag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_priv_value = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0L);
  }
  
  public static final class PraiseRankNotify
    extends MessageMicro<PraiseRankNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 88, 96, 106 }, new String[] { "uint32_is_champion", "uint32_rank_num", "str_msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, PraiseRankNotify.class);
    public final PBStringField str_msg = PBField.initString("");
    public final PBUInt32Field uint32_is_champion = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rank_num = PBField.initUInt32(0);
  }
  
  public static final class ProfileInfo
    extends MessageMicro<ProfileInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_field = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_field", "bytes_value" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ProfileInfo.class);
    }
  }
  
  public static final class PushReportDev
    extends MessageMicro<PushReportDev>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sn = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_report_max_num = PBField.initUInt32(200);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 34, 40, 50 }, new String[] { "uint32_msg_type", "bytes_cookie", "uint32_report_max_num", "bytes_sn" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(200), localByteStringMicro2 }, PushReportDev.class);
    }
  }
  
  public static final class PushSearchDev
    extends MessageMicro<PushSearchDev>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50 }, new String[] { "uint32_msg_type", "msg_gps_info", "uint32_dev_time", "uint32_push_time", "uint64_din", "str_data" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "" }, PushSearchDev.class);
    public SubMsgType0x27.GPS msg_gps_info = new SubMsgType0x27.GPS();
    public final PBStringField str_data = PBField.initString("");
    public final PBUInt32Field uint32_dev_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_push_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_din = PBField.initUInt64(0L);
  }
  
  public static final class QQPayPush
    extends MessageMicro<QQPayPush>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "bool_pay_ok" }, new Object[] { Long.valueOf(0L), Boolean.valueOf(false) }, QQPayPush.class);
    public final PBBoolField bool_pay_ok = PBField.initBool(false);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SnsUpateBuffer
    extends MessageMicro<SnsUpateBuffer>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 3202, 3208 }, new String[] { "uint64_uin", "uint64_code", "uint32_result", "rpt_msg_sns_update_item", "rpt_uint32_idlist" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, SnsUpateBuffer.class);
    public final PBRepeatMessageField<SubMsgType0x27.SnsUpdateItem> rpt_msg_sns_update_item = PBField.initRepeatMessage(SubMsgType0x27.SnsUpdateItem.class);
    public final PBRepeatField<Integer> rpt_uint32_idlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SnsUpdateFlag
    extends MessageMicro<SnsUpdateFlag>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_update_sns_flag" }, new Object[] { null }, SnsUpdateFlag.class);
    public final PBRepeatMessageField<SubMsgType0x27.SnsUpdateOneFlag> rpt_msg_update_sns_flag = PBField.initRepeatMessage(SubMsgType0x27.SnsUpdateOneFlag.class);
  }
  
  public static final class SnsUpdateItem
    extends MessageMicro<SnsUpdateItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_update_sns_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_update_sns_type", "bytes_value" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, SnsUpdateItem.class);
    }
  }
  
  public static final class SnsUpdateOneFlag
    extends MessageMicro<SnsUpdateOneFlag>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64__uin", "uint64_id", "uint32_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, SnsUpdateOneFlag.class);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64__uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27
 * JD-Core Version:    0.7.0.1
 */