package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WujiSmobaOuterClass$WujiSmobaLadderGradeConf
  extends MessageMicro<WujiSmobaLadderGradeConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field big_grade_level = PBField.initInt32(0);
  public final PBStringField big_image = PBField.initString("");
  public final PBInt32Field disp_grade_level = PBField.initInt32(0);
  public final PBInt32Field disp_style = PBField.initInt32(0);
  public final PBStringField display_name = PBField.initString("");
  public final PBStringField grade_level_name = PBField.initString("");
  public final PBInt32Field logic_grade_level = PBField.initInt32(0);
  public final PBStringField small_image = PBField.initString("");
  public final PBInt32Field total_star = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 58, 66, 72 }, new String[] { "disp_grade_level", "logic_grade_level", "grade_level_name", "total_star", "display_name", "big_grade_level", "small_image", "big_image", "disp_style" }, new Object[] { localInteger, localInteger, "", localInteger, "", localInteger, "", "", localInteger }, WujiSmobaLadderGradeConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiSmobaOuterClass.WujiSmobaLadderGradeConf
 * JD-Core Version:    0.7.0.1
 */