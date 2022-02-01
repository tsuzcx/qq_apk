package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PremadesTeamServerOuterClass$SmobaPremadesTeamUserInfo
  extends MessageMicro<SmobaPremadesTeamUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField avatar = PBField.initString("");
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public final PBUInt32Field pos = PBField.initUInt32(0);
  public final PBInt32Field status = PBField.initInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBInt32Field user_from = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "pos", "status", "uid", "avatar", "user_from", "gender" }, new Object[] { localInteger, localInteger, Long.valueOf(0L), "", localInteger, localInteger }, SmobaPremadesTeamUserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamUserInfo
 * JD-Core Version:    0.7.0.1
 */