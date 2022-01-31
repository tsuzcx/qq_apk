package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class structmsg$FriendInfo
  extends MessageMicro
{
  public static final int MSG_BLACKLIST_FIELD_NUMBER = 2;
  public static final int MSG_JOINT_FRIEND_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_joint_friend", "msg_blacklist" }, new Object[] { "", "" }, FriendInfo.class);
  public final PBStringField msg_blacklist = PBField.initString("");
  public final PBStringField msg_joint_friend = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.FriendInfo
 * JD-Core Version:    0.7.0.1
 */