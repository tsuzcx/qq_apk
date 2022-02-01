package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UserProxyCmdOuterClass$UserRoom
  extends MessageMicro<UserRoom>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "room_id", "room_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, UserRoom.class);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBInt32Field room_type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.UserRoom
 * JD-Core Version:    0.7.0.1
 */