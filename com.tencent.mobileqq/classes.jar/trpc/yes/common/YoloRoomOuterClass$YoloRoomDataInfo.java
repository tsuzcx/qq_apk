package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomDataInfo
  extends MessageMicro<YoloRoomDataInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBStringField channel_name = PBField.initString("");
  public final PBInt32Field create_from = PBField.initInt32(0);
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  public final PBInt32Field max_player_num = PBField.initInt32(0);
  public final PBInt32Field max_speaking_num = PBField.initInt32(0);
  public final PBInt32Field max_user_num = PBField.initInt32(0);
  public final PBInt32Field min_player_num = PBField.initInt32(0);
  public final PBInt32Field sub_create_from = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72 }, new String[] { "min_player_num", "max_player_num", "max_user_num", "max_speaking_num", "create_from", "guild_id", "channel_id", "channel_name", "sub_create_from" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localLong, localLong, "", localInteger }, YoloRoomDataInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomDataInfo
 * JD-Core Version:    0.7.0.1
 */