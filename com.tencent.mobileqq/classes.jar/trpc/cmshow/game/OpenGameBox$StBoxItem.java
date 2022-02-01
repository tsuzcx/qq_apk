package trpc.cmshow.game;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class OpenGameBox$StBoxItem
  extends MessageMicro<StBoxItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field ad_id = PBField.initUInt32(0);
  public final PBStringField app_desc = PBField.initString("");
  public final PBStringField appid = PBField.initString("");
  public final PBStringField avatar = PBField.initString("");
  public final PBStringField background = PBField.initString("");
  public final PBUInt32Field box_type = PBField.initUInt32(0);
  public final PBStringField footer_icon = PBField.initString("");
  public final PBStringField gamer_range = PBField.initString("");
  public final PBStringField hall_jump_url = PBField.initString("");
  public final PBStringField miniapp_jump_url = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 64, 74, 82, 90 }, new String[] { "appid", "avatar", "name", "gamer_range", "background", "footer_icon", "ad_id", "box_type", "hall_jump_url", "miniapp_jump_url", "app_desc" }, new Object[] { "", "", "", "", "", "", localInteger, localInteger, "", "", "" }, StBoxItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.cmshow.game.OpenGameBox.StBoxItem
 * JD-Core Version:    0.7.0.1
 */