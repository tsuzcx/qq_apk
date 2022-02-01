package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$DoYoloRoomCmdReq
  extends MessageMicro<DoYoloRoomCmdReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field client_seq_id = PBField.initUInt64(0L);
  public final PBInt32Field cmd_type = PBField.initInt32(0);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public YoloRoomOuterClass.YoloRoomCmdReq yolo_room_cmd_req = new YoloRoomOuterClass.YoloRoomCmdReq();
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "room_id", "cmd_type", "client_seq_id", "yolo_room_cmd_req" }, new Object[] { localLong, Integer.valueOf(0), localLong, null }, DoYoloRoomCmdReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.DoYoloRoomCmdReq
 * JD-Core Version:    0.7.0.1
 */