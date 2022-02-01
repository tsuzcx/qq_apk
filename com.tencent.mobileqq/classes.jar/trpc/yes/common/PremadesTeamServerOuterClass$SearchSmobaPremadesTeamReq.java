package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PremadesTeamServerOuterClass$SearchSmobaPremadesTeamReq
  extends MessageMicro<SearchSmobaPremadesTeamReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field display_type = PBField.initInt32(0);
  public final PBRepeatField<Integer> game_mode_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> grade_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> lane_type_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBStringField origin_id = PBField.initString("");
  public final PBInt32Field page = PBField.initInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56 }, new String[] { "origin_id", "game_mode_list", "grade_list", "lane_type_list", "page", "display_type", "uid" }, new Object[] { "", localInteger, localInteger, localInteger, localInteger, localInteger, Long.valueOf(0L) }, SearchSmobaPremadesTeamReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.PremadesTeamServerOuterClass.SearchSmobaPremadesTeamReq
 * JD-Core Version:    0.7.0.1
 */