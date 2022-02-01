package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PremadesTeamServerOuterClass$SmobaPremadesTeamInfo
  extends MessageMicro<SmobaPremadesTeamInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field create_time = PBField.initInt64(0L);
  public final PBInt32Field game_mode = PBField.initInt32(0);
  public final PBStringField game_mode_name = PBField.initString("");
  public final PBInt32Field game_status = PBField.initInt32(0);
  public final PBStringField grade_desc = PBField.initString("");
  public final PBRepeatField<Integer> grade_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBRepeatMessageField<PremadesTeamServerOuterClass.SmobaPremadesTeamIcon> icon_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass.SmobaPremadesTeamIcon.class);
  public final PBUInt64Field id = PBField.initUInt64(0L);
  public final PBStringField lane_type_desc = PBField.initString("");
  public final PBRepeatField<Integer> lane_type_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBStringField name = PBField.initString("");
  public final PBStringField origin_id = PBField.initString("");
  public final PBInt32Field status = PBField.initInt32(0);
  public final PBInt32Field type = PBField.initInt32(0);
  public final PBRepeatMessageField<PremadesTeamServerOuterClass.SmobaPremadesTeamUserInfo> user_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass.SmobaPremadesTeamUserInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 56, 66, 72, 82, 90, 98, 104, 112, 120 }, new String[] { "id", "type", "name", "grade_desc", "grade_list", "lane_type_desc", "lane_type_list", "game_mode_name", "game_mode", "user_list", "icon_list", "origin_id", "create_time", "status", "game_status" }, new Object[] { Long.valueOf(0L), localInteger, "", "", localInteger, "", localInteger, "", localInteger, null, null, "", Long.valueOf(0L), localInteger, localInteger }, SmobaPremadesTeamInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamInfo
 * JD-Core Version:    0.7.0.1
 */