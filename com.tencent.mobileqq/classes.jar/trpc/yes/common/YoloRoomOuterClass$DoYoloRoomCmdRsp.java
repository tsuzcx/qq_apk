package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$DoYoloRoomCmdRsp
  extends MessageMicro<DoYoloRoomCmdRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "client_seq_id", "yolo_room_cmd_rsp", "safe_check_result" }, new Object[] { Long.valueOf(0L), null, null }, DoYoloRoomCmdRsp.class);
  public final PBUInt64Field client_seq_id = PBField.initUInt64(0L);
  public YoloRoomOuterClass.SafeCheckResult safe_check_result = new YoloRoomOuterClass.SafeCheckResult();
  public YoloRoomOuterClass.YoloRoomCmdRsp yolo_room_cmd_rsp = new YoloRoomOuterClass.YoloRoomCmdRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.DoYoloRoomCmdRsp
 * JD-Core Version:    0.7.0.1
 */