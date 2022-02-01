package trpc.qq_vgame.share;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameShare$CmdGetShareLinkReq
  extends MessageMicro<CmdGetShareLinkReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField game_type = PBField.initEnum(0);
  public final PBStringField play_game_id = PBField.initString("");
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBStringField share_name = PBField.initString("");
  public final PBUInt32Field share_type = PBField.initUInt32(0);
  public final PBUInt64Field share_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48 }, new String[] { "roomid", "share_uin", "share_name", "share_type", "play_game_id", "game_type" }, new Object[] { localLong, localLong, "", localInteger, "", localInteger }, CmdGetShareLinkReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.share.AvGameShare.CmdGetShareLinkReq
 * JD-Core Version:    0.7.0.1
 */