package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf
  extends MessageMicro<WujiYoloCommunityRoomConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field create_from = PBField.initInt32(0);
  public final PBStringField introduce = PBField.initString("");
  public final PBBoolField is_show_third_part_gift = PBField.initBool(false);
  public final PBInt32Field max_user_limit = PBField.initInt32(0);
  public final PBStringField notice = PBField.initString("");
  public final PBRepeatMessageField<WujiYoloRoomOuterClass.WujiYoloRoomCommunityOnlineNumItem> online_num_items = PBField.initRepeatMessage(WujiYoloRoomOuterClass.WujiYoloRoomCommunityOnlineNumItem.class);
  public final PBStringField room_background_color_v2 = PBField.initString("");
  public final PBStringField room_background_img = PBField.initString("");
  public final PBStringField room_background_img_v2 = PBField.initString("");
  public final PBStringField room_cover = PBField.initString("");
  public final PBStringField room_detail_background_img = PBField.initString("");
  public final PBBoolField speaking_list_switch = PBField.initBool(false);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 64, 74, 82, 88, 96 }, new String[] { "create_from", "introduce", "notice", "room_cover", "room_background_img", "online_num_items", "room_detail_background_img", "max_user_limit", "room_background_img_v2", "room_background_color_v2", "speaking_list_switch", "is_show_third_part_gift" }, new Object[] { localInteger, "", "", "", "", null, "", localInteger, "", "", localBoolean, localBoolean }, WujiYoloCommunityRoomConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf
 * JD-Core Version:    0.7.0.1
 */