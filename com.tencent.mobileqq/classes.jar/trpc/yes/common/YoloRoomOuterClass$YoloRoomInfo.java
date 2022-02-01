package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomInfo
  extends MessageMicro<YoloRoomInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field background = PBField.initInt32(0);
  public final PBUInt32Field create_time = PBField.initUInt32(0);
  public final PBUInt64Field create_uid = PBField.initUInt64(0L);
  public YoloRoomOuterClass.YoloGameDataInfo game_data_info = new YoloRoomOuterClass.YoloGameDataInfo();
  public YoloRoomOuterClass.YoloGameRouteInfo game_route_info = new YoloRoomOuterClass.YoloGameRouteInfo();
  public final PBStringField introduce = PBField.initString("");
  public final PBInt32Field is_need_apply_inspeaking = PBField.initInt32(0);
  public final PBInt32Field is_not_close = PBField.initInt32(0);
  public final PBInt32Field is_private = PBField.initInt32(0);
  public final PBStringField notice = PBField.initString("");
  public final PBUInt64Field owner_uid = PBField.initUInt64(0L);
  public final PBStringField room_cover = PBField.initString("");
  public YoloRoomOuterClass.YoloRoomDataInfo room_data_info = new YoloRoomOuterClass.YoloRoomDataInfo();
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBInt32Field room_type = PBField.initInt32(0);
  public final PBInt32Field server_index = PBField.initInt32(0);
  public final PBInt32Field status = PBField.initInt32(0);
  public final PBInt32Field theme = PBField.initInt32(0);
  public final PBUInt64Field tim_group_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 88, 98, 106, 114, 122, 130, 136, 800, 808 }, new String[] { "room_id", "owner_uid", "create_uid", "tim_group_id", "room_type", "status", "is_private", "theme", "background", "introduce", "create_time", "game_route_info", "game_data_info", "room_data_info", "notice", "room_cover", "is_need_apply_inspeaking", "server_index", "is_not_close" }, new Object[] { localLong, localLong, localLong, localLong, localInteger, localInteger, localInteger, localInteger, localInteger, "", localInteger, null, null, null, "", "", localInteger, localInteger, localInteger }, YoloRoomInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo
 * JD-Core Version:    0.7.0.1
 */