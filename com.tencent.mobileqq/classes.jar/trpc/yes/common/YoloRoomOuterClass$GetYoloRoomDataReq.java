package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$GetYoloRoomDataReq
  extends MessageMicro<GetYoloRoomDataReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field client_max_id = PBField.initUInt64(0L);
  public final PBInt32Field is_update_heartbeat = PBField.initInt32(0);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "room_id", "client_max_id", "is_update_heartbeat" }, new Object[] { localLong, localLong, Integer.valueOf(0) }, GetYoloRoomDataReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.GetYoloRoomDataReq
 * JD-Core Version:    0.7.0.1
 */