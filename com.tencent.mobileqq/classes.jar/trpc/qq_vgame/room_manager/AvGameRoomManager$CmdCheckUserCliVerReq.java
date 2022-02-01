package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameRoomManager$CmdCheckUserCliVerReq
  extends MessageMicro<CmdCheckUserCliVerReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cli_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uin", "roomid", "cli_ver" }, new Object[] { localLong, localLong, localByteStringMicro }, CmdCheckUserCliVerReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.room_manager.AvGameRoomManager.CmdCheckUserCliVerReq
 * JD-Core Version:    0.7.0.1
 */