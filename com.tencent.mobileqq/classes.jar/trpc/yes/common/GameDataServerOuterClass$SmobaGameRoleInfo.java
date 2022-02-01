package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GameDataServerOuterClass$SmobaGameRoleInfo
  extends MessageMicro<SmobaGameRoleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field area = PBField.initUInt32(0);
  public final PBUInt32Field big_grade_level = PBField.initUInt32(0);
  public final PBUInt32Field disp_grade_level = PBField.initUInt32(0);
  public final PBRepeatField<Integer> display_branch_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> display_hero_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBStringField head_url = PBField.initString("");
  public final PBUInt32Field hero_count = PBField.initUInt32(0);
  public final PBUInt32Field logic_grade_level = PBField.initUInt32(0);
  public final PBUInt32Field lose_mvp = PBField.initUInt32(0);
  public final PBUInt32Field lose_num = PBField.initUInt32(0);
  public final PBUInt32Field partition = PBField.initUInt32(0);
  public final PBUInt32Field ranking_star = PBField.initUInt32(0);
  public final PBUInt32Field register_time = PBField.initUInt32(0);
  public final PBUInt32Field role_level = PBField.initUInt32(0);
  public final PBStringField role_name = PBField.initString("");
  public final PBUInt32Field win_mvp = PBField.initUInt32(0);
  public final PBUInt32Field win_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 106, 112, 120, 130, 136 }, new String[] { "area", "partition", "display_hero_list", "display_branch_list", "win_num", "lose_num", "win_mvp", "lose_mvp", "logic_grade_level", "disp_grade_level", "ranking_star", "hero_count", "role_name", "role_level", "register_time", "head_url", "big_grade_level" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, "", localInteger, localInteger, "", localInteger }, SmobaGameRoleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo
 * JD-Core Version:    0.7.0.1
 */