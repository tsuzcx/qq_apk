package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$SystemMsg
  extends MessageMicro
{
  public static final int ACTIONS_FIELD_NUMBER = 9;
  public static final int ACTION_UIN_FIELD_NUMBER = 11;
  public static final int ACTION_UIN_NICK_FIELD_NUMBER = 53;
  public static final int ACTOR_UIN_FIELD_NUMBER = 16;
  public static final int ACTOR_UIN_NICK_FIELD_NUMBER = 58;
  public static final int FRIEND_INFO_FIELD_NUMBER = 14;
  public static final int GROUP_CODE_FIELD_NUMBER = 10;
  public static final int GROUP_EXT_FLAG_FIELD_NUMBER = 57;
  public static final int GROUP_INFO_FIELD_NUMBER = 15;
  public static final int GROUP_INVITER_ROLE_FIELD_NUMBER = 13;
  public static final int GROUP_MSG_TYPE_FIELD_NUMBER = 12;
  public static final int GROUP_NAME_FIELD_NUMBER = 52;
  public static final int MSG_ACTOR_DESCRIBE_FIELD_NUMBER = 17;
  public static final int MSG_ADDITIONAL_FIELD_NUMBER = 4;
  public static final int MSG_ADDITIONAL_LIST_FIELD_NUMBER = 18;
  public static final int MSG_DECIDED_FIELD_NUMBER = 6;
  public static final int MSG_DESCRIBE_FIELD_NUMBER = 3;
  public static final int MSG_DETAIL_FIELD_NUMBER = 55;
  public static final int MSG_QNA_FIELD_NUMBER = 54;
  public static final int MSG_SOURCE_FIELD_NUMBER = 5;
  public static final int MSG_TITLE_FIELD_NUMBER = 2;
  public static final int REQ_UIN_FACEID_FIELD_NUMBER = 50;
  public static final int REQ_UIN_NICK_FIELD_NUMBER = 51;
  public static final int SRC_ID_FIELD_NUMBER = 7;
  public static final int SUB_SRC_ID_FIELD_NUMBER = 8;
  public static final int SUB_TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 74, 80, 88, 96, 104, 114, 122, 128, 138, 146, 400, 410, 418, 426, 434, 442, 456, 466 }, new String[] { "sub_type", "msg_title", "msg_describe", "msg_additional", "msg_source", "msg_decided", "src_id", "sub_src_id", "actions", "group_code", "action_uin", "group_msg_type", "group_inviter_role", "friend_info", "group_info", "actor_uin", "msg_actor_describe", "msg_additional_list", "req_uin_faceid", "req_uin_nick", "group_name", "action_uin_nick", "msg_qna", "msg_detail", "group_ext_flag", "actor_uin_nick" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null, Long.valueOf(0L), "", "", Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), "" }, SystemMsg.class);
  public final PBUInt64Field action_uin = PBField.initUInt64(0L);
  public final PBStringField action_uin_nick = PBField.initString("");
  public final PBRepeatMessageField actions = PBField.initRepeatMessage(structmsg.SystemMsgAction.class);
  public final PBUInt64Field actor_uin = PBField.initUInt64(0L);
  public final PBStringField actor_uin_nick = PBField.initString("");
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
  public final PBStringField msg_qna = PBField.initString("");
  public final PBStringField msg_source = PBField.initString("");
  public final PBStringField msg_title = PBField.initString("");
  public final PBInt32Field req_uin_faceid = PBField.initInt32(0);
  public final PBStringField req_uin_nick = PBField.initString("");
  public final PBUInt32Field src_id = PBField.initUInt32(0);
  public final PBUInt32Field sub_src_id = PBField.initUInt32(0);
  public final PBUInt32Field sub_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.SystemMsg
 * JD-Core Version:    0.7.0.1
 */