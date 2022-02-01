package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomSpeakingPosInfo
  extends MessageMicro<YoloRoomSpeakingPosInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBStringField channel_name = PBField.initString("");
  public final PBUInt64Field from_room_id = PBField.initUInt64(0L);
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  public final PBUInt32Field in_speaking_time = PBField.initUInt32(0);
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBUInt32Field last_ready_status_change_time = PBField.initUInt32(0);
  public final PBUInt32Field last_remind_time = PBField.initUInt32(0);
  public final PBInt32Field leave_status = PBField.initInt32(0);
  public final PBUInt32Field leave_status_time = PBField.initUInt32(0);
  public final PBUInt32Field pos = PBField.initUInt32(0);
  public final PBInt32Field ready_status = PBField.initInt32(0);
  public final PBInt32Field status = PBField.initInt32(0);
  public final PBInt32Field sub_user_from = PBField.initInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBUInt32Field unready_timeout_time = PBField.initUInt32(0);
  public final PBInt32Field user_from = PBField.initInt32(0);
  public YoloRoomOuterClass.YoloUserGameData user_game_data = new YoloRoomOuterClass.YoloUserGameData();
  public CommonOuterClass.QQUserId user_id = new CommonOuterClass.QQUserId();
  public final PBStringField voice_id = PBField.initString("");
  public final PBInt32Field voice_switch = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 64, 72, 80, 88, 96, 104, 112, 122, 128, 136, 146, 152, 800, 808 }, new String[] { "pos", "status", "uid", "voice_id", "voice_switch", "ready_status", "user_game_data", "last_ready_status_change_time", "last_remind_time", "leave_status", "unready_timeout_time", "leave_status_time", "user_from", "guild_id", "user_id", "from_room_id", "channel_id", "channel_name", "sub_user_from", "index", "in_speaking_time" }, new Object[] { localInteger, localInteger, localLong, "", localInteger, localInteger, null, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localLong, null, localLong, localLong, "", localInteger, localInteger, localInteger }, YoloRoomSpeakingPosInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo
 * JD-Core Version:    0.7.0.1
 */