package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$RotateMessageLabel
  extends MessageMicro<RotateMessageLabel>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField key = PBField.initString("");
  public final PBStringField text = PBField.initString("");
  public final PBInt32Field type = PBField.initInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBRepeatField<Long> uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "key", "text", "type", "uid", "uid_list" }, new Object[] { "", "", Integer.valueOf(0), localLong, localLong }, RotateMessageLabel.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.RotateMessageLabel
 * JD-Core Version:    0.7.0.1
 */