package trpc.qq_av_together.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WTogetherCommon$PlayerStatus
  extends MessageMicro<PlayerStatus>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cur_play_rate = PBField.initUInt32(0);
  public final PBUInt64Field cur_play_time = PBField.initUInt64(0L);
  public final PBInt32Field left_time = PBField.initInt32(0);
  public final PBEnumField video_status = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "video_status", "cur_play_rate", "cur_play_time", "left_time" }, new Object[] { localInteger, localInteger, Long.valueOf(0L), localInteger }, PlayerStatus.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_av_together.common.WTogetherCommon.PlayerStatus
 * JD-Core Version:    0.7.0.1
 */