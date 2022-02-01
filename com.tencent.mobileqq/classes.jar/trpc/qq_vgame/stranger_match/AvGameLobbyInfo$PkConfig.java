package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameLobbyInfo$PkConfig
  extends MessageMicro<PkConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "pk_id", "pk_begin_min_user_num", "pool_timeout_ts", "pool_timeout_min_user_num", "max_award_top_n" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PkConfig.class);
  public final PBUInt32Field max_award_top_n = PBField.initUInt32(0);
  public final PBUInt32Field pk_begin_min_user_num = PBField.initUInt32(0);
  public final PBUInt32Field pk_id = PBField.initUInt32(0);
  public final PBUInt32Field pool_timeout_min_user_num = PBField.initUInt32(0);
  public final PBUInt32Field pool_timeout_ts = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameLobbyInfo.PkConfig
 * JD-Core Version:    0.7.0.1
 */