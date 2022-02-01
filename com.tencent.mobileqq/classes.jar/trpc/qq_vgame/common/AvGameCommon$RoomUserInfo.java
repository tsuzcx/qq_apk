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
  public final PBUInt32Field game_view = PBField.initUInt32(0);
  public final PBEnumField match_tag = PBField.initEnum(0);
  public final PBUInt32Field role = PBField.initUInt32(0);
  public final PBEnumField status = PBField.initEnum(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56 }, new String[] { "uin", "role", "status", "enter_time", "cli_ver", "match_tag", "game_view" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, localByteStringMicro, localInteger, localInteger }, RoomUserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.RoomUserInfo
 * JD-Core Version:    0.7.0.1
 */