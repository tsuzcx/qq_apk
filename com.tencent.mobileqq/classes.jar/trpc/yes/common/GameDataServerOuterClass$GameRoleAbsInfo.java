package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.yes.wuji.WujiSmobaOuterClass.WujiSmobaLadderGradeConf;

public final class GameDataServerOuterClass$GameRoleAbsInfo
  extends MessageMicro<GameRoleAbsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field area = PBField.initUInt32(0);
  public WujiSmobaOuterClass.WujiSmobaLadderGradeConf grade_info = new WujiSmobaOuterClass.WujiSmobaLadderGradeConf();
  public final PBInt32Field grade_level = PBField.initInt32(0);
  public final PBStringField head_url = PBField.initString("");
  public final PBUInt32Field partition = PBField.initUInt32(0);
  public final PBInt32Field pvplevel = PBField.initInt32(0);
  public final PBInt32Field ranking_star = PBField.initInt32(0);
  public final PBUInt32Field register_time = PBField.initUInt32(0);
  public final PBStringField role_name = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56, 66, 74 }, new String[] { "area", "partition", "role_name", "register_time", "grade_level", "ranking_star", "pvplevel", "head_url", "grade_info" }, new Object[] { localInteger, localInteger, "", localInteger, localInteger, localInteger, localInteger, "", null }, GameRoleAbsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.GameRoleAbsInfo
 * JD-Core Version:    0.7.0.1
 */