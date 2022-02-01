package trpc.qq_av_together.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WTogetherCommon$OnlineResourceInfo
  extends MessageMicro<OnlineResourceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "play_info", "platform_id", "sdtform_id", "is_pay" }, new Object[] { null, "", "", Integer.valueOf(0) }, OnlineResourceInfo.class);
  public final PBUInt32Field is_pay = PBField.initUInt32(0);
  public final PBStringField platform_id = PBField.initString("");
  public WTogetherCommon.PlayInfo play_info = new WTogetherCommon.PlayInfo();
  public final PBStringField sdtform_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_av_together.common.WTogetherCommon.OnlineResourceInfo
 * JD-Core Version:    0.7.0.1
 */