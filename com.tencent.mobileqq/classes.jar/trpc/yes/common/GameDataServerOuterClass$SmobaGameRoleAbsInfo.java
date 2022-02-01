package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GameDataServerOuterClass$SmobaGameRoleAbsInfo
  extends MessageMicro<SmobaGameRoleAbsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field area = PBField.initUInt32(0);
  public final PBUInt32Field big_grade_level = PBField.initUInt32(0);
  public final PBUInt32Field disp_grade_level = PBField.initUInt32(0);
  public final PBStringField grade_level_name = PBField.initString("");
  public final PBStringField grade_level_short_name = PBField.initString("");
  public final PBBoolField is_default = PBField.initBool(false);
  public final PBUInt32Field logic_grade_level = PBField.initUInt32(0);
  public final PBUInt32Field partition = PBField.initUInt32(0);
  public final PBStringField role_desc = PBField.initString("");
  public final PBUInt32Field role_level = PBField.initUInt32(0);
  public final PBStringField role_name = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 40, 48, 58, 66, 72, 82, 88, 96 }, new String[] { "area", "partition", "role_name", "logic_grade_level", "disp_grade_level", "grade_level_name", "grade_level_short_name", "role_level", "role_desc", "is_default", "big_grade_level" }, new Object[] { localInteger, localInteger, "", localInteger, localInteger, "", "", localInteger, "", Boolean.valueOf(false), localInteger }, SmobaGameRoleAbsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleAbsInfo
 * JD-Core Version:    0.7.0.1
 */