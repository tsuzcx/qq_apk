package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg
{
  public static final class AddFrdSNInfo
    extends MessageMicro<AddFrdSNInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_not_see_dynamic", "uint32_set_sn" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, AddFrdSNInfo.class);
    public final PBUInt32Field uint32_not_see_dynamic = PBField.initUInt32(0);
    public final PBUInt32Field uint32_set_sn = PBField.initUInt32(0);
  }
  
  public static final class FlagInfo
    extends MessageMicro<FlagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136 }, new String[] { "GrpMsg_Kick_Admin", "GrpMsg_HiddenGrp", "GrpMsg_WordingDown", "FrdMsg_GetBusiCard", "GrpMsg_GetOfficialAccount", "GrpMsg_GetPayInGroup", "FrdMsg_Discuss2ManyChat", "GrpMsg_NotAllowJoinGrp_InviteNotFrd", "FrdMsg_NeedWaitingMsg", "FrdMsg_uint32_need_all_unread_msg", "GrpMsg_NeedAutoAdminWording", "GrpMsg_get_transfer_group_msg_flag", "GrpMsg_get_quit_pay_group_msg_flag", "GrpMsg_support_invite_auto_join", "GrpMsg_mask_invite_auto_join", "GrpMsg_GetDisbandedByAdmin", "GrpMsg_GetC2cInviteJoinGroup" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FlagInfo.class);
    public final PBUInt32Field FrdMsg_Discuss2ManyChat = PBField.initUInt32(0);
    public final PBUInt32Field FrdMsg_GetBusiCard = PBField.initUInt32(0);
    public final PBUInt32Field FrdMsg_NeedWaitingMsg = PBField.initUInt32(0);
    public final PBUInt32Field FrdMsg_uint32_need_all_unread_msg = PBField.initUInt32(0);
    public final PBUInt32Field GrpMsg_GetC2cInviteJoinGroup = PBField.initUInt32(0);
    public final PBUInt32Field GrpMsg_GetDisbandedByAdmin = PBField.initUInt32(0);
    public final PBUInt32Field GrpMsg_GetOfficialAccount = PBField.initUInt32(0);
    public final PBUInt32Field GrpMsg_GetPayInGroup = PBField.initUInt32(0);
    public final PBUInt32Field GrpMsg_HiddenGrp = PBField.initUInt32(0);
    public final PBUInt32Field GrpMsg_Kick_Admin = PBField.initUInt32(0);
    public final PBUInt32Field GrpMsg_NeedAutoAdminWording = PBField.initUInt32(0);
    public final PBUInt32Field GrpMsg_NotAllowJoinGrp_InviteNotFrd = PBField.initUInt32(0);
    public final PBUInt32Field GrpMsg_WordingDown = PBField.initUInt32(0);
    public final PBUInt32Field GrpMsg_get_quit_pay_group_msg_flag = PBField.initUInt32(0);
    public final PBUInt32Field GrpMsg_get_transfer_group_msg_flag = PBField.initUInt32(0);
    public final PBUInt32Field GrpMsg_mask_invite_auto_join = PBField.initUInt32(0);
    public final PBUInt32Field GrpMsg_support_invite_auto_join = PBField.initUInt32(0);
  }
  
  public static final class FriendInfo
    extends MessageMicro<FriendInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_joint_friend", "msg_blacklist" }, new Object[] { "", "" }, FriendInfo.class);
    public final PBStringField msg_blacklist = PBField.initString("");
    public final PBStringField msg_joint_friend = PBField.initString("");
  }
  
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "group_auth_type", "display_action", "msg_alert", "msg_detail_alert", "msg_other_admin_done", "uint32_app_privilege_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0) }, GroupInfo.class);
    public final PBUInt32Field display_action = PBField.initUInt32(0);
    public final PBUInt32Field group_auth_type = PBField.initUInt32(0);
    public final PBStringField msg_alert = PBField.initString("");
    public final PBStringField msg_detail_alert = PBField.initString("");
    public final PBStringField msg_other_admin_done = PBField.initString("");
    public final PBUInt32Field uint32_app_privilege_flag = PBField.initUInt32(0);
  }
  
  public static final class MsgInviteExt
    extends MessageMicro<MsgInviteExt>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_src_type", "uint64_src_code", "uint32_wait_state" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, MsgInviteExt.class);
    public final PBUInt32Field uint32_src_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wait_state = PBField.initUInt32(0);
    public final PBUInt64Field uint64_src_code = PBField.initUInt64(0L);
  }
  
  public static final class MsgPayGroupExt
    extends MessageMicro<MsgPayGroupExt>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_join_grp_time", "uint64_quit_grp_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, MsgPayGroupExt.class);
    public final PBUInt64Field uint64_join_grp_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_quit_grp_time = PBField.initUInt64(0L);
  }
  
  public static final class ReqNextSystemMsg
    extends MessageMicro<ReqNextSystemMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 72 }, new String[] { "msg_num", "following_friend_seq", "following_group_seq", "checktype", "flag", "language", "version", "friend_msg_type_flag", "uint32_req_msg_type" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, ReqNextSystemMsg.class);
    public final PBEnumField checktype = PBField.initEnum(1);
    public structmsg.FlagInfo flag = new structmsg.FlagInfo();
    public final PBUInt64Field following_friend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field following_group_seq = PBField.initUInt64(0L);
    public final PBUInt64Field friend_msg_type_flag = PBField.initUInt64(0L);
    public final PBUInt32Field language = PBField.initUInt32(0);
    public final PBUInt32Field msg_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class ReqSystemMsg
    extends MessageMicro<ReqSystemMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "msg_num", "latest_friend_seq", "latest_group_seq", "version", "language" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqSystemMsg.class);
    public final PBUInt32Field language = PBField.initUInt32(0);
    public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);
    public final PBUInt32Field msg_num = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class ReqSystemMsgAction
    extends MessageMicro<ReqSystemMsgAction>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72 }, new String[] { "msg_type", "msg_seq", "req_uin", "sub_type", "src_id", "sub_src_id", "group_msg_type", "action_info", "language" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, ReqSystemMsgAction.class);
    public structmsg.SystemMsgActionInfo action_info = new structmsg.SystemMsgActionInfo();
    public final PBUInt32Field group_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field language = PBField.initUInt32(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
    public final PBEnumField msg_type = PBField.initEnum(1);
    public final PBUInt64Field req_uin = PBField.initUInt64(0L);
    public final PBUInt32Field src_id = PBField.initUInt32(0);
    public final PBUInt32Field sub_src_id = PBField.initUInt32(0);
    public final PBUInt32Field sub_type = PBField.initUInt32(0);
  }
  
  public static final class ReqSystemMsgNew
    extends MessageMicro<ReqSystemMsgNew>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 64, 72, 80, 88 }, new String[] { "msg_num", "latest_friend_seq", "latest_group_seq", "version", "checktype", "flag", "language", "is_get_frd_ribbon", "is_get_grp_ribbon", "friend_msg_type_flag", "uint32_req_msg_type" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1), null, Integer.valueOf(0), Boolean.valueOf(true), Boolean.valueOf(true), Long.valueOf(0L), Integer.valueOf(0) }, ReqSystemMsgNew.class);
    public final PBEnumField checktype = PBField.initEnum(1);
    public structmsg.FlagInfo flag = new structmsg.FlagInfo();
    public final PBUInt64Field friend_msg_type_flag = PBField.initUInt64(0L);
    public final PBBoolField is_get_frd_ribbon = PBField.initBool(true);
    public final PBBoolField is_get_grp_ribbon = PBField.initBool(true);
    public final PBUInt32Field language = PBField.initUInt32(0);
    public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);
    public final PBUInt32Field msg_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class ReqSystemMsgRead
    extends MessageMicro<ReqSystemMsgRead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "latest_friend_seq", "latest_group_seq", "type", "checktype", "uint32_req_msg_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) }, ReqSystemMsgRead.class);
    public final PBEnumField checktype = PBField.initEnum(1);
    public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);
  }
  
  public static final class RspHead
    extends MessageMicro<RspHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "msg_fail" }, new Object[] { Integer.valueOf(0), "" }, RspHead.class);
    public final PBStringField msg_fail = PBField.initString("");
    public final PBInt32Field result = PBField.initInt32(0);
  }
  
  public static final class RspNextSystemMsg
    extends MessageMicro<RspNextSystemMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField bytes_game_nick = PBField.initString("");
    public final PBBytesField bytes_undecid_for_qim = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField checktype = PBField.initEnum(1);
    public final PBUInt64Field following_friend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field following_group_seq = PBField.initUInt64(0L);
    public structmsg.RspHead head = new structmsg.RspHead();
    public final PBRepeatMessageField<structmsg.StructMsg> msgs = PBField.initRepeatMessage(structmsg.StructMsg.class);
    public final PBUInt32Field uint32_un_read_count3 = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 802, 810, 816 }, new String[] { "head", "msgs", "following_friend_seq", "following_group_seq", "checktype", "bytes_game_nick", "bytes_undecid_for_qim", "uint32_un_read_count3" }, new Object[] { null, null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), "", localByteStringMicro, Integer.valueOf(0) }, RspNextSystemMsg.class);
    }
  }
  
  public static final class RspSystemMsg
    extends MessageMicro<RspSystemMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 66 }, new String[] { "head", "msgs", "unread_count", "latest_friend_seq", "latest_group_seq", "following_friend_seq", "following_group_seq", "msg_display" }, new Object[] { null, null, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "" }, RspSystemMsg.class);
    public final PBUInt64Field following_friend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field following_group_seq = PBField.initUInt64(0L);
    public structmsg.RspHead head = new structmsg.RspHead();
    public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);
    public final PBStringField msg_display = PBField.initString("");
    public final PBRepeatMessageField<structmsg.StructMsg> msgs = PBField.initRepeatMessage(structmsg.StructMsg.class);
    public final PBUInt32Field unread_count = PBField.initUInt32(0);
  }
  
  public static final class RspSystemMsgAction
    extends MessageMicro<RspSystemMsgAction>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 42, 48 }, new String[] { "head", "msg_detail", "type", "msg_invalid_decided", "remark_result" }, new Object[] { null, "", Integer.valueOf(0), "", Integer.valueOf(0) }, RspSystemMsgAction.class);
    public structmsg.RspHead head = new structmsg.RspHead();
    public final PBStringField msg_detail = PBField.initString("");
    public final PBStringField msg_invalid_decided = PBField.initString("");
    public final PBUInt32Field remark_result = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class RspSystemMsgNew
    extends MessageMicro<RspSystemMsgNew>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField bytes_game_nick = PBField.initString("");
    public final PBBytesField bytes_undecid_for_qim = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField checktype = PBField.initEnum(1);
    public final PBUInt64Field following_friend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field following_group_seq = PBField.initUInt64(0L);
    public final PBRepeatMessageField<structmsg.StructMsg> friendmsgs = PBField.initRepeatMessage(structmsg.StructMsg.class);
    public final PBRepeatMessageField<structmsg.StructMsg> groupmsgs = PBField.initRepeatMessage(structmsg.StructMsg.class);
    public final PBStringField grp_msg_display = PBField.initString("");
    public structmsg.RspHead head = new structmsg.RspHead();
    public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);
    public final PBStringField msg_display = PBField.initString("");
    public structmsg.StructMsg msg_ribbon_friend = new structmsg.StructMsg();
    public structmsg.StructMsg msg_ribbon_group = new structmsg.StructMsg();
    public final PBUInt32Field uint32_has_suspicious_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_un_read_count3 = PBField.initUInt32(0);
    public final PBUInt32Field unread_friend_count = PBField.initUInt32(0);
    public final PBUInt32Field unread_group_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 74, 82, 90, 98, 106, 114, 120, 160, 802, 810, 816, 824 }, new String[] { "head", "unread_friend_count", "unread_group_count", "latest_friend_seq", "latest_group_seq", "following_friend_seq", "following_group_seq", "friendmsgs", "groupmsgs", "msg_ribbon_friend", "msg_ribbon_group", "msg_display", "grp_msg_display", "uint32_over", "checktype", "bytes_game_nick", "bytes_undecid_for_qim", "uint32_un_read_count3", "uint32_has_suspicious_flag" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, null, null, null, "", "", Integer.valueOf(0), Integer.valueOf(1), "", localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, RspSystemMsgNew.class);
    }
  }
  
  public static final class RspSystemMsgRead
    extends MessageMicro<RspSystemMsgRead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "head", "type", "checktype" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(1) }, RspSystemMsgRead.class);
    public final PBEnumField checktype = PBField.initEnum(1);
    public structmsg.RspHead head = new structmsg.RspHead();
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class StructMsg
    extends MessageMicro<StructMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 402 }, new String[] { "version", "msg_type", "msg_seq", "msg_time", "req_uin", "uint32_unread_flag", "msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null }, StructMsg.class);
    public structmsg.SystemMsg msg = new structmsg.SystemMsg();
    public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
    public final PBUInt64Field msg_time = PBField.initUInt64(0L);
    public final PBEnumField msg_type = PBField.initEnum(1);
    public final PBUInt64Field req_uin = PBField.initUInt64(0L);
    public final PBUInt32Field uint32_unread_flag = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class SystemMsg
    extends MessageMicro<SystemMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field action_uin = PBField.initUInt64(0L);
    public final PBStringField action_uin_nick = PBField.initString("");
    public final PBBytesField action_uin_qq_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField action_uin_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<structmsg.SystemMsgAction> actions = PBField.initRepeatMessage(structmsg.SystemMsgAction.class);
    public final PBUInt64Field actor_uin = PBField.initUInt64(0L);
    public final PBStringField actor_uin_nick = PBField.initString("");
    public final PBBytesField bytes_game_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_game_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name_more = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_warning_tips = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field card_switch = PBField.initUInt32(0);
    public final PBUInt64Field clone_uin = PBField.initUInt64(0L);
    public final PBStringField clone_uin_nick = PBField.initString("");
    public final PBBytesField eim_group_id_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public structmsg.FriendInfo friend_info = new structmsg.FriendInfo();
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt32Field group_ext_flag = PBField.initUInt32(0);
    public structmsg.GroupInfo group_info = new structmsg.GroupInfo();
    public final PBUInt32Field group_inviter_role = PBField.initUInt32(0);
    public final PBUInt32Field group_msg_type = PBField.initUInt32(0);
    public final PBStringField group_name = PBField.initString("");
    public final PBStringField msg_actor_describe = PBField.initString("");
    public final PBStringField msg_additional = PBField.initString("");
    public final PBStringField msg_additional_list = PBField.initString("");
    public final PBStringField msg_decided = PBField.initString("");
    public final PBStringField msg_describe = PBField.initString("");
    public final PBStringField msg_detail = PBField.initString("");
    public structmsg.MsgInviteExt msg_invite_extinfo = new structmsg.MsgInviteExt();
    public structmsg.MsgPayGroupExt msg_pay_group_extinfo = new structmsg.MsgPayGroupExt();
    public final PBStringField msg_qna = PBField.initString("");
    public final PBStringField msg_source = PBField.initString("");
    public final PBStringField msg_title = PBField.initString("");
    public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field relation = PBField.initUInt32(0);
    public final PBUInt32Field req_uin_age = PBField.initUInt32(0);
    public final PBBytesField req_uin_business_card = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field req_uin_faceid = PBField.initInt32(0);
    public final PBUInt32Field req_uin_gender = PBField.initUInt32(0);
    public final PBStringField req_uin_nick = PBField.initString("");
    public final PBBytesField req_uin_pre_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field reqsubtype = PBField.initUInt32(0);
    public final PBUInt32Field src_id = PBField.initUInt32(0);
    public final PBUInt32Field sub_src_id = PBField.initUInt32(0);
    public final PBUInt32Field sub_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_c2c_invite_join_group_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_doubt_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_flagext3 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_eim_group_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_owner_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 74, 80, 88, 96, 104, 114, 122, 128, 138, 146, 152, 160, 168, 176, 184, 194, 202, 208, 218, 226, 232, 240, 248, 258, 266, 400, 410, 418, 426, 434, 442, 456, 466, 474, 482, 490, 506, 514, 522, 530, 536, 544, 552, 808 }, new String[] { "sub_type", "msg_title", "msg_describe", "msg_additional", "msg_source", "msg_decided", "src_id", "sub_src_id", "actions", "group_code", "action_uin", "group_msg_type", "group_inviter_role", "friend_info", "group_info", "actor_uin", "msg_actor_describe", "msg_additional_list", "relation", "reqsubtype", "clone_uin", "uint64_discuss_uin", "uint64_eim_group_id", "msg_invite_extinfo", "msg_pay_group_extinfo", "uint32_source_flag", "bytes_game_nick", "bytes_game_msg", "uint32_group_flagext3", "uint64_group_owner_uin", "uint32_doubt_flag", "bytes_warning_tips", "bytes_name_more", "req_uin_faceid", "req_uin_nick", "group_name", "action_uin_nick", "msg_qna", "msg_detail", "group_ext_flag", "actor_uin_nick", "pic_url", "clone_uin_nick", "req_uin_business_card", "eim_group_id_name", "req_uin_pre_remark", "action_uin_qq_nick", "action_uin_remark", "req_uin_gender", "req_uin_age", "uint32_c2c_invite_join_group_flag", "card_switch" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null, Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), "", localByteStringMicro5, "", localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SystemMsg.class);
    }
  }
  
  public static final class SystemMsgAction
    extends MessageMicro<SystemMsgAction>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "name", "result", "action", "action_info", "detail_name" }, new Object[] { "", "", Integer.valueOf(0), null, "" }, SystemMsgAction.class);
    public final PBUInt32Field action = PBField.initUInt32(0);
    public structmsg.SystemMsgActionInfo action_info = new structmsg.SystemMsgActionInfo();
    public final PBStringField detail_name = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField result = PBField.initString("");
  }
  
  public static final class SystemMsgActionInfo
    extends MessageMicro<SystemMsgActionInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public structmsg.AddFrdSNInfo addFrdSNInfo = new structmsg.AddFrdSNInfo();
    public final PBBoolField blacklist = PBField.initBool(false);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt32Field group_id = PBField.initUInt32(0);
    public final PBStringField msg = PBField.initString("");
    public final PBStringField remark = PBField.initString("");
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 402, 408, 418, 424, 434, 440 }, new String[] { "type", "group_code", "sig", "msg", "group_id", "remark", "blacklist", "addFrdSNInfo", "uint32_req_msg_type" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), localByteStringMicro, "", Integer.valueOf(0), "", Boolean.valueOf(false), null, Integer.valueOf(0) }, SystemMsgActionInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg
 * JD-Core Version:    0.7.0.1
 */