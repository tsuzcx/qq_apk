package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import trpc.yes.wuji.WujiSafeOuterClass.WujiSafeConf;

public final class YoloRoomOuterClass$YoloRoomCommonConf
  extends MessageMicro<YoloRoomCommonConf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "get_data_pull_time", "forbidden_speech_conf_list", "tag_list", "safe_conf", "is_ios_audit" }, new Object[] { Integer.valueOf(0), null, "", null, Boolean.valueOf(false) }, YoloRoomCommonConf.class);
  public final PBRepeatMessageField<YoloRoomOuterClass.YoloRoomForbiddenSpeechConf> forbidden_speech_conf_list = PBField.initRepeatMessage(YoloRoomOuterClass.YoloRoomForbiddenSpeechConf.class);
  public final PBInt32Field get_data_pull_time = PBField.initInt32(0);
  public final PBBoolField is_ios_audit = PBField.initBool(false);
  public WujiSafeOuterClass.WujiSafeConf safe_conf = new WujiSafeOuterClass.WujiSafeConf();
  public final PBRepeatField<String> tag_list = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomCommonConf
 * JD-Core Version:    0.7.0.1
 */