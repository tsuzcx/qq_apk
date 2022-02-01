package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd
  extends MessageMicro<YoloRoomSpeakingPosChangeCmd>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField bill_no = PBField.initString("");
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBStringField channel_name = PBField.initString("");
  public final PBInt32Field enter_from = PBField.initInt32(0);
  public final PBUInt64Field from_room_id = PBField.initUInt64(0L);
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  public final PBInt32Field no_user_type_check = PBField.initInt32(0);
  public final PBInt32Field op = PBField.initInt32(0);
  public final PBInt32Field pos = PBField.initInt32(0);
  public final PBInt32Field sub_enter_from = PBField.initInt32(0);
  public final PBInt32Field voice_switch = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 802, 808, 816, 824, 832, 842, 848 }, new String[] { "op", "voice_switch", "pos", "no_user_type_check", "bill_no", "enter_from", "guild_id", "from_room_id", "channel_id", "channel_name", "sub_enter_from" }, new Object[] { localInteger, localInteger, localInteger, localInteger, "", localInteger, localLong, localLong, localLong, "", localInteger }, YoloRoomSpeakingPosChangeCmd.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosChangeCmd
 * JD-Core Version:    0.7.0.1
 */