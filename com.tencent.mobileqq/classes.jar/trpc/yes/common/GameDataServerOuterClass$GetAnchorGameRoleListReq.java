package trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GameDataServerOuterClass$GetAnchorGameRoleListReq
  extends MessageMicro<GetAnchorGameRoleListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField a2_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField anchor_id = PBField.initString("");
  public final PBInt32Field game_id = PBField.initInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "anchor_id", "game_id", "uid", "a2_key" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, GetAnchorGameRoleListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.GetAnchorGameRoleListReq
 * JD-Core Version:    0.7.0.1
 */