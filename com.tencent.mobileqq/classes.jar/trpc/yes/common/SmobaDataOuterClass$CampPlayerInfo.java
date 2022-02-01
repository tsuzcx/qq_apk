package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SmobaDataOuterClass$CampPlayerInfo
  extends MessageMicro<CampPlayerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "partition_id", "game_openid", "game_uid" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L) }, CampPlayerInfo.class);
  public final PBStringField game_openid = PBField.initString("");
  public final PBUInt64Field game_uid = PBField.initUInt64(0L);
  public final PBInt32Field partition_id = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.SmobaDataOuterClass.CampPlayerInfo
 * JD-Core Version:    0.7.0.1
 */