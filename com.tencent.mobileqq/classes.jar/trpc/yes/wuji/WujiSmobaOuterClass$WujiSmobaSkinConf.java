package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WujiSmobaOuterClass$WujiSmobaSkinConf
  extends MessageMicro<WujiSmobaSkinConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field hero_id = PBField.initInt32(0);
  public final PBInt32Field id = PBField.initInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBStringField small_icon = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "id", "name", "hero_id", "small_icon" }, new Object[] { localInteger, "", localInteger, "" }, WujiSmobaSkinConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiSmobaOuterClass.WujiSmobaSkinConf
 * JD-Core Version:    0.7.0.1
 */