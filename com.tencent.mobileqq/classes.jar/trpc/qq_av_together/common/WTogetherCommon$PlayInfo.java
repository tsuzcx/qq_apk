package trpc.qq_av_together.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WTogetherCommon$PlayInfo
  extends MessageMicro<PlayInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "player", "player_mode", "player_params" }, new Object[] { "", Integer.valueOf(0), null }, PlayInfo.class);
  public final PBStringField player = PBField.initString("");
  public final PBEnumField player_mode = PBField.initEnum(0);
  public WTogetherCommon.PlayerParams player_params = new WTogetherCommon.PlayerParams();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_av_together.common.WTogetherCommon.PlayInfo
 * JD-Core Version:    0.7.0.1
 */