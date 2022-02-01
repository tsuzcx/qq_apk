package trpc.qq_vgame.share;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameShare$CmdInviteCheckRsp
  extends MessageMicro<CmdInviteCheckRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "roomid", "share_uin", "game_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1) }, CmdInviteCheckRsp.class);
  public final PBEnumField game_type = PBField.initEnum(1);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBUInt64Field share_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.share.AvGameShare.CmdInviteCheckRsp
 * JD-Core Version:    0.7.0.1
 */