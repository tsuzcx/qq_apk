package trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GameDataServerOuterClass$SetAnchorGameEquipRoleReq
  extends MessageMicro<SetAnchorGameEquipRoleReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField a2_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField anchor_id = PBField.initString("");
  public final PBUInt32Field area = PBField.initUInt32(0);
  public final PBInt32Field equip_status = PBField.initInt32(0);
  public final PBUInt32Field partition = PBField.initUInt32(0);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56 }, new String[] { "area", "partition", "equip_status", "uid", "anchor_id", "a2_key", "room_id" }, new Object[] { localInteger, localInteger, localInteger, localLong, "", localByteStringMicro, localLong }, SetAnchorGameEquipRoleReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.SetAnchorGameEquipRoleReq
 * JD-Core Version:    0.7.0.1
 */