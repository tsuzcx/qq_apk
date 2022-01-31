package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$ReqSystemMsg
  extends MessageMicro
{
  public static final int LANGUAGE_FIELD_NUMBER = 5;
  public static final int LATEST_FRIEND_SEQ_FIELD_NUMBER = 2;
  public static final int LATEST_GROUP_SEQ_FIELD_NUMBER = 3;
  public static final int MSG_NUM_FIELD_NUMBER = 1;
  public static final int VERSION_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "msg_num", "latest_friend_seq", "latest_group_seq", "version", "language" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqSystemMsg.class);
  public final PBUInt32Field language = PBField.initUInt32(0);
  public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);
  public final PBUInt32Field msg_num = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.ReqSystemMsg
 * JD-Core Version:    0.7.0.1
 */