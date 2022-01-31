package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$ReqSystemMsgRead
  extends MessageMicro
{
  public static final int CHECKTYPE_FIELD_NUMBER = 4;
  public static final int LATEST_FRIEND_SEQ_FIELD_NUMBER = 1;
  public static final int LATEST_GROUP_SEQ_FIELD_NUMBER = 2;
  public static final int TYPE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "latest_friend_seq", "latest_group_seq", "type", "checktype" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1) }, ReqSystemMsgRead.class);
  public final PBEnumField checktype = PBField.initEnum(1);
  public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.ReqSystemMsgRead
 * JD-Core Version:    0.7.0.1
 */