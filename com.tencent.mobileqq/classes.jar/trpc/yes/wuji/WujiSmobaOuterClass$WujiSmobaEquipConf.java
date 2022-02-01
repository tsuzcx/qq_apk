package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WujiSmobaOuterClass$WujiSmobaEquipConf
  extends MessageMicro<WujiSmobaEquipConf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "id", "icon" }, new Object[] { Integer.valueOf(0), "" }, WujiSmobaEquipConf.class);
  public final PBStringField icon = PBField.initString("");
  public final PBInt32Field id = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiSmobaOuterClass.WujiSmobaEquipConf
 * JD-Core Version:    0.7.0.1
 */