package trpc.qq_av_together.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WTogetherRoomMng$CmdSyncPlayTimeReq
  extends MessageMicro<CmdSyncPlayTimeReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field client_type = PBField.initUInt32(0);
  public final PBUInt32Field cur_play_rate = PBField.initUInt32(0);
  public final PBUInt64Field cur_play_time = PBField.initUInt64(0L);
  public final PBEnumField from = PBField.initEnum(0);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBEnumField video_status = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "from", "seq", "room_id", "cur_play_time", "video_status", "cur_play_rate", "client_type" }, new Object[] { localInteger, localLong, localLong, localLong, localInteger, localInteger, localInteger }, CmdSyncPlayTimeReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdSyncPlayTimeReq
 * JD-Core Version:    0.7.0.1
 */