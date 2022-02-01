package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomLeaveReq
  extends MessageMicro<YoloRoomLeaveReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field force_exit = PBField.initInt32(0);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBInt32Field room_type = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "room_id", "force_exit", "room_type" }, new Object[] { Long.valueOf(0L), localInteger, localInteger }, YoloRoomLeaveReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveReq
 * JD-Core Version:    0.7.0.1
 */