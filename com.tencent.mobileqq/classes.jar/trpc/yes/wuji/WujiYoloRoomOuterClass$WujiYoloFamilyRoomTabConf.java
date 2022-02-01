package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WujiYoloRoomOuterClass$WujiYoloFamilyRoomTabConf
  extends MessageMicro<WujiYoloFamilyRoomTabConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField is_show = PBField.initBool(false);
  public final PBBoolField is_show_admin = PBField.initBool(false);
  public final PBBoolField is_show_member = PBField.initBool(false);
  public final PBBoolField is_show_owner = PBField.initBool(false);
  public final PBBoolField is_show_red_dot = PBField.initBool(false);
  public final PBBoolField is_show_visitor = PBField.initBool(false);
  public final PBStringField max_version = PBField.initString("");
  public final PBStringField min_version = PBField.initString("");
  public final PBStringField tab_link = PBField.initString("");
  public final PBStringField tab_name = PBField.initString("");
  public final PBInt32Field tab_type = PBField.initInt32(0);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 72, 82, 90 }, new String[] { "tab_type", "tab_name", "tab_link", "is_show", "is_show_visitor", "is_show_member", "is_show_admin", "is_show_red_dot", "is_show_owner", "min_version", "max_version" }, new Object[] { Integer.valueOf(0), "", "", localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, "", "" }, WujiYoloFamilyRoomTabConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloFamilyRoomTabConf
 * JD-Core Version:    0.7.0.1
 */