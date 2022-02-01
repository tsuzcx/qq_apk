package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WujiSafeOuterClass$WujiSafeConf
  extends MessageMicro<WujiSafeConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field forbidden_speech_time = PBField.initInt32(0);
  public final PBInt32Field game_room_send_interval_times = PBField.initInt32(0);
  public final PBInt32Field id = PBField.initInt32(0);
  public final PBStringField introduce = PBField.initString("");
  public final PBInt32Field send_interval_times = PBField.initInt32(0);
  public final PBInt32Field system_notice_message_num = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "id", "send_interval_times", "forbidden_speech_time", "system_notice_message_num", "introduce", "game_room_send_interval_times" }, new Object[] { localInteger, localInteger, localInteger, localInteger, "", localInteger }, WujiSafeConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiSafeOuterClass.WujiSafeConf
 * JD-Core Version:    0.7.0.1
 */