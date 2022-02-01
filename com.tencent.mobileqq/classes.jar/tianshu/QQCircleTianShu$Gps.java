package tianshu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQCircleTianShu$Gps
  extends MessageMicro<Gps>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field accuracy = PBField.initInt32(0);
  public final PBInt32Field lat = PBField.initInt32(0);
  public final PBInt32Field lon = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "lat", "lon", "accuracy" }, new Object[] { localInteger, localInteger, localInteger }, Gps.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tianshu.QQCircleTianShu.Gps
 * JD-Core Version:    0.7.0.1
 */