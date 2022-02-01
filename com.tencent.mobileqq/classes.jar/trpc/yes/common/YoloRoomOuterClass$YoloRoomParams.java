package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomParams
  extends MessageMicro<YoloRoomParams>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field background = PBField.initInt32(0);
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBStringField channel_name = PBField.initString("");
  public final PBInt32Field create_from = PBField.initInt32(0);
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  public final PBStringField introduce = PBField.initString("");
  public final PBInt32Field is_private = PBField.initInt32(0);
  public final PBStringField notice = PBField.initString("");
  public final PBStringField room_cover = PBField.initString("");
  public final PBInt32Field room_type = PBField.initInt32(0);
  public final PBInt32Field sub_create_from = PBField.initInt32(0);
  public final PBInt32Field theme = PBField.initInt32(0);
  public final PBInt32Field voice_switch = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56, 66, 74, 80, 88, 98, 104 }, new String[] { "room_type", "is_private", "introduce", "theme", "background", "create_from", "voice_switch", "notice", "room_cover", "guild_id", "channel_id", "channel_name", "sub_create_from" }, new Object[] { localInteger, localInteger, "", localInteger, localInteger, localInteger, localInteger, "", "", Long.valueOf(0L), Long.valueOf(0L), "", localInteger }, YoloRoomParams.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomParams
 * JD-Core Version:    0.7.0.1
 */