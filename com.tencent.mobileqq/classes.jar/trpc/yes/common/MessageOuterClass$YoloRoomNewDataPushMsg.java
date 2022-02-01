package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MessageOuterClass$YoloRoomNewDataPushMsg
  extends MessageMicro<YoloRoomNewDataPushMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "new_data_time_ms" }, new Object[] { Long.valueOf(0L) }, YoloRoomNewDataPushMsg.class);
  public final PBUInt64Field new_data_time_ms = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.MessageOuterClass.YoloRoomNewDataPushMsg
 * JD-Core Version:    0.7.0.1
 */