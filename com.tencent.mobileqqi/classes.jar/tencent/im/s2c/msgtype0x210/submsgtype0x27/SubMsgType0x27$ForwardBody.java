package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x27$ForwardBody
  extends MessageMicro
{
  public static final int MSG_ADD_GROUP_FIELD_NUMBER = 3;
  public static final int MSG_BIN_PKG_FIELD_NUMBER = 19;
  public static final int MSG_DEL_FRIEND_FIELD_NUMBER = 14;
  public static final int MSG_DEL_GROUP_FIELD_NUMBER = 4;
  public static final int MSG_MOD_CONF_PROFILE_FIELD_NUMBER = 21;
  public static final int MSG_MOD_CUSTOM_FACE_FIELD_NUMBER = 11;
  public static final int MSG_MOD_FRIEND_FLAG_FIELD_NUMBER = 22;
  public static final int MSG_MOD_FRIEND_GROUP_FIELD_NUMBER = 7;
  public static final int MSG_MOD_FRIEND_REMARK_FIELD_NUMBER = 9;
  public static final int MSG_MOD_FRIEND_RINGS_FIELD_NUMBER = 20;
  public static final int MSG_MOD_GROUP_MEMBER_PROFILE_FIELD_NUMBER = 13;
  public static final int MSG_MOD_GROUP_NAME_FIELD_NUMBER = 5;
  public static final int MSG_MOD_GROUP_PROFILE_FIELD_NUMBER = 12;
  public static final int MSG_MOD_GROUP_SORT_FIELD_NUMBER = 6;
  public static final int MSG_MOD_LONG_NICK_FIELD_NUMBER = 10;
  public static final int MSG_MOD_PROFILE_FIELD_NUMBER = 8;
  public static final int MSG_MOD_RICH_LONG_NICK_FIELD_NUMBER = 18;
  public static final int UINT32_NOTIFY_TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_OP_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 146, 154, 162, 170, 178 }, new String[] { "uint32_notify_type", "uint32_op_type", "msg_add_group", "msg_del_group", "msg_mod_group_name", "msg_mod_group_sort", "msg_mod_friend_group", "msg_mod_profile", "msg_mod_friend_remark", "msg_mod_long_nick", "msg_mod_custom_face", "msg_mod_group_profile", "msg_mod_group_member_profile", "msg_del_friend", "msg_mod_rich_long_nick", "msg_bin_pkg", "msg_mod_friend_rings", "msg_mod_conf_profile", "msg_mod_friend_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, ForwardBody.class);
  public SubMsgType0x27.AddGroup msg_add_group = new SubMsgType0x27.AddGroup();
  public SubMsgType0x27.BinaryMsg msg_bin_pkg = new SubMsgType0x27.BinaryMsg();
  public SubMsgType0x27.DelFriend msg_del_friend = new SubMsgType0x27.DelFriend();
  public SubMsgType0x27.DelGroup msg_del_group = new SubMsgType0x27.DelGroup();
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
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ForwardBody
 * JD-Core Version:    0.7.0.1
 */