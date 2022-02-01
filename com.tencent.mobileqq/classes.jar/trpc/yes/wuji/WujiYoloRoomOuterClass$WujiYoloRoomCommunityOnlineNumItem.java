package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WujiYoloRoomOuterClass$WujiYoloRoomCommunityOnlineNumItem
  extends MessageMicro<WujiYoloRoomCommunityOnlineNumItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField icon = PBField.initString("");
  public final PBInt32Field max = PBField.initInt32(0);
  public final PBInt32Field min = PBField.initInt32(0);
  public final PBStringField text = PBField.initString("");
  public final PBStringField text_color = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "min", "max", "text", "icon", "text_color" }, new Object[] { localInteger, localInteger, "", "", "" }, WujiYoloRoomCommunityOnlineNumItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloRoomCommunityOnlineNumItem
 * JD-Core Version:    0.7.0.1
 */