package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WujiYoloRoomOuterClass$WujiFamilyRoomWidgetsConf
  extends MessageMicro<WujiFamilyRoomWidgetsConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field end_time = PBField.initUInt32(0);
  public final PBBoolField is_countdown = PBField.initBool(false);
  public final PBBoolField is_show = PBField.initBool(false);
  public final PBBoolField is_time_limit = PBField.initBool(false);
  public final PBInt32Field show_style = PBField.initInt32(0);
  public final PBUInt32Field show_time = PBField.initUInt32(0);
  public final PBInt32Field show_type = PBField.initInt32(0);
  public final PBUInt32Field start_time = PBField.initUInt32(0);
  public final PBUInt32Field widget_group_id = PBField.initUInt32(0);
  public final PBStringField widget_icon = PBField.initString("");
  public final PBUInt32Field widget_id = PBField.initUInt32(0);
  public final PBStringField widget_img = PBField.initString("");
  public final PBStringField widget_link = PBField.initString("");
  public final PBStringField widget_name = PBField.initString("");
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 64, 72, 80, 88, 96, 104, 112 }, new String[] { "widget_group_id", "widget_name", "widget_link", "widget_icon", "widget_img", "show_type", "is_show", "is_time_limit", "start_time", "end_time", "show_time", "is_countdown", "show_style", "widget_id" }, new Object[] { localInteger, "", "", "", "", localInteger, localBoolean, localBoolean, localInteger, localInteger, localInteger, localBoolean, localInteger, localInteger }, WujiFamilyRoomWidgetsConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiYoloRoomOuterClass.WujiFamilyRoomWidgetsConf
 * JD-Core Version:    0.7.0.1
 */