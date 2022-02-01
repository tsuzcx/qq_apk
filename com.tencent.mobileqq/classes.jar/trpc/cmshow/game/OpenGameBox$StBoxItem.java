package trpc.cmshow.game;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class OpenGameBox$StBoxItem
  extends MessageMicro<StBoxItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56 }, new String[] { "appid", "avatar", "name", "gamer_range", "background", "footer_icon", "ad_id" }, new Object[] { "", "", "", "", "", "", Integer.valueOf(0) }, StBoxItem.class);
  public final PBUInt32Field ad_id = PBField.initUInt32(0);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField avatar = PBField.initString("");
  public final PBStringField background = PBField.initString("");
  public final PBStringField footer_icon = PBField.initString("");
  public final PBStringField gamer_range = PBField.initString("");
  public final PBStringField name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.cmshow.game.OpenGameBox.StBoxItem
 * JD-Core Version:    0.7.0.1
 */