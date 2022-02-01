package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WujiYoloRoomOuterClass$WujiYoloRoomActionOfflinePushConf
  extends MessageMicro<WujiYoloRoomActionOfflinePushConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field action_type = PBField.initInt32(0);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField ext = PBField.initString("");
  public final PBInt32Field room_type = PBField.initInt32(0);
  public final PBStringField title = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "room_type", "action_type", "title", "desc", "ext" }, new Object[] { localInteger, localInteger, "", "", "" }, WujiYoloRoomActionOfflinePushConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloRoomActionOfflinePushConf
 * JD-Core Version:    0.7.0.1
 */