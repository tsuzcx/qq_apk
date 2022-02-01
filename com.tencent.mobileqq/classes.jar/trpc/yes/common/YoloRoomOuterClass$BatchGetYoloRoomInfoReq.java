package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$BatchGetYoloRoomInfoReq
  extends MessageMicro<BatchGetYoloRoomInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "room_id_list" }, new Object[] { Long.valueOf(0L) }, BatchGetYoloRoomInfoReq.class);
  public final PBRepeatField<Long> room_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.BatchGetYoloRoomInfoReq
 * JD-Core Version:    0.7.0.1
 */