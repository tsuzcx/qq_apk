package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameCommon$RoomUserInfo
  extends MessageMicro<RoomUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cli_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field enter_time = PBField.initUInt32(0);
  public final PBUInt32Field role = PBField.initUInt32(0);
  public final PBEnumField status = PBField.initEnum(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uin", "role", "status", "enter_time", "cli_ver" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, RoomUserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.RoomUserInfo
 * JD-Core Version:    0.7.0.1
 */