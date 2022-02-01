package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WujiSmobaOuterClass$WujiSmobaBigGradeLevelConf
  extends MessageMicro<WujiSmobaBigGradeLevelConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field big_grade_level = PBField.initInt32(0);
  public final PBStringField level_name = PBField.initString("");
  public final PBInt32Field merge_show = PBField.initInt32(0);
  public final PBStringField merge_show_begin = PBField.initString("");
  public final PBStringField merge_show_end = PBField.initString("");
  public final PBStringField short_level_name = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "big_grade_level", "level_name", "merge_show", "merge_show_begin", "merge_show_end", "short_level_name" }, new Object[] { localInteger, "", localInteger, "", "", "" }, WujiSmobaBigGradeLevelConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiSmobaOuterClass.WujiSmobaBigGradeLevelConf
 * JD-Core Version:    0.7.0.1
 */