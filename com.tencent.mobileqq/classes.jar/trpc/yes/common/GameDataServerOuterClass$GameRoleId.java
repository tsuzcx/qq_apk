package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GameDataServerOuterClass$GameRoleId
  extends MessageMicro<GameRoleId>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field area = PBField.initUInt32(0);
  public final PBUInt32Field partition = PBField.initUInt32(0);
  public final PBUInt32Field plat_id = PBField.initUInt32(0);
  public final PBStringField smoba_openid = PBField.initString("");
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uid", "area", "partition", "smoba_openid", "plat_id" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, "", localInteger }, GameRoleId.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.GameRoleId
 * JD-Core Version:    0.7.0.1
 */