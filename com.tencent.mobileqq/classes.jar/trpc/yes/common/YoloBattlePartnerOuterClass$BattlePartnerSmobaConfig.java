package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoloBattlePartnerOuterClass$BattlePartnerSmobaConfig
  extends MessageMicro<BattlePartnerSmobaConfig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field big_grade_level_begin = PBField.initInt32(0);
  public final PBInt32Field big_grade_level_end = PBField.initInt32(0);
  public final PBInt32Field game_mode = PBField.initInt32(0);
  public final PBEnumField partner_area = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "game_mode", "big_grade_level_begin", "big_grade_level_end", "partner_area" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, BattlePartnerSmobaConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattlePartnerOuterClass.BattlePartnerSmobaConfig
 * JD-Core Version:    0.7.0.1
 */