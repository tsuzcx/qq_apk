package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WujiYoloRoomOuterClass$WujiYoloSmobaRoomCommonConf
  extends MessageMicro<WujiYoloSmobaRoomCommonConf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "conf_id", "conf_key", "conf_value" }, new Object[] { Integer.valueOf(0), "", "" }, WujiYoloSmobaRoomCommonConf.class);
  public final PBInt32Field conf_id = PBField.initInt32(0);
  public final PBStringField conf_key = PBField.initString("");
  public final PBStringField conf_value = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloSmobaRoomCommonConf
 * JD-Core Version:    0.7.0.1
 */