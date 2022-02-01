package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomEnterReq
  extends MessageMicro<YoloRoomEnterReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBStringField channel_name = PBField.initString("");
  public final PBInt32Field enter_from = PBField.initInt32(0);
  public final PBUInt64Field from_room_id = PBField.initUInt64(0L);
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBInt32Field room_type = PBField.initInt32(0);
  public final PBInt32Field sub_enter_from = PBField.initInt32(0);
  public final PBInt32Field voice_switch = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 48, 56, 64, 74, 80 }, new String[] { "room_id", "enter_from", "voice_switch", "room_type", "guild_id", "from_room_id", "channel_id", "channel_name", "sub_enter_from" }, new Object[] { localLong, localInteger, localInteger, localInteger, localLong, localLong, localLong, "", localInteger }, YoloRoomEnterReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomEnterReq
 * JD-Core Version:    0.7.0.1
 */