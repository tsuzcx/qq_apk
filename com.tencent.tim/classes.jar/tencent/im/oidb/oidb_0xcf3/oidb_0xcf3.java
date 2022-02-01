package tencent.im.oidb.oidb_0xcf3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.intimate_relation.intimate_relation.IntimateInfo;

public final class oidb_0xcf3
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "sub_cmd", "target_uin", "intimate_type", "source", "bind_time", "level", "chat_days" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field bind_time = PBField.initUInt32(0);
    public final PBUInt32Field chat_days = PBField.initUInt32(0);
    public final PBUInt32Field intimate_type = PBField.initUInt32(0);
    public final PBUInt32Field level = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field sub_cmd = PBField.initUInt32(0);
    public final PBUInt64Field target_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "intimate_list" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<intimate_relation.IntimateInfo> intimate_list = PBField.initRepeatMessage(intimate_relation.IntimateInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xcf3.oidb_0xcf3
 * JD-Core Version:    0.7.0.1
 */