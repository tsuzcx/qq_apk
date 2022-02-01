package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomRecoverReq
  extends MessageMicro<YoloRoomRecoverReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "room_id" }, new Object[] { Long.valueOf(0L) }, YoloRoomRecoverReq.class);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomRecoverReq
 * JD-Core Version:    0.7.0.1
 */