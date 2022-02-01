package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class WujiSmobaOuterClass$WujiSmobaGradeLevelConvertConf
  extends MessageMicro<WujiSmobaGradeLevelConvertConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field dest_disp_grade_level = PBField.initInt32(0);
  public final PBInt32Field lower_star = PBField.initInt32(0);
  public final PBInt32Field src_disp_grade_level = PBField.initInt32(0);
  public final PBInt32Field upper_star = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "src_disp_grade_level", "dest_disp_grade_level", "lower_star", "upper_star" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, WujiSmobaGradeLevelConvertConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiSmobaOuterClass.WujiSmobaGradeLevelConvertConf
 * JD-Core Version:    0.7.0.1
 */