package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WujiYoloRoomOuterClass$WujiYoloRoomRotateMessageConf
  extends MessageMicro<WujiYoloRoomRotateMessageConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField message_tpl = PBField.initString("");
  public final PBInt32Field message_type = PBField.initInt32(0);
  public final PBInt32Field room_type = PBField.initInt32(0);
  public final PBInt32Field show_time = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "room_type", "message_type", "message_tpl", "show_time" }, new Object[] { localInteger, localInteger, "", localInteger }, WujiYoloRoomRotateMessageConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloRoomRotateMessageConf
 * JD-Core Version:    0.7.0.1
 */