package msf.msgcomm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_comm$MsgHead
  extends MessageMicro
{
  public static final int AUTH_NICK_FIELD_NUMBER = 16;
  public static final int AUTH_REMARK_FIELD_NUMBER = 18;
  public static final int AUTH_UIN_FIELD_NUMBER = 15;
  public static final int C2C_CMD_FIELD_NUMBER = 4;
  public static final int C2C_TMP_MSG_HEAD_FIELD_NUMBER = 8;
  public static final int DISCUSS_INFO_FIELD_NUMBER = 13;
  public static final int FROM_APPID_FIELD_NUMBER = 10;
  public static final int FROM_INSTID_FIELD_NUMBER = 11;
  public static final int FROM_NICK_FIELD_NUMBER = 14;
  public static final int FROM_UIN_FIELD_NUMBER = 1;
  public static final int GROUP_INFO_FIELD_NUMBER = 9;
  public static final int GROUP_NAME_FIELD_NUMBER = 19;
  public static final int MSG_FLAG_FIELD_NUMBER = 17;
  public static final int MSG_SEQ_FIELD_NUMBER = 5;
  public static final int MSG_TIME_FIELD_NUMBER = 6;
  public static final int MSG_TYPE_FIELD_NUMBER = 3;
  public static final int MSG_UID_FIELD_NUMBER = 7;
  public static final int TO_UIN_FIELD_NUMBER = 2;
  public static final int USER_ACTIVE_FIELD_NUMBER = 12;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 74, 80, 88, 96, 106, 114, 120, 130, 136, 146, 154 }, new String[] { "from_uin", "to_uin", "msg_type", "c2c_cmd", "msg_seq", "msg_time", "msg_uid", "c2c_tmp_msg_head", "group_info", "from_appid", "from_instid", "user_active", "discuss_info", "from_nick", "auth_uin", "auth_nick", "msg_flag", "auth_remark", "group_name" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, "", Long.valueOf(0L), "", Integer.valueOf(0), "", "" }, MsgHead.class);
  public final PBStringField auth_nick = PBField.initString("");
  public final PBStringField auth_remark = PBField.initString("");
  public final PBUInt64Field auth_uin = PBField.initUInt64(0L);
  public final PBUInt32Field c2c_cmd = PBField.initUInt32(0);
  public msg_comm.C2CTmpMsgHead c2c_tmp_msg_head = new msg_comm.C2CTmpMsgHead();
  public msg_comm.DiscussInfo discuss_info = new msg_comm.DiscussInfo();
  public final PBUInt32Field from_appid = PBField.initUInt32(0);
  public final PBUInt32Field from_instid = PBField.initUInt32(0);
  public final PBStringField from_nick = PBField.initString("");
  public final PBUInt64Field from_uin = PBField.initUInt64(0L);
  public msg_comm.GroupInfo group_info = new msg_comm.GroupInfo();
  public final PBStringField group_name = PBField.initString("");
  public final PBUInt32Field msg_flag = PBField.initUInt32(0);
  public final PBUInt32Field msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field msg_time = PBField.initUInt32(0);
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  public final PBUInt64Field msg_uid = PBField.initUInt64(0L);
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  public final PBUInt32Field user_active = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     msf.msgcomm.msg_comm.MsgHead
 * JD-Core Version:    0.7.0.1
 */