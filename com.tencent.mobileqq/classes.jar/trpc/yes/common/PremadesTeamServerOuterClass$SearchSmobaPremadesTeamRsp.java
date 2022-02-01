package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class PremadesTeamServerOuterClass$SearchSmobaPremadesTeamRsp
  extends MessageMicro<SearchSmobaPremadesTeamRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<PremadesTeamServerOuterClass.SmobaPremadesTeamInfo> list = PBField.initRepeatMessage(PremadesTeamServerOuterClass.SmobaPremadesTeamInfo.class);
  public final PBBoolField more = PBField.initBool(false);
  public final PBInt32Field refresh_interval = PBField.initInt32(0);
  public final PBInt32Field total = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "total", "list", "more", "refresh_interval" }, new Object[] { localInteger, null, Boolean.valueOf(false), localInteger }, SearchSmobaPremadesTeamRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.PremadesTeamServerOuterClass.SearchSmobaPremadesTeamRsp
 * JD-Core Version:    0.7.0.1
 */