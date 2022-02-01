package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomGreetUserCmd
  extends MessageMicro<YoloRoomGreetUserCmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "greet_uid", "greet_nick" }, new Object[] { Long.valueOf(0L), "" }, YoloRoomGreetUserCmd.class);
  public final PBStringField greet_nick = PBField.initString("");
  public final PBUInt64Field greet_uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomGreetUserCmd
 * JD-Core Version:    0.7.0.1
 */