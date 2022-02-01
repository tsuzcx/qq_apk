package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WujiSmobaOuterClass$WujiSmobaHeroConf
  extends MessageMicro<WujiSmobaHeroConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField icon = PBField.initString("");
  public final PBInt32Field id = PBField.initInt32(0);
  public final PBInt32Field lane_type = PBField.initInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBInt32Field type = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "id", "name", "type", "lane_type", "icon" }, new Object[] { localInteger, "", localInteger, localInteger, "" }, WujiSmobaHeroConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiSmobaOuterClass.WujiSmobaHeroConf
 * JD-Core Version:    0.7.0.1
 */