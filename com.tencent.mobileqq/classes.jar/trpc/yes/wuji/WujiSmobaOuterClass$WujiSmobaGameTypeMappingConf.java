package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class WujiSmobaOuterClass$WujiSmobaGameTypeMappingConf
  extends MessageMicro<WujiSmobaGameTypeMappingConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field ai_flag = PBField.initInt32(0);
  public final PBInt32Field game_type = PBField.initInt32(0);
  public final PBInt32Field in_continue_win = PBField.initInt32(0);
  public final PBInt32Field ladder2_flag = PBField.initInt32(0);
  public final PBInt32Field ladder3_flag = PBField.initInt32(0);
  public final PBInt32Field ladder5_flag = PBField.initInt32(0);
  public final PBInt32Field map_id = PBField.initInt32(0);
  public final PBInt32Field need_filter = PBField.initInt32(0);
  public final PBInt32Field show_type = PBField.initInt32(0);
  public final PBInt32Field warm_flag = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "game_type", "map_id", "ai_flag", "warm_flag", "ladder2_flag", "ladder3_flag", "ladder5_flag", "show_type", "need_filter", "in_continue_win" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, WujiSmobaGameTypeMappingConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiSmobaOuterClass.WujiSmobaGameTypeMappingConf
 * JD-Core Version:    0.7.0.1
 */