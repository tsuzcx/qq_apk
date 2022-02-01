package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameRoomManager$CmdRoomBatchForGroupReq
  extends MessageMicro<CmdRoomBatchForGroupReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field batch_num = PBField.initUInt32(0);
  public final PBUInt64Field groupid = PBField.initUInt64(0L);
  public final PBUInt32Field req_from = PBField.initUInt32(0);
  public final PBUInt32Field req_platform = PBField.initUInt32(0);
  public final PBUInt32Field start = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "groupid", "uin", "start", "batch_num", "req_from", "req_platform" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger, localInteger }, CmdRoomBatchForGroupReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomBatchForGroupReq
 * JD-Core Version:    0.7.0.1
 */