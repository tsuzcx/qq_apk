package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WujiYoloRoomOuterClass$WujiYoloRoomBanConf
  extends MessageMicro<WujiYoloRoomBanConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField ban_param = PBField.initString("");
  public final PBInt32Field ban_param_type = PBField.initInt32(0);
  public final PBStringField ban_reason = PBField.initString("");
  public final PBInt32Field ban_type = PBField.initInt32(0);
  public final PBUInt32Field end_time = PBField.initUInt32(0);
  public final PBBoolField in_use = PBField.initBool(false);
  public final PBInt32Field room_type = PBField.initInt32(0);
  public final PBUInt32Field start_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56, 66 }, new String[] { "room_type", "ban_type", "ban_param_type", "ban_param", "in_use", "start_time", "end_time", "ban_reason" }, new Object[] { localInteger, localInteger, localInteger, "", Boolean.valueOf(false), localInteger, localInteger, "" }, WujiYoloRoomBanConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloRoomBanConf
 * JD-Core Version:    0.7.0.1
 */